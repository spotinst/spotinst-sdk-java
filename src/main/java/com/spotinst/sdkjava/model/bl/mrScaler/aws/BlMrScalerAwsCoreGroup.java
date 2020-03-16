package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ElastigroupCapacityConfiguration;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsCoreGroup {
    //region Members
    private List<String>                     instanceTypes;
    private ElastigroupCapacityConfiguration capacity;
    private String                           lifeCycle;
    private BlMrScalerAwsEbsConfiguration    ebsConfiguration;
    private BlMrScalerAwsFile                configurations;
    private Integer                          target;

    // endregion

    //region Constructor
    public BlMrScalerAwsCoreGroup() {
    }
    // endregion

    // region methods
    // region instanceTypes
    public List<String> getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(List<String> instanceTypes) {
        this.instanceTypes = instanceTypes;
    }
    // endregion

    // region capacity
    public ElastigroupCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ElastigroupCapacityConfiguration capacity) {
        this.capacity = capacity;
    }
    // endregion

    // region lifeCycle
    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }
    // endregion

    // region ebsConfiguration
    public BlMrScalerAwsEbsConfiguration getEbsConfiguration() {
        return ebsConfiguration;
    }

    public void setEbsConfiguration(BlMrScalerAwsEbsConfiguration ebsConfiguration) {
        this.ebsConfiguration = ebsConfiguration;
    }
    // endregion

    // region configurations
    public BlMrScalerAwsFile getConfigurations() {
        return configurations;
    }

    public void setConfigurations(BlMrScalerAwsFile configurations) {
        this.configurations = configurations;
    }
    // endregion

    // region target
    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
    // endregion

    // endregion
}
