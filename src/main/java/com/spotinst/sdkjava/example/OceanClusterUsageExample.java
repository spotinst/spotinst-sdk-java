package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.SpotinstOceanClusterClient;
import com.spotinst.sdkjava.model.Tag;
import com.spotinst.sdkjava.model.bl.ocean.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OceanClusterUsageExample {
    private final static String auth_token          =
            "33016d3ae3388f8c85015813155481aeafaac718cc76d1d527fb605bf83a5015";
    private final static String act_id              = "act-7c46c6df";
    private final static String controllerClusterId = "testSdkCluster_2";


    public static void main(String[] args) {
        SpotinstOceanClusterClient clusterClient = SpotinstClient.getOceanClusterClient(auth_token, act_id);

        String clusterId = createCluster(clusterClient);
        System.out.println("Created a new cluster with id: " + clusterId);

        updateCluster(clusterClient, clusterId);
        deleteCluster(clusterClient, clusterId);
    }

    private static String createCluster(SpotinstOceanClusterClient client) {
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
        ClusterCapacityConfiguration         capacity        =
                capacityBuilder.setMaximum(0).setMinimum(0).setTarget(0).build();

        //Build strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy =
                strategyBuilder.setFallbackToOnDemand(false).setUtilizeReservedInstances(true).setDrainingTimeout(60)
                               .setGracePeriod(600).build();

        //Build compute
        Tag.Builder tagsBuilder = Tag.Builder.get();

        //todo lihi -  extract all mandatory filed to be members of the class, that should be filled by whoever runs the example.
        //todo lihi - change to more generic email
        Tag       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("lihi.shoham@spot.io").build();
        List<Tag> tagsList = Collections.singletonList(tag1);

        //todo lihi - Arrays.asList
        List<String> securityGroups = new ArrayList<>();
        securityGroups.add("sg-0d8bb5479f633c0ac");
        securityGroups.add("sg-a22000e8");

        ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = ClusterIamInstanceProfileSpec.Builder.get();
        ClusterIamInstanceProfileSpec iamInstanceProfileSpec =
                iamInstanceProfileBuilder.setArn("arn:aws:iam::253244684816:instance-profile/AutomationRole").build();

        ClusterLaunchSpecification.Builder launchSpecificatioBuilder = ClusterLaunchSpecification.Builder.get();
        ClusterLaunchSpecification launchSpecification =
                launchSpecificatioBuilder.setSecurityGroupIds(securityGroups).setAssociatePublicIpAddress(true)
                                         .setEbsOptimized(false).setMonitoring(false).setRootVolumeSize(73)
                                         .setIamInstanceProfile(iamInstanceProfileSpec)
                                         .setImageId("ami-0cb72367e98845d43").setTags(tagsList)
                                         .setKeyPair("testingKeyPair").build();

        ClusterInstanceTypes.Builder instanceTypesBuilder = ClusterInstanceTypes.Builder.get();

        List<String> whiteList = new ArrayList<>();
        whiteList.add("c4.xlarge");

        ClusterInstanceTypes instanceTypes = instanceTypesBuilder.setWhitelist(whiteList).build();

        List<String> subnetList = new ArrayList<>();
        subnetList.add("subnet-4333093a");
        subnetList.add("subnet-8ab89cc1");

        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute =
                computeBuilder.setInstanceTypes(instanceTypes).setLaunchSpecification(launchSpecification)
                              .setSubnetIds(subnetList).build();

        //Build scheduling
        List<String> timeWindows = new ArrayList<>();
        timeWindows.add("Mon:12:00-Tue:12:00");
        timeWindows.add("Fri:12:00-Sat:12:00");

        ClusterShutdownHoursSpecification.Builder shutDownSpecBuilder = ClusterShutdownHoursSpecification.Builder.get();
        ClusterShutdownHoursSpecification shutDownHours =
                shutDownSpecBuilder.setEnabled(true).setTimeWindows(timeWindows).build();

        ClusterTasksSpecification.Builder tasksBuilder = ClusterTasksSpecification.Builder.get();
        List<ClusterTasksSpecification>   tasksList    = new ArrayList<>();

        ClusterTasksSpecification task1 =
                tasksBuilder.setIsEnabled(true).setCronExpression("0 1 * * *").setTaskType("clusterRoll").build();

        tasksList.add(task1);

        ClusterSchedulingConfiguration.Builder schedulingBuilder = ClusterSchedulingConfiguration.Builder.get();
        ClusterSchedulingConfiguration scheduling =
                schedulingBuilder.setShutdownHours(shutDownHours).setTasks(tasksList).build();


        // Build cluster
        OceanCluster.Builder oceanBuilder = OceanCluster.Builder.get();
        OceanCluster oceanCluster = oceanBuilder.setName("Java-SDK-Testing").setRegion("us-west-2")
                                                .setControllerClusterId(controllerClusterId).setAutoScaler(autoScaler)
                                                .setStrategy(strategy).setCapacity(capacity).setCompute(compute)
                                                .setScheduling(scheduling).build();
        // Build cluster creation request
        ClusterCreationRequest.Builder clusterCreationRequestBuilder = ClusterCreationRequest.Builder.get();
        ClusterCreationRequest creationRequest = clusterCreationRequestBuilder.setCluster(oceanCluster).build();

        // Convert cluster to API object json
        //System.out.println(creationRequest.toJson());

        // Create cluster
        OceanCluster createdCluster = client.createCluster(creationRequest);
        System.out.println("Cluster successfully created: " + createdCluster.getId());

        return createdCluster.getId();
    }

    private static void updateCluster(SpotinstOceanClusterClient client, String clusterId) {
        System.out.println("-------------------------start updating ocean cluster------------------------");
        //Create cluster update
        ClusterCapacityConfiguration.Builder updateCapacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration updateCapacity =
                updateCapacityBuilder.setMinimum(0).setTarget(1).setMaximum(2).build();

        // Build cluster update
        OceanCluster.Builder updateOceanClusterBuilder = OceanCluster.Builder.get();
        //todo lihi - use the cluster name defined above
        OceanCluster oceanClusterUpdate =
                updateOceanClusterBuilder.setCapacity(updateCapacity).setName("SpotinstTestClusterUpdate").build();

        ClusterUpdateRequest.Builder clusterUpdateRequestBuilder = ClusterUpdateRequest.Builder.get();
        ClusterUpdateRequest updateRequest = clusterUpdateRequestBuilder.setCluster(oceanClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated.");
        }
    }

    private static void deleteCluster(SpotinstOceanClusterClient client, String clusterId) {
        System.out.println("-------------------------start deleting ocean cluster------------------------");
        ClusterDeleteRequest.Builder deletionBuilder = ClusterDeleteRequest.Builder.get();
        ClusterDeleteRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster successfully deleted: " + clusterId);
        }
    }

}
