package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupDetachedVmsAzure implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private List<ApiDetachedVmsAzure> detachedVms;
    @JsonProperty("newVms")
    private List<ApiNewVmsAzure>      newVmsAzure;

    public ApiElastigroupDetachedVmsAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiDetachedVmsAzure> getDetachedVms() {
        return detachedVms;
    }

    public void setDetachedVms(List<ApiDetachedVmsAzure> detachedVms) {
        isSet.add("detachedVms");
        this.detachedVms = detachedVms;
    }

    public List<ApiNewVmsAzure> getNewVmsAzure() {
        return newVmsAzure;
    }

    public void setNewVmsAzure(List<ApiNewVmsAzure> newVmsAzure) {
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
