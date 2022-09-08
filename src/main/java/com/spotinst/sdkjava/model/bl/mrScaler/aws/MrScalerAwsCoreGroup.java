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
public class MrScalerAwsCoreGroup {
    @JsonIgnore
    private Set<String>                      isSet;
    private List<String>                     instanceTypes;
    private ElastigroupCapacityConfiguration capacity;
    private String                           lifeCycle;
    private MrScalerAwsEbsConfiguration ebsConfiguration;
    private MrScalerAwsFile configurations;
    private Integer                          target;

    private MrScalerAwsCoreGroup() {  isSet = new HashSet<>(); }

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

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }


    public static class Builder {
        private MrScalerAwsCoreGroup coreGroup;

        private Builder(){this.coreGroup= new MrScalerAwsCoreGroup();}

        public static Builder get(){
            return new Builder();
        }

        public Builder setInstanceTypes(List<String> instanceTypes){
            coreGroup.setInstanceTypes(instanceTypes);
            return this;
        }
        public Builder setCapacity(ElastigroupCapacityConfiguration capacity){
            coreGroup.setCapacity(capacity);
            return this;
        }
        public Builder setLifeCycle(String lifeCycle){
            coreGroup.setLifeCycle(lifeCycle);
            return this;
        }
        public Builder setEbsConfiguration(MrScalerAwsEbsConfiguration ebsConfiguration){
            coreGroup.setEbsConfiguration(ebsConfiguration);
            return this;
        }
        public Builder setConfigurations(MrScalerAwsFile configurations){
            coreGroup.setConfigurations(configurations);
            return this;
        }
        public Builder setTarget(Integer target){
            coreGroup.setTarget(target);
            return this;
        }

        public MrScalerAwsCoreGroup build(){
            return coreGroup;
        }
    }

    @JsonIgnore
    public Boolean isInstanceTypesSet(){ return isSet.contains("instanceTypes"); }

    @JsonIgnore
    public Boolean isCapacitySet(){ return isSet.contains("capacity"); }

    @JsonIgnore
    public Boolean isLifeCycleSet(){ return isSet.contains("lifeCycle"); }

    @JsonIgnore
    public Boolean isConfigurationsSet(){ return isSet.contains("configurations"); }

    @JsonIgnore
    public Boolean isEbsConfigurationSet(){ return isSet.contains("ebsConfiguration"); }

    @JsonIgnore
    public Boolean isTargetSet(){ return isSet.contains("target"); }

}
