package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiNewVmsAzure implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String      createdAt;
    private String      lifeCycle;
    private String      os;
    private String      powerState;
    private Integer     privateIp;
    private String      provisioningState;
    private Integer     publicIp;
    private String      region;
    private String      vmName;
    private String      vmSize;

    public ApiNewVmsAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        isSet.add("os");
        this.os = os;
    }

    public String getPowerState() {
        return powerState;
    }

    public void setPowerState(String powerState) {
        isSet.add("powerState");
        this.powerState = powerState;
    }

    public Integer getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(Integer privateIp) {
        isSet.add("privateIp");
        this.privateIp = privateIp;
    }

    public String getProvisioningState() {
        return provisioningState;
    }

    public void setProvisioningState(String provisioningState) {
        isSet.add("provisioningState");
        this.provisioningState = provisioningState;
    }

    public Integer getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(Integer publicIp) {
        isSet.add("publicIp");
        this.publicIp = publicIp;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public String getVmSize() {
        return vmSize;
    }

    public void setVmSize(String vmSize) {
        isSet.add("vmSize");
        this.vmSize = vmSize;
    }


    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
    }

    @JsonIgnore
    public boolean isOsSet() {
        return isSet.contains("os");
    }

    @JsonIgnore
    public boolean isPowerStateSet() {
        return isSet.contains("powerState");
    }

    @JsonIgnore
    public boolean isPrivateIpSet() {
        return isSet.contains("privateIp");
    }

    @JsonIgnore
    public boolean isProvisioningStateSet() {
        return isSet.contains("provisioningState");
    }

    @JsonIgnore
    public boolean isPublicIpSet() {
        return isSet.contains("publicIp");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }

    @JsonIgnore
    public boolean isVmSizeSet() {
        return isSet.contains("vmSize");
    }
}
