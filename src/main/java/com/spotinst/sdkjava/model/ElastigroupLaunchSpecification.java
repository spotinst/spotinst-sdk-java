package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.CpuOptions;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.CreditSpecification;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.MetadataOptions;

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
    private Boolean                  autoHealing;
    private String                   healthCheckType;
    private Integer                  healthCheckGracePeriod;
    private List<String>             securityGroupIds;
    private Boolean                  detailedMonitoring;
    private Boolean                  ebsOptimized;
    private String                   imageId;
    private List<Images>             images;
    private String                   keyPair;
    private String                   userData;
    private String                   shutdownScript;
    private Integer                  healthCheckUnhealthyDurationBeforeReplacement;
    private IamRole                  iamRole;
    private List<NetworkInterface>   networkInterfaces;
    private List<Tag>                tags;
    private GroupResourceTagSpecification resourceTagSpecification;
    private List<BlockDeviceMapping> blockDeviceMappings;
    private LoadBalancersConfig      loadBalancersConfig;
    private ElastigroupItf           itf;
    private CpuOptions               cpuOptions;
    private MetadataOptions          metadataOptions;
    private CreditSpecification      creditSpec;
    private Boolean                  monitoring;
    //endregion

    //region Constructor

    private ElastigroupLaunchSpecification() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public GroupResourceTagSpecification getResourceTagSpecification() {
        return resourceTagSpecification;
    }

    public void setResourceTagSpecification(GroupResourceTagSpecification groupResourceTagSpecification) {
        isSet.add("resourceTagSpecification");
        this.resourceTagSpecification = groupResourceTagSpecification;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getAutoHealing() {
        return autoHealing;
    }

    public void setAutoHealing(Boolean autohealing) {
        isSet.add("autoHealing");
        this.autoHealing = autohealing;
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

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        isSet.add("images");
        this.images = images;
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

    public String getShutdownScript() {
        return shutdownScript;
    }

    public void setShutdownScript(String script) {
        isSet.add("shutdownScript");
        this.shutdownScript = script;
    }

    public Integer getHealthCheckUnhealthyDurationBeforeReplacement() { return healthCheckUnhealthyDurationBeforeReplacement; }

    public void setHealthCheckUnhealthyDurationBeforeReplacement(Integer healthCheckUnhealthyDurationBeforeReplacement) {
        isSet.add("healthCheckUnhealthyDurationBeforeReplacement");
        this.healthCheckUnhealthyDurationBeforeReplacement = healthCheckUnhealthyDurationBeforeReplacement;
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

    public LoadBalancersConfig getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(LoadBalancersConfig loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public ElastigroupItf getItf() {
        return itf;
    }

    public void setItf(ElastigroupItf itf) {
        isSet.add("itf");
        this.itf = itf;
    }

    public CpuOptions getCpuOptions() {
        return cpuOptions;
    }

    public void setCpuOptions(CpuOptions options) {
        isSet.add("cpuOptions");
        this.cpuOptions = options;
    }

    public MetadataOptions getMetadataOptions() {
        return metadataOptions;
    }

    public void setMetadataOptions(MetadataOptions options) {
        isSet.add("metadataOptions");
        this.metadataOptions = options;
    }

    public CreditSpecification getCreditSpecification() {
        return creditSpec;
    }

    public void setCreditSpecification(CreditSpecification spec) {
        isSet.add("creditSpecification");
        this.creditSpec = spec;
    }

    public Boolean getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(Boolean monitoring) {
        isSet.add("monitoring");
        this.monitoring = monitoring;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupLaunchSpecification launchSpecification;

        private Builder() {
            this.launchSpecification = new ElastigroupLaunchSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setKeyPair(final String keyPair) {
            launchSpecification.setKeyPair(keyPair);
            return this;
        }

        public Builder setImageId(final String imageId) {
            launchSpecification.setImageId(imageId);
            return this;
        }

        public Builder setImages(final List<Images> images) {
            launchSpecification.setImages(images);
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

        public Builder setAutoHealing(final Boolean autohealing) {
            launchSpecification.setAutoHealing(autohealing);
            return this;
        }

        public Builder setUserData(final String userData) {
            launchSpecification.setUserData(userData);
            return this;
        }

        public Builder setShutdownScript(final String script) {
            launchSpecification.setShutdownScript(script);
            return this;
        }

        public Builder setHealthCheckUnhealthyDurationBeforeReplacement(final Integer healthCheckUnhealthyDurationBeforeReplacement) {
            launchSpecification.setHealthCheckUnhealthyDurationBeforeReplacement(healthCheckUnhealthyDurationBeforeReplacement);
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

        public Builder setLoadBalancersConfig(final LoadBalancersConfig loadBalancersConfig) {
            launchSpecification.setLoadBalancersConfig(loadBalancersConfig);
            return this;
        }

        public Builder setResourceTagSpecification(final GroupResourceTagSpecification resourceTagSpecification) {
            launchSpecification.setResourceTagSpecification(resourceTagSpecification);
            return this;
        }

        public Builder setItf(final ElastigroupItf itf) {
            launchSpecification.setItf(itf);
            return this;
        }

        public Builder setCpuOptions(final CpuOptions options) {
            launchSpecification.setCpuOptions(options);
            return this;
        }

        public Builder setMetadataOptions(final MetadataOptions options) {
            launchSpecification.setMetadataOptions(options);
            return this;
        }

        public Builder setCreditSpecification(final CreditSpecification spec) {
            launchSpecification.setCreditSpecification(spec);
            return this;
        }

        public Builder setMonitoring(final Boolean monitoring) {
            launchSpecification.setMonitoring(monitoring);
            return this;
        }

        public ElastigroupLaunchSpecification build() {
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

    @JsonIgnore
    public boolean isAutoHealingSet() {
        return isSet.contains("autoHealing");
    }

    // Is ResourceTagSpecification Set boolean method
    @JsonIgnore
    public boolean isResourceTagSpecificationSet() {
        return isSet.contains("resourceTagSpecification");
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

    // Is images Set boolean method
    @JsonIgnore
    public boolean isImagesSet() {
        return isSet.contains("images");
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

    @JsonIgnore
    public boolean isShutdownScriptSet() {
        return isSet.contains("shutdownScript");
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

    // Is healthCheckUnhealthyDurationBeforeReplacement Set boolean method
    @JsonIgnore
    public boolean isHealthCheckUnhealthyDurationBeforeReplacementSet() {
        return isSet.contains("healthCheckUnhealthyDurationBeforeReplacement");
    }

    // Is itf Set boolean method
    @JsonIgnore
    public boolean isItfSet() {
        return isSet.contains("itf");
    }

    @JsonIgnore
    public boolean isCpuOptionsSet() {
        return isSet.contains("cpuOptions");
    }

    @JsonIgnore
    public boolean isMetadataOptionsSet() {
        return isSet.contains("metadataOptions");
    }

    @JsonIgnore
    public boolean isCreditSpecificationSet() {
        return isSet.contains("creditSpecification");
    }

    @JsonIgnore
    public boolean isMonitoringSet() {
        return isSet.contains("monitoring");
    }

    //endregion
}
