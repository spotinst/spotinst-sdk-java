package com.spotinst.sdkjava.model.bl.mrScaler.aws;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsFile {
    //region Members
    private BlMrScalerAwsFileParams file;
    // endregion

    //region Constructor
    public BlMrScalerAwsFile() {
    }
    // endregion

    // region methods
    // region file
    public BlMrScalerAwsFileParams getFile() {
        return file;
    }

    public void setFile(BlMrScalerAwsFileParams file) {
        this.file = file;
    }
    // endregion
    // endregion
}
