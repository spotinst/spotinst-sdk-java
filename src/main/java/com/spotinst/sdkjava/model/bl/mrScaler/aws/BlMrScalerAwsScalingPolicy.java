package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlMrScalerAwsScalingPolicy {
    //region Members
    private String policyName;
    private String namespace;
    private String metricName;
    private List<BlMrScalerAwsScalingDimenation> dimensions;
    private String statistic;
    private String unit;
    private Integer threshold;
    private Integer adjustment;
    private Integer minTargetCapacity;
    private Integer period;
    private Integer evaluationPeriods;
    private Integer cooldown;
    private BlMrScalerAwsScalingAction action;
    private String operator;
    // endregion

    //region Constructor
    public BlMrScalerAwsScalingPolicy() { }
    // endregion

    //region getters and setters
    // region policyName
    public String getPolicyName(){
        return policyName;
    }

    public void setPolicyName(String policyName){
        this.policyName = policyName;
    }
    // endregion

    // region namespace
    public String getNamespace(){
        return namespace;
    }

    public void setNamespace(String namespace){
        this.namespace = namespace;
    }
    // endregion

    // region metricName
    public String getMetricName(){
        return metricName;
    }

    public void setMetricName(String metricName){
        this.metricName = metricName;
    }
    // endregion

    // region dimensions
    public List<BlMrScalerAwsScalingDimenation> getDimensions(){
        return dimensions;
    }

    public void setDimensions(List<BlMrScalerAwsScalingDimenation> dimensions){
        this.dimensions = dimensions;
    }
    // endregion

    // region statistic
    public String getStatistic(){
        return statistic;
    }

    public void setStatistic(String statistic){
        this.statistic = statistic;
    }
    // endregion

    // region unit
    public String getUnit(){
        return unit;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }
    // endregion

    // region threshold
    public Integer getThreshold(){
        return threshold;
    }

    public void setThreshold(Integer threshold){
        this.threshold = threshold;
    }
    // endregion

    // region adjustment
    public Integer getAdjustment(){
        return adjustment;
    }

    public void setAdjustment(Integer adjustment){
        this.adjustment = adjustment;
    }
    // endregion

    // region minTargetCapacity
    public Integer getMinTargetCapacity(){ return minTargetCapacity; }

    public void setMinTargetCapacity(Integer minTargetCapacity){
        this.minTargetCapacity = minTargetCapacity;
    }
    // endregion

    // region period
    public Integer getPeriod(){
        return period;
    }

    public void setPeriod(Integer period){
        this.period = period;
    }
    // endregion

    // region evaluationPeriods
    public Integer getEvaluationPeriods(){
        return evaluationPeriods;
    }

    public void setEvaluationPeriods(Integer evaluationPeriods){
        this.evaluationPeriods = evaluationPeriods;
    }
    // endregion

    // region cooldown
    public Integer getCooldown(){
        return cooldown;
    }

    public void setCooldown(Integer cooldown){
        this.cooldown = cooldown;
    }
    // endregion

    // region action
    public BlMrScalerAwsScalingAction getAction(){
        return action;
    }

    public void setAction(BlMrScalerAwsScalingAction action){
        this.action = action;
    }
    // endregion

    // region operator
    public String getOperator(){
        return operator;
    }

    public void setOperator(String operator){
        this.operator = operator;
    }
    // endregion

    // endregion
}
