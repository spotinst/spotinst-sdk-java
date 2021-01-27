package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiCapacityGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     minimum;
    private Integer     maximum;
    private Integer     target;
    private String      unit;
    //endregion

    //region Constructor

    public ApiCapacityGcp() {
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

    //region Minimum
    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        isSet.add("minimum");
        this.minimum = minimum;
    }

    //endregion

    //region Maximum
    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        isSet.add("maximum");
        this.maximum = maximum;
    }

    //endregion

    //region Target
    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }
    //endregion

    //region Unit
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }
    //endregion


    //region isset methods
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

    // Is target Set boolean method
    @JsonIgnore
    public boolean isTargetSet() {
        return isSet.contains("target");
    }

    // Is unit Set boolean method
    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("unit");
    }

    //endregion
}
