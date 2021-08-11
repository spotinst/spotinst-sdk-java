package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class RevertToSpot {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      performAt;

    //endregion

    //region constructor
    private RevertToSpot() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

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
        private RevertToSpot revertToSpot;

        private Builder() {
            this.revertToSpot = new RevertToSpot();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPerformAt(final String performAt) {
            revertToSpot.setPerformAt(performAt);
            return this;
        }

        public RevertToSpot build() {
            // TODO : Validations
            return revertToSpot;
        }
    }
    //endregion

    //region isSet methods
    // Is performAt Set boolean method
    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }
    //endregion
}
