package com.spotinst.sdkjava.example.elastigroup.aws;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.RecurrenceFrequencyEnum;
import com.spotinst.sdkjava.model.bl.admin.account.Subscription;
import com.spotinst.sdkjava.model.bl.admin.account.response.SubscriptionResponse;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;
import com.spotinst.sdkjava.model.requests.elastigroup.*;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.spotinst.sdkjava.enums.EventsLogsSeverityEnum.ALL;
import static com.spotinst.sdkjava.utils.Constants.*;

public class ElastigroupUsageExample {
    private final static String auth_token    = "your-token";
    private final static String act_id        = "your-account-id";
    private final static String instanceId        = "instance-id";
    private final static String key_pair_name = "some-key-pair-name";

    private static final String SPOTINST_TEST_GROUP_NAME = "SpotinstTestJavaSDKGroup";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        SpotinstElastigroupClient elastigroupClient = SpotinstClient.getElastigroupClient(auth_token, act_id);

        // Create group
        String elastigroupId = createGroup(elastigroupClient);

        // Enter Group Standby
        enterInstanceStandby(elastigroupClient, instanceId);

        // Exit Group Standby
        exitInstanceStandby(elastigroupClient, instanceId);

        // Clone group
        String clonedElastigroupId = cloneGroup(elastigroupClient, elastigroupId);

        // Delete Clone
        deleteElastigroup(elastigroupClient, clonedElastigroupId);

        // Get all Elastigroups
        getAllElastigroupsFilteredByDate(elastigroupClient);
        getAllElastigroupsFilteredByName(elastigroupClient);

        // Get subscription service client
        SpotinstSubscriptionClient subscriptionClient = SpotinstClient.getSubscriptionClient(auth_token, act_id);

        // Create subscription (Launch)
        String createdLaunchSubscriptionId = createSubscription(elastigroupId, subscriptionClient,
                                                                SubscriptionEventTypeEnum.AWS_EC2_INSTANCE_LAUNCH);

        // Get subscription (Launch)
        getSubscription(subscriptionClient, createdLaunchSubscriptionId);

        // Get All subscriptions
        getAllSubscriptionEvents(subscriptionClient);

        // Update group
        updateGroup(elastigroupClient, elastigroupId);

        // Detach Load Balancer
        detachLoadBalancer(elastigroupClient, elastigroupId);

        // Scale Up
        scaleUpGroup(elastigroupClient, elastigroupId);

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 100 seconds.");
        sleep(100);

        // Get instance healthiness
        getInstanceHealthiness(elastigroupClient, elastigroupId);

        // Retrieve active instances
        List<String> activeInstanceIds = getActiveInstances(elastigroupClient, elastigroupId);

        // Detach active instances
        detachInstances(elastigroupClient, elastigroupId, activeInstanceIds);

        // Delete subscription (Launch)
        deleteSubscription(subscriptionClient, createdLaunchSubscriptionId);

        // Update subscription
        updateSubscription(subscriptionClient, createdLaunchSubscriptionId);

        // Suspend AUTO_HEALING process
        SuspendedProcesses activeSuspensions =
                suspendProcess(elastigroupClient, elastigroupId, ProcessNameEnum.AUTO_HEALING);

        List<ProcessNameEnum> activeSuspensionNames =
                activeSuspensions.getSuspensions().stream().map(ProcessSuspensionResult::getName)
                                 .collect(Collectors.toList());

        // Remove all active suspensions
        removeSuspendedProcesses(elastigroupClient, activeSuspensions.getGroupId(), activeSuspensionNames);

        // Enter Instance Standby
        enterInstanceStandby(elastigroupClient, instanceId);

        // List suspended processes
        getSuspendedProcesses(elastigroupClient, elastigroupId);

        // Exit Group Standby
        exitInstanceStandby(elastigroupClient, instanceId);

        // Get Group Events Logs
        getEventsLogs(elastigroupClient, elastigroupId, LOGS_FROM_DATE_EXAMPLE, LOGS_TO_DATE_EXAMPLE, ALL, null,
                      LOGS_MAX_LIMIT);

        // Delete elastigroup
        deleteElastigroup(elastigroupClient, elastigroupId);

        // Get Deleted Elastigroup
        getAllElastigroupsIncludeDeleted(elastigroupClient);

        // Lock/Unlock Instance
        lockUnlockInstance(elastigroupClient, act_id, 5, "your-instance-id", "LOCK");
        lockUnlockInstance(elastigroupClient, act_id, 5, "your-instance-id", "UNLOCK");

        System.out.println("----------Suspend Specific Scaling Policy--------------");
        suspendScalingPolicies(elastigroupClient,"your-elastigroup-id","policy-name");

        System.out.println("----------List Suspended Scaling Policies--------------");
        getAllSuspendedScalingPolicies(elastigroupClient, "your-elastigroup-id");

        System.out.println("----------Remove/Resume Suspended Scaling Policy--------------");
        removeSuspendedScalingPolicies(elastigroupClient,"your-elastigroup-id","policy-name");

        System.out.println("----------Simulate Instance Interruption Example--------------");
        List<String> listOfInstances = Arrays.asList("i-0687d633ba59aad5f");
        interruptInstances(elastigroupClient, listOfInstances);

        //Start deployment
        System.out.println("----------Start Deployment--------------");
        String deploymentId = startDeployment(elastigroupClient, "elastigroup-id").getId();

        //Get Deployment Status
        System.out.println("----------Get Deployment Status--------------");
        getDeploymentStatus(elastigroupClient, "elastigroup-id", deploymentId);

        //Get group Deployment Staus
        System.out.println("----------Get Group Deployment Status--------------");
        getGroupDeploymentStatus(elastigroupClient, "elastigroup-id");

        //Stop deployment
        System.out.println("----------Stop Deployment--------------");
        stopDeployment(elastigroupClient, "elastigroup-id",deploymentId);

        //Get Deployment Action
        System.out.println("----------Apply Deployment Action to Deployment--------------");
        applyDeploymentAction(elastigroupClient, "elastigroup-id", deploymentId);

        //Get ITF migation Rules Status
        System.out.println("----------get ITF migration list--------------");
        getItfMigrationRulesStatus(elastigroupClient, "elastigroup-id");

        //Get ITF migation list
        System.out.println("----------retry ITF migration --------------");
        retryItfMigration(elastigroupClient, "elastigroup-id");

        //Get Elastilog
        System.out.println("----------Get Elastilog--------------");
        List<ElastigroupGetElastilogResponse> getLogs = getElastilog(elastigroupClient, act_id, "fromDate", "limit", "resourceId", "severity", "toDate", "elastigroupId");

        //Get Instance types by region
        System.out.println("----------Get Instance Types by region--------------");
        List<GetInstanceTypesResponse> getInstanceTypesByRegion = getInstanceTypesByRegion(elastigroupClient, "region");

        //Get suggested Instance types
        System.out.println("----------Get Suggested Instance Types--------------");
        List<GetInstanceTypesResponse> getSuggestedInstanceTypes = getSuggestedInstanceTypes(elastigroupClient);

        //Initiate Roll
        System.out.println("----------Initiate Roll--------------");
        ElastigroupEcsClusterRollResponse initiateRollResponse = initiateClusterRoll(elastigroupClient, "group-id", 25, "comment", true, 100);

        //Get cluster Roll
        System.out.println("----------Get cluster Roll--------------");
        ElastigroupEcsClusterRollResponse getClusterRollStatus = getClusterRoll (elastigroupClient, "group-id", "rollId");

        //List cluster Rolls
        System.out.println("----------List cluster Rolls--------------");
        List<ElastigroupEcsClusterRollResponse> listClusterRolls = getAllClusterRolls(elastigroupClient, "group-id");

        //Update cluster Roll
        System.out.println("----------Update cluster Roll--------------");
        ElastigroupEcsClusterRollResponse updateRollResponse = updateClusterRoll(elastigroupClient, "group-id", "STOPPED");

        //Create Instance Signal
        System.out.println("----------Create Instance Signal--------------");
        String signal = "INSTANCE_READY";
        Boolean createInstanceSignalStatus = createInstanceSignal(elastigroupClient, signal);

        // Get instance status
        System.out.println("----------Get Instance Status--------------");
        ElastigroupGetInstanceStatusResponse response = getInstanceStatus(elastigroupClient, instanceId);

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
        System.out.println(String.format("%s Instances with unknown health: %s", unknownHealthInstanceIds.size(),
                                         unknownHealthInstanceIds));
    }

    private static void scaleUpGroup(SpotinstElastigroupClient elastigroupClient, String elastigroupId) {
        ElastigroupScalingRequest.Builder scalingRequestBuilder = ElastigroupScalingRequest.Builder.get();
        ElastigroupScalingRequest scalingRequest =
                scalingRequestBuilder.setElastigroupId(elastigroupId).setAdjustment(1).build();
        ElastigroupScalingResponse elastigroupScalingResponse = elastigroupClient.scaleGroupUp(scalingRequest);
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

        // Create Subscription
        SubscriptionResponse createdSubscription = subscriptionClient.subscribeToEvent(terminationSub);

        // Subscription Id
        String createdSubscriptionId = createdSubscription.getId();

        // Print subscription Id
        System.out.println("Subscription Created succesfully! ID : " + createdSubscriptionId);
        return createdSubscriptionId;
    }

    private static void deleteSubscription(SpotinstSubscriptionClient subscriptionClient,
                                           String createdSubscriptionId) {

        Boolean deletionSuccess = subscriptionClient.deleteSubscription(createdSubscriptionId);
        if (deletionSuccess) {
            System.out.println("Successfully deleted subscription" + createdSubscriptionId + " in database.");
        }
        else {
            System.out.println("Failed in deleting subscription" + createdSubscriptionId + " in database.");
        }
    }

    private static void getSubscription(SpotinstSubscriptionClient subscriptionClient, String createdSubscriptionId) {

        SubscriptionResponse subscriptionEvent = subscriptionClient.getSubscriptionEvent(createdSubscriptionId);

        // Print Retrieved event
        System.out.println(
                "Retrieving event resulted in : " + subscriptionEvent.getId() + " " + subscriptionEvent.getProtocol() +
                " " + subscriptionEvent.getEndpoint() + " " + subscriptionEvent.getResourceId() + " " +
                subscriptionEvent.getEventType());
    }

    private static List<SubscriptionResponse> getAllSubscriptionEvents(SpotinstSubscriptionClient subscriptionClient) {

        return subscriptionClient.getAllSubscriptionEvents();
    }

    private static void updateSubscription(SpotinstSubscriptionClient subscriptionClient, String createdSubscriptionId) {

        Subscription.Builder subscriptionBuilder = Subscription.Builder.get();
        Subscription subscription = subscriptionBuilder.setEndpoint("test@spotinst.com").build();

        // Update Subscription
        Boolean updatedSubscription = subscriptionClient.updateSubscription(subscription, createdSubscriptionId);

        if (updatedSubscription) {
            System.out.println("Successfully updated subscription" + createdSubscriptionId + " in database.");
        }
        else {
            System.out.println("Failed in update subscription" + createdSubscriptionId + " in database.");
        }
    }

    private static void deleteElastigroup(SpotinstElastigroupClient client, String elastigroupId) {
        StatefulDeallocationConfig.Builder deallocationConfigBuilder = StatefulDeallocationConfig.Builder.get();
        StatefulDeallocationConfig         deallocationConfig        =
                deallocationConfigBuilder.setShouldDeleteVolumes(true).build();

        AmiBackupConfig.Builder amiBackupConfigBuilder = AmiBackupConfig.Builder.get();
        AmiBackupConfig         amiBackup              = amiBackupConfigBuilder.setShouldDeleteImages(true).build();

        ApiDeleteGroupRequest.Builder deleteRequestBuilder = ApiDeleteGroupRequest.Builder.get();
        ApiDeleteGroupRequest deleteRequest =
                deleteRequestBuilder.setStatefulDeallocation(deallocationConfig).setAmiBackup(amiBackup).build();

        ElastigroupDeletionRequest.Builder deletionBuilder = ElastigroupDeletionRequest.Builder.get();
        ElastigroupDeletionRequest deletionRequest =
                deletionBuilder.setElastigroupId(elastigroupId).setDeleteRequest(deleteRequest).build();

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
        ElastigroupDetachInstancesRequest detachRequest =
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

    private static List<Elastigroup> getAllElastigroupsFilteredByName(SpotinstElastigroupClient client) {

        ElastigroupGetAllRequest.Builder requestBuilder = ElastigroupGetAllRequest.Builder.get();
        ElastigroupGetAllRequest         requestByName  = requestBuilder.setName(SPOTINST_TEST_GROUP_NAME).build();

        return client.getAllElastigroups(requestByName);
    }

    private static List<Elastigroup> getAllElastigroupsFilteredByDate(SpotinstElastigroupClient client) {
        Date     activeTo = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date activeFrom = calendar.getTime();

        ElastigroupGetAllRequest.Builder requestBuilder = ElastigroupGetAllRequest.Builder.get();
        ElastigroupGetAllRequest requestByDates =
                requestBuilder.setActiveFrom(activeFrom).setActiveTo(activeTo).build();

        return client.getAllElastigroups(requestByDates);
    }

    private static List<Elastigroup> getAllElastigroupsIncludeDeleted(SpotinstElastigroupClient client) {

        ElastigroupGetAllRequest.Builder requestBuilder = ElastigroupGetAllRequest.Builder.get();
        ElastigroupGetAllRequest requestByName =
                requestBuilder.setName(SPOTINST_TEST_GROUP_NAME).setIncludeDeleted(true).build();

        return client.getAllElastigroups(requestByName);
    }

    private static List<String> getActiveInstances(SpotinstElastigroupClient client, String elastigroupId) {
        ElastigroupGetActiveInstancesRequest.Builder getActiveInstancesBuilder =
                ElastigroupGetActiveInstancesRequest.Builder.get();
        ElastigroupGetActiveInstancesRequest getActiveInstancesRequest =
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
        ArrayList<Placement> placements        = new ArrayList<>();
        Placement.Builder    placementBuilder1 = Placement.Builder.get();
        Placement.Builder    placementBuilder2 = Placement.Builder.get();
        List<String>         subnetIds         = new ArrayList<>();
        subnetIds.add("subnet-020cf6648937b2272");
        Placement placement = placementBuilder1.setAvailabilityZoneName("us-west-2a").setSubnetIds(subnetIds).build();
        placements.add(placement);
        List<String> subnets2 = new LinkedList<>();
        subnets2.add("subnet-01972f2531cb1ca4b");
        Placement placement2 = placementBuilder2.setAvailabilityZoneName("us-west-2b").setSubnetIds(subnets2).build();
        placements.add(placement2);

        //Build Load Balancer Config
        LoadBalancersConfig.Builder loadBalancerConfigBuilder = LoadBalancersConfig.Builder.get();
        LoadBalancer.Builder        lbBuilder                 = LoadBalancer.Builder.get();
        LoadBalancer loadBalancer = lbBuilder.setType(LbTypeEnum.CLASSIC).setName("spotapp-dev-v1").build();
        LoadBalancersConfig loadBalancersConfig =
                loadBalancerConfigBuilder.setLoadBalancers(Collections.singletonList(loadBalancer)).build();


        //Build Resource Tag Spec
        GroupTagSpecification volumes = new GroupTagSpecification();
        volumes.setShouldTag(true);
        GroupTagSpecification amis = new GroupTagSpecification();
        amis.setShouldTag(true);
        GroupTagSpecification enis = new GroupTagSpecification();
        enis.setShouldTag(true);
        GroupTagSpecification snapshots = new GroupTagSpecification();
        snapshots.setShouldTag(true);

        GroupResourceTagSpecification.Builder resourceTagSpecBuilder = GroupResourceTagSpecification.Builder.get();
        GroupResourceTagSpecification resourceTagSpecification =
                resourceTagSpecBuilder.setTagAmis(amis).setTagEnis(enis).setTagSnapshot(snapshots).setTagVolume(volumes)
                                      .build();
        // Build group launch spec
        ElastigroupLaunchSpecification.Builder launchSpecBuilder = ElastigroupLaunchSpecification.Builder.get();
        List<String>                           securityGroupIds  = new ArrayList<>();
        securityGroupIds.add("sg-060d199c638390fa1");
        ElastigroupLaunchSpecification launchSpec =
                launchSpecBuilder.setSecurityGroupIds(securityGroupIds).setImageId("ami-28e07e50")
                                 .setKeyPair(key_pair_name).setDetailedMonitoring(true)
                                 .setLoadBalancersConfig(loadBalancersConfig)
                                 .setResourceTagSpecification(resourceTagSpecification).build();

        // Build group compute
        ElastigroupComputeConfiguration.Builder computeBuilder = ElastigroupComputeConfiguration.Builder.get();
        ElastigroupComputeConfiguration compute =
                computeBuilder.setInstanceTypes(instanceTypes).setProduct("Linux/UNIX")
                              .setLaunchSpecification(launchSpec).setAvailabilityZones(placements).build();

        // Build group Target Scaling policies
        PredictiveScale.Builder predictiveScaleBuilder1 = PredictiveScale.Builder.get();
        PredictiveScale         predictiveScale1        =
                predictiveScaleBuilder1.setMode(ScalingPredictiveModeEnum.FORECAST_ONLY).build();

        ScalingPolicy.Builder   scalingPolicyBuilder1   = ScalingPolicy.Builder.get();
        ScalingPolicy           scalingPolicy1          =
                scalingPolicyBuilder1.setPolicyName("target Scaling Policy 1").setMetricName("CPUUtilization")
                                     .setNamespace("AWS/EC2").setCooldown(300).setStatistic("average")
                                     .setUnit("percent").setTarget(50).setPredictive(predictiveScale1).build();

        PredictiveScale.Builder predictiveScaleBuilder2 = PredictiveScale.Builder.get();
        PredictiveScale         predictiveScale2        =
                predictiveScaleBuilder2.setMode(ScalingPredictiveModeEnum.FORECAST_AND_SCALE).build();

        ScalingPolicy.Builder   scalingPolicyBuilder2   = ScalingPolicy.Builder.get();
        ScalingPolicy           scalingPolicy2          =
                scalingPolicyBuilder2.setPolicyName("target Scaling Policy 2").setMetricName("CPUUtilization")
                                     .setNamespace("AWS/EC2").setCooldown(300).setStatistic("average").setUnit("bytes")
                                     .setTarget(500).setPredictive(predictiveScale2).build();

        List<ScalingPolicy> targetScalingPolicies = new ArrayList<>();
        targetScalingPolicies.add(scalingPolicy1);
        targetScalingPolicies.add(scalingPolicy2);

        // Build group scaling
        ElastigroupScalingConfiguration.Builder scalingBuilder = ElastigroupScalingConfiguration.Builder.get();
        ElastigroupScalingConfiguration         scaling        =
                scalingBuilder.setTarget(targetScalingPolicies).build();

        // Build group strategy persistence
        ElastigroupPersistenceConfiguration.Builder persistenceBuilder =
                ElastigroupPersistenceConfiguration.Builder.get();
        ElastigroupPersistenceConfiguration persistence =
                persistenceBuilder.setBlockDevicesMode("reattach").setShouldPersistBlockDevices(true)
                                  .setShouldPersistRootDevice(true).build();

        // Build group strategy
        ElastigroupStrategyConfiguration.Builder strategyBuilder = ElastigroupStrategyConfiguration.Builder.get();
        ElastigroupStrategyConfiguration strategy =
                strategyBuilder.setElastigroupOrientation(ElastigroupOrientationEnum.COST_ORIENTED)
                               .setFallbackToOnDemand(true).setUtilizeReservedInstances(false).setSpotPercentage(100)
                               .setPersistence(persistence).setConsiderODPricing(true).build();

        //Build group capacity
        ElastigroupCapacityConfiguration.Builder capacityBuilder = ElastigroupCapacityConfiguration.Builder.get();
        ElastigroupCapacityConfiguration capacity = capacityBuilder.setMinimum(0).setMaximum(1).setTarget(1).build();


        //build down
        ElastigroupDownSpecification.Builder downBuilder = ElastigroupDownSpecification.Builder.get();
        ElastigroupDownSpecification down = downBuilder.setEvaluationPeriods(4).setMaxScaleDownPercentage(20).build();
        //build headroom
        ElastigroupHeadroomSpecification.Builder headroomBuilder = ElastigroupHeadroomSpecification.Builder.get();
        ElastigroupHeadroomSpecification headRoom =
                headroomBuilder.setCpuPerUnit(1).setNumOfUnits(2).setMemoryPerUnit(3).build();
        //build attributes
        ElastigroupAttributesSpecification.Builder attributesBuilder = ElastigroupAttributesSpecification.Builder.get();
        ElastigroupAttributesSpecification attributesSpecification =
                attributesBuilder.setkey("sali_key").setValue("sali_val").build();
        ElastigroupAttributesSpecification.Builder attributesBuilder2 =
                ElastigroupAttributesSpecification.Builder.get();
        ElastigroupAttributesSpecification attributesSpecification2 =
                attributesBuilder2.setkey("almog_key").setValue("almog_val").build();

        //build autoscale
        ElastigroupAutoScaleSpecification.Builder autoScaleBuilder = ElastigroupAutoScaleSpecification.Builder.get();
        List<ElastigroupAttributesSpecification>  attributesList   = new ArrayList<>();
        attributesList.add(attributesSpecification);
        attributesList.add(attributesSpecification2);
        ElastigroupAutoScaleSpecification autoscale =
                autoScaleBuilder.setCooldown(300).setDown(down).setHeadroom(headRoom).setIsAutoConfig(true)
                                .setIsEnabled(true).setShouldScaleDownNonServiceTasks(true)
                                .setAttributes(attributesList).build();

        //build optimizeImages
        ElastigroupOptimizeImages.Builder optimizeImagesBuilder = ElastigroupOptimizeImages.Builder.get();
        List<String>                      timeWindow            = new ArrayList<>();
        timeWindow.add("Mon:12:00-Tue:12:00");
        timeWindow.add("Fri:12:00-Sat:12:00");
        ElastigroupOptimizeImages optimizeImages =
                optimizeImagesBuilder.setShouldOptimizeEcsAmi(true).setPerformAt(MaintenanceWindowTypeEnum.TIME_WINDOW)
                                     .setTimeWindow(timeWindow).build();
        // build batch
        ElastigroupEcsBatch.Builder ecsBatchBuilder = ElastigroupEcsBatch.Builder.get();
        List<String>                batchList       = new ArrayList<>();
        batchList.add("abc");
        ElastigroupEcsBatch batch = ecsBatchBuilder.setJobQueueNames(batchList).build();
        //build ecs
        ElastigroupEcsSpecification.Builder ecsBuilder = ElastigroupEcsSpecification.Builder.get();
        ElastigroupEcsSpecification ecs =
                ecsBuilder.setAutoScale(autoscale).setClusterName("sali-ecs").setOptimizeImages(optimizeImages)
                          .setBatch(batch).build();
        //build group third party integration ECS
        ElastigroupThirdPartiesIntegrationConfiguration.Builder thirdPartiesIntegrationBuilder =
                ElastigroupThirdPartiesIntegrationConfiguration.Builder.get();
        ElastigroupThirdPartiesIntegrationConfiguration thirdPartiesIntegration =
                thirdPartiesIntegrationBuilder.setEcs(ecs).build();
        //build task
        TasksConfiguration.Builder tasksBuilder = TasksConfiguration.Builder.get();
        List<TasksConfiguration>   tasksList    = new ArrayList<>();


        //Frequency and cronExpression cannot be defined together on the same scheduled task.
        TasksConfiguration task1 =
                tasksBuilder.setIsEnabled(true).setCronExpression("sali").setTaskType(SchedulingTaskTypeEnum.BACKUP_AMI)
                            .setScaleTargetCapacity(1).setScaleMinCapacity(0).setScaleMaxCapacity(2)
                            .setBatchSizePercentage(20).setGracePeriod(500).setAdjustment(5).setAdjustmentPercentage(6)
                            .setTargetCapacity(8).setMinCapacity(7).setMaxCapacity(9).build();

        tasksList.add(task1);

        TasksConfiguration.Builder tasksBuilder2 = TasksConfiguration.Builder.get();
        TasksConfiguration task2 = tasksBuilder2.setIsEnabled(true).setFrequency(RecurrenceFrequencyEnum.DAILY)
                                                .setTaskType(SchedulingTaskTypeEnum.ROLL).setScaleTargetCapacity(0)
                                                .setScaleMinCapacity(0).setScaleMaxCapacity(2)
                                                .setBatchSizePercentage(20).setGracePeriod(500).setAdjustment(5)
                                                .setAdjustmentPercentage(6).setTargetCapacity(8).setMinCapacity(7)
                                                .setMaxCapacity(9).build();


        tasksList.add(task2);
        SimpleDateFormat formatter    = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String           dateInString = "2021-05-18T02:00:00Z";
        Date             date         = null;
        try {
            date = formatter.parse(dateInString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }


        TasksConfiguration.Builder tasksBuilder3 = TasksConfiguration.Builder.get();
        TasksConfiguration task3 =
                tasksBuilder3.setIsEnabled(true).setStartTime(date).setTaskType(SchedulingTaskTypeEnum.ROLL)
                             .setScaleTargetCapacity(0).setScaleMinCapacity(0).setScaleMaxCapacity(2)
                             .setBatchSizePercentage(20).setGracePeriod(500).setAdjustment(5).setAdjustmentPercentage(6)
                             .setTargetCapacity(8).setMinCapacity(7).setMaxCapacity(9).build();


        tasksList.add(task3);
        //build scheduling
        ElastigroupSchedulingConfiguration.Builder schedulingBuilder = ElastigroupSchedulingConfiguration.Builder.get();
        ElastigroupSchedulingConfiguration         scheduling        = schedulingBuilder.setTasks(tasksList).build();
        // Build elastigroup
        Elastigroup.Builder elastigroupBuilder = Elastigroup.Builder.get();
        Elastigroup elastigroup =
                elastigroupBuilder.setName(SPOTINST_TEST_GROUP_NAME).setDescription("descriptive-information")
                                  .setStrategy(strategy).setCapacity(capacity).setCompute(compute)
                                  // you can either set 'Scaling' or 'thirdPartyIntegration' of ECS with Auto-Scaler, but not both together.
                                  //.setScaling(scaling)
                                  .setThirdPartiesIntegration(thirdPartiesIntegration)
                                  .setScheduling(scheduling)
                                  .build();
        // Build elastigroup creation request
        ElastigroupCreationRequest.Builder elastigroupCreationRequestBuilder = ElastigroupCreationRequest.Builder.get();
        ElastigroupCreationRequest creationRequest =
                elastigroupCreationRequestBuilder.setElastigroup(elastigroup).build();

        // Convert elastigroup to API object json
        System.out.println(creationRequest.toJson());

        // Create elastigroup
        Elastigroup createdElastigroup = client.createElastigroup(creationRequest);
        System.out.println("Elastigroup succesfully created: " + createdElastigroup.getId());

        // Get elastigroup Id
        return createdElastigroup.getId();
    }

    private static String cloneGroup(SpotinstElastigroupClient client, String elastigroupIdToClone) {
        String retVal;

        // Build elastigroup clone
        Elastigroup.Builder cloneElastigroupBuilder  = Elastigroup.Builder.get();
        Elastigroup         elastigroupModifications = cloneElastigroupBuilder.setName("Cloned Elastigroup").build();

        // Build elastigroup clone request
        ElastigroupCloneRequest.Builder elastigroupCloneRequestBuilder = ElastigroupCloneRequest.Builder.get();
        ElastigroupCloneRequest cloneRequest =
                elastigroupCloneRequestBuilder.setElastigroup(elastigroupModifications).build();

        // Convert elastigroup clone to API object json
        System.out.println(cloneRequest.toJson());

        // Clone elastigroup
        Elastigroup clonedElastigroup = client.cloneElastigroup(cloneRequest, elastigroupIdToClone);
        retVal = clonedElastigroup.getId();

        System.out.println(String.format("Group successfully cloned - new group id: %s", retVal));
        return retVal;
    }

    private static void updateGroup(SpotinstElastigroupClient client, String elastigroupId) {
        //Create group update
        ElastigroupCapacityConfiguration.Builder updateCapacityBuilder = ElastigroupCapacityConfiguration.Builder.get();
        ElastigroupCapacityConfiguration updateCapacity =
                updateCapacityBuilder.setMinimum(0).setTarget(3).setMaximum(5).build();

        //create group update - tag specs
        GroupTagSpecification volumes = new GroupTagSpecification();
        volumes.setShouldTag(false);

        GroupResourceTagSpecification.Builder updateResourceTagSpecBuilder =
                GroupResourceTagSpecification.Builder.get();
        GroupResourceTagSpecification updateResourceTagSpec =
                updateResourceTagSpecBuilder.setTagVolume(volumes).build();

        ElastigroupLaunchSpecification.Builder launchSpecBuilder = ElastigroupLaunchSpecification.Builder.get();
        ElastigroupLaunchSpecification launchSpecification =
                launchSpecBuilder.setResourceTagSpecification(updateResourceTagSpec).build();

        ElastigroupComputeConfiguration.Builder updateComputeConfigureBuilder =
                ElastigroupComputeConfiguration.Builder.get();
        ElastigroupComputeConfiguration updateComputeConfigure =
                updateComputeConfigureBuilder.setLaunchSpecification(launchSpecification).build();


        // Build elastigroup update
        Elastigroup.Builder updateElastigroupBuilder = Elastigroup.Builder.get();
        Elastigroup elastigroupUpdate =
                updateElastigroupBuilder.setCapacity(updateCapacity).setCompute(updateComputeConfigure)
                                        .setName("SpotinstTestGroupU1").build();

        // Build elastigroup update request
        ElastigroupUpdateRequest.Builder elastigroupUpdateRequestBuilder = ElastigroupUpdateRequest.Builder.get();
        ElastigroupUpdateRequest updateRequest =
                elastigroupUpdateRequestBuilder.setElastigroup(elastigroupUpdate).build();

        // Convert elastigroup update to API object json
        System.out.println(updateRequest.toJson());

        // Update elastigroup
        Boolean updateSuccess = client.updateElastigroup(updateRequest, elastigroupId);
        if (updateSuccess) {
            System.out.println("Group successfully updated.");
        }
    }

    private static void detachLoadBalancer(SpotinstElastigroupClient client, String elastigroupId) {
        LoadBalancersConfig.Builder            loadBalancerConfigBuilder = LoadBalancersConfig.Builder.get();
        LoadBalancersConfig                    loadBalancersConfig       =
                loadBalancerConfigBuilder.setLoadBalancers(null).build();
        ElastigroupLaunchSpecification.Builder launchSpecBuilder         = ElastigroupLaunchSpecification.Builder.get();
        ElastigroupLaunchSpecification launchSpec =
                launchSpecBuilder.setLoadBalancersConfig(loadBalancersConfig).build();

        // Build group compute
        ElastigroupComputeConfiguration.Builder computeBuilder = ElastigroupComputeConfiguration.Builder.get();
        ElastigroupComputeConfiguration         compute        =
                computeBuilder.setLaunchSpecification(launchSpec).build();

        // Build elastigroup update
        Elastigroup.Builder updateElastigroupBuilder = Elastigroup.Builder.get();
        Elastigroup         elastigroupUpdate        = updateElastigroupBuilder.setCompute(compute).build();

        // Build elastigroup update request
        ElastigroupUpdateRequest.Builder elastigroupUpdateRequestBuilder = ElastigroupUpdateRequest.Builder.get();
        ElastigroupUpdateRequest updateRequest =
                elastigroupUpdateRequestBuilder.setElastigroup(elastigroupUpdate).build();

        // Convert elastigroup update to API object json
        System.out.println(updateRequest.toJson());

        // Update elastigroup
        Boolean updateSuccess = client.updateElastigroup(updateRequest, elastigroupId);
        if (updateSuccess) {
            System.out.println("Group successfully detached its Load Balancer.");
        }
    }

    private static void enterInstanceStandby(SpotinstElastigroupClient client, String instanceId) {

        // enter group standby
        Boolean updateSuccess = client.enterInstanceStandby(instanceId);

        if (updateSuccess) {
            System.out.println("Instance successfully entered standby mode.");
        }
    }

    private static void exitInstanceStandby(SpotinstElastigroupClient client, String instanceId) {

        // exit group standby
        Boolean updateSuccess = client.exitInstanceStandby(instanceId);

        if (updateSuccess) {
            System.out.println("Instance successfully exited standby mode.");
        }
    }

    private static void lockUnlockInstance(SpotinstElastigroupClient client, String accountId, Integer ttlInMinutes, String instanceId, String Operation) {

        Boolean success = false;

        if(Operation.equals("LOCK")) {
            // Build lock request
            ElastigroupInstanceLockRequest.Builder elastigroupLockRequestBuilder = ElastigroupInstanceLockRequest.Builder.get();
            ElastigroupInstanceLockRequest request =  elastigroupLockRequestBuilder.setAccountId(accountId)
                                                                                   .setTtlInMinutes(ttlInMinutes).build();

            success = client.lockInstance(request, instanceId);
        }
        else if(Operation.equals("UNLOCK")) {
            // Build unlock request
            ElastigroupInstanceUnLockRequest.Builder elastigroupUnLockRequestBuilder = ElastigroupInstanceUnLockRequest.Builder.get();
            ElastigroupInstanceUnLockRequest request = elastigroupUnLockRequestBuilder.setAccountId(accountId).build();

            success = client.unlockInstance(request, instanceId);
        }

        if (success) {
            System.out.println(String.format("Elastigroup Instance %s request succeeded", Operation));
        }
        else {
            System.out.println(String.format("Elastigroup Instance %s request failed", Operation));
        }
    }

    private static void interruptInstances(SpotinstElastigroupClient client, List<String> listOfInstances) {

        Boolean success;

        success = client.simulateInstanceInterruption(listOfInstances);


        if (success) {
            System.out.println("Successfully triggered Instances Interruption.");
        }
        else {
            System.out.println("Instances couldn't be interrupted.");
        }
    }

    private static SuspendedProcesses getSuspendedProcesses(SpotinstElastigroupClient elastigroupClient,
                                                            String elastigroupId) {
        SuspendedProcesses retVal;

        ElastigroupGetSuspensionsRequest.Builder requestBuilder = ElastigroupGetSuspensionsRequest.Builder.get();

        ElastigroupGetSuspensionsRequest request = requestBuilder.setElastigroupId(elastigroupId).build();

        retVal = elastigroupClient.getSuspendedProcesses(request);

        List<String> suspendedProcesses =
                retVal.getSuspensions().stream().filter(p -> p.getName() != null).map(p -> p.getName().getName())
                      .collect(Collectors.toList());

        System.out.println(String.format("Suspended processes: %s", suspendedProcesses));

        return retVal;
    }

    private static SuspendedProcesses removeSuspendedProcesses(SpotinstElastigroupClient elastigroupClient,
                                                               String groupId, List<ProcessNameEnum> processNames) {
        SuspendedProcesses retVal;

        ElastigroupRemoveSuspensionsRequest.Builder requestBuilder = ElastigroupRemoveSuspensionsRequest.Builder.get();

        ElastigroupRemoveSuspensionsRequest request =
                requestBuilder.setElastigroupId(groupId).setProcesses(processNames).build();

        retVal = elastigroupClient.removeSuspensions(request);

        System.out.println(String.format("Remaining suspended processes: %s", retVal.getProcesses()));

        return retVal;
    }

    private static SuspendedProcesses suspendProcess(SpotinstElastigroupClient elastigroupClient, String elastigroupId,
                                                     ProcessNameEnum processName) {
        SuspendedProcesses retVal;

        ElastigroupSuspendProcessesRequest.Builder requestBuilder = ElastigroupSuspendProcessesRequest.Builder.get();

        ProcessSuspension.Builder suspensionBuilder = ProcessSuspension.Builder.get();
        ProcessSuspension suspension = suspensionBuilder.setName(processName).setTtlInMinutes(null).build();
        List<ProcessSuspension> suspensions = Collections.singletonList(suspension);
        ElastigroupSuspendProcessesRequest request =
                requestBuilder.setElastigroupId(elastigroupId).setSuspensions(suspensions).build();

        retVal = elastigroupClient.suspendProcess(request);

        return retVal;
    }

    private static SuspendedScalingPolicy suspendScalingPolicies(SpotinstElastigroupClient elastigroupClient,
                                                                 String elastigroupId, String policyName) {
        ElastigroupSuspendScalingPoliciesRequest.Builder requestBuilder    =
                ElastigroupSuspendScalingPoliciesRequest.Builder.get();
        ScalingPolicySuspension.Builder                  suspensionBuilder = ScalingPolicySuspension.Builder.get();
        ScalingPolicySuspension                          suspension        =
                suspensionBuilder.setTtlInMinutes(20).build();
        ElastigroupSuspendScalingPoliciesRequest request =
                requestBuilder.setSuspension(suspension).setGroupId(elastigroupId).setPolicyName(policyName).build();

        SuspendedScalingPolicy retVal = elastigroupClient.suspendScalingPolicies(request);

        System.out.println(String.format("Group Id: %s", retVal.getGroupId()));
        System.out.println(String.format("Policy Name: %s", retVal.getPolicyName()));
        System.out.println(String.format("Expires At: %s", retVal.getExpiresAt()));
        System.out.println(String.format("State: %s", retVal.getState()));

        return retVal;
    }

    private static Boolean removeSuspendedScalingPolicies(SpotinstElastigroupClient elastigroupClient,
                                                          String elastigroupId, String policyName) {
        ElastigroupSuspendScalingPoliciesRequest.Builder requestBuilder =
                ElastigroupSuspendScalingPoliciesRequest.Builder.get();

        ElastigroupSuspendScalingPoliciesRequest request =
                requestBuilder.setGroupId(elastigroupId).setPolicyName(policyName).build();

        Boolean removeStatus = elastigroupClient.removeSuspendedScalingPolicies(request);
        System.out.println(
                String.format("Remove suspended scaling policy status for policy %s: %s", policyName, removeStatus));
        return removeStatus;
    }

    private static List<SuspendedScalingPolicy> getAllSuspendedScalingPolicies(
            SpotinstElastigroupClient elastigroupClient, String elastigroupId) {
        ElastigroupSuspendScalingPoliciesRequest.Builder requestBuilder =
                ElastigroupSuspendScalingPoliciesRequest.Builder.get();
        ElastigroupSuspendScalingPoliciesRequest         request        =
                requestBuilder.setGroupId(elastigroupId).build();

        List<SuspendedScalingPolicy> allSuspendedScalingPolicies =
                elastigroupClient.getAllSuspendedScalingPolicies(request);

        for (SuspendedScalingPolicy policy : allSuspendedScalingPolicies) {
            System.out.println(String.format("Group Id: %s", policy.getGroupId()));
            System.out.println(String.format("Policy Name: %s", policy.getPolicyName()));
            System.out.println(String.format("Expires At: %s", policy.getExpiresAt()));
            System.out.println(String.format("State: %s", policy.getState()));
            System.out.println();
        }
        return allSuspendedScalingPolicies;
    }

    private static void getEventsLogs(SpotinstElastigroupClient client, String elastigroupId, String fromDate,
                                      String toDate, EventsLogsSeverityEnum logsSeverity, String resourceId,
                                      String limit) {

        GetEventsLogsRequest.Builder requestBuilder = GetEventsLogsRequest.Builder.get();
        GetEventsLogsRequest getEventsLogsRequest =
                requestBuilder.setFromDate(fromDate).setToDate(toDate).setSeverity(logsSeverity)
                              .setResourceId(resourceId).setLimit(limit).setElastigroupId(elastigroupId).build();

        List<EventLog> eventsLogs = client.getEventsLogs(getEventsLogsRequest);

        System.out.println(String.format("Fetched %s events logs for group", eventsLogs.size()));

        for (EventLog eventLog : eventsLogs) {
            System.out.println(String.format("%s, %s, %s", eventLog.getCreatedAt(), eventLog.getSeverity(),
                                             eventLog.getMessage()));
        }
    }

    private static ElastigroupStartDeploymentResponse startDeployment(SpotinstElastigroupClient elastigroupClient,
                                                                      String elastigroupId) {

        // Build Onfailure
        ElastigroupDeploymentStrategyOnFailure onfailure =
                ElastigroupDeploymentStrategyOnFailure.Builder.get().setActionType(AwsElastigroupActionTypeEnum.DETACH_NEW)
                                                              .setDrainingTimeout(200)
                                                              .setShouldDecrementTargetCapacity(true)
                                                              .setShouldHandleAllBatches(false).build();

        // Build Strategy
        ElastigroupDeploymentStrategy strategy =
                ElastigroupDeploymentStrategy.Builder.get().setAction(AwsElastigroupActionEnum.RESTART_SERVER).setBatchMinHealthyPercentage(50).setOnFailure(onfailure)
                                                     .build();

        //Build Elastigroup Deployment
        ElastigroupStartDeployment.Builder requestBuilder = ElastigroupStartDeployment.Builder.get();
        ElastigroupStartDeployment elastigroupStartDeployment =
                requestBuilder.setBatchSizePercentage(100).setDrainingTimeout(240).setGracePeriod(10)
                              .setHealthCheckType(AwsElastigroupHealthCheckTypeEnum.NONE).setStrategy(strategy).build();

        ElastigroupStartDeploymentRequest.Builder startDeploymentRequestBuilder = ElastigroupStartDeploymentRequest.Builder.get();
        ElastigroupStartDeploymentRequest startDeploymentRequest =
                startDeploymentRequestBuilder.setElastigroupDeployment(elastigroupStartDeployment).build();

        System.out.println("Start Deployment Request for elastigroup:" + elastigroupId);
        System.out.println(startDeploymentRequest.toJson());

        ElastigroupStartDeploymentResponse startDeploymentResponse =
                elastigroupClient.startDeployment(startDeploymentRequest, elastigroupId);

        System.out.println("Start Deployment for  elastigroup: " + elastigroupId + " with id " + startDeploymentResponse.getId() +
                           " and status " + startDeploymentResponse.getStatus() + " in current batch " +
                           startDeploymentResponse.getCurrentBatch() + " out of " + startDeploymentResponse.getNumOfBatches() +
                           " total batches");

        return startDeploymentResponse;

    }

    private static ElastigroupStopDeploymentResponse stopDeployment(SpotinstElastigroupClient elastigroupClient, String elastigroupId,
                                                                    String deploymentId) {

        ElastigroupStopDeploymentRequest.Builder stopDeploymentRequestBuilder = ElastigroupStopDeploymentRequest.Builder.get();

        //Build stopDeployment
        ElastigroupDeploymentRoll.Builder stopDeployBuilder = ElastigroupDeploymentRoll.Builder.get();

        ElastigroupDeploymentRoll stopDeployment = stopDeployBuilder.setStatus("STOPPED").build();

        ElastigroupStopDeploymentRequest stopDeploymentRequest = stopDeploymentRequestBuilder.setRoll(stopDeployment).build();
        System.out.println("Stop Deployment Request: " + stopDeploymentRequest.toJson());

        ElastigroupStopDeploymentResponse stopDeploymentResponse = elastigroupClient.stopDeployment(stopDeploymentRequest, elastigroupId, deploymentId);
        System.out.println("Stopped Deployment for  elastigroup: " + elastigroupId + " with id " + stopDeploymentResponse.getId() +" and status " + stopDeploymentResponse.getStatus());

        return stopDeploymentResponse;

    }

    private static ElastigroupGetDeploymentStatusResponse getDeploymentStatus(SpotinstElastigroupClient elastigroupClient, String elastigroupId,
                                                                                                                      String deploymentId) {

        ElastigroupGetDeploymentStatusResponse GetDeploymentStatusResponse = elastigroupClient.getDeploymentStatus(elastigroupId, deploymentId);

        System.out.println("Deployment for  elastigroup: " + elastigroupId + " And Deployment id " + deploymentId +" is as below : ");

        if(GetDeploymentStatusResponse.getInstances().size() > 0) {

            for (int i = 0; i < GetDeploymentStatusResponse.getInstances().size(); i++) {

                if (GetDeploymentStatusResponse.getInstances().get(i).getBlue().size() > 0) {
                    System.out.println("Blue Instances List: ");
                    for (int j = 0; j < GetDeploymentStatusResponse.getInstances().get(i).getBlue().size(); j++) {
                        System.out.println("Blue Instance " + j + " :");
                        System.out.println("Id : " + GetDeploymentStatusResponse.getInstances().get(i).getBlue().get(i)
                                            .getInstanceId() + " with status " + GetDeploymentStatusResponse.getInstances().get(i).getBlue().get(i).getStatus());
                    }

                }

                if (GetDeploymentStatusResponse.getInstances().get(i).getGreen().size() > 0) {
                    System.out.println("Green Instances List: ");
                    for (int k = 0; k < GetDeploymentStatusResponse.getInstances().get(i).getGreen().size(); k++) {
                        System.out.println("Id : " + GetDeploymentStatusResponse.getInstances().get(i).getGreen().get(i)
                                           .getInstanceId() + " with status " + GetDeploymentStatusResponse.getInstances().get(i).getGreen().get(i).getStatus());
                    }

                }

            }
        }

        return GetDeploymentStatusResponse;

    }

    private static List<ElastigroupGroupDeploymentStatusResponse> getGroupDeploymentStatus(SpotinstElastigroupClient elastigroupClient, String elastigroupId) {

        List<ElastigroupGroupDeploymentStatusResponse> GetGroupDeploymentStatusResponse = elastigroupClient.getGroupDeploymentStatus(elastigroupId);

        System.out.println("Group Deployment Status for  elastigroup: " + elastigroupId + " is as below : ");

        for (ElastigroupGroupDeploymentStatusResponse response : GetGroupDeploymentStatusResponse) {
            System.out.println(response.getId() + " : " + response.getStatus());
        }

        return GetGroupDeploymentStatusResponse;

    }

    private static ElastigroupGetDeploymentActionResponse applyDeploymentAction(SpotinstElastigroupClient elastigroupClient, String elastigroupId, String deploymentId) {

        ElastigroupGetDeploymentActionRequest.Builder getDeploymentActionBuilder = ElastigroupGetDeploymentActionRequest.Builder.get();

        ElastigroupDeploymentStrategyOnFailure applyDeploymentAction = ElastigroupDeploymentStrategyOnFailure.Builder.get().setActionType(AwsElastigroupActionTypeEnum.DETACH_OLD)
                                                                                                                     .setDrainingTimeout(240).setShouldDecrementTargetCapacity(true)
                                                                                                                     .setShouldHandleAllBatches(true).build();

        ElastigroupGetDeploymentActionRequest getDeploymentActionRequest = getDeploymentActionBuilder.setElastigroupDeploymentAction(applyDeploymentAction).build();

        ElastigroupGetDeploymentActionResponse getDeploymentActionResponse = elastigroupClient.applyDeploymentAction(getDeploymentActionRequest, elastigroupId, deploymentId);

        System.out.println("Deployment Action for  elastigroup: " + elastigroupId + " and roll id " + deploymentId + " is: " +
                           getDeploymentActionResponse.getActionType()+ " for below Detach Instances");

        for (int i = 0; i < getDeploymentActionResponse.getDetachedInstances().size() ; i++) {
            System.out.println(" detach instance id" +getDeploymentActionResponse.getDetachedInstances().get(i));
        }

        return getDeploymentActionResponse;

    }

    private static List<ItfMigrationRulesStatus> getItfMigrationRulesStatus(
            SpotinstElastigroupClient elastigroupClient, String elastigroupId) {

        List<ItfMigrationRulesStatus> itfMigrationRulesStatusList =
                elastigroupClient.getItfMigrationRulesStatus(elastigroupId);

        for (ItfMigrationRulesStatus list : itfMigrationRulesStatusList) {
            System.out.println(String.format("Id: %s", list.getId()));
            System.out.println(String.format("Group Id: %s", list.getGroupId()));
            System.out.println(String.format("Rule ARN: %s", list.getRuleArn()));
            System.out.println(String.format("Status: %s", list.getStatus()));
            System.out.println(String.format("Created At: %s", list.getCreatedAt()));
            System.out.println(String.format("Updated At: %s", list.getUpdatedAt()));
            System.out.println();
        }
        return itfMigrationRulesStatusList;
    }

    private static Boolean retryItfMigration(SpotinstElastigroupClient elastigroupClient,
                                                                      String elastigroupId) {

        ItfMigrationRulesStatus.Builder migrationBuilder = ItfMigrationRulesStatus.Builder.get();
        ItfMigrationRulesStatus         migration        = migrationBuilder.setStatus("USER_RETRY").build();

        RetryItfMigrationRequest.Builder requestBuilder = RetryItfMigrationRequest.Builder.get();
        RetryItfMigrationRequest retryItfMigration = requestBuilder.setMigration(migration).setId("ilrm-72bf5f74")
                                                                   .setGroupId(elastigroupId).build();

        System.out.println("ITF migration retry for elastigroup:" + elastigroupId);

        return elastigroupClient.retryItfMigration(retryItfMigration);

    }

    private static List<ElastigroupGetElastilogResponse> getElastilog(SpotinstElastigroupClient client, String accountId, String fromDate, String limit, String resourceId, String severity, String toDate, String elastigroupId) {

        // Build get request
        ElastigroupGetElastilogRequest.Builder getElastilogRequestBuilder = ElastigroupGetElastilogRequest.Builder.get();
        ElastigroupGetElastilogRequest request = getElastilogRequestBuilder.setAccountId(accountId)
                .setFromDate(fromDate).setLimit(limit).setResourceId(resourceId)
                .setSeverity(severity).setToDate(toDate).build();

        List<ElastigroupGetElastilogResponse> elastigroupGetLogsResponse =
                client.getElastilog(request, elastigroupId);

        for (ElastigroupGetElastilogResponse logs : elastigroupGetLogsResponse) {
            System.out.println(String.format("Message: %s", logs.getMessage()));
            System.out.println(String.format("Severity: %s", logs.getSeverity()));
            System.out.println(String.format("Created At: %s", logs.getCreatedAt()));
        }

        return elastigroupGetLogsResponse;
    }

    private static List<GetInstanceTypesResponse> getInstanceTypesByRegion(SpotinstElastigroupClient client, String region) {


        List<GetInstanceTypesResponse> getInstanceTypesByRegionResponse =
                client.getInstanceTypesByRegion(region);

        for (GetInstanceTypesResponse instanceType : getInstanceTypesByRegionResponse) {
            System.out.println(String.format("InstanceType: %s", instanceType.getInstanceType()));
        }

        return getInstanceTypesByRegionResponse;
    }

    private static List<GetInstanceTypesResponse> getSuggestedInstanceTypes(SpotinstElastigroupClient elastigroupClient) {

        GetSuggestedInstanceType.Builder instanceTypeBuilder = GetSuggestedInstanceType.Builder.get();
        GetSuggestedInstanceType         instanceType        = instanceTypeBuilder.setRegion("us-west-2").setBaselineInstanceType("m5.large").build();

        GetSuggestedInstanceTypeRequest.Builder requestBuilder = GetSuggestedInstanceTypeRequest.Builder.get();
        GetSuggestedInstanceTypeRequest instanceTypesReq = requestBuilder.setSuggestedInstanceType(instanceType).build();

        List<GetInstanceTypesResponse> getInstanceTypesByRegionResponse =
                elastigroupClient.getSuggestedInstanceTypes(instanceTypesReq);

        for (GetInstanceTypesResponse instances : getInstanceTypesByRegionResponse) {
            System.out.println(String.format("InstanceType: %s", instances.getInstanceType()));
        }

        return getInstanceTypesByRegionResponse;

    }

    private static ElastigroupEcsClusterRollResponse initiateClusterRoll(SpotinstElastigroupClient client, String groupId, Integer batchSizePercentage, String comment, Boolean respectPdb, Integer batchMinHealthyPercentage) {

        ElastigroupEcsInitiateRoll.Builder initiateRollBuilder = ElastigroupEcsInitiateRoll.Builder.get();
        ElastigroupEcsInitiateRoll initiateRoll = initiateRollBuilder.setBatchSizePercentage(batchSizePercentage).setComment(comment).setBatchMinHealthyPercentage(batchMinHealthyPercentage).build();

        System.out.println(String.format("Initiate cluster Roll: %s", groupId));
        ElastigroupEcsClusterRollResponse rollResponse = client.initiateClusterRollInEGWithECS(initiateRoll, groupId);

        String rollId = rollResponse.getId();

        return rollResponse;
    }

    private static ElastigroupEcsClusterRollResponse getClusterRoll (SpotinstElastigroupClient client, String groupId, String rollId) {

        System.out.println(String.format("Get cluster Roll. ClusterId: %s, RollId: %s", groupId, rollId));
        ElastigroupEcsClusterRollResponse getRollResponse = client.getECSClusterRollinEG(groupId, rollId);

        k8sClusterRollStatusEnum rollStatus = getRollResponse.getStatus();

        return getRollResponse;
    }

    private static List<ElastigroupEcsClusterRollResponse> getAllClusterRolls(SpotinstElastigroupClient client, String groupId) {

        System.out.println(String.format("Get all cluster Rolls. ClusterId: %s", groupId));
        List<ElastigroupEcsClusterRollResponse> getAllRolls = client.listECSClusterRollsPerEG(groupId);

        for (ElastigroupEcsClusterRollResponse roll : getAllRolls){
            System.out.println(String.format("RollId: %s", roll.getId()));
            System.out.println(String.format("RollId: %s", roll.getStatus()));
        }
        return getAllRolls;
    }

    private static ElastigroupEcsClusterRollResponse updateClusterRoll(SpotinstElastigroupClient client, String groupId, String status) {

        ElastigroupEcsUpdateRollRequest.Builder updateRollBuilder = ElastigroupEcsUpdateRollRequest.Builder.get();
        ElastigroupEcsUpdateRollRequest updateRoll = updateRollBuilder.setStatus(status).build();

        System.out.println(String.format("Update Cluster Roll. ClusterId: %s", groupId));
        ElastigroupEcsClusterRollResponse response = client.updateECSClusterRollinEG(updateRoll, groupId);

        System.out.println(String.format("RollStatus: %s", response.getStatus()));

        return response;
    }

    private static Boolean createInstanceSignal(SpotinstElastigroupClient elastigroupClient, String signal) {

        ElastigroupCreateInstanceSignal.Builder instanceSignalBuilder = ElastigroupCreateInstanceSignal.Builder.get();
        ElastigroupCreateInstanceSignal         instanceSignal        = instanceSignalBuilder.setInstanceId(instanceId).setSignal(signal).build();

        System.out.println("Create instance signal:" + instanceId);

        return elastigroupClient.createInstanceSignal(instanceSignal);

    }

    private static ElastigroupGetInstanceStatusResponse getInstanceStatus(SpotinstElastigroupClient client, String instanceId) {

        System.out.println(String.format("Get Instance Status. InstanceId: %s", instanceId));
        ElastigroupGetInstanceStatusResponse response = client.getInstanceStatus(instanceId);

        System.out.println(String.format("Instance ID: %s", response.getInstanceId()));
        System.out.println(String.format("Lifecycle State: %s", response.getLifeCycleState()));

        return response;
    }

}
