package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.spotinst.sdkjava.enums.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sniramsalem
 * @since: 06/12/2016
 */
class ElastigroupConverterAzure {
    //region BL -> DAL
    public static ApiElastigroupAzure toDal(ElastigroupAzure src) {
        ApiElastigroupAzure apiGroup = null;

        if (src != null) {
            apiGroup = new ApiElastigroupAzure();

            if (src.isNameSet()) {
                apiGroup.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                apiGroup.setDescription(src.getDescription());
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
                ApiThirdPartiesIntegrationAzure apiThirdPartiesIntegration = toDal(src.getThirdPartiesIntegration());
                apiGroup.setThirdPartiesIntegration(apiThirdPartiesIntegration);
            }
            if (src.isSchedulingSet()) {
                apiGroup.setScheduling(toDal(src.getScheduling()));
            }
        }

        return apiGroup;
    }

    private static ApiElastigroupSchedulingAzure toDal(ElastigroupSchedulingConfigurationAzure schedulingConfiguration) {
        ApiElastigroupSchedulingAzure retVal = null;
        if (schedulingConfiguration != null) {
            retVal = new ApiElastigroupSchedulingAzure();
            if (schedulingConfiguration.isTasksSet()) {
                if (schedulingConfiguration.getTasks() != null) {
                    List<ApiElastigroupScheduledTaskAzure> taskList =
                            schedulingConfiguration.getTasks().stream().map(ElastigroupConverterAzure::toDal)
                                                   .collect(Collectors.toList());
                    retVal.setTasks(taskList);
                }
            }
        }
        return retVal;
    }

    private static ApiElastigroupScheduledTaskAzure toDal(TasksConfigurationAzure tasksConfiguration) {
        ApiElastigroupScheduledTaskAzure retVal = null;
        if (tasksConfiguration != null) {
            retVal = new ApiElastigroupScheduledTaskAzure();
            if (tasksConfiguration.isIsEnabledSet()) {
                retVal.setIsEnabled(tasksConfiguration.getIsEnabled());
            }
            if (tasksConfiguration.isFrequencySet()) {
                retVal.setFrequency(tasksConfiguration.getFrequency().getName());
            }
            if (tasksConfiguration.isStartTimeSet()) {
                retVal.setStartTime(tasksConfiguration.getStartTime());
            }
            if (tasksConfiguration.isCronExpressionSet()) {
                retVal.setCronExpression(tasksConfiguration.getCronExpression());
            }
            if (tasksConfiguration.isTaskTypeSet()) {
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

    private static ApiThirdPartiesIntegrationAzure toDal(
            ElastigroupThirdPartiesIntegrationConfigurationAzure thirdPartiesIntegration) {
        ApiThirdPartiesIntegrationAzure retVal = null;

        if (thirdPartiesIntegration != null) {
            retVal = new ApiThirdPartiesIntegrationAzure();
            if (thirdPartiesIntegration.isEcsSet()) {
                retVal.setEcs(toDal(thirdPartiesIntegration.getEcs()));
            }
        }

        return retVal;
    }

    private static ApiEcsAzure toDal(ElastigroupEcsSpecificationAzure ecs) {
        ApiEcsAzure retVal = null;
        if (ecs != null) {
            retVal = new ApiEcsAzure();
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

    private static ApiBatchAzure toDal(ElastigroupEcsBatchAzure ecsBatch) {
        ApiBatchAzure retVal = null;
        if (ecsBatch != null) {
            retVal = new ApiBatchAzure();
            if (ecsBatch.isJobQueueNamesSet()) {
                if (ecsBatch.getJobQueueNames() != null) {
                    retVal.setJobQueueNames(new LinkedList<>(ecsBatch.getJobQueueNames()));
                }
            }
        }
        return retVal;
    }

    private static ApiAttributesAzure toDal(ElastigroupAttributesSpecificationAzure attributes) {
        ApiAttributesAzure retVal = null;
        if (attributes != null) {
            retVal = new ApiAttributesAzure();
            if (attributes.isKeySet()) {
                retVal.setKey(attributes.getKey());
            }
            if (attributes.isValueSet()) {
                retVal.setValue(attributes.getValue());
            }
        }

        return retVal;
    }

    private static ApiOptimizeImagesAzure toDal(ElastigroupOptimizeImagesAzure optimizeImages) {
        ApiOptimizeImagesAzure retVal = null;
        if (optimizeImages != null) {
            retVal = new ApiOptimizeImagesAzure();
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

    private static ApiAutoScaleAzure toDal(ElastigroupAutoScaleSpecificationAzure autoScale) {
        ApiAutoScaleAzure retVal = null;
        if (autoScale != null) {
            retVal = new ApiAutoScaleAzure();
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
                    List<ApiAttributesAzure> attributesList =
                            autoScale.getAttributes().stream().map(ElastigroupConverterAzure::toDal)
                                     .collect(Collectors.toList());
                    retVal.setAttributes(attributesList);
                }
            }
        }
        return retVal;
    }

    private static ApiDownAzure toDal(ElastigroupDownSpecificationAzure down) {
        ApiDownAzure retVal = null;

        if (down != null) {
            retVal = new ApiDownAzure();
            if (down.isEvaluationPeriodsSet()) {
                retVal.setEvaluationPeriods(down.getEvaluationPeriods());
            }
            if (down.isMaxScaleDownPercentageSet()) {
                retVal.setMaxScaleDownPercentage(down.getMaxScaleDownPercentage());
            }
        }
        return retVal;

    }

    private static ApiHeadroomAzure toDal(ElastigroupHeadroomSpecificationAzure headroom) {
        ApiHeadroomAzure retVal = null;
        if (headroom != null) {
            retVal = new ApiHeadroomAzure();
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

    private static ApiGroupComputeAzure toDal(ElastigroupComputeConfigurationAzure compute) {
        ApiGroupComputeAzure optCompute = null;

        if (compute != null) {
            optCompute = new ApiGroupComputeAzure();
            if (compute.isInstanceTypesSet()) {
                optCompute.setInstanceTypes(toDal(compute.getInstanceTypes()));
            }

            if (compute.isAvailabilityZonesSet()) {
                if (compute.getAvailabilityZones() != null) {
                    List<ApiPlacementAzure> optPlacements =
                            compute.getAvailabilityZones().stream().map(ElastigroupConverterAzure::toDal)
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
                    List<ApiVolumePoolAzure> optVolumePool =
                            compute.getEbsVolumePool().stream().map(ElastigroupConverterAzure::toDal)
                                   .collect(Collectors.toList());
                    optCompute.setEbsVolumePool(optVolumePool);
                }
            }

        }

        return optCompute;
    }

    private static ApiVolumePoolAzure toDal(ElastigroupEbsVolumePoolAzure volumePool) {
        ApiVolumePoolAzure retVal = null;

        if (volumePool != null) {
            retVal = new ApiVolumePoolAzure();
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

    private static ApiPlacementAzure toDal(PlacementAzure placement) {
        ApiPlacementAzure retVal = null;

        if (placement != null) {
            retVal = new ApiPlacementAzure();
            if (placement.isAzNameSet()) {
                retVal.setName(placement.getAzName());
            }
            if (placement.isSubnetIdsSet()) {
                if (placement.getSubnetIds() != null) {
                    retVal.setSubnetIds(new LinkedList<>(placement.getSubnetIds()));
                }
            }
        }

        return retVal;
    }

    private static ApiLaunchSpecAzure toDal(ElastigroupLaunchSpecificationAzure launchSpecification) {
        ApiLaunchSpecAzure retVal = null;

        if (launchSpecification != null) {
            retVal = new ApiLaunchSpecAzure();

            if (launchSpecification.isHealthCheckTypeSet()) {
                retVal.setHealthCheckType(launchSpecification.getHealthCheckType());
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

            if (launchSpecification.isImageIdSet()) {
                retVal.setImageId(launchSpecification.getImageId());
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

            if (launchSpecification.isBlockDeviceMappingsSet()) {
                if (launchSpecification.getBlockDeviceMappings() != null) {
                    List<ApiBlockDeviceAzure> optimizerBDM =
                            launchSpecification.getBlockDeviceMappings().stream().map(ElastigroupConverterAzure::toDal)
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
                    List<ApiNetworkInterfaceAzure> optimizerNIC =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverterAzure::toDal)
                                               .collect(Collectors.toList());
                    retVal.setNetworkInterfaces(optimizerNIC);
                }
            }

            if (launchSpecification.isTagsSet()) {
                if (launchSpecification.getTags() != null) {
                    List<ApiTagAzure> optimizerTags =
                            launchSpecification.getTags().stream().map(ElastigroupConverterAzure::toDal)
                                               .collect(Collectors.toList());
                    retVal.setTags(optimizerTags);
                }
            }
        }

        return retVal;
    }

    private static ApiTagAzure toDal(TagAzure tag) {
        ApiTagAzure retVal = null;
        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                retVal = new ApiTagAzure(tag.getTagKey(), tag.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiNetworkInterfaceAzure toDal(NetworkInterfaceAzure networkInterface) {
        ApiNetworkInterfaceAzure retVal = null;
        if (networkInterface != null) {
            retVal = new ApiNetworkInterfaceAzure();
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
        }

        return retVal;
    }

    private static ApiBlockDeviceAzure toDal(BlockDeviceMappingAzure blockDeviceMapping) {
        ApiBlockDeviceAzure retVal = null;

        if (blockDeviceMapping != null) {
            retVal = new ApiBlockDeviceAzure();
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

    private static ApiLoadBalancersConfigAzure toDal(LoadBalancersConfigAzure loadBalancersConfig) {
        ApiLoadBalancersConfigAzure retVal           = new ApiLoadBalancersConfigAzure();
        List<ApiLoadBalancerAzure>  apiLoadBalancers = null;

        List<LoadBalancerAzure> loadBalancers = loadBalancersConfig.getLoadBalancers();

        if (loadBalancers != null) {
            apiLoadBalancers =
                    loadBalancers.stream().map(ElastigroupConverterAzure::toDal).collect(Collectors.toList());
        }

        retVal.setLoadBalancers(apiLoadBalancers);

        return retVal;
    }

    private static ApiLoadBalancerAzure toDal(LoadBalancerAzure loadBalancer) {
        ApiLoadBalancerAzure retVal = null;

        if (loadBalancer != null) {
            retVal = new ApiLoadBalancerAzure();

            if (loadBalancer.isNameSet()) {
                retVal.setName(loadBalancer.getName());
            }

            if (loadBalancer.isArnSet()) {
                retVal.setArn(loadBalancer.getArn());
            }

            if (loadBalancer.isTypeSet() && loadBalancer.getType() != null) {
                retVal.setType(loadBalancer.getType().getName());
            }
        }

        return retVal;
    }

    private static ApiEbsDeviceAzure toDal(EbsDeviceAzure ebsDevice) {
        ApiEbsDeviceAzure retVal = null;

        if (ebsDevice != null) {
            retVal = new ApiEbsDeviceAzure();

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
        }

        return retVal;
    }

    private static ApiIamRoleAzure toDal(IamRoleAzure iamRole) {
        ApiIamRoleAzure retVal = null;

        if (iamRole != null) {
            retVal = new ApiIamRoleAzure();

            if (iamRole.isNameSet()) {
                retVal.setName(iamRole.getName());
            }

            if (iamRole.isArnSet()) {
                retVal.setArn(iamRole.getArn());
            }
        }

        return retVal;
    }

    private static ApiInstanceTypesAzure toDal(ElastigroupInstanceTypesAzure instanceTypes) {
        ApiInstanceTypesAzure retVal = null;

        if (instanceTypes != null) {
            retVal = new ApiInstanceTypesAzure();
            if (instanceTypes.isOnDemandSet()) {
                retVal.setOndemand(instanceTypes.getOnDemand());
            }
            if (instanceTypes.isSpotSet()) {
                if (instanceTypes.getSpot() != null) {
                    retVal.setSpot(new LinkedList<>(instanceTypes.getSpot()));
                }
            }
        }

        return retVal;
    }

    private static ApiStrategyAzure toDal(ElastigroupStrategyConfigurationAzure strategy) {
        ApiStrategyAzure retVal = null;

        if (strategy != null) {
            retVal = new ApiStrategyAzure();

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

            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }

        }

        return retVal;
    }

    private static ApiCapacityAzure toDal(ElastigroupCapacityConfigurationAzure capacity) {
        ApiCapacityAzure retVal = null;

        if (capacity != null) {
            retVal = new ApiCapacityAzure();

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

    private static ApiScalingAzure toDal(ElastigroupScalingConfigurationAzure scaling) {
        ApiScalingAzure retVal = null;

        if (scaling != null) {
            retVal = new ApiScalingAzure();

            if (scaling.isUpSet()) {
                List<ApiScalingPolicyAzure> apiUpScalingPolicies = null;

                if (scaling.getUp() != null) {
                    List<ScalingPolicyAzure> up = scaling.getUp();
                    apiUpScalingPolicies =
                            up.stream().map(ElastigroupConverterAzure::toDal).collect(Collectors.toList());
                }

                retVal.setUp(apiUpScalingPolicies);
            }

            if (scaling.isDownSet()) {
                List<ApiScalingPolicyAzure> apiDownScalingPolicies = null;

                if (scaling.getDown() != null) {
                    List<ScalingPolicyAzure> down = scaling.getDown();
                    apiDownScalingPolicies =
                            down.stream().map(ElastigroupConverterAzure::toDal).collect(Collectors.toList());
                }

                retVal.setDown(apiDownScalingPolicies);
            }
        }

        return retVal;
    }

    private static ApiScalingPolicyAzure toDal(ScalingPolicyAzure scalingPolicy) {
        ApiScalingPolicyAzure retVal = null;

        if (scalingPolicy != null) {
            retVal = new ApiScalingPolicyAzure();

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
                List<ScalingDimensionAzure> dimensions = scalingPolicy.getDimensions();

                if (dimensions != null) {
                    List<ApiScalingDimensionAzure> optimizerScalingDimensions =
                            dimensions.stream().map(ElastigroupConverterAzure::toDal).collect(Collectors.toList());
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
        }

        return retVal;
    }


    private static ApiScalingDimensionAzure toDal(ScalingDimensionAzure scalingDimension) {
        ApiScalingDimensionAzure retVal = null;

        if (scalingDimension != null) {
            retVal = new ApiScalingDimensionAzure();

            if (scalingDimension.isNameSet()) {
                retVal.setName(scalingDimension.getName());
            }

            if (scalingDimension.isValueSet()) {
                retVal.setValue(scalingDimension.getValue());
            }
        }

        return retVal;
    }


    private static ApiScalingActionAzure toDal(ScalingActionAzure scalingAction) {
        ApiScalingActionAzure retVal = null;

        if (scalingAction != null) {
            retVal = new ApiScalingActionAzure();

            if (scalingAction.isTypeSet() && scalingAction.getType() != null) {
                retVal.setType(scalingAction.getType().getName());
            }

            if (scalingAction.isAdjustmentSet()) {
                retVal.setAdjustment(scalingAction.getAdjustment());
            }

            if (scalingAction.isMinTargetCapacitySet()) {
                retVal.setMinTargetCapacity(scalingAction.getMinTargetCapacity());
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

    //endregion

    //region DAL -> BL
    public static ElastigroupAzure toBl(ApiElastigroupAzure apiElastigroup) {
        ElastigroupAzure elastigroup = null;

        if (apiElastigroup != null) {
            ElastigroupAzure.Builder elastigroupBuilder = ElastigroupAzure.Builder.get();

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

    private static ElastigroupSchedulingConfigurationAzure toBl(ApiElastigroupSchedulingAzure apiScheduling) {
        ElastigroupSchedulingConfigurationAzure blSchedulingConfiguration = null;

        if (apiScheduling != null) {
            ElastigroupSchedulingConfigurationAzure.Builder blSchedulingConfigurationBuilder =
                    ElastigroupSchedulingConfigurationAzure.Builder.get();
            if (apiScheduling.isTasksSet()) {
                if (apiScheduling.getTasks() != null) {
                    List<TasksConfigurationAzure> tasksConfigurationList =
                            apiScheduling.getTasks().stream().map(ElastigroupConverterAzure::toBl)
                                         .collect(Collectors.toList());
                    blSchedulingConfigurationBuilder.setTasks(tasksConfigurationList);
                }
            }
            blSchedulingConfiguration = blSchedulingConfigurationBuilder.build();
        }
        return blSchedulingConfiguration;
    }

    private static TasksConfigurationAzure toBl(ApiElastigroupScheduledTaskAzure apiScheduledTask) {
        TasksConfigurationAzure bLTasks = null;

        if (apiScheduledTask != null) {
            TasksConfigurationAzure.Builder blTasksBuilder = TasksConfigurationAzure.Builder.get();
            if (apiScheduledTask.isIsEnabledSet()) {
                blTasksBuilder.setIsEnabled(apiScheduledTask.getIsEnabled());
            }
            if (apiScheduledTask.isFrequencySet()) {
                blTasksBuilder.setFrequency(RecurrenceFrequencyEnumAzure.fromName(apiScheduledTask.getFrequency()));
            }
            if (apiScheduledTask.isStartTimeSet()) {
                blTasksBuilder.setStartTime(apiScheduledTask.getStartTime());
            }
            if (apiScheduledTask.isCronExpressionSet()) {
                blTasksBuilder.setCronExpression(apiScheduledTask.getCronExpression());
            }
            if (apiScheduledTask.isTaskTypeSet()) {
                blTasksBuilder.setTaskType(SchedulingTaskTypeEnumAzure.fromName(apiScheduledTask.getTaskType()));
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

    private static ElastigroupThirdPartiesIntegrationConfigurationAzure toBl(
            ApiThirdPartiesIntegrationAzure apiThirdPartiesIntegration) {
        ElastigroupThirdPartiesIntegrationConfigurationAzure blThirdPartiesIntegration = null;

        if (apiThirdPartiesIntegration != null) {
            ElastigroupThirdPartiesIntegrationConfigurationAzure.Builder blThirdPartiesIntegrationBuilder =
                    ElastigroupThirdPartiesIntegrationConfigurationAzure.Builder.get();

            if (apiThirdPartiesIntegration.isEcsSet()) {
                blThirdPartiesIntegrationBuilder.setEcs(toBl(apiThirdPartiesIntegration.getEcs()));
            }
            blThirdPartiesIntegration = blThirdPartiesIntegrationBuilder.build();
        }
        return blThirdPartiesIntegration;
    }


    private static ElastigroupOptimizeImagesAzure toBl(ApiOptimizeImagesAzure apiOptimizeImages) {
        ElastigroupOptimizeImagesAzure blOptimizeImages = null;

        if (apiOptimizeImages != null) {
            ElastigroupOptimizeImagesAzure.Builder blOptimizeImagesBuilder = ElastigroupOptimizeImagesAzure.Builder.get();
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
                        .setPerformAt(MaintenanceWindowTypeEnumAzure.fromName(apiOptimizeImages.getPerformAt()));
            }
            blOptimizeImages = blOptimizeImagesBuilder.build();
        }
        return blOptimizeImages;
    }

    private static ElastigroupEcsSpecificationAzure toBl(ApiEcsAzure apiEcs) {
        ElastigroupEcsSpecificationAzure blEcs = null;

        if (apiEcs != null) {
            ElastigroupEcsSpecificationAzure.Builder blEcsBuilder = ElastigroupEcsSpecificationAzure.Builder.get();

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

    private static ElastigroupEcsBatchAzure toBl(ApiBatchAzure apiBatch) {
        ElastigroupEcsBatchAzure retVal = null;

        if (apiBatch != null) {
            ElastigroupEcsBatchAzure.Builder blEcsBuilder = ElastigroupEcsBatchAzure.Builder.get();
            if (apiBatch.isJobQueueNamesSet()) {
                if (apiBatch.getJobQueueNames() != null) {
                    blEcsBuilder.setJobQueueNames(new LinkedList<>(apiBatch.getJobQueueNames()));
                }
            }
            retVal = blEcsBuilder.build();
        }
        return retVal;
    }

    private static ElastigroupAttributesSpecificationAzure toBl(ApiAttributesAzure apiAttributes) {
        ElastigroupAttributesSpecificationAzure blAttributes = null;

        if (apiAttributes != null) {
            ElastigroupAttributesSpecificationAzure.Builder blAttributesBuilder =
                    ElastigroupAttributesSpecificationAzure.Builder.get();

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

    private static ElastigroupAutoScaleSpecificationAzure toBl(ApiAutoScaleAzure apiAutoScale) {
        ElastigroupAutoScaleSpecificationAzure blAutoScale = null;

        if (apiAutoScale != null) {
            ElastigroupAutoScaleSpecificationAzure.Builder blAutoScaleBuilder =
                    ElastigroupAutoScaleSpecificationAzure.Builder.get();

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
                    List<ElastigroupAttributesSpecificationAzure> attributesSpecificationList =
                            apiAutoScale.getAttributes().stream().map(ElastigroupConverterAzure::toBl)
                                        .collect(Collectors.toList());
                    blAutoScaleBuilder.setAttributes(attributesSpecificationList);
                }
            }
            blAutoScale = blAutoScaleBuilder.build();
        }
        return blAutoScale;
    }

    private static ElastigroupHeadroomSpecificationAzure toBl(ApiHeadroomAzure apiHeadroom) {
        ElastigroupHeadroomSpecificationAzure blHeadroom = null;

        if (apiHeadroom != null) {
            ElastigroupHeadroomSpecificationAzure.Builder blHeadroomBuilder = ElastigroupHeadroomSpecificationAzure.Builder.get();

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

    private static ElastigroupDownSpecificationAzure toBl(ApiDownAzure apidown) {
        ElastigroupDownSpecificationAzure blDown = null;

        if (apidown != null) {
            ElastigroupDownSpecificationAzure.Builder blDownBuilder = ElastigroupDownSpecificationAzure.Builder.get();

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

    private static ElastigroupComputeConfigurationAzure toBl(ApiGroupComputeAzure compute) {
        ElastigroupComputeConfigurationAzure blCompute = null;

        if (compute != null) {
            ElastigroupComputeConfigurationAzure.Builder blComputeBuilder = ElastigroupComputeConfigurationAzure.Builder.get();

            if (compute.isInstanceTypesSet()) {
                blComputeBuilder.setInstanceTypes(toBl(compute.getInstanceTypes()));
            }

            if (compute.isAvailabilityZonesSet()) {
                if (compute.getAvailabilityZones() != null) {
                    List<PlacementAzure> placements =
                            compute.getAvailabilityZones().stream().map(ElastigroupConverterAzure::toBl)
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
                    List<ElastigroupEbsVolumePoolAzure> blVolumePool =
                            compute.getEbsVolumePool().stream().map(ElastigroupConverterAzure::toBl)
                                   .collect(Collectors.toList());
                    blComputeBuilder.setEbsVolumePools(blVolumePool);
                }
            }

            blCompute = blComputeBuilder.build();
        }

        return blCompute;
    }

    private static ElastigroupEbsVolumePoolAzure toBl(ApiVolumePoolAzure volumePool) {
        ElastigroupEbsVolumePoolAzure retVal = null;

        if (volumePool != null) {
            ElastigroupEbsVolumePoolAzure.Builder retValBuilder = ElastigroupEbsVolumePoolAzure.Builder.get();
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

    private static PlacementAzure toBl(ApiPlacementAzure placement) {
        PlacementAzure retVal = null;

        if (placement != null) {
            PlacementAzure.Builder retValBuilder = PlacementAzure.Builder.get();
            if (placement.isNameSet()) {
                retValBuilder.setAvailabilityZoneName(placement.getName());
            }

            if (placement.isSubnetIdsSet()) {
                if (placement.getSubnetIds() != null) {
                    retValBuilder.setSubnetIds(new LinkedList<>(placement.getSubnetIds()));
                }
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupLaunchSpecificationAzure toBl(ApiLaunchSpecAzure launchSpecification) {
        ElastigroupLaunchSpecificationAzure retVal = null;

        if (launchSpecification != null) {

            ElastigroupLaunchSpecificationAzure.Builder retValBuilder = ElastigroupLaunchSpecificationAzure.Builder.get();

            if (launchSpecification.isHealthCheckTypeSet()) {
                retValBuilder.setHealthCheckType(launchSpecification.getHealthCheckType());
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

            if (launchSpecification.isImageIdSet()) {
                retValBuilder.setImageId(launchSpecification.getImageId());
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

            if (launchSpecification.isBlockDeviceMappingsSet()) {
                if (launchSpecification.getBlockDeviceMappings() != null) {
                    List<BlockDeviceMappingAzure> blBDM =
                            launchSpecification.getBlockDeviceMappings().stream().map(ElastigroupConverterAzure::toBl)
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
                    List<NetworkInterfaceAzure> blNIC =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverterAzure::toBl)
                                               .collect(Collectors.toList());
                    retValBuilder.setNetworkInterfaces(blNIC);
                }
            }

            if (launchSpecification.isTagsSet()) {
                if (launchSpecification.getTags() != null) {
                    List<TagAzure> tags = launchSpecification.getTags().stream().map(ElastigroupConverterAzure::toBl)
                                                        .collect(Collectors.toList());
                    retValBuilder.setTags(tags);
                }
            }

            retVal = retValBuilder.build();
        }


        return retVal;
    }

    private static TagAzure toBl(ApiTagAzure tag) {
        TagAzure retVal = null;

        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                TagAzure.Builder tagBuilder = TagAzure.Builder.get();
                retVal = tagBuilder.setTagKey(tag.getTagKey()).setTagValue(tag.getTagValue()).build();
            }
        }

        return retVal;
    }

    private static NetworkInterfaceAzure toBl(ApiNetworkInterfaceAzure networkInterface) {
        NetworkInterfaceAzure retVal = null;

        if (networkInterface != null) {
            NetworkInterfaceAzure.Builder retValBuilder = NetworkInterfaceAzure.Builder.get();

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

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static BlockDeviceMappingAzure toBl(ApiBlockDeviceAzure blockDevice) {
        BlockDeviceMappingAzure retVal = null;

        if (blockDevice != null) {

            BlockDeviceMappingAzure.Builder retValBuilder = BlockDeviceMappingAzure.Builder.get();

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

    private static LoadBalancerAzure toBl(ApiLoadBalancerAzure loadBalancer) {
        LoadBalancerAzure retVal = null;

        if (loadBalancer != null) {
            LoadBalancerAzure.Builder retValBuilder = LoadBalancerAzure.Builder.get();

            if (loadBalancer.isNameSet()) {
                retValBuilder.setName(loadBalancer.getName());
            }

            if (loadBalancer.isArnSet()) {
                retValBuilder.setArn(loadBalancer.getArn());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static EbsDeviceAzure toBl(ApiEbsDeviceAzure ebsDevice) {
        EbsDeviceAzure retVal = null;

        if (ebsDevice != null) {
            EbsDeviceAzure.Builder retValBuilder = EbsDeviceAzure.Builder.get();

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
                retValBuilder.setVolumeType(AzureVolumeTypeEnum.fromName(ebsDevice.getVolumeType()));
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static IamRoleAzure toBl(ApiIamRoleAzure iamRole) {
        IamRoleAzure retVal = null;

        if (iamRole != null) {
            IamRoleAzure.Builder retValBuilder = IamRoleAzure.Builder.get();

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

    private static ElastigroupInstanceTypesAzure toBl(ApiInstanceTypesAzure instanceTypes) {
        ElastigroupInstanceTypesAzure retVal = null;

        if (instanceTypes != null) {
            ElastigroupInstanceTypesAzure.Builder retValBuilder = ElastigroupInstanceTypesAzure.Builder.get();

            if (instanceTypes.isOndemandSet()) {
                retValBuilder.setOnDemandType(instanceTypes.getOndemand());
            }

            if (instanceTypes.isSpotSet()) {
                if (instanceTypes.getSpot() != null) {
                    retValBuilder.setSpotTypes(new LinkedList<>(instanceTypes.getSpot()));
                }
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupStrategyConfigurationAzure toBl(ApiStrategyAzure strategy) {
        ElastigroupStrategyConfigurationAzure retVal = null;

        if (strategy != null) {
            ElastigroupStrategyConfigurationAzure.Builder retValBuilder = ElastigroupStrategyConfigurationAzure.Builder.get();
            if (strategy.isRiskSet()) {
                retValBuilder.setSpotPercentage(strategy.getRisk());
            }

            if (strategy.isOnDemandCountSet()) {
                retValBuilder.setOnDemandCount(strategy.getOnDemandCount());
            }

            if (strategy.isAvailabilityVsCostSet()) {
                retValBuilder.setElastigroupOrientation(
                        ElastigroupOrientationEnumAzure.fromName(strategy.getAvailabilityVsCost()));
            }

            if (strategy.isDrainingTimeoutSet()) {
                retValBuilder.setDrainingTimeout(strategy.getDrainingTimeout());
            }

            if (strategy.isUtilizeReservedInstancesSet()) {
                retValBuilder.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }

            if (strategy.isFallbackToOdSet()) {
                retValBuilder.setFallbackToOnDemand(strategy.getFallbackToOd());
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static ElastigroupCapacityConfigurationAzure toBl(ApiCapacityAzure capacity) {
        ElastigroupCapacityConfigurationAzure retVal = null;

        if (capacity != null) {
            ElastigroupCapacityConfigurationAzure.Builder retValBuilder = ElastigroupCapacityConfigurationAzure.Builder.get();

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


    private static ElastigroupScalingConfigurationAzure toBl(ApiScalingAzure scaling) {
        ElastigroupScalingConfigurationAzure retVal = null;

        if (scaling != null) {
            ElastigroupScalingConfigurationAzure.Builder retValBuilder = ElastigroupScalingConfigurationAzure.Builder.get();

            if (scaling.isUpSet()) {
                if (scaling.getUp() != null) {
                    List<ApiScalingPolicyAzure> apiScalingPolicies = scaling.getUp();
                    List<ScalingPolicyAzure> scalingPolicies =
                            apiScalingPolicies.stream().map(ElastigroupConverterAzure::toBl)
                                              .collect(Collectors.toList());
                    retValBuilder.setUp(scalingPolicies);
                }
            }

            if (scaling.isDownSet()) {
                if (scaling.getDown() != null) {
                    List<ApiScalingPolicyAzure> apiScalingPolicies = scaling.getDown();
                    List<ScalingPolicyAzure> scalingPolicies =
                            apiScalingPolicies.stream().map(ElastigroupConverterAzure::toBl)
                                              .collect(Collectors.toList());
                    retValBuilder.setDown(scalingPolicies);
                }
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static LoadBalancersConfigAzure toBl(ApiLoadBalancersConfigAzure loadBalancersConfig) {
        LoadBalancersConfigAzure retVal = null;

        if (loadBalancersConfig != null) {
            LoadBalancersConfigAzure.Builder retValBuilder = LoadBalancersConfigAzure.Builder.get();
            List<ApiLoadBalancerAzure>       loadBalancers = loadBalancersConfig.getLoadBalancers();

            if (loadBalancersConfig.isLoadBalancersSet() && loadBalancers != null) {
                List<LoadBalancerAzure> blLoadBalancers =
                        loadBalancers.stream().map(ElastigroupConverterAzure::toBl).collect(Collectors.toList());
                retValBuilder.setLoadBalancers(blLoadBalancers);
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ScalingPolicyAzure toBl(ApiScalingPolicyAzure scalingPolicy) {
        ScalingPolicyAzure retVal = null;

        if (scalingPolicy != null) {
            ScalingPolicyAzure.Builder retValBuilder = ScalingPolicyAzure.Builder.get();

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
                    List<ApiScalingDimensionAzure> apiDimensions = scalingPolicy.getDimensions();
                    List<ScalingDimensionAzure> dimensions =
                            apiDimensions.stream().map(ElastigroupConverterAzure::toBl).collect(Collectors.toList());
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

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static ScalingDimensionAzure toBl(ApiScalingDimensionAzure scalingDimension) {
        ScalingDimensionAzure retVal = null;

        if (scalingDimension != null) {
            retVal = new ScalingDimensionAzure();

            if (scalingDimension.isNameSet()) {
                retVal.setName(scalingDimension.getName());
            }

            if (scalingDimension.isValueSet()) {
                retVal.setValue(scalingDimension.getValue());
            }
        }

        return retVal;
    }

    private static ScalingActionAzure toBl(ApiScalingActionAzure scalingAction) {
        ScalingActionAzure retVal = null;

        if (scalingAction != null) {
            retVal = new ScalingActionAzure();

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
    //endregion
}
