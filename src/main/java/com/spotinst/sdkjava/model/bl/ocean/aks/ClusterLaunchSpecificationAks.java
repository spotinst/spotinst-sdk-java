package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ClusterLaunchSpecificationAks {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<ClusterExtensionAks>           extensions;
    private ClusterImageAks                     image;
    private ClusterLoadBalancersConfigAks       loadBalancersConfig;
    private ClusterLoginAks                     login;
    private ClusterNetworkAks                   network;
    private String                              resourceGroupName;
    private List<ClusterTagAks>                 tags;


    private ClusterLaunchSpecificationAks() {
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

    public ClusterLoginAks getLogin() {
        return login;
    }

    public void setLogin(ClusterLoginAks login) {

        isSet.add("login");
        this.login = login;
    }

    public ClusterNetworkAks getNetwork() {
        return network;
    }

    public void setNetwork(ClusterNetworkAks network) {

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
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    public static class Builder {

        private ClusterLaunchSpecificationAks clusterLaunchSpecificationAks;

        private Builder() {
            this.clusterLaunchSpecificationAks = new ClusterLaunchSpecificationAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
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
        public Builder setLogin(final ClusterLoginAks login) {
            clusterLaunchSpecificationAks.setLogin(login);
            return this;
        }
        public Builder setNetwork(final ClusterNetworkAks networkn) {
            clusterLaunchSpecificationAks.setNetwork(networkn);
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

        public ClusterLaunchSpecificationAks build() {
            return clusterLaunchSpecificationAks;
        }
    }

}

