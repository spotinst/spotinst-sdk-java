package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsProvisioningTimeout {
    //region Members
    private Integer timeout;
    private String  timeoutAction;
    // endregion

    //region Constructor
    public BlMrScalerAwsProvisioningTimeout() {
    }
    // endregion

    // region methods
    // region timeout
    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
    // endregion

    // region timeoutAction
    public String getTimeoutAction() {
        return timeoutAction;
    }

    public void setTimeoutAction(String timeoutAction) {
        this.timeoutAction = timeoutAction;
    }
    // endregion
    // endregion
}
