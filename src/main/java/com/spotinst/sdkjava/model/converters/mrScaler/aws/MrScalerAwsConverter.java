package com.spotinst.sdkjava.model.converters.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.*;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.*;
import java.util.List;
import java.util.stream.Collectors;

public class MrScalerAwsConverter {
    // region toBl
    public static MrScalerAws toBl(ApiMrScalerAws apiMrScalerAws) {
        MrScalerAws mrScalerAws = null;

        if (apiMrScalerAws != null) {
            MrScalerAws.Builder  mrScalerBuilder= MrScalerAws.Builder.get();

            if (apiMrScalerAws.isNameSet()) {
                mrScalerBuilder.setName(apiMrScalerAws.getName());
            }
            if (apiMrScalerAws.isDescriptionSet()) {
                mrScalerBuilder.setDescription(apiMrScalerAws.getDescription());
            }
            if (apiMrScalerAws.isRegionSet()) {
                mrScalerBuilder.setRegion(apiMrScalerAws.getRegion());
            }
            if (apiMrScalerAws.isIdSet()) {
                mrScalerBuilder.setId(apiMrScalerAws.getId());
            }
            if (apiMrScalerAws.isComputeSet()) {
                mrScalerBuilder.setCompute(toBl(apiMrScalerAws.getCompute()));
            }
            if (apiMrScalerAws.isCoreScalingSet()) {
                mrScalerBuilder.setCoreScaling(toBl(apiMrScalerAws.getCoreScaling()));
            }
            if (apiMrScalerAws.isClusterSet()) {
                mrScalerBuilder.setCluster(toBl(apiMrScalerAws.getCluster()));
            }
            if (apiMrScalerAws.isStrategySet()) {
                mrScalerBuilder.setStrategy(toBl(apiMrScalerAws.getStrategy()));
            }
            if (apiMrScalerAws.isScalingSet() && apiMrScalerAws.getScaling() != null) {
                mrScalerBuilder.setScaling(toBl(apiMrScalerAws.getScaling()));
            }
            if (apiMrScalerAws.isSchedulingSet()) {
                mrScalerBuilder.setScheduling(toBl(apiMrScalerAws.getScheduling()));
            }
            mrScalerAws = mrScalerBuilder.build();
        }

        return mrScalerAws;
    }

    public static MrScalerAwsComputeConfiguration toBl(ApiMrScalerAwsComputeConfiguration apiCompute) {
        MrScalerAwsComputeConfiguration blCompute = null;

        if (apiCompute != null) {
            MrScalerAwsComputeConfiguration.Builder  mrComputeBuilder =
                    MrScalerAwsComputeConfiguration.Builder.get();

            if (apiCompute.isEbsRootVolumeSizeSet()) {
                mrComputeBuilder.setEbsRootVolumeSize(apiCompute.getEbsRootVolumeSize());
            }
            if (apiCompute.isEmrManagedMasterSecurityGroupSet()) {
                mrComputeBuilder.setEmrManagedMasterSecurityGroup(apiCompute.getEmrManagedMasterSecurityGroup());
            }
            if (apiCompute.isEmrManagedSlaveSecurityGroupSet()) {
                mrComputeBuilder.setEmrManagedSlaveSecurityGroup(apiCompute.getEmrManagedSlaveSecurityGroup());
            }
            if (apiCompute.isServiceAccessSecurityGroupSet()) {
                mrComputeBuilder.setServiceAccessSecurityGroup(apiCompute.getServiceAccessSecurityGroup());
            }
            if (apiCompute.isCustomAmiIdSet()) {
                mrComputeBuilder.setCustomAmiId(apiCompute.getCustomAmiId());
            }
            if (apiCompute.isRepoUpgradeOnBootSet()) {
                mrComputeBuilder.setRepoUpgradeOnBoot(apiCompute.getRepoUpgradeOnBoot());
            }
            if (apiCompute.isEc2KeyNameSet()) {
                mrComputeBuilder.setEc2KeyName(apiCompute.getEc2KeyName());
            }
            if (apiCompute.isAdditionalMasterSecurityGroupsSet()) {
                mrComputeBuilder.setAdditionalMasterSecurityGroups(apiCompute.getAdditionalMasterSecurityGroups());
            }
            if (apiCompute.isAdditionalSlaveSecurityGroupsSet()) {
                mrComputeBuilder.setAdditionalSlaveSecurityGroups(apiCompute.getAdditionalSlaveSecurityGroups());
            }
            if (apiCompute.isAvailabilityZonesSet()) {
                mrComputeBuilder.setAvailabilityZones(apiCompute.getAvailabilityZones());
            }
            if (apiCompute.isTagsSet()) {
                mrComputeBuilder.setTags(apiCompute.getTags());
            }
            if (apiCompute.isBootstrapActionsSet()) {
                mrComputeBuilder.setBootstrapActions(toBl(apiCompute.getBootstrapActions()));
            }
            if (apiCompute.isConfigurationsSet()) {
                mrComputeBuilder.setConfigurations(toBl(apiCompute.getConfigurations()));
            }
            if (apiCompute.isStepsSet()) {
                mrComputeBuilder.setSteps(toBl(apiCompute.getSteps()));
            }

            if (apiCompute.isApplicationsSet()) {
                List<MrScalerAwsApplication> blApplications =
                        apiCompute.getApplications().stream().map(MrScalerAwsConverter::toBl)
                                .collect(Collectors.toList());
                mrComputeBuilder.setApplications(blApplications);
            }
            if (apiCompute.isInstanceGroupsSet()) {
                mrComputeBuilder.setInstanceGroups(toBl(apiCompute.getInstanceGroups()));
            }
            blCompute = mrComputeBuilder.build();
        }

        return blCompute;
    }

    public static MrScalerAwsFileParams toBl(ApiMrScalerAwsFileParams apiFileParams) {
        MrScalerAwsFileParams blFileParams = null;

        if (apiFileParams != null) {
            MrScalerAwsFileParams.Builder  fileBuilder =
                    MrScalerAwsFileParams.Builder.get();

            if (apiFileParams.isBucketSet()) {
                fileBuilder.setBucket(apiFileParams.getBucket());
            }
            if (apiFileParams.isKeySet()) {
                fileBuilder.setKey(apiFileParams.getKey());
            }
            blFileParams = fileBuilder.build();
        }

        return blFileParams;
    }

    public static MrScalerAwsFile toBl(ApiMrScalerAwsFile apiFile) {
        MrScalerAwsFile blFile = null;

        if (apiFile != null) {
            MrScalerAwsFile.Builder blFileBuilder = MrScalerAwsFile.Builder.get();
            if (apiFile.isFileSet()) {
                blFileBuilder.setFile(toBl(apiFile.getFile()));
            }
            blFile = blFileBuilder.build();
        }
        return blFile;
    }

    public static MrScalerAwsApplication toBl(ApiMrScalerAwsApplication apiApplications) {
        MrScalerAwsApplication blApplication = null;

        if (apiApplications != null) {
            MrScalerAwsApplication.Builder blApplicationBuilder = MrScalerAwsApplication.Builder.get();

                if (apiApplications.isNameSet()) {
                    blApplicationBuilder.setName(apiApplications.getName());
                }
                if (apiApplications.isVersionSet()) {
                    blApplicationBuilder.setVersion(apiApplications.getVersion());
                }

                blApplication = blApplicationBuilder.build();
            }
        return blApplication;
    }

    public static MrScalerAwsInstancegroups toBl(ApiMrScalerAwsInstancegroups apiInstancegroups) {
        MrScalerAwsInstancegroups blInstanceGroups = null;

        if (apiInstancegroups != null) {
            MrScalerAwsInstancegroups.Builder blInstanceGroupsBuilder =
                    MrScalerAwsInstancegroups.Builder.get();

            if (apiInstancegroups.isCoreGroupSet()) {
                blInstanceGroupsBuilder.setCoreGroup(toBl(apiInstancegroups.getCoreGroup()));
            }
            if (apiInstancegroups.isMasterGroupSet()) {
                blInstanceGroupsBuilder.setMasterGroup(toBl(apiInstancegroups.getMasterGroup()));
            }
            if (apiInstancegroups.isTaskGroupSet()) {
                blInstanceGroupsBuilder.setTaskGroup(toBl(apiInstancegroups.getTaskGroup()));
            }
            blInstanceGroups = blInstanceGroupsBuilder.build();
        }
        return blInstanceGroups;
    }

    public static MrScalerAwsCoreGroup toBl(ApiMrScalerAwsCoreGroup apiCoreGroup) {
        MrScalerAwsCoreGroup blCoreGroup = null;

        if (apiCoreGroup != null) {
            MrScalerAwsCoreGroup.Builder blCoreGroupBuilder = MrScalerAwsCoreGroup.Builder.get();

            if (apiCoreGroup.isInstanceTypesSet()) {
                blCoreGroupBuilder.setInstanceTypes(apiCoreGroup.getInstanceTypes());
            }
            if (apiCoreGroup.isLifeCycleSet()) {
                blCoreGroupBuilder.setLifeCycle(apiCoreGroup.getLifeCycle());
            }
            if (apiCoreGroup.isTargetSet()) {
                blCoreGroupBuilder.setTarget(apiCoreGroup.getTarget());
            }
            if (apiCoreGroup.isCapacitySet()) {
                blCoreGroupBuilder.setCapacity(apiCoreGroup.getCapacity());
            }
            if (apiCoreGroup.isConfigurationsSet()) {
                blCoreGroupBuilder.setConfigurations(toBl(apiCoreGroup.getConfigurations()));
            }
            if (apiCoreGroup.isEbsConfigurationSet()) {
                blCoreGroupBuilder.setEbsConfiguration(toBl(apiCoreGroup.getEbsConfiguration()));
            }
            blCoreGroup = blCoreGroupBuilder.build();
        }
        return blCoreGroup;
    }

    public static MrScalerAwsMasterGroup toBl(ApiMrScalerAwsMasterGroup apiMasterGroup) {
        MrScalerAwsMasterGroup blMasterGroup = null;

        if (apiMasterGroup != null) {
            MrScalerAwsMasterGroup.Builder blMasterGroupBuilder = MrScalerAwsMasterGroup.Builder.get();

            if (apiMasterGroup.isInstanceTypesSet()) {
                blMasterGroupBuilder.setInstanceTypes(apiMasterGroup.getInstanceTypes());
            }
            if (apiMasterGroup.isTargetSet()) {
                blMasterGroupBuilder.setTarget(apiMasterGroup.getTarget());
            }
            if (apiMasterGroup.isLifeCycleSet()) {
                blMasterGroupBuilder.setLifeCycle(apiMasterGroup.getLifeCycle());
            }
            if (apiMasterGroup.isConfigurationsSet()) {
                blMasterGroupBuilder.setConfigurations(toBl(apiMasterGroup.getConfigurations()));
            }
            if (apiMasterGroup.isEbsConfigurationSet()) {
                blMasterGroupBuilder.setEbsConfiguration(toBl(apiMasterGroup.getEbsConfiguration()));
            }
            blMasterGroup = blMasterGroupBuilder.build();
        }
        return blMasterGroup;
    }

    public static MrScalerAwsTaskGroup toBl(ApiMrScalerAwsTaskGroup apiTaskGroup) {
        MrScalerAwsTaskGroup blTaskGroup = null;

        if (apiTaskGroup != null) {
            MrScalerAwsTaskGroup.Builder blTaskGroupBuilder = MrScalerAwsTaskGroup.Builder.get();

            if (apiTaskGroup.isInstanceTypesSet()) {
                blTaskGroupBuilder.setInstanceTypes(apiTaskGroup.getInstanceTypes());
            }
            if (apiTaskGroup.isLifeCycleSet()) {
                blTaskGroupBuilder.setLifeCycle(apiTaskGroup.getLifeCycle());
            }
            if (apiTaskGroup.isCapacitySet()) {
                blTaskGroupBuilder.setCapacity(apiTaskGroup.getCapacity());
            }
            if (apiTaskGroup.isEbsConfigurationSet()) {
                blTaskGroupBuilder.setEbsConfiguration(toBl(apiTaskGroup.getEbsConfiguration()));
            }
            if (apiTaskGroup.isConfigurationsSet()) {
                blTaskGroupBuilder.setConfigurations(toBl(apiTaskGroup.getConfigurations()));
            }
            blTaskGroup = blTaskGroupBuilder.build();
        }
        return blTaskGroup;
    }

    public static MrScalerAwsEbsConfiguration toBl(ApiMrScalerAwsEbsConfiguration apiEbsConfig) {
        MrScalerAwsEbsConfiguration blEbsConfig = null;

        if (apiEbsConfig != null) {
            MrScalerAwsEbsConfiguration.Builder blEbsConfigBuilder =
                    MrScalerAwsEbsConfiguration.Builder.get();

            if (apiEbsConfig.isEbsOptimizedSet()) {
                blEbsConfigBuilder.setEbsOptimized(apiEbsConfig.getEbsOptimized());
            }
            if (apiEbsConfig.isEbsBlockDeviceConfigsSet()) {
                List<MrScalerAwsEbsBlockDeviceConfig> blBlockDeviceConfigs =
                        apiEbsConfig.getEbsBlockDeviceConfigs().stream().map(MrScalerAwsConverter::toBl)
                                .collect(Collectors.toList());
                blEbsConfigBuilder.setEbsBlockDeviceConfigs(blBlockDeviceConfigs);
            }
            blEbsConfig = blEbsConfigBuilder.build();
        }
        return blEbsConfig;
    }

    public static MrScalerAwsEbsBlockDeviceConfig toBl(ApiMrScalerAwsEbsBlockDeviceConfig apiEbsBlockdevice) {
        MrScalerAwsEbsBlockDeviceConfig blEbsBlockdevice = null;

        if (apiEbsBlockdevice != null) {
            MrScalerAwsEbsBlockDeviceConfig.Builder blEbsBlockdeviceBuilder =
                    MrScalerAwsEbsBlockDeviceConfig.Builder.get();

            if (apiEbsBlockdevice.isVolumesPerInstanceSet()) {
                blEbsBlockdeviceBuilder.setVolumesPerInstance(apiEbsBlockdevice.getVolumesPerInstance());
            }
            if (apiEbsBlockdevice.isVolumeSpecificationSet()) {
                blEbsBlockdeviceBuilder.setVolumeSpecification(toBl(apiEbsBlockdevice.getVolumeSpecification()));
            }
            blEbsBlockdevice = blEbsBlockdeviceBuilder.build();
        }
        return blEbsBlockdevice;
    }

    public static MrScalerAwsVolumeSpecification toBl(ApiMrScalerAwsVolumeSpecification apiVolumeSpecification){
        MrScalerAwsVolumeSpecification volumeSpecification = null;

        if(apiVolumeSpecification != null){
            MrScalerAwsVolumeSpecification.Builder volumeSpecificationBuilder =
                    MrScalerAwsVolumeSpecification.Builder.get();

            if(apiVolumeSpecification.isIopsSet()){
                volumeSpecificationBuilder.setIops(apiVolumeSpecification.getIops());
            }

            if(apiVolumeSpecification.isSizeInGBSet()){
                volumeSpecificationBuilder.setSizeInGb(apiVolumeSpecification.getSizeInGB());
            }

            if(apiVolumeSpecification.isVolumeTypeSet()){
                volumeSpecificationBuilder.setVolumeType(apiVolumeSpecification.getVolumeType());
            }

            volumeSpecification = volumeSpecificationBuilder.build();
        }
        return volumeSpecification;
    }

    public static MrScalerAwsClusterConfiguration toBl(ApiMrScalerAwsClusterConfiguration apiCluster) {
        MrScalerAwsClusterConfiguration blCluster = null;

        if (apiCluster != null) {
            MrScalerAwsClusterConfiguration.Builder blClusterBuilder = MrScalerAwsClusterConfiguration.Builder.get();

            if (apiCluster.isVisibleToAllUsersSet()) {
                blClusterBuilder.setVisibleToAllUsers(apiCluster.getVisibleToAllUsers());
            }
            if (apiCluster.isTerminationProtectedSet()) {
                blClusterBuilder.setTerminationProtected(apiCluster.getTerminationProtected());
            }
            if (apiCluster.isServiceRoleSet()) {
                blClusterBuilder.setServiceRole(apiCluster.getServiceRole());
            }
            if (apiCluster.isSecurityConfigurationSet()) {
                blClusterBuilder.setSecurityConfiguration(apiCluster.getSecurityConfiguration());
            }
            if (apiCluster.isLogUriSet()) {
                blClusterBuilder.setLogUri(apiCluster.getLogUri());
            }
            if (apiCluster.isKeepJobFlowAliveWhenNoStepsSet()) {
                blClusterBuilder.setKeepJobFlowAliveWhenNoSteps(apiCluster.getKeepJobFlowAliveWhenNoSteps());
            }
            if (apiCluster.isJobFlowRoleSet()) {
                blClusterBuilder.setJobFlowRole(apiCluster.getJobFlowRole());
            }
            if (apiCluster.isAdditionalInfoSet()) {
                blClusterBuilder.setAdditionalInfo(apiCluster.getAdditionalInfo());
            }
            blCluster = blClusterBuilder.build();
        }
        return blCluster;
    }

    public static MrScalerAwsStrategyConfiguration toBl(ApiMrScalerAwsStrategyConfiguration apiStrategy) {
        MrScalerAwsStrategyConfiguration blStrategy = null;

        if (apiStrategy != null) {
            MrScalerAwsStrategyConfiguration.Builder blStrategyBuilder =
                    MrScalerAwsStrategyConfiguration.Builder.get();

            if (apiStrategy.isCloningSet()) {
                blStrategyBuilder.setCloning(toBl(apiStrategy.getCloning()));
            }

            if (apiStrategy.isNewSet()) {
                blStrategyBuilder.setNew(toBl(apiStrategy.getNew()));
            }

            if (apiStrategy.isProvisioningTimeoutSet()) {
                blStrategyBuilder.setProvisioningTimeout(toBl(apiStrategy.getProvisioningTimeout()));
            }

            if (apiStrategy.isWrappingSet()) {
                blStrategyBuilder.setWrapping(toBl(apiStrategy.getWrapping()));
            }
            blStrategy = blStrategyBuilder.build();
        }
        return blStrategy;
    }

    public static MrScalerAwsCloneStrategy toBl(ApiMrScalerAwsCloneStrategy apiCloneStrategy) {
        MrScalerAwsCloneStrategy strategy = null;
        if (apiCloneStrategy != null) {

            MrScalerAwsCloneStrategy.Builder strategyBuilder = MrScalerAwsCloneStrategy.Builder.get();
            if (apiCloneStrategy.isIncludeStepsSet()) {
                strategyBuilder.setIncludeSteps(apiCloneStrategy.getIncludeSteps());
            }
            if (apiCloneStrategy.isNumberOfRetriesSet()) {
                strategyBuilder.setNumberOfRetries(apiCloneStrategy.getNumberOfRetries());
            }
            if (apiCloneStrategy.isOriginClusterIdSet()) {
                strategyBuilder.setOriginClusterId(apiCloneStrategy.getOriginClusterId());
            }
            strategy = strategyBuilder.build();
        }
        return strategy;
    }

    public static MrScalerAwsNewStrategy toBl (ApiMrScalerAwsNewStrategy apiNewstratgey){
        MrScalerAwsNewStrategy newStrategy = null;

        if (apiNewstratgey != null ) {
            MrScalerAwsNewStrategy.Builder blNewBuilder = MrScalerAwsNewStrategy.Builder.get();

            if (apiNewstratgey.isReleaseLabelSet()) {
                blNewBuilder.setReleaseLabel(apiNewstratgey.getReleaseLabel());
            }
            if (apiNewstratgey.isNumberOfRetriesSet()) {
                blNewBuilder.setNumberOfRetries(apiNewstratgey.getNumberOfRetries());
            }
            newStrategy = blNewBuilder.build();
        }
        return newStrategy;
    }

    public static MrScalerAwsWrapStrategy toBl(ApiMrScalerAwsWrapStrategy apiWrapStrategy) {
        MrScalerAwsWrapStrategy wrapStrategy = null;

        if (apiWrapStrategy != null) {
            MrScalerAwsWrapStrategy.Builder wrapStrategybuilder = MrScalerAwsWrapStrategy.Builder.get();

            if (apiWrapStrategy.isSourceClusterIdSet()) {
                wrapStrategybuilder.setSourceClusterId(apiWrapStrategy.getSourceClusterId());
            }

            wrapStrategy = wrapStrategybuilder.build();
        }
        return wrapStrategy;
    }
    public static MrScalerAwsProvisioningTimeout toBl(ApiMrScalerAwsProvisioningTimeout apiProvisiontimeout){
        MrScalerAwsProvisioningTimeout provisioningTimeout = null;

        if(apiProvisiontimeout != null){
            MrScalerAwsProvisioningTimeout.Builder provisionTimeoutBuilder =
                    MrScalerAwsProvisioningTimeout.Builder.get();

            if (apiProvisiontimeout.isTimeoutSet()) {
                provisionTimeoutBuilder.setTimeout(apiProvisiontimeout.getTimeout());
            }
            if (apiProvisiontimeout.isTimeoutActionSet()) {
                provisionTimeoutBuilder.setTimeoutAction(apiProvisiontimeout.getTimeoutAction());
            }
            provisioningTimeout = provisionTimeoutBuilder.build();
        }
        return provisioningTimeout;
    }

    public static MrScalerAwsScalingConfiguration toBl(ApiMrScalerAwsScalingConfiguration apiScaling) {
        MrScalerAwsScalingConfiguration blScaling = null;

        if (apiScaling != null) {
            MrScalerAwsScalingConfiguration.Builder blScalingbuilder = MrScalerAwsScalingConfiguration.Builder.get();

            if (apiScaling.isUpSet() && apiScaling.getUp() != null) {
                List<MrScalerAwsScalingPolicy> blUpConfig =
                        apiScaling.getUp().stream().map(MrScalerAwsConverter::toBl)
                                .collect(Collectors.toList());
                blScalingbuilder.setUp(blUpConfig);
            }
            if (apiScaling.isDownSet() && apiScaling.getDown() != null) {
                List<MrScalerAwsScalingPolicy> blDownConfig = apiScaling.getDown().stream().map(MrScalerAwsConverter::toBl)
                        .collect(Collectors.toList());
                blScalingbuilder.setDown(blDownConfig);
            }
            blScaling = blScalingbuilder.build();
        }

        return blScaling;
    }

    public static MrScalerAwsScalingPolicy toBl(ApiMrScalerAwsScalingPolicy apiScalingPolicies) {
        MrScalerAwsScalingPolicy blScalingPolicies = null;

        if (apiScalingPolicies != null) {
                MrScalerAwsScalingPolicy.Builder policyBuilder = MrScalerAwsScalingPolicy.Builder.get();

                if (apiScalingPolicies.isPolicyNameSet()) {
                    policyBuilder.setPolicyName(apiScalingPolicies.getPolicyName());
                }
                if (apiScalingPolicies.isThresholdSet()) {
                    policyBuilder.setThreshold(apiScalingPolicies.getThreshold());
                }
                if (apiScalingPolicies.isStatisticSet()) {
                    policyBuilder.setStatistic(apiScalingPolicies.getStatistic());
                }
                if (apiScalingPolicies.isUnitSet()) {
                    policyBuilder.setUnit(apiScalingPolicies.getUnit());
                }
                if (apiScalingPolicies.isPeriodSet()) {
                    policyBuilder.setPeriod(apiScalingPolicies.getPeriod());
                }
                if (apiScalingPolicies.isOperatorSet()) {
                    policyBuilder.setOperator(apiScalingPolicies.getOperator());
                }
                if (apiScalingPolicies.isNamespaceSet()) {
                    policyBuilder.setNamespace(apiScalingPolicies.getNamespace());
                }
                if (apiScalingPolicies.isMinTargetCapacitySet()) {
                    policyBuilder.setMinTargetCapacity(apiScalingPolicies.getMinTargetCapacity());
                }
                if (apiScalingPolicies.isMetricNameSet()) {
                    policyBuilder.setMetricName(apiScalingPolicies.getMetricName());
                }
                if (apiScalingPolicies.isEvaluationPeriodsSet()) {
                    policyBuilder.setEvaluationPeriods(apiScalingPolicies.getEvaluationPeriods());
                }
                if (apiScalingPolicies.isCooldownSet()) {
                    policyBuilder.setCooldown(apiScalingPolicies.getCooldown());
                }
                if (apiScalingPolicies.isAdjustmentSet()) {
                    policyBuilder.setAdjustment(apiScalingPolicies.getAdjustment());
                }
                if (apiScalingPolicies.isActionSet()) {
                    policyBuilder.setAction(toBl(apiScalingPolicies.getAction()));
                }
                if (apiScalingPolicies.isDimensionsSet()) {
                    List<MrScalerAwsScalingDimenation> dimensions = apiScalingPolicies.getDimensions().stream().map(MrScalerAwsConverter::toBl)
                            .collect(Collectors.toList());
                    policyBuilder.setDimensions(dimensions);
            }
            blScalingPolicies = policyBuilder.build();
        }

        return blScalingPolicies;
    }

    public static MrScalerAwsScalingAction toBl(ApiMrScalerAwsScalingAction scalerAwsScalingAction){
        MrScalerAwsScalingAction scalingAction = null;

        if(scalerAwsScalingAction != null) {
            MrScalerAwsScalingAction.Builder scalingActionBuilder = MrScalerAwsScalingAction.Builder.get();

            if(scalerAwsScalingAction.isAdjustmentSet()){
                scalingActionBuilder.setAdjustment(scalerAwsScalingAction.getAdjustment());
            }
            if(scalerAwsScalingAction.isMaximumSet()){
                scalingActionBuilder.setMaximum(scalerAwsScalingAction.getMaximum());
            }
            if(scalerAwsScalingAction.isMinimumSet()){
                scalingActionBuilder.setMinimum(scalerAwsScalingAction.getMinimum());
            }
            if(scalerAwsScalingAction.isMinTargetCapacitySet()){
                scalingActionBuilder.setMinTargetCapacity(scalerAwsScalingAction.getMinTargetCapacity());
            }
            if(scalerAwsScalingAction.isTargetSet()){
                scalingActionBuilder.setTarget(scalerAwsScalingAction.getTarget());
            }
            if(scalerAwsScalingAction.isTypeSet()){
                scalingActionBuilder.setType(scalerAwsScalingAction.getType());
            }
            scalingAction = scalingActionBuilder.build();
        }
        return scalingAction;
    }

    public static MrScalerAwsScalingDimenation toBl(ApiMrScalerAwsScalingDimenation apiScalingDimenation){
        MrScalerAwsScalingDimenation scalingDimenation = null;

        if(apiScalingDimenation != null) {
            MrScalerAwsScalingDimenation.Builder dimenationBuilder = MrScalerAwsScalingDimenation.Builder.get();

            if(apiScalingDimenation.isNameSet()){
                dimenationBuilder.setName(apiScalingDimenation.getName());
            }
            if(apiScalingDimenation.isValueSet()){
                dimenationBuilder.setValue(apiScalingDimenation.getValue());
            }
            scalingDimenation = dimenationBuilder.build();
        }
        return scalingDimenation;

    }

    public static MrScalerAwsSchedulingConfiguration toBl(ApiMrScalerAwsSchedulingConfiguration apiScheduling) {
        MrScalerAwsSchedulingConfiguration blScheduling = null;

        if (apiScheduling != null) {
            MrScalerAwsSchedulingConfiguration.Builder blSchedulingBuilder = MrScalerAwsSchedulingConfiguration.Builder.get();

            if (apiScheduling.isTasksSet()) {
                List<MrScalerAwsTask> blTasks = apiScheduling.getTasks().stream().map(MrScalerAwsConverter::toBl)
                        .collect(Collectors.toList());
                blSchedulingBuilder.setTasks(blTasks);
            }
            blScheduling = blSchedulingBuilder.build();
        }

        return blScheduling;
    }

    public static MrScalerAwsTask toBl(ApiMrScalerAwsTask apiTasks) {
        MrScalerAwsTask blTasks = null;

        if(apiTasks != null){
            MrScalerAwsTask.Builder taskBuilder = MrScalerAwsTask.Builder.get();

            if (apiTasks.isTaskTypeSet()) {
                taskBuilder.setTaskType(apiTasks.getTaskType());
            }
            if (apiTasks.isTargetCapacitySet()) {
                taskBuilder.setTargetCapacity(apiTasks.getTargetCapacity());
            }
            if (apiTasks.isMinCapacitySet()) {
                taskBuilder.setMinCapacity(apiTasks.getMinCapacity());
            }
            if (apiTasks.isMaxCapacitySet()) {
                taskBuilder.setMaxCapacity(apiTasks.getMaxCapacity());
            }
            if (apiTasks.isIsEnabledSet()) {
                taskBuilder.setIsEnabled(apiTasks.getIsEnabled());
            }
            if (apiTasks.isInstanceGroupTypeSet()) {
                taskBuilder.setInstanceGroupType(apiTasks.getInstanceGroupType());
            }
            if (apiTasks.isCronExpressionSet()) {
                taskBuilder.setCronExpression(apiTasks.getCronExpression());
            }
            blTasks = taskBuilder.build();
        }

        return blTasks;
    }

    public static MrScalerOperatorAws toBl(ApiMrScalerOperatorAws apiMrScalerOperatorAws) {
        MrScalerOperatorAws mrScalerOperatorAws = null;

        if (apiMrScalerOperatorAws != null) {
            MrScalerOperatorAws.Builder scalerOperatorAwsBuilder = MrScalerOperatorAws.Builder.get();

            if (apiMrScalerOperatorAws.isMrScalerSet()) {
                ApiMrScalerAws apiMrScalerAws = apiMrScalerOperatorAws.getMrScaler();
                MrScalerAws mrScalerAws = MrScalerAwsConverter.toBl(apiMrScalerAws);
                scalerOperatorAwsBuilder.setMrScaler(mrScalerAws);
            }

            if (apiMrScalerOperatorAws.isNameSet()) {
                scalerOperatorAwsBuilder.setName(apiMrScalerOperatorAws.getName());
            }
            mrScalerOperatorAws = scalerOperatorAwsBuilder.build();
        }

        return mrScalerOperatorAws;
    }

    public static MrScalerOperatorResponse toBl(ApiMrScalerOperatorAwsResponse apiMrScalerOperatorAws) {
        MrScalerOperatorResponse blMrScalerOperatorAws = null;

        if (apiMrScalerOperatorAws != null) {
            MrScalerOperatorResponse.Builder scalerOperatorBuilder = MrScalerOperatorResponse.Builder.get();

            if (apiMrScalerOperatorAws.isMrScalerIdSet()) {
                scalerOperatorBuilder.setMrScalerId(apiMrScalerOperatorAws.getMrScalerId());
            }

            if (apiMrScalerOperatorAws.isNameSet()) {
                scalerOperatorBuilder.setName(apiMrScalerOperatorAws.getName());
            }

            if (apiMrScalerOperatorAws.isStateSet()) {
                scalerOperatorBuilder.setState(apiMrScalerOperatorAws.getState());
            }
            blMrScalerOperatorAws = scalerOperatorBuilder.build();
        }

        return blMrScalerOperatorAws;
    }

    public static MrScalerListInstancesAws toBl(ApiMrScalerListInstancesAws apiMrScalerListInstancesAws) {
        MrScalerListInstancesAws mrScalerListInstancesAws = null;

        if (apiMrScalerListInstancesAws != null) {
            MrScalerListInstancesAws.Builder instancesBuilder= MrScalerListInstancesAws.Builder.get();

            if (apiMrScalerListInstancesAws.isInstanceIdSet()) {
                instancesBuilder.setInstanceId(apiMrScalerListInstancesAws.getInstanceId());
            }

            if (apiMrScalerListInstancesAws.isInstanceGroupIdSet()) {
                instancesBuilder.setInstanceGroupId(apiMrScalerListInstancesAws.getInstanceGroupId());
            }

            if (apiMrScalerListInstancesAws.isInstanceGroupRoleSet()) {
                instancesBuilder.setInstanceGroupRole(apiMrScalerListInstancesAws.getInstanceGroupRole());
            }

            if (apiMrScalerListInstancesAws.isInstanceTypeSet()) {
                instancesBuilder.setInstanceType(apiMrScalerListInstancesAws.getInstanceType());
            }

            if (apiMrScalerListInstancesAws.isAvailabilityZoneSet()) {
                instancesBuilder.setAvailabilityZone(apiMrScalerListInstancesAws.getAvailabilityZone());
            }

            if (apiMrScalerListInstancesAws.isStatusSet()) {
                instancesBuilder.setStatus(apiMrScalerListInstancesAws.getStatus());
            }
            mrScalerListInstancesAws = instancesBuilder.build();
        }

        return mrScalerListInstancesAws;
    }

    public static MrScalerListScalersAws toBl(ApiMrScalerListScalersAws apiMrScalerListScalersAws) {
        MrScalerListScalersAws mrScalerListScalersAws = null;

        if (apiMrScalerListScalersAws != null) {
            MrScalerListScalersAws.Builder scalersAwsBuilder = MrScalerListScalersAws.Builder.get();

            if (apiMrScalerListScalersAws.isIdSet()) {
                scalersAwsBuilder.setId(apiMrScalerListScalersAws.getId());
            }

            if (apiMrScalerListScalersAws.isAvailabilityZoneSet()) {
                scalersAwsBuilder.setAvailabilityZone(apiMrScalerListScalersAws.getAvailabilityZone());
            }

            if (apiMrScalerListScalersAws.isStateSet()) {
                scalersAwsBuilder.setState(apiMrScalerListScalersAws.getState());
            }
            mrScalerListScalersAws = scalersAwsBuilder.build();
        }
        return mrScalerListScalersAws;
    }

    public static MrScalerScaleDownAws toBl(ApiMrScalerScaleDownAws apiMrScalerScaleDownAws) {
        MrScalerScaleDownAws mrScalerScaleDownAws = null;

        if (apiMrScalerScaleDownAws != null) {
            MrScalerScaleDownAws.Builder scaleDownAwsBuilder = MrScalerScaleDownAws.Builder.get();

            if (apiMrScalerScaleDownAws.isModifiedInstanceGroupsSet()) {
                scaleDownAwsBuilder.setModifiedInstanceGroups(apiMrScalerScaleDownAws.getModifiedInstanceGroups());
            }

            if (apiMrScalerScaleDownAws.isVictimInstancesSet()) {
                scaleDownAwsBuilder.setVictimInstances(apiMrScalerScaleDownAws.getVictimInstances());
            }
            mrScalerScaleDownAws = scaleDownAwsBuilder.build();
        }
        return mrScalerScaleDownAws;
    }

    public static MrScalerScaleUpAws toBl(ApiMrScalerScaleUpAws apiMrScalerScaleUpAws) {
        MrScalerScaleUpAws mrScalerScaleUpAws = null;

        if (apiMrScalerScaleUpAws != null) {
            MrScalerScaleUpAws.Builder scaleUpAwsBuilder = MrScalerScaleUpAws.Builder.get();

            if (apiMrScalerScaleUpAws.isModifiedInstanceGroupsSet()) {
                scaleUpAwsBuilder.setModifiedInstanceGroups(apiMrScalerScaleUpAws.getModifiedInstanceGroups());
            }

            if (apiMrScalerScaleUpAws.isNewInstanceGroupsSet()) {
                scaleUpAwsBuilder.setNewInstanceGroups(apiMrScalerScaleUpAws.getNewInstanceGroups());
            }
            mrScalerScaleUpAws = scaleUpAwsBuilder.build();
        }
        return mrScalerScaleUpAws;
    }

    //region toDal
    public static ApiMrScalerAws toDal(MrScalerAws mrScalerAws) {
        ApiMrScalerAws apiMrScalerAws = null;

        if (mrScalerAws != null) {
            apiMrScalerAws = new ApiMrScalerAws();

            if (mrScalerAws.isNameSet()) {
                apiMrScalerAws.setName(mrScalerAws.getName());
            }
            if (mrScalerAws.isDescriptionSet()) {
                apiMrScalerAws.setDescription(mrScalerAws.getDescription());
            }
            if (mrScalerAws.isRegionSet()) {
                apiMrScalerAws.setRegion(mrScalerAws.getRegion());
            }
            if (mrScalerAws.isIdSet()) {
                apiMrScalerAws.setId(mrScalerAws.getId());
            }

            if (mrScalerAws.isComputeSet()) {
                ApiMrScalerAwsComputeConfiguration apiCompute = toDal(mrScalerAws.getCompute());
                apiMrScalerAws.setCompute(apiCompute);
            }
            if (mrScalerAws.isClusterSet()) {
                ApiMrScalerAwsClusterConfiguration apiCluster = toDal(mrScalerAws.getCluster());
                apiMrScalerAws.setCluster(apiCluster);
            }
            if (mrScalerAws.isStrategySet()) {
                ApiMrScalerAwsStrategyConfiguration apiStrategy = toDal(mrScalerAws.getStrategy());
                apiMrScalerAws.setStrategy(apiStrategy);
            }
            if (mrScalerAws.isScalingSet()) {
                ApiMrScalerAwsScalingConfiguration apiScaling = toDal(mrScalerAws.getScaling());
                apiMrScalerAws.setScaling(apiScaling);
            }
            if (mrScalerAws.isCoreScalingSet()) {
                ApiMrScalerAwsScalingConfiguration apiCoreScaling = toDal(mrScalerAws.getCoreScaling());
                apiMrScalerAws.setCoreScaling(apiCoreScaling);
            }
            if (mrScalerAws.isSchedulingSet()) {
                ApiMrScalerAwsSchedulingConfiguration apiScheduling = toDal(mrScalerAws.getScheduling());
                apiMrScalerAws.setScheduling(apiScheduling);
            }
        }

        return apiMrScalerAws;
    }

    public static ApiMrScalerAwsComputeConfiguration toDal(MrScalerAwsComputeConfiguration blCompute) {
        ApiMrScalerAwsComputeConfiguration apiCompute = null;

        if (blCompute != null) {
            apiCompute = new ApiMrScalerAwsComputeConfiguration();

            if (blCompute.isEbsRootVolumeSizeSet()) {
                apiCompute.setEbsRootVolumeSize(blCompute.getEbsRootVolumeSize());
            }
            if (blCompute.isEmrManagedMasterSecurityGroupSet()) {
                apiCompute.setEmrManagedMasterSecurityGroup(blCompute.getEmrManagedMasterSecurityGroup());
            }
            if (blCompute.isEmrManagedSlaveSecurityGroupSet()) {
                apiCompute.setEmrManagedSlaveSecurityGroup(blCompute.getEmrManagedSlaveSecurityGroup());
            }
            if (blCompute.isServiceAccessSecurityGroupSet()) {
                apiCompute.setServiceAccessSecurityGroup(blCompute.getServiceAccessSecurityGroup());
            }
            if (blCompute.isCustomAmiIdSet()) {
                apiCompute.setCustomAmiId(blCompute.getCustomAmiId());
            }
            if (blCompute.isRepoUpgradeOnBootSet()) {
                apiCompute.setRepoUpgradeOnBoot(blCompute.getRepoUpgradeOnBoot());
            }
            if (blCompute.isEc2KeyNameSet()) {
                apiCompute.setEc2KeyName(blCompute.getEc2KeyName());
            }
            if (blCompute.isAdditionalMasterSecurityGroupsSet()) {
                apiCompute.setAdditionalMasterSecurityGroups(blCompute.getAdditionalMasterSecurityGroups());
            }
            if (blCompute.isAdditionalSlaveSecurityGroupsSet()) {
                apiCompute.setAdditionalSlaveSecurityGroups(blCompute.getAdditionalSlaveSecurityGroups());
            }
            if (blCompute.isAvailabilityZonesSet()) {
                apiCompute.setAvailabilityZones(blCompute.getAvailabilityZones());
            }
            if (blCompute.isTagsSet()) {
                apiCompute.setTags(blCompute.getTags());
            }
            if (blCompute.isBootstrapActionsSet()) {
                ApiMrScalerAwsFile apiBootstrapFile = toDal(blCompute.getBootstrapActions());
                apiCompute.setBootstrapActions(apiBootstrapFile);
            }
            if (blCompute.isConfigurationsSet()) {
                ApiMrScalerAwsFile apiConfigFile = toDal(blCompute.getConfigurations());
                apiCompute.setConfigurations(apiConfigFile);
            }
            if (blCompute.isStepsSet()) {
                ApiMrScalerAwsFile apiStepsFile = toDal(blCompute.getSteps());
                apiCompute.setSteps(apiStepsFile);
            }
            if (blCompute.isApplicationsSet()) {
                List<ApiMrScalerAwsApplication> apiApplications =
                        blCompute.getApplications().stream().map(MrScalerAwsConverter::toDal).collect(Collectors.toList());
                apiCompute.setApplications(apiApplications);
            }
            if (blCompute.isInstanceGroupsSet()) {
                ApiMrScalerAwsInstancegroups apiInstanceGroups = toDal(blCompute.getInstanceGroups());
                apiCompute.setInstanceGroups(apiInstanceGroups);
            }
        }

        return apiCompute;
    }

    public static ApiMrScalerAwsFile toDal(MrScalerAwsFile blFile) {
        ApiMrScalerAwsFile apiFile = null;

        if (blFile != null) {
            apiFile = new ApiMrScalerAwsFile();

                if (blFile.isFileSet()) {
                    ApiMrScalerAwsFileParams params = toDal(blFile.getFile());
                            apiFile.setFile(params);
                }
        }
        return apiFile;
    }

    public static ApiMrScalerAwsFileParams toDal(MrScalerAwsFileParams blParams) {
        ApiMrScalerAwsFileParams apiParams = null;

        if (blParams != null) {
            apiParams = new ApiMrScalerAwsFileParams();

            if (blParams.isBucketSet()) {
                apiParams.setBucket(blParams.getBucket());
            }

            if (blParams.isKeySet()) {
                apiParams.setKey(blParams.getKey());
            }
        }
        return apiParams;
    }

    public static ApiMrScalerAwsApplication toDal(MrScalerAwsApplication blApplications) {
        ApiMrScalerAwsApplication apiApplications = null;

        if (blApplications != null) {
            apiApplications = new ApiMrScalerAwsApplication();

                if (blApplications.isNameSet()) {
                    apiApplications.setName(blApplications.getName());
                }
                if (blApplications.getVersion() != null) {
                    apiApplications.setVersion(blApplications.getVersion());
                }
        }
        return apiApplications;
    }

    public static ApiMrScalerAwsInstancegroups toDal(MrScalerAwsInstancegroups blInstanceGroups) {
        ApiMrScalerAwsInstancegroups apiInstanceGroups = null;

        if (blInstanceGroups != null) {
            apiInstanceGroups = new ApiMrScalerAwsInstancegroups();
            if (blInstanceGroups.isCoreGroupSet()) {
                ApiMrScalerAwsCoreGroup apiCoreGroup = toDal(blInstanceGroups.getCoreGroup());
                apiInstanceGroups.setCoreGroup(apiCoreGroup);
            }
            if (blInstanceGroups.getMasterGroup() != null) {
                ApiMrScalerAwsMasterGroup apiMastergroup = toDal(blInstanceGroups.getMasterGroup());
                apiInstanceGroups.setMasterGroup(apiMastergroup);
            }
            if (blInstanceGroups.getTaskGroup() != null) {
                ApiMrScalerAwsTaskGroup apiTaskGroup = toDal(blInstanceGroups.getTaskGroup());
                apiInstanceGroups.setTaskGroup(apiTaskGroup);
            }
        }

        return apiInstanceGroups;
    }

    public static ApiMrScalerAwsCoreGroup toDal(MrScalerAwsCoreGroup blCoreGroup) {
        ApiMrScalerAwsCoreGroup apiCoreGroup = null;

        if (blCoreGroup != null) {
            apiCoreGroup = new ApiMrScalerAwsCoreGroup();

            if (blCoreGroup.isInstanceTypesSet()) {
                apiCoreGroup.setInstanceTypes(blCoreGroup.getInstanceTypes());
            }
            if (blCoreGroup.isLifeCycleSet()){
                apiCoreGroup.setLifeCycle(blCoreGroup.getLifeCycle());
            }
            if (blCoreGroup.isTargetSet()) {
                apiCoreGroup.setTarget(blCoreGroup.getTarget());
            }
            if (blCoreGroup.isCapacitySet()) {
                apiCoreGroup.setCapacity(blCoreGroup.getCapacity());
            }
            if (blCoreGroup.isConfigurationsSet()) {
                ApiMrScalerAwsFile apiConfigFile = toDal(blCoreGroup.getConfigurations());
                apiCoreGroup.setConfigurations(apiConfigFile);
            }
            if (blCoreGroup.isEbsConfigurationSet()) {
                ApiMrScalerAwsEbsConfiguration apiEbsConfiguration = toDal(blCoreGroup.getEbsConfiguration());
                apiCoreGroup.setEbsConfiguration(apiEbsConfiguration);
            }
        }
        return apiCoreGroup;
    }

    public static ApiMrScalerAwsMasterGroup toDal(MrScalerAwsMasterGroup blMasterGroup) {
        ApiMrScalerAwsMasterGroup apiMasterGroup = null;

        if (blMasterGroup != null) {
            apiMasterGroup = new ApiMrScalerAwsMasterGroup();

            if (blMasterGroup.isInstanceTypesSet()) {
                apiMasterGroup.setInstanceTypes(blMasterGroup.getInstanceTypes());
            }
            if (blMasterGroup.isTargetSet()) {
                apiMasterGroup.setTarget(blMasterGroup.getTarget());
            }
            if (blMasterGroup.isLifeCycleSet()) {
                apiMasterGroup.setLifeCycle(blMasterGroup.getLifeCycle());
            }
            if (blMasterGroup.isConfigurationsSet()) {
                ApiMrScalerAwsFile apiConfigFile = toDal(blMasterGroup.getConfigurations());
                apiMasterGroup.setConfigurations(apiConfigFile);
            }
            if (blMasterGroup.isEbsConfigurationSet()) {
                ApiMrScalerAwsEbsConfiguration apiEbsConfig =
                        toDal(blMasterGroup.getEbsConfiguration());
                apiMasterGroup.setEbsConfiguration(apiEbsConfig);
            }
        }
        return apiMasterGroup;
    }

    public static ApiMrScalerAwsTaskGroup toDal(MrScalerAwsTaskGroup blTaskGroup) {
        ApiMrScalerAwsTaskGroup apiTaskGroup = null;

        if (blTaskGroup != null) {
            apiTaskGroup = new ApiMrScalerAwsTaskGroup();

            if (blTaskGroup.isInstanceTypesSet()) {
                apiTaskGroup.setInstanceTypes(blTaskGroup.getInstanceTypes());
            }
            if (blTaskGroup.isLifeCycleSet()) {
                apiTaskGroup.setLifeCycle(blTaskGroup.getLifeCycle());
            }
            if (blTaskGroup.isCapacitySet()) {
                apiTaskGroup.setCapacity(blTaskGroup.getCapacity());
            }
            if (blTaskGroup.isEbsConfigurationSet()) {
                ApiMrScalerAwsEbsConfiguration apiEbsConfig =
                        toDal(blTaskGroup.getEbsConfiguration());
                apiTaskGroup.setEbsConfiguration(apiEbsConfig);
            }
            if (blTaskGroup.isConfigurationsSet()) {
                ApiMrScalerAwsFile apiFile = toDal(blTaskGroup.getConfigurations());
                apiTaskGroup.setConfigurations(apiFile);
            }
        }
        return apiTaskGroup;
    }

    public static ApiMrScalerAwsEbsConfiguration toDal(MrScalerAwsEbsConfiguration blEbsConfig) {
        ApiMrScalerAwsEbsConfiguration apiEbsConfig = null;

        if (blEbsConfig != null) {
            apiEbsConfig = new ApiMrScalerAwsEbsConfiguration();

            if (blEbsConfig.isEbsOptimizedSet()) {
                apiEbsConfig.setEbsOptimized(blEbsConfig.getEbsOptimized());
            }
            if (blEbsConfig.isEbsBlockDeviceConfigsSet()) {
                List<ApiMrScalerAwsEbsBlockDeviceConfig> apiBlockDeviceConfigs =
                        blEbsConfig.getEbsBlockDeviceConfigs().stream().map(MrScalerAwsConverter::toDal).collect(Collectors.toList());
                apiEbsConfig.setEbsBlockDeviceConfigs(apiBlockDeviceConfigs);
            }
        }
        return apiEbsConfig;
    }

    public static ApiMrScalerAwsEbsBlockDeviceConfig toDal(MrScalerAwsEbsBlockDeviceConfig ebsBlockDeviceConfig) {
        ApiMrScalerAwsEbsBlockDeviceConfig apiEbsBlockDeviceConfig = null;

        if (ebsBlockDeviceConfig != null) {
            apiEbsBlockDeviceConfig = new ApiMrScalerAwsEbsBlockDeviceConfig();

            if (ebsBlockDeviceConfig.isVolumesPerInstanceSet()) {
                apiEbsBlockDeviceConfig.setVolumesPerInstance(ebsBlockDeviceConfig.getVolumesPerInstance());
            }
            if (ebsBlockDeviceConfig.isVolumeSpecificationSet()) {
                ApiMrScalerAwsVolumeSpecification apiVolumeSpec = toDal(ebsBlockDeviceConfig.getVolumeSpecification());
                apiEbsBlockDeviceConfig.setVolumeSpecification(apiVolumeSpec);
            }
        }
        return apiEbsBlockDeviceConfig;
    }

    public static ApiMrScalerAwsVolumeSpecification toDal(MrScalerAwsVolumeSpecification volumeSpecification){
        ApiMrScalerAwsVolumeSpecification apiVolumeSpecification = null;

        if(volumeSpecification != null){
            apiVolumeSpecification = new ApiMrScalerAwsVolumeSpecification();

            if (volumeSpecification.isIopsSet()) {
                apiVolumeSpecification.setIops(volumeSpecification.getIops());
            }
            if (volumeSpecification.isSizeInGBSet() != null) {
                apiVolumeSpecification.setSizeInGB(volumeSpecification.getSizeInGB());
            }
            if (volumeSpecification.isVolumeTypeSet() != null) {
                apiVolumeSpecification.setVolumeType(volumeSpecification.getVolumeType());
            }
        }
        return apiVolumeSpecification;
    }

    public static ApiMrScalerAwsClusterConfiguration toDal(MrScalerAwsClusterConfiguration blCluster) {
        ApiMrScalerAwsClusterConfiguration apiCluster = null;

        if (blCluster != null) {
            apiCluster = new ApiMrScalerAwsClusterConfiguration();

            if (blCluster.isVisibleToAllUsersSet()) {
                apiCluster.setVisibleToAllUsers(blCluster.getVisibleToAllUsers());
            }
            if (blCluster.isTerminationProtectedSet()) {
                apiCluster.setTerminationProtected(blCluster.getTerminationProtected());
            }
            if (blCluster.isServiceRoleSet()) {
                apiCluster.setServiceRole(blCluster.getServiceRole());
            }
            if (blCluster.isSecurityConfigurationSet()) {
                apiCluster.setSecurityConfiguration(blCluster.getSecurityConfiguration());
            }
            if (blCluster.isLogUriSet()) {
                apiCluster.setLogUri(blCluster.getLogUri());
            }
            if (blCluster.isKeepJobFlowAliveWhenNoStepsSet()) {
                apiCluster.setKeepJobFlowAliveWhenNoSteps(blCluster.getKeepJobFlowAliveWhenNoSteps());
            }
            if (blCluster.isJobFlowRoleSet()) {
                apiCluster.setJobFlowRole(blCluster.getJobFlowRole());
            }
            if (blCluster.isAdditionalInfoSet()) {
                apiCluster.setAdditionalInfo(blCluster.getAdditionalInfo());
            }
        }
        return apiCluster;
    }

    public static ApiMrScalerAwsStrategyConfiguration toDal(MrScalerAwsStrategyConfiguration blStrategy) {
        ApiMrScalerAwsStrategyConfiguration apiStrategy = null;

        if (blStrategy != null) {
            apiStrategy = new ApiMrScalerAwsStrategyConfiguration();

            if (blStrategy.isCloningSet()) {
                ApiMrScalerAwsCloneStrategy apiClone = toDal(blStrategy.getCloning());
                apiStrategy.setCloning(apiClone);
            }
            if (blStrategy.isNewSet()) {
                ApiMrScalerAwsNewStrategy apiNew = toDal(blStrategy.getNew());
                apiStrategy.setNew(apiNew);
            }
            if (blStrategy.isWrappingSet()) {
                ApiMrScalerAwsWrapStrategy apiWrap = toDal(blStrategy.getWrapping());
                apiStrategy.setWrapping(apiWrap);
            }
            if (blStrategy.isProvisioningTimeoutSet()) {
                ApiMrScalerAwsProvisioningTimeout apiProvision = toDal(blStrategy.getProvisioningTimeout());
                apiStrategy.setProvisioningTimeout(apiProvision);
            }
        }
        return apiStrategy;
    }

    public static ApiMrScalerAwsCloneStrategy toDal(MrScalerAwsCloneStrategy cloneStrategy) {
        ApiMrScalerAwsCloneStrategy apiStrategy = null;

        if (cloneStrategy != null) {
            apiStrategy = new ApiMrScalerAwsCloneStrategy();

            if (cloneStrategy.isIncludeStepsSet()) {
                apiStrategy.setIncludeSteps(cloneStrategy.getIncludeSteps());
            }
            if (cloneStrategy.isNumberOfRetriesSet()) {
                apiStrategy.setNumberOfRetries(cloneStrategy.getNumberOfRetries());
            }
            if (cloneStrategy.isOriginClusterIdSet()) {
                apiStrategy.setOriginClusterId(cloneStrategy.getOriginClusterId());
            }
        }
        return apiStrategy;
    }

    public static ApiMrScalerAwsNewStrategy toDal(MrScalerAwsNewStrategy newStrategy) {
        ApiMrScalerAwsNewStrategy apiNewStratgey = null;

        if (newStrategy != null) {
            apiNewStratgey = new ApiMrScalerAwsNewStrategy();

            if (newStrategy.isReleaseLabelSet()) {
                apiNewStratgey.setReleaseLabel(newStrategy.getReleaseLabel());
            }
            if (newStrategy.isNumberOfRetriesSet()) {
                apiNewStratgey.setNumberOfRetries(newStrategy.getNumberOfRetries());
            }
        }
        return apiNewStratgey;
    }

    public static ApiMrScalerAwsWrapStrategy toDal(MrScalerAwsWrapStrategy wrapStrategy) {
        ApiMrScalerAwsWrapStrategy apiWrapStrategy = null;

        if (wrapStrategy != null) {
            apiWrapStrategy = new ApiMrScalerAwsWrapStrategy();

            if (wrapStrategy.isSourceClusterIdSet()) {
                apiWrapStrategy.setSourceClusterId(wrapStrategy.getSourceClusterId());
            }
        }
        return apiWrapStrategy;
    }

    public static ApiMrScalerAwsProvisioningTimeout toDal(MrScalerAwsProvisioningTimeout provisioningTimeout){
        ApiMrScalerAwsProvisioningTimeout apiProvisioningTimeout = null;

        if(provisioningTimeout != null){
            apiProvisioningTimeout = new ApiMrScalerAwsProvisioningTimeout();

            if(provisioningTimeout.isTimeoutActionSet()){
                apiProvisioningTimeout.setTimeoutAction(provisioningTimeout.getTimeoutAction());
            }
            if(provisioningTimeout.isTimeoutSet()){
                apiProvisioningTimeout.setTimeout(provisioningTimeout.getTimeout());
            }
        }
        return apiProvisioningTimeout;
    }

    public static ApiMrScalerAwsScalingConfiguration toDal(MrScalerAwsScalingConfiguration blScaling) {
        ApiMrScalerAwsScalingConfiguration apiScaling = null;

        if (blScaling != null) {
            apiScaling = new ApiMrScalerAwsScalingConfiguration();

            if (blScaling.isUpSet()) {
                List<ApiMrScalerAwsScalingPolicy> apiUpConfig = blScaling.getUp().stream().map(MrScalerAwsConverter::toDal).collect(Collectors.toList());
                apiScaling.setUp(apiUpConfig);
            }
            if (blScaling.isDownSet()) {
                List<ApiMrScalerAwsScalingPolicy> apiDownConfig = blScaling.getDown().stream().map(MrScalerAwsConverter::toDal).collect(Collectors.toList());
                apiScaling.setDown(apiDownConfig);
            }
        }

        return apiScaling;
    }

    public static ApiMrScalerAwsScalingPolicy toDal(MrScalerAwsScalingPolicy blScalingPolicies) {
        ApiMrScalerAwsScalingPolicy apiScalingPolicies = null;

        if (blScalingPolicies != null) {
            apiScalingPolicies = new ApiMrScalerAwsScalingPolicy();

            if (blScalingPolicies.isUnitSet()) {
                apiScalingPolicies.setUnit(blScalingPolicies.getUnit());
            }
            if (blScalingPolicies.isThresholdSet()) {
                apiScalingPolicies.setThreshold(blScalingPolicies.getThreshold());
            }
            if (blScalingPolicies.isStatisticSet()) {
                apiScalingPolicies.setStatistic(blScalingPolicies.getStatistic());
            }
            if (blScalingPolicies.isPolicyNameSet()) {
                apiScalingPolicies.setPolicyName(blScalingPolicies.getPolicyName());
            }
            if (blScalingPolicies.isPeriodSet()) {
                apiScalingPolicies.setPeriod(blScalingPolicies.getPeriod());
            }
            if (blScalingPolicies.isOperatorSet()) {
                apiScalingPolicies.setOperator(blScalingPolicies.getOperator());
            }
            if (blScalingPolicies.isNamespaceSet()) {
                apiScalingPolicies.setNamespace(blScalingPolicies.getNamespace());
            }
            if (blScalingPolicies.isMinTargetCapacitySet()) {
                apiScalingPolicies.setMinTargetCapacity(blScalingPolicies.getMinTargetCapacity());
            }
            if (blScalingPolicies.isMetricNameSet()) {
                apiScalingPolicies.setMetricName(blScalingPolicies.getMetricName());
            }
            if (blScalingPolicies.isEvaluationPeriodsSet()) {
                apiScalingPolicies.setEvaluationPeriods(blScalingPolicies.getEvaluationPeriods());
            }
            if (blScalingPolicies.isCooldownSet()) {
                apiScalingPolicies.setCooldown(blScalingPolicies.getCooldown());
            }
            if (blScalingPolicies.isAdjustmentSet()) {
                apiScalingPolicies.setAdjustment(blScalingPolicies.getAdjustment());
            }

            if (blScalingPolicies.isActionSet()) {
                ApiMrScalerAwsScalingAction apiScalingAction = toDal(blScalingPolicies.getAction());
                apiScalingPolicies.setAction(apiScalingAction);
            }
            if (blScalingPolicies.isDimensionsSet()) {
                List<ApiMrScalerAwsScalingDimenation> apiDimenation = blScalingPolicies.getDimensions().stream()
                        .map(MrScalerAwsConverter::toDal).collect(Collectors.toList());
                apiScalingPolicies.setDimensions(apiDimenation);
            }
        }
        return apiScalingPolicies;
    }

    public static ApiMrScalerAwsScalingAction toDal(MrScalerAwsScalingAction scalingAction) {
        ApiMrScalerAwsScalingAction apiScalingAction = null;

        if (scalingAction != null) {
            apiScalingAction = new ApiMrScalerAwsScalingAction();

            if (scalingAction.isTypeSet()) {
                apiScalingAction.setType(scalingAction.getType());
            }
            if (scalingAction.isTargetSet()) {
                apiScalingAction.setTarget(scalingAction.getTarget());
            }
            if (scalingAction.isMinTargetCapacitySet()) {
                apiScalingAction.setMinTargetCapacity(scalingAction.getMinTargetCapacity());
            }
            if (scalingAction.isMinimumSet()) {
                apiScalingAction.setMinimum(scalingAction.getMinimum());
            }
            if (scalingAction.isMaximumSet()) {
                apiScalingAction.setMaximum(scalingAction.getMaximum());
            }
            if (scalingAction.isAdjustmentSet()) {
                apiScalingAction.setAdjustment(scalingAction.getAdjustment());
            }
        }
        return apiScalingAction;
    }

    public static ApiMrScalerAwsScalingDimenation toDal(MrScalerAwsScalingDimenation scalingDimenation){
        ApiMrScalerAwsScalingDimenation apiScalingDimenation = null;

        if (scalingDimenation != null) {
            apiScalingDimenation = new ApiMrScalerAwsScalingDimenation();

            if (scalingDimenation.isValueSet()) {
                apiScalingDimenation.setValue(scalingDimenation.getValue());
            }
            if (scalingDimenation.isNameSet()) {
                apiScalingDimenation.setName(scalingDimenation.getName());
            }
        }
        return apiScalingDimenation;
    }

    public static ApiMrScalerAwsSchedulingConfiguration toDal(MrScalerAwsSchedulingConfiguration blScheduling) {
        ApiMrScalerAwsSchedulingConfiguration apiScheduling = null;

        if (blScheduling != null) {
            apiScheduling = new ApiMrScalerAwsSchedulingConfiguration();

            if (blScheduling.isTasksSet() != null) {
                List<ApiMrScalerAwsTask> apiTasks = blScheduling.getTasks().stream()
                        .map(MrScalerAwsConverter::toDal).collect(Collectors.toList());
                apiScheduling.setTasks(apiTasks);
            }
        }
        return apiScheduling;
    }

    public static ApiMrScalerAwsTask toDal(MrScalerAwsTask blTasks) {
        ApiMrScalerAwsTask apiTasks = null;

        if(blTasks != null){
            apiTasks = new ApiMrScalerAwsTask();

            if (blTasks.isTaskTypeSet()) {
                apiTasks.setTaskType(blTasks.getTaskType());
            }
            if (blTasks.isTargetCapacitySet()) {
                apiTasks.setTargetCapacity(blTasks.getTargetCapacity());
            }
            if (blTasks.isMinCapacitySet()) {
                apiTasks.setMinCapacity(blTasks.getMinCapacity());
            }
            if (blTasks.isMaxCapacitySet()) {
                apiTasks.setMaxCapacity(blTasks.getMaxCapacity());
            }
            if (blTasks.isIsEnabledSet()) {
                apiTasks.setIsEnabled(blTasks.getIsEnabled());
            }
            if (blTasks.isInstanceGroupTypeSet()) {
                apiTasks.setInstanceGroupType(blTasks.getInstanceGroupType());
            }
            if (blTasks.isCronExpressionSet()) {
                apiTasks.setCronExpression(blTasks.getCronExpression());
            }
        }
        return apiTasks;
    }

    public static ApiMrScalerOperatorAwsResponse toDal(MrScalerOperatorResponse blMrScalerOperatorAwsResponse) {
        ApiMrScalerOperatorAwsResponse apiMrScalerOperatorAwsResponse = null;

        if (blMrScalerOperatorAwsResponse != null) {
            apiMrScalerOperatorAwsResponse = new ApiMrScalerOperatorAwsResponse();

            if (blMrScalerOperatorAwsResponse.isNameSet()) {
                apiMrScalerOperatorAwsResponse.setName(blMrScalerOperatorAwsResponse.getName());
            }

            if (blMrScalerOperatorAwsResponse.isMrScalerIdSet()) {
                apiMrScalerOperatorAwsResponse.setMrScalerId(blMrScalerOperatorAwsResponse.getMrScalerId());
            }
            if (blMrScalerOperatorAwsResponse.isStateSet()) {
                apiMrScalerOperatorAwsResponse.setState(blMrScalerOperatorAwsResponse.getState());
            }
        }

        return apiMrScalerOperatorAwsResponse;
    }

    public static ApiMrScalerOperatorAws toDal(MrScalerOperatorAws mrScalerOperatorAws) {
        ApiMrScalerOperatorAws apiMrScalerOperatorAws = null;

        if (mrScalerOperatorAws != null) {
            apiMrScalerOperatorAws = new ApiMrScalerOperatorAws();

            if (mrScalerOperatorAws.isNameSet()) {
                apiMrScalerOperatorAws.setName(mrScalerOperatorAws.getName());
            }
            if (mrScalerOperatorAws.isMrScalerSet()) {
                ApiMrScalerAws apiScaler = toDal(mrScalerOperatorAws.getMrScaler());
                apiMrScalerOperatorAws.setMrScaler(apiScaler);
            }
        }
        return apiMrScalerOperatorAws;
    }

    public static ApiMrScalerListInstancesAws toDal(MrScalerListInstancesAws mrScalerListInstancesAws) {
        ApiMrScalerListInstancesAws apiMrScalerListInstancesAws = null;

        if (mrScalerListInstancesAws != null) {
            apiMrScalerListInstancesAws = new ApiMrScalerListInstancesAws();

            if (mrScalerListInstancesAws.isInstanceIdSet()) {
                apiMrScalerListInstancesAws.setInstanceId(mrScalerListInstancesAws.getInstanceId());
            }

            if (mrScalerListInstancesAws.isInstanceGroupIdSet()) {
                apiMrScalerListInstancesAws.setInstanceGroupId(mrScalerListInstancesAws.getInstanceGroupId());
            }

            if (mrScalerListInstancesAws.isInstanceGroupRoleSet()) {
                apiMrScalerListInstancesAws.setInstanceGroupRole(mrScalerListInstancesAws.getInstanceGroupRole());
            }

            if (mrScalerListInstancesAws.isInstanceTypeSet()) {
                apiMrScalerListInstancesAws.setInstanceType(mrScalerListInstancesAws.getInstanceType());
            }

            if (mrScalerListInstancesAws.isAvailabilityZoneSet()) {
                apiMrScalerListInstancesAws.setAvailabilityZone(mrScalerListInstancesAws.getAvailabilityZone());
            }

            if (mrScalerListInstancesAws.isStatusSet()) {
                apiMrScalerListInstancesAws.setStatus(mrScalerListInstancesAws.getStatus());
            }
        }
        return apiMrScalerListInstancesAws;
    }

    public static ApiMrScalerListScalersAws toDal(MrScalerListScalersAws mrScalerListScalersAws) {
        ApiMrScalerListScalersAws apiMrScalerListScalersAws = null;

        if (mrScalerListScalersAws != null) {
            apiMrScalerListScalersAws = new ApiMrScalerListScalersAws();

            if (mrScalerListScalersAws.isIdSet()) {
                apiMrScalerListScalersAws.setId(mrScalerListScalersAws.getId());
            }

            if (mrScalerListScalersAws.isAvailabilityZoneSet()) {
                apiMrScalerListScalersAws.setAvailabilityZone(mrScalerListScalersAws.getAvailabilityZone());
            }

            if (mrScalerListScalersAws.isStateSet()) {
                apiMrScalerListScalersAws.setState(mrScalerListScalersAws.getState());
            }
        }
        return apiMrScalerListScalersAws;
    }

    public static ApiMrScalerScaleDownAws toDal(MrScalerScaleDownAws mrScalerScaleDownAws) {
        ApiMrScalerScaleDownAws apiMrScalerScaleDownAws = null;

        if (mrScalerScaleDownAws != null) {
            apiMrScalerScaleDownAws = new ApiMrScalerScaleDownAws();

            if (mrScalerScaleDownAws.isModifiedInstanceGroupsSet()) {
                apiMrScalerScaleDownAws.setModifiedInstanceGroups(mrScalerScaleDownAws.getModifiedInstanceGroups());
            }

            if (mrScalerScaleDownAws.isVictimInstancesSet()) {
                apiMrScalerScaleDownAws.setVictimInstances(mrScalerScaleDownAws.getVictimInstances());
            }
        }
        return apiMrScalerScaleDownAws;
    }

    public static ApiMrScalerScaleUpAws toDal(MrScalerScaleUpAws mrScalerScaleUpAws) {
        ApiMrScalerScaleUpAws apiMrScalerScaleUpAws = null;

        if (mrScalerScaleUpAws != null) {
            apiMrScalerScaleUpAws = new ApiMrScalerScaleUpAws();

            if (mrScalerScaleUpAws.isModifiedInstanceGroupsSet()) {
                apiMrScalerScaleUpAws.setModifiedInstanceGroups(mrScalerScaleUpAws.getModifiedInstanceGroups());
            }

            if (mrScalerScaleUpAws.isNewInstanceGroupsSet()) {
                apiMrScalerScaleUpAws.setNewInstanceGroups(mrScalerScaleUpAws.getNewInstanceGroups());
            }
        }
        return apiMrScalerScaleUpAws;
    }
}
