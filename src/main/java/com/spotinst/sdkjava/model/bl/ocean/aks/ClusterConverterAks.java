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
}
