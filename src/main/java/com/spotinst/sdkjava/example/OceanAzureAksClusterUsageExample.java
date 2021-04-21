package com.spotinst.sdkjava.example;


import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.SpotOceanAzureAksClusterClient;

import com.spotinst.sdkjava.model.bl.ocean.aks.*;

import java.util.Arrays;

import java.util.List;

import static java.lang.Thread.sleep;

public class OceanAzureAksClusterUsageExample {

    private final static String auth_token = "eeab5e1e5e9b5dcbb1aba6d7023d2ae981c6b48dd13784439bb6061f8beb053a";
    private final static String act_id     = "act-e929c6e7";

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
        ClusterMarketplaceAks clusterMarketplace = marketplaceAksBuilder.setOffer("aks").setPublisher("microsoft-aks").setSku("aks-ubuntu-1804-gen2-2021-q1")
                .setVersion("2021.03.29").build();

        //Build image
        ClusterImageAks.Builder imageAksBuilder = ClusterImageAks.Builder.get();
        ClusterImageAks imageAks = imageAksBuilder.setMarketplace(clusterMarketplace).build();

        //Build launchSpecification
        ClusterLaunchSpecificationAks.Builder launchSpecificationAksBuilder = ClusterLaunchSpecificationAks.Builder.get();
        ClusterLaunchSpecificationAks launchSpecificationAks = launchSpecificationAksBuilder.setExtensions(extensions).setImage(imageAks)
                                                                .setLogin(loginAks).setLoadBalancersConfig(loadBalancersConfigAks).setOsDisk(osDiskAks).setTags(tags)
                                                                .setNetwork(networkAks).setResourceGroupName("MC_AutomationApiRG_AutomationApi_eastus").build();

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
}

