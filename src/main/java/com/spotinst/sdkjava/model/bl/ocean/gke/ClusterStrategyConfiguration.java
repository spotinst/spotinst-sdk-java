package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterStrategyConfiguration {

    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private Integer                           drainingTimeout;
    //endregion

    //region Constructor
    private ClusterStrategyConfiguration() {
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

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ClusterStrategyConfiguration strategy;

        private Builder() {
            this.strategy = new ClusterStrategyConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            strategy.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public ClusterStrategyConfiguration build() {
            return strategy;
        }
    }
    //endregion

    @JsonIgnore
    public boolean isDrainingTimeoutSet() { return isSet.contains("drainingTimeout"); }

}
