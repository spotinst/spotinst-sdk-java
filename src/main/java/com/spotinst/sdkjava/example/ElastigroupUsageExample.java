package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.ElastigroupOrientationEnum;
import com.spotinst.sdkjava.enums.SubscriptionEventTypeEnum;
import com.spotinst.sdkjava.enums.SubscriptionProtocolEnum;
import com.spotinst.sdkjava.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElastigroupUsageExample {
    private final static String auth_token = "your-token";
    private final static String act_id     = "your-account-id";
    private final static String key_pair_name = "some-key-pair-name";

    public static void main(String[] args) throws IOException {

        // Get elastigroup service client
        SpotinstElastigroupClient elastigroupClient = SpotinstClient.getElastigroupClient(auth_token, act_id);

        // Create group
        String elastigroupId = createGroup(elastigroupClient);

        // Get subscription service client
        SpotinstSubscriptionClient subscriptionClient = SpotinstClient.getSubscriptionClient(auth_token, act_id);

        // Create subscription (Launch)
        String createdLaunchSubscriptionId = createSubscription(elastigroupId, subscriptionClient,
                                                                SubscriptionEventTypeEnum.AWS_EC2_INSTANCE_LAUNCH);

        // Create subscription (Terminate)
        String createdTerminateSubscriptionId = createSubscription(elastigroupId, subscriptionClient,
                                                                   SubscriptionEventTypeEnum.AWS_EC2_INSTANCE_TERMINATE);

        // Get subscription (Launch)
        getSubscription(subscriptionClient, createdLaunchSubscriptionId);

        // Get subscription (Terminate)
        getSubscription(subscriptionClient, createdTerminateSubscriptionId);

        // Update group
        updateGroup(elastigroupClient, elastigroupId);

        // Scale Up
        scaleUpGroup(elastigroupClient, elastigroupId);

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 45 seconds.");
        sleep(100);

        // Retrieve active instances
        List<String> activeInstanceIds = getActiveInstances(elastigroupClient, elastigroupId);

        // Detach active instances
        detachInstances(elastigroupClient, elastigroupId, activeInstanceIds);

        // Delete subscription (Launch)
        deleteSubscription(subscriptionClient, createdLaunchSubscriptionId);

        // Delete subscription (Terminate)
        deleteSubscription(subscriptionClient, createdTerminateSubscriptionId);

        // Delete elastigroup
        deleteElastigroup(elastigroupClient, elastigroupId);
    }

    private static void scaleUpGroup(SpotinstElastigroupClient elastigroupClient, String elastigroupId) {
        ElastigroupScalingRequest.Builder scalingRequestBuilder      = ElastigroupScalingRequest.Builder.get();
        ElastigroupScalingRequest         scalingRequest             =
                scalingRequestBuilder.setElastigroupId(elastigroupId).setAdjustment(1).build();
        ElastigroupScalingResponse        elastigroupScalingResponse = elastigroupClient.scaleGroupUp(scalingRequest);
        System.out.println(elastigroupScalingResponse.getNewInstances());
        System.out.println(elastigroupScalingResponse.getNewSpotRequests());
    }

    private static String createSubscription(String elastigroupId, SpotinstSubscriptionClient subscriptionClient,
                                             SubscriptionEventTypeEnum eventType) {
        // Subscribe to termination event

        Subscription.Builder subscriptionBuilder = Subscription.Builder.get();
        Subscription terminationSub =
                subscriptionBuilder.setEndpoint("demo@spotinst.com").setProtocol(SubscriptionProtocolEnum.EMAIL)
                                   .setResourceId(elastigroupId).setEventType(eventType).build();

        SubscriptionCreationRequest.Builder subCreationRequestBuilder = SubscriptionCreationRequest.Builder.get();
        SubscriptionCreationRequest         subCreationRequest        =
                subCreationRequestBuilder.setSubscription(terminationSub).build();

        // Print Subscription creation request
        System.out.println(subCreationRequest.toJson());

        // Create Subscription
        Subscription createdSubscription = subscriptionClient.subscribeToEvent(subCreationRequest);

        // Subscription Id
        String createdSubscriptionId = createdSubscription.getId();

        // Print subscription Id
        System.out.println("Subscription Created succesfully! ID : " + createdSubscriptionId);
        return createdSubscriptionId;
    }

    private static void deleteSubscription(SpotinstSubscriptionClient subscriptionClient,
                                           String createdSubscriptionId) {
        // Delete Retrieved event
        SubscriptionDeletionRequest.Builder subDelBuilder = SubscriptionDeletionRequest.Builder.get();
        SubscriptionDeletionRequest         subDelRequest =
                subDelBuilder.setSubscriptionId(createdSubscriptionId).build();

        Boolean deletionSuccess = subscriptionClient.deleteSubscription(subDelRequest);
        if (deletionSuccess) {
            System.out.println("Successfully deleted subscription" + createdSubscriptionId + " in database.");
        }
        else {
            System.out.println("Failed in deleting subscription" + createdSubscriptionId + " in database.");
        }
    }

    private static void getSubscription(SpotinstSubscriptionClient subscriptionClient, String createdSubscriptionId) {
        // Get Subscription
        SubscriptionGetRequest.Builder subscriptionGetRequestBuilder = SubscriptionGetRequest.Builder.get();
        SubscriptionGetRequest         subGetRequest                 =
                subscriptionGetRequestBuilder.setSubscriptionId(createdSubscriptionId).build();

        Subscription subscriptionEvent = subscriptionClient.getSubscriptionEvent(subGetRequest);

        // Print Retrieved event
        System.out.println(
                "Retrieving event resulted in : " + subscriptionEvent.getId() + " " + subscriptionEvent.getProtocol() +
                " " + subscriptionEvent.getEndpoint() + " " + subscriptionEvent.getResourceId() + " " +
                subscriptionEvent.getEventType());
    }

    private static void deleteElastigroup(SpotinstElastigroupClient client, String elastigroupId) {
        ElastigroupDeletionRequest.Builder deletionBuilder = ElastigroupDeletionRequest.Builder.get();
        ElastigroupDeletionRequest         deletionRequest = deletionBuilder.setElastigroupId(elastigroupId).build();

        Boolean successfulDeletion = client.deleteElastigroup(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Elastigroup succesfully deleted: " + elastigroupId);
        }
    }

    private static void detachInstances(SpotinstElastigroupClient client, String elastigroupId,
                                        List<String> activeInstanceIds) {
        // Create detach request
        ElastigroupDetachInstancesRequest.Builder elastigroupDetachInstancesRequestBuilder =
                ElastigroupDetachInstancesRequest.Builder.get();
        ElastigroupDetachInstancesRequest         detachRequest                            =
                elastigroupDetachInstancesRequestBuilder.setInstancesToDetach(activeInstanceIds)
                                                        .setShouldTerminateInstances(true)
                                                        .setShouldDecrementTargetCapacity(true).setDrainingTimeout(0)
                                                        .build();

        // Convert detach request to API object json
        System.out.println(detachRequest.toJson());

        // Execute detachment
        Boolean succesfulDetachment = client.detachInstances(detachRequest, elastigroupId);
        if (succesfulDetachment) {
            System.out.println(String.format("Successfully detached instances from %s", elastigroupId));
        }
    }

    private static List<String> getActiveInstances(SpotinstElastigroupClient client, String elastigroupId) {
        ElastigroupGetActiveInstancesRequest.Builder getActiveInstancesBuilder =
                ElastigroupGetActiveInstancesRequest.Builder.get();
        ElastigroupGetActiveInstancesRequest         getActiveInstancesRequest =
                getActiveInstancesBuilder.setElastigroupId(elastigroupId).build();

        List<ElastigroupActiveInstance> activeInstances = client.getActiveInstances(getActiveInstancesRequest);
        List<String> activeInstanceIds =
                activeInstances.stream().map(ElastigroupActiveInstance::getInstanceId).collect(Collectors.toList());
        System.out.println(activeInstanceIds);
        return activeInstanceIds;
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

    private static String createGroup(SpotinstElastigroupClient client) {
        // Build group instance types
        ElastigroupInstanceTypes.Builder instanceTypesBuilder = ElastigroupInstanceTypes.Builder.get();
        List<String>                     spotTypes            = new ArrayList<>();
        spotTypes.add("c3.large");
        ElastigroupInstanceTypes instanceTypes =
                instanceTypesBuilder.setOnDemandType("c3.large").setSpotTypes(spotTypes).build();

        // Build group availability Zones
        Placement.Builder placementBuilder = Placement.Builder.get();
        List<String>      subnetIds        = new ArrayList<>();
        subnetIds.add("subnet-79da021e");
        Placement            placement  =
                placementBuilder.setAvailabilityZoneName("us-west-2a").setSubnetIds(subnetIds).build();
        ArrayList<Placement> placements = new ArrayList<>();
        placements.add(placement);

        // Build group launch spec
        ElastigroupLaunchSpecification.Builder launchSpecBuilder = ElastigroupLaunchSpecification.Builder.get();
        List<String>                           securityGroupIds  = new ArrayList<>();
        securityGroupIds.add("sg-46cdc13d");
        ElastigroupLaunchSpecification launchSpec =
                launchSpecBuilder.setSecurityGroupIds(securityGroupIds).setImageId("ami-f173cc91")
                                 .setKeyPair(key_pair_name).setDetailedMonitoring(true).build();

        // Build group compute
        ElastigroupComputeConfiguration.Builder computeBuilder = ElastigroupComputeConfiguration.Builder.get();
        ElastigroupComputeConfiguration         compute        =
                computeBuilder.setInstanceTypes(instanceTypes).setProduct("Linux/UNIX")
                              .setLaunchSpecification(launchSpec).setAvailabilityZones(placements).build();

        // Build group strategy
        ElastigroupStrategyConfiguration.Builder strategyBuilder = ElastigroupStrategyConfiguration.Builder.get();
        ElastigroupStrategyConfiguration strategy =
                strategyBuilder.setElastigroupOrientation(ElastigroupOrientationEnum.COST_ORIENTED)
                               .setFallbackToOnDemand(true).setUtilizeReservedInstances(false).setSpotPercentage(100)
                               .build();

        //Build group capacity
        ElastigroupCapacityConfiguration.Builder capacityBuilder = ElastigroupCapacityConfiguration.Builder.get();
        ElastigroupCapacityConfiguration         capacity        =
                capacityBuilder.setMinimum(0).setMaximum(0).setTarget(0).build();

        //build group third party integration ECS



        // Build elastigroup
        Elastigroup.Builder elastigroupBuilder = Elastigroup.Builder.get();
        Elastigroup         elastigroup        =
                elastigroupBuilder.setName("SpotinstTestGroup").setDescription("descriptive-information")
                                  .setStrategy(strategy).setCapacity(capacity).setCompute(compute).build();

        // Build elastigroup creation request
        ElastigroupCreationRequest.Builder elastigroupCreationRequestBuilder = ElastigroupCreationRequest.Builder.get();
        ElastigroupCreationRequest         creationRequest                   =
                elastigroupCreationRequestBuilder.setElastigroup(elastigroup).build();

        // Convert elastigroup to API object json
        System.out.println(creationRequest.toJson());

        // Create elastigroup
        Elastigroup createdElastigroup = client.createElastigroup(creationRequest);
        System.out.println("Elastigroup succesfully created: " + createdElastigroup.getId());

        // Get elastigroup Id
        return createdElastigroup.getId();
    }

    private static void updateGroup(SpotinstElastigroupClient client, String elastigroupId) {
        //Create group update
        ElastigroupCapacityConfiguration.Builder updateCapacityBuilder = ElastigroupCapacityConfiguration.Builder.get();
        ElastigroupCapacityConfiguration         updateCapacity        =
                updateCapacityBuilder.setMinimum(0).setTarget(3).setMaximum(5).build();

        // Build elastigroup update
        Elastigroup.Builder updateElastigroupBuilder = Elastigroup.Builder.get();
        Elastigroup         elastigroupUpdate        =
                updateElastigroupBuilder.setCapacity(updateCapacity).setName("SpotinstTestGroupU1").build();

        // Build elastigroup update request
        ElastigroupUpdateRequest.Builder elastigroupUpdateRequestBuilder = ElastigroupUpdateRequest.Builder.get();
        ElastigroupUpdateRequest         updateRequest                   =
                elastigroupUpdateRequestBuilder.setElastigroup(elastigroupUpdate).build();

        // Convert elastigroup update to API object json
        System.out.println(updateRequest.toJson());

        // Update elastigroup
        Boolean updateSuccess = client.updateElastigroup(updateRequest, elastigroupId);
        if (updateSuccess) {
            System.out.println("Group successfully updated.");
        }
    }

}
