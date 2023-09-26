package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsCpuCreditsEnum;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsInstanceMetadataTagsEnum;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsTerminationPolicyEnum;
import com.spotinst.sdkjava.model.api.elastigroup.aws.*;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;
import com.spotinst.sdkjava.model.responses.elastigroup.aws.CodeDeployBGDeploymentResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sniramsalem
 * @since: 06/12/2016
 */
public class ElastigroupConverter {
    //region BL -> DAL
    public static ApiElastigroup toDal(Elastigroup src) {
        ApiElastigroup apiGroup = null;

        if (src != null) {
            apiGroup = new ApiElastigroup();

            if (src.isNameSet()) {
                apiGroup.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                apiGroup.setDescription(src.getDescription());
            }
            if (src.isRegionSet()){
                apiGroup.setRegion(src.getRegion());
            }
            if (src.isScalingSet()) {
                apiGroup.setScaling(toDal(src.getScaling()));
            }
            if (src.isCapacitySet()) {
                apiGroup.setCapacity(toDal(src.getCapacity()));
            }
            if (src.isStrategySet()) {
                apiGroup.setStrategy(toDal(src.getStrategy()));
            }
            if (src.isComputeSet()) {
                apiGroup.setCompute(toDal(src.getCompute()));
            }
            if (src.isThirdPartiesIntegrationSet()) {
                ApiThirdPartiesIntegration apiThirdPartiesIntegration = toDal(src.getThirdPartiesIntegration());
                apiGroup.setThirdPartiesIntegration(apiThirdPartiesIntegration);
            }
            if (src.isSchedulingSet()) {
                apiGroup.setScheduling(toDal(src.getScheduling()));
            }
        }

        return apiGroup;
    }

    private static ApiElastigroupScheduling toDal(ElastigroupSchedulingConfiguration schedulingConfiguration) {
        ApiElastigroupScheduling retVal = null;
        if (schedulingConfiguration != null) {
            retVal = new ApiElastigroupScheduling();
            if (schedulingConfiguration.isTasksSet()) {
                if (schedulingConfiguration.getTasks() != null) {
                    List<ApiElastigroupScheduledTask> taskList =
                            schedulingConfiguration.getTasks().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setTasks(taskList);
                }
            }
        }
        return retVal;
    }

    private static ApiElastigroupScheduledTask toDal(TasksConfiguration tasksConfiguration) {
        ApiElastigroupScheduledTask retVal = null;
        if (tasksConfiguration != null) {
            retVal = new ApiElastigroupScheduledTask();
            if (tasksConfiguration.isIsEnabledSet()) {
                retVal.setIsEnabled(tasksConfiguration.getIsEnabled());
            }
            if (tasksConfiguration.isFrequencySet() && tasksConfiguration.getFrequency() != null) {
                retVal.setFrequency(tasksConfiguration.getFrequency().getName());
            }
            if (tasksConfiguration.isStartTimeSet()) {
                retVal.setStartTime(tasksConfiguration.getStartTime());
            }
            if (tasksConfiguration.isCronExpressionSet()) {
                retVal.setCronExpression(tasksConfiguration.getCronExpression());
            }
            if (tasksConfiguration.isTaskTypeSet() && tasksConfiguration.getTaskType() != null) {
                retVal.setTaskType(tasksConfiguration.getTaskType().getName());
            }
            if (tasksConfiguration.isScaleTargetCapacitySet()) {
                retVal.setScaleTargetCapacity(tasksConfiguration.getScaleTargetCapacity());
            }
            if (tasksConfiguration.isScaleMinCapacitySet()) {
                retVal.setScaleMinCapacity(tasksConfiguration.getScaleMinCapacity());
            }
            if (tasksConfiguration.isScaleMaxCapacitySet()) {
                retVal.setScaleMaxCapacity(tasksConfiguration.getScaleMaxCapacity());
            }
            if (tasksConfiguration.isBatchSizePercentageSet()) {
                retVal.setBatchSizePercentage(tasksConfiguration.getBatchSizePercentage());
            }
            if (tasksConfiguration.isgracePeriodSet()) {
                retVal.setGracePeriod(tasksConfiguration.getGracePeriod());
            }
            if (tasksConfiguration.isAdjustmentSet()) {
                retVal.setAdjustment(tasksConfiguration.getAdjustment());
            }
            if (tasksConfiguration.isAdjustmentPercentageSet()) {
                retVal.setAdjustmentPercentage(tasksConfiguration.getAdjustmentPercentage());
            }
            if (tasksConfiguration.isTargetCapacitySet()) {
                retVal.setTargetCapacity(tasksConfiguration.getTargetCapacity());
            }
            if (tasksConfiguration.isMinCapacitySet()) {
                retVal.setMinCapacity(tasksConfiguration.getMinCapacity());
            }
            if (tasksConfiguration.isMaxCapacitySet()) {
                retVal.setMaxCapacity(tasksConfiguration.getMaxCapacity());
            }
        }

        return retVal;
    }

    private static ApiThirdPartiesIntegration toDal(
            ElastigroupThirdPartiesIntegrationConfiguration thirdPartiesIntegration) {
        ApiThirdPartiesIntegration retVal = null;

        if (thirdPartiesIntegration != null) {
            retVal = new ApiThirdPartiesIntegration();
            if (thirdPartiesIntegration.isEcsSet()) {
                retVal.setEcs(toDal(thirdPartiesIntegration.getEcs()));
            }

            if (thirdPartiesIntegration.isCodeDeploySet()) {
                retVal.setCodeDeploy(toDal(thirdPartiesIntegration.getCodeDeploy()));
            }

            if (thirdPartiesIntegration.isElasticBeanstalkSet()) {
                retVal.setElasticBeanstalk(toDal(thirdPartiesIntegration.getElasticBeanstalk()));
            }
        }

        return retVal;
    }

    private static ApiCodeDeploy toDal(ElastigroupCodeDeploy codeDeploy) {
        ApiCodeDeploy retVal = null;

        if (codeDeploy != null) {
            retVal = new ApiCodeDeploy();

            if (codeDeploy.isCleanUpOnFailureSet()) {
                retVal.setCleanUpOnFailure(codeDeploy.getCleanUpOnFailure());
            }

            if (codeDeploy.isTerminateInstanceOnFailureSet()) {
                retVal.setTerminateInstanceOnFailure(codeDeploy.getTerminateInstanceOnFailure());
            }

            if (codeDeploy.isDeploymentGroupsSet()) {
                if (codeDeploy.getDeploymentGroups() != null) {
                    List<ApiDeploymentGroup> deploymentGroups =
                            codeDeploy.getDeploymentGroups().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                    retVal.setDeploymentGroups(deploymentGroups);
                }
            }
        }

        return retVal;

    }

    private static ApiElasticBeanstalk toDal(ElasticBeanstalk beanstalk) {
        ApiElasticBeanstalk retVal = null;

        if (beanstalk != null) {
            retVal = new ApiElasticBeanstalk();
            if (beanstalk.isEnvironmentIdSet()) {
                retVal.setEnvironmentId(beanstalk.getEnvironmentId());
            }
            if (beanstalk.isDeploymentPreferencesSet()) {
                if (beanstalk.getDeploymentPreferences() != null) {
                    retVal.setDeploymentPreferences(toDal(beanstalk.getDeploymentPreferences()));
                }
            }
            if (beanstalk.isManagedActionsSet()) {
                if (beanstalk.getManagedActions() != null) {
                    retVal.setManagedActions(toDal(beanstalk.getManagedActions()));
                }
            }
        }
        return retVal;
    }

    private static ApiElastigroupDeploymentPreferences toDal(ElastigroupDeploymentPreferences deploymentPreferences) {
        ApiElastigroupDeploymentPreferences retVal = null;

        if (deploymentPreferences != null) {
            retVal = new ApiElastigroupDeploymentPreferences();
            if (deploymentPreferences.isAutomaticRollSet()) {
                retVal.setAutomaticRoll(deploymentPreferences.getAutomaticRoll());
            }
            if (deploymentPreferences.isBatchSizePercentageSet()) {
                retVal.setBatchSizePercentage(deploymentPreferences.getBatchSizePercentage());
            }
            if (deploymentPreferences.isGracePeriodSet()) {
                retVal.setGracePeriod(deploymentPreferences.getGracePeriod());
            }
            if (deploymentPreferences.isStrategySet()) {
                if (deploymentPreferences.getStrategy() != null) {
                    retVal.setStrategy(toDal(deploymentPreferences.getStrategy()));
                }
            }
        }
        return retVal;
    }

    private static ApiBeanstalkStrategy toDal(BeanstalkStrategy strategy) {
        ApiBeanstalkStrategy retVal = null;

        if (strategy != null) {
            retVal = new ApiBeanstalkStrategy();
            if (strategy.isActionSet()) {
                retVal.setAction(strategy.getAction());
            }
            if (strategy.isShouldDrainInstancesSet()) {
                retVal.setShouldDrainInstances(strategy.getShouldDrainInstances());
            }
        }
        return retVal;
    }

    private static ApiManagedActions toDal(ManagedActions managedActions) {
        ApiManagedActions retVal = null;

        if (managedActions != null) {
            retVal = new ApiManagedActions();
            if (managedActions.isPlatformUpdateSet()) {
                if (managedActions.getPlatformUpdate() != null) {
                    retVal.setPlatformUpdate(toDal(managedActions.getPlatformUpdate()));
                }
            }
        }
        return retVal;
    }

    private static ApiBeanstalkPlatformUpdate toDal(BeanstalkPlatformUpdate platformUpdate) {
        ApiBeanstalkPlatformUpdate retVal = null;

        if (platformUpdate != null) {
            retVal = new ApiBeanstalkPlatformUpdate();
            if (platformUpdate.isInstanceRefreshEnabledSet()) {
                retVal.setInstanceRefreshEnabled(platformUpdate.getInstanceRefreshEnabled());
            }
            if (platformUpdate.isPerformAtSet()) {
                retVal.setPerformAt(platformUpdate.getPerformAt());
            }
            if (platformUpdate.isTimeWindowSet()) {
                retVal.setTimeWindow(platformUpdate.getTimeWindow());
            }
            if (platformUpdate.isUpdateLevelSet()) {
                retVal.setUpdateLevel(platformUpdate.getUpdateLevel());
            }
        }
        return retVal;
    }

    private static ApiDeploymentGroup toDal(ElastigroupDeploymentGroup deploymentGroups) {
        ApiDeploymentGroup retVal = null;

        if (deploymentGroups != null) {
            retVal = new ApiDeploymentGroup();

            if (deploymentGroups.isApplicationNameSet()) {
                retVal.setApplicationName(deploymentGroups.getApplicationName());
            }

            if (deploymentGroups.isDeploymentGroupNameSet()) {
                retVal.setDeploymentGroupName(deploymentGroups.getDeploymentGroupName());
            }

        }

        return retVal;

    }

    private static ApiEcs toDal(ElastigroupEcsSpecification ecs) {
        ApiEcs retVal = null;
        if (ecs != null) {
            retVal = new ApiEcs();
            if (ecs.isAutoScaleSet()) {
                retVal.setAutoScale(toDal(ecs.getAutoScale()));
            }
            if (ecs.isClusterNameSet()) {
                retVal.setClusterName(ecs.getClusterName());
            }
            if (ecs.isOptimizeImagesSet()) {
                retVal.setOptimizeImages(toDal(ecs.getOptimizeImages()));
            }
            if (ecs.isBatchSet()) {
                retVal.setBatch(toDal(ecs.getBatch()));
            }
        }
        return retVal;

    }

    private static ApiBatch toDal(ElastigroupEcsBatch ecsBatch) {
        ApiBatch retVal = null;
        if (ecsBatch != null) {
            retVal = new ApiBatch();
            if (ecsBatch.isJobQueueNamesSet()) {
                if (ecsBatch.getJobQueueNames() != null) {
                    retVal.setJobQueueNames(new LinkedList<>(ecsBatch.getJobQueueNames()));
                }
            }
        }
        return retVal;
    }

    private static ApiAttributes toDal(ElastigroupAttributesSpecification attributes) {
        ApiAttributes retVal = null;
        if (attributes != null) {
            retVal = new ApiAttributes();
            if (attributes.isKeySet()) {
                retVal.setKey(attributes.getKey());
            }
            if (attributes.isValueSet()) {
                retVal.setValue(attributes.getValue());
            }
        }

        return retVal;
    }

    private static ApiOptimizeImages toDal(ElastigroupOptimizeImages optimizeImages) {
        ApiOptimizeImages retVal = null;
        if (optimizeImages != null) {
            retVal = new ApiOptimizeImages();
            if (optimizeImages.isShouldOptimizeEcsAmiSet()) {
                retVal.setShouldOptimizeEcsAmi(optimizeImages.getShouldOptimizeEcsAmi());
            }
            if (optimizeImages.isTimeWindowSet()) {
                if (optimizeImages.getTimeWindows() != null) {
                    retVal.setTimeWindows(new LinkedList<>(optimizeImages.getTimeWindows()));
                }
            }
            if (optimizeImages.isPerformAtSet()) {
                if (optimizeImages.getPerformAt() != null) {
                    retVal.setPerformAt(optimizeImages.getPerformAt().getName());
                }

            }

        }
        return retVal;
    }

    private static ApiAutoScale toDal(ElastigroupAutoScaleSpecification autoScale) {
        ApiAutoScale retVal = null;
        if (autoScale != null) {
            retVal = new ApiAutoScale();
            if (autoScale.isCooldownSet()) {
                retVal.setCooldown(autoScale.getCooldown());
            }
            if (autoScale.isDownSet()) {
                retVal.setDown(toDal(autoScale.getDown()));
            }
            if (autoScale.isHeadroomSet()) {
                retVal.setHeadroom(toDal(autoScale.getHeadroom()));
            }
            if (autoScale.isIsAutoConfigSet()) {
                retVal.setIsAutoConfig(autoScale.getAutoConfig());
            }
            if (autoScale.isIsEnabledSet()) {
                retVal.setIsEnabled(autoScale.getEnabled());
            }
            if (autoScale.isShouldScaleDownNonServiceTasksSet()) {
                retVal.setShouldScaleDownNonServiceTasks(autoScale.getShouldScaleDownNonServiceTasks());
            }
            if (autoScale.isAttributesSet()) {
                if (autoScale.getAttributes() != null) {
                    List<ApiAttributes> attributesList =
                            autoScale.getAttributes().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setAttributes(attributesList);
                }
            }
        }
        return retVal;
    }

    private static ApiDown toDal(ElastigroupDownSpecification down) {
        ApiDown retVal = null;

        if (down != null) {
            retVal = new ApiDown();
            if (down.isEvaluationPeriodsSet()) {
                retVal.setEvaluationPeriods(down.getEvaluationPeriods());
            }
            if (down.isMaxScaleDownPercentageSet()) {
                retVal.setMaxScaleDownPercentage(down.getMaxScaleDownPercentage());
            }
        }
        return retVal;

    }

    private static ApiHeadroom toDal(ElastigroupHeadroomSpecification headroom) {
        ApiHeadroom retVal = null;
        if (headroom != null) {
            retVal = new ApiHeadroom();
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

    private static ApiGroupCompute toDal(ElastigroupComputeConfiguration compute) {
        ApiGroupCompute optCompute = null;

        if (compute != null) {
            optCompute = new ApiGroupCompute();
            if (compute.isInstanceTypesSet()) {
                optCompute.setInstanceTypes(toDal(compute.getInstanceTypes()));
            }

            if (compute.isAvailabilityZonesSet()) {
                if (compute.getAvailabilityZones() != null) {
                    List<ApiPlacement> optPlacements =
                            compute.getAvailabilityZones().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    optCompute.setAvailabilityZones(optPlacements);
                }
            }
            if (compute.isProductSet()) {
                optCompute.setProduct(compute.getProduct());
            }
            if (compute.isLaunchSpecificationSet()) {
                optCompute.setLaunchSpecification(toDal(compute.getLaunchSpecification()));
            }

            if (compute.isElasticIpsSet()) {
                if (compute.getElasticIps() != null) {
                    optCompute.setElasticIps(new LinkedList<>(compute.getElasticIps()));
                }
            }

            if (compute.isEbsVolumePoolSet()) {
                if (compute.getEbsVolumePool() != null) {
                    List<ApiVolumePool> optVolumePool =
                            compute.getEbsVolumePool().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    optCompute.setEbsVolumePool(optVolumePool);
                }
            }

            if (compute.isPreferredAvailabilityZonesSet()) {
                if (compute.getPreferredAvailabilityZones() != null) {
                    optCompute.setPreferredAvailabilityZones(new LinkedList<>(compute.getPreferredAvailabilityZones()));
                }
            }

            if(compute.isPrivateIpsSet()){
                optCompute.setPrivateIps(compute.getPrivateIps());
            }

            if(compute.isSubnetIdsSet()){
                optCompute.setSubnetIds(compute.getSubnetIds());
            }

        }

        return optCompute;
    }

    private static ApiVolumePool toDal(ElastigroupEbsVolumePool volumePool) {
        ApiVolumePool retVal = null;

        if (volumePool != null) {
            retVal = new ApiVolumePool();
            if (volumePool.isDeviceNameSet()) {
                retVal.setDeviceName(volumePool.getDeviceName());
            }

            if (volumePool.isVolumeIdsSet()) {
                if (volumePool.getVolumeIds() != null) {
                    retVal.setVolumeIds(new LinkedList<>(volumePool.getVolumeIds()));
                }
            }
        }

        return retVal;
    }

    private static ApiPlacement toDal(Placement placement) {
        ApiPlacement retVal = null;

        if (placement != null) {
            retVal = new ApiPlacement();
            if (placement.isAzNameSet()) {
                retVal.setName(placement.getAzName());
            }
            if (placement.isSubnetIdsSet()) {
                if (placement.getSubnetIds() != null) {
                    retVal.setSubnetIds(new LinkedList<>(placement.getSubnetIds()));
                }
            }
            if(placement.isPlacementGroupNamesSet()){
                if (placement.getPlacementGroupName() != null) {
                    retVal.setPlacementGroupName(placement.getPlacementGroupName());
                }
            }
        }

        return retVal;
    }

    private static ApiLaunchSpec toDal(ElastigroupLaunchSpecification launchSpecification) {
        ApiLaunchSpec retVal = null;

        if (launchSpecification != null) {
            retVal = new ApiLaunchSpec();

            if (launchSpecification.isHealthCheckTypeSet()) {
                retVal.setHealthCheckType(launchSpecification.getHealthCheckType());
            }

            if (launchSpecification.isAutoHealingSet()) {
                retVal.setAutoHealing(launchSpecification.getAutoHealing());
            }

            if (launchSpecification.isHealthCheckGracePeriodSet()) {
                retVal.setHealthCheckGracePeriod(launchSpecification.getHealthCheckGracePeriod());
            }

            if (launchSpecification.isSecurityGroupIdsSet()) {
                if (launchSpecification.getSecurityGroupIds() != null) {
                    retVal.setSecurityGroupIds(new LinkedList<>(launchSpecification.getSecurityGroupIds()));
                }
            }

            if (launchSpecification.isDetailedMonitoringSet()) {
                retVal.setMonitoring(launchSpecification.getDetailedMonitoring());
            }

            if (launchSpecification.isEbsOptimizedSet()) {
                retVal.setEbsOptimized(launchSpecification.getEbsOptimized());
            }

            if (launchSpecification.isImageIdSet() && launchSpecification.getImageId() != null) {
                retVal.setImageId(launchSpecification.getImageId());
            }

            if (launchSpecification.isImagesSet()) {
                if (launchSpecification.getImages() != null) {
                    List<ApiImages> images = launchSpecification.getImages().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setImages(images);
                }
            }

            if (launchSpecification.isHealthCheckUnhealthyDurationBeforeReplacementSet()) {
                retVal.setHealthCheckUnhealthyDurationBeforeReplacement(launchSpecification.getHealthCheckUnhealthyDurationBeforeReplacement());
            }

            if (launchSpecification.isIamRoleSet()) {
                retVal.setIamRole(toDal(launchSpecification.getIamRole()));
            }

            if (launchSpecification.isKeyPairSet()) {
                retVal.setKeyPair(launchSpecification.getKeyPair());
            }

            if (launchSpecification.isUserDataSet()) {
                retVal.setUserData(launchSpecification.getUserData());
            }

            if (launchSpecification.isShutdownScriptSet()) {
                retVal.setShutdownScript(launchSpecification.getShutdownScript());
            }

            if (launchSpecification.isResourceTagSpecificationSet()) {
                retVal.setResourceTagSpecification(toDal(launchSpecification.getResourceTagSpecification()));
            }

            if (launchSpecification.isBlockDeviceMappingsSet()) {
                if (launchSpecification.getBlockDeviceMappings() != null) {
                    List<ApiBlockDevice> optimizerBDM =
                            launchSpecification.getBlockDeviceMappings().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setBlockDeviceMappings(optimizerBDM);
                }
            }

            if (launchSpecification.isLoadBalancersConfigSet()) {
                if (launchSpecification.getLoadBalancersConfig() != null) {
                    retVal.setLoadBalancersConfig(toDal(launchSpecification.getLoadBalancersConfig()));
                }
            }

            if (launchSpecification.isNetworkInterfacesSet()) {
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterface> optimizerNIC =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setNetworkInterfaces(optimizerNIC);
                }
            }

            if (launchSpecification.isTagsSet()) {
                if (launchSpecification.getTags() != null) {
                    List<ApiTag> optimizerTags = launchSpecification.getTags().stream().map(ElastigroupConverter::toDal)
                            .collect(Collectors.toList());
                    retVal.setTags(optimizerTags);
                }
            }

            if (launchSpecification.isItfSet()) {
                retVal.setItf(toDal(launchSpecification.getItf()));
            }

            if (launchSpecification.isCpuOptionsSet()) {
                retVal.setCpuOptions(toDal(launchSpecification.getCpuOptions()));
            }

            if (launchSpecification.isMetadataOptionsSet()) {
                retVal.setMetadataOptions(toDal(launchSpecification.getMetadataOptions()));
            }

            if (launchSpecification.isCreditSpecificationSet()) {
                retVal.setCreditSpecification(toDal(launchSpecification.getCreditSpecification()));
            }

            if(launchSpecification.isMonitoringSet()){
                retVal.setMonitoring(launchSpecification.getMonitoring());
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

    private static ApiNetworkInterface toDal(NetworkInterface networkInterface) {
        ApiNetworkInterface retVal = null;
        if (networkInterface != null) {
            retVal = new ApiNetworkInterface();
            if (networkInterface.isDescriptionSet()) {
                retVal.setDescription(networkInterface.getDescription());
            }

            if (networkInterface.isDeviceIndexSet()) {
                retVal.setDeviceIndex(networkInterface.getDeviceIndex());
            }

            if (networkInterface.isSecondaryPrivateIpAddressCountSet()) {
                retVal.setSecondaryPrivateIpAddressCount(networkInterface.getSecondaryPrivateIpAddressCount());
            }

            if (networkInterface.isAssociatePublicIpAddressSet()) {
                retVal.setAssociatePublicIpAddress(networkInterface.getAssociatePublicIpAddress());
            }

            if (networkInterface.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(networkInterface.getDeleteOnTermination());
            }

            if (networkInterface.isNetworkInterfaceIdSet()) {
                retVal.setNetworkInterfaceId(networkInterface.getNetworkInterfaceId());
            }

            if(networkInterface.isAssociateIpv6AddressSet()){
                retVal.setAssociateIpv6Address(networkInterface.getAssociateIpv6Address());
            }

            if(networkInterface.isSubnetIdSet()){
                retVal.setSubnetId(networkInterface.getSubnetId());
            }

            if(networkInterface.isPrivateIpAddressesSet()){
                List<ApiPrivateIpAddresses> ipAddress =
                        networkInterface.getPrivateIpAddresses().stream().map(ElastigroupConverter::toDal)
                                .collect(Collectors.toList());

                retVal.setPrivateIpAddresses(ipAddress);
            }
        }

        return retVal;
    }

    private static ApiPrivateIpAddresses toDal(PrivateIpAddresses ipAddress){
        ApiPrivateIpAddresses retVal = null;

        if(ipAddress != null){
            retVal = new ApiPrivateIpAddresses();

            if(ipAddress.isPrimarySet()){
                retVal.setPrimary(ipAddress.getPrimary());
            }

            if(ipAddress.isPrivateIpAddressSet()){
                retVal.setPrivateIpAddress(ipAddress.getPrivateIpAddress());
            }
        }
        return  retVal;
    }

    private static ApiBlockDevice toDal(BlockDeviceMapping blockDeviceMapping) {
        ApiBlockDevice retVal = null;

        if (blockDeviceMapping != null) {
            retVal = new ApiBlockDevice();
            if (blockDeviceMapping.isDeviceNameSet()) {
                retVal.setDeviceName(blockDeviceMapping.getDeviceName());
            }

            if (blockDeviceMapping.isNoDeviceSet()) {
                retVal.setNoDevice(blockDeviceMapping.getNoDevice());
            }

            if (blockDeviceMapping.isVirtualNameSet()) {
                retVal.setVirtualName(blockDeviceMapping.getVirtualName());
            }

            if (blockDeviceMapping.isEbsDeviceSet()) {
                retVal.setEbs(toDal(blockDeviceMapping.getEbsDevice()));
            }
        }

        return retVal;
    }

    private static ApiGroupTagSpecification toDal(GroupTagSpecification groupTagSpecification) {
        ApiGroupTagSpecification retVal = null;

        if (groupTagSpecification != null) {
            retVal = new ApiGroupTagSpecification();
            retVal.setShouldTag(groupTagSpecification.getShouldTag());
        }
        return retVal;
    }

    private static ApiGroupResourceTagSpecification toDal(GroupResourceTagSpecification resourceTagSpecification) {
        ApiGroupResourceTagSpecification retVal = null;

        if (resourceTagSpecification != null) {
            retVal = new ApiGroupResourceTagSpecification();

            if (resourceTagSpecification.isVolumeSet()) {
                retVal.setVolumes(toDal(resourceTagSpecification.getVolumes()));
            }
            if (resourceTagSpecification.isSnapshotSet()) {
                retVal.setSnapshots(toDal(resourceTagSpecification.getSnapshots()));
            }
            if (resourceTagSpecification.isEniSet()) {
                retVal.setEnis(toDal(resourceTagSpecification.getEnis()));
            }
            if (resourceTagSpecification.isAmiSet()) {
                retVal.setAmis(toDal(resourceTagSpecification.getAmis()));
            }
        }
        return retVal;
    }

    private static ApiImages toDal(Images images) {
        ApiImages retVal = null;

        if (images != null) {
            retVal = new ApiImages();

            if (images.isIdSet()) {
                retVal.setId(images.getId());
            }
        }
        return retVal;
    }

    private static ApiLoadBalancersConfig toDal(LoadBalancersConfig loadBalancersConfig) {
        ApiLoadBalancersConfig retVal = new ApiLoadBalancersConfig();
        List<ApiLoadBalancer> apiLoadBalancers = null;

        List<LoadBalancer> loadBalancers = loadBalancersConfig.getLoadBalancers();

        if (loadBalancers != null) {
            apiLoadBalancers = loadBalancers.stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
        }

        retVal.setLoadBalancers(apiLoadBalancers);

        return retVal;
    }

    private static ApiItf toDal(ElastigroupItf itf) {
        ApiItf retVal = null;

        if (itf != null) {
            retVal = new ApiItf();

            if (itf.isMigrationHealthinessThresholdSet()) {
                retVal.setMigrationHealthinessThreshold(itf.getMigrationHealthinessThreshold());
            }

            if (itf.isFixedTargetGroupsSet()) {
                retVal.setFixedTargetGroups(itf.getFixedTargetGroups());
            }

            if (itf.isWeightStrategySet()) {
                retVal.setWeightStrategy(itf.getWeightStrategy());
            }

            if (itf.isTargetGroupConfigSet()) {
                retVal.setTargetGroupConfig(toDal(itf.getTargetGroupConfig()));
            }

            if (itf.isLoadBalancersSet()) {
                if (itf.getLoadBalancers() != null) {
                    List<ApiItfLoadBalancer> optItfLoadBalancers =
                            itf.getLoadBalancers().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                    retVal.setLoadBalancers(optItfLoadBalancers);
                }
            }

        }

        return retVal;
    }

    private static ApiItfLoadBalancer toDal(ElastigroupItfLoadBalancer loadBalancer) {
        ApiItfLoadBalancer retVal = null;

        if (loadBalancer != null) {
            retVal = new ApiItfLoadBalancer();

            if (loadBalancer.isLoadBalancerArnSet()) {
                retVal.setLoadBalancerArn(loadBalancer.getLoadBalancerArn());
            }

            if (loadBalancer.isListenerRulesSet()) {
                if (loadBalancer.getListenerRules() != null) {
                    List<ApiListenerRule> optListenerRules =
                            loadBalancer.getListenerRules().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                    retVal.setListenerRules(optListenerRules);
                }
            }

            if(loadBalancer.isDefaultStaticTargetGroupsSet()){

                List<ApiDefaultStaticTargetGroups> apiDefaultStaticTargetGroups =
                        loadBalancer.getDefaultStaticTargetGroups().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());

                retVal.setDefaultStaticTargetGroups(apiDefaultStaticTargetGroups);
            }
        }

        return retVal;
    }

    private static ApiDefaultStaticTargetGroups toDal(DefaultStaticTargetGroups defaultStaticTargetGroups){
        ApiDefaultStaticTargetGroups retVal = null;

        if(defaultStaticTargetGroups != null){
            retVal = new ApiDefaultStaticTargetGroups();

            if(defaultStaticTargetGroups.isArnSet()){
                retVal.setArn(defaultStaticTargetGroups.getArn());
            }
            if(defaultStaticTargetGroups.isPercentageSet()){
                retVal.setPercentage(defaultStaticTargetGroups.getPercentage());
            }
        }
        return retVal;
    }

    private static ApiListenerRule toDal(ElastigroupListenerRule listenerRule) {
        ApiListenerRule retVal = null;

        if (listenerRule != null) {
            retVal = new ApiListenerRule();

            if (listenerRule.isRuleArnSet()) {
                retVal.setRuleArn(listenerRule.getRuleArn());
            }

            if(listenerRule.isStaticTargetGroupsSet()){
                List<ApiStaticTargetGroups> apiStaticTargetGroups =listenerRule.getStaticTargetGroups().stream().map(ElastigroupConverter::toDal)
                        .collect(Collectors.toList());
                retVal.setStaticTargetGroups(apiStaticTargetGroups);
            }
        }

        return retVal;
    }

    private static ApiStaticTargetGroups toDal(StaticTargetGroups  staticTargetGroups) {
        ApiStaticTargetGroups retVal = null;

        if (staticTargetGroups != null) {
            retVal = new ApiStaticTargetGroups();

            if(staticTargetGroups.isPercentageSet()){
                retVal.setPercentage(staticTargetGroups.getPercentage());
            }

            if(staticTargetGroups.isArnSet()){
                retVal.setArn(staticTargetGroups.getArn());
            }
        }

        return retVal;
    }
    private static ApiTargetGroupConfig toDal(ElastigroupTargetGroupConfig targetGroupConfig) {
        ApiTargetGroupConfig retVal = null;

        if (targetGroupConfig != null) {
            retVal = new ApiTargetGroupConfig();

            if (targetGroupConfig.isHealthCheckIntervalSecondsSet()) {
                retVal.setHealthCheckIntervalSeconds(targetGroupConfig.getHealthCheckIntervalSeconds());
            }

            if (targetGroupConfig.isVpcIdSet()) {
                retVal.setVpcId(targetGroupConfig.getVpcId());
            }

            if (targetGroupConfig.isHealthCheckPathSet()) {
                retVal.setHealthCheckPath(targetGroupConfig.getHealthCheckPath());
            }

            if (targetGroupConfig.isHealthCheckPortSet()) {
                retVal.setHealthCheckPort(targetGroupConfig.getHealthCheckPort());
            }

            if (targetGroupConfig.isHealthCheckProtocolSet()) {
                retVal.setHealthCheckProtocol(targetGroupConfig.getHealthCheckProtocol());
            }

            if (targetGroupConfig.isHealthCheckTimeoutSecondsSet()) {
                retVal.setHealthCheckTimeoutSeconds(targetGroupConfig.getHealthCheckTimeoutSeconds());
            }

            if (targetGroupConfig.isHealthyThresholdCountSet()) {
                retVal.setHealthyThresholdCount(targetGroupConfig.getHealthyThresholdCount());
            }

            if (targetGroupConfig.isUnhealthyThresholdCountSet()) {
                retVal.setUnhealthyThresholdCount(targetGroupConfig.getUnhealthyThresholdCount());
            }

            if (targetGroupConfig.isPortSet()) {
                retVal.setPort(targetGroupConfig.getPort());
            }

            if (targetGroupConfig.isProtocolSet()) {
                retVal.setProtocol(targetGroupConfig.getProtocol());
            }

            if (targetGroupConfig.isProtocolVersionSet()) {
                retVal.setProtocolVersion(targetGroupConfig.getProtocolVersion());
            }

            if (targetGroupConfig.isTagsSet()) {
                if (targetGroupConfig.getTags() != null) {
                    List<ApiTargetGroupConfigTag> optItfTags =
                            targetGroupConfig.getTags().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                    retVal.setTags(optItfTags);
                }
            }

            if (targetGroupConfig.isMatcherSet()) {
                retVal.setMatcher(toDal(targetGroupConfig.getMatcher()));
            }

        }

        return retVal;
    }

    private static ApiMatcher toDal(ElastigroupMatcher matcher) {
        ApiMatcher retVal = null;

        if (matcher != null) {
            retVal = new ApiMatcher();

            if (matcher.isHttpCodeSet()) {
                retVal.setHttpCode(matcher.getHttpCode());
            }

            if (matcher.isGrpcCodeSet()) {
                retVal.setGrpcCode(matcher.getGrpcCode());
            }
        }

        return retVal;
    }

    private static ApiTargetGroupConfigTag toDal(ElastigroupTargetGroupConfigTag tags) {
        ApiTargetGroupConfigTag retVal = null;

        if (tags != null) {
            retVal = new ApiTargetGroupConfigTag();

            if (tags.isTagKeySet()) {
                retVal.setTagKey(tags.getTagKey());
            }

            if (tags.isTagValueSet()) {
                retVal.setTagValue(tags.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiLoadBalancer toDal(LoadBalancer loadBalancer) {
        ApiLoadBalancer retVal = null;

        if (loadBalancer != null) {
            retVal = new ApiLoadBalancer();

            if (loadBalancer.isNameSet()) {
                retVal.setName(loadBalancer.getName());
            }

            if (loadBalancer.isArnSet()) {
                retVal.setArn(loadBalancer.getArn());
            }

            if (loadBalancer.isBalancerIdSet()) {
                retVal.setBalancerId(loadBalancer.getBalancerId());
            }

            if (loadBalancer.isTargetSetIdSet()) {
                retVal.setTargetSetId(loadBalancer.getTargetSetId());
            }

            if (loadBalancer.isAzAwarenessSet()) {
                retVal.setAzAwareness(loadBalancer.getAzAwareness());
            }

            if (loadBalancer.isAutoWeightSet()) {
                retVal.setAutoWeight(loadBalancer.getAutoWeight());
            }

            if (loadBalancer.isTypeSet() && loadBalancer.getType() != null) {
                retVal.setType(loadBalancer.getType().getName());
            }
        }

        return retVal;
    }

    private static ApiEbsDevice toDal(EbsDevice ebsDevice) {
        ApiEbsDevice retVal = null;

        if (ebsDevice != null) {
            retVal = new ApiEbsDevice();

            if (ebsDevice.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(ebsDevice.getDeleteOnTermination());
            }

            if (ebsDevice.isEncryptedSet()) {
                retVal.setEncrypted(ebsDevice.getEncrypted());
            }

            if (ebsDevice.isIopsSet()) {
                retVal.setIops(ebsDevice.getIops());
            }

            if (ebsDevice.isSnapshotIdSet()) {
                retVal.setSnapshotId(ebsDevice.getSnapshotId());
            }

            if (ebsDevice.isVolumeSizeSet()) {
                retVal.setVolumeSize(ebsDevice.getVolumeSize());
            }

            if (ebsDevice.isVolumeTypeSet()) {
                if (ebsDevice.getVolumeType() != null) {
                    retVal.setVolumeType(ebsDevice.getVolumeType().getName());
                }
            }

            if (ebsDevice.isThroughputSet()) {
                retVal.setThroughput(ebsDevice.getThroughput());
            }

            if (ebsDevice.isDynamicVolumeSizeSet()) {
                ApiDynamicVolumeSize apiDynamicVolumeSize = toDal(ebsDevice.getDynamicVolumeSize());
                retVal.setDynamicVolumeSize(apiDynamicVolumeSize);
            }

            if(ebsDevice.isKmsKeyIdSet()){
                retVal.setKmsKeyId(ebsDevice.getKmsKeyId());
            }

            if(ebsDevice.isDynamicIopsSet()){
                ApiDynamiclops apiDynamiclops = toDal(ebsDevice.getDynamicIops());
                retVal.setDynamicIops(apiDynamiclops);
            }

        }

        return retVal;
    }

    private static ApiDynamiclops toDal(Dynamiclops  dynamiclops) {
        ApiDynamiclops retVal = null;

        if (dynamiclops != null) {
            retVal = new ApiDynamiclops();

            if(dynamiclops.isBaseSizeSet()){
                retVal.setBaseSize(dynamiclops.getBaseSize());
            }

            if(dynamiclops.isResourceSet()){
                retVal.setResource(dynamiclops.getResource());
            }

            if(dynamiclops.isSizePerResourceUnitSet()){
                retVal.setSizePerResourceUnit(dynamiclops.getSizePerResourceUnit());
            }
        }

        return retVal;
    }

    private static ApiDynamicVolumeSize toDal(DynamicVolumeSize  dynamicVolumeSize) {
        ApiDynamicVolumeSize retVal = null;

        if (dynamicVolumeSize != null) {
            retVal = new ApiDynamicVolumeSize();

            if(dynamicVolumeSize.isBaseSizeSet()){
                retVal.setBaseSize(dynamicVolumeSize.getBaseSize());
            }

            if(dynamicVolumeSize.isResourceSet()){
                retVal.setResource(dynamicVolumeSize.getResource());
            }

            if(dynamicVolumeSize.isSizePerResourceUnitSet()){
                retVal.setSizePerResourceUnit(dynamicVolumeSize.getSizePerResourceUnit());
            }
        }

        return retVal;
    }

    private static ApiIamRole toDal(IamRole iamRole) {
        ApiIamRole retVal = null;

        if (iamRole != null) {
            retVal = new ApiIamRole();

            if (iamRole.isNameSet()) {
                retVal.setName(iamRole.getName());
            }

            if (iamRole.isArnSet()) {
                retVal.setArn(iamRole.getArn());
            }
        }

        return retVal;
    }

    private static ApiCpuOptions toDal(CpuOptions options) {
        ApiCpuOptions retVal = null;

        if (options != null) {
            retVal = new ApiCpuOptions();

            if (options.isThreadsPerCoreSet()) {
                retVal.setThreadsPerCore(options.getThreadsPerCore());
            }
        }

        return retVal;
    }

    private static ApiMetadataOptions toDal(MetadataOptions options) {
        ApiMetadataOptions retVal = null;

        if (options != null) {
            retVal = new ApiMetadataOptions();

            if (options.isHttpPutResponseHopLimitSet()) {
                retVal.setHttpPutResponseHopLimit(options.getHttpPutResponseHopLimit());
            }

            if (options.isHttpTokensSet()) {
                retVal.setHttpTokens(options.getHttpTokens());
            }

            if (options.isInstanceMetadataTagsSet()) {
                retVal.setInstanceMetadataTags(options.getInstanceMetadataTags().getName());
            }
        }

        return retVal;
    }

    private static ApiCreditSpecification toDal(CreditSpecification spec) {
        ApiCreditSpecification retVal = null;

        if (spec != null) {
            retVal = new ApiCreditSpecification();

            if (spec.isCpuCreditsSet()) {
                retVal.setCpuCredits(spec.getCpuCredits().getName());
            }
        }

        return retVal;
    }

    private static ApiInstanceTypes toDal(ElastigroupInstanceTypes instanceTypes) {
        ApiInstanceTypes retVal = null;

        if (instanceTypes != null) {
            retVal = new ApiInstanceTypes();
            if (instanceTypes.isOnDemandSet()) {
                retVal.setOndemand(instanceTypes.getOnDemand());
            }

            if (instanceTypes.isOnDemandTypesSet()) {
                if (instanceTypes.getOnDemandTypes() != null) {
                    retVal.setOnDemandTypes(new LinkedList<>(instanceTypes.getOnDemandTypes()));
                }
            }

            if (instanceTypes.isSpotSet()) {
                if (instanceTypes.getSpot() != null) {
                    retVal.setSpot(new LinkedList<>(instanceTypes.getSpot()));
                }
            }

            if (instanceTypes.isPreferredSpotSet()) {
                if (instanceTypes.getPreferredSpot() != null) {
                    retVal.setPreferredSpot(new LinkedList<>(instanceTypes.getPreferredSpot()));
                }
            }

            if (instanceTypes.isWeightsSet()) {
                if (instanceTypes.getWeights() != null) {
                    List<ApiInstanceTypesWeights> optWeights = instanceTypes.getWeights().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                    retVal.setWeights(optWeights);
                }
            }

            if (instanceTypes.isResourceRequirementsSet()) {
                retVal.setResourceRequirements(toDal(instanceTypes.getResourceRequirements()));
            }
        }

        return retVal;
    }

    private static ApiInstanceTypesWeights toDal(ElastigroupInstanceTypesWeights weights) {
        ApiInstanceTypesWeights retVal = null;

        if (weights != null) {
            retVal = new ApiInstanceTypesWeights();

            if (weights.isInstanceTypeSet()) {
                retVal.setInstanceType(weights.getInstanceType());
            }

            if (weights.isWeightedCapacitySet()) {
                retVal.setWeightedCapacity(weights.getWeightedCapacity());
            }
        }

        return retVal;
    }

    private static ApiResourceRequirements toDal(ResourceRequirements requirements) {
        ApiResourceRequirements retVal = null;

        if (requirements != null) {
            retVal = new ApiResourceRequirements();

            if (requirements.isExcludedInstanceFamiliesSet()) {
                retVal.setExcludedInstanceFamilies(new LinkedList<>(requirements.getExcludedInstanceFamilies()));
            }

            if (requirements.isExcludedInstanceGenerationsSet()) {
                retVal.setExcludedInstanceGenerations(new LinkedList<>(requirements.getExcludedInstanceGenerations()));
            }

            if (requirements.isExcludedInstanceTypesSet()) {
                retVal.setExcludedInstanceTypes(new LinkedList<>(requirements.getExcludedInstanceTypes()));
            }

            if (requirements.isRequiredGpuSet()) {
                retVal.setRequiredGpu(toDal(requirements.getRequiredGpu()));
            }

            if (requirements.isRequiredMemorySet()) {
                retVal.setRequiredMemory(toDal(requirements.getRequiredMemory()));
            }

            if (requirements.isRequiredVCpuSet()) {
                retVal.setRequiredVCpu(toDal(requirements.getRequiredVCpu()));
            }
        }

        return retVal;
    }


    private static ApiRequiredVCpuMemoryGpu toDal(RequiredVCpuMemoryGpu requiredVCpuMemory) {
        ApiRequiredVCpuMemoryGpu retVal = null;

        if (requiredVCpuMemory != null) {

            retVal = new ApiRequiredVCpuMemoryGpu();

            if (requiredVCpuMemory.isMinimumSet()) {
                retVal.setMinimum(requiredVCpuMemory.getMinimum());
            }

            if (requiredVCpuMemory.isMaximumSet()) {
                retVal.setMaximum(requiredVCpuMemory.getMaximum());
            }
        }

        return retVal;
    }


    private static ApiStrategy toDal(ElastigroupStrategyConfiguration strategy) {
        ApiStrategy retVal = null;

        if (strategy != null) {
            retVal = new ApiStrategy();

            if (strategy.isSpotPercentageSet()) {
                retVal.setRisk(strategy.getSpotPercentage());
            }

            if (strategy.isOnDemandCountSet()) {
                retVal.setOnDemandCount(strategy.getOnDemandCount());
            }

            if (strategy.isElastigroupOrientationSet()) {
                if (strategy.getElastigroupOrientation() != null) {
                    retVal.setAvailabilityVsCost(strategy.getElastigroupOrientation().getName());
                }
            }

            if (strategy.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(strategy.getDrainingTimeout());
            }

            if (strategy.isUtilizeReservedInstancesSet()) {
                retVal.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }

            if (strategy.isUtilizeCommitmentsSet()) {
                retVal.setUtilizeCommitments(strategy.getUtilizeCommitments());
            }

            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }

            if (strategy.isPersistenceSet()) {
                retVal.setPersistence(toDal(strategy.getPersistence()));
            }

            if (strategy.isRevertToSpotSet()) {
                retVal.setRevertToSpot(toDal(strategy.getRevertToSpot()));
            }

            if (strategy.isConsiderODPricingSet()) {
                retVal.setConsiderODPricing(strategy.getConsiderODPricing());
            }

            if (strategy.isRestrictSingleAzSet()) {
                retVal.setRestrictSingleAz(strategy.getRestrictSingleAz());
            }

            if(strategy.isSignalsSet()) {
                if(strategy.getSignals()!=null) {
                    List<ApiStrategySignal> signals =
                            strategy.getSignals().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setSignals(signals);
                }
            }

            if (strategy.isScalingStrategySet()) {
                retVal.setScalingStrategy(toDal(strategy.getScalingStrategy()));
            }
        }

        return retVal;
    }

    private static ApiRevertToSpot toDal(ElastigroupRevertToSpot revertToSpot) {
        ApiRevertToSpot retVal = null;

        if (revertToSpot != null) {
            retVal = new ApiRevertToSpot();

            if (revertToSpot.isPerformAtSet()) {
                retVal.setPerformAt(revertToSpot.getPerformAt());
            }

            if (revertToSpot.isTimeWindowSet()) {
                if (revertToSpot.getTimeWindows() != null) {
                    retVal.setTimeWindows(new LinkedList<>(revertToSpot.getTimeWindows()));
                }
            }
        }

        return retVal;
    }

    private static ApiGroupPersistence toDal(ElastigroupPersistenceConfiguration persistence) {
        ApiGroupPersistence retVal = null;

        if (persistence != null) {
            retVal = new ApiGroupPersistence();

            if (persistence.isBlockDevicesModeSet()) {
                retVal.setBlockDevicesMode(persistence.getBlockDevicesMode());
            }

            if (persistence.isShouldPersistBlockDevicesSet()) {
                retVal.setShouldPersistBlockDevices(persistence.getShouldPersistBlockDevices());
            }

            if (persistence.isShouldPersistPrivateIpSet()) {
                retVal.setShouldPersistPrivateIp(persistence.getShouldPersistPrivateIp());
            }

            if (persistence.isShouldPersistRootDeviceSet()) {
                retVal.setShouldPersistRootDevice(persistence.getShouldPersistRootDevice());
            }
        }

        return retVal;
    }

    private static ApiStrategySignal toDal(StrategySignal signal) {
        ApiStrategySignal retVal = null;

        if (signal != null) {
            retVal = new ApiStrategySignal();

            if (signal.isNameSet()) {
                retVal.setName(signal.getName());
            }

            if (signal.isTimeoutSet()) {
                retVal.setTimeout(signal.getTimeout());
            }
        }

        return retVal;
    }

    private static ApiScalingStrategy toDal(ScalingStrategy scalingStrategy) {
        ApiScalingStrategy retVal = null;

        if (scalingStrategy != null) {
            retVal = new ApiScalingStrategy();

            if (scalingStrategy.isTerminationPolicySet()) {
                retVal.setTerminationPolicy(scalingStrategy.getTerminationPolicy().getName());
            }
        }

        return retVal;
    }


    private static ApiCapacity toDal(ElastigroupCapacityConfiguration capacity) {
        ApiCapacity retVal = null;

        if (capacity != null) {
            retVal = new ApiCapacity();

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

    private static ApiScaling toDal(ElastigroupScalingConfiguration scaling) {
        ApiScaling retVal = null;

        if (scaling != null) {
            retVal = new ApiScaling();

            if (scaling.isUpSet()) {
                List<ApiScalingPolicy> apiUpScalingPolicies = null;

                if (scaling.getUp() != null) {
                    List<ScalingPolicy> up = scaling.getUp();
                    apiUpScalingPolicies = up.stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                }

                retVal.setUp(apiUpScalingPolicies);
            }

            if (scaling.isDownSet()) {
                List<ApiScalingPolicy> apiDownScalingPolicies = null;

                if (scaling.getDown() != null) {
                    List<ScalingPolicy> down = scaling.getDown();
                    apiDownScalingPolicies =
                            down.stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                }

                retVal.setDown(apiDownScalingPolicies);
            }

            if (scaling.isTargetSet()) {
                List<ApiScalingPolicy> apiTargetScalingPolicies = null;

                if (scaling.getTarget() != null) {
                    List<ScalingPolicy> target = scaling.getTarget();
                    apiTargetScalingPolicies =
                            target.stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                }

                retVal.setTarget(apiTargetScalingPolicies);
            }

            if(scaling.isMultipleMetricsSet()){
                if(scaling.getMultipleMetrics() != null){
                    retVal.setMultipleMetrics(toDal(scaling.getMultipleMetrics()));
                }
            }
        }

        return retVal;
    }

    private static ApiMultipleMetrics toDal(MultipleMetrics multipleMetrics){
        ApiMultipleMetrics retVal = null;

        if(multipleMetrics != null){
            retVal = new ApiMultipleMetrics();

            if(multipleMetrics.isExpressionsSet()){
                List<Expressions> expressions = multipleMetrics.getExpressions();
                List<ApiExpressions> apiExpressions =
                        expressions.stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                retVal.setExpressions(apiExpressions);
            }

            if(multipleMetrics.isMetricssSet()){
                List<Metrics> Metrics = multipleMetrics.getMetrics();
                List<ApiMetrics> apimetrics = Metrics.stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                retVal.setMetrics(apimetrics);
            }
        }
        return retVal;
    }

    private static ApiExpressions toDal(Expressions expressions){
        ApiExpressions retVal = null;

        if(expressions != null){
            retVal = new ApiExpressions();

            if(expressions.isExpressionSet()){
                retVal.setExpression(expressions.getExpression());
            }

            if(expressions.isNameSet()){
                retVal.setName(expressions.getName());
            }
        }
        return  retVal;
    }

    private static ApiMetrics toDal(Metrics metrics){
        ApiMetrics retVal = null;

        if(metrics != null){
            retVal = new ApiMetrics();

            if(metrics.isDimensionSet()){
                List<ApiScalingDimension> apiStepAdjustments =
                        metrics.getDimensions().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                retVal.setDimensions(apiStepAdjustments);
            }

            if(metrics.isExtendedStatisticSet()){
                retVal.setExtendedStatistic(metrics.getExtendedStatistic());
            }

            if(metrics.isMetricNameSet()){
                retVal.setMetricName(metrics.getMetricName());
            }

            if(metrics.isNameSet()){
                retVal.setName(metrics.getName());
            }

            if(metrics.isNamespaceSet()){
                retVal.setNamespace(metrics.getNamespace());
            }

            if(metrics.isStatisticSet()){
                retVal.setStatistic(metrics.getStatistic());
            }

            if(metrics.isUnitSet()){
                retVal.setUnit(metrics.getUnit());
            }
        }
        return  retVal;
    }


    private static ApiStepAdjustments toDal(StepAdjustments stepAdjustments){
        ApiStepAdjustments retVal = null;

        if(stepAdjustments != null){
            retVal = new ApiStepAdjustments();

            if(stepAdjustments.isActionSet()){
                retVal.setAction(toDal(stepAdjustments.getAction()));
            }
            if(stepAdjustments.isThresholdSet()){
                retVal.setThreshold(stepAdjustments.getThreshold());
            }
        }
        return retVal;
    }

    private static ApiScalingPolicy toDal(ScalingPolicy scalingPolicy) {
        ApiScalingPolicy retVal = null;

        if (scalingPolicy != null) {
            retVal = new ApiScalingPolicy();

            if(scalingPolicy.isStepAdjustmentsSet()){
                List<ApiStepAdjustments> apiStepAdjustments =
                        scalingPolicy.getStepAdjustments().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                retVal.setStepAdjustments(apiStepAdjustments);
            }
            if (scalingPolicy.isPolicyNameSet()) {
                retVal.setPolicyName(scalingPolicy.getPolicyName());
            }

            if (scalingPolicy.isMetricNameSet()) {
                retVal.setMetricName(scalingPolicy.getMetricName());
            }

            if (scalingPolicy.isStatisticSet()) {
                retVal.setStatistic(scalingPolicy.getStatistic());
            }

            if (scalingPolicy.isExtendedStatisticSet()) {
                retVal.setExtendedStatistic(scalingPolicy.getExtendedStatistic());
            }

            if (scalingPolicy.isUnitSet()) {
                retVal.setUnit(scalingPolicy.getUnit());
            }

            if (scalingPolicy.isThresholdSet()) {
                retVal.setThreshold(scalingPolicy.getThreshold());
            }

            if (scalingPolicy.isNamespaceSet()) {
                retVal.setNamespace(scalingPolicy.getNamespace());
            }

            if (scalingPolicy.isPeriodSet()) {
                retVal.setPeriod(scalingPolicy.getPeriod());
            }

            if (scalingPolicy.isEvaluationPeriodsSet()) {
                retVal.setEvaluationPeriods(scalingPolicy.getEvaluationPeriods());
            }

            if (scalingPolicy.isCooldownSet()) {
                retVal.setCooldown(scalingPolicy.getCooldown());
            }

            if (scalingPolicy.isDimensionsSet()) {
                List<ScalingDimension> dimensions = scalingPolicy.getDimensions();

                if (dimensions != null) {
                    List<ApiScalingDimension> optimizerScalingDimensions =
                            dimensions.stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                    retVal.setDimensions(optimizerScalingDimensions);
                }
            }

            if (scalingPolicy.isActionSet()) {
                retVal.setAction(toDal(scalingPolicy.getAction()));
            }

            if (scalingPolicy.isOperatorSet()) {
                retVal.setOperator(scalingPolicy.getOperator());
            }

            if (scalingPolicy.isIsEnabledSet()) {
                retVal.setIsEnabled(scalingPolicy.getIsEnabled());
            }

            if (scalingPolicy.isTargetSet()) {
                retVal.setTarget(scalingPolicy.getTarget());
            }

            if (scalingPolicy.isPredictiveSet()) {
                ApiPredictiveScale apiPredictiveScale = toDal(scalingPolicy.getPredictive());
                retVal.setPredictive(apiPredictiveScale);
            }
        }

        return retVal;
    }

    private static ApiPredictiveScale toDal(PredictiveScale predictiveScale) {
        ApiPredictiveScale retVal = null;

        if (predictiveScale != null) {
            retVal = new ApiPredictiveScale();

            if (predictiveScale.isModeSet()) {
                retVal.setMode(predictiveScale.getMode().getName());
            }
        }

        return retVal;
    }


    private static ApiScalingDimension toDal(ScalingDimension scalingDimension) {
        ApiScalingDimension retVal = null;

        if (scalingDimension != null) {
            retVal = new ApiScalingDimension();

            if (scalingDimension.isNameSet()) {
                retVal.setName(scalingDimension.getName());
            }

            if (scalingDimension.isValueSet()) {
                retVal.setValue(scalingDimension.getValue());
            }
        }

        return retVal;
    }


    private static ApiScalingAction toDal(ScalingAction scalingAction) {
        ApiScalingAction retVal = null;

        if (scalingAction != null) {
            retVal = new ApiScalingAction();

            if (scalingAction.isTypeSet() && scalingAction.getType() != null) {
                retVal.setType(scalingAction.getType().getName());
            }

            if (scalingAction.isAdjustmentSet()) {
                retVal.setAdjustment(scalingAction.getAdjustment());
            }

            if (scalingAction.isMinTargetCapacitySet()) {
                retVal.setMinTargetCapacity(scalingAction.getMinTargetCapacity());
            }

            if (scalingAction.isMaxTargetCapacitySet()) {
                retVal.setMaxTargetCapacity(scalingAction.getMaxTargetCapacity());
            }

            if (scalingAction.isTargetSet()) {
                retVal.setTarget(scalingAction.getTarget());
            }

            if (scalingAction.isMinimumSet()) {
                retVal.setMinimum(scalingAction.getMinimum());
            }

            if (scalingAction.isMaximumSet()) {
                retVal.setMaximum(scalingAction.getMaximum());
            }
        }

        return retVal;
    }

    public static ApiElastigroupStartDeployment toDal(ElastigroupStartDeployment elastigroupDeployment) {
        ApiElastigroupStartDeployment retVal = null;

        if (elastigroupDeployment != null) {
            retVal = new ApiElastigroupStartDeployment();

            if (elastigroupDeployment.isBatchSizePercentageSet()) {
                retVal.setBatchSizePercentage(elastigroupDeployment.getBatchSizePercentage());
            }

            if (elastigroupDeployment.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(elastigroupDeployment.getDrainingTimeout());
            }

            if (elastigroupDeployment.isGracePeriodSet()) {
                retVal.setGracePeriod(elastigroupDeployment.getGracePeriod());
            }

            if (elastigroupDeployment.isHealthCheckTypeSet()) {
                retVal.setHealthCheckType(elastigroupDeployment.getHealthCheckType().getName());
            }

            if (elastigroupDeployment.isStrategySet()) {
                retVal.setStrategy(toDal(elastigroupDeployment.getStrategy()));
            }

        }

        return retVal;
    }

    private static ApiElastigroupDeploymentStrategy toDal(ElastigroupDeploymentStrategy elastigroupStrategy) {
        ApiElastigroupDeploymentStrategy retVal = null;

        if (elastigroupStrategy != null) {
            retVal = new ApiElastigroupDeploymentStrategy();

            if (elastigroupStrategy.isActionSet()) {
                retVal.setAction(elastigroupStrategy.getAction().getName());
            }

            if (elastigroupStrategy.isBatchMinHealthyPercentageSet()) {
                retVal.setBatchMinHealthyPercentage(elastigroupStrategy.getBatchMinHealthyPercentage());
            }

            if (elastigroupStrategy.isOnFailureSet()) {
                retVal.setOnFailure(toDal(elastigroupStrategy.getOnFailure()));
            }
        }

        return retVal;
    }

    public static ApiElastigroupDeploymentStrategyOnFailure toDal(
            ElastigroupDeploymentStrategyOnFailure elastigroupOnFailure) {
        ApiElastigroupDeploymentStrategyOnFailure retVal = null;

        if (elastigroupOnFailure != null) {
            retVal = new ApiElastigroupDeploymentStrategyOnFailure();

            if (elastigroupOnFailure.isActionTypeSet()) {
                retVal.setActionType(elastigroupOnFailure.getActionType().getName());
            }

            if (elastigroupOnFailure.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(elastigroupOnFailure.getDrainingTimeout());
            }

            if (elastigroupOnFailure.isShouldDecrementTargetCapacitySet()) {
                retVal.setShouldDecrementTargetCapacity(elastigroupOnFailure.getShouldDecrementTargetCapacity());
            }

            if (elastigroupOnFailure.isShouldHandleAllBatchesSet()) {
                retVal.setShouldHandleAllBatches(elastigroupOnFailure.getShouldHandleAllBatches());
            }
        }

        return retVal;
    }


    private static ApiElastigroupStartDeploymentResponse toDal(
            ElastigroupStartDeploymentResponse elastigroupStartDeploymentItems) {
        ApiElastigroupStartDeploymentResponse retVal = null;

        if (elastigroupStartDeploymentItems != null) {
            retVal = new ApiElastigroupStartDeploymentResponse();

            if (elastigroupStartDeploymentItems.isIdSet()) {
                retVal.setId(elastigroupStartDeploymentItems.getId());
            }

            if (elastigroupStartDeploymentItems.isStatusSet()) {
                retVal.setStatus(elastigroupStartDeploymentItems.getStatus());
            }

            if (elastigroupStartDeploymentItems.isCurrentBatchSet()) {
                retVal.setCurrentBatch(elastigroupStartDeploymentItems.getCurrentBatch());
            }

            if (elastigroupStartDeploymentItems.isNumOfBatchesSet()) {
                retVal.setNumOfBatches(elastigroupStartDeploymentItems.getNumOfBatches());
            }

            if (elastigroupStartDeploymentItems.isProgressSet()) {
                retVal.setProgress(toDal(elastigroupStartDeploymentItems.getProgress()));
            }
        }

        return retVal;
    }

    private static ApiElastigroupStopDeploymentResponse toDal(
            ElastigroupStopDeploymentResponse elastigroupStopDeploymentItems) {
        ApiElastigroupStopDeploymentResponse retVal = null;

        if (elastigroupStopDeploymentItems != null) {
            retVal = new ApiElastigroupStopDeploymentResponse();

            if (elastigroupStopDeploymentItems.isIdSet()) {
                retVal.setId(elastigroupStopDeploymentItems.getId());
            }

            if (elastigroupStopDeploymentItems.isStatusSet()) {
                retVal.setStatus(elastigroupStopDeploymentItems.getStatus());
            }

            if (elastigroupStopDeploymentItems.isProgressSet()) {
                retVal.setProgress(toDal(elastigroupStopDeploymentItems.getProgress()));
            }
        }

        return retVal;
    }


    private static ApiElastigroupDeploymentProgress toDal(
            ElastigroupDeploymentProgress elastigroupStartDeploymentProgress) {
        ApiElastigroupDeploymentProgress retVal = null;

        if (elastigroupStartDeploymentProgress != null) {
            retVal = new ApiElastigroupDeploymentProgress();

            if (elastigroupStartDeploymentProgress.isUnitSet()) {
                retVal.setUnit(elastigroupStartDeploymentProgress.getUnit());
            }

            if (elastigroupStartDeploymentProgress.isValueSet()) {
                retVal.setValue(elastigroupStartDeploymentProgress.getValue());
            }

        }

        return retVal;
    }

    public static ApiElastigroupDeploymentRoll toDal(ElastigroupDeploymentRoll elastigroupStopDeployment) {
        ApiElastigroupDeploymentRoll retVal = null;

        if (elastigroupStopDeployment != null) {

            retVal = new ApiElastigroupDeploymentRoll();

            if (elastigroupStopDeployment.isStatusSet()) {
                retVal.setStatus(elastigroupStopDeployment.getStatus());
            }
        }
        return retVal;
    }

    public static ApiElastigroupImportEC2Instance toDal(ElastigroupImportEC2Instance elastigroupImportInstance) {
        ApiElastigroupImportEC2Instance retVal = null;

        if (elastigroupImportInstance != null) {

            retVal = new ApiElastigroupImportEC2Instance();

            if (elastigroupImportInstance.isNameSet()) {
                retVal.setName(elastigroupImportInstance.getName());
            }

            if (elastigroupImportInstance.isSpotInstanceTypesSet()) {
                retVal.setSpotInstanceTypes(elastigroupImportInstance.getSpotInstanceTypes());
            }

        }

        return retVal;
    }

    public static ApiElastigroupUpdateCapacityConfiguration toDal(ElastigroupUpdateCapacityConfiguration elastigroupUpdateCapacity) {
        ApiElastigroupUpdateCapacityConfiguration retVal = null;

        if (elastigroupUpdateCapacity != null) {

            retVal = new ApiElastigroupUpdateCapacityConfiguration();

            if (elastigroupUpdateCapacity.isMaximumSet()) {
                retVal.setMaximum(elastigroupUpdateCapacity.getMaximum());
            }

            if (elastigroupUpdateCapacity.isMinimumSet()) {
                retVal.setMinimum(elastigroupUpdateCapacity.getMinimum());
            }

            if (elastigroupUpdateCapacity.isTargetSet()) {
                retVal.setTarget(elastigroupUpdateCapacity.getTarget());
            }

        }

        return retVal;
    }

    public static ApiImportASG toDal(ImportASG importASG) {
        ApiImportASG retVal = null;

        if (importASG != null) {

            retVal = new ApiImportASG();

            if (importASG.isProductSet()) {
                retVal.setProduct(importASG.getProduct());
            }

            if (importASG.isSpotInstanceTypesSet()) {
                retVal.setSpotInstanceTypes(importASG.getSpotInstanceTypes());
            }

            if (importASG.isNameSet()) {
                retVal.setName(importASG.getName());
            }

            if (importASG.isAvailabilityVsCostSet()) {
                retVal.setAvailabilityVsCost(importASG.getAvailabilityVsCost());
            }

        }

        return retVal;
    }

    public static ApiGetSuggestedInstanceType toDal(GetSuggestedInstanceType suggestedInstanceType) {
        ApiGetSuggestedInstanceType apisuggestedInstanceType = null;

        if (suggestedInstanceType != null) {
            apisuggestedInstanceType = new ApiGetSuggestedInstanceType();

            if (suggestedInstanceType.isRegionSet()) {
                apisuggestedInstanceType.setRegion(suggestedInstanceType.getRegion());
            }
            if (suggestedInstanceType.isBaselineInstanceTypeSet() && suggestedInstanceType.getBaselineInstanceType() != null) {
                apisuggestedInstanceType.setBaselineInstanceType(suggestedInstanceType.getBaselineInstanceType());
            }
            if (suggestedInstanceType.isRequiredVCpuSet() && suggestedInstanceType.getRequiredVCpu() != null) {
                apisuggestedInstanceType.setRequiredVCpu(toDal(suggestedInstanceType.getRequiredVCpu()));
            }
            if (suggestedInstanceType.isRequiredMemoryGibSet() && suggestedInstanceType.getRequiredMemoryGib() != null) {
                apisuggestedInstanceType.setRequiredMemoryGib(toDal(suggestedInstanceType.getRequiredMemoryGib()));
            }
        }

        return apisuggestedInstanceType;
    }

    private static ApiRequiredVCpuRequiredMemoryGib toDal(RequiredVCpuRequiredMemoryGib requiredVCpuMemory) {
        ApiRequiredVCpuRequiredMemoryGib retVal = null;

        if (requiredVCpuMemory != null) {

            retVal = new ApiRequiredVCpuRequiredMemoryGib();

            if (requiredVCpuMemory.isMinimumSet()) {
                retVal.setMinimum(requiredVCpuMemory.getMinimum());
            }

            if (requiredVCpuMemory.isMaximumSet()) {
                retVal.setMaximum(requiredVCpuMemory.getMaximum());
            }
        }

        return retVal;
    }

    public static ApiElastigroupEcsInitiateRoll toDal(ElastigroupEcsInitiateRoll initiateRollRequest) {
        ApiElastigroupEcsInitiateRoll retval = null;

        if (initiateRollRequest != null) {
            retval = new ApiElastigroupEcsInitiateRoll();

            if (initiateRollRequest.isBatchSizePercentageSet()) {
                retval.setBatchSizePercentage(initiateRollRequest.getBatchSizePercentage());
            }

            if (initiateRollRequest.isCommentSet()) {
                retval.setComment(initiateRollRequest.getComment());
            }

            if (initiateRollRequest.isBatchMinHealthyPercentageSet()) {
                retval.setBatchMinHealthyPercentage(initiateRollRequest.getBatchMinHealthyPercentage());
            }
        }

        return retval;
    }

    //endregion

    //region DAL -> BL
    public static Elastigroup toBl(ApiElastigroup apiElastigroup) {
        Elastigroup elastigroup = null;

        if (apiElastigroup != null) {
            Elastigroup.Builder elastigroupBuilder = Elastigroup.Builder.get();

            if (apiElastigroup.isIdSet()) {
                elastigroupBuilder.setId(apiElastigroup.getId());
            }
            if (apiElastigroup.isNameSet()) {
                elastigroupBuilder.setName(apiElastigroup.getName());
            }

            if (apiElastigroup.isDescriptionSet()) {
                elastigroupBuilder.setDescription(apiElastigroup.getDescription());
            }

            if (apiElastigroup.isRegionSet()) {
                elastigroupBuilder.setRegion(apiElastigroup.getRegion());
            }

            if (apiElastigroup.isCapacitySet()) {
                elastigroupBuilder.setCapacity(toBl(apiElastigroup.getCapacity()));
            }

            if (apiElastigroup.isScalingSet()) {
                elastigroupBuilder.setScaling(toBl(apiElastigroup.getScaling()));
            }

            if (apiElastigroup.isStrategySet()) {
                elastigroupBuilder.setStrategy(toBl(apiElastigroup.getStrategy()));
            }
            if (apiElastigroup.isComputeSet()) {
                elastigroupBuilder.setCompute(toBl(apiElastigroup.getCompute()));
            }
            if (apiElastigroup.isThirdPartiesIntegrationSet()) {
                elastigroupBuilder.setThirdPartiesIntegration(toBl(apiElastigroup.getThirdPartiesIntegration()));
            }
            if (apiElastigroup.isSchedulingSet()) {
                elastigroupBuilder.setScheduling(toBl(apiElastigroup.getScheduling()));
            }
            elastigroup = elastigroupBuilder.build();

            // createdAt is not taken from builder since it cannot be set when creating/updating an Elastigroup
            if (apiElastigroup.isCreatedAtSet()) {
                elastigroup.setCreatedAt(apiElastigroup.getCreatedAt());
            }
        }

        return elastigroup;
    }

    private static ElastigroupSchedulingConfiguration toBl(ApiElastigroupScheduling apiScheduling) {
        ElastigroupSchedulingConfiguration blSchedulingConfiguration = null;

        if (apiScheduling != null) {
            ElastigroupSchedulingConfiguration.Builder blSchedulingConfigurationBuilder =
                    ElastigroupSchedulingConfiguration.Builder.get();
            if (apiScheduling.isTasksSet()) {
                if (apiScheduling.getTasks() != null) {
                    List<TasksConfiguration> tasksConfigurationList =
                            apiScheduling.getTasks().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    blSchedulingConfigurationBuilder.setTasks(tasksConfigurationList);
                }
            }
            blSchedulingConfiguration = blSchedulingConfigurationBuilder.build();
        }
        return blSchedulingConfiguration;
    }

    private static TasksConfiguration toBl(ApiElastigroupScheduledTask apiScheduledTask) {
        TasksConfiguration bLTasks = null;

        if (apiScheduledTask != null) {
            TasksConfiguration.Builder blTasksBuilder = TasksConfiguration.Builder.get();
            if (apiScheduledTask.isIsEnabledSet()) {
                blTasksBuilder.setIsEnabled(apiScheduledTask.getIsEnabled());
            }
            if (apiScheduledTask.isFrequencySet()) {
                blTasksBuilder.setFrequency(RecurrenceFrequencyEnum.fromName(apiScheduledTask.getFrequency()));
            }
            if (apiScheduledTask.isStartTimeSet()) {
                blTasksBuilder.setStartTime(apiScheduledTask.getStartTime());
            }
            if (apiScheduledTask.isCronExpressionSet()) {
                blTasksBuilder.setCronExpression(apiScheduledTask.getCronExpression());
            }
            if (apiScheduledTask.isTaskTypeSet()) {
                blTasksBuilder.setTaskType(SchedulingTaskTypeEnum.fromName(apiScheduledTask.getTaskType()));
            }
            if (apiScheduledTask.isScaleTargetCapacitySet()) {
                blTasksBuilder.setScaleTargetCapacity(apiScheduledTask.getScaleTargetCapacity());
            }
            if (apiScheduledTask.isScaleMinCapacitySet()) {
                blTasksBuilder.setScaleMinCapacity(apiScheduledTask.getScaleMinCapacity());
            }
            if (apiScheduledTask.isScaleMaxCapacitySet()) {
                blTasksBuilder.setScaleMaxCapacity(apiScheduledTask.getScaleMaxCapacity());
            }
            if (apiScheduledTask.isBatchSizePercentageSet()) {
                blTasksBuilder.setBatchSizePercentage(apiScheduledTask.getBatchSizePercentage());
            }
            if (apiScheduledTask.isgracePeriodSet()) {
                blTasksBuilder.setGracePeriod(apiScheduledTask.getGracePeriod());
            }
            if (apiScheduledTask.isAdjustmentSet()) {
                blTasksBuilder.setAdjustment(apiScheduledTask.getAdjustment());
            }
            if (apiScheduledTask.isAdjustmentPercentageSet()) {
                blTasksBuilder.setAdjustmentPercentage(apiScheduledTask.getAdjustmentPercentage());
            }
            if (apiScheduledTask.isTargetCapacitySet()) {
                blTasksBuilder.setTargetCapacity(apiScheduledTask.getTargetCapacity());
            }
            if (apiScheduledTask.isMinCapacitySet()) {
                blTasksBuilder.setMinCapacity(apiScheduledTask.getMinCapacity());
            }
            if (apiScheduledTask.isMaxCapacitySet()) {
                blTasksBuilder.setMaxCapacity(apiScheduledTask.getMaxCapacity());
            }

            bLTasks = blTasksBuilder.build();
        }
        return bLTasks;
    }

    private static ElastigroupThirdPartiesIntegrationConfiguration toBl(
            ApiThirdPartiesIntegration apiThirdPartiesIntegration) {
        ElastigroupThirdPartiesIntegrationConfiguration blThirdPartiesIntegration = null;

        if (apiThirdPartiesIntegration != null) {
            ElastigroupThirdPartiesIntegrationConfiguration.Builder blThirdPartiesIntegrationBuilder =
                    ElastigroupThirdPartiesIntegrationConfiguration.Builder.get();

            if (apiThirdPartiesIntegration.isEcsSet()) {
                blThirdPartiesIntegrationBuilder.setEcs(toBl(apiThirdPartiesIntegration.getEcs()));
            }

            if (apiThirdPartiesIntegration.isCodeDeploySet()) {
                blThirdPartiesIntegrationBuilder.setCodeDeploy(toBl(apiThirdPartiesIntegration.getCodeDeploy()));
            }

            if (apiThirdPartiesIntegration.isElasticBeanstalkSet()) {
                blThirdPartiesIntegrationBuilder.setElasticBeanstalk(toBl(apiThirdPartiesIntegration.getElasticBeanstalk()));
            }
            blThirdPartiesIntegration = blThirdPartiesIntegrationBuilder.build();
        }
        return blThirdPartiesIntegration;
    }

    private static ElastigroupCodeDeploy toBl(ApiCodeDeploy apiCodeDeploy) {
        ElastigroupCodeDeploy blCodeDeploy = null;

        if (apiCodeDeploy != null) {
            ElastigroupCodeDeploy.Builder blCodeDeployBuilder = ElastigroupCodeDeploy.Builder.get();
            if (apiCodeDeploy.isCleanUpOnFailureSet()) {
                blCodeDeployBuilder.setCleanUpOnFailure(apiCodeDeploy.getCleanUpOnFailure());
            }

            if (apiCodeDeploy.isTerminateInstanceOnFailureSet()) {
                blCodeDeployBuilder.setTerminateInstanceOnFailure(apiCodeDeploy.getTerminateInstanceOnFailure());
            }

            if (apiCodeDeploy.isDeploymentGroupsSet()) {
                if (apiCodeDeploy.getDeploymentGroups() != null) {
                    List<ElastigroupDeploymentGroup> deploymentGroups =
                            apiCodeDeploy.getDeploymentGroups().stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                    blCodeDeployBuilder.setDeploymentGroups(deploymentGroups);
                }
            }
            blCodeDeploy = blCodeDeployBuilder.build();
        }

        return blCodeDeploy;
    }

    private static ElasticBeanstalk toBl(ApiElasticBeanstalk apiBeanstalk) {
        ElasticBeanstalk blBeanstalk = null;

        if (apiBeanstalk != null) {
            ElasticBeanstalk.Builder blBeanstalkBuilder = ElasticBeanstalk.Builder.get();
            if (apiBeanstalk.isEnvironmentIdSet()) {
                blBeanstalkBuilder.setEnvironmentId(apiBeanstalk.getEnvironmentId());
            }
            if (apiBeanstalk.isDeploymentPreferencesSet()) {
                if (apiBeanstalk.getDeploymentPreferences() != null) {
                    blBeanstalkBuilder.setDeploymentPreferences(toBl(apiBeanstalk.getDeploymentPreferences()));
                }
            }
            if (apiBeanstalk.isManagedActionsSet()) {
                if (apiBeanstalk.getManagedActions() != null) {
                    blBeanstalkBuilder.setManagedActions(toBl(apiBeanstalk.getManagedActions()));
                }
            }
            blBeanstalk = blBeanstalkBuilder.build();
        }
        return blBeanstalk;
    }

    private static ElastigroupDeploymentPreferences toBl(ApiElastigroupDeploymentPreferences apiDeploymentPreferences) {
        ElastigroupDeploymentPreferences blDeploymentPreference = null;

        if (apiDeploymentPreferences != null) {
            ElastigroupDeploymentPreferences.Builder blDeploymentPreferenceBuilder = ElastigroupDeploymentPreferences.Builder.get();
            if (apiDeploymentPreferences.isAutomaticRollSet()) {
                blDeploymentPreferenceBuilder.setAutomaticRoll(apiDeploymentPreferences.getAutomaticRoll());
            }
            if (apiDeploymentPreferences.isBatchSizePercentageSet()) {
                blDeploymentPreferenceBuilder.setBatchSizePercentage(apiDeploymentPreferences.getBatchSizePercentage());
            }
            if (apiDeploymentPreferences.isGracePeriodSet()) {
                blDeploymentPreferenceBuilder.setGracePeriod(apiDeploymentPreferences.getGracePeriod());
            }
            if (apiDeploymentPreferences.isStrategySet()) {
                if (apiDeploymentPreferences.getStrategy() != null) {
                    blDeploymentPreferenceBuilder.setStrategy(toBl(apiDeploymentPreferences.getStrategy()));
                }
            }
            blDeploymentPreference = blDeploymentPreferenceBuilder.build();
        }
        return blDeploymentPreference;
    }

    private static BeanstalkStrategy toBl(ApiBeanstalkStrategy apiStrategy) {
        BeanstalkStrategy blStrategy = null;

        if (apiStrategy != null) {
            BeanstalkStrategy.Builder blStrategyBuilder = BeanstalkStrategy.Builder.get();
            if (apiStrategy.isActionSet()) {
                blStrategyBuilder.setAction(apiStrategy.getAction());
            }
            if (apiStrategy.isShouldDrainInstancesSet()) {
                blStrategyBuilder.setShouldDrainInstances(apiStrategy.getShouldDrainInstances());
            }
            blStrategy = blStrategyBuilder.build();
        }
        return blStrategy;
    }

    private static ManagedActions toBl(ApiManagedActions apiManagedActions) {
        ManagedActions blManagedActions = null;

        if (apiManagedActions != null) {
            ManagedActions.Builder blManagedActionsBuilder = ManagedActions.Builder.get();
            if (apiManagedActions.isPlatformUpdateSet()) {
                if (apiManagedActions.getPlatformUpdate() != null) {
                    blManagedActionsBuilder.setPlatformUpdate(toBl(apiManagedActions.getPlatformUpdate()));
                }
            }
            blManagedActions = blManagedActionsBuilder.build();
        }
        return blManagedActions;
    }

    private static BeanstalkPlatformUpdate toBl(ApiBeanstalkPlatformUpdate apiPlatformUpdate) {
        BeanstalkPlatformUpdate blBeanstalkPlatformUpdate = null;

        if (apiPlatformUpdate != null) {
            BeanstalkPlatformUpdate.Builder blBeanstalkPlatformUpdateBuilder = BeanstalkPlatformUpdate.Builder.get();
            if (apiPlatformUpdate.isInstanceRefreshEnabledSet()) {
                blBeanstalkPlatformUpdateBuilder.setInstanceRefreshEnabled(apiPlatformUpdate.getInstanceRefreshEnabled());
            }
            if (apiPlatformUpdate.isPerformAtSet()) {
                blBeanstalkPlatformUpdateBuilder.setPerformAt(apiPlatformUpdate.getPerformAt());
            }
            if (apiPlatformUpdate.isTimeWindowSet()) {
                blBeanstalkPlatformUpdateBuilder.setTimeWindow(apiPlatformUpdate.getTimeWindow());
            }
            if (apiPlatformUpdate.isUpdateLevelSet()) {
                blBeanstalkPlatformUpdateBuilder.setUpdateLevel(apiPlatformUpdate.getUpdateLevel());
            }
            blBeanstalkPlatformUpdate = blBeanstalkPlatformUpdateBuilder.build();
        }
        return blBeanstalkPlatformUpdate;
    }

    private static ElastigroupDeploymentGroup toBl(ApiDeploymentGroup apiDeploymentGroup) {
        ElastigroupDeploymentGroup blDeploymentGroups = null;

        if (apiDeploymentGroup != null) {
            ElastigroupDeploymentGroup.Builder blDeploymentGroupsBuilder = ElastigroupDeploymentGroup.Builder.get();

            if (apiDeploymentGroup.isApplicationNameSet()) {
                blDeploymentGroupsBuilder.setApplicationName(apiDeploymentGroup.getApplicationName());
            }

            if (apiDeploymentGroup.isDeploymentGroupNameSet()) {
                blDeploymentGroupsBuilder.setDeploymentGroupName(apiDeploymentGroup.getDeploymentGroupName());
            }

            blDeploymentGroups = blDeploymentGroupsBuilder.build();
        }

        return blDeploymentGroups;
    }

    private static ElastigroupOptimizeImages toBl(ApiOptimizeImages apiOptimizeImages) {
        ElastigroupOptimizeImages blOptimizeImages = null;

        if (apiOptimizeImages != null) {
            ElastigroupOptimizeImages.Builder blOptimizeImagesBuilder = ElastigroupOptimizeImages.Builder.get();
            if (apiOptimizeImages.isShouldOptimizeEcsAmiSet()) {
                blOptimizeImagesBuilder.setShouldOptimizeEcsAmi(apiOptimizeImages.getShouldOptimizeEcsAmi());
            }
            if (apiOptimizeImages.isTimeWindowSet()) {
                if (apiOptimizeImages.getTimeWindows() != null) {
                    blOptimizeImagesBuilder.setTimeWindow(new LinkedList<>(apiOptimizeImages.getTimeWindows()));
                }
            }
            if (apiOptimizeImages.isPerformAtSet()) {
                blOptimizeImagesBuilder
                        .setPerformAt(MaintenanceWindowTypeEnum.fromName(apiOptimizeImages.getPerformAt()));
            }
            blOptimizeImages = blOptimizeImagesBuilder.build();
        }
        return blOptimizeImages;
    }

    private static ElastigroupEcsSpecification toBl(ApiEcs apiEcs) {
        ElastigroupEcsSpecification blEcs = null;

        if (apiEcs != null) {
            ElastigroupEcsSpecification.Builder blEcsBuilder = ElastigroupEcsSpecification.Builder.get();

            if (apiEcs.isClusterNameSet()) {
                blEcsBuilder.setClusterName(apiEcs.getClusterName());
            }
            if (apiEcs.isAutoScaleSet()) {
                blEcsBuilder.setAutoScale(toBl(apiEcs.getAutoScale()));
            }
            if (apiEcs.isOptimizeImagesSet()) {
                blEcsBuilder.setOptimizeImages(toBl(apiEcs.getOptimizeImages()));
            }
            if (apiEcs.isApiBatchSet()) {
                blEcsBuilder.setBatch(toBl(apiEcs.getBatch()));
            }
            blEcs = blEcsBuilder.build();
        }
        return blEcs;
    }

    private static ElastigroupEcsBatch toBl(ApiBatch apiBatch) {
        ElastigroupEcsBatch retVal = null;

        if (apiBatch != null) {
            ElastigroupEcsBatch.Builder blEcsBuilder = ElastigroupEcsBatch.Builder.get();
            if (apiBatch.isJobQueueNamesSet()) {
                if (apiBatch.getJobQueueNames() != null) {
                    blEcsBuilder.setJobQueueNames(new LinkedList<>(apiBatch.getJobQueueNames()));
                }
            }
            retVal = blEcsBuilder.build();
        }
        return retVal;
    }

    private static ElastigroupAttributesSpecification toBl(ApiAttributes apiAttributes) {
        ElastigroupAttributesSpecification blAttributes = null;

        if (apiAttributes != null) {
            ElastigroupAttributesSpecification.Builder blAttributesBuilder =
                    ElastigroupAttributesSpecification.Builder.get();

            if (apiAttributes.isKeySet()) {
                blAttributesBuilder.setkey(apiAttributes.getKey());
            }
            if (apiAttributes.isValueSet()) {
                blAttributesBuilder.setValue(apiAttributes.getValue());
            }
            blAttributes = blAttributesBuilder.build();
        }
        return blAttributes;
    }

    private static ElastigroupAutoScaleSpecification toBl(ApiAutoScale apiAutoScale) {
        ElastigroupAutoScaleSpecification blAutoScale = null;

        if (apiAutoScale != null) {
            ElastigroupAutoScaleSpecification.Builder blAutoScaleBuilder =
                    ElastigroupAutoScaleSpecification.Builder.get();

            if (apiAutoScale.isShouldScaleDownNonServiceTasksSet()) {
                blAutoScaleBuilder.setShouldScaleDownNonServiceTasks(apiAutoScale.getShouldScaleDownNonServiceTasks());
            }
            if (apiAutoScale.isIsEnabledSet()) {
                blAutoScaleBuilder.setIsEnabled(apiAutoScale.getIsEnabled());
            }
            if (apiAutoScale.isIsAutoConfigSet()) {
                blAutoScaleBuilder.setIsAutoConfig(apiAutoScale.getIsAutoConfig());
            }
            if (apiAutoScale.isHeadroomSet()) {
                blAutoScaleBuilder.setHeadroom(toBl(apiAutoScale.getHeadroom()));
            }
            if (apiAutoScale.isDownSet()) {
                blAutoScaleBuilder.setDown(toBl(apiAutoScale.getDown()));
            }
            if (apiAutoScale.isCooldownSet()) {
                blAutoScaleBuilder.setCooldown(apiAutoScale.getCooldown());
            }
            if (apiAutoScale.isAttributesSet()) {
                if (apiAutoScale.getAttributes() != null) {
                    List<ElastigroupAttributesSpecification> attributesSpecificationList =
                            apiAutoScale.getAttributes().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    blAutoScaleBuilder.setAttributes(attributesSpecificationList);
                }
            }
            blAutoScale = blAutoScaleBuilder.build();
        }
        return blAutoScale;
    }

    private static ElastigroupHeadroomSpecification toBl(ApiHeadroom apiHeadroom) {
        ElastigroupHeadroomSpecification blHeadroom = null;

        if (apiHeadroom != null) {
            ElastigroupHeadroomSpecification.Builder blHeadroomBuilder = ElastigroupHeadroomSpecification.Builder.get();

            if (apiHeadroom.isCpuPerUnitSet()) {
                blHeadroomBuilder.setCpuPerUnit(apiHeadroom.getCpuPerUnit());
            }
            if (apiHeadroom.isMemoryPerUnitSet()) {
                blHeadroomBuilder.setMemoryPerUnit(apiHeadroom.getMemoryPerUnit());
            }
            if (apiHeadroom.isNumOfUnitsSet()) {
                blHeadroomBuilder.setNumOfUnits(apiHeadroom.getNumOfUnits());
            }
            blHeadroom = blHeadroomBuilder.build();
        }
        return blHeadroom;
    }

    private static ElastigroupDownSpecification toBl(ApiDown apidown) {
        ElastigroupDownSpecification blDown = null;

        if (apidown != null) {
            ElastigroupDownSpecification.Builder blDownBuilder = ElastigroupDownSpecification.Builder.get();

            if (apidown.isEvaluationPeriodsSet()) {
                blDownBuilder.setEvaluationPeriods(apidown.getEvaluationPeriods());
            }
            if (apidown.isMaxScaleDownPercentageSet()) {
                blDownBuilder.setMaxScaleDownPercentage(apidown.getMaxScaleDownPercentage());
            }
            blDown = blDownBuilder.build();
        }
        return blDown;
    }

    private static ElastigroupComputeConfiguration toBl(ApiGroupCompute compute) {
        ElastigroupComputeConfiguration blCompute = null;

        if (compute != null) {
            ElastigroupComputeConfiguration.Builder blComputeBuilder = ElastigroupComputeConfiguration.Builder.get();

            if (compute.isInstanceTypesSet()) {
                blComputeBuilder.setInstanceTypes(toBl(compute.getInstanceTypes()));
            }

            if (compute.isAvailabilityZonesSet()) {
                if (compute.getAvailabilityZones() != null) {
                    List<Placement> placements = compute.getAvailabilityZones().stream().map(ElastigroupConverter::toBl)
                            .collect(Collectors.toList());
                    blComputeBuilder.setAvailabilityZones(placements);
                }
            }

            if (compute.isProductSet()) {
                blComputeBuilder.setProduct(compute.getProduct());
            }
            if (compute.isLaunchSpecificationSet()) {
                blComputeBuilder.setLaunchSpecification(toBl(compute.getLaunchSpecification()));
            }

            if (compute.isElasticIpsSet()) {
                if (compute.getElasticIps() != null) {
                    blComputeBuilder.setElasticIps(new LinkedList<>(compute.getElasticIps()));
                }
            }

            if (compute.isEbsVolumePoolSet()) {
                if (compute.getEbsVolumePool() != null) {
                    List<ElastigroupEbsVolumePool> blVolumePool =
                            compute.getEbsVolumePool().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    blComputeBuilder.setEbsVolumePools(blVolumePool);
                }
            }

            if (compute.isPreferredAvailabilityZonesSet()) {
                if (compute.getPreferredAvailabilityZones() != null) {
                    blComputeBuilder.setPreferredAvailabilityZones(new LinkedList<>(compute.getPreferredAvailabilityZones()));
                }
            }

            if(compute.isPrivateIpsSet()){
                blComputeBuilder.setPrivateIps(compute.getPrivateIps());
            }

            if(compute.isSubnetIdsSet()){
                blComputeBuilder.setSubnetIds(compute.getSubnetIds());
            }

            blCompute = blComputeBuilder.build();
        }

        return blCompute;
    }

    private static ElastigroupEbsVolumePool toBl(ApiVolumePool volumePool) {
        ElastigroupEbsVolumePool retVal = null;

        if (volumePool != null) {
            ElastigroupEbsVolumePool.Builder retValBuilder = ElastigroupEbsVolumePool.Builder.get();
            if (volumePool.isDeviceNameSet()) {
                retValBuilder.setDeviceName(volumePool.getDeviceName());
            }

            if (volumePool.isVolumeIdsSet()) {
                if (volumePool.getVolumeIds() != null) {
                    retValBuilder.setVolumeIds(new LinkedList<>(volumePool.getVolumeIds()));
                }
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static Placement toBl(ApiPlacement placement) {
        Placement retVal = null;

        if (placement != null) {
            Placement.Builder retValBuilder = Placement.Builder.get();
            if (placement.isNameSet()) {
                retValBuilder.setAvailabilityZoneName(placement.getName());
            }

            if (placement.isSubnetIdsSet()) {
                if (placement.getSubnetIds() != null) {
                    retValBuilder.setSubnetIds(new LinkedList<>(placement.getSubnetIds()));
                }
            }

            if (placement.isPlacementGroupNameSet()) {
                if (placement.getPlacementGroupName() != null) {
                    retValBuilder.setPlacementGroupName(placement.getPlacementGroupName());
                }
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static GroupTagSpecification toBl(ApiGroupTagSpecification apiGroupTagSpecification) {
        GroupTagSpecification retVal = null;

        if (apiGroupTagSpecification != null) {
            retVal = new GroupTagSpecification();

            if (apiGroupTagSpecification.isShouldTagSet()) {
                retVal.setShouldTag(apiGroupTagSpecification.getShouldTag());
            }
        }
        return retVal;
    }

    private static GroupResourceTagSpecification toBl(ApiGroupResourceTagSpecification resourceTagSpecification) {
        GroupResourceTagSpecification retVal = null;

        if (resourceTagSpecification != null) {
            GroupResourceTagSpecification.Builder retValBuilder = GroupResourceTagSpecification.Builder.get();

            if (resourceTagSpecification.isVolumeSet()) {
                retValBuilder.setTagVolume(toBl(resourceTagSpecification.getVolumes()));
            }

            if (resourceTagSpecification.isSnapshotSet()) {
                retValBuilder.setTagSnapshot(toBl(resourceTagSpecification.getSnapshots()));
            }

            if (resourceTagSpecification.isAmiSet()) {
                retValBuilder.setTagAmis(toBl(resourceTagSpecification.getAmis()));
            }

            if (resourceTagSpecification.isEniSet()) {
                retValBuilder.setTagEnis(toBl(resourceTagSpecification.getEnis()));
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static ElastigroupLaunchSpecification toBl(ApiLaunchSpec launchSpecification) {
        ElastigroupLaunchSpecification retVal = null;

        if (launchSpecification != null) {

            ElastigroupLaunchSpecification.Builder retValBuilder = ElastigroupLaunchSpecification.Builder.get();

            if (launchSpecification.isResourceTagSpecificationSet()) {
                retValBuilder.setResourceTagSpecification(toBl(launchSpecification.getResourceTagSpecification()));
            }

            if (launchSpecification.isHealthCheckTypeSet()) {
                retValBuilder.setHealthCheckType(launchSpecification.getHealthCheckType());
            }

            if (launchSpecification.isAutoHealingSet()) {
                retValBuilder.setAutoHealing(launchSpecification.getAutoHealing());
            }

            if (launchSpecification.isHealthCheckGracePeriodSet()) {
                retValBuilder.setHealthCheckGracePeriod(launchSpecification.getHealthCheckGracePeriod());
            }

            if (launchSpecification.isSecurityGroupIdsSet()) {
                if (launchSpecification.getSecurityGroupIds() != null) {
                    retValBuilder.setSecurityGroupIds(new LinkedList<>(launchSpecification.getSecurityGroupIds()));
                }
            }

            if (launchSpecification.isMonitoringSet()) {
                retValBuilder.setDetailedMonitoring(launchSpecification.getMonitoring());
            }

            if (launchSpecification.isEbsOptimizedSet()) {
                retValBuilder.setEbsOptimized(launchSpecification.getEbsOptimized());
            }

            if (launchSpecification.isImageIdSet() && launchSpecification.getImageId() != null) {
                retValBuilder.setImageId(launchSpecification.getImageId());
            }

            if (launchSpecification.isImagesSet()) {
                if (launchSpecification.getImages() != null) {
                    List<Images> images = launchSpecification.getImages().stream().map(ElastigroupConverter::toBl)
                            .collect(Collectors.toList());
                    retValBuilder.setImages(images);
                }
            }

            if (launchSpecification.isHealthCheckUnhealthyDurationBeforeReplacementSet()) {
                retValBuilder.setHealthCheckUnhealthyDurationBeforeReplacement(launchSpecification.getHealthCheckUnhealthyDurationBeforeReplacement());
            }

            if (launchSpecification.isIamRoleSet()) {
                retValBuilder.setIamRole(toBl(launchSpecification.getIamRole()));
            }

            if (launchSpecification.isKeyPairSet()) {
                retValBuilder.setKeyPair(launchSpecification.getKeyPair());
            }

            if (launchSpecification.isUserDataSet()) {
                retValBuilder.setUserData(launchSpecification.getUserData());
            }

            if (launchSpecification.isShutdownScriptSet()) {
                retValBuilder.setShutdownScript(launchSpecification.getShutdownScript());
            }

            if (launchSpecification.isBlockDeviceMappingsSet()) {
                if (launchSpecification.getBlockDeviceMappings() != null) {
                    List<BlockDeviceMapping> blBDM =
                            launchSpecification.getBlockDeviceMappings().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    retValBuilder.setBlockDeviceMappings(blBDM);
                }
            }

            if (launchSpecification.isLoadBalancersConfigSet()) {
                if (launchSpecification.getLoadBalancersConfig() != null) {
                    retValBuilder.setLoadBalancersConfig(toBl(launchSpecification.getLoadBalancersConfig()));
                }
            }

            if (launchSpecification.isNetworkInterfacesSet()) {
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<NetworkInterface> blNIC =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    retValBuilder.setNetworkInterfaces(blNIC);
                }
            }

            if (launchSpecification.isTagsSet()) {
                if (launchSpecification.getTags() != null) {
                    List<Tag> tags = launchSpecification.getTags().stream().map(ElastigroupConverter::toBl)
                            .collect(Collectors.toList());
                    retValBuilder.setTags(tags);
                }
            }

            if (launchSpecification.isItfSet()) {
                retValBuilder.setItf(toBl(launchSpecification.getItf()));
            }

            if (launchSpecification.isCpuOptionsSet()) {
                retValBuilder.setCpuOptions(toBl(launchSpecification.getCpuOptions()));
            }

            if (launchSpecification.isMetadataOptionsSet()) {
                retValBuilder.setMetadataOptions(toBl(launchSpecification.getMetadataOptions()));
            }

            if (launchSpecification.isCreditSpecificationSet()) {
                retValBuilder.setCreditSpecification(toBl(launchSpecification.getCreditSpecification()));
            }

            retVal = retValBuilder.build();
        }


        return retVal;
    }

    private static ElastigroupItf toBl(ApiItf itf) {
        ElastigroupItf retVal = null;

        if (itf != null) {
            ElastigroupItf.Builder retValBuilder = ElastigroupItf.Builder.get();

            if (itf.isFixedTargetGroupsSet()) {
                retValBuilder.setFixedTargetGroups(itf.getFixedTargetGroups());
            }

            if (itf.isWeightStrategySet()) {
                retValBuilder.setWeightStrategy(itf.getWeightStrategy());
            }

            if (itf.isMigrationHealthinessThresholdSet()) {
                retValBuilder.setMigrationHealthinessThreshold(itf.getMigrationHealthinessThreshold());
            }

            if (itf.isTargetGroupConfigSet()) {
                retValBuilder.setTargetGroupConfig(toBl(itf.getTargetGroupConfig()));
            }

            if (itf.isLoadBalancersSet()) {
                if (itf.getLoadBalancers() != null) {
                    List<ElastigroupItfLoadBalancer> blItfLoadBalancers =
                            itf.getLoadBalancers().stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                    retValBuilder.setLoadBalancers(blItfLoadBalancers);
                }
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupItfLoadBalancer toBl(ApiItfLoadBalancer itfLoadBalancer) {
        ElastigroupItfLoadBalancer retVal = null;

        if (itfLoadBalancer != null) {
            ElastigroupItfLoadBalancer.Builder retValBuilder = ElastigroupItfLoadBalancer.Builder.get();

            if (itfLoadBalancer.isLoadBalancerArnSet()) {
                retValBuilder.setLoadBalancerArn(itfLoadBalancer.getLoadBalancerArn());
            }

            if (itfLoadBalancer.isListenerRulesSet()) {
                if (itfLoadBalancer.getListenerRules() != null) {
                    List<ElastigroupListenerRule> blListenerRules =
                            itfLoadBalancer.getListenerRules().stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                    retValBuilder.setListenerRules(blListenerRules);
                }
            }

            if(itfLoadBalancer.isDefaultStaticTargetGroupsSet()){

                List<DefaultStaticTargetGroups> defaultStaticTargetGroups =
                        itfLoadBalancer.getDefaultStaticTargetGroups().stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());

                retValBuilder.setDefaultStaticTargetGroups(defaultStaticTargetGroups);
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static DefaultStaticTargetGroups toBl(ApiDefaultStaticTargetGroups apiDefaultStaticTargetGroups){
        DefaultStaticTargetGroups retVal = null;

        if(apiDefaultStaticTargetGroups != null){
            retVal = new DefaultStaticTargetGroups();

            if(apiDefaultStaticTargetGroups.isArnSet()){
                retVal.setArn(apiDefaultStaticTargetGroups.getArn());
            }
            if(apiDefaultStaticTargetGroups.isPercentageSet()){
                retVal.setPercentage(apiDefaultStaticTargetGroups.getPercentage());
            }
        }
        return retVal;
    }

    private static ElastigroupListenerRule toBl(ApiListenerRule listenerRules) {
        ElastigroupListenerRule retVal = null;

        if (listenerRules != null) {
            ElastigroupListenerRule.Builder retValBuilder = ElastigroupListenerRule.Builder.get();

            if (listenerRules.isRuleArnSet()) {
                retValBuilder.setRuleArn(listenerRules.getRuleArn());
            }

            if(listenerRules.isStaticTargetGroupsSet()){
                List<StaticTargetGroups> staticTargetGroupsList =listenerRules.getStaticTargetGroups().stream().map(ElastigroupConverter::toBl)
                        .collect(Collectors.toList());
                retValBuilder.setStaticTargetGroups(staticTargetGroupsList);
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static StaticTargetGroups toBl(ApiStaticTargetGroups apiStaticTargetGroups){
        StaticTargetGroups retVal = null;
        if(apiStaticTargetGroups != null){
            StaticTargetGroups.Builder retValBuilder = StaticTargetGroups.Builder.get();

            if(apiStaticTargetGroups.isArnSet()){
                retVal.setArn(apiStaticTargetGroups.getArn());
            }

            if(apiStaticTargetGroups.isPercentageSet()){
                retVal.setPercentage(apiStaticTargetGroups.getPercentage());
            }
            retVal = retValBuilder.build();
        }
        return  retVal;
    }

    private static ElastigroupInstanceTypesWeights toBl(ApiInstanceTypesWeights weights) {
        ElastigroupInstanceTypesWeights retVal = null;

        if (weights != null) {
            ElastigroupInstanceTypesWeights.Builder retValBuilder = ElastigroupInstanceTypesWeights.Builder.get();

            if (weights.isInstanceTypeSet()) {
                retValBuilder.setInstanceType(weights.getInstanceType());
            }
            if (weights.isWeightedCapacitySet()) {
                retValBuilder.setWeightedCapacity(weights.getWeightedCapacity());
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupTargetGroupConfig toBl(ApiTargetGroupConfig targetGroupConfig) {

        ElastigroupTargetGroupConfig retVal = null;

        if (targetGroupConfig != null) {
            ElastigroupTargetGroupConfig.Builder retValBuilder = ElastigroupTargetGroupConfig.Builder.get();

            if (targetGroupConfig.isHealthCheckIntervalSecondsSet()) {
                retValBuilder.setHealthCheckIntervalSeconds(targetGroupConfig.getHealthCheckIntervalSeconds());
            }

            if (targetGroupConfig.isVpcIdSet()) {
                retValBuilder.setVpcId(targetGroupConfig.getVpcId());
            }

            if (targetGroupConfig.isHealthCheckPathSet()) {
                retValBuilder.setHealthCheckPath(targetGroupConfig.getHealthCheckPath());
            }

            if (targetGroupConfig.isHealthCheckPortSet()) {
                retValBuilder.setHealthCheckPort(targetGroupConfig.getHealthCheckPort());
            }

            if (targetGroupConfig.isHealthCheckProtocolSet()) {
                retValBuilder.setHealthCheckProtocol(targetGroupConfig.getHealthCheckProtocol());
            }

            if (targetGroupConfig.isHealthCheckTimeoutSecondsSet()) {
                retValBuilder.setHealthCheckTimeoutSeconds(targetGroupConfig.getHealthCheckTimeoutSeconds());
            }

            if (targetGroupConfig.isHealthyThresholdCountSet()) {
                retValBuilder.setHealthyThresholdCount(targetGroupConfig.getHealthyThresholdCount());
            }

            if (targetGroupConfig.isUnhealthyThresholdCountSet()) {
                retValBuilder.setUnhealthyThresholdCount(targetGroupConfig.getUnhealthyThresholdCount());
            }

            if (targetGroupConfig.isPortSet()) {
                retValBuilder.setPort(targetGroupConfig.getPort());
            }

            if (targetGroupConfig.isProtocolSet()) {
                retValBuilder.setProtocol(targetGroupConfig.getProtocol());
            }

            if (targetGroupConfig.isProtocolVersionSet()) {
                retValBuilder.setProtocolVersion(targetGroupConfig.getProtocolVersion());
            }

            if (targetGroupConfig.isMatcherSet()) {
                retValBuilder.setMatcher(toBl(targetGroupConfig.getMatcher()));
            }

            if (targetGroupConfig.isTagsSet()) {
                if (targetGroupConfig.getTags() != null) {
                    List<ElastigroupTargetGroupConfigTag> blItfTags = targetGroupConfig.getTags().stream().map(ElastigroupConverter::toBl)
                            .collect(Collectors.toList());
                    retValBuilder.setTags(blItfTags);
                }
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupMatcher toBl(ApiMatcher matcher) {
        ElastigroupMatcher retVal = null;

        if (matcher != null) {
            ElastigroupMatcher.Builder retValBuilder = ElastigroupMatcher.Builder.get();

            if (matcher.isGrpcCodeSet()) {
                retValBuilder.setGrpcCode(matcher.getGrpcCode());
            }

            if (matcher.isHttpCodeSet()) {
                retValBuilder.setHttpCode(matcher.getHttpCode());
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupTargetGroupConfigTag toBl(ApiTargetGroupConfigTag targetGroupConfigTag) {
        ElastigroupTargetGroupConfigTag retVal = null;

        if (targetGroupConfigTag != null) {
            ElastigroupTargetGroupConfigTag.Builder retValBuilder = ElastigroupTargetGroupConfigTag.Builder.get();

            if (targetGroupConfigTag.isTagKeySet()) {
                retValBuilder.setTagKey(targetGroupConfigTag.getTagKey());
            }

            if (targetGroupConfigTag.isTagValueSet()) {
                retValBuilder.setTagValue(targetGroupConfigTag.getTagValue());
            }
            retVal = retValBuilder.build();
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

    private static NetworkInterface toBl(ApiNetworkInterface networkInterface) {
        NetworkInterface retVal = null;

        if (networkInterface != null) {
            NetworkInterface.Builder retValBuilder = NetworkInterface.Builder.get();

            if (networkInterface.isDescriptionSet()) {
                retValBuilder.setDescription(networkInterface.getDescription());
            }

            if (networkInterface.isDeviceIndexSet()) {
                retValBuilder.setDeviceIndex(networkInterface.getDeviceIndex());
            }

            if (networkInterface.isSecondaryPrivateIpAddressCountSet()) {
                retValBuilder.setSecondaryPrivateIpAddressCount(networkInterface.getSecondaryPrivateIpAddressCount());
            }

            if (networkInterface.isAssociatePublicIpAddressSet()) {
                retValBuilder.setAssociatePublicIpAddress(networkInterface.getAssociatePublicIpAddress());
            }

            if (networkInterface.isDeleteOnTerminationSet()) {
                retValBuilder.setDeleteOnTermination(networkInterface.getDeleteOnTermination());
            }

            if (networkInterface.isNetworkInterfaceIdSet()) {
                retValBuilder.setNetworkInterfaceId(networkInterface.getNetworkInterfaceId());
            }

            if(networkInterface.isPrivateIpAddressesSet()){

                List<PrivateIpAddresses> ipAddress =
                        networkInterface.getPrivateIpAddresses().stream().map(ElastigroupConverter::toBl)
                                .collect(Collectors.toList());

                retValBuilder.setPrivateIpAddresses(ipAddress);
            }

            if(networkInterface.isAssociateIpv6AddressSet()){
                retValBuilder.setAssociateIpv6Address(networkInterface.getAssociateIpv6Address());
            }

            if(networkInterface.isSubnetIdSet()){
                retValBuilder.setSubnetId(networkInterface.getSubnetId());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static PrivateIpAddresses toBl(ApiPrivateIpAddresses apiPrivateIpAddresses){
        PrivateIpAddresses retVal = null;

        if(apiPrivateIpAddresses != null){
            PrivateIpAddresses.Builder privateIpAddresses = PrivateIpAddresses.Builder.get();

            if(apiPrivateIpAddresses.isPrimarySet()){
                privateIpAddresses.setPrimary(apiPrivateIpAddresses.getPrimary());
            }

            if(apiPrivateIpAddresses.isPrivateIpAddressSet()){
                privateIpAddresses.setPrivateIpAddress(apiPrivateIpAddresses.getPrivateIpAddress());
            }
            retVal = privateIpAddresses.build();
        }
        return retVal;
    }

    private static BlockDeviceMapping toBl(ApiBlockDevice blockDevice) {
        BlockDeviceMapping retVal = null;

        if (blockDevice != null) {

            BlockDeviceMapping.Builder retValBuilder = BlockDeviceMapping.Builder.get();

            if (blockDevice.isDeviceNameSet()) {
                retValBuilder.setDeviceName(blockDevice.getDeviceName());
            }

            if (blockDevice.isNoDeviceSet()) {
                retValBuilder.setNoDevice(blockDevice.getNoDevice());
            }

            if (blockDevice.isVirtualNameSet()) {
                retValBuilder.setVirtualName(blockDevice.getVirtualName());
            }

            if (blockDevice.isEbsSet()) {
                retValBuilder.setEbsDevice(toBl(blockDevice.getEbs()));
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static Images toBl(ApiImages apiImages) {
        Images retVal = null;

        if (apiImages != null) {

            Images.Builder retValBuilder = Images.Builder.get();

            if (apiImages.isIdSet()) {
                retValBuilder.setId(apiImages.getId());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static LoadBalancer toBl(ApiLoadBalancer loadBalancer) {
        LoadBalancer retVal = null;

        if (loadBalancer != null) {
            LoadBalancer.Builder retValBuilder = LoadBalancer.Builder.get();

            if (loadBalancer.isNameSet()) {
                retValBuilder.setName(loadBalancer.getName());
            }

            if (loadBalancer.isArnSet()) {
                retValBuilder.setArn(loadBalancer.getArn());
            }

            if (loadBalancer.isBalancerIdSet()) {
                retValBuilder.setBalancerId(loadBalancer.getBalancerId());
            }

            if (loadBalancer.isTargetSetIdSet()) {
                retValBuilder.setTargetSetId(loadBalancer.getTargetSetId());
            }

            if (loadBalancer.isAzAwarenessSet()) {
                retValBuilder.setAzAwareness(loadBalancer.getAzAwareness());
            }

            if (loadBalancer.isAutoWeightSet()) {
                retValBuilder.setAutoWeight(loadBalancer.getAutoWeight());
            }

            if (loadBalancer.isTypeSet()) {
                retValBuilder.setType(LbTypeEnum.fromName(loadBalancer.getType()));
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static EbsDevice toBl(ApiEbsDevice ebsDevice) {
        EbsDevice retVal = null;

        if (ebsDevice != null) {
            EbsDevice.Builder retValBuilder = EbsDevice.Builder.get();

            if (ebsDevice.isDeleteOnTerminationSet()) {
                retValBuilder.setDeleteOnTermination(ebsDevice.getDeleteOnTermination());
            }

            if (ebsDevice.isEncryptedSet()) {
                retValBuilder.setEncrypted(ebsDevice.getEncrypted());
            }

            if (ebsDevice.isIopsSet()) {
                retValBuilder.setIops(ebsDevice.getIops());
            }

            if (ebsDevice.isSnapshotIdSet()) {
                retValBuilder.setSnapshotId(ebsDevice.getSnapshotId());
            }

            if (ebsDevice.isVolumeSizeSet()) {
                retValBuilder.setVolumeSize(ebsDevice.getVolumeSize());
            }

            if (ebsDevice.isVolumeTypeSet()) {
                retValBuilder.setVolumeType(AwsVolumeTypeEnum.fromName(ebsDevice.getVolumeType()));
            }

            if (ebsDevice.isThroughputSet()) {
                retValBuilder.setThroughput(ebsDevice.getThroughput());
            }

            if(ebsDevice.isDynamicVolumeSizeSet()){
                DynamicVolumeSize dynamicVolumeSize = toBl(ebsDevice.getDynamicVolumeSize());
                retValBuilder.setDynamicVolumeSize(dynamicVolumeSize);
            }

            if(ebsDevice.isKmsKeyIdSet()){
                retValBuilder.setKmsKeyId(ebsDevice.getKmsKeyId());
            }

            if(ebsDevice.isDynamicIopsSet()){
                retValBuilder.setDynamicIops(toBl(ebsDevice.getDynamicIops()));
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static Dynamiclops toBl(ApiDynamiclops apiDynamiclops){
        Dynamiclops retVal = null;

        if(apiDynamiclops != null){
            Dynamiclops.Builder retValBuilder = Dynamiclops.Builder.get();

            if(apiDynamiclops.isBaseSizeSet()){
                retValBuilder.setBaseSize(apiDynamiclops.getBaseSize());
            }

            if(apiDynamiclops.isResourceSet()){
                retValBuilder.setResource(apiDynamiclops.getResource());
            }

            if(apiDynamiclops.isSizePerResourceUnitSet()){
                retValBuilder.setSizePerResourceUnit(apiDynamiclops.getSizePerResourceUnit());
            }
            retVal = retValBuilder.build();

        }
        return retVal;
    }

    private static DynamicVolumeSize toBl(ApiDynamicVolumeSize apiDynamicVolumeSize){
        DynamicVolumeSize retVal = null;

        if(apiDynamicVolumeSize != null){
            DynamicVolumeSize.Builder retValBuilder = DynamicVolumeSize.Builder.get();

            if(apiDynamicVolumeSize.isBaseSizeSet()){
                retValBuilder.setBaseSize(apiDynamicVolumeSize.getBaseSize());
            }

            if(apiDynamicVolumeSize.isResourceSet()){
                retValBuilder.setResource(apiDynamicVolumeSize.getResource());
            }

            if(apiDynamicVolumeSize.isSizePerResourceUnitSet()){
                retValBuilder.setSizePerResourceUnit(apiDynamicVolumeSize.getSizePerResourceUnit());
            }
            retVal = retValBuilder.build();

        }
        return retVal;
    }

    private static IamRole toBl(ApiIamRole iamRole) {
        IamRole retVal = null;

        if (iamRole != null) {
            IamRole.Builder retValBuilder = IamRole.Builder.get();

            if (iamRole.isNameSet()) {
                retValBuilder.setName(iamRole.getName());
            }

            if (iamRole.isArnSet()) {
                retValBuilder.setArn(iamRole.getArn());
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }


    private static CpuOptions toBl(ApiCpuOptions options) {
        CpuOptions retVal = null;

        if (options != null) {
            CpuOptions.Builder retValBuilder = CpuOptions.Builder.get();

            if (options.isThreadsPerCoreSet()) {
                retValBuilder.setThreadsPerCore(options.getThreadsPerCore());
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static MetadataOptions toBl(ApiMetadataOptions options) {
        MetadataOptions retVal = null;

        if (options != null) {
            MetadataOptions.Builder retValBuilder = MetadataOptions.Builder.get();

            if (options.isHttpPutResponseHopLimitSet()) {
                retValBuilder.setHttpPutResponseHopLimit(options.getHttpPutResponseHopLimit());
            }

            if (options.isHttpTokensSet()) {
                retValBuilder.setHttpTokens(options.getHttpTokens());
            }

            if (options.isInstanceMetadataTagsSet()) {
                retValBuilder.setInstanceMetadataTags(AwsInstanceMetadataTagsEnum.fromName(options.getInstanceMetadataTags()));
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static CreditSpecification toBl(ApiCreditSpecification spec) {
        CreditSpecification retVal = null;

        if (spec != null) {
            CreditSpecification.Builder retValBuilder = CreditSpecification.Builder.get();

            if (spec.isCpuCreditsSet()) {
                retValBuilder.setCpuCredits(AwsCpuCreditsEnum.fromName(spec.getCpuCredits()));
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static ElastigroupInstanceTypes toBl(ApiInstanceTypes instanceTypes) {
        ElastigroupInstanceTypes retVal = null;

        if (instanceTypes != null) {
            ElastigroupInstanceTypes.Builder retValBuilder = ElastigroupInstanceTypes.Builder.get();

            if (instanceTypes.isOndemandSet()) {
                retValBuilder.setOnDemandType(instanceTypes.getOndemand());
            }

            if (instanceTypes.isOnDemandTypesSet()) {
                if (instanceTypes.getOnDemandTypes() != null) {
                    retValBuilder.setOnDemandTypes(new LinkedList<>(instanceTypes.getOnDemandTypes()));
                }
            }

            if (instanceTypes.isSpotSet()) {
                if (instanceTypes.getSpot() != null) {
                    retValBuilder.setSpotTypes(new LinkedList<>(instanceTypes.getSpot()));
                }
            }

            if (instanceTypes.isPreferredSpotSet()) {
                if (instanceTypes.getPreferredSpot() != null) {
                    retValBuilder.setPreferredSpotTypes(new LinkedList<>(instanceTypes.getPreferredSpot()));
                }
            }

            if (instanceTypes.isWeightsSet()) {
                if (instanceTypes.getWeights() != null) {
                    List<ElastigroupInstanceTypesWeights> blWeights =
                            instanceTypes.getWeights().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    retValBuilder.setWeights(blWeights);
                }
            }

            if (instanceTypes.isResourceRequirementsSet()) {
                retValBuilder.setResourceRequirements(toBl(instanceTypes.getResourceRequirements()));
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ResourceRequirements toBl(ApiResourceRequirements requirements) {
        ResourceRequirements retVal = null;

        if (requirements != null) {
            ResourceRequirements.Builder retValBuilder = ResourceRequirements.Builder.get();

            if (requirements.isExcludedInstanceFamiliesSet()) {
                retValBuilder.setExcludedInstanceFamilies(new LinkedList<>(requirements.getExcludedInstanceFamilies()));
            }

            if (requirements.isExcludedInstanceGenerationsSet()) {
                retValBuilder.setExcludedInstanceGenerations(new LinkedList<>(requirements.getExcludedInstanceGenerations()));
            }

            if (requirements.isExcludedInstanceTypesSet()) {
                retValBuilder.setExcludedInstanceTypes(new LinkedList<>(requirements.getExcludedInstanceTypes()));
            }

            if (requirements.isRequiredGpuSet()) {
                retValBuilder.setRequiredGpu(toBl(requirements.getRequiredGpu()));
            }

            if (requirements.isRequiredMemorySet()) {
                retValBuilder.setRequiredMemory(toBl(requirements.getRequiredMemory()));
            }

            if (requirements.isRequiredVCpuSet()) {
                retValBuilder.setRequiredVCpu(toBl(requirements.getRequiredVCpu()));
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static RequiredVCpuMemoryGpu toBl(ApiRequiredVCpuMemoryGpu requiredVCpuMemory) {
        RequiredVCpuMemoryGpu retVal = null;

        if (requiredVCpuMemory != null) {
            RequiredVCpuMemoryGpu.Builder retValBuilder = RequiredVCpuMemoryGpu.Builder.get();

            if (requiredVCpuMemory.isMinimumSet()) {
                retValBuilder.setMinimum(requiredVCpuMemory.getMinimum());
            }

            if (requiredVCpuMemory.isMaximumSet()) {
                retValBuilder.setMaximum(requiredVCpuMemory.getMaximum());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }


    private static ElastigroupStrategyConfiguration toBl(ApiStrategy strategy) {
        ElastigroupStrategyConfiguration retVal = null;

        if (strategy != null) {
            ElastigroupStrategyConfiguration.Builder retValBuilder = ElastigroupStrategyConfiguration.Builder.get();
            if (strategy.isRiskSet()) {
                retValBuilder.setSpotPercentage(strategy.getRisk());
            }

            if (strategy.isOnDemandCountSet()) {
                retValBuilder.setOnDemandCount(strategy.getOnDemandCount());
            }

            if (strategy.isAvailabilityVsCostSet()) {
                retValBuilder.setElastigroupOrientation(
                        ElastigroupOrientationEnum.fromName(strategy.getAvailabilityVsCost()));
            }

            if (strategy.isDrainingTimeoutSet()) {
                retValBuilder.setDrainingTimeout(strategy.getDrainingTimeout());
            }

            if (strategy.isUtilizeReservedInstancesSet()) {
                retValBuilder.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }

            if (strategy.isUtilizeCommitmentsSet()) {
                retValBuilder.setUtilizeCommitments(strategy.getUtilizeCommitments());
            }

            if (strategy.isFallbackToOdSet()) {
                retValBuilder.setFallbackToOnDemand(strategy.getFallbackToOd());
            }

            if (strategy.isPersistenceSet()) {
                retValBuilder.setPersistence(toBl(strategy.getPersistence()));
            }

            if (strategy.isRevertToSpotSet()) {
                retValBuilder.setRevertToSpot(toBl(strategy.getRevertToSpot()));
            }

            if (strategy.isConsiderODPricingSet()) {
                retValBuilder.setConsiderODPricing(strategy.getConsiderODPricing());
            }

            if (strategy.isRestrictSingleAzSet()) {
                retValBuilder.setRestrictSingleAz(strategy.getRestrictSingleAz());
            }

            if(strategy.isSignalsSet()) {
                if(strategy.getSignals() != null) {
                    List<StrategySignal> signals = strategy.getSignals().stream().map(ElastigroupConverter::toBl)
                            .collect(Collectors.toList());
                    retValBuilder.setSignals(signals);
                }
            }

            if (strategy.isScalingStrategySet()) {
                retValBuilder.setScalingStrategy(toBl(strategy.getScalingStrategy()));
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupRevertToSpot toBl(ApiRevertToSpot apiRevertToSpot) {
        ElastigroupRevertToSpot retVal = null;

        if (apiRevertToSpot != null) {
            ElastigroupRevertToSpot.Builder retValBuilder = ElastigroupRevertToSpot.Builder.get();

            if (apiRevertToSpot.isPerformAtSet()) {
                retValBuilder.setPerformAt(apiRevertToSpot.getPerformAt());
            }

            if (apiRevertToSpot.isTimeWindowSet()) {
                if (apiRevertToSpot.getTimeWindows() != null) {
                    retValBuilder.setTimeWindows(new LinkedList<>(apiRevertToSpot.getTimeWindows()));
                }
            }

            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static ElastigroupPersistenceConfiguration toBl(ApiGroupPersistence persistence) {
        ElastigroupPersistenceConfiguration retVal = null;

        if (persistence != null) {
            retVal = new ElastigroupPersistenceConfiguration();

            if (persistence.isBlockDevicesModeSet()) {
                retVal.setBlockDevicesMode(persistence.getBlockDevicesMode());
            }

            if (persistence.isShouldPersistBlockDevicesSet()) {
                retVal.setShouldPersistBlockDevices(persistence.getShouldPersistBlockDevices());
            }

            if (persistence.isShouldPersistPrivateIpSet()) {
                retVal.setShouldPersistPrivateIp(persistence.getShouldPersistPrivateIp());
            }

            if (persistence.isShouldPersistRootDeviceSet()) {
                retVal.setShouldPersistRootDevice(persistence.getShouldPersistRootDevice());
            }
        }

        return retVal;
    }

    private static StrategySignal toBl(ApiStrategySignal signal) {
        StrategySignal retVal = null;

        if (signal != null) {
            StrategySignal.Builder builder = StrategySignal.Builder.get();


            if (signal.isNameSet()) {
                builder.setName(signal.getName());
            }

            if (signal.isTimeoutSet()) {
                builder.setTimeout(signal.getTimeout());
            }

            retVal = builder.build();
        }

        return retVal;
    }

    private static ScalingStrategy toBl(ApiScalingStrategy scalingStrategy) {
        ScalingStrategy retVal = null;

        if (scalingStrategy != null) {
            ScalingStrategy.Builder retValBuilder = ScalingStrategy.Builder.get();

            if (scalingStrategy.isTerminationPolicySet()) {
                retValBuilder.setTerminationPolicy(AwsTerminationPolicyEnum.fromName(scalingStrategy.getTerminationPolicy()));
            }

            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static ElastigroupCapacityConfiguration toBl(ApiCapacity capacity) {
        ElastigroupCapacityConfiguration retVal = null;

        if (capacity != null) {
            ElastigroupCapacityConfiguration.Builder retValBuilder = ElastigroupCapacityConfiguration.Builder.get();

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


    private static ElastigroupScalingConfiguration toBl(ApiScaling scaling) {
        ElastigroupScalingConfiguration retVal = null;

        if (scaling != null) {
            ElastigroupScalingConfiguration.Builder retValBuilder = ElastigroupScalingConfiguration.Builder.get();

            if (scaling.isUpSet()) {
                if (scaling.getUp() != null) {
                    List<ApiScalingPolicy> apiScalingPolicies = scaling.getUp();
                    List<ScalingPolicy> scalingPolicies =
                            apiScalingPolicies.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                    retValBuilder.setUp(scalingPolicies);
                }
            }

            if (scaling.isDownSet()) {
                if (scaling.getDown() != null) {
                    List<ApiScalingPolicy> apiScalingPolicies = scaling.getDown();
                    List<ScalingPolicy> scalingPolicies =
                            apiScalingPolicies.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                    retValBuilder.setDown(scalingPolicies);
                }
            }

            if (scaling.isTargetSet()) {
                if (scaling.getTarget() != null) {
                    List<ApiScalingPolicy> apiScalingPolicies = scaling.getTarget();
                    List<ScalingPolicy> scalingPolicies =
                            apiScalingPolicies.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                    retValBuilder.setTarget(scalingPolicies);
                }
            }

            if(scaling.isMultipleMetricsSet()){
                if(scaling.getMultipleMetrics() != null){
                    retValBuilder.setMultipleMetrics(toBl(scaling.getMultipleMetrics()));
                }
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static MultipleMetrics toBl(ApiMultipleMetrics apiMultipleMetrics){
        MultipleMetrics retVal = null;

        if(apiMultipleMetrics != null){
            MultipleMetrics.Builder retValBuilder = MultipleMetrics.Builder.get();

            if(apiMultipleMetrics.isExpressionsSet()){
                List<ApiExpressions> apiExpressions = apiMultipleMetrics.getExpressions();
                List<Expressions> expressions =
                        apiExpressions.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                retValBuilder.setExpressions(expressions);
            }

            if(apiMultipleMetrics.isMetricssSet()){
                List<ApiMetrics> apiMetrics = apiMultipleMetrics.getMetrics();
                List<Metrics> metrics = apiMetrics.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                retValBuilder.setMetrics(metrics);
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static Expressions toBl(ApiExpressions apiExpressions){
        Expressions retVal = null;

        if(apiExpressions != null){
            Expressions.Builder expressions = Expressions.Builder.get();

            if(apiExpressions.isExpressionSet()){
                expressions.setExpression(apiExpressions.getExpression());
            }

            if(apiExpressions.isNameSet()){
                expressions.setName(apiExpressions.getName());
            }
            retVal = expressions.build();
        }
        return  retVal;
    }

    private static Metrics toBl(ApiMetrics apiMetrics){
        Metrics retVal = null;

        if(apiMetrics != null){
            Metrics.Builder retValBuilder = Metrics.Builder.get();

            if(apiMetrics.isDimensionSet()){
                List<ScalingDimension> apiStepAdjustments =
                        apiMetrics.getDimensions().stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                retValBuilder.setDimensions(apiStepAdjustments);
            }

            if(apiMetrics.isExtendedStatisticSet()){
                retValBuilder.setExtendedStatistic(apiMetrics.getExtendedStatistic());
            }

            if(apiMetrics.isMetricNameSet()){
                retValBuilder.setMetricName(apiMetrics.getMetricName());
            }

            if(apiMetrics.isNameSet()){
                retValBuilder.setName(apiMetrics.getName());
            }

            if(apiMetrics.isNamespaceSet()){
                retValBuilder.setNamespace(apiMetrics.getNamespace());
            }

            if(apiMetrics.isStatisticSet()){
                retValBuilder.setStatistic(apiMetrics.getStatistic());
            }

            if(apiMetrics.isUnitSet()){
                retValBuilder.setUnit(apiMetrics.getUnit());
            }

            retVal = retValBuilder.build();
        }
        return  retVal;
    }

    private static LoadBalancersConfig toBl(ApiLoadBalancersConfig loadBalancersConfig) {
        LoadBalancersConfig retVal = null;

        if (loadBalancersConfig != null) {
            LoadBalancersConfig.Builder retValBuilder = LoadBalancersConfig.Builder.get();
            List<ApiLoadBalancer> loadBalancers = loadBalancersConfig.getLoadBalancers();

            if (loadBalancersConfig.isLoadBalancersSet() && loadBalancers != null) {
                List<LoadBalancer> blLoadBalancers =
                        loadBalancers.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                retValBuilder.setLoadBalancers(blLoadBalancers);
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static StepAdjustments toBl(ApiStepAdjustments apiStepAdjustments){
        StepAdjustments retVal = null;

        if(apiStepAdjustments != null){
            StepAdjustments.Builder retValBuilder = StepAdjustments.Builder.get();

            if(apiStepAdjustments.isActionSet()){
                retValBuilder.setAction(toBl(apiStepAdjustments.getAction()));
            }
            if(apiStepAdjustments.isThresholdSet()){
                retValBuilder.setThreshold(apiStepAdjustments.getThreshold());
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ScalingPolicy toBl(ApiScalingPolicy scalingPolicy) {
        ScalingPolicy retVal = null;

        if (scalingPolicy != null) {
            ScalingPolicy.Builder retValBuilder = ScalingPolicy.Builder.get();

            if(scalingPolicy.isSourceSet()){
                retValBuilder.setSource(scalingPolicy.getSource());
            }
            if(scalingPolicy.isStepAdjustmentsSet()){
                List<StepAdjustments> stepAdjustments =
                        scalingPolicy.getStepAdjustments().stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                retValBuilder.setStepAdjustments(stepAdjustments);
            }
            if (scalingPolicy.isPolicyNameSet()) {
                retValBuilder.setPolicyName(scalingPolicy.getPolicyName());
            }

            if (scalingPolicy.isMetricNameSet()) {
                retValBuilder.setMetricName(scalingPolicy.getMetricName());
            }

            if (scalingPolicy.isStatisticSet()) {
                retValBuilder.setStatistic(scalingPolicy.getStatistic());
            }

            if (scalingPolicy.isExtendedStatisticSet()) {
                retValBuilder.setExtendedStatistic(scalingPolicy.getExtendedStatistic());
            }

            if (scalingPolicy.isUnitSet()) {
                retValBuilder.setUnit(scalingPolicy.getUnit());
            }

            if (scalingPolicy.isThresholdSet()) {
                retValBuilder.setThreshold(scalingPolicy.getThreshold());
            }

            if (scalingPolicy.isNamespaceSet()) {
                retValBuilder.setNamespace(scalingPolicy.getNamespace());
            }

            if (scalingPolicy.isPeriodSet()) {
                retValBuilder.setPeriod(scalingPolicy.getPeriod());
            }

            if (scalingPolicy.isEvaluationPeriodsSet()) {
                retValBuilder.setEvaluationPeriods(scalingPolicy.getEvaluationPeriods());
            }

            if (scalingPolicy.isCooldownSet()) {
                retValBuilder.setCooldown(scalingPolicy.getCooldown());
            }

            if (scalingPolicy.isDimensionsSet()) {
                if (scalingPolicy.getDimensions() != null) {
                    List<ApiScalingDimension> apiDimensions = scalingPolicy.getDimensions();
                    List<ScalingDimension> dimensions =
                            apiDimensions.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                    retValBuilder.setDimensions(dimensions);
                }
            }

            if (scalingPolicy.isActionSet()) {
                retValBuilder.setAction(toBl(scalingPolicy.getAction()));
            }

            if (scalingPolicy.isOperatorSet()) {
                retValBuilder.setOperator(scalingPolicy.getOperator());
            }

            if (scalingPolicy.isIsEnabledSet()) {
                retValBuilder.setIsEnabled(scalingPolicy.getIsEnabled());
            }

            if (scalingPolicy.isTargetSet()) {
                retValBuilder.setTarget(scalingPolicy.getTarget());
            }

            if (scalingPolicy.isPredictiveSet()) {
                retValBuilder.setPredictive(toBl(scalingPolicy.getPredictive()));
            }
            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static ScalingDimension toBl(ApiScalingDimension scalingDimension) {
        ScalingDimension retVal = null;

        if (scalingDimension != null) {
            retVal = new ScalingDimension();

            if (scalingDimension.isNameSet()) {
                retVal.setName(scalingDimension.getName());
            }

            if (scalingDimension.isValueSet()) {
                retVal.setValue(scalingDimension.getValue());
            }
        }

        return retVal;
    }

    private static ScalingAction toBl(ApiScalingAction scalingAction) {
        ScalingAction retVal = null;

        if (scalingAction != null) {
            retVal = new ScalingAction();

            if (scalingAction.isTypeSet()) {
                if (scalingAction.getType() != null) {
                    ScalingActionTypeEnum actionTypeEnum = ScalingActionTypeEnum.fromName(scalingAction.getType());
                    retVal.setType(actionTypeEnum);
                }
            }

            if (scalingAction.isAdjustmentSet()) {
                retVal.setAdjustment(scalingAction.getAdjustment());
            }

            if (scalingAction.isMinTargetCapacitySet()) {
                retVal.setMinTargetCapacity(scalingAction.getMinTargetCapacity());
            }

            if (scalingAction.isMaxTargetCapacitySet()) {
                retVal.setMaxTargetCapacity(scalingAction.getMaxTargetCapacity());
            }

            if (scalingAction.isTargetSet()) {
                retVal.setTarget(scalingAction.getTarget());
            }

            if (scalingAction.isMinimumSet()) {
                retVal.setMinimum(scalingAction.getMinimum());
            }

            if (scalingAction.isMaximumSet()) {
                retVal.setMaximum(scalingAction.getMaximum());
            }
        }

        return retVal;
    }

    private static PredictiveScale toBl(ApiPredictiveScale predictiveScale) {
        PredictiveScale retVal = null;

        if (predictiveScale != null) {
            retVal = new PredictiveScale();

            if (predictiveScale.isModeSet()) {
                if (predictiveScale.getMode() != null) {
                    ScalingPredictiveModeEnum modeEnum = ScalingPredictiveModeEnum.fromName(predictiveScale.getMode());
                    retVal.setMode(modeEnum);
                }
            }
        }

        return retVal;
    }

    public static ElastigroupStartDeployment toBl(ApiElastigroupStartDeployment elastigroupDeployment) {
        ElastigroupStartDeployment retVal = null;

        if (elastigroupDeployment != null) {
            retVal = new ElastigroupStartDeployment();

            if (elastigroupDeployment.isBatchSizePercentageSet()) {
                retVal.setBatchSizePercentage(elastigroupDeployment.getBatchSizePercentage());
            }

            if (elastigroupDeployment.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(elastigroupDeployment.getDrainingTimeout());
            }

            if (elastigroupDeployment.isGracePeriodSet()) {
                retVal.setGracePeriod(elastigroupDeployment.getGracePeriod());
            }

            if (elastigroupDeployment.isHealthCheckTypeSet()) {
                retVal.setHealthCheckType(AwsElastigroupHealthCheckTypeEnum.fromName(elastigroupDeployment.getHealthCheckType()));
            }

            if (elastigroupDeployment.isStrategySet()) {
                retVal.setStrategy(toBl(elastigroupDeployment.getStrategy()));
            }
        }

        return retVal;
    }

    private static ElastigroupDeploymentStrategy toBl(ApiElastigroupDeploymentStrategy elastigroupStrategy) {
        ElastigroupDeploymentStrategy retVal = null;

        if (elastigroupStrategy != null) {
            retVal = new ElastigroupDeploymentStrategy();

            if (elastigroupStrategy.isActionSet()) {
                retVal.setAction(AwsElastigroupActionEnum.fromName(elastigroupStrategy.getAction()));
            }

            if (elastigroupStrategy.isBatchMinHealthyPercentageSet()) {
                retVal.setBatchMinHealthyPercentage(elastigroupStrategy.getBatchMinHealthyPercentage());
            }

            if (elastigroupStrategy.isOnFailureSet()) {
                retVal.setOnFailure(toBl(elastigroupStrategy.getOnFailure()));
            }

        }

        return retVal;
    }

    private static ElastigroupDeploymentStrategyOnFailure toBl(
            ApiElastigroupDeploymentStrategyOnFailure elastigroupOnFailure) {
        ElastigroupDeploymentStrategyOnFailure retVal = null;

        if (elastigroupOnFailure != null) {
            retVal = new ElastigroupDeploymentStrategyOnFailure();

            if (elastigroupOnFailure.isActionTypeSet()) {
                retVal.setActionType(AwsElastigroupActionTypeEnum.fromName(elastigroupOnFailure.getActionType()));
            }

            if (elastigroupOnFailure.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(elastigroupOnFailure.getDrainingTimeout());
            }

            if (elastigroupOnFailure.isShouldDecrementTargetCapacitySet()) {
                retVal.setShouldDecrementTargetCapacity(elastigroupOnFailure.getShouldDecrementTargetCapacity());
            }

            if (elastigroupOnFailure.isShouldHandleAllBatchesSet()) {
                retVal.setShouldHandleAllBatches(elastigroupOnFailure.getShouldHandleAllBatches());
            }

        }

        return retVal;
    }

    public static ElastigroupStartDeploymentResponse toBl(
            ApiElastigroupStartDeploymentResponse elastigroupStartDeploymentItems) {
        ElastigroupStartDeploymentResponse retVal = null;

        if (elastigroupStartDeploymentItems != null) {
            retVal = new ElastigroupStartDeploymentResponse();

            if (elastigroupStartDeploymentItems.isIdSet()) {
                retVal.setId(elastigroupStartDeploymentItems.getId());
            }

            if (elastigroupStartDeploymentItems.isStatusSet()) {
                retVal.setStatus(elastigroupStartDeploymentItems.getStatus());
            }

            if (elastigroupStartDeploymentItems.isCurrentBatchSet()) {
                retVal.setCurrentBatch(elastigroupStartDeploymentItems.getCurrentBatch());
            }

            if (elastigroupStartDeploymentItems.isNumOfBatchesSet()) {
                retVal.setNumOfBatches(elastigroupStartDeploymentItems.getNumOfBatches());
            }

            if (elastigroupStartDeploymentItems.isProgressSet()) {
                retVal.setProgress(toBl(elastigroupStartDeploymentItems.getProgress()));
            }

        }

        return retVal;
    }

    public static ElastigroupStopDeploymentResponse toBl(
            ApiElastigroupStopDeploymentResponse elastigroupStopDeploymentItems) {
        ElastigroupStopDeploymentResponse retVal = null;

        if (elastigroupStopDeploymentItems != null) {
            retVal = new ElastigroupStopDeploymentResponse();

            if (elastigroupStopDeploymentItems.isIdSet()) {
                retVal.setId(elastigroupStopDeploymentItems.getId());
            }

            if (elastigroupStopDeploymentItems.isStatusSet()) {
                retVal.setStatus(elastigroupStopDeploymentItems.getStatus());
            }

            if (elastigroupStopDeploymentItems.isProgressSet()) {
                retVal.setProgress(toBl(elastigroupStopDeploymentItems.getProgress()));
            }

        }

        return retVal;
    }

    private static ElastigroupDeploymentProgress toBl(
            ApiElastigroupDeploymentProgress elastigroupStartDeploymentItems) {
        ElastigroupDeploymentProgress retVal = null;

        if (elastigroupStartDeploymentItems != null) {
            retVal = new ElastigroupDeploymentProgress();

            if (elastigroupStartDeploymentItems.isUnitSet()) {
                retVal.setUnit(elastigroupStartDeploymentItems.getUnit());
            }

            if (elastigroupStartDeploymentItems.isValueSet()) {
                retVal.setValue(elastigroupStartDeploymentItems.getValue());
            }

        }

        return retVal;
    }

    private static ElastigroupDeploymentRoll toBl(ApiElastigroupDeploymentRoll elastigroupStopDeployment) {
        ElastigroupDeploymentRoll retVal = null;

        if (elastigroupStopDeployment != null) {

            if (elastigroupStopDeployment.isStatusSet()) {
                retVal.setStatus(elastigroupStopDeployment.getStatus());
            }
        }
        return retVal;

    }

    public static ElastigroupGetDeploymentStatusResponse toBl(ApiElastigroupGetDeploymentStatusResponse elastigroupGetDeploymentStatusResponse) {
        ElastigroupGetDeploymentStatusResponse retVal = null;

        if (elastigroupGetDeploymentStatusResponse != null) {
            retVal = new ElastigroupGetDeploymentStatusResponse();

            if (elastigroupGetDeploymentStatusResponse.isStrategyActionSet()) {
                retVal.setStrategyAction(elastigroupGetDeploymentStatusResponse.getStrategyAction().getName());
            }

            if (elastigroupGetDeploymentStatusResponse.isHealthCheckSet()) {
                retVal.setHealthCheck(elastigroupGetDeploymentStatusResponse.getHealthCheck().getName());
            }

            if (elastigroupGetDeploymentStatusResponse.isCurrentBatchSet()) {
                retVal.setCurrentBatch(elastigroupGetDeploymentStatusResponse.getCurrentBatch());
            }

            if (elastigroupGetDeploymentStatusResponse.isNumberOfBatchesSet()) {
                retVal.setNumberOfBatches(elastigroupGetDeploymentStatusResponse.getNumberOfBatches());
            }

            if (elastigroupGetDeploymentStatusResponse.isGracePeriodSet()) {
                retVal.setGracePeriod(elastigroupGetDeploymentStatusResponse.getGracePeriod());
            }

            if (elastigroupGetDeploymentStatusResponse.isProgressSet()) {
                retVal.setProgress(toBl(elastigroupGetDeploymentStatusResponse.getProgress()));
            }

            if (elastigroupGetDeploymentStatusResponse.isInstancesSet()) {

                List<ElastigroupDeploymentStatusInstances> instancesList =
                        elastigroupGetDeploymentStatusResponse.getInstances().stream().map(ElastigroupConverter::toBl)
                                .collect(Collectors.toList());
                retVal.setInstances(instancesList);
            }

        }

        return retVal;
    }

    private static ElastigroupDeploymentStatusInstances toBl(
            ApiElastigroupDeploymentStatusInstances elastigroupGetDeploymentStatusInstances) {
        ElastigroupDeploymentStatusInstances retVal = null;

        if (elastigroupGetDeploymentStatusInstances != null) {
            retVal = new ElastigroupDeploymentStatusInstances();

            if (elastigroupGetDeploymentStatusInstances.isBlueSet()) {
                List<ElastigroupDeploymentStatusInstancesBlue> blueInstancesList =
                        elastigroupGetDeploymentStatusInstances.getBlue().stream().map(ElastigroupConverter::toBl)
                                .collect(Collectors.toList());
                retVal.setBlue(blueInstancesList);
            }

            if (elastigroupGetDeploymentStatusInstances.isGreenSet()) {
                List<ElastigroupDeploymentStatusInstancesGreen> greenInstancesList = elastigroupGetDeploymentStatusInstances.getGreen().stream().map(ElastigroupConverter::toBl)
                        .collect(Collectors.toList());
                retVal.setGreen(greenInstancesList);
            }
        }
        return retVal;

    }

    private static ElastigroupDeploymentStatusInstancesBlue toBl(
            ApiElastigroupDeploymentStatusInstancesBlue elastigroupGetDeploymentStatusInstancesblue) {
        ElastigroupDeploymentStatusInstancesBlue retVal = null;

        if (elastigroupGetDeploymentStatusInstancesblue != null) {

            retVal = new ElastigroupDeploymentStatusInstancesBlue();

            if (elastigroupGetDeploymentStatusInstancesblue.isInstanceIdSet()) {
                retVal.setInstanceId(elastigroupGetDeploymentStatusInstancesblue.getInstanceId());
            }

            if (elastigroupGetDeploymentStatusInstancesblue.isBatchNumSet()) {
                retVal.setBatchNum(elastigroupGetDeploymentStatusInstancesblue.getBatchNum());
            }

            if (elastigroupGetDeploymentStatusInstancesblue.isLifeCycleSet()) {
                retVal.setLifeCycle(elastigroupGetDeploymentStatusInstancesblue.getLifeCycle());
            }

            if (elastigroupGetDeploymentStatusInstancesblue.isStatusSet()) {
                retVal.setStatus(elastigroupGetDeploymentStatusInstancesblue.getStatus());
            }

        }
        return retVal;

    }

    private static ElastigroupDeploymentStatusInstancesGreen toBl(
            ApiElastigroupDeploymentStatusInstancesGreen elastigroupGetDeploymentStatusInstancesGreen) {
        ElastigroupDeploymentStatusInstancesGreen retVal = null;

        if (elastigroupGetDeploymentStatusInstancesGreen != null) {
            retVal = new ElastigroupDeploymentStatusInstancesGreen();


            if (elastigroupGetDeploymentStatusInstancesGreen.isInstanceIdSet()) {
                retVal.setInstanceId(elastigroupGetDeploymentStatusInstancesGreen.getInstanceId());
            }

            if (elastigroupGetDeploymentStatusInstancesGreen.isBatchNumSet()) {
                retVal.setBatchNum(elastigroupGetDeploymentStatusInstancesGreen.getBatchNum());
            }

            if (elastigroupGetDeploymentStatusInstancesGreen.isLifeCycleSet()) {
                retVal.setLifeCycle(elastigroupGetDeploymentStatusInstancesGreen.getLifeCycle());
            }

            if (elastigroupGetDeploymentStatusInstancesGreen.isStatusSet()) {
                retVal.setStatus(elastigroupGetDeploymentStatusInstancesGreen.getStatus());
            }
        }
        return retVal;

    }

    public static ElastigroupGroupDeploymentStatusResponse toBl(ApiElastigroupGetGroupDeploymentStatusResponse getGroupDeploymentStatusResponse) {
        ElastigroupGroupDeploymentStatusResponse retVal = null;

        if (getGroupDeploymentStatusResponse != null) {
            retVal = new ElastigroupGroupDeploymentStatusResponse();

            if (getGroupDeploymentStatusResponse.isIdSet()) {
                retVal.setId(getGroupDeploymentStatusResponse.getId());
            }

            if (getGroupDeploymentStatusResponse.isProgressSet()) {
                retVal.setProgress(toBl(getGroupDeploymentStatusResponse.getProgress()));
            }

            if (getGroupDeploymentStatusResponse.isStatusSet()) {
                retVal.setStatus(getGroupDeploymentStatusResponse.getStatus());
            }

            if (getGroupDeploymentStatusResponse.isCreatedAtSet()) {
                retVal.setCreatedAt(getGroupDeploymentStatusResponse.getCreatedAt());
            }

            if (getGroupDeploymentStatusResponse.isUpdatedAtSet()) {
                retVal.setUpdatedAt(getGroupDeploymentStatusResponse.getUpdatedAt());
            }

        }

        return retVal;
    }

    public static ElastigroupGetDeploymentActionResponse toBl(ApiElastigroupGetDeploymentActionResponse getDeploymentActionResponse) {
        ElastigroupGetDeploymentActionResponse retVal = null;

        if (getDeploymentActionResponse != null) {
            retVal = new ElastigroupGetDeploymentActionResponse();

            if (getDeploymentActionResponse.isActionTypeSet()) {
                retVal.setActionType(getDeploymentActionResponse.getActionType());
            }

            if (getDeploymentActionResponse.isGroupIdSet()) {
                retVal.setGroupId(getDeploymentActionResponse.getGroupId());
            }

            if (getDeploymentActionResponse.isRollIdSet()) {
                retVal.setRollId(getDeploymentActionResponse.getRollId());
            }

            if (getDeploymentActionResponse.isDetachedInstancesSet()) {
                retVal.setDetachedInstances(getDeploymentActionResponse.getDetachedInstances());
            }

        }

        return retVal;
    }

    public static ElastigroupImportEC2Instance toBl(
            ApiElastigroupImportEC2Instance elastigroupImportInstance) {
        ElastigroupImportEC2Instance retVal = null;

        if (elastigroupImportInstance != null) {
            retVal = new ElastigroupImportEC2Instance();

            if (elastigroupImportInstance.isNameSet()) {
                retVal.setName(elastigroupImportInstance.getName());
            }
            if (elastigroupImportInstance.isSpotInstanceTypesSet()) {
                retVal.setSpotInstanceTypes(elastigroupImportInstance.getSpotInstanceTypes());
            }

        }

        return retVal;
    }

    public static GetInstanceTypesResponse toBl(
            ApiGetInstanceTypesResponse getInstanceTypesByRegion) {
        GetInstanceTypesResponse retVal = null;

        if (getInstanceTypesByRegion != null) {
            retVal = new GetInstanceTypesResponse();

            if (getInstanceTypesByRegion.isInstanceTypeSet()) {
                retVal.setInstanceType(getInstanceTypesByRegion.getInstanceType());
            }
        }
        return retVal;
    }

    public static ElastigroupEcsInitiateRollResponseOldInstances toBl(ApiElastigroupEcsInitiateRollResponseOldInstances oldInstances) {
        ElastigroupEcsInitiateRollResponseOldInstances retVal = null;

        if (oldInstances != null) {
            ElastigroupEcsInitiateRollResponseOldInstances.Builder instancesBuilder = ElastigroupEcsInitiateRollResponseOldInstances.Builder.get();

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

    public static ElastigroupEcsInitiateRollDetailedStatus toBl(ApiElastigroupEcsInitiateRollDetailedStatus detailedStatus) {
        ElastigroupEcsInitiateRollDetailedStatus retVal = null;

        if (detailedStatus != null) {
            ElastigroupEcsInitiateRollDetailedStatus.Builder detailedStatusBuilder = ElastigroupEcsInitiateRollDetailedStatus.Builder.get();

            if (detailedStatus.isOldInstancesSet()) {

                List<ElastigroupEcsInitiateRollResponseOldInstances> instancesList =
                        detailedStatus.getOldInstances().stream().map(ElastigroupConverter::toBl)
                                .collect(Collectors.toList());
                detailedStatusBuilder.setOldInstances(instancesList);
            }

            retVal = detailedStatusBuilder.build();
        }

        return retVal;
    }

    public static ElastigroupEcsInitiateRollProgress toBl(ApiElastigroupEcsInitiateRollProgress progress) {
        ElastigroupEcsInitiateRollProgress retVal = null;

        if (progress != null) {
            ElastigroupEcsInitiateRollProgress.Builder progressBuilder = ElastigroupEcsInitiateRollProgress.Builder.get();

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

    public static ElastigroupEcsClusterRollResponse toBl(ApiElastigroupEcsClusterRollResponse initiateRollResponse) {
        ElastigroupEcsClusterRollResponse retVal = null;

        if (initiateRollResponse != null) {
            ElastigroupEcsClusterRollResponse.Builder responseBuilder = ElastigroupEcsClusterRollResponse.Builder.get();

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

            if (initiateRollResponse.isGroupIdSet()) {
                responseBuilder.setGroupId(initiateRollResponse.getGroupId());
            }

            if (initiateRollResponse.isScopeSet()) {
                responseBuilder.setScope(initiateRollResponse.getScope());
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

    public static ElastigroupGetInstanceStatusResponse toBl(
            ApiElastigroupGetInstanceStatusResponse elastigroupGetInstanceStatusResponse) {
        ElastigroupGetInstanceStatusResponse retVal = null;

        if (elastigroupGetInstanceStatusResponse != null) {
            retVal = new ElastigroupGetInstanceStatusResponse();

            if (elastigroupGetInstanceStatusResponse.isInstanceIdSet()) {
                retVal.setInstanceId(elastigroupGetInstanceStatusResponse.getInstanceId());
            }

            if (elastigroupGetInstanceStatusResponse.isLifeCycleStateSet()) {
                retVal.setLifeCycleState(elastigroupGetInstanceStatusResponse.getLifeCycleState());
            }

        }
        return retVal;
    }

    public static ApiElastigroupCodeDeployBGDeployment toDal(ElastigroupCodeDeployBGDeployment codeDeployBGDeployment) {
        ApiElastigroupCodeDeployBGDeployment retVal = null;

        if (codeDeployBGDeployment != null) {
            retVal = new ApiElastigroupCodeDeployBGDeployment();

            if (codeDeployBGDeployment.isTimeoutSet()) {
                retVal.setTimeout(codeDeployBGDeployment.getTimeout());
            }

            if (codeDeployBGDeployment.isTagsSet()) {
                if (codeDeployBGDeployment.getTags() != null) {
                    List<ApiTag> tags =
                            codeDeployBGDeployment.getTags().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setTags(tags);
                }
            }

            if (codeDeployBGDeployment.isDeploymentGroupsSet()) {
                if (codeDeployBGDeployment.getDeploymentGroups() != null) {
                    List<ApiDeploymentGroup> deploymentGroups =
                            codeDeployBGDeployment.getDeploymentGroups().stream().map((ElastigroupConverter::toDal))
                                    .collect(Collectors.toList());
                    retVal.setDeploymentGroups(deploymentGroups);
                }
            }
        }
        return retVal;
    }

    public static CodeDeployBGDeploymentResponse toBl(ApiCodeDeployBGDeploymentResponse apiCodeDeployBGResponse) {
        CodeDeployBGDeploymentResponse retVal = null;

        if (apiCodeDeployBGResponse != null) {

            retVal = new CodeDeployBGDeploymentResponse();

            if (apiCodeDeployBGResponse.isIdSet()) {
                retVal.setId(apiCodeDeployBGResponse.getId());
            }

            if (apiCodeDeployBGResponse.isGroupIdSet()) {
                retVal.setGroupId(apiCodeDeployBGResponse.getGroupId());
            }

            if (apiCodeDeployBGResponse.isStateSet()) {
                retVal.setState(apiCodeDeployBGResponse.getState());
            }

            if (apiCodeDeployBGResponse.isConfigSet()) {
                retVal.setConfig(apiCodeDeployBGResponse.getConfig());
            }

        }
        return retVal;
    }

    private static CodeDeployConfig toBl(ApiCodeDeployConfig apiCodeDeployConfig) {
        CodeDeployConfig retVal = null;

        if (apiCodeDeployConfig != null) {

            retVal = new CodeDeployConfig();

            if (apiCodeDeployConfig.isTimeoutSet()) {
                retVal.setTimeout(apiCodeDeployConfig.getTimeout());
            }

            if (apiCodeDeployConfig.isTagsSet()) {
                List<Tag> tags =
                        apiCodeDeployConfig.getTag().stream().map(ElastigroupConverter::toBl)
                                .collect(Collectors.toList());
                retVal.setTags(tags);
            }

            if (apiCodeDeployConfig.isDeploymentGroupsSet()) {
                List<ElastigroupDeploymentGroup> deploymentGroups =
                        apiCodeDeployConfig.getDeploymentGroups().stream().map(ElastigroupConverter::toBl)
                                .collect(Collectors.toList());
                retVal.setDeploymentGroups(deploymentGroups);
            }

        }
        return retVal;
    }

    public static ElastigroupGetBeanstalkMaintenanceStatusResponse toBl(ApiElastigroupGetBeanstalkMaintenanceStatusResponse apiGetBeanstalkStatus) {
        ElastigroupGetBeanstalkMaintenanceStatusResponse blGetBeanstalkStatus = null;

        if (apiGetBeanstalkStatus != null) {
            ElastigroupGetBeanstalkMaintenanceStatusResponse.Builder blGetBeanstalkStatusBuilder = ElastigroupGetBeanstalkMaintenanceStatusResponse.Builder.get();
            if (apiGetBeanstalkStatus.isStatusSet()) {
                if (apiGetBeanstalkStatus.getStatus() != null) {
                    blGetBeanstalkStatusBuilder.setStatus(apiGetBeanstalkStatus.getStatus());
                }
            }
            blGetBeanstalkStatus = blGetBeanstalkStatusBuilder.build();
        }
        return blGetBeanstalkStatus;

    }
}
