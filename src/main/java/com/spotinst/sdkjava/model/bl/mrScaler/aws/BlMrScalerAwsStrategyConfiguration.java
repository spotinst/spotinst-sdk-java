package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsStrategyConfiguration {
    // region Members
    private BlMrScalerAwsCloneStrategy       cloning;
    private BlMrScalerAwsNewStrategy         newing;
    private BlMrScalerAwsWrapStrategy        wrapping;
    private BlMrScalerAwsProvisioningTimeout provisioningTimeout;
    // endregion

    //region Constructor
    public BlMrScalerAwsStrategyConfiguration() {
    }
    // endregion

    // region getters and setters
    // region Clone
    public BlMrScalerAwsCloneStrategy getCloning() {
        return cloning;
    }

    public void setCloning(BlMrScalerAwsCloneStrategy cloning) {
        this.cloning = cloning;
    }
    // endregion

    // region New
    public BlMrScalerAwsNewStrategy getNew() {
        return newing;
    }

    public void setNew(BlMrScalerAwsNewStrategy newing) {
        this.newing = newing;
    }
    // endregion

    // region Wrap
    public BlMrScalerAwsWrapStrategy getWrapping() {
        return wrapping;
    }

    public void setWrapping(BlMrScalerAwsWrapStrategy wrapping) {
        this.wrapping = wrapping;
    }
    // endregion

    // region Provisioning Timeout
    public BlMrScalerAwsProvisioningTimeout getProvisioningTimeout() {
        return provisioningTimeout;
    }

    public void setProvisioningTimeout(BlMrScalerAwsProvisioningTimeout provisioningTimeout) {
        this.provisioningTimeout = provisioningTimeout;
    }
    // endregion
    // endregion
}
