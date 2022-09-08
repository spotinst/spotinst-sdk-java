package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScalingResponseVms {

    @JsonIgnore
    private Set<String> isSet;
    private String      lifeCycle;
    private String      vmName;
    private String      vmSize;

    private ScalingResponseVms() {
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
        private ScalingResponseVms vmsAzure;

        private Builder() {
            this.vmsAzure = new ScalingResponseVms();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setLifeCycle(final String lifeCycle) {
            vmsAzure.setLifeCycle(lifeCycle);
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

        public ScalingResponseVms build() {
            return vmsAzure;
        }
    }

    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
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
