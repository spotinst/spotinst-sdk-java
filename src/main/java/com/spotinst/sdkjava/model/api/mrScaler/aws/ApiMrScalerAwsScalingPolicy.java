package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsScalingPolicy implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                             isSet;
    private String                                  policyName;
    private String                                  namespace;
    private String                                  metricName;
    private List<ApiMrScalerAwsScalingDimenation>   dimensions;
    private String                                  statistic;
    private String                                  unit;
    private Integer                                 threshold;
    private Integer                                 adjustment;
    private Integer                                 minTargetCapacity;
    private Integer                                 period;
    private Integer                                 evaluationPeriods;
    private Integer                                 cooldown;
    private ApiMrScalerAwsScalingAction             action;
    private String                                  operator;

    public ApiMrScalerAwsScalingPolicy() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getPolicyName(){
        return policyName;
    }

    public void setPolicyName(String policyName){
        isSet.add("policyName");
        this.policyName = policyName;
    }

    public String getNamespace(){
        return namespace;
    }

    public void setNamespace(String namespace){
        isSet.add("namespace");
        this.namespace = namespace;
    }

    public String getMetricName(){
        return metricName;
    }

    public void setMetricName(String metricName){
        isSet.add("metricName");
        this.metricName = metricName;
    }

    public List<ApiMrScalerAwsScalingDimenation> getDimensions(){
        return dimensions;
    }

    public void setDimensions(List<ApiMrScalerAwsScalingDimenation> dimensions){
        isSet.add("dimensions");
        this.dimensions = dimensions;
    }

    public String getStatistic(){
        return statistic;
    }

    public void setStatistic(String statistic){
        isSet.add("statistic");
        this.statistic = statistic;
    }

    public String getUnit(){
        return unit;
    }

    public void setUnit(String unit){
        isSet.add("unit");
        this.unit = unit;
    }

    public Integer getThreshold(){
        return threshold;
    }

    public void setThreshold(Integer threshold){
        isSet.add("threshold");
        this.threshold = threshold;
    }

    public Integer getAdjustment(){
        return adjustment;
    }

    public void setAdjustment(Integer adjustment){
        isSet.add("adjustment");
        this.adjustment = adjustment;
    }

    public Integer getMinTargetCapacity(){ return minTargetCapacity; }

    public void setMinTargetCapacity(Integer minTargetCapacity){
        isSet.add("minTargetCapacity");
        this.minTargetCapacity = minTargetCapacity;
    }

    public Integer getPeriod(){
        return period;
    }

    public void setPeriod(Integer period){
        isSet.add("period");
        this.period = period;
    }

    public Integer getEvaluationPeriods(){
        return evaluationPeriods;
    }

    public void setEvaluationPeriods(Integer evaluationPeriods){
        isSet.add("evaluationPeriods");
        this.evaluationPeriods = evaluationPeriods;
    }

    public Integer getCooldown(){
        return cooldown;
    }

    public void setCooldown(Integer cooldown){
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }

    public ApiMrScalerAwsScalingAction getAction(){
        return action;
    }

    public void setAction(ApiMrScalerAwsScalingAction action){
        isSet.add("action");
        this.action = action;
    }

    public String getOperator(){
        return operator;
    }

    public void setOperator(String operator){
        isSet.add("operator");
        this.operator = operator;
    }

    @JsonIgnore
    public Boolean isPolicyNameSet(){
        return isSet.contains("policyName");
    }

    @JsonIgnore
    public Boolean isNamespaceSet(){
        return isSet.contains("namespace");
    }

    @JsonIgnore
    public Boolean isMetricNameSet(){
        return isSet.contains("metricName");
    }

    @JsonIgnore
    public Boolean isDimensionsSet(){
        return isSet.contains("dimensions");
    }

    @JsonIgnore
    public Boolean isStatisticSet(){
        return isSet.contains("statistic");
    }

    @JsonIgnore
    public Boolean isUnitSet(){
        return isSet.contains("unit");
    }

    @JsonIgnore
    public Boolean isThresholdSet(){
        return isSet.contains("threshold");
    }

    @JsonIgnore
    public Boolean isAdjustmentSet(){
        return isSet.contains("adjustment");
    }

    @JsonIgnore
    public Boolean isMinTargetCapacitySet(){
        return isSet.contains("minTargetCapacity");
    }

    @JsonIgnore
    public Boolean isPeriodSet(){
        return isSet.contains("period");
    }

    @JsonIgnore
    public Boolean isEvaluationPeriodsSet(){
        return isSet.contains("evaluationPeriods");
    }

    @JsonIgnore
    public Boolean isCooldownSet(){
        return isSet.contains("cooldown");
    }

    @JsonIgnore
    public Boolean isActionSet(){
        return isSet.contains("action");
    }

    @JsonIgnore
    public Boolean isOperatorSet(){
        return isSet.contains("operator");
    }
}
