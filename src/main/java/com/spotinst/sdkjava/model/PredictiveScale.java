package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.enums.ScalingPredictiveModeEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SagiShoshan on 11/05/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PredictiveScale {

    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>               isSet = new HashSet<>();
    private ScalingPredictiveModeEnum mode;
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ScalingPredictiveModeEnum getMode() {
        return mode;
    }

    public void setMode(ScalingPredictiveModeEnum mode) {
        isSet.add("mode");
        this.mode = mode;
    }
    //endregion

    //region override methods
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PredictiveScale that = (PredictiveScale) o;

        return !(mode != null ? !mode.equals(that.mode) : that.mode != null);
    }

    @Override
    public int hashCode() {
        int result = mode.hashCode();
        return result;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private PredictiveScale predictive;

        private Builder() {
            this.predictive = new PredictiveScale();
        }

        public static PredictiveScale.Builder get() {
            PredictiveScale.Builder builder = new PredictiveScale.Builder();
            return builder;
        }

        public PredictiveScale.Builder setMode(final ScalingPredictiveModeEnum mode) {
            predictive.setMode(mode);
            return this;
        }

        public PredictiveScale build() {
            // TODO : Validations
            return predictive;
        }
    }
    //endregion

    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isModeSet() {
        return isSet.contains("mode");
    }
    //endregion
}
