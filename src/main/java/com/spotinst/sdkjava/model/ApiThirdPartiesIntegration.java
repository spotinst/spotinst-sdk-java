package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
class ApiThirdPartiesIntegration implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                 isSet;
    private ElastigroupEcsSpecification ecs;
    //endregion

    //region Constructor

    public ApiThirdPartiesIntegration(){isSet = new HashSet<>();}
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupEcsSpecification getEcs() {
        return ecs;
    }

    public void setEcs(ElastigroupEcsSpecification ecs) {
        isSet.add("ecs");
        this.ecs = ecs;
    }
    //endregion
    //region isSet methods
    // Is deviceName Set boolean method
    @JsonIgnore
    public boolean isEcsSet() {return isSet.contains("ecs");}

    //endregion

}
