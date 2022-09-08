package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupSubnetsGcp {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String region;
    private Set<String> subnetNames;
    //endregion

    //region Constructors
    private ElastigroupSubnetsGcp() {
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

    //region subnetNames
    public Set<String> getSubnetNames() {
        return subnetNames;
    }

    public void setSubnetNames(Set<String> subnetNames) {
        isSet.add("subnetNames");
        this.subnetNames = subnetNames;
    }
    //endregion

    //region region
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupSubnetsGcp instanceTypes;

        private Builder() {
            this.instanceTypes = new ElastigroupSubnetsGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setRegion(final String regionType) {
            instanceTypes.setRegion(regionType);
            return this;
        }

        public Builder setSubnetNames(final Set<String> subnetNamesTypes) {
            instanceTypes.setSubnetNames(subnetNamesTypes);
            return this;
        }

        public ElastigroupSubnetsGcp build() {
            return instanceTypes;
        }
    }
    //endregion

    //region isSet methods
    // Is region Set boolean method
    @JsonIgnore
    public boolean isRegionSet() { return isSet.contains("region"); }

    // Is subnetNames Set boolean method
    @JsonIgnore
    public boolean isSubnetNamesSet() { return isSet.contains("subnetNames"); }
    //endregion
}
