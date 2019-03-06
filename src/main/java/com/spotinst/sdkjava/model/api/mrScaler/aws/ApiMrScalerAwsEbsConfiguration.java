package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ApiMrScalerAwsEbsConfiguration {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean ebsOptimized;
    private List<ApiMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs;
    // endregion


    //region Constructor
    public ApiMrScalerAwsEbsConfiguration() {
        isSet = new HashSet<>();
    }
    // endregion

    // region methods
    // region ebsOptimized
    public Boolean getEbsOptimized() { return ebsOptimized; }

    public void setEbsOptimized(Boolean ebsOptimized) {
        isSet.add("ebsOptimized");
        this.ebsOptimized = ebsOptimized;
    }

    public Boolean isEbsOptimizedSet() { return isSet.contains("ebsOptimized"); }
    // endregion

    // region ebsBlockDeviceConfigs
    public List<ApiMrScalerAwsEbsBlockDeviceConfig> getEbsBlockDeviceConfigs() { return ebsBlockDeviceConfigs; }

    public void setEbsBlockDeviceConfigs(List<ApiMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs) {
        isSet.add("ebsBlockDeviceConfigs");
        this.ebsBlockDeviceConfigs = ebsBlockDeviceConfigs;
    }

    public Boolean isEbsBlockDeviceConfigsSet() { return isSet.contains("ebsBlockDeviceConfigs"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsEbsConfiguration ebsConfiguration;

        private Builder(){ this.ebsConfiguration = new ApiMrScalerAwsEbsConfiguration(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setEbsOptimized(final Boolean ebsOptimized){
            ebsConfiguration.setEbsOptimized(ebsOptimized);
            return this;
        }
        public Builder setEbsBlockDeviceConfigs(final List<ApiMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs){
            ebsConfiguration.setEbsBlockDeviceConfigs(ebsBlockDeviceConfigs);
            return this;
        }

        public ApiMrScalerAwsEbsConfiguration build(){
            return ebsConfiguration;
        }
        // endregion
    }
}
