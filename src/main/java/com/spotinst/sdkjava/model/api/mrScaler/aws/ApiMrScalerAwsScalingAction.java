package com.spotinst.sdkjava.model.api.mrScaler.aws;

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
public class ApiMrScalerAwsScalingAction implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      type;
    private Integer     adjustment;
    private Integer     minTargetCapacity;
    private Integer     target;
    private Integer     minimum;
    private Integer     maximum;

    public ApiMrScalerAwsScalingAction() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        isSet.add("type");
        this.type = type;
    }

    public Integer getAdjustment(){ return adjustment; }

    public void setAdjustment(Integer adjustment){
        isSet.add("adjustment");
        this.adjustment = adjustment;
    }

    public Integer getMinTargetCapacity(){ return minTargetCapacity; }

    public void setMinTargetCapacity(Integer minTargetCapacity){
        isSet.add("minTargetCapacity");
        this.minTargetCapacity = minTargetCapacity;
    }

    public Integer getTarget(){ return target; }

    public void setTarget(Integer target){
        isSet.add("target");
        this.target = target;
    }

    public Integer getMinimum(){ return minimum; }

    public void setMinimum(Integer minimum){
        isSet.add("minimum");
        this.minimum = minimum;
    }

    public Integer getMaximum(){ return maximum; }

    public void setMaximum(Integer maximum){
        isSet.add("maximum");
        this.maximum = maximum;
    }

    @JsonIgnore
    public Boolean isMinTargetCapacitySet(){
        return isSet.contains("minTargetCapacity");
    }

    @JsonIgnore
    public Boolean isTargetSet(){
        return isSet.contains("target");
    }

    @JsonIgnore
    public Boolean isMinimumSet(){
        return isSet.contains("minimum");
    }

    @JsonIgnore
    public Boolean isMaximumSet(){
        return isSet.contains("maximum");
    }

    @JsonIgnore
    public Boolean isAdjustmentSet(){
        return isSet.contains("adjustment");
    }

    @JsonIgnore
    public Boolean isTypeSet(){
        return isSet.contains("type");
    }
}
