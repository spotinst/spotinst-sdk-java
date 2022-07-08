package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ImportClusterDownSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     maxScaleDownPercentage;


    private ImportClusterDownSpecification() {
        isSet = new HashSet<>();
    }


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public Integer getMaxScaleDownPercentage() {
        return maxScaleDownPercentage;
    }

    public void setMaxScaleDownPercentage(Integer maxScaleDownPercentage) {
        isSet.add("maxScaleDownPercentage");
        this.maxScaleDownPercentage = maxScaleDownPercentage;
    }

    public static class Builder {
        private ImportClusterDownSpecification down;

        private Builder() {
            this.down = new ImportClusterDownSpecification();
        }

        public static ImportClusterDownSpecification.Builder get() {
            return new Builder();
        }

        public ImportClusterDownSpecification.Builder setMaxScaleDownPercentage(final Integer maxScaleDownPercentage) {
            down.setMaxScaleDownPercentage(maxScaleDownPercentage);
            return this;
        }

        public ImportClusterDownSpecification build() {
            return down;
        }
    }

    @JsonIgnore
    public boolean isMaxScaleDownPercentageSet() {
        return isSet.contains("maxScaleDownPercentage");
    }
}
