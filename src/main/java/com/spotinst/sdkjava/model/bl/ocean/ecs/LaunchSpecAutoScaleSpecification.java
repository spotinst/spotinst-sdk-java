package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaunchSpecAutoScaleSpecification {

    @JsonIgnore
    private Set<String>                         isSet;
    private List<ClusterHeadroomsSpecification> headrooms;

    private LaunchSpecAutoScaleSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterHeadroomsSpecification> getHeadrooms() {
        return headrooms;
    }

    public void setHeadrooms(List<ClusterHeadroomsSpecification> headrooms) {
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    public static class Builder {
        private LaunchSpecAutoScaleSpecification autoScale;

        public Builder() {
            this.autoScale = new LaunchSpecAutoScaleSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setHeadrooms(List<ClusterHeadroomsSpecification> headrooms) {
            autoScale.setHeadrooms(headrooms);
            return this;
        }

        public LaunchSpecAutoScaleSpecification build() {
            return autoScale;
        }
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headrooms");
    }
}
