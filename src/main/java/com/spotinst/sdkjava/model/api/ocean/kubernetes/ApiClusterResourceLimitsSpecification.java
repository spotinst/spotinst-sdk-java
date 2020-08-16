package com.spotinst.sdkjava.model.api.ocean.kubernetes;

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
public class ApiClusterResourceLimitsSpecification implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     maxMemoryGib;
    private Integer     maxVCpu;

    public ApiClusterResourceLimitsSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getMaxMemoryGib() {
        return maxMemoryGib;
    }

    public void setMaxMemoryGib(Integer maxMemoryGib) {
        isSet.add("maxMemoryGib");
        this.maxMemoryGib = maxMemoryGib;
    }

    public Integer getMaxVCpu() {
        return maxVCpu;
    }

    public void setMaxVCpu(Integer maxVCpu) {
        isSet.add("maxCPU");
        this.maxVCpu = maxVCpu;
    }

    @JsonIgnore
    public boolean isMaxMemoryGibSet() {
        return isSet.contains("maxMemoryGib");
    }

    @JsonIgnore
    public boolean isMaxVCpuSet() {
        return isSet.contains("maxVCpu");
    }

}
