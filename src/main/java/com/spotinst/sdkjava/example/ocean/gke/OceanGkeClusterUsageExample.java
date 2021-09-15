package com.spotinst.sdkjava.example.ocean.gke;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.SpotOceanGkeClusterClient;
import com.spotinst.sdkjava.model.bl.ocean.gke.*;
import com.spotinst.sdkjava.model.requests.ocean.gke.OceanGkeClusterRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OceanGkeClusterUsageExample {

    private final static String         auth_token        = "3526b1fbfb2d375d095c3d4c2b552c2db86f1b4020a99f425d96b70604293f65";
    private final static String         act_id            = "act-7d8b3fee";
    private final static List<String>   availabilityZones = Arrays.asList("us-central1-c");
    private final static String         clusterName       = "automation-cluster-do-not-delete";
    private final static String         masterLocation    = "us-central1-c";
    private final static List<String>   approvedImage     = Arrays.asList("");
    private final static String         subnetName        = "autoamtion-subnet-do-not-delete";
    private final static List<String>   launchSpecTags    = Arrays.asList("gke-automation-cluster-do-not-delete-97229e3d-node");

    public static void main(String[] args) throws InterruptedException {

        SpotOceanGkeClusterClient clusterClient = SpotinstClient.getOceanGkeClusterClient(auth_token, act_id);

        System.out.println("----------Creation of ocean gke cluster--------------");
        String clusterId = createCluster(clusterClient);

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
                capacityBuilder.setMaximum(1000).setMinimum(0).setTarget(1).build();

        // Build ResourceLimit Specification
        ClusterResourceLimitsSpecification.Builder resourceLimitSpecBuilder =
                ClusterResourceLimitsSpecification.Builder.get();
        ClusterResourceLimitsSpecification resourceLimits = resourceLimitSpecBuilder.setMaxMemoryGib(100000).setMaxVCpu(20000).build();

        //Build autoscale specification
        ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
        ClusterAutoScalerConfiguration autoScaler =
                clusterAutoScalerBuilder.setResourceLimits(resourceLimits).build();

        //Build InstanceTypes
        ClusterInstanceTypesConfiguration instanceTypes = ClusterInstanceTypesConfiguration.Builder.get().build();

        //Build Backend Service


        // Form a metadata request builder
        LaunchSpecMetadataSpecification.Builder metadataBuilder1 = LaunchSpecMetadataSpecification.Builder.get();
        LaunchSpecMetadataSpecification metadata1 =  metadataBuilder1.setKey("cluster-name").setValue("automation-cluster-do-not-delete").build();

        LaunchSpecMetadataSpecification.Builder metadataBuilder2 = LaunchSpecMetadataSpecification.Builder.get();
        LaunchSpecMetadataSpecification metadata2 =  metadataBuilder2.setKey("cluster-location").setValue("us-central1-c").build();

        List<LaunchSpecMetadataSpecification> metadata         = new ArrayList<>();
        metadata.add(metadata1);
        metadata.add(metadata2);

        //Build LaunchSpec ResourceLimit
        LaunchSpecResourceLimitsSpecification
                launchSpecResourceLimits = LaunchSpecResourceLimitsSpecification.Builder.get().setMaxInstanceCount(5).build();

        // Form a labels request builder
        List<LaunchSpecLabelsSpecification> labels         = new ArrayList<>();
        LaunchSpecLabelsSpecification       labelBuilder = LaunchSpecLabelsSpecification.Builder.get().setKey("spotinst-gke-original-node-pool").setValue("default-pool").build();
        labels.add(labelBuilder);

        //Build shielded Instance
        LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig = LaunchSpecShieldedInstanceConfigSpecification.Builder.get().setEnableSecureBoot(false).setEnableIntegrityMonitoring(true).build();

        // Build Ocean GKE launch spec
        LaunchSpecSpecification.Builder oceanGKECreateLaunchSpecResBuilder = LaunchSpecSpecification.Builder.get();
        LaunchSpecSpecification launchSpecification = oceanGKECreateLaunchSpecResBuilder.setServiceAccount("265168459660-compute@developer.gserviceaccount.com")
                                                                                .setRootVolumeType("pd-standard")
                                                                                .setRootVolumeSizeInGb(100)
                                                                                .setSourceImage("https://www.googleapis.com/compute/v1/projects/gke-node-images/global/images/gke-1208-gke2100-cos-89-16108-470-1-v210716-pre")
                                                                                .setMetadata(metadata)//.setInstanceTypes(instanceTypes)
                                                                                .setTags(launchSpecTags)
                                                                                .setLabels(labels)
                                                                                //.setResourceLimits(launchSpecResourceLimits)
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
                                                            .setLaunchSpecification(launchSpecification).setNetworkInterfaces(networkInterfaces).setSubnetName(subnetName).build();


        //Build ContainerImage
        ClusterContainerImageSpecification.Builder containerImageBuilder = ClusterContainerImageSpecification.Builder.get();
        ClusterContainerImageSpecification containerImage = containerImageBuilder.setApprovedImages(approvedImage).build();

        //Build Scheduling
        ClusterSchedulingConfiguration scheduling = ClusterSchedulingConfiguration.Builder.get().build();

        // Build security
        ClusterSecurityConfiguration.Builder securityBuilder = ClusterSecurityConfiguration.Builder.get();
        ClusterSecurityConfiguration security = securityBuilder.setContainerImage(containerImage).build();

        //Build Strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration         strategy        =
                strategyBuilder.setDrainingTimeout(120).build();

        // Build Ocean Gke Cluster
        OceanGkeCluster.Builder ocenGkeBuilder = OceanGkeCluster.Builder.get();
        OceanGkeCluster ocenGkeCluster = ocenGkeBuilder.setName("Automation-java-SDK-OceanGkeCluster")
                                                       .setControllerClusterId("Automation-java-SDK-OceanGkeCluster")
                                                       .setGke(gke)
                                                       .setCapacity(capacity)
                                                       .setAutoScaler(autoScaler)
                                                       .setCompute(compute)
                                                       .setScheduling(scheduling)
                                                       // .setSecurity(security)
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
    private static void deleteCluster(SpotOceanGkeClusterClient client, String clusterId) {

        OceanGkeClusterRequest.Builder deletionBuilder = OceanGkeClusterRequest.Builder.get();
        OceanGkeClusterRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteGkeCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster successfully deleted: " + clusterId);
        }
    }

}