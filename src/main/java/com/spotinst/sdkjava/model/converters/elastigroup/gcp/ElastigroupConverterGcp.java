package com.spotinst.sdkjava.model.converters.elastigroup.gcp;

import com.spotinst.sdkjava.model.api.gcp.*;
import com.spotinst.sdkjava.model.bl.elastigroup.gcp.*;


import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class ElastigroupConverterGcp {
    //region BL -> DAL
    public static ApiElastigroupGcp toDal(ElastigroupGcp src) {
        ApiElastigroupGcp retVal = null;

        if (src != null) {
            retVal = new ApiElastigroupGcp();

            if (src.isNameSet()) {
                retVal.setName(src.getName());
            }

            if (src.isDescriptionSet()) {
                retVal.setDescription(src.getDescription());
            }

            if (src.isCapacitySet()) {
                retVal.setCapacity(toDal(src.getCapacity()));
            }

            if (src.isStrategySet()) {
                retVal.setStrategy(toDal(src.getStrategy()));
            }

            if (src.isComputeSet()) {
                retVal.setCompute(toDal(src.getCompute()));
            }

            if (src.isCreatedAtSet()) {
                retVal.setCreatedAt(src.getCreatedAt());
            }

            if (src.isUpdatedAtSet()) {
                retVal.setUpdatedAt(src.getUpdatedAt());
            }

            if (src.isSchedulingSet()) {
                retVal.setScheduling(toDal(src.getScheduling()));
            }

            if (src.isScalingSet()) {
                retVal.setScaling(toDal(src.getScaling()));
            }

            if (src.isThirdPartiesIntegrationSet()) {
                retVal.setThirdPartiesIntegration(toDal(src.getThirdPartiesIntegration()));
            }

        }

        return retVal;
    }

    private static ApiGroupComputeGcp toDal(ElastigroupComputeGcp compute) {
        ApiGroupComputeGcp retVal = null;

        if (compute != null) {
            retVal = new ApiGroupComputeGcp();

            if (compute.isAvailabilityZonesSet()) {

                if (compute.getAvailabilityZones() == null) {
                    retVal.setAvailabilityZones(null);
                } else {
                    retVal.setAvailabilityZones(new LinkedList<>(compute.getAvailabilityZones()));
                }
            }

            if (compute.isLaunchSpecificationSet()) {
                retVal.setLaunchSpecification(toDal(compute.getLaunchSpecification()));
            }

            if (compute.isSubnetsSet()) {

                if (compute.getSubnets() != null) {
                    List<ApiSubnetsGcp> subnets = compute.getSubnets().stream().map(ElastigroupConverterGcp::toDal)
                            .collect(Collectors.toList());
                    retVal.setSubnets(subnets);
                }

            }

            if (compute.isInstanceTypesSet()) {
                retVal.setInstanceTypes(toDal(compute.getInstanceTypes()));
            }

            if (compute.isGpuSet()) {
                retVal.setGpu(toDal(compute.getGpu()));
            }

            if (compute.isHealthSet()) {
                retVal.setHealth(toDal(compute.getHealth()));
            }

            if (compute.isPreferredAvailabilityZonesSet()) {

                if (compute.getPreferredAvailabilityZones() == null) {
                    retVal.setPreferredAvailabilityZones(null);
                } else {
                    retVal.setPreferredAvailabilityZones(new LinkedList<>(compute.getPreferredAvailabilityZones()));
                }
            }
        }

        return retVal;
    }

    private static ApiLaunchSpecificationGcp toDal(ElastigroupLaunchSpecificationGcp launchSpecification) {
        ApiLaunchSpecificationGcp retVal = null;

        if (launchSpecification != null) {
            retVal = new ApiLaunchSpecificationGcp();

            if (launchSpecification.isDisksSet()) {
                if (launchSpecification.getDisks() != null) {
                    List<ApiDisksGcp> optimizerDisks =
                            launchSpecification.getDisks().stream().map(ElastigroupConverterGcp::toDal)
                                    .collect(Collectors.toList());
                    retVal.setDisks(optimizerDisks);
                } else {
                    retVal.setDisks(null);
                }
            }

            if (launchSpecification.isNetworkInterfacesSet()) {
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterfacesGcp> optimizerNetworkInterfaces =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverterGcp::toDal)
                                    .collect(Collectors.toList());
                    retVal.setNetworkInterfaces(optimizerNetworkInterfaces);
                } else {
                    retVal.setNetworkInterfaces(null);
                }
            }

            if (launchSpecification.isBackendServiceConfigSet()) {
                retVal.setBackendServiceConfig(toDal(launchSpecification.getBackendServiceConfig()));
            }

            if (launchSpecification.isInstanceNamePrefixSet()) {
                retVal.setInstanceNamePrefix(launchSpecification.getInstanceNamePrefix());
            }

            if (launchSpecification.isIpForwardingSet()) {
                retVal.setIpForwarding(launchSpecification.getIpForwarding());
            }

            if (launchSpecification.isMetadataSet()) {
                if (launchSpecification.getMetadata() != null) {
                    List<ApiElastigroupMetadataGcp> metadataGcp =
                            launchSpecification.getMetadata().stream().map(ElastigroupConverterGcp::toDal)
                                    .collect(Collectors.toList());
                    retVal.setMetadata(metadataGcp);
                } else {
                    retVal.setNetworkInterfaces(null);
                }
            }

            if (launchSpecification.isMinCpuPlatformSet()) {
                retVal.setMinCpuPlatform(launchSpecification.getMinCpuPlatform());
            }

            if (launchSpecification.isShutdownScriptSet()) {
                retVal.setShutdownScript(launchSpecification.getShutdownScript());
            }

            if (launchSpecification.isStartupScriptSet()) {
                retVal.setStartupScript(launchSpecification.getStartupScript());
            }

            if (launchSpecification.isTagsSet()) {

                if (launchSpecification.getTags() == null) {
                    retVal.setTags(null);
                } else {
                    retVal.setTags(new LinkedList<>(launchSpecification.getTags()));
                }
            }
        }

        return retVal;
    }

    private static ApiDisksGcp toDal(ElastigroupDisksGcp disksGcp) {
        ApiDisksGcp retVal = null;

        if (disksGcp != null) {
            retVal = new ApiDisksGcp();

            if (disksGcp.isAutoDeleteSet()) {
                retVal.setAutoDelete(disksGcp.getAutoDelete());
            }

            if (disksGcp.isBootSet()) {
                retVal.setBoot(disksGcp.getBoot());
            }

            if (disksGcp.isDeviceNameSet()) {
                retVal.setDeviceName(disksGcp.getDeviceName());
            }

            if (disksGcp.isTypeSet()) {
                retVal.setType(disksGcp.getType());
            }

            if (disksGcp.isSourceSet()) {
                retVal.setSource(disksGcp.getSource());
            }

            if (disksGcp.isModeSet()) {
                retVal.setMode(disksGcp.getMode());
            }

            if (disksGcp.isInitializeParamsSet()) {
                retVal.setInitializeParams(toDal(disksGcp.getInitializeParams()));
            }
        }

        return retVal;
    }

    private static ApiInitializeParamsGcp toDal(ElastigroupInitializeParamsGcp initializeParamsGcp) {
        ApiInitializeParamsGcp retVal = null;

        if (initializeParamsGcp != null) {
            retVal = new ApiInitializeParamsGcp();

            if (initializeParamsGcp.isDiskSizeGbSet()) {
                retVal.setDiskSizeGb(initializeParamsGcp.getDiskSizeGb());
            }

            if (initializeParamsGcp.isDiskTypeSet()) {
                retVal.setDiskType(initializeParamsGcp.getDiskType());
            }

            if (initializeParamsGcp.isSourceImageSet()) {
                retVal.setSourceImage(initializeParamsGcp.getSourceImage());
            }
        }

        return retVal;
    }

    private static ApiNetworkInterfacesGcp toDal(ElastigroupNetworkInterfacesGcp network) {
        ApiNetworkInterfacesGcp retVal = null;

        if (network != null) {
            retVal = new ApiNetworkInterfacesGcp();

            if (network.isNetworkSet()) {
                retVal.setNetwork(network.getNetwork());
            }

            if (network.isProjectIdSet()) {
                retVal.setProjectId(network.getProjectId());
            }
        }

        return retVal;
    }

    private static ApiSubnetsGcp toDal(ElastigroupSubnetsGcp subnetsGcp) {
        ApiSubnetsGcp retVal = null;

        if (subnetsGcp != null) {
            retVal = new ApiSubnetsGcp();

            if (subnetsGcp.isRegionSet()) {
                retVal.setRegion(subnetsGcp.getRegion());
            }

            if (subnetsGcp.isSubnetNamesSet()) {

                if (subnetsGcp.getSubnetNames() != null) {

                    if (subnetsGcp.getSubnetNames() == null) {
                        retVal.setSubnetNames(null);
                    } else {
                        retVal.setSubnetNames(new LinkedHashSet<>(subnetsGcp.getSubnetNames()));
                    }
                }

            }
        }

        return retVal;
    }

    private static ApiStrategyGcp toDal(ElastigroupStrategyGcp strategyConfigurationGcp) {
        ApiStrategyGcp retVal = null;

        if (strategyConfigurationGcp != null) {
            retVal = new ApiStrategyGcp();

            if (strategyConfigurationGcp.isPreemptiblePercentageSet()) {
                retVal.setPreemptiblePercentage(strategyConfigurationGcp.getPreemptiblePercentage());
            }

            if (strategyConfigurationGcp.isOnDemandCountSet()) {
                retVal.setOnDemandCount(strategyConfigurationGcp.getOnDemandCount());
            }

            if (strategyConfigurationGcp.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(strategyConfigurationGcp.getDrainingTimeout());
            }

            if (strategyConfigurationGcp.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategyConfigurationGcp.getFallbackToOd());
            }

            if (strategyConfigurationGcp.isOptimizationWindowsSet()) {

                if (strategyConfigurationGcp.getOptimizationWindows() == null) {
                    retVal.setOptimizationWindows(null);
                } else {
                    retVal.setOptimizationWindows(new LinkedList<>(strategyConfigurationGcp.getOptimizationWindows()));
                }
            }

            if (strategyConfigurationGcp.isRevertToPreemptibleSet()) {
                retVal.setRevertToPreemptible(toDal(strategyConfigurationGcp.getRevertToPreemptible()));
            }

            if (strategyConfigurationGcp.isProvisioningModelSet()) {
                retVal.setProvisioningModel(strategyConfigurationGcp.getProvisioningModel());
            }
        }

        return retVal;
    }

    private static ApiRevertToPreemptibleGcp toDal(ElastigroupRevertToPreemptibleGcp revertToPreemptibleGcp) {
        ApiRevertToPreemptibleGcp retVal = null;

        if (revertToPreemptibleGcp != null) {
            retVal = new ApiRevertToPreemptibleGcp();

            if (revertToPreemptibleGcp.isPerformAtSet()) {
                retVal.setPerformAt(revertToPreemptibleGcp.getPerformAt());
            }

        }

        return retVal;
    }

    private static ApiCapacityGcp toDal(ElastigroupCapacityGcp capacity) {
        ApiCapacityGcp retVal = null;
        if (capacity != null) {
            retVal = new ApiCapacityGcp();
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


    private static ApiInstanceTypesGcp toDal(ElastigroupInstanceTypesGcp instanceTypesGcp) {
        ApiInstanceTypesGcp retVal = null;

        if (instanceTypesGcp != null) {
            retVal = new ApiInstanceTypesGcp();

            if (instanceTypesGcp.isOndemandSet()) {
                retVal.setOndemand(instanceTypesGcp.getOndemand());
            }

            if (instanceTypesGcp.isPreemptibleSet()) {

                if (instanceTypesGcp.getPreemptible() == null) {
                    retVal.setPreemptible(null);
                } else {
                    retVal.setPreemptible(new LinkedList<>(instanceTypesGcp.getPreemptible()));
                }
            }
        }

        return retVal;
    }

    private static ApiElastigroupScalingConfigurationGcp toDal(ElastigroupScalingConfigurationGcp scaling) {
        ApiElastigroupScalingConfigurationGcp retVal = null;

        if (scaling != null) {
            retVal = new ApiElastigroupScalingConfigurationGcp();

            if (scaling.isUpSet()) {
                List<ApiElastigroupScalingPolicyGcp> apiUpScalingPolicies = null;

                if (scaling.getUp() != null) {
                    List<ElastigroupScalingPolicyGcp> up = scaling.getUp();
                    apiUpScalingPolicies = up.stream().map(ElastigroupConverterGcp::toDal).collect(Collectors.toList());
                }

                retVal.setUp(apiUpScalingPolicies);
            }

            if (scaling.isDownSet()) {
                List<ApiElastigroupScalingPolicyGcp> apiDownScalingPolicies = null;

                if (scaling.getDown() != null) {
                    List<ElastigroupScalingPolicyGcp> down = scaling.getDown();
                    apiDownScalingPolicies =
                            down.stream().map(ElastigroupConverterGcp::toDal).collect(Collectors.toList());
                }

                retVal.setDown(apiDownScalingPolicies);
            }
        }

        return retVal;
    }

    private static ApiElastigroupScalingPolicyGcp toDal(ElastigroupScalingPolicyGcp scalingPolicy) {
        ApiElastigroupScalingPolicyGcp retVal = null;

        if (scalingPolicy != null) {
            retVal = new ApiElastigroupScalingPolicyGcp();

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
                List<ElastigroupScalingDimensionGcp> dimensions = scalingPolicy.getDimensions();

                if (dimensions != null) {
                    List<ApiElastigroupScalingDimensionGcp> optimizerScalingDimensions =
                            dimensions.stream().map(ElastigroupConverterGcp::toDal).collect(Collectors.toList());
                    retVal.setDimensions(optimizerScalingDimensions);
                }
            }

            if (scalingPolicy.isActionSet()) {
                retVal.setAction(toDal(scalingPolicy.getAction()));
            }

            if (scalingPolicy.isOperatorSet()) {
                retVal.setOperator(scalingPolicy.getOperator());
            }
        }

        return retVal;
    }

    private static ApiElastigroupScalingDimensionGcp toDal(ElastigroupScalingDimensionGcp scalingDimension) {
        ApiElastigroupScalingDimensionGcp retVal = null;

        if (scalingDimension != null) {
            retVal = new ApiElastigroupScalingDimensionGcp();

            if (scalingDimension.isNameSet()) {
                retVal.setName(scalingDimension.getName());
            }

            if (scalingDimension.isValueSet()) {
                retVal.setValue(scalingDimension.getValue());
            }
        }

        return retVal;
    }


    private static ApiElastigroupScalingActionGcp toDal(ElastigroupScalingActionGcp scalingAction) {
        ApiElastigroupScalingActionGcp retVal = null;

        if (scalingAction != null) {
            retVal = new ApiElastigroupScalingActionGcp();

            if (scalingAction.isTypeSet()) {
                retVal.setType(scalingAction.getType());
            }

            if (scalingAction.isAdjustmentSet()) {
                retVal.setAdjustment(scalingAction.getAdjustment());
            }
        }

        return retVal;
    }

    private static ApiElastigroupSchedulingGcp toDal(ElastigroupSchedulingGcp schedulingConfiguration) {
        ApiElastigroupSchedulingGcp retVal = null;
        if (schedulingConfiguration != null) {
            retVal = new ApiElastigroupSchedulingGcp();
            if (schedulingConfiguration.isTasksSet()) {
                if (schedulingConfiguration.getTasks() != null) {
                    List<ApiElastigroupScheduleTasksConfigurationGcp> taskList =
                            schedulingConfiguration.getTasks().stream().map(ElastigroupConverterGcp::toDal)
                                    .collect(Collectors.toList());
                    retVal.setTasks(taskList);
                }
            }
        }
        return retVal;
    }

    private static ApiElastigroupScheduleTasksConfigurationGcp toDal(ElastigroupScheduleTasksConfigurationGcp tasksConfiguration) {
        ApiElastigroupScheduleTasksConfigurationGcp retVal = null;
        if (tasksConfiguration != null) {
            retVal = new ApiElastigroupScheduleTasksConfigurationGcp();
            if (tasksConfiguration.isIsEnabledSet()) {
                retVal.setIsEnabled(tasksConfiguration.getIsEnabled());
            }
            if (tasksConfiguration.isCronExpressionSet()) {
                retVal.setCronExpression(tasksConfiguration.getCronExpression());
            }
            if (tasksConfiguration.isTaskTypeSet()) {
                retVal.setTaskType(tasksConfiguration.getTaskType());
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

    private static ApiElastigroupThirdPartiesIntegrationGcp toDal(
            ElastigroupThirdPartiesIntegrationGcp thirdPartiesIntegration) {
        ApiElastigroupThirdPartiesIntegrationGcp retVal = null;

        if (thirdPartiesIntegration != null) {
            retVal = new ApiElastigroupThirdPartiesIntegrationGcp();
            if (thirdPartiesIntegration.isGkeSet()) {
                retVal.setGke(toDal(thirdPartiesIntegration.getGke()));
            }

            if (thirdPartiesIntegration.isDockerSwarmSet()) {
                retVal.setDockerSwarm(toDal(thirdPartiesIntegration.getDockerSwarm()));
            }
        }

        return retVal;
    }

    private static ApiElastigroupDockerSwarmGcp toDal(ElastigroupDockerSwarmGcp dockerSwarm) {
        ApiElastigroupDockerSwarmGcp retVal = null;
        if (dockerSwarm != null) {
            retVal = new ApiElastigroupDockerSwarmGcp();
            if (dockerSwarm.isMasterHostSet()) {
                retVal.setMasterHost(dockerSwarm.getMasterHost());
            }
            if (dockerSwarm.isMasterPortSet()) {
                retVal.setMasterPort(dockerSwarm.getMasterPort());
            }
        }
        return retVal;
    }

    private static ApiElastigroupGkeConfigurationGcp toDal(ElastigroupGkeConfigurationGcp gke) {
        ApiElastigroupGkeConfigurationGcp retVal = null;
        if (gke != null) {
            retVal = new ApiElastigroupGkeConfigurationGcp();
            if (gke.isAutoScaleSet()) {
                retVal.setAutoScale(toDal(gke.getAutoScale()));
            }
            if (gke.isAutoUpdateSet()) {
                retVal.setAutoUpdate(gke.getAutoUpdate());
            }
            if (gke.isClusterIdentifierSet()) {
                retVal.setLocation(gke.getClusterIdentifier());
            }
            if (gke.isLocationSet()) {
                retVal.setLocation(gke.getLocation());
            }
        }
        return retVal;
    }

    private static ApiElastigroupAutoscaleConfigurationGcp toDal(ElastigroupAutoscaleConfigurationGcp autoScale) {
        ApiElastigroupAutoscaleConfigurationGcp retVal = null;
        if (autoScale != null) {
            retVal = new ApiElastigroupAutoscaleConfigurationGcp();
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
                retVal.setIsAutoConfig(autoScale.getIsAutoConfig());
            }
            if (autoScale.isIsEnabledSet()) {
                retVal.setIsEnabled(autoScale.getIsEnabled());
            }
        }
        return retVal;
    }

    private static ApiElastigroupDownSpecificationGcp toDal(ElastigroupDownSpecificationGcp down) {
        ApiElastigroupDownSpecificationGcp retVal = null;

        if (down != null) {
            retVal = new ApiElastigroupDownSpecificationGcp();
            if (down.isEvaluationPeriodsSet()) {
                retVal.setEvaluationPeriods(down.getEvaluationPeriods());
            }
        }
        return retVal;

    }

    private static ApiElastigroupHeadroomSpecificationGcp toDal(ElastigroupHeadroomSpecificationGcp headroom) {
        ApiElastigroupHeadroomSpecificationGcp retVal = null;
        if (headroom != null) {
            retVal = new ApiElastigroupHeadroomSpecificationGcp();
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

    private static ApiElastigroupGpuGcp toDal(ElastigroupGpuGcp gpu) {
        ApiElastigroupGpuGcp retVal = null;
        if (gpu != null) {
            retVal = new ApiElastigroupGpuGcp();
            if (gpu.isCountSet()) {
                retVal.setCount(gpu.getCount());
            }
            if (gpu.isTypeSet()) {
                retVal.setType(gpu.getType());
            }
        }
        return retVal;
    }

    private static ApiElastigroupHealthGcp toDal(ElastigroupHealthGcp health) {
        ApiElastigroupHealthGcp retVal = null;
        if (health != null) {
            retVal = new ApiElastigroupHealthGcp();
            if (health.isAutoHealingSet()) {
                retVal.setAutoHealing(health.getAutoHealing());
            }
            if (health.isGracePeriodSet()) {
                retVal.setGracePeriod(health.getGracePeriod());
            }
            if (health.isHealthCheckTypeSet()) {
                retVal.setHealthCheckType(health.getHealthCheckType());
            }
            if (health.isUnhealthyDurationSet()) {
                retVal.setUnhealthyDuration(health.getUnhealthyDuration());
            }
        }
        return retVal;
    }

    private static ApiElastigroupMetadataGcp toDal(ElastigroupMetadataGcp metadataGcp) {
        ApiElastigroupMetadataGcp retVal = null;

        if (metadataGcp != null) {
            retVal = new ApiElastigroupMetadataGcp();

            if (metadataGcp.isKeySet()) {
                retVal.setKey(metadataGcp.getKey());
            }

            if (metadataGcp.isValueSet()) {
                retVal.setValue(metadataGcp.getValue());
            }
        }

        return retVal;
    }

    private static ApiElastigroupBackendServiceConfigGcp toDal(ElastigroupBackendServiceConfigGcp backendServiceConfigGcp) {
        ApiElastigroupBackendServiceConfigGcp retVal = null;

        if (backendServiceConfigGcp != null) {
            retVal = new ApiElastigroupBackendServiceConfigGcp();

            if (backendServiceConfigGcp.isBackendServicesSet()) {
                if (backendServiceConfigGcp.getBackendServices() != null) {
                    List<ApiElastigroupBackendServicesGcp> metadataGcp =
                            backendServiceConfigGcp.getBackendServices().stream().map(ElastigroupConverterGcp::toDal)
                                    .collect(Collectors.toList());
                    retVal.setBackendServices(metadataGcp);
                } else {
                    retVal.setBackendServices(null);
                }
            }
        }

        return retVal;
    }

    private static ApiElastigroupBackendServicesGcp toDal(ElastigroupBackendServicesGcp backendService) {
        ApiElastigroupBackendServicesGcp retVal = null;

        if (backendService != null) {
            retVal = new ApiElastigroupBackendServicesGcp();

            if (backendService.isBackendServiceNameSet()) {
                retVal.setBackendServiceName(backendService.getBackendServiceName());
            }
            if (backendService.isLocationTypeSet()) {
                retVal.setLocationType(backendService.getLocationType());
            }
            if (backendService.isSchemeSet()) {
                retVal.setScheme(backendService.getScheme());
            }
            if (backendService.isNamedPortsSet()) {
                retVal.setNamedPorts(toDal(backendService.getNamedPorts()));
            }
        }

        return retVal;
    }

    private static ApiElastigroupNamedPortsGcp toDal(ElastigroupNamedPortsGcp backendService) {
        ApiElastigroupNamedPortsGcp retVal = null;

        if (backendService != null) {
            retVal = new ApiElastigroupNamedPortsGcp();

            if (backendService.isNameSet()) {
                retVal.setName(backendService.getName());
            }
            if (backendService.isPortsSet()) {
                if (backendService.getPorts() == null) {
                    retVal.setPorts(null);
                } else {
                    retVal.setPorts(new LinkedList<>(backendService.getPorts()));
                }
            }
        }
        return retVal;
    }
    //endregion

    //region DAL -> BL
    public static ElastigroupGcp toBl(ApiElastigroupGcp src) {
        ElastigroupGcp retVal = null;

        if (src != null) {
            ElastigroupGcp.Builder elastigroupBuilder = ElastigroupGcp.Builder.get();

            if (src.isIdSet()) {
                elastigroupBuilder.setId(src.getId());
            }

            if (src.isNameSet()) {
                elastigroupBuilder.setName(src.getName());
            }

            if (src.isDescriptionSet()) {
                elastigroupBuilder.setDescription(src.getDescription());
            }

            if (src.isCapacitySet()) {
                elastigroupBuilder.setCapacity(toBl(src.getCapacity()));
            }

            if (src.isStrategySet()) {
                elastigroupBuilder.setStrategy(toBl(src.getStrategy()));
            }

            if (src.isComputeSet()) {
                elastigroupBuilder.setCompute(toBl(src.getCompute()));
            }

            retVal = elastigroupBuilder.build();
            // createdAt is not taken from builder since it cannot be set when creating/updating an Elastigroup
            if (src.isCreatedAtSet()) {
                retVal.setCreatedAt(src.getCreatedAt());
            }

            if (src.isUpdatedAtSet()) {
                retVal.setUpdatedAt(src.getUpdatedAt());
            }

            if (src.isScalingSet()) {
                elastigroupBuilder.setScaling(toBl(src.getScaling()));
            }

            if (src.isSchedulingSet()) {
                elastigroupBuilder.setScheduling(toBl(src.getScheduling()));
            }

            if (src.isThirdPartiesIntegrationSet()) {
                elastigroupBuilder.setThirdPartiesIntegration(toBl(src.getThirdPartiesIntegration()));
            }

        }

        return retVal;
    }

    private static ElastigroupComputeGcp toBl(ApiGroupComputeGcp compute) {
        ElastigroupComputeGcp retVal = null;

        if (compute != null) {
            ElastigroupComputeGcp.Builder blComputeBuilder = ElastigroupComputeGcp.Builder.get();

            if (compute.isAvailabilityZonesSet()) {

                if (compute.getAvailabilityZones() == null) {
                    blComputeBuilder.setAvailabilityZones(null);
                } else {
                    blComputeBuilder.setAvailabilityZones(new LinkedList<>(compute.getAvailabilityZones()));
                }
            }

            if (compute.isLaunchSpecificationSet()) {
                blComputeBuilder.setLaunchSpecification(toBl(compute.getLaunchSpecification()));
            }

            if (compute.isSubnetsSet()) {
                if (compute.getSubnets() != null) {
                    List<ApiSubnetsGcp> apiOptimizerSubnets = compute.getSubnets();
                    List<ElastigroupSubnetsGcp> optimizerSubnets =
                            apiOptimizerSubnets.stream().map(ElastigroupConverterGcp::toBl)
                                    .collect(Collectors.toList());
                    blComputeBuilder.setSubnets(optimizerSubnets);
                } else {
                    blComputeBuilder.setSubnets(null);
                }
            }

            if (compute.isInstanceTypesSet()) {
                blComputeBuilder.setInstanceTypes(toBl(compute.getInstanceTypes()));
            }

            retVal = blComputeBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupLaunchSpecificationGcp toBl(ApiLaunchSpecificationGcp launchSpecification) {
        ElastigroupLaunchSpecificationGcp retVal = null;

        if (launchSpecification != null) {
            ElastigroupLaunchSpecificationGcp.Builder blLaunchSpecificationBuilder =
                    ElastigroupLaunchSpecificationGcp.Builder.get();

            if (launchSpecification.isDisksSet()) {

                if (launchSpecification.getDisks() != null) {
                    List<ApiDisksGcp> apiOptimizerDisks = launchSpecification.getDisks();
                    List<ElastigroupDisksGcp> optimizerDisks =
                            apiOptimizerDisks.stream().map(ElastigroupConverterGcp::toBl).collect(Collectors.toList());
                    blLaunchSpecificationBuilder.setDisks(optimizerDisks);
                } else {
                    blLaunchSpecificationBuilder.setDisks(null);
                }
            }

            if (launchSpecification.isNetworkInterfacesSet()) {

                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterfacesGcp> apiOptimizerNetworkInterfaces =
                            launchSpecification.getNetworkInterfaces();
                    List<ElastigroupNetworkInterfacesGcp> optimizerNetworkInterfaces =
                            apiOptimizerNetworkInterfaces.stream().map(ElastigroupConverterGcp::toBl)
                                    .collect(Collectors.toList());
                    blLaunchSpecificationBuilder.setNetworkInterfaces(optimizerNetworkInterfaces);
                } else {
                    blLaunchSpecificationBuilder.setNetworkInterfaces(null);
                }
            }

            if (launchSpecification.isBackendServiceConfigSet()) {
                blLaunchSpecificationBuilder.setBackendServiceConfig(toBl(launchSpecification.getBackendServiceConfig()));
            }

            if (launchSpecification.isInstanceNamePrefixSet()) {
                blLaunchSpecificationBuilder.setInstanceNamePrefix(launchSpecification.getInstanceNamePrefix());
            }

            if (launchSpecification.isIpForwardingSet()) {
                blLaunchSpecificationBuilder.setIpForwarding(launchSpecification.getIpForwarding());
            }

            if (launchSpecification.isMinCpuPlatformSet()) {
                blLaunchSpecificationBuilder.setMinCpuPlatform(launchSpecification.getMinCpuPlatform());
            }

            if (launchSpecification.isShutdownScriptSet()) {
                blLaunchSpecificationBuilder.setShutdownScript(launchSpecification.getShutdownScript());
            }

            if (launchSpecification.isStartupScriptSet()) {
                blLaunchSpecificationBuilder.setStartupScript(launchSpecification.getStartupScript());
            }

            if (launchSpecification.getMetadata() != null) {
                List<ApiElastigroupMetadataGcp> apiMetadta =
                        launchSpecification.getMetadata();
                List<ElastigroupMetadataGcp> metadta =
                        apiMetadta.stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                blLaunchSpecificationBuilder.setMetadata(metadta);
            } else {
                blLaunchSpecificationBuilder.setMetadata(null);
            }

            if (launchSpecification.isTagsSet()) {
                if (launchSpecification.getTags() != null) {
                    blLaunchSpecificationBuilder.setTags(new LinkedList<>(launchSpecification.getTags()));
                }
            }

            retVal = blLaunchSpecificationBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupDisksGcp toBl(ApiDisksGcp disksGcp) {
        ElastigroupDisksGcp retVal = null;

        if (disksGcp != null) {
            ElastigroupDisksGcp.Builder blDisksGcpBuilder = ElastigroupDisksGcp.Builder.get();

            if (disksGcp.isAutoDeleteSet()) {
                blDisksGcpBuilder.setAutoDelete(disksGcp.getAutoDelete());
            }

            if (disksGcp.isBootSet()) {
                blDisksGcpBuilder.setBoot(disksGcp.getBoot());
            }

            if (disksGcp.isDeviceNameSet()) {
                blDisksGcpBuilder.setDeviceName(disksGcp.getDeviceName());
            }

            if (disksGcp.isTypeSet()) {
                blDisksGcpBuilder.setType(disksGcp.getType());
            }

            if (disksGcp.isSourceSet()) {
                blDisksGcpBuilder.setSource(disksGcp.getSource());
            }

            if (disksGcp.isModeSet()) {
                blDisksGcpBuilder.setMode(disksGcp.getMode());
            }

            if (disksGcp.isInitializeParamsSet()) {
                blDisksGcpBuilder.setInitializeParams(toBl(disksGcp.getInitializeParams()));
            }

            retVal = blDisksGcpBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupInitializeParamsGcp toBl(ApiInitializeParamsGcp initializeParamsGcp) {
        ElastigroupInitializeParamsGcp retVal = null;

        if (initializeParamsGcp != null) {
            ElastigroupInitializeParamsGcp.Builder blInitializeParamsGcpBuilder =
                    ElastigroupInitializeParamsGcp.Builder.get();

            if (initializeParamsGcp.isDiskSizeGbSet()) {
                blInitializeParamsGcpBuilder.setDiskSizeGb(initializeParamsGcp.getDiskSizeGb());
            }

            if (initializeParamsGcp.isDiskTypeSet()) {
                blInitializeParamsGcpBuilder.setDiskType(initializeParamsGcp.getDiskType());
            }

            if (initializeParamsGcp.isSourceImageSet()) {
                blInitializeParamsGcpBuilder.setSourceImage(initializeParamsGcp.getSourceImage());
            }

            retVal = blInitializeParamsGcpBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupNetworkInterfacesGcp toBl(ApiNetworkInterfacesGcp network) {
        ElastigroupNetworkInterfacesGcp retVal = null;

        if (network != null) {
            ElastigroupNetworkInterfacesGcp.Builder blNetworkBuilder = ElastigroupNetworkInterfacesGcp.Builder.get();

            if (network.isNetworkSet()) {
                blNetworkBuilder.setNetwork(network.getNetwork());
            }

            if (network.isProjectIdSet()) {
                blNetworkBuilder.setProjectId(network.getProjectId());
            }

            retVal = blNetworkBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupSubnetsGcp toBl(ApiSubnetsGcp subnetsGcp) {
        ElastigroupSubnetsGcp retVal = null;

        if (subnetsGcp != null) {
            ElastigroupSubnetsGcp.Builder blSubnetsGcpBuilder = ElastigroupSubnetsGcp.Builder.get();

            if (subnetsGcp.isRegionSet()) {
                blSubnetsGcpBuilder.setRegion(subnetsGcp.getRegion());
            }

            if (subnetsGcp.isSubnetNamesSet()) {
                if (subnetsGcp.getSubnetNames() != null) {
                    blSubnetsGcpBuilder.setSubnetNames(new LinkedHashSet<>(subnetsGcp.getSubnetNames()));
                } else {
                    blSubnetsGcpBuilder.setSubnetNames(null);
                }
            }

            retVal = blSubnetsGcpBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupStrategyGcp toBl(ApiStrategyGcp strategyConfigurationGcp) {
        ElastigroupStrategyGcp retVal = null;

        if (strategyConfigurationGcp != null) {
            ElastigroupStrategyGcp.Builder blStrategyConfigurationGcpBuilder = ElastigroupStrategyGcp.Builder.get();

            if (strategyConfigurationGcp.isPreemptiblePercentageSet()) {
                blStrategyConfigurationGcpBuilder
                        .setPreemptiblePercentage(strategyConfigurationGcp.getPreemptiblePercentage());
            }

            if (strategyConfigurationGcp.isOnDemandCountSet()) {
                blStrategyConfigurationGcpBuilder.setOnDemandCount(strategyConfigurationGcp.getOnDemandCount());
            }

            if (strategyConfigurationGcp.isDrainingTimeoutSet()) {
                blStrategyConfigurationGcpBuilder.setDrainingTimeout(strategyConfigurationGcp.getDrainingTimeout());
            }

            if (strategyConfigurationGcp.isFallbackToOdSet()) {
                blStrategyConfigurationGcpBuilder.setFallbackToOd(strategyConfigurationGcp.getFallbackToOd());
            }

            if (strategyConfigurationGcp.isOptimizationWindowsSet()) {

                if (strategyConfigurationGcp.getOptimizationWindows() != null) {
                    blStrategyConfigurationGcpBuilder.setOptimizationWindows(new LinkedList<>(strategyConfigurationGcp.getOptimizationWindows()));
                } else {
                    blStrategyConfigurationGcpBuilder.setOptimizationWindows(null);
                }
            }

            if (strategyConfigurationGcp.isRevertToPreemptibleSet()) {
                ElastigroupRevertToPreemptibleGcp blRevertToPreemptible =
                        toBl(strategyConfigurationGcp.getRevertToPreemptible());
                blStrategyConfigurationGcpBuilder.setRevertToPreemptible(blRevertToPreemptible);
            }

            if (strategyConfigurationGcp.isProvisioningModelSet()) {
                blStrategyConfigurationGcpBuilder.setProvisioningModel(strategyConfigurationGcp.getProvisioningModel());
            }

            retVal = blStrategyConfigurationGcpBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupRevertToPreemptibleGcp toBl(ApiRevertToPreemptibleGcp revertToPreemptibleGcp) {
        ElastigroupRevertToPreemptibleGcp retVal = null;

        if (revertToPreemptibleGcp != null) {
            ElastigroupRevertToPreemptibleGcp.Builder blRevertToPreemptibleGcpBuilder =
                    ElastigroupRevertToPreemptibleGcp.Builder.get();

            if (revertToPreemptibleGcp.isPerformAtSet()) {
                blRevertToPreemptibleGcpBuilder.setPerformAt(revertToPreemptibleGcp.getPerformAt());
            }
            retVal = blRevertToPreemptibleGcpBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupCapacityGcp toBl(ApiCapacityGcp capacityConfigurationGcp) {
        ElastigroupCapacityGcp retVal = null;

        if (capacityConfigurationGcp != null) {
            ElastigroupCapacityGcp.Builder blCapacityConfigurationGcpBuilder = ElastigroupCapacityGcp.Builder.get();

            if (capacityConfigurationGcp.isMinimumSet()) {
                blCapacityConfigurationGcpBuilder.setMinimum(capacityConfigurationGcp.getMinimum());
            }

            if (capacityConfigurationGcp.isMaximumSet()) {
                blCapacityConfigurationGcpBuilder.setMaximum(capacityConfigurationGcp.getMaximum());
            }

            if (capacityConfigurationGcp.isTargetSet()) {
                blCapacityConfigurationGcpBuilder.setTarget(capacityConfigurationGcp.getTarget());
            }

            if (capacityConfigurationGcp.isUnitSet()) {
                blCapacityConfigurationGcpBuilder.setUnit(capacityConfigurationGcp.getUnit());
            }

            retVal = blCapacityConfigurationGcpBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupInstanceTypesGcp toBl(ApiInstanceTypesGcp instanceTypesGcp) {
        ElastigroupInstanceTypesGcp retVal = null;

        if (instanceTypesGcp != null) {
            ElastigroupInstanceTypesGcp.Builder blInstanceTypesGcpBuilder = ElastigroupInstanceTypesGcp.Builder.get();

            if (instanceTypesGcp.isOndemandSet()) {
                blInstanceTypesGcpBuilder.setOndemand(instanceTypesGcp.getOndemand());
            }

            if (instanceTypesGcp.isPreemptibleSet()) {

                if (instanceTypesGcp.getPreemptible() != null) {
                    blInstanceTypesGcpBuilder.setPreemptible(new LinkedList<>(instanceTypesGcp.getPreemptible()));
                } else {
                    blInstanceTypesGcpBuilder.setPreemptible(null);
                }
            }

            retVal = blInstanceTypesGcpBuilder.build();
        }

        return retVal;
    }

    public static ElastigroupScaleUpResponseGcp toBl(ApiElastigroupScaleUpResponseGcp elastigroupScaleUpResponseGcp) {
        ElastigroupScaleUpResponseGcp retVal = null;

        if (elastigroupScaleUpResponseGcp != null) {
            retVal = new ElastigroupScaleUpResponseGcp();

            if (elastigroupScaleUpResponseGcp.isNewPreemptiblesSet()) {
                List<ElastigroupScaleUpNewInstancesGcp> newPreemptibles =
                        elastigroupScaleUpResponseGcp.getNewPreemptibles().stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                retVal.setNewPreemptibles(newPreemptibles);
            }

            if (elastigroupScaleUpResponseGcp.isNewInstancesSet() && elastigroupScaleUpResponseGcp.getNewInstances() != null) {
                List<ElastigroupScaleUpNewInstancesGcp> newInstances =
                        elastigroupScaleUpResponseGcp.getNewInstances().stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                retVal.setNewInstances(newInstances);
            }
        }
        return retVal;

    }

    private static ElastigroupScaleUpNewInstancesGcp toBl(
            ApiElastigroupScaleUpNewInstancesGcp elastigroupScaleUpNewPreemptiblesGcp) {
        ElastigroupScaleUpNewInstancesGcp retVal = null;

        if (elastigroupScaleUpNewPreemptiblesGcp != null) {

            retVal = new ElastigroupScaleUpNewInstancesGcp();

            if (elastigroupScaleUpNewPreemptiblesGcp.isInstanceNameSet()) {
                retVal.setInstanceName(elastigroupScaleUpNewPreemptiblesGcp.getInstanceName());
            }

        }
        return retVal;

    }

    public static ElastigroupScaleDownResponseGcp toBl(ApiElastigroupScaleDownResponseGcp elastigroupScaleDownResponseGcp) {
        ElastigroupScaleDownResponseGcp retVal = null;

        if (elastigroupScaleDownResponseGcp != null) {
            retVal = new ElastigroupScaleDownResponseGcp();

            if (elastigroupScaleDownResponseGcp.isVictimPreemptiblesSet()) {
                List<ElastigroupScaleDownVictimGcp> victimPreemptibles =
                        elastigroupScaleDownResponseGcp.getVictimPreemptibles().stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                retVal.setVictimPreemptibles(victimPreemptibles);
            }

            if (elastigroupScaleDownResponseGcp.isVictimInstancesSet() && elastigroupScaleDownResponseGcp.getVictimInstances() != null) {
                List<ElastigroupScaleDownVictimGcp> victimInstances =
                        elastigroupScaleDownResponseGcp.getVictimInstances().stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                retVal.setVictimInstances(victimInstances);
            }
        }
        return retVal;

    }

    private static ElastigroupScaleDownVictimGcp toBl(
            ApiElastigroupScaleDownVictimGcp elastigroupScaleDownVictimGcp) {
        ElastigroupScaleDownVictimGcp retVal = null;

        if (elastigroupScaleDownVictimGcp != null) {

            retVal = new ElastigroupScaleDownVictimGcp();

            if (elastigroupScaleDownVictimGcp.isInstanceNameSet()) {
                retVal.setInstanceName(elastigroupScaleDownVictimGcp.getInstanceName());
            }

        }
        return retVal;

    }

    private static ElastigroupScalingConfigurationGcp toBl(ApiElastigroupScalingConfigurationGcp scaling) {
        ElastigroupScalingConfigurationGcp retVal = null;

        if (scaling != null) {
            ElastigroupScalingConfigurationGcp.Builder retValBuilder = ElastigroupScalingConfigurationGcp.Builder.get();

            if (scaling.isUpSet()) {
                if (scaling.getUp() != null) {
                    List<ApiElastigroupScalingPolicyGcp> apiScalingPolicies = scaling.getUp();
                    List<ElastigroupScalingPolicyGcp> scalingPolicies =
                            apiScalingPolicies.stream().map(ElastigroupConverterGcp::toBl).collect(Collectors.toList());
                    retValBuilder.setUp(scalingPolicies);
                }
            }

            if (scaling.isDownSet()) {
                if (scaling.getDown() != null) {
                    List<ApiElastigroupScalingPolicyGcp> apiScalingPolicies = scaling.getDown();
                    List<ElastigroupScalingPolicyGcp> scalingPolicies =
                            apiScalingPolicies.stream().map(ElastigroupConverterGcp::toBl).collect(Collectors.toList());
                    retValBuilder.setDown(scalingPolicies);
                }
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupScalingPolicyGcp toBl(ApiElastigroupScalingPolicyGcp scalingPolicy) {
        ElastigroupScalingPolicyGcp retVal = null;

        if (scalingPolicy != null) {
            ElastigroupScalingPolicyGcp.Builder retValBuilder = ElastigroupScalingPolicyGcp.Builder.get();

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
                    List<ApiElastigroupScalingDimensionGcp> apiDimensions = scalingPolicy.getDimensions();
                    List<ElastigroupScalingDimensionGcp> dimensions =
                            apiDimensions.stream().map(ElastigroupConverterGcp::toBl).collect(Collectors.toList());
                    retValBuilder.setDimensions(dimensions);
                }
            }

            if (scalingPolicy.isActionSet()) {
                retValBuilder.setAction(toBl(scalingPolicy.getAction()));
            }

            if (scalingPolicy.isOperatorSet()) {
                retValBuilder.setOperator(scalingPolicy.getOperator());
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static ElastigroupScalingDimensionGcp toBl(ApiElastigroupScalingDimensionGcp scalingDimension) {
        ElastigroupScalingDimensionGcp retVal = null;

        if (scalingDimension != null) {
            ElastigroupScalingDimensionGcp.Builder retValBuilder = ElastigroupScalingDimensionGcp.Builder.get();

            if (scalingDimension.isNameSet()) {
                retValBuilder.setName(scalingDimension.getName());
            }

            if (scalingDimension.isValueSet()) {
                retValBuilder.setValue(scalingDimension.getValue());
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupScalingActionGcp toBl(ApiElastigroupScalingActionGcp scalingAction) {
        ElastigroupScalingActionGcp retVal = null;

        if (scalingAction != null) {
            ElastigroupScalingActionGcp.Builder retValBuilder = ElastigroupScalingActionGcp.Builder.get();

            if (scalingAction.isTypeSet()) {
                retValBuilder.setType(scalingAction.getType());
            }

            if (scalingAction.isAdjustmentSet()) {
                retValBuilder.setAdjustment(scalingAction.getAdjustment());
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupSchedulingGcp toBl(ApiElastigroupSchedulingGcp apiScheduling) {
        ElastigroupSchedulingGcp blSchedulingConfiguration = null;

        if (apiScheduling != null) {
            ElastigroupSchedulingGcp.Builder blSchedulingConfigurationBuilder =
                    ElastigroupSchedulingGcp.Builder.get();
            if (apiScheduling.isTasksSet()) {
                if (apiScheduling.getTasks() != null) {
                    List<ElastigroupScheduleTasksConfigurationGcp> tasksConfigurationList =
                            apiScheduling.getTasks().stream().map(ElastigroupConverterGcp::toBl)
                                    .collect(Collectors.toList());
                    blSchedulingConfigurationBuilder.setTasks(tasksConfigurationList);
                }
            }
            blSchedulingConfiguration = blSchedulingConfigurationBuilder.build();
        }
        return blSchedulingConfiguration;
    }

    private static ElastigroupScheduleTasksConfigurationGcp toBl(ApiElastigroupScheduleTasksConfigurationGcp apiScheduledTask) {
        ElastigroupScheduleTasksConfigurationGcp bLTasks = null;

        if (apiScheduledTask != null) {
            ElastigroupScheduleTasksConfigurationGcp.Builder blTasksBuilder = ElastigroupScheduleTasksConfigurationGcp.Builder.get();
            if (apiScheduledTask.isIsEnabledSet()) {
                blTasksBuilder.setIsEnabled(apiScheduledTask.getIsEnabled());
            }
            if (apiScheduledTask.isCronExpressionSet()) {
                blTasksBuilder.setCronExpression(apiScheduledTask.getCronExpression());
            }
            if (apiScheduledTask.isTaskTypeSet()) {
                blTasksBuilder.setTaskType(apiScheduledTask.getTaskType());
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

    private static ElastigroupThirdPartiesIntegrationGcp toBl(
            ApiElastigroupThirdPartiesIntegrationGcp apiThirdPartiesIntegration) {
        ElastigroupThirdPartiesIntegrationGcp blThirdPartiesIntegration = null;

        if (apiThirdPartiesIntegration != null) {
            ElastigroupThirdPartiesIntegrationGcp.Builder blThirdPartiesIntegrationBuilder =
                    ElastigroupThirdPartiesIntegrationGcp.Builder.get();

            if (apiThirdPartiesIntegration.isGkeSet()) {
                blThirdPartiesIntegrationBuilder.setGke(toBl(apiThirdPartiesIntegration.getGke()));
            }

            if (apiThirdPartiesIntegration.isDockerSwarmSet()) {
                blThirdPartiesIntegrationBuilder.setDockerSwarm(toBl(apiThirdPartiesIntegration.getDockerSwarm()));
            }
            blThirdPartiesIntegration = blThirdPartiesIntegrationBuilder.build();
        }
        return blThirdPartiesIntegration;
    }

    private static ElastigroupDockerSwarmGcp toBl(
            ApiElastigroupDockerSwarmGcp apiDockerSwarm) {
        ElastigroupDockerSwarmGcp blDockerSwarm = null;

        if (apiDockerSwarm != null) {
            ElastigroupDockerSwarmGcp.Builder blThirdPartiesIntegrationBuilder =
                    ElastigroupDockerSwarmGcp.Builder.get();

            if (apiDockerSwarm.isMasterHostSet()) {
                blThirdPartiesIntegrationBuilder.setMasterHost(apiDockerSwarm.getMasterHost());
            }

            if (apiDockerSwarm.isMasterPortSet()) {
                blThirdPartiesIntegrationBuilder.setMasterPort(apiDockerSwarm.getMasterPort());
            }
            blDockerSwarm = blThirdPartiesIntegrationBuilder.build();
        }
        return blDockerSwarm;
    }

    private static ElastigroupGkeConfigurationGcp toBl(ApiElastigroupGkeConfigurationGcp apiGke) {
        ElastigroupGkeConfigurationGcp blGke = null;

        if (apiGke != null) {
            ElastigroupGkeConfigurationGcp.Builder blEcsBuilder = ElastigroupGkeConfigurationGcp.Builder.get();

            if (apiGke.isAutoUpdateSet()) {
                blEcsBuilder.setAutoUpdate(apiGke.getAutoUpdate());
            }
            if (apiGke.isAutoScaleSet()) {
                blEcsBuilder.setAutoScale(toBl(apiGke.getAutoScale()));
            }
            if (apiGke.isClusterIdentifierSet()) {
                blEcsBuilder.setClusterIdentifier(apiGke.getClusterIdentifier());
            }
            if (apiGke.isLocationSet()) {
                blEcsBuilder.setLocation(apiGke.getLocation());
            }
            blGke = blEcsBuilder.build();
        }
        return blGke;
    }

    private static ElastigroupAutoscaleConfigurationGcp toBl(ApiElastigroupAutoscaleConfigurationGcp apiAutoScale) {
        ElastigroupAutoscaleConfigurationGcp blAutoScale = null;

        if (apiAutoScale != null) {
            ElastigroupAutoscaleConfigurationGcp.Builder blAutoScaleBuilder =
                    ElastigroupAutoscaleConfigurationGcp.Builder.get();

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
            blAutoScale = blAutoScaleBuilder.build();
        }
        return blAutoScale;
    }

    private static ElastigroupHeadroomSpecificationGcp toBl(ApiElastigroupHeadroomSpecificationGcp apiHeadroom) {
        ElastigroupHeadroomSpecificationGcp blHeadroom = null;

        if (apiHeadroom != null) {
            ElastigroupHeadroomSpecificationGcp.Builder blHeadroomBuilder = ElastigroupHeadroomSpecificationGcp.Builder.get();

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

    private static ElastigroupDownSpecificationGcp toBl(ApiElastigroupDownSpecificationGcp apidown) {
        ElastigroupDownSpecificationGcp blDown = null;

        if (apidown != null) {
            ElastigroupDownSpecificationGcp.Builder blDownBuilder = ElastigroupDownSpecificationGcp.Builder.get();

            if (apidown.isEvaluationPeriodsSet()) {
                blDownBuilder.setEvaluationPeriods(apidown.getEvaluationPeriods());
            }
            blDown = blDownBuilder.build();
        }
        return blDown;
    }

    private static ElastigroupMetadataGcp toBl(ApiElastigroupMetadataGcp apiMetadata) {
        ElastigroupMetadataGcp blMetadata = null;

        if (apiMetadata != null) {
            ElastigroupMetadataGcp.Builder blDownBuilder = ElastigroupMetadataGcp.Builder.get();

            if (apiMetadata.isKeySet()) {
                blDownBuilder.setKey(apiMetadata.getKey());
            }
            if (apiMetadata.isValueSet()) {
                blDownBuilder.setValue(apiMetadata.getValue());
            }
            blMetadata = blDownBuilder.build();
        }
        return blMetadata;
    }

    private static ElastigroupBackendServiceConfigGcp toBl(ApiElastigroupBackendServiceConfigGcp apiBackendService) {
        ElastigroupBackendServiceConfigGcp backendServiceConfigGcp = null;

        if (apiBackendService != null) {
            ElastigroupBackendServiceConfigGcp.Builder blBackendBuilder = ElastigroupBackendServiceConfigGcp.Builder.get();

            if (apiBackendService.isBackendServicesSet()) {
                if (apiBackendService.getBackendServices() != null) {
                    List<ElastigroupBackendServicesGcp> backendService =
                            apiBackendService.getBackendServices().stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                    blBackendBuilder.setBackendServices(backendService);
                }
            }
            backendServiceConfigGcp = blBackendBuilder.build();
        }
        return backendServiceConfigGcp;
    }

    private static ElastigroupBackendServicesGcp toBl(ApiElastigroupBackendServicesGcp apiBackendService) {
        ElastigroupBackendServicesGcp backendServiceGcp = null;

        if (apiBackendService != null) {
            ElastigroupBackendServicesGcp.Builder blBackendBuilder = ElastigroupBackendServicesGcp.Builder.get();

            if (apiBackendService.isNamedPortsSet()) {
                blBackendBuilder.setNamedPorts(toBl(apiBackendService.getNamedPorts()));
            }

            if (apiBackendService.isSchemeSet()) {
                blBackendBuilder.setScheme(apiBackendService.getScheme());
            }

            if (apiBackendService.isLocationTypeSet()) {
                blBackendBuilder.setLocationType(apiBackendService.getLocationType());
            }

            if (apiBackendService.isBackendServiceNameSet()) {
                blBackendBuilder.setBackendServiceName(apiBackendService.getBackendServiceName());
            }

            backendServiceGcp = blBackendBuilder.build();
        }
        return backendServiceGcp;
    }

    private static ElastigroupNamedPortsGcp toBl(ApiElastigroupNamedPortsGcp apiNamedPorts) {
        ElastigroupNamedPortsGcp namedPorts = null;

        if (apiNamedPorts != null) {
            ElastigroupNamedPortsGcp.Builder namedPortsBuilder = ElastigroupNamedPortsGcp.Builder.get();

            if (apiNamedPorts.isNameSet()) {
                namedPortsBuilder.setName(apiNamedPorts.getName());
            }

            if (apiNamedPorts.isPortsSet()) {
                namedPortsBuilder.setPorts(apiNamedPorts.getPorts());
            }

            if (apiNamedPorts.isPortsSet()) {

                if (apiNamedPorts.getPorts() == null) {
                    namedPortsBuilder.setPorts(null);
                } else {
                    namedPortsBuilder.setPorts(new LinkedList<>(apiNamedPorts.getPorts()));
                }
            }

            namedPorts = namedPortsBuilder.build();
        }
        return namedPorts;
    }
}
