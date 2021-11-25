package com.spotinst.sdkjava.example.statefulnode.azure;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.SpotinstAzureStatefulNodeClient;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.*;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeCreationRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AzureStatefulNodeExample {

    private final static String       auth_token         = "553579a8c5d58e1180376dbf385da3066e41b59c293c5c685a9799fb36ff670a";
    private final static String       act_id             = "act-e97117d5";
    private final static List<String> spotSizes          =
            Arrays.asList("standard_ds1_v2", "standard_ds2_v2", "standard_ds3_v2", "standard_ds4_v2");
    private final static List<String> odSizes            = Arrays.asList("standard_ds1_v2", "standard_ds2_v2");
    private final static List<String> preferredSpotSizes = Arrays.asList("standard_ds1_v2", "standard_ds2_v2");
    private final static List<String> zones              = Arrays.asList("1", "2", "3");
    private final static List<String> healthCheckTypes   = Arrays.asList("vmState");
    private final static List<String> loadBalancers      = Arrays.asList();

    public static void main(String[] args) throws InterruptedException {

        SpotinstAzureStatefulNodeClient nodeClient = SpotinstClient.getAzureStatefulNodeClient(auth_token, act_id);

        System.out.println("----------Creation of azure stateful node--------------");
        String nodeId = createStatefulNode(nodeClient);

        //Get Stateful Node
        getStatefulNode(nodeClient, nodeId);

    }

    private static String createStatefulNode(SpotinstAzureStatefulNodeClient client) {

        //Build VmSizes
        StatefulNodeVmSizesConfiguration.Builder vmSizesBuilder = StatefulNodeVmSizesConfiguration.Builder.get();
        StatefulNodeVmSizesConfiguration vmSizes =
                vmSizesBuilder.setOdSizes(odSizes).setSpotSizes(spotSizes).setPreferredSpotSizes(preferredSpotSizes).build();

        //Build MarketPlace
        LaunchSpecMarketplaceConfiguration.Builder marketPlaceBuilder = LaunchSpecMarketplaceConfiguration.Builder.get();
        LaunchSpecMarketplaceConfiguration marketplace =
                marketPlaceBuilder.setPublisher("Canonical").setOffer("UbuntuServer").setSku("18.04-LTS").setVersion("latest").build();

        //Build Image
        LaunchSpecImageConfiguration image = LaunchSpecImageConfiguration.Builder.get().setMarketplace(marketplace).build();

        //Build Network Security Group
        LaunchSpecNetworkSecurityGroupConfiguration.Builder networkSecurityGroupBuilder =
                LaunchSpecNetworkSecurityGroupConfiguration.Builder.get();
        LaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup =
                networkSecurityGroupBuilder.setName("ManualQA-NSG-Public").setResourceGroupName("ManualQAResourceGroup")
                                           .build();

        //Build Network Interfaces
        LaunchSpecNetworkInterfacesConfiguration.Builder networkInterfacesBuilder =
                LaunchSpecNetworkInterfacesConfiguration.Builder.get();
        LaunchSpecNetworkInterfacesConfiguration networkInterfaces =
                networkInterfacesBuilder.setPrimary(true).setSubnetName("ManualQA-PublicSubnet").setAssignPublicIp(true)
                                        .setPublicIpSku("Standard").setNetworkSecurityGroup(networkSecurityGroup).build();
        List<LaunchSpecNetworkInterfacesConfiguration> networkInterfacesList = Collections.singletonList(networkInterfaces);

        //Build network
        LaunchSpecNetworkConfiguration.Builder networkBuilder = LaunchSpecNetworkConfiguration.Builder.get();
        LaunchSpecNetworkConfiguration network = networkBuilder.setResourceGroupName("ManualQAResourceGroup").setVirtualNetworkName("ManualQA-VirtualNetwork")
                                                               .setNetworkInterfaces(networkInterfacesList).build();

        //Build Data Disk
        LaunchSpecDataDisksSpecification.Builder dataDiskBuilder = LaunchSpecDataDisksSpecification.Builder.get();
        LaunchSpecDataDisksSpecification dataDisk = dataDiskBuilder.setLun(1).setSizeGB(1).setType("Standard_LRS").build();
        List<LaunchSpecDataDisksSpecification> dataDisks = Collections.singletonList(dataDisk);

        //Build OsDisk
        LaunchSpecOsDiskSpecification.Builder osDiskBuilder = LaunchSpecOsDiskSpecification.Builder.get();
        LaunchSpecOsDiskSpecification osDisk =
                osDiskBuilder.setName("OsTestDisk").setType("Standard_LRS").setSizeGB(33).build();

        //Build Extension Protected Settings
        LaunchSpecExtensionsProtectedSettings protectedSettings = LaunchSpecExtensionsProtectedSettings.Builder.get().setScript(
                "IyEvYmluL2Jhc2gKZWNobyAibmlyIiA+IC9ob21lL25pci9uaXIudHh0Cg==").build();

        //Build Extentions
        LaunchSpecExtensionsSpecification.Builder extensionBuilder = LaunchSpecExtensionsSpecification.Builder.get();
        LaunchSpecExtensionsSpecification extensions = extensionBuilder.setName("extensionName").setType("customScript")
                                                                       .setPublisher("Microsoft.Azure.Extensions").setApiVersion("2.0")
                                                                       .setMinorVersionAutoUpgrade(true).setProtectedSettings(protectedSettings).build();

        List<LaunchSpecExtensionsSpecification> extensionsList = Collections.singletonList(extensions);
        // Build Login
        LaunchSpecLoginSpecification login =
                LaunchSpecLoginSpecification.Builder.get().setUserName("ubuntu").setPassword("NetApp@123@321").build();

        // Build Tags
        LaunchSpecTagsSpecification tags =
                LaunchSpecTagsSpecification.Builder.get().setTagKey("creator").setTagValue("spotau@netapp.com").build();
        List<LaunchSpecTagsSpecification> tagsList = Collections.singletonList(tags);

        //Build Launch Specification
        StatefulNodeLaunchSpecification.Builder launchSpecificationBuilder = StatefulNodeLaunchSpecification.Builder.get();
        StatefulNodeLaunchSpecification launchSpecification =
                launchSpecificationBuilder.setImage(image).setNetwork(network).setDataDisks(dataDisks).setOsDisk(osDisk)
                                          .setExtensions(extensionsList).setLogin(login).setTags(tagsList).build();

        // Build LoadBalancers Config
        StatefulNodeLoadBalancersConfig loadBalancersList =
                StatefulNodeLoadBalancersConfig.Builder.get().setLoadBalancers(loadBalancers).build();

        //Build Compute
        StatefulNodeComputeConfiguration.Builder computeBuilder = StatefulNodeComputeConfiguration.Builder.get();
        StatefulNodeComputeConfiguration compute = computeBuilder.setOs(AzureOsEnum.LINUX).setPreferredZone("2").setLaunchSpecification(launchSpecification)
                                                                 .setLoadBalancersConfig(loadBalancersList).setVmSizes(vmSizes).setZones(zones).build();

        //Build Signals
        StatefulNodeSignalConfiguration signal =
                StatefulNodeSignalConfiguration.Builder.get().setEnabledAt(1624).setTimeout(180).setType(ElastigroupVmSignalEnumAzure.vmReady).build();
        List<StatefulNodeSignalConfiguration> signalList = Collections.singletonList(signal);

        //Build RevertToSpot
        StatefulNodeRevertToSpotConfiguration revertToSpot =
                StatefulNodeRevertToSpotConfiguration.Builder.get().setPerformAt(AzurePerformAtEnum.ALWAYS).build();
        //Build Strategy
        StatefulNodeStrategyConfiguration.Builder strategyBuilder = StatefulNodeStrategyConfiguration.Builder.get();
        StatefulNodeStrategyConfiguration strategy =
                strategyBuilder.setSignals(signalList).setFallbackToOd(true).setDrainingTimeout(180).setOrientation("AVAILABILITY").setPreferredLifecycle(AzureLifeCycleTypeEnum.SPOT)
                               .setRevertToSpot(revertToSpot).build();

        //Build Scheduling Tasks
        StatefulNodeTasksConfiguration.Builder tasksBuilder1 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task1 =
                tasksBuilder1.setIsEnabled(true).setCronExpression("0 1 * * *").setType("pause").setAdjustment(1).setIdentifier(-1636758474).build();

        StatefulNodeTasksConfiguration.Builder tasksBuilder2 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task2 =
                tasksBuilder2.setIsEnabled(false).setCronExpression("37 * * * *").setType("resume").setIdentifier(2085552106).build();
        List<StatefulNodeTasksConfiguration> tasksList = new ArrayList<>();
        tasksList.add(task1);
        tasksList.add(task2);

        //Build Scheduling
        StatefulNodeSchedulingConfiguration scheduling =
                StatefulNodeSchedulingConfiguration.Builder.get().setTasks(tasksList).build();

        // Build persistent
        StatefulNodePersistentConfiguration.Builder persistentBuilder = StatefulNodePersistentConfiguration.Builder.get();
        StatefulNodePersistentConfiguration persistent =
                persistentBuilder.setShouldPersistDataDisks(true).setShouldPersistNetwork(true).setShouldPersistOsDisk(true).setDataDisksPersistenceMode(AzureDiskModeEnum.ONLAUNCH)
                                 .setOsDiskPersistenceMode(AzureDiskModeEnum.ONLAUNCH).build();

        //Build Health
        StatefulNodeHealthConfiguration.Builder healthBuilder = StatefulNodeHealthConfiguration.Builder.get();
        StatefulNodeHealthConfiguration health =
                healthBuilder.setHealthCheckTypes(healthCheckTypes).setUnhealthyDuration(300).setGracePeriod(180).setAutoHealing("true").build();

        // Build Stateful Node
        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNode =
                statefulNodeBuilder.setName("Automation-java-SDK-StatefulNode-Bansi").setRegion("eastus").setResourceGroupName("ManualQAResourceGroup")
                                   .setDescription("stateful node for tests").setCompute(compute).setStrategy(strategy).setScheduling(scheduling).setPersistent(persistent).setHealth(health).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest creationRequest = nodeCreationRequestBuilder.setNode(statefulNode).build();

        // Convert node to API object json
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(creationRequest.toJson());

        System.out.println("assign public IP: " +
                           creationRequest.getNode().getCompute().getLaunchSpecification().getNetwork().getNetworkInterfaces().get(0).getAssignPublicIp());
        System.out.println("primary: " + creationRequest.getNode().getCompute().getLaunchSpecification().getNetwork().getNetworkInterfaces().get(0).getPrimary());

        // Create stateful Node
        StatefulNode createdNode = client.createNode(creationRequest);
        System.out.println("Node successfully created: " + createdNode.getId());

        //return createdNode.getId();
        return null;
    }

    private static StatefulNode getStatefulNode(SpotinstAzureStatefulNodeClient client, String nodeId) {

        System.out.println("----------Get Stateful Node Status--------------");
        // Create stateful Node
        StatefulNode getNode = client.getNode(nodeId);
        System.out.println("Node successfully created: " + getNode.getId());

        return getNode;
    }

}