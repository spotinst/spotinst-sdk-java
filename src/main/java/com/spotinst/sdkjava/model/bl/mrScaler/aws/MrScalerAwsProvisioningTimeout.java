package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsProvisioningTimeout {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     timeout;
    private String      timeoutAction;

    private MrScalerAwsProvisioningTimeout() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        isSet.add("timeout");
        this.timeout = timeout;
    }

    public String getTimeoutAction() {
        return timeoutAction;
    }

    public void setTimeoutAction(String timeoutAction) {
        isSet.add("timeoutAction");
        this.timeoutAction = timeoutAction;
    }

    public static class Builder {
        private MrScalerAwsProvisioningTimeout provisioningTimeout;

        private Builder(){ this.provisioningTimeout = new MrScalerAwsProvisioningTimeout(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setTimeout(final Integer timeout){
            provisioningTimeout.setTimeout(timeout);
            return this;
        }
        public Builder setTimeoutAction(final String timeoutAction){
            provisioningTimeout.setTimeoutAction(timeoutAction);
            return this;
        }

        public MrScalerAwsProvisioningTimeout build(){
            return provisioningTimeout;
        }
    }

    @JsonIgnore
    public Boolean isTimeoutSet(){ return isSet.contains("timeout"); }

    @JsonIgnore
    public Boolean isTimeoutActionSet(){ return isSet.contains("timeoutAction"); }
}
