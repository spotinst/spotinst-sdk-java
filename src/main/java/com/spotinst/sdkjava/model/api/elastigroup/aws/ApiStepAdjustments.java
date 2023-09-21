package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ApiScalingAction;
import com.spotinst.sdkjava.model.ApiScalingPolicy;
import com.spotinst.sdkjava.model.ScalingAction;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by sobhana p on 9/20/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStepAdjustments {
    //region Members
    @JsonIgnore
    private Set<String>            isSet;
    private ApiScalingAction action;
    private Integer                threshold;
    //endregion

    //region Constructor

    public ApiStepAdjustments() {
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

    public ApiScalingAction getAction() {
        return action;
    }

    public void setAction(ApiScalingAction action) {
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
        private ApiStepAdjustments stepAdjustments;
        //endregion


        private Builder() {
            this.stepAdjustments = new ApiStepAdjustments();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        protected Builder setAction(final ApiScalingAction action) {
            stepAdjustments.setAction(action);
            return this;
        }

        public Builder setThreshold(final Integer threshold) {
            stepAdjustments.setThreshold(threshold);
            return this;
        }

        public ApiStepAdjustments build() {
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
