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
    private Integer         maxInstanceCount;
    private Integer minInstanceCount;

    public LaunchSpecResourceLimitsSpecification(){ isSet = new HashSet<>();
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

    public Integer getMinInstanceCount() {
        return minInstanceCount;
    }

    public void setMaxInstanceCount(Integer maxInstanceCount) {
        isSet.add("maxInstanceCount");
        this.maxInstanceCount = maxInstanceCount;
    }

    public void setMinInstanceCount(Integer minInstanceCount) {
        isSet.add("minInstanceCount");
        this.minInstanceCount = minInstanceCount;
    }

    public static class Builder {
        private LaunchSpecResourceLimitsSpecification resourceLimits;

        private Builder() {
            this.resourceLimits = new LaunchSpecResourceLimitsSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMaxInstanceCount(final Integer maxInstanceCount) {
            resourceLimits.setMaxInstanceCount(maxInstanceCount);
            return this;
        }

        public Builder setMinInstanceCount(final Integer minInstanceCount) {
            resourceLimits.setMinInstanceCount(minInstanceCount);
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

    public boolean isMinInstanceCountSet() {
        return isSet.contains("minInstanceCount");
    }
}
