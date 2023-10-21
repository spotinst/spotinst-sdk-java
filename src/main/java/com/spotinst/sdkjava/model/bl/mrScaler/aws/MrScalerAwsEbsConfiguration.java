package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsEbsConfiguration {
    @JsonIgnore
    private Set<String>                             isSet;
    private Boolean                                 ebsOptimized;
    private List<MrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs;

    private MrScalerAwsEbsConfiguration()  {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getEbsOptimized() {
        return ebsOptimized;
    }

    public void setEbsOptimized(Boolean ebsOptimized) {
        isSet.add("ebsOptimized");
        this.ebsOptimized = ebsOptimized;
    }

    public List<MrScalerAwsEbsBlockDeviceConfig> getEbsBlockDeviceConfigs() {
        return ebsBlockDeviceConfigs;
    }

    public void setEbsBlockDeviceConfigs(List<MrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs) {
        isSet.add("ebsBlockDeviceConfigs");
        this.ebsBlockDeviceConfigs = ebsBlockDeviceConfigs;
    }

    public static class Builder {
        private MrScalerAwsEbsConfiguration ebsConfiguration;

        private Builder(){ this.ebsConfiguration = new MrScalerAwsEbsConfiguration(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setEbsOptimized(final Boolean ebsOptimized){
            ebsConfiguration.setEbsOptimized(ebsOptimized);
            return this;
        }
        public Builder setEbsBlockDeviceConfigs(final List<MrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs){
            ebsConfiguration.setEbsBlockDeviceConfigs(ebsBlockDeviceConfigs);
            return this;
        }

        public MrScalerAwsEbsConfiguration build(){
            return ebsConfiguration;
        }
    }

    @JsonIgnore
    public Boolean isEbsOptimizedSet() { return isSet.contains("ebsOptimized"); }

    @JsonIgnore
    public Boolean isEbsBlockDeviceConfigsSet() { return isSet.contains("ebsBlockDeviceConfigs"); }

}
