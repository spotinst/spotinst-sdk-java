package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsStrategyConfiguration {
    @JsonIgnore
    private Set<String>                      isSet;
    private MrScalerAwsCloneStrategy cloning;
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private MrScalerAwsNewStrategy newing;
    private MrScalerAwsWrapStrategy wrapping;
    private MrScalerAwsProvisioningTimeout provisioningTimeout;

    private MrScalerAwsStrategyConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public MrScalerAwsCloneStrategy getCloning() {
        return cloning;
    }

    public void setCloning(MrScalerAwsCloneStrategy cloning) {
        isSet.add("cloning");
        this.cloning = cloning;
    }

    public MrScalerAwsNewStrategy getNew() {
        return newing;
    }

    public void setNew(MrScalerAwsNewStrategy newing) {
        isSet.add("new");
        this.newing = newing;
    }

    public MrScalerAwsWrapStrategy getWrapping() {
        return wrapping;
    }

    public void setWrapping(MrScalerAwsWrapStrategy wrapping) {
        isSet.add("wrapping");
        this.wrapping = wrapping;
    }

    public MrScalerAwsProvisioningTimeout getProvisioningTimeout() {
        return provisioningTimeout;
    }

    public void setProvisioningTimeout(MrScalerAwsProvisioningTimeout provisioningTimeout) {
        isSet.add("provisioningTimeout");
        this.provisioningTimeout = provisioningTimeout;
    }

    public static class Builder {
        private MrScalerAwsStrategyConfiguration mrScalerAwsStrategyConfiguration;

        private Builder(){ this.mrScalerAwsStrategyConfiguration = new MrScalerAwsStrategyConfiguration(); }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCloning(final MrScalerAwsCloneStrategy cloning){
            mrScalerAwsStrategyConfiguration.setCloning(cloning);
            return this;
        }
        public Builder setNew(final MrScalerAwsNewStrategy newing){
            mrScalerAwsStrategyConfiguration.setNew(newing);
            return this;
        }
        public Builder setWrapping(final MrScalerAwsWrapStrategy wrapping){
            mrScalerAwsStrategyConfiguration.setWrapping(wrapping);
            return this;
        }
        public Builder setProvisioningTimeout(final MrScalerAwsProvisioningTimeout provisioningTimeout){
            mrScalerAwsStrategyConfiguration.setProvisioningTimeout(provisioningTimeout);
            return this;
        }

        public MrScalerAwsStrategyConfiguration build(){
            return mrScalerAwsStrategyConfiguration;
        }
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
