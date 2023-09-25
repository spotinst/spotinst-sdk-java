package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.ScalingAction;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by sobhana p on 9/20/2023.
 */
public class StepAdjustments {
    //region Members
    @JsonIgnore
    private Set<String>            isSet;
    private ScalingAction           action;
    private Integer                threshold;
    //endregion

    //region Constructor

    public StepAdjustments() {
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

    public ScalingAction getAction() {
        return action;
    }

    public void setAction(ScalingAction action) {
        isSet.add("action");
        this.action = action;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        isSet.add("threshold");
        this.threshold = threshold;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private StepAdjustments stepAdjustments;
        //endregion


        private Builder() {
            this.stepAdjustments = new StepAdjustments();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setAction(final ScalingAction action) {
            stepAdjustments.setAction(action);
            return this;
        }

        public Builder setThreshold(final Integer threshold) {
            stepAdjustments.setThreshold(threshold);
            return this;
        }

        public StepAdjustments build() {
            // Validations
            return stepAdjustments;
        }
        //endregion
    }
    //endregion

    //region isSet methods

    // Is action Set boolean method
    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }

    // Is threshold Set boolean method
    @JsonIgnore
    public boolean isThresholdSet() {
        return isSet.contains("threshold");
    }

    //endregion
}
