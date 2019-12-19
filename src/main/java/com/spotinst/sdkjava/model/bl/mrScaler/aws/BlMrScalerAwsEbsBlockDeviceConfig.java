package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class BlMrScalerAwsEbsBlockDeviceConfig {
    //region Members
    private Integer volumesPerInstance;
    private BlMrScalerAwsVolumeSpecification volumeSpecification;
    // endregion

    //region Constructor
    public BlMrScalerAwsEbsBlockDeviceConfig() { }
    // endregion

    // region methods
    // region volumesPerInstance
    public Integer getVolumesPerInstance(){ return volumesPerInstance; }

    public void setVolumesPerInstance(Integer volumesPerInstance) {
        this.volumesPerInstance = volumesPerInstance;
    }
    // endregion

    // region volumeSpecification
    public BlMrScalerAwsVolumeSpecification getVolumeSpecification(){ return volumeSpecification; }

    public void setVolumeSpecification(BlMrScalerAwsVolumeSpecification volumeSpecification) {
        this.volumeSpecification = volumeSpecification;
    }
    // endregion
    // endregion
}
