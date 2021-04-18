package com.spotinst.sdkjava.model.bl.ocean.aks;


import com.spotinst.sdkjava.model.api.ocean.aks.*;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;



public class ClusterConverterAks {
    //BL -> DAL

    public static ApiClusterAks toDal(ClusterAks src) {

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

    private static ApiVirtualNodeGroupTemplateAks toDal(ClusterVirtualNodeGroupTemplateAks virtualNodeGroupTemplateAks) {

        ApiVirtualNodeGroupTemplateAks retVal = null;

        if (virtualNodeGroupTemplateAks != null) {
            retVal = new ApiVirtualNodeGroupTemplateAks();

            if (virtualNodeGroupTemplateAks.isLaunchSpecificationSet()) {
                retVal.setLaunchSpecification(toDal(virtualNodeGroupTemplateAks.getLaunchSpecification()));
            }
        }

        return retVal;
    }

    private static ApiLaunchSpecificationAks toDal(ClusterLaunchSpecificationAks launchSpecificationAks) {

        ApiLaunchSpecificationAks retVal = null;

        if (launchSpecificationAks != null) {

            retVal = new ApiLaunchSpecificationAks();

            if (launchSpecificationAks.isExtensionsSet()) {
               if (launchSpecificationAks.getExtensions() != null){
                   List<ApiExtensionAks> extensions =
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

            if (launchSpecificationAks.isResourceGroupNameSet()){
                retVal.setResourceGroupName(launchSpecificationAks.getResourceGroupName());
            }

            if (launchSpecificationAks.isTagsSet()){

                if (launchSpecificationAks.getTags() != null){
                    List<ApiTagAks> tags =
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

    private static ApiExtensionAks toDal(ClusterExtensionAks extensionAks) {
        ApiExtensionAks retVal = null;

        if (extensionAks != null) {
            retVal = new ApiExtensionAks();

            if (extensionAks.isApiVersionSet()) {
                retVal.setApiVersion(extensionAks.getApiVersion());
            }

            if (extensionAks.isMinorVersionAutoUpgradeSet()) {
                retVal.setMinorVersionAutoUpgrade(extensionAks.GetMinorVersionAutoUpgrade());
            }

            if (extensionAks.isNameSet()){
                retVal.setName(extensionAks.getName());
            }

            if (extensionAks.isPublisherSet()){
                retVal.setName(extensionAks.getPublisher());
            }

            if (extensionAks.isTypeSet()){
                retVal.setName(extensionAks.getType());
            }

        }

        return retVal;
    }

    private static ApiTagAks toDal(ClusterTagAks tagAks) {
        ApiTagAks retVal = null;

        if (tagAks != null) {
            retVal = new ApiTagAks();

            if (tagAks.isTagKeySet()) {
                retVal.setTagKey(tagAks.getTagKey());
            }

            if (tagAks.isTagValueSet()){
                retVal.setTagValue(tagAks.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiImageAks toDal(ClusterImageAks imageAks) {
        ApiImageAks retVal = null;

        if (imageAks != null) {
            retVal = new ApiImageAks();

            if (imageAks.isMarketplaceSet()) {
                retVal.setMarketplace(toDal(imageAks.getMarketplace()));
            }
        }

        return retVal;
    }

    private static ApiMarketplaceAks toDal(ClusterMarketplaceAks marketplaceAks) {
        ApiMarketplaceAks retVal = null;

        if (marketplaceAks != null) {
            retVal = new ApiMarketplaceAks();

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

    private static ApiLoadBalancersConfigAks toDal(ClusterLoadBalancersConfigAks loadBalancersConfigAks) {
        ApiLoadBalancersConfigAks retVal = null;

        if (loadBalancersConfigAks != null) {
            retVal = new ApiLoadBalancersConfigAks();

            if (loadBalancersConfigAks.isLoadBalancersSet()) {

                if (loadBalancersConfigAks.getLoadBalancers() != null){
                    List<ApiLoadBalancerAks> loadBalancers =
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

    private static ApiLoadBalancerAks toDal(ClusterLoadBalancerAks loadBalancerAks) {
        ApiLoadBalancerAks retVal = null;

        if (loadBalancerAks != null) {
            retVal = new ApiLoadBalancerAks();

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

    private static ApiLoginAks toDal(ClusterLoginAks loginAks){
        ApiLoginAks retVal = null;

        if (loginAks != null){
            retVal = new ApiLoginAks();

            if (loginAks.isSshPublicKeySet()){
                retVal.setSshPublicKey(loginAks.getSshPublicKey());
            }

            if (loginAks.isUserNameSet()){
                retVal.setUserName(loginAks.getUserName());
            }
        }
        return retVal;
    }

    private static ApiNetworkAks toDal(ClusterNetworkAks networkAks){
        ApiNetworkAks retVal = null;

        if (networkAks != null){
            retVal = new ApiNetworkAks();

            if (networkAks.isNetworkInterfacesSet()){

                if (networkAks.getNetworkInterfaces() != null){
                    List<ApiNetworkInterfaceAks> networks =
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

    private static ApiNetworkInterfaceAks toDal(ClusterNetworkInterfaceAks networkInterfaceAks){
        ApiNetworkInterfaceAks retVal = null;

        if (networkInterfaceAks != null){

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

                if (networkInterfaceAks.getSecurityGroup() != null){
                    List<ApiSecurityGroupAks> securityGroup =
                            networkInterfaceAks.getSecurityGroup().stream().map(ClusterConverterAks::toDal)
                                    .collect(Collectors.toList());
                    retVal.setSecurityGroup(securityGroup);
                }
                else{
                    retVal.setSecurityGroup(null);
                }
            }

            if (networkInterfaceAks.isSubnetNameSet()){
                retVal.setSubnetName(networkInterfaceAks.getSubnetName());
            }

        }
        return retVal;
    }

    private static ApiSecurityGroupAks toDal(ClusterSecurityGroupAks securityGroupAks) {
        ApiSecurityGroupAks retVal = null;

        if (securityGroupAks != null) {
            retVal = new ApiSecurityGroupAks();

            if (securityGroupAks.isNameSet()){
                retVal.setName(securityGroupAks.getName());
            }

            if (securityGroupAks.isResourceGroupNameSet()){
                retVal.setResourceGroupName(securityGroupAks.getResourceGroupName());
            }
        }
        return retVal;
    }

    private static ApiOsDiskAks toDal(ClusterOsDiskAks clusterOsDiskAks){
        ApiOsDiskAks retVal = null;

        if(clusterOsDiskAks != null){
            retVal = new ApiOsDiskAks();

            if (clusterOsDiskAks.isSizeGBSet()){
                retVal.setSizeGB(clusterOsDiskAks.getSizeGB());
            }
        }
        return retVal;
    }

    //DAL -> BL

    public static ClusterAks toBl(ApiClusterAks src) {

        ClusterAks retVal = null;

        if (src != null) {
            ClusterAks.Builder builder = ClusterAks.Builder.get();

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

    private static ClusterVirtualNodeGroupTemplateAks toBl(ApiVirtualNodeGroupTemplateAks virtualNodeGroupTemplateAks) {
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

    private static ClusterLaunchSpecificationAks toBl(ApiLaunchSpecificationAks launchSpecificationAks) {

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
                    List<ClusterTagAks> tags =
                            launchSpecificationAks.getTags().stream().map(ClusterConverterAks::toBl)
                                    .collect(Collectors.toList());
                    builder.setTags(tags);
                }
                else{
                    builder.setTags(null);

                }
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static ClusterExtensionAks toBl(ApiExtensionAks extensionAks) {
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

    private static ClusterTagAks toBl(ApiTagAks tagAks) {
        ClusterTagAks retVal = null;

        if (tagAks != null) {
            ClusterTagAks.Builder builder = ClusterTagAks.Builder.get();

            if (tagAks.isTagKeySet()) {
                builder.setTagKey(tagAks.getTagKey());
            }

            if (tagAks.isTagValueSet()){
                builder.setTagValue(tagAks.getTagValue());
            }

            retVal = builder.build();
        }

        return retVal;
    }

    private static ClusterImageAks toBl(ApiImageAks imageAks) {
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

    private static ClusterMarketplaceAks toBl(ApiMarketplaceAks marketplaceAks) {
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

    private static ClusterLoadBalancersConfigAks toBl(ApiLoadBalancersConfigAks loadBalancersConfigAks) {
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

    private static ClusterLoadBalancerAks toBl(ApiLoadBalancerAks loadBalancerAks) {
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

    private static ClusterLoginAks toBl(ApiLoginAks loginAks){
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

    private static ClusterNetworkAks toBl(ApiNetworkAks networkAks){
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

    private static ClusterNetworkInterfaceAks toBl(ApiNetworkInterfaceAks networkInterfaceAks){
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

                if (networkInterfaceAks.getSecurityGroup() != null){
                    List<ClusterSecurityGroupAks> securityGroup =
                            networkInterfaceAks.getSecurityGroup().stream().map(ClusterConverterAks::toBl)
                                    .collect(Collectors.toList());
                    builder.setSecurityGroup(securityGroup);
                }
                else{
                    builder.setSecurityGroup(null);
                }
            }

            if (networkInterfaceAks.isSubnetNameSet()){
                builder.setSubnetName(networkInterfaceAks.getSubnetName());
            }
            retVal = builder.build();
        }
        return retVal;
    }

    private static ClusterSecurityGroupAks toBl(ApiSecurityGroupAks securityGroupAks) {
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

    private static ClusterOsDiskAks toBl(ApiOsDiskAks osDiskAks){
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
}