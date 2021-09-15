package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiClusterAliasIpRangesSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private String      ipCidrRange;
    private String      subnetworkRangeName;

    public ApiClusterAliasIpRangesSpecification() {
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

    @JsonIgnore
    public boolean isIpCidrRangeSet() { return isSet.contains("ipCidrRange"); }

    @JsonIgnore
    public boolean isSubnetworkRangeNameSet() {
        return isSet.contains("subnetworkRangeName");
    }

}
