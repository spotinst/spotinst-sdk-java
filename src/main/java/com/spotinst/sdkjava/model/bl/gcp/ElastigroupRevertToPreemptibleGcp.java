package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;


public class ElastigroupRevertToPreemptibleGcp {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String performAt;
    //endregion

    //region Constructors
    private ElastigroupRevertToPreemptibleGcp() {
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

    //region performAt
    public String getPerformAt() {
        return performAt;
    }

    public void setPerformAt(String performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupRevertToPreemptibleGcp instanceTypes;

        private Builder() {
            this.instanceTypes = new ElastigroupRevertToPreemptibleGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPerformAt(final String performAt) {
            instanceTypes.setPerformAt(performAt);
            return this;
        }

        public ElastigroupRevertToPreemptibleGcp build() {
            return instanceTypes;
        }
    }
    //endregion

    //region isSet methods
    // Is network Set boolean method
    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }
    //endregion
}
