package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodePerformAtEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeStrategyRevertToSpotConfiguration {

    @JsonIgnore
    private Set<String>                    isSet;
    private AzureStatefulNodePerformAtEnum performAt;

    private StatefulNodeStrategyRevertToSpotConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public AzureStatefulNodePerformAtEnum getPerformAt() {
        return performAt;
    }

    public void setPerformAt(AzureStatefulNodePerformAtEnum performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }

    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }

    public static class Builder {
        private StatefulNodeStrategyRevertToSpotConfiguration statefulNodeRevertToSpot;

        private Builder() {
            this.statefulNodeRevertToSpot = new StatefulNodeStrategyRevertToSpotConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPerformAt(final AzureStatefulNodePerformAtEnum performAt) {
            statefulNodeRevertToSpot.setPerformAt(performAt);
            return this;
        }

        public StatefulNodeStrategyRevertToSpotConfiguration build() {
            return statefulNodeRevertToSpot;
        }
    }

}