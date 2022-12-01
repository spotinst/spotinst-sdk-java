package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupImportStatefulInstance {

    @JsonIgnore
    private Set<String>                                          isSet;
    private String                                               originalInstanceId;
    private Boolean                                              shouldKeepPrivateIp;
    private Boolean                                              shouldTerminateInstance;
    private String                                               name;
    private String                                               product;
    private List<String>                                         spotInstanceTypes;
    private String                                               region;
    private List<ElastigroupStatefulInstanceAvalilabilityZones>  availabilityZones;

    public ElastigroupImportStatefulInstance() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOriginalInstanceId() {
        return originalInstanceId;
    }

    public void setOriginalInstanceId(String originalInstanceId) {
        isSet.add("originalInstanceId");
        this.originalInstanceId = originalInstanceId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        isSet.add("product");
        this.product = product;
    }

    public List<String> getSpotInstanceTypes() {
        return spotInstanceTypes;
    }

    public void setSpotInstanceTypes(List<String> spotInstanceTypes) {
        isSet.add("spotInstanceTypes");
        this.spotInstanceTypes = spotInstanceTypes;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public List<ElastigroupStatefulInstanceAvalilabilityZones> getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<ElastigroupStatefulInstanceAvalilabilityZones> availabilityZones) {
        isSet.add("availabilityZones");
        this.availabilityZones = availabilityZones;
    }

    public static class Builder {
        private ElastigroupImportStatefulInstance elastigroupImportStatefulInstance;

        private Builder() {
            this.elastigroupImportStatefulInstance = new ElastigroupImportStatefulInstance();
        }

        public static Builder get() {
            return new Builder();
        }

        public ElastigroupImportStatefulInstance.Builder setOriginalInstanceId(final String originalInstanceId) {
            elastigroupImportStatefulInstance.setOriginalInstanceId(originalInstanceId);
            return this;
        }

        public ElastigroupImportStatefulInstance.Builder setShouldKeepPrivateIp(final Boolean shouldKeepPrivateIp) {
            elastigroupImportStatefulInstance.setShouldKeepPrivateIp(shouldKeepPrivateIp);
            return this;
        }

        public ElastigroupImportStatefulInstance.Builder setShouldTerminateInstance(final Boolean shouldTerminateInstance) {
            elastigroupImportStatefulInstance.setShouldTerminateInstance(shouldTerminateInstance);
            return this;
        }

        public ElastigroupImportStatefulInstance.Builder setName(final String name) {
            elastigroupImportStatefulInstance.setName(name);
            return this;
        }

        public ElastigroupImportStatefulInstance.Builder setProduct(final String product) {
            elastigroupImportStatefulInstance.setProduct(product);
            return this;
        }

        public Builder setSpotInstanceTypes(final List<String> spotInstanceTypes) {
            elastigroupImportStatefulInstance.setSpotInstanceTypes(spotInstanceTypes);
            return this;
        }

        public ElastigroupImportStatefulInstance.Builder setRegion(final String region) {
            elastigroupImportStatefulInstance.setRegion(region);
            return this;
        }

        public ElastigroupImportStatefulInstance.Builder setAvailabilityZones(final List<ElastigroupStatefulInstanceAvalilabilityZones> availabilityZones) {
            elastigroupImportStatefulInstance.setAvailabilityZones(availabilityZones);
            return this;
        }

        public ElastigroupImportStatefulInstance build() {
            return elastigroupImportStatefulInstance;
        }

    }

    @JsonIgnore
    public boolean isOriginalInstanceIdSet() {
        return isSet.contains("originalInstanceId");
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
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isProductSet() {
        return isSet.contains("product");
    }

    @JsonIgnore
    public boolean isSpotInstanceTypesSet() {
        return isSet.contains("spotInstanceTypes");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isAvailabilityZonesSet() {
        return isSet.contains("availabilityZones");
    }

}
