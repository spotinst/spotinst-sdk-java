package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecStrategySpecification {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     preemptiblePercentage;

    public LaunchSpecStrategySpecification(){ isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getPreemptiblePercentage() {
        return preemptiblePercentage;
    }

    public void setPreemptiblePercentage(Integer preemptiblePercentage) {
        isSet.add("preemptiblePercentage");
        this.preemptiblePercentage = preemptiblePercentage;
    }

    public static class Builder {
        private LaunchSpecStrategySpecification strategy;

        private Builder() {
            this.strategy = new LaunchSpecStrategySpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPreemptiblePercentage(final Integer preemptiblePercentage) {
            strategy.setPreemptiblePercentage(preemptiblePercentage);
            return this;
        }

        public LaunchSpecStrategySpecification build() {
            return strategy;
        }
    }

    @JsonIgnore
    public boolean isPreemptiblePercentageSet() {
        return isSet.contains("preemptiblePercentage");
    }

}