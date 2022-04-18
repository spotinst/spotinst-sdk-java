package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Import {

    @JsonIgnore
    private Set<String>  isSet;
    private String       managedInstanceName;
    private String       originalInstanceId;
    private String       product;
    private String       region;
    private Boolean      shouldKeepPrivateIp;
    private Boolean      shouldTerminateInstance;
    private List<String> spotInstanceTypes;

    private Import() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getManagedInstanceName() {
        return managedInstanceName;
    }

    public void setManagedInstanceName(String managedInstanceName) {
        isSet.add("managedInstanceName");
        this.managedInstanceName = managedInstanceName;
    }

    public String getOriginalInstanceId() {
        return originalInstanceId;
    }

    public void setOriginalInstanceId(String originalInstanceId) {
        isSet.add("originalInstanceId");
        this.originalInstanceId = originalInstanceId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        isSet.add("product");
        this.product = product;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public Boolean getShouldKeepPrivateIp() {
        return shouldKeepPrivateIp;
    }

    public void setShouldKeepPrivateIp(Boolean shouldKeepPrivateIp) {
        isSet.add("shouldKeepPrivateIp");
        this.shouldKeepPrivateIp = shouldKeepPrivateIp;
    }

    public Boolean getShouldTerminateInstance() {
        return shouldTerminateInstance;
    }

    public void setShouldTerminateInstance(Boolean shouldTerminateInstance) {
        isSet.add("shouldTerminateInstance");
        this.shouldTerminateInstance = shouldTerminateInstance;
    }

    public List<String> getSpotInstanceTypes() {
        return spotInstanceTypes;
    }

    public void setSpotInstanceTypes(List<String> spotInstanceTypes) {
        isSet.add("spotInstanceTypes");
        this.spotInstanceTypes = spotInstanceTypes;
    }

    public static class Builder {
        private Import importBuilder;

        private Builder() {
            this.importBuilder = new Import();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setManagedInstanceName(final String managedInstanceName) {
            importBuilder.setManagedInstanceName(managedInstanceName);
            return this;
        }

        public Builder setRegion(final String region) {
            importBuilder.setRegion(region);
            return this;
        }

        public Builder setOriginalInstanceId(final String originalInstanceId) {
            importBuilder.setOriginalInstanceId(originalInstanceId);
            return this;
        }

        public Builder setProduct(final String product) {
            importBuilder.setProduct(product);
            return this;
        }

        public Builder setShouldKeepPrivateIp(final Boolean shouldKeepPrivateIp) {
            importBuilder.setShouldKeepPrivateIp(shouldKeepPrivateIp);
            return this;
        }

        public Builder setShouldTerminateInstance(final Boolean shouldTerminateInstance) {
            importBuilder.setShouldTerminateInstance(shouldTerminateInstance);
            return this;
        }

        public Builder setSpotInstanceTypes(final List<String> spotInstanceTypes) {
            importBuilder.setSpotInstanceTypes(spotInstanceTypes);
            return this;
        }

        public Import build() {
            return importBuilder;
        }
    }

    @JsonIgnore
    public boolean isManagedInstanceNameSet() {
        return isSet.contains("managedInstanceName");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isOriginalInstanceIdSet() {
        return isSet.contains("originalInstanceId");
    }

    @JsonIgnore
    public boolean isProductSet() {
        return isSet.contains("product");
    }

    @JsonIgnore
    public boolean isShouldKeepPrivateIpSet() {
        return isSet.contains("shouldKeepPrivateIp");
    }

    @JsonIgnore
    public boolean isShouldTerminateInstanceSet() {
        return isSet.contains("shouldTerminateInstance");
    }

    @JsonIgnore
    public boolean isSpotInstanceTypesSet() {
        return isSet.contains("spotInstanceTypes");
    }

}