package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class K8sVngStrategySpec {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     spotPercentage;


    private K8sVngStrategySpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getSpotPercentage() {
        return spotPercentage;
    }

    public void setSpotPercentage(Integer spotPercentage) {
        isSet.add("spotPercentage");
        this.spotPercentage = spotPercentage;
    }

    public static class Builder {
        private K8sVngStrategySpec strategy;

        private Builder() {
            this.strategy = new K8sVngStrategySpec();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setSpotPercentage(final Integer spotPercentage) {
            strategy.setSpotPercentage(spotPercentage);
            return this;
        }

        public K8sVngStrategySpec build() {
            return strategy;
        }
    }


    @JsonIgnore
    public boolean isSpotPercentageSet() {
        return isSet.contains("spotPercentage");
    }
}
