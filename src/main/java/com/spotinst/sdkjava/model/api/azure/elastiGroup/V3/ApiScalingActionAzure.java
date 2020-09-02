package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 7/22/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiScalingActionAzure {

    private Set<String> isSet = new HashSet<>();
    private String      type;
    private String      adjustment;
    private String      minTargetCapacity;
    private String      target;
    private String      minimum;
    private String      maximum;
    //endregion

    //region Getter and Setter methods


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getMinTargetCapacity() {
        return minTargetCapacity;
    }

    public void setMinTargetCapacity(String minTargetCapacity) {
        isSet.add("minTargetCapacity");
        this.minTargetCapacity = minTargetCapacity;
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


    // Is minTargetCapacity Set boolean method
    @JsonIgnore
    public boolean isMinTargetCapacitySet() {
        return isSet.contains("minTargetCapacity");
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
