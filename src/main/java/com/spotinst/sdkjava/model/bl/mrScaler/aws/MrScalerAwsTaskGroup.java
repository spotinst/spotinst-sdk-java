package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ElastigroupCapacityConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsTaskGroup {
    @JsonIgnore
    private Set<String>                      isSet;
    private List<String>                     instanceTypes;
    private ElastigroupCapacityConfiguration capacity;
    private String                           lifeCycle;
    private MrScalerAwsEbsConfiguration ebsConfiguration;
    private MrScalerAwsFile configurations;

    private MrScalerAwsTaskGroup() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(List<String> instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public ElastigroupCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ElastigroupCapacityConfiguration capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public MrScalerAwsEbsConfiguration getEbsConfiguration() {
        return ebsConfiguration;
    }

    public void setEbsConfiguration(MrScalerAwsEbsConfiguration ebsConfiguration) {
        isSet.add("ebsConfiguration");
        this.ebsConfiguration = ebsConfiguration;
    }

    public MrScalerAwsFile getConfigurations() {
        return configurations;
    }

    public void setConfigurations(MrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    public static class Builder {
        private MrScalerAwsTaskGroup taskGroup;

        private Builder(){ this.taskGroup = new MrScalerAwsTaskGroup(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setInstanceTypes(List<String> instanceTypes){
            taskGroup.setInstanceTypes(instanceTypes);
            return this;
        }
        public Builder setCapacity(ElastigroupCapacityConfiguration capacity){
            taskGroup.setCapacity(capacity);
            return this;
        }
        public Builder setLifeCycle(String lifeCycle){
            taskGroup.setLifeCycle(lifeCycle);
            return this;
        }
        public Builder setEbsConfiguration(MrScalerAwsEbsConfiguration ebsConfiguration){
            taskGroup.setEbsConfiguration(ebsConfiguration);
            return this;
        }
        public Builder setConfigurations(MrScalerAwsFile configurations){
            taskGroup.setConfigurations(configurations);
            return this;
        }

        public MrScalerAwsTaskGroup build(){
            return taskGroup;
        }
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
