package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;

import java.util.List;
import java.util.stream.Collectors;


public class OceanK8sConverter {
    //region BL -> DAL

    public static ApiOceanK8sCluster toDal(OceanK8sCluster src) {
        ApiOceanK8sCluster apiCluster = null;

        if (src != null) {
            apiCluster = new ApiOceanK8sCluster();

            if (src.isIdSet()) {
                apiCluster.setId(src.getId());
            }
            if (src.isNameSet()) {
                apiCluster.setName(src.getName());
            }
            if (src.isRegionSet()) {
                apiCluster.setRegion(src.getRegion());
            }
            if (src.isControllerClusterIdSet()) {
                apiCluster.setControllerClusterId(src.getControllerClusterId());
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
            if (src.isSecuritySet()){
                apiCluster.setSecurity(toDal(src.getSecurity()));
            }
        }

        return apiCluster;
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
        }

        return retVal;
    }

    private static ApiClusterAutoScalerConfiguration toDal(ClusterAutoScalerConfiguration autoScaler) {
        ApiClusterAutoScalerConfiguration retval = null;

        if (autoScaler != null) {
            retval = new ApiClusterAutoScalerConfiguration();

            if (autoScaler.isIsEnabledSet()) {
                retval.setIsEnabled(autoScaler.getIsEnabled());
            }
            if (autoScaler.isCooldownSet()) {
                retval.setCooldown(autoScaler.getCooldown());
            }
            if (autoScaler.isResourceLimits()) {
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
                retval.setAutoHeadroomPercentage(autoScaler.getAutoHeadroomPrecentage());
            }
        }

        return retval;
    }

    private static ApiClusterResourceLimitsSpecification toDal(
            ClusterResourceLimitsSpecification resourceLimitsSpecification) {
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

    private static ApiClusterHeadroomSpecification toDal(ClusterHeadroomSpecification headroom) {
        ApiClusterHeadroomSpecification retVal = null;

        if (headroom != null) {
            retVal = new ApiClusterHeadroomSpecification();

            if (headroom.isCpuPerUnitSet()) {
                retVal.setCpuPerUnit(headroom.getCpuPerUnit());
            }
            if (headroom.isGpuPerUnitSet()) {
                retVal.setGpuPerUnit(headroom.getGpuPerUnit());
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

    private static ApiClusterDownSpecification toDal(ClusterDownSpecification down) {
        ApiClusterDownSpecification retVal = null;

        if (down != null) {
            retVal = new ApiClusterDownSpecification();

            if (down.isMaxScaleDownPercentageSet()) {
                retVal.setMaxScaleDownPercentage(down.getMaxScaleDownPercentage());
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
                    List<ApiClusterTasksSpecification> taskList =
                            scheduling.getTasks().stream().map(OceanK8sConverter::toDal).collect(Collectors.toList());
                    retVal.setTasks(taskList);
                }
                if (scheduling.isShutdownHoursSet()) {
                    if (scheduling.getShutdownHours() != null) {
                        retVal.setShutdownHours(toDal(scheduling.getShutdownHours()));
                    }
                }
            }
        }

        return retVal;
    }

    private static ApiClusterTasksSpecification toDal(ClusterTasksSpecification tasksSpecification) {
        ApiClusterTasksSpecification retVal = null;

        if (tasksSpecification != null) {
            retVal = new ApiClusterTasksSpecification();

            if (tasksSpecification.isIsEnabledSet()) {
                retVal.setIsEnabled(tasksSpecification.getIsEnabled());
            }
            if (tasksSpecification.isCronExpressionSet()) {
                retVal.setCronExpression(tasksSpecification.getCronExpression());
            }
            if (tasksSpecification.isTaskTypeSet()) {
                retVal.setTaskType(tasksSpecification.getTaskType());
            }
        }

        return retVal;
    }

    private static ApiClusterShutdownHoursSpecification toDal(
            ClusterShutdownHoursSpecification shutdownHoursSpecification) {
        ApiClusterShutdownHoursSpecification retVal = null;

        if (shutdownHoursSpecification != null) {
            retVal = new ApiClusterShutdownHoursSpecification();

            if (shutdownHoursSpecification.isIsEnabledSet()) {
                retVal.setIsEnabled(shutdownHoursSpecification.getIsEnabled());
            }
            if (shutdownHoursSpecification.istimeWindowsSet()) {
                retVal.setTimeWindows(shutdownHoursSpecification.getTimeWindows());
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
            if (compute.isInstanceTypesSet()) {
                retVal.setInstanceTypes(toDal(compute.getInstanceTypes()));
            }
            if (compute.isLaunchSpecificationSet()) {
                retVal.setLaunchSpecification(toDal(compute.getLaunchSpecification()));
            }
        }

        return retVal;
    }

    private static ApiClusterInstanceTypes toDal(ClusterInstanceTypes instanceTypes) {
        ApiClusterInstanceTypes retVal = null;

        if (instanceTypes != null) {
            retVal = new ApiClusterInstanceTypes();

            if (instanceTypes.isBlacklistSet()) {
                retVal.setBlacklist(instanceTypes.getBlacklist());
            }
            if (instanceTypes.isWhitelistSet()) {
                retVal.setWhitelist(instanceTypes.getWhitelist());
            }
        }

        return retVal;
    }

    private static ApiClusterLaunchSpecification toDal(ClusterLaunchSpecification launchSpecification) {
        ApiClusterLaunchSpecification retVal = null;

        if (launchSpecification != null) {
            retVal = new ApiClusterLaunchSpecification();

            if (launchSpecification.isImageIdSet()) {
                retVal.setImageId(launchSpecification.getImageId());
            }
            if (launchSpecification.isUserDataSet()) {
                retVal.setUserData(launchSpecification.getUserData());
            }
            if (launchSpecification.isSecurityGroupIdsSet()) {
                retVal.setSecurityGroupIds(launchSpecification.getSecurityGroupIds());
            }
            if (launchSpecification.isIamInstanceProfileSet()) {
                retVal.setIamInstanceProfile(toDal(launchSpecification.getIamInstanceProfile()));
            }
            if (launchSpecification.isKeyPairSet()) {
                retVal.setKeyPair(launchSpecification.getKeyPair());
            }
            if (launchSpecification.isTagsSet()) {
                if (launchSpecification.getTags() != null) {
                    List<ApiTag> tagList = launchSpecification.getTags().stream().map(OceanK8sConverter::toDal)
                                                              .collect(Collectors.toList());
                    retVal.setTags(tagList);
                }
            }
            if (launchSpecification.isAssociatePublicIpAddressSet()) {
                retVal.setAssociatePublicIpAddress(launchSpecification.getAssociatePublicIpAddress());
            }
            if (launchSpecification.isMonitoringSet()) {
                retVal.setMonitoring(launchSpecification.getMonitoring());
            }
            if (launchSpecification.isEbsOptimizedSet()) {
                retVal.setEbsOptimized(launchSpecification.getEbsOptimized());
            }
            if (launchSpecification.isRootVolumeSizeSet()) {
                retVal.setRootVolumeSize(launchSpecification.getRootVolumeSize());
            }
        }

        return retVal;
    }

    private static ApiTag toDal(Tag tag) {
        ApiTag retVal = null;

        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                retVal = new ApiTag(tag.getTagKey(), tag.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiClusterIamInstanceProfileSpec toDal(ClusterIamInstanceProfileSpec iamInstanceProfileSpec) {
        ApiClusterIamInstanceProfileSpec retVal = null;

        if (iamInstanceProfileSpec != null) {
            retVal = new ApiClusterIamInstanceProfileSpec();

            if (iamInstanceProfileSpec.isArnSet()) {
                retVal.setArn(iamInstanceProfileSpec.getArn());
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
            if (strategy.isGracePeriodSet()) {
                retVal.setGracePeriod(strategy.getGracePeriod());
            }
            if (strategy.isUtilizeReservedInstancesSet()) {
                retVal.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }
        }

        return retVal;
    }

    private static ApiClusterSecurityConfiguration toDal(ClusterSecurityConfiguration security) {
        ApiClusterSecurityConfiguration retVal = null;

        if (security != null) {
            retVal = new ApiClusterSecurityConfiguration();

            if (security.isContainerimageSet()) {
                retVal.setContainerImage(toDal(security.getContainerImage()));
            }
        }

        return retVal;
    }

    private static ApiClusterContainerImageSpecification toDal(ClusterContainerImageSpecification containerImage) {
        ApiClusterContainerImageSpecification retVal = null;

        if (containerImage != null) {
            retVal = new ApiClusterContainerImageSpecification();

            if (containerImage.isApprovedImagesSet()) {
                retVal.setApprovedImages(containerImage.getApprovedImages());
            }
        }

        return retVal;
    }

    //endregion

    //region DAL -> BL
    public static OceanK8sCluster toBl(ApiOceanK8sCluster src) {
        OceanK8sCluster cluster = null;

        if (src != null) {
            OceanK8sCluster.Builder clusterBuilder = OceanK8sCluster.Builder.get();

            if (src.isIdSet()) {
                clusterBuilder.setId(src.getId());
            }
            if (src.isNameSet()) {
                clusterBuilder.setName(src.getName());
            }
            if (src.isControllerClusterIdSet()) {
                clusterBuilder.setControllerClusterId(src.getControllerClusterId());
            }
            if (src.isRegionSet()) {
                clusterBuilder.setRegion(src.getRegion());
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
            if (src.isSecuritySet()){
                clusterBuilder.setSecurity(toBl(src.getSecurity()));
            }

            cluster = clusterBuilder.build();

            // createdAt is not taken from builder since it cannot be set when creating/updating an cluster
            if (src.isCreatedAtSet()) {
                cluster.setCreatedAt(src.getCreatedAt());
            }

            if (src.isUpdatedAtSet()) {
                cluster.setUpdatedAt(src.getUpdatedAt());
            }
        }
        return cluster;
    }

    private static ClusterAutoScalerConfiguration toBl(ApiClusterAutoScalerConfiguration apiAutoScaler) {
        ClusterAutoScalerConfiguration retVal = null;

        if (apiAutoScaler != null) {
            ClusterAutoScalerConfiguration.Builder autoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();

            if (apiAutoScaler.isIsEnabledSet()) {
                autoScalerBuilder.setIsEnabled(apiAutoScaler.getIsEnabled());
            }
            if (apiAutoScaler.isCooldownSet()) {
                autoScalerBuilder.setCooldown(apiAutoScaler.getCooldown());
            }
            if (apiAutoScaler.isResourceLimits()) {
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
                autoScalerBuilder.setAutoHeadroomPercentage(apiAutoScaler.getAutoHeadroomPrecentage());
            }

            retVal = autoScalerBuilder.build();
        }

        return retVal;
    }

    private static ClusterResourceLimitsSpecification toBl(
            ApiClusterResourceLimitsSpecification apiResourceLimitsSpecification) {
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

    private static ClusterHeadroomSpecification toBl(ApiClusterHeadroomSpecification headroom) {
        ClusterHeadroomSpecification retVal = null;

        if (headroom != null) {
            ClusterHeadroomSpecification.Builder headroomBuilder = ClusterHeadroomSpecification.Builder.get();

            if (headroom.isCpuPerUnitSet()) {
                headroomBuilder.setCpuPerUnit(headroom.getCpuPerUnit());
            }
            if (headroom.isGpuPerUnitSet()) {
                headroomBuilder.setGpuPerUnit(headroom.getGpuPerUnit());
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

    private static ClusterDownSpecification toBl(ApiClusterDownSpecification apidown) {
        ClusterDownSpecification retVal = null;

        if (apidown != null) {
            ClusterDownSpecification.Builder downBuilder = ClusterDownSpecification.Builder.get();

            if (apidown.isMaxScaleDownPercentageSet()) {
                downBuilder.setMaxScaleDownPercentage(apidown.getMaxScaleDownPercentage());
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
                    List<ClusterTasksSpecification> tasksConfigurationList =
                            apiScheduling.getTasks().stream().map(OceanK8sConverter::toBl).collect(Collectors.toList());
                    schedulingConfigurationBuilder.setTasks(tasksConfigurationList);
                }
            }
            if (apiScheduling.isShutdownHoursSet()){
                schedulingConfigurationBuilder.setShutdownHours(toBl(apiScheduling.getShutdownHours()));
            }
            retVal = schedulingConfigurationBuilder.build();
        }
        return retVal;
    }

    private static ClusterTasksSpecification toBl(ApiClusterTasksSpecification apiScheduledTask) {
        ClusterTasksSpecification bLTasks = null;

        if (apiScheduledTask != null) {
            ClusterTasksSpecification.Builder tasksBuilder = ClusterTasksSpecification.Builder.get();
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

    private static ClusterShutdownHoursSpecification toBl(
            ApiClusterShutdownHoursSpecification apiShutdownHoursSpecification) {
        ClusterShutdownHoursSpecification retVal = null;

        if (apiShutdownHoursSpecification != null) {
            ClusterShutdownHoursSpecification.Builder shutDownBuilder = ClusterShutdownHoursSpecification.Builder.get();
            if (apiShutdownHoursSpecification.isIsEnabledSet()) {
                shutDownBuilder.setEnabled(apiShutdownHoursSpecification.getIsEnabled());
            }
            if (apiShutdownHoursSpecification.isTimeWindowsSet()) {
                shutDownBuilder.setTimeWindows(apiShutdownHoursSpecification.getTimeWindows());
            }

            retVal = shutDownBuilder.build();
        }

        return retVal;
    }

    private static ClusterComputeConfiguration toBl(ApiClusterComputeConfiguration apicompute) {
        ClusterComputeConfiguration retVal = null;

        if (apicompute != null) {
            ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();

            if (apicompute.isInstanceTypesSet()) {
                computeBuilder.setInstanceTypes(toBl(apicompute.getInstanceTypes()));
            }
            if (apicompute.isSubnetIdsSet()) {
                computeBuilder.setSubnetIds(apicompute.getSubnetIds());
            }
            if (apicompute.isLaunchSpecificationSet()) {
                computeBuilder.setLaunchSpecification(toBl(apicompute.getLaunchSpecification()));
            }

            retVal = computeBuilder.build();
        }

        return retVal;
    }

    private static ClusterLaunchSpecification toBl(ApiClusterLaunchSpecification apilaunchSpecification) {
        ClusterLaunchSpecification retVal = null;

        if (apilaunchSpecification != null) {

            ClusterLaunchSpecification.Builder launchSpecBuilder = ClusterLaunchSpecification.Builder.get();

            if (apilaunchSpecification.isImageIdSet()) {
                launchSpecBuilder.setImageId(apilaunchSpecification.getImageId());
            }
            if (apilaunchSpecification.isUserDataSet()) {
                launchSpecBuilder.setUserData(apilaunchSpecification.getUserData());
            }
            if (apilaunchSpecification.isSecurityGroupIdsSet()) {
                launchSpecBuilder.setSecurityGroupIds(apilaunchSpecification.getSecurityGroupIds());
            }
            if (apilaunchSpecification.isIamInstanceProfileSet()) {
                launchSpecBuilder.setIamInstanceProfile(toBl(apilaunchSpecification.getIamInstanceProfile()));
            }
            if (apilaunchSpecification.isKeyPairSet()) {
                launchSpecBuilder.setKeyPair(apilaunchSpecification.getKeyPair());
            }
            if (apilaunchSpecification.isTagsSet()) {
                if (apilaunchSpecification.getTags() != null) {
                    List<Tag> tags = apilaunchSpecification.getTags().stream().map(OceanK8sConverter::toBl)
                                                           .collect(Collectors.toList());
                    launchSpecBuilder.setTags(tags);
                }
            }
            if (apilaunchSpecification.isAssociatePublicIpAddressSet()) {
                launchSpecBuilder.setAssociatePublicIpAddress(apilaunchSpecification.getAssociatePublicIpAddress());
            }
            if (apilaunchSpecification.isMonitoringSet()) {
                launchSpecBuilder.setMonitoring(apilaunchSpecification.getMonitoring());
            }
            if (apilaunchSpecification.isEbsOptimizedSet()) {
                launchSpecBuilder.setEbsOptimized(apilaunchSpecification.getEbsOptimized());
            }
            if (apilaunchSpecification.isRootVolumeSizeSet()) {
                launchSpecBuilder.setRootVolumeSize(apilaunchSpecification.getRootVolumeSize());
            }

            retVal = launchSpecBuilder.build();
        }

        return retVal;
    }

    private static Tag toBl(ApiTag tag) {
        Tag retVal = null;

        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                Tag.Builder tagBuilder = Tag.Builder.get();
                retVal = tagBuilder.setTagKey(tag.getTagKey()).setTagValue(tag.getTagValue()).build();
            }
        }

        return retVal;
    }

    private static ClusterIamInstanceProfileSpec toBl(ApiClusterIamInstanceProfileSpec apiIamInstanceProfileSpec) {
        ClusterIamInstanceProfileSpec retVal = null;

        if (apiIamInstanceProfileSpec != null) {
            ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder =
                    ClusterIamInstanceProfileSpec.Builder.get();

            if (apiIamInstanceProfileSpec.isArnSet()) {
                iamInstanceProfileBuilder.setArn(apiIamInstanceProfileSpec.getArn());
            }
            retVal = iamInstanceProfileBuilder.build();
        }

        return retVal;
    }

    private static ClusterInstanceTypes toBl(ApiClusterInstanceTypes apiInstanceTypes) {
        ClusterInstanceTypes retVal = null;

        if (apiInstanceTypes != null) {
            ClusterInstanceTypes.Builder instanceTypesBuilder = ClusterInstanceTypes.Builder.get();

            if (apiInstanceTypes.isBlacklistSet()) {
                apiInstanceTypes.setBlacklist(apiInstanceTypes.getBlacklist());
            }
            if (apiInstanceTypes.isWhitelistSet()) {
                apiInstanceTypes.setWhitelist(apiInstanceTypes.getWhitelist());
            }

            retVal = instanceTypesBuilder.build();
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
            if (apiStrategy.isGracePeriodSet()) {
                strategyBuilder.setGracePeriod(apiStrategy.getGracePeriod());
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

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ClusterSecurityConfiguration toBl(ApiClusterSecurityConfiguration security) {
        ClusterSecurityConfiguration retVal = null;

        if (security != null) {
            ClusterSecurityConfiguration.Builder retValBuilder = ClusterSecurityConfiguration.Builder.get();

            if (security.isContainerimageSet()) {
                retValBuilder.setContainerImage(toBl(security.getContainerImage()));
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ClusterContainerImageSpecification toBl(ApiClusterContainerImageSpecification containerImage) {
        ClusterContainerImageSpecification retVal = null;

        if (containerImage != null) {
            ClusterContainerImageSpecification.Builder retValBuilder = ClusterContainerImageSpecification.Builder.get();

            if (containerImage.isApprovedImagesSet()) {
                retValBuilder.setApprovedImages(containerImage.getApprovedImages());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }


    //endregion
}
