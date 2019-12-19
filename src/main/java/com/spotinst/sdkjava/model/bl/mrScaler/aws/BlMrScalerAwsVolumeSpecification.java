package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class BlMrScalerAwsVolumeSpecification {
    //region Members
    private String volumeType;
    private Integer sizeInGB;
    private Integer iops;
    // endregion

    //region Constructor
    public BlMrScalerAwsVolumeSpecification() { }
    // endregion

    // region methods
    // region volumeType
    public String getVolumeType(){ return volumeType; }

    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }
    // endregion

    // region sizeInGB
    public Integer getSizeInGB(){ return sizeInGB; }

    public void setSizeInGB(Integer sizeInGB) {
        this.sizeInGB = sizeInGB;
    }
    // endregion

    // region iops
    public Integer getIops(){ return iops; }

    public void setIops(Integer iops) {
        this.iops = iops;
    }
    // endregion
    // endregion
}
