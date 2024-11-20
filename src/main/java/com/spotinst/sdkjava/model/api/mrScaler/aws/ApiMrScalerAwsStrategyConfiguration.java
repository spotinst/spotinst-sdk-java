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
public class ApiMrScalerAwsStrategyConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private ApiMrScalerAwsCloneStrategy         cloning;
    private ApiMrScalerAwsNewStrategy           newing;
    private ApiMrScalerAwsWrapStrategy          wrapping;
    private ApiMrScalerAwsProvisioningTimeout   provisioningTimeout;

    public ApiMrScalerAwsStrategyConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiMrScalerAwsCloneStrategy getCloning(){ return cloning; }

    public void setCloning(ApiMrScalerAwsCloneStrategy cloning){
        isSet.add("cloning");
        this.cloning = cloning;
    }

    public ApiMrScalerAwsNewStrategy getNew(){ return newing; }

    public void setNew(ApiMrScalerAwsNewStrategy newing){
        isSet.add("new");
        this.newing = newing;
    }

    public ApiMrScalerAwsWrapStrategy getWrapping() { return wrapping; }

    public void setWrapping(ApiMrScalerAwsWrapStrategy wrapping){
        isSet.add("wrapping");
        this.wrapping = wrapping;
    }

    public ApiMrScalerAwsProvisioningTimeout getProvisioningTimeout() { return provisioningTimeout; }

    public void setProvisioningTimeout(ApiMrScalerAwsProvisioningTimeout provisioningTimeout){
        isSet.add("provisioningTimeout");
        this.provisioningTimeout = provisioningTimeout;
    }

    @JsonIgnore
    public Boolean isCloningSet(){
        return isSet.contains("cloning");
    }

    @JsonIgnore
    public Boolean isNewSet(){
        return isSet.contains("new");
    }

    @JsonIgnore
    public Boolean isWrappingSet(){
        return isSet.contains("wrapping");
    }

    @JsonIgnore
    public Boolean isProvisioningTimeoutSet(){
        return isSet.contains("provisioningTimeout");
    }
}
