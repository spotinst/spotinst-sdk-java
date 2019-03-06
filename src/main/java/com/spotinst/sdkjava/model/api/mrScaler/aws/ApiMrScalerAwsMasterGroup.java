package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ApiMrScalerAwsMasterGroup {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<String> instanceTypes;
    private Integer target;
    private String lifeCycle;
    private ApiMrScalerAwsFile configurations;
    private ApiMrScalerAwsEbsConfiguration ebsConfiguration;
    // endregion

    //region Constructor
    public ApiMrScalerAwsMasterGroup() {  isSet = new HashSet<>(); }
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

    // region target
    public Integer getTarget(){ return target; }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }

    public Boolean isTargetSet(){ return isSet.contains("target"); }
    // endregion

    // region lifeCycle
    public String getLifeCycle(){ return lifeCycle; }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public Boolean isLifeCycleSet(){ return isSet.contains("lifeCycle"); }
    // endregion

    // region instanceTypes
    public ApiMrScalerAwsFile getConfigurations(){ return configurations; }

    public void setConfigurations(ApiMrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    public Boolean isConfigurationsSet(){ return isSet.contains("configurations"); }
    // endregion

    // region ebsConfiguration
    public ApiMrScalerAwsEbsConfiguration getEbsConfiguration(){ return ebsConfiguration; }

    public void setEbsConfiguration(ApiMrScalerAwsEbsConfiguration ebsConfiguration) {
        isSet.add("ebsConfiguration");
        this.ebsConfiguration = ebsConfiguration;
    }

    public Boolean isEbsConfigurationSet(){ return isSet.contains("ebsConfiguration"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsMasterGroup masterGroup;

        private Builder() {this.masterGroup = new ApiMrScalerAwsMasterGroup(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods

        public Builder setInstanceTypes(final List<String> instanceTypes){
            masterGroup.setInstanceTypes(instanceTypes);
            return this;
        }
        public Builder setTarget(final Integer target){
            masterGroup.setTarget(target);
            return this;
        }
        public Builder setLifeCycle(final String lifeCycle){
            masterGroup.setLifeCycle(lifeCycle);
            return this;
        }
        public Builder setConfigurations(final ApiMrScalerAwsFile configurations){
            masterGroup.setConfigurations(configurations);
            return this;
        }
        public Builder setEbsConfiguration(final ApiMrScalerAwsEbsConfiguration ebsConfiguration){
            masterGroup.setEbsConfiguration(ebsConfiguration);
            return this;
        }

        public ApiMrScalerAwsMasterGroup build(){
            return masterGroup;
        }
        // endregion
    }
}
