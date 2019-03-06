package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsProvisioningTimeout {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer timeout;
    private String timeoutAction;
    // endregion

    //region Constructor
    public ApiMrScalerAwsProvisioningTimeout() { isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region timeout
    public Integer getTimeout(){ return timeout; }

    public void setTimeout(Integer timeout){
        isSet.add("timeout");
        this.timeout = timeout;
    }

    public Boolean isTimeoutSet(){ return isSet.contains("timeout"); }
    // endregion

    // region timeoutAction
    public String  getTimeoutAction(){ return timeoutAction; }

    public void setTimeoutAction(String timeoutAction){
        isSet.add("timeoutAction");
        this.timeoutAction = timeoutAction;
    }

    public Boolean isTimeoutActionSet(){ return isSet.contains("timeoutAction"); }
    // endregion
    // endregion
    public static class Builder {
        private ApiMrScalerAwsProvisioningTimeout provisioningTimeout;

        private Builder(){ this.provisioningTimeout = new ApiMrScalerAwsProvisioningTimeout(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setTimeout(final Integer timeout){
            provisioningTimeout.setTimeout(timeout);
            return this;
        }
        public Builder setTimeoutAction(final String timeoutAction){
            provisioningTimeout.setTimeoutAction(timeoutAction);
            return this;
        }

        public ApiMrScalerAwsProvisioningTimeout build(){
            return provisioningTimeout;
        }
        // endregion
    }
}
