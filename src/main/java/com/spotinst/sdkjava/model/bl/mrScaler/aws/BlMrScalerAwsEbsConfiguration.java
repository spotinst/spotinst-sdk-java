package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsEbsConfiguration {
    //region Members
    private Boolean                                 ebsOptimized;
    private List<BlMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs;
    // endregion


    //region Constructor
    public BlMrScalerAwsEbsConfiguration() {
    }
    // endregion

    // region methods
    // region ebsOptimized
    public Boolean getEbsOptimized() {
        return ebsOptimized;
    }

    public void setEbsOptimized(Boolean ebsOptimized) {
        this.ebsOptimized = ebsOptimized;
    }
    // endregion

    // region ebsBlockDeviceConfigs
    public List<BlMrScalerAwsEbsBlockDeviceConfig> getEbsBlockDeviceConfigs() {
        return ebsBlockDeviceConfigs;
    }

    public void setEbsBlockDeviceConfigs(List<BlMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs) {
        this.ebsBlockDeviceConfigs = ebsBlockDeviceConfigs;
    }
    // endregion
    // endregion

}
