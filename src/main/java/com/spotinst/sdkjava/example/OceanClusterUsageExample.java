package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.OceanKubernetes.aws.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OceanClusterUsageExample {
    private final static String auth_token = "33016d3ae3388f8c85015813155481aeafaac718cc76d1d527fb605bf83a5015";
    private final static String act_id     = "act-7c46c6df";
    private final static String controllerClusterId = "testSdkCluster_2";


    public static void main(String[] args) throws IOException {
        SpotinstOceanClusterClient clusterClient = SpotinstClient.getOceanClusterClient(auth_token, act_id);

        String clusterId = createCluster(clusterClient);
        System.out.println("clusterId : " + clusterId);

        updateCluster(clusterClient, clusterId);

        deleteCluster(clusterClient, clusterId);
    }

    private static String createCluster(SpotinstOceanClusterClient client) {
        System.out.println("-------------------------start creation!!!!------------------------");
        //Build autoScaler
        ClusterDownSpecification.Builder downSpecBuilder = ClusterDownSpecification.Builder.get();
        ClusterDownSpecification down = downSpecBuilder.setMaxScaleDownPercentage(60).build();

        ClusterHeadroomSpecification.Builder headroomSpecBuilder = ClusterHeadroomSpecification.Builder.get();
        ClusterHeadroomSpecification             headroom        =
                headroomSpecBuilder.setCpuPerUnit(2000)
                                   .setGpuPerUnit(0).setMemoryPerUnit(0).setNumOfUnits(2).build();

        ClusterResourceLimitsSpecification.Builder recourceLimitSpecBuilder = ClusterResourceLimitsSpecification.Builder.get();
        ClusterResourceLimitsSpecification resourceLimits = recourceLimitSpecBuilder.setMaxMemoryGib(5).setMaxVCpu(2000).build();

        ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
        ClusterAutoScalerConfiguration autoScaler =
                clusterAutoScalerBuilder.setIsAutoConfig(false)
                                       .setCooldown(180).setDown(down).setAutoHeadroomPercentage(null).setHeadroom(headroom)
                                        .setIsEnabled(false).setResourceLimits(resourceLimits).build();

        //Build capacity
        ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration capacity = capacityBuilder.setMaximum(0).setMinimum(0).setTarget(0).build();

        //Build strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy =
                strategyBuilder.setFallbackToOnDemand(false)
                               .setUtilizeReservedInstances(true).setDrainingTimeout(60).setGracePeriod(600).build();
        //todo- add spotPercentage?
        //Build compute
        Tag.Builder tagsBuilder = Tag.Builder.get();
        List<Tag>   tagsList    = new ArrayList<>();

        Tag tag1 =
                tagsBuilder.setTagKey("Creator").setTagValue("lihi.shoham@spot.io")
                            .build();

        tagsList.add(tag1);

        List<String>   securityGroups    = new ArrayList<>();
        securityGroups.add("sg-0d8bb5479f633c0ac");
        securityGroups.add("sg-a22000e8");

        ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = ClusterIamInstanceProfileSpec.Builder.get();
        ClusterIamInstanceProfileSpec iamInstanceProfileSpec =
                iamInstanceProfileBuilder.setArn("arn:aws:iam::253244684816:instance-profile/AutomationRole").build();
        //todo- check if need to switch to only automationRole.

        ClusterLaunchSpecification.Builder launchSpecificatioBuilder = ClusterLaunchSpecification.Builder.get();
        ClusterLaunchSpecification launchSpecification =
                launchSpecificatioBuilder.setSecurityGroupIds(securityGroups).setAssociatePublicIpAddress(true)
                .setEbsOptimized(false).setMonitoring(false).setRootVolumeSize(73).setIamInstanceProfile(iamInstanceProfileSpec)
                .setImageId("ami-0cb72367e98845d43").setTags(tagsList)
                                         .setKeyPair("testingKeyPair").build();

        ClusterInstanceTypes.Builder instanceTypesBuilder = ClusterInstanceTypes.Builder.get();

        List<String>   whiteList    = new ArrayList<>();
        whiteList.add("c4.xlarge");

        ClusterInstanceTypes instanceTypes =
                instanceTypesBuilder.setWhitelist(whiteList).build();

        List<String>   subnetList    = new ArrayList<>();
        subnetList.add("subnet-4333093a");
        subnetList.add("subnet-8ab89cc1");

        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute =
                computeBuilder.setInstanceTypes(instanceTypes).setLaunchSpecification(launchSpecification).setSubnetIds(subnetList).build();

        //Build scheduling
        List<String> timeWindows  = new ArrayList<>();
        timeWindows.add("Mon:12:00-Tue:12:00");
        timeWindows.add("Fri:12:00-Sat:12:00");

        ClusterShutdownHoursSpecification.Builder shutDownSpecBuilder =ClusterShutdownHoursSpecification.Builder.get();
        ClusterShutdownHoursSpecification shutDownHours =shutDownSpecBuilder.setEnabled(true).setTimeWindows(timeWindows).build();

        ClusterTasksSpecification.Builder tasksBuilder = ClusterTasksSpecification.Builder.get();
        List<ClusterTasksSpecification>   tasksList    = new ArrayList<>();

        ClusterTasksSpecification task1 =
                tasksBuilder.setIsEnabled(true).setCronExpression("0 1 * * *").setTaskType("clusterRoll")
                            .build();

        tasksList.add(task1);

        ClusterSchedulingConfiguration.Builder schedulingBuilder =ClusterSchedulingConfiguration.Builder.get();
        ClusterSchedulingConfiguration scheduling =schedulingBuilder.setShutdownHours(shutDownHours).setTasks(tasksList).build();


        // Build cluster
        OceanCluster.Builder oceanBuilder = OceanCluster.Builder.get();
        OceanCluster oceanCluster =
                oceanBuilder.setName("Java-SDK-Testing").setRegion("us-west-2").setControllerClusterId(controllerClusterId)
                                  .setAutoScaler(autoScaler).setStrategy(strategy).setCapacity(capacity).setCompute(compute)
                                  .setScheduling(scheduling)
                                  .build();
        // Build cluster creation request
        ClusterCreationRequest.Builder clusterCreationRequestBuilder = ClusterCreationRequest.Builder.get();
        ClusterCreationRequest creationRequest =
                clusterCreationRequestBuilder.setCluster(oceanCluster).build();

        // Convert cluster to API object json
        //System.out.println(creationRequest.toJson());

        // Create cluster
        OceanCluster createdCluster = client.createCluster(creationRequest);
        System.out.println(createdCluster.toString());
        System.out.println("Cluster succesfully created: " + createdCluster.getId());
//o-53fcca5e
        // Get elastigroup Id
        return createdCluster.getId();

    }

    private static void updateCluster(SpotinstOceanClusterClient client, String clusterId) {
        System.out.println("-------------------------start update!!!!------------------------");
        //Create cluster update
        ClusterCapacityConfiguration.Builder updateCapacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration updateCapacity =
                updateCapacityBuilder.setMinimum(0).setTarget(1).setMaximum(2).build();

        // Build cluster update
        OceanCluster.Builder updateOceanClusterBuilder = OceanCluster.Builder.get();
        OceanCluster elastigroupUpdate =
                updateOceanClusterBuilder.setCapacity(updateCapacity).setName("SpotinstTestClusterUpdate").build();

        ClusterUpdateRequest.Builder clusterUpdateRequestBuilder = ClusterUpdateRequest.Builder.get();
        ClusterUpdateRequest updateRequest =
                clusterUpdateRequestBuilder.setCluster(elastigroupUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated.");
        }
    }

    private static void deleteCluster(SpotinstOceanClusterClient client, String clusterId) {
        System.out.println("-------------------------start deletion!!!!------------------------");
        ClusterDeleteRequest.Builder deletionBuilder = ClusterDeleteRequest.Builder.get();
        ClusterDeleteRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster succesfully deleted: " + clusterId);
        }
    }

}
