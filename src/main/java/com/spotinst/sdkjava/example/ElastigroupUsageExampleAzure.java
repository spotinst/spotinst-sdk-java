package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.DeploymentDetailsOverviewAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentAzure;
import com.spotinst.sdkjava.model.filters.SortFilter;

import java.io.IOException;
import java.util.*;

public class ElastigroupUsageExampleAzure {
        private final static String auth_token          = "Your-Spot-Token";
        private final static String act_id              = "act-XXXXXXXX";
        private final static String SSA                 = "Your SSH";
        private static final String SPOTINST_GROUP_NAME = "SpotinstJavaSDKGroup-Example";

    public static void main(String[] args) throws IOException {
        //        // Get elastigroup service client
        SpotinstElastigroupClientAzure elastigroupClient = SpotinstClient.getElastigroupClientAzure(auth_token, act_id);

        // Create group
        String elastigroupId = createElastigroup(elastigroupClient);

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 7 seconds.");
        sleep(7);
        // Update group
//        updateElastigroup(elastigroupClient, elastigroupId);

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // Get all Elastigroups
        getAllElastigroupsIncludeDeleted(elastigroupClient);

        // Create Deployment (Group should have > 0 VMs)
        GroupDeploymentAzure newlyCreatedDeployment = createDeployment(elastigroupClient, elastigroupId);

        // Get Deployment
        String               deploymentId        = newlyCreatedDeployment.getId();
        GroupDeploymentAzure retrievedDeployment = getDeployment(elastigroupClient, elastigroupId, deploymentId);

        // Get Deployment Details
        GroupDeploymentDetailsAzure deploymentDetails =
                getDeploymentDetails(elastigroupClient, elastigroupId, deploymentId);

        // List Deployments
        List<GroupDeploymentAzure> allDeployments = getAllDeployments(elastigroupClient, elastigroupId);

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
                networkInterfaceBuilder.setIsPrimary(true).setAssignPublicIp(false).setSubnetName("default")
                                       .setEnableIPForwarding(true)
                                       .setAdditionalIpConfigurations(additionalIpConfigurationsAzureList).build();

        List<NetworkInterfaceAzure> networkInterfaceAzuresList = new ArrayList<>();
        networkInterfaceAzuresList.add(networkInterfaceAzure);

        //build network
        NetworkAzure.Builder networkBuilder = NetworkAzure.Builder.get();

        NetworkAzure network =
                networkBuilder.setResourceGroupName("AutomationResourceGroup").setVirtualNetworkName("automationVN")
                              .setNetworkInterfaces(networkInterfaceAzuresList).build();


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
        String             ssh          = SSA;

        // it is recommended to set a unique username that isn't present in the "reserved usernames" pool
        LoginAzure login = loginBuilder.setUserName("notAReservedUserName").setSshPublicKey(ssh).build();


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
                               .setOptimizationWindows(optimizationTimeList).setRevertToSpot(reveertToSpot).build();

        //Build group capacity
        ElastigroupCapacityConfigurationAzure.Builder capacityBuilder =
                ElastigroupCapacityConfigurationAzure.Builder.get();
        ElastigroupCapacityConfigurationAzure capacity =
                capacityBuilder.setMinimum(0).setMaximum(0).setTarget(0).build();


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
        System.out.println("Elastigroup succesfully created: " + createdElastigroup.getId());

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
        ElastigroupDeletionRequestAzure deletionRequest = deletionBuilder.setElastigroupId(elastigroupId).build();

        Boolean successfulDeletion = client.deleteElastigroup(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Elastigroup succesfully deleted: " + elastigroupId);
        }
    }

    private static List<ElastigroupAzure> getAllElastigroupsIncludeDeleted(SpotinstElastigroupClientAzure client) {

        ElastigroupGetAllRequestAzure.Builder requestBuilder = ElastigroupGetAllRequestAzure.Builder.get();
        ElastigroupGetAllRequestAzure requestByName =
                requestBuilder.setName(SPOTINST_GROUP_NAME).setIncludeDeleted(true).build();
        return client.getAllElastigroups(requestByName);
    }

    private static GroupDeploymentAzure createDeployment(SpotinstElastigroupClientAzure client, String elastigroupId) {

        GroupDeploymentCreationRequestAzure.Builder groupDeploymentRequestBuilder =
                GroupDeploymentCreationRequestAzure.Builder.get();
        GroupDeploymentCreationRequestAzure groupDeploymentRequest =
                groupDeploymentRequestBuilder.setBatchSizePercentage(50).setDrainingTimeout(20).setGracePeriod(300)
                                             .build();


        GroupDeploymentAzure createdDeployment        = client.createDeployment(groupDeploymentRequest, elastigroupId);
        String               cDeploymentId            = createdDeployment.getId();
        String               cDeploymentGroupId       = createdDeployment.getGroupId();
        String               cDeploymentProgressValue = createdDeployment.getProgress().getValue().toString();
        String               cDeploymentProgressUnit  = createdDeployment.getProgress().getUnit().getName();
        String preFormat = "deployment %s for group %s successfully created, progress: %s %s complete";
        System.out.println(String.format(preFormat, cDeploymentId, cDeploymentGroupId, cDeploymentProgressValue,
                                         cDeploymentProgressUnit));

        return createdDeployment;

    }

    private static List<GroupDeploymentAzure> getAllDeployments(SpotinstElastigroupClientAzure client, String groupId) {

        SortFilter filter = new SortFilter();
        filter.setLimit(20);
        filter.setSortField("createdAt");
        filter.setSortOrder(AscDescEnum.DESC);
        List<GroupDeploymentAzure> deployments = client.getAllDeployments(filter, groupId);
        System.out.println(String.format("found %s deployments with IDs:", deployments.size()));
        deployments.stream().map(GroupDeploymentAzure::getId).forEach(System.out::println);

        return deployments;
    }

    private static GroupDeploymentAzure getDeployment(SpotinstElastigroupClientAzure client, String groupId,
                                                      String deploymentId) {

        GroupDeploymentAzure deployment    = client.getDeployment(groupId, deploymentId);
        String               progressValue = deployment.getProgress().getValue().toString();
        String               progressUnit  = deployment.getProgress().getUnit().getName();
        String               status        = deployment.getStatus().getName();
        String               preFormat     = "deployment ID: %s - status: %s - progress: %s %s complete";
        System.out.println(String.format(preFormat, deploymentId, status, progressValue, progressUnit));
        return deployment;

    }

    private static GroupDeploymentDetailsAzure getDeploymentDetails(SpotinstElastigroupClientAzure client,
                                                                    String groupId, String deploymentId) {

        GroupDeploymentDetailsAzure    deploymentDetails = client.getDeploymentDetails(groupId, deploymentId);
        DeploymentDetailsOverviewAzure overview          = deploymentDetails.getDetailsOverview();
        String                         retDeploymentId   = overview.getDeploymentId();
        String                         blueInstances     = overview.getBlueInstances().toString();
        String                         greenInstances    = overview.getGreenInstances().toString();
        String                         currentBatch      = overview.getCurrentBatch().toString();
        String                         numOfBatches      = overview.getNumberOfBatches().toString();
        String                         preFormatted      =
                "Get deployment details: ID: %s, batches: %s out of %s complete, blue/green: %s/%s";
        System.out.println(String.format(preFormatted, retDeploymentId, currentBatch, numOfBatches, blueInstances,
                                         greenInstances));

        return deploymentDetails;
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
}



