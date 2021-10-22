package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.ElastigroupScalingResponse;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.*;
import com.sun.istack.internal.Nullable;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
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
            if (src.isRegionSet()) {
                apiGroup.setRegion(src.getRegion());
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
                optCompute.setVmSizes(toDal(compute.getVmSizes()));
            }
        }
        return optCompute;
    }

    private static ApiElastigroupVmSizesAzure toDal(ElastigroupVmSizesAzure vmSizes) {
        ApiElastigroupVmSizesAzure retVal = null;
        if (vmSizes != null) {
            retVal = new ApiElastigroupVmSizesAzure();
            if (vmSizes.isOdSizesSet()) {
                retVal.setOdSizes(new LinkedList<>(vmSizes.getOdSizes()));
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
                    retVal.setNetwork(toDal(launchSpecification.getNetwork()));
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
                    retVal.setLogin(toDal(launchSpecification.getLogin()));
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
                retVal.setMarketplace(toDal(imageSpecAzure.getMarketplace()));
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

    private static ApiVmsAzure toDal(VmsAzure vms) {
        ApiVmsAzure retVal = null;
        if (vms != null) {
            retVal = new ApiVmsAzure();
//            if (vms.isCreatedAtSet()) {
//                retVal.setCreatedAt(vms.getCreatedAt());
//            }
            if (vms.isLifeCycleSet()) {
                retVal.setLifeCycle(vms.getLifeCycle());
            }
//            if (vms.isOsSet()) {
//                retVal.setOs(vms.getOs());
//            }
//            if (vms.isPowerStateSet()) {
//                retVal.setPowerState(vms.getPowerState());
//            }
//            if (vms.isPrivateIpSet()) {
//                retVal.setPrivateIp(vms.getPrivateIp());
//            }
//            if (vms.isProvisioningStateSet()) {
//                retVal.setProvisioningState(vms.getProvisioningState());
//            }
//            if (vms.isPublicIpSet()) {
//                retVal.setPublicIp(vms.getPublicIp());
//            }
//            if (vms.isRegionSet()) {
//                retVal.setRegion(vms.getRegion());
//            }
            if (vms.isVmNameSet()) {
                retVal.setVmName(vms.getVmName());
            }
            if (vms.isVmSizeSet()) {
                retVal.setVmSize(vms.getVmSize());
            }
        }
        return retVal;
    }

    public static ApiElastigroupStatusAzure toDal(ElastigroupStatusAzure groupStatus) {
        ApiElastigroupStatusAzure retVal = null;
        if (groupStatus != null) {
            retVal = new ApiElastigroupStatusAzure();
            if (groupStatus.isStatusSet()) {
                retVal.setStatus(groupStatus.getStatus());
            }
            if (groupStatus.isSuspendedProcessesSet()) {
                retVal.setSuspendedProcesses(groupStatus.getSuspendedProcesses());
            }
            if (groupStatus.isVmsSet()) {
                List<ApiVmsAzure> vmsAzures = groupStatus.getVms().stream().map(ElastigroupConverterAzure::toDal)
                        .collect(Collectors.toList());
                retVal.setVms(vmsAzures);
            }
        }
        return retVal;
    }

    public static APIElastigroupScalingResponseAzure toDal(ElastigroupScalingResponseAzure scalingResponseAzure) {
        APIElastigroupScalingResponseAzure retVal = null;
        if (scalingResponseAzure != null) {
            retVal = new APIElastigroupScalingResponseAzure();
//            if (scalingResponseAzure.isStatusSet()) {
//                retVal.setStatus(scalingResponseAzure.getStatus());
//            }
//            if (scalingResponseAzure.isSuspendedProcessesSet()) {
//                retVal.setSuspendedProcesses(scalingResponseAzure.getSuspendedProcesses());
//            }
            if (scalingResponseAzure.isVmsSet()) {
                List<ApiVmsAzure> vmsAzures = scalingResponseAzure.getVms().stream().map(ElastigroupConverterAzure::toDal)
                        .collect(Collectors.toList());
                retVal.setVms(vmsAzures);
            }
        }
        return retVal;
    }

    public static ApiElastigroupVmSignalAzure toDal(ElastigroupVmSignalAzure vmSignal) {
        ApiElastigroupVmSignalAzure retVal = null;
        if (vmSignal != null) {
            retVal = new ApiElastigroupVmSignalAzure();
            if (vmSignal.isSignalTypeSet()) {
                retVal.setSignalType(vmSignal.getSignalType());
            }
            if (vmSignal.isVmNameSet()) {
                retVal.setVmName(vmSignal.getVmName());
            }
        }
        return retVal;
    }

    public static ApiElastigroupUpdateCapacityAzure toDal(ElastigroupUpdateCapacityAzure capacityAzure) {
        ApiElastigroupUpdateCapacityAzure retVal = null;
        if (capacityAzure != null) {
            retVal = new ApiElastigroupUpdateCapacityAzure();
            if (capacityAzure.isMinimumSet()) {
                retVal.setMinimum(capacityAzure.getMinimum());
            }
            if (capacityAzure.isMaximumSet()) {
                retVal.setMaximum(capacityAzure.getMaximum());
            }
            if (capacityAzure.isTargetSet()) {
                retVal.setTarget(capacityAzure.getTarget());
            }
        }
        return retVal;
    }

    public static ApiVmHealthinessAzure toDal(VmHealthinessAzure vmHealthinessAzure) {
        ApiVmHealthinessAzure retVal = null;
        if (vmHealthinessAzure != null) {
            retVal = new ApiVmHealthinessAzure();
            if (vmHealthinessAzure.isHealthStatusSet()) {
                retVal.setHealthStatus(vmHealthinessAzure.getHealthStatus());
            }
            if (vmHealthinessAzure.isLifeCycleSet()) {
                retVal.setLifeCycle(vmHealthinessAzure.getLifeCycle());
            }
            if (vmHealthinessAzure.isVmNameSet()) {
                retVal.setVmName(vmHealthinessAzure.getVmName());
            }
        }
        return retVal;
    }

//    public static List<ApiSuspendgroupProcessesAzure> toDal(List<SuspendGroupProcessesAzure> suspendGroupProcesses, @Nullable String dummy) {
//
//        List<ApiSuspendgroupProcessesAzure> retVal = null;
//        if (suspendGroupProcesses != null) {
//            retVal = new ArrayList<ApiSuspendgroupProcessesAzure>();
//            for(SuspendGroupProcessesAzure process : suspendGroupProcesses) {
//                ApiSuspendgroupProcessesAzure apiProcess = new ApiSuspendgroupProcessesAzure();
//                if (process.isNameSet()) {
//                    apiProcess.setName(process.getName());
//                }
//                if (process.isTtlInMinutesSet()) {
//                    apiProcess.setTtlInMinutes(process.getTtlInMinutes());
//                }
//                retVal.add(apiProcess);
//            }
//        }
//        return retVal;
//    }

    public static List<ApiResumeGroupProcessesAzure> toDal(List<ResumeGroupProcessesAzure> resumeGroupProcesses) {
        List<ApiResumeGroupProcessesAzure> retVal = null;
        if (resumeGroupProcesses != null) {
            retVal = new ArrayList<ApiResumeGroupProcessesAzure>();
            for(ResumeGroupProcessesAzure groupProcess : resumeGroupProcesses) {
                ApiResumeGroupProcessesAzure apiProcess = new ApiResumeGroupProcessesAzure();
                if (groupProcess.isNameSet()) {
                    apiProcess.setName(groupProcess.getName());
                }
                retVal.add(apiProcess);
            }
        }
        return retVal;
    }

    public static ApiDetachVmsAzure toDal(DetachVmsAzure detachVmsAzure) {
        ApiDetachVmsAzure retVal = null;
        if (detachVmsAzure != null) {
            retVal = new ApiDetachVmsAzure();
            if (detachVmsAzure.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(detachVmsAzure.getDrainingTimeout());
            }

            if (detachVmsAzure.isShouldDecrementTargetCapacitySet()) {
                retVal.setShouldDecrementTargetCapacity(detachVmsAzure.getShouldDecrementTargetCapacity());
            }

            if (detachVmsAzure.isShouldTerminateVmsSet()) {
                retVal.setShouldTerminateVms(detachVmsAzure.getShouldTerminateVms());
            }

            if (detachVmsAzure.isVmsToDetachSet()) {
                retVal.setVmsToDetach(detachVmsAzure.getVmsToDetach());
            }
        }
        return retVal;
    }

    private static ApiDetachedVmsAzure toDal(DetachedVmsAzure detachedVmsAzure) {
        ApiDetachedVmsAzure retVal = null;
        if (detachedVmsAzure != null) {
            retVal = new ApiDetachedVmsAzure();

            if (detachedVmsAzure.isLifeCycleSet()) {
                retVal.setLifeCycle(detachedVmsAzure.getLifeCycle());
            }
            if (detachedVmsAzure.isOsSet()) {
                retVal.setOs(detachedVmsAzure.getOs());
            }
            if (detachedVmsAzure.isPrivateIpSet()) {
                retVal.setPrivateIp(detachedVmsAzure.getPrivateIp());
            }
            if (detachedVmsAzure.isPublicIpSet()) {
                retVal.setPublicIp(detachedVmsAzure.getPublicIp());
            }
            if (detachedVmsAzure.isRegionSet()) {
                retVal.setRegion(detachedVmsAzure.getRegion());
            }
            if (detachedVmsAzure.isVmNameSet()) {
                retVal.setVmName(detachedVmsAzure.getVmName());
            }
            if (detachedVmsAzure.isVmSizeSet()) {
                retVal.setVmSize(detachedVmsAzure.getVmSize());
            }
        }
        return retVal;
    }

    private static ApiNewVmsAzure toDal(NewVmsAzure newVms) {
        ApiNewVmsAzure retVal = null;
        if (newVms != null) {
            retVal = new ApiNewVmsAzure();
            if (newVms.isCreatedAtSet()) {
                retVal.setCreatedAt(newVms.getCreatedAt());
            }
            if (newVms.isLifeCycleSet()) {
                retVal.setLifeCycle(newVms.getLifeCycle());
            }
            if (newVms.isOsSet()) {
                retVal.setOs(newVms.getOs());
            }
            if (newVms.isPowerStateSet()) {
                retVal.setPowerState(newVms.getPowerState());
            }
            if (newVms.isPrivateIpSet()) {
                retVal.setPrivateIp(newVms.getPrivateIp());
            }
            if (newVms.isProvisioningStateSet()) {
                retVal.setProvisioningState(newVms.getProvisioningState());
            }
            if (newVms.isPublicIpSet()) {
                retVal.setPublicIp(newVms.getPublicIp());
            }
            if (newVms.isRegionSet()) {
                retVal.setRegion(newVms.getRegion());
            }
            if (newVms.isVmNameSet()) {
                retVal.setVmName(newVms.getVmName());
            }
            if (newVms.isVmSizeSet()) {
                retVal.setVmSize(newVms.getVmSize());
            }
        }
        return retVal;
    }

    public static ApiElastigroupDetachedVmsAzure toDal(ElastigroupDetachedVmsAzure detachVmsAzure) {
        ApiElastigroupDetachedVmsAzure retVal = null;
        if (detachVmsAzure != null) {
            retVal = new ApiElastigroupDetachedVmsAzure();
            if (detachVmsAzure.isDetachedVmsSet()) {
                List<ApiDetachedVmsAzure> detachVms = detachVmsAzure.getDetachedVms().stream().map(ElastigroupConverterAzure::toDal)
                        .collect(Collectors.toList());
                retVal.setDetachedVms(detachVms);
            }

            if (detachVmsAzure.isNewVmsAzureSet()) {
                List<ApiNewVmsAzure> newVms = detachVmsAzure.getNewVmsAzure().stream().map(ElastigroupConverterAzure::toDal)
                        .collect(Collectors.toList());
                retVal.setNewVmsAzure(newVms);
            }
        }
        return retVal;
    }

    public static ApiGetElastilogAzure toDal(GetElastilogAzure elastilogAzure) {
        ApiGetElastilogAzure retVal = null;
        if (elastilogAzure != null) {
            retVal = new ApiGetElastilogAzure();
            if (elastilogAzure.isCreatedAtSet()) {
                retVal.setCreatedAt(elastilogAzure.getCreatedAt());
            }
            if (elastilogAzure.isMessageSet()) {
                retVal.setMessage(elastilogAzure.getMessage());
            }
            if (elastilogAzure.isSeveritySet()) {
                retVal.setSeverity(elastilogAzure.getSeverity());
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
            if (apiScheduledTask.isGracePeriodSet()) {
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
                blComputeBuilder.setVmSizes(toBl(compute.getVmSizes()));
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
                    retValBuilder.setNetwork(toBl(launchSpecification.getNetwork()));
                }
            }
            if (launchSpecification.isLoginSet()) {
                if (launchSpecification.getLogin() != null) {
                    retValBuilder.setLogin(toBl(launchSpecification.getLogin()));
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
                retValBuilder.setMarketplace(toBl(apiImageSpecAzure.getMarketplace()));
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
            List<ApiLoadBalancerAzure> loadBalancers = loadBalancersConfig.getLoadBalancers();
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
                if (vmSizes.getSpotSizes() != null) {
                    retValBuilder.setSpotSizes(new LinkedList<>(vmSizes.getSpotSizes()));
                }
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

    private static VmsAzure toBl(ApiVmsAzure vmsAzure) {
        VmsAzure retVal = null;
        if (vmsAzure != null) {
            VmsAzure.Builder vmsBuilder = VmsAzure.Builder.get();
//            if (vmsAzure.isCreatedAtSet()) {
//                vmsBuilder.setCreatedAt(vmsAzure.getCreatedAt());
//            }
            if (vmsAzure.isLifeCycleSet()) {
                vmsBuilder.setLifeCycle(vmsAzure.getLifeCycle());
            }
//            if (vmsAzure.isOsSet()) {
//                vmsBuilder.setOs(vmsAzure.getOs());
//            }
//            if (vmsAzure.isPowerStateSet()) {
//                vmsBuilder.setPowerState(vmsAzure.getPowerState());
//            }
//            if (vmsAzure.isPrivateIpSet()) {
//                vmsBuilder.setPrivateIp(vmsAzure.getPrivateIp());
//            }
//            if (vmsAzure.isProvisioningStateSet()) {
//                vmsBuilder.setProvisioningState(vmsAzure.getProvisioningState());
//            }
//            if (vmsAzure.isPublicIpSet()) {
//                vmsBuilder.setPublicIp(vmsAzure.getPublicIp());
//            }
//            if (vmsAzure.isRegionSet()) {
//                vmsBuilder.setRegion(vmsAzure.getRegion());
//            }
            if (vmsAzure.isVmNameSet()) {
                vmsBuilder.setVmName(vmsAzure.getVmName());
            }
            if (vmsAzure.isVmSizeSet()) {
                vmsBuilder.setVmSize(vmsAzure.getVmSize());
            }
            retVal = vmsBuilder.build();
        }
        return retVal;
    }

    public static ElastigroupStatusAzure toBl(ApiElastigroupStatusAzure elastigroupStatusAzure) {
        ElastigroupStatusAzure retVal = null;
        if (elastigroupStatusAzure != null) {
            ElastigroupStatusAzure.Builder elastiBuilder = ElastigroupStatusAzure.Builder.get();
            if (elastigroupStatusAzure.isStatusSet()) {
                if (elastigroupStatusAzure.getStatus() != null) {
                    elastiBuilder.setStatus(elastigroupStatusAzure.getStatus());
//                    ElastigroupStatusEnumAzure statusEnum = ElastigroupStatusEnumAzure.fromName(elastigroupStatusAzure.getStatus());
//                    elastiBuilder.setStatus(statusEnum);
                }
            }
            if (elastigroupStatusAzure.isSuspendedProcessesSet()) {
                elastiBuilder.setSuspendedProcesses(elastigroupStatusAzure.getSuspendedProcesses());
            }
            if (elastigroupStatusAzure.isVmsSet()) {
                List<VmsAzure> vms = elastigroupStatusAzure.getVms().stream().map(ElastigroupConverterAzure::toBl)
                        .collect(Collectors.toList());
                elastiBuilder.setVms(vms);
            }
            retVal = elastiBuilder.build();
        }
        return retVal;
    }

    public static ElastigroupScalingResponseAzure toBl(APIElastigroupScalingResponseAzure elastigroupStatusAzure) {
        ElastigroupScalingResponseAzure retVal = null;
        if (elastigroupStatusAzure != null) {
            ElastigroupScalingResponseAzure.Builder elastiBuilder = ElastigroupScalingResponseAzure.Builder.get();
//            if (elastigroupStatusAzure.isStatusSet()) {
//                if (elastigroupStatusAzure.getStatus() != null) {
//                    elastiBuilder.setStatus(elastigroupStatusAzure.getStatus());
//                }
//            }
//            if (elastigroupStatusAzure.isSuspendedProcessesSet()) {
//                elastiBuilder.setSuspendedProcesses(elastigroupStatusAzure.getSuspendedProcesses());
//            }
            if (elastigroupStatusAzure.isVmsSet()) {
                List<VmsAzure> vms = elastigroupStatusAzure.getVms().stream().map(ElastigroupConverterAzure::toBl)
                        .collect(Collectors.toList());
                elastiBuilder.setVms(vms);
            }
            retVal = elastiBuilder.build();
        }
        return retVal;
    }

//    public static ElastigroupVmSignalAzure toBl(ApiElastigroupVmSignalAzure elastigroupVmSignal) {
//        ElastigroupVmSignalAzure retVal = null;
//        if (elastigroupVmSignal != null) {
//            ElastigroupVmSignalAzure.Builder elastiBuilder = ElastigroupVmSignalAzure.Builder.get();
//            if (elastigroupVmSignal.isSignalTypeSet()) {
//                elastiBuilder.setSignalType(elastigroupVmSignal.getSignalType());
//            }
//            if (elastigroupVmSignal.isVmNameSet()) {
//                elastiBuilder.setVmName(elastigroupVmSignal.getVmName());
//            }
//            retVal = elastiBuilder.build();
//        }
//        return retVal;
//    }

    public static ElastigroupUpdateCapacityAzure toBl(ApiElastigroupUpdateCapacityAzure apiCapacityAzure) {
        ElastigroupUpdateCapacityAzure retVal = null;
        if (apiCapacityAzure != null) {
            ElastigroupUpdateCapacityAzure.Builder capacityBuilder = ElastigroupUpdateCapacityAzure.Builder.get();
            if (apiCapacityAzure.isMinimumSet()) {
                capacityBuilder.setMinimum(apiCapacityAzure.getMinimum());
            }
            if (apiCapacityAzure.isMaximumSet()) {
                capacityBuilder.setMaximum(apiCapacityAzure.getMaximum());
            }
            if (apiCapacityAzure.isTargetSet()) {
                capacityBuilder.setTarget(apiCapacityAzure.getTarget());
            }
            retVal = capacityBuilder.build();
        }
        return retVal;
    }

    public static VmHealthinessAzure toBl(ApiVmHealthinessAzure apiVmHealthiness) {
        VmHealthinessAzure retVal = null;
        if (apiVmHealthiness != null) {
            VmHealthinessAzure.Builder vmHealthBuilder = VmHealthinessAzure.Builder.get();
            if (apiVmHealthiness.isHealthStatusSet()) {
                vmHealthBuilder.setHealthStatus(apiVmHealthiness.getHealthStatus());
            }
            if (apiVmHealthiness.isLifeCycleSet()) {
                vmHealthBuilder.setLifeCycle(apiVmHealthiness.getLifeCycle());
            }
            if (apiVmHealthiness.isVmNameSet()) {
                vmHealthBuilder.setVmName(apiVmHealthiness.getVmName());
            }
            retVal = vmHealthBuilder.build();
        }
        return retVal;
    }

//    public static SuspendGroupProcessesAzure toBl(ApiSuspendgroupProcessesAzure apiSuspendgroup) {
//        SuspendGroupProcessesAzure retVal = null;
//        if (apiSuspendgroup != null) {
//            SuspendGroupProcessesAzure.Builder suspendBuilder = SuspendGroupProcessesAzure.Builder.get();
//            if (apiSuspendgroup.isNameSet()) {
//                suspendBuilder.setName(apiSuspendgroup.getName());
//            }
//            if (apiSuspendgroup.isTtlInMinutesSet()) {
//                suspendBuilder.setTtlInMinutes(apiSuspendgroup.getTtlInMinutes());
//            }
//            retVal = suspendBuilder.build();
//        }
//        return retVal;
//    }
//
//    public static ResumeGroupProcessesAzure toBl(ApiResumeGroupProcessesAzure apiResumegroup) {
//        ResumeGroupProcessesAzure retVal = null;
//        if (apiResumegroup != null) {
//            ResumeGroupProcessesAzure.Builder resumeBuilder = ResumeGroupProcessesAzure.Builder.get();
//            if (apiResumegroup.isNameSet()) {
//                resumeBuilder.setName(apiResumegroup.getName());
//            }
//            retVal = resumeBuilder.build();
//        }
//        return retVal;
//    }
//
//    public static DetachVmsAzure toBl(ApiDetachVmsAzure apiDetachVms) {
//        DetachVmsAzure retVal = null;
//        if (apiDetachVms != null) {
//            DetachVmsAzure.Builder detachVmBuilder = DetachVmsAzure.Builder.get();
//            if (apiDetachVms.isDrainingTimeoutSet()) {
//                detachVmBuilder.setDrainingTimeout(apiDetachVms.getDrainingTimeout());
//            }
//
//            if (apiDetachVms.isShouldDecrementTargetCapacitySet()) {
//                detachVmBuilder.setShouldDecrementTargetCapacity(apiDetachVms.getShouldDecrementTargetCapacity());
//            }
//
//            if (apiDetachVms.isShouldTerminateVmsSet()) {
//                detachVmBuilder.setShouldTerminateVms(apiDetachVms.getShouldTerminateVms());
//            }
//
//            if (apiDetachVms.isVmsToDetachSet()) {
//                detachVmBuilder.setVmsToDetach(apiDetachVms.getVmsToDetach());
//            }
//            retVal = detachVmBuilder.build();
//        }
//        return retVal;
//    }

    private static DetachedVmsAzure toBl(ApiDetachedVmsAzure apiDetachedVms) {
        DetachedVmsAzure retVal = null;
        if (apiDetachedVms != null) {
            DetachedVmsAzure.Builder detachedVmsBuilder = DetachedVmsAzure.Builder.get();
            if (apiDetachedVms.isLifeCycleSet()) {
                detachedVmsBuilder.setLifeCycle(apiDetachedVms.getLifeCycle());
            }
            if (apiDetachedVms.isOsSet()) {
                detachedVmsBuilder.setOs(apiDetachedVms.getOs());
            }
            if (apiDetachedVms.isPrivateIpSet()) {
                detachedVmsBuilder.setPrivateIp(apiDetachedVms.getPrivateIp());
            }
            if (apiDetachedVms.isPublicIpSet()) {
                detachedVmsBuilder.setPublicIp(apiDetachedVms.getPublicIp());
            }
            if (apiDetachedVms.isRegionSet()) {
                detachedVmsBuilder.setRegion(apiDetachedVms.getRegion());
            }
            if (apiDetachedVms.isVmNameSet()) {
                detachedVmsBuilder.setVmName(apiDetachedVms.getVmName());
            }
            if (apiDetachedVms.isVmSizeSet()) {
                detachedVmsBuilder.setVmSize(apiDetachedVms.getVmSize());
            }
            retVal = detachedVmsBuilder.build();
        }
        return retVal;
    }

    private static NewVmsAzure toBl(ApiNewVmsAzure newVmsAzure) {
        NewVmsAzure retVal = null;
        if (newVmsAzure != null) {
            NewVmsAzure.Builder vmsBuilder = NewVmsAzure.Builder.get();
            if (newVmsAzure.isCreatedAtSet()) {
                vmsBuilder.setCreatedAt(newVmsAzure.getCreatedAt());
            }
            if (newVmsAzure.isLifeCycleSet()) {
                vmsBuilder.setLifeCycle(newVmsAzure.getLifeCycle());
            }
            if (newVmsAzure.isOsSet()) {
                vmsBuilder.setOs(newVmsAzure.getOs());
            }
            if (newVmsAzure.isPowerStateSet()) {
                vmsBuilder.setPowerState(newVmsAzure.getPowerState());
            }
            if (newVmsAzure.isPrivateIpSet()) {
                vmsBuilder.setPrivateIp(newVmsAzure.getPrivateIp());
            }
            if (newVmsAzure.isProvisioningStateSet()) {
                vmsBuilder.setProvisioningState(newVmsAzure.getProvisioningState());
            }
            if (newVmsAzure.isPublicIpSet()) {
                vmsBuilder.setPublicIp(newVmsAzure.getPublicIp());
            }
            if (newVmsAzure.isRegionSet()) {
                vmsBuilder.setRegion(newVmsAzure.getRegion());
            }
            if (newVmsAzure.isVmNameSet()) {
                vmsBuilder.setVmName(newVmsAzure.getVmName());
            }
            if (newVmsAzure.isVmSizeSet()) {
                vmsBuilder.setVmSize(newVmsAzure.getVmSize());
            }
            retVal = vmsBuilder.build();
        }
        return retVal;
    }

    public static ElastigroupDetachedVmsAzure toBl(ApiElastigroupDetachedVmsAzure detachVmsAzure) {
        ElastigroupDetachedVmsAzure retVal = null;
        if (detachVmsAzure != null) {
            ElastigroupDetachedVmsAzure.Builder detachVmsBuilder = ElastigroupDetachedVmsAzure.Builder.get();
            if (detachVmsAzure.isDetachedVmsSet()) {
                    List<DetachedVmsAzure> detachVms = detachVmsAzure.getDetachedVms().stream().map(ElastigroupConverterAzure::toBl)
                            .collect(Collectors.toList());
                    detachVmsBuilder.setDetachedVms(detachVms);
            }
            if (detachVmsAzure.isNewVmsAzureSet()) {
                    List<NewVmsAzure> newVms = detachVmsAzure.getNewVmsAzure().stream().map(ElastigroupConverterAzure::toBl)
                            .collect(Collectors.toList());
                    detachVmsBuilder.setNewVmsAzure(newVms);
            }
            retVal = detachVmsBuilder.build();
        }
        return retVal;
    }

    public static GetElastilogAzure toBl(ApiGetElastilogAzure getElastilogAzure) {
        GetElastilogAzure retVal = null;
        if (getElastilogAzure != null) {
            GetElastilogAzure.Builder elastiLogBuilder = GetElastilogAzure.Builder.get();
            if (getElastilogAzure.isCreatedAtSet()) {
                elastiLogBuilder.setCreatedAt(getElastilogAzure.getCreatedAt());
            }
            if (getElastilogAzure.isMessageSet()) {
                elastiLogBuilder.setMessage(getElastilogAzure.getMessage());
            }
            if (getElastilogAzure.isSeveritySet()) {
                elastiLogBuilder.setSeverity(getElastilogAzure.getSeverity());
            }
            retVal = elastiLogBuilder.build();
        }
        return retVal;
    }

}

