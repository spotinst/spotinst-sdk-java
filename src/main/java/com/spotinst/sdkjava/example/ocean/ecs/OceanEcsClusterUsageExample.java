package com.spotinst.sdkjava.example.ocean.ecs;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.SpotOceanEcsClusterClient;
import com.spotinst.sdkjava.model.bl.ocean.ecs.*;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsClusterRequest;

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
                headroomSpecBuilder.setCpuPerUnit(2000).setMemoryPerUnit(0).setNumOfUnits(1).build();

        // Build ResourceLimit Specification
        ClusterResourceLimitsSpecification.Builder resourceLimitSpecBuilder =ClusterResourceLimitsSpecification.Builder.get();
        ClusterResourceLimitsSpecification resourceLimits =resourceLimitSpecBuilder.setMaxMemoryGib(8).setMaxVCpu(2000).build();

        //Build autoscale specification
        ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
        ClusterAutoScalerConfiguration autoScaler =
                clusterAutoScalerBuilder.setAttributes(attributes).setIsAutoConfig(false).setCooldown(180).setDown(down)
                                        .setAutoHeadroomPercentage(50).setHeadroom(headroom).setIsEnabled(true).setEnableAutomaticAndManualHeadroom(false)
                                        .setResourceLimits(resourceLimits).setShouldScaleDownNonServiceTasks(false)
                                        .build();

        //Build OptimizeImage
        List<String> timeWindows = Arrays.asList("Mon:10:00-Tue:10:00", "Sat:10:00-Sat:10:00");
        ClusterOptimizeImageConfiguration.Builder clusterOptimizeImageBuilder = ClusterOptimizeImageConfiguration.Builder.get();
        ClusterOptimizeImageConfiguration optimizeImage = clusterOptimizeImageBuilder.setTimeWindows(timeWindows)
                                                                                     .setPerformAt("timeWindow").setShouldOptimizeEcsAmi(true).build();
        //Build instance metadata options
        LaunchSpecInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder =
                LaunchSpecInstanceMetadataOptions.Builder.get();
        LaunchSpecInstanceMetadataOptions instanceMetadataOptions        =
                instanceMetadataOptionsBuilder.setHttpPutResponseHopLimit(18).setHttpTokens("optional").build();

        //Build ebs specification
        LaunchSpecEbsSpecification.Builder ebsBuilder = LaunchSpecEbsSpecification.Builder.get();
        LaunchSpecEbsSpecification ebs        = ebsBuilder.setDeleteOnTermination(true)
                                                          .setEncrypted(false)
                                                          .setVolumeType("gp2")
                                                          .setVolumeSize(50)
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
                                                                 .setBlockDeviceMappings(blockDeviceMappings)
                                                                 .build();
        //Build compute
        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute = computeBuilder.setLaunchSpecification(launchSpec).setSubnetIds(subnetIds)
                                                            .setOptimizeImages(optimizeImage)
                                                            .build();

        //Build Strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy = strategyBuilder.setDrainingTimeout(120).setFallbackToOnDemand(true).setspotPercentage(50).setUtilizeReservedInstances(true).build();

        OceanEcsCluster oceanEcsClusterUpdate =
                updateOceanClusterBuilder.setAutoScaler(autoScaler).setCompute(compute).setStrategy(strategy).build();

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

}
