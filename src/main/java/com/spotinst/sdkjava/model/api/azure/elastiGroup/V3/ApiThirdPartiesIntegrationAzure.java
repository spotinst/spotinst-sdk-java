package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
class ApiThirdPartiesIntegrationAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private ApiEcsAzure      ecs;
    //endregion

    //region Constructor

    public ApiThirdPartiesIntegrationAzure() {
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

    public ApiEcsAzure getEcs() {
        return ecs;
    }

    public void setEcs(ApiEcsAzure ecs) {
        isSet.add("ecs");
        this.ecs = ecs;
    }

    //endregion
    //region isSet methods
    // Is deviceName Set boolean method
    @JsonIgnore
    public boolean isEcsSet() {
        return isSet.contains("ecs");
    }

    //endregion

}
