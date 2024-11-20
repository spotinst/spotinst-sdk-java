package com.spotinst.sdkjava.example.mrScaler.aws;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.enums.AwsMrScalerStateEnum;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.*;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MrScalerAwsUsageExample {
    private final static String auth_token = "api-token";
    private final static String act_id     = "act-no";

    public static void main(String[] args) throws IOException {
        SpotinstMrScalerAwsClient mrScalerAwsClient = SpotinstClient.getMrScalerAwsClient(auth_token, act_id);

        System.out.println("Creating MrScaler");
        String mrScalerId = createMrScaler(mrScalerAwsClient);
        System.out.println("Creation Success: " + mrScalerId);

        System.out.println("Getting New MrScaler");
        getMrScaler(mrScalerAwsClient, mrScalerId);
        System.out.println("Get Singe Cluster Success");

        System.out.println("Get all MrScaler");
        getAllMrScaler(mrScalerAwsClient);
        System.out.println("Get All Success");

        System.out.println("Update MrScaler");
        updateMrScaler(mrScalerAwsClient, mrScalerId);
        System.out.println("Update Success: " + mrScalerId);

        System.out.print("List Instances");
        listMrScalerInstances(mrScalerAwsClient, mrScalerId);
        System.out.println("List All Instances Success");

        System.out.print("List MrScaler Cluster");
        listMrScaler(mrScalerAwsClient, mrScalerId);
        System.out.println("List MrScaler Cluster Success");

        System.out.print("Scale Up MrScaler Cluster");
        scaleUpMrScaler(mrScalerAwsClient, mrScalerId, 2);
        System.out.println("Scale Up MrScaler Cluster Success");

        System.out.print("Scale Down MrScaler Cluster");
        scaleDownMrScaler(mrScalerAwsClient, mrScalerId, 2);
        System.out.println("Scale Down MrScaler Cluster Success");

        System.out.println("Delete MrScaler");
        deleteMrScaler(mrScalerAwsClient, mrScalerId);
        System.out.println("Delete Success: " + mrScalerId);

        System.out.println("Creating MrScaler Operator");
        MrScalerAws mrScalerForOperator = buildApiMrScalerAws();
        MrScalerOperatorResponse mrScalerOperator    =
                createMrScaleOperator(mrScalerAwsClient, mrScalerForOperator);
        AwsMrScalerStateEnum mrScalerState      = mrScalerOperator.getState();
        String               mrScalerOperatorId = mrScalerOperator.getMrScalerId();

        System.out.println("Update MrScaler cached in MrScaler Operator");
        updateMrScaler(mrScalerAwsClient, mrScalerOperatorId);
        System.out.println("Update Success: " + mrScalerOperatorId);

        System.out.println("Creation Success: " + mrScalerOperatorId);
        System.out.println("MrScaler state: " + mrScalerState.getName());

        System.out.println("Delete MrScaler cached in MrScaler Operator");
        deleteMrScaler(mrScalerAwsClient, mrScalerOperatorId);
        System.out.println("Delete Success: " + mrScalerOperatorId);
    }

    public static String createMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient) {
        MrScalerAws mrScalerRequest = buildApiMrScalerAws();

        System.out.println("Building MrScaler Creation Request");
        MrScalerAwsCreationRequest.Builder mrScalerCreationRequestBuilder =
                MrScalerAwsCreationRequest.Builder.get();

        MrScalerAwsCreationRequest creationRequest =
                mrScalerCreationRequestBuilder.setMrScaler(mrScalerRequest).build();

        System.out.println(JsonMapper.toJson(creationRequest));

        System.out.println("Sending Request");
        MrScalerAws mrScalerResponse = mrScalerAwsClient.createMrScaler(creationRequest);

        System.out.println("Request Success: ");
        System.out.println(JsonMapper.toJson(mrScalerResponse));

        return mrScalerResponse.getId();
    }

    public static MrScalerAws buildApiMrScalerAws() {
        System.out.println("Building Scheduling Parameters");
        List<MrScalerAwsTask>   tasks       = new ArrayList<>();
        MrScalerAwsTask.Builder taskBuilder = MrScalerAwsTask.Builder.get();
        MrScalerAwsTask task =
                taskBuilder.setCronExpression("cron").setInstanceGroupType("instnace").setIsEnabled(true)
                           .setMaxCapacity(0).setMinCapacity(0).setTargetCapacity(0).setTaskType("type").build();
        tasks.add(task);

        MrScalerAwsSchedulingConfiguration.Builder schedulingBuilder =
                MrScalerAwsSchedulingConfiguration.Builder.get();
        MrScalerAwsSchedulingConfiguration scheduling = schedulingBuilder.setTasks(tasks).build();

        System.out.println("End Building Scheduling Params");
        System.out.println(JsonMapper.toJson(scheduling));


        System.out.println("Building Scaling Parameters");
        List<MrScalerAwsScalingDimenation>   dimList    = new ArrayList<>();
        MrScalerAwsScalingDimenation.Builder dimBuilder = MrScalerAwsScalingDimenation.Builder.get();
        MrScalerAwsScalingDimenation dim        = dimBuilder.setName("name").setValue("value").build();
        dimList.add(dim);

        MrScalerAwsScalingAction.Builder actionBuilder = MrScalerAwsScalingAction.Builder.get();

        MrScalerAwsScalingAction scalingAction = actionBuilder.setAdjustment(2).setType("adjustment").build();


        List<MrScalerAwsScalingPolicy> uppolicies = new ArrayList<>();

        MrScalerAwsScalingPolicy.Builder policyBuilder = MrScalerAwsScalingPolicy.Builder.get();

        MrScalerAwsScalingPolicy scaleuppolicy = policyBuilder.setAction(scalingAction).setCooldown(300)

                                                                 .setDimensions(dimList).setMetricName("test")

                                                                 .setNamespace("AWS").setOperator("lte").setPeriod(300)
                                                                 .setEvaluationPeriods(1)

                                                                 .setPolicyName("scaleUpPolicy").setStatistic("average")
                                                                 .setUnit("percent").setThreshold(20).build();

        uppolicies.add(scaleuppolicy);


        List<MrScalerAwsScalingPolicy>   downPolicies   = new ArrayList<>();
        MrScalerAwsScalingPolicy.Builder policyBuilder3 = MrScalerAwsScalingPolicy.Builder.get();
        MrScalerAwsScalingPolicy scaleDownPolicy =
                policyBuilder3.setAction(scalingAction).setCooldown(300).setDimensions(dimList)
                              .setMetricName("YARNMemoryAvailablePercentage").setNamespace("AWS/ElasticMapReduce")
                              .setOperator("gte").setPeriod(300).setEvaluationPeriods(1).setPolicyName("scaleuppolicy")
                              .setStatistic("average").setUnit("percent").setThreshold(90).build();
        downPolicies.add(scaleDownPolicy);

        MrScalerAwsScalingConfiguration.Builder scalingBuilder = MrScalerAwsScalingConfiguration.Builder.get();

        MrScalerAwsScalingConfiguration scaling = scalingBuilder.setDown(downPolicies).setUp(uppolicies).build();

        System.out.println("End Building Scaling Params");
        System.out.println(JsonMapper.toJson(scaling));


        System.out.println("Building Cluster Parameters");
        MrScalerAwsClusterConfiguration.Builder clusterBuilder = MrScalerAwsClusterConfiguration.Builder.get();
        MrScalerAwsClusterConfiguration cluster =
                clusterBuilder.setTerminationProtected(true).setVisibleToAllUsers(true).build();
        System.out.println("End Building Cluster Params");
        System.out.println(JsonMapper.toJson(cluster));


        System.out.println("Building Compute Parameters");
        MrScalerAwsFileParams.Builder fileParamsBuilder = MrScalerAwsFileParams.Builder.get();
        MrScalerAwsFileParams fileParams = fileParamsBuilder.setBucket("test-bucket").setKey("test-key").build();

        MrScalerAwsFile.Builder fileBuilder = MrScalerAwsFile.Builder.get();
        MrScalerAwsFile file        = fileBuilder.setFile(fileParams).build();

        Tag.Builder tagBuilder = Tag.Builder.get();
        Tag         tag        = tagBuilder.setTagKey("test-key").setTagValue("test-value").build();
        List<Tag>   tags       = new ArrayList<>();
        tags.add(tag);

        List<String> additionalSec = new ArrayList<>();
        additionalSec.add("m3.xlarge");

        MrScalerAwsApplication.Builder applicationBuilder = MrScalerAwsApplication.Builder.get();
        MrScalerAwsApplication application        =
                applicationBuilder.setName("app-name").setVersion("app-verion").build();

        List<MrScalerAwsApplication> appList = new ArrayList<>();
        appList.add(application);

        AvailabilityZone.Builder azBuilder = AvailabilityZone.Builder.get();
        AvailabilityZone         az        = azBuilder.setName("us-west-2a").setSubnetId("subnet-4333093a").build();

        List<AvailabilityZone> availabilityZones = new ArrayList<>();
        availabilityZones.add(az);

        MrScalerAwsVolumeSpecification.Builder volumeBuilder = MrScalerAwsVolumeSpecification.Builder.get();
        MrScalerAwsVolumeSpecification volume =
                volumeBuilder.setIops(1).setSizeInGb(1).setVolumeType("volume-type").build();

        MrScalerAwsEbsBlockDeviceConfig.Builder configBuilder = MrScalerAwsEbsBlockDeviceConfig.Builder.get();
        MrScalerAwsEbsBlockDeviceConfig singleConfig =
                configBuilder.setVolumeSpecification(volume).setVolumesPerInstance(1).build();

        List<MrScalerAwsEbsBlockDeviceConfig> blockList = new ArrayList<>();
        blockList.add(singleConfig);

        ElastigroupCapacityConfiguration.Builder capacityBuilder = ElastigroupCapacityConfiguration.Builder.get();
        ElastigroupCapacityConfiguration         capacity        =
                capacityBuilder.setMaximum(1).setMinimum(0).setTarget(1).build();


        MrScalerAwsEbsConfiguration.Builder ebsBuilder = MrScalerAwsEbsConfiguration.Builder.get();
        MrScalerAwsEbsConfiguration ebs        = ebsBuilder.setEbsOptimized(true).build();

        MrScalerAwsMasterGroup.Builder masterGroupBuilder = MrScalerAwsMasterGroup.Builder.get();
        MrScalerAwsMasterGroup masterGroup =
                masterGroupBuilder.setInstanceTypes(additionalSec).setTarget(1).setLifeCycle("ON_DEMAND").build();

        MrScalerAwsCoreGroup.Builder coreGroupBuilder = MrScalerAwsCoreGroup.Builder.get();
        MrScalerAwsCoreGroup coreGroup =
                coreGroupBuilder.setCapacity(capacity).setInstanceTypes(additionalSec).setLifeCycle("SPOT").setTarget(1)
                                .build();

        MrScalerAwsTaskGroup.Builder taskGroupBuilder = MrScalerAwsTaskGroup.Builder.get();
        MrScalerAwsTaskGroup taskgroup =
                taskGroupBuilder.setCapacity(capacity).setInstanceTypes(additionalSec).setLifeCycle("SPOT").build();


        MrScalerAwsInstancegroups.Builder instanceGroupsBuilder = MrScalerAwsInstancegroups.Builder.get();
        MrScalerAwsInstancegroups instancegroups =
                instanceGroupsBuilder.setMasterGroup(masterGroup).setCoreGroup(coreGroup).setTaskGroup(taskgroup)
                                     .build();

        MrScalerAwsComputeConfiguration.Builder computeBuilder = MrScalerAwsComputeConfiguration.Builder.get();
        MrScalerAwsComputeConfiguration compute =
                computeBuilder.setInstanceGroups(instancegroups).setAvailabilityZones(availabilityZones).build();
        System.out.println("End Building Copmute Params");
        System.out.println(JsonMapper.toJson(compute));


        System.out.println("Building Strategy Parameters");
        MrScalerAwsProvisioningTimeout.Builder ptBuilder = MrScalerAwsProvisioningTimeout.Builder.get();
        MrScalerAwsProvisioningTimeout pt = ptBuilder.setTimeout(1).setTimeoutAction("test-action").build();

        MrScalerAwsWrapStrategy.Builder wrapBuilder = MrScalerAwsWrapStrategy.Builder.get();
        MrScalerAwsWrapStrategy wrap        = wrapBuilder.setSourceClusterId("test-source-id").build();

        MrScalerAwsNewStrategy.Builder newBuilder = MrScalerAwsNewStrategy.Builder.get();
        MrScalerAwsNewStrategy newing     = newBuilder.setReleaseLabel("emr-5.17.0").build();

        MrScalerAwsCloneStrategy.Builder cloneBuilder = MrScalerAwsCloneStrategy.Builder.get();
        MrScalerAwsCloneStrategy clone =
                cloneBuilder.setOriginClusterId("test-id").setIncludeSteps(true).setNumberOfRetries(0).build();

        MrScalerAwsStrategyConfiguration.Builder strategyBuilder = MrScalerAwsStrategyConfiguration.Builder.get();
        MrScalerAwsStrategyConfiguration strategy        = strategyBuilder.setNew(newing).build();
        System.out.println("End Building Strategy Params");
        System.out.println(JsonMapper.toJson(strategy));


        System.out.println("Building All Parameters");
        MrScalerAws.Builder mrScalerBuilder = MrScalerAws.Builder.get();

        MrScalerAws mrScalerRequest =
                mrScalerBuilder.setName("Java SDK Test").setRegion("us-west-2").setDescription("description-test")
                               .setStrategy(strategy).setCompute(compute).setCluster(cluster).setScaling(scaling)
                               .build();
        System.out.println(JsonMapper.toJson(mrScalerRequest));
        return mrScalerRequest;
    }

    public static void updateMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId) {
        System.out.println("Building Cluster Parameters");
        MrScalerAwsClusterConfiguration.Builder clusterBuilder = MrScalerAwsClusterConfiguration.Builder.get();
        MrScalerAwsClusterConfiguration cluster =
                clusterBuilder.setTerminationProtected(false).setVisibleToAllUsers(true).build();
        System.out.println("End Building Cluster Params");
        System.out.println(JsonMapper.toJson(cluster));

        System.out.println("Building All Parameters");
        MrScalerAws.Builder mrScalerBuilder = MrScalerAws.Builder.get();
        MrScalerAws mrScalerRequest = mrScalerBuilder.setCluster(cluster).build();
        System.out.println(JsonMapper.toJson(mrScalerRequest));

        MrScalerAwsUpdateRequest.Builder updateBuilder = MrScalerAwsUpdateRequest.Builder.get();
        MrScalerAwsUpdateRequest updateRequest = updateBuilder.setMrScaler(mrScalerRequest).build();

        System.out.println("Sending Request");
        Boolean mrScalerUpdateResponse = mrScalerAwsClient.updateMrScaler(updateRequest, mrScalerId);

        System.out.println("Update Status: " + mrScalerUpdateResponse);
    }

    public static void listMrScalerInstances(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId) {
        System.out.print("List Instances");
        MrScalerListInstancesRequest.Builder listMrScalerInstancesBuilder = MrScalerListInstancesRequest.Builder.get();
        MrScalerListInstancesRequest listMrScalerInstances        = listMrScalerInstancesBuilder.setMrScalerId(mrScalerId).build();

        System.out.println("Sending Request");
        List<MrScalerListInstancesAws> listRes = mrScalerAwsClient.listMrScalerInstances(listMrScalerInstances);
        System.out.println(JsonMapper.toJson(listRes));
    }

    public static void listMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId) {
        System.out.print("List MrScaler");
        MrScalerListMrScalersRequest.Builder listMrScalersBuilder = MrScalerListMrScalersRequest.Builder.get();
        MrScalerListMrScalersRequest listMrScalers        = listMrScalersBuilder.setMrScalerId(mrScalerId).build();

        System.out.println("Sending Request");
        List<MrScalerListScalersAws> listRes = mrScalerAwsClient.listMrScalers(listMrScalers);
        System.out.println(JsonMapper.toJson(listRes));

    }

    public static void scaleUpMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId, Integer adjustment){
        System.out.print("Scale Up MrScaler");
        MrScalerScaleUpRequest.Builder scalerUpMrScalersBuilder = MrScalerScaleUpRequest.Builder.get();
        MrScalerScaleUpRequest scalerScaleUpRequest     = scalerUpMrScalersBuilder.setMrScalerId(mrScalerId).setAdjustment(adjustment).build();

        System.out.println("Sending Request");
        List<MrScalerScaleUpAws> scalerUpRes = mrScalerAwsClient.scaleUpMrScaler(scalerScaleUpRequest);
        System.out.println(JsonMapper.toJson(scalerUpRes));
    }

    public static void scaleDownMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId, Integer adjustment){
        System.out.print("Scale Down MrScaler");
        MrScalerScaleDownRequest.Builder scalerDownMrScalersBuilder = MrScalerScaleDownRequest.Builder.get();
        MrScalerScaleDownRequest scalerScaleDownRequest     = scalerDownMrScalersBuilder.setMrScalerId(mrScalerId).setAdjustment(adjustment).build();

        System.out.println("Sending Request");
        List<MrScalerScaleDownAws> scalerDownRes = mrScalerAwsClient.scaleDownMrScaler(scalerScaleDownRequest);
        System.out.println(JsonMapper.toJson(scalerDownRes));
    }

    public static void deleteMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId) {
        MrScalerAwsDeleteRequest.Builder deleteBuilder = MrScalerAwsDeleteRequest.Builder.get();
        MrScalerAwsDeleteRequest         delete        = deleteBuilder.setMrScalerId(mrScalerId).build();

        System.out.println("Sending Request");
        Boolean deleteRes = mrScalerAwsClient.deleteMrScaler(delete);
        System.out.println("Delete Status: " + deleteRes);
    }

    public static void getMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId) {
        MrScalerAwsGetRequest.Builder getBuilder = MrScalerAwsGetRequest.Builder.get();
        MrScalerAwsGetRequest get        = getBuilder.setMrScalerId(mrScalerId).build();

        System.out.println("Sending Request");
        MrScalerAws getRes = mrScalerAwsClient.getMrScaler(get);
        System.out.println("get Success");
        System.out.println(JsonMapper.toJson(getRes));
    }

    public static void getAllMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient) {
        System.out.println("Sending Request");
        List<MrScalerAws> getRes = mrScalerAwsClient.getAllMrScalers();
        System.out.println("get all Success");
        System.out.println(JsonMapper.toJson(getRes));
    }

    public static MrScalerOperatorResponse createMrScaleOperator(SpotinstMrScalerAwsClient mrScalerAwsClient,
                                                                 MrScalerAws mrScalerAws) {
        System.out.println("Building MrScaler Operator");
        MrScalerOperatorAws.Builder mrScalerOperatorBuilder = MrScalerOperatorAws.Builder.get();

        MrScalerOperatorAws mrScalerOperator =
                mrScalerOperatorBuilder.setName("Java-SDK-MrScaler-Operator-Test").setMrScaler(mrScalerAws).build();
        System.out.println(JsonMapper.toJson(mrScalerOperator));

        System.out.println("Building MrScaler Operator Creation Request");

        System.out.println(JsonMapper.toJson(mrScalerOperator));

        System.out.println("Sending Request");
        MrScalerOperatorResponse mrScalerOperatorResponse =
                mrScalerAwsClient.createMrScalerOperator(mrScalerOperator);

        System.out.println("Request Success: ");
        System.out.println(JsonMapper.toJson(mrScalerOperatorResponse));

        return mrScalerOperatorResponse;
    }
}
