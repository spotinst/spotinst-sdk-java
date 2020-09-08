package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupLaunchSpecificationAzure {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private ImageSpecAzure           image;
    private LoadBalancersConfigAzure loadBalancersConfig;
    private List<TagAzure>           tags;
    private List<NetworkAzure>       network;
    private List<LoginAzure>         login;
    private String                   customData;
    //todo add managedServiceIdentities, shutdownScript ,extensions,dataDisks
    //endregion

    //region Constructor
    private ElastigroupLaunchSpecificationAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<NetworkAzure> getNetwork() {
        return network;
    }

    public void setNetwork(List<NetworkAzure> network) {
        isSet.add("network");
        this.network = network;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        isSet.add("customData");
        this.customData = customData;
    }

    public List<TagAzure> getTags() {
        return tags;
    }

    public void setTags(List<TagAzure> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public List<LoginAzure> getLogin() {
        return login;
    }

    public void setLogin(List<LoginAzure> login) {
        isSet.add("login");
        this.login = login;
    }

    public LoadBalancersConfigAzure getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(LoadBalancersConfigAzure loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public ImageSpecAzure getImage() {
        return image;
    }

    public void setImage(ImageSpecAzure image) {
        isSet.add("image");
        this.image = image;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupLaunchSpecificationAzure launchSpecification;
        private Builder() {
            this.launchSpecification = new ElastigroupLaunchSpecificationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCustomData(final String customData) {
            launchSpecification.setCustomData(customData);
            return this;
        }

        public Builder setNetwork(final List<NetworkAzure> network) {
            launchSpecification.setNetwork(network);
            return this;
        }

        public Builder setTags(final List<TagAzure> tags) {
            launchSpecification.setTags(tags);
            return this;
        }

        public Builder setLogin(final List<LoginAzure> login) {
            launchSpecification.setLogin(login);
            return this;
        }

        public Builder setLoadBalancersConfig(final LoadBalancersConfigAzure loadBalancersConfig) {
            launchSpecification.setLoadBalancersConfig(loadBalancersConfig);
            return this;
        }

        public Builder setImage(final ImageSpecAzure image) {
            launchSpecification.setImage(image);
            return this;
        }

        public ElastigroupLaunchSpecificationAzure build() {
            // TODO : Validations
            return launchSpecification;
        }
    }
    //endregion

    //region isSet methods
    // Is customData Set boolean method
    @JsonIgnore
    public boolean isCustomDataSet() {
        return isSet.contains("customData");
    }

    // Is network Set boolean method
    @JsonIgnore
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    // Is tags Set boolean method
    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    // Is image Set boolean method
    @JsonIgnore
    public boolean isImageSet() {
        return isSet.contains("image");
    }

    // Is login Set boolean method
    @JsonIgnore
    public boolean isLoginSet() {
        return isSet.contains("login");
    }

    // Is loadBalancers Set boolean method
    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }
    //endregion
}