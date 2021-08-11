package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VirtualNodeGroupAutoScaleSpec {

    @JsonIgnore
    private Set<String>                         isSet;
    private List<ClusterHeadroomSpecification> headrooms;

    private VirtualNodeGroupAutoScaleSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterHeadroomSpecification> getHeadrooms() {
        return headrooms;
    }

    public void setHeadrooms(List<ClusterHeadroomSpecification> headrooms) {
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    public static class Builder {
        private VirtualNodeGroupAutoScaleSpec autoScale;

        public Builder() {
            this.autoScale = new VirtualNodeGroupAutoScaleSpec();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setHeadrooms(List<ClusterHeadroomSpecification> headrooms) {
            autoScale.setHeadrooms(headrooms);
            return this;
        }

        public VirtualNodeGroupAutoScaleSpec build() {
            return autoScale;
        }
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headrooms");
    }
}