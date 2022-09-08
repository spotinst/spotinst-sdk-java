package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class VmsDetails {
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                vmName;
    private String                                vmSize;
    private String                             lifeCycle;

    private VmsDetails() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public static class Builder {
        private VmsDetails launchSpecification;

        private Builder() {
            this.launchSpecification = new VmsDetails();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVmName(final String vmName) {
            launchSpecification.setVmName(vmName);
            return this;
        }

        public Builder setVmSize(final String vmSize) {
            launchSpecification.setVmSize(vmSize);
            return this;
        }

        public Builder setLifeCycle(final String lifeCycle) {
            launchSpecification.setLifeCycle(lifeCycle);
            return this;
        }

        public VmsDetails build() {
            // Validations
            return launchSpecification;
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