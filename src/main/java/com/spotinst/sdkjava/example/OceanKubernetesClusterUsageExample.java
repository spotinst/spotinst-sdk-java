package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.SpotOceanK8sClusterClient;
import com.spotinst.sdkjava.model.Tag;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;

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
        System.out.println("Created a new cluster with id: " + clusterId);
        OceanCluster cluster = getCluster(clusterClient,clusterId);
        System.out.println("Retrieved cluster id: " + cluster.getId());
        updateCluster(clusterClient, clusterId);
        deleteCluster(clusterClient, clusterId);
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
        OceanCluster.Builder oceanBuilder = OceanCluster.Builder.get();
        OceanCluster oceanCluster =
                oceanBuilder.setName("Java-SDK-Testing").setRegion(region).setControllerClusterId(controllerClusterId)
                            .setAutoScaler(autoScaler).setStrategy(strategy).setCapacity(capacity).setCompute(compute)
                            .setScheduling(scheduling).build();
        // Build cluster creation request
        ClusterCreationRequest.Builder clusterCreationRequestBuilder = ClusterCreationRequest.Builder.get();
        ClusterCreationRequest         creationRequest               =
                clusterCreationRequestBuilder.setCluster(oceanCluster).build();

        // Convert cluster to API object json
        System.out.println(JsonMapper.toJson(creationRequest));

        // Create cluster
        OceanCluster createdCluster = client.createK8sCluster(creationRequest);
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
        OceanCluster.Builder updateOceanClusterBuilder = OceanCluster.Builder.get();
        OceanCluster oceanClusterUpdate =
                updateOceanClusterBuilder.setCapacity(updateCapacity).setName("Java-SDK-Testing-Update").build();

        ClusterUpdateRequest.Builder clusterUpdateRequestBuilder = ClusterUpdateRequest.Builder.get();
        ClusterUpdateRequest         updateRequest               =
                clusterUpdateRequestBuilder.setCluster(oceanClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(JsonMapper.toJson(updateRequest));

        // Update cluster
        Boolean updateSuccess = client.updateK8sCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated.");
        }
    }

    private static void deleteCluster(SpotOceanK8sClusterClient client, String clusterId) {
        System.out.println("-------------------------start deleting ocean cluster------------------------");
        ClusterDeleteRequest.Builder deletionBuilder = ClusterDeleteRequest.Builder.get();
        ClusterDeleteRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteK8sCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster successfully deleted: " + clusterId);
        }
    }

    private static OceanCluster getCluster(SpotOceanK8sClusterClient client, String clusterId) {
        System.out.println("-------------------------start getting ocean cluster------------------------");
        ClusterGetRequest.Builder getBuilder = ClusterGetRequest.Builder.get();
        ClusterGetRequest         getRequest = getBuilder.setClusterId(clusterId).build();

        OceanCluster succesffulGet = client.getOceanK8sCluster(getRequest);
        if (succesffulGet!=null) {
            System.out.println("Get Cluster successfully: " + clusterId);
        }
        return succesffulGet;
    }



}
