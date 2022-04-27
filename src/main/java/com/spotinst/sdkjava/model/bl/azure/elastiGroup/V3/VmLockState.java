package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmLockState {

    private Set<String> isSet;
    private String      vmName;
    private Boolean     isLockEnabled;
    private Integer     lockDuration;

    public VmLockState() {
        this.isSet = new HashSet<>();
    }

    public String getVmName() {
        return vmName;
    }

    public Boolean getIsLockEnabled() {
        return isLockEnabled;
    }

    public Integer getLockDuration() {
        return lockDuration;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public void setIsLockEnabled(Boolean isLockEnabled) {
        isSet.add("isLockEnabled");
        this.isLockEnabled = isLockEnabled;
    }

    public void setLockDuration(Integer lockDuration) {
        isSet.add("lockDuration");
        this.lockDuration = lockDuration;
    }

    public static class Builder {
        VmLockState lockState;

        public Builder() {
            this.lockState  =   new VmLockState();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVmName(String vmName) {
            lockState.setVmName(vmName);
            return this;
        }

        public Builder setIsLockEnabled(Boolean isLockEnabled) {
            lockState.setIsLockEnabled(isLockEnabled);
            return this;
        }

        public Builder setLockDuration(Integer lockDuration) {
            lockState.setLockDuration(lockDuration);
            return this;
        }

        public VmLockState build() {
            return lockState;
        }
    }

    @JsonIgnore
    public Boolean isVmNameSet() {
            return isSet.contains("vmName");
        }

    @JsonIgnore
    public Boolean isIsLockEnabledSet() {
            return isSet.contains("isLockEnabled");
        }

    @JsonIgnore
    public Boolean isLockDurationSet() {
            return isSet.contains("lockDuration");
        }
}
