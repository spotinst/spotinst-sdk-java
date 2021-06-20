package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

// TODO yael: rename BL objects to follow convention
public class VolumeAutoResizeResizePolicyAction {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      type;
    private Integer     adjustmentPercentage;
    //endregion

    //region Constructor
    private VolumeAutoResizeResizePolicyAction() {
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

    //region Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }
    //endregion

    //region adjustmentPercentage
    public Integer getAdjustmentPercentage() {
        return adjustmentPercentage;
    }

    public void setAdjustmentPercentage(Integer adjustmentPercentage) {
        isSet.add("adjustmentPercentage");
        this.adjustmentPercentage = adjustmentPercentage;
    }
    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private VolumeAutoResizeResizePolicyAction volumeAutoResizeResizePolicyAction;
        //endregion


        private Builder() {
            this.volumeAutoResizeResizePolicyAction = new VolumeAutoResizeResizePolicyAction();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setType(final String type) {
            volumeAutoResizeResizePolicyAction.setType(type);
            return this;
        }

        public Builder setAdjustmentPercentage(final Integer adjustmentPercentage) {
            volumeAutoResizeResizePolicyAction.setAdjustmentPercentage(adjustmentPercentage);
            return this;
        }

        public VolumeAutoResizeResizePolicyAction build() {
            // Validations
            return volumeAutoResizeResizePolicyAction;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is type Set boolean method
    @JsonIgnore
    public boolean istypeSet() {
        return isSet.contains("type");
    }

    // Is adjustmentPercentage Set boolean method
    @JsonIgnore
    public boolean isadjustmentPercentageSet() {
        return isSet.contains("adjustmentPercentage");
    }
    //endregion
}
