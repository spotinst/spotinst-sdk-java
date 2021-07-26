package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupRevertToSpot {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> timeWindows;
    private String       performAt;

    //endregion
    //region Constructors
    private ElastigroupRevertToSpot() {
        isSet = new HashSet<>();
    }

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getTimeWindows() {
        return timeWindows;
    }

    public void setTimeWindows(List<String> timeWindows) {
        isSet.add("timeWindows");
        this.timeWindows = timeWindows;
    }

    public String getPerformAt() {
        return performAt;
    }

    public void setPerformAt(String performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupRevertToSpot optimizeImages;

        private Builder() {
            this.optimizeImages = new ElastigroupRevertToSpot();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPerformAt(final String performAt) {
            optimizeImages.setPerformAt(performAt);
            return this;
        }

        public Builder setTimeWindow(final List<String> timeWindow) {
            optimizeImages.setTimeWindows(timeWindow);
            return this;
        }

        public ElastigroupRevertToSpot build() {
            return optimizeImages;
        }

    }

    //region isSet methods

    // Is timeWindow Set boolean method
    @JsonIgnore
    public boolean isTimeWindowSet() {
        return isSet.contains("timeWindows");
    }

    // Is performAt Set boolean method
    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }
}
