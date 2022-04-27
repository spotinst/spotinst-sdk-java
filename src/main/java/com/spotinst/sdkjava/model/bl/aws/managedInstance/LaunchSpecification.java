package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class LaunchSpecification {

    @JsonIgnore
    private Set<String>                 isSet;
    private List<BlockDeviceMappings>   blockDeviceMappings;
    private CreditSpecification         creditSpecification;
    private Boolean                     ebsOptimized;
    private IamRole                     iamRole;
    private String                      imageId;
    private InstanceTypes               instanceTypes;
    private String                      keyPair;
    private Boolean                     monitoring;
    private List<NetworkInterfaces>     networkInterfaces;
    private ResourceTagSpecification    resourceTagSpecification;
    private List<String>                securityGroupIds;
    private String                      shutdownScript;
    private List<Tags>                  tags;
    private String                      tenancy;
    private String                      userData;

    private LaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<BlockDeviceMappings> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<BlockDeviceMappings> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public CreditSpecification getCreditSpecification() {
        return creditSpecification;
    }

    public void setCreditSpecification(CreditSpecification creditSpecification) {
        isSet.add("creditSpecification");
        this.creditSpecification = creditSpecification;
    }

    public Boolean getEbsOptimized() {
        return ebsOptimized;
    }

    public void setEbsOptimized(Boolean ebsOptimized) {
        isSet.add("ebsOptimized");
        this.ebsOptimized = ebsOptimized;
    }

    public IamRole getIamRole() {
        return iamRole;
    }

    public void setIamRole(IamRole iamRole) {
        isSet.add("iamRole");
        this.iamRole = iamRole;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        isSet.add("imageId");
        this.imageId = imageId;
    }

    public InstanceTypes getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(InstanceTypes instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        isSet.add("keyPair");
        this.keyPair = keyPair;
    }

    public Boolean getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(Boolean monitoring) {
        isSet.add("monitoring");
        this.monitoring = monitoring;
    }

    public List<NetworkInterfaces> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<NetworkInterfaces> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public ResourceTagSpecification getResourceTagSpecification() {
        return resourceTagSpecification;
    }

    public void setResourceTagSpecification(ResourceTagSpecification resourceTagSpecification) {
        isSet.add("resourceTagSpecification");
        this.resourceTagSpecification = resourceTagSpecification;
    }

    public List<String> getSecurityGroupIds() {
        return securityGroupIds;
    }

    public void setSecurityGroupIds(List<String> securityGroupIds) {
        isSet.add("securityGroupIds");
        this.securityGroupIds = securityGroupIds;
    }

    public String getShutdownScript() {
        return shutdownScript;
    }

    public void setShutdownScript(String shutdownScript) {
        isSet.add("shutdownScript");
        this.shutdownScript = shutdownScript;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public String getTenancy() {
        return tenancy;
    }

    public void setTenancy(String tenancy) {
        isSet.add("tenancy");
        this.tenancy = tenancy;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        isSet.add("userData");
        this.userData = userData;
    }

    public static class Builder {
        private LaunchSpecification launchSpecification;

        private Builder() {
            this.launchSpecification = new LaunchSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBlockDeviceMappings(final List<BlockDeviceMappings> blockDeviceMappings) {
            launchSpecification.setBlockDeviceMappings(blockDeviceMappings);
            return this;
        }

        public Builder setCreditSpecification(final CreditSpecification creditSpecification) {
            launchSpecification.setCreditSpecification(creditSpecification);
            return this;
        }

        public Builder setEbsOptimized(final Boolean ebsOptimized) {
            launchSpecification.setEbsOptimized(ebsOptimized);
            return this;
        }

        public Builder setIamRole(final IamRole iamRole) {
            launchSpecification.setIamRole(iamRole);
            return this;
        }

        public Builder setImageId(final String imageId) {
            launchSpecification.setImageId(imageId);
            return this;
        }

        public Builder setInstanceTypes(final InstanceTypes instanceTypes) {
            launchSpecification.setInstanceTypes(instanceTypes);
            return this;
        }

        public Builder setKeyPair(final String keyPair) {
            launchSpecification.setKeyPair(keyPair);
            return this;
        }

        public Builder setMonitoring(final Boolean monitoring) {
            launchSpecification.setMonitoring(monitoring);
            return this;
        }

        public Builder setNetworkInterfaces(final List<NetworkInterfaces> networkInterfaces) {
            launchSpecification.setNetworkInterfaces(networkInterfaces);
            return this;
        }

        public Builder setResourceTagSpecification(final ResourceTagSpecification resourceTagSpecification) {
            launchSpecification.setResourceTagSpecification(resourceTagSpecification);
            return this;
        }

        public Builder setSecurityGroupIds(final List<String> securityGroupIds) {
            launchSpecification.setSecurityGroupIds(securityGroupIds);
            return this;
        }

        public Builder setShutdownScript(final String shutdownScript) {
            launchSpecification.setShutdownScript(shutdownScript);
            return this;
        }

        public Builder setTags(final List<Tags> tags) {
            launchSpecification.setTags(tags);
            return this;
        }

        public Builder setTenancy(final String tenancy) {
            launchSpecification.setTenancy(tenancy);
            return this;
        }

        public Builder setUserData(final String userData) {
            launchSpecification.setUserData(userData);
            return this;
        }

        public LaunchSpecification build() {
            return launchSpecification;
        }
    }

    @JsonIgnore
    public boolean isBlockDeviceMappingsSet() {
        return isSet.contains("blockDeviceMappings");
    }

    @JsonIgnore
    public boolean isCreditSpecificationSet() {
        return isSet.contains("creditSpecification");
    }

    @JsonIgnore
    public boolean isEbsOptimizedSet() {
        return isSet.contains("ebsOptimized");
    }

    @JsonIgnore
    public boolean isIamRoleSet() {
        return isSet.contains("iamRole");
    }

    @JsonIgnore
    public boolean isImageIdSet() {
        return isSet.contains("imageId");
    }

    @JsonIgnore
    public boolean isInstanceTypesSet() {
        return isSet.contains("instanceTypes");
    }

    @JsonIgnore
    public boolean isKeyPairSet() {
        return isSet.contains("keyPair");
    }

    @JsonIgnore
    public boolean isMonitoringSet() {
        return isSet.contains("monitoring");
    }

    @JsonIgnore
    public boolean isNetworkInterfacesSet() {
        return isSet.contains("networkInterfaces");
    }

    @JsonIgnore
    public boolean isResourceTagSpecificationSet() {
        return isSet.contains("resourceTagSpecification");
    }

    @JsonIgnore
    public boolean isSecurityGroupIdsSet() {
        return isSet.contains("securityGroupIds");
    }

    @JsonIgnore
    public boolean isShutdownScriptSet() {
        return isSet.contains("shutdownScript");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isTenancySet() {
        return isSet.contains("tenancy");
    }

    @JsonIgnore
    public boolean isUserDataSet() {
        return isSet.contains("userData");
    }
}
