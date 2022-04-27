package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterVngResourceLimits {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     maxInstanceCount;


    private ClusterVngResourceLimits() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getMaxInstanceCount() {
        return maxInstanceCount;
    }

    public void setMaxInstanceCount(Integer maxInstanceCount) {
        isSet.add("maxInstanceCount");
        this.maxInstanceCount = maxInstanceCount;
    }

    public static class Builder {
        private ClusterVngResourceLimits strategy;

        private Builder() {
            this.strategy = new ClusterVngResourceLimits();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMaxInstanceCount(final Integer maxInstanceCount) {
            strategy.setMaxInstanceCount(maxInstanceCount);
            return this;
        }

        public ClusterVngResourceLimits build() {
            return strategy;
        }
    }


    @JsonIgnore
    public boolean isMaxInstanceCountSet() {
        return isSet.contains("maxInstanceCount");
    }
}
