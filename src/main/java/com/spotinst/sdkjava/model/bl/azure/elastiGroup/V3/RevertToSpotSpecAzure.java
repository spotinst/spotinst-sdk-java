package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class RevertToSpotSpecAzure {
    // Partial Update support
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      performAt;
    //endregion

    //region Constructors
    private RevertToSpotSpecAzure(){
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
        private RevertToSpotSpecAzure revertTo;

        private Builder() {
            this.revertTo = new RevertToSpotSpecAzure();
        }

        public static Builder get(){
            return new Builder();
        }

        public Builder setPerformAt(final String performAt) {
            revertTo.setPerformAt(performAt);
            return this;
        }

        public RevertToSpotSpecAzure build() {
            // TODO : Validations
            return revertTo;
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
