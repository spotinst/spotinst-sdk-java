package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiAksDetachInstances implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>      isSet;
    private List<String>     vmsToDetach;

    public ApiAksDetachInstances() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getVmsToDetach() {
        return vmsToDetach;
    }

    public void setVmsToDetach(List<String> vmsToDetach) {
        isSet.add("vmsToDetach");
        this.vmsToDetach = vmsToDetach;
    }

    @JsonIgnore
    public boolean isVmsToDetachSet() {
        return isSet.contains("vmsToDetach");
    }
}