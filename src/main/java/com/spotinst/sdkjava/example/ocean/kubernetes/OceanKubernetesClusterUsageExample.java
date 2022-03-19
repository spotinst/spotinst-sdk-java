package com.spotinst.sdkjava.example.ocean.kubernetes;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.k8sClusterRollStatusEnum;
import com.spotinst.sdkjava.model.SpotOceanK8sClusterClient;
import com.spotinst.sdkjava.model.Tag;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.GetClusterNodesRequest;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sClusterFetchElastilogRequest;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.UpdateRollRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OceanKubernetesClusterUsageExample {

    private final static String auth_token = "your-token";
    private final static String act_id     = "your-account-id";

    // Fill in the correct values from your account
    private final static String       controllerClusterId        = "your-sdk-Cluster-id";
    private final static String       launchSpecificationImageId = "your-launchSpec-image-id";
    private final static List<String> securityGroups             = Arrays.asList("sg-1", "sg-2");
    private final static String       region                     = "chosen-region";
    private final static String       keyPair                    = "some-key-pair";
    private final static List<String> subnetIds                  = Arrays.asList("subnet-1", "subnet-2");
    private final static String       arnRole                    = "your-arn-role";

    public static void main(String[] args) {
        SpotOceanK8sClusterClient clusterClient = SpotinstClient.getOceanClusterClient(auth_token, act_id);

        String clusterId = createCluster(clusterClient);
        getCluster(clusterClient,clusterId);
        updateCluster(clusterClient, clusterId);
        deleteCluster(clusterClient, clusterId);

        //Get all clusters
        System.out.println("----------Get all clusters--------------");
        List<OceanK8sCluster> getClusters = getAllK8sClusters(clusterClient);

        //Get cluster heartbeat status
        System.out.println("----------Get cluster heartbeat status-------------");
        GetK8sClusterHeartBeatStatusResponse getClusterHeartBeatStatus = getK8sClusterHeartBeatStatus(clusterClient,"cluster-id");

        //Import ASG to ocean cluster
        System.out.println("----------Import ASG to ocean cluster--------------");
        OceanK8sCluster importASGResponse = importASGToOceanCluster(clusterClient, "ASGName", "region");

        //Get Elastilog
        System.out.println("----------Get Elastilog--------------");
        List<K8sClusterFetchElastilogResponse> getLogs = fetchElastilog(clusterClient, act_id, "fromDate", "limit", "resourceId", "severity", "toDate", "clusterId");

        //Detach instances
        System.out.println("----------Detach Instances--------------");
        Boolean detachStatus = detachClusterInstances(clusterClient, "cluster-id", Collections.singletonList("instances"), true, true);

        //Initiate Roll
        System.out.println("----------Initiate Roll--------------");
        ClusterRollResponse initiateRollResponse = initiateClusterRoll(clusterClient, "cluster-id", 25, "comment", true, 100);

        //Get cluster Roll
        System.out.println("----------Get cluster Roll--------------");
        ClusterRollResponse getClusterRollStatus = getClusterRollStatus (clusterClient, "cluster-id", "rollId");

        //List cluster Rolls
        System.out.println("----------List cluster Rolls--------------");
        List<ClusterRollResponse> listClusterRolls = getAllClusterRolls(clusterClient, "cluster-id");

        //Update cluster Roll
        System.out.println("----------Update cluster Roll--------------");
        ClusterRollResponse updateRollResponse = updateClusterRoll(clusterClient, "cluster-id", "roll-id", "STOPPED");

        //Get cluster nodes
        System.out.println("----------Get cluster Nodes--------------");
        List<GetClusterNodesResponse> nodes = getClusterNodes(clusterClient, "cluster-id");
    }

    private static String createCluster(SpotOceanK8sClusterClient client) {
        System.out.println("-------------------------start creating ocean cluster------------------------");
        //Build autoScaler
        ClusterDownSpecification.Builder downSpecBuilder = ClusterDownSpecification.Builder.get();
        ClusterDownSpecification         down            = downSpecBuilder.setMaxScaleDownPercentage(60).build();

        ClusterHeadroomSpecification.Builder headroomSpecBuilder = ClusterHeadroomSpecification.Builder.get();
        ClusterHeadroomSpecification headroom =
                headroomSpecBuilder.setCpuPerUnit(2000).setGpuPerUnit(0).setMemoryPerUnit(0).setNumOfUnits(2).build();

        ClusterResourceLimitsSpecification.Builder resourceLimitSpecBuilder =
                ClusterResourceLimitsSpecification.Builder.get();
        ClusterResourceLimitsSpecification resourceLimits =
                resourceLimitSpecBuilder.setMaxMemoryGib(5).setMaxVCpu(2000).build();

        ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
        ClusterAutoScalerConfiguration autoScaler =
                clusterAutoScalerBuilder.setIsAutoConfig(false).setCooldown(180).setDown(down)
                                        .setAutoHeadroomPercentage(null).setHeadroom(headroom).setIsEnabled(false)
                                        .setResourceLimits(resourceLimits).build();

        //Build capacity
        ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration capacity = capacityBuilder.setMaximum(0).setMinimum(0).setTarget(0).build();

        //Build strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy =
                strategyBuilder.setFallbackToOnDemand(false).setUtilizeReservedInstances(true).setDrainingTimeout(60)
                               .setGracePeriod(600).build();

        //Build compute
        Tag.Builder tagsBuilder = Tag.Builder.get();

        Tag       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingSdkOcean").build();
        List<Tag> tagsList = Collections.singletonList(tag1);


        ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = ClusterIamInstanceProfileSpec.Builder.get();
        ClusterIamInstanceProfileSpec iamInstanceProfileSpec = iamInstanceProfileBuilder.setArn(arnRole).build();

        ClusterLaunchSpecification.Builder launchSpecificationBuilder = ClusterLaunchSpecification.Builder.get();
        ClusterLaunchSpecification launchSpecification =
                launchSpecificationBuilder.setSecurityGroupIds(securityGroups).setAssociatePublicIpAddress(true)
                                         .setEbsOptimized(false).setMonitoring(false).setRootVolumeSize(73)
                                         .setIamInstanceProfile(iamInstanceProfileSpec)
                                         .setImageId(launchSpecificationImageId).setTags(tagsList).setKeyPair(keyPair)
                                         .build();

        ClusterInstanceTypes.Builder instanceTypesBuilder = ClusterInstanceTypes.Builder.get();

        List<String> whiteList = Arrays.asList("c4.xlarge");

        ClusterInstanceTypes instanceTypes = instanceTypesBuilder.setWhitelist(whiteList).build();


        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute =
                computeBuilder.setInstanceTypes(instanceTypes).setLaunchSpecification(launchSpecification)
                              .setSubnetIds(subnetIds).build();

        //Build scheduling
        List<String> timeWindows = Arrays.asList("Mon:12:00-Tue:12:00", "Fri:12:00-Sat:12:00");

        ClusterShutdownHoursSpecification.Builder shutDownSpecBuilder = ClusterShutdownHoursSpecification.Builder.get();
        ClusterShutdownHoursSpecification shutDownHours =
                shutDownSpecBuilder.setEnabled(true).setTimeWindows(timeWindows).build();

        ClusterTasksSpecification.Builder tasksBuilder = ClusterTasksSpecification.Builder.get();

        ClusterTasksSpecification task1 =
                tasksBuilder.setIsEnabled(true).setCronExpression("0 1 * * *").setTaskType("clusterRoll").build();
        List<ClusterTasksSpecification> tasksList = Collections.singletonList(task1);

        ClusterSchedulingConfiguration.Builder schedulingBuilder = ClusterSchedulingConfiguration.Builder.get();
        ClusterSchedulingConfiguration scheduling =
                schedulingBuilder.setShutdownHours(shutDownHours).setTasks(tasksList).build();

        // Build cluster
        OceanK8sCluster.Builder oceanBuilder = OceanK8sCluster.Builder.get();
        OceanK8sCluster oceanK8sCluster =
                oceanBuilder.setName("Java-SDK-Testing").setRegion(region).setControllerClusterId(controllerClusterId)
                            .setAutoScaler(autoScaler).setStrategy(strategy).setCapacity(capacity).setCompute(compute)
                            .setScheduling(scheduling).build();
        // Build cluster creation request
        K8sClusterCreationRequest.Builder clusterCreationRequestBuilder = K8sClusterCreationRequest.Builder.get();
        K8sClusterCreationRequest creationRequest               =
                clusterCreationRequestBuilder.setCluster(oceanK8sCluster).build();

        // Convert cluster to API object json
        System.out.println(creationRequest.toJson());

        // Create cluster
        OceanK8sCluster createdCluster = client.createK8sCluster(creationRequest);
        System.out.println("Cluster successfully created: " + createdCluster.getId());

        return createdCluster.getId();
    }

    private static void updateCluster(SpotOceanK8sClusterClient client, String clusterId) {
        System.out.println("-------------------------start updating ocean cluster------------------------");
        //Create cluster update
        ClusterCapacityConfiguration.Builder updateCapacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration updateCapacity =
                updateCapacityBuilder.setMinimum(0).setTarget(1).setMaximum(2).build();

        ClusterStrategyConfiguration.Builder updateStrategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration updateStrategy = updateStrategyBuilder.setGracePeriod(null).build();

        // Build cluster update
        OceanK8sCluster.Builder updateOceanClusterBuilder = OceanK8sCluster.Builder.get();
        OceanK8sCluster oceanK8sClusterUpdate =
                updateOceanClusterBuilder.setCapacity(updateCapacity).setName("Java-SDK-Testing-Update").build();

        K8sClusterUpdateRequest.Builder clusterUpdateRequestBuilder = K8sClusterUpdateRequest.Builder.get();
        K8sClusterUpdateRequest updateRequest               =
                clusterUpdateRequestBuilder.setCluster(oceanK8sClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateK8sCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated.");
        }
    }

    private static void deleteCluster(SpotOceanK8sClusterClient client, String clusterId) {
        System.out.println("-------------------------start deleting ocean cluster------------------------");
        K8sClusterDeleteRequest.Builder deletionBuilder = K8sClusterDeleteRequest.Builder.get();
        K8sClusterDeleteRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteK8sCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster successfully deleted: " + clusterId);
        }
    }

    private static OceanK8sCluster getCluster(SpotOceanK8sClusterClient client, String clusterId) {
        System.out.println("-------------------------start getting ocean cluster------------------------");
        K8sClusterGetRequest.Builder getBuilder = K8sClusterGetRequest.Builder.get();
        K8sClusterGetRequest         getRequest = getBuilder.setClusterId(clusterId).build();

        OceanK8sCluster oceanK8sCluster = client.getOceanK8sCluster(getRequest);
        if (oceanK8sCluster!=null) {
            System.out.println("Get Cluster successfully: " + oceanK8sCluster.getId());
        }
        return oceanK8sCluster;
    }

    private static List<OceanK8sCluster> getAllK8sClusters(SpotOceanK8sClusterClient client) {

        System.out.println("Getting all Kubernetes Clusters");

        return client.getAllK8sClusters();
    }

    private static GetK8sClusterHeartBeatStatusResponse getK8sClusterHeartBeatStatus(SpotOceanK8sClusterClient client, String clusterId) {

        System.out.println(String.format("Getting the Heartbeat status for the Kubernetes Cluster: %s", clusterId));
        GetK8sClusterHeartBeatStatusResponse clusterHeartBeatStatus = client.getK8sClusterHeartBeatStatus(clusterId);

        System.out.println(String.format("Status: %s", clusterHeartBeatStatus.getStatus()));
        System.out.println(String.format("LastHeartBeat: %s", clusterHeartBeatStatus.getLastHeartbeat()));

        return clusterHeartBeatStatus;
    }

    private static OceanK8sCluster importASGToOceanCluster(SpotOceanK8sClusterClient client, String autoscalingGroupName, String region) {

        System.out.println(String.format("Import ASG to ocean cluster. ASG name: %s", autoscalingGroupName));
        ImportAsgToClusterConfiguration.Builder instanceTypesBuilder = ImportAsgToClusterConfiguration.Builder.get();
        List<String> instancetypes = Arrays.asList("t2.medium", "t3.medium", "c4.xlarge");
        ImportAsgToClusterConfiguration instanceTypes = instanceTypesBuilder.setInstanceTypes(instancetypes).build();

        OceanK8sCluster asgConfigToImport = client.importASGToOceanCluster(instanceTypes, autoscalingGroupName, region);

        System.out.println(String.format("Response: %s", asgConfigToImport.toString()));

        return asgConfigToImport;
    }

    private static List<K8sClusterFetchElastilogResponse> fetchElastilog(SpotOceanK8sClusterClient client, String accountId, String fromDate, String limit, String resourceId, String severity, String toDate, String clusterId) {

        // Build get request
        K8sClusterFetchElastilogRequest.Builder getElastilogRequestBuilder = K8sClusterFetchElastilogRequest.Builder.get();
        K8sClusterFetchElastilogRequest request = getElastilogRequestBuilder.setAccountId(accountId)
                .setFromDate(fromDate).setLimit(limit).setResourceId(resourceId)
                .setSeverity(severity).setToDate(toDate).build();

        List<K8sClusterFetchElastilogResponse> k8sGetLogsResponse =
                client.fetchElastilog(request, clusterId);

        for (K8sClusterFetchElastilogResponse logs : k8sGetLogsResponse) {
            System.out.println(String.format("Message: %s", logs.getMessage()));
            System.out.println(String.format("Severity: %s", logs.getSeverity()));
            System.out.println(String.format("Created At: %s", logs.getCreatedAt()));
        }

        return k8sGetLogsResponse;
    }

    private static Boolean detachClusterInstances(SpotOceanK8sClusterClient client, String clusterId, List instances, Boolean shouldDecrementTargetCapacity, Boolean shouldTerminateInstances) {

        DetachInstances.Builder detachInstancesBuilder = DetachInstances.Builder.get();
        DetachInstances detachInstances                = detachInstancesBuilder.setInstancesToDetach(instances).setShouldDecrementTargetCapacity(shouldDecrementTargetCapacity).setShouldTerminateInstances(shouldTerminateInstances).build();

        System.out.println(String.format("Detach the instances for cluster: %s", clusterId));
        Boolean detachedStatus = client.detachInstances(detachInstances, clusterId);

        return detachedStatus;
    }

    private static ClusterRollResponse initiateClusterRoll(SpotOceanK8sClusterClient client, String clusterId, Integer batchSizePercentage, String comment, Boolean respectPdb, Integer batchMinHealthyPercentage) {

        InitiateRoll.Builder initiateRollBuilder = InitiateRoll.Builder.get();
        InitiateRoll initiateRoll = initiateRollBuilder.setBatchSizePercentage(batchSizePercentage).setComment(comment).setRespectPdb(respectPdb).setBatchMinHealthyPercentage(batchMinHealthyPercentage).build();

        System.out.println(String.format("Initiate cluster Roll: %s", clusterId));
        ClusterRollResponse detachStatus = client.initiateRoll(initiateRoll, clusterId);

        String rollId = detachStatus.getId();

        return detachStatus;
    }

    private static ClusterRollResponse getClusterRollStatus (SpotOceanK8sClusterClient client, String clusterId, String rollId) {

        System.out.println(String.format("Get cluster Roll. ClusterId: %s, RollId: %s", clusterId, rollId));
        ClusterRollResponse getRollResponse = client.getRoll(clusterId, rollId);

        k8sClusterRollStatusEnum rollStatus = getRollResponse.getStatus();

        return getRollResponse;
    }

    private static List<ClusterRollResponse> getAllClusterRolls(SpotOceanK8sClusterClient client, String clusterId) {

        System.out.println(String.format("Get all cluster Rolls. ClusterId: %s", clusterId));
        List<ClusterRollResponse> getAllRolls = client.listRolls(clusterId);

        for (ClusterRollResponse roll : getAllRolls){
            System.out.println(String.format("RollId: %s", roll.getId()));
            System.out.println(String.format("RollId: %s", roll.getStatus()));
        }
        return getAllRolls;
    }

    private static ClusterRollResponse updateClusterRoll(SpotOceanK8sClusterClient client, String clusterId, String rollId, String status) {

        UpdateRollRequest.Builder updateRollBuilder = UpdateRollRequest.Builder.get();
        UpdateRollRequest updateRoll = updateRollBuilder.setStatus(status).build();

        System.out.println(String.format("Update Cluster Roll. ClusterId: %s, RollId: %s", clusterId, rollId));
        ClusterRollResponse response = client.updateRoll(updateRoll, clusterId, rollId);

        System.out.println(String.format("RollStatus: %s", response.getStatus()));

        return response;
    }



    private static List<GetClusterNodesResponse> getClusterNodes(SpotOceanK8sClusterClient client, String clusterId) {
        System.out.println("-------------------------Get cluster Nodes------------------------");

        GetClusterNodesRequest.Builder getNodesBuilder = GetClusterNodesRequest.Builder.get();
        GetClusterNodesRequest getNodesRequest = getNodesBuilder.setAccountId(act_id).build();

        // Fetch the nodes
        List<GetClusterNodesResponse>  nodes = client.getClusterNodes(getNodesRequest, clusterId);

        for (GetClusterNodesResponse node : nodes){
            System.out.println(String.format("InstanceId: %s", node.getInstanceId()));
            System.out.println(String.format("InstanceType: %s", node.getInstanceType()));
            System.out.println(String.format("LaunchSpecId: %s", node.getLaunchSpecId()));
            System.out.println(String.format("LaunchSpecName: %s", node.getLaunchSpecName()));
            System.out.println(String.format("NodeName: %s", node.getNodeName()));
        }

        return nodes;
    }
}
