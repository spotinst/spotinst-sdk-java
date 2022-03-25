package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterVngAutoScaleSpec {

    @JsonIgnore
    private Set<String>                    isSet;
    private List<ClusterVngHeadroomSpec>   headrooms;
    private Integer                        autoHeadroomPercentage;

    private ClusterVngAutoScaleSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterVngHeadroomSpec> getHeadrooms() {
        return headrooms;
    }

    public void setHeadrooms(List<ClusterVngHeadroomSpec> headrooms) {
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    public Integer getAutoHeadroomPercentage() {
        return autoHeadroomPercentage;
    }

    public void setAutoHeadroomPercentage(Integer autoHeadroomPercentage) {
        isSet.add("autoHeadroomPercentage");
        this.autoHeadroomPercentage = autoHeadroomPercentage;
    }

    public static class Builder {
        private ClusterVngAutoScaleSpec autoScale;

        public Builder() {
            this.autoScale = new ClusterVngAutoScaleSpec();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setHeadrooms(List<ClusterVngHeadroomSpec> headrooms) {
            autoScale.setHeadrooms(headrooms);
            return this;
        }

        public Builder setAutoHeadroomPercentage(Integer autoHeadroomPercentage) {
            autoScale.setAutoHeadroomPercentage(autoHeadroomPercentage);
            return this;
        }

        public ClusterVngAutoScaleSpec build() {
            return autoScale;
        }
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headrooms");
    }

    @JsonIgnore
    public boolean isAutoHeadroomPercentageSet() {
        return isSet.contains("autoHeadroomPercentage");
    }
}