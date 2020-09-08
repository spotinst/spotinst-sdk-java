package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ElastigroupConverterAzure {
    //region BL -> DAL
    public static ApiElastigroupAzure toDal(ElastigroupAzure src) {
        ApiElastigroupAzure apiGroup = null;
        if (src != null) {
            apiGroup = new ApiElastigroupAzure();
            if (src.isNameSet()) {
                apiGroup.setName(src.getName());
            }
            if (src.isResourceGroupNameSet()) {
                apiGroup.setResourceGroupName(src.getResourceGroupName());
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
            if (src.isSchedulingSet()) {
                apiGroup.setScheduling(toDal(src.getScheduling()));
            }
            if (src.isHealthSet()) {
                apiGroup.setHealth(toDal(src.getHealth()));
            }
        }
        return apiGroup;
    }

    private static ApiElastigroupSchedulingAzure toDal(
            ElastigroupSchedulingConfigurationAzure schedulingConfiguration) {
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


    private static ApiGroupComputeAzure toDal(ElastigroupComputeConfigurationAzure compute) {
        ApiGroupComputeAzure optCompute = null;
        if (compute != null) {
            optCompute = new ApiGroupComputeAzure();
            if (compute.isOsSet()) {
                optCompute.setOs(compute.getOs());
            }
            if (compute.isLaunchSpecificationSet()) {
                optCompute.setLaunchSpecification(toDal(compute.getLaunchSpecification()));
            }
            if (compute.isVmSizesSet()) {
                if (compute.getVmSizes() != null) {
                    List<ApiElastigroupVmSizesAzure> vmSizes =
                            compute.getVmSizes().stream().map(ElastigroupConverterAzure::toDal)
                                   .collect(Collectors.toList());
                    optCompute.setVmSizes(vmSizes);
                }
            }
        }
        return optCompute;
    }

    private static ApiElastigroupVmSizesAzure toDal(ElastigroupVmSizesAzure vmSizes) {
        ApiElastigroupVmSizesAzure retVal = null;
        if (vmSizes != null) {
            retVal = new ApiElastigroupVmSizesAzure();
            if (vmSizes.isOdSizesSet()) {
                retVal.setOdSizes(vmSizes.getOdSizes());
            }
            if (vmSizes.isSpotSizesSet()) {
                if (vmSizes.getSpotSizes() != null) {
                    retVal.setSpotSizes(new LinkedList<>(vmSizes.getSpotSizes()));
                }
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecAzure toDal(ElastigroupLaunchSpecificationAzure launchSpecification) {
        ApiLaunchSpecAzure retVal = null;
        if (launchSpecification != null) {
            retVal = new ApiLaunchSpecAzure();
            if (launchSpecification.isCustomDataSet()) {
                retVal.setCustomData(launchSpecification.getCustomData());
            }
            if (launchSpecification.isLoadBalancersConfigSet()) {
                if (launchSpecification.getLoadBalancersConfig() != null) {
                    retVal.setLoadBalancersConfig(toDal(launchSpecification.getLoadBalancersConfig()));
                }
            }
            if (launchSpecification.isImageSet()) {
                if (launchSpecification.getImage() != null) {
                    retVal.setImage(toDal(launchSpecification.getImage()));
                }
            }
            if (launchSpecification.isNetworkSet()) {
                if (launchSpecification.getNetwork() != null) {
                    List<ApiNetworkAzure> optimizerNIC =
                            launchSpecification.getNetwork().stream().map(ElastigroupConverterAzure::toDal)
                                               .collect(Collectors.toList());
                    retVal.setNetwork(optimizerNIC);
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
            if (launchSpecification.isLoginSet()) {
                if (launchSpecification.getLogin() != null) {
                    List<ApiLoginAzure> optimizerLogin =
                            launchSpecification.getLogin().stream().map(ElastigroupConverterAzure::toDal)
                                               .collect(Collectors.toList());
                    retVal.setLogin(optimizerLogin);
                }
            }
        }
        return retVal;
    }

    private static ApiImageSpecAzure toDal(ImageSpecAzure imageSpecAzure) {
        ApiImageSpecAzure retVal = null;
        if (imageSpecAzure != null) {
            retVal = new ApiImageSpecAzure();
            if (imageSpecAzure.isMarketplaceSet()) {
                if (imageSpecAzure.getMarketplace() != null) {
                    List<ApiMarketplaceAzure> marketplaceAzures =
                            imageSpecAzure.getMarketplace().stream().map(ElastigroupConverterAzure::toDal)
                                          .collect(Collectors.toList());
                    retVal.setMarketplace(marketplaceAzures);
                }
            }
            if (imageSpecAzure.isCustomSet()) {
                if (imageSpecAzure.getCustom() != null) {
                    List<ApiCustomSpecAzure> customAzures =
                            imageSpecAzure.getCustom().stream().map(ElastigroupConverterAzure::toDal)
                                          .collect(Collectors.toList());
                    retVal.setCustom(customAzures);
                }
            }

        }
        return retVal;
    }

    private static ApiCustomSpecAzure toDal(CustomSpecAzure customSpecAzure) {
        ApiCustomSpecAzure retVal = null;
        if (customSpecAzure != null) {
            retVal = new ApiCustomSpecAzure();
            if (customSpecAzure.isNameSet()) {
                retVal.setName(customSpecAzure.getName());
            }
            if (customSpecAzure.isResourceGroupNameSet()) {
                retVal.setResourceGroupName(customSpecAzure.getResourceGroupName());
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

    private static ApiNetworkAzure toDal(NetworkAzure network) {
        ApiNetworkAzure retVal = null;
        if (network != null) {
            retVal = new ApiNetworkAzure();
            if (network.isResourceGroupNameSet()) {
                retVal.setResourceGroupName(network.getResourceGroupName());
            }
            if (network.isVirtualNetworkNameSet()) {
                retVal.setVirtualNetworkName(network.getVirtualNetworkName());
            }
            if (network.isNetworkInterfaceSet()) {
                List<NetworkInterfaceAzure> networkInterfaces = network.getNetworkInterfaces();
                if (networkInterfaces != null) {
                    List<ApiNetworkInterfaceAzure> apinetworkInterfaces =
                            network.getNetworkInterfaces().stream().map(ElastigroupConverterAzure::toDal)
                                   .collect(Collectors.toList());
                    retVal.setNetworkInterfaces(apinetworkInterfaces);
                }
            }
        }
        return retVal;
    }

    private static ApiLoadBalancersConfigAzure toDal(LoadBalancersConfigAzure loadBalancersConfig) {
        ApiLoadBalancersConfigAzure retVal = new ApiLoadBalancersConfigAzure();
        if (loadBalancersConfig.isLoadBalancersSet()) {
            List<LoadBalancerAzure> LoadBalancers = loadBalancersConfig.getLoadBalancers();
            if (LoadBalancers != null) {
                List<ApiLoadBalancerAzure> apiloadbalancers =
                        LoadBalancers.stream().map(ElastigroupConverterAzure::toDal).collect(Collectors.toList());
                retVal.setLoadBalancers(apiloadbalancers);
            }
        }
        return retVal;
    }

    private static ApiLoadBalancerAzure toDal(LoadBalancerAzure loadBalancer) {
        ApiLoadBalancerAzure retVal = null;
        if (loadBalancer != null) {
            retVal = new ApiLoadBalancerAzure();
            if (loadBalancer.isTypeSet()) {
                retVal.setType(loadBalancer.getType());
            }
            if (loadBalancer.isResourceGroupNameSet()) {
                retVal.setResourceGroupName(loadBalancer.getResourceGroupName());
            }
            if (loadBalancer.isNameSet()) {
                retVal.setName(loadBalancer.getName());
            }
            if (loadBalancer.isBackendPoolNamesSet()) {
                retVal.setBackendPoolNames(loadBalancer.getBackendPoolNames());
            }
            if (loadBalancer.isSkuSet()) {
                retVal.setSku(loadBalancer.getSku());
            }
        }
        return retVal;
    }

    private static ApiLoginAzure toDal(LoginAzure loginAzure) {
        ApiLoginAzure retVal = null;
        if (loginAzure != null) {
            retVal = new ApiLoginAzure();
            if (loginAzure.isPasswordSet()) {
                retVal.setPassword(loginAzure.getPassword());
            }
            if (loginAzure.isUserNameSet()) {
                retVal.setUserName(loginAzure.getUserName());
            }
            if (loginAzure.isSshPublicKeySet()) {
                retVal.setSshPublicKey(loginAzure.getSshPublicKey());
            }
        }
        return retVal;
    }

    private static ApiMarketplaceAzure toDal(MarketplaceAzure marketplaceAzure) {
        ApiMarketplaceAzure retVal = null;
        if (marketplaceAzure != null) {
            retVal = new ApiMarketplaceAzure();
            if (marketplaceAzure.isOfferSet()) {
                retVal.setOffer(marketplaceAzure.getOffer());
            }
            if (marketplaceAzure.isPublisherSet()) {
                retVal.setPublisher(marketplaceAzure.getPublisher());
            }
            if (marketplaceAzure.isSkuSet()) {
                retVal.setSku(marketplaceAzure.getSku());
            }
            if (marketplaceAzure.isVersionSet()) {
                retVal.setVersion(marketplaceAzure.getVersion());
            }
        }
        return retVal;
    }

    private static ApiAdditionalIpConfigurationsAzure toDal(AdditionalIpConfigurationsAzure configurationsAzure) {
        ApiAdditionalIpConfigurationsAzure retVal = null;

        if (configurationsAzure != null) {
            retVal = new ApiAdditionalIpConfigurationsAzure();
            if (configurationsAzure.isNameSet()) {
                retVal.setName(configurationsAzure.getName());
            }
            if (configurationsAzure.isPrivateIpAddressVersionSet()) {
                retVal.setPrivateIpAddressVersion(configurationsAzure.getPrivateIpAddressVersion());
            }
        }
        return retVal;
    }

    private static ApiStrategyAzure toDal(ElastigroupStrategyConfigurationAzure strategy) {
        ApiStrategyAzure retVal = null;
        if (strategy != null) {
            retVal = new ApiStrategyAzure();
            if (strategy.isSpotPercentageSet()) {
                retVal.setSpotPercentage(strategy.getSpotPercentage());
            }
            if (strategy.isOnDemandCountSet()) {
                retVal.setOnDemandCount(strategy.getOnDemandCount());
            }
            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }
            if (strategy.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(strategy.getDrainingTimeout());
            }
            if (strategy.isRevertToSpotSet()) {
                retVal.setRevertToSpot(toDal(strategy.getRevertToSpot()));
            }
            if (strategy.isOptimizationWindowsSet()) {
                if (strategy.getOptimizationWindows() != null) {
                    retVal.setOptimizationWindows(new LinkedList<>(strategy.getOptimizationWindows()));
                }
            }
        }
        return retVal;
    }

    private static ApiRevertToSpotSpecAzure toDal(RevertToSpotSpecAzure revertToSpot) {
        ApiRevertToSpotSpecAzure retVal = null;
        if (revertToSpot != null) {
            retVal = new ApiRevertToSpotSpecAzure();
            if (revertToSpot.isPerformAtSet()) {
                retVal.setPerformAt(revertToSpot.getPerformAt());
            }
        }
        return retVal;
    }

    private static ApiElastigroupHealthConfigurationAzure toDal(ElastigroupHealthConfigurationAzure health) {
        ApiElastigroupHealthConfigurationAzure retVal = null;
        if (health != null) {
            retVal = new ApiElastigroupHealthConfigurationAzure();
            if (health.isAutoHealingSet()) {
                retVal.setAutoHealing(health.getAutoHealing());
            }
            if (health.isHealthCheckTypesSet()) {
                retVal.setHealthCheckTypes(health.getHealthCheckTypes());
            }
            if (health.isGracePeriodSet()) {
                retVal.setGracePeriod(health.getGracePeriod());
            }
            if (health.isUnhealthyDurationSet()) {
                retVal.setUnhealthyDuration(health.getUnhealthyDuration());
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

    private static ApiNetworkInterfaceAzure toDal(NetworkInterfaceAzure networkInterfaceAzure) {
        ApiNetworkInterfaceAzure retVal = null;
        if (networkInterfaceAzure != null) {
            retVal = new ApiNetworkInterfaceAzure();
            if (networkInterfaceAzure.isIsPrimarySet()) {
                retVal.setIsPrimary(networkInterfaceAzure.getIsPrimary());
            }
            if (networkInterfaceAzure.isSubnetNameSet()) {
                retVal.setSubnetName(networkInterfaceAzure.getSubnetName());
            }
            if (networkInterfaceAzure.isSetAssignPublicIpSet()) {
                retVal.setAssignPublicIp(networkInterfaceAzure.getAssignPublicIp());
            }
            if (networkInterfaceAzure.isPublicIpSkuSet()) {
                retVal.setPublicIpSku(networkInterfaceAzure.getPublicIpSku());
            }
            if (networkInterfaceAzure.isEnableIPForwardingSet()) {
                retVal.setEnableIPForwarding(networkInterfaceAzure.getEnableIPForwarding());
            }
            if (networkInterfaceAzure.isAdditionalIpConfigurationsSet()) {
                List<AdditionalIpConfigurationsAzure> configurations =
                        networkInterfaceAzure.getAdditionalIpConfigurations();
                if (configurations != null) {
                    List<ApiAdditionalIpConfigurationsAzure> additionalIpConfigurationsAzures =
                            configurations.stream().map(ElastigroupConverterAzure::toDal).collect(Collectors.toList());
                    retVal.setAdditionalIpConfigurations(additionalIpConfigurationsAzures);
                }
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

    //TODO Nadav to review
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
            if (apiElastigroup.isResourceGroupNameSet()) {
                elastigroupBuilder.setResourceGroupName((apiElastigroup.getResourceGroupName()));
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
            if (apiElastigroup.isHealthSet()) {
                elastigroupBuilder.setHealth(toBl(apiElastigroup.getHealth()));
            }
            if (apiElastigroup.isStrategySet()) {
                elastigroupBuilder.setStrategy(toBl(apiElastigroup.getStrategy()));
            }
            if (apiElastigroup.isComputeSet()) {
                elastigroupBuilder.setCompute(toBl(apiElastigroup.getCompute()));
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

    private static ElastigroupComputeConfigurationAzure toBl(ApiGroupComputeAzure compute) {
        ElastigroupComputeConfigurationAzure blCompute = null;
        if (compute != null) {
            ElastigroupComputeConfigurationAzure.Builder blComputeBuilder =
                    ElastigroupComputeConfigurationAzure.Builder.get();

            if (compute.isOsSet()) {
                blComputeBuilder.setOs(compute.getOs());
            }
            if (compute.isLaunchSpecificationSet()) {
                blComputeBuilder.setLaunchSpecification(toBl(compute.getLaunchSpecification()));
            }
            if (compute.isVmSizesSet()) {
                if (compute.getVmSizes() != null) {
                    List<ApiElastigroupVmSizesAzure> ApiElastigroupVmSizesAzure = compute.getVmSizes();
                    List<ElastigroupVmSizesAzure> ElastigroupVmSizesAzure =
                            ApiElastigroupVmSizesAzure.stream().map(ElastigroupConverterAzure::toBl)
                                                      .collect(Collectors.toList());
                    blComputeBuilder.setVmSizes(ElastigroupVmSizesAzure);
                }
            }
            blCompute = blComputeBuilder.build();
        }
        return blCompute;
    }

    private static ElastigroupLaunchSpecificationAzure toBl(ApiLaunchSpecAzure launchSpecification) {
        ElastigroupLaunchSpecificationAzure retVal = null;
        if (launchSpecification != null) {
            ElastigroupLaunchSpecificationAzure.Builder retValBuilder =
                    ElastigroupLaunchSpecificationAzure.Builder.get();
            if (launchSpecification.isCustomDataSet()) {
                retValBuilder.setCustomData(launchSpecification.getCustomData());
            }
            if (launchSpecification.isLoadBalancersConfigSet()) {
                if (launchSpecification.getLoadBalancersConfig() != null) {
                    retValBuilder.setLoadBalancersConfig(toBl(launchSpecification.getLoadBalancersConfig()));
                }
            }
            if (launchSpecification.isImageSet()) {
                if (launchSpecification.getImage() != null) {
                    retValBuilder.setImage(toBl(launchSpecification.getImage()));
                }
            }
            if (launchSpecification.isNetworkSet()) {
                if (launchSpecification.getNetwork() != null) {
                    List<NetworkAzure> blNIC =
                            launchSpecification.getNetwork().stream().map(ElastigroupConverterAzure::toBl)
                                               .collect(Collectors.toList());
                    retValBuilder.setNetwork(blNIC);
                }
            }
            if (launchSpecification.isLoginSet()) {
                if (launchSpecification.getLogin() != null) {
                    List<LoginAzure> loginAzures =
                            launchSpecification.getLogin().stream().map(ElastigroupConverterAzure::toBl)
                                               .collect(Collectors.toList());
                    retValBuilder.setLogin(loginAzures);
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

    private static ImageSpecAzure toBl(ApiImageSpecAzure apiImageSpecAzure) {
        ImageSpecAzure retVal = null;
        if (apiImageSpecAzure != null) {
            ImageSpecAzure.Builder retValBuilder = ImageSpecAzure.Builder.get();
            if (apiImageSpecAzure.isMarketplaceSet()) {
                if (apiImageSpecAzure.getMarketplace() != null) {
                    List<MarketplaceAzure> marketplaceAzures =
                            apiImageSpecAzure.getMarketplace().stream().map(ElastigroupConverterAzure::toBl)
                                             .collect(Collectors.toList());
                    retValBuilder.setMarketplace(marketplaceAzures);
                }
            }
            if (apiImageSpecAzure.isCustomSet()) {
                if (apiImageSpecAzure.getCustom() != null) {
                    List<CustomSpecAzure> customSpec =
                            apiImageSpecAzure.getCustom().stream().map(ElastigroupConverterAzure::toBl)
                                             .collect(Collectors.toList());
                    retValBuilder.setCustom(customSpec);
                }
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static RevertToSpotSpecAzure toBl(ApiRevertToSpotSpecAzure revertToSpotSpecAzure) {
        RevertToSpotSpecAzure retVal = null;
        if (revertToSpotSpecAzure != null) {
            if (revertToSpotSpecAzure.isPerformAtSet()) {
                RevertToSpotSpecAzure.Builder retBuilder = RevertToSpotSpecAzure.Builder.get();
                retVal = retBuilder.setPerformAt(revertToSpotSpecAzure.getPerformAt()).build();
            }
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

    private static CustomSpecAzure toBl(ApiCustomSpecAzure apiCustomSpecAzure) {
        CustomSpecAzure retVal = null;
        if (apiCustomSpecAzure != null) {
            CustomSpecAzure.Builder retValBuilder = CustomSpecAzure.Builder.get();
            if (apiCustomSpecAzure.isResourceGroupNameSet()) {
                retValBuilder.setResourceGroupName(apiCustomSpecAzure.getResourceGroupName());
            }
            if (apiCustomSpecAzure.isNameSet()) {
                retValBuilder.setName(apiCustomSpecAzure.getName());
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static NetworkAzure toBl(ApiNetworkAzure network) {
        NetworkAzure retVal = null;
        if (network != null) {
            NetworkAzure.Builder retValBuilder = NetworkAzure.Builder.get();
            if (network.isResourceGroupNameSet()) {
                retValBuilder.setResourceGroupName(network.getResourceGroupName());
            }
            if (network.isVirtualNetworkNameSet()) {
                retValBuilder.setVirtualNetworkName(network.getVirtualNetworkName());
            }
            if (network.isNetworkInterfaceSet()) {
                if (network.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterfaceAzure> apiNetworkInterfaceAzure = network.getNetworkInterfaces();
                    List<NetworkInterfaceAzure> networkInterfaceAzure =
                            apiNetworkInterfaceAzure.stream().map(ElastigroupConverterAzure::toBl)
                                                    .collect(Collectors.toList());
                    retValBuilder.setNetworkInterfaces(networkInterfaceAzure);
                }
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static LoginAzure toBl(ApiLoginAzure apiLoginAzure) {
        LoginAzure retVal = null;
        if (apiLoginAzure != null) {
            LoginAzure.Builder retValBuilder = LoginAzure.Builder.get();
            if (apiLoginAzure.isPasswordSet()) {
                retValBuilder.setPassword(apiLoginAzure.getPassword());
            }
            if (apiLoginAzure.isUserNameSet()) {
                retValBuilder.setUserName(apiLoginAzure.getUserName());
            }
            if (apiLoginAzure.isSshPublicKeySet()) {
                retValBuilder.setSshPublicKey(apiLoginAzure.getSshPublicKey());
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static MarketplaceAzure toBl(ApiMarketplaceAzure apiMarketplaceAzure) {
        MarketplaceAzure retVal = null;
        if (apiMarketplaceAzure != null) {
            MarketplaceAzure.Builder retValBuilder = MarketplaceAzure.Builder.get();
            if (apiMarketplaceAzure.isOfferSet()) {
                retValBuilder.setOffer(apiMarketplaceAzure.getOffer());
            }
            if (apiMarketplaceAzure.isPublisherSet()) {
                retValBuilder.setPublisher(apiMarketplaceAzure.getPublisher());
            }
            if (apiMarketplaceAzure.isSkuSet()) {
                retValBuilder.setSku(apiMarketplaceAzure.getSku());
            }
            if (apiMarketplaceAzure.isVersionSet()) {
                retValBuilder.setVersion(apiMarketplaceAzure.getVersion());
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static LoadBalancerAzure toBl(ApiLoadBalancerAzure loadBalancer) {
        LoadBalancerAzure retVal = null;
        if (loadBalancer != null) {
            LoadBalancerAzure.Builder retValBuilder = LoadBalancerAzure.Builder.get();
            if (loadBalancer.isTypeSet()) {
                retValBuilder.setType(loadBalancer.getType());
            }
            if (loadBalancer.isResourceGroupNameSet()) {
                retValBuilder.setResourceGroupName(loadBalancer.getResourceGroupName());
            }
            if (loadBalancer.isNameSet()) {
                retValBuilder.setName(loadBalancer.getName());
            }
            if (loadBalancer.isBackendPoolNamesSet()) {
                retValBuilder.setBackendPoolNames(loadBalancer.getBackendPoolNames());
            }
            if (loadBalancer.isSkuSet()) {
                retValBuilder.setSku(loadBalancer.getSku());
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static AdditionalIpConfigurationsAzure toBl(
            ApiAdditionalIpConfigurationsAzure apiAdditionalIpConfigurationsAzure) {
        AdditionalIpConfigurationsAzure retVal = null;
        if (apiAdditionalIpConfigurationsAzure != null) {
            AdditionalIpConfigurationsAzure.Builder retValBuilder = AdditionalIpConfigurationsAzure.Builder.get();
            if (apiAdditionalIpConfigurationsAzure.isNameSet()) {
                retValBuilder.setName(apiAdditionalIpConfigurationsAzure.getName());
            }
            if (apiAdditionalIpConfigurationsAzure.isPrivateIpAddressVersionSet()) {
                retValBuilder
                        .setPrivateIpAddressVersion(apiAdditionalIpConfigurationsAzure.getPrivateIpAddressVersion());
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static ElastigroupStrategyConfigurationAzure toBl(ApiStrategyAzure strategy) {
        ElastigroupStrategyConfigurationAzure retVal = null;
        if (strategy != null) {
            ElastigroupStrategyConfigurationAzure.Builder retValBuilder =
                    ElastigroupStrategyConfigurationAzure.Builder.get();
            if (strategy.isSpotPercentageSet()) {
                retValBuilder.setSpotPercentage(strategy.getSpotPercentage());
            }
            if (strategy.isOnDemandCountSet()) {
                retValBuilder.setOnDemandCount(strategy.getOnDemandCount());
            }
            if (strategy.isOptimizationWindowsSet()) {
                retValBuilder.setOptimizationWindows(strategy.getOptimizationWindows());
            }
            if (strategy.isRevertToSpotSet()) {
                retValBuilder.setRevertToSpot(toBl(strategy.getRevertToSpot()));
            }
            if (strategy.isFallbackToOdSet()) {
                retValBuilder.setFallbackToOd(strategy.getFallbackToOd());
            }
            if (strategy.isDrainingTimeoutSet()) {
                retValBuilder.setDrainingTimeout(strategy.getDrainingTimeout());
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static ElastigroupHealthConfigurationAzure toBl(ApiElastigroupHealthConfigurationAzure health) {
        ElastigroupHealthConfigurationAzure retVal = null;
        if (health != null) {
            ElastigroupHealthConfigurationAzure.Builder retValBuilder =
                    ElastigroupHealthConfigurationAzure.Builder.get();
            if (health.isHealthCheckTypesSet()) {
                retValBuilder.setHealthCheckTypes(health.getHealthCheckTypes());
            }
            if (health.isAutoHealingSet()) {
                retValBuilder.setAutoHealing(health.getAutoHealing());
            }
            if (health.isGracePeriodSet()) {
                retValBuilder.setGracePeriod(health.getGracePeriod());
            }
            if (health.isUnhealthyDurationSet()) {
                retValBuilder.setUnhealthyDuration(health.getUnhealthyDuration());
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }

    private static ElastigroupCapacityConfigurationAzure toBl(ApiCapacityAzure capacity) {
        ElastigroupCapacityConfigurationAzure retVal = null;
        if (capacity != null) {
            ElastigroupCapacityConfigurationAzure.Builder retValBuilder =
                    ElastigroupCapacityConfigurationAzure.Builder.get();
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

    private static ElastigroupScalingConfigurationAzure toBl(ApiScalingAzure scaling) {
        ElastigroupScalingConfigurationAzure retVal = null;
        if (scaling != null) {
            ElastigroupScalingConfigurationAzure.Builder retValBuilder =
                    ElastigroupScalingConfigurationAzure.Builder.get();
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

    private static NetworkInterfaceAzure toBl(ApiNetworkInterfaceAzure networkInterfaceAzure) {
        NetworkInterfaceAzure retVal = null;
        if (networkInterfaceAzure != null) {
            NetworkInterfaceAzure.Builder retValBuilder = NetworkInterfaceAzure.Builder.get();
            if (networkInterfaceAzure.isIsPrimarySet()) {
                retValBuilder.setIsPrimary(networkInterfaceAzure.getIsPrimary());
            }
            if (networkInterfaceAzure.isSubnetNameSet()) {
                retValBuilder.setSubnetName(networkInterfaceAzure.getSubnetName());
            }
            if (networkInterfaceAzure.isAssignPublicIpSet()) {
                retValBuilder.setAssignPublicIp(networkInterfaceAzure.getAssignPublicIp());
            }
            if (networkInterfaceAzure.isPublicIpSkuSet()) {
                retValBuilder.setPublicIpSku(networkInterfaceAzure.getPublicIpSku());
            }
            if (networkInterfaceAzure.isEnableIPForwardingSet()) {
                retValBuilder.setEnableIPForwarding(networkInterfaceAzure.getEnableIPForwarding());
            }
            if (networkInterfaceAzure.isAdditionalIpConfigurationsSet()) {
                if (networkInterfaceAzure.getAdditionalIpConfigurations() != null) {
                    List<ApiAdditionalIpConfigurationsAzure> apiAdditionalIpConfigurationsAzure =
                            networkInterfaceAzure.getAdditionalIpConfigurations();
                    List<AdditionalIpConfigurationsAzure> additionalIpConfigurationsAzure =
                            apiAdditionalIpConfigurationsAzure.stream().map(ElastigroupConverterAzure::toBl)
                                                              .collect(Collectors.toList());
                    retValBuilder.setAdditionalIpConfigurations(additionalIpConfigurationsAzure);
                }
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

    private static ElastigroupVmSizesAzure toBl(ApiElastigroupVmSizesAzure vmSizes) {
        ElastigroupVmSizesAzure retVal = null;
        if (vmSizes != null) {
            ElastigroupVmSizesAzure.Builder retValBuilder = ElastigroupVmSizesAzure.Builder.get();
            if (vmSizes.isSpotSizesSet()) {
                retValBuilder.setSpotSizes(vmSizes.getSpotSizes());
            }
            if (vmSizes.isOdSizesSet()) {
                if (vmSizes.getOdSizes() != null) {
                    retValBuilder.setOdSizes(new LinkedList<>(vmSizes.getOdSizes()));
                }
            }
            retVal = retValBuilder.build();
        }
        return retVal;
    }
    //endregion
}
