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
public class ApiNetworkInterfacesGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private String       network;
    private String       projectId;
    //endregion

    //region Constructor

    public ApiNetworkInterfacesGcp() {
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

    public String getProjectId() {

        return projectId;
    }

    public void setProjectId(String projectId) {
        isSet.add("projectId");
        this.projectId = projectId;
    }

    public String getNetwork() {

        return network;
    }

    public void setNetwork(String network) {
        isSet.add("network");
        this.network = network;
    }

    //endregion

    //region isSet methods

    // Is network Set boolean method
    @JsonIgnore
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    // Is projectId Set boolean method
    @JsonIgnore
    public boolean isProjectIdSet() {
        return isSet.contains("projectId");
    }


    //endregion

}
