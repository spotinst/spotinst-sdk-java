package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetachedVmsAzure {

    @JsonIgnore
    private Set<String>     isSet;
    private String          lifeCycle;
    private String          os;
    private String          privateIp;
    private String          publicIp;
    private String          region;
    private String          vmName;
    private String          vmSize;

    private DetachedVmsAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        isSet.add("privateIp");
        this.privateIp = privateIp;
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
        private DetachedVmsAzure detachedVms;

        private Builder() {
            this.detachedVms = new DetachedVmsAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setLifeCycle(final String lifeCycle) {
            detachedVms.setLifeCycle(lifeCycle);
            return this;
        }

        public Builder setOs(final String os) {
            detachedVms.setOs(os);
            return this;
        }

        public Builder setPrivateIp(final String privateIp) {
            detachedVms.setPrivateIp(privateIp);
            return this;
        }

        public Builder setPublicIp(final String publicIp) {
            detachedVms.setPublicIp(publicIp);
            return this;
        }

        public Builder setRegion(final String region) {
            detachedVms.setRegion(region);
            return this;
        }

        public Builder setVmName(final String vmName) {
            detachedVms.setVmName(vmName);
            return this;
        }

        public Builder setVmSize(final String vmSize) {
            detachedVms.setVmSize(vmSize);
            return this;
        }

        public DetachedVmsAzure build() {
            return detachedVms;
        }

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
    public boolean isPrivateIpSet() {
        return isSet.contains("privateIp");
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
