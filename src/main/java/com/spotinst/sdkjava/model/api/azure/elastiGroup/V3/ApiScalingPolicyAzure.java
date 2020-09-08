package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiScalingPolicyAzure {
    //region Members
    // Partial Update support
    private Set<String>                    isSet = new HashSet<>();
    private String                         policyName;
    private String                         metricName;
    private String                         statistic;
    private String                         unit;
    private Float                          threshold;
    private String                         namespace;
    private Integer                        period;
    private Integer                        evaluationPeriods;
    private Integer                        cooldown;
    private List<ApiScalingDimensionAzure> dimensions;
    private ApiScalingActionAzure          action;
    private String                         operator;
    private Boolean                        isEnabled;

    //endregion

    //region Getters & Setters

    //region Metric name
    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        isSet.add("metricName");
        this.metricName = metricName;
    }

    @JsonIgnore
    public boolean isMetricNameSet() {
        return isSet.contains("metricName");
    }
    //endregion

    //region Min target capacity
    @JsonIgnore
    public boolean isMinTargetCapcitySet() {
        return isSet.contains("minTargetCapacity");
    }
    //endregion

    //region Max target capacity
    @JsonIgnore
    public boolean isMaxTargetCapcitySet() {
        return isSet.contains("maxTargetCapacity");
    }
    //endregion

    //region Statistics
    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistics) {
        isSet.add("statistic");
        this.statistic = statistics;
    }

    @JsonIgnore
    public boolean isStatisticSet() {
        return isSet.contains("statistic");
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

    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("unit");
    }
    //endregion

    //region Threshold
    public Float getThreshold() {
        return threshold;
    }

    public void setThreshold(Float threshold) {
        isSet.add("threshold");
        this.threshold = threshold;
    }

    @JsonIgnore
    public boolean isThresholdSet() {
        return isSet.contains("threshold");
    }
    //endregion

    //region Namespace
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        isSet.add("namespace");
        this.namespace = namespace;
    }

    @JsonIgnore
    public boolean isNamespaceSet() {
        return isSet.contains("namespace");
    }
    //endregion

    //region Period
    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        isSet.add("period");
        this.period = period;
    }

    @JsonIgnore
    public boolean isPeriodSet() {
        return isSet.contains("period");
    }
    //endregion

    //region Evaluation periods
    public Integer getEvaluationPeriods() {
        return evaluationPeriods;
    }

    public void setEvaluationPeriods(Integer evaluationPeriods) {
        isSet.add("evaluationPeriods");
        this.evaluationPeriods = evaluationPeriods;
    }

    @JsonIgnore
    public boolean isEvaluationPeriodsSet() {
        return isSet.contains("evaluationPeriods");
    }
    //endregion

    //region Cooldown
    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }

    @JsonIgnore
    public boolean isCooldownSet() {
        return isSet.contains("cooldown");
    }
    //endregion

    //region Dimensions
    public List<ApiScalingDimensionAzure> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<ApiScalingDimensionAzure> dimensions) {
        isSet.add("dimensions");
        this.dimensions = dimensions;
    }

    @JsonIgnore
    public boolean isDimensionsSet() {
        return isSet.contains("dimensions");
    }
    //endregion

    //region Policy name
    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        isSet.add("policyName");
        this.policyName = policyName;
    }

    @JsonIgnore
    public boolean isPolicyNameSet() {

        return isSet.contains("policyName");
    }
    //endregion

    //region Action
    public ApiScalingActionAzure getAction() {
        return action;
    }

    public void setAction(ApiScalingActionAzure action) {
        isSet.add("action");
        this.action = action;
    }

    @JsonIgnore
    public boolean isActionSet() {

        return isSet.contains("action");
    }
    //endregion

    //region Operator

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        isSet.add("operator");
        this.operator = operator;
    }

    @JsonIgnore
    public boolean isOperatorSet() {
        return isSet.contains("operator");
    }
    //endregion

    //region isEnabled
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    @JsonIgnore
    public Boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }
    //endregion

    //endregion
}
