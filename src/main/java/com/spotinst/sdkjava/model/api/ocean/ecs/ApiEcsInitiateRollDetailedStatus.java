package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiInitiateRollResponseOldInstances;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiEcsInitiateRollDetailedStatus implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                   isSet;
    private List<ApiEcsInitiateRollResponseOldInstances>  oldInstances;


    public ApiEcsInitiateRollDetailedStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiEcsInitiateRollResponseOldInstances> getOldInstances() {
        return oldInstances;
    }

    public void setOldInstances(List<ApiEcsInitiateRollResponseOldInstances> oldInstances) {
        isSet.add("oldInstances");
        this.oldInstances = oldInstances;
    }

    @JsonIgnore
    public boolean isOldInstancesSet() {
        return isSet.contains("oldInstances");
    }
}