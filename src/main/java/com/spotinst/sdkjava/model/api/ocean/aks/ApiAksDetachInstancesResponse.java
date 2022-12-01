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
public class ApiAksDetachInstancesResponse implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>              isSet;
    private List<ApiDetachedVms>     detachedVms;

    public ApiAksDetachInstancesResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiDetachedVms> getDetachedVms() {
        return detachedVms;
    }

    public void setDetachedVms(List<ApiDetachedVms> detachedVms) {
        isSet.add("detachedVms");
        this.detachedVms = detachedVms;
    }

    @JsonIgnore
    public boolean isDetachedVmsSet() {
        return isSet.contains("detachedVms");
    }


}