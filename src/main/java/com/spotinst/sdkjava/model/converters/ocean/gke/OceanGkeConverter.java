package com.spotinst.sdkjava.model.converters.ocean.gke;

import com.spotinst.sdkjava.enums.OceanGkeLaunchSpecRootVolumeTypeEnum;
import com.spotinst.sdkjava.model.api.ocean.gke.*;
import com.spotinst.sdkjava.model.bl.ocean.gke.*;

import java.util.List;
import java.util.stream.Collectors;

public class OceanGkeConverter {

    //region BL -> DAL
    public static ApiOceanGkeCluster toDal(OceanGkeCluster src) {
        ApiOceanGkeCluster apiCluster = null;

        if (src != null) {
            apiCluster = new ApiOceanGkeCluster();

            if (src.isIdSet()) {
                apiCluster.setId(src.getId());
            }
            if (src.isNameSet()) {
                apiCluster.setName(src.getName());
            }
            if (src.isControllerClusterIdSet()) {
                apiCluster.setControllerClusterId(src.getControllerClusterId());
            }
            if(src.isGkeSet()) {
                apiCluster.setGke(toDal(src.getGke()));
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
            if(src.isSecuritySet()){
                apiCluster.setSecurity(toDal(src.getSecurity()));
            }
        }

        return apiCluster;
    }

    private static ApiClusterAutoScalerConfiguration toDal(ClusterAutoScalerConfiguration autoScaler) {
        ApiClusterAutoScalerConfiguration retval = null;

        if (autoScaler != null) {
            retval = new ApiClusterAutoScalerConfiguration();

            if (autoScaler.isIsEnabledSet()) {
                retval.setIsEnabled(autoScaler.getIsEnabled());
            }
            if (autoScaler.isAutoHeadroomPercentageSet()) {
                retval.setAutoHeadroomPercentage(autoScaler.getAutoHeadroomPercentage());
            }
            if (autoScaler.isCooldownSet()) {
                retval.setCooldown(autoScaler.getCooldown());
            }
            if (autoScaler.isResourceLimitsSet()) {
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
            if(autoScaler.isEnableAutomaticAndManualHeadroomSet()){
                retval.setEnableAutomaticAndManualHeadroom(autoScaler.getEnableAutomaticAndManualHeadroom());
            }
        }
        return retval;
    }

    private static ApiClusterResourceLimitsSpecification toDal(ClusterResourceLimitsSpecification resourceLimitsSpecification) {
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

    private static ApiClusterGkeConfiguration toDal(ClusterGkeConfiguration gke){
        ApiClusterGkeConfiguration retVal = null;

        if (gke != null) {
            retVal = new ApiClusterGkeConfiguration();

            if(gke.isClusterNameSet()){
                retVal.setClusterName(gke.getClusterName());
            }
            if(gke.isMasterLocationSet()){
                retVal.setMasterLocation(gke.getMasterLocation());
            }

        }
        return retVal;
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

    private static ApiClusterComputeConfiguration toDal(ClusterComputeConfiguration compute) {
        ApiClusterComputeConfiguration retVal = null;

        if (compute != null) {
            retVal = new ApiClusterComputeConfiguration();

            if (compute.isAvailabilityZonesSet()) {
                retVal.setAvailabilityZones(compute.getAvailabilityZones());
            }
            if (compute.isBackendServicesSet()) {
                List<ApiClusterBackendServicesConfiguration> backendServices = compute.getBackendServices().stream().map(OceanGkeConverter::toDal).collect(Collectors.toList());
                retVal.setBackendServices(backendServices);
            }
            if (compute.isInstanceTypesSet()) {
                retVal.setInstanceTypes(toDal(compute.getInstanceTypes()));
            }
            if (compute.isSubnetNameSet()) {
                retVal.setSubnetName(compute.getSubnetName());
            }
            if (compute.isLaunchSpecificationSet()) {
                retVal.setLaunchSpecification(toDal(compute.getLaunchSpecification()));
            }
            if (compute.isNetworkInterfacesSet()) {
                List<ApiClusterNetworkInterfacesConfiguration> networkInterfaces = compute.getNetworkInterfaces().stream().map(OceanGkeConverter::toDal).collect(Collectors.toList());
                retVal.setNetworkInterfaces(networkInterfaces);
            }

        }
        return retVal;
    }

    private static ApiClusterBackendServicesConfiguration toDal(ClusterBackendServicesConfiguration backendService){
        ApiClusterBackendServicesConfiguration retVal = null;

        if(backendService != null){
            retVal = new ApiClusterBackendServicesConfiguration();

            if(backendService.isBackendServiceNameSet()){
                retVal.setBackendServiceName(backendService.getBackendServiceName());
            }
            if(backendService.isLocationTypeSet()){
                retVal.setLocationType(backendService.getLocationType());
            }
        }

        return retVal;
    }

    private static ApiClusterInstanceTypesConfiguration toDal(ClusterInstanceTypesConfiguration instanceTypes){
        ApiClusterInstanceTypesConfiguration retVal = null;

        if(instanceTypes != null){
            retVal = new ApiClusterInstanceTypesConfiguration();

            if(instanceTypes.isWhitelistSet()){
                retVal.setWhitelist(instanceTypes.getWhitelist());
            }
        }

        return retVal;
    }

    private static ApiClusterNetworkInterfacesConfiguration toDal(ClusterNetworkInterfacesConfiguration apiNetworkInterfaces){
        ApiClusterNetworkInterfacesConfiguration retVal = null;

        if(apiNetworkInterfaces != null){
            retVal = new ApiClusterNetworkInterfacesConfiguration();

            if(apiNetworkInterfaces.isAccessConfigsSet()){
                List<ApiClusterAccessConfigsSpecification> accessconfig = apiNetworkInterfaces.getAccessConfigs()
                                                                                              .stream().map(OceanGkeConverter::toDal).collect(Collectors.toList());
                retVal.setAccessConfigs(accessconfig);
            }
            if(apiNetworkInterfaces.isAliasIpRangesSet()){
                List<ApiClusterAliasIpRangesSpecification> aliasIpRange =
                        apiNetworkInterfaces.getAliasIpRanges().stream().map(OceanGkeConverter::toDal)
                                            .collect(Collectors.toList());
                retVal.setAliasIpRanges(aliasIpRange);
            }
            if(apiNetworkInterfaces.isAccessConfigsSet()){
                retVal.setNetwork(apiNetworkInterfaces.getNetwork());
            }
            if(apiNetworkInterfaces.isProjectIdSet()){
                retVal.setProjectId(apiNetworkInterfaces.getProjectId());
            }
        }

        return retVal;
    }

    private static ApiClusterAccessConfigsSpecification toDal(ClusterAccessConfigsSpecification accessConfigs){
        ApiClusterAccessConfigsSpecification retVal = null;

        if(accessConfigs != null){
            retVal = new ApiClusterAccessConfigsSpecification();

            if(accessConfigs.isNameSet()){
                retVal.setName(accessConfigs.getName());
            }
            if(accessConfigs.isTypeSet()){
                retVal.setType(accessConfigs.getType());
            }
        }

        return retVal;
    }

    private static ApiClusterAliasIpRangesSpecification toDal(ClusterAliasIpRangesSpecification aliasIpRanges){
        ApiClusterAliasIpRangesSpecification retVal = null;

        if(aliasIpRanges != null){
            retVal = new ApiClusterAliasIpRangesSpecification();

            if(aliasIpRanges.isIpCidrRangeSet()){
                retVal.setIpCidrRange(aliasIpRanges.getIpCidrRange());
            }
            if(aliasIpRanges.isSubNetworkRangeNameSet()){
                retVal.setSubnetworkRangeName(aliasIpRanges.getSubnetworkRangeName());
            }
        }

        return retVal;
    }

    public static ApiLaunchSpecSpecification toDal(LaunchSpecSpecification launchSpec) {
        ApiLaunchSpecSpecification apiLaunchSpec = null;

        if (launchSpec != null) {
            apiLaunchSpec = new ApiLaunchSpecSpecification();

            if (launchSpec.isIdSet()) {
                apiLaunchSpec.setId(launchSpec.getId());
            }

            if (launchSpec.isNameSet()) {
                apiLaunchSpec.setName(launchSpec.getName());
            }

            if (launchSpec.isOceanIdSet()) {
                apiLaunchSpec.setOceanId(launchSpec.getOceanId());
            }

            if (launchSpec.isSourceImageSet()) {
                apiLaunchSpec.setSourceImage(launchSpec.getSourceImage());
            }

            if (launchSpec.isServiceAccountSet()) {
                apiLaunchSpec.setServiceAccount(launchSpec.getServiceAccount());
            }

            if (launchSpec.isRootVolumeSizeInGbSet()) {
                apiLaunchSpec.setRootVolumeSizeInGb(launchSpec.getRootVolumeSizeInGb());
            }

            if (launchSpec.isRootVolumeTypeSet()) {
                apiLaunchSpec.setRootVolumeType(launchSpec.getRootVolumeType().getName());
            }

            if (launchSpec.isRestrictScaleDownSet()) {
                apiLaunchSpec.setRestrictScaleDown(launchSpec.getRestrictScaleDown());
            }

            if (launchSpec.isMetadataSet()) {

                List<ApiLaunchSpecMetadataSpecification> metadata =
                        launchSpec.getMetadata().stream().map(OceanGkeConverter::toDal)
                           .collect(Collectors.toList());
                apiLaunchSpec.setMetadata(metadata);
            }

            if (launchSpec.isInstanceTypesSet()) {
                apiLaunchSpec.setInstanceTypes(launchSpec.getInstanceTypes());
            }

            if (launchSpec.isTaintsSet()) {

                List<ApiLaunchSpecTaintsSpecification> taint =
                        launchSpec.getTaints().stream().map(OceanGkeConverter::toDal)
                           .collect(Collectors.toList());

                apiLaunchSpec.setTaints(taint);
            }

            if (launchSpec.isLabelsSet()) {
                List<ApiLaunchSpecLabelsSpecification> lebels =
                        launchSpec.getLabels().stream().map(OceanGkeConverter::toDal)
                                           .collect(Collectors.toList());
                apiLaunchSpec.setLabels(lebels);
            }

            if (launchSpec.isAutoScaleSet()) {
                apiLaunchSpec.setAutoScale(toDal(launchSpec.getAutoScale()));
            }

            if (launchSpec.isResourceLimitsSet()) {
                apiLaunchSpec.setResourceLimits(toDal(launchSpec.getResourceLimits()));
            }

            if (launchSpec.isShieldedInstanceConfigSet()) {
                apiLaunchSpec.setShieldedInstanceConfig(toDal(launchSpec.getShieldedInstanceConfig()));
            }
            if (launchSpec.isStrategySet()) {
                apiLaunchSpec.setStrategy(toDal(launchSpec.getStrategy()));
            }
            if (launchSpec.isStorageSet()) {
                apiLaunchSpec.setStorage(toDal(launchSpec.getStorage()));
            }
            if (launchSpec.isIpForwardingSet()) {
                apiLaunchSpec.setIpForwarding(launchSpec.getIpForwarding());
            }
            if (launchSpec.isMinCpuPlatformSet()) {
                apiLaunchSpec.setMinCpuPlatform(launchSpec.getMinCpuPlatform());
            }
            if (launchSpec.isTagsSet()) {
                apiLaunchSpec.setTags(launchSpec.getTags());
            }
        }

        return apiLaunchSpec;
    }

    private static ApiLaunchSpecTaintsSpecification toDal(LaunchSpecTaintsSpecification taint) {

        ApiLaunchSpecTaintsSpecification apiLaunchSpecTaintsSpecification = null;

        if(taint != null){
            apiLaunchSpecTaintsSpecification = new ApiLaunchSpecTaintsSpecification();

            if (taint.isKeySet()) {
                apiLaunchSpecTaintsSpecification.setKey(taint.getKey());
            }

            if (taint.isEffectSet()) {
                apiLaunchSpecTaintsSpecification.setEffect(taint.getEffect());
            }

            if (taint.isValueSet()) {
                apiLaunchSpecTaintsSpecification.setValue(taint.getValue());
            }
        }
        return apiLaunchSpecTaintsSpecification;
    }

    private static ApiLaunchSpecLabelsSpecification toDal(LaunchSpecLabelsSpecification label) {

        ApiLaunchSpecLabelsSpecification apiLaunchSpecLabelsSpecification = null;

        if(label != null) {
            apiLaunchSpecLabelsSpecification = new ApiLaunchSpecLabelsSpecification();

            if (label.isKeySet()) {
                apiLaunchSpecLabelsSpecification.setKey(label.getKey());
            }

            if (label.isValueSet()) {
                apiLaunchSpecLabelsSpecification.setValue(label.getValue());
            }
        }
        return apiLaunchSpecLabelsSpecification;
    }

    private static ApiLaunchSpecAutoScaleSpecification toDal(LaunchSpecAutoScaleSpecification autoScale){
        ApiLaunchSpecAutoScaleSpecification autoScaleListToReturn = null;

        if(autoScale != null) {
            autoScaleListToReturn = new ApiLaunchSpecAutoScaleSpecification();

            if (autoScale.isHeadroomsSet()) {

                List<ApiLaunchSpecHeadRoomsSpecification> headrooms =
                        autoScale.getHeadrooms().stream().map(OceanGkeConverter::toDal).collect(Collectors.toList());

                autoScaleListToReturn.setHeadrooms(headrooms);
            }
        }
        return autoScaleListToReturn;
    }

    private static ApiLaunchSpecHeadRoomsSpecification toDal(LaunchSpecHeadroomsSpecification headroom) {

        ApiLaunchSpecHeadRoomsSpecification headRoomsListToReturn = null;

        if(headroom != null) {
            headRoomsListToReturn =  new ApiLaunchSpecHeadRoomsSpecification();

            if (headroom.isGpuPerUnitSet()) {
                headRoomsListToReturn.setGpuPerUnit(headroom.getGpuPerUnit());
            }

            if (headroom.isMemoryPerUnitSet()) {
                headRoomsListToReturn.setMemoryPerUnit(headroom.getMemoryPerUnit());
            }

            if(headroom.isCpuPerUnitSet()){
                headRoomsListToReturn.setCpuPerUnit(headroom.getCpuPerUnit());
            }

            if (headroom.isNumOfUnitsSet()) {
                headRoomsListToReturn.setNumOfUnits(headroom.getMemoryPerUnit());
            }
        }
        return headRoomsListToReturn;
    }

    private static ApiLaunchSpecResourceLimitSpecification toDal(LaunchSpecResourceLimitsSpecification resourceLimit){
        ApiLaunchSpecResourceLimitSpecification resourceLimitToReturn = null;

        if(resourceLimit != null) {
            resourceLimitToReturn = new ApiLaunchSpecResourceLimitSpecification();

            if (resourceLimit.isMaxInstanceCountSet()) {
                resourceLimitToReturn.setMaxInstanceCount(resourceLimit.getMaxInstanceCount());
            }
            if (resourceLimit.isMinInstanceCountSet()) {
                resourceLimitToReturn.setMinInstanceCount(resourceLimit.getMinInstanceCount());
            }
        }
        return resourceLimitToReturn;
    }

    private static ApiLaunchSpecResourceShieldedInstanceSpecification toDal(LaunchSpecShieldedInstanceConfigSpecification shieldedInstance){
        ApiLaunchSpecResourceShieldedInstanceSpecification shieldedInstanceConfig =  null;

        if(shieldedInstance != null) {
            shieldedInstanceConfig =  new ApiLaunchSpecResourceShieldedInstanceSpecification();
            if (shieldedInstance.isEnableIntegrityMonitoringSet()) {
                shieldedInstanceConfig.setEnableIntegrityMonitoring(shieldedInstance.getEnableIntegrityMonitoring());
            }

            if (shieldedInstance.isEnableSecureBootSet()) {
                shieldedInstanceConfig.setEnableSecureBoot(shieldedInstance.getEnableSecureBoot());
            }
        }
        return shieldedInstanceConfig;
    }

    private static ApiLaunchSpecStrategySpecification toDal(LaunchSpecStrategySpecification strategy){
        ApiLaunchSpecStrategySpecification strategyList = null;

        if(strategy !=null) {
            strategyList = new ApiLaunchSpecStrategySpecification();

            if (strategy.isPreemptiblePercentageSet()) {
                strategyList.setPreemptiblePercentage(strategy.getPreemptiblePercentage());
            }
        }
        return strategyList;
    }

    private static ApiLaunchSpecStorageSpecification toDal(LaunchSpecStorageSpecification storage){
        ApiLaunchSpecStorageSpecification storageSpec = null;

        if(storage != null) {
            storageSpec = new ApiLaunchSpecStorageSpecification();

            if (storage.isLocalSsdCountSet()) {
                storageSpec.setLocalSsdCount(storage.getLocalSsdCount());
            }
        }
        return storageSpec;
    }

    private static ApiLaunchSpecMetadataSpecification toDal(LaunchSpecMetadataSpecification metadata){

        ApiLaunchSpecMetadataSpecification apiLaunchSpecMetadataSpecification = null;

        if(metadata != null) {
            apiLaunchSpecMetadataSpecification = new ApiLaunchSpecMetadataSpecification();

            if (metadata.isKeySet()) {
                apiLaunchSpecMetadataSpecification.setKey(metadata.getKey());
            }

            if (metadata.isValueSet()) {
                apiLaunchSpecMetadataSpecification.setValue(metadata.getValue());
            }
        }
        return apiLaunchSpecMetadataSpecification;
    }

    private static ApiClusterStrategyConfiguration toDal(ClusterStrategyConfiguration strategy){

        ApiClusterStrategyConfiguration retval = null;

        if (strategy != null) {
            retval = new ApiClusterStrategyConfiguration();

            if(strategy.isDrainingTimeoutSet()){
                retval.setDrainingTimeout(strategy.getDrainingTimeout());
            }
        }

        return retval;
    }

    private static ApiClusterSecurityConfiguration toDal(ClusterSecurityConfiguration security) {
        ApiClusterSecurityConfiguration retval = null;

        if (security != null) {
            retval = new ApiClusterSecurityConfiguration();

            if (security.isContainerImageSet()) {
                retval.setContainerImage(toDal(security.getContainerImage()));
            }

        }
        return retval;
    }

    private static ApiClusterContainerImageSpecification toDal(ClusterContainerImageSpecification containerImage) {
        ApiClusterContainerImageSpecification retval = null;

        if (containerImage != null) {
            retval = new ApiClusterContainerImageSpecification();

            if (containerImage.isApprovedImagesSet()) {
                retval.setApprovedImages(containerImage.getApprovedImages());
            }

        }
        return retval;
    }

    private static ApiClusterSchedulingConfiguration toDal(ClusterSchedulingConfiguration scheduling) {
        ApiClusterSchedulingConfiguration retVal = null;

        if (scheduling != null) {
            retVal = new ApiClusterSchedulingConfiguration();

            if (scheduling.isTasksSet()) {
                if (scheduling.getTasks() != null) {
                    List<ApiClusterTasksConfiguration> taskList =
                            scheduling.getTasks().stream().map(OceanGkeConverter::toDal).collect(Collectors.toList());
                    retVal.setTasks(taskList);
                }
            }
            if(scheduling.isShutdownHoursSet()){
                retVal.setShutdownHours(toDal(scheduling.getShutdownHours()));
            }
        }

        return retVal;
    }

    private static ApiClusterShutdownHoursSpecification toDal(ClusterShutdownHoursSpecification shutdownHours) {
        ApiClusterShutdownHoursSpecification retVal = null;

        if (shutdownHours != null) {
            retVal = new ApiClusterShutdownHoursSpecification();

            if(shutdownHours.isIsEnabledSet()){
                retVal.setIsEnabled(shutdownHours.getIsEnabled());
            }
            if(shutdownHours.isTimeWindowsSet()){
                retVal.setTimeWindows(shutdownHours.getTimeWindows());
            }
        }

        return retVal;
    }

    private static ApiClusterTasksConfiguration toDal(ClusterTasksConfiguration tasksConfiguration) {
        ApiClusterTasksConfiguration retVal = null;

        if (tasksConfiguration != null) {
            retVal = new ApiClusterTasksConfiguration();

            if (tasksConfiguration.isIsEnabledSet()) {
                retVal.setIsEnabled(tasksConfiguration.getIsEnabled());
            }
            if (tasksConfiguration.isCronExpressionSet()) {
                retVal.setCronExpression(tasksConfiguration.getCronExpression());
            }
            if (tasksConfiguration.isTaskTypeSet()) {
                retVal.setTaskType(tasksConfiguration.getTaskType());
            }
            if (tasksConfiguration.isBatchSizePercentageSet()) {
                retVal.setBatchSizePercentage(tasksConfiguration.getBatchSizePercentage());
            }

        }

        return retVal;
    }

    //region DAL -> BL

    public static OceanGkeCluster toBl(ApiOceanGkeCluster src) {
        OceanGkeCluster cluster = null;

        if (src != null) {
            OceanGkeCluster.Builder clusterBuilder = OceanGkeCluster.Builder.get();

            if (src.isIdSet()) {
                clusterBuilder.setId(src.getId());
            }
            if (src.isNameSet()) {
                clusterBuilder.setName(src.getName());
            }
            if (src.isGkeSet()) {
                clusterBuilder.setGke(toBl(src.getGke()));
            }
            if (src.isControllerClusterIdSet()) {
                clusterBuilder.setControllerClusterId(src.getControllerClusterId());
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
            if (src.isSecuritySet()) {
                clusterBuilder.setSecurity(toBl(src.getSecurity()));
            }
            if (src.isComputeSet()) {
                clusterBuilder.setCompute(toBl(src.getCompute()));
            }
            if (src.isSchedulingSet()) {
                clusterBuilder.setScheduling(toBl(src.getScheduling()));
            }
            cluster = clusterBuilder.build();

        }
        return cluster;
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

    private static ClusterAutoScalerConfiguration toBl(ApiClusterAutoScalerConfiguration autoScaler) {
        ClusterAutoScalerConfiguration retVal = null;

        if (autoScaler != null) {
            ClusterAutoScalerConfiguration.Builder retValBuilder = ClusterAutoScalerConfiguration.Builder.get();

            if (autoScaler.isAutoHeadroomPercentageSet()) {
                retValBuilder.setAutoHeadroomPercentage(autoScaler.getAutoHeadroomPercentage());
            }
            if (autoScaler.isCooldownSet()) {
                retValBuilder.setCooldown(autoScaler.getCooldown());
            }
            if (autoScaler.isDownSet()) {
                retValBuilder.setDown(toBl(autoScaler.getDown()));
            }
            if (autoScaler.isEnableAutomaticAndManualHeadroomSet()) {
                retValBuilder.setEnableAutomaticAndManualHeadroom(autoScaler.getenableAutomaticAndManualHeadroom());
            }
            if (autoScaler.isHeadroomSet()) {
                retValBuilder.setHeadroom(toBl(autoScaler.getHeadroom()));
            }
            if (autoScaler.isIsAutoConfigSet()) {
                retValBuilder.setIsAutoConfig(autoScaler.getIsAutoConfig());
            }
            if (autoScaler.isIsEnabledSet()) {
                retValBuilder.setIsEnabled(autoScaler.getIsEnabled());
            }
            if (autoScaler.isResourceLimitsSet()) {
                retValBuilder.setResourceLimits(toBl(autoScaler.getResourceLimits()));
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ClusterDownSpecification toBl(ApiClusterDownSpecification down) {
        ClusterDownSpecification retVal =  null;

        if(down != null){
            ClusterDownSpecification.Builder retValBuilder = ClusterDownSpecification.Builder.get();

            if(down.isMaxScaleDownPercentageSet()){
                retValBuilder.setMaxScaleDownPercentage(down.getMaxScaleDownPercentage());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ClusterResourceLimitsSpecification toBl(ApiClusterResourceLimitsSpecification apiResourceLimitsSpecification) {
        ClusterResourceLimitsSpecification retVal = null;

        if (apiResourceLimitsSpecification != null) {
            ClusterResourceLimitsSpecification.Builder apiResourceLimitsBuilder = ClusterResourceLimitsSpecification.Builder.get();

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

    private static ClusterGkeConfiguration toBl(ApiClusterGkeConfiguration gke) {
        ClusterGkeConfiguration retVal =  null;

        if(gke != null){
            ClusterGkeConfiguration.Builder retValBuilder = ClusterGkeConfiguration.Builder.get();

            if(gke.isClusterNameSet()){
                retValBuilder.setClusterName(gke.getClusterName());
            }
            if(gke.isMasterLocationSet()){
                retValBuilder.setMasterLocation(gke.getMasterLocation());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ClusterComputeConfiguration toBl(ApiClusterComputeConfiguration apicompute) {
        ClusterComputeConfiguration retVal = null;

        if (apicompute != null) {
            ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();

            if (apicompute.isAvailabilityZonesSet()) {
                computeBuilder.setAvailabilityZones(apicompute.getAvailabilityZones());
            }
            if (apicompute.isBackendServicesSet()) {
                List<ClusterBackendServicesConfiguration> backendServices =
                        (apicompute.getBackendServices()).stream().map(OceanGkeConverter::toBl)
                                  .collect(Collectors.toList());
                computeBuilder.setBackendServices(backendServices);
            }
            if (apicompute.isInstanceTypesSet()) {
                computeBuilder.setInstanceTypes(toBl(apicompute.getInstanceTypes()));
            }
            if (apicompute.isLaunchSpecificationSet()) {
                computeBuilder.setLaunchSpecification(toBl(apicompute.getLaunchSpecification()));
            }
            if (apicompute.isNetworkInterfacesSet()) {

                List<ClusterNetworkInterfacesConfiguration> networkInterface =
                        apicompute.getNetworkInterfaces().stream().map(OceanGkeConverter::toBl)
                                  .collect(Collectors.toList());

                computeBuilder.setNetworkInterfaces(networkInterface);
            }

            if (apicompute.isSubnetNameSet()) {
                computeBuilder.setSubnetName(apicompute.getSubnetName());
            }
            retVal = computeBuilder.build();
        }

        return retVal;
    }

    private static ClusterBackendServicesConfiguration toBl(ApiClusterBackendServicesConfiguration apiBackendServices) {
        ClusterBackendServicesConfiguration retVal = null;

        if (apiBackendServices != null) {
            ClusterBackendServicesConfiguration.Builder computeBuilder = ClusterBackendServicesConfiguration.Builder.get();

            if (apiBackendServices.isBackendServiceNameSet()) {
                computeBuilder.setBackendServiceName(apiBackendServices.getBackendServiceName());
            }
            if (apiBackendServices.isLocationTypeSet()) {
                computeBuilder.setLocationType(apiBackendServices.getLocationType());
            }

            retVal = computeBuilder.build();
        }

        return retVal;
    }

    private static ClusterInstanceTypesConfiguration toBl(ApiClusterInstanceTypesConfiguration apiIinstanceTypes) {
        ClusterInstanceTypesConfiguration retVal = null;

        if (apiIinstanceTypes != null) {
            ClusterInstanceTypesConfiguration.Builder computeBuilder = ClusterInstanceTypesConfiguration.Builder.get();

            if (apiIinstanceTypes.isWhitelistSet()) {
                computeBuilder.setWhitelist(apiIinstanceTypes.getWhitelist());
            }

            retVal = computeBuilder.build();
        }

        return retVal;
    }

    private static ClusterNetworkInterfacesConfiguration toBl(ApiClusterNetworkInterfacesConfiguration apiNetworkInterface) {
        ClusterNetworkInterfacesConfiguration retVal = null;

        if (apiNetworkInterface != null) {
            ClusterNetworkInterfacesConfiguration.Builder computeBuilder = ClusterNetworkInterfacesConfiguration.Builder.get();

            if (apiNetworkInterface.isAccessConfigsSet()) {
                List<ClusterAccessConfigsSpecification> accessConfig =
                        apiNetworkInterface.getAccessConfigs().stream().map(OceanGkeConverter::toBl)
                                           .collect(Collectors.toList());
                computeBuilder.setAccessConfigs(accessConfig);
            }
            if (apiNetworkInterface.isAliasIpRangesSet()) {

                List<ClusterAliasIpRangesSpecification> aliasIpRange =
                        apiNetworkInterface.getAliasIpRanges().stream().map(OceanGkeConverter::toBl)
                                           .collect(Collectors.toList());
                computeBuilder.setAliasIpRanges(aliasIpRange);
            }
            if (apiNetworkInterface.isNetworkSet()) {
                computeBuilder.setNetwork(apiNetworkInterface.getNetwork());
            }
            if (apiNetworkInterface.isProjectIdSet()) {
                computeBuilder.setProjectId(apiNetworkInterface.getProjectId());
            }

            retVal = computeBuilder.build();
        }

        return retVal;
    }

    private static ClusterAccessConfigsSpecification toBl(ApiClusterAccessConfigsSpecification apiAccessConfig) {
        ClusterAccessConfigsSpecification retVal = null;

        if (apiAccessConfig != null) {
            ClusterAccessConfigsSpecification.Builder computeBuilder = ClusterAccessConfigsSpecification.Builder.get();

            if (apiAccessConfig.isNameSet()) {
                computeBuilder.setName(apiAccessConfig.getName());
            }
            if (apiAccessConfig.isTypeSet()) {
                computeBuilder.setType(apiAccessConfig.getType());
            }

            retVal = computeBuilder.build();
        }

        return retVal;
    }

    private static ClusterAliasIpRangesSpecification toBl(ApiClusterAliasIpRangesSpecification apiAliasIpRanges) {
        ClusterAliasIpRangesSpecification retVal = null;

        if (apiAliasIpRanges != null) {
            ClusterAliasIpRangesSpecification.Builder computeBuilder = ClusterAliasIpRangesSpecification.Builder.get();

            if (apiAliasIpRanges.isIpCidrRangeSet()) {
                computeBuilder.setIpCidrRange(apiAliasIpRanges.getIpCidrRange());
            }
            if (apiAliasIpRanges.isSubnetworkRangeNameSet()) {
                computeBuilder.setSubnetworkRangeName(apiAliasIpRanges.getSubnetworkRangeName());
            }

            retVal = computeBuilder.build();
        }

        return retVal;
    }

    private static LaunchSpecTaintsSpecification toBl(ApiLaunchSpecTaintsSpecification apiTaint) {

        LaunchSpecTaintsSpecification launchSpecTaintsSpecification = null;

        if(apiTaint != null) {
            LaunchSpecTaintsSpecification.Builder launchSpecTaintsSpecificationBuilder = LaunchSpecTaintsSpecification.Builder.get();

            if (apiTaint.isEffectSet()) {
                launchSpecTaintsSpecificationBuilder.setEffect(apiTaint.getEffect());
            }

            if (apiTaint.isKeySet()) {
                launchSpecTaintsSpecificationBuilder.setKey(apiTaint.getKey());
            }

            if (apiTaint.isValueSet()) {
                launchSpecTaintsSpecificationBuilder.setValue(apiTaint.getValue());
            }
            launchSpecTaintsSpecification = launchSpecTaintsSpecificationBuilder.build();
        }
        return launchSpecTaintsSpecification;
    }

    private static LaunchSpecLabelsSpecification toBl(ApiLaunchSpecLabelsSpecification apiLabel){

        LaunchSpecLabelsSpecification launchSpecLabelsSpecification = null;

        if (apiLabel != null) {
            LaunchSpecLabelsSpecification.Builder launchSpecLabelBuilder = LaunchSpecLabelsSpecification.Builder.get();

            if (apiLabel.isKeySet()) {
                launchSpecLabelBuilder.setKey(apiLabel.getKey());
            }
            if (apiLabel.isValueSet()) {
                launchSpecLabelBuilder.setValue((apiLabel.getValue()));
            }
            launchSpecLabelsSpecification = launchSpecLabelBuilder.build();
        }
        return launchSpecLabelsSpecification;
    }

    public static LaunchSpecSpecification toBl(ApiLaunchSpecSpecification apiLaunchSpecSpecification) {
        LaunchSpecSpecification launchSpec = null;

        if (apiLaunchSpecSpecification != null) {
            LaunchSpecSpecification.Builder oceanGKECreateLaunchSpecBuilder = LaunchSpecSpecification.Builder.get();

            if (apiLaunchSpecSpecification.isIdSet()) {
                oceanGKECreateLaunchSpecBuilder.setId(apiLaunchSpecSpecification.getId());
            }

            if (apiLaunchSpecSpecification.isNameSet()) {
                oceanGKECreateLaunchSpecBuilder.setName(apiLaunchSpecSpecification.getName());
            }

            if (apiLaunchSpecSpecification.isOceanIdSet()) {
                oceanGKECreateLaunchSpecBuilder.setOceanId(apiLaunchSpecSpecification.getOceanId());
            }

            if (apiLaunchSpecSpecification.isSourceImageSet()) {
                oceanGKECreateLaunchSpecBuilder.setSourceImage(apiLaunchSpecSpecification.getSourceImage());
            }

            if (apiLaunchSpecSpecification.isServiceAccountSet()) {
                oceanGKECreateLaunchSpecBuilder.setServiceAccount(apiLaunchSpecSpecification.getServiceAccount());
            }

            if (apiLaunchSpecSpecification.isRootVolumeSizeInGbSet()) {
                oceanGKECreateLaunchSpecBuilder.setRootVolumeSizeInGb(apiLaunchSpecSpecification.getRootVolumeSizeInGb());
            }

            if (apiLaunchSpecSpecification.isRootVolumeTypeSet()) {
                oceanGKECreateLaunchSpecBuilder.setRootVolumeType(OceanGkeLaunchSpecRootVolumeTypeEnum.fromName(apiLaunchSpecSpecification.getRootVolumeType()));
            }

            if (apiLaunchSpecSpecification.isRestrictScaleDownSet()) {
                oceanGKECreateLaunchSpecBuilder.setRestrictScaleDown(apiLaunchSpecSpecification.getRestrictScaleDown());
            }

            if (apiLaunchSpecSpecification.isMetadataSet()) {

                List<LaunchSpecMetadataSpecification> metadata =
                        apiLaunchSpecSpecification.getMetadata().stream().map(OceanGkeConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setMetadata(metadata);
            }

            if (apiLaunchSpecSpecification.isInstanceTypesSet()) {
                oceanGKECreateLaunchSpecBuilder.setInstanceTypes(apiLaunchSpecSpecification.getInstanceTypes());
            }

            if (apiLaunchSpecSpecification.isTaintsSet()) {

                List<LaunchSpecTaintsSpecification> taint =
                        apiLaunchSpecSpecification.getTaints().stream().map(OceanGkeConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setTaints(taint);
            }

            if (apiLaunchSpecSpecification.isLabelsSet()) {

                List<LaunchSpecLabelsSpecification> label =
                        apiLaunchSpecSpecification.getLabels().stream().map(OceanGkeConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setLabels(label);
            }

            if (apiLaunchSpecSpecification.isAutoScaleSet()) {

                oceanGKECreateLaunchSpecBuilder.setAutoScale(toBl(apiLaunchSpecSpecification.getAutoScale()));
            }

            if (apiLaunchSpecSpecification.isResourceLimitsSet()) {
                oceanGKECreateLaunchSpecBuilder.setResourceLimits(toBl(apiLaunchSpecSpecification.getResourceLimits()));
            }

            if (apiLaunchSpecSpecification.isShieldedInstanceConfigSet()) {
                oceanGKECreateLaunchSpecBuilder.setShieldedInstanceConfig(toBl(
                        apiLaunchSpecSpecification.getShieldedInstanceConfig()));
            }
            if (apiLaunchSpecSpecification.isStrategySet()) {
                oceanGKECreateLaunchSpecBuilder.setStrategy(toBl(apiLaunchSpecSpecification.getStrategy()));
            }
            if (apiLaunchSpecSpecification.isStorageSet()) {
                oceanGKECreateLaunchSpecBuilder.setStorage(toBl(apiLaunchSpecSpecification.getStorage()));
            }
            if (apiLaunchSpecSpecification.isIpForwardingSet()) {
                oceanGKECreateLaunchSpecBuilder.setIpForwarding(apiLaunchSpecSpecification.getIpForwarding());
            }
            if (apiLaunchSpecSpecification.isMinCpuPlatformSet()) {
                oceanGKECreateLaunchSpecBuilder.setMinCpuPlatform(apiLaunchSpecSpecification.getMinCpuPlatform());
            }
            if (apiLaunchSpecSpecification.isTagsSet()) {
                oceanGKECreateLaunchSpecBuilder.setTags(apiLaunchSpecSpecification.getTags());
            }
            launchSpec = oceanGKECreateLaunchSpecBuilder.build();
        }

        return launchSpec;
    }

    private static LaunchSpecAutoScaleSpecification toBl(ApiLaunchSpecAutoScaleSpecification apiAutoScale){

        LaunchSpecAutoScaleSpecification autoScale = null;

        if(apiAutoScale != null) {
            LaunchSpecAutoScaleSpecification.Builder autoScaleBuilder = LaunchSpecAutoScaleSpecification.Builder.get();
            if (apiAutoScale.isHeadroomsSet()) {

                List<LaunchSpecHeadroomsSpecification> headRooms =
                        apiAutoScale.getHeadrooms().stream().map(OceanGkeConverter::toBl).collect(Collectors.toList());

                autoScaleBuilder.setHeadrooms(headRooms);
            }
            autoScale = autoScaleBuilder.build();
        }
        return autoScale;
    }

    private static LaunchSpecHeadroomsSpecification toBl(ApiLaunchSpecHeadRoomsSpecification apiHeadRooms) {

        LaunchSpecHeadroomsSpecification headRoomsListToReturn = null;

        if(apiHeadRooms != null){

            LaunchSpecHeadroomsSpecification.Builder headRoomsBuilder = LaunchSpecHeadroomsSpecification.Builder.get();

            if (apiHeadRooms.isGpuPerUnitSet()) {
                headRoomsBuilder.setGpuPerUnit(apiHeadRooms.getGpuPerUnit());
            }

            if(apiHeadRooms.isCpuPerUnitSet()){
                headRoomsBuilder.setCpuPerUnit(apiHeadRooms.getCpuPerUnit());
            }

            if (apiHeadRooms.isMemoryPerUnitSet()) {
                headRoomsBuilder.setMemoryPerUnit(apiHeadRooms.getMemoryPerUnit());
            }

            if (apiHeadRooms.isNumOfUnitsSet()) {
                headRoomsBuilder.setNumOfUnits(apiHeadRooms.getNumOfUnits());
            }
            headRoomsListToReturn = headRoomsBuilder.build();
        }
        return headRoomsListToReturn;
    }

    private static LaunchSpecResourceLimitsSpecification toBl( ApiLaunchSpecResourceLimitSpecification apiResourceLimit) {
        LaunchSpecResourceLimitsSpecification restourceLimitToReturn = null;

        if(apiResourceLimit != null){
            LaunchSpecResourceLimitsSpecification.Builder resourceLimitBuilder = LaunchSpecResourceLimitsSpecification.Builder.get();

        if (apiResourceLimit.isMaxInstanceCountSet()) {
            resourceLimitBuilder.setMaxInstanceCount(apiResourceLimit.getMaxInstanceCount());
        }
        if (apiResourceLimit.isMinInstanceCountSet()) {
            resourceLimitBuilder.setMinInstanceCount(apiResourceLimit.getMinInstanceCount());
        }
            restourceLimitToReturn = resourceLimitBuilder.build();
        }
        return restourceLimitToReturn;
    }

    private static LaunchSpecShieldedInstanceConfigSpecification toBl(ApiLaunchSpecResourceShieldedInstanceSpecification apiShieldedInstance){
        LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig = null;

        if(apiShieldedInstance != null) {
            LaunchSpecShieldedInstanceConfigSpecification.Builder shieldedInstanceConfigBuilder = LaunchSpecShieldedInstanceConfigSpecification.Builder.get();

            if (apiShieldedInstance.isEnableIntegrityMonitoringSet()) {
                shieldedInstanceConfigBuilder.setEnableIntegrityMonitoring(apiShieldedInstance.getEnableIntegrityMonitoring());
            }

            if (apiShieldedInstance.isEnableSecureBootSet()) {
                shieldedInstanceConfigBuilder.setEnableSecureBoot(apiShieldedInstance.getEnableSecureBoot());
            }
            shieldedInstanceConfig = shieldedInstanceConfigBuilder.build();
        }
        return shieldedInstanceConfig;
    }

    private static LaunchSpecStrategySpecification toBl(ApiLaunchSpecStrategySpecification apiStrategy){
        LaunchSpecStrategySpecification strategyList = null;

        if(apiStrategy != null) {
            LaunchSpecStrategySpecification.Builder strategyBuilder = LaunchSpecStrategySpecification.Builder.get();

            if (apiStrategy.isPreemptiblePercentageSet()) {
                strategyBuilder.setPreemptiblePercentage(apiStrategy.getPreemptiblePercentage());
            }
            strategyList = strategyBuilder.build();
        }
        return strategyList;
    }

    private static LaunchSpecStorageSpecification toBl(ApiLaunchSpecStorageSpecification apiStorage){
        LaunchSpecStorageSpecification storageSpec = null;

        if(apiStorage != null) {
            LaunchSpecStorageSpecification.Builder storageBuilder = LaunchSpecStorageSpecification.Builder.get();

            if (apiStorage.isLocalSsdCountSet()) {
                storageBuilder.setLocalSsdCount(apiStorage.getLocalSsdCount());
            }
            storageSpec = storageBuilder.build();
        }
        return storageSpec;
    }

    private static LaunchSpecMetadataSpecification toBl(ApiLaunchSpecMetadataSpecification apiMetadata) {

        LaunchSpecMetadataSpecification launchSpecMetadataSpecification = null;

        if(apiMetadata != null){
            LaunchSpecMetadataSpecification.Builder metadataBuilder = LaunchSpecMetadataSpecification.Builder.get();
            if (apiMetadata.isKeySet()) {
                metadataBuilder.setKey(apiMetadata.getKey());
            }

            if (apiMetadata.isValueSet()) {
                metadataBuilder.setValue(apiMetadata.getValue());
            }
            launchSpecMetadataSpecification  = metadataBuilder.build();
        }
        return launchSpecMetadataSpecification;
    }

    private static ClusterSecurityConfiguration toBl(ApiClusterSecurityConfiguration apiStrategy) {
        ClusterSecurityConfiguration retVal = null;

        if (apiStrategy != null) {
            ClusterSecurityConfiguration.Builder strategyBuilder = ClusterSecurityConfiguration.Builder.get();

            if (apiStrategy.isContainerImageSet()) {
                strategyBuilder.setContainerImage(toBl(apiStrategy.getContainerImage()));
            }
            retVal = strategyBuilder.build();
        }

        return retVal;
    }

    private static ClusterContainerImageSpecification toBl(ApiClusterContainerImageSpecification apiContainerImage) {
        ClusterContainerImageSpecification retVal = null;

        if (apiContainerImage != null) {
            ClusterContainerImageSpecification.Builder strategyBuilder = ClusterContainerImageSpecification.Builder.get();

            if (apiContainerImage.isApprovedImagesSet()) {
                strategyBuilder.setApprovedImages(apiContainerImage.getApprovedImages());
            }
            retVal = strategyBuilder.build();
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
                    List<ClusterTasksConfiguration> tasksConfigurationList =
                            apiScheduling.getTasks().stream().map(OceanGkeConverter::toBl).collect(Collectors.toList());
                    schedulingConfigurationBuilder.setTasks(tasksConfigurationList);
                }
            }
            if(apiScheduling.isShutdownHoursSet()){
                schedulingConfigurationBuilder.setShutdownHours(toBl(apiScheduling.getShutdownHours()));
            }
            retVal = schedulingConfigurationBuilder.build();
        }
        return retVal;
    }

    private static ClusterTasksConfiguration toBl(ApiClusterTasksConfiguration apiScheduledTask) {
        ClusterTasksConfiguration bLTasks = null;

        if (apiScheduledTask != null) {
            ClusterTasksConfiguration.Builder tasksBuilder = ClusterTasksConfiguration.Builder.get();
            if (apiScheduledTask.isIsEnabledSet()) {
                tasksBuilder.setIsEnabled(apiScheduledTask.getIsEnabled());
            }
            if (apiScheduledTask.isCronExpressionSet()) {
                tasksBuilder.setCronExpression(apiScheduledTask.getCronExpression());
            }
            if (apiScheduledTask.isTaskTypeSet()) {
                tasksBuilder.setTaskType(apiScheduledTask.getTaskType());
            }
            if (apiScheduledTask.isBatchSizePercentageSet()) {
                tasksBuilder.setBatchSizePercentage(apiScheduledTask.getBatchSizePercentage());
            }

            bLTasks = tasksBuilder.build();
        }

        return bLTasks;
    }

    private static ClusterShutdownHoursSpecification toBl(ApiClusterShutdownHoursSpecification apiClusterShutdownHoursSpecification) {
        ClusterShutdownHoursSpecification retVal = null;

        if (apiClusterShutdownHoursSpecification != null) {
            ClusterShutdownHoursSpecification.Builder apiShutdownHoursBuilder =
                    ClusterShutdownHoursSpecification.Builder.get();

            if (apiClusterShutdownHoursSpecification.isIsEnabledSet()) {
                apiShutdownHoursBuilder.setIsEnabled(apiClusterShutdownHoursSpecification.getIsEnabled());
            }
            if (apiClusterShutdownHoursSpecification.isTimeWindowsSet()) {
                apiShutdownHoursBuilder.setTimeWindows(apiClusterShutdownHoursSpecification.getTimeWindows());
            }

            retVal = apiShutdownHoursBuilder.build();
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

            retVal = strategyBuilder.build();
        }

        return retVal;
    }


}