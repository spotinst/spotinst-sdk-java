package com.spotinst.sdkjava.model.bl.gcp;

import com.spotinst.sdkjava.enums.ScalingActionTypeEnum;
import com.spotinst.sdkjava.enums.SchedulingTaskTypeEnumAzure;
import com.spotinst.sdkjava.model.api.gcp.*;
import com.spotinst.sdkjava.model.bl.gcp.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ElastigroupConverterGcp {
    //region BL -> DAL
    public static ApiElastigroupGcp toDal(ElastigroupGcp src) {
        ApiElastigroupGcp apiGroup = null;
        if (src != null) {
            apiGroup = new ApiElastigroupGcp();
            if (src.isNameSet()) {
                apiGroup.setName(src.getName());
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
        }
        return apiGroup;
    }

    private static ApiGroupComputeGcp toDal(ElastigroupComputeConfigurationGcp compute) {
        ApiGroupComputeGcp optCompute = null;
        if (compute != null) {
            optCompute = new ApiGroupComputeGcp();
            if (compute.isAvailabilityZonesSet()) {
                optCompute.setAvailabilityZones(new LinkedList<>(compute.getAvailabilityZones()));
            }
            if (compute.isLaunchSpecificationSet()) {
                optCompute.setLaunchSpecification(toDal(compute.getLaunchSpecification()));
            }
            if (compute.isSubnetsSet()) {
                if(compute.getSubnets() != null){
                    List<ApiSubnetsGcp> optimizerSubnets=
                        compute.getSubnets().stream().map(ElastigroupConverterGcp::toDal)
                               .collect(Collectors.toList());
                    optCompute.setSubnets(optimizerSubnets);
                }
            }
            if (compute.isInstanceTypesSet()) {
                optCompute.setInstanceTypes(toDal(compute.getInstanceTypes()));
            }
        }
        return optCompute;
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
                }
            }
            if (launchSpecification.isNetworkInterfacesSet()) {
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterfacesGcp> optimizerNetworkInterfaces =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverterGcp::toDal)
                                               .collect(Collectors.toList());
                    retVal.setNetworkInterfaces(optimizerNetworkInterfaces);
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
            if (disksGcp.isInterfazeSet()) {
                retVal.setInterfaze(disksGcp.getInterfaze());
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
                    retVal.setSubnetNames(new LinkedList<>(subnetsGcp.getSubnetNames()));
                }
            }
        }
        return retVal;
    }


    private static ApiStrategyGcp toDal(ElastigroupStrategyConfigurationGcp strategyConfigurationGcp) {
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
                retVal.setOptimizationWindows(new LinkedList<>(strategyConfigurationGcp.getOptimizationWindows()));
            }
            if (strategyConfigurationGcp.isRevertToPreemptibleSet()) {
                retVal.setRevertToPreemptible(toDal(strategyConfigurationGcp.getRevertToPreemptible()));
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

    private static ApiCapacityGcp toDal(ElastigroupCapacityConfigurationGcp capacityConfigurationGcp) {
        ApiCapacityGcp retVal = null;
        if (capacityConfigurationGcp != null) {
            retVal = new ApiCapacityGcp();
            if (capacityConfigurationGcp.isMinimumSet()) {
                retVal.setMinimum(capacityConfigurationGcp.getMinimum());
            }
            if (capacityConfigurationGcp.isMaximumSet()) {
                retVal.setMaximum(capacityConfigurationGcp.getMaximum());
            }
            if (capacityConfigurationGcp.isTargetSet()) {
                retVal.setTarget(capacityConfigurationGcp.getTarget());
            }
            if (capacityConfigurationGcp.isUnitSet()) {
                retVal.setUnit(capacityConfigurationGcp.getUnit());
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
                retVal.setPreemptible(new LinkedList<>(instanceTypesGcp.getPreemptible()));
            }
        }
        return retVal;
    }
    //endregion

    //region DAL -> BL
    public static ElastigroupGcp toBl(ApiElastigroupGcp src) {
        ElastigroupGcp elastigroup = null;
        if (src != null) {
            ElastigroupGcp.Builder elastigroupBuilder= ElastigroupGcp.Builder.get();
            if (src.isIdSet()) {
                elastigroupBuilder.setId(src.getId());
            }
            if (src.isNameSet()) {
                elastigroupBuilder.setName(src.getName());
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
            elastigroup=elastigroupBuilder.build();
            // createdAt is not taken from builder since it cannot be set when creating/updating an Elastigroup
            if (src.isCreatedAtSet()) {
                elastigroup.setCreatedAt(src.getCreatedAt());
            }
        }
        return elastigroup;
    }

    private static ElastigroupComputeConfigurationGcp toBl(ApiGroupComputeGcp compute) {
        ElastigroupComputeConfigurationGcp blCompute = null;
        if (compute != null) {
            ElastigroupComputeConfigurationGcp.Builder blComputeBuilder = ElastigroupComputeConfigurationGcp.Builder.get();
            if (compute.isAvailabilityZonesSet()) {
                blComputeBuilder.setAvailabilityZones(new LinkedList<>(compute.getAvailabilityZones()));
            }
            if (compute.isLaunchSpecificationSet()) {
                blComputeBuilder.setLaunchSpecification(toBl(compute.getLaunchSpecification()));
            }
            if (compute.isSubnetsSet()) {
                if(compute.getSubnets() != null) {
                    List<ApiSubnetsGcp> apiOptimizerSubnets = compute.getSubnets();
                    List<ElastigroupSubnetsGcp> optimizerSubnets = apiOptimizerSubnets.stream().map(ElastigroupConverterGcp::toBl)
                                                .collect(Collectors.toList());
                    blComputeBuilder.setSubnets(optimizerSubnets);
                }
            }
            if (compute.isInstanceTypesSet()) {
                blComputeBuilder.setInstanceTypes(toBl(compute.getInstanceTypes()));
            }
            blCompute = blComputeBuilder.build();
        }
        return blCompute;
    }

    private static ElastigroupLaunchSpecificationGcp toBl(ApiLaunchSpecificationGcp launchSpecification) {
        ElastigroupLaunchSpecificationGcp blLaunchSpecification = null;
        if (launchSpecification != null) {
            ElastigroupLaunchSpecificationGcp.Builder blLaunchSpecificationBuilder = ElastigroupLaunchSpecificationGcp.Builder.get() ;
            if (launchSpecification.isDisksSet()) {
                if (launchSpecification.getDisks() != null) {
                    List<ApiDisksGcp> apiOptimizerDisks = launchSpecification.getDisks();
                    List<ElastigroupDisksGcp> optimizerDisks = apiOptimizerDisks.stream().map(ElastigroupConverterGcp::toBl)
                                               .collect(Collectors.toList());
                    blLaunchSpecificationBuilder.setDisks(optimizerDisks);
                }
            }
            if (launchSpecification.isNetworkInterfacesSet()) {
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterfacesGcp> apiOptimizerNetworkInterfaces = launchSpecification.getNetworkInterfaces();
                    List<ElastigroupNetworkInterfacesGcp> optimizerNetworkInterfaces = apiOptimizerNetworkInterfaces.stream().map(ElastigroupConverterGcp::toBl)
                                               .collect(Collectors.toList());
                    blLaunchSpecificationBuilder.setNetworkInterfaces(optimizerNetworkInterfaces);
                }
            }
            blLaunchSpecification = blLaunchSpecificationBuilder.build();
        }
        return blLaunchSpecification;
    }

    private static ElastigroupDisksGcp toBl(ApiDisksGcp disksGcp) {
        ElastigroupDisksGcp blDisksGcp = null;
        if (disksGcp != null) {
            ElastigroupDisksGcp.Builder blDisksGcpBuilder= ElastigroupDisksGcp.Builder.get();
            if (disksGcp.isAutoDeleteSet()) {
                blDisksGcpBuilder.setAutoDelete(disksGcp.getAutoDelete());
            }
            if (disksGcp.isBootSet()) {
                blDisksGcpBuilder.setBoot(disksGcp.getBoot());
            }
            if (disksGcp.isDeviceNameSet()) {
                blDisksGcpBuilder.setDeviceName(disksGcp.getDeviceName());
            }
            if (disksGcp.isInterfazeSet()) {
                blDisksGcpBuilder.setInterfaze(disksGcp.getInterfaze());
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
            blDisksGcp = blDisksGcpBuilder.build();
        }
        return blDisksGcp;
    }

    private static ElastigroupInitializeParamsGcp toBl(ApiInitializeParamsGcp initializeParamsGcp) {
        ElastigroupInitializeParamsGcp blInitializeParamsGcp = null;
        if (initializeParamsGcp != null) {
            ElastigroupInitializeParamsGcp.Builder blInitializeParamsGcpBuilder = ElastigroupInitializeParamsGcp.Builder.get();
            if (initializeParamsGcp.isDiskSizeGbSet()) {
                blInitializeParamsGcpBuilder.setDiskSizeGb(initializeParamsGcp.getDiskSizeGb());
            }
            if (initializeParamsGcp.isDiskTypeSet()) {
                blInitializeParamsGcpBuilder.setDiskType(initializeParamsGcp.getDiskType());
            }
            if (initializeParamsGcp.isSourceImageSet()) {
                blInitializeParamsGcpBuilder.setSourceImage(initializeParamsGcp.getSourceImage());
            }
            blInitializeParamsGcp = blInitializeParamsGcpBuilder.build();
        }
        return blInitializeParamsGcp;
    }

    private static ElastigroupNetworkInterfacesGcp toBl(ApiNetworkInterfacesGcp network) {
        ElastigroupNetworkInterfacesGcp blNetwork = null;
        if (network != null) {
            ElastigroupNetworkInterfacesGcp.Builder blNetworkBuilder = ElastigroupNetworkInterfacesGcp.Builder.get();
            if (network.isNetworkSet()) {
                blNetworkBuilder.setNetwork(network.getNetwork());
            }
            if (network.isProjectIdSet()) {
                blNetworkBuilder.setProjectId(network.getProjectId());
            }
            blNetwork = blNetworkBuilder.build();
        }
        return blNetwork;
    }

    private static ElastigroupSubnetsGcp toBl(ApiSubnetsGcp subnetsGcp) {
        ElastigroupSubnetsGcp blSubnetsGcp = null;
        if (subnetsGcp != null) {
            ElastigroupSubnetsGcp.Builder blSubnetsGcpBuilder = ElastigroupSubnetsGcp.Builder.get();
            if (subnetsGcp.isRegionSet()) {
                blSubnetsGcpBuilder.setRegion(subnetsGcp.getRegion());
            }
            if (subnetsGcp.isSubnetNamesSet()) {
                if (subnetsGcp.getSubnetNames() != null) {
                    blSubnetsGcpBuilder.setSubnetNames(new LinkedList<>(subnetsGcp.getSubnetNames()));
                }
            }
            blSubnetsGcp=blSubnetsGcpBuilder.build();
        }
        return blSubnetsGcp;
    }

    private static ElastigroupStrategyConfigurationGcp toBl(ApiStrategyGcp strategyConfigurationGcp) {
        ElastigroupStrategyConfigurationGcp blStrategyConfigurationGcp = null;
        if (strategyConfigurationGcp != null) {
            ElastigroupStrategyConfigurationGcp.Builder blStrategyConfigurationGcpBuilder= ElastigroupStrategyConfigurationGcp.Builder.get();
            if (strategyConfigurationGcp.isPreemptiblePercentageSet()) {
                blStrategyConfigurationGcpBuilder.setPreemptiblePercentage(strategyConfigurationGcp.getPreemptiblePercentage());
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
                blStrategyConfigurationGcpBuilder.setOptimizationWindows(new LinkedList<>(strategyConfigurationGcp.getOptimizationWindows()));
            }
            if (strategyConfigurationGcp.isRevertToPreemptibleSet()) {
                blStrategyConfigurationGcpBuilder.setRevertToPreemptible(toBl(strategyConfigurationGcp.getRevertToPreemptible()));
            }
            blStrategyConfigurationGcp = blStrategyConfigurationGcpBuilder.build();
        }
        return blStrategyConfigurationGcp;
    }

    private static ElastigroupRevertToPreemptibleGcp toBl(ApiRevertToPreemptibleGcp revertToPreemptibleGcp) {
        ElastigroupRevertToPreemptibleGcp blRevertToPreemptibleGcp = null;
        if (revertToPreemptibleGcp != null) {
            ElastigroupRevertToPreemptibleGcp.Builder blRevertToPreemptibleGcpBuilder = ElastigroupRevertToPreemptibleGcp.Builder.get();
            if (revertToPreemptibleGcp.isPerformAtSet()) {
                blRevertToPreemptibleGcpBuilder.setPerformAt(revertToPreemptibleGcp.getPerformAt());
            }
            blRevertToPreemptibleGcp = blRevertToPreemptibleGcpBuilder.build();
        }
        return blRevertToPreemptibleGcp;
    }

    private static ElastigroupCapacityConfigurationGcp toBl(ApiCapacityGcp capacityConfigurationGcp) {
        ElastigroupCapacityConfigurationGcp blCapacityConfigurationGcp = null;
        if (capacityConfigurationGcp != null) {
            ElastigroupCapacityConfigurationGcp.Builder blCapacityConfigurationGcpBuilder = ElastigroupCapacityConfigurationGcp.Builder.get();
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
            blCapacityConfigurationGcp = blCapacityConfigurationGcpBuilder.build();
        }
        return blCapacityConfigurationGcp;
    }

    private static ElastigroupInstanceTypesGcp toBl(ApiInstanceTypesGcp instanceTypesGcp) {
        ElastigroupInstanceTypesGcp blInstanceTypesGcp = null;
        if (instanceTypesGcp != null) {
            ElastigroupInstanceTypesGcp.Builder blInstanceTypesGcpBuilder = ElastigroupInstanceTypesGcp.Builder.get();
            if (instanceTypesGcp.isOndemandSet()) {
                blInstanceTypesGcpBuilder.setOndemand(instanceTypesGcp.getOndemand());
            }
            if (instanceTypesGcp.isPreemptibleSet()) {
                blInstanceTypesGcpBuilder.setPreemptible(new LinkedList<>(instanceTypesGcp.getPreemptible()));
            }
            blInstanceTypesGcp = blInstanceTypesGcpBuilder.build();
        }
        return blInstanceTypesGcp;
    }
    //endregion
}
