package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlMrScalerAwsMasterGroup {
    //region Members
    private List<String> instanceTypes;
    private Integer target;
    private String lifeCycle;
    private BlMrScalerAwsFile configurations;
    private BlMrScalerAwsEbsConfiguration ebsConfiguration;
    // endregion

    //region Constructor
    public BlMrScalerAwsMasterGroup() { }
    // endregion

    // region methods
    // region instanceTypes
    public List<String> getInstanceTypes(){ return instanceTypes; }

    public void setInstanceTypes(List<String> instanceTypes) {
        this.instanceTypes = instanceTypes;
    }
    // endregion

    // region target
    public Integer getTarget(){ return target; }

    public void setTarget(Integer target) {
        this.target = target;
    }
    // endregion

    // region lifeCycle
    public String getLifeCycle(){ return lifeCycle; }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }
    // endregion

    // region instanceTypes
    public BlMrScalerAwsFile getConfigurations(){ return configurations; }

    public void setConfigurations(BlMrScalerAwsFile configurations) {
        this.configurations = configurations;
    }
    // endregion

    // region ebsConfiguration
    public BlMrScalerAwsEbsConfiguration getEbsConfiguration(){ return ebsConfiguration; }

    public void setEbsConfiguration(BlMrScalerAwsEbsConfiguration ebsConfiguration) {
        this.ebsConfiguration = ebsConfiguration;
    }
    // endregion
    // endregion
}
