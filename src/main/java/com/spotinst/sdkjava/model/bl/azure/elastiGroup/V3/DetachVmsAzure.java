package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetachVmsAzure {

    @JsonIgnore
    private Set<String>     isSet;
    private String          drainingTimeout;
    private Boolean         shouldDecrementTargetCapacity;
    private Boolean         shouldTerminateVms;
    private List<String>    vmsToDetach;

    private DetachVmsAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) { this.isSet = isSet;
    }

    public String getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(String drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }

    public Boolean getShouldDecrementTargetCapacity() {
        return shouldDecrementTargetCapacity;
    }

    public void setShouldDecrementTargetCapacity(Boolean shouldDecrementTargetCapacity) {
        isSet.add("shouldDecrementTargetCapacity");
        this.shouldDecrementTargetCapacity = shouldDecrementTargetCapacity;
    }

    public Boolean getShouldTerminateVms() {
        return shouldTerminateVms;
    }

    public void setShouldTerminateVms(Boolean shouldTerminateVms) {
        isSet.add("shouldTerminateVms");
        this.shouldTerminateVms = shouldTerminateVms;
    }

    public List<String> getVmsToDetach() {
        return vmsToDetach;
    }

    public void setVmsToDetach(List<String> vmsToDetach) {
        isSet.add("vmsToDetach");
        this.vmsToDetach = vmsToDetach;
    }

    public static class Builder {
        private DetachVmsAzure detachVms;

        private Builder() {
            this.detachVms = new DetachVmsAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDrainingTimeout(final String drainingTimeout) {
            detachVms.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setShouldDecrementTargetCapacity(final Boolean shouldDecrementTargetCapacity) {
            detachVms.setShouldDecrementTargetCapacity(shouldDecrementTargetCapacity);
            return this;
        }

        public Builder setShouldTerminateVms(final Boolean shouldTerminateVms) {
            detachVms.setShouldTerminateVms(shouldTerminateVms);
            return this;
        }

        public Builder setVmsToDetach(final List<String> vmsToDetach) {
            detachVms.setVmsToDetach(vmsToDetach);
            return this;
        }

        public DetachVmsAzure build() {
            return detachVms;
        }

    }


    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    @JsonIgnore
    public boolean isShouldDecrementTargetCapacitySet() {
        return isSet.contains("shouldDecrementTargetCapacity");
    }

    @JsonIgnore
    public boolean isShouldTerminateVmsSet() {
        return isSet.contains("shouldTerminateVms");
    }

    @JsonIgnore
    public boolean isVmsToDetachSet() {
        return isSet.contains("vmsToDetach");
    }
}
