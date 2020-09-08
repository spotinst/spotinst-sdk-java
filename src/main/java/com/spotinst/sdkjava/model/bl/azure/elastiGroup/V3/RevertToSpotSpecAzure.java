package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class RevertToSpotSpecAzure {
    //region Members
    // Partial Update support
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

    //TODO Itzik - delete?
    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RevertToSpotSpecAzure tag = (RevertToSpotSpecAzure) o;

        return performAt.equals(tag.performAt);

    }

    @Override
    public int hashCode() {
        int result = performAt.hashCode();
        result = 31 * result + performAt.hashCode();
        return result;
    }
    //endregion
    //region Builder class
    public static class Builder {
        private RevertToSpotSpecAzure revertTo;

        private Builder() {
            this.revertTo = new RevertToSpotSpecAzure();
        }

        public static Builder get(){
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPerfortmAt(final String PerfortmAt) {
            revertTo.setPerformAt(PerfortmAt);
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
