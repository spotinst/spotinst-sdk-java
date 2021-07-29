package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterOptimizeImageConfiguration {

    private Set<String>  isSet;
    private Boolean      shouldOptimizeEcsAmi;
    private String       performAt;
    private List<String> timeWindows;


    public ClusterOptimizeImageConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public Boolean getShouldOptimizeEcsAmi() {
        return shouldOptimizeEcsAmi;
    }

    public void setShouldOptimizeEcsAmi(Boolean shouldOptimizeEcsAmi) {
        isSet.add("shouldOptimizeEcsAmi");
        this.shouldOptimizeEcsAmi = shouldOptimizeEcsAmi;
    }

    public String getPerformAt() {
        return performAt;
    }

    public void setPerformAt(String performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }

    public List<String> getTimeWindows() {
        return timeWindows;
    }

    public void setTimeWindows(List<String> timeWindows) {
        isSet.add("timeWindows");
        this.timeWindows = timeWindows;
    }

    public static class Builder {
        private ClusterOptimizeImageConfiguration scheduling;

        private Builder() {
            this.scheduling = new ClusterOptimizeImageConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldOptimizeEcsAmi(final Boolean shouldOptimizeEcsAmi) {
            scheduling.setShouldOptimizeEcsAmi(shouldOptimizeEcsAmi);
            return this;
        }

        public Builder setTimeWindows(final List<String> timeWindows) {
            scheduling.setTimeWindows(timeWindows);
            return this;
        }

        public Builder setPerformAt(final String performAt) {
            scheduling.setPerformAt(performAt);
            return this;
        }

        public ClusterOptimizeImageConfiguration build() {
            return scheduling;
        }
    }

    @JsonIgnore
    public boolean isShouldOptimizeEcsAmiSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }

    @JsonIgnore
    public boolean istimeWindowsSet() {
        return isSet.contains("timeWindows");
    }
}