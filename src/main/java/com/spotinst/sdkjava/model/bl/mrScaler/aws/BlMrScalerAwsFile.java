package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class BlMrScalerAwsFile {
    //region Members
    private BlMrScalerAwsFileParams file;
    // endregion

    //region Constructor
    public BlMrScalerAwsFile() { }
    // endregion

    // region methods
    // region file
    public BlMrScalerAwsFileParams getFile(){ return file; }

    public void setFile(BlMrScalerAwsFileParams file) {
        this.file = file;
    }
    // endregion
    // endregion
}
