package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLaunchSpecificationGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                             isSet;
    private List<ApiDisksGcp>                       disks;
    private List<ApiNetworkInterfacesGcp>           networkInterfaces;
    //endregion

    //region Constructor
    public ApiLaunchSpecificationGcp() {
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

    public List<ApiDisksGcp> getDisks() {
        return disks;
    }

    public void setDisks(List<ApiDisksGcp> disks) {
        isSet.add("disks");
        this.disks = disks;
    }

    public List<ApiNetworkInterfacesGcp> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiNetworkInterfacesGcp> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }
    //endregion

    //region isSet methods
    // Is disks Set boolean method
    @JsonIgnore
    public boolean isDisksSet() {
        return isSet.contains("disks");
    }

    // Is networkInterfaces Set boolean method
    @JsonIgnore
    public boolean isNetworkInterfacesSet() {
        return isSet.contains("networkInterfaces");
    }
    //endregion
}
