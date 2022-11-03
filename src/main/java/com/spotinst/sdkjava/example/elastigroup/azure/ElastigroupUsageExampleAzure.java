package com.spotinst.sdkjava.example.elastigroup.azure;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.DeploymentDetailsBatchAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.DeploymentDetailsOverviewAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentCreateAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentGetAzure;
import com.spotinst.sdkjava.model.filters.SortQueryParam;
import com.spotinst.sdkjava.model.requests.elastigroup.azure.*;
import java.io.IOException;
import java.util.*;

public class ElastigroupUsageExampleAzure {
    private final static String auth_token          = "auth-token";
    private final static String act_id              = "act-id";
    private final static String SSA                 = "ssh user login";
    private final static String SPOTINST_GROUP_NAME = "SpotinstJavaSDKGroup";
    private final static List<String> vmList        = Arrays.asList("vm-b92e1161bfe5");
    private final static String vmName              = "vm-17793a03a276";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        SpotinstElastigroupClientAzure elastigroupClient = SpotinstClient.getElastigroupClientAzure(auth_token, act_id);

        // Create group
        String elastigroupId = createElastigroup(elastigroupClient);

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 60 seconds.");
        sleep(60);
        // Update group
        updateElastigroup(elastigroupClient, elastigroupId);

        ElastigroupAzure group =  getGroup(elastigroupClient, elastigroupId);
        String groupName = group.getName();
        String preFormat     = "groupId: %s - groupName: %s";
        System.out.println(String.format(preFormat, elastigroupId, groupName));

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // Get all Elastigroups
        getAllElastigroupsIncludeDeleted(elastigroupClient);
        // Create Deployment (Group should have > 0 VMs)
        GroupDeploymentCreateAzure newlyCreatedDeployment = createDeployment(elastigroupClient, elastigroupId);

        // Get Deployment
        String                  deploymentId        = newlyCreatedDeployment.getId();
        GroupDeploymentGetAzure retrievedDeployment = getDeployment(elastigroupClient, elastigroupId, deploymentId);

        // Get Deployment Details
        GroupDeploymentDetailsAzure deploymentDetails =
                getDeploymentDetails(elastigroupClient, elastigroupId, deploymentId);
         //List Deployments
        List<GroupDeploymentGetAzure> allDeployments = getAllDeployments(elastigroupClient, elastigroupId);

        // Get Elastigroup Status
        GetElastigroupStatusResponseAzure status = getGroupStatus(elastigroupClient, "sig-a6a44b9b");
        String vmName = status.getVms().get(0).getVmName();
        System.out.println("Name of the Elastigroup is "+ vmName);

        // Scale Up
      scaleUpGroup(elastigroupClient, "sig-a6a44b9b", 3);

        // Scale Down
        scaleDownGroup(elastigroupClient, "sig-a6a44b9b", 4);

        //import from scale set
        ElastigroupAzure elastigroupAzuregroup = importGroupFromScaleSet(elastigroupClient, "AutomationResourceGroup",
                "sig-f22cc948_standard_d1_v2_regular");
        String azureGroupName = elastigroupAzuregroup.getName();
        System.out.println("Imported Group name " + azureGroupName + " from scale set");

        //Create Vm Signal
        createVmSignal(elastigroupClient);

        //update capacity
        updateCapacity(elastigroupClient, "sig-a6a44b9b");
        System.out.println("Successfully updated the capacity settings for elastigroup: sig-a6a44b9b");

        //get vm healthiness
        List<VmHealthinessAzure> vmHealth = vmHealthiness(elastigroupClient, "sig-a6a44b9b");
        VmHealthStatusEnumAzure statusEnum = vmHealth.get(0).getHealthStatus();
        System.out.println("VM Health Status of group is: "+ statusEnum);

        //suspendGroup Process
        suspendGroup(elastigroupClient, "sig-a6a44b9b");

        //resumeGroup Process
        resumeGroup(elastigroupClient, "sig-94b203f9");

        //Vm protection
        vmProtection(elastigroupClient, "sig-94b203f9");

        //Remove Vm protection
        removeVmProtection(elastigroupClient, "sig-a6a44b9b", "vm-42144e5c3582");

        //Import from VM
        ElastigroupAzure response = importFromVm(elastigroupClient);
        String name = response.getName();
        System.out.println("Import from VM updated at : "+ name);

        //Get Elasti logs
        GetElastilogResponseAzure logs = getElastiLog(elastigroupClient, "sig-a6a44b9b");
        String message = logs.getCreatedAt();
        System.out.println("Logs : "+ message);

        //Detach VmsDetails
        DetachVmsResponseAzure detachResponse = detachVms(elastigroupClient, "sig-94b203f9");
        String oldVmName = detachResponse.getDetachedVms().get(0).getVmName();
        String newvmName = detachResponse.getNewVmsAzure().get(0).getVmName();
        System.out.println("Detached Vm Name : "+ oldVmName);
        System.out.println("Newaly attached Vm Name : "+ newvmName);



        // Delete elastigroup
        deleteElastigroup(elastigroupClient, elastigroupId);
    }

    private static String createElastigroup(SpotinstElastigroupClientAzure client) {
        // Build group launch spec
        ElastigroupLaunchSpecificationAzure.Builder launchSpecBuilder =
                ElastigroupLaunchSpecificationAzure.Builder.get();

        MarketplaceAzure.Builder marketplaceBuilder = MarketplaceAzure.Builder.get();

        MarketplaceAzure marketplace =
                marketplaceBuilder.setVersion("latest").setSku("18.04-LTS").setPublisher("Canonical")
                                  .setOffer("UbuntuServer").build();

        ImageSpecAzure.Builder imageSpecBuilder = ImageSpecAzure.Builder.get();

        ImageSpecAzure imageSpecAzure = imageSpecBuilder.setMarketplace(marketplace).build();

        //build Additional Ip Configurations
        AdditionalIpConfigurationsAzure.Builder additionalIpConfigurationsAzureBuilder =
                AdditionalIpConfigurationsAzure.Builder.get();

        AdditionalIpConfigurationsAzure ipConfiguration =
                additionalIpConfigurationsAzureBuilder.setName("automationTestSecondaryIpConfig").build();


        List<AdditionalIpConfigurationsAzure> additionalIpConfigurationsAzureList = new ArrayList<>();
        additionalIpConfigurationsAzureList.add(ipConfiguration);

        //build network interface
        NetworkInterfaceAzure.Builder networkInterfaceBuilder = NetworkInterfaceAzure.Builder.get();

        NetworkInterfaceAzure networkInterfaceAzure =
                networkInterfaceBuilder.setIsPrimary(true).setAssignPublicIp(false).setSubnetName("automationVN")
                                       .setEnableIPForwarding(true)
                                       .setAdditionalIpConfigurations(additionalIpConfigurationsAzureList).build();

        List<NetworkInterfaceAzure> networkInterfaceAzuresList = new ArrayList<>();
        networkInterfaceAzuresList.add(networkInterfaceAzure);

        //build network
        NetworkAzure.Builder networkBuilder = NetworkAzure.Builder.get();

        NetworkAzure network =
                networkBuilder.setResourceGroupName("AutomationResourceGroup").setVirtualNetworkName("automationVN").
                              setNetworkInterfaces(networkInterfaceAzuresList).build();


        //build tags
        TagAzure.Builder tagsBuilder1 = TagAzure.Builder.get();
        TagAzure.Builder tagsBuilder2 = TagAzure.Builder.get();

        TagAzure tag1 = tagsBuilder1.setTagKey("creator").setTagValue("automation@spotinst.com").build();
        TagAzure tag2 = tagsBuilder2.setTagKey("name").setTagValue("automation").build();

        List<TagAzure> tagsList = new ArrayList<>();
        tagsList.add(tag1);
        tagsList.add(tag2);

        //build login
        LoginAzure.Builder loginBuilder = LoginAzure.Builder.get();

        // it is recommended to set a unique username that isn't present in the "reserved usernames" pool
        LoginAzure login = loginBuilder.setUserName("notAReservedUserName").setSshPublicKey(SSA).build();


        ElastigroupLaunchSpecificationAzure launchSpec =
                launchSpecBuilder.setImage(imageSpecAzure).setNetwork(network).setLogin(login).setTags(tagsList)
                                 .build();


        //buildVmSizes
        List<String> odSizesAzureList = new ArrayList<>();
        odSizesAzureList.add("standard_a1_v2");
        List<String> spotSizesAzureList = new ArrayList<>();
        spotSizesAzureList.add("standard_a1_v2");

        ElastigroupVmSizesAzure.Builder vmSizesAzureBuilder = ElastigroupVmSizesAzure.Builder.get();

        ElastigroupVmSizesAzure vmSizesAzure =
                vmSizesAzureBuilder.setOdSizes(odSizesAzureList).setSpotSizes(spotSizesAzureList).build();


        // Build group compute
        ElastigroupComputeConfigurationAzure.Builder computeBuilder =
                ElastigroupComputeConfigurationAzure.Builder.get();
        ElastigroupComputeConfigurationAzure compute =
                computeBuilder.setOs("Linux").setLaunchSpecification(launchSpec).setVmSizes(vmSizesAzure).build();


        //Build group strategy
        //build revert to spot
        RevertToSpotSpecAzure.Builder reveertToSpotBuilder = RevertToSpotSpecAzure.Builder.get();

        List<String> optimizationTimeList = new ArrayList<>();
        optimizationTimeList.add("Mon:03:00-Wed:02:30");

        RevertToSpotSpecAzure reveertToSpot = reveertToSpotBuilder.setPerformAt("timeWindow").build();

        ElastigroupStrategyConfigurationAzure.Builder strategyBuilder =
                ElastigroupStrategyConfigurationAzure.Builder.get();

        ElastigroupStrategyConfigurationAzure strategy =
                strategyBuilder.setSpotPercentage(100).setDrainingTimeout(30).setFallbackToOd(true)
                               .setOptimizationWindows(optimizationTimeList).setRevertToSpot(reveertToSpot).setOrientation(AzureOrientationEnum.CHEAPEST).build();

        //Build group capacity
        ElastigroupCapacityConfigurationAzure.Builder capacityBuilder =
                ElastigroupCapacityConfigurationAzure.Builder.get();
        ElastigroupCapacityConfigurationAzure capacity =
                capacityBuilder.setMinimum(0).setMaximum(5).setTarget(0).build();


        // Build elastigroup
        ElastigroupAzure.Builder elastigroupBuilder = ElastigroupAzure.Builder.get();
        ElastigroupAzure elastigroup =
                elastigroupBuilder.setName(SPOTINST_GROUP_NAME).setResourceGroupName("AutomationResourceGroup")
                                  .setRegion("eastus").setStrategy(strategy).setCapacity(capacity).setCompute(compute)
                                  .build();

        // Build elastigroup creation request
        ElastigroupCreationRequestAzure.Builder elastigroupCreationRequestBuilder =
                ElastigroupCreationRequestAzure.Builder.get();
        ElastigroupCreationRequestAzure creationRequest =
                elastigroupCreationRequestBuilder.setElastigroup(elastigroup).build();

        // Convert elastigroup to API object json
        System.out.println(creationRequest.toJson());
        // Create elastigroup

        ElastigroupAzure createdElastigroup = client.createElastigroup(creationRequest);
        System.out.println("Elastigroup successfully created: " + createdElastigroup.getId());

        // Get elastigroup Id
        return createdElastigroup.getId();
    }


    private static void updateElastigroup(SpotinstElastigroupClientAzure client, String elastigroupId) {
        //Create group update
        ElastigroupCapacityConfigurationAzure.Builder updateCapacityBuilder =
                ElastigroupCapacityConfigurationAzure.Builder.get();
        ElastigroupCapacityConfigurationAzure updateCapacity =
                updateCapacityBuilder.setMinimum(0).setTarget(0).setMaximum(0).build();

        // Build elastigroup update
        ElastigroupAzure.Builder updateElastigroupBuilder = ElastigroupAzure.Builder.get();
        ElastigroupAzure elastigroupUpdate =
                updateElastigroupBuilder.setCapacity(updateCapacity).setName(SPOTINST_GROUP_NAME).build();

        // Build elastigroup update request
        ElastigroupUpdateRequestAzure.Builder elastigroupUpdateRequestBuilder =
                ElastigroupUpdateRequestAzure.Builder.get();
        ElastigroupUpdateRequestAzure updateRequest =
                elastigroupUpdateRequestBuilder.setElastigroup(elastigroupUpdate).build();

        // Convert elastigroup update to API object json
        System.out.println(updateRequest.toJson());

        // Update elastigroup
        Boolean updateSuccess = client.updateElastigroup(updateRequest, elastigroupId);
        if (updateSuccess) {
            System.out.println("Elastigroup successfully updated.");
        }
    }

    private static void deleteElastigroup(SpotinstElastigroupClientAzure client, String elastigroupId) {
        ElastigroupDeletionRequestAzure.Builder deletionBuilder = ElastigroupDeletionRequestAzure.Builder.get();
        ElastigroupDeletionRequestAzure         deletionRequest =
                deletionBuilder.setElastigroupId(elastigroupId).build();

        Boolean successfulDeletion = client.deleteElastigroup(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Elastigroup successfully deleted: " + elastigroupId);
        }
    }

    private static List<ElastigroupAzure> getAllElastigroupsIncludeDeleted(SpotinstElastigroupClientAzure client) {

        ElastigroupGetAllRequestAzure.Builder requestBuilder = ElastigroupGetAllRequestAzure.Builder.get();
        ElastigroupGetAllRequestAzure requestByName =
                requestBuilder.setName(SPOTINST_GROUP_NAME).setIncludeDeleted(true).build();
        return client.getAllElastigroups(requestByName);
    }

    private static GroupDeploymentCreateAzure createDeployment(SpotinstElastigroupClientAzure client,
                                                               String elastigroupId) {

        GroupDeploymentCreationRequestAzure.Builder groupDeploymentRequestBuilder =
                GroupDeploymentCreationRequestAzure.Builder.get();
        GroupDeploymentCreationRequestAzure groupDeploymentRequest =
                groupDeploymentRequestBuilder.setBatchSizePercentage(100).setDrainingTimeout(20).setGracePeriod(300)
                                             .build();


        GroupDeploymentCreateAzure createdDeployment        =
                client.createDeployment(groupDeploymentRequest, elastigroupId);
        String                     cDeploymentId            = createdDeployment.getId();
        String                     cDeploymentGroupId       = createdDeployment.getGroupId();
        String                     cDeploymentProgressValue = createdDeployment.getProgress().getValue().toString();
        String                     cDeploymentProgressUnit  = createdDeployment.getProgress().getUnit().getName();
        String                     preFormat                =
                "deployment %s for group %s successfully created, progress: %s %s complete";
        System.out.println(String.format(preFormat, cDeploymentId, cDeploymentGroupId, cDeploymentProgressValue,
                                         cDeploymentProgressUnit));

        return createdDeployment;

    }

    private static List<GroupDeploymentGetAzure> getAllDeployments(SpotinstElastigroupClientAzure client,
                                                                   String groupId) {

        SortQueryParam sortQueryParam = new SortQueryParam("createdAt");
        sortQueryParam.setSortOrder(AscDescEnum.DESC);
        Integer                       limit       = 20;
        List<GroupDeploymentGetAzure> deployments = client.getAllDeployments(groupId, limit, sortQueryParam);
        System.out.println(String.format("found %s deployments with IDs:", deployments.size()));
        deployments.stream().map(GroupDeploymentGetAzure::getId).forEach(System.out::println);

        return deployments;
    }

    private static GroupDeploymentGetAzure getDeployment(SpotinstElastigroupClientAzure client, String groupId,
                                                         String deploymentId) {

        GroupDeploymentGetAzure deployment    = client.getDeployment(groupId, deploymentId);
        String                  progressValue = deployment.getProgress().getValue().toString();
        String                  progressUnit  = deployment.getProgress().getUnit().getName();
        String                  status        = deployment.getStatus().getName();
        String                  preFormat     = "deployment ID: %s - status: %s - progress: %s %s complete";
        System.out.println(String.format(preFormat, deploymentId, status, progressValue, progressUnit));
        return deployment;

    }

    private static GroupDeploymentDetailsAzure getDeploymentDetails(SpotinstElastigroupClientAzure client,
                                                                    String groupId, String deploymentId) {

        GroupDeploymentDetailsAzure    deploymentDetails = client.getDeploymentDetails(groupId, deploymentId);
        DeploymentDetailsOverviewAzure overview          = deploymentDetails.getDetailsOverview();
        String                         retDeploymentId   = overview.getDeploymentId();
        String                         blueInstances     = overview.getBlueVms().toString();
        String                         greenInstances    = overview.getGreenVms().toString();
        String                         currentBatch      = overview.getCurrentBatch().toString();
        String                         numOfBatches      = overview.getNumberOfBatches().toString();
        String preFormatted = "Get deployment details: ID: %s, batches: %s out of %s complete, blue/green: %s/%s";
        System.out.println(String.format(preFormatted, retDeploymentId, currentBatch, numOfBatches, blueInstances,
                                         greenInstances));
        List<DeploymentDetailsBatchAzure> overviewBatches = deploymentDetails.getBatches();

        if (overviewBatches != null && overviewBatches.size() > 0) {

            for (DeploymentDetailsBatchAzure batch : overviewBatches) {
                String batchPreString = "batch number %s: # of green VMs %s, # of blue VMs %s";
                int    greenSizes     = batch.getGreen().size();
                int    blueSizes      = batch.getBlue().size();
                System.out.println(String.format(batchPreString, batch.getBatch(), greenSizes, blueSizes));
            }

        }

        return deploymentDetails;
    }

    private static ElastigroupAzure getGroup(SpotinstElastigroupClientAzure client, String groupId) {

        ElastigroupGetRequestAzure.Builder requestBuilder = ElastigroupGetRequestAzure.Builder.get();
        ElastigroupGetRequestAzure requestById = requestBuilder.setElastigroupId(groupId).build();

        return client.getElastigroup(requestById);

    }

    private static void sleep(Integer seconds) {
        for (Integer i = 0; i < seconds; i++) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((i % 5) == 0 && i > 0) {
                System.out.println(i + " seconds have passed.");
            }
        }

    }

    private static GetElastigroupStatusResponseAzure getGroupStatus(SpotinstElastigroupClientAzure client, String groupId) {

        return client.getGroupStatus(groupId);

    }

    private static List<ScalingResponseVms> scaleUpGroup(SpotinstElastigroupClientAzure elastigroupClient,
                                                         String elastigroupId, Integer adjustment) {

        return elastigroupClient.scaleGroupUp(elastigroupId, adjustment);
    }

    private static List<ScalingResponseVms> scaleDownGroup(SpotinstElastigroupClientAzure elastigroupClient,
                                                           String elastigroupId, Integer adjustment) {

        return elastigroupClient.scaleGroupDown(elastigroupId, adjustment);
    }

    private static ElastigroupAzure importGroupFromScaleSet(SpotinstElastigroupClientAzure elastigroupClient,
                                                            String  resourceGroupName, String scaleSetName) {

        return elastigroupClient.importGroupFromScaleSet(resourceGroupName, scaleSetName);
    }

    private static void createVmSignal(SpotinstElastigroupClientAzure elastigroupClient) {

        VmSignalAzure.Builder vmSignalBuilder = VmSignalAzure.Builder.get();
        VmSignalAzure vmSignal =
                vmSignalBuilder.setSignalType(ElastigroupVmSignalEnumAzure.vmReadyToShutdown)
                        .setVmName("vm-aac01a6bcaad").build();

        CreateVmSignalRequestAzure.Builder vmSignalCreationRequestBuilder =
                CreateVmSignalRequestAzure.Builder.get();
        CreateVmSignalRequestAzure creationRequest =
                vmSignalCreationRequestBuilder.setVmSignalAzure(vmSignal).build();

        Boolean updateSuccess = elastigroupClient.createVmSignal(creationRequest);
        if (updateSuccess) {
            System.out.println("Vm Signal Successfully created.");
        }
    }

    public static UpdateCapacityAzure updateCapacity(SpotinstElastigroupClientAzure elastigroupClient, String groupId) {

        UpdateCapacityAzure.Builder groupCapacityBuilder = UpdateCapacityAzure.Builder.get();
        UpdateCapacityAzure updateCapacity = groupCapacityBuilder.setMaximum(3).setMinimum(1).setTarget(2)
                .build();


        UpdateCapacityRequestAzure.Builder capacityRequestBuilder =
                UpdateCapacityRequestAzure.Builder.get();
        UpdateCapacityRequestAzure capacityUpdateRequest =
                capacityRequestBuilder.setGroupId(groupId).setCapacityAzure(updateCapacity).build();

        return elastigroupClient.updateCapacity(capacityUpdateRequest);
    }

    public static List<VmHealthinessAzure> vmHealthiness(SpotinstElastigroupClientAzure elastigroupClient, String groupId) {

        return elastigroupClient.vmHealthiness(groupId);
    }

    public static void suspendGroup(SpotinstElastigroupClientAzure elastigroupClient, String groupId) {
        SuspendGroupProcessesAzure.Builder suspendgroupBuilder = SuspendGroupProcessesAzure.Builder.get();
        SuspendGroupProcessesAzure suspendProcessRequest = suspendgroupBuilder.setName(ProcessNameEnumsAzure.autoHealing)
                .setTtlInMinutes(120)
                .build();
        List<SuspendGroupProcessesAzure> suspendProcess = new ArrayList<>();
        suspendProcess.add(suspendProcessRequest);
        SuspendgroupRequestAzure.Builder requestBuilder = SuspendgroupRequestAzure.Builder.get();
        SuspendgroupRequestAzure suspendGroupRequest = requestBuilder.setSuspendGroup(suspendProcess)
                .setGroupId(groupId).build();

        Boolean suspended = elastigroupClient.suspendGroup(suspendGroupRequest);
        if (suspended) {
            System.out.println("Group Process suspended Successfully.");
        }
    }

    public static void resumeGroup(SpotinstElastigroupClientAzure elastigroupClient, String groupId) {
        ResumeGroupProcessesAzure.Builder resumegroupBuilder = ResumeGroupProcessesAzure.Builder.get();
        ResumeGroupProcessesAzure resumeProcessRequest = resumegroupBuilder.setName(ProcessNameEnumsAzure.autoHealing)
                .build();
        List<ResumeGroupProcessesAzure> resumeProcess = new ArrayList<>();
        resumeProcess.add(resumeProcessRequest);
        ResumegroupRequestAzure.Builder requestBuilder = ResumegroupRequestAzure.Builder.get();
        ResumegroupRequestAzure resumeGroupRequest = requestBuilder.setResumeGroup(resumeProcess)
                .setGroupId(groupId).build();

        Boolean resumed = elastigroupClient.resumeGroup(resumeGroupRequest );
        if (resumed) {
            System.out.println("Group Process resumed Successfully.");
        }
    }

    public static void vmProtection(SpotinstElastigroupClientAzure elastigroupClient, String groupId) {
        GetElastigroupStatusResponseAzure groupStatus = elastigroupClient.getGroupStatus(groupId);
        String vmName = groupStatus.getVms().get(0).getVmName();
        Boolean vmProtected = elastigroupClient.vmProtection(groupId, vmName, 180);
        if (vmProtected) {
            System.out.println("Virtual Machine is Protected Successfully.");
        }
    }

    public static void removeVmProtection(SpotinstElastigroupClientAzure elastigroupClient, String groupId, String vmName) {

        Boolean vmProtectedRemoved = elastigroupClient.vmRemoveProtection(groupId, vmName);
        if (vmProtectedRemoved) {
            System.out.println("Virtual Machine is Protection Removed Successfully.");
        }
    }

    public static ElastigroupAzure importFromVm(SpotinstElastigroupClientAzure elastigroupClient) {

        return elastigroupClient
                .importGroupFromVirtalMachine("AutomationResourceGroup", vmName);
    }

    public static GetElastilogResponseAzure getElastiLog(SpotinstElastigroupClientAzure elastigroupClient, String groupId) {

        return elastigroupClient.getElastilog(groupId, "2021-10-08",
                1000, null,
                ElastigroupSeverityEnumAzure.INFO, "2021-10-23");
    }

    public static DetachVmsResponseAzure detachVms(SpotinstElastigroupClientAzure elastigroupClient, String groupId) {
        DetachVmsAzure.Builder detachVmBuilder = DetachVmsAzure.Builder.get();
        DetachVmsAzure detachVmAzure = detachVmBuilder.setDrainingTimeout(300)
                .setShouldDecrementTargetCapacity(false)
                .setShouldTerminateVms(true)
                .setVmsToDetach(vmList)
                .build();
        DetachVmsRequestAzure.Builder detachVmRequestBuilder = DetachVmsRequestAzure.Builder.get();
        DetachVmsRequestAzure detachVmsRequest = detachVmRequestBuilder.setGroupId(groupId).setDetachVms(detachVmAzure)
                .build();

        return elastigroupClient.detachVms(detachVmsRequest);
    }
}



