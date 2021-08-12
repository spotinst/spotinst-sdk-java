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
    private final static String         auth_token                  = "553579a8c5d58e1180376dbf385da3066e41b59c293c5c685a9799fb36ff670a";
    private final static String         act_id                      = "act-7c46c6df";
    private final static String         image_id                    = "ami-082b5a644766e0e6f";
    private final static String         region                      = "us-west-2";
    private final static String         keyPair                     = "AutomationKeyPair";
    private final static List<String>   securityGroups              = Arrays.asList("sg-a22000e8");
    private final static List<String>   subnetIds                   = Arrays.asList("subnet-4333093a", "subnet-8ab89cc1", "subnet-42f1e418");
    private final static String         userData                    = "dXNlcmJhc2g2NGVuY29kZWQ=";
    private final static List<String>   whiteListInstanceTypes      = Arrays.asList("t3.medium", "m4.xlarge", "m4.2xlarge");

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
       ClusterAttributes            attributes        = attributesBuilder1.setKey("creator").setValue("bansiben@netapp.com").build();

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
               iamInstanceProfileBuilder.setArn("arn:aws:iam::842422002533:instance-profile/ecsInstanceRole").build();

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
                                                                .setUserData(userData)
                                                                .setKeyPair(keyPair)
                                                                .setSecurityGroupIds(securityGroups)
                                                                .setInstanceMetadataOptions(instanceMetadataOptions)
                                                                .setIamInstanceProfile(iamInstanceProfile)
                                                                .setBlockDeviceMappings(blockDeviceMappings)
                                                                .setAssociatePublicIpAddress(false)
                                                                .setTags(tags)
                                                                .build();
       //Build Instance Types
       ClusterInstanceTypes.Builder instanceTypesBuilder = ClusterInstanceTypes.Builder.get();
       ClusterInstanceTypes instanceTypes = instanceTypesBuilder.setWhitelist(whiteListInstanceTypes).build();

       //Build compute
       ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
       ClusterComputeConfiguration compute = computeBuilder.setLaunchSpecification(launchSpec).setSubnetIds(subnetIds)
                                                           .setOptimizeImages(optimizeImage)
                                                           .setInstanceTypes(instanceTypes)
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
      ClusterStrategyConfiguration strategy = strategyBuilder.setDrainingTimeout(120).setFallbackToOnDemand(true).setspotPercentage(50).setUtilizeReservedInstances(true).setUtilizeCommitments(true).build();

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

    private static void updateClusterCapacity(SpotOceanEcsClusterClient client, String clusterId) {

        // Build cluster update
        OceanEcsCluster.Builder updateOceanClusterBuilder = OceanEcsCluster.Builder.get();

        //Build Attributes
        ClusterAttributes.Builder    attributesBuilder1 = ClusterAttributes.Builder.get();
        ClusterAttributes            attributes        = attributesBuilder1.setKey("creator").setValue("bansi").build();

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
                                                                 .setUserData(userData)
                                                                 .setKeyPair(keyPair)
                                                                 .setSecurityGroupIds(securityGroups)
                                                                 .setInstanceMetadataOptions(instanceMetadataOptions)
                                                                 .setBlockDeviceMappings(blockDeviceMappings)
                                                                 .setAssociatePublicIpAddress(false)
                                                                 .build();
        //Build compute
        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute = computeBuilder.setLaunchSpecification(launchSpec).setSubnetIds(subnetIds)
                                                            .setOptimizeImages(optimizeImage)
                                                            .build();

        //Build Strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy = strategyBuilder.setDrainingTimeout(120).setFallbackToOnDemand(true).setspotPercentage(50).setUtilizeReservedInstances(true).setUtilizeCommitments(true).build();

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

    private static void updateCluster(SpotOceanEcsClusterClient client, String clusterId) {
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
