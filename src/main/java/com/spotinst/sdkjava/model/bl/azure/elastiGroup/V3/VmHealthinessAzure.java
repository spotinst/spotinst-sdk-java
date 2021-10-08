package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.VmHealthStatusEnumAzure;
import com.spotinst.sdkjava.enums.VmLifecycleEnumAzure;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmHealthinessAzure {

    @JsonIgnore
    private Set<String>             isSet;
    private VmHealthStatusEnumAzure healthStatus;
    private VmLifecycleEnumAzure    lifeCycle;
    private String                  vmName;

    private VmHealthinessAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public VmHealthStatusEnumAzure getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(VmHealthStatusEnumAzure healthStatus) {
        isSet.add("healthStatus");
        this.healthStatus = healthStatus;
    }

    public VmLifecycleEnumAzure getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(VmLifecycleEnumAzure lifeCycle) {
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

    public static class Builder {
        private VmHealthinessAzure vmHealthiness;

        private Builder() {
            this.vmHealthiness = new VmHealthinessAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setHealthStatus(final VmHealthStatusEnumAzure healthStatus) {
            vmHealthiness.setHealthStatus(healthStatus);
            return this;
        }

        public Builder setLifeCycle(final VmLifecycleEnumAzure lifeCycle) {
            vmHealthiness.setLifeCycle(lifeCycle);
            return this;
        }

        public Builder setVmName(final String vmName) {
            vmHealthiness.setVmName(vmName);
            return this;
        }

        public VmHealthinessAzure build() {
            return vmHealthiness;
        }

    }


    @JsonIgnore
    public boolean isHealthStatusSet() {
        return isSet.contains("healthStatus");
    }

    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }
}
