package com.spotinst.sdkjava.example.ocean.gke;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.SpotOceanGkeClusterClient;
import com.spotinst.sdkjava.model.bl.ocean.gke.*;
import com.spotinst.sdkjava.model.requests.ocean.gke.OceanGkeClusterRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class OceanGkeClusterUsageExample {

    private final static String         auth_token        = "auth_token";
    private final static String         act_id            = "act-id";
    private final static List<String>   availabilityZones = Arrays.asList("us-central1-c");
    private final static String         clusterName       = "clusterName";
    private final static String         masterLocation    = "region";
    private final static List<String>   approvedImage     = Arrays.asList("approvedImage");
    private final static String         subnetName        = "subnetName";
    private final static List<String>   launchSpecTags    = Arrays.asList("tag1","tag2");

    public static void main(String[] args) throws InterruptedException {

        SpotOceanGkeClusterClient clusterClient = SpotinstClient.getOceanGkeClusterClient(auth_token, act_id);

        System.out.println("----------Creation of ocean gke cluster--------------");
        String clusterId = createCluster(clusterClient);

        System.out.println("----------Get ocean gke cluster--------------");
        OceanGkeCluster gkeCluster = getCluster(clusterClient, clusterId);
        // Convert ocean gke cluster response to json
        System.out.println(JsonMapper.toJson(gkeCluster));

        System.out.println("----------Update ocean gke cluster Name--------------");
        updateClusterName(clusterClient, clusterId);

        System.out.println("----------Update ocean gke cluster Capacity--------------");
        updateClusterCapacity(clusterClient, clusterId);

        System.out.println("----------Update ocean gke cluster--------------");
        updateCluster(clusterClient, clusterId);

        System.out.println("----------List of gke clusters--------------");
        List<OceanGkeCluster> allGkeClusters = listOceanGkeClusters(clusterClient);
        for (OceanGkeCluster myGkeCluster : allGkeClusters) {
            System.out.println(String.format("OceanGkeCluster Id: %s, OceanGkeCluster Name: %s", myGkeCluster.getId(),
                                             myGkeCluster.getName()));
        }

        System.out.println("----------Deletion of ocean gke cluster--------------");
        deleteCluster(clusterClient, clusterId);

    }

    private static String createCluster(SpotOceanGkeClusterClient client) {

        // Build gke
        ClusterGkeConfiguration.Builder gkeBuilder = ClusterGkeConfiguration.Builder.get();
        ClusterGkeConfiguration gke = gkeBuilder.setClusterName(clusterName).setMasterLocation(masterLocation).build();

        //Build Capacity
        ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration         capacity        =
                capacityBuilder.setMaximum(2000).setMinimum(0).setTarget(1).build();

        // Build ResourceLimit Specification
        ClusterResourceLimitsSpecification.Builder resourceLimitSpecBuilder =
                ClusterResourceLimitsSpecification.Builder.get();
        ClusterResourceLimitsSpecification resourceLimits = resourceLimitSpecBuilder.setMaxMemoryGib(100000).setMaxVCpu(20000).build();

        //Build Down
        ClusterDownSpecification down = ClusterDownSpecification.Builder.get().setMaxScaleDownPercentage(50).build();

        //Build Headroom
         LaunchSpecHeadroomsSpecification headRoom = LaunchSpecHeadroomsSpecification.Builder.get().setCpuPerUnit(1000)
                                                                            .setGpuPerUnit(0)
                                                                            .setMemoryPerUnit(2048)
                                                                            .setNumOfUnits(3).build();

        //Build autoscale specification
        ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
        ClusterAutoScalerConfiguration autoScaler = clusterAutoScalerBuilder.setAutoHeadroomPercentage(100).setIsEnabled(true)
                                                    .setCooldown(180).setDown(down).setEnableAutomaticAndManualHeadroom(true).setIsAutoConfig(true)
                                                    .setHeadroom(headRoom).setResourceLimits(resourceLimits).build();

        //Build BackendServices
        List<ClusterBackendServicesConfiguration> backendServices = new ArrayList<>();
        ClusterBackendServicesConfiguration  backendService1 =   ClusterBackendServicesConfiguration.Builder.get()
                                                            .setBackendServiceName("scheme1").setLocationType("regional").build();
        backendServices.add(backendService1);

        //Build InstanceTypes
        List<String>   whiteList         = Arrays.asList("n1-standard-1","n1-standard-2");
        ClusterInstanceTypesConfiguration instanceTypes = ClusterInstanceTypesConfiguration.Builder.get().setWhitelist(whiteList).build();

        // Form a metadata request builder
        LaunchSpecMetadataSpecification.Builder metadataBuilder1 = LaunchSpecMetadataSpecification.Builder.get();
        LaunchSpecMetadataSpecification metadata1 =  metadataBuilder1.setKey("cluster-name").setValue("automation-cluster-do-not-delete").build();

        LaunchSpecMetadataSpecification.Builder metadataBuilder2 = LaunchSpecMetadataSpecification.Builder.get();
        LaunchSpecMetadataSpecification metadata2 =  metadataBuilder2.setKey("cluster-location").setValue("us-central1-c").build();

        List<LaunchSpecMetadataSpecification> metadata         = new ArrayList<>();
        metadata.add(metadata1);
        metadata.add(metadata2);

        // Form a labels request builder
        List<LaunchSpecLabelsSpecification> labels         = new ArrayList<>();
        LaunchSpecLabelsSpecification       labelBuilder = LaunchSpecLabelsSpecification.Builder.get().setKey("spotinst-gke-original-node-pool").setValue("default-pool").build();
        labels.add(labelBuilder);

        //Build shielded Instance
        LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig = LaunchSpecShieldedInstanceConfigSpecification.Builder.get()
                                                                                .setEnableSecureBoot(false).setEnableIntegrityMonitoring(true).build();

        // Build Ocean GKE launch spec
        LaunchSpecSpecification.Builder oceanGKECreateLaunchSpecResBuilder = LaunchSpecSpecification.Builder.get();
        LaunchSpecSpecification launchSpecification = oceanGKECreateLaunchSpecResBuilder.setServiceAccount("265168459660-compute@developer.gserviceaccount.com")
                                                                                .setRootVolumeType("pd-standard")
                                                                                .setRootVolumeSizeInGb(100)
                                                                                .setSourceImage("https://www.googleapis.com/compute/v1/projects/gke-node-images/global/images/gke-1208-gke2100-cos-89-16108-470-1-v210716-pre")
                                                                                .setMetadata(metadata)
                                                                                .setTags(launchSpecTags)
                                                                                .setLabels(labels)
                                                                                .setShieldedInstanceConfig(shieldedInstanceConfig).build();
        //Build Network AccessConfigs
        ClusterAccessConfigsSpecification accessConfig1 = ClusterAccessConfigsSpecification.Builder.get().setName("external-nat").setType("ONE_TO_ONE_NAT").build();
        ArrayList<ClusterAccessConfigsSpecification> accessConfigs = new ArrayList<>();
        accessConfigs.add(accessConfig1);

        //Build Network AliasIpRanges
        ClusterAliasIpRangesSpecification alisIpRanges1 = ClusterAliasIpRangesSpecification.Builder.get().setIpCidrRange("/24")
                                                                                                  .setSubnetworkRangeName("gke-automation-cluster-do-not-delete-pods-97229e3d").build();
        ArrayList<ClusterAliasIpRangesSpecification> alisIpRanges = new ArrayList<>();
        alisIpRanges.add(alisIpRanges1);

        //Build Network Interfaces
        ClusterNetworkInterfacesConfiguration.Builder networkInterfacesBuilder =  ClusterNetworkInterfacesConfiguration.Builder.get();
        ClusterNetworkInterfacesConfiguration networkInterfaces1 = networkInterfacesBuilder.setAccessConfigs(accessConfigs)
                                                                                          .setAliasIpRanges(alisIpRanges)
                                                                                          .setNetwork("autoamtion-vpc-do-not-delete")
                                                                                          .setProjectId("spotinst-labs").build();

        List<ClusterNetworkInterfacesConfiguration>  networkInterfaces = new ArrayList<>();
        networkInterfaces.add(networkInterfaces1);

        //Build compute
        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute = computeBuilder.setAvailabilityZones(availabilityZones)
                                                            //.setBackendServices(backendServices)
                                                            .setInstanceTypes(instanceTypes)
                                                            .setLaunchSpecification(launchSpecification)
                                                            .setNetworkInterfaces(networkInterfaces)
                                                            .setSubnetName(subnetName).build();


        //Build ContainerImage
        ClusterContainerImageSpecification.Builder containerImageBuilder = ClusterContainerImageSpecification.Builder.get();
        ClusterContainerImageSpecification containerImage = containerImageBuilder.setApprovedImages(approvedImage).build();

        //Build Shutdown Hours and TimeWindows
        List<String> timeWindows = Arrays.asList("Mon:12:00-Tue:12:00", "Fri:12:00-Sat:12:00");
        ClusterShutdownHoursSpecification shutdownHours = ClusterShutdownHoursSpecification.Builder.get().setIsEnabled(true).setTimeWindows(timeWindows).build();

        //Build Scheduling Tasks
        ClusterTasksConfiguration.Builder tasksBuilder = ClusterTasksConfiguration.Builder.get();

        ClusterTasksConfiguration task = tasksBuilder.setIsEnabled(true).setCronExpression("0 1 * * *").setTaskType("clusterRoll").setBatchSizePercentage(50).build();
        List<ClusterTasksConfiguration> tasksList = Collections.singletonList(task);

        //Build Scheduling
        ClusterSchedulingConfiguration.Builder schedulingBuilder = ClusterSchedulingConfiguration.Builder.get();
        ClusterSchedulingConfiguration scheduling = schedulingBuilder.setShutdownHours(shutdownHours).setTasks(tasksList).build();

        // Build security
        ClusterSecurityConfiguration.Builder securityBuilder = ClusterSecurityConfiguration.Builder.get();
        ClusterSecurityConfiguration security = securityBuilder.setContainerImage(containerImage).build();

        //Build Strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy = strategyBuilder.setDrainingTimeout(120).build();

        // Build Ocean Gke Cluster
        OceanGkeCluster.Builder ocenGkeBuilder = OceanGkeCluster.Builder.get();
        OceanGkeCluster ocenGkeCluster = ocenGkeBuilder.setName("Automation-java-SDK-OceanGkeCluster")
                                                       .setControllerClusterId("Automation-java-SDK-OceanGkeCluster")
                                                       .setGke(gke)
                                                       .setCapacity(capacity)
                                                       .setAutoScaler(autoScaler)
                                                       .setCompute(compute)
                                                       .setScheduling(scheduling)
                                                       .setSecurity(security)
                                                       .setStrategy(strategy)
                                                       .build();

        // Build cluster creation request
        OceanGkeClusterRequest.Builder clusterCreationRequestBuilder = OceanGkeClusterRequest.Builder.get();
        OceanGkeClusterRequest         creationRequest               =
                clusterCreationRequestBuilder.setCluster(ocenGkeCluster).build();

        // Convert cluster to API object json
        System.out.println(creationRequest.toJson());

        // Create cluster
        OceanGkeCluster createdCluster = client.createOceanGkeCluster(creationRequest);
        System.out.println("Cluster successfully created: " + createdCluster.getId());

        return createdCluster.getId();

    }

    private static OceanGkeCluster getCluster(SpotOceanGkeClusterClient client, String clusterId){

        System.out.println("-------------------------start getting ocean cluster------------------------");
        OceanGkeClusterRequest.Builder getBuilder = OceanGkeClusterRequest.Builder.get();
        OceanGkeClusterRequest getRequest = getBuilder.setClusterId(clusterId).build();

        OceanGkeCluster oceanGkeCluster = client.getOceanGkeCluster(getRequest);

        if (oceanGkeCluster!=null) {
            System.out.println("Get Cluster Successful: " + oceanGkeCluster.getId());
        }
        return oceanGkeCluster;
    }

    private static void updateClusterName(SpotOceanGkeClusterClient client, String clusterId) {

        // Build cluster update
        OceanGkeCluster.Builder updateOceanClusterBuilder = OceanGkeCluster.Builder.get();
        OceanGkeCluster oceanGkeClusterUpdate = updateOceanClusterBuilder.setName("Automation-java-SDK-OceanGkeCluster-Renamed").build();

        OceanGkeClusterRequest.Builder clusterUpdateRequestBuilder = OceanGkeClusterRequest.Builder.get();
        OceanGkeClusterRequest updateRequest = clusterUpdateRequestBuilder.setCluster(oceanGkeClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster Name
        Boolean updateSuccess = client.updateGkeCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster Name updated successfully.");
        }
    }

    private static void updateClusterCapacity(SpotOceanGkeClusterClient client, String clusterId) {
        // Build cluster update
        OceanGkeCluster.Builder updateOceanClusterBuilder = OceanGkeCluster.Builder.get();

        // Build Capacity
        ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration capacity = capacityBuilder.setMaximum(1000).setMinimum(0).setTarget(2).build();

        OceanGkeCluster oceanGkeClusterUpdate =
                updateOceanClusterBuilder.setCapacity(capacity).build();

        OceanGkeClusterRequest.Builder clusterUpdateRequestBuilder = OceanGkeClusterRequest.Builder.get();
        OceanGkeClusterRequest updateRequest = clusterUpdateRequestBuilder.setCluster(oceanGkeClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateGkeCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster Capacity successfully updated."+ clusterId);
        }
    }

    private static List<OceanGkeCluster> listOceanGkeClusters(SpotOceanGkeClusterClient client) {
        return client.getAllOceanGkeClusters();
    }

    private static void updateCluster(SpotOceanGkeClusterClient client, String clusterId) {

        //Build Capacity
        ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration         capacity        =
                capacityBuilder.setMaximum(2000).setMinimum(0).setTarget(1).build();

        // Build ResourceLimit Specification
        ClusterResourceLimitsSpecification.Builder resourceLimitSpecBuilder =
                ClusterResourceLimitsSpecification.Builder.get();
        ClusterResourceLimitsSpecification resourceLimits = resourceLimitSpecBuilder.setMaxMemoryGib(10000).setMaxVCpu(2000).build();

        //Build Down
        ClusterDownSpecification down = ClusterDownSpecification.Builder.get().setMaxScaleDownPercentage(100).build();

        //Build Headroom
        LaunchSpecHeadroomsSpecification headRoom = LaunchSpecHeadroomsSpecification.Builder.get().setCpuPerUnit(2000)
                                                                                            .setGpuPerUnit(50)
                                                                                            .setMemoryPerUnit(1024)
                                                                                            .setNumOfUnits(5).build();

        //Build autoscale specification
        ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
        ClusterAutoScalerConfiguration autoScaler = clusterAutoScalerBuilder.setAutoHeadroomPercentage(50)
                                                                            .setCooldown(240).setDown(down)
                                                                            .setHeadroom(headRoom).setResourceLimits(resourceLimits).build();

        // Build Ocean GKE launch spec
        LaunchSpecSpecification.Builder oceanGKECreateLaunchSpecResBuilder = LaunchSpecSpecification.Builder.get();
        LaunchSpecSpecification launchSpecification = oceanGKECreateLaunchSpecResBuilder.setServiceAccount("265168459660-compute@developer.gserviceaccount.com")
                                                                                        .setRootVolumeType("pd-standard")
                                                                                        .setRootVolumeSizeInGb(50)
                                                                                        .build();

        //Build compute
        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute = computeBuilder.setLaunchSpecification(launchSpecification).build();

        //Build Shutdown Hours a
        ClusterShutdownHoursSpecification shutdownHours = ClusterShutdownHoursSpecification.Builder.get().setIsEnabled(false).build();

        //Build Scheduling
        ClusterSchedulingConfiguration.Builder schedulingBuilder = ClusterSchedulingConfiguration.Builder.get();
        ClusterSchedulingConfiguration scheduling = schedulingBuilder.setShutdownHours(shutdownHours).build();

        //Build Strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy = strategyBuilder.setDrainingTimeout(300).build();

        // Build Ocean Gke Cluster
        OceanGkeCluster.Builder updateOceanClusterBuilder = OceanGkeCluster.Builder.get();
        OceanGkeCluster oceanGkeClusterUpdate = updateOceanClusterBuilder.setName("Automation-java-SDK-OceanGkeCluster")
                                                       .setCapacity(capacity)
                                                       .setAutoScaler(autoScaler)
                                                       .setCompute(compute)
                                                       .setScheduling(scheduling)
                                                       .setStrategy(strategy)
                                                       .build();

        OceanGkeClusterRequest.Builder clusterUpdateRequestBuilder = OceanGkeClusterRequest.Builder.get();
        OceanGkeClusterRequest updateRequest = clusterUpdateRequestBuilder.setCluster(oceanGkeClusterUpdate).build();

        // Convert cluster update to API object json
        System.out.println(updateRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateGkeCluster(updateRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated.");
        }
    }

    private static void deleteCluster(SpotOceanGkeClusterClient client, String clusterId) {

        OceanGkeClusterRequest.Builder deletionBuilder = OceanGkeClusterRequest.Builder.get();
        OceanGkeClusterRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteGkeCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster successfully deleted: " + clusterId);
        }
    }

}