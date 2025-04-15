package com.spotinst.sdkjava.model.api.mrScaler.aws;

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
public class ApiMrScalerScaleUpAws implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> modifiedInstanceGroups;
    private List<String> newInstanceGroups;

    public ApiMrScalerScaleUpAws() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getModifiedInstanceGroups() {
        return modifiedInstanceGroups;
    }

    public void setModifiedInstanceGroups(List<String> modifiedInstanceGroups) {
        isSet.add("modifiedInstanceGroups");
        this.modifiedInstanceGroups = modifiedInstanceGroups;
    }

    public List<String> getNewInstanceGroups() {
        return newInstanceGroups;
    }

    public void setNewInstanceGroups(List<String> newInstanceGroups) {
        isSet.add("newInstanceGroups");
        this.newInstanceGroups = newInstanceGroups;
    }

    @JsonIgnore
    public Boolean isModifiedInstanceGroupsSet(){
        return isSet.contains("modifiedInstanceGroups");
    }

    @JsonIgnore
    public Boolean isNewInstanceGroupsSet(){
        return isSet.contains("newInstanceGroups");
    }
}