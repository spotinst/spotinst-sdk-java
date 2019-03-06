package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ApiMrScalerAwsScalingPolicy {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String policyName;
    private String namespace;
    private String metricName;
    private List<ApiMrScalerAwsScalingDimenation> dimensions;
    private String statistic;
    private String unit;
    private Integer threshold;
    private Integer adjustment;
    private Integer minTargetCapacity;
    private Integer period;
    private Integer evaluationPeriods;
    private Integer cooldown;
    private ApiMrScalerAwsScalingAction action;
    private String operator;
    // endregion

    //region Constructor
    public ApiMrScalerAwsScalingPolicy() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    // region policyName
    public String getPolicyName(){
        return policyName;
    }

    public void setPolicyName(String policyName){
        isSet.add("policyName");
        this.policyName = policyName;
    }

    public Boolean isPolicyNameSet(){
        return isSet.contains("policyName");
    }
    // endregion

    // region namespace
    public String getNamespace(){
        return namespace;
    }

    public void setNamespace(String namespace){
        isSet.add("namespace");
        this.namespace = namespace;
    }

    public Boolean isNamespaceSet(){
        return isSet.contains("namespace");
    }
    // endregion

    // region metricName
    public String getMetricName(){
        return metricName;
    }

    public void setMetricName(String metricName){
        isSet.add("metricName");
        this.metricName = metricName;
    }

    public Boolean isMetricNameSet(){
        return isSet.contains("metricName");
    }
    // endregion

    // region dimensions
    public List<ApiMrScalerAwsScalingDimenation> getDimensions(){
        return dimensions;
    }

    public void setDimensions(List<ApiMrScalerAwsScalingDimenation> dimensions){
        isSet.add("dimensions");
        this.dimensions = dimensions;
    }

    public Boolean isDimensionsSet(){
        return isSet.contains("dimensions");
    }
    // endregion

    // region statistic
    public String getStatistic(){
        return statistic;
    }

    public void setStatistic(String statistic){
        isSet.add("statistic");
        this.statistic = statistic;
    }

    public Boolean isStatisticSet(){
        return isSet.contains("statistic");
    }
    // endregion

    // region unit
    public String getUnit(){
        return unit;
    }

    public void setUnit(String unit){
        isSet.add("unit");
        this.unit = unit;
    }

    public Boolean isUnitSet(){
        return isSet.contains("unit");
    }
    // endregion

    // region threshold
    public Integer getThreshold(){
        return threshold;
    }

    public void setThreshold(Integer threshold){
        isSet.add("threshold");
        this.threshold = threshold;
    }

    public Boolean isThresholdSet(){
        return isSet.contains("threshold");
    }
    // endregion

    // region adjustment
    public Integer getAdjustment(){
        return adjustment;
    }

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

    // region period
    public Integer getPeriod(){
        return period;
    }

    public void setPeriod(Integer period){
        isSet.add("period");
        this.period = period;
    }

    public Boolean isPeriodSet(){
        return isSet.contains("period");
    }
    // endregion

    // region evaluationPeriods
    public Integer getEvaluationPeriods(){
        return evaluationPeriods;
    }

    public void setEvaluationPeriods(Integer evaluationPeriods){
        isSet.add("evaluationPeriods");
        this.evaluationPeriods = evaluationPeriods;
    }

    public Boolean isEvaluationPeriodsSet(){
        return isSet.contains("evaluationPeriods");
    }
    // endregion

    // region cooldown
    public Integer getCooldown(){
        return cooldown;
    }

    public void setCooldown(Integer cooldown){
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }

    public Boolean isCooldownSet(){
        return isSet.contains("cooldown");
    }
    // endregion

    // region action
    public ApiMrScalerAwsScalingAction getAction(){
        return action;
    }

    public void setAction(ApiMrScalerAwsScalingAction action){
        isSet.add("action");
        this.action = action;
    }

    public Boolean isActionSet(){
        return isSet.contains("action");
    }
    // endregion

    // region operator
    public String getOperator(){
        return operator;
    }

    public void setOperator(String operator){
        isSet.add("operator");
        this.operator = operator;
    }

    public Boolean isOperatorSet(){
        return isSet.contains("operator");
    }
    // endregion

    // endregion

    public static class Builder {
        private ApiMrScalerAwsScalingPolicy scalingPolicy;

        private Builder(){ this.scalingPolicy = new ApiMrScalerAwsScalingPolicy(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setPolicyName(final String policyName){
            scalingPolicy.setPolicyName(policyName);
            return this;
        }
        public Builder setNamespace(final String namespace){
            scalingPolicy.setNamespace(namespace);
            return this;
        }
        public Builder setMetricName(final String metricName){
            scalingPolicy.setMetricName(metricName);
            return this;
        }
        public Builder setDimensions(final List<ApiMrScalerAwsScalingDimenation> dimensions){
            scalingPolicy.setDimensions(dimensions);
            return this;
        }
        public Builder setStatistic(final String statistic){
            scalingPolicy.setStatistic(statistic);
            return this;
        }
        public Builder setUnit(final String unit){
            scalingPolicy.setUnit(unit);
            return this;
        }
        public Builder setThreshold(final Integer threshold){
            scalingPolicy.setThreshold(threshold);
            return this;
        }
        public Builder setAdjustment(final Integer adjustment){
            scalingPolicy.setAdjustment(adjustment);
            return this;
        }
        public Builder setMinTargetCapacity(final Integer minTargetCapacity){
            scalingPolicy.setMinTargetCapacity(minTargetCapacity);
            return this;
        }
        public Builder setPeriod(final Integer period){
            scalingPolicy.setPeriod(period);
            return this;
        }
        public Builder setEvaluationPeriods(final Integer evaluationPeriods){
            scalingPolicy.setEvaluationPeriods(evaluationPeriods);
            return this;
        }
        public Builder setCooldown(final Integer cooldown){
            scalingPolicy.setCooldown(cooldown);
            return this;
        }
        public Builder setAction(final ApiMrScalerAwsScalingAction action){
            scalingPolicy.setAction(action);
            return this;
        }
        public Builder setOperator(final String operator){
            scalingPolicy.setOperator(operator);
            return this;
        }

        public ApiMrScalerAwsScalingPolicy build(){
            return scalingPolicy;
        }

        // endregion
    }
}
