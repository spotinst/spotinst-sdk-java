package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScalingPolicyAzure {

    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet = new HashSet<>();
    private String                      policyName;
    private String                      metricName;
    private String                      statistic;
    private String                      unit;
    private Float                       threshold;
    private Integer                     period;
    private Integer                     evaluationPeriods;
    private Integer                     cooldown;
    private ScalingActionAzure          action;
    private String                      operator;
    private String                      namespace;
    private List<ScalingDimensionAzure> dimensions;
    private Boolean                     isEnabled;
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //region Metric name
    public String getMetricName() {
        return metricName;
    }

    private void setMetricName(String metricName) {
        isSet.add("metricName");
        this.metricName = metricName;
    }

    //endregion

    //region Statistics
    public String getStatistic() {
        return statistic;
    }

    private void setStatistic(String statistics) {
        isSet.add("statistic");
        this.statistic = statistics;
    }

    //endregion

    //region Unit
    public String getUnit() {
        return unit;
    }

    private void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }
    //endregion

    //region Threshold
    public Float getThreshold() {
        return threshold;
    }

    private void setThreshold(Float threshold) {
        isSet.add("threshold");
        this.threshold = threshold;
    }
    //endregion

    //region Namespace
    public String getNamespace() {
        return namespace;
    }

    private void setNamespace(String namespace) {
        isSet.add("namespace");
        this.namespace = namespace;
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
    //endregion

    //region Evaluation periods
    public Integer getEvaluationPeriods() {
        return evaluationPeriods;
    }

    private void setEvaluationPeriods(Integer evaluationPeriods) {
        isSet.add("evaluationPeriods");
        this.evaluationPeriods = evaluationPeriods;
    }

    //endregion

    //region Cooldown
    public Integer getCooldown() {
        return cooldown;
    }

    private void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }
    //endregion


    //region Policy Name
    public String getPolicyName() {
        return policyName;
    }

    private void setPolicyName(String policyName) {
        isSet.add("policyName");
        this.policyName = policyName;
    }
    //endregion

    //region is Enabled

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean enabled) {
        isSet.add("isEnabled");
        isEnabled = enabled;
    }
    //endregion

    //region Dimensions
    public List<ScalingDimensionAzure> getDimensions() {
        return dimensions;
    }

    private void setDimensions(List<ScalingDimensionAzure> dimensions) {
        isSet.add("dimensions");
        this.dimensions = dimensions;
    }

    //endregion


    //region operator
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        isSet.add("operator");
        this.operator = operator;
    }
    //endregion


    //region action
    public ScalingActionAzure getAction() {
        return action;
    }

    public void setAction(ScalingActionAzure action) {
        isSet.add("action");
        this.action = action;
    }
    //endregion
    //endregion

    //region equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ScalingPolicyAzure that = (ScalingPolicyAzure) o;

        if (!policyName.equals(that.policyName)) {
            return false;
        }
        if (!metricName.equals(that.metricName)) {
            return false;
        }
        if (!statistic.equals(that.statistic)) {
            return false;
        }
        if (!unit.equals(that.unit)) {
            return false;
        }
        if (!threshold.equals(that.threshold)) {
            return false;
        }
        if (!namespace.equals(that.namespace)) {
            return false;
        }
        if (!period.equals(that.period)) {
            return false;
        }
        if (!evaluationPeriods.equals(that.evaluationPeriods)) {
            return false;
        }
        if (!cooldown.equals(that.cooldown)) {
            return false;
        }
        if (!dimensions.equals(that.dimensions)) {
            return false;
        }
        if (!isEnabled.equals(that.isEnabled)) {
            return false;
        }

        if (!operator.equals(that.operator)) {
            return false;
        }
        return action.equals(that.action);

    }

    @Override
    public int hashCode() {
        int result = policyName.hashCode();
        result = 31 * result + metricName.hashCode();
        result = 31 * result + statistic.hashCode();
        result = 31 * result + unit.hashCode();
        result = 31 * result + threshold.hashCode();
        result = 31 * result + namespace.hashCode();
        result = 31 * result + period.hashCode();
        result = 31 * result + evaluationPeriods.hashCode();
        result = 31 * result + cooldown.hashCode();
        result = 31 * result + dimensions.hashCode();
        result = 31 * result + action.hashCode();
        result = 31 * result + operator.hashCode();
        result = 31 * result + isEnabled.hashCode();
        return result;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ScalingPolicyAzure scalingPolicy;

        private Builder() {
            this.scalingPolicy = new ScalingPolicyAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setUnit(final String unit) {
            scalingPolicy.setUnit(unit);
            return this;
        }

        public Builder setThreshold(final Float threshold) {
            scalingPolicy.setThreshold(threshold);
            return this;
        }

        public Builder setStatistic(final String statistic) {
            scalingPolicy.setStatistic(statistic);
            return this;
        }

        public Builder setPolicyName(final String policyName) {
            scalingPolicy.setPolicyName(policyName);
            return this;
        }

        public Builder setPeriod(final Integer period) {
            scalingPolicy.setPeriod(period);
            return this;
        }

        public Builder setNamespace(final String namespace) {
            scalingPolicy.setNamespace(namespace);
            return this;
        }

        public Builder setMetricName(final String metricName) {
            scalingPolicy.setMetricName(metricName);
            return this;
        }

        public Builder setDimensions(final List<ScalingDimensionAzure> dimensions) {
            scalingPolicy.setDimensions(dimensions);
            return this;
        }

        public Builder setCooldown(final Integer cooldown) {
            scalingPolicy.setCooldown(cooldown);
            return this;
        }

        public Builder setAction(final ScalingActionAzure scalingAction) {
            scalingPolicy.setAction(scalingAction);
            return this;
        }

        public Builder setOperator(final String operator) {
            scalingPolicy.setOperator(operator);
            return this;
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            scalingPolicy.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setEvaluationPeriods(final Integer evaluationPeriods) {
            scalingPolicy.setEvaluationPeriods(evaluationPeriods);
            return this;
        }

        public ScalingPolicyAzure build() {
            // TODO : Validations
            return scalingPolicy;
        }
    }
    //endregion

    //region isSet methods
    // Is policyName Set boolean method
    @JsonIgnore
    public boolean isPolicyNameSet() {
        return isSet.contains("policyName");
    }


    // Is metricName Set boolean method
    @JsonIgnore
    public boolean isMetricNameSet() {
        return isSet.contains("metricName");
    }


    // Is statistic Set boolean method
    @JsonIgnore
    public boolean isStatisticSet() {
        return isSet.contains("statistic");
    }
    
    // Is unit Set boolean method
    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("unit");
    }


    // Is threshold Set boolean method
    @JsonIgnore
    public boolean isThresholdSet() {
        return isSet.contains("threshold");
    }


    // Is namespace Set boolean method
    @JsonIgnore
    public boolean isNamespaceSet() {
        return isSet.contains("namespace");
    }


    // Is period Set boolean method
    @JsonIgnore
    public boolean isPeriodSet() {
        return isSet.contains("period");
    }


    // Is evaluationPeriods Set boolean method
    @JsonIgnore
    public boolean isEvaluationPeriodsSet() {
        return isSet.contains("evaluationPeriods");
    }


    // Is cooldown Set boolean method
    @JsonIgnore
    public boolean isCooldownSet() {
        return isSet.contains("cooldown");
    }

    // Is dimensions Set boolean method
    @JsonIgnore
    public boolean isDimensionsSet() {
        return isSet.contains("dimensions");
    }


    // Is action Set boolean method
    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }

    // Is operator Set boolean method
    @JsonIgnore
    public boolean isOperatorSet() {
        return isSet.contains("operator");
    }

    // Is operator Set boolean method
    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }
    //endregion


}
