package com.spotinst.sdkjava.example.ocean.ecs;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.enums.k8sClusterRollStatusEnum;
import com.spotinst.sdkjava.model.SpotOceanEcsClusterClient;
import com.spotinst.sdkjava.model.bl.ocean.ecs.*;
import com.spotinst.sdkjava.model.requests.ocean.ecs.GetEcsClusterNodesRequest;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsClusterRequest;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsUpdateRollRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OceanEcsClusterUsageExample {

    private final static String         auth_token                  = "auth_token";
    private final static String         act_id                      = "act_id";
    private final static String         image_id                    = "ami-123";
    private final static String         region                      = "region";
    private final static List<String>   securityGroups              = Arrays.asList("sg-1");
    private final static List<String>   subnetIds                   = Arrays.asList("subnet-1", "subnet-2");

    public static void main(String[] args) throws InterruptedException {

        SpotOceanEcsClusterClient clusterClient = SpotinstClient.getOceanEcsClusterClient(auth_token, act_id);

        System.out.println("----------Creation of ocean ecs cluster--------------");
        String clusterId = createCluster(clusterClient);

        System.out.println("----------Get ocean ecs cluster--------------");
        OceanEcsCluster ecsCluster = getCluster(clusterClient, clusterId);
        // Convert ocean ecs cluster response to json
        System.out.println(JsonMapper.toJson(ecsCluster));

        System.out.println("----------Update ocean ecs cluster Name--------------");
        updateClusterName(clusterClient, clusterId);

        System.out.println("----------Update ocean ecs cluster Capacity--------------");
        updateClusterCapacity(clusterClient, clusterId);

        System.out.println("----------Update ocean ecs cluster--------------");
        updateCluster(clusterClient, clusterId);

        System.out.println("----------List of ecs clusters--------------");
        List<OceanEcsCluster> allEcsClusters = listOceanEcsClusters(clusterClient);
        for (OceanEcsCluster myEcsCluster : allEcsClusters) {
            System.out.println(String.format("OceanEcsCluster Id: %s, OceanEcsCluster Name: %s", myEcsCluster.getId(),
                                             myEcsCluster.getName()));
        }

        System.out.println("----------Delete ocean ecs cluster--------------");
        deleteCluster(clusterClient, clusterId);

        //Initiate Roll
        System.out.println("----------Initiate Roll--------------");
        EcsClusterRollResponse initiateRollResponse = initiateClusterRoll(clusterClient, "cluster-id", 25, "comment", true, 100);

        //Get cluster Roll
        System.out.println("----------Get cluster Roll--------------");
        EcsClusterRollResponse getClusterRollStatus = getClusterRollStatus (clusterClient, "cluster-id", "rollId");

        //List cluster Rolls
        System.out.println("----------List cluster Rolls--------------");
        List<EcsClusterRollResponse> listClusterRolls = getAllClusterRolls(clusterClient, "cluster-id");

        //Update cluster Roll
        System.out.println("----------Update cluster Roll--------------");
        EcsClusterRollResponse updateRollResponse = updateClusterRoll(clusterClient, "cluster-id", "roll-id", "STOPPED");

        //Get cluster container instances
        System.out.println("----------Get cluster container instances--------------");
        List<GetEcsClusterNodesResponse> nodes = getClusterContainerInstances(clusterClient, "cluster-id");

        System.out.println("----------Import ocean ecs cluster--------------");
        ImportOceanEcsClusterObjectResponse importOceanEcsClusterResponse = importEcsCluster(clusterClient, "cluster-name");

   }

   private static String createCluster(SpotOceanEcsClusterClient client) {

      //Build Attributes
       ClusterAttributes.Builder    attributesBuilder1 = ClusterAttributes.Builder.get();
       ClusterAttributes            attributes        = attributesBuilder1.setKey("key2").setValue("value2").build();

      // Build down
      ClusterDownSpecification.Builder downSpecBuilder = ClusterDownSpecification.Builder.get();
      ClusterDownSpecification         down            = downSpecBuilder.setMaxScaleDownPercentage(60).setEvaluationPeriods(4).build();

      // Build autoHeadroomPercentage
      ClusterHeadroomsSpecification.Builder headroomSpecBuilder = ClusterHeadroomsSpecification.Builder.get();
      ClusterHeadroomsSpecification headroom =
              headroomSpecBuilder.setCpuPerUnit(2000).setMemoryPerUnit(0).setNumOfUnits(2).build();

      // Build ResourceLimit Specification
      ClusterResourceLimitsSpecification.Builder resourceLimitSpecBuilder =ClusterResourceLimitsSpecification.Builder.get();
      ClusterResourceLimitsSpecification resourceLimits =resourceLimitSpecBuilder.setMaxMemoryGib(5).setMaxVCpu(2000).build();

       //Build autoscale specification
       ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
       ClusterAutoScalerConfiguration autoScaler =
              clusterAutoScalerBuilder.setAttributes(attributes).setIsAutoConfig(false).setCooldown(180).setDown(down)
                                      .setAutoHeadroomPercentage(50).setHeadroom(headroom).setIsEnabled(true).setEnableAutomaticAndManualHeadroom(false)
                                      .setResourceLimits(resourceLimits).setShouldScaleDownNonServiceTasks(false)
                                      .build();

      //Build OptimizeImage
      List<String> timeWindows = Arrays.asList("Mon:12:00-Tue:12:00", "Fri:12:00-Sat:12:00");
      ClusterOptimizeImageConfiguration.Builder clusterOptimizeImageBuilder = ClusterOptimizeImageConfiguration.Builder.get();
      ClusterOptimizeImageConfiguration optimizeImage = clusterOptimizeImageBuilder.setTimeWindows(timeWindows)
                                                        .setPerformAt("timeWindow").setShouldOptimizeEcsAmi(true)
                                                        .build();

       LaunchSpecIamInstanceProfileSpecification.Builder iamInstanceProfileBuilder = LaunchSpecIamInstanceProfileSpecification.Builder.get();
       LaunchSpecIamInstanceProfileSpecification iamInstanceProfile        =
               iamInstanceProfileBuilder.setArn("arn:aws:iam::abc1234").build();

       //Build tags
       LaunchSpecTagsSpecification.Builder tagBuilder = LaunchSpecTagsSpecification.Builder.get();
       LaunchSpecTagsSpecification         tag1       = tagBuilder.setTagKey("Creator").setTagValue("Automation").build();
       List<LaunchSpecTagsSpecification>   tags       = Collections.singletonList(tag1);

       //Build instance metadata options
       LaunchSpecInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder =
               LaunchSpecInstanceMetadataOptions.Builder.get();
       LaunchSpecInstanceMetadataOptions instanceMetadataOptions        =
               instanceMetadataOptionsBuilder.setHttpPutResponseHopLimit(12).setHttpTokens("optional").build();

       //Build dynamic volumesize mapping
       LaunchSpecDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = LaunchSpecDynamicVolumeSize.Builder.get();
       LaunchSpecDynamicVolumeSize dynamicVolumeSize  = dynamicVolumeSizeBuilder.setBaseSize(50).setResource("CPU").setSizePerResourceUnit(20).build();

       //Build ebs specification
       LaunchSpecEbsSpecification.Builder ebsBuilder = LaunchSpecEbsSpecification.Builder.get();
       LaunchSpecEbsSpecification ebs        = ebsBuilder.setThroughput(400)
                                                         .setDeleteOnTermination(true)
                                                         .setEncrypted(false)
                                                         .setVolumeType("gp3")
                                                         .setDynamicVolumeSize(dynamicVolumeSize)
                                                         .build();

       //Build block device mappings
       LaunchSpecBlockDeviceMappings.Builder blockDeviceBuilder1  = LaunchSpecBlockDeviceMappings.Builder.get();
       LaunchSpecBlockDeviceMappings         blockDeviceMappings1 = blockDeviceBuilder1.setDeviceName("/dev/xvda").setEbs(ebs).build();
       List<LaunchSpecBlockDeviceMappings>   blockDeviceMappings  = Collections.singletonList(blockDeviceMappings1);

       // Build launch specification
       ClusterLaunchSpecification.Builder launchSpecBuilder = ClusterLaunchSpecification.Builder.get();
       ClusterLaunchSpecification launchSpec = launchSpecBuilder.setImageId(image_id)
                                                                .setUserData("dXNlcmJhc2g2NGVuY29kZWQ=")
                                                                .setSecurityGroupIds(securityGroups)
                                                                .setInstanceMetadataOptions(instanceMetadataOptions)
                                                                .setIamInstanceProfile(iamInstanceProfile)
                                                                .setBlockDeviceMappings(blockDeviceMappings)
                                                                .setTags(tags)
                                                                .build();

       //Build compute
       ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
       ClusterComputeConfiguration compute = computeBuilder.setLaunchSpecification(launchSpec).setSubnetIds(subnetIds)
                                                           .setOptimizeImages(optimizeImage)
                                                           .build();

      //Build Capacity
      ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
      ClusterCapacityConfiguration capacity = capacityBuilder.setMaximum(1000).setMinimum(0).setTarget(0).build();

      // Build ShutdownHours
       ClusterShutdownHoursSpecification.Builder shutDownSpecBuilder = ClusterShutdownHoursSpecification.Builder.get();
       ClusterShutdownHoursSpecification shutDownHours =
               shutDownSpecBuilder.setEnabled(false).setTimeWindows(timeWindows).build();

       //Build Scheduling
      ClusterTasksConfiguration.Builder tasksBuilder = ClusterTasksConfiguration.Builder.get();

      ClusterTasksConfiguration task =
              tasksBuilder.setIsEnabled(true).setCronExpression("0 1 * * *").setTaskType("clusterRoll").build();
      List<ClusterTasksConfiguration> tasksList = Collections.singletonList(task);
      ClusterSchedulingConfiguration.Builder schedulingBuilder = ClusterSchedulingConfiguration.Builder.get();
      ClusterSchedulingConfiguration scheduling = schedulingBuilder.setShutdownHours(shutDownHours).setTasks(tasksList).build();

      //Build Strategy
      ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
      ClusterStrategyConfiguration strategy = strategyBuilder.setDrainingTimeout(120).setFallbackToOnDemand(true).setspotPercentage(50).setUtilizeReservedInstances(true).build();

      // Build Ocean Ecs Cluster
      OceanEcsCluster.Builder ocenEcsBuilder = OceanEcsCluster.Builder.get();
      OceanEcsCluster ocenEcsCluster = ocenEcsBuilder.setClusterName("Automation-java-SDK-OceanEcsCluster").setRegion(region).setName("Automation-java-SDK-OceanEcsCluster")
                                        .setAutoScaler(autoScaler)
                                        .setCompute(compute).setCapacity(capacity).setScheduling(scheduling).setStrategy(strategy).build();

      // Build cluster creation request
      OceanEcsClusterRequest.Builder clusterCreationRequestBuilder =  OceanEcsClusterRequest.Builder.get();
      OceanEcsClusterRequest creationRequest = clusterCreationRequestBuilder.setCluster(ocenEcsCluster).build();

      // Convert cluster to API object json
      System.out.println(creationRequest.toJson());

      // Create cluster
      OceanEcsCluster createdCluster = client.createOceanEcsCluster(creationRequest);
      System.out.println("Cluster successfully created: " + createdCluster.getId());

      return createdCluster.getId();

   }

    private static OceanEcsCluster getCluster(SpotOceanEcsClusterClient client, String clusterId){

       System.out.println("-------------------------start getting ocean cluster------------------------");
       OceanEcsClusterRequest.Builder getBuilder = OceanEcsClusterRequest.Builder.get();
       OceanEcsClusterRequest getRequest = getBuilder.setClusterId(clusterId).build();

       OceanEcsCluster oceanEcsCluster = client.getOceanEcsCluster(getRequest);

       if (oceanEcsCluster!=null) {
           System.out.println("Get Cluster successfully: " + oceanEcsCluster.getId());
       }
       return oceanEcsCluster;
   }

    private static void updateClusterName(SpotOceanEcsClusterClient client, String clusterId) {

        // Build cluster update
        OceanEcsCluster.Builder updateOceanClusterBuilder = OceanEcsCluster.Builder.get();
        OceanEcsCluster oceanEcsClusterUpdate =
                updateOceanClusterBuilder.setName("Automation-java-SDK-OceanEcsCluster-Renamed").build();

        OceanEcsClusterRequest.Builder clusterUpdateRequestBuilder = OceanEcsClusterRequest.Builder.get();
        OceanEcsClusterRequest updateRequest               =
                clusterUpdateRequestBuilder.setCluster(oceanEcsClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateEcsCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated.");
        }
    }

    private static void updateCluster(SpotOceanEcsClusterClient client, String clusterId) {

        // Build cluster update
        OceanEcsCluster.Builder updateOceanClusterBuilder = OceanEcsCluster.Builder.get();

        //Build Attributes
        ClusterAttributes.Builder    attributesBuilder1 = ClusterAttributes.Builder.get();
        ClusterAttributes            attributes        = attributesBuilder1.setKey("key1").setValue("value1").build();

        // Build down
        ClusterDownSpecification.Builder downSpecBuilder = ClusterDownSpecification.Builder.get();
        ClusterDownSpecification         down            = downSpecBuilder.setMaxScaleDownPercentage(50).setEvaluationPeriods(5).build();

        // Build autoHeadroomPercentage
        ClusterHeadroomsSpecification.Builder headroomSpecBuilder = ClusterHeadroomsSpecification.Builder.get();
        ClusterHeadroomsSpecification headroom =
                headroomSpecBuilder.setCpuPerUnit(4000).setMemoryPerUnit(1).setNumOfUnits(1).build();

        // Build ResourceLimit Specification
        ClusterResourceLimitsSpecification.Builder resourceLimitSpecBuilder =ClusterResourceLimitsSpecification.Builder.get();
        ClusterResourceLimitsSpecification resourceLimits =resourceLimitSpecBuilder.setMaxMemoryGib(8).setMaxVCpu(2000).build();

        //Build autoscale specification
        ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
        ClusterAutoScalerConfiguration autoScaler =
                clusterAutoScalerBuilder.setAttributes(attributes).setIsAutoConfig(true).setCooldown(240).setDown(down)
                                        .setAutoHeadroomPercentage(25).setHeadroom(headroom).setIsEnabled(false).setEnableAutomaticAndManualHeadroom(true)
                                        .setResourceLimits(resourceLimits).setShouldScaleDownNonServiceTasks(true)
                                        .build();

        //Build OptimizeImage
        List<String> timeWindows = Arrays.asList("Mon:10:00-Tue:10:00", "Sat:10:00-Sat:10:00");
        ClusterOptimizeImageConfiguration.Builder clusterOptimizeImageBuilder = ClusterOptimizeImageConfiguration.Builder.get();
        ClusterOptimizeImageConfiguration optimizeImage = clusterOptimizeImageBuilder.setTimeWindows(timeWindows)
                                                                                     .setPerformAt("timeWindow").setShouldOptimizeEcsAmi(false).build();
        //Build instance metadata options
        LaunchSpecInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder = LaunchSpecInstanceMetadataOptions.Builder.get();
        LaunchSpecInstanceMetadataOptions instanceMetadataOptions        =
                instanceMetadataOptionsBuilder.setHttpPutResponseHopLimit(18).setHttpTokens("required").build();

        //Build ebs specification
        LaunchSpecEbsSpecification.Builder ebsBuilder = LaunchSpecEbsSpecification.Builder.get();
        LaunchSpecEbsSpecification ebs        = ebsBuilder.setDeleteOnTermination(false)
                                                          .setEncrypted(true)
                                                          .setVolumeType("gp2")
                                                          .setVolumeSize(50)
                                                          .build();

        //Build block device mappings
        LaunchSpecBlockDeviceMappings.Builder blockDeviceBuilder1  = LaunchSpecBlockDeviceMappings.Builder.get();
        LaunchSpecBlockDeviceMappings         blockDeviceMappings1 = blockDeviceBuilder1.setDeviceName("/dev/xvdb").setEbs(ebs).build();
        List<LaunchSpecBlockDeviceMappings>   blockDeviceMappings  = Collections.singletonList(blockDeviceMappings1);

        LaunchSpecTagsSpecification.Builder tagBuilder = LaunchSpecTagsSpecification.Builder.get();
        LaunchSpecTagsSpecification         tag2       = tagBuilder.setTagKey("Creator").setTagValue("Automation_Creator").build();
        List<LaunchSpecTagsSpecification>   tags       = Collections.singletonList(tag2);

        // Build launch specification
        ClusterLaunchSpecification.Builder launchSpecBuilder = ClusterLaunchSpecification.Builder.get();
        ClusterLaunchSpecification launchSpec = launchSpecBuilder.setImageId(image_id)
                                                                 .setUserData("QXV0b21hdGlvbiB1c2VyIGRhdGE=")
                                                                 .setSecurityGroupIds(securityGroups)
                                                                 .setInstanceMetadataOptions(instanceMetadataOptions)
                                                                 .setBlockDeviceMappings(blockDeviceMappings)
                                                                 .setTags(tags).build();
        //Build Capacity
        ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration capacity = capacityBuilder.setMaximum(200).setMinimum(10).setTarget(20).build();

        //Build Scheduling
        ClusterTasksConfiguration.Builder tasksBuilder = ClusterTasksConfiguration.Builder.get();

        ClusterTasksConfiguration task =
                tasksBuilder.setIsEnabled(false).setCronExpression("1 1 * * *").setTaskType("clusterRoll").build();
        List<ClusterTasksConfiguration> tasksList = Collections.singletonList(task);
        ClusterSchedulingConfiguration.Builder schedulingBuilder = ClusterSchedulingConfiguration.Builder.get();
        ClusterSchedulingConfiguration scheduling = schedulingBuilder.setTasks(tasksList).build();

        //Build compute
        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute = computeBuilder.setLaunchSpecification(launchSpec).setSubnetIds(subnetIds)
                                                            .setOptimizeImages(optimizeImage)
                                                            .build();

        //Build Strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy = strategyBuilder.setDrainingTimeout(240).setFallbackToOnDemand(false).setspotPercentage(0).setUtilizeReservedInstances(false).build();

        OceanEcsCluster oceanEcsClusterUpdate =
                updateOceanClusterBuilder.setCapacity(capacity).setAutoScaler(autoScaler).setScheduling(scheduling).setCompute(compute).setStrategy(strategy).build();

        OceanEcsClusterRequest.Builder clusterUpdateRequestBuilder = OceanEcsClusterRequest.Builder.get();
        OceanEcsClusterRequest updateRequest               =
                clusterUpdateRequestBuilder.setCluster(oceanEcsClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateEcsCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated."+ clusterId);
        }
    }

    private static void updateClusterCapacity(SpotOceanEcsClusterClient client, String clusterId) {
         // Build cluster update
        OceanEcsCluster.Builder updateOceanClusterBuilder = OceanEcsCluster.Builder.get();

        // Build Capacity
        ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration capacity = capacityBuilder.setMaximum(1000).setMinimum(1).setTarget(2).build();

        OceanEcsCluster oceanEcsClusterUpdate =
                updateOceanClusterBuilder.setCapacity(capacity).build();

        OceanEcsClusterRequest.Builder clusterUpdateRequestBuilder = OceanEcsClusterRequest.Builder.get();
        OceanEcsClusterRequest updateRequest               =
                clusterUpdateRequestBuilder.setCluster(oceanEcsClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateEcsCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated."+ clusterId);
        }
    }

    private static List<OceanEcsCluster> listOceanEcsClusters(SpotOceanEcsClusterClient client) {
        return client.getAllOceanEcsClusters();
    }

    private static void deleteCluster(SpotOceanEcsClusterClient client, String clusterId) {

        OceanEcsClusterRequest.Builder deletionBuilder = OceanEcsClusterRequest.Builder.get();
        OceanEcsClusterRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteEcsCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster successfully deleted: " + clusterId);
        }
    }

    private static EcsClusterRollResponse initiateClusterRoll(SpotOceanEcsClusterClient client, String clusterId, Integer batchSizePercentage, String comment, Boolean respectPdb, Integer batchMinHealthyPercentage) {

        EcsInitiateRoll.Builder initiateRollBuilder = EcsInitiateRoll.Builder.get();
        EcsInitiateRoll initiateRoll = initiateRollBuilder.setBatchSizePercentage(batchSizePercentage).setComment(comment).setBatchMinHealthyPercentage(batchMinHealthyPercentage).build();

        System.out.println(String.format("Initiate cluster Roll: %s", clusterId));
        EcsClusterRollResponse rollResponse = client.initiateRoll(initiateRoll, clusterId);

        String rollId = rollResponse.getId();

        return rollResponse;
    }

    private static EcsClusterRollResponse getClusterRollStatus (SpotOceanEcsClusterClient client, String clusterId, String rollId) {

        System.out.println(String.format("Get cluster Roll. ClusterId: %s, RollId: %s", clusterId, rollId));
        EcsClusterRollResponse getRollResponse = client.getRoll(clusterId, rollId);

        k8sClusterRollStatusEnum rollStatus = getRollResponse.getStatus();

        return getRollResponse;
    }

    private static List<EcsClusterRollResponse> getAllClusterRolls(SpotOceanEcsClusterClient client, String clusterId) {

        System.out.println(String.format("Get all cluster Rolls. ClusterId: %s", clusterId));
        List<EcsClusterRollResponse> getAllRolls = client.listRolls(clusterId);

        for (EcsClusterRollResponse roll : getAllRolls){
            System.out.println(String.format("RollId: %s", roll.getId()));
            System.out.println(String.format("RollId: %s", roll.getStatus()));
        }
        return getAllRolls;
    }

    private static EcsClusterRollResponse updateClusterRoll(SpotOceanEcsClusterClient client, String clusterId, String rollId, String status) {

        OceanEcsUpdateRollRequest.Builder updateRollBuilder = OceanEcsUpdateRollRequest.Builder.get();
        OceanEcsUpdateRollRequest updateRoll = updateRollBuilder.setStatus(status).build();

        System.out.println(String.format("Update Cluster Roll. ClusterId: %s, RollId: %s", clusterId, rollId));
        EcsClusterRollResponse response = client.updateRoll(updateRoll, clusterId, rollId);

        System.out.println(String.format("RollStatus: %s", response.getStatus()));

        return response;
    }

    private static List<GetEcsClusterNodesResponse> getClusterContainerInstances(SpotOceanEcsClusterClient client, String clusterId) {
        System.out.println("-------------------------Get cluster Nodes------------------------");

        GetEcsClusterNodesRequest.Builder getNodesBuilder = GetEcsClusterNodesRequest.Builder.get();
        GetEcsClusterNodesRequest getNodesRequest = getNodesBuilder.setAccountId(act_id).build();

        // Fetch the nodes
        List<GetEcsClusterNodesResponse>  nodes = client.getClusterContainerInstances(getNodesRequest, clusterId);

        for (GetEcsClusterNodesResponse node : nodes){
            System.out.println(String.format("InstanceId: %s", node.getInstanceId()));
            System.out.println(String.format("InstanceType: %s", node.getInstanceType()));
            System.out.println(String.format("LaunchSpecId: %s", node.getLaunchSpecId()));
            System.out.println(String.format("LaunchSpecName: %s", node.getLaunchSpecName()));
            System.out.println(String.format("NodeName: %s", node.getContainerInstanceId()));
        }

        return nodes;
    }

    private static ImportOceanEcsClusterObjectResponse importEcsCluster(SpotOceanEcsClusterClient client, String ecsClusterName) {

        ImportEcsCluster.Builder importEcsClusterBuilder = ImportEcsCluster.Builder.get();
        ImportEcsCluster importEcsCluster = importEcsClusterBuilder.setName("ECS_Import").setRegion("us-west2").build();

        System.out.println(String.format("Import ECS Cluster. ClusterName: %s", ecsClusterName));

        return client.importEcsCluster(importEcsCluster, ecsClusterName);
    }


}
