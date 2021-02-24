package com.spotinst.sdkjava.model.bl.gcp;


import com.spotinst.sdkjava.model.api.gcp.*;


import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


// todo or: follow convention, call return value "retVal" - DONE
// todo or: follow convenrtion, separate new code blocks - DONE
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
        }

        return retVal;
    }

    private static ApiGroupComputeGcp toDal(ElastigroupComputeGcp compute) {
        ApiGroupComputeGcp retVal = null;

        if (compute != null) {
            retVal = new ApiGroupComputeGcp();

            if (compute.isAvailabilityZonesSet()) {
                // todo or: what if set to null?
                retVal.setAvailabilityZones(new LinkedList<>(compute.getAvailabilityZones()));
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
                    // todo or: what if set to null? (maybe check with product if it can be nullified)
                    retVal.setSubnetNames(new LinkedHashSet<>(subnetsGcp.getSubnetNames()));
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
                // todo or: what if it's set to null?
                retVal.setOptimizationWindows(new LinkedList<>(strategyConfigurationGcp.getOptimizationWindows()));
            }
            else {
                retVal.setOptimizationWindows(null);
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

    // todo or: align names, either with or without "Configuration" - DONE
    private static ApiCapacityGcp toDal(ElastigroupCapacityGcp capacityConfigurationGcp) {
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
                // todo or: what if set to null?
                retVal.setPreemptible(new LinkedList<>(instanceTypesGcp.getPreemptible()));
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
        }

        return retVal;
    }

    private static ElastigroupComputeGcp toBl(ApiGroupComputeGcp compute) {
        ElastigroupComputeGcp retVal = null;

        if (compute != null) {
            ElastigroupComputeGcp.Builder blComputeBuilder = ElastigroupComputeGcp.Builder.get();

            if (compute.isAvailabilityZonesSet()) {
                // todo or: if null
                blComputeBuilder.setAvailabilityZones(new LinkedList<>(compute.getAvailabilityZones()));
            }
            if (compute.isLaunchSpecificationSet()) {
                blComputeBuilder.setLaunchSpecification(toBl(compute.getLaunchSpecification()));
            }
            if (compute.isSubnetsSet()) {
                if (compute.getSubnets() != null) {
                    // todo or: if null
                    List<ApiSubnetsGcp> apiOptimizerSubnets = compute.getSubnets();
                    List<ElastigroupSubnetsGcp> optimizerSubnets =
                            apiOptimizerSubnets.stream().map(ElastigroupConverterGcp::toBl)
                                               .collect(Collectors.toList());
                    blComputeBuilder.setSubnets(optimizerSubnets);
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
                // todo or: if null
                if (launchSpecification.getDisks() != null) {
                    List<ApiDisksGcp> apiOptimizerDisks = launchSpecification.getDisks();
                    List<ElastigroupDisksGcp> optimizerDisks =
                            apiOptimizerDisks.stream().map(ElastigroupConverterGcp::toBl).collect(Collectors.toList());
                    blLaunchSpecificationBuilder.setDisks(optimizerDisks);
                }
            }
            if (launchSpecification.isNetworkInterfacesSet()) {
                // todo or: if null
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterfacesGcp> apiOptimizerNetworkInterfaces =
                            launchSpecification.getNetworkInterfaces();
                    List<ElastigroupNetworkInterfacesGcp> optimizerNetworkInterfaces =
                            apiOptimizerNetworkInterfaces.stream().map(ElastigroupConverterGcp::toBl)
                                                         .collect(Collectors.toList());
                    blLaunchSpecificationBuilder.setNetworkInterfaces(optimizerNetworkInterfaces);
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
                // todo or: what if it became back as null from Api?
                blStrategyConfigurationGcpBuilder
                        .setOptimizationWindows(new LinkedList<>(strategyConfigurationGcp.getOptimizationWindows()));
            }
            if (strategyConfigurationGcp.isRevertToPreemptibleSet()) {
                ElastigroupRevertToPreemptibleGcp blRevertToPreemptible = toBl(strategyConfigurationGcp.getRevertToPreemptible());
                blStrategyConfigurationGcpBuilder.setRevertToPreemptible(blRevertToPreemptible);
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
                // todo or: if null
                blInstanceTypesGcpBuilder.setPreemptible(new LinkedList<>(instanceTypesGcp.getPreemptible()));
            }
            retVal = blInstanceTypesGcpBuilder.build();
        }

        return retVal;
    }
    //endregion
}