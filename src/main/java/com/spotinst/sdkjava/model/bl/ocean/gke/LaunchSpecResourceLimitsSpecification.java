package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecResourceLimitsSpecification {
    @JsonIgnore
    private Set<String> isSet;
    private int         maxInstanceCount;

    public LaunchSpecResourceLimitsSpecification(){ isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public int getMaxInstanceCount() {
        return maxInstanceCount;
    }

    public void setMaxInstanceCount(int maxInstanceCount) {
        isSet.add("maxInstanceCount");
        this.maxInstanceCount = maxInstanceCount;
    }

    public static class Builder {
        private LaunchSpecResourceLimitsSpecification resourceLimits;

        private Builder() {
            this.resourceLimits = new LaunchSpecResourceLimitsSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setMaxInstanceCount(final int maxInstanceCount) {
            resourceLimits.setMaxInstanceCount(maxInstanceCount);
            return this;
        }

        public LaunchSpecResourceLimitsSpecification build() {
            return resourceLimits;
        }
    }

    @JsonIgnore
    public boolean isMaxInstanceCountSet() {
        return isSet.contains("maxInstanceCount");
    }
}
