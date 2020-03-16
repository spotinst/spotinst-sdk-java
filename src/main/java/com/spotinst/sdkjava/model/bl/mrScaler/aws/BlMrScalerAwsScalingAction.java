package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsScalingAction {
    //region Members
    private String  type;
    private Integer adjustment;
    private Integer minTargetCapacity;
    private Integer target;
    private Integer minimum;
    private Integer maximum;
    // endregion

    //region Constructor
    public BlMrScalerAwsScalingAction() {
    }
    // endregion

    //region getters and setters
    // region type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    // endregion

    // region adjustment
    public Integer getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Integer adjustment) {
        this.adjustment = adjustment;
    }
    // endregion

    // region minTargetCapacity
    public Integer getMinTargetCapacity() {
        return minTargetCapacity;
    }

    public void setMinTargetCapacity(Integer minTargetCapacity) {
        this.minTargetCapacity = minTargetCapacity;
    }
    // endregion

    // region target
    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
    // endregion

    // region minimum
    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }
    // endregion

    // region maximum
    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }
    // endregion
    // endregion
}
