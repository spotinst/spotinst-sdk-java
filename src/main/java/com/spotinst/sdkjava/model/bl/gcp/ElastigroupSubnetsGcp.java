package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ElastigroupSubnetsGcp {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String region;
    private List<String> subnetNames;
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
    public List<String> getSubnetNames() {
        return subnetNames;
    }

    public void setSubnetNames(List<String> subnetNames) {
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

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupSubnetsGcp instanceTypes;

        private Builder() {
            this.instanceTypes = new ElastigroupSubnetsGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setRegionType(final String regionType) {
            instanceTypes.setRegion(regionType);
            return this;
        }

        public Builder setSubnetNamesTypes(final List<String> subnetNamesTypes) {
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
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    // Is subnetNames Set boolean method
    @JsonIgnore
    public boolean isSubnetNamesSet() {
        return isSet.contains("subnetNames");
    }

    //endregion
}
