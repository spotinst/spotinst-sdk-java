package com.spotinst.sdkjava.model.bl.ocean.aks;


import com.spotinst.sdkjava.model.api.ocean.aks.*;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;



public class ClusterConverterAks {
    //BL -> DAL

    public static ApiClusterAks toDal(OceanClusterAks src) {

        ApiClusterAks retVal = null;

        if (src != null) {
            retVal = new ApiClusterAks();

            if (src.isAksSet()) {
                retVal.setAks(toDal(src.getAks()));
            }

            if (src.isControllerClusterIdSet()) {
                retVal.setControllerClusterId(src.getControllerClusterId());
            }

            if (src.isNameSet()) {
                retVal.setName(src.getName());
            }

            if (src.isVirtualNodeGroupTemplateSet()) {
                retVal.setVirtualNodeGroupTemplate(toDal(src.getVirtualNodeGroupTemplate()));
            }

            if (src.isIdSet()){
                retVal.setId(src.getId());
            }

        }

        return retVal;
    }

    private static ApiClusterConfigurationAks toDal(ClusterConfigurationAks aks) {
        ApiClusterConfigurationAks retVal = null;

        if (aks != null) {
            retVal = new ApiClusterConfigurationAks();

            if (aks.isNameSet()) {
                retVal.setName(aks.getName());
            }

            if (aks.isResourceGroupNameSet()) {
                retVal.setResourceGroupName(aks.getResourceGroupName());
            }

        }

        return retVal;
    }

    private static ApiClusterVirtualNodeGroupTemplateAks toDal(ClusterVirtualNodeGroupTemplateAks virtualNodeGroupTemplateAks) {

        ApiClusterVirtualNodeGroupTemplateAks retVal = null;

        if (virtualNodeGroupTemplateAks != null) {
            retVal = new ApiClusterVirtualNodeGroupTemplateAks();
            if (virtualNodeGroupTemplateAks.isLaunchSpecificationSet()) {
                retVal.setLaunchSpecification(toDal(virtualNodeGroupTemplateAks.getLaunchSpecification()));
            }
        }

        return retVal;
    }

    private static ApiClusterLaunchSpecificationAks toDal(ClusterLaunchSpecificationAks launchSpecificationAks) {

        ApiClusterLaunchSpecificationAks retVal = null;

        if (launchSpecificationAks != null) {

            retVal = new ApiClusterLaunchSpecificationAks();

            if (launchSpecificationAks.isResourceGroupNameSet()){

                retVal.setResourceGroupName(launchSpecificationAks.getResourceGroupName());
            }

            if (launchSpecificationAks.isExtensionsSet()) {

               if (launchSpecificationAks.getExtensions() != null){
                   List<ApiClusterExtensionAks> extensions =
                           launchSpecificationAks.getExtensions().stream().map(ClusterConverterAks::toDal)
                           .collect(Collectors.toList());
                   retVal.setExtensions(extensions);
               }
               else{
                   retVal.setExtensions(null);

               }
            }

            if (launchSpecificationAks.isImageSet()) {
                retVal.setImage(toDal(launchSpecificationAks.getImage()));
            }

            if (launchSpecificationAks.isLoadBalancersConfigSet()){
                retVal.setLoadBalancersConfig(toDal(launchSpecificationAks.getLoadBalancersConfig()));
            }

            if (launchSpecificationAks.isLoginSet()){
                retVal.setLogin(toDal(launchSpecificationAks.getLogin()));
            }

            if (launchSpecificationAks.isNetworkSet()){
                retVal.setNetwork(toDal(launchSpecificationAks.getNetwork()));
            }

            if (launchSpecificationAks.isOsDiskSet()){
                retVal.setOsDisk(toDal(launchSpecificationAks.getOsDisk()));
            }

            if(launchSpecificationAks.isManagedServiceIdentitiesSet()){

                if (launchSpecificationAks.getManagedServiceIdentities() != null) {
                    List<ApiClusterMsiAks> managedServiceIdentities = launchSpecificationAks
                            .getManagedServiceIdentities()
                            .stream().map(ClusterConverterAks::toDal)
                            .collect(Collectors.toList());

                    retVal.setManagedServiceIdentities(managedServiceIdentities);
                }
                else {
                    retVal.setManagedServiceIdentities(null);
                }

            }

            if (launchSpecificationAks.isTagsSet()){

                if (launchSpecificationAks.getTags() != null){
                    List<ApiClusterTagAks> tags =
                            launchSpecificationAks.getTags().stream().map(ClusterConverterAks::toDal)
                                    .collect(Collectors.toList());
                    retVal.setTags(tags);
                }
                else{
                    retVal.setTags(null);

                }
            }
        }

        return retVal;
    }

    private static ApiClusterExtensionAks toDal(ClusterExtensionAks extensionAks) {
        ApiClusterExtensionAks retVal = null;

        if (extensionAks != null) {
            retVal = new ApiClusterExtensionAks();

            if (extensionAks.isApiVersionSet()) {
                retVal.setApiVersion(extensionAks.getApiVersion());
            }

            if (extensionAks.isMinorVersionAutoUpgradeSet()) {
                retVal.setMinorVersionAutoUpgrade(extensionAks.getMinorVersionAutoUpgrade());
            }

            if (extensionAks.isNameSet()){
                retVal.setName(extensionAks.getName());
            }

            if (extensionAks.isPublisherSet()){
                retVal.setPublisher(extensionAks.getPublisher());
            }

            if (extensionAks.isTypeSet()){
                retVal.setType(extensionAks.getType());
            }

        }

        return retVal;
    }

    private static ApiClusterImageAks toDal(ClusterImageAks imageAks) {
        ApiClusterImageAks retVal = null;

        if (imageAks != null) {
            retVal = new ApiClusterImageAks();

            if (imageAks.isMarketplaceSet()) {
                retVal.setMarketplace(toDal(imageAks.getMarketplace()));
            }
        }

        return retVal;
    }

    private static ApiClusterMarketplaceAks toDal(ClusterMarketplaceAks marketplaceAks) {
        ApiClusterMarketplaceAks retVal = null;

        if (marketplaceAks != null) {
            retVal = new ApiClusterMarketplaceAks();

            if (marketplaceAks.isOfferSet()) {
                retVal.setOffer(marketplaceAks.getOffer());
            }

            if (marketplaceAks.isPublisherSet()) {
                retVal.setPublisher(marketplaceAks.getPublisher());
            }

            if (marketplaceAks.isSkuSet()) {
                retVal.setSku(marketplaceAks.getSku());
            }

            if (marketplaceAks.isVersioneSet()) {
                retVal.setVersion(marketplaceAks.getVersion());
            }

        }

        return retVal;
    }

    private static ApiClusterLoadBalancersConfigAks toDal(ClusterLoadBalancersConfigAks loadBalancersConfigAks) {
        ApiClusterLoadBalancersConfigAks retVal = null;

        if (loadBalancersConfigAks != null) {
            retVal = new ApiClusterLoadBalancersConfigAks();

            if (loadBalancersConfigAks.isLoadBalancersSet()) {

                if (loadBalancersConfigAks.getLoadBalancers() != null){
                    List<ApiClusterLoadBalancerAks> loadBalancers =
                            loadBalancersConfigAks.getLoadBalancers().stream().map(ClusterConverterAks::toDal)
                                    .collect(Collectors.toList());
                    retVal.setLoadBalancers(loadBalancers);
                }
                else{
                    retVal.setLoadBalancers(null);

                }
            }
        }

        return retVal;
    }

    private static ApiClusterLoadBalancerAks toDal(ClusterLoadBalancerAks loadBalancerAks) {
        ApiClusterLoadBalancerAks retVal = null;

        if (loadBalancerAks != null) {
            retVal = new ApiClusterLoadBalancerAks();

            if (loadBalancerAks.isBackendPoolNamesSet()) {

                if (loadBalancerAks.getBackendPoolNames() == null) {
                    retVal.setBackendPoolNames(null);
                }
                else {
                    retVal.setBackendPoolNames(new LinkedList<>(loadBalancerAks.getBackendPoolNames()));
                }
            }

            if (loadBalancerAks.isLoadBalancerSkuSet()) {
                retVal.setLoadBalancerSku(loadBalancerAks.getLoadBalancerSku());
            }
            if (loadBalancerAks.isNameSet()) {
                retVal.setName(loadBalancerAks.getName());
            }
            if (loadBalancerAks.isResourceGroupNameSet()) {
                retVal.setResourceGroupName(loadBalancerAks.getResourceGroupName());
            }
            if (loadBalancerAks.isTypeSet()) {
                retVal.setType(loadBalancerAks.getType());
            }
        }

        return retVal;
    }

    private static ApiClusterLoginAks toDal(ClusterLoginAks loginAks){
        ApiClusterLoginAks retVal = null;

        if (loginAks != null){
            retVal = new ApiClusterLoginAks();

            if (loginAks.isSshPublicKeySet()){
                retVal.setSshPublicKey(loginAks.getSshPublicKey());
            }

            if (loginAks.isUserNameSet()){
                retVal.setUserName(loginAks.getUserName());
            }
        }
        return retVal;
    }

    private static ApiClusterNetworkAks toDal(ClusterNetworkAks networkAks){
        ApiClusterNetworkAks retVal = null;

        if (networkAks != null){
            retVal = new ApiClusterNetworkAks();

            if (networkAks.isNetworkInterfacesSet()){

                if (networkAks.getNetworkInterfaces() != null){
                    List<ApiClusterNetworkInterfaceAks> networks =
                            networkAks.getNetworkInterfaces().stream().map(ClusterConverterAks::toDal)
                                    .collect(Collectors.toList());
                    retVal.setNetworkInterfaces(networks);
                }
                else{
                    retVal.setNetworkInterfaces(null);
                }
            }

            if (networkAks.isResourceGroupNameSet()){
                retVal.setResourceGroupName(networkAks.getResourceGroupName());
            }

            if (networkAks.isVirtualNetworkNameSet()){
                retVal.setVirtualNetworkName(networkAks.getVirtualNetworkName());
            }
        }
        return retVal;

    }

    private static ApiClusterNetworkInterfaceAks toDal(ClusterNetworkInterfaceAks networkInterfaceAks){
        ApiClusterNetworkInterfaceAks retVal = null;

        if (networkInterfaceAks != null){
            retVal = new ApiClusterNetworkInterfaceAks();

            if (networkInterfaceAks.isAssignPublicIpSet()){
                retVal.setAssignPublicIp(networkInterfaceAks.getAssignPublicIp());
            }

            if (networkInterfaceAks.isEnableIPForwardingSet()){
                retVal.setEnableIPForwarding(networkInterfaceAks.getEnableIPForwarding());
            }

            if (networkInterfaceAks.isIsPrimarySet()){
                retVal.setIsPrimary(networkInterfaceAks.getIsPrimary());
            }

            if (networkInterfaceAks.isSecurityGroupSet()){
                retVal.setSecurityGroup(toDal(networkInterfaceAks.getSecurityGroup()));
            }

            if (networkInterfaceAks.isSubnetNameSet()){
                retVal.setSubnetName(networkInterfaceAks.getSubnetName());
            }

            if (networkInterfaceAks.isPublicIpSkuSet()){
                retVal.setPublicIpSku(networkInterfaceAks.getPublicIpSku());
            }

            if (networkInterfaceAks.isAdditionalIpConfigurationsSet()){

                if (networkInterfaceAks.getAdditionalIpConfigurations() != null){
                    List<ApiClusterAdditionalIpConfigurationsAks> configurationsAks = networkInterfaceAks.getAdditionalIpConfigurations().stream().map(ClusterConverterAks::toDal).collect(Collectors.toList());
                    retVal.setAdditionalIpConfigurations(configurationsAks);
                }
                else{
                    retVal.setAdditionalIpConfigurations(null);
                }
            }
        }
        return retVal;
    }

    private static ApiClusterSecurityGroupAks toDal(ClusterSecurityGroupAks securityGroupAks) {
        ApiClusterSecurityGroupAks retVal = null;

        if (securityGroupAks != null) {
            retVal = new ApiClusterSecurityGroupAks();

            if (securityGroupAks.isNameSet()){
                retVal.setName(securityGroupAks.getName());
            }

            if (securityGroupAks.isResourceGroupNameSet()){
                retVal.setResourceGroupName(securityGroupAks.getResourceGroupName());
            }
        }
        return retVal;
    }

    private static ApiClusterOsDiskAks toDal(ClusterOsDiskAks clusterOsDiskAks){
        ApiClusterOsDiskAks retVal = null;

        if(clusterOsDiskAks != null){
            retVal = new ApiClusterOsDiskAks();

            if (clusterOsDiskAks.isSizeGBSet()){
                retVal.setSizeGB(clusterOsDiskAks.getSizeGB());
            }
        }
        return retVal;
    }

    private static ApiClusterAdditionalIpConfigurationsAks toDal(ClusterAdditionalIpConfigurationsAks additionalIpConfigurationsAks){
        ApiClusterAdditionalIpConfigurationsAks retVal = null;

        if (additionalIpConfigurationsAks != null){
            retVal = new ApiClusterAdditionalIpConfigurationsAks();

            if (additionalIpConfigurationsAks.isNameSet()){
                retVal.setName(additionalIpConfigurationsAks.getName());
            }
        }
        return retVal;
    }

    private static ApiClusterMsiAks toDal(ClusterMsiAks msiAks){
            ApiClusterMsiAks retVal = null;

        if (msiAks != null) {
            retVal = new ApiClusterMsiAks();

            if (msiAks.isNameSet()) {
                retVal.setName(msiAks.getName());
            }

            if (msiAks.isResourceGroupNameSet()){
                retVal.setResourceGroupName(msiAks.getResourceGroupName());
            }
        }

        return retVal;
    }

    private static ApiClusterTagAks toDal(ClusterTagAks tag){
        ApiClusterTagAks retVal = null;

        if (tag != null){
            retVal = new ApiClusterTagAks();

            if (tag.isTagKeySet()){
                retVal.setTagKey(tag.getTagKey());
            }

            if (tag.isTagValueSet()){
                retVal.setTagValue(tag.getTagValue());
            }
        }
        return retVal;
    }

    public static ApiAksDetachInstances toDal(AksDetachInstances detachInstances) {
        ApiAksDetachInstances retval = null;

        if (detachInstances != null) {
            retval = new ApiAksDetachInstances();

            if (detachInstances.isVmsToDetachSet()) {
                retval.setVmsToDetach(detachInstances.getVmsToDetach());
            }
        }

        return retval;
    }

    public static ApiAksInitiateRoll toDal(AksInitiateRoll initiateRollRequest) {
        ApiAksInitiateRoll retval = null;

        if (initiateRollRequest != null) {
            retval = new ApiAksInitiateRoll();

            if (initiateRollRequest.isBatchSizePercentageSet()) {
                retval.setBatchSizePercentage(initiateRollRequest.getBatchSizePercentage());
            }

            if (initiateRollRequest.isCommentSet()) {
                retval.setComment(initiateRollRequest.getComment());
            }

            if (initiateRollRequest.isVmNamesSet() && initiateRollRequest.getVmNames() != null) {
                retval.setVmNames(initiateRollRequest.getVmNames());
            }

            if (initiateRollRequest.isVirtualNodeGroupIdsSet() && initiateRollRequest.getVirtualNodeGroupIds() != null) {
                retval.setVirtualNodeGroupIds(initiateRollRequest.getVirtualNodeGroupIds());
            }
        }

        return retval;
    }

    public static ApiImportOceanClusterAks toDal(ImportOceanClusterAks src) {

        ApiImportOceanClusterAks retVal = null;

        if (src != null) {
            retVal = new ApiImportOceanClusterAks();

            if (src.isAksSet()) {
                retVal.setAks(toDal(src.getAks()));
            }

            if (src.isControllerClusterIdSet()) {
                retVal.setControllerClusterId(src.getControllerClusterId());
            }

            if (src.isNameSet()) {
                retVal.setName(src.getName());
            }

            if (src.isVirtualNodeGroupTemplateSet()) {
                retVal.setVirtualNodeGroupTemplate(toDal(src.getVirtualNodeGroupTemplate()));
            }

            if (src.isIdSet()){
                retVal.setId(src.getId());
            }

            if (src.isAutoScalerSet()) {
                retVal.setAutoScaler(toDal(src.getAutoScaler()));
            }

            if (src.isStrategySet()) {
                retVal.setStrategy(toDal(src.getStrategy()));
            }

            if (src.isHealthSet()) {
                retVal.setHealth(toDal(src.getHealth()));
            }

        }

        return retVal;
    }

    private static ApiImportClusterVirtualNodeGroupTemplate toDal(ImportClusterVirtualNodeGroupTemplate virtualNodeGroupTemplateAks) {

        ApiImportClusterVirtualNodeGroupTemplate retVal = null;

        if (virtualNodeGroupTemplateAks != null) {
            retVal = new ApiImportClusterVirtualNodeGroupTemplate();
            if (virtualNodeGroupTemplateAks.isVmSizesSet()) {
                retVal.setVmSizes(toDal(virtualNodeGroupTemplateAks.getVmSizes()));
            }
            if (virtualNodeGroupTemplateAks.isZonesSet()) {
                retVal.setZones(virtualNodeGroupTemplateAks.getZones());
            }
        }

        return retVal;
    }

    private static ApiImportClusterWhitelist toDal(ImportClusterWhitelist whitelist) {

        ApiImportClusterWhitelist retVal = null;

        if (whitelist != null) {
            retVal = new ApiImportClusterWhitelist();
            if (whitelist.isWhitelistSet()) {
                retVal.setWhitelist(whitelist.getWhitelist());
            }
        }

        return retVal;
    }

    private static ApiImportClusterAutoScalerConfiguration toDal(ImportClusterAutoScalerConfiguration autoScale) {

        ApiImportClusterAutoScalerConfiguration retVal = null;

        if (autoScale != null) {
            retVal = new ApiImportClusterAutoScalerConfiguration();

            if (autoScale.isIsEnabledSet()) {
                retVal.setIsEnabled(autoScale.getIsEnabled());
            }
            if (autoScale.isResourceLimits()) {
                retVal.setResourceLimits(toDal(autoScale.getResourceLimits()));
            }
            if (autoScale.isDownSet()) {
                retVal.setDown(toDal(autoScale.getDown()));
            }
            if (autoScale.isHeadroomSet()) {
                retVal.setHeadroom(toDal(autoScale.getHeadroom()));
            }
        }

        return retVal;
    }

    private static ApiImportClusterResourceLimitsSpecification toDal(ImportClusterResourceLimitsSpecification resourceLimits) {

        ApiImportClusterResourceLimitsSpecification retVal = null;

        if (resourceLimits != null) {
            retVal = new ApiImportClusterResourceLimitsSpecification();

            if (resourceLimits.isMaxVCpuSet()) {
                retVal.setMaxVCpu(resourceLimits.getMaxVCpu());
            }
            if (resourceLimits.isMaxMemoryGibSet()) {
                retVal.setMaxMemoryGib(resourceLimits.getMaxMemoryGib());
            }

        }

        return retVal;
    }

    private static ApiImportClusterDownSpecification toDal(ImportClusterDownSpecification down) {

        ApiImportClusterDownSpecification retVal = null;

        if (down != null) {
            retVal = new ApiImportClusterDownSpecification();

            if (down.isMaxScaleDownPercentageSet()) {
                retVal.setMaxScaleDownPercentage(down.getMaxScaleDownPercentage());
            }
        }

        return retVal;
    }

    private static ApiImportClusterHeadroomSpecification toDal(ImportClusterHeadroomSpecification headroom) {

        ApiImportClusterHeadroomSpecification retVal = null;

        if (headroom != null) {
            retVal = new ApiImportClusterHeadroomSpecification();

            if (headroom.isAutomaticSet()) {
                retVal.setAutomatic(toDal(headroom.getAutomatic()));
            }
        }

        return retVal;
    }

    private static ApiImportClusterAutomatic toDal(ImportClusterAutomatic automatic) {

        ApiImportClusterAutomatic retVal = null;

        if (automatic != null) {
            retVal = new ApiImportClusterAutomatic();

            if (automatic.isIsEnabledSet()) {
                retVal.setIsEnabled(automatic.getIsEnabled());
            }
            if (automatic.isPercentageSet()) {
                retVal.setPercentage(automatic.getPercentage());
            }
        }

        return retVal;
    }

    private static ApiImportClusterStrategyConfiguration toDal(ImportClusterStrategyConfiguration strategy) {

        ApiImportClusterStrategyConfiguration retVal = null;

        if (strategy != null) {
            retVal = new ApiImportClusterStrategyConfiguration();

            if (strategy.isSpotPercentageSet()) {
                retVal.setSpotPercentage(strategy.getSpotPercentage());
            }
            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }
        }

        return retVal;
    }

    private static ApiImportClusterHealth toDal(ImportClusterHealth health) {

        ApiImportClusterHealth retVal = null;

        if (health != null) {
            retVal = new ApiImportClusterHealth();

            if (health.isGracePeriodSet()) {
                retVal.setGracePeriod(health.getGracePeriod());
            }
        }

        return retVal;
    }

    //DAL -> BL

    public static OceanClusterAks toBl(ApiClusterAks src) {

        OceanClusterAks retVal = null;

        if (src != null) {
            OceanClusterAks.Builder builder = OceanClusterAks.Builder.get();

            if (src.isAksSet()) {
                builder.setAks(toBl(src.getAks()));
            }

            if (src.isControllerClusterIdSet()) {
                builder.setControllerClusterId(src.getControllerClusterId());
            }

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }

            if (src.isVirtualNodeGroupTemplateSet()) {
                builder.setVirtualNodeGroupTemplate(toBl(src.getVirtualNodeGroupTemplate()));
            }

            if (src.isIdSet()){
                builder.setId(src.getId());
            }

            retVal = builder.build();

        }
        return retVal;
    }

    private static ClusterConfigurationAks toBl(ApiClusterConfigurationAks aks) {
        ClusterConfigurationAks retVal = null;

        if (aks != null) {
            ClusterConfigurationAks.Builder builder = ClusterConfigurationAks.Builder.get();

            if (aks.isNameSet()) {
                builder.setName(aks.getName());
            }

            if (aks.isResourceGroupNameSet()) {
                builder.setResourceGroupName(aks.getResourceGroupName());
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static ClusterVirtualNodeGroupTemplateAks toBl(ApiClusterVirtualNodeGroupTemplateAks virtualNodeGroupTemplateAks) {
        ClusterVirtualNodeGroupTemplateAks retVal = null;

        if (virtualNodeGroupTemplateAks != null) {

            ClusterVirtualNodeGroupTemplateAks.Builder builder = ClusterVirtualNodeGroupTemplateAks.Builder.get();

            if (virtualNodeGroupTemplateAks.isLaunchSpecificationSet()) {
                builder.setLaunchSpecification(toBl(virtualNodeGroupTemplateAks.getLaunchSpecification()));
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ClusterLaunchSpecificationAks toBl(ApiClusterLaunchSpecificationAks launchSpecificationAks) {

        ClusterLaunchSpecificationAks retVal = null;

        if (launchSpecificationAks != null) {

            ClusterLaunchSpecificationAks.Builder builder = ClusterLaunchSpecificationAks.Builder.get();

            if (launchSpecificationAks.isExtensionsSet()) {
                if (launchSpecificationAks.getExtensions() != null){

                    List<ClusterExtensionAks> extensions =
                            launchSpecificationAks.getExtensions().stream().map(ClusterConverterAks::toBl)
                                    .collect(Collectors.toList());
                    builder.setExtensions(extensions);
                }
                else{
                    builder.setExtensions(null);
                }
            }

            if (launchSpecificationAks.isImageSet()) {
                builder.setImage(toBl(launchSpecificationAks.getImage()));
            }

            if (launchSpecificationAks.isLoadBalancersConfigSet()){
                builder.setLoadBalancersConfig(toBl(launchSpecificationAks.getLoadBalancersConfig()));
            }

            if (launchSpecificationAks.isLoginSet()){
                builder.setLogin(toBl(launchSpecificationAks.getLogin()));
            }

            if (launchSpecificationAks.isNetworkSet()){
                builder.setNetwork(toBl(launchSpecificationAks.getNetwork()));
            }

            if (launchSpecificationAks.isOsDiskSet()){
                builder.setOsDisk(toBl(launchSpecificationAks.getOsDisk()));
            }

            if (launchSpecificationAks.isResourceGroupNameSet()){
                builder.setResourceGroupName(launchSpecificationAks.getResourceGroupName());
            }

            if (launchSpecificationAks.isTagsSet()){

                if (launchSpecificationAks.getTags() != null){
                List<ClusterTagAks> tags = launchSpecificationAks.getTags().stream()
                        .map(ClusterConverterAks::toBl).collect(Collectors.toList());

                builder.setTags(tags);
                }
                else {
                    builder.setTags(null);

                }
            }
            if (launchSpecificationAks.isManagedServiceIdentitiesSet()) {

                if (launchSpecificationAks.getManagedServiceIdentities() != null){
                    List<ClusterMsiAks> managedServiceIdentities = launchSpecificationAks.getManagedServiceIdentities().stream()
                                                                                         .map(ClusterConverterAks::toBl).collect(Collectors.toList());
                    builder.setManagedServiceIdentities(managedServiceIdentities);
                }
                else {
                    builder.setTags(null);
                }
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static ClusterExtensionAks toBl(ApiClusterExtensionAks extensionAks) {
        ClusterExtensionAks retVal = null;

        if (extensionAks != null) {
            ClusterExtensionAks.Builder builder = ClusterExtensionAks.Builder.get();

            if (extensionAks.isApiVersionSet()) {
                builder.setApiVersion(extensionAks.getApiVersion());
            }

            if (extensionAks.isMinorVersionAutoUpgradeSet()) {
                builder.setMinorVersionAutoUpgrade(extensionAks.getMinorVersionAutoUpgrade());
            }

            if (extensionAks.isNameSet()){
                builder.setName(extensionAks.getName());
            }

            if (extensionAks.isPublisherSet()){
                builder.setName(extensionAks.getPublisher());
            }

            if (extensionAks.isTypeSet()){
                builder.setName(extensionAks.getType());
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static ClusterImageAks toBl(ApiClusterImageAks imageAks) {
        ClusterImageAks retVal = null;

        if (imageAks != null) {
            ClusterImageAks.Builder builder = ClusterImageAks.Builder.get();

            if (imageAks.isMarketplaceSet()) {
                builder.setMarketplace(toBl(imageAks.getMarketplace()));
            }

            retVal = builder.build();
        }

        return retVal;
    }

    private static ClusterMarketplaceAks toBl(ApiClusterMarketplaceAks marketplaceAks) {
        ClusterMarketplaceAks retVal = null;

        if (marketplaceAks != null) {
            ClusterMarketplaceAks.Builder builder = ClusterMarketplaceAks.Builder.get();

            if (marketplaceAks.isOfferSet()) {
                builder.setOffer(marketplaceAks.getOffer());
            }

            if (marketplaceAks.isPublisherSet()) {
                builder.setPublisher(marketplaceAks.getPublisher());
            }

            if (marketplaceAks.isSkuSet()) {
                builder.setSku(marketplaceAks.getSku());
            }
            if (marketplaceAks.isVersioneSet()) {
                builder.setVersion(marketplaceAks.getVersion());
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static ClusterLoadBalancersConfigAks toBl(ApiClusterLoadBalancersConfigAks loadBalancersConfigAks) {
        ClusterLoadBalancersConfigAks retVal = null;

        if (loadBalancersConfigAks != null) {
            ClusterLoadBalancersConfigAks.Builder builder = ClusterLoadBalancersConfigAks.Builder.get();

            if (loadBalancersConfigAks.isLoadBalancersSet()) {

                if (loadBalancersConfigAks.getLoadBalancers() != null){
                    List<ClusterLoadBalancerAks> loadBalancers =
                            loadBalancersConfigAks.getLoadBalancers().stream().map(ClusterConverterAks::toBl)
                                    .collect(Collectors.toList());
                    builder.setLoadBalancers(loadBalancers);
                }
                else{
                    builder.setLoadBalancers(null);

                }
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ClusterLoadBalancerAks toBl(ApiClusterLoadBalancerAks loadBalancerAks) {
        ClusterLoadBalancerAks retVal = null;

        if (loadBalancerAks != null) {
            ClusterLoadBalancerAks.Builder builder = ClusterLoadBalancerAks.Builder.get();

            if (loadBalancerAks.isBackendPoolNamesSet()) {

                if (loadBalancerAks.getBackendPoolNames() == null) {
                    builder.setBackendPoolNames(null);
                }
                else {
                    builder.setBackendPoolNames(new LinkedList<>(loadBalancerAks.getBackendPoolNames()));
                }
            }
            if (loadBalancerAks.isLoadBalancerSkuSet()) {
                builder.setLoadBalancerSku(loadBalancerAks.getLoadBalancerSku());
            }
            if (loadBalancerAks.isNameSet()) {
                builder.setName(loadBalancerAks.getName());
            }
            if (loadBalancerAks.isResourceGroupNameSet()) {
                builder.setResourceGroupName(loadBalancerAks.getResourceGroupName());
            }
            if (loadBalancerAks.isTypeSet()) {
                builder.setType(loadBalancerAks.getType());
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ClusterLoginAks toBl(ApiClusterLoginAks loginAks){
        ClusterLoginAks retVal = null;

        if (loginAks != null){
            ClusterLoginAks.Builder builder = ClusterLoginAks.Builder.get();

            if (loginAks.isSshPublicKeySet()){
                builder.setSshPublicKey(loginAks.getSshPublicKey());
            }

            if (loginAks.isUserNameSet()){
                builder.setUserName(loginAks.getUserName());
            }
            retVal = builder.build();
        }
        return retVal;
    }

    private static ClusterNetworkAks toBl(ApiClusterNetworkAks networkAks){
        ClusterNetworkAks retVal = null;

        if (networkAks != null){
            ClusterNetworkAks.Builder builder = ClusterNetworkAks.Builder.get();

            if (networkAks.isNetworkInterfacesSet()){

                if (networkAks.getNetworkInterfaces() != null){
                    List<ClusterNetworkInterfaceAks> networks =
                            networkAks.getNetworkInterfaces().stream().map(ClusterConverterAks::toBl)
                                    .collect(Collectors.toList());
                    builder.setNetworkInterfaces(networks);
                }
                else{
                    builder.setNetworkInterfaces(null);
                }
            }

            if (networkAks.isResourceGroupNameSet()){
                builder.setResourceGroupName(networkAks.getResourceGroupName());
            }

            if (networkAks.isVirtualNetworkNameSet()){
                builder.setVirtualNetworkName(networkAks.getVirtualNetworkName());
            }
            retVal = builder.build();
        }
        return retVal;

    }

    private static ClusterNetworkInterfaceAks toBl(ApiClusterNetworkInterfaceAks networkInterfaceAks){
        ClusterNetworkInterfaceAks retVal = null;

        if (networkInterfaceAks != null){

            ClusterNetworkInterfaceAks.Builder builder = ClusterNetworkInterfaceAks.Builder.get();

            if (networkInterfaceAks.isAssignPublicIpSet()){
                builder.setAssignPublicIp(networkInterfaceAks.getAssignPublicIp());
            }

            if (networkInterfaceAks.isEnableIPForwardingSet()){
                builder.setEnableIPForwarding(networkInterfaceAks.getEnableIPForwarding());
            }

            if (networkInterfaceAks.isIsPrimarySet()){
                builder.setIsPrimary(networkInterfaceAks.getIsPrimary());
            }

            if (networkInterfaceAks.isSecurityGroupSet()){
                builder.setSecurityGroup(toBl(networkInterfaceAks.getSecurityGroup()));

            }

            if (networkInterfaceAks.isSubnetNameSet()){
                builder.setSubnetName(networkInterfaceAks.getSubnetName());
            }

            if (networkInterfaceAks.isPublicIpSkuSet()){
                builder.setPublicIpSku(networkInterfaceAks.getPublicIpSku());
            }

            if (networkInterfaceAks.isAdditionalIpConfigurationsSet()){
                if (networkInterfaceAks.getAdditionalIpConfigurations() != null){

                    List<ClusterAdditionalIpConfigurationsAks> configurationsAks = networkInterfaceAks.getAdditionalIpConfigurations().stream().map(ClusterConverterAks::toBl).collect(Collectors.toList());
                    builder.setAdditionalIpConfigurations(configurationsAks);
                }
                else {
                    builder.setAdditionalIpConfigurations(null);
                }
            }

            retVal = builder.build();
        }
        return retVal;
    }

    private static ClusterSecurityGroupAks toBl(ApiClusterSecurityGroupAks securityGroupAks) {
        ClusterSecurityGroupAks retVal = null;

        if (securityGroupAks != null) {

            ClusterSecurityGroupAks.Builder builder = ClusterSecurityGroupAks.Builder.get();

            if (securityGroupAks.isNameSet()){
                builder.setName(securityGroupAks.getName());
            }

            if (securityGroupAks.isResourceGroupNameSet()){
                builder.setResourceGroupName(securityGroupAks.getResourceGroupName());
            }
            retVal = builder.build();
        }
        return retVal;
    }

    private static ClusterOsDiskAks toBl(ApiClusterOsDiskAks osDiskAks){
        ClusterOsDiskAks retVal = null;

        if (osDiskAks != null) {
            ClusterOsDiskAks.Builder builder = ClusterOsDiskAks.Builder.get();

            if (osDiskAks.isSizeGBSet()) {
                builder.setSizeGB(osDiskAks.getSizeGB());
            }

            retVal = builder.build();
        }

        return retVal;

    }

    private static ClusterAdditionalIpConfigurationsAks toBl(ApiClusterAdditionalIpConfigurationsAks additionalIpConfigurationsAks){
        ClusterAdditionalIpConfigurationsAks retVal = null;

        if (additionalIpConfigurationsAks != null){
            ClusterAdditionalIpConfigurationsAks.Builder builder = ClusterAdditionalIpConfigurationsAks.Builder.get();

            if (additionalIpConfigurationsAks.isNameSet()){
                builder.setName(additionalIpConfigurationsAks.getName());
            }
            retVal = builder.build();
        }
        return retVal;
    }

    private static ClusterTagAks toBl(ApiClusterTagAks tag){
        ClusterTagAks retVal = null;

        if (tag != null){

            ClusterTagAks.Builder builder = ClusterTagAks.Builder.get();
            if (tag.isTagKeySet()){

                builder.setTagKey(tag.getTagKey());
                }

            if (tag.isTagValueSet()){
                builder.setTagValue(tag.getTagValue());
                }

                retVal = builder.build();
            }
        return retVal;
    }

    private static ClusterMsiAks toBl(ApiClusterMsiAks msiAks){
        ClusterMsiAks retVal = null;

        if (msiAks != null){

            ClusterMsiAks.Builder builder = ClusterMsiAks.Builder.get();
            if (msiAks.isNameSet()){

                builder.setName(msiAks.getName());
                }

            if (msiAks.isResourceGroupNameSet()){
                builder.setResourceGroupName(msiAks.getResourceGroupName());
                }

                retVal = builder.build();
            }
        return retVal;
    }

    public static GetAzureAksClusterHeartBeatStatusResponse toBl(
            ApiGetAzureAksClusterHeartBeatStatusResponse clusterHeartBeatStatus) {
        GetAzureAksClusterHeartBeatStatusResponse retVal = null;

        if (clusterHeartBeatStatus != null) {
            retVal = new GetAzureAksClusterHeartBeatStatusResponse();

            if (clusterHeartBeatStatus.isStatusSet()) {
                retVal.setStatus(clusterHeartBeatStatus.getStatus());
            }
            if (clusterHeartBeatStatus.isLastHeartbeatSet()) {
                retVal.setLastHeartbeat(clusterHeartBeatStatus.getLastHeartbeat());
            }

        }

        return retVal;
    }

    public static GetAksClusterNodesResponse toBl(ApiGetAksClusterNodesResponse apiClusterNodes) {
        GetAksClusterNodesResponse retVal = null;

        if (apiClusterNodes != null) {
            GetAksClusterNodesResponse.Builder instancesBuilder = GetAksClusterNodesResponse.Builder.get();

            if (apiClusterNodes.isLifeCycleSet()) {
                instancesBuilder.setLifeCycle(apiClusterNodes.getLifeCycle());
            }

            if (apiClusterNodes.isPublicIpSet()) {
                instancesBuilder.setPublicIp(apiClusterNodes.getPublicIp());
            }

            if (apiClusterNodes.isWorkloadRequestedMilliCpuSet()) {
                instancesBuilder.setWorkloadRequestedMilliCpu(apiClusterNodes.getWorkloadRequestedMilliCpu());
            }

            if (apiClusterNodes.isWorkloadRequestedMemoryInMiBSet()) {
                instancesBuilder.setWorkloadRequestedMemoryInMiB(apiClusterNodes.getWorkloadRequestedMemoryInMiB());
            }

            if (apiClusterNodes.isWorkloadRequestedGpuSet()) {
                instancesBuilder.setWorkloadRequestedGpu(apiClusterNodes.getWorkloadRequestedGpu());
            }

            if (apiClusterNodes.isHeadroomRequestedMilliCpuSet()) {
                instancesBuilder.setHeadroomRequestedMilliCpu(apiClusterNodes.getHeadroomRequestedMilliCpu());
            }

            if (apiClusterNodes.isHeadroomRequestedMilliCpuSet()) {
                instancesBuilder.setHeadroomRequestedMilliCpu(apiClusterNodes.getHeadroomRequestedMilliCpu());
            }

            if (apiClusterNodes.isHeadroomRequestedGpuSet()) {
                instancesBuilder.setHeadroomRequestedGpu(apiClusterNodes.getHeadroomRequestedGpu());
            }

            if (apiClusterNodes.isHeadroomRequestedMemoryInMiBSet()) {
                instancesBuilder.setHeadroomRequestedMemoryInMiB(apiClusterNodes.getHeadroomRequestedMemoryInMiB());
            }

            if (apiClusterNodes.isAllocatableMilliCpuSet()) {
                instancesBuilder.setAllocatableMilliCpu(apiClusterNodes.getAllocatableMilliCpu());
            }

            if (apiClusterNodes.isAllocatableMemoryInMiBSet()) {
                instancesBuilder.setAllocatableMemoryInMiB(apiClusterNodes.getAllocatableMemoryInMiB());
            }

            if (apiClusterNodes.isAllocatableGpuSet()) {
                instancesBuilder.setAllocatableGpu(apiClusterNodes.getAllocatableGpu());
            }

            if (apiClusterNodes.isNodeNameSet()) {
                instancesBuilder.setNodeName(apiClusterNodes.getNodeName());
            }

            if (apiClusterNodes.isRegistrationStatusSet()) {
                instancesBuilder.setRegistrationStatus(apiClusterNodes.getRegistrationStatus());
            }

            if (apiClusterNodes.isCreatedAtSet()) {
                instancesBuilder.setCreatedAt(apiClusterNodes.getCreatedAt());
            }

            if (apiClusterNodes.isVmNameSet()) {
                instancesBuilder.setVmName(apiClusterNodes.getVmName());
            }

            if (apiClusterNodes.isVmSizeSet()) {
                instancesBuilder.setVmSize(apiClusterNodes.getVmSize());
            }

            if (apiClusterNodes.isAvailabilityZoneSet()) {
                instancesBuilder.setAvailabilityZone(apiClusterNodes.getAvailabilityZone());
            }

            if (apiClusterNodes.isVirtualNodeGroupIdSet()) {
                instancesBuilder.setVirtualNodeGroupId(apiClusterNodes.getVirtualNodeGroupId());
            }

            if (apiClusterNodes.isVirtualNodeGroupNameSet()) {
                instancesBuilder.setVirtualNodeGroupName(apiClusterNodes.getVirtualNodeGroupName());
            }

            retVal = instancesBuilder.build();
        }

        return retVal;
    }

    public static AksDetachInstancesResponse toBl(ApiAksDetachInstancesResponse apiDetachVms) {
        AksDetachInstancesResponse retVal = null;

        if (apiDetachVms != null) {
            AksDetachInstancesResponse.Builder vmsBuilder = AksDetachInstancesResponse.Builder.get();

            if (apiDetachVms.isDetachedVmsSet()) {
                List<DetachedVms> vms = apiDetachVms.getDetachedVms().stream().map(ClusterConverterAks::toBl)
                                .collect(Collectors.toList());
                vmsBuilder.setDetachedVms(vms);
            }

            retVal = vmsBuilder.build();
        }

        return retVal;
    }

    private static DetachedVms toBl(ApiDetachedVms apiDetachedvms){
        DetachedVms retVal = null;

        if (apiDetachedvms != null){

            DetachedVms.Builder builder = DetachedVms.Builder.get();

            if (apiDetachedvms.isVmNameSet()){
                builder.setVmName(apiDetachedvms.getVmName());
            }

            retVal = builder.build();
        }
        return retVal;
    }

    public static AksClusterRollResponse toBl(ApiAksClusterRollResponse initiateRollResponse) {
        AksClusterRollResponse retVal = null;

        if (initiateRollResponse != null) {
            AksClusterRollResponse.Builder responseBuilder = AksClusterRollResponse.Builder.get();

            if (initiateRollResponse.isIdSet()) {
                responseBuilder.setId(initiateRollResponse.getId());
            }

            if (initiateRollResponse.isStatusSet()) {
                responseBuilder.setStatus(initiateRollResponse.getStatus());
            }

            if (initiateRollResponse.isCurrentBatchSet()) {
                responseBuilder.setCurrentBatch(initiateRollResponse.getCurrentBatch());
            }

            if (initiateRollResponse.isNumOfBatchesSet()) {
                responseBuilder.setNumOfBatches(initiateRollResponse.getNumOfBatches());
            }

            if (initiateRollResponse.isCommentSet()) {
                responseBuilder.setComment(initiateRollResponse.getComment());
            }

            if (initiateRollResponse.isProgressSet()) {
                responseBuilder.setProgress(toBl(initiateRollResponse.getProgress()));
            }

            if (initiateRollResponse.isOceanIdSet()) {
                responseBuilder.setOceanId(initiateRollResponse.getOceanId());
            }

            if (initiateRollResponse.isVmNamesSet()) {
                responseBuilder.setVmNames(initiateRollResponse.getVmNames());
            }

            if (initiateRollResponse.isVirtualNodeGroupIdsSet()) {
                responseBuilder.setVirtualNodeGroupIds(initiateRollResponse.getVirtualNodeGroupIds());
            }

            if (initiateRollResponse.isCreatedAtSet()) {
                responseBuilder.setCreatedAt(initiateRollResponse.getCreatedAt());
            }

            if (initiateRollResponse.isUpdatedAtSet()) {
                responseBuilder.setUpdatedAt(initiateRollResponse.getUpdatedAt());
            }
            retVal = responseBuilder.build();
        }

        return retVal;
    }

    public static AksInitiateRollResponseOldVms toBl(ApiAksInitiateRollResponseOldVms oldVms) {
        AksInitiateRollResponseOldVms retVal = null;

        if (oldVms != null) {
            AksInitiateRollResponseOldVms.Builder instancesBuilder = AksInitiateRollResponseOldVms.Builder.get();

            if (oldVms.isVmNameSet()) {
                instancesBuilder.setVmName(oldVms.getVmName());
            }

            if (oldVms.isStatusSet()) {
                instancesBuilder.setStatus(oldVms.getStatus());
            }

            retVal = instancesBuilder.build();
        }

        return retVal;
    }

    public static AksInitiateRollDetailedStatus toBl(ApiAksInitiateRollDetailedStatus detailedStatus) {
        AksInitiateRollDetailedStatus retVal = null;

        if (detailedStatus != null) {
            AksInitiateRollDetailedStatus.Builder detailedStatusBuilder = AksInitiateRollDetailedStatus.Builder.get();

            if (detailedStatus.isOldVmsSet()) {

                List<AksInitiateRollResponseOldVms> vmsList =
                        detailedStatus.getOldVms().stream().map(ClusterConverterAks::toBl)
                                .collect(Collectors.toList());
                detailedStatusBuilder.setOldVms(vmsList);
            }

            retVal = detailedStatusBuilder.build();
        }

        return retVal;
    }

    public static AksInitiateRollProgress toBl(ApiAksInitiateRollProgress progress) {
        AksInitiateRollProgress retVal = null;

        if (progress != null) {
            AksInitiateRollProgress.Builder progressBuilder = AksInitiateRollProgress.Builder.get();

            if (progress.isUnitSet()) {
                progressBuilder.setUnit(progress.getUnit());
            }

            if (progress.isValueSet()) {
                progressBuilder.setValue(progress.getValue());
            }

            if (progress.isDetailedStatusSet()) {
                progressBuilder.setDetailedStatus(toBl(progress.getDetailedStatus()));
            }

            retVal = progressBuilder.build();
        }

        return retVal;
    }

    public static ImportOceanClusterAksResponse toBl(ApiImportOceanClusterAksResponse src) {

        ImportOceanClusterAksResponse retVal = null;

        if (src != null) {
            ImportOceanClusterAksResponse.Builder builder = ImportOceanClusterAksResponse.Builder.get();

            if (src.isAksSet()) {
                builder.setAks(toBl(src.getAks()));
            }

            if (src.isControllerClusterIdSet()) {
                builder.setControllerClusterId(src.getControllerClusterId());
            }

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }

            if (src.isVirtualNodeGroupTemplateSet()) {
                builder.setVirtualNodeGroupTemplate(toBl(src.getVirtualNodeGroupTemplate()));
            }

            if (src.isIdSet()){
                builder.setId(src.getId());
            }

            if (src.isAutoScalerSet()) {
                builder.setAutoScaler(toBl(src.getAutoScaler()));
            }

            if (src.isStrategySet()) {
                builder.setStrategy(toBl(src.getStrategy()));
            }

            if (src.isHealthSet()) {
                builder.setHealth(toBl(src.getHealth()));
            }

            if (src.isCreatedAtSet()) {
                builder.setCreatedAt(src.getCreatedAt());
            }

            if (src.isUpdatedAtSet()) {
                builder.setUpdatedAt(src.getUpdatedAt());
            }

            retVal = builder.build();

        }
        return retVal;
    }

    private static ImportClusterVirtualNodeGroupTemplateResponse toBl(ApiImportClusterVirtualNodeGroupTemplateResponse virtualNodeGroupTemplateAks) {

        ImportClusterVirtualNodeGroupTemplateResponse retVal = null;

        if (virtualNodeGroupTemplateAks != null) {
            ImportClusterVirtualNodeGroupTemplateResponse.Builder builder = ImportClusterVirtualNodeGroupTemplateResponse.Builder.get();
            if (virtualNodeGroupTemplateAks.isVmSizesSet()) {
                builder.setVmSizes(toBl(virtualNodeGroupTemplateAks.getVmSizes()));
            }
            if (virtualNodeGroupTemplateAks.isZonesSet()) {
                builder.setZones(virtualNodeGroupTemplateAks.getZones());
            }
            if (virtualNodeGroupTemplateAks.isLaunchSpecificationSet()) {
                builder.setLaunchSpecification(toBl(virtualNodeGroupTemplateAks.getLaunchSpecification()));
            }

            retVal = builder.build();
        }
        return retVal;
    }

    private static ImportClusterLaunchSpecificationAks toBl(ApiImportClusterLaunchSpecificationAks launchSpecificationAks) {

        ImportClusterLaunchSpecificationAks retVal = null;

        if (launchSpecificationAks != null) {

            ImportClusterLaunchSpecificationAks.Builder builder = ImportClusterLaunchSpecificationAks.Builder.get();

            if (launchSpecificationAks.isExtensionsSet()) {
                if (launchSpecificationAks.getExtensions() != null){

                    List<ClusterExtensionAks> extensions =
                            launchSpecificationAks.getExtensions().stream().map(ClusterConverterAks::toBl)
                                    .collect(Collectors.toList());
                    builder.setExtensions(extensions);
                }
                else{
                    builder.setExtensions(null);
                }
            }

            if (launchSpecificationAks.isImageSet()) {
                builder.setImage(toBl(launchSpecificationAks.getImage()));
            }

            if (launchSpecificationAks.isLoadBalancersConfigSet()){
                builder.setLoadBalancersConfig(toBl(launchSpecificationAks.getLoadBalancersConfig()));
            }

            if (launchSpecificationAks.isLoginSet()){
                builder.setLogin(toBl(launchSpecificationAks.getLogin()));
            }

            if (launchSpecificationAks.isNetworkSet()){
                builder.setNetwork(toBl(launchSpecificationAks.getNetwork()));
            }

            if (launchSpecificationAks.isOsDiskSet()){
                builder.setOsDisk(toBl(launchSpecificationAks.getOsDisk()));
            }

            if (launchSpecificationAks.isResourceGroupNameSet()){
                builder.setResourceGroupName(launchSpecificationAks.getResourceGroupName());
            }

            if (launchSpecificationAks.isTagsSet()){

                if (launchSpecificationAks.getTags() != null){
                    List<ClusterTagAks> tags = launchSpecificationAks.getTags().stream()
                            .map(ClusterConverterAks::toBl).collect(Collectors.toList());

                    builder.setTags(tags);
                }
                else {
                    builder.setTags(null);

                }
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static ImportClusterOsDiskAks toBl(ApiImportClusterOsDiskAks osDiskAks){
        ImportClusterOsDiskAks retVal = null;

        if (osDiskAks != null) {
            ImportClusterOsDiskAks.Builder builder = ImportClusterOsDiskAks.Builder.get();

            if (osDiskAks.isSizeGBSet()) {
                builder.setSizeGB(osDiskAks.getSizeGB());
            }

            if (osDiskAks.isTypeSet()) {
                builder.setType(osDiskAks.getType());
            }

            retVal = builder.build();
        }

        return retVal;

    }

    private static ImportClusterLoginAks toBl(ApiImportClusterLoginAks loginAks){
        ImportClusterLoginAks retVal = null;

        if (loginAks != null){
            ImportClusterLoginAks.Builder builder = ImportClusterLoginAks.Builder.get();

            if (loginAks.isUserNameSet()){
                builder.setUserName(loginAks.getUserName());
            }
            retVal = builder.build();
        }
        return retVal;
    }

    private static ImportClusterNetworkAks toBl(ApiImportClusterNetworkAks networkAks){
        ImportClusterNetworkAks retVal = null;

        if (networkAks != null){
            ImportClusterNetworkAks.Builder builder = ImportClusterNetworkAks.Builder.get();

            if (networkAks.isNetworkInterfacesSet()){

                if (networkAks.getNetworkInterfaces() != null){
                    List<ImportClusterNetworkInterfaceAks> networks =
                            networkAks.getNetworkInterfaces().stream().map(ClusterConverterAks::toBl)
                                    .collect(Collectors.toList());
                    builder.setNetworkInterfaces(networks);
                }
                else{
                    builder.setNetworkInterfaces(null);
                }
            }

            if (networkAks.isResourceGroupNameSet()){
                builder.setResourceGroupName(networkAks.getResourceGroupName());
            }

            if (networkAks.isVirtualNetworkNameSet()){
                builder.setVirtualNetworkName(networkAks.getVirtualNetworkName());
            }
            retVal = builder.build();
        }
        return retVal;

    }

    private static ImportClusterNetworkInterfaceAks toBl(ApiImportClusterNetworkInterfaceAks networkInterfaceAks){
        ImportClusterNetworkInterfaceAks retVal = null;

        if (networkInterfaceAks != null){

            ImportClusterNetworkInterfaceAks.Builder builder = ImportClusterNetworkInterfaceAks.Builder.get();

            if (networkInterfaceAks.isAssignPublicIpSet()){
                builder.setAssignPublicIp(networkInterfaceAks.getAssignPublicIp());
            }

            if (networkInterfaceAks.isEnableIPForwardingSet()){
                builder.setEnableIPForwarding(networkInterfaceAks.getEnableIPForwarding());
            }

            if (networkInterfaceAks.isIsPrimarySet()){
                builder.setIsPrimary(networkInterfaceAks.getIsPrimary());
            }

            if (networkInterfaceAks.isSecurityGroupSet()){
                builder.setSecurityGroup(toBl(networkInterfaceAks.getSecurityGroup()));
            }

            if (networkInterfaceAks.isSubnetNameSet()){
                builder.setSubnetName(networkInterfaceAks.getSubnetName());
            }

            if (networkInterfaceAks.isPublicIpSkuSet()){
                builder.setPublicIpSku(networkInterfaceAks.getPublicIpSku());
            }

            if (networkInterfaceAks.isAdditionalIpConfigurationsSet()){
                if (networkInterfaceAks.getAdditionalIpConfigurations() != null){

                    List<ImportClusterAdditionalIpConfigurationsAks> configurationsAks = networkInterfaceAks.getAdditionalIpConfigurations().stream().map(ClusterConverterAks::toBl).collect(Collectors.toList());
                    builder.setAdditionalIpConfigurations(configurationsAks);
                }
                else {
                    builder.setAdditionalIpConfigurations(null);
                }
            }

            retVal = builder.build();
        }
        return retVal;
    }

    private static ImportClusterAdditionalIpConfigurationsAks toBl(ApiImportClusterAdditionalIpConfigurationsAks additionalIpConfigurationsAks){
        ImportClusterAdditionalIpConfigurationsAks retVal = null;

        if (additionalIpConfigurationsAks != null){
            ImportClusterAdditionalIpConfigurationsAks.Builder builder = ImportClusterAdditionalIpConfigurationsAks.Builder.get();

            if (additionalIpConfigurationsAks.isNameSet()){
                builder.setName(additionalIpConfigurationsAks.getName());
            }
            if (additionalIpConfigurationsAks.isPrivateIpAddressVersionSet()){
                builder.setPrivateIpAddressVersion(additionalIpConfigurationsAks.getPrivateIpAddressVersion());
            }
            retVal = builder.build();
        }
        return retVal;
    }

    private static ImportClusterWhitelist toBl(ApiImportClusterWhitelist whitelist) {

        ImportClusterWhitelist retVal = null;

        if (whitelist != null) {
            ImportClusterWhitelist.Builder builder = ImportClusterWhitelist.Builder.get();
            if (whitelist.isWhitelistSet()) {
                builder.setWhitelist(whitelist.getWhitelist());
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ImportClusterAutoScalerConfiguration toBl(ApiImportClusterAutoScalerConfiguration autoScale) {

        ImportClusterAutoScalerConfiguration retVal = null;

        if (autoScale != null) {
            ImportClusterAutoScalerConfiguration.Builder builder = ImportClusterAutoScalerConfiguration.Builder.get();

            if (autoScale.isIsEnabledSet()) {
                builder.setIsEnabled(autoScale.getIsEnabled());
            }
            if (autoScale.isResourceLimits()) {
                builder.setResourceLimits(toBl(autoScale.getResourceLimits()));
            }
            if (autoScale.isDownSet()) {
                builder.setDown(toBl(autoScale.getDown()));
            }
            if (autoScale.isHeadroomSet()) {
                builder.setHeadroom(toBl(autoScale.getHeadroom()));
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ImportClusterResourceLimitsSpecification toBl(ApiImportClusterResourceLimitsSpecification resourceLimits) {

        ImportClusterResourceLimitsSpecification retVal = null;

        if (resourceLimits != null) {
            ImportClusterResourceLimitsSpecification.Builder builder = ImportClusterResourceLimitsSpecification.Builder.get();

            if (resourceLimits.isMaxVCpuSet()) {
                builder.setMaxVCpu(resourceLimits.getMaxVCpu());
            }
            if (resourceLimits.isMaxMemoryGibSet()) {
                builder.setMaxMemoryGib(resourceLimits.getMaxMemoryGib());
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ImportClusterDownSpecification toBl(ApiImportClusterDownSpecification down) {

        ImportClusterDownSpecification retVal = null;

        if (down != null) {
            ImportClusterDownSpecification.Builder builder = ImportClusterDownSpecification.Builder.get();

            if (down.isMaxScaleDownPercentageSet()) {
                builder.setMaxScaleDownPercentage(down.getMaxScaleDownPercentage());
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ImportClusterHeadroomSpecification toBl(ApiImportClusterHeadroomSpecification headroom) {

        ImportClusterHeadroomSpecification retVal = null;

        if (headroom != null) {
            ImportClusterHeadroomSpecification.Builder builder = ImportClusterHeadroomSpecification.Builder.get();

            if (headroom.isAutomaticSet()) {
                builder.setAutomatic(toBl(headroom.getAutomatic()));
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ImportClusterAutomatic toBl(ApiImportClusterAutomatic automatic) {

        ImportClusterAutomatic retVal = null;

        if (automatic != null) {
            ImportClusterAutomatic.Builder builder = ImportClusterAutomatic.Builder.get();

            if (automatic.isIsEnabledSet()) {
                retVal.setIsEnabled(automatic.getIsEnabled());
            }
            if (automatic.isPercentageSet()) {
                retVal.setPercentage(automatic.getPercentage());
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ImportClusterStrategyConfiguration toBl(ApiImportClusterStrategyConfiguration strategy) {

        ImportClusterStrategyConfiguration retVal = null;

        if (strategy != null) {
            ImportClusterStrategyConfiguration.Builder builder = ImportClusterStrategyConfiguration.Builder.get();

            if (strategy.isSpotPercentageSet()) {
                retVal.setSpotPercentage(strategy.getSpotPercentage());
            }
            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }
            retVal = builder.build();
        }

        return retVal;
    }

    private static ImportClusterHealth toBl(ApiImportClusterHealth health) {

        ImportClusterHealth retVal = null;

        if (health != null) {
            ImportClusterHealth.Builder builder = ImportClusterHealth.Builder.get();

            if (health.isGracePeriodSet()) {
                retVal.setGracePeriod(health.getGracePeriod());
            }
            retVal = builder.build();
        }

        return retVal;
    }
}
