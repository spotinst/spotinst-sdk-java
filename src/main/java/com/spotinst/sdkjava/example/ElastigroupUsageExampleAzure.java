package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.LoadBalancersConfigAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ElastigroupUsageExampleAzure {
    private final static String auth_token    = "your-token";
    private final static String act_id        = "your-account-id";
    private final static String key_pair_name = "some-key-pair-name";

    private static final String SPOTINST_TEST_GROUP_NAME = "SpotinstTestJavaSDKGroup";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        SpotinstElastigroupClientAzure elastigroupClient = SpotinstClient.getElastigroupClientAzure(auth_token, act_id);

        // Create group
        String elastigroupId = createGroup(elastigroupClient);

        // Get all Elastigroups
        getAllElastigroupsFilteredByDate(elastigroupClient);
        getAllElastigroupsFilteredByName(elastigroupClient);

        // Get subscription service client
        SpotinstSubscriptionClient subscriptionClient = SpotinstClient.getSubscriptionClient(auth_token, act_id);

        // Update group
        updateGroup(elastigroupClient, elastigroupId);

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 45 seconds.");
        sleep(100);

        // Delete elastigroup
        deleteElastigroup(elastigroupClient, elastigroupId);
    }

    private static void getInstanceHealthiness(SpotinstElastigroupClient elastigroupClient, String elastigroupId) {
        ElastigroupGetInstanceHealthinessRequest.Builder instanceHealthinessRequestBuilder =
                ElastigroupGetInstanceHealthinessRequest.Builder.get();

        ElastigroupGetInstanceHealthinessRequest instanceHealthinessRequest =
                instanceHealthinessRequestBuilder.setElastigroupId(elastigroupId).build();
        List<ElastigroupInstanceHealthiness> elastigroupInstanceHealthinesses =
                elastigroupClient.getInstanceHealthiness(instanceHealthinessRequest);

        List<String> healthyInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                   instance.getHealthStatus() ==
                                                                                                   InstanceHealthStatusEnum.HEALTHY)
                                                                          .map(ElastigroupInstanceHealthiness::getInstanceId)
                                                                          .collect(Collectors.toList());

        List<String> unhealthyInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                     instance.getHealthStatus() ==
                                                                                                     InstanceHealthStatusEnum.UNHEALTHY)
                                                                            .map(ElastigroupInstanceHealthiness::getInstanceId)
                                                                            .collect(Collectors.toList());

        List<String> insufficientDataInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                            instance.getHealthStatus() ==
                                                                                                            InstanceHealthStatusEnum.INSUFFICIENT_DATA)
                                                                                   .map(ElastigroupInstanceHealthiness::getInstanceId)
                                                                                   .collect(Collectors.toList());

        List<String> unknownHealthInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                         instance.getHealthStatus() ==
                                                                                                         InstanceHealthStatusEnum.UNKNOWN)
                                                                                .map(ElastigroupInstanceHealthiness::getInstanceId)
                                                                                .collect(Collectors.toList());

        System.out.println(String.format("%s Healthy instances: %s", healthyInstanceIds.size(), healthyInstanceIds));
        System.out.println(
                String.format("%s Unhealthy instances: %s", unhealthyInstanceIds.size(), unhealthyInstanceIds));
        System.out.println(
                String.format("%s Instances with insufficient healthiness data: %s", insufficientDataInstanceIds.size(),
                              insufficientDataInstanceIds));
        System.out.println(String.format("%s Instances with unknown ElastigroupHealthConfigurationAzure: %s",
                                         unknownHealthInstanceIds.size(), unknownHealthInstanceIds));
    }

    private static List<ElastigroupAzure> getAllElastigroupsFilteredByName(SpotinstElastigroupClientAzure client) {

        ElastigroupGetAllRequestAzure.Builder requestBuilder = ElastigroupGetAllRequestAzure.Builder.get();
        ElastigroupGetAllRequestAzure         requestByName  = requestBuilder.setName(SPOTINST_TEST_GROUP_NAME).build();

        return client.getAllElastigroups(requestByName);
    }

    private static List<ElastigroupAzure> getAllElastigroupsFilteredByDate(SpotinstElastigroupClientAzure client) {
        Date     activeTo = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date activeFrom = calendar.getTime();

        ElastigroupGetAllRequestAzure.Builder requestBuilder = ElastigroupGetAllRequestAzure.Builder.get();
        ElastigroupGetAllRequestAzure requestByDates =
                requestBuilder.setActiveFrom(activeFrom).setActiveTo(activeTo).build();

        return client.getAllElastigroups(requestByDates);
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

    private static String createGroup(SpotinstElastigroupClientAzure client) {
        // Build group launch spec
        ElastigroupLaunchSpecificationAzure.Builder launchSpecBuilder =
                ElastigroupLaunchSpecificationAzure.Builder.get();

        MarketplaceAzure.Builder marketplaceBuilder = MarketplaceAzure.Builder.get();

        MarketplaceAzure marketplace =
                marketplaceBuilder.setVersion("latest").setSku("18.04-LTS").setPublisher("Canonical")
                                  .setOffer("UbuntuServer").build();
        List<MarketplaceAzure> marketplaceAzureList = new ArrayList<>();
        marketplaceAzureList.add(marketplace);

        ImageSpecAzure.Builder imageSpecBuilder = ImageSpecAzure.Builder.get();

        ImageSpecAzure imageSpecAzure = imageSpecBuilder.setMarketplace(marketplaceAzureList).build();

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

        NetworkAzure network = networkBuilder.setResourceGroupName("AutomationResourceGroup_SDK")
                                             .setVirtualNetworkName("automationVN_SDK")
                                             .setNetworkInterfaces(networkInterfaceAzuresList).build();
        List<NetworkAzure> networkAzureList = new ArrayList<>();
        networkAzureList.add(network);

        //build tags
        TagAzure.Builder tagsBuilder = TagAzure.Builder.get();

        TagAzure tag1 = tagsBuilder.setTagKey("creator").setTagValue("automation@spotinst.com").build();
        TagAzure tag2 = tagsBuilder.setTagKey("name").setTagValue("automation").build();

        List<TagAzure> tagsList = new ArrayList<>();
        tagsList.add(tag1);
        tagsList.add(tag2);

        //build login
        LoginAzure.Builder loginBuilder = LoginAzure.Builder.get();
        String ssh =
                "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDKskc6QhEyuwpMnZQR3N4bbwFQGRiXhnVcdqptshD4fyymGsLWSgY8lWzNlBFbIV/Y6DeCZIvIQxdguhW53r2EbDqb4qgP4dli2AHgDuO8TE6ldHC8+IPz4OF28Jed2H+hVsUtL6MuUtM2habYEz4pKTLTUoA8wMr8ORDpKCjeUTG+ggnhUgrhpkKoQNLa54GshcAkdOuXepEGDvqu07x35QmpdWNdB9TZj2V0fvdSMdl+Eg0n52OjYE1mFoxpB93SPUpOKZoUQtRq4kl5sfbkIVybrwuMNPrPeInP9ct0BaItWudSN1mhZ3grjBcjEEYUJn98mEmVFirkxKw0UZvj nir.cohen@nircohen.local";

        LoginAzure login = loginBuilder.setUserName("test").setSshPublicKey(ssh).build();

        List<LoginAzure> loginList = new ArrayList<>();
        loginList.add(login);


        ElastigroupLaunchSpecificationAzure launchSpec =
                launchSpecBuilder.setImage(imageSpecAzure).setNetwork(networkAzureList).setLogin(loginList)
                                 .setTags(tagsList).build();


        //buildVmSizes
        List<String> odSizesAzureList = new ArrayList<>();
        odSizesAzureList.add("standard_a1_v2");
        List<String> spotSizesAzureList = new ArrayList<>();
        spotSizesAzureList.add("standard_a1_v2");

        ElastigroupVmSizesAzure.Builder vmSizesAzureBuilder = ElastigroupVmSizesAzure.Builder.get();

        ElastigroupVmSizesAzure vmSizesAzure =
                vmSizesAzureBuilder.setOdSizes(odSizesAzureList).setSpotSizes(spotSizesAzureList).build();

        List<ElastigroupVmSizesAzure> vmSizesAzureList = new ArrayList<>();
        vmSizesAzureList.add(vmSizesAzure);

        // Build group compute
        ElastigroupComputeConfigurationAzure.Builder computeBuilder =
                ElastigroupComputeConfigurationAzure.Builder.get();
        ElastigroupComputeConfigurationAzure compute =
                computeBuilder.setOs("Linux").setLaunchSpecification(launchSpec).setVmSizes(vmSizesAzureList).build();


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
                elastigroupBuilder.setName("Automation Group_SDK").setResourceGroupName("AutomationResourceGroup_SDK")
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


    private static void updateGroup(SpotinstElastigroupClientAzure client, String elastigroupId) {
        //Create group update
        ElastigroupCapacityConfigurationAzure.Builder updateCapacityBuilder =
                ElastigroupCapacityConfigurationAzure.Builder.get();
        ElastigroupCapacityConfigurationAzure updateCapacity =
                updateCapacityBuilder.setMinimum(0).setTarget(0).setMaximum(0).build();

        // Build elastigroup update
        ElastigroupAzure.Builder updateElastigroupBuilder = ElastigroupAzure.Builder.get();
        ElastigroupAzure elastigroupUpdate =
                updateElastigroupBuilder.setCapacity(updateCapacity).setName("SpotinstTestGroupU1").build();

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
            System.out.println("Group successfully updated.");
        }
    }
    private static void deleteElastigroup(SpotinstElastigroupClientAzure client, String elastigroupId) {
        ElastigroupDeletionRequestAzure.Builder deletionBuilder = ElastigroupDeletionRequestAzure.Builder.get();
        ElastigroupDeletionRequestAzure         deletionRequest = deletionBuilder.setElastigroupId(elastigroupId).build();

        Boolean successfulDeletion = client.deleteElastigroup(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Elastigroup succesfully deleted: " + elastigroupId);
        }
    }
}


