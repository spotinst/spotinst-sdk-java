package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonFilter("PartialUpdateEntityFilter")
public class ApiDetachVmsResponseAzure implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                 isSet;
    private List<ApiDetachVmsResponseDetachedVmsAzure>  detachedVms;
    @JsonProperty("newVms")
    private List<ApiDetachVmsResponseNewVmsAzure>                        newVmsAzure;

    public ApiDetachVmsResponseAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiDetachVmsResponseDetachedVmsAzure> getDetachedVms() {
        return detachedVms;
    }

    public void setDetachedVms(List<ApiDetachVmsResponseDetachedVmsAzure> detachedVms) {
        isSet.add("detachedVms");
        this.detachedVms = detachedVms;
    }

    public List<ApiDetachVmsResponseNewVmsAzure> getNewVmsAzure() {
        return newVmsAzure;
    }

    public void setNewVmsAzure(List<ApiDetachVmsResponseNewVmsAzure> newVmsAzure) {
        isSet.add("newVmsAzure");
        this.newVmsAzure = newVmsAzure;
    }

    @JsonIgnore
    public boolean isDetachedVmsSet() {
        return isSet.contains("detachedVms");
    }

    @JsonIgnore
    public boolean isNewVmsAzureSet() {
        return isSet.contains("newVmsAzure");
    }
}
