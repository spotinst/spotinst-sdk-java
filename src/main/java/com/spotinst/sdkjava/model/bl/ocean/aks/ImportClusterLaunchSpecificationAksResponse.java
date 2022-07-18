package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportClusterLaunchSpecificationAksResponse {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<ClusterExtensionAks>           extensions;
    private ClusterImageAks                     image;
    private ClusterLoadBalancersConfigAks       loadBalancersConfig;
    private ImportClusterLoginAks               login;
    private ImportClusterNetworkAks             network;
    private ImportClusterOsDiskAks              osDisk;
    private String                              resourceGroupName;
    private String                              customData;
    private List<ClusterTagAks>                 tags;
    private Integer                             maxPods;

    private ImportClusterLaunchSpecificationAksResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterExtensionAks> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<ClusterExtensionAks> extensions) {
        isSet.add("extensions");
        this.extensions = extensions;
    }

    public ClusterImageAks getImage() {
        return image;
    }

    public void setImage(ClusterImageAks image) {

        isSet.add("image");
        this.image = image;
    }

    public ClusterLoadBalancersConfigAks getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(ClusterLoadBalancersConfigAks loadBalancersConfig) {

        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public ImportClusterLoginAks getLogin() {
        return login;
    }

    public void setLogin(ImportClusterLoginAks login) {

        isSet.add("login");
        this.login = login;
    }

    public ImportClusterNetworkAks getNetwork() {
        return network;
    }

    public void setNetwork(ImportClusterNetworkAks network) {

        isSet.add("network");
        this.network = network;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {

        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public List<ClusterTagAks> getTags() {
        return tags;
    }

    public void setTags(List<ClusterTagAks> tags) {

        isSet.add("tags");
        this.tags = tags;
    }

    public ImportClusterOsDiskAks getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(ImportClusterOsDiskAks osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {

        isSet.add("customData");
        this.customData = customData;
    }

    public Integer getMaxPods() {
        return maxPods;
    }

    public void setMaxPods(Integer maxPods) {

        isSet.add("maxPods");
        this.maxPods = maxPods;
    }

    public static class Builder {

        private ImportClusterLaunchSpecificationAksResponse clusterLaunchSpecificationAks;

        private Builder() {
            this.clusterLaunchSpecificationAks = new ImportClusterLaunchSpecificationAksResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setExtensions(final List<ClusterExtensionAks> extensions) {
            clusterLaunchSpecificationAks.setExtensions(extensions);
            return this;
        }
        public Builder setImage(final ClusterImageAks image) {
            clusterLaunchSpecificationAks.setImage(image);
            return this;
        }
        public Builder setLoadBalancersConfig(final ClusterLoadBalancersConfigAks loadBalancersConfig) {
            clusterLaunchSpecificationAks.setLoadBalancersConfig(loadBalancersConfig);
            return this;
        }
        public Builder setLogin(final ImportClusterLoginAks login) {
            clusterLaunchSpecificationAks.setLogin(login);
            return this;
        }
        public Builder setNetwork(final ImportClusterNetworkAks networkn) {
            clusterLaunchSpecificationAks.setNetwork(networkn);
            return this;
        }
        public Builder setOsDisk(final ImportClusterOsDiskAks osDisk){
            clusterLaunchSpecificationAks.setOsDisk(osDisk);
            return this;
        }
        public Builder setResourceGroupName(final String resourceGroupName) {
            clusterLaunchSpecificationAks.setResourceGroupName(resourceGroupName);
            return this;
        }
        public Builder setTags(final List<ClusterTagAks> tags) {
            clusterLaunchSpecificationAks.setTags(tags);
            return this;
        }

        public Builder setCustomData(final String customData) {
            clusterLaunchSpecificationAks.setCustomData(customData);
            return this;
        }

        public Builder setMaxPods(final Integer maxPods) {
            clusterLaunchSpecificationAks.setMaxPods(maxPods);
            return this;
        }

        public ImportClusterLaunchSpecificationAksResponse build() {
            return clusterLaunchSpecificationAks;
        }
    }

    @JsonIgnore
    public boolean isExtensionsSet() {
        return isSet.contains("extensions");
    }

    @JsonIgnore
    public boolean isImageSet() {
        return isSet.contains("image");
    }

    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }

    @JsonIgnore
    public boolean isLoginSet() {
        return isSet.contains("login");
    }

    @JsonIgnore
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    @JsonIgnore
    public boolean isOsDiskSet() {
        return isSet.contains("osDisk");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isCustomDataSet() {
        return isSet.contains("customData");
    }

    @JsonIgnore
    public boolean isMaxPodsSet() {
        return isSet.contains("maxPods");
    }

}

