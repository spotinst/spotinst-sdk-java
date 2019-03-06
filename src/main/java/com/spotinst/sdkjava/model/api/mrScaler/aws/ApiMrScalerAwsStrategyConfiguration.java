package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsStrategyConfiguration {
    // region Members
    @JsonIgnore
    private Set<String> isSet;
    private ApiMrScalerAwsCloneStrategy clone;
    private ApiMrScalerAwsNewStrategy newing;
    private ApiMrScalerAwsWrapStrategy wrap;
    private ApiMrScalerAwsProvisioningTimeout provisioningTimeout;
    // endregion

    //region Constructor
    public ApiMrScalerAwsStrategyConfiguration() {
        isSet = new HashSet<>();

    }
    // endregion

    // region getters and setters
    // region Clone
    public ApiMrScalerAwsCloneStrategy getClone(){ return clone; }

    public void setClone(ApiMrScalerAwsCloneStrategy clone){
        isSet.add("clone");
        this.clone = clone;
    }

    public Boolean isCloneSet(){
        return isSet.contains("clone");
    }
    // endregion

    // region New
    public ApiMrScalerAwsNewStrategy getNew(){ return newing; }

    public void setNew(ApiMrScalerAwsNewStrategy newing){
        isSet.add("new");
        this.newing = newing;
    }

    public Boolean isNewSet(){
        return isSet.contains("new");
    }
    // endregion

    // region Wrap
    public ApiMrScalerAwsWrapStrategy getWrap() { return wrap; }

    public void setWrap(ApiMrScalerAwsWrapStrategy wrap){
        isSet.add("wrap");
        this.wrap = wrap;
    }

    public Boolean isWrapSet(){
        return isSet.contains("wrap");
    }
    // endregion

    // region Provisioning Timeout
    public ApiMrScalerAwsProvisioningTimeout getProvisioningTimeout() { return provisioningTimeout; }

    public void setProvisioningTimeout(ApiMrScalerAwsProvisioningTimeout provisioningTimeout){
        isSet.add("provisioningTimeout");
        this.provisioningTimeout = provisioningTimeout;
    }

    public Boolean isProvisioningTimeoutSet(){
        return isSet.contains("provisioningTimeout");
    }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsStrategyConfiguration mrScalerAwsStrategyConfiguration;

        private Builder(){ this.mrScalerAwsStrategyConfiguration = new ApiMrScalerAwsStrategyConfiguration(); }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;

        }

        // Build methods
        public Builder setClone(final ApiMrScalerAwsCloneStrategy clone){
            mrScalerAwsStrategyConfiguration.setClone(clone);
            return this;
        }
        public Builder setNew(final ApiMrScalerAwsNewStrategy newing){
            mrScalerAwsStrategyConfiguration.setNew(newing);
            return this;
        }
        public Builder setWrap(final ApiMrScalerAwsWrapStrategy wrap){
            mrScalerAwsStrategyConfiguration.setWrap(wrap);
            return this;
        }
        public Builder setProvisioningTimeout(final ApiMrScalerAwsProvisioningTimeout provisioningTimeout){
            mrScalerAwsStrategyConfiguration.setProvisioningTimeout(provisioningTimeout);
            return this;
        }

        public ApiMrScalerAwsStrategyConfiguration build(){
            return mrScalerAwsStrategyConfiguration;
        }
        // endregion
    }
}
