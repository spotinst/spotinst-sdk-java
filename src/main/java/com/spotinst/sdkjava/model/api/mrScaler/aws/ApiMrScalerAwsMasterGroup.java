package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsMasterGroup implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                     isSet;
    private List<String>                    instanceTypes;
    private Integer                         target;
    private String                          lifeCycle;
    private ApiMrScalerAwsFile              configurations;
    private ApiMrScalerAwsEbsConfiguration  ebsConfiguration;

    public ApiMrScalerAwsMasterGroup() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getInstanceTypes(){ return instanceTypes; }

    public void setInstanceTypes(List<String> instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public Integer getTarget(){ return target; }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }

    public String getLifeCycle(){ return lifeCycle; }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public ApiMrScalerAwsFile getConfigurations(){ return configurations; }

    public void setConfigurations(ApiMrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    public ApiMrScalerAwsEbsConfiguration getEbsConfiguration(){ return ebsConfiguration; }

    public void setEbsConfiguration(ApiMrScalerAwsEbsConfiguration ebsConfiguration) {
        isSet.add("ebsConfiguration");
        this.ebsConfiguration = ebsConfiguration;
    }

    @JsonIgnore
    public Boolean isInstanceTypesSet(){ return isSet.contains("instanceTypes"); }

    @JsonIgnore
    public Boolean isTargetSet(){ return isSet.contains("target"); }

    @JsonIgnore
    public Boolean isLifeCycleSet(){ return isSet.contains("lifeCycle"); }

    @JsonIgnore
    public Boolean isConfigurationsSet(){ return isSet.contains("configurations"); }

    @JsonIgnore
    public Boolean isEbsConfigurationSet(){ return isSet.contains("ebsConfiguration"); }

}
