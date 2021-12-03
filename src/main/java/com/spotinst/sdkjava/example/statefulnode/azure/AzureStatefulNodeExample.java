package com.spotinst.sdkjava.example.statefulnode.azure;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.SpotinstAzureStatefulNodeClient;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.*;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeCreationRequest;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeDeletionRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AzureStatefulNodeExample {

    private final static String       auth_token         = "553579a8c5d58e1180376dbf385da3066e41b59c293c5c685a9799fb36ff670a";
    private final static String       act_id             = "act-e97117d5";
    private final static List<String> spotSizes          = Arrays.asList("standard_ds1_v2", "standard_ds2_v2", "standard_ds3_v2", "standard_ds4_v2");
    private final static List<String> odSizes            = Arrays.asList("standard_ds1_v2", "standard_ds2_v2");
    private final static List<String> preferredSpotSizes = Arrays.asList("standard_ds1_v2", "standard_ds2_v2");
    private final static List<String> zones              = Arrays.asList("1", "2", "3");
    private final static List<String> healthCheckTypes   = Arrays.asList("vmState");
    private final static List<String> loadBalancers      = Arrays.asList();

    public static void main(String[] args) throws InterruptedException {

        SpotinstAzureStatefulNodeClient nodeClient = SpotinstClient.getAzureStatefulNodeClient(auth_token, act_id);

        //Create Stateful Node
        System.out.println("----------Creation of azure stateful node--------------");
        String nodeId = createStatefulNode(nodeClient);

        //Get Stateful Node
        System.out.println("----------Get Stateful Node--------------");
        getStatefulNode(nodeClient, nodeId);

        //Update Stateful Node
        System.out.println("----------Update Stateful Node Name--------------");
        updateStatefulNodeName(nodeClient, nodeId);

        //update Stateful Node Strategy
        updateStatefulNodeStrategy(nodeClient, nodeId);

        //update Stateful Node Data Disk
        updateStatefulNodeDataDisk(nodeClient, nodeId);

        //update Stateful Node Os Disk
        updateStatefulNodeOsDisk(nodeClient, nodeId);

        //update Stateful Node Scheduling Tasks
        updateStatefulNodeScheduling(nodeClient, nodeId);

        //update Stateful Node Health
        updateStatefulNodeHealth(nodeClient, nodeId);

        //update Stateful Node Persistent
        updateStatefulNodePersistent(nodeClient, nodeId);

        //Get All Stateful Node
        System.out.println("----------List All Stateful Nodes--------------");
        getAllStatefulNode(nodeClient);

        //Delete Stateful Node
        System.out.println("----------Delete Stateful Node--------------");
        deleteStatefulNode(nodeClient, nodeId);

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
                networkInterfacesBuilder.setIsPrimary(true).setSubnetName("ManualQA-PublicSubnet").setAssignPublicIp(true)
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
                osDiskBuilder.setName("Automation-OsDisk").setType("Standard_LRS").setSizeGB(33).build();

        //Build Extension Protected Settings
        LaunchSpecExtensionsProtectedSettings protectedSettings = LaunchSpecExtensionsProtectedSettings.Builder.get().setScript(
                "IyEvYmluL2Jhc2gKZWNobyAibmlyIiA+IC9ob21lL25pci9uaXIudHh0Cg==").build();

        //Build Extentions
        LaunchSpecExtensionsSpecification.Builder extensionBuilder = LaunchSpecExtensionsSpecification.Builder.get();
        LaunchSpecExtensionsSpecification extensions = extensionBuilder.setName("Automation-Extension").setType("customScript")
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
                tasksBuilder1.setIsEnabled(true).setCronExpression("0 1 * * *").setType("pause").setAdjustment(1).build();

        StatefulNodeTasksConfiguration.Builder tasksBuilder2 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task2 =
                tasksBuilder2.setIsEnabled(false).setCronExpression("37 * * * *").setType("resume").build();
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
                healthBuilder.setHealthCheckTypes(healthCheckTypes).setUnhealthyDuration(300).setGracePeriod(180).setAutoHealing(true).build();

        // Build Stateful Node
        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNode =
                statefulNodeBuilder.setName("Automation-java-SDK-StatefulNode-Bansi").setRegion("eastus").setResourceGroupName("ManualQAResourceGroup")
                                   .setDescription("stateful node for tests").setCompute(compute).setStrategy(strategy).setScheduling(scheduling).setPersistent(persistent).setHealth(health).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest creationRequest = nodeCreationRequestBuilder.setNode(statefulNode).build();

        // Convert node to API object json
        System.out.println(creationRequest.toJson());

        // Create stateful Node
        StatefulNode createdNode = client.createNode(creationRequest);
        System.out.println("Stateful Node successfully created: " + createdNode.getId());

        return createdNode.getId();
    }

    private static StatefulNode getStatefulNode(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Get stateful Node
        StatefulNode getNodeResponse = client.getNode(nodeId);
        System.out.println("Get Stateful Node " + getNodeResponse.getName() + " Successful with Id " + getNodeResponse.getId() + " with ResourceGroup "
                          + getNodeResponse.getResourceGroupName());

        return getNodeResponse;
    }

    private static StatefulNode updateStatefulNodeName(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Build Stateful Node
        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate =
                statefulNodeBuilder.setName("Automation-java-SDK-StatefulNode-Bansi-renamed")
                                   .setDescription("stateful node for tests update").build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println("Update Request for stateful Node: "+ nodeId);
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Succesfully Updated Stateful Node " + updateNodeResponse.getId() + " with name " + updateNodeResponse.getName() + " to  "
                           + updateNodeResponse.getName());

        return updateNodeResponse;
    }

    private static StatefulNode updateStatefulNodeStrategy(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build Signals
        StatefulNodeSignalConfiguration signal =
                StatefulNodeSignalConfiguration.Builder.get().setEnabledAt(1200).setTimeout(200).setType(ElastigroupVmSignalEnumAzure.vmReadyToShutdown).build();
        List<StatefulNodeSignalConfiguration> signalList = Collections.singletonList(signal);

        //Build RevertToSpot
        StatefulNodeRevertToSpotConfiguration revertToSpot =
                StatefulNodeRevertToSpotConfiguration.Builder.get().setPerformAt(AzurePerformAtEnum.NEVER).build();

        //Build Strategy to update
        StatefulNodeStrategyConfiguration.Builder strategyBuilder = StatefulNodeStrategyConfiguration.Builder.get();
        StatefulNodeStrategyConfiguration strategy =
                strategyBuilder.setSignals(signalList).setFallbackToOd(false).setDrainingTimeout(240).setOrientation("AVAILABILITY").setPreferredLifecycle(AzureLifeCycleTypeEnum.OD)
                               .setRevertToSpot(revertToSpot).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setStrategy(strategy).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println("Update Request for stateful Node: "+ nodeId);
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node " + updateNodeResponse.getName() + " Successful with Id " + updateNodeResponse.getId() + " with name renamed to  "
                           + updateNodeResponse.getName());

        return updateNodeResponse;
    }

    private static StatefulNode updateStatefulNodeDataDisk(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build Data Disk
        LaunchSpecDataDisksSpecification.Builder dataDiskBuilder = LaunchSpecDataDisksSpecification.Builder.get();
        LaunchSpecDataDisksSpecification dataDisk = dataDiskBuilder.setLun(2).setSizeGB(2).setType("Standard_LRS").build();
        List<LaunchSpecDataDisksSpecification> dataDisks = Collections.singletonList(dataDisk);

        //Build Launch Specification
        StatefulNodeLaunchSpecification.Builder launchSpecificationBuilder = StatefulNodeLaunchSpecification.Builder.get();
        StatefulNodeLaunchSpecification launchSpecification =
                launchSpecificationBuilder.setDataDisks(dataDisks).build();

        //Build Compute
        StatefulNodeComputeConfiguration.Builder computeBuilder = StatefulNodeComputeConfiguration.Builder.get();
        StatefulNodeComputeConfiguration compute = computeBuilder.setLaunchSpecification(launchSpecification).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setCompute(compute).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println("Update Request for stateful Node: "+ nodeId);
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Data Disk Successful");

        return updateNodeResponse;
    }

    private static StatefulNode updateStatefulNodeOsDisk(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build OsDisk
        LaunchSpecOsDiskSpecification.Builder osDiskBuilder = LaunchSpecOsDiskSpecification.Builder.get();
        LaunchSpecOsDiskSpecification osDisk =
                osDiskBuilder.setName("Automation-OsDisk-updated").setType("Standard_LRS").setSizeGB(33).build();

        //Build Launch Specification
        StatefulNodeLaunchSpecification.Builder launchSpecificationBuilder = StatefulNodeLaunchSpecification.Builder.get();
        StatefulNodeLaunchSpecification launchSpecification = launchSpecificationBuilder.setOsDisk(osDisk).build();

        //Build Compute
        StatefulNodeComputeConfiguration.Builder computeBuilder = StatefulNodeComputeConfiguration.Builder.get();
        StatefulNodeComputeConfiguration compute = computeBuilder.setLaunchSpecification(launchSpecification).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setCompute(compute).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println("Update Request for stateful Node: "+ nodeId);
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Os Disk is successful");

        return updateNodeResponse;

    }



    private static StatefulNode updateStatefulNodeScheduling(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build Scheduling Tasks
        StatefulNodeTasksConfiguration.Builder tasksBuilder1 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task1 =
                tasksBuilder1.setIsEnabled(true).setCronExpression("0 2 * * *").setType("resume").setAdjustment(2).build();

        StatefulNodeTasksConfiguration.Builder tasksBuilder2 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task2 =
                tasksBuilder2.setIsEnabled(false).setCronExpression("25 * * * *").setType("pause").build();
        List<StatefulNodeTasksConfiguration> tasksList = new ArrayList<>();
        tasksList.add(task1);
        tasksList.add(task2);

        //Build Scheduling
        StatefulNodeSchedulingConfiguration scheduling =
                StatefulNodeSchedulingConfiguration.Builder.get().setTasks(tasksList).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setScheduling(scheduling).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println("Update Request for stateful Node: "+ nodeId);
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Scheduling Tasks is successful");

        return updateNodeResponse;

    }

    private static StatefulNode updateStatefulNodeHealth(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build Health
        StatefulNodeHealthConfiguration.Builder healthBuilder = StatefulNodeHealthConfiguration.Builder.get();
        StatefulNodeHealthConfiguration health =
                healthBuilder.setHealthCheckTypes(healthCheckTypes).setUnhealthyDuration(200).setGracePeriod(240).setAutoHealing(false).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setHealth(health).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println("Update Request for stateful Node: "+ nodeId);
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Health is successful");

        return updateNodeResponse;

    }


    private static StatefulNode updateStatefulNodePersistent(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Build persistent
        StatefulNodePersistentConfiguration.Builder persistentBuilder = StatefulNodePersistentConfiguration.Builder.get();
        StatefulNodePersistentConfiguration persistent =
                persistentBuilder.setShouldPersistDataDisks(false).setShouldPersistNetwork(false).setShouldPersistOsDisk(false).setDataDisksPersistenceMode(AzureDiskModeEnum.REATTACH)
                                 .setOsDiskPersistenceMode(AzureDiskModeEnum.REATTACH).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setPersistent(persistent).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println("Update Request for stateful Node: "+ nodeId);
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Persistent is successful");

        return updateNodeResponse;

    }

    private static Boolean deleteStatefulNode(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Build Stateful Deallocation Node
        StatefulNodeDeallocationConfig.Builder statefulDeallocationConfigBuilder = StatefulNodeDeallocationConfig.Builder.get();

        // Build Network Deallocation Node
        StatefulNodeNetworkDeallocationConfig networkDeallocationConfig = StatefulNodeNetworkDeallocationConfig.Builder.get().setShouldDeallocate(true).build();

        // Build Disk Deallocation Node
        StatefulNodeDiskDeallocationConfig diskDeallocationConfig = StatefulNodeDiskDeallocationConfig.Builder.get().setShouldDeallocate(true).build();

        // Build Snapshot Deallocation Node
        StatefulNodeSnapshotDeallocationConfig snapchatDeallocationConfig = StatefulNodeSnapshotDeallocationConfig.Builder.get().setShouldDeallocate(true).build();

        // Build PublicIp Deallocation Node
        StatefulNodePublicIpDeallocationConfig publicIpDeallocationConfig = StatefulNodePublicIpDeallocationConfig.Builder.get().setShouldDeallocate(true).build();

        StatefulNodeDeallocationConfig statefulDeallocationConfig = statefulDeallocationConfigBuilder.setShouldTerminateVms(true)
                                       .setNetworkDeallocationConfig(networkDeallocationConfig).setDiskDeallocationConfig(diskDeallocationConfig)
                                       .setSnapshotDeallocationConfig(snapchatDeallocationConfig).setPublicIpDeallocationConfig(publicIpDeallocationConfig).build();

        // Build node deletion request
        StatefulNodeDeletionRequest.Builder nodeDeletionRequestBuilder = StatefulNodeDeletionRequest.Builder.get();
        StatefulNodeDeletionRequest         deletionRequest            = nodeDeletionRequestBuilder.setDeallocationConfig(statefulDeallocationConfig).build();

        System.out.println("Stateful Node deletion Request: " + deletionRequest.toJson());
        Boolean deleteNodeResponse = client.deleteNode(deletionRequest,nodeId);

        System.out.print("Stateful Node " + nodeId+ " is successfully Deleted");

        return deleteNodeResponse;
    }

    private static List<StatefulNode> getAllStatefulNode(SpotinstAzureStatefulNodeClient client) {

        // Get All Stateful Nodes
        List<StatefulNode> statefulNodesList = client.getAllNodes();

        System.out.println("Stateful Nodes List: ");
        for (int i=0; i< statefulNodesList.size(); i++){
            System.out.println("Stateful Node Id: " + statefulNodesList.get(i).getId() + " And Name: " + statefulNodesList.get(i).getName());
        }

        return statefulNodesList;

    }

}

