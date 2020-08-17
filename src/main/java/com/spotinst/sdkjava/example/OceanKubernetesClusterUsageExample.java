package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.SpotOceanClusterClient;
import com.spotinst.sdkjava.model.Tag;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OceanKubernetesClusterUsageExample {
    //fields to change
    private final static String auth_token = "your-token";
    private final static String act_id     = "your-account-id";

    // Fill in the correct values from your account

    //todo lihi - rename values to be general
    private final static String       controllerClusterId        = "testSdkClusterid";
    private final static String       launchSpecificationImageId = "launchSpec image id";
    private final static List<String> securityGroups             = Arrays.asList("sg-0d8bb5479f633c0ac", "sg-a22000e8");
    private final static String       region                     = "us-west-2";
    private final static String       keyPair                    = "key-pair";
    private final static List<String> subnetIds                  = Arrays.asList("subnet-4333093a", "subnet-8ab89cc1");
    private final static String       arnRole                    = "arn role";

    public static void main(String[] args) {
        SpotOceanClusterClient clusterClient = SpotinstClient.getOceanClusterClient(auth_token, act_id);

        String clusterId = createCluster(clusterClient);
        System.out.println("Created a new cluster with id: " + clusterId);

        updateCluster(clusterClient, clusterId);
        deleteCluster(clusterClient, clusterId);
    }

    private static String createCluster(SpotOceanClusterClient client) {
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

    private static void updateCluster(SpotOceanClusterClient client, String clusterId) {
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
        Boolean updateSuccess = client.updateCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated.");
        }
    }

    private static void deleteCluster(SpotOceanClusterClient client, String clusterId) {
        System.out.println("-------------------------start deleting ocean cluster------------------------");
        ClusterDeleteRequest.Builder deletionBuilder = ClusterDeleteRequest.Builder.get();
        ClusterDeleteRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster successfully deleted: " + clusterId);
        }
    }

}
