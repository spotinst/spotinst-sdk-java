package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterAliasIpRangesSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private String      ipCidrRange;
    private String      subnetworkRangeName;

    private ClusterAliasIpRangesSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getIpCidrRange() {
        return ipCidrRange;
    }

    public void setIpCidrRange(String ipCidrRange) {
        isSet.add("ipCidrRange");
        this.ipCidrRange = ipCidrRange;
    }

    public String getSubnetworkRangeName() {
        return subnetworkRangeName;
    }

    public void setSubnetworkRangeName(String subnetworkRangeName) {
        isSet.add("subnetworkRangeName");
        this.subnetworkRangeName = subnetworkRangeName;
    }

    public static class Builder {
        private ClusterAliasIpRangesSpecification aliasIpRanges;

        private Builder() {
            this.aliasIpRanges = new ClusterAliasIpRangesSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setIpCidrRange(final String ipCidrRange) {
            aliasIpRanges.setIpCidrRange(ipCidrRange);
            return this;
        }

        public Builder setSubnetworkRangeName(final String subnetworkRangeName) {
            aliasIpRanges.setSubnetworkRangeName(subnetworkRangeName);
            return this;
        }

        public ClusterAliasIpRangesSpecification build() {
            return aliasIpRanges;
        }
    }

    @JsonIgnore
    public boolean isIpCidrRangeSet() {
        return isSet.contains("ipCidrRange");
    }

    @JsonIgnore
    public boolean isSubNetworkRangeNameSet() {
        return isSet.contains("subnetworkRangeName");
    }

}
