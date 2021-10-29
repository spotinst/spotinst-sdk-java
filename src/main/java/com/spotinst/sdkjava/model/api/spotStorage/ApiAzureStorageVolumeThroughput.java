package com.spotinst.sdkjava.model.api.spotStorage;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAzureStorageVolumeThroughput implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Double      throughputMibps;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeThroughput() {
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

    //region ThroughputMibps
    public Double getThroughputMibps() {
        return throughputMibps;
    }

    public void setThroughputMibps(Double throughputMibps) {
        isSet.add("throughputMibps");
        this.throughputMibps = throughputMibps;
    }
    //endregion

    //region isSet methods

    // Is throughputMibps Set boolean method
    @JsonIgnore
    public boolean isThroughputMibpsSet() {
        return isSet.contains("throughputMibps");
    }
    //endregion

}
