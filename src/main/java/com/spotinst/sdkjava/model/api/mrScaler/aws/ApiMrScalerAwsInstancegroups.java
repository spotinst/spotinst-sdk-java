package com.spotinst.sdkjava.model.api.mrScaler.aws;

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
public class ApiMrScalerAwsInstancegroups implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                 isSet;
    private ApiMrScalerAwsMasterGroup   masterGroup;
    private ApiMrScalerAwsCoreGroup     coreGroup;
    private ApiMrScalerAwsTaskGroup     taskGroup;

    public ApiMrScalerAwsInstancegroups() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiMrScalerAwsMasterGroup getMasterGroup(){ return masterGroup; }

    public void setMasterGroup(ApiMrScalerAwsMasterGroup masterGroup) {
        isSet.add("masterGroup");
        this.masterGroup = masterGroup;
    }

    public ApiMrScalerAwsCoreGroup getCoreGroup(){ return coreGroup; }

    public void setCoreGroup(ApiMrScalerAwsCoreGroup coreGroup) {
        isSet.add("coreGroup");
        this.coreGroup = coreGroup;
    }

    public ApiMrScalerAwsTaskGroup getTaskGroup(){ return taskGroup; }

    public void setTaskGroup(ApiMrScalerAwsTaskGroup taskGroup) {
        isSet.add("taskGroup");
        this.taskGroup = taskGroup;
    }

    @JsonIgnore
    public Boolean isMasterGroupSet(){ return isSet.contains("masterGroup"); }

    @JsonIgnore
    public Boolean isCoreGroupSet(){ return isSet.contains("coreGroup"); }

    @JsonIgnore
    public Boolean isTaskGroupSet(){ return isSet.contains("taskGroup"); }


}
