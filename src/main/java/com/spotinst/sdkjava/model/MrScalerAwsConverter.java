package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.mrScaler.aws.*;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MrScalerAwsConverter {
    // region toBl
    public static BlMrScalerAws toBl(ApiMrScalerAws apiMrScalerAws) {
        BlMrScalerAws blMrScalerAws = null;

        if (apiMrScalerAws != null) {
            blMrScalerAws = new BlMrScalerAws();

            if (apiMrScalerAws.isNameSet()) {
                blMrScalerAws.setName(apiMrScalerAws.getName());
            }
            if (apiMrScalerAws.isDescriptionSet()) {
                blMrScalerAws.setDescription(apiMrScalerAws.getDescription());
            }
            if (apiMrScalerAws.isRegionSet()) {
                blMrScalerAws.setRegion(apiMrScalerAws.getRegion());
            }
            if (apiMrScalerAws.isIdSet()) {
                blMrScalerAws.setId(apiMrScalerAws.getId());
            }
            if (apiMrScalerAws.isComputeSet()) {
                BlMrScalerAwsComputeConfiguration blCompute = computeApiToBl(apiMrScalerAws.getCompute());
                blMrScalerAws.setCompute(blCompute);
            }
            if (apiMrScalerAws.isClusterSet()) {
                BlMrScalerAwsClusterConfiguration blCluster = clusterApiToBl(apiMrScalerAws.getCluster());
                blMrScalerAws.setCluster(blCluster);
            }
            if (apiMrScalerAws.isStrategySet()) {
                BlMrScalerAwsStrategyConfiguration blStrategy = strategyApiToBl(apiMrScalerAws.getStrategy());
                blMrScalerAws.setStrategy(blStrategy);
            }
            if (apiMrScalerAws.isScalingSet()) {
                BlMrScalerAwsScalingConfiguration blScaling = scalingApiToBl(apiMrScalerAws.getScaling());
                blMrScalerAws.setScaling(blScaling);
            }
            if (apiMrScalerAws.isSchedulingSet()) {
                BlMrScalerAwsSchedulingConfiguration blScheduling = schedulingApiToBl(apiMrScalerAws.getScheduling());
                blMrScalerAws.setScheduling(blScheduling);
            }
        }

        return blMrScalerAws;
    }

    // region Compute
    public static BlMrScalerAwsComputeConfiguration computeApiToBl(ApiMrScalerAwsComputeConfiguration apiCompute) {
        BlMrScalerAwsComputeConfiguration blCompute = null;

        if (apiCompute != null) {
            blCompute = new BlMrScalerAwsComputeConfiguration();

            if (apiCompute.isEbsRootVolumeSizeSet()) {
                blCompute.setEbsRootVolumeSize(apiCompute.getEbsRootVolumeSize());
            }
            if (apiCompute.isEmrManagedMasterSecurityGroupSet()) {
                blCompute.setEmrManagedMasterSecurityGroup(apiCompute.getEmrManagedMasterSecurityGroup());
            }
            if (apiCompute.isEmrManagedSlaveSecurityGroupSet()) {
                blCompute.setEmrManagedSlaveSecurityGroup(apiCompute.getEmrManagedSlaveSecurityGroup());
            }
            if (apiCompute.isServiceAccessSecurityGroupSet()) {
                blCompute.setServiceAccessSecurityGroup(apiCompute.getServiceAccessSecurityGroup());
            }
            if (apiCompute.isCustomAmiIdSet()) {
                blCompute.setCustomAmiId(apiCompute.getCustomAmiId());
            }
            if (apiCompute.isRepoUpgradeOnBootSet()) {
                blCompute.setRepoUpgradeOnBoot(apiCompute.getRepoUpgradeOnBoot());
            }
            if (apiCompute.isEc2KeyNameSet()) {
                blCompute.setEc2KeyName(apiCompute.getEc2KeyName());
            }
            if (apiCompute.isAdditionalMasterSecurityGroupsSet()) {
                blCompute.setAdditionalMasterSecurityGroups(apiCompute.getAdditionalMasterSecurityGroups());
            }
            if (apiCompute.isAdditionalSlaveSecurityGroupsSet()) {
                blCompute.setAdditionalSlaveSecurityGroups(apiCompute.getAdditionalSlaveSecurityGroups());
            }
            if (apiCompute.isAvailabilityZonesSet()) {
                blCompute.setAvailabilityZones(apiCompute.getAvailabilityZones());
            }
            if (apiCompute.isTagsSet()) {
                blCompute.setTags(apiCompute.getTags());
            }
            if (apiCompute.isBootstrapActionsSet()) {
                BlMrScalerAwsFile blBootstrapFile = convertFileApiToBl(apiCompute.getBootstrapActions());
                blCompute.setBootstrapActions(blBootstrapFile);
            }
            if (apiCompute.isConfigurationsSet()) {
                BlMrScalerAwsFile blConfigFile = convertFileApiToBl(apiCompute.getConfigurations());
                blCompute.setConfigurations(blConfigFile);
            }
            if (apiCompute.isStepsSet()) {
                BlMrScalerAwsFile blStepsFile = convertFileApiToBl(apiCompute.getSteps());
                blCompute.setSteps(blStepsFile);
            }
            if (apiCompute.isApplicationsSet()) {
                List<BlMrScalerAwsApplication> blApplications =
                        convertApplicationApitToBl(apiCompute.getApplications());
                blCompute.setApplications(blApplications);
            }
            if (apiCompute.isInstanceGroupsSet()) {
                BlMrScalerAwsInstancegroups blInstanceGroups =
                        convertInstanceGroupsApiToBl(apiCompute.getInstanceGroups());
                blCompute.setInstanceGroups(blInstanceGroups);
            }
        }

        return blCompute;
    }

    public static BlMrScalerAwsFile convertFileApiToBl(ApiMrScalerAwsFile apiFile) {
        BlMrScalerAwsFile blFile = null;

        if (apiFile != null) {
            blFile = new BlMrScalerAwsFile();
            if (apiFile.isFileSet()) {
                BlMrScalerAwsFileParams blFileParams = new BlMrScalerAwsFileParams();

                if (apiFile.getFile().isBucketSet()) {
                    blFileParams.setBucket(apiFile.getFile().getBucket());
                }
                if (apiFile.getFile().isKeySet()) {
                    blFileParams.setKey(apiFile.getFile().getKey());
                }

                blFile.setFile(blFileParams);
            }
        }

        return blFile;
    }

    public static List<BlMrScalerAwsApplication> convertApplicationApitToBl(
            List<ApiMrScalerAwsApplication> apiApplications) {
        List<BlMrScalerAwsApplication> blApplication = null;

        if (apiApplications != null) {
            blApplication = new ArrayList<>();

            for (ApiMrScalerAwsApplication singleApplication : apiApplications) {
                BlMrScalerAwsApplication tempBlApplication = new BlMrScalerAwsApplication();

                if (singleApplication.isNameSet()) {
                    tempBlApplication.setName(singleApplication.getName());
                }
                if (singleApplication.isVersionSet()) {
                    tempBlApplication.setVersion(singleApplication.getVersion());
                }

                blApplication.add(tempBlApplication);
            }
        }

        return blApplication;
    }

    public static BlMrScalerAwsInstancegroups convertInstanceGroupsApiToBl(
            ApiMrScalerAwsInstancegroups apiInstancegroups) {
        BlMrScalerAwsInstancegroups blInstanceGroups = null;

        if (apiInstancegroups != null) {
            blInstanceGroups = new BlMrScalerAwsInstancegroups();
            if (apiInstancegroups.isCoreGroupSet()) {
                BlMrScalerAwsCoreGroup blCoreGroup = convertCoreGroupApiToBl(apiInstancegroups.getCoreGroup());
                blInstanceGroups.setCoreGroup(blCoreGroup);
            }
            if (apiInstancegroups.isMasterGroupSet()) {
                BlMrScalerAwsMasterGroup blMastergroup = convertMasterGroupApiToBl(apiInstancegroups.getMasterGroup());
                blInstanceGroups.setMasterGroup(blMastergroup);
            }
            if (apiInstancegroups.isTaskGroupSet()) {
                BlMrScalerAwsTaskGroup blTaskGroup = convertTaskGroupApiToBl(apiInstancegroups.getTaskGroup());
                blInstanceGroups.setTaskGroup(blTaskGroup);
            }
        }

        return blInstanceGroups;
    }

    public static BlMrScalerAwsCoreGroup convertCoreGroupApiToBl(ApiMrScalerAwsCoreGroup apiCoreGroup) {
        BlMrScalerAwsCoreGroup blCoreGroup = null;

        if (apiCoreGroup != null) {
            blCoreGroup = new BlMrScalerAwsCoreGroup();

            if (apiCoreGroup.isInstanceTypesSet()) {
                blCoreGroup.setInstanceTypes(apiCoreGroup.getInstanceTypes());
            }
            if (apiCoreGroup.isLifeCycle()) {
                blCoreGroup.setLifeCycle(apiCoreGroup.getLifeCycle());
            }
            if (apiCoreGroup.isTargetSet()) {
                blCoreGroup.setTarget(apiCoreGroup.getTarget());
            }
            if (apiCoreGroup.isCapacitySet()) {
                blCoreGroup.setCapacity(apiCoreGroup.getCapacity());
            }
            if (apiCoreGroup.isConfigurations()) {
                BlMrScalerAwsFile blConfigFile = convertFileApiToBl(apiCoreGroup.getConfigurations());
                blCoreGroup.setConfigurations(blConfigFile);
            }
            if (apiCoreGroup.isEbsConfigurationSet()) {
                BlMrScalerAwsEbsConfiguration blEbsConfiguration =
                        convertEbsConfigApiToBl(apiCoreGroup.getEbsConfiguration());
                blCoreGroup.setEbsConfiguration(blEbsConfiguration);
            }

        }

        return blCoreGroup;
    }

    public static BlMrScalerAwsMasterGroup convertMasterGroupApiToBl(ApiMrScalerAwsMasterGroup apiMasterGroup) {
        BlMrScalerAwsMasterGroup blMasterGroup = null;

        if (apiMasterGroup != null) {
            blMasterGroup = new BlMrScalerAwsMasterGroup();

            if (apiMasterGroup.isInstanceTypesSet()) {
                blMasterGroup.setInstanceTypes(apiMasterGroup.getInstanceTypes());
            }
            if (apiMasterGroup.isTargetSet()) {
                blMasterGroup.setTarget(apiMasterGroup.getTarget());
            }
            if (apiMasterGroup.isLifeCycleSet()) {
                blMasterGroup.setLifeCycle(apiMasterGroup.getLifeCycle());
            }
            if (apiMasterGroup.isConfigurationsSet()) {
                BlMrScalerAwsFile blConfigFile = convertFileApiToBl(apiMasterGroup.getConfigurations());
                blMasterGroup.setConfigurations(blConfigFile);
            }
            if (apiMasterGroup.isEbsConfigurationSet()) {
                BlMrScalerAwsEbsConfiguration blEbsConfig =
                        convertEbsConfigApiToBl(apiMasterGroup.getEbsConfiguration());
                blMasterGroup.setEbsConfiguration(blEbsConfig);
            }
        }
        return blMasterGroup;
    }

    public static BlMrScalerAwsTaskGroup convertTaskGroupApiToBl(ApiMrScalerAwsTaskGroup apiTaskGroup) {
        BlMrScalerAwsTaskGroup blTaskGroup = null;

        if (apiTaskGroup != null) {
            blTaskGroup = new BlMrScalerAwsTaskGroup();

            if (apiTaskGroup.isInstanceTypesSet()) {
                blTaskGroup.setInstanceTypes(apiTaskGroup.getInstanceTypes());
            }
            if (apiTaskGroup.isLifeCycle()) {
                blTaskGroup.setLifeCycle(apiTaskGroup.getLifeCycle());
            }
            if (apiTaskGroup.isCapacitySet()) {
                blTaskGroup.setCapacity(apiTaskGroup.getCapacity());
            }
            if (apiTaskGroup.isEbsConfigurationSet()) {
                BlMrScalerAwsEbsConfiguration blEbsConfig = convertEbsConfigApiToBl(apiTaskGroup.getEbsConfiguration());
                blTaskGroup.setEbsConfiguration(blEbsConfig);
            }
            if (apiTaskGroup.isConfigurations()) {
                BlMrScalerAwsFile blFile = convertFileApiToBl(apiTaskGroup.getConfigurations());
                blTaskGroup.setConfigurations(blFile);
            }
        }
        return blTaskGroup;
    }

    public static BlMrScalerAwsEbsConfiguration convertEbsConfigApiToBl(ApiMrScalerAwsEbsConfiguration apiEbsConfig) {
        BlMrScalerAwsEbsConfiguration blEbsConfig = null;

        if (apiEbsConfig != null) {
            blEbsConfig = new BlMrScalerAwsEbsConfiguration();

            if (apiEbsConfig.isEbsOptimizedSet()) {
                blEbsConfig.setEbsOptimized(apiEbsConfig.getEbsOptimized());
            }
            if (apiEbsConfig.isEbsBlockDeviceConfigsSet()) {
                List<BlMrScalerAwsEbsBlockDeviceConfig> blBlockDeviceConfigs = new ArrayList<>();

                for (ApiMrScalerAwsEbsBlockDeviceConfig singleConfig : apiEbsConfig.getEbsBlockDeviceConfigs()) {
                    BlMrScalerAwsEbsBlockDeviceConfig tempConfig = new BlMrScalerAwsEbsBlockDeviceConfig();

                    if (singleConfig.isVolumeSpecificationSet()) {
                        BlMrScalerAwsVolumeSpecification blVolumetSpec = new BlMrScalerAwsVolumeSpecification();

                        if (singleConfig.getVolumeSpecification().isIopsSet()) {
                            blVolumetSpec.setIops(singleConfig.getVolumeSpecification().getIops());
                        }
                        if (singleConfig.getVolumeSpecification().isSizeInGBSet()) {
                            blVolumetSpec.setSizeInGB(singleConfig.getVolumeSpecification().getSizeInGB());
                        }
                        if (singleConfig.getVolumeSpecification().isVolumeTypeSet()) {
                            blVolumetSpec.setVolumeType(singleConfig.getVolumeSpecification().getVolumeType());
                        }

                        tempConfig.setVolumeSpecification(blVolumetSpec);
                    }
                    if (singleConfig.isVolumesPerInstanceSet()) {
                        tempConfig.setVolumesPerInstance(singleConfig.getVolumesPerInstance());
                    }

                    blBlockDeviceConfigs.add(tempConfig);
                }

                blEbsConfig.setEbsBlockDeviceConfigs(blBlockDeviceConfigs);
            }
        }

        return blEbsConfig;
    }
    // endregion

    // region Cluster
    public static BlMrScalerAwsClusterConfiguration clusterApiToBl(ApiMrScalerAwsClusterConfiguration apiCluster) {
        BlMrScalerAwsClusterConfiguration blCluster = null;

        if (apiCluster != null) {
            blCluster = new BlMrScalerAwsClusterConfiguration();

            if (apiCluster.isVisibleToAllUsersSet()) {
                blCluster.setVisibleToAllUsers(apiCluster.getVisibleToAllUsers());
            }
            if (apiCluster.isTerminationProtectedSet()) {
                blCluster.setTerminationProtected(apiCluster.getTerminationProtected());
            }
            if (apiCluster.isServiceRoleSet()) {
                blCluster.setServiceRole(apiCluster.getServiceRole());
            }
            if (apiCluster.isSecurityConfigurationSet()) {
                blCluster.setSecurityConfiguration(apiCluster.getSecurityConfiguration());
            }
            if (apiCluster.isLogUriSet()) {
                blCluster.setLogUri(apiCluster.getLogUri());
            }
            if (apiCluster.isKeepJobFlowAliveWhenNoStepsSet()) {
                blCluster.setKeepJobFlowAliveWhenNoSteps(apiCluster.getKeepJobFlowAliveWhenNoSteps());
            }
            if (apiCluster.isJobFlowRoleSet()) {
                blCluster.setJobFlowRole(apiCluster.getJobFlowRole());
            }
            if (apiCluster.isAdditionalInfoSet()) {
                blCluster.setAdditionalInfo(apiCluster.getAdditionalInfo());
            }
        }

        return blCluster;
    }
    // endregion

    // region Strategy
    public static BlMrScalerAwsStrategyConfiguration strategyApiToBl(ApiMrScalerAwsStrategyConfiguration apiStrategy) {
        BlMrScalerAwsStrategyConfiguration blStrategy = null;

        if (apiStrategy != null) {
            blStrategy = new BlMrScalerAwsStrategyConfiguration();

            if (apiStrategy.isCloneSet()) {
                BlMrScalerAwsCloneStrategy blClone = null;

                if (apiStrategy.getClone() != null) {
                    blClone = new BlMrScalerAwsCloneStrategy();

                    if (apiStrategy.getClone().isOriginClusterIdSet()) {
                        blClone.setOriginClusterId(apiStrategy.getClone().getOriginClusterId());
                    }
                    if (apiStrategy.getClone().isNumberOfRetriesSet()) {
                        blClone.setNumberOfRetries(apiStrategy.getClone().getNumberOfRetries());
                    }
                    if (apiStrategy.getClone().isIncludeStepsSet()) {
                        blClone.setIncludeSteps(apiStrategy.getClone().getIncludeSteps());
                    }
                }

                blStrategy.setCloning(blClone);
            }

            if (apiStrategy.isNewSet()) {
                BlMrScalerAwsNewStrategy blNew = null;

                if (apiStrategy.getNew() != null) {
                    blNew = new BlMrScalerAwsNewStrategy();

                    if (apiStrategy.getNew().isReleaseLabelSet()) {
                        blNew.setReleaseLabel(apiStrategy.getNew().getReleaseLabel());
                    }
                    if (apiStrategy.getNew().isNumberOfRetriesSet()) {
                        blNew.setNumberOfRetries(apiStrategy.getNew().getNumberOfRetries());
                    }
                }

                blStrategy.setNew(blNew);
            }

            if (apiStrategy.isWrapSet()) {
                BlMrScalerAwsWrapStrategy blWrap = null;

                if (apiStrategy.getWrap() != null) {
                    blWrap = new BlMrScalerAwsWrapStrategy();

                    if (apiStrategy.getWrap().isSourceClusterIdSet()) {
                        blWrap.setSourceClusterId(apiStrategy.getWrap().getSourceClusterId());
                    }
                }

                blStrategy.setWrapping(blWrap);
            }

            if (apiStrategy.isProvisioningTimeoutSet()) {
                BlMrScalerAwsProvisioningTimeout blProTimeout = null;

                if (apiStrategy.getProvisioningTimeout() != null) {
                    blProTimeout = new BlMrScalerAwsProvisioningTimeout();

                    if (apiStrategy.getProvisioningTimeout().isTimeoutSet()) {
                        blProTimeout.setTimeout(apiStrategy.getProvisioningTimeout().getTimeout());
                    }
                    if (apiStrategy.getProvisioningTimeout().isTimeoutActionSet()) {
                        blProTimeout.setTimeoutAction(apiStrategy.getProvisioningTimeout().getTimeoutAction());
                    }
                }

                blStrategy.setProvisioningTimeout(blProTimeout);
            }

        }

        return blStrategy;
    }
    // endregion

    // region Scaling
    public static BlMrScalerAwsScalingConfiguration scalingApiToBl(ApiMrScalerAwsScalingConfiguration apiScaling) {
        BlMrScalerAwsScalingConfiguration blScaling = null;

        if (apiScaling != null) {
            blScaling = new BlMrScalerAwsScalingConfiguration();

            if (apiScaling.isUpSet()) {
                List<BlMrScalerAwsScalingPolicy> blUpConfig = convertScalingPolicyApiToBl(apiScaling.getUp());
                blScaling.setUp(blUpConfig);
            }
            if (apiScaling.isDownSet()) {
                List<BlMrScalerAwsScalingPolicy> blDownConfig = convertScalingPolicyApiToBl(apiScaling.getDown());
                blScaling.setDown(blDownConfig);
            }
        }

        return blScaling;
    }

    public static List<BlMrScalerAwsScalingPolicy> convertScalingPolicyApiToBl(
            List<ApiMrScalerAwsScalingPolicy> apiScalingPolicies) {
        List<BlMrScalerAwsScalingPolicy> blScalingPolicies = new ArrayList<>();

        if (apiScalingPolicies != null) {

            for (ApiMrScalerAwsScalingPolicy singlePolicy : apiScalingPolicies) {
                BlMrScalerAwsScalingPolicy tempPolicy = new BlMrScalerAwsScalingPolicy();

                if (singlePolicy.isUnitSet()) {
                    tempPolicy.setUnit(singlePolicy.getUnit());
                }
                if (singlePolicy.isThresholdSet()) {
                    tempPolicy.setThreshold(singlePolicy.getThreshold());
                }
                if (singlePolicy.isStatisticSet()) {
                    tempPolicy.setStatistic(singlePolicy.getStatistic());
                }
                if (singlePolicy.isPolicyNameSet()) {
                    tempPolicy.setPolicyName(singlePolicy.getPolicyName());
                }
                if (singlePolicy.isPeriodSet()) {
                    tempPolicy.setPeriod(singlePolicy.getPeriod());
                }
                if (singlePolicy.isOperatorSet()) {
                    tempPolicy.setOperator(singlePolicy.getOperator());
                }
                if (singlePolicy.isNamespaceSet()) {
                    tempPolicy.setNamespace(singlePolicy.getNamespace());
                }
                if (singlePolicy.isMinTargetCapacitySet()) {
                    tempPolicy.setMinTargetCapacity(singlePolicy.getMinTargetCapacity());
                }
                if (singlePolicy.isMetricNameSet()) {
                    tempPolicy.setMetricName(singlePolicy.getMetricName());
                }
                if (singlePolicy.isEvaluationPeriodsSet()) {
                    tempPolicy.setEvaluationPeriods(singlePolicy.getEvaluationPeriods());
                }
                if (singlePolicy.isCooldownSet()) {
                    tempPolicy.setCooldown(singlePolicy.getCooldown());
                }
                if (singlePolicy.isAdjustmentSet()) {
                    tempPolicy.setAdjustment(singlePolicy.getAdjustment());
                }
                if (singlePolicy.isActionSet()) {
                    BlMrScalerAwsScalingAction blScalingAction = new BlMrScalerAwsScalingAction();

                    if (singlePolicy.getAction().isTypeSet()) {
                        blScalingAction.setType(singlePolicy.getAction().getType());
                    }
                    if (singlePolicy.getAction().isTargetSet()) {
                        blScalingAction.setTarget(singlePolicy.getAction().getTarget());
                    }
                    if (singlePolicy.getAction().isMinTargetCapacitySet()) {
                        blScalingAction.setMinTargetCapacity(singlePolicy.getAction().getMinTargetCapacity());
                    }
                    if (singlePolicy.getAction().isMinimumSet()) {
                        blScalingAction.setMinimum(singlePolicy.getAction().getMinimum());
                    }
                    if (singlePolicy.getAction().isMaximumSet()) {
                        blScalingAction.setMaximum(singlePolicy.getAction().getMaximum());
                    }
                    if (singlePolicy.getAction().isAdjustmentSet()) {
                        blScalingAction.setAdjustment(singlePolicy.getAction().getAdjustment());
                    }

                    tempPolicy.setAction(blScalingAction);
                }
                if (singlePolicy.isDimensionsSet()) {
                    List<BlMrScalerAwsScalingDimenation> blDims = new ArrayList<>();

                    for (ApiMrScalerAwsScalingDimenation singleDim : singlePolicy.getDimensions()) {
                        BlMrScalerAwsScalingDimenation tempDim = new BlMrScalerAwsScalingDimenation();

                        if (singleDim.isValueSet()) {
                            tempDim.setValue(singleDim.getValue());
                        }
                        if (singleDim.isNameSet()) {
                            tempDim.setName(singleDim.getName());
                        }

                        blDims.add(tempDim);
                    }

                    tempPolicy.setDimensions(blDims);
                }

                blScalingPolicies.add(tempPolicy);
            }
        }

        return blScalingPolicies;
    }
    // endregion

    // region Scheduling
    public static BlMrScalerAwsSchedulingConfiguration schedulingApiToBl(
            ApiMrScalerAwsSchedulingConfiguration apiScheduling) {
        BlMrScalerAwsSchedulingConfiguration blScheduling = null;

        if (apiScheduling != null) {
            blScheduling = new BlMrScalerAwsSchedulingConfiguration();

            if (apiScheduling.isTasksSet()) {
                List<BlMrScalerAwsTask> blTasks = converSchedulingTasksApiToBl(apiScheduling.getTasks());
                blScheduling.setTasks(blTasks);
            }
        }

        return blScheduling;
    }

    public static List<BlMrScalerAwsTask> converSchedulingTasksApiToBl(List<ApiMrScalerAwsTask> apiTasks) {
        List<BlMrScalerAwsTask> blTasks = new ArrayList<>();

        for (ApiMrScalerAwsTask singleTask : apiTasks) {
            BlMrScalerAwsTask tempTask = new BlMrScalerAwsTask();

            if (singleTask.isTaskTypeSet()) {
                tempTask.setTaskType(singleTask.getTaskType());
            }
            if (singleTask.isTargetCapacitySet()) {
                tempTask.setTargetCapacity(singleTask.getTargetCapacity());
            }
            if (singleTask.isMinCapacitySet()) {
                tempTask.setMinCapacity(singleTask.getMinCapacity());
            }
            if (singleTask.isMaxCapacitySet()) {
                tempTask.setMaxCapacity(singleTask.getMaxCapacity());
            }
            if (singleTask.isIsEnabledSet()) {
                tempTask.setIsEnabled(singleTask.getIsEnabled());
            }
            if (singleTask.isInstanceGroupTypeSet()) {
                tempTask.setInstanceGroupType(singleTask.getInstanceGroupType());
            }
            if (singleTask.isCronExpressionSet()) {
                tempTask.setCronExpression(singleTask.getCronExpression());
            }

            blTasks.add(tempTask);
        }

        return blTasks;
    }
    // endregion
    // endregion

    // region toApi
    public static ApiMrScalerAws toApi(BlMrScalerAws blMrScalerAws) {
        ApiMrScalerAws apiMrScalerAws = null;

        if (blMrScalerAws != null) {
            apiMrScalerAws = new ApiMrScalerAws();

            if (blMrScalerAws.getName() != null) {
                apiMrScalerAws.setName(blMrScalerAws.getName());
            }
            if (blMrScalerAws.getDescription() != null) {
                apiMrScalerAws.setDescription(blMrScalerAws.getDescription());
            }
            if (blMrScalerAws.getRegion() != null) {
                apiMrScalerAws.setRegion(blMrScalerAws.getRegion());
            }
            if (blMrScalerAws.getId() != null) {
                apiMrScalerAws.setId(blMrScalerAws.getId());
            }
            if (blMrScalerAws.getCompute() != null) {
                ApiMrScalerAwsComputeConfiguration apiCompute = computeBlToApi(blMrScalerAws.getCompute());
                apiMrScalerAws.setCompute(apiCompute);
            }
            if (blMrScalerAws.getCluster() != null) {
                ApiMrScalerAwsClusterConfiguration apiCluster = clusterBlToApi(blMrScalerAws.getCluster());
                apiMrScalerAws.setCluster(apiCluster);
            }
            if (blMrScalerAws.getStrategy() != null) {
                ApiMrScalerAwsStrategyConfiguration apiStrategy = strategyBlToApi(blMrScalerAws.getStrategy());
                apiMrScalerAws.setStrategy(apiStrategy);
            }
            if (blMrScalerAws.getScaling() != null) {
                ApiMrScalerAwsScalingConfiguration apiScaling = scalingBlToApi(blMrScalerAws.getScaling());
                apiMrScalerAws.setScaling(apiScaling);
            }
            if (blMrScalerAws.getScheduling() != null) {
                ApiMrScalerAwsSchedulingConfiguration apiScheduling = schedulingBlToApi(blMrScalerAws.getScheduling());
                apiMrScalerAws.setScheduling(apiScheduling);
            }
        }

        return apiMrScalerAws;
    }

    // region Compute
    public static ApiMrScalerAwsComputeConfiguration computeBlToApi(BlMrScalerAwsComputeConfiguration blCompute) {
        ApiMrScalerAwsComputeConfiguration apiCompute = null;

        if (blCompute != null) {
            apiCompute = new ApiMrScalerAwsComputeConfiguration();

            if (blCompute.getEbsRootVolumeSize() != null) {
                apiCompute.setEbsRootVolumeSize(blCompute.getEbsRootVolumeSize());
            }
            if (blCompute.getEmrManagedMasterSecurityGroup() != null) {
                apiCompute.setEmrManagedMasterSecurityGroup(blCompute.getEmrManagedMasterSecurityGroup());
            }
            if (blCompute.getEmrManagedSlaveSecurityGroup() != null) {
                apiCompute.setEmrManagedSlaveSecurityGroup(blCompute.getEmrManagedSlaveSecurityGroup());
            }
            if (blCompute.getServiceAccessSecurityGroup() != null) {
                apiCompute.setServiceAccessSecurityGroup(blCompute.getServiceAccessSecurityGroup());
            }
            if (blCompute.getCustomAmiId() != null) {
                apiCompute.setCustomAmiId(blCompute.getCustomAmiId());
            }
            if (blCompute.getRepoUpgradeOnBoot() != null) {
                apiCompute.setRepoUpgradeOnBoot(blCompute.getRepoUpgradeOnBoot());
            }
            if (blCompute.getEc2KeyName() != null) {
                apiCompute.setEc2KeyName(blCompute.getEc2KeyName());
            }
            if (blCompute.getAdditionalMasterSecurityGroups() != null) {
                apiCompute.setAdditionalMasterSecurityGroups(blCompute.getAdditionalMasterSecurityGroups());
            }
            if (blCompute.getAdditionalSlaveSecurityGroups() != null) {
                apiCompute.setAdditionalSlaveSecurityGroups(blCompute.getAdditionalSlaveSecurityGroups());
            }
            if (blCompute.getAvailabilityZones() != null) {
                apiCompute.setAvailabilityZones(blCompute.getAvailabilityZones());
            }
            if (blCompute.getTags() != null) {
                apiCompute.setTags(blCompute.getTags());
            }
            if (blCompute.getBootstrapActions() != null) {
                ApiMrScalerAwsFile apiBootstrapFile = convertFileBlToApi(blCompute.getBootstrapActions());
                apiCompute.setBootstrapActions(apiBootstrapFile);
            }
            if (blCompute.getConfigurations() != null) {
                ApiMrScalerAwsFile apiConfigFile = convertFileBlToApi(blCompute.getConfigurations());
                apiCompute.setConfigurations(apiConfigFile);
            }
            if (blCompute.getSteps() != null) {
                ApiMrScalerAwsFile apiStepsFile = convertFileBlToApi(blCompute.getSteps());
                apiCompute.setSteps(apiStepsFile);
            }
            if (blCompute.getApplications() != null) {
                List<ApiMrScalerAwsApplication> apiApplications =
                        convertApplicationBlToApi(blCompute.getApplications());
                apiCompute.setApplications(apiApplications);
            }
            if (blCompute.getInstanceGroups() != null) {
                ApiMrScalerAwsInstancegroups apiInstanceGroups =
                        convertInstanceGroupsBlToApi(blCompute.getInstanceGroups());
                apiCompute.setInstanceGroups(apiInstanceGroups);
            }
        }

        return apiCompute;
    }

    public static ApiMrScalerAwsFile convertFileBlToApi(BlMrScalerAwsFile blFile) {
        ApiMrScalerAwsFile apiFile = null;

        if (blFile != null) {
            apiFile = new ApiMrScalerAwsFile();
            if (blFile.getFile() != null) {
                ApiMrScalerAwsFileParams apiFileParams = new ApiMrScalerAwsFileParams();

                if (blFile.getFile().getBucket() != null) {
                    apiFileParams.setBucket(blFile.getFile().getBucket());
                }
                if (blFile.getFile().getKey() != null) {
                    apiFileParams.setKey(blFile.getFile().getKey());
                }

                apiFile.setFile(apiFileParams);
            }
        }

        return apiFile;
    }

    public static List<ApiMrScalerAwsApplication> convertApplicationBlToApi(
            List<BlMrScalerAwsApplication> blApplications) {
        List<ApiMrScalerAwsApplication> apiApplications = null;

        if (blApplications != null) {
            apiApplications = new ArrayList<>();

            for (BlMrScalerAwsApplication singleApplication : blApplications) {
                ApiMrScalerAwsApplication tempApiApplication = new ApiMrScalerAwsApplication();

                if (singleApplication.getName() != null) {
                    tempApiApplication.setName(singleApplication.getName());
                }
                if (singleApplication.getVersion() != null) {
                    tempApiApplication.setVersion(singleApplication.getVersion());
                }

                apiApplications.add(tempApiApplication);
            }
        }

        return apiApplications;
    }

    public static ApiMrScalerAwsInstancegroups convertInstanceGroupsBlToApi(
            BlMrScalerAwsInstancegroups blInstanceGroups) {
        ApiMrScalerAwsInstancegroups apiInstanceGroups = null;

        if (blInstanceGroups != null) {
            apiInstanceGroups = new ApiMrScalerAwsInstancegroups();
            if (blInstanceGroups.getCoreGroup() != null) {
                ApiMrScalerAwsCoreGroup apiCoreGroup = convertCoreGroupBlToApi(blInstanceGroups.getCoreGroup());
                apiInstanceGroups.setCoreGroup(apiCoreGroup);
            }
            if (blInstanceGroups.getMasterGroup() != null) {
                ApiMrScalerAwsMasterGroup apiMastergroup = convertMasterGroupBlToApi(blInstanceGroups.getMasterGroup());
                apiInstanceGroups.setMasterGroup(apiMastergroup);
            }
            if (blInstanceGroups.getTaskGroup() != null) {
                ApiMrScalerAwsTaskGroup apiTaskGroup = convertTaskGroupBlToApi(blInstanceGroups.getTaskGroup());
                apiInstanceGroups.setTaskGroup(apiTaskGroup);
            }
        }

        return apiInstanceGroups;
    }

    public static ApiMrScalerAwsCoreGroup convertCoreGroupBlToApi(BlMrScalerAwsCoreGroup blCoreGroup) {
        ApiMrScalerAwsCoreGroup apiCoreGroup = null;

        if (blCoreGroup != null) {
            apiCoreGroup = new ApiMrScalerAwsCoreGroup();

            if (blCoreGroup.getInstanceTypes() != null) {
                apiCoreGroup.setInstanceTypes(blCoreGroup.getInstanceTypes());
            }
            if (blCoreGroup.getLifeCycle() != null) {
                apiCoreGroup.setLifeCycle(blCoreGroup.getLifeCycle());
            }
            if (blCoreGroup.getTarget() != null) {
                apiCoreGroup.setTarget(blCoreGroup.getTarget());
            }
            if (blCoreGroup.getCapacity() != null) {
                apiCoreGroup.setCapacity(blCoreGroup.getCapacity());
            }
            if (blCoreGroup.getConfigurations() != null) {
                ApiMrScalerAwsFile apiConfigFile = convertFileBlToApi(blCoreGroup.getConfigurations());
                apiCoreGroup.setConfigurations(apiConfigFile);
            }
            if (blCoreGroup.getEbsConfiguration() != null) {
                ApiMrScalerAwsEbsConfiguration apiEbsConfiguration =
                        convertEbsConfigBlToApi(blCoreGroup.getEbsConfiguration());
                apiCoreGroup.setEbsConfiguration(apiEbsConfiguration);
            }

        }

        return apiCoreGroup;
    }

    public static ApiMrScalerAwsMasterGroup convertMasterGroupBlToApi(BlMrScalerAwsMasterGroup blMasterGroup) {
        ApiMrScalerAwsMasterGroup apiMasterGroup = null;

        if (blMasterGroup != null) {
            apiMasterGroup = new ApiMrScalerAwsMasterGroup();

            if (blMasterGroup.getInstanceTypes() != null) {
                apiMasterGroup.setInstanceTypes(blMasterGroup.getInstanceTypes());
            }
            if (blMasterGroup.getTarget() != null) {
                apiMasterGroup.setTarget(blMasterGroup.getTarget());
            }
            if (blMasterGroup.getLifeCycle() != null) {
                apiMasterGroup.setLifeCycle(blMasterGroup.getLifeCycle());
            }
            if (blMasterGroup.getConfigurations() != null) {
                ApiMrScalerAwsFile apiConfigFile = convertFileBlToApi(blMasterGroup.getConfigurations());
                apiMasterGroup.setConfigurations(apiConfigFile);
            }
            if (blMasterGroup.getEbsConfiguration() != null) {
                ApiMrScalerAwsEbsConfiguration apiEbsConfig =
                        convertEbsConfigBlToApi(blMasterGroup.getEbsConfiguration());
                apiMasterGroup.setEbsConfiguration(apiEbsConfig);
            }
        }
        return apiMasterGroup;
    }

    public static ApiMrScalerAwsTaskGroup convertTaskGroupBlToApi(BlMrScalerAwsTaskGroup blTaskGroup) {
        ApiMrScalerAwsTaskGroup apiTaskGroup = null;

        if (blTaskGroup != null) {
            apiTaskGroup = new ApiMrScalerAwsTaskGroup();

            if (blTaskGroup.getInstanceTypes() != null) {
                apiTaskGroup.setInstanceTypes(blTaskGroup.getInstanceTypes());
            }
            if (blTaskGroup.getLifeCycle() != null) {
                apiTaskGroup.setLifeCycle(blTaskGroup.getLifeCycle());
            }
            if (blTaskGroup.getCapacity() != null) {
                apiTaskGroup.setCapacity(blTaskGroup.getCapacity());
            }
            if (blTaskGroup.getEbsConfiguration() != null) {
                ApiMrScalerAwsEbsConfiguration apiEbsConfig =
                        convertEbsConfigBlToApi(blTaskGroup.getEbsConfiguration());
                apiTaskGroup.setEbsConfiguration(apiEbsConfig);
            }
            if (blTaskGroup.getConfigurations() != null) {
                ApiMrScalerAwsFile apiFile = convertFileBlToApi(blTaskGroup.getConfigurations());
                apiTaskGroup.setConfigurations(apiFile);
            }
        }
        return apiTaskGroup;
    }

    public static ApiMrScalerAwsEbsConfiguration convertEbsConfigBlToApi(BlMrScalerAwsEbsConfiguration blEbsConfig) {
        ApiMrScalerAwsEbsConfiguration apiEbsConfig = null;

        if (blEbsConfig != null) {
            apiEbsConfig = new ApiMrScalerAwsEbsConfiguration();

            if (blEbsConfig.getEbsOptimized() != null) {
                apiEbsConfig.setEbsOptimized(blEbsConfig.getEbsOptimized());
            }
            if (blEbsConfig.getEbsBlockDeviceConfigs() != null) {
                List<ApiMrScalerAwsEbsBlockDeviceConfig> apiBlockDeviceConfigs = new ArrayList<>();

                for (BlMrScalerAwsEbsBlockDeviceConfig singleConfig : blEbsConfig.getEbsBlockDeviceConfigs()) {
                    ApiMrScalerAwsEbsBlockDeviceConfig tempConfig = new ApiMrScalerAwsEbsBlockDeviceConfig();

                    if (singleConfig.getVolumeSpecification() != null) {
                        ApiMrScalerAwsVolumeSpecification apiVolumetSpec = new ApiMrScalerAwsVolumeSpecification();

                        if (singleConfig.getVolumeSpecification().getIops() != null) {
                            apiVolumetSpec.setIops(singleConfig.getVolumeSpecification().getIops());
                        }
                        if (singleConfig.getVolumeSpecification().getSizeInGB() != null) {
                            apiVolumetSpec.setSizeInGB(singleConfig.getVolumeSpecification().getSizeInGB());
                        }
                        if (singleConfig.getVolumeSpecification().getVolumeType() != null) {
                            apiVolumetSpec.setVolumeType(singleConfig.getVolumeSpecification().getVolumeType());
                        }

                        tempConfig.setVolumeSpecification(apiVolumetSpec);
                    }
                    if (singleConfig.getVolumesPerInstance() != null) {
                        tempConfig.setVolumesPerInstance(singleConfig.getVolumesPerInstance());
                    }

                    apiBlockDeviceConfigs.add(tempConfig);
                }

                apiEbsConfig.setEbsBlockDeviceConfigs(apiBlockDeviceConfigs);
            }
        }

        return apiEbsConfig;
    }
    // endregion

    // region Cluster
    public static ApiMrScalerAwsClusterConfiguration clusterBlToApi(BlMrScalerAwsClusterConfiguration blCluster) {
        ApiMrScalerAwsClusterConfiguration apiCluster = null;

        if (blCluster != null) {
            apiCluster = new ApiMrScalerAwsClusterConfiguration();

            if (blCluster.getVisibleToAllUsers() != null) {
                apiCluster.setVisibleToAllUsers(blCluster.getVisibleToAllUsers());
            }
            if (blCluster.getTerminationProtected() != null) {
                apiCluster.setTerminationProtected(blCluster.getTerminationProtected());
            }
            if (blCluster.getServiceRole() != null) {
                apiCluster.setServiceRole(blCluster.getServiceRole());
            }
            if (blCluster.getSecurityConfiguration() != null) {
                apiCluster.setSecurityConfiguration(blCluster.getSecurityConfiguration());
            }
            if (blCluster.getLogUri() != null) {
                apiCluster.setLogUri(blCluster.getLogUri());
            }
            if (blCluster.getKeepJobFlowAliveWhenNoSteps() != null) {
                apiCluster.setKeepJobFlowAliveWhenNoSteps(blCluster.getKeepJobFlowAliveWhenNoSteps());
            }
            if (blCluster.getJobFlowRole() != null) {
                apiCluster.setJobFlowRole(blCluster.getJobFlowRole());
            }
            if (blCluster.getAdditionalInfo() != null) {
                apiCluster.setAdditionalInfo(blCluster.getAdditionalInfo());
            }
        }

        return apiCluster;
    }
    // endregion

    // region Strategy
    public static ApiMrScalerAwsStrategyConfiguration strategyBlToApi(BlMrScalerAwsStrategyConfiguration blStrategy) {
        ApiMrScalerAwsStrategyConfiguration apiStrategy = null;

        if (blStrategy != null) {
            apiStrategy = new ApiMrScalerAwsStrategyConfiguration();

            if (blStrategy.getCloning() != null) {
                ApiMrScalerAwsCloneStrategy apiClone = new ApiMrScalerAwsCloneStrategy();

                if (blStrategy.getCloning().getOriginClusterId() != null) {
                    apiClone.setOriginClusterId(blStrategy.getCloning().getOriginClusterId());
                }
                if (blStrategy.getCloning().getNumberOfRetries() != null) {
                    apiClone.setNumberOfRetries(blStrategy.getCloning().getNumberOfRetries());
                }
                if (blStrategy.getCloning().getIncludeSteps() != null) {
                    apiClone.setIncludeSteps(blStrategy.getCloning().getIncludeSteps());
                }

                apiStrategy.setClone(apiClone);
            }

            if (blStrategy.getNew() != null) {
                ApiMrScalerAwsNewStrategy apiNew = new ApiMrScalerAwsNewStrategy();

                if (blStrategy.getNew().getReleaseLabel() != null) {
                    apiNew.setReleaseLabel(blStrategy.getNew().getReleaseLabel());
                }
                if (blStrategy.getNew().getNumberOfRetries() != null) {
                    apiNew.setNumberOfRetries(blStrategy.getNew().getNumberOfRetries());
                }

                apiStrategy.setNew(apiNew);
            }

            if (blStrategy.getWrapping() != null) {
                ApiMrScalerAwsWrapStrategy apiWrap = new ApiMrScalerAwsWrapStrategy();

                if (blStrategy.getWrapping().getSourceClusterId() != null) {
                    apiWrap.setSourceClusterId(blStrategy.getWrapping().getSourceClusterId());
                }

                apiStrategy.setWrap(apiWrap);
            }

            if (blStrategy.getProvisioningTimeout() != null) {
                ApiMrScalerAwsProvisioningTimeout apiProTimeout = new ApiMrScalerAwsProvisioningTimeout();

                if (blStrategy.getProvisioningTimeout().getTimeout() != null) {
                    apiProTimeout.setTimeout(blStrategy.getProvisioningTimeout().getTimeout());
                }
                if (blStrategy.getProvisioningTimeout().getTimeoutAction() != null) {
                    apiProTimeout.setTimeoutAction(blStrategy.getProvisioningTimeout().getTimeoutAction());
                }

                apiStrategy.setProvisioningTimeout(apiProTimeout);
            }

        }

        return apiStrategy;
    }
    // endregion

    // region Scaling
    public static ApiMrScalerAwsScalingConfiguration scalingBlToApi(BlMrScalerAwsScalingConfiguration blScaling) {
        ApiMrScalerAwsScalingConfiguration apiScaling = null;

        if (blScaling != null) {
            apiScaling = new ApiMrScalerAwsScalingConfiguration();

            if (blScaling.getUp() != null) {
                List<ApiMrScalerAwsScalingPolicy> apiUpConfig = convertScalingPolicyBlToApi(blScaling.getUp());
                apiScaling.setUp(apiUpConfig);
            }
            if (blScaling.getDown() != null) {
                List<ApiMrScalerAwsScalingPolicy> apiDownConfig = convertScalingPolicyBlToApi(blScaling.getDown());
                apiScaling.setDown(apiDownConfig);
            }
        }

        return apiScaling;
    }

    public static List<ApiMrScalerAwsScalingPolicy> convertScalingPolicyBlToApi(
            List<BlMrScalerAwsScalingPolicy> blScalingPolicies) {
        List<ApiMrScalerAwsScalingPolicy> apiScalingPolicies = null;

        if (blScalingPolicies != null) {
            apiScalingPolicies = new LinkedList<>();

            for (BlMrScalerAwsScalingPolicy singlePolicy : blScalingPolicies) {
                ApiMrScalerAwsScalingPolicy tempPolicy = new ApiMrScalerAwsScalingPolicy();

                if (singlePolicy.getUnit() != null) {
                    tempPolicy.setUnit(singlePolicy.getUnit());
                }
                if (singlePolicy.getThreshold() != null) {
                    tempPolicy.setThreshold(singlePolicy.getThreshold());
                }
                if (singlePolicy.getStatistic() != null) {
                    tempPolicy.setStatistic(singlePolicy.getStatistic());
                }
                if (singlePolicy.getPolicyName() != null) {
                    tempPolicy.setPolicyName(singlePolicy.getPolicyName());
                }
                if (singlePolicy.getPeriod() != null) {
                    tempPolicy.setPeriod(singlePolicy.getPeriod());
                }
                if (singlePolicy.getOperator() != null) {
                    tempPolicy.setOperator(singlePolicy.getOperator());
                }
                if (singlePolicy.getNamespace() != null) {
                    tempPolicy.setNamespace(singlePolicy.getNamespace());
                }
                if (singlePolicy.getMinTargetCapacity() != null) {
                    tempPolicy.setMinTargetCapacity(singlePolicy.getMinTargetCapacity());
                }
                if (singlePolicy.getMetricName() != null) {
                    tempPolicy.setMetricName(singlePolicy.getMetricName());
                }
                if (singlePolicy.getEvaluationPeriods() != null) {
                    tempPolicy.setEvaluationPeriods(singlePolicy.getEvaluationPeriods());
                }
                if (singlePolicy.getCooldown() != null) {
                    tempPolicy.setCooldown(singlePolicy.getCooldown());
                }
                if (singlePolicy.getAdjustment() != null) {
                    tempPolicy.setAdjustment(singlePolicy.getAdjustment());
                }

                if (singlePolicy.getAction() != null) {
                    ApiMrScalerAwsScalingAction apiScalingAction = new ApiMrScalerAwsScalingAction();

                    if (singlePolicy.getAction().getType() != null) {
                        apiScalingAction.setType(singlePolicy.getAction().getType());
                    }
                    if (singlePolicy.getAction().getTarget() != null) {
                        apiScalingAction.setTarget(singlePolicy.getAction().getTarget());
                    }
                    if (singlePolicy.getAction().getMinTargetCapacity() != null) {
                        apiScalingAction.setMinTargetCapacity(singlePolicy.getAction().getMinTargetCapacity());
                    }
                    if (singlePolicy.getAction().getMinimum() != null) {
                        apiScalingAction.setMinimum(singlePolicy.getAction().getMinimum());
                    }
                    if (singlePolicy.getAction().getMaximum() != null) {
                        apiScalingAction.setMaximum(singlePolicy.getAction().getMaximum());
                    }
                    if (singlePolicy.getAction().getAdjustment() != null) {
                        apiScalingAction.setAdjustment(singlePolicy.getAction().getAdjustment());
                    }

                    tempPolicy.setAction(apiScalingAction);
                }

                if (singlePolicy.getDimensions() != null) {
                    List<ApiMrScalerAwsScalingDimenation> apiDims = new ArrayList<>();

                    for (BlMrScalerAwsScalingDimenation singleDim : singlePolicy.getDimensions()) {
                        ApiMrScalerAwsScalingDimenation tempDim = new ApiMrScalerAwsScalingDimenation();

                        if (singleDim.getValue() != null) {
                            tempDim.setValue(singleDim.getValue());
                        }
                        if (singleDim.getName() != null) {
                            tempDim.setName(singleDim.getName());
                        }

                        apiDims.add(tempDim);
                    }

                    tempPolicy.setDimensions(apiDims);
                }

                apiScalingPolicies.add(tempPolicy);
            }
        }

        return apiScalingPolicies;
    }
    // endregion

    // region Scheduling
    public static ApiMrScalerAwsSchedulingConfiguration schedulingBlToApi(
            BlMrScalerAwsSchedulingConfiguration blScheduling) {
        ApiMrScalerAwsSchedulingConfiguration apiScheduling = null;

        if (blScheduling != null) {
            apiScheduling = new ApiMrScalerAwsSchedulingConfiguration();

            if (blScheduling.getTasks() != null) {
                List<ApiMrScalerAwsTask> apiTasks = converSchedulingTasksBlToApi(blScheduling.getTasks());
                apiScheduling.setTasks(apiTasks);
            }
        }

        return apiScheduling;
    }

    public static List<ApiMrScalerAwsTask> converSchedulingTasksBlToApi(List<BlMrScalerAwsTask> blTasks) {
        List<ApiMrScalerAwsTask> apiTasks = new ArrayList<>();

        for (BlMrScalerAwsTask singleTask : blTasks) {
            ApiMrScalerAwsTask tempTask = new ApiMrScalerAwsTask();

            if (singleTask.getTaskType() != null) {
                tempTask.setTaskType(singleTask.getTaskType());
            }
            if (singleTask.getTargetCapacity() != null) {
                tempTask.setTargetCapacity(singleTask.getTargetCapacity());
            }
            if (singleTask.getMinCapacity() != null) {
                tempTask.setMinCapacity(singleTask.getMinCapacity());
            }
            if (singleTask.getMaxCapacity() != null) {
                tempTask.setMaxCapacity(singleTask.getMaxCapacity());
            }
            if (singleTask.getIsEnabled() != null) {
                tempTask.setIsEnabled(singleTask.getIsEnabled());
            }
            if (singleTask.getInstanceGroupType() != null) {
                tempTask.setInstanceGroupType(singleTask.getInstanceGroupType());
            }
            if (singleTask.getCronExpression() != null) {
                tempTask.setCronExpression(singleTask.getCronExpression());
            }

            apiTasks.add(tempTask);
        }

        return apiTasks;
    }
    // endregion
    // endregion
}
