package com.spotinst.sdkjava.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupCapacityConfiguration {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer minimum;
    private Integer maximum;
    private Integer target;
    //endregion

    //region Constructor

    private ElastigroupCapacityConfiguration() {
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

    //endregion

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupCapacityConfiguration capacity;

        private Builder() {
            this.capacity = new ElastigroupCapacityConfiguration();
        }

        public static Builder get(){
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

        public ElastigroupCapacityConfiguration build() {
            // TODO : Validations
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
    public boolean isTargetSet() {
        return isSet.contains("target");
    }

    //endregion
}
