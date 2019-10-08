package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupPerFormAtSpecification {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<String> timeWindow;
    //endregion

    //region Constructor
    private ElastigroupPerFormAtSpecification()  {
        isSet = new HashSet<>();
    }
    //endregion
    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    public List<String> getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(List<String> timeWindow) {
        isSet.add("timeWindow");
        this.timeWindow = timeWindow;
    }
    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupPerFormAtSpecification perFormAt;

        private Builder() {this.perFormAt = new ElastigroupPerFormAtSpecification();}

        public static Builder get() {
            Builder builder = new Builder();
            return  builder;
        }

        public Builder setTimeWindow (final List<String> timeWindow) {
            perFormAt.setTimeWindow(timeWindow);
            return this;
        }
        public ElastigroupPerFormAtSpecification build() {return perFormAt;}
    }
    //endregion

    //region isSet methods
    // Is timeWindow Set boolean method
    @JsonIgnore
    public boolean isTimeWindowSet() {
        return isSet.contains("timeWindow");
    }

}
