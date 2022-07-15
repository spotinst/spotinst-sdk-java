package com.spotinst.sdkjava.model.converters.ocean.ecs;

import com.spotinst.sdkjava.model.api.ocean.ecs.*;
import com.spotinst.sdkjava.model.bl.ocean.ecs.*;
import java.util.List;
import java.util.stream.Collectors;


public class OceanEcsConverter {

    //region BL -> DAL

    public static ApiOceanEcsCluster toDal(OceanEcsCluster src) {
        ApiOceanEcsCluster apiCluster = null;

        if (src != null) {
            apiCluster = new ApiOceanEcsCluster();

            if (src.isIdSet()) {
                apiCluster.setId(src.getId());
            }
            if (src.isNameSet()) {
                apiCluster.setName(src.getName());
            }
            if (src.isRegionSet()) {
                apiCluster.setRegion(src.getRegion());
            }
            if (src.isClusterNameSet()) {
                apiCluster.setclusterName(src.getClusterName());
            }
            if (src.isAutoScalerSet()) {
                apiCluster.setAutoScaler(toDal(src.getAutoScaler()));
            }
            if (src.isCapacitySet()) {
                apiCluster.setCapacity(toDal(src.getCapacity()));
            }
            if (src.isStrategySet()) {
                apiCluster.setStrategy(toDal(src.getStrategy()));
            }
            if (src.isComputeSet()) {
                apiCluster.setCompute(toDal(src.getCompute()));
            }
            if (src.isSchedulingSet()) {
                apiCluster.setScheduling(toDal(src.getScheduling()));
            }
        }

        return apiCluster;
    }

    private static ApiClusterAutoScalerConfiguration toDal(ClusterAutoScalerConfiguration autoScaler) {
        ApiClusterAutoScalerConfiguration retval = null;

        if (autoScaler != null) {
            retval = new ApiClusterAutoScalerConfiguration();

            if (autoScaler.isIsEnabledSet()) {
                retval.setIsEnabled(autoScaler.getIsEnabled());
            }
            if (autoScaler.isAttributesSet()) {
                retval.setAttribute(toDal(autoScaler.getAttribute()));
            }
            if (autoScaler.isCooldownSet()) {
                retval.setCooldown(autoScaler.getCooldown());
            }
            if (autoScaler.isResourceLimitsSet()) {
                retval.setResourceLimits(toDal(autoScaler.getResourceLimits()));
            }
            if (autoScaler.isDownSet()) {
                retval.setDown(toDal(autoScaler.getDown()));
            }
            if (autoScaler.isHeadroomSet()) {
                retval.setHeadroom(toDal(autoScaler.getHeadroom()));
            }
            if (autoScaler.isIsAutoConfigSet()) {
                retval.setIsAutoConfig(autoScaler.getIsAutoConfig());
            }
            if (autoScaler.isAutoHeadroomPercentageSet()) {
                retval.setAutoHeadroomPercentage(autoScaler.getAutoHeadroomPercentage());
            }
            if (autoScaler.isShouldScaleDownNonServiceTasksSet()) {
                retval.setshouldScaleDownNonServiceTasks(autoScaler.getshouldScaleDownNonServiceTasks());
            }
            if(autoScaler.isEnableAutomaticAndManualHeadroomSet()){
                retval.setenableAutomaticAndManualHeadroom(autoScaler.getenableAutomaticAndManualHeadroom());
            }
        }
        return retval;
    }

    private static ApiClusterResourceLimitsSpecification toDal(ClusterResourceLimitsSpecification resourceLimitsSpecification) {
        ApiClusterResourceLimitsSpecification retVal = null;

        if (resourceLimitsSpecification != null) {
            retVal = new ApiClusterResourceLimitsSpecification();

            if (resourceLimitsSpecification.isMaxMemoryGibSet()) {
                retVal.setMaxMemoryGib(resourceLimitsSpecification.getMaxMemoryGib());
            }
            if (resourceLimitsSpecification.isMaxVCpuSet()) {
                retVal.setMaxVCpu(resourceLimitsSpecification.getMaxVCpu());
            }
        }
        return retVal;

    }

    private static ApiClusterDownSpecification toDal(ClusterDownSpecification down) {
        ApiClusterDownSpecification retVal = null;

        if (down != null) {
            retVal = new ApiClusterDownSpecification();

            if (down.isMaxScaleDownPercentageSet()) {
                retVal.setMaxScaleDownPercentage(down.getMaxScaleDownPercentage());
            }
            if (down.isEvaluationPeriodSet()) {
                retVal.setEvaluationPeriods(down.getEvaluationPeriods());
            }
        }
        return retVal;

    }

    private static ApiClusterCapacityConfiguration toDal(ClusterCapacityConfiguration capacity) {
        ApiClusterCapacityConfiguration retVal = null;

        if (capacity != null) {
            retVal = new ApiClusterCapacityConfiguration();

            if (capacity.isMaximumSet()) {
                retVal.setMaximum(capacity.getMaximum());
            }

            if (capacity.isMinimumSet()) {
                retVal.setMinimum(capacity.getMinimum());
            }

            if (capacity.isTargetSet()) {
                retVal.setTarget(capacity.getTarget());
            }
            if (capacity.isUnitSet()) {
                retVal.setUnit(capacity.getUnit());
            }

        }

        return retVal;
    }

    private static ApiClusterComputeConfiguration toDal(ClusterComputeConfiguration compute) {
        ApiClusterComputeConfiguration retVal = null;

        if (compute != null) {
            retVal = new ApiClusterComputeConfiguration();

            if (compute.isSubnetIdsSet()) {
                retVal.setSubnetIds(compute.getSubnetIds());
            }
            if (compute.isLaunchSpecificationSet()) {
                retVal.setLaunchSpecification(toDal(compute.getLaunchSpecification()));
            }
            if (compute.isOptimizeImagesSet()) {
                retVal.setOptimizeImages(toDal(compute.getOptimizeImages()));
            }
        }
        return retVal;
    }

    private static ApiClusterOptimizeImageConfiguration toDal(ClusterOptimizeImageConfiguration optimizeImage) {
        ApiClusterOptimizeImageConfiguration retVal = null;

        if(optimizeImage != null)
        {
            retVal = new ApiClusterOptimizeImageConfiguration();

            if(optimizeImage.isPerformAtSet()){
                retVal.setPerformAt(optimizeImage.getPerformAt());
            }
            if(optimizeImage.isShouldOptimizeEcsAmiSet()) {
                retVal.setShouldOptimizeEcsAmi(optimizeImage.getShouldOptimizeEcsAmi());
            }
            if(optimizeImage.istimeWindowsSet()){
                retVal.setTimeWindows(optimizeImage.getTimeWindows());
            }

        }
        return retVal;
    }

    private static ApiClusterSchedulingConfiguration toDal(ClusterSchedulingConfiguration scheduling) {
        ApiClusterSchedulingConfiguration retVal = null;

        if (scheduling != null) {
            retVal = new ApiClusterSchedulingConfiguration();

            if (scheduling.isTasksSet()) {
                if (scheduling.getTasks() != null) {
                    List<ApiClusterTasksConfiguration> taskList =
                            scheduling.getTasks().stream().map(OceanEcsConverter::toDal).collect(Collectors.toList());
                    retVal.setTasks(taskList);
                }
            }
            if(scheduling.isShutdownHoursSet()){
                retVal.setShutdownHours(toDal(scheduling.getShutdownHours()));
            }
        }

        return retVal;
    }

    private static ApiClusterShutdownHoursSpecification toDal(ClusterShutdownHoursSpecification shutDownHour) {
        ApiClusterShutdownHoursSpecification retVal = null;

        if(shutDownHour != null)
        {
            retVal = new ApiClusterShutdownHoursSpecification();

            if(shutDownHour.isIsEnabledSet()){
                retVal.setIsEnabled(shutDownHour.getIsEnabled());
            }
            if(shutDownHour.istimeWindowsSet()) {
                retVal.setTimeWindows(shutDownHour.getTimeWindows());
            }
        }
        return retVal;
    }


    private static ApiClusterTasksConfiguration toDal(ClusterTasksConfiguration tasksConfiguration) {
        ApiClusterTasksConfiguration retVal = null;

        if (tasksConfiguration != null) {
            retVal = new ApiClusterTasksConfiguration();

            if (tasksConfiguration.isIsEnabledSet()) {
                retVal.setIsEnabled(tasksConfiguration.getIsEnabled());
            }
            if (tasksConfiguration.isCronExpressionSet()) {
                retVal.setCronExpression(tasksConfiguration.getCronExpression());
            }
            if (tasksConfiguration.isTaskTypeSet()) {
                retVal.setTaskType(tasksConfiguration.getTaskType());
            }
        }

        return retVal;
    }

    private static ApiClusterStrategyConfiguration toDal(ClusterStrategyConfiguration strategy) {
        ApiClusterStrategyConfiguration retVal = null;

        if (strategy != null) {
            retVal = new ApiClusterStrategyConfiguration();

            if (strategy.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(strategy.getDrainingTimeout());
            }
            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }
            if (strategy.isUtilizeReservedInstancesSet()) {
                retVal.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }
            if (strategy.isspotPercentageSet()) {
                retVal.setspotPercentage(strategy.getspotPercentage());
            }
        }
        return retVal;
    }

    public static ApiClusterLaunchSpecification toDal(ClusterLaunchSpecification launchSpecification) {
        ApiClusterLaunchSpecification retVal = null;

        if (launchSpecification != null) {
            retVal = new ApiClusterLaunchSpecification();

            if (launchSpecification.isIdSet()) {
                retVal.setId(launchSpecification.getId());
            }
            if (launchSpecification.isImageIdSet()) {
                retVal.setImageId(launchSpecification.getImageId());
            }
            if (launchSpecification.isNameSet()) {
                retVal.setName(launchSpecification.getName());
            }
            if (launchSpecification.isOceanIdSet()) {
                retVal.setOceanId(launchSpecification.getOceanId());
            }
            if (launchSpecification.isAttributesSet()) {
                List<ApiClusterAttributes> attributes =
                        launchSpecification.getAttributes().stream().map(OceanEcsConverter::toDal)
                                           .collect(Collectors.toList());
                retVal.setAttributes(attributes);
            }
            if (launchSpecification.isAutoScaleSet()) {
                retVal.setAutoScale(toDal(launchSpecification.getAutoScale()));
            }
            if (launchSpecification.isBlockDeviceMappingsSet()) {
                List<ApiLaunchSpecBlockDeviceMappings> blockDeviceMappings =
                        launchSpecification.getBlockDeviceMappings().stream().map(OceanEcsConverter::toDal)
                                           .collect(Collectors.toList());
                retVal.setBlockDeviceMappings(blockDeviceMappings);
            }
            if (launchSpecification.isIamInstanceProfileSet()) {
                ApiLaunchSpecIamInstanceProfileSpecification instanceProfileSpecs =
                        toDal(launchSpecification.getIamInstanceProfile());
                retVal.setIamInstanceProfile(instanceProfileSpecs);
            }
            if (launchSpecification.isInstanceMetadataOptionsSet()) {
                retVal.setInstanceMetadataOptions(toDal(launchSpecification.getInstanceMetadataOptions()));
            }
            if (launchSpecification.isRestrictScaleDownSet()) {
                retVal.setRestrictScaleDown(launchSpecification.getRestrictScaleDown());
            }
            if (launchSpecification.isSecurityGroupIdsSet()) {
                retVal.setSecurityGroupIds(launchSpecification.getSecurityGroupIds());
            }
            if (launchSpecification.isSubnetIdsSet()) {
                retVal.setSubnetIds(launchSpecification.getSubnetIds());
            }
            if (launchSpecification.isTagsSet()) {
                List<ApiLaunchSpecTagsSpecification> tags =
                        launchSpecification.getTags().stream().map(OceanEcsConverter::toDal)
                                           .collect(Collectors.toList());
                retVal.setTags(tags);
            }
            if (launchSpecification.isUserDataSet()) {
                retVal.setUserData(launchSpecification.getUserData());
            }
        }
        return retVal;
    }

    private static ApiClusterAttributes toDal(ClusterAttributes attributes) {
        ApiClusterAttributes retVal = null;

        if (attributes != null) {

            if (attributes.isKeySet() && attributes.isValueSet()) {
                retVal = new ApiClusterAttributes(attributes.getKey(), attributes.getValue());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecAutoScaleSpecification toDal(LaunchSpecAutoScaleSpecification autoScaler) {
        ApiLaunchSpecAutoScaleSpecification retval = null;

        if (autoScaler != null) {
            retval = new ApiLaunchSpecAutoScaleSpecification();

            if (autoScaler.isHeadroomSet()) {
                List<ApiClusterHeadroomsSpecification> headrooms =
                        autoScaler.getHeadrooms().stream().map(OceanEcsConverter::toDal)
                                  .collect(Collectors.toList());
                retval.setHeadrooms(headrooms);
            }
        }

        return retval;
    }

    private static ApiClusterHeadroomsSpecification toDal(ClusterHeadroomsSpecification headroom) {
        ApiClusterHeadroomsSpecification retVal = null;

        if (headroom != null) {
            retVal = new ApiClusterHeadroomsSpecification();

            if (headroom.isCpuPerUnitSet()) {
                retVal.setCpuPerUnit(headroom.getCpuPerUnit());
            }
            if (headroom.isMemoryPerUnitSet()) {
                retVal.setMemoryPerUnit(headroom.getMemoryPerUnit());
            }
            if (headroom.isNumOfUnitsSet()) {
                retVal.setNumOfUnits(headroom.getNumOfUnits());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecBlockDeviceMappings toDal(LaunchSpecBlockDeviceMappings blockDeviceMappings) {
        ApiLaunchSpecBlockDeviceMappings retVal = null;

        if (blockDeviceMappings != null) {
            retVal = new ApiLaunchSpecBlockDeviceMappings();

            if (blockDeviceMappings.isDeviceNameSet()) {
                retVal.setDeviceName(blockDeviceMappings.getDeviceName());
            }
            if (blockDeviceMappings.isEbsSet()) {
                retVal.setEbs(toDal(blockDeviceMappings.getEbs()));
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecEbsSpecification toDal(LaunchSpecEbsSpecification ebs) {
        ApiLaunchSpecEbsSpecification retVal = null;

        if (ebs != null) {
            retVal = new ApiLaunchSpecEbsSpecification();

            if (ebs.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(ebs.getDeleteOnTermination());
            }
            if (ebs.isDynamicVolumeSizeSet()) {
                retVal.setDynamicVolumeSize(toDal(ebs.getDynamicVolumeSize()));
            }
            if (ebs.isEncryptedSet()) {
                retVal.setEncrypted(ebs.getEncrypted());
            }
            if (ebs.isIopsSet()) {
                retVal.setIops(ebs.getIops());
            }
            if (ebs.isKmsKeyIdSet()) {
                retVal.setKmsKeyId(ebs.getKmsKeyId());
            }
            if (ebs.isSnapshotIdSet()) {
                retVal.setSnapshotId(ebs.getSnapshotId());
            }
            if (ebs.isThroughputSet()) {
                retVal.setThroughput(ebs.getThroughput());
            }
            if (ebs.isVolumeSizeSet()) {
                retVal.setVolumeSize(ebs.getVolumeSize());
            }
            if (ebs.isVolumeTypeSet()) {
                retVal.setVolumeType(ebs.getVolumeType());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecDynamicVolumeSize toDal(LaunchSpecDynamicVolumeSize dynamicVolumeSize) {
        ApiLaunchSpecDynamicVolumeSize retVal = null;

        if (dynamicVolumeSize != null) {
            retVal = new ApiLaunchSpecDynamicVolumeSize();

            if (dynamicVolumeSize.isBaseSizeSet()) {
                retVal.setBaseSize(dynamicVolumeSize.getBaseSize());
            }
            if (dynamicVolumeSize.isResourceSet()) {
                retVal.setResource(dynamicVolumeSize.getResource());
            }
            if (dynamicVolumeSize.isSizePerResourceUnitSet()) {
                retVal.setSizePerResourceUnit(dynamicVolumeSize.getSizePerResourceUnit());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecIamInstanceProfileSpecification toDal(
            LaunchSpecIamInstanceProfileSpecification instanceProfile) {
        ApiLaunchSpecIamInstanceProfileSpecification retVal = null;

        if (instanceProfile != null) {
            retVal = new ApiLaunchSpecIamInstanceProfileSpecification();

            if (instanceProfile.isArnSet()) {
                retVal.setArn(instanceProfile.getArn());
            }
            if (instanceProfile.isNameSet()) {
                retVal.setName(instanceProfile.getName());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecInstanceMetadataOptions toDal(LaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
        ApiLaunchSpecInstanceMetadataOptions retVal = null;

        if (instanceMetadataOptions != null) {
            retVal = new ApiLaunchSpecInstanceMetadataOptions();

            if (instanceMetadataOptions.isHttpPutResponseHopLimitSet()) {
                retVal.setHttpPutResponseHopLimit(instanceMetadataOptions.getHttpPutResponseHopLimit());
            }
            if (instanceMetadataOptions.isHttpTokensSet()) {
                retVal.setHttpTokens(instanceMetadataOptions.getHttpTokens());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecTagsSpecification toDal(LaunchSpecTagsSpecification tag) {
        ApiLaunchSpecTagsSpecification retVal = null;

        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                retVal = new ApiLaunchSpecTagsSpecification(tag.getTagKey(), tag.getTagValue());
            }
        }
        return retVal;
    }

    public static ApiEcsInitiateRoll toDal(EcsInitiateRoll initiateRollRequest) {
        ApiEcsInitiateRoll retval = null;

        if (initiateRollRequest != null) {
            retval = new ApiEcsInitiateRoll();

            if (initiateRollRequest.isBatchSizePercentageSet()) {
                retval.setBatchSizePercentage(initiateRollRequest.getBatchSizePercentage());
            }

            if (initiateRollRequest.isCommentSet()) {
                retval.setComment(initiateRollRequest.getComment());
            }

            if (initiateRollRequest.isBatchMinHealthyPercentageSet()) {
                retval.setBatchMinHealthyPercentage(initiateRollRequest.getBatchMinHealthyPercentage());
            }

            if (initiateRollRequest.isInstanceIdsSet() && initiateRollRequest.getInstanceIds() != null) {
                retval.setInstanceIds(initiateRollRequest.getInstanceIds());
            }

            if (initiateRollRequest.isLaunchSpecIdsSet() && initiateRollRequest.getLaunchSpecIds() != null) {
                retval.setLaunchSpecIds(initiateRollRequest.getLaunchSpecIds());
            }
        }

        return retval;
    }

    //endregion

    //region DAL -> BL
    public static OceanEcsCluster toBl(ApiOceanEcsCluster src) {
        OceanEcsCluster cluster = null;

        if (src != null) {
            OceanEcsCluster.Builder clusterBuilder = OceanEcsCluster.Builder.get();

            if (src.isIdSet()) {
                clusterBuilder.setId(src.getId());
            }
            if (src.isNameSet()) {
                clusterBuilder.setName(src.getName());
            }
            if (src.isRegionSet()) {
                clusterBuilder.setRegion(src.getRegion());
            }
            if (src.isClusterNameSet()) {
                clusterBuilder.setClusterName(src.getClusterName());
            }
            if (src.isAutoScalerSet()) {
                clusterBuilder.setAutoScaler(toBl(src.getAutoScaler()));
            }
            if (src.isCapacitySet()) {
                clusterBuilder.setCapacity(toBl(src.getCapacity()));
            }
            if (src.isStrategySet()) {
                clusterBuilder.setStrategy(toBl(src.getStrategy()));
            }
            if (src.isComputeSet()) {
                clusterBuilder.setCompute(toBl(src.getCompute()));
            }
            if (src.isSchedulingSet()) {
                clusterBuilder.setScheduling(toBl(src.getScheduling()));
            }

            cluster = clusterBuilder.build();

            // createdAt is not taken from builder since it cannot be set when creating/updating an cluster
            /*if (src.isCreatedAtSet()) {
                cluster.setCreatedAt(src.getCreatedAt());
            }

            if (src.isUpdatedAtSet()) {
                cluster.setUpdatedAt(src.getUpdatedAt());
            }*/
        }
        return cluster;
    }

    private static ClusterAutoScalerConfiguration toBl(ApiClusterAutoScalerConfiguration apiAutoScaler) {
        ClusterAutoScalerConfiguration retVal = null;

        if (apiAutoScaler != null) {
            ClusterAutoScalerConfiguration.Builder autoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();

            if (apiAutoScaler.isAttributesSet()) {
                autoScalerBuilder.setAttributes(toBl(apiAutoScaler.getAttribute()));
            }
            if (apiAutoScaler.isIsEnabledSet()) {
                autoScalerBuilder.setIsEnabled(apiAutoScaler.getIsEnabled());
            }
            if (apiAutoScaler.isCooldownSet()) {
                autoScalerBuilder.setCooldown(apiAutoScaler.getCooldown());
            }
            if (apiAutoScaler.isResourceLimitsSet()) {
                autoScalerBuilder.setResourceLimits(toBl(apiAutoScaler.getResourceLimits()));
            }
            if (apiAutoScaler.isDownSet()) {
                autoScalerBuilder.setDown(toBl(apiAutoScaler.getDown()));
            }
            if (apiAutoScaler.isHeadroomSet()) {
                autoScalerBuilder.setHeadroom(toBl(apiAutoScaler.getHeadroom()));
            }
            if (apiAutoScaler.isIsAutoConfigSet()) {
                autoScalerBuilder.setIsAutoConfig(apiAutoScaler.getIsAutoConfig());
            }
            if (apiAutoScaler.isAutoHeadroomPercentageSet()) {
                autoScalerBuilder.setAutoHeadroomPercentage(apiAutoScaler.getAutoHeadroomPercentage());
            }
            if(apiAutoScaler.isShouldScaleDownNonServiceTasksSet()){
                autoScalerBuilder.setShouldScaleDownNonServiceTasks(apiAutoScaler.getshouldScaleDownNonServiceTasks());
            }
            if(apiAutoScaler.isEnableAutomaticAndManualHeadroomSet()){
                autoScalerBuilder.setEnableAutomaticAndManualHeadroom(apiAutoScaler.getenableAutomaticAndManualHeadroom());
            }
            retVal = autoScalerBuilder.build();
        }

        return retVal;
    }

    private static ClusterResourceLimitsSpecification toBl(ApiClusterResourceLimitsSpecification apiResourceLimitsSpecification) {
        ClusterResourceLimitsSpecification retVal = null;

        if (apiResourceLimitsSpecification != null) {
            ClusterResourceLimitsSpecification.Builder apiResourceLimitsBuilder =
                    ClusterResourceLimitsSpecification.Builder.get();

            if (apiResourceLimitsSpecification.isMaxMemoryGibSet()) {
                apiResourceLimitsBuilder.setMaxMemoryGib(apiResourceLimitsSpecification.getMaxMemoryGib());
            }
            if (apiResourceLimitsSpecification.isMaxVCpuSet()) {
                apiResourceLimitsBuilder.setMaxVCpu(apiResourceLimitsSpecification.getMaxVCpu());
            }

            retVal = apiResourceLimitsBuilder.build();
        }
        return retVal;

    }

    private static ClusterDownSpecification toBl(ApiClusterDownSpecification apidown) {
        ClusterDownSpecification retVal = null;

        if (apidown != null) {
            ClusterDownSpecification.Builder downBuilder = ClusterDownSpecification.Builder.get();

            if (apidown.isMaxScaleDownPercentageSet()) {
                downBuilder.setMaxScaleDownPercentage(apidown.getMaxScaleDownPercentage());
            }
            if (apidown.isEvaluationPeriodSet()) {
                downBuilder.setEvaluationPeriods(apidown.getEvaluationPeriods());
            }
            retVal = downBuilder.build();
        }
        return retVal;
    }

    private static ClusterSchedulingConfiguration toBl(ApiClusterSchedulingConfiguration apiScheduling) {
        ClusterSchedulingConfiguration retVal = null;

        if (apiScheduling != null) {
            ClusterSchedulingConfiguration.Builder schedulingConfigurationBuilder =
                    ClusterSchedulingConfiguration.Builder.get();
            if (apiScheduling.isTasksSet()) {
                if (apiScheduling.getTasks() != null) {
                    List<ClusterTasksConfiguration> tasksConfigurationList =
                            apiScheduling.getTasks().stream().map(OceanEcsConverter::toBl).collect(Collectors.toList());
                    schedulingConfigurationBuilder.setTasks(tasksConfigurationList);
                }
            }
            if(apiScheduling.isShutdownHoursSet()){
                schedulingConfigurationBuilder.setShutdownHours(toBl(apiScheduling.getShutdownHours()));
            }
            retVal = schedulingConfigurationBuilder.build();
        }
        return retVal;
    }

    private static ClusterShutdownHoursSpecification toBl(ApiClusterShutdownHoursSpecification apiClusterShutdownHoursSpecification) {
        ClusterShutdownHoursSpecification retVal = null;

        if (apiClusterShutdownHoursSpecification != null) {
            ClusterShutdownHoursSpecification.Builder apiShutdownHoursBuilder =
                    ClusterShutdownHoursSpecification.Builder.get();

            if (apiClusterShutdownHoursSpecification.isIsEnabledSet()) {
                apiShutdownHoursBuilder.setEnabled(apiClusterShutdownHoursSpecification.getIsEnabled());
            }
            if (apiClusterShutdownHoursSpecification.isTimeWindowsSet()) {
                apiShutdownHoursBuilder.setTimeWindows(apiClusterShutdownHoursSpecification.getTimeWindows());
            }

            retVal = apiShutdownHoursBuilder.build();
        }
        return retVal;

    }


    private static ClusterTasksConfiguration toBl(ApiClusterTasksConfiguration apiScheduledTask) {
        ClusterTasksConfiguration bLTasks = null;

        if (apiScheduledTask != null) {
            ClusterTasksConfiguration.Builder tasksBuilder = ClusterTasksConfiguration.Builder.get();
            if (apiScheduledTask.isIsEnabledSet()) {
                tasksBuilder.setIsEnabled(apiScheduledTask.getIsEnabled());
            }
            if (apiScheduledTask.isCronExpressionSet()) {
                tasksBuilder.setCronExpression(apiScheduledTask.getCronExpression());
            }
            if (apiScheduledTask.isTaskTypeSet()) {
                tasksBuilder.setTaskType(apiScheduledTask.getTaskType());
            }
            bLTasks = tasksBuilder.build();
        }

        return bLTasks;
    }

    private static ClusterComputeConfiguration toBl(ApiClusterComputeConfiguration apicompute) {
        ClusterComputeConfiguration retVal = null;

        if (apicompute != null) {
            ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();

            if (apicompute.isSubnetIdsSet()) {
                computeBuilder.setSubnetIds(apicompute.getSubnetIds());
            }
            if (apicompute.isLaunchSpecificationSet()) {
                computeBuilder.setLaunchSpecification(toBl(apicompute.getLaunchSpecification()));
            }
            if (apicompute.isOptimizeImagesSet()) {
                computeBuilder.setOptimizeImages(toBl(apicompute.getOptimizeImages()));
            }
            retVal = computeBuilder.build();
        }

        return retVal;
    }

    private static ClusterOptimizeImageConfiguration toBl(ApiClusterOptimizeImageConfiguration apiOptimizeImage) {
        ClusterOptimizeImageConfiguration retVal = null;

        if(apiOptimizeImage != null) {
            ClusterOptimizeImageConfiguration.Builder optimizeImage = ClusterOptimizeImageConfiguration.Builder.get();
            if(apiOptimizeImage.isPerformAtSet()){
                optimizeImage.setPerformAt(apiOptimizeImage.getPerformAt());
            }
            if(apiOptimizeImage.isShouldOptimizeEcsAmiSet()){
                optimizeImage.setShouldOptimizeEcsAmi(apiOptimizeImage.getShouldOptimizeEcsAmi());
            }
            if(apiOptimizeImage.istimeWindowsSet()){
                optimizeImage.setTimeWindows(apiOptimizeImage.getTimeWindows());
            }
            retVal = optimizeImage.build();
        }
        return retVal;
    }

    private static ClusterStrategyConfiguration toBl(ApiClusterStrategyConfiguration apiStrategy) {
        ClusterStrategyConfiguration retVal = null;

        if (apiStrategy != null) {
            ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();

            if (apiStrategy.isDrainingTimeoutSet()) {
                strategyBuilder.setDrainingTimeout(apiStrategy.getDrainingTimeout());
            }
            if (apiStrategy.isUtilizeReservedInstancesSet()) {
                strategyBuilder.setUtilizeReservedInstances(apiStrategy.getUtilizeReservedInstances());
            }
            if (apiStrategy.isFallbackToOdSet()) {
                strategyBuilder.setFallbackToOnDemand(apiStrategy.getFallbackToOd());
            }
            if (apiStrategy.isspotPercentageSet()) {
                strategyBuilder.setspotPercentage(apiStrategy.getspotPercentage());
            }

            retVal = strategyBuilder.build();
        }

        return retVal;
    }

    private static ClusterCapacityConfiguration toBl(ApiClusterCapacityConfiguration capacity) {
        ClusterCapacityConfiguration retVal = null;

        if (capacity != null) {
            ClusterCapacityConfiguration.Builder retValBuilder = ClusterCapacityConfiguration.Builder.get();

            if (capacity.isMaximumSet()) {
                retValBuilder.setMaximum(capacity.getMaximum());
            }

            if (capacity.isMinimumSet()) {
                retValBuilder.setMinimum(capacity.getMinimum());
            }

            if (capacity.isTargetSet()) {
                retValBuilder.setTarget(capacity.getTarget());
            }
            if (capacity.isUnitSet()) {
                retValBuilder.setUnit(capacity.getUnit());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    public static ClusterLaunchSpecification toBl(ApiClusterLaunchSpecification launchSpecification) {
        ClusterLaunchSpecification retVal = null;

        if (launchSpecification != null) {
            ClusterLaunchSpecification.Builder clusterLaunchSpecBuilder = ClusterLaunchSpecification.Builder.get();

            if (launchSpecification.isIdSet()) {
                clusterLaunchSpecBuilder.setId(launchSpecification.getId());
            }
            if (launchSpecification.isImageIdSet()) {
                clusterLaunchSpecBuilder.setImageId(launchSpecification.getImageId());
            }
            if (launchSpecification.isNameSet()) {
                clusterLaunchSpecBuilder.setName(launchSpecification.getName());
            }
            if (launchSpecification.isOceanIdSet()) {
                clusterLaunchSpecBuilder.setOceanId(launchSpecification.getOceanId());
            }
            if (launchSpecification.isAttributesSet()) {
                List<ClusterAttributes> attributes =
                        launchSpecification.getAttributes().stream().map(OceanEcsConverter::toBl)
                                           .collect(Collectors.toList());
                clusterLaunchSpecBuilder.setAttributes(attributes);
            }
            if (launchSpecification.isAutoScaleSet()) {
                clusterLaunchSpecBuilder.setAutoScale(toBl(launchSpecification.getAutoScale()));
            }
            if (launchSpecification.isBlockDeviceMappingsSet()) {
                List<LaunchSpecBlockDeviceMappings> blockDeviceMappings =
                        launchSpecification.getBlockDeviceMappings().stream().map(OceanEcsConverter::toBl)
                                           .collect(Collectors.toList());
                clusterLaunchSpecBuilder.setBlockDeviceMappings(blockDeviceMappings);
            }
            if (launchSpecification.isIamInstanceProfileSet()) {
                LaunchSpecIamInstanceProfileSpecification
                        instanceProfileSpecs = toBl(launchSpecification.getIamInstanceProfile());
                clusterLaunchSpecBuilder.setIamInstanceProfile(instanceProfileSpecs);
            }
            if (launchSpecification.isInstanceMetadataOptionsSet()) {
                clusterLaunchSpecBuilder
                        .setInstanceMetadataOptions(toBl(launchSpecification.getInstanceMetadataOptions()));
            }
            if (launchSpecification.isRestrictScaleDownSet()) {
                clusterLaunchSpecBuilder.setRestrictScaleDown(launchSpecification.getRestrictScaleDown());
            }
            if (launchSpecification.isSecurityGroupIdsSet()) {
                clusterLaunchSpecBuilder.setSecurityGroupIds(launchSpecification.getSecurityGroupIds());
            }
            if (launchSpecification.isSubnetIdsSet()) {
                clusterLaunchSpecBuilder.setSubnetIds(launchSpecification.getSubnetIds());
            }
            if (launchSpecification.isTagsSet()) {
                List<LaunchSpecTagsSpecification> tags =
                        launchSpecification.getTags().stream().map(OceanEcsConverter::toBl)
                                           .collect(Collectors.toList());
                clusterLaunchSpecBuilder.setTags(tags);
            }
            if (launchSpecification.isUserDataSet()) {
                clusterLaunchSpecBuilder.setUserData(launchSpecification.getUserData());
            }
            retVal = clusterLaunchSpecBuilder.build();
        }
        return retVal;
    }

    private static ClusterAttributes toBl(ApiClusterAttributes attributes) {
        ClusterAttributes retVal = null;

        if (attributes != null) {
            ClusterAttributes.Builder attributeBuilder = ClusterAttributes.Builder.get();

            if (attributes.isKeySet() && attributes.isValueSet()) {
                attributeBuilder.setKey(attributes.getKey());
                attributeBuilder.setValue(attributes.getValue());
            }
            retVal = attributeBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecAutoScaleSpecification toBl(ApiLaunchSpecAutoScaleSpecification autoScaler) {
        LaunchSpecAutoScaleSpecification retval = null;

        if (autoScaler != null) {
            LaunchSpecAutoScaleSpecification.Builder autoScaleBuilder = LaunchSpecAutoScaleSpecification.Builder.get();

            if (autoScaler.isHeadroomSet()) {
                List<ClusterHeadroomsSpecification> headrooms =
                        autoScaler.getHeadrooms().stream().map(OceanEcsConverter::toBl)
                                  .collect(Collectors.toList());
                autoScaleBuilder.setHeadrooms(headrooms);
            }
            retval = autoScaleBuilder.build();
        }
        return retval;
    }

    private static ClusterHeadroomsSpecification toBl(ApiClusterHeadroomsSpecification headroom) {
        ClusterHeadroomsSpecification retVal = null;

        if (headroom != null) {
            ClusterHeadroomsSpecification.Builder headroomBuilder = ClusterHeadroomsSpecification.Builder.get();

            if (headroom.isCpuPerUnitSet()) {
                headroomBuilder.setCpuPerUnit(headroom.getCpuPerUnit());
            }
            if (headroom.isMemoryPerUnitSet()) {
                headroomBuilder.setMemoryPerUnit(headroom.getMemoryPerUnit());
            }
            if (headroom.isNumOfUnitsSet()) {
                headroomBuilder.setNumOfUnits(headroom.getNumOfUnits());
            }
            retVal = headroomBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecBlockDeviceMappings toBl(ApiLaunchSpecBlockDeviceMappings blockDeviceMappings) {
        LaunchSpecBlockDeviceMappings retVal = null;

        if (blockDeviceMappings != null) {
            LaunchSpecBlockDeviceMappings.Builder blockDeviceMappingsBuilder = LaunchSpecBlockDeviceMappings.Builder.get();

            if (blockDeviceMappings.isDeviceNameSet()) {
                blockDeviceMappingsBuilder.setDeviceName(blockDeviceMappings.getDeviceName());
            }
            if (blockDeviceMappings.isEbsSet()) {
                blockDeviceMappingsBuilder.setEbs(toBl(blockDeviceMappings.getEbs()));
            }
            retVal = blockDeviceMappingsBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecEbsSpecification toBl(ApiLaunchSpecEbsSpecification ebs) {
        LaunchSpecEbsSpecification retVal = null;

        if (ebs != null) {
            LaunchSpecEbsSpecification.Builder ebsBuilder = LaunchSpecEbsSpecification.Builder.get();

            if (ebs.isDeleteOnTerminationSet()) {
                ebsBuilder.setDeleteOnTermination(ebs.getDeleteOnTermination());
            }
            if (ebs.isDynamicVolumeSizeSet()) {
                ebsBuilder.setDynamicVolumeSize(toBl(ebs.getDynamicVolumeSize()));
            }
            if (ebs.isEncryptedSet()) {
                ebsBuilder.setEncrypted(ebs.getEncrypted());
            }
            if (ebs.isIopsSet()) {
                ebsBuilder.setIops(ebs.getIops());
            }
            if (ebs.isKmsKeyIdSet()) {
                ebsBuilder.setKmsKeyId(ebs.getKmsKeyId());
            }
            if (ebs.isSnapshotIdSet()) {
                ebsBuilder.setSnapshotId(ebs.getSnapshotId());
            }
            if (ebs.isThroughputSet()) {
                ebsBuilder.setThroughput(ebs.getThroughput());
            }
            if (ebs.isVolumeSizeSet()) {
                ebsBuilder.setVolumeSize(ebs.getVolumeSize());
            }
            if (ebs.isVolumeTypeSet()) {
                ebsBuilder.setVolumeType(ebs.getVolumeType());
            }
            retVal = ebsBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecDynamicVolumeSize toBl(ApiLaunchSpecDynamicVolumeSize dynamicVolumeSize) {
        LaunchSpecDynamicVolumeSize retVal = null;

        if (dynamicVolumeSize != null) {
            LaunchSpecDynamicVolumeSize.Builder volumeSizeBuilder = LaunchSpecDynamicVolumeSize.Builder.get();

            if (dynamicVolumeSize.isBaseSizeSet()) {
                volumeSizeBuilder.setBaseSize(dynamicVolumeSize.getBaseSize());
            }
            if (dynamicVolumeSize.isResourceSet()) {
                volumeSizeBuilder.setResource(dynamicVolumeSize.getResource());
            }
            if (dynamicVolumeSize.isSizePerResourceUnitSet()) {
                volumeSizeBuilder.setSizePerResourceUnit(dynamicVolumeSize.getSizePerResourceUnit());
            }
            retVal = volumeSizeBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecIamInstanceProfileSpecification toBl(ApiLaunchSpecIamInstanceProfileSpecification instanceProfile) {
        LaunchSpecIamInstanceProfileSpecification retVal = null;

        if (instanceProfile != null) {
            LaunchSpecIamInstanceProfileSpecification.Builder IamInstanceProfileSpecBuilder =
                    LaunchSpecIamInstanceProfileSpecification.Builder.get();

            if (instanceProfile.isArnSet()) {
                IamInstanceProfileSpecBuilder.setArn(instanceProfile.getArn());
            }
            if (instanceProfile.isNameSet()) {
                IamInstanceProfileSpecBuilder.setName(instanceProfile.getName());
            }
            retVal = IamInstanceProfileSpecBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecInstanceMetadataOptions toBl(ApiLaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
        LaunchSpecInstanceMetadataOptions retVal = null;

        if (instanceMetadataOptions != null) {
            LaunchSpecInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder =
                    LaunchSpecInstanceMetadataOptions.Builder.get();

            if (instanceMetadataOptions.isHttpPutResponseHopLimitSet()) {
                instanceMetadataOptionsBuilder
                        .setHttpPutResponseHopLimit(instanceMetadataOptions.getHttpPutResponseHopLimit());
            }
            if (instanceMetadataOptions.isHttpTokensSet()) {
                instanceMetadataOptionsBuilder.setHttpTokens(instanceMetadataOptions.getHttpTokens());
            }
            retVal = instanceMetadataOptionsBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecTagsSpecification toBl(ApiLaunchSpecTagsSpecification tag) {
        LaunchSpecTagsSpecification retVal = null;

        if (tag != null) {
            LaunchSpecTagsSpecification.Builder tagBuilder = LaunchSpecTagsSpecification.Builder.get();

            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                tagBuilder.setTagKey(tag.getTagKey());
                tagBuilder.setTagValue(tag.getTagValue());
            }
            retVal = tagBuilder.build();
        }
        return retVal;
    }

    public static EcsInitiateRollResponseOldInstances toBl(ApiEcsInitiateRollResponseOldInstances oldInstances) {
        EcsInitiateRollResponseOldInstances retVal = null;

        if (oldInstances != null) {
            EcsInitiateRollResponseOldInstances.Builder instancesBuilder = EcsInitiateRollResponseOldInstances.Builder.get();

            if (oldInstances.isInstanceIdSet()) {
                instancesBuilder.setInstanceId(oldInstances.getInstanceId());
            }

            if (oldInstances.isStatusSet()) {
                instancesBuilder.setStatus(oldInstances.getStatus());
            }

            retVal = instancesBuilder.build();
        }

        return retVal;
    }

    public static EcsInitiateRollDetailedStatus toBl(ApiEcsInitiateRollDetailedStatus detailedStatus) {
        EcsInitiateRollDetailedStatus retVal = null;

        if (detailedStatus != null) {
            EcsInitiateRollDetailedStatus.Builder detailedStatusBuilder = EcsInitiateRollDetailedStatus.Builder.get();

            if (detailedStatus.isOldInstancesSet()) {

                List<EcsInitiateRollResponseOldInstances> instancesList =
                        detailedStatus.getOldInstances().stream().map(OceanEcsConverter::toBl)
                                .collect(Collectors.toList());
                detailedStatusBuilder.setOldInstances(instancesList);
            }

            retVal = detailedStatusBuilder.build();
        }

        return retVal;
    }

    public static EcsInitiateRollProgress toBl(ApiEcsInitiateRollProgress progress) {
        EcsInitiateRollProgress retVal = null;

        if (progress != null) {
            EcsInitiateRollProgress.Builder progressBuilder = EcsInitiateRollProgress.Builder.get();

            if (progress.isUnitSet()) {
                progressBuilder.setUnit(progress.getUnit());
            }

            if (progress.isValueSet()) {
                progressBuilder.setValue(progress.getValue());
            }

            if (progress.isDetailedStatusSet()) {
                progressBuilder.setDetailedStatus(toBl(progress.getDetailedStatus()));
            }

            retVal = progressBuilder.build();
        }

        return retVal;
    }

    public static EcsClusterRollResponse toBl(ApiEcsClusterRollResponse initiateRollResponse) {
        EcsClusterRollResponse retVal = null;

        if (initiateRollResponse != null) {
            EcsClusterRollResponse.Builder responseBuilder = EcsClusterRollResponse.Builder.get();

            if (initiateRollResponse.isIdSet()) {
                responseBuilder.setId(initiateRollResponse.getId());
            }

            if (initiateRollResponse.isStatusSet()) {
                responseBuilder.setStatus(initiateRollResponse.getStatus());
            }

            if (initiateRollResponse.isCurrentBatchSet()) {
                responseBuilder.setCurrentBatch(initiateRollResponse.getCurrentBatch());
            }

            if (initiateRollResponse.isNumOfBatchesSet()) {
                responseBuilder.setNumOfBatches(initiateRollResponse.getNumOfBatches());
            }

            if (initiateRollResponse.isCommentSet()) {
                responseBuilder.setComment(initiateRollResponse.getComment());
            }

            if (initiateRollResponse.isProgressSet()) {
                responseBuilder.setProgress(toBl(initiateRollResponse.getProgress()));
            }

            if (initiateRollResponse.isOceanIdSet()) {
                responseBuilder.setOceanId(initiateRollResponse.getOceanId());
            }

            if (initiateRollResponse.isInstanceIdsSet()) {
                responseBuilder.setInstanceIds(initiateRollResponse.getInstanceIds());
            }

            if (initiateRollResponse.isLaunchSpecIdsSet()) {
                responseBuilder.setLaunchSpecIds(initiateRollResponse.getLaunchSpecIds());
            }

            if (initiateRollResponse.isBatchMinHealthyPercentageSet()) {
                responseBuilder.setBatchMinHealthyPercentage(initiateRollResponse.getBatchMinHealthyPercentage());
            }

            if (initiateRollResponse.isCreatedAtSet()) {
                responseBuilder.setCreatedAt(initiateRollResponse.getCreatedAt());
            }

            if (initiateRollResponse.isUpdatedAtSet()) {
                responseBuilder.setUpdatedAt(initiateRollResponse.getUpdatedAt());
            }
            retVal = responseBuilder.build();
        }

        return retVal;
    }

    public static GetEcsClusterNodesResponse toBl(ApiGetEcsClusterNodesResponse apiClusterNodes) {
        GetEcsClusterNodesResponse retVal = null;

        if (apiClusterNodes != null) {
            GetEcsClusterNodesResponse.Builder instancesBuilder = GetEcsClusterNodesResponse.Builder.get();

            if (apiClusterNodes.isLifeCycleSet()) {
                instancesBuilder.setLifeCycle(apiClusterNodes.getLifeCycle());
            }

            if (apiClusterNodes.isPublicIpSet()) {
                instancesBuilder.setPublicIp(apiClusterNodes.getPublicIp());
            }

            if (apiClusterNodes.isWorkloadRequestedCpuUnitSet()) {
                instancesBuilder.setWorkloadRequestedCpuUnit(apiClusterNodes.getWorkloadRequestedCpuUnit());
            }

            if (apiClusterNodes.isWorkloadRequestedMemoryInMiBSet()) {
                instancesBuilder.setWorkloadRequestedMemoryInMiB(apiClusterNodes.getWorkloadRequestedMemoryInMiB());
            }

            if (apiClusterNodes.isWorkloadRequestedGpuSet()) {
                instancesBuilder.setWorkloadRequestedGpu(apiClusterNodes.getWorkloadRequestedGpu());
            }

            if (apiClusterNodes.isHeadroomRequestedCpuUnitSet()) {
                instancesBuilder.setHeadroomRequestedCpuUnit(apiClusterNodes.getHeadroomRequestedCpuUnit());
            }

            if (apiClusterNodes.isRegisteredCpuUnitSet()) {
                instancesBuilder.setRegisteredCpuUnit(apiClusterNodes.getRegisteredCpuUnit());
            }

            if (apiClusterNodes.isHeadroomRequestedGpuSet()) {
                instancesBuilder.setHeadroomRequestedGpu(apiClusterNodes.getHeadroomRequestedGpu());
            }

            if (apiClusterNodes.isHeadroomRequestedMemoryInMiBSet()) {
                instancesBuilder.setHeadroomRequestedMemoryInMiB(apiClusterNodes.getHeadroomRequestedMemoryInMiB());
            }

            if (apiClusterNodes.isRegisteredMemoryInMiBSet()) {
                instancesBuilder.setRegisteredMemoryInMiB(apiClusterNodes.getRegisteredMemoryInMiB());
            }

            if (apiClusterNodes.isRegisteredGpuSet()) {
                instancesBuilder.setRegisteredGpu(apiClusterNodes.getRegisteredGpu());
            }

            if (apiClusterNodes.isContainerInstanceIdSet()) {
                instancesBuilder.setContainerInstanceId(apiClusterNodes.getContainerInstanceId());
            }

            if (apiClusterNodes.isRegistrationStatusSet()) {
                instancesBuilder.setRegistrationStatus(apiClusterNodes.getRegistrationStatus());
            }

            if (apiClusterNodes.isCreatedAtSet()) {
                instancesBuilder.setCreatedAt(apiClusterNodes.getCreatedAt());
            }

            if (apiClusterNodes.isInstanceIdSet()) {
                instancesBuilder.setInstanceId(apiClusterNodes.getInstanceId());
            }

            if (apiClusterNodes.isInstanceTypeSet()) {
                instancesBuilder.setInstanceType(apiClusterNodes.getInstanceType());
            }

            if (apiClusterNodes.isAvailabilityZoneSet()) {
                instancesBuilder.setAvailabilityZone(apiClusterNodes.getAvailabilityZone());
            }

            if (apiClusterNodes.isLaunchSpecIdSet()) {
                instancesBuilder.setLaunchSpecId(apiClusterNodes.getLaunchSpecId());
            }

            if (apiClusterNodes.isLaunchSpecNameSet()) {
                instancesBuilder.setLaunchSpecName(apiClusterNodes.getLaunchSpecName());
            }

            retVal = instancesBuilder.build();
        }

        return retVal;
    }

}