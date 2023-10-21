package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ElastigroupCapacityConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsTaskGroup implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<String>                        instanceTypes;
    private ElastigroupCapacityConfiguration    capacity;
    private String                              lifeCycle;
    private ApiMrScalerAwsEbsConfiguration      ebsConfiguration;
    private ApiMrScalerAwsFile                  configurations;

    public ApiMrScalerAwsTaskGroup() {  isSet = new HashSet<>(); }

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

    public ElastigroupCapacityConfiguration getCapacity(){ return capacity; }

    public void setCapacity(ElastigroupCapacityConfiguration capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public String getLifeCycle(){ return lifeCycle; }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public ApiMrScalerAwsEbsConfiguration getEbsConfiguration(){ return ebsConfiguration; }

    public void setEbsConfiguration(ApiMrScalerAwsEbsConfiguration ebsConfiguration) {
        isSet.add("ebsConfiguration");
        this.ebsConfiguration = ebsConfiguration;
    }

    public ApiMrScalerAwsFile getConfigurations(){ return configurations; }

    public void setConfigurations(ApiMrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    @JsonIgnore
    public Boolean isInstanceTypesSet(){ return isSet.contains("instanceTypes"); }

    @JsonIgnore
    public Boolean isCapacitySet(){ return isSet.contains("capacity"); }

    @JsonIgnore
    public Boolean isLifeCycleSet(){ return isSet.contains("lifeCycle"); }

    @JsonIgnore
    public Boolean isEbsConfigurationSet(){ return isSet.contains("ebsConfiguration"); }

    @JsonIgnore
    public Boolean isConfigurationsSet(){ return isSet.contains("configurations"); }
}
