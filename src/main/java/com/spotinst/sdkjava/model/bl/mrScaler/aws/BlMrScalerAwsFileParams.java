package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class BlMrScalerAwsFileParams {
    //region Members
    private String bucket;
    private String key;

    // endregion

    //region Constructor
    public BlMrScalerAwsFileParams() { }
    // endregion

    // region methods
    // region bucket
    public String getBucket(){ return bucket; }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
    // endregion

    // region key
    public String getKey(){ return key; }

    public void setKey(String key) {
        this.key = key;
    }
    // endregion
    // endregion
}
