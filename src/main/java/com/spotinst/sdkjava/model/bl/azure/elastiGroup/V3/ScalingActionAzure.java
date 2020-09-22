package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.ScalingActionTypeEnum;

import java.util.HashSet;
import java.util.Set;

public class ScalingActionAzure {
    //region Members
    @JsonIgnore
    private Set<String>           isSet = new HashSet<>();
    private ScalingActionTypeEnum type;
    private String                adjustment;
    private String                target;
    private String                minimum;
    private String                maximum;
    //endregion


    //region Getter and Setter methods
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ScalingActionTypeEnum getType() {
        return type;
    }

    public void setType(ScalingActionTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }

    public String getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(String adjustment) {
        isSet.add("adjustment");
        this.adjustment = adjustment;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        isSet.add("target");
        this.target = target;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        isSet.add("minimum");
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        isSet.add("maximum");
        this.maximum = maximum;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ScalingActionAzure scalingAction;

        private Builder() {
            this.scalingAction = new ScalingActionAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setType(final ScalingActionTypeEnum type) {
            scalingAction.setType(type);
            return this;
        }

        public Builder setTarget(final String target) {
            scalingAction.setTarget(target);
            return this;
        }

        public Builder setAdjustment(final String adjustment) {
            scalingAction.setAdjustment(adjustment);
            return this;
        }

        public Builder setMaximum(final String maximum) {
            scalingAction.setMaximum(maximum);
            return this;
        }

        public Builder setMinimum(final String minimum) {
            scalingAction.setMinimum(minimum);
            return this;
        }

        public ScalingActionAzure build() {
            // TODO : Validations
            return scalingAction;
        }
    }

    //endregion

    //region isSet methods
    // Is type Set boolean method
    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }


    // Is adjustment Set boolean method
    @JsonIgnore
    public boolean isAdjustmentSet() {
        return isSet.contains("adjustment");
    }


    // Is target Set boolean method
    @JsonIgnore
    public boolean isTargetSet() {
        return isSet.contains("target");
    }


    // Is minimum Set boolean method
    @JsonIgnore
    public boolean isMinimumSet() {
        return isSet.contains("minimum");
    }

    // Is maximum Set boolean method
    @JsonIgnore
    public boolean isMaximumSet() {
        return isSet.contains("maximum");
    }

    //endregion
}
