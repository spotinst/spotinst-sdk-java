package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsProvisioningTimeout implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     timeout;
    private String      timeoutAction;
    // endregion

    //region Constructor
    public ApiMrScalerAwsProvisioningTimeout() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getTimeout(){ return timeout; }

    public void setTimeout(Integer timeout){
        isSet.add("timeout");
        this.timeout = timeout;
    }

    public String  getTimeoutAction(){ return timeoutAction; }

    public void setTimeoutAction(String timeoutAction){
        isSet.add("timeoutAction");
        this.timeoutAction = timeoutAction;
    }

    @JsonIgnore
    public Boolean isTimeoutSet(){ return isSet.contains("timeout"); }

    @JsonIgnore
    public Boolean isTimeoutActionSet(){ return isSet.contains("timeoutAction"); }
}
