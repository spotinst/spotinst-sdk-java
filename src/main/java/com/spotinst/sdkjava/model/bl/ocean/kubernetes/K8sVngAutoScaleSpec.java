package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class K8sVngAutoScaleSpec {

    @JsonIgnore
    private Set<String>                 isSet;
    private List<K8sVngHeadroomSpec>    headrooms;

    private K8sVngAutoScaleSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<K8sVngHeadroomSpec> getHeadrooms() {
        return headrooms;
    }

    public void setHeadrooms(List<K8sVngHeadroomSpec> headrooms) {
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    public static class Builder {
        private K8sVngAutoScaleSpec autoScale;

        public Builder() {
            this.autoScale = new K8sVngAutoScaleSpec();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setHeadrooms(List<K8sVngHeadroomSpec> headrooms) {
            autoScale.setHeadrooms(headrooms);
            return this;
        }

        public K8sVngAutoScaleSpec build() {
            return autoScale;
        }
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headrooms");
    }
}