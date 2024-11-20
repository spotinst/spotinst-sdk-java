package com.spotinst.sdkjava.model.api.gcp;

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
public class ApiElastigroupCustomInstanceTypesGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>     isSet;
    private Integer         memoryGiB;
    private Integer         vCPU;

    public ApiElastigroupCustomInstanceTypesGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getMemoryGiB() {
        return memoryGiB;
    }

    public void setMemoryGiB(Integer memoryGiB) {
        isSet.add("memoryGiB");
        this.memoryGiB = memoryGiB;
    }

    public Integer getVCPU() {
        return vCPU;
    }

    public void setVCPU(Integer vCPU) {
        isSet.add("vCPU");
        this.vCPU = vCPU;
    }

    @JsonIgnore
    public boolean isMemoryGiBSet() {
        return isSet.contains("memoryGiB");
    }

    @JsonIgnore
    public boolean isVCPUSet() { return isSet.contains("vCPU"); }
}
