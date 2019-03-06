package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlMrScalerAwsEbsConfiguration {
    //region Members
    private Boolean ebsOptimized;
    private List<BlMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs;
    // endregion


    //region Constructor
    public BlMrScalerAwsEbsConfiguration() { }
    // endregion

    // region methods
    // region ebsOptimized
    public Boolean getEbsOptimized() { return ebsOptimized; }

    public void setEbsOptimized(Boolean ebsOptimized) {
        this.ebsOptimized = ebsOptimized;
    }
    // endregion

    // region ebsBlockDeviceConfigs
    public List<BlMrScalerAwsEbsBlockDeviceConfig> getEbsBlockDeviceConfigs() { return ebsBlockDeviceConfigs; }

    public void setEbsBlockDeviceConfigs(List<BlMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs) {
        this.ebsBlockDeviceConfigs = ebsBlockDeviceConfigs;
    }
    // endregion
    // endregion

}
