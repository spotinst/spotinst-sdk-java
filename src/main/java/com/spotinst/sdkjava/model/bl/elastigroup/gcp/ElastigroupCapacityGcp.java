package com.spotinst.sdkjava.model.bl.elastigroup.gcp;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupCapacityGcp {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     minimum;
    private Integer     maximum;
    private Integer     target;
    private String      unit;
    //endregion

    //region Constructor
    private ElastigroupCapacityGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter and Setter methods
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }

    public String getUnit() { return unit; }

    public void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupCapacityGcp capacity;

        private Builder() {
            this.capacity = new ElastigroupCapacityGcp();
        }

        public static Builder get() {
            return new Builder();
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

        public ElastigroupCapacityGcp build() {
            return capacity;
        }
    }
    //endregion

    //region isSet methods
    // Is minimum Set boolean method
    @JsonIgnore
    public boolean isMinimumSet() {
        return isSet.contains("minimum");
    }

    // Is maximum Set boolean method
    @JsonIgnore
    public boolean isMaximumSet() {
        return isSet.contains("maximum");
    }

    // Is target Set boolean method
    @JsonIgnore
    public boolean isTargetSet() { return isSet.contains("target"); }

    // Is unit Set boolean method
    @JsonIgnore
    public boolean isUnitSet() { return isSet.contains("unit"); }
    //endregion
}
