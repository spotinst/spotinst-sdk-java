package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.api.elastigroup.aws.*;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;

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
        }

        return retVal;
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

    private static ApiLoadBalancersConfig toDal(LoadBalancersConfig loadBalancersConfig) {
        ApiLoadBalancersConfig retVal           = new ApiLoadBalancersConfig();
        List<ApiLoadBalancer>  apiLoadBalancers = null;

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

    private static ApiInstanceTypes toDal(ElastigroupInstanceTypes instanceTypes) {
        ApiInstanceTypes retVal = null;

        if (instanceTypes != null) {
            retVal = new ApiInstanceTypes();
            if (instanceTypes.isOnDemandSet()) {
                retVal.setOndemand(instanceTypes.getOnDemand());
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
                    List <ApiInstanceTypesWeights> optWeights = instanceTypes.getWeights().stream().map(ElastigroupConverter::toDal).collect(Collectors.toList());
                    retVal.setWeights(optWeights);
                }
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

            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }

            if (strategy.isPersistenceSet()) {
                retVal.setPersistence(toDal(strategy.getPersistence()));
            }

            if (strategy.isRevertToSpotSet()) {
                retVal.setRevertToSpot(toDal(strategy.getRevertToSpot()));
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
        }

        return retVal;
    }

    private static ApiScalingPolicy toDal(ScalingPolicy scalingPolicy) {
        ApiScalingPolicy retVal = null;

        if (scalingPolicy != null) {
            retVal = new ApiScalingPolicy();

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

        if(elastigroupStopDeployment != null) {

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
            retVal = retValBuilder.build();
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
            retVal = retValBuilder.build();
        }

        return retVal;
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

            retVal = retValBuilder.build();
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

    private static ElastigroupInstanceTypes toBl(ApiInstanceTypes instanceTypes) {
        ElastigroupInstanceTypes retVal = null;

        if (instanceTypes != null) {
            ElastigroupInstanceTypes.Builder retValBuilder = ElastigroupInstanceTypes.Builder.get();

            if (instanceTypes.isOndemandSet()) {
                retValBuilder.setOnDemandType(instanceTypes.getOndemand());
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

            if (strategy.isFallbackToOdSet()) {
                retValBuilder.setFallbackToOnDemand(strategy.getFallbackToOd());
            }

            if (strategy.isPersistenceSet()) {
                retValBuilder.setPersistence(toBl(strategy.getPersistence()));
            }

            if (strategy.isRevertToSpotSet()) {
                retValBuilder.setRevertToSpot(toBl(strategy.getRevertToSpot()));
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

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static LoadBalancersConfig toBl(ApiLoadBalancersConfig loadBalancersConfig) {
        LoadBalancersConfig retVal = null;

        if (loadBalancersConfig != null) {
            LoadBalancersConfig.Builder retValBuilder = LoadBalancersConfig.Builder.get();
            List<ApiLoadBalancer>       loadBalancers = loadBalancersConfig.getLoadBalancers();

            if (loadBalancersConfig.isLoadBalancersSet() && loadBalancers != null) {
                List<LoadBalancer> blLoadBalancers =
                        loadBalancers.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                retValBuilder.setLoadBalancers(blLoadBalancers);
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ScalingPolicy toBl(ApiScalingPolicy scalingPolicy) {
        ScalingPolicy retVal = null;

        if (scalingPolicy != null) {
            ScalingPolicy.Builder retValBuilder = ScalingPolicy.Builder.get();

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

            if (elastigroupGetDeploymentStatusResponse.isNumOfBatchesSet()) {
                retVal.setNumOfBatches(elastigroupGetDeploymentStatusResponse.getNumOfBatches());
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

    public static ElastigroupListStatefulInstancesResponse toBl(
            ApiElastigroupListStatefulInstancesResponse elastigroupListStatefulInstancesResponse) {
        ElastigroupListStatefulInstancesResponse retVal = null;

        if (elastigroupListStatefulInstancesResponse != null) {
            retVal = new ElastigroupListStatefulInstancesResponse();

            if (elastigroupListStatefulInstancesResponse.isIdSet()) {
                retVal.setId(elastigroupListStatefulInstancesResponse.getId());
            }

            if (elastigroupListStatefulInstancesResponse.isInstanceIdSet()) {
                retVal.setInstanceId(elastigroupListStatefulInstancesResponse.getInstanceId());
            }

            if (elastigroupListStatefulInstancesResponse.isPrivateIpSet()) {
                retVal.setPrivateIp(elastigroupListStatefulInstancesResponse.getPrivateIp());
            }

            if (elastigroupListStatefulInstancesResponse.isImageIdSet()) {
                retVal.setImageId(elastigroupListStatefulInstancesResponse.getImageId());
            }

            if (elastigroupListStatefulInstancesResponse.isStateSet()) {
                retVal.setState(elastigroupListStatefulInstancesResponse.getState());
            }

            if (elastigroupListStatefulInstancesResponse.isDevicesSet()) {
                List<ElastigroupListStatefulInstancesDevices> devices = elastigroupListStatefulInstancesResponse.getDevices()
                        .stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
                retVal.setDevices(devices);
            }

            if (elastigroupListStatefulInstancesResponse.isLaunchedAtSet()) {
                retVal.setLaunchedAt(elastigroupListStatefulInstancesResponse.getLaunchedAt());
            }

            if (elastigroupListStatefulInstancesResponse.isCreatedAtSet()) {
                retVal.setCreatedAt(elastigroupListStatefulInstancesResponse.getCreatedAt());
            }

        }
        return retVal;

    }

    private static ElastigroupListStatefulInstancesDevices toBl(
            ApiElastigroupListStatefulInstancesDevices elastigroupListStatefulInstancesDevices) {
        ElastigroupListStatefulInstancesDevices retVal = null;

        if (elastigroupListStatefulInstancesDevices != null) {
            retVal = new ElastigroupListStatefulInstancesDevices();


            if (elastigroupListStatefulInstancesDevices.isDeviceNameSet()) {
                retVal.setDeviceName(elastigroupListStatefulInstancesDevices.getDeviceName());
            }

            if (elastigroupListStatefulInstancesDevices.isVolumeIdSet()) {
                retVal.setVolumeId(elastigroupListStatefulInstancesDevices.getVolumeId());
            }

            if (elastigroupListStatefulInstancesDevices.isSnapshotIdSet()) {
                retVal.setSnapshotId(elastigroupListStatefulInstancesDevices.getSnapshotId());
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

}