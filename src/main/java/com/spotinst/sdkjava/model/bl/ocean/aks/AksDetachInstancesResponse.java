package com.spotinst.sdkjava.model.bl.ocean.aks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class AksDetachInstancesResponse {
    @JsonIgnore
    private Set<String>              isSet;
    private List<DetachedVms>        detachedVms;

    public AksDetachInstancesResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<DetachedVms> getDetachedVms() {
        return detachedVms;
    }

    public void setDetachedVms(List<DetachedVms> detachedVms) {
        isSet.add("detachedVms");
        this.detachedVms = detachedVms;
    }

    public static class Builder {
        private AksDetachInstancesResponse detachInstances;

        private Builder() {
            this.detachInstances = new AksDetachInstancesResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDetachedVms(final List<DetachedVms> detachedVms) {
            detachInstances.setDetachedVms(detachedVms);
            return this;
        }

        public AksDetachInstancesResponse build() {
            return detachInstances;
        }
    }

    @JsonIgnore
    public boolean isDetachedVmsSet() {
        return isSet.contains("detachedVms");
    }


}