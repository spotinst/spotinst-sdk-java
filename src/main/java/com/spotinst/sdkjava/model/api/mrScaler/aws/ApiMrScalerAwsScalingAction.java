package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsScalingAction {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String type;
    private Integer adjustment;
    private Integer minTargetCapacity;
    private Integer target;
    private Integer minimum;
    private Integer maximum;
    // endregion

    //region Constructor
    public ApiMrScalerAwsScalingAction() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    // region type
    public String getType(){
        return type;
    }

    public void setType(String type){
        isSet.add("type");
        this.type = type;
    }

    public Boolean isTypeSet(){
        return isSet.contains("type");
    }
    // endregion

    // region adjustment
    public Integer getAdjustment(){ return adjustment; }

    public void setAdjustment(Integer adjustment){
        isSet.add("adjustment");
        this.adjustment = adjustment;
    }

    public Boolean isAdjustmentSet(){
        return isSet.contains("adjustment");
    }
    // endregion

    // region minTargetCapacity
    public Integer getMinTargetCapacity(){ return minTargetCapacity; }

    public void setMinTargetCapacity(Integer minTargetCapacity){
        isSet.add("minTargetCapacity");
        this.minTargetCapacity = minTargetCapacity;
    }

    public Boolean isMinTargetCapacitySet(){
        return isSet.contains("minTargetCapacity");
    }
    // endregion

    // region target
    public Integer getTarget(){ return target; }

    public void setTarget(Integer target){
        isSet.add("target");
        this.target = target;
    }

    public Boolean isTargetSet(){
        return isSet.contains("target");
    }
    // endregion

    // region minimum
    public Integer getMinimum(){ return minimum; }

    public void setMinimum(Integer minimum){
        isSet.add("minimum");
        this.minimum = minimum;
    }

    public Boolean isMinimumSet(){
        return isSet.contains("minimum");
    }
    // endregion

    // region maximum
    public Integer getMaximum(){ return maximum; }

    public void setMaximum(Integer maximum){
        isSet.add("maximum");
        this.maximum = maximum;
    }

    public Boolean isMaximumSet(){
        return isSet.contains("maximum");
    }
    // endregion
    // endregion
    public static class Builder {
        private ApiMrScalerAwsScalingAction scalingAction;

        private Builder(){this.scalingAction = new ApiMrScalerAwsScalingAction();}

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setType(final String type){
            scalingAction.setType(type);
            return this;
        }
        public Builder setAdjustment(final Integer adjustment){
            scalingAction.setAdjustment(adjustment);
            return this;
        }
        public Builder setMinTargetCapacity(final Integer minTargetCapacity){
            scalingAction.setMinTargetCapacity(minTargetCapacity);
            return this;
        }
        public Builder setTarget(final Integer target){
            scalingAction.setTarget(target);
            return this;
        }
        public Builder setMinimum(final Integer minimum){
            scalingAction.setMinimum(minimum);
            return this;
        }
        public Builder setMaximum(final Integer maximum){
            scalingAction.setMaximum(maximum);
            return this;
        }

        public ApiMrScalerAwsScalingAction build(){
            return scalingAction;
        }
        // endregion
    }
}
