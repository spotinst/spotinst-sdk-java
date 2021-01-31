package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiSubnetsGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private String       region;
    private List<String> subnetNames;
    //endregion

    //region Constructor

    public ApiSubnetsGcp() {
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

    public List<String> getSubnetNames() {
        return subnetNames;
    }

    public void setSubnetNames(List<String> subnetNames) {
        isSet.add("subnetNames");
        this.subnetNames = subnetNames;
    }

    public String getRegion() {

        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
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
