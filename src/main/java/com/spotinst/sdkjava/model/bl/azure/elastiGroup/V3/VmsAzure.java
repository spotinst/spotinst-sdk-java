package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiVmsAzure;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmsAzure {
    @JsonIgnore
    private Set<String> isSet;
    private String      createdAt;
    private String      lifeCycle;
    private String      os;
    private String      powerState;
    private String      privateIp;
    private String      provisioningState;
    private String      publicIp;
    private String      region;
    private String      vmName;
    private String      vmSize;

    private VmsAzure() {
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

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
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

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
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

    public static class Builder {
        private VmsAzure vmsAzure;

        private Builder() {
            this.vmsAzure = new VmsAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCreatedAt(final String createdAt) {
            vmsAzure.setCreatedAt(createdAt);
            return this;
        }

        public Builder setLifeCycle(final String lifeCycle) {
            vmsAzure.setLifeCycle(lifeCycle);
            return this;
        }

        public Builder setOs(final String os) {
            vmsAzure.setOs(os);
            return this;
        }

        public Builder setPowerState(final String powerState) {
            vmsAzure.setPowerState(powerState);
            return this;
        }

        public Builder setPrivateIp(final String privateIp) {
            vmsAzure.setPrivateIp(privateIp);
            return this;
        }

        public Builder setProvisioningState(final String provisioningState) {
            vmsAzure.setProvisioningState(provisioningState);
            return this;
        }

        public Builder setPublicIp(final String publicIp) {
            vmsAzure.setPublicIp(publicIp);
            return this;
        }

        public Builder setRegion(final String region) {
            vmsAzure.setRegion(region);
            return this;
        }

        public Builder setVmName(final String vmName) {
            vmsAzure.setVmName(vmName);
            return this;
        }

        public Builder setVmSize(final String vmSize) {
            vmsAzure.setVmSize(vmSize);
            return this;
        }

        public VmsAzure build() {
            return vmsAzure;
        }
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
