package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class K8sVngResourceLimits {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     maxInstanceCount;


    private K8sVngResourceLimits() {
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
        private K8sVngResourceLimits strategy;

        private Builder() {
            this.strategy = new K8sVngResourceLimits();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setMaxInstanceCount(final Integer maxInstanceCount) {
            strategy.setMaxInstanceCount(maxInstanceCount);
            return this;
        }

        public K8sVngResourceLimits build() {
            return strategy;
        }
    }


    @JsonIgnore
    public boolean isMaxInstanceCountSet() {
        return isSet.contains("maxInstanceCount");
    }
}
