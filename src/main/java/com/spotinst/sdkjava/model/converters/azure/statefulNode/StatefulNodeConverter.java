package com.spotinst.sdkjava.model.converters.azure.statefulNode;

import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.api.azure.statefulNode.*;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.*;

import java.util.List;
import java.util.stream.Collectors;

public class StatefulNodeConverter {

    //region BL -> DAL

    public static ApiStatefulNode toDal(StatefulNode statefulNode) {
        ApiStatefulNode apiStatefulNode = null;

        if (statefulNode != null) {
            apiStatefulNode = new ApiStatefulNode();

            if (statefulNode.isIdSet()) {
                apiStatefulNode.setId(statefulNode.getId());
            }
            if (statefulNode.isNameSet()) {
                apiStatefulNode.setName(statefulNode.getName());
            }
            if (statefulNode.isRegionSet()) {
                apiStatefulNode.setRegion(statefulNode.getRegion());
            }
            if (statefulNode.isDescriptionSet()) {
                apiStatefulNode.setDescription(statefulNode.getDescription());
            }
            if (statefulNode.isResourceGroupNameSet()) {
                apiStatefulNode.setResourceGroupName(statefulNode.getResourceGroupName());
            }
            if (statefulNode.isStrategySet()) {
                apiStatefulNode.setStrategy(toDal(statefulNode.getStrategy()));
            }
            if (statefulNode.isComputeSet()) {
                apiStatefulNode.setCompute(toDal(statefulNode.getCompute()));
            }
            if (statefulNode.isSchedulingSet()) {
                apiStatefulNode.setScheduling(toDal(statefulNode.getScheduling()));
            }
            if (statefulNode.isPersistenceSet()) {
                apiStatefulNode.setPersistence(toDal(statefulNode.getPersistence()));
            }
            if (statefulNode.isHealthSet()) {
                apiStatefulNode.setHealth(toDal(statefulNode.getHealth()));
            }
        }

        return apiStatefulNode;
    }

    private static ApiStatefulNodeStrategyConfiguration toDal(StatefulNodeStrategyConfiguration statefulNodeStrategy) {
        ApiStatefulNodeStrategyConfiguration apiStatefulNodeStrategy = null;

        if (statefulNodeStrategy != null) {
            apiStatefulNodeStrategy = new ApiStatefulNodeStrategyConfiguration();

            if (statefulNodeStrategy.isFallbackToOdSet()) {
                apiStatefulNodeStrategy.setFallbackToOd(statefulNodeStrategy.getFallbackToOd());
            }
            if (statefulNodeStrategy.isDrainingTimeoutSet()) {
                apiStatefulNodeStrategy.setDrainingTimeout(statefulNodeStrategy.getDrainingTimeout());
            }
            if (statefulNodeStrategy.isPreferredLifecycleSet()) {
                apiStatefulNodeStrategy.setPreferredLifecycle(statefulNodeStrategy.getPreferredLifecycle().getName());
            }
            if (statefulNodeStrategy.isRevertToSpotSet()) {
                apiStatefulNodeStrategy.setRevertToSpot(toDal(statefulNodeStrategy.getRevertToSpot()));
            }
            if (statefulNodeStrategy.isSignalsSet()) {
                List<ApiStatefulNodeSignalConfiguration> signalsList = statefulNodeStrategy.getSignals().stream().map(StatefulNodeConverter::toDal)
                                                                       .collect(Collectors.toList());
                apiStatefulNodeStrategy.setSignals(signalsList);
            }
            if (statefulNodeStrategy.isOptimizationWindowsSet()) {
                apiStatefulNodeStrategy.setOptimizationWindows(statefulNodeStrategy.getOptimizationWindows());
            }

        }

        return apiStatefulNodeStrategy;
    }

    private static ApiStatefulNodeRevertToSpotConfiguration toDal(StatefulNodeRevertToSpotConfiguration statefulNodeRevertToSpot) {
        ApiStatefulNodeRevertToSpotConfiguration apiStatefulNodeRevertToSpot = null;

        if (statefulNodeRevertToSpot != null) {
            apiStatefulNodeRevertToSpot = new ApiStatefulNodeRevertToSpotConfiguration();

            if (statefulNodeRevertToSpot.isPerformAtSet()) {
                apiStatefulNodeRevertToSpot.setPerformAt(statefulNodeRevertToSpot.getPerformAt().getName());
            }
        }

        return apiStatefulNodeRevertToSpot;
    }

    private static ApiStatefulNodeSignalConfiguration toDal(StatefulNodeSignalConfiguration statefulNodeSignal) {
        ApiStatefulNodeSignalConfiguration apiStatefulNodeSignal = null;

        if (statefulNodeSignal != null) {
            apiStatefulNodeSignal = new ApiStatefulNodeSignalConfiguration();

            if (statefulNodeSignal.isTypeSet()) {
                apiStatefulNodeSignal.setType(statefulNodeSignal.getType().getName());
            }
            if (statefulNodeSignal.isTimeoutSet()) {
                apiStatefulNodeSignal.setTimeout(statefulNodeSignal.getTimeout());
            }
        }

        return apiStatefulNodeSignal;
    }

    private static ApiStatefulNodeComputeConfiguration toDal(StatefulNodeComputeConfiguration statefulNodeCompute) {
        ApiStatefulNodeComputeConfiguration apiStatefulNodeCompute = null;

        if (statefulNodeCompute != null) {
            apiStatefulNodeCompute = new ApiStatefulNodeComputeConfiguration();

            if (statefulNodeCompute.isOsSet()) {
                apiStatefulNodeCompute.setOs(statefulNodeCompute.getOs().getName());
            }
            if (statefulNodeCompute.isVmSizesSet()) {
                apiStatefulNodeCompute.setVmSizes(toDal(statefulNodeCompute.getVmSizes()));
            }
            if (statefulNodeCompute.isZonesSet()) {
                apiStatefulNodeCompute.setZones(statefulNodeCompute.getZones());
            }
            if (statefulNodeCompute.isPreferredZoneSet()) {
                apiStatefulNodeCompute.setPreferredZone(statefulNodeCompute.getPreferredZone());
            }
            if (statefulNodeCompute.isLaunchSpecificationSet()) {
                apiStatefulNodeCompute.setLaunchSpecification(toDal(statefulNodeCompute.getLaunchSpecification()));
            }
            if (statefulNodeCompute.isLoadBalancersConfigSet()) {
                apiStatefulNodeCompute.setLoadBalancersConfig(toDal(statefulNodeCompute.getLoadBalancersConfig()));
            }
        }
        return apiStatefulNodeCompute;
    }

    private static ApiStatefulNodeVmSizesConfiguration toDal(StatefulNodeVmSizesConfiguration statefulNodeVmSizes) {
        ApiStatefulNodeVmSizesConfiguration apiStatefulNodeVmSizes = null;

        if (statefulNodeVmSizes != null) {
            apiStatefulNodeVmSizes = new ApiStatefulNodeVmSizesConfiguration();

            if (statefulNodeVmSizes.isOdSizesSet()) {
                apiStatefulNodeVmSizes.setOdSizes(statefulNodeVmSizes.getOdSizes());
            }
            if (statefulNodeVmSizes.isSpotSizesSet()) {
                apiStatefulNodeVmSizes.setSpotSizes(statefulNodeVmSizes.getSpotSizes());
            }
            if (statefulNodeVmSizes.isPreferredSpotSizesSet()) {
                apiStatefulNodeVmSizes.setPreferredSpotSizes(statefulNodeVmSizes.getPreferredSpotSizes());
            }

        }
        return apiStatefulNodeVmSizes;
    }

    private static ApiStatefulNodeLaunchSpecification toDal(StatefulNodeLaunchSpecification statefulNodeLaunchSpecification) {
        ApiStatefulNodeLaunchSpecification apiStatefulNodeLaunchSpecification = null;

        if (statefulNodeLaunchSpecification != null) {
            apiStatefulNodeLaunchSpecification = new ApiStatefulNodeLaunchSpecification();

            if (statefulNodeLaunchSpecification.isImageSet()) {
                apiStatefulNodeLaunchSpecification.setImage(toDal(statefulNodeLaunchSpecification.getImage()));
            }
            if (statefulNodeLaunchSpecification.isNetworkSet()) {
                apiStatefulNodeLaunchSpecification.setNetwork(toDal(statefulNodeLaunchSpecification.getNetwork()));
            }
            if (statefulNodeLaunchSpecification.isDataDisksSet()) {
                List<ApiLaunchSpecDataDisksSpecification> dataDisksList =
                statefulNodeLaunchSpecification.getDataDisks().stream().map(StatefulNodeConverter::toDal)
                         .collect(Collectors.toList());
                apiStatefulNodeLaunchSpecification.setDataDisks(dataDisksList);
            }
            if (statefulNodeLaunchSpecification.isOsDiskSet()) {
                apiStatefulNodeLaunchSpecification.setOsDisk(toDal(statefulNodeLaunchSpecification.getOsDisk()));
            }
            if (statefulNodeLaunchSpecification.isExtensionsSet()) {
                List<ApiLaunchSpecExtensionsSpecification> launchSpecExtensionsList =
                        statefulNodeLaunchSpecification.getExtensions().stream().map(StatefulNodeConverter::toDal)
                                                       .collect(Collectors.toList());
                apiStatefulNodeLaunchSpecification.setExtensions(launchSpecExtensionsList);
            }

            if (statefulNodeLaunchSpecification.isLoginSet()) {
                apiStatefulNodeLaunchSpecification.setLogin(toDal(statefulNodeLaunchSpecification.getLogin()));
            }

            if (statefulNodeLaunchSpecification.isTagsSet()) {
                List<ApiLaunchSpecTagsSpecification> launchSpecTagsList =
                        statefulNodeLaunchSpecification.getTags().stream().map(StatefulNodeConverter::toDal)
                                                       .collect(Collectors.toList());
                apiStatefulNodeLaunchSpecification.setTags(launchSpecTagsList);
            }
        }

        return apiStatefulNodeLaunchSpecification;
    }

    private static ApiLaunchSpecDataDisksSpecification toDal(LaunchSpecDataDisksSpecification launchSpecDataDisks) {
        ApiLaunchSpecDataDisksSpecification apiLaunchSpecDataDisks = null;

        if (launchSpecDataDisks != null) {
            apiLaunchSpecDataDisks = new ApiLaunchSpecDataDisksSpecification();

            if (launchSpecDataDisks.isSetSizeGBSet()) {
                apiLaunchSpecDataDisks.setSizeGB(launchSpecDataDisks.getSizeGB());
            }
            if (launchSpecDataDisks.isLunSet()) {
                apiLaunchSpecDataDisks.setLun(launchSpecDataDisks.getLun());
            }
            if(launchSpecDataDisks.isTypeSet()){
                apiLaunchSpecDataDisks.setType(launchSpecDataDisks.getType());
            }
        }
        return apiLaunchSpecDataDisks;

    }

    private static ApiLaunchSpecOsDiskSpecification toDal(LaunchSpecOsDiskSpecification launchSpecOsDisk) {
        ApiLaunchSpecOsDiskSpecification apiLaunchSpecOsDisk = null;

        if (launchSpecOsDisk != null) {
            apiLaunchSpecOsDisk = new ApiLaunchSpecOsDiskSpecification();

            if (launchSpecOsDisk.isSetSizeGBSet()) {
                apiLaunchSpecOsDisk.setSizeGB(launchSpecOsDisk.getSizeGB());
            }
            if (launchSpecOsDisk.isNameSet()) {
                apiLaunchSpecOsDisk.setName(launchSpecOsDisk.getName());
            }
            if(launchSpecOsDisk.isTypeSet()){
                apiLaunchSpecOsDisk.setType(launchSpecOsDisk.getType());
            }
        }
        return apiLaunchSpecOsDisk;

    }

    private static ApiLaunchSpecExtensionsSpecification toDal(LaunchSpecExtensionsSpecification launchSpecOsDisk) {
        ApiLaunchSpecExtensionsSpecification apiLaunchSpecOsDisk = null;

        if (launchSpecOsDisk != null) {
            apiLaunchSpecOsDisk = new ApiLaunchSpecExtensionsSpecification();

            if (launchSpecOsDisk.isNameSet()) {
                apiLaunchSpecOsDisk.setName(launchSpecOsDisk.getName());
            }
            if (launchSpecOsDisk.isPublisherSet()) {
                apiLaunchSpecOsDisk.setPublisher(launchSpecOsDisk.getPublisher());
            }
            if(launchSpecOsDisk.isTypeSet()){
                apiLaunchSpecOsDisk.setType(launchSpecOsDisk.getType());
            }
            if(launchSpecOsDisk.isApiVersionet()){
                apiLaunchSpecOsDisk.setApiVersion(launchSpecOsDisk.getApiVersion());
            }
            if(launchSpecOsDisk.isMinorVersionAutoUpgradeSet()){
                apiLaunchSpecOsDisk.setMinorVersionAutoUpgrade(launchSpecOsDisk.getMinorVersionAutoUpgrade());
            }
            if(launchSpecOsDisk.isProtectedSettingsSet()){
                apiLaunchSpecOsDisk.setProtectedSettings(toDal(launchSpecOsDisk.getProtectedSettings()));
            }

        }
        return apiLaunchSpecOsDisk;

    }

    private static ApiLaunchSpecExtensionsProtectedSettings toDal(LaunchSpecExtensionsProtectedSettings launchSpecExtensionsProtectedSettings){
        ApiLaunchSpecExtensionsProtectedSettings apiLaunchSpecExtensionsProtectedSettings = null;

        if(launchSpecExtensionsProtectedSettings != null)
        {
            apiLaunchSpecExtensionsProtectedSettings = new ApiLaunchSpecExtensionsProtectedSettings();

            if(launchSpecExtensionsProtectedSettings.isScriptSet()){
                apiLaunchSpecExtensionsProtectedSettings.setScript(launchSpecExtensionsProtectedSettings.getScript());
            }
        }
        return apiLaunchSpecExtensionsProtectedSettings;
    }

    private static ApiLaunchSpecLoginSpecification toDal(LaunchSpecLoginSpecification launchSpecLogin) {
        ApiLaunchSpecLoginSpecification apiLaunchSpecLogin = null;

        if (launchSpecLogin != null) {
            apiLaunchSpecLogin = new ApiLaunchSpecLoginSpecification();

            if (launchSpecLogin.isUserNameSet()) {
                apiLaunchSpecLogin.setUserName(launchSpecLogin.getUserName());
            }
            if (launchSpecLogin.isPasswordSet()) {
                apiLaunchSpecLogin.setPassword(launchSpecLogin.getPassword());
            }

        }
        return apiLaunchSpecLogin;
    }

    private static ApiLaunchSpecTagsSpecification toDal(LaunchSpecTagsSpecification launchSpecTags) {
        ApiLaunchSpecTagsSpecification apiLaunchSpecTags = null;

        if (launchSpecTags != null) {
            apiLaunchSpecTags = new ApiLaunchSpecTagsSpecification();

            if (launchSpecTags.isTagKeySet()) {
                apiLaunchSpecTags.setTagKey(launchSpecTags.getTagKey());
            }
            if (launchSpecTags.isTagValueSet()) {
                apiLaunchSpecTags.setTagValue(launchSpecTags.getTagValue());
            }
        }
        return apiLaunchSpecTags;
    }

    private static ApiLaunchSpecNetworkConfiguration toDal(LaunchSpecNetworkConfiguration launchSpecNetwork) {
        ApiLaunchSpecNetworkConfiguration apiLaunchSpecImage = null;

        if (launchSpecNetwork != null) {
            apiLaunchSpecImage = new ApiLaunchSpecNetworkConfiguration();

            if (launchSpecNetwork.isResourceGroupNameSet()) {
                apiLaunchSpecImage.setResourceGroupName(launchSpecNetwork.getResourceGroupName());
            }
            if (launchSpecNetwork.isVirtualNetworkNameSet()) {
                apiLaunchSpecImage.setVirtualNetworkName(launchSpecNetwork.getVirtualNetworkName());
            }
            if (launchSpecNetwork.isNetworkInterfacesSet()) {
                List<ApiLaunchSpecNetworkInterfacesConfiguration> networkInterfacesList =
                        launchSpecNetwork.getNetworkInterfaces().stream().map(StatefulNodeConverter::toDal)
                                      .collect(Collectors.toList());
                apiLaunchSpecImage.setNetworkInterfaces(networkInterfacesList);
            }
        }
        return apiLaunchSpecImage;
    }

    private static ApiLaunchSpecNetworkInterfacesConfiguration toDal(LaunchSpecNetworkInterfacesConfiguration launchSpecNetworkInterfaces) {
        ApiLaunchSpecNetworkInterfacesConfiguration apiLaunchSpecNetworkInterfaces = null;

        if (launchSpecNetworkInterfaces != null) {
            apiLaunchSpecNetworkInterfaces = new ApiLaunchSpecNetworkInterfacesConfiguration();

            if (launchSpecNetworkInterfaces.isAssignPublicIpSet()) {
                apiLaunchSpecNetworkInterfaces.setAssignPublicIp(launchSpecNetworkInterfaces.getAssignPublicIp());
            }
            if (launchSpecNetworkInterfaces.isIsPrimarySet()) {
                apiLaunchSpecNetworkInterfaces.setIsPrimary(launchSpecNetworkInterfaces.getIsPrimary());
            }
            if (launchSpecNetworkInterfaces.isSubnetNameSet()) {
                apiLaunchSpecNetworkInterfaces.setSubnetName(launchSpecNetworkInterfaces.getSubnetName());
            }
            if (launchSpecNetworkInterfaces.isPublicIpSkuSet()) {
                apiLaunchSpecNetworkInterfaces.setPublicIpSku(launchSpecNetworkInterfaces.getPublicIpSku());
            }
            if (launchSpecNetworkInterfaces.isNetworkSecurityGroupSet()) {
                apiLaunchSpecNetworkInterfaces.setNetworkSecurityGroup(toDal(launchSpecNetworkInterfaces.getNetworkSecurityGroup()));
            }
        }
        return apiLaunchSpecNetworkInterfaces;
    }

    private static ApiLaunchSpecNetworkSecurityGroupConfiguration toDal(LaunchSpecNetworkSecurityGroupConfiguration launchSpecNetworkSecurityGroup) {
        ApiLaunchSpecNetworkSecurityGroupConfiguration apiLaunchSpecNetworkSecurityGroup = null;

        if (launchSpecNetworkSecurityGroup != null) {
            apiLaunchSpecNetworkSecurityGroup = new ApiLaunchSpecNetworkSecurityGroupConfiguration();

            if (launchSpecNetworkSecurityGroup.isNameSet()) {
                apiLaunchSpecNetworkSecurityGroup.setName(launchSpecNetworkSecurityGroup.getName());
            }
            if (launchSpecNetworkSecurityGroup.isResourceGroupNameSet()) {
                apiLaunchSpecNetworkSecurityGroup.setResourceGroupName(launchSpecNetworkSecurityGroup.getResourceGroupName());
            }
        }
        return apiLaunchSpecNetworkSecurityGroup;
    }

    private static ApiLaunchSpecImageConfiguration toDal(LaunchSpecImageConfiguration launchSpecImage) {
        ApiLaunchSpecImageConfiguration apiLaunchSpecImage = null;

        if (launchSpecImage != null) {
            apiLaunchSpecImage = new ApiLaunchSpecImageConfiguration();

            if (launchSpecImage.isMarketplaceSet()) {
                apiLaunchSpecImage.setMarketplace(toDal(launchSpecImage.getMarketplace()));
            }

        }
        return apiLaunchSpecImage;
    }

    private static ApiLaunchSpecMarketplaceConfiguration toDal(LaunchSpecMarketplaceConfiguration launchSpecMarketplace){
        ApiLaunchSpecMarketplaceConfiguration apiLaunchSpecMarketplace = null;

        if(launchSpecMarketplace != null){
            apiLaunchSpecMarketplace = new ApiLaunchSpecMarketplaceConfiguration();

            if(launchSpecMarketplace.isOfferSet()){
                apiLaunchSpecMarketplace.setOffer(launchSpecMarketplace.getOffer());
            }
            if(launchSpecMarketplace.isPublisherSet()){
                apiLaunchSpecMarketplace.setPublisher(launchSpecMarketplace.getPublisher());
            }
            if(launchSpecMarketplace.isSkuSet()){
                apiLaunchSpecMarketplace.setSku(launchSpecMarketplace.getSku());
            }
            if(launchSpecMarketplace.isVersionSet()){
                apiLaunchSpecMarketplace.setVersion(launchSpecMarketplace.getVersion());
            }
        }

        return apiLaunchSpecMarketplace;
    }


    private static ApiStatefulNodeLoadBalancersConfig toDal(StatefulNodeLoadBalancersConfig statefulNodeLoadBalancers) {
        ApiStatefulNodeLoadBalancersConfig apiStatefulNodeLoadBalancers = null;

        if (statefulNodeLoadBalancers != null) {
            apiStatefulNodeLoadBalancers = new ApiStatefulNodeLoadBalancersConfig();

            if (statefulNodeLoadBalancers.isLoadBalancersSet()) {
                apiStatefulNodeLoadBalancers.setLoadBalancers(statefulNodeLoadBalancers.getLoadBalancers());
            }

        }
        return apiStatefulNodeLoadBalancers;
    }

    private static ApiStatefulNodeHealthConfiguration toDal(StatefulNodeHealthConfiguration statefulNodeHealth) {
        ApiStatefulNodeHealthConfiguration apiStatefulNodeHealth = null;

        if (statefulNodeHealth != null) {
            apiStatefulNodeHealth = new ApiStatefulNodeHealthConfiguration();

            if (statefulNodeHealth.isHealthCheckTypesSet()) {
                apiStatefulNodeHealth.setHealthCheckTypes(statefulNodeHealth.getHealthCheckTypes());
            }
            if (statefulNodeHealth.isUnhealthyDurationSet()) {
                apiStatefulNodeHealth.setUnhealthyDuration(statefulNodeHealth.getUnhealthyDuration());
            }
            if (statefulNodeHealth.isGracePeriodSet()) {
                apiStatefulNodeHealth.setGracePeriod(statefulNodeHealth.getGracePeriod());
            }
            if (statefulNodeHealth.isAutoHealingSet()) {
                apiStatefulNodeHealth.setAutoHealing(statefulNodeHealth.getAutoHealing());
            }
        }

        return apiStatefulNodeHealth;
    }

    private static ApiStatefulNodePersistenceConfiguration toDal(
            StatefulNodePersistenceConfiguration statefulNodePersistent) {
        ApiStatefulNodePersistenceConfiguration apiStatefulNodePersistent = null;

        if (statefulNodePersistent != null) {
            apiStatefulNodePersistent = new ApiStatefulNodePersistenceConfiguration();

            if (statefulNodePersistent.isShouldPersistDataDisksSet()) {
                apiStatefulNodePersistent.setShouldPersistDataDisks(statefulNodePersistent.getShouldPersistDataDisks());
            }
            if (statefulNodePersistent.isShouldPersistNetworkSet()) {
                apiStatefulNodePersistent.setShouldPersistNetwork(statefulNodePersistent.getShouldPersistNetwork());
            }
            if (statefulNodePersistent.isShouldPersistOsDiskSet()) {
                apiStatefulNodePersistent.setShouldPersistOsDisk(statefulNodePersistent.getShouldPersistOsDisk());
            }
            if (statefulNodePersistent.isOsDiskPersistenceModeSet()) {
                apiStatefulNodePersistent.setOsDiskPersistenceMode(statefulNodePersistent.getOsDiskPersistenceMode().getName());
            }
            if (statefulNodePersistent.isDataDisksPersistenceModeSet()) {
                apiStatefulNodePersistent.setDataDisksPersistenceMode(statefulNodePersistent.getDataDisksPersistenceMode().getName());
            }
        }

        return apiStatefulNodePersistent;
    }

    private static ApiStatefulNodeSchedulingConfiguration toDal(StatefulNodeSchedulingConfiguration statefulNodeScheduling) {
        ApiStatefulNodeSchedulingConfiguration apiStatefulNodeScheduling = null;

        if (statefulNodeScheduling != null) {
            apiStatefulNodeScheduling = new ApiStatefulNodeSchedulingConfiguration();

            if (statefulNodeScheduling.isTasksSet()) {
                if (statefulNodeScheduling.getTasks() != null) {
                    List<ApiStatefulNodeTasksConfiguration> taskList =
                            statefulNodeScheduling.getTasks().stream().map(StatefulNodeConverter::toDal).collect(Collectors.toList());
                    apiStatefulNodeScheduling.setTasks(taskList);
                }
            }
        }
        return apiStatefulNodeScheduling;
    }


    private static ApiStatefulNodeTasksConfiguration toDal(StatefulNodeTasksConfiguration tasksConfiguration) {
        ApiStatefulNodeTasksConfiguration retVal = null;

        if (tasksConfiguration != null) {
            retVal = new ApiStatefulNodeTasksConfiguration();

            if (tasksConfiguration.isIsEnabledSet()) {
                retVal.setIsEnabled(tasksConfiguration.getIsEnabled());
            }
            if (tasksConfiguration.isCronExpressionSet()) {
                retVal.setCronExpression(tasksConfiguration.getCronExpression());
            }
            if (tasksConfiguration.isTypeSet()) {
                retVal.setType(tasksConfiguration.getType().getName());
            }
        }

        return retVal;
    }

    public static ApiStatefulNodeDeallocationConfig toDal(StatefulNodeDeallocationConfig deallocationConfig) {
        ApiStatefulNodeDeallocationConfig retVal = null;

        if (deallocationConfig != null) {
            retVal = new ApiStatefulNodeDeallocationConfig();

            if (deallocationConfig.isShouldTerminateVmSet()) {
                retVal.setShouldTerminateVm(deallocationConfig.getShouldTerminateVm());
            }
            if (deallocationConfig.isNetworkDeallocationConfigSet()) {
                retVal.setNetworkDeallocationConfig(toDal(deallocationConfig.getNetworkDeallocationConfig()));
            }
            if (deallocationConfig.isDiskDeallocationConfigSet()) {
                retVal.setDiskDeallocationConfig(toDal(deallocationConfig.getDiskDeallocationConfig()));
            }
            if (deallocationConfig.isSnapshotDeallocationConfigSet()) {
                retVal.setSnapshotDeallocationConfig(toDal(deallocationConfig.getSnapshotDeallocationConfig()));
            }
            if (deallocationConfig.isPublicIpDeallocationConfigSet()) {
                retVal.setPublicIpDeallocationConfig(toDal(deallocationConfig.getPublicIpDeallocationConfig()));
            }
        }

        return retVal;
    }

    private static ApiStatefulNodeNetworkDeallocationConfig toDal(StatefulNodeNetworkDeallocationConfig deallocationNetworkConfig) {
        ApiStatefulNodeNetworkDeallocationConfig retVal = null;

        if (deallocationNetworkConfig != null) {
            retVal = new ApiStatefulNodeNetworkDeallocationConfig();

            if (deallocationNetworkConfig.isShouldDeallocateSet()) {
                retVal.setShouldDeallocate(deallocationNetworkConfig.getShouldDeallocate());
            }
            if(deallocationNetworkConfig.isTtlInHoursSet()){
                retVal.setTtlInHours(deallocationNetworkConfig.getTtlInHours());
            }

        }

        return retVal;
    }

    private static ApiStatefulNodeDiskDeallocationConfig toDal(StatefulNodeDiskDeallocationConfig deallocationDiskonfig) {
        ApiStatefulNodeDiskDeallocationConfig retVal = null;

        if (deallocationDiskonfig != null) {
            retVal = new ApiStatefulNodeDiskDeallocationConfig();

            if (deallocationDiskonfig.isShouldDeallocateSet()) {
                retVal.setShouldDeallocate(deallocationDiskonfig.getShouldDeallocate());
            }
            if(deallocationDiskonfig.isTtlInHoursSet()){
                retVal.setTtlInHours(deallocationDiskonfig.getTtlInHours());
            }

        }

        return retVal;
    }

    private static ApiStatefulNodeSnapshotDeallocationConfig toDal(StatefulNodeSnapshotDeallocationConfig deallocationSnapshotConfig) {
        ApiStatefulNodeSnapshotDeallocationConfig retVal = null;

        if (deallocationSnapshotConfig != null) {
            retVal = new ApiStatefulNodeSnapshotDeallocationConfig();

            if (deallocationSnapshotConfig.isShouldDeallocateSet()) {
                retVal.setShouldDeallocate(deallocationSnapshotConfig.getShouldDeallocate());
            }
            if(deallocationSnapshotConfig.isTtlInHoursSet()){
                retVal.setTtlInHours(deallocationSnapshotConfig.getTtlInHours());
            }

        }

        return retVal;
    }


    private static ApiStatefulNodePublicIpDeallocationConfig toDal(StatefulNodePublicIpDeallocationConfig deallocationPublicIpConfig) {
        ApiStatefulNodePublicIpDeallocationConfig retVal = null;

        if (deallocationPublicIpConfig != null) {
            retVal = new ApiStatefulNodePublicIpDeallocationConfig();

            if (deallocationPublicIpConfig.isShouldDeallocateSet()) {
                retVal.setShouldDeallocate(deallocationPublicIpConfig.getShouldDeallocate());
            }
            if(deallocationPublicIpConfig.isTtlInHoursSet()){
                retVal.setTtlInHours(deallocationPublicIpConfig.getTtlInHours());
            }

        }

        return retVal;
    }

    //endregion

    //region DAL -> BL
    public static StatefulNode toBl(ApiStatefulNode apiStatefulNode) {
        StatefulNode statefulNode = null;

        if (apiStatefulNode != null) {
            StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();

            if (apiStatefulNode.isIdSet()) {
                statefulNodeBuilder.setId(apiStatefulNode.getId());
            }
            if (apiStatefulNode.isNameSet()) {
                statefulNodeBuilder.setName(apiStatefulNode.getName());
            }
            if (apiStatefulNode.isRegionSet()) {
                statefulNodeBuilder.setRegion(apiStatefulNode.getRegion());
            }
            if (apiStatefulNode.isResourceGroupNameSet()) {
                statefulNodeBuilder.setResourceGroupName(apiStatefulNode.getResourceGroupName());
            }
            if (apiStatefulNode.isDescriptionSet()) {
                statefulNodeBuilder.setDescription(apiStatefulNode.getDescription());
            }
            if (apiStatefulNode.isPersistenceSet()) {
                statefulNodeBuilder.setPersistence(toBl(apiStatefulNode.getPersistence()));
            }
            if (apiStatefulNode.isStrategySet()) {
                statefulNodeBuilder.setStrategy(toBl(apiStatefulNode.getStrategy()));
            }
            if (apiStatefulNode.isComputeSet()) {
                statefulNodeBuilder.setCompute(toBl(apiStatefulNode.getCompute()));
            }
            if (apiStatefulNode.isSchedulingSet()) {
                statefulNodeBuilder.setScheduling(toBl(apiStatefulNode.getScheduling()));
            }
            if (apiStatefulNode.isHealthSet()) {
                statefulNodeBuilder.setHealth(toBl(apiStatefulNode.getHealth()));
            }

            statefulNode = statefulNodeBuilder.build();

        }
        return statefulNode;
    }


    private static StatefulNodeComputeConfiguration toBl(ApiStatefulNodeComputeConfiguration apiStatefulNodeCompute){

        StatefulNodeComputeConfiguration statefulNodeCompute = null;

        if(apiStatefulNodeCompute != null) {

            StatefulNodeComputeConfiguration.Builder statefulNodeComputeBuilder = StatefulNodeComputeConfiguration.Builder.get();

            if (apiStatefulNodeCompute.isOsSet()) {
                statefulNodeComputeBuilder.setOs(AzureOsEnum.fromName(apiStatefulNodeCompute.getOs()));
            }

            if (apiStatefulNodeCompute.isVmSizesSet()) {
                statefulNodeComputeBuilder.setVmSizes(toBl(apiStatefulNodeCompute.getVmSizes()));
            }

            if (apiStatefulNodeCompute.isZonesSet()) {
                statefulNodeComputeBuilder.setZones(apiStatefulNodeCompute.getZones());
            }

            if (apiStatefulNodeCompute.isPreferredZoneSet()) {
                statefulNodeComputeBuilder.setPreferredZone(apiStatefulNodeCompute.getPreferredZone());
            }

            if (apiStatefulNodeCompute.isLaunchSpecificationSet()) {
                statefulNodeComputeBuilder.setLaunchSpecification(toBl(apiStatefulNodeCompute.getLaunchSpecification()));
            }

            if (apiStatefulNodeCompute.isLoadBalancersConfigSet()) {
                statefulNodeComputeBuilder.setLoadBalancersConfig(toBl(apiStatefulNodeCompute.getLoadBalancersConfig()));
            }

            statefulNodeCompute = statefulNodeComputeBuilder.build();
        }

        return statefulNodeCompute;
    }

    private static StatefulNodeVmSizesConfiguration toBl(ApiStatefulNodeVmSizesConfiguration apiStatefulNodeVmSizes){

        StatefulNodeVmSizesConfiguration statefulNodeVmSizes = null;

        if(apiStatefulNodeVmSizes != null) {

            StatefulNodeVmSizesConfiguration.Builder statefulNodeVmSizesBuilder = StatefulNodeVmSizesConfiguration.Builder.get();

            if (apiStatefulNodeVmSizes.isOdSizesSet()) {
                statefulNodeVmSizesBuilder.setOdSizes(apiStatefulNodeVmSizes.getOdSizes());
            }

            if (apiStatefulNodeVmSizes.isSpotSizesSet()) {
                statefulNodeVmSizesBuilder.setSpotSizes(apiStatefulNodeVmSizes.getSpotSizes());
            }

            if (apiStatefulNodeVmSizes.isPreferredSpotSizesSet()) {
                statefulNodeVmSizesBuilder.setPreferredSpotSizes(apiStatefulNodeVmSizes.getPreferredSpotSizes());
            }

            statefulNodeVmSizes = statefulNodeVmSizesBuilder.build();
        }

        return statefulNodeVmSizes;
    }

    private static StatefulNodeLaunchSpecification toBl(ApiStatefulNodeLaunchSpecification apiStatefulNodeLaunchSpecification){

        StatefulNodeLaunchSpecification statefulNodeLaunchSpecification = null;

        if(apiStatefulNodeLaunchSpecification != null) {

            StatefulNodeLaunchSpecification.Builder statefulNodeLaunchSpecificationBuilder = StatefulNodeLaunchSpecification.Builder.get();

            if (apiStatefulNodeLaunchSpecification.isImageSet()) {
                statefulNodeLaunchSpecificationBuilder.setImage(toBl(apiStatefulNodeLaunchSpecification.getImage()));
            }

            if (apiStatefulNodeLaunchSpecification.isNetworkSet()) {
                statefulNodeLaunchSpecificationBuilder.setNetwork(toBl(apiStatefulNodeLaunchSpecification.getNetwork()));
            }

            if (apiStatefulNodeLaunchSpecification.isDataDisksSet()) {
                if (apiStatefulNodeLaunchSpecification.getDataDisks() != null) {
                    List<LaunchSpecDataDisksSpecification> dataDisksList =
                            apiStatefulNodeLaunchSpecification.getDataDisks().stream().map(StatefulNodeConverter::toBl).collect(Collectors.toList());
                    statefulNodeLaunchSpecificationBuilder.setDataDisks(dataDisksList);
                }
            }

            if (apiStatefulNodeLaunchSpecification.isOsDiskSet()) {
                statefulNodeLaunchSpecificationBuilder.setOsDisk(toBl(apiStatefulNodeLaunchSpecification.getOsDisk()));
            }

            if (apiStatefulNodeLaunchSpecification.isExtensionsSet()) {
                if (apiStatefulNodeLaunchSpecification.getExtensions() != null) {
                    List<LaunchSpecExtensionsSpecification> extensionsList =
                            apiStatefulNodeLaunchSpecification.getExtensions().stream().map(StatefulNodeConverter::toBl).collect(Collectors.toList());
                    statefulNodeLaunchSpecificationBuilder.setExtensions(extensionsList);
                }
            }

            if (apiStatefulNodeLaunchSpecification.isLoginSet()) {
                statefulNodeLaunchSpecificationBuilder.setLogin(toBl(apiStatefulNodeLaunchSpecification.getLogin()));
            }

            if (apiStatefulNodeLaunchSpecification.isTagsSet()) {
                if(apiStatefulNodeLaunchSpecification.getTags() != null){
                    List<LaunchSpecTagsSpecification> tagsList =
                            apiStatefulNodeLaunchSpecification.getTags().stream().map(StatefulNodeConverter::toBl).collect(Collectors.toList());
                    statefulNodeLaunchSpecificationBuilder.setTags(tagsList);
                }

            }
            statefulNodeLaunchSpecification = statefulNodeLaunchSpecificationBuilder.build();
        }

        return statefulNodeLaunchSpecification;
    }

    private static LaunchSpecImageConfiguration toBl(ApiLaunchSpecImageConfiguration apiLaunchSpecImageConfiguration){

        LaunchSpecImageConfiguration launchSpecImageConfiguration = null;

        if(apiLaunchSpecImageConfiguration != null) {

            LaunchSpecImageConfiguration.Builder launchSpecImageConfigurationBuilder = LaunchSpecImageConfiguration.Builder.get();

            if (apiLaunchSpecImageConfiguration.isMarketplaceSet()) {
                launchSpecImageConfigurationBuilder.setMarketplace(toBl(apiLaunchSpecImageConfiguration.getMarketplace()));
            }

            launchSpecImageConfiguration = launchSpecImageConfigurationBuilder.build();
        }

        return launchSpecImageConfiguration;
    }

    private static LaunchSpecMarketplaceConfiguration toBl(ApiLaunchSpecMarketplaceConfiguration apiLaunchSpecMarketplaceConfiguration){

        LaunchSpecMarketplaceConfiguration launchSpecMarketplaceConfiguration = null;

        if(apiLaunchSpecMarketplaceConfiguration != null) {

            LaunchSpecMarketplaceConfiguration.Builder launchSpecImageConfigurationBuilder = LaunchSpecMarketplaceConfiguration.Builder.get();

            if (apiLaunchSpecMarketplaceConfiguration.isOfferSet()) {
                launchSpecImageConfigurationBuilder.setOffer(apiLaunchSpecMarketplaceConfiguration.getOffer());
            }

            if (apiLaunchSpecMarketplaceConfiguration.isPublisherSet()) {
                launchSpecImageConfigurationBuilder.setPublisher(apiLaunchSpecMarketplaceConfiguration.getPublisher());
            }

            if (apiLaunchSpecMarketplaceConfiguration.isSkuSet()) {
                launchSpecImageConfigurationBuilder.setSku(apiLaunchSpecMarketplaceConfiguration.getSku());
            }

            if (apiLaunchSpecMarketplaceConfiguration.isVersionSet()) {
                launchSpecImageConfigurationBuilder.setVersion(apiLaunchSpecMarketplaceConfiguration.getVersion());
            }

            launchSpecMarketplaceConfiguration = launchSpecImageConfigurationBuilder.build();
        }

        return launchSpecMarketplaceConfiguration;
    }

    private static LaunchSpecNetworkConfiguration toBl(ApiLaunchSpecNetworkConfiguration apiLaunchSpecNetworkConfigurationn){

        LaunchSpecNetworkConfiguration launchSpecNetworkConfiguration = null;

        if(apiLaunchSpecNetworkConfigurationn != null) {

            LaunchSpecNetworkConfiguration.Builder launchSpecNetworkConfigurationBuilder = LaunchSpecNetworkConfiguration.Builder.get();

            if (apiLaunchSpecNetworkConfigurationn.isResourceGroupNameSet()) {
                launchSpecNetworkConfigurationBuilder.setResourceGroupName(apiLaunchSpecNetworkConfigurationn.getResourceGroupName());
            }

            if (apiLaunchSpecNetworkConfigurationn.isVirtualNetworkNameSet()) {
                launchSpecNetworkConfigurationBuilder.setVirtualNetworkName(apiLaunchSpecNetworkConfigurationn.getVirtualNetworkName());
            }

            if (apiLaunchSpecNetworkConfigurationn.isNetworkInterfacesSet()) {

                if(apiLaunchSpecNetworkConfigurationn.getNetworkInterfaces() != null){
                    List<LaunchSpecNetworkInterfacesConfiguration> networkInterfacesList =
                            apiLaunchSpecNetworkConfigurationn.getNetworkInterfaces().stream().map(StatefulNodeConverter::toBl).collect(Collectors.toList());
                    launchSpecNetworkConfigurationBuilder.setNetworkInterfaces(networkInterfacesList);
                }
            }

            launchSpecNetworkConfiguration = launchSpecNetworkConfigurationBuilder.build();
        }

        return launchSpecNetworkConfiguration;
    }

    private static LaunchSpecNetworkInterfacesConfiguration toBl(ApiLaunchSpecNetworkInterfacesConfiguration apiLaunchSpecNetworkInterfaces){

        LaunchSpecNetworkInterfacesConfiguration launchSpecNetworkInterfaces = null;

        if(apiLaunchSpecNetworkInterfaces != null) {

            LaunchSpecNetworkInterfacesConfiguration.Builder launchSpecNetworkInterfacesBuilder = LaunchSpecNetworkInterfacesConfiguration.Builder.get();

            if (apiLaunchSpecNetworkInterfaces.isAssignPublicIpSet()) {
                launchSpecNetworkInterfacesBuilder.setAssignPublicIp(apiLaunchSpecNetworkInterfaces.getAssignPublicIp());
            }

            if (apiLaunchSpecNetworkInterfaces.isIsPrimarySet()) {
                launchSpecNetworkInterfacesBuilder.setIsPrimary(apiLaunchSpecNetworkInterfaces.getIsPrimary());
            }

            if (apiLaunchSpecNetworkInterfaces.isSubnetNameSet()) {
                launchSpecNetworkInterfacesBuilder.setSubnetName(apiLaunchSpecNetworkInterfaces.getSubnetName());
            }

            if (apiLaunchSpecNetworkInterfaces.isPublicIpSkuSet()) {
                launchSpecNetworkInterfacesBuilder.setPublicIpSku(apiLaunchSpecNetworkInterfaces.getPublicIpSku());
            }

            if (apiLaunchSpecNetworkInterfaces.isNetworkSecurityGroupSet()) {
                launchSpecNetworkInterfacesBuilder.setNetworkSecurityGroup(toBl(apiLaunchSpecNetworkInterfaces.getNetworkSecurityGroup()));
            }

            launchSpecNetworkInterfaces = launchSpecNetworkInterfacesBuilder.build();
        }

        return launchSpecNetworkInterfaces;
    }

    private static LaunchSpecNetworkSecurityGroupConfiguration toBl(ApiLaunchSpecNetworkSecurityGroupConfiguration apiLaunchSpecNetworkSecurityGroup){

        LaunchSpecNetworkSecurityGroupConfiguration launchSpecNetworkSecurityGroup = null;

        if(apiLaunchSpecNetworkSecurityGroup != null) {

            LaunchSpecNetworkSecurityGroupConfiguration.Builder launchSpecNetworkSecurityGroupBuilder = LaunchSpecNetworkSecurityGroupConfiguration.Builder.get();

            if (apiLaunchSpecNetworkSecurityGroup.isNameSet()) {
                launchSpecNetworkSecurityGroupBuilder.setName(apiLaunchSpecNetworkSecurityGroup.getName());
            }

            if (apiLaunchSpecNetworkSecurityGroup.isResourceGroupNameSet()) {
                launchSpecNetworkSecurityGroupBuilder.setResourceGroupName(apiLaunchSpecNetworkSecurityGroup.getResourceGroupName());
            }

            launchSpecNetworkSecurityGroup = launchSpecNetworkSecurityGroupBuilder.build();
        }

        return launchSpecNetworkSecurityGroup;
    }

    private static LaunchSpecOsDiskSpecification toBl(ApiLaunchSpecOsDiskSpecification apiLaunchSpecOsDiskSpecification){

        LaunchSpecOsDiskSpecification launchSpecOsDiskSpecification = null;

        if(apiLaunchSpecOsDiskSpecification != null) {

            LaunchSpecOsDiskSpecification.Builder launchSpecOsDiskSpecificationBuilder = LaunchSpecOsDiskSpecification.Builder.get();

            if (apiLaunchSpecOsDiskSpecification.isNameSet()) {
                launchSpecOsDiskSpecificationBuilder.setName(apiLaunchSpecOsDiskSpecification.getName());
            }

            if (apiLaunchSpecOsDiskSpecification.isTypeSet()) {
                launchSpecOsDiskSpecificationBuilder.setType(apiLaunchSpecOsDiskSpecification.getType());
            }

            if (apiLaunchSpecOsDiskSpecification.isSizeGBSet()) {
                launchSpecOsDiskSpecificationBuilder.setSizeGB(apiLaunchSpecOsDiskSpecification.getSizeGB());
            }

            launchSpecOsDiskSpecification = launchSpecOsDiskSpecificationBuilder.build();
        }

        return launchSpecOsDiskSpecification;
    }


    private static LaunchSpecExtensionsSpecification toBl(ApiLaunchSpecExtensionsSpecification apiLaunchSpecExtensionsSpecification){

        LaunchSpecExtensionsSpecification launchSpecExtensionsSpecification = null;

        if(apiLaunchSpecExtensionsSpecification != null) {

            LaunchSpecExtensionsSpecification.Builder launchSpecExtensionsSpecificationBuilder = LaunchSpecExtensionsSpecification.Builder.get();

            if (apiLaunchSpecExtensionsSpecification.isNameSet()) {
                launchSpecExtensionsSpecificationBuilder.setName(apiLaunchSpecExtensionsSpecification.getName());
            }

            if (apiLaunchSpecExtensionsSpecification.isTypeSet()) {
                launchSpecExtensionsSpecificationBuilder.setType(apiLaunchSpecExtensionsSpecification.getType());
            }

            if (apiLaunchSpecExtensionsSpecification.isApiVersionet()) {
                launchSpecExtensionsSpecificationBuilder.setApiVersion(apiLaunchSpecExtensionsSpecification.getApiVersion());
            }

            if (apiLaunchSpecExtensionsSpecification.isPublisherSet()) {
                launchSpecExtensionsSpecificationBuilder.setPublisher(apiLaunchSpecExtensionsSpecification.getPublisher());
            }

            if (apiLaunchSpecExtensionsSpecification.isMinorVersionAutoUpgradeSet()) {
                launchSpecExtensionsSpecificationBuilder.setMinorVersionAutoUpgrade(apiLaunchSpecExtensionsSpecification.getMinorVersionAutoUpgrade());
            }

            if (apiLaunchSpecExtensionsSpecification.isProtectedSettingsSet()) {
                launchSpecExtensionsSpecificationBuilder.setProtectedSettings(toBl(apiLaunchSpecExtensionsSpecification.getProtectedSettings()));
            }

            launchSpecExtensionsSpecification = launchSpecExtensionsSpecificationBuilder.build();
        }

        return launchSpecExtensionsSpecification;
    }

    private static LaunchSpecExtensionsProtectedSettings toBl(ApiLaunchSpecExtensionsProtectedSettings apiLaunchSpecExtensionsProtectedSettings){

        LaunchSpecExtensionsProtectedSettings launchSpecExtensionsProtectedSettings = null;

        if(apiLaunchSpecExtensionsProtectedSettings != null) {

            LaunchSpecExtensionsProtectedSettings.Builder launchSpecExtensionsProtectedSettingsBuilder = LaunchSpecExtensionsProtectedSettings.Builder.get();

            if (apiLaunchSpecExtensionsProtectedSettings.isScriptSet()) {
                launchSpecExtensionsProtectedSettingsBuilder.setScript(apiLaunchSpecExtensionsProtectedSettings.getScript());
            }

            launchSpecExtensionsProtectedSettings = launchSpecExtensionsProtectedSettingsBuilder.build();
        }

        return launchSpecExtensionsProtectedSettings;

    }

    private static LaunchSpecDataDisksSpecification toBl(ApiLaunchSpecDataDisksSpecification apiLaunchSpecDataDisksSpecification){

        LaunchSpecDataDisksSpecification launchSpecDataDisksSpecification = null;

        if(apiLaunchSpecDataDisksSpecification != null) {

            LaunchSpecDataDisksSpecification.Builder launchSpecDataDisksSpecificationBuilder = LaunchSpecDataDisksSpecification.Builder.get();

            if (apiLaunchSpecDataDisksSpecification.isLunSet()) {
                launchSpecDataDisksSpecificationBuilder.setLun(apiLaunchSpecDataDisksSpecification.getLun());
            }

            if (apiLaunchSpecDataDisksSpecification.isSizeGBSet()) {
                launchSpecDataDisksSpecificationBuilder.setSizeGB(apiLaunchSpecDataDisksSpecification.getSizeGB());
            }

            if (apiLaunchSpecDataDisksSpecification.isTypeSet()) {
                launchSpecDataDisksSpecificationBuilder.setType(apiLaunchSpecDataDisksSpecification.getType());
            }

            launchSpecDataDisksSpecification = launchSpecDataDisksSpecificationBuilder.build();
        }

        return launchSpecDataDisksSpecification;
    }

    private static LaunchSpecLoginSpecification toBl(ApiLaunchSpecLoginSpecification apiLaunchSpecLoginSpecification){

        LaunchSpecLoginSpecification launchSpecLoginSpecification = null;

        if(apiLaunchSpecLoginSpecification != null) {

            LaunchSpecLoginSpecification.Builder launchSpecLoginSpecificationBuilder = LaunchSpecLoginSpecification.Builder.get();

            if (apiLaunchSpecLoginSpecification.isUserNameSet()) {
                launchSpecLoginSpecificationBuilder.setUserName(apiLaunchSpecLoginSpecification.getUserName());
            }
            if(apiLaunchSpecLoginSpecification.isPasswordSet()){
                launchSpecLoginSpecificationBuilder.setPassword(apiLaunchSpecLoginSpecification.getPassword());
            }

            launchSpecLoginSpecification = launchSpecLoginSpecificationBuilder.build();
        }

        return launchSpecLoginSpecification;
    }


    private static LaunchSpecTagsSpecification toBl(ApiLaunchSpecTagsSpecification apiLaunchSpecTagsSpecification){

        LaunchSpecTagsSpecification launchSpecTagsSpecification = null;

        if(apiLaunchSpecTagsSpecification != null) {

            LaunchSpecTagsSpecification.Builder launchSpecTagsSpecificationBuilder = LaunchSpecTagsSpecification.Builder.get();

            if (apiLaunchSpecTagsSpecification.isTagKeySet()) {
                launchSpecTagsSpecificationBuilder.setTagKey(apiLaunchSpecTagsSpecification.getTagKey());
            }
            if(apiLaunchSpecTagsSpecification.isTagValueSet()){
                launchSpecTagsSpecificationBuilder.setTagValue(apiLaunchSpecTagsSpecification.getTagValue());
            }

            launchSpecTagsSpecification = launchSpecTagsSpecificationBuilder.build();
        }

        return launchSpecTagsSpecification;
    }


    private static StatefulNodeLoadBalancersConfig toBl(ApiStatefulNodeLoadBalancersConfig apiStatefulNodeLoadBalancers){

        StatefulNodeLoadBalancersConfig statefulNodeLoadBalancers = null;

        if(apiStatefulNodeLoadBalancers != null) {

            StatefulNodeLoadBalancersConfig.Builder statefulNodeLoadBalancersBuilder = StatefulNodeLoadBalancersConfig.Builder.get();

            if (apiStatefulNodeLoadBalancers.isLoadBalancersSet()) {
                statefulNodeLoadBalancersBuilder.setLoadBalancers(apiStatefulNodeLoadBalancers.getLoadBalancers());
            }

            statefulNodeLoadBalancers = statefulNodeLoadBalancersBuilder.build();
        }

        return statefulNodeLoadBalancers;
    }

    private static StatefulNodeStrategyConfiguration toBl(ApiStatefulNodeStrategyConfiguration apiStatefulNodeStrategy){

        StatefulNodeStrategyConfiguration statefulNodeStrategy = null;

        if(apiStatefulNodeStrategy != null) {

            StatefulNodeStrategyConfiguration.Builder statefulNodeStrategyBuilder = StatefulNodeStrategyConfiguration.Builder.get();

            if (apiStatefulNodeStrategy.isFallbackToOdSet()) {
                statefulNodeStrategyBuilder.setFallbackToOd(apiStatefulNodeStrategy.getFallbackToOd());
            }

            if (apiStatefulNodeStrategy.isDrainingTimeoutSet()) {
                statefulNodeStrategyBuilder.setDrainingTimeout(apiStatefulNodeStrategy.getDrainingTimeout());
            }

            if (apiStatefulNodeStrategy.isPreferredLifecycleSet()) {
                statefulNodeStrategyBuilder.setPreferredLifecycle(AzureLifeCycleTypeEnum.fromName(apiStatefulNodeStrategy.getPreferredLifecycle()));
            }

            if (apiStatefulNodeStrategy.isRevertToSpotSet()) {
                statefulNodeStrategyBuilder.setRevertToSpot(toBl(apiStatefulNodeStrategy.getRevertToSpot()));
            }

            if (apiStatefulNodeStrategy.isSignalsSet()) {
                List<StatefulNodeSignalConfiguration> signalsList = apiStatefulNodeStrategy.getSignals()
                                                        .stream().map(StatefulNodeConverter::toBl).collect(Collectors.toList());
                statefulNodeStrategyBuilder.setSignals(signalsList);
            }

            if(apiStatefulNodeStrategy.isOptimizationWindowsSet()){
                statefulNodeStrategyBuilder.setOptimizationWindows(apiStatefulNodeStrategy.getOptimizationWindows());
            }

            statefulNodeStrategy = statefulNodeStrategyBuilder.build();
        }

        return statefulNodeStrategy;
    }


    private static StatefulNodeSignalConfiguration toBl(ApiStatefulNodeSignalConfiguration apiStatefulNodeSignal){

        StatefulNodeSignalConfiguration statefulNodeSignal = null;

        if(apiStatefulNodeSignal != null) {

            StatefulNodeSignalConfiguration.Builder statefulNodeSignalBuilder = StatefulNodeSignalConfiguration.Builder.get();

            if (apiStatefulNodeSignal.isTimeoutSet()) {
                statefulNodeSignalBuilder.setTimeout(apiStatefulNodeSignal.getTimeout());
            }

            if (apiStatefulNodeSignal.isTypeSet()) {
                statefulNodeSignalBuilder.setType(ElastigroupVmSignalEnumAzure.fromName(apiStatefulNodeSignal.getType()));
            }
            statefulNodeSignal = statefulNodeSignalBuilder.build();
        }

        return statefulNodeSignal;
    }

    private static StatefulNodeRevertToSpotConfiguration toBl(ApiStatefulNodeRevertToSpotConfiguration apiStatefulNodeRevertToSpot){

        StatefulNodeRevertToSpotConfiguration statefulNodeRevertToSpot = null;

        if(apiStatefulNodeRevertToSpot != null) {

            StatefulNodeRevertToSpotConfiguration.Builder statefulNodeRevertToSpotBuilder = StatefulNodeRevertToSpotConfiguration.Builder.get();

            if (apiStatefulNodeRevertToSpot.isPerformAtSet()) {
                statefulNodeRevertToSpotBuilder.setPerformAt(AzurePerformAtEnum.fromName(apiStatefulNodeRevertToSpot.getPerformAt()));
            }

            statefulNodeRevertToSpot = statefulNodeRevertToSpotBuilder.build();
        }

        return statefulNodeRevertToSpot;
    }


    private static StatefulNodeSchedulingConfiguration toBl(ApiStatefulNodeSchedulingConfiguration apiStatefulNodeScheduling) {

        StatefulNodeSchedulingConfiguration statefulNodeScheduling = null;

        if(apiStatefulNodeScheduling != null){

            StatefulNodeSchedulingConfiguration.Builder statefulNodeSchedulingBuilder = StatefulNodeSchedulingConfiguration.Builder.get();

            if (apiStatefulNodeScheduling.getTasks() != null) {
                List<StatefulNodeTasksConfiguration> tasksConfigurationList =
                        apiStatefulNodeScheduling.getTasks().stream().map(StatefulNodeConverter::toBl).collect(Collectors.toList());
                statefulNodeSchedulingBuilder.setTasks(tasksConfigurationList);
            }

            statefulNodeScheduling = statefulNodeSchedulingBuilder.build();
        }
        return statefulNodeScheduling;
    }

    private static StatefulNodeTasksConfiguration toBl(ApiStatefulNodeTasksConfiguration apiStatefulNodeTasks){

        StatefulNodeTasksConfiguration statefulNodeTasks = null;

        if(apiStatefulNodeTasks != null){

            StatefulNodeTasksConfiguration.Builder statefulNodeTasksBuilder = StatefulNodeTasksConfiguration.Builder.get();

            if (apiStatefulNodeTasks.isIsEnabledSet()) {
                statefulNodeTasksBuilder.setIsEnabled(apiStatefulNodeTasks.getIsEnabled());
            }

            if (apiStatefulNodeTasks.isCronExpressionSet()) {
                statefulNodeTasksBuilder.setCronExpression(apiStatefulNodeTasks.getCronExpression());
            }

            if (apiStatefulNodeTasks.isTypeSet()) {
                statefulNodeTasksBuilder.setType(AzureStatefulNodeTaskTypeEnum.fromName(apiStatefulNodeTasks.getType()));
            }

            statefulNodeTasks = statefulNodeTasksBuilder.build();
        }
        return statefulNodeTasks;

    }


    private static StatefulNodePersistenceConfiguration toBl(
            ApiStatefulNodePersistenceConfiguration apiStatefulNodePersistent) {

        StatefulNodePersistenceConfiguration statefulNodePersistent = null;

        if(apiStatefulNodePersistent != null){

            StatefulNodePersistenceConfiguration.Builder statefulNodePersistentBuilder = StatefulNodePersistenceConfiguration.Builder.get();

            if (apiStatefulNodePersistent.isShouldPersistDataDisksSet()) {
                statefulNodePersistentBuilder.setShouldPersistDataDisks(apiStatefulNodePersistent.getShouldPersistDataDisks());
            }

            if(apiStatefulNodePersistent.isShouldPersistNetworkSet()){
                statefulNodePersistentBuilder.setShouldPersistNetwork(apiStatefulNodePersistent.getShouldPersistNetwork());
            }

            if (apiStatefulNodePersistent.isShouldPersistOsDiskSet()) {
                statefulNodePersistentBuilder.setShouldPersistOsDisk(apiStatefulNodePersistent.getShouldPersistOsDisk());
            }

            if (apiStatefulNodePersistent.isOsDiskPersistenceModeSet()) {
                statefulNodePersistentBuilder.setOsDiskPersistenceMode(AzureDiskModeEnum.fromName(apiStatefulNodePersistent.getOsDiskPersistenceMode()));
            }

            if (apiStatefulNodePersistent.isDataDisksPersistenceModeSet()) {
                statefulNodePersistentBuilder.setDataDisksPersistenceMode(AzureDiskModeEnum.fromName(apiStatefulNodePersistent.getDataDisksPersistenceMode()));
            }

            statefulNodePersistent = statefulNodePersistentBuilder.build();
        }
        return statefulNodePersistent;
    }


    private static StatefulNodeHealthConfiguration toBl(ApiStatefulNodeHealthConfiguration apiStatefulNodeHealth) {

        StatefulNodeHealthConfiguration statefulNodeHealthToReturn = null;

        if(apiStatefulNodeHealth != null){

            StatefulNodeHealthConfiguration.Builder statefulNodeHealthBuilder = StatefulNodeHealthConfiguration.Builder.get();

            if (apiStatefulNodeHealth.isAutoHealingSet()) {
                statefulNodeHealthBuilder.setAutoHealing(apiStatefulNodeHealth.getAutoHealing());
            }

            if(apiStatefulNodeHealth.isGracePeriodSet()){
                statefulNodeHealthBuilder.setGracePeriod(apiStatefulNodeHealth.getGracePeriod());
            }

            if (apiStatefulNodeHealth.isHealthCheckTypesSet()) {
                statefulNodeHealthBuilder.setHealthCheckTypes(apiStatefulNodeHealth.getHealthCheckTypes());
            }

            if (apiStatefulNodeHealth.isUnhealthyDurationSet()) {
                statefulNodeHealthBuilder.setUnhealthyDuration(apiStatefulNodeHealth.getUnhealthyDuration());
            }

            statefulNodeHealthToReturn = statefulNodeHealthBuilder.build();
        }
        return statefulNodeHealthToReturn;
    }

}
