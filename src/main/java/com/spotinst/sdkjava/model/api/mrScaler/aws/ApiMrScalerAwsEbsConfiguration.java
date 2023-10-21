package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsEbsConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                              isSet;
    private Boolean                                  ebsOptimized;
    private List<ApiMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs;

    public ApiMrScalerAwsEbsConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getEbsOptimized() { return ebsOptimized; }

    public void setEbsOptimized(Boolean ebsOptimized) {
        isSet.add("ebsOptimized");
        this.ebsOptimized = ebsOptimized;
    }

    public List<ApiMrScalerAwsEbsBlockDeviceConfig> getEbsBlockDeviceConfigs() { return ebsBlockDeviceConfigs; }

    public void setEbsBlockDeviceConfigs(List<ApiMrScalerAwsEbsBlockDeviceConfig> ebsBlockDeviceConfigs) {
        isSet.add("ebsBlockDeviceConfigs");
        this.ebsBlockDeviceConfigs = ebsBlockDeviceConfigs;
    }

    @JsonIgnore
    public Boolean isEbsOptimizedSet() { return isSet.contains("ebsOptimized"); }

    @JsonIgnore
    public Boolean isEbsBlockDeviceConfigsSet() { return isSet.contains("ebsBlockDeviceConfigs"); }
}
