package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupScalingPolicyGcp implements IPartialUpdateEntity {
        @JsonIgnore
        private Set<String>                             isSet;
        private ApiElastigroupScalingActionGcp          action;
        private Integer                                 cooldown;
        private String                                  policyName;
        private String                                  metricName;
        private String                                  source;
        private String                                  statistic;
        private Integer                                 threshold;
        private String                                  unit;
        private String                                  namespace;
        private Integer                                 period;
        private Integer                                 evaluationPeriods;
        private List<ApiElastigroupScalingDimensionGcp> dimensions;
        private String                                  operator;


        public ApiElastigroupScalingPolicyGcp() {
        isSet = new HashSet<>();
    }

        public Set<String> getIsSet() {
            return isSet;
        }

        public void setIsSet(Set<String> isSet) {
            this.isSet = isSet;
        }

        public String getMetricName() {
            return metricName;
        }

        public void setMetricName(String metricName) {
            isSet.add("metricName");
            this.metricName = metricName;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            isSet.add("source");
            this.source = source;
        }

        public String getStatistic() {
            return statistic;
        }

        public void setStatistic(String statistics) {
            isSet.add("statistic");
            this.statistic = statistics;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            isSet.add("unit");
            this.unit = unit;
        }

        public Integer getThreshold() {
            return threshold;
        }

        public void setThreshold(Integer threshold) {
            isSet.add("threshold");
            this.threshold = threshold;
        }

        public String getNamespace() {
            return namespace;
        }

        public void setNamespace(String namespace) {
            isSet.add("namespace");
            this.namespace = namespace;
        }

        public Integer getPeriod() {
            return period;
        }

        public void setPeriod(Integer period) {
            isSet.add("period");
            this.period = period;
        }

        public Integer getEvaluationPeriods() {
            return evaluationPeriods;
        }

        public void setEvaluationPeriods(Integer evaluationPeriods) {
            isSet.add("evaluationPeriods");
            this.evaluationPeriods = evaluationPeriods;
        }

        public Integer getCooldown() {
            return cooldown;
        }

        public void setCooldown(Integer cooldown) {
            isSet.add("cooldown");
            this.cooldown = cooldown;
        }

        public String getPolicyName() {
            return policyName;
        }

        public void setPolicyName(String policyName) {
            isSet.add("policyName");
            this.policyName = policyName;
        }

        public List<ApiElastigroupScalingDimensionGcp> getDimensions() {
            return dimensions;
        }

        public void setDimensions(List<ApiElastigroupScalingDimensionGcp> dimensions) {
            isSet.add("dimensions");
            this.dimensions = dimensions;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            isSet.add("operator");
            this.operator = operator;
        }

        public ApiElastigroupScalingActionGcp getAction() {
            return action;
        }

        public void setAction(ApiElastigroupScalingActionGcp action) {
            isSet.add("action");
            this.action = action;
        }


        @JsonIgnore
        public boolean isPolicyNameSet() {
            return isSet.contains("policyName");
        }

        @JsonIgnore
        public boolean isMetricNameSet() {
            return isSet.contains("metricName");
        }

        @JsonIgnore
        public boolean isSourceSet() {
            return isSet.contains("source");
        }

        @JsonIgnore
        public boolean isStatisticSet() {
            return isSet.contains("statistic");
        }

        @JsonIgnore
        public boolean isUnitSet() {
            return isSet.contains("unit");
        }

        @JsonIgnore
        public boolean isThresholdSet() {
            return isSet.contains("threshold");
        }

        @JsonIgnore
        public boolean isNamespaceSet() {
            return isSet.contains("namespace");
        }

        @JsonIgnore
        public boolean isPeriodSet() {
            return isSet.contains("period");
        }

        @JsonIgnore
        public boolean isEvaluationPeriodsSet() {
            return isSet.contains("evaluationPeriods");
        }

        @JsonIgnore
        public boolean isCooldownSet() {
            return isSet.contains("cooldown");
        }

        @JsonIgnore
        public boolean isDimensionsSet() {
            return isSet.contains("dimensions");
        }

        @JsonIgnore
        public boolean isActionSet() {
            return isSet.contains("action");
        }

        @JsonIgnore
        public boolean isOperatorSet() {
            return isSet.contains("operator");
        }

}
