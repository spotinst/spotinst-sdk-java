package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.api.mrScaler.aws.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MrScalerAwsUsageExample {
    private final static String auth_token = "your-token";
    private final static String act_id     = "your-account-id";

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

        System.out.println("Delete MrScaler");
        deleteMrScaler(mrScalerAwsClient, mrScalerId);
        System.out.println("Delete Success: " + mrScalerId);

    }

    public static String createMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient) {

        System.out.println("Building Scheduling Parameters");
        List<ApiMrScalerAwsTask>   tasks       = new ArrayList<>();
        ApiMrScalerAwsTask.Builder taskBuilder = ApiMrScalerAwsTask.Builder.get();
        ApiMrScalerAwsTask task = taskBuilder.setCronExpression("cron").setInstanceGroupType("instnace").setIsEnabled(true)
                           .setMaxCapacity(0).setMinCapacity(0).setTargetCapacity(0).setTaskType("type").build();
        tasks.add(task);

        ApiMrScalerAwsSchedulingConfiguration.Builder schedulingBuilder =
                ApiMrScalerAwsSchedulingConfiguration.Builder.get();
        ApiMrScalerAwsSchedulingConfiguration scheduling = schedulingBuilder.setTasks(tasks).build();

        System.out.println("End Building Scheduling Params");
        System.out.println(JsonMapper.toJson(scheduling));


        System.out.println("Building Scaling Parameters");
        List<ApiMrScalerAwsScalingDimenation>   dimList    = new ArrayList<>();
        ApiMrScalerAwsScalingDimenation.Builder dimBuilder = ApiMrScalerAwsScalingDimenation.Builder.get();
        ApiMrScalerAwsScalingDimenation dim = dimBuilder.setName("name").setValue("value").build();
        dimList.add(dim);

        ApiMrScalerAwsScalingAction.Builder actionBuilder = ApiMrScalerAwsScalingAction.Builder.get();

        ApiMrScalerAwsScalingAction scalingAction = actionBuilder.setAdjustment(2).setType("adjustment").build();


        List<ApiMrScalerAwsScalingPolicy> uppolicies = new ArrayList<>();

        ApiMrScalerAwsScalingPolicy.Builder policyBuilder = ApiMrScalerAwsScalingPolicy.Builder.get();

        ApiMrScalerAwsScalingPolicy scaleuppolicy = policyBuilder.setAction(scalingAction).setCooldown(300)

                                                                 .setDimensions(dimList)
                                                                 .setMetricName("test")

                                                                 .setNamespace("AWS")
                                                                 .setOperator("lte").setPeriod(300)
                                                                 .setEvaluationPeriods(1)

                                                                 .setPolicyName("scaleUpPolicy").setStatistic("average")
                                                                 .setUnit("percent").setThreshold(20).build();

        uppolicies.add(scaleuppolicy);


        List<ApiMrScalerAwsScalingPolicy> downpolicies = new ArrayList<>();

        ApiMrScalerAwsScalingPolicy.Builder policyBuilder2 = ApiMrScalerAwsScalingPolicy.Builder.get();

        ApiMrScalerAwsScalingPolicy scaledownpolicy = policyBuilder2.setAction(scalingAction).setCooldown(300)

                                                                    .setDimensions(dimList)
                                                                    .setMetricName("test")

                                                                    .setNamespace("AWS")
                                                                    .setOperator("gte").setPeriod(300)
                                                                    .setEvaluationPeriods(1)

                                                                    .setPolicyName("scaleUpPolicy")
                                                                    .setStatistic("average").setUnit("percent")
                                                                    .setThreshold(90).build();

        downpolicies.add(scaledownpolicy);

        List<ApiMrScalerAwsScalingPolicy> downPolicies = new ArrayList<>();
        ApiMrScalerAwsScalingPolicy.Builder policyBuilder2 = ApiMrScalerAwsScalingPolicy.Builder.get();
        ApiMrScalerAwsScalingPolicy scaleDownPolicy = policyBuilder2.setAction(scalingAction).setCooldown(300)
                                                                    .setDimensions(dimList).setMetricName("YARNMemoryAvailablePercentage")
                                                                    .setNamespace("AWS/ElasticMapReduce").setOperator("gte").setPeriod(300).setEvaluationPeriods(1)
                                                                    .setPolicyName("scaleuppolicy").setStatistic("average").setUnit("percent").setThreshold(90).build();
        downPolicies.add(scaleDownPolicy);

        ApiMrScalerAwsScalingConfiguration.Builder scalingBuilder = ApiMrScalerAwsScalingConfiguration.Builder.get();

        ApiMrScalerAwsScalingConfiguration scaling = scalingBuilder.setDown(downpolicies).setUp(uppolicies).build();

        System.out.println("End Building Scaling Params");
        System.out.println(JsonMapper.toJson(scaling));


        System.out.println("Building Cluster Parameters");
        ApiMrScalerAwsClusterConfiguration.Builder clusterBuilder = ApiMrScalerAwsClusterConfiguration.Builder.get();
        ApiMrScalerAwsClusterConfiguration cluster =
                clusterBuilder.setTerminationProtected(true).setVisibleToAllUsers(true).build();
        System.out.println("End Building Cluster Params");
        System.out.println(JsonMapper.toJson(cluster));


        System.out.println("Building Compute Parameters");
        ApiMrScalerAwsFileParams.Builder fileParamsBuilder = ApiMrScalerAwsFileParams.Builder.get();
        ApiMrScalerAwsFileParams fileParams = fileParamsBuilder.setBucket("test-bucket").setKey("test-key").build();

        ApiMrScalerAwsFile.Builder fileBuilder = ApiMrScalerAwsFile.Builder.get();
        ApiMrScalerAwsFile file = fileBuilder.setFile(fileParams).build();

        Tag.Builder tagBuilder = Tag.Builder.get();
        Tag         tag        = tagBuilder.setTagKey("test-key").setTagValue("test-value").build();
        List<Tag>   tags       = new ArrayList<>();
        tags.add(tag);

        List<String> additionalSec = new ArrayList<>();
        additionalSec.add("m3.xlarge");

        ApiMrScalerAwsApplication.Builder applicationBuilder = ApiMrScalerAwsApplication.Builder.get();
        ApiMrScalerAwsApplication         application        =
                applicationBuilder.setName("app-name").setVersion("app-verion").build();

        List<ApiMrScalerAwsApplication> appList = new ArrayList<>();
        appList.add(application);

        AvailabilityZone.Builder azBuilder = AvailabilityZone.Builder.get();
        AvailabilityZone         az        = azBuilder.setName("us-west-2b").setSubnetId("subnet-1ba25052").build();

        List<AvailabilityZone> availabilityZones = new ArrayList<>();
        availabilityZones.add(az);

        ApiMrScalerAwsVolumeSpecification.Builder volumeBuilder = ApiMrScalerAwsVolumeSpecification.Builder.get();
        ApiMrScalerAwsVolumeSpecification volume =
                volumeBuilder.setIops(1).setSizeInGb(1).setVolumeType("volume-type").build();

        ApiMrScalerAwsEbsBlockDeviceConfig.Builder configBuilder = ApiMrScalerAwsEbsBlockDeviceConfig.Builder.get();
        ApiMrScalerAwsEbsBlockDeviceConfig singleConfig =
                configBuilder.setVolumeSpecification(volume).setVolumesPerInstance(1).build();

        List<ApiMrScalerAwsEbsBlockDeviceConfig> blockList = new ArrayList<>();
        blockList.add(singleConfig);

        ElastigroupCapacityConfiguration.Builder capacityBuilder = ElastigroupCapacityConfiguration.Builder.get();
        ElastigroupCapacityConfiguration         capacity        =
                capacityBuilder.setMaximum(1).setMinimum(0).setTarget(1).build();


        ApiMrScalerAwsEbsConfiguration.Builder ebsBuilder = ApiMrScalerAwsEbsConfiguration.Builder.get();
        ApiMrScalerAwsEbsConfiguration ebs = ebsBuilder.setEbsOptimized(true).build();

        ApiMrScalerAwsMasterGroup.Builder masterGroupBuilder = ApiMrScalerAwsMasterGroup.Builder.get();
        ApiMrScalerAwsMasterGroup masterGroup =
                masterGroupBuilder.setInstanceTypes(additionalSec).setTarget(1).setLifeCycle("ON_DEMAND").build();

        ApiMrScalerAwsCoreGroup.Builder coreGroupBuilder = ApiMrScalerAwsCoreGroup.Builder.get();
        ApiMrScalerAwsCoreGroup coreGroup =
                coreGroupBuilder.setCapacity(capacity).setInstanceTypes(additionalSec).setLifeCycle("SPOT").setTarget(1)
                                .build();

        ApiMrScalerAwsTaskGroup.Builder taskGroupBuilder = ApiMrScalerAwsTaskGroup.Builder.get();
        ApiMrScalerAwsTaskGroup taskgroup =
                taskGroupBuilder.setCapacity(capacity).setInstanceTypes(additionalSec).setLifeCycle("SPOT").build();


        ApiMrScalerAwsInstancegroups.Builder instanceGroupsBuilder = ApiMrScalerAwsInstancegroups.Builder.get();
        ApiMrScalerAwsInstancegroups instancegroups =
                instanceGroupsBuilder.setMasterGroup(masterGroup).setCoreGroup(coreGroup).setTaskGroup(taskgroup)
                                     .build();

        ApiMrScalerAwsComputeConfiguration.Builder computeBuilder = ApiMrScalerAwsComputeConfiguration.Builder.get();
        ApiMrScalerAwsComputeConfiguration compute =
                computeBuilder.setInstanceGroups(instancegroups).setAvailabilityZones(availabilityZones).build();
        System.out.println("End Building Copmute Params");
        System.out.println(JsonMapper.toJson(compute));


        System.out.println("Building Strategy Parameters");
        ApiMrScalerAwsProvisioningTimeout.Builder ptBuilder = ApiMrScalerAwsProvisioningTimeout.Builder.get();
        ApiMrScalerAwsProvisioningTimeout pt = ptBuilder.setTimeout(1).setTimeoutAction("test-action").build();

        ApiMrScalerAwsWrapStrategy.Builder wrapBuilder = ApiMrScalerAwsWrapStrategy.Builder.get();
        ApiMrScalerAwsWrapStrategy wrap = wrapBuilder.setSourceClusterId("test-source-id").build();

        ApiMrScalerAwsNewStrategy.Builder newBuilder = ApiMrScalerAwsNewStrategy.Builder.get();
        ApiMrScalerAwsNewStrategy newing = newBuilder.setReleaseLabel("emr-5.17.0").build();

        ApiMrScalerAwsCloneStrategy.Builder cloneBuilder = ApiMrScalerAwsCloneStrategy.Builder.get();
        ApiMrScalerAwsCloneStrategy clone =
                cloneBuilder.setOriginClusterId("test-id").setIncludeSteps(true).setNumberOfRetries(1).build();

        ApiMrScalerAwsStrategyConfiguration.Builder strategyBuilder = ApiMrScalerAwsStrategyConfiguration.Builder.get();
        ApiMrScalerAwsStrategyConfiguration strategy = strategyBuilder.setNew(newing).build();
        System.out.println("End Building Strategy Params");
        System.out.println(JsonMapper.toJson(strategy));


        System.out.println("Building All Parameters");
        ApiMrScalerAws.Builder mrScalerBuilder = ApiMrScalerAws.Builder.get();

        ApiMrScalerAws mrScalerRequest =
                mrScalerBuilder.setName("Java SDK Test").setRegion("us-west-2").setDescription("description-test")
                               .setStrategy(strategy).setCompute(compute).setCluster(cluster).setScaling(scaling)
                               .build();
        System.out.println(JsonMapper.toJson(mrScalerRequest));

        System.out.println("Building MrScaler Creation Request");
        ApiMrScalerAwsCreationRequest.Builder mrScalerCreationRequestBuilder =
                ApiMrScalerAwsCreationRequest.Builder.get();

        ApiMrScalerAwsCreationRequest creationRequest =
                mrScalerCreationRequestBuilder.setMrScaler(mrScalerRequest).build();

        System.out.println(JsonMapper.toJson(creationRequest));

        System.out.println("Sending Request");
        ApiMrScalerAws mrScalerResponse = mrScalerAwsClient.createMrScaler(creationRequest);

        System.out.println("Request Success: ");
        System.out.println(JsonMapper.toJson(mrScalerResponse));

        return mrScalerResponse.getId();
    }

    public static void updateMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId) {
        System.out.println("Building Cluster Parameters");
        ApiMrScalerAwsClusterConfiguration.Builder clusterBuilder = ApiMrScalerAwsClusterConfiguration.Builder.get();
        ApiMrScalerAwsClusterConfiguration cluster =
                clusterBuilder.setTerminationProtected(false).setVisibleToAllUsers(true).build();
        System.out.println("End Building Cluster Params");
        System.out.println(JsonMapper.toJson(cluster));

        System.out.println("Building All Parameters");
        ApiMrScalerAws.Builder mrScalerBuilder = ApiMrScalerAws.Builder.get();
        ApiMrScalerAws mrScalerRequest = mrScalerBuilder.setCluster(cluster).build();
        System.out.println(JsonMapper.toJson(mrScalerRequest));

        ApiMrScalerAwsUpdateRequest.Builder updateBuilder = ApiMrScalerAwsUpdateRequest.Builder.get();
        ApiMrScalerAwsUpdateRequest         updateRequest = updateBuilder.setMrScaler(mrScalerRequest).build();

        System.out.println("Sending Request");
        Boolean mrScalerUpdateResponse = mrScalerAwsClient.updateMrScaler(updateRequest, mrScalerId);

        System.out.println("Update Status: " + mrScalerUpdateResponse);
    }

    public static void deleteMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId) {
        ApiMrScalerAwsDeleteRequest.Builder deleteBuilder = ApiMrScalerAwsDeleteRequest.Builder.get();
        ApiMrScalerAwsDeleteRequest         delete        = deleteBuilder.setMrScalerId(mrScalerId).build();

        System.out.println("Sending Request");
        Boolean deleteRes = mrScalerAwsClient.deleteMrScaler(delete);
        System.out.println("Delete Status: " + deleteRes);
    }

    public static void getMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient, String mrScalerId) {
        ApiMrScalerAwsGetRequest.Builder getBuilder = ApiMrScalerAwsGetRequest.Builder.get();
        ApiMrScalerAwsGetRequest         get        = getBuilder.setMrScalerId(mrScalerId).build();

        System.out.println("Sending Request");
        ApiMrScalerAws getRes = mrScalerAwsClient.getMrScaler(get);
        System.out.println("get Success");
        System.out.println(JsonMapper.toJson(getRes));
    }

    public static void getAllMrScaler(SpotinstMrScalerAwsClient mrScalerAwsClient) {
        System.out.println("Sending Request");
        List<ApiMrScalerAws> getRes = mrScalerAwsClient.getAllMrScalers();
        System.out.println("get all Success");
        System.out.println(JsonMapper.toJson(getRes));
    }

}
