package com.spotinst.sdkjava.example.ocean.aks;


import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.k8sClusterRollStatusEnum;
import com.spotinst.sdkjava.model.SpotOceanAzureAksClusterClient;
import com.spotinst.sdkjava.model.bl.ocean.aks.*;
import com.spotinst.sdkjava.model.requests.ocean.aks.AksUpdateRollRequest;
import com.spotinst.sdkjava.model.requests.ocean.aks.GetAksClusterNodesRequest;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class OceanAzureAksClusterUsageExample {

    private final static String auth_token = "your-token";
    private final static String act_id     = "act-id";

    public static void main(String[] args) throws InterruptedException {
        SpotOceanAzureAksClusterClient clusterClient = SpotinstClient.getOceanAzureAksClusterClient(auth_token, act_id);

        String clusterId = createCluster(clusterClient);
        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 7 seconds.");
        sleep(7);
        getCluster(clusterClient, clusterId);
        updateCluster(clusterClient, clusterId);
        listClusters(clusterClient);
        deleteCluster(clusterClient, clusterId);

        //Get cluster heartbeat status
        System.out.println("----------Get cluster heartbeat status-------------");
        GetAzureAksClusterHeartBeatStatusResponse getClusterHeartBeatStatus = getK8sClusterHeartBeatStatus(clusterClient,"cluster-id");

        //Detach instances
        System.out.println("----------Detach Instances--------------");
        List<AksDetachInstancesResponse> detachStatus = detachClusterInstances(clusterClient, "cluster-id", Collections.singletonList("instances"), true, true);

        //Get cluster nodes
        System.out.println("----------Get cluster Nodes--------------");
        List<GetAksClusterNodesResponse> nodes = getClusterNodes(clusterClient, "cluster-id");

        //Initiate Roll
        System.out.println("----------Initiate Roll--------------");
        AksClusterRollResponse initiateRollResponse = initiateClusterRoll(clusterClient, "cluster-id", 25, "comment", true, 100);

        //Get cluster Roll
        System.out.println("----------Get cluster Roll--------------");
        AksClusterRollResponse getClusterRollStatus = getClusterRollStatus (clusterClient, "cluster-id", "rollId");

        //List cluster Rolls
        System.out.println("----------List cluster Rolls--------------");
        List<AksClusterRollResponse> listClusterRolls = getAllClusterRolls(clusterClient, "cluster-id");

        //Update cluster Roll
        System.out.println("----------Update cluster Roll--------------");
        AksClusterRollResponse updateRollResponse = updateClusterRoll(clusterClient, "cluster-id", "roll-id", "STOPPED");
    }

    private static String createCluster(SpotOceanAzureAksClusterClient client) {
        System.out.println("-------------------------start creating ocean cluster------------------------");

        //Build osDisk
        ClusterOsDiskAks.Builder osDiskAksBuilder = ClusterOsDiskAks.Builder.get();
        ClusterOsDiskAks osDiskAks = osDiskAksBuilder.setSizeGB(30).build();

        //Build extensions
        ClusterExtensionAks.Builder extensionBuilder = ClusterExtensionAks.Builder.get();
        List<ClusterExtensionAks> extensions = Arrays.asList(extensionBuilder.setName("OceanAKS").setApiVersion("2.0").setType("customScript")
                .setPublisher("Microsoft.Azure.Extensions").setMinorVersionAutoUpgrade(true).build());


        //Build tag
        ClusterTagAks.Builder tagAksBuilder = ClusterTagAks.Builder.get();
        List<ClusterTagAks> tags = Arrays.asList(tagAksBuilder.setTagKey("creator").setTagValue("AutomationApi").build());

        //Build Load Balancers
        ClusterLoadBalancerAks.Builder loadBalancerAksBuilder = ClusterLoadBalancerAks.Builder.get();
        List<ClusterLoadBalancerAks> loadBalancers = Arrays.asList(loadBalancerAksBuilder.setLoadBalancerSku("Standard").setType("loadBalancer")
                                                        .setResourceGroupName("MC_AutomationApiRG_AutomationApi_eastus").setName("kubernetes")
                                                        .setBackendPoolNames(Arrays.asList("aksOutboundBackendPool", "kubernetes")).build());
        //Build Load Balancers Config
        ClusterLoadBalancersConfigAks.Builder loadBalancersConfigBuilder = ClusterLoadBalancersConfigAks.Builder.get();
        ClusterLoadBalancersConfigAks loadBalancersConfigAks = loadBalancersConfigBuilder.setLoadBalancers(loadBalancers).build();

        //Build login
        ClusterLoginAks.Builder loginAksBuilder = ClusterLoginAks.Builder.get();
        ClusterLoginAks loginAks = loginAksBuilder.setUserName("azureuser").setSshPublicKey("ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQC6v8BnN6OcFZjDLQ85uSg3qM/p2WVddk8J2S921uO8ydT1M3lwy+vSNWT6O7/wUl2U0c+ZcFJSEZQCLJ7cs85Q9ER6b9oscABLFtnYdTR9OBNJ9B9oTkao+EgEEa3i8uX2iMzqVZndQJoJ1/N3ds1KhozKC2t76jD+rPRjHQJ4ReJHNHO+aalivssPwfofELg82dJ1urWksjXSdzO39OHBqfCIztS1wPeiWWYSuJWJuPL000bfH8ngU5Vzh0plPK9fdRmBIEx8GhY4hBfOSlRO5ITaIqQTXoZaMHCX2AwhIj+ZHiiWPY+5/9x9H6tdLXRJ9huCF5dNaTj2D8Jt1So1B6QuN8Iqchu7FzlpuSB+uOaChvJ5NfGEJvCO7SqosiSKhxOv0GAFY99Vj53JoUO3+7mFortO+kDmMKwrJmw0adTURHM+tetNd6txs+86FmU576b3MhvTBbssCH1A54gThdbtseOEqrRJMNQoicb0f2/IzkdjT6RWu4IG+vFMbHLOts1dDqP3paWY/vhHfTvNVcXU5gYzu4RZZOtespRt3/kSBgiZvmhiifVqShf6cgn6+9BGznT4FMtpQZQ9tqP/hUII/9uQn7CEU6X7Pualc7FiWjGbEVArTVHHTxIfUPTqnp9f7X1oG4+AYvSTQsJXJalrSBx6iok4+9Xk5pxrVQ==").build();


        //Build security groups
        ClusterSecurityGroupAks.Builder clusterSecurityGroupAksBuilder = ClusterSecurityGroupAks.Builder.get();
        ClusterSecurityGroupAks securityGroups = clusterSecurityGroupAksBuilder.setName("aks-agentpool-15320214-nsg").setResourceGroupName("MC_AutomationApiRG_AutomationApi_eastus").build();


        //Build Network interface
        ClusterNetworkInterfaceAks.Builder networkInterfaceAksBuilder = ClusterNetworkInterfaceAks.Builder.get();
        List<ClusterNetworkInterfaceAks> networkInterfaces = Arrays.asList(networkInterfaceAksBuilder.setSecurityGroup(securityGroups).setAssignPublicIp(false).setIsPrimary(true)
                                                            .setEnableIPForwarding(true).setSubnetName("aks-subnet").build());
        //Build Network
        ClusterNetworkAks.Builder networkAksBuilder = ClusterNetworkAks.Builder.get();
        ClusterNetworkAks networkAks = networkAksBuilder.setNetworkInterfaces(networkInterfaces).setVirtualNetworkName("aks-vnet-15320214")
                .setResourceGroupName("MC_AutomationApiRG_AutomationApi_eastus").build();

        //Build marketplace
        ClusterMarketplaceAks.Builder marketplaceAksBuilder = ClusterMarketplaceAks.Builder.get();
        ClusterMarketplaceAks clusterMarketplace = marketplaceAksBuilder.setOffer("UbuntuServer").setPublisher("Canonical").setSku("18.04-LTS")
                .setVersion("latest").build();

        //Build image
        ClusterImageAks.Builder imageAksBuilder = ClusterImageAks.Builder.get();
        ClusterImageAks imageAks = imageAksBuilder.setMarketplace(clusterMarketplace).build();

        ClusterMsiAks.Builder msiAksBuilder = ClusterMsiAks.Builder.get();
        ClusterMsiAks msiAks = msiAksBuilder.setName("AutomationApi-agentpool").setResourceGroupName("MC_AutomationApiRG_AutomationApi_eastus").build();
        List<ClusterMsiAks> listMsi = Arrays.asList(msiAks);

        //Build launchSpecification
        ClusterLaunchSpecificationAks.Builder launchSpecificationAksBuilder = ClusterLaunchSpecificationAks.Builder.get();
        ClusterLaunchSpecificationAks launchSpecificationAks = launchSpecificationAksBuilder.setExtensions(extensions).setImage(imageAks)
                                                                .setLogin(loginAks).setLoadBalancersConfig(loadBalancersConfigAks).setOsDisk(osDiskAks).setTags(tags)
                                                                .setNetwork(networkAks).setManagedServiceIdentities(listMsi).setResourceGroupName("MC_AutomationApiRG_AutomationApi_eastus").build();

        //Build Cluster
        ClusterVirtualNodeGroupTemplateAks.Builder virtualNodeGroupTemplateAksBuilder = ClusterVirtualNodeGroupTemplateAks.Builder.get();
        ClusterVirtualNodeGroupTemplateAks virtualNodeGroupTemplateAks = virtualNodeGroupTemplateAksBuilder.setLaunchSpecification(launchSpecificationAks).build();

        ClusterConfigurationAks.Builder aksBuilder = ClusterConfigurationAks.Builder.get();
        ClusterConfigurationAks aks = aksBuilder.setName("AutomationApi").setResourceGroupName("AutomationApiRG").build();

        OceanClusterAks.Builder clusterAksBuilder = OceanClusterAks.Builder.get();
        OceanClusterAks clusterAks = clusterAksBuilder.setAks(aks).setVirtualNodeGroupTemplate(virtualNodeGroupTemplateAks)
                                .setControllerClusterId("automation-api").setName("AutomationApi").build();

        AksClusterCreationRequest.Builder clusterCreationRequestBuilder = AksClusterCreationRequest.Builder.get();
        AksClusterCreationRequest clusterCreationRequest = clusterCreationRequestBuilder.setCluster(clusterAks).build();

        System.out.println(clusterCreationRequest.toJson());

        OceanClusterAks createdCluster = client.createAksCluster(clusterCreationRequest);
        System.out.println("Cluster successfully created: " + createdCluster.getId());

        return createdCluster.getId();

    }

    private static void updateCluster(SpotOceanAzureAksClusterClient client, String clusterId) {
        System.out.println("-------------------------start updating ocean cluster------------------------");

        //Build osDisk
        ClusterOsDiskAks.Builder osDiskAksBuilder = ClusterOsDiskAks.Builder.get();
        ClusterOsDiskAks osDiskAks = osDiskAksBuilder.setSizeGB(40).build();


        //Build launchSpecification
        ClusterLaunchSpecificationAks.Builder launchSpecificationAksBuilder = ClusterLaunchSpecificationAks.Builder.get();
        ClusterLaunchSpecificationAks launchSpecificationAks = launchSpecificationAksBuilder
                .setOsDisk(osDiskAks)
                .build();

        //Build Cluster
        ClusterVirtualNodeGroupTemplateAks.Builder virtualNodeGroupTemplateAksBuilder = ClusterVirtualNodeGroupTemplateAks.Builder.get();
        ClusterVirtualNodeGroupTemplateAks virtualNodeGroupTemplateAks = virtualNodeGroupTemplateAksBuilder.setLaunchSpecification(launchSpecificationAks).build();


        OceanClusterAks.Builder clusterAksBuilder = OceanClusterAks.Builder.get();
        OceanClusterAks clusterAks = clusterAksBuilder.setName("AutomationApi-updated").setVirtualNodeGroupTemplate(virtualNodeGroupTemplateAks).build();

        AksClusterUpdateRequest.Builder clusterUpdateRequestBuilder = AksClusterUpdateRequest.Builder.get();
        AksClusterUpdateRequest updatedClusterRequest = clusterUpdateRequestBuilder.setCluster(clusterAks).build();


        // Convert cluster update to API object json
        System.out.println(updatedClusterRequest.toJson());

        // Update cluster
        Boolean updateSuccess = client.updateAksCluster(updatedClusterRequest, clusterId);
        if (updateSuccess) {
            System.out.println("Cluster successfully updated.\n");
        }

    }

    private static void deleteCluster(SpotOceanAzureAksClusterClient client, String clusterId) {
        System.out.println("-------------------------start deleting ocean cluster------------------------");
        AksClusterDeleteRequest.Builder deletionBuilder = AksClusterDeleteRequest.Builder.get();
        AksClusterDeleteRequest         deletionRequest = deletionBuilder.setClusterId(clusterId).build();

        Boolean successfulDeletion = client.deleteAksCluster(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Cluster successfully deleted: " + clusterId);
        }
    }

    private static OceanClusterAks getCluster(SpotOceanAzureAksClusterClient client, String clusterId) {
        System.out.println("-------------------------start getting ocean cluster------------------------");
        AksClusterGetRequest.Builder getBuilder = AksClusterGetRequest.Builder.get();
        AksClusterGetRequest         getRequest = getBuilder.setClusterId(clusterId).build();

        OceanClusterAks aksCluster = client.getOceanAksCluster(getRequest);
        if (aksCluster!=null) {
            System.out.println("Get Cluster successfully: " + aksCluster.getControllerClusterId());
        }
        return aksCluster;
    }

    private static List<OceanClusterAks> listClusters(SpotOceanAzureAksClusterClient client) {
        System.out.println("-------------------------start listing ocean clusters------------------------");
        return client.ListOceanAksCluster();
    }

    private static GetAzureAksClusterHeartBeatStatusResponse getK8sClusterHeartBeatStatus(SpotOceanAzureAksClusterClient client, String clusterId) {

        System.out.println(String.format("Getting the Heartbeat status for the Kubernetes Cluster: %s", clusterId));
        GetAzureAksClusterHeartBeatStatusResponse clusterHeartBeatStatus = client.getAzureAksClusterHeartBeatStatus(clusterId);

        System.out.println(String.format("Status: %s", clusterHeartBeatStatus.getStatus()));
        System.out.println(String.format("LastHeartBeat: %s", clusterHeartBeatStatus.getLastHeartbeat()));

        return clusterHeartBeatStatus;
    }

    private static List<AksDetachInstancesResponse> detachClusterInstances(SpotOceanAzureAksClusterClient client, String clusterId, List instances, Boolean shouldDecrementTargetCapacity, Boolean shouldTerminateInstances) {

        AksDetachInstances.Builder detachInstancesBuilder = AksDetachInstances.Builder.get();
        AksDetachInstances detachInstances                = detachInstancesBuilder.setVmsToDetach(instances).build();

        System.out.println(String.format("Detach the instances for cluster: %s", clusterId));

        return client.detachVms(detachInstances, clusterId);
    }

    private static List<GetAksClusterNodesResponse> getClusterNodes(SpotOceanAzureAksClusterClient client, String clusterId) {
        System.out.println("-------------------------Get cluster Nodes------------------------");

        GetAksClusterNodesRequest.Builder getNodesBuilder = GetAksClusterNodesRequest.Builder.get();
        GetAksClusterNodesRequest getNodesRequest = getNodesBuilder.setAccountId(act_id).build();

        // Fetch the nodes
        List<GetAksClusterNodesResponse>  nodes = client.getClusterNodes(getNodesRequest, clusterId);

        for (GetAksClusterNodesResponse node : nodes){
            System.out.println(String.format("VM Name: %s", node.getVmName()));
            System.out.println(String.format("VM Size: %s", node.getVmSize()));
            System.out.println(String.format("Node name: %s", node.getNodeName()));
            System.out.println(String.format("VNG ID: %s", node.getVirtualNodeGroupId()));
            System.out.println(String.format("VNG name: %s", node.getVirtualNodeGroupName()));
            System.out.println(String.format("Public IP: %s", node.getPublicIp()));

        }

        return nodes;
    }

    private static AksClusterRollResponse initiateClusterRoll(SpotOceanAzureAksClusterClient client, String clusterId, Integer batchSizePercentage, String comment, Boolean respectPdb, Integer batchMinHealthyPercentage) {

        AksInitiateRoll.Builder initiateRollBuilder = AksInitiateRoll.Builder.get();
        AksInitiateRoll initiateRoll = initiateRollBuilder.setBatchSizePercentage(batchSizePercentage).setComment(comment).build();

        System.out.println(String.format("Initiate cluster Roll: %s", clusterId));
        AksClusterRollResponse rollResponse = client.initiateRoll(initiateRoll, clusterId);

        String rollId = rollResponse.getId();

        return rollResponse;
    }

    private static AksClusterRollResponse getClusterRollStatus (SpotOceanAzureAksClusterClient client, String clusterId, String rollId) {

        System.out.println(String.format("Get cluster Roll. ClusterId: %s, RollId: %s", clusterId, rollId));
        AksClusterRollResponse getRollResponse = client.getRoll(clusterId, rollId);

        k8sClusterRollStatusEnum rollStatus = getRollResponse.getStatus();

        return getRollResponse;
    }

    private static List<AksClusterRollResponse> getAllClusterRolls(SpotOceanAzureAksClusterClient client, String clusterId) {

        System.out.println(String.format("Get all cluster Rolls. ClusterId: %s", clusterId));
        List<AksClusterRollResponse> getAllRolls = client.listRolls(clusterId);

        for (AksClusterRollResponse roll : getAllRolls){
            System.out.println(String.format("RollId: %s", roll.getId()));
            System.out.println(String.format("RollId: %s", roll.getStatus()));
        }
        return getAllRolls;
    }

    private static AksClusterRollResponse updateClusterRoll(SpotOceanAzureAksClusterClient client, String clusterId, String rollId, String status) {

        AksUpdateRollRequest.Builder updateRollBuilder = AksUpdateRollRequest.Builder.get();
        AksUpdateRollRequest updateRoll = updateRollBuilder.setStatus(status).build();

        System.out.println(String.format("Update Cluster Roll. ClusterId: %s, RollId: %s", clusterId, rollId));
        AksClusterRollResponse response = client.updateRoll(updateRoll, clusterId, rollId);

        System.out.println(String.format("RollStatus: %s", response.getStatus()));

        return response;
    }

}

