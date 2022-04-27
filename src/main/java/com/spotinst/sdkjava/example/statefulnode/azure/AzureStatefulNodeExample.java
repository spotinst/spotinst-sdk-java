package com.spotinst.sdkjava.example.statefulnode.azure;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.enums.azure.statefulNode.*;
import com.spotinst.sdkjava.model.SpotinstAzureStatefulNodeClient;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.*;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AzureStatefulNodeExample {

    private final static String       auth_token          = "auth-token";
    private final static String       act_id              = "act-no";
    private final static String       userName          = "username";
    private final static String       password          = "password";
    private final static List<String> spotSizes           = Arrays.asList("standard_ds1_v2", "standard_ds2_v2", "standard_ds3_v2", "standard_ds4_v2");
    private final static List<String> odSizes             = Arrays.asList("standard_ds1_v2", "standard_ds2_v2");
    private final static List<String> preferredSpotSizes  = Arrays.asList("standard_ds1_v2", "standard_ds2_v2");
    private final static List<String> zones               = Arrays.asList("1", "2", "3");
    private final static List<String> loadBalancers       = Arrays.asList();
    private final static List<String> optimizationWindows = Arrays.asList("Tue:03:00-Wed:04:00","Wed:05:00-Wed:07:30");
    private final static String       vmName              = "SDK-Testing";
    private final static String       resourceGroup       = "AutomationResourceGroup";
    private final static String       dataDiskName       = "Attach-Detach-DataDisk";

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
        System.out.println("----------Update Stateful Node Strategy--------------");
        updateStatefulNodeStrategy(nodeClient, nodeId);

        //update Stateful Node Data Disk
        System.out.println("----------Update Stateful Node DataDisk--------------");
        updateStatefulNodeDataDisk(nodeClient, nodeId);

        //update Stateful Node Os Disk
        System.out.println("----------Update Stateful Node OsDisk--------------");
        updateStatefulNodeOsDisk(nodeClient, nodeId);

        //update Stateful Node Scheduling Tasks
        System.out.println("----------Update Stateful Node Scheduling--------------");
        updateStatefulNodeScheduling(nodeClient, nodeId);

        //update Stateful Node Health
        System.out.println("----------Update Stateful Node Health--------------");
        updateStatefulNodeHealth(nodeClient, nodeId);

        //update Stateful Node Persistent
        System.out.println("----------Update Stateful Node Persistent--------------");
        updateStatefulNodePersistence(nodeClient, nodeId);

        //Get All Stateful Node
        System.out.println("----------List All Stateful Nodes--------------");
        getAllStatefulNode(nodeClient);

        //Get All Stateful Node Status
        System.out.println("----------List All Stateful Node Status--------------");
        getAllStatefulNodeStatus(nodeClient);

        //Recycle Stateful Node
        System.out.println("----------Recycle Stateful Node--------------");
        recycleStatefulNode(nodeClient, nodeId);

        //Get Stateful Node Status
        System.out.println("----------Get Stateful Node Status--------------");
        getStatefulNodeStatus(nodeClient, nodeId);

        //Pause Stateful Node
        System.out.println("----------Pause Stateful Node--------------");
        pauseStatefulNode(nodeClient, nodeId);

        //Resume Stateful Node
        System.out.println("----------Resume Stateful Node--------------");
        resumeStatefulNode(nodeClient, nodeId);

        //Delete Stateful Node
        System.out.println("----------Delete Stateful Node--------------");
        deleteStatefulNode(nodeClient, nodeId);

        //Get Import VM configuration
        System.out.println("----------Get VM Configuration--------------");
        getImportVmConfiguration(nodeClient, vmName, resourceGroup);


        //Import VM to a Stateful Node
        System.out.println("----------Importing VM to Stateful Node--------------");
        ImportConfiguration importId = importStatefulNode(nodeClient);
        String nodeImportId = importId.getStatefulImportId();

        //Get Stateful node import status
        System.out.println("----------Get Stateful Node Import Status--------------");
        getNodeImportStatus(nodeClient, nodeImportId);

        //Get Stateful node import status
        System.out.println("----------Get Stateful Node Resources --------------");
        getNodeResources(nodeClient, nodeId);

        //Get Elastilog
        System.out.println("----------Get StatefulNode log--------------");
        List<StatefulNodeLogsResponse> getLogs = getStaefulNodeLogs(nodeClient, act_id, "fromDate", "toDate", "nodeId");

        //attach the disk to stateful node
        System.out.println("----------Attach DataDisk--------------");
        attachDataDisk(nodeClient, nodeId, dataDiskName);

        //attach the disk to stateful node
        System.out.println("----------Detach DataDisk--------------");
        detachDataDisk(nodeClient, nodeId, dataDiskName);

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
                networkSecurityGroupBuilder.setName("Automation-NSG-PublicSubnet").setResourceGroupName(resourceGroup)
                                           .build();

        //Build Network Interfaces
        LaunchSpecNetworkInterfacesConfiguration.Builder networkInterfacesBuilder =
                LaunchSpecNetworkInterfacesConfiguration.Builder.get();
        LaunchSpecNetworkInterfacesConfiguration networkInterfaces =
                networkInterfacesBuilder.setIsPrimary(true).setSubnetName("Automation-PublicSubnet").setAssignPublicIp(true)
                                        .setPublicIpSku("Standard").setNetworkSecurityGroup(networkSecurityGroup).build();
        List<LaunchSpecNetworkInterfacesConfiguration> networkInterfacesList = Collections.singletonList(networkInterfaces);

        //Build network
        LaunchSpecNetworkConfiguration.Builder networkBuilder = LaunchSpecNetworkConfiguration.Builder.get();
        LaunchSpecNetworkConfiguration network = networkBuilder.setResourceGroupName(resourceGroup).setVirtualNetworkName("Automation-VirtualNetwork")
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
                LaunchSpecLoginSpecification.Builder.get().setUserName(userName).setPassword(password)
                        .build();

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
        StatefulNodeComputeConfiguration compute = computeBuilder.setOs(AzureStatefulNodeOsEnum.LINUX).setPreferredZone("2").setLaunchSpecification(launchSpecification)
                                                                 .setLoadBalancersConfig(loadBalancersList).setVmSizes(vmSizes).setZones(zones).build();

        //Build Signals
        StatefulNodeSignalConfiguration signal =
                StatefulNodeSignalConfiguration.Builder.get().setTimeout(180).setType(ElastigroupVmSignalEnumAzure.vmReady).build();
        List<StatefulNodeSignalConfiguration> signalList = Collections.singletonList(signal);

        //Build RevertToSpot
        StatefulNodeStrategyRevertToSpotConfiguration revertToSpot =
                StatefulNodeStrategyRevertToSpotConfiguration.Builder.get().setPerformAt(AzureStatefulNodePerformAtEnum.ALWAYS).build();
        //Build Strategy
        StatefulNodeStrategyConfiguration.Builder strategyBuilder = StatefulNodeStrategyConfiguration.Builder.get();
        StatefulNodeStrategyConfiguration strategy =
                strategyBuilder.setSignals(signalList).setFallbackToOd(true).setDrainingTimeout(180).setPreferredLifecycle(
                        AzureStatefulNodePreferredLifeCycleEnum.OD)
                               .setRevertToSpot(revertToSpot).setOptimizationWindows(optimizationWindows).build();

        //Build Scheduling Tasks
        StatefulNodeTasksConfiguration.Builder tasksBuilder1 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task1 =
                tasksBuilder1.setIsEnabled(true).setCronExpression("0 1 * * *").setType(AzureStatefulNodeSchedulingTaskTypeEnum.PAUSE).build();

        StatefulNodeTasksConfiguration.Builder tasksBuilder2 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task2 =
                tasksBuilder2.setIsEnabled(false).setCronExpression("37 * * * *").setType(AzureStatefulNodeSchedulingTaskTypeEnum.RESUME).build();
        List<StatefulNodeTasksConfiguration> tasksList = new ArrayList<>();
        tasksList.add(task1);
        tasksList.add(task2);

        //Build Scheduling
        StatefulNodeSchedulingConfiguration scheduling =
                StatefulNodeSchedulingConfiguration.Builder.get().setTasks(tasksList).build();

        // Build persistent
        StatefulNodePersistenceConfiguration.Builder persistentBuilder = StatefulNodePersistenceConfiguration.Builder.get();
        StatefulNodePersistenceConfiguration persistent =
                persistentBuilder.setShouldPersistDataDisks(false).setShouldPersistNetwork(true).setShouldPersistOsDisk(false).setDataDisksPersistenceMode(
                        AzureStatefulNodeDiskPersistenceModeEnum.ONLAUNCH)
                                 .setOsDiskPersistenceMode(AzureStatefulNodeDiskPersistenceModeEnum.ONLAUNCH).build();

        //Build Health
        List<HealthCheckTypeEnumAzure> healthCheckTypesList = new ArrayList<>();
        healthCheckTypesList.add(HealthCheckTypeEnumAzure.VM_STATE);
        StatefulNodeHealthConfiguration.Builder healthBuilder = StatefulNodeHealthConfiguration.Builder.get();
        StatefulNodeHealthConfiguration health =
                healthBuilder.setHealthCheckTypes(healthCheckTypesList).setUnhealthyDuration(300).setGracePeriod(180).setAutoHealing(true).build();

        // Build Stateful Node
        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNode =
                statefulNodeBuilder.setName("Automation-java-SDK-StatefulNode").setRegion("eastus").setResourceGroupName(resourceGroup)
                                   .setDescription("stateful node for tests").setCompute(compute).setStrategy(strategy).setScheduling(scheduling).setPersistence(persistent).setHealth(health).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest creationRequest = nodeCreationRequestBuilder.setNode(statefulNode).build();

        // Convert node to API object json
        System.out.println(creationRequest.toJson());

        // Create stateful Node
        StatefulNode createdNode = client.createNode(creationRequest);
        System.out.println(String.format("Stateful Node %s successfully created: ", createdNode.getId()));

        return createdNode.getId();
    }

    private static StatefulNode getStatefulNode(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Get stateful Node
        StatefulNode getNodeResponse = client.getNode(nodeId);
        System.out.println(String.format("Get Stateful Node %s is Successful with Id %s and with ResourceGroup %s ",
                                         getNodeResponse.getName(), getNodeResponse.getId() , getNodeResponse.getResourceGroupName()));

        return getNodeResponse;
    }

    private static StatefulNodeGetStatusResponse getStatefulNodeStatus(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Get stateful Node
        StatefulNodeGetStatusResponse getNodeStatusResponse = client.getNodeStatus(nodeId);

        System.out.println(String.format("Get Stateful Node Status of %s is Successful with Id %s",
                                         getNodeStatusResponse.getName(), getNodeStatusResponse.getId()));
        System.out.println(String.format("Status is %s and VMName is %s with LifeCycle %s", getNodeStatusResponse.getStatus(),
                              getNodeStatusResponse.getVmName(), getNodeStatusResponse.getLifeCycle()));

        return getNodeStatusResponse;
    }

    private static StatefulNode updateStatefulNodeName(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Build Stateful Node
        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate =
                statefulNodeBuilder.setName("Automation-java-SDK-StatefulNode-renamed")
                                   .setDescription("stateful node for tests update").build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println(String.format("Update Request for stateful Node: %s ", nodeId));
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println(String.format("Successfully Updated Stateful Node %s with name %s to %s " , updateNodeResponse.getId(),  updateNodeResponse.getName(), updateNodeResponse.getName()));

        return updateNodeResponse;
    }

    private static StatefulNode updateStatefulNodeStrategy(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build Signals
        StatefulNodeSignalConfiguration signal =
                StatefulNodeSignalConfiguration.Builder.get().setTimeout(200).setType(ElastigroupVmSignalEnumAzure.vmReadyToShutdown).build();
        List<StatefulNodeSignalConfiguration> signalList = Collections.singletonList(signal);

        //Build RevertToSpot
        StatefulNodeStrategyRevertToSpotConfiguration revertToSpot =
                StatefulNodeStrategyRevertToSpotConfiguration.Builder.get().setPerformAt(AzureStatefulNodePerformAtEnum.NEVER).build();

        //Build Strategy to update
        StatefulNodeStrategyConfiguration.Builder strategyBuilder = StatefulNodeStrategyConfiguration.Builder.get();
        StatefulNodeStrategyConfiguration strategy =
                strategyBuilder.setSignals(signalList).setFallbackToOd(false).setDrainingTimeout(240).setPreferredLifecycle(
                        AzureStatefulNodePreferredLifeCycleEnum.SPOT)
                               .setRevertToSpot(revertToSpot).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setStrategy(strategy).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println(String.format("Update Request for stateful Node: %s ", nodeId));
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println(String.format("Update Stateful Node %s is  Successful with Id %s",  updateNodeResponse.getName(), updateNodeResponse.getId()));

        return updateNodeResponse;
    }

    private static StatefulNode updateStatefulNodeDataDisk(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build Data Disk
        LaunchSpecDataDisksSpecification.Builder dataDiskBuilder = LaunchSpecDataDisksSpecification.Builder.get();
        LaunchSpecDataDisksSpecification dataDisk = dataDiskBuilder.setLun(2).setSizeGB(2).setType("StandardSSD_LRS").build();
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
        System.out.println(String.format("Update Request for stateful Node: %s ", nodeId));
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Data Disk Successful");

        return updateNodeResponse;
    }

    private static StatefulNode updateStatefulNodeOsDisk(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build OsDisk
        LaunchSpecOsDiskSpecification.Builder osDiskBuilder = LaunchSpecOsDiskSpecification.Builder.get();
        LaunchSpecOsDiskSpecification osDisk =
                osDiskBuilder.setName("Automation-OsDisk-updated").setType("Premium_LRS").setSizeGB(33).build();

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
        System.out.println(String.format("Update Request for stateful Node: %s ", nodeId));
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Os Disk is successful");

        return updateNodeResponse;

    }

    private static StatefulNode updateStatefulNodeScheduling(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build Scheduling Tasks
        StatefulNodeTasksConfiguration.Builder tasksBuilder1 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task1 =
                tasksBuilder1.setIsEnabled(true).setCronExpression("0 2 * * *").setType(AzureStatefulNodeSchedulingTaskTypeEnum.RESUME).build();

        StatefulNodeTasksConfiguration.Builder tasksBuilder2 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task2 =
                tasksBuilder2.setIsEnabled(false).setCronExpression("25 * * * *").setType(AzureStatefulNodeSchedulingTaskTypeEnum.PAUSE).build();
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
        System.out.println(String.format("Update Request for stateful Node: %s ", nodeId));
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Scheduling Tasks is successful");

        return updateNodeResponse;

    }

    private static StatefulNode updateStatefulNodeHealth(SpotinstAzureStatefulNodeClient client, String nodeId) {

        //Build Health
        List<HealthCheckTypeEnumAzure> healthCheckTypesList = new ArrayList<>();
        healthCheckTypesList.add(HealthCheckTypeEnumAzure.VM_STATE);

        StatefulNodeHealthConfiguration.Builder healthBuilder = StatefulNodeHealthConfiguration.Builder.get();
        StatefulNodeHealthConfiguration health =
                healthBuilder.setHealthCheckTypes(healthCheckTypesList).setUnhealthyDuration(200).setGracePeriod(240).setAutoHealing(false).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setHealth(health).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println(String.format("Update Request for stateful Node: %s ", nodeId));
        System.out.println(updationRequest.toJson());

        StatefulNode updateNodeResponse = client.updateNode(updationRequest,nodeId);
        System.out.println("Update Stateful Node Health is successful");

        return updateNodeResponse;

    }

    private static StatefulNode updateStatefulNodePersistence(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Build persistent
        StatefulNodePersistenceConfiguration.Builder persistentBuilder = StatefulNodePersistenceConfiguration.Builder.get();
        StatefulNodePersistenceConfiguration persistent =
                persistentBuilder.setShouldPersistDataDisks(false).setShouldPersistNetwork(false).setShouldPersistOsDisk(false).setDataDisksPersistenceMode(
                        AzureStatefulNodeDiskPersistenceModeEnum.REATTACH)
                                 .setOsDiskPersistenceMode(AzureStatefulNodeDiskPersistenceModeEnum.REATTACH).build();

        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNodeToUpdate = statefulNodeBuilder.setPersistence(persistent).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder = StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest updationRequest = nodeCreationRequestBuilder.setNode(statefulNodeToUpdate).build();

        // Convert node to API object json
        System.out.println(String.format("Update Request for stateful Node: %s ", nodeId));
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

        System.out.println(String.format("Stateful Node deletion Request: " + deletionRequest.toJson()));
        Boolean deleteNodeResponse = client.deleteNode(deletionRequest,nodeId);

        System.out.println(String.format("Stateful Node %s is successfully Deleted", nodeId));
        return deleteNodeResponse;
    }

    private static List<StatefulNode> getAllStatefulNode(SpotinstAzureStatefulNodeClient client) {

        // Get All Stateful Nodes
        List<StatefulNode> statefulNodesList = client.getAllNodes();

        System.out.println("Stateful Nodes List: ");

        for (int i=0; i< statefulNodesList.size(); i++){
            System.out.println(String.format("Stateful Node Id: %s and Name: %s ",statefulNodesList.get(i).getId() , statefulNodesList.get(i).getName()));

        }

        return statefulNodesList;

    }

    private static Boolean recycleStatefulNode(SpotinstAzureStatefulNodeClient client, String nodeId){

        // Recycle Stateful Nodes
        StatefulNodeStateChangeRequest.Builder recycleStatefulNodeBuilder = StatefulNodeStateChangeRequest.Builder.get();
        StatefulNodeStateChangeRequest recycleStatefulNode = recycleStatefulNodeBuilder.setState(AzureStatefulNodeStateEnum.RECYCLE).build();

        Boolean recycleStatefulNodeResponse = client.updateStatefulNodeState(recycleStatefulNode,nodeId);

        if (recycleStatefulNodeResponse) {
            System.out.println(String.format("Recycle of stateful Node %s is successful", nodeId));
        }
        else {
            System.out.println(String.format("Recycle of stateful Node %s is not successful", nodeId));
        }

        return recycleStatefulNodeResponse;

    }

    private static Boolean pauseStatefulNode(SpotinstAzureStatefulNodeClient client, String nodeId){

        // Pause Stateful Node
        StatefulNodeStateChangeRequest.Builder pauseStatefulNodeBuilder = StatefulNodeStateChangeRequest.Builder.get();
        StatefulNodeStateChangeRequest pauseStatefulNode = pauseStatefulNodeBuilder.setState(AzureStatefulNodeStateEnum.PAUSE).build();

        Boolean pauseStatefulNodeResponse = client.updateStatefulNodeState(pauseStatefulNode,nodeId);

        if(pauseStatefulNodeResponse) {
            System.out.println(String.format("Pause of stateful Node %s is successful ", nodeId));
        }
        else{
            System.out.println(String.format("Pause of stateful Node %s is not successful ", nodeId));
        }

        return pauseStatefulNodeResponse;

    }

    private static Boolean resumeStatefulNode(SpotinstAzureStatefulNodeClient client, String nodeId){

        // Resume Stateful Node
        StatefulNodeStateChangeRequest.Builder resumeStatefulNodeBuilder = StatefulNodeStateChangeRequest.Builder.get();
        StatefulNodeStateChangeRequest resumeStatefulNode = resumeStatefulNodeBuilder.setState(AzureStatefulNodeStateEnum.RESUME).build();

        Boolean resumeStatefulNodeResponse = client.updateStatefulNodeState(resumeStatefulNode,nodeId);

        if(resumeStatefulNodeResponse) {
            System.out.println(String.format("Resume of stateful Node %s is successful ", nodeId));
        }
        else {
            System.out.println(String.format("Resume of stateful Node %s is not successful ", nodeId));
        }

        return resumeStatefulNodeResponse;

    }


    private static ImportConfiguration importStatefulNode(SpotinstAzureStatefulNodeClient client) {

        //Build VmSizes
        StatefulNodeVmSizesConfiguration.Builder vmSizesBuilder = StatefulNodeVmSizesConfiguration.Builder.get();
        StatefulNodeVmSizesConfiguration vmSizes =
                vmSizesBuilder.setOdSizes(odSizes).setSpotSizes(spotSizes).setPreferredSpotSizes(preferredSpotSizes).build();

        //Build Network Security Group
        LaunchSpecNetworkSecurityGroupConfiguration.Builder networkSecurityGroupBuilder =
                LaunchSpecNetworkSecurityGroupConfiguration.Builder.get();
        LaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup =
                networkSecurityGroupBuilder.setName("Automation-NSG-PublicSubnet").setResourceGroupName(resourceGroup)
                        .build();

        //Build Network Interfaces
        LaunchSpecNetworkInterfacesConfiguration.Builder networkInterfacesBuilder =
                LaunchSpecNetworkInterfacesConfiguration.Builder.get();
        LaunchSpecNetworkInterfacesConfiguration networkInterfaces =
                networkInterfacesBuilder.setIsPrimary(true).setSubnetName("Automation-PublicSubnet").setAssignPublicIp(true)
                        .setPublicIpSku("Standard").setNetworkSecurityGroup(networkSecurityGroup).build();
        List<LaunchSpecNetworkInterfacesConfiguration> networkInterfacesList = Collections.singletonList(networkInterfaces);

        //Build network
        LaunchSpecNetworkConfiguration.Builder networkBuilder = LaunchSpecNetworkConfiguration.Builder.get();
        LaunchSpecNetworkConfiguration network = networkBuilder.setResourceGroupName(resourceGroup).setVirtualNetworkName("Automation-VirtualNetwork")
                .setNetworkInterfaces(networkInterfacesList).build();

        //Build Data Disk
        LaunchSpecDataDisksSpecification.Builder dataDiskBuilder = LaunchSpecDataDisksSpecification.Builder.get();
        LaunchSpecDataDisksSpecification dataDisk = dataDiskBuilder.setLun(1).setSizeGB(15).setType("Standard_LRS").build();
        List<LaunchSpecDataDisksSpecification> dataDisks = Collections.singletonList(dataDisk);

        // Build Tags
        LaunchSpecTagsSpecification tags =
                LaunchSpecTagsSpecification.Builder.get().setTagKey("creator").setTagValue("spotau@netapp.com").build();
        List<LaunchSpecTagsSpecification> tagsList = Collections.singletonList(tags);

        //Build Launch Specification
        StatefulNodeLaunchSpecification.Builder launchSpecificationBuilder = StatefulNodeLaunchSpecification.Builder.get();
        StatefulNodeLaunchSpecification launchSpecification =
                launchSpecificationBuilder.setNetwork(network).setDataDisks(dataDisks).setTags(tagsList).build();

        // Build LoadBalancers Config
        StatefulNodeLoadBalancersConfig loadBalancersList =
                StatefulNodeLoadBalancersConfig.Builder.get().setLoadBalancers(loadBalancers).build();

        //Build Compute
        StatefulNodeComputeConfiguration.Builder computeBuilder = StatefulNodeComputeConfiguration.Builder.get();
        StatefulNodeComputeConfiguration compute = computeBuilder.setPreferredZone("1").setLaunchSpecification(launchSpecification)
                .setLoadBalancersConfig(loadBalancersList).setVmSizes(vmSizes).setZones(zones).build();

        //Build Signals
        StatefulNodeSignalConfiguration signal =
                StatefulNodeSignalConfiguration.Builder.get().setTimeout(180).setType(ElastigroupVmSignalEnumAzure.vmReady).build();
        List<StatefulNodeSignalConfiguration> signalList = Collections.singletonList(signal);

        //Build RevertToSpot
        StatefulNodeStrategyRevertToSpotConfiguration revertToSpot =
                StatefulNodeStrategyRevertToSpotConfiguration.Builder.get().setPerformAt(AzureStatefulNodePerformAtEnum.ALWAYS).build();
        //Build Strategy
        StatefulNodeStrategyConfiguration.Builder strategyBuilder = StatefulNodeStrategyConfiguration.Builder.get();
        StatefulNodeStrategyConfiguration strategy =
                strategyBuilder.setSignals(signalList).setFallbackToOd(true).setDrainingTimeout(120).setPreferredLifecycle(
                        AzureStatefulNodePreferredLifeCycleEnum.SPOT)
                        .setRevertToSpot(revertToSpot).setOptimizationWindows(optimizationWindows).build();

        //Build Scheduling Tasks
        StatefulNodeTasksConfiguration.Builder tasksBuilder1 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task1 =
                tasksBuilder1.setIsEnabled(false).setCronExpression("0 1 * * *").setType(AzureStatefulNodeSchedulingTaskTypeEnum.PAUSE).build();

        StatefulNodeTasksConfiguration.Builder tasksBuilder2 = StatefulNodeTasksConfiguration.Builder.get();
        StatefulNodeTasksConfiguration task2 =
                tasksBuilder2.setIsEnabled(false).setCronExpression("37 * * * *").setType(AzureStatefulNodeSchedulingTaskTypeEnum.RESUME).build();
        List<StatefulNodeTasksConfiguration> tasksList = new ArrayList<>();
        tasksList.add(task1);
        tasksList.add(task2);

        //Build Scheduling
        StatefulNodeSchedulingConfiguration scheduling =
                StatefulNodeSchedulingConfiguration.Builder.get().setTasks(tasksList).build();

        // Build persistent
        StatefulNodePersistenceConfiguration.Builder persistentBuilder = StatefulNodePersistenceConfiguration.Builder.get();
        StatefulNodePersistenceConfiguration persistent =
                persistentBuilder.setShouldPersistDataDisks(false).setShouldPersistNetwork(false).setShouldPersistOsDisk(true).setDataDisksPersistenceMode(
                        AzureStatefulNodeDiskPersistenceModeEnum.ONLAUNCH)
                        .setOsDiskPersistenceMode(AzureStatefulNodeDiskPersistenceModeEnum.ONLAUNCH).build();

        //Build Health
        List<HealthCheckTypeEnumAzure> healthCheckTypesList = new ArrayList<>();
        healthCheckTypesList.add(HealthCheckTypeEnumAzure.VM_STATE);
        StatefulNodeHealthConfiguration.Builder healthBuilder = StatefulNodeHealthConfiguration.Builder.get();
        StatefulNodeHealthConfiguration health =
                healthBuilder.setHealthCheckTypes(healthCheckTypesList).setUnhealthyDuration(300).setGracePeriod(180).setAutoHealing(true).build();

        // Build Stateful Node
        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNode =
                statefulNodeBuilder.setName("Automation-java-SDK-Import-StatefulNode").setRegion("eastus").setResourceGroupName(resourceGroup)
                        .setDescription("stateful node for tests").setCompute(compute).setStrategy(strategy).setScheduling(scheduling).setPersistence(persistent).setHealth(health).build();

        ImportConfiguration.Builder importNodeBuilder = ImportConfiguration.Builder.get();
        ImportConfiguration importNode =
                importNodeBuilder.setNode(statefulNode).setDrainingTimeout(120).setResourceGroupName(resourceGroup)
                        .setResourcesRetentionTime(0).setOriginalVmName(vmName).build();

        // Build node creation request
        StatefulNodeImportRequest.Builder nodeImportRequestBuilder = StatefulNodeImportRequest.Builder.get();
        StatefulNodeImportRequest importRequest = nodeImportRequestBuilder.setImportNode(importNode).build();

        // Convert node to API object json
        System.out.println(importRequest.toJson());

        // Create stateful Node by importing VM
        ImportConfiguration importedNode = client.importNode(importRequest);
        System.out.println(String.format("Stateful Node successfully imported with importId %s ", importedNode.getStatefulImportId()));

        return importedNode;
    }

    private static NodeImportStatusResponse getNodeImportStatus(SpotinstAzureStatefulNodeClient client, String importId) {

        // Get stateful Node Import status
        NodeImportStatusResponse getNodeImportStatusResponse = client.getNodeImportStatus(importId);

        System.out.println(String.format("Status of the import process is %s for the importId %s with nodeId %s", getNodeImportStatusResponse.getState(),
                getNodeImportStatusResponse.getStatefulImportId(), getNodeImportStatusResponse.getStatefulNodeId()));

        return getNodeImportStatusResponse;
    }

    private static StatefulNode getImportVmConfiguration(SpotinstAzureStatefulNodeClient client, String vmName, String resourceGroup) {

        // Get Import VM configuration
        StatefulNode getNodeResponse = client.getImportVmConfiguration(vmName, resourceGroup);
        System.out.println(String.format("Get Import VM configuration %s is Successful for the ResourceGroup %s",
                getNodeResponse.getName(), getNodeResponse.getResourceGroupName()));

        return getNodeResponse;
    }

    private static List<StatefulNodeLogsResponse> getStaefulNodeLogs(SpotinstAzureStatefulNodeClient client, String accountId, String fromDate, String toDate, String nodeId) {

        // Build get request
        StatefulNodeGetLogsRequest.Builder getNodelogRequestBuilder = StatefulNodeGetLogsRequest.Builder.get();
        StatefulNodeGetLogsRequest request = getNodelogRequestBuilder.setAccountId(accountId)
                .setFromDate(fromDate).setToDate(toDate).build();

        List<StatefulNodeLogsResponse> nodeGetLogsResponse =
                client.getStatefulNodeLogs(request, nodeId);

        for (StatefulNodeLogsResponse logs : nodeGetLogsResponse) {
            System.out.println(String.format("Message: %s", logs.getMessage()));
            System.out.println(String.format("Severity: %s", logs.getSeverity()));
            System.out.println(String.format("Created At: %s", logs.getCreatedAt()));
        }

        return nodeGetLogsResponse;
    }

    private static StatefulNodeResourceResponse getNodeResources(SpotinstAzureStatefulNodeClient client, String nodeId) {

        // Get stateful Node Resources
        StatefulNodeResourceResponse getNodeResponse = client.getStatefulNodeResources(nodeId);
        System.out.println(String.format("Get Stateful Node Resources is Successful with Id %s with Name %s ",
                getNodeResponse.getId() , getNodeResponse.getName()));

        return getNodeResponse;
    }

    private static List<StatefulNodeGetStatusResponse> getAllStatefulNodeStatus(SpotinstAzureStatefulNodeClient client) {

        // Get All Stateful Node status
        List<StatefulNodeGetStatusResponse> statefulNodesList = client.getAllNodeStatus();

        System.out.println("Stateful Node status List: ");

        for (int i=0; i< statefulNodesList.size(); i++){
            System.out.println(String.format("Stateful Node Id: %s and Status: %s ",statefulNodesList.get(i).getId() , statefulNodesList.get(i).getStatus()));
        }

        return statefulNodesList;

    }

    private static StatefulNodeAttachDataDiskResponse attachDataDisk(SpotinstAzureStatefulNodeClient client, String nodeId, String dataDiskName) {

        StatefulNodeAttachDataDiskConfiguration.Builder attachDiskBuilder = StatefulNodeAttachDataDiskConfiguration.Builder.get();
        StatefulNodeAttachDataDiskConfiguration attachDiskConfig = attachDiskBuilder.setDataDiskName(dataDiskName)
                .setDataDiskResourceGroupName(resourceGroup)
                .setLun(2)
                .setSizeGB(10)
                .setStorageAccountType("Standard_LRS")
                .setZone("2").build();
        StatefulNodeAttachDataDiskRequest.Builder attachDiskRequest = StatefulNodeAttachDataDiskRequest.Builder.get();

        StatefulNodeAttachDataDiskRequest attachDisk = attachDiskRequest.setAttachDataDisk(attachDiskConfig).build();

        StatefulNodeAttachDataDiskResponse attachDiskResponse = client.attachDataDisk(attachDisk, nodeId);

        System.out.println(String.format("Attached %s to the Stateful Node %s successfully ", attachDiskResponse.getName(), nodeId));

        return attachDiskResponse;
    }

    private static Boolean detachDataDisk(SpotinstAzureStatefulNodeClient client, String nodeId, String dataDiskName) {

        StatefulNodeDetachDataDiskConfiguration.Builder detachDiskBuilder = StatefulNodeDetachDataDiskConfiguration.Builder.get();
        StatefulNodeDetachDataDiskConfiguration detachDiskConfig = detachDiskBuilder.setDataDiskName(dataDiskName)
                .setDataDiskResourceGroupName(resourceGroup)
                .setShouldDeallocate(true)
                .setTtlnHours(0).build();
        StatefulNodeDetachDataDiskRequest.Builder detachDiskRequest = StatefulNodeDetachDataDiskRequest.Builder.get();

        StatefulNodeDetachDataDiskRequest detachDisk = detachDiskRequest.setDetachDataDisk(detachDiskConfig).build();

        Boolean detachDiskResponse = client.detachDataDisk(detachDisk, nodeId);

        if(detachDiskResponse) {
            System.out.println(String.format("Detach DataDisk for stateful Node %s is successful ", nodeId));
        }
        else {
            System.out.println(String.format("Detach DataDisk for stateful Node %s is not successful ", nodeId));
        }

        return detachDiskResponse;
    }

}

