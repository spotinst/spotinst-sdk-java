package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;
import java.util.HashSet;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterCapacityConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     target;
    private Integer     minimum;
    private Integer     maximum;
    private String      unit;

    private ClusterCapacityConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        isSet.add("minimum");
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        isSet.add("maximum");
        this.maximum = maximum;
    }

    public static class Builder {
        private ClusterCapacityConfiguration capacity;

        private Builder() {
            this.capacity = new ClusterCapacityConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setMinimum(final Integer minimum) {
            capacity.setMinimum(minimum);
            return this;
        }

        public Builder setMaximum(final Integer maximum) {
            capacity.setMaximum(maximum);
            return this;
        }

        public Builder setTarget(final Integer target) {
            capacity.setTarget(target);
            return this;
        }

        public Builder setUnit(final String unit) {
            capacity.setUnit(unit);
            return this;
        }

        public ClusterCapacityConfiguration build() {
            return capacity;
        }
    }

    @JsonIgnore
    public boolean isTargetSet() {
        return isSet.contains("target");
    }

    @JsonIgnore
    public boolean isMinimumSet() {
        return isSet.contains("minimum");
    }

    @JsonIgnore
    public boolean isMaximumSet() {
        return isSet.contains("maximum");
    }

    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("unit");
    }
}
