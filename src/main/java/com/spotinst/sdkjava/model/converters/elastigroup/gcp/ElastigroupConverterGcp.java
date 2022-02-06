package com.spotinst.sdkjava.model.converters.elastigroup.gcp;

import com.spotinst.sdkjava.model.api.gcp.*;
import com.spotinst.sdkjava.model.bl.gcp.*;

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
                }
                else {
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
                else {
                    retVal.setDisks(null);
                }
            }

            if (launchSpecification.isNetworkInterfacesSet()) {
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterfacesGcp> optimizerNetworkInterfaces =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverterGcp::toDal)
                                               .collect(Collectors.toList());
                    retVal.setNetworkInterfaces(optimizerNetworkInterfaces);
                }
                else {
                    retVal.setNetworkInterfaces(null);
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

                    if(subnetsGcp.getSubnetNames() == null) {
                        retVal.setSubnetNames(null);
                    }
                    else {
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

                if(strategyConfigurationGcp.getOptimizationWindows() == null) {
                    retVal.setOptimizationWindows(null);
                }
                else {
                    retVal.setOptimizationWindows(new LinkedList<>(strategyConfigurationGcp.getOptimizationWindows()));
                }
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
                }
                else {
                    retVal.setPreemptible(new LinkedList<>(instanceTypesGcp.getPreemptible()));
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

        }

        return retVal;
    }

    private static ElastigroupComputeGcp toBl(ApiGroupComputeGcp compute) {
        ElastigroupComputeGcp retVal = null;

        if (compute != null) {
            ElastigroupComputeGcp.Builder blComputeBuilder = ElastigroupComputeGcp.Builder.get();

            if (compute.isAvailabilityZonesSet()) {

                if(compute.getAvailabilityZones() == null) {
                    blComputeBuilder.setAvailabilityZones(null);
                }

                else {
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
                }

                else {
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
                }

                else {
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
                }

                else {
                    blLaunchSpecificationBuilder.setNetworkInterfaces(null);
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
                else {
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

                if (strategyConfigurationGcp.getOptimizationWindows() != null){
                    blStrategyConfigurationGcpBuilder.setOptimizationWindows(new LinkedList<>(strategyConfigurationGcp.getOptimizationWindows()));
                }

                else {
                    blStrategyConfigurationGcpBuilder.setOptimizationWindows(null);
                }
            }

            if (strategyConfigurationGcp.isRevertToPreemptibleSet()) {
                ElastigroupRevertToPreemptibleGcp blRevertToPreemptible =
                        toBl(strategyConfigurationGcp.getRevertToPreemptible());
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
                }

                else {
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
                List<ElastigroupScaleUpNewPreemptiblesListGcp> newPreemptiblesList =
                        elastigroupScaleUpResponseGcp.getNewPreemptiblesList().stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                retVal.setNewPreemptibles(newPreemptiblesList);            }

            if (elastigroupScaleUpResponseGcp.isNewInstancesSet()== true && elastigroupScaleUpResponseGcp.getNewInstancesList()!=null) {
                List<ElastigroupScaleUpNewInstancesListGcp> newInstancesList =
                        elastigroupScaleUpResponseGcp.getNewInstancesList().stream().map(ElastigroupConverterGcp::toBl)
                        .collect(Collectors.toList());
                retVal.setNewInstances(newInstancesList);
            }
        }
        return retVal;

    }

    private static ElastigroupScaleUpNewPreemptiblesListGcp toBl(
            ApiElastigroupScaleUpNewPreemptiblesListGcp elastigroupScaleUpNewPreemptiblesListGcp) {
        ElastigroupScaleUpNewPreemptiblesListGcp retVal = null;

        if (elastigroupScaleUpNewPreemptiblesListGcp != null) {

            retVal = new ElastigroupScaleUpNewPreemptiblesListGcp();

            if (elastigroupScaleUpNewPreemptiblesListGcp.isInstanceNameSet()) {
                retVal.setInstanceName(elastigroupScaleUpNewPreemptiblesListGcp.getInstanceName());
            }

        }
        return retVal;

    }

    private static ElastigroupScaleUpNewInstancesListGcp toBl(
            ApiElastigroupScaleUpNewInstancesListGcp elastigroupScaleUpNewInstancesListGcp) {
        ElastigroupScaleUpNewInstancesListGcp retVal = null;

        if (elastigroupScaleUpNewInstancesListGcp != null) {
            retVal = new ElastigroupScaleUpNewInstancesListGcp();


            if (elastigroupScaleUpNewInstancesListGcp.isInstanceNameSet()) {
                retVal.setInstanceName(elastigroupScaleUpNewInstancesListGcp.getInstanceName());
            }
        }
        return retVal;

    }

    public static ElastigroupScaleDownResponseGcp toBl(ApiElastigroupScaleDownResponseGcp elastigroupScaleDownResponseGcp) {
        ElastigroupScaleDownResponseGcp retVal = null;

        if (elastigroupScaleDownResponseGcp != null) {
            retVal = new ElastigroupScaleDownResponseGcp();

            if (elastigroupScaleDownResponseGcp.isVictimPreemptiblesListSet()) {
                List<ElastigroupScaleDownVictimPreemptiblesListGcp> victimPreemptiblesList =
                        elastigroupScaleDownResponseGcp.getVictimPreemptibles().stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                retVal.setVictimPreemptibles(victimPreemptiblesList);
            }

            if (elastigroupScaleDownResponseGcp.isVictimInstancesListSet()== true && elastigroupScaleDownResponseGcp.getVictimInstancesList()!=null) {
                List<ElastigroupScaleDownVictimInstancesListGcp> victimInstancesList =
                        elastigroupScaleDownResponseGcp.getVictimInstancesList().stream().map(ElastigroupConverterGcp::toBl)
                                .collect(Collectors.toList());
                retVal.setVictimInstancesList(victimInstancesList);
            }
        }
        return retVal;

    }

    private static ElastigroupScaleDownVictimPreemptiblesListGcp toBl(
            ApiElastigroupScaleDownVictimPreemptiblesListGcp elastigroupScaleDownVictimPreemptiblesListGcp) {
        ElastigroupScaleDownVictimPreemptiblesListGcp retVal = null;

        if (elastigroupScaleDownVictimPreemptiblesListGcp != null) {

            retVal = new ElastigroupScaleDownVictimPreemptiblesListGcp();

            if (elastigroupScaleDownVictimPreemptiblesListGcp.isInstanceNameSet()) {
                retVal.setInstanceName(elastigroupScaleDownVictimPreemptiblesListGcp.getInstanceName());
            }

        }
        return retVal;

    }

    private static ElastigroupScaleDownVictimInstancesListGcp toBl(
            ApiElastigroupScaleDownVictimInstancesListGcp elastigroupScaleDownVictimInstancesListGcp) {
        ElastigroupScaleDownVictimInstancesListGcp retVal = null;

        if (elastigroupScaleDownVictimInstancesListGcp != null) {
            retVal = new ElastigroupScaleDownVictimInstancesListGcp();


            if (elastigroupScaleDownVictimInstancesListGcp.isInstanceNameSet()) {
                retVal.setInstanceName(elastigroupScaleDownVictimInstancesListGcp.getInstanceName());
            }
        }
        return retVal;

    }

    //endregion
}