package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsMasterGroup {
    @JsonIgnore
    private Set<String>                   isSet;
    private List<String>                  instanceTypes;
    private Integer                       target;
    private String                        lifeCycle;
    private MrScalerAwsFile configurations;
    private MrScalerAwsEbsConfiguration ebsConfiguration;

    private MrScalerAwsMasterGroup() {  isSet = new HashSet<>(); }

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

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public MrScalerAwsFile getConfigurations() {
        return configurations;
    }

    public void setConfigurations(MrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    public MrScalerAwsEbsConfiguration getEbsConfiguration() {
        return ebsConfiguration;
    }

    public void setEbsConfiguration(MrScalerAwsEbsConfiguration ebsConfiguration) {
        isSet.add("ebsConfiguration");
        this.ebsConfiguration = ebsConfiguration;
    }

    public static class Builder {
        private MrScalerAwsMasterGroup masterGroup;

        private Builder() {this.masterGroup = new MrScalerAwsMasterGroup(); }

        public static Builder get(){
            return new Builder();
        }

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
        public Builder setConfigurations(final MrScalerAwsFile configurations){
            masterGroup.setConfigurations(configurations);
            return this;
        }
        public Builder setEbsConfiguration(final MrScalerAwsEbsConfiguration ebsConfiguration){
            masterGroup.setEbsConfiguration(ebsConfiguration);
            return this;
        }

        public MrScalerAwsMasterGroup build(){
            return masterGroup;
        }
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
