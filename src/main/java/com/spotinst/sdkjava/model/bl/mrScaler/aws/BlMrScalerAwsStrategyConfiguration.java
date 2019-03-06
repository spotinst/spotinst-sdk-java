package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class BlMrScalerAwsStrategyConfiguration {
    // region Members
    private BlMrScalerAwsCloneStrategy clone;
    private BlMrScalerAwsNewStrategy newing;
    private BlMrScalerAwsWrapStrategy wrap;
    private BlMrScalerAwsProvisioningTimeout provisioningTimeout;
    // endregion

    //region Constructor
    public BlMrScalerAwsStrategyConfiguration() { }
    // endregion

    // region getters and setters
    // region Clone
    public BlMrScalerAwsCloneStrategy getClone(){ return clone; }

    public void setClone(BlMrScalerAwsCloneStrategy clone){
        this.clone = clone;
    }
    // endregion

    // region New
    public BlMrScalerAwsNewStrategy getNew(){ return newing; }

    public void setNew(BlMrScalerAwsNewStrategy newing){
        this.newing = newing;
    }
    // endregion

    // region Wrap
    public BlMrScalerAwsWrapStrategy getWrap() { return wrap; }

    public void setWrap(BlMrScalerAwsWrapStrategy wrap){
        this.wrap = wrap;
    }
    // endregion

    // region Provisioning Timeout
    public BlMrScalerAwsProvisioningTimeout getProvisioningTimeout() { return provisioningTimeout; }

    public void setProvisioningTimeout(BlMrScalerAwsProvisioningTimeout provisioningTimeout){
        this.provisioningTimeout = provisioningTimeout;
    }
    // endregion
    // endregion
}
