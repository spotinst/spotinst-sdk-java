package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupLaunchSpecification {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private String                   healthCheckType;
    private Integer                  healthCheckGracePeriod;
    private List<String>             securityGroupIds;
    private Boolean                  detailedMonitoring;
    private Boolean                  ebsOptimized;
    private String                   imageId;
    private String                   keyPair;
    private String                   userData;
    private IamRole                  iamRole;
    private List<NetworkInterface>   networkInterfaces;
    private List<Tag>                tags;
    private List<BlockDeviceMapping> blockDeviceMappings;
    private LoadBalancersConfigAzure loadBalancersConfig;
    //endregion

    //region Constructor

    private ElastigroupLaunchSpecification() {
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

    public String getHealthCheckType() {
        return healthCheckType;
    }

    public void setHealthCheckType(String healthCheckType) {
        isSet.add("healthCheckType");
        this.healthCheckType = healthCheckType;
    }

    public Integer getHealthCheckGracePeriod() {
        return healthCheckGracePeriod;
    }

    public void setHealthCheckGracePeriod(Integer healthCheckGracePeriod) {
        isSet.add("healthCheckGracePeriod");
        this.healthCheckGracePeriod = healthCheckGracePeriod;
    }

    public IamRole getIamRole() {
        return iamRole;
    }

    public void setIamRole(IamRole iamRole) {
        isSet.add("iamRole");
        this.iamRole = iamRole;
    }

    public List<NetworkInterface> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public List<String> getSecurityGroupIds() {
        return securityGroupIds;
    }

    public void setSecurityGroupIds(List<String> securityGroupIds) {
        isSet.add("securityGroupIds");
        this.securityGroupIds = securityGroupIds;
    }

    public Boolean getDetailedMonitoring() {
        return detailedMonitoring;
    }

    public void setDetailedMonitoring(Boolean detailedMonitoring) {
        isSet.add("detailedMonitoring");
        this.detailedMonitoring = detailedMonitoring;
    }

    public Boolean getEbsOptimized() {
        return ebsOptimized;
    }

    public void setEbsOptimized(Boolean ebsOptimized) {
        isSet.add("ebsOptimized");
        this.ebsOptimized = ebsOptimized;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        isSet.add("imageId");
        this.imageId = imageId;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        isSet.add("keyPair");
        this.keyPair = keyPair;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        isSet.add("userData");
        this.userData = userData;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public List<BlockDeviceMapping> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<BlockDeviceMapping> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public LoadBalancersConfigAzure getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(LoadBalancersConfigAzure loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupLaunchSpecification launchSpecification;

        private Builder() {
            this.launchSpecification = new ElastigroupLaunchSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setKeyPair(final String keyPair) {
            launchSpecification.setKeyPair(keyPair);
            return this;
        }

        public Builder setImageId(final String imageId) {
            launchSpecification.setImageId(imageId);
            return this;
        }

        public Builder setDetailedMonitoring(final Boolean detailedMonitoring) {
            launchSpecification.setDetailedMonitoring(detailedMonitoring);
            return this;
        }

        public Builder setEbsOptimized(final Boolean ebsOptimized) {
            launchSpecification.setEbsOptimized(ebsOptimized);
            return this;
        }

        public Builder setHealthCheckGracePeriod(final Integer healthCheckGracePeriod) {
            launchSpecification.setHealthCheckGracePeriod(healthCheckGracePeriod);
            return this;
        }

        public Builder setHealthCheckType(final String healthCheckType) {
            launchSpecification.setHealthCheckType(healthCheckType);
            return this;
        }

        public Builder setUserData(final String userData) {
            launchSpecification.setUserData(userData);
            return this;
        }

        public Builder setSecurityGroupIds(final List<String> securityGroupIds) {
            launchSpecification.setSecurityGroupIds(securityGroupIds);
            return this;
        }

        public Builder setBlockDeviceMappings(final List<BlockDeviceMapping> blockDeviceMappings) {
            launchSpecification.setBlockDeviceMappings(blockDeviceMappings);
            return this;
        }

        public Builder setIamRole(final IamRole iamRole) {
            launchSpecification.setIamRole(iamRole);
            return this;
        }

        public Builder setNetworkInterfaces(final List<NetworkInterface> networkInterfaces) {
            launchSpecification.setNetworkInterfaces(networkInterfaces);
            return this;
        }

        public Builder setTags(final List<Tag> tags) {
            launchSpecification.setTags(tags);
            return this;
        }

        public Builder setLoadBalancersConfig(final LoadBalancersConfigAzure loadBalancersConfig) {
            launchSpecification.setLoadBalancersConfig(loadBalancersConfig);
            return this;
        }

        public ElastigroupLaunchSpecification build() {
            // TODO : Validations
            return launchSpecification;
        }
    }
    //endregion
    //region isSet methods

    // Is healthCheckType Set boolean method
    @JsonIgnore
    public boolean isHealthCheckTypeSet() {
        return isSet.contains("healthCheckType");
    }


    // Is healthCheckGracePeriod Set boolean method
    @JsonIgnore
    public boolean isHealthCheckGracePeriodSet() {
        return isSet.contains("healthCheckGracePeriod");
    }


    // Is securityGroupIds Set boolean method
    @JsonIgnore
    public boolean isSecurityGroupIdsSet() {
        return isSet.contains("securityGroupIds");
    }


    // Is detailedMonitoring Set boolean method
    @JsonIgnore
    public boolean isDetailedMonitoringSet() {
        return isSet.contains("detailedMonitoring");
    }


    // Is ebsOptimized Set boolean method
    @JsonIgnore
    public boolean isEbsOptimizedSet() {
        return isSet.contains("ebsOptimized");
    }


    // Is imageId Set boolean method
    @JsonIgnore
    public boolean isImageIdSet() {
        return isSet.contains("imageId");
    }


    // Is keyPair Set boolean method
    @JsonIgnore
    public boolean isKeyPairSet() {
        return isSet.contains("keyPair");
    }


    // Is userData Set boolean method
    @JsonIgnore
    public boolean isUserDataSet() {
        return isSet.contains("userData");
    }


    // Is iamRole Set boolean method
    @JsonIgnore
    public boolean isIamRoleSet() {
        return isSet.contains("iamRole");
    }


    // Is networkInterfaces Set boolean method
    @JsonIgnore
    public boolean isNetworkInterfacesSet() {
        return isSet.contains("networkInterfaces");
    }


    // Is tags Set boolean method
    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    // Is blockDeviceMappings Set boolean method
    @JsonIgnore
    public boolean isBlockDeviceMappingsSet() {
        return isSet.contains("blockDeviceMappings");
    }
    //endregion

    // Is loadBalancers Set boolean method
    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }
    //endregion
}
