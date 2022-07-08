package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.k8sClusterRollOldVmsStatusEnum;

import java.util.HashSet;
import java.util.Set;

public class AksInitiateRollResponseOldVms {
    @JsonIgnore
    private Set<String>                     isSet;
    private String                         vmName;
    private k8sClusterRollOldVmsStatusEnum status;

    private AksInitiateRollResponseOldVms() {
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

    public k8sClusterRollOldVmsStatusEnum getStatus() {
        return status;
    }

    public void setStatus(k8sClusterRollOldVmsStatusEnum status) {
        isSet.add("status");
        this.status = status;
    }

    public static class Builder {
        private AksInitiateRollResponseOldVms initiateRollOldInstances;

        private Builder() {
            this.initiateRollOldInstances = new AksInitiateRollResponseOldVms();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVmName(final String vmName) {
            initiateRollOldInstances.setVmName(vmName);
            return this;
        }

        public Builder setStatus(final k8sClusterRollOldVmsStatusEnum status) {
            initiateRollOldInstances.setStatus(status);
            return this;
        }

        public AksInitiateRollResponseOldVms build() {
            return initiateRollOldInstances;
        }
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("setVmName");
    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }
}