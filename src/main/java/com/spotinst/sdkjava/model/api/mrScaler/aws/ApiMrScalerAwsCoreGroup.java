package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.ElastigroupCapacityConfiguration;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ApiMrScalerAwsCoreGroup {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<String> instanceTypes;
    private ElastigroupCapacityConfiguration capacity;
    private String lifeCycle;
    private ApiMrScalerAwsEbsConfiguration ebsConfiguration;
    private ApiMrScalerAwsFile configurations;
    private Integer target;

    // endregion

    //region Constructor
    public ApiMrScalerAwsCoreGroup() {  isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region instanceTypes
    public List<String> getInstanceTypes(){ return instanceTypes; }

    public void setInstanceTypes(List<String> instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public Boolean isInstanceTypesSet(){ return isSet.contains("instanceTypes"); }
    // endregion

    // region capacity
    public ElastigroupCapacityConfiguration getCapacity(){ return capacity; }

    public void setCapacity(ElastigroupCapacityConfiguration capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public Boolean isCapacitySet(){ return isSet.contains("capacity"); }
    // endregion

    // region lifeCycle
    public String getLifeCycle(){ return lifeCycle; }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public Boolean isLifeCycle(){ return isSet.contains("lifeCycle"); }
    // endregion

    // region ebsConfiguration
    public ApiMrScalerAwsEbsConfiguration getEbsConfiguration(){ return ebsConfiguration; }

    public void setEbsConfiguration(ApiMrScalerAwsEbsConfiguration ebsConfiguration) {
        isSet.add("ebsConfiguration");
        this.ebsConfiguration = ebsConfiguration;
    }

    public Boolean isEbsConfigurationSet(){ return isSet.contains("ebsConfiguration"); }
    // endregion

    // region configurations
    public ApiMrScalerAwsFile getConfigurations(){ return configurations; }

    public void setConfigurations(ApiMrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    public Boolean isConfigurations(){ return isSet.contains("configurations"); }
    // endregion

    // region target
    public Integer getTarget(){ return target; }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }

    public Boolean isTargetSet(){ return isSet.contains("target"); }
    // endregion

    // endregion

    public static class Builder {
        private ApiMrScalerAwsCoreGroup coreGroup;

        private Builder(){this.coreGroup= new ApiMrScalerAwsCoreGroup();}

        public static Builder get(){
            return new Builder();
        }

        // region build methods
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
        public Builder setEbsConfiguration(ApiMrScalerAwsEbsConfiguration ebsConfiguration){
            coreGroup.setEbsConfiguration(ebsConfiguration);
            return this;
        }
        public Builder setConfigurations(ApiMrScalerAwsFile configurations){
            coreGroup.setConfigurations(configurations);
            return this;
        }
        public Builder setTarget(Integer target){
            coreGroup.setTarget(target);
            return this;
        }

        public ApiMrScalerAwsCoreGroup build(){
            return coreGroup;
        }
        // endregion
    }
}
