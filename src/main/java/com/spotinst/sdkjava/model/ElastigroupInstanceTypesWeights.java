package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupInstanceTypesWeights {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String       instanceType;
    private Integer      weightedCapacity;
    //endregion

    //region Constructors

    private ElastigroupInstanceTypesWeights() {
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

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public Integer getWeightedCapacity() {
        return weightedCapacity;
    }

    public void setWeightedCapacity(Integer weightedCapacity) {
        isSet.add("weightedCapacity");
        this.weightedCapacity = weightedCapacity;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupInstanceTypesWeights weights;

        private Builder() {
            this.weights = new ElastigroupInstanceTypesWeights();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setInstanceType(final String instanceType) {
            weights.setInstanceType(instanceType);
            return this;
        }

        public Builder setWeightedCapacity(final Integer weightedCapacity) {
            weights.setWeightedCapacity(weightedCapacity);
            return this;
        }

        public ElastigroupInstanceTypesWeights build() {
            return weights;
        }
    }
    //endregion
    //region isSet methods
    // Is instanceType Set boolean method
    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

    // Is weightedCapacity Set boolean method
    @JsonIgnore
    public boolean isWeightedCapacitySet() {
        return isSet.contains("weightedCapacity");
    }

    //endregion
}
