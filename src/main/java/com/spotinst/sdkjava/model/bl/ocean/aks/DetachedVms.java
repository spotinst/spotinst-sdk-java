package com.spotinst.sdkjava.model.bl.ocean.aks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class DetachedVms {
    @JsonIgnore
    private Set<String>              isSet;
    private String                  vmName;

    public DetachedVms() {
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

    public static class Builder {
        private DetachedVms detachInstances;

        private Builder() {
            this.detachInstances = new DetachedVms();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVmName(final String vmName) {
            detachInstances.setVmName(vmName);
            return this;
        }

        public DetachedVms build() {
            return detachInstances;
        }
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }


}