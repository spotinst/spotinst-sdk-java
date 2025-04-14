package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScalingPolicyGcp {
        @JsonIgnore
        private Set<String>                             isSet;
        private ElastigroupScalingActionGcp             action;
        private Integer                                 cooldown;
        private List<ElastigroupScalingDimensionGcp>    dimensions;
        private Integer                                 evaluationPeriods;
        private String                                  metricName;
        private String                                  namespace;
        private String                                  operator;
        private Integer                                 period;
        private String                                  policyName;
        private String                                  source;
        private String                                  statistic;
        private Integer                                 threshold;
        private String                                  unit;


        private ElastigroupScalingPolicyGcp() {
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

        private void setMetricName(String metricName) {
            isSet.add("metricName");
            this.metricName = metricName;
        }

        public String getStatistic() {
            return statistic;
        }

        private void setStatistic(String statistics) {
            isSet.add("statistic");
            this.statistic = statistics;
        }

        public String getSource() {
            return source;
        }

        private void setSource(String source) {
            isSet.add("source");
            this.source = source;
        }

        public String getUnit() {
            return unit;
        }

        private void setUnit(String unit) {
            isSet.add("unit");
            this.unit = unit;
        }

        public Integer getThreshold() {
            return threshold;
        }

        private void setThreshold(Integer threshold) {
            isSet.add("threshold");
            this.threshold = threshold;
        }

        public String getNamespace() {
            return namespace;
        }

        private void setNamespace(String namespace) {
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

        private void setEvaluationPeriods(Integer evaluationPeriods) {
            isSet.add("evaluationPeriods");
            this.evaluationPeriods = evaluationPeriods;
        }

        public Integer getCooldown() {
            return cooldown;
        }

        private void setCooldown(Integer cooldown) {
            isSet.add("cooldown");
            this.cooldown = cooldown;
        }

        public String getPolicyName() {
            return policyName;
        }

        private void setPolicyName(String policyName) {
            isSet.add("policyName");
            this.policyName = policyName;
        }

        public List<ElastigroupScalingDimensionGcp> getDimensions() {
            return dimensions;
        }

        private void setDimensions(List<ElastigroupScalingDimensionGcp> dimensions) {
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

        public ElastigroupScalingActionGcp getAction() {
            return action;
        }

        public void setAction(ElastigroupScalingActionGcp action) {
            isSet.add("action");
            this.action = action;
        }

        public static class Builder {
            private ElastigroupScalingPolicyGcp scalingPolicy;

            private Builder() {
                this.scalingPolicy = new ElastigroupScalingPolicyGcp();
            }

            public static Builder get() {
                return new Builder();
            }

            public Builder setUnit(final String unit) {
                scalingPolicy.setUnit(unit);
                return this;
            }

            public Builder setThreshold(final Integer threshold) {
                scalingPolicy.setThreshold(threshold);
                return this;
            }

            public Builder setStatistic(final String statistic) {
                scalingPolicy.setStatistic(statistic);
                return this;
            }

            public Builder setSource(final String source) {
                scalingPolicy.setSource(source);
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

            public Builder setDimensions(final List<ElastigroupScalingDimensionGcp> dimensions) {
                scalingPolicy.setDimensions(dimensions);
                return this;
            }

            public Builder setCooldown(final Integer cooldown) {
                scalingPolicy.setCooldown(cooldown);
                return this;
            }

            public Builder setAction(final ElastigroupScalingActionGcp scalingAction) {
                scalingPolicy.setAction(scalingAction);
                return this;
            }

            public Builder setOperator(final String operator) {
                scalingPolicy.setOperator(operator);
                return this;
            }

            public Builder setEvaluationPeriods(final Integer evaluationPeriods) {
                scalingPolicy.setEvaluationPeriods(evaluationPeriods);
                return this;
            }

            public ElastigroupScalingPolicyGcp build() {
                return scalingPolicy;
            }
        }

        @JsonIgnore
        public boolean isActionSet() {
        return isSet.contains("action");
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
        public boolean isEvaluationPeriodsSet() {
        return isSet.contains("evaluationPeriods");
    }

        @JsonIgnore
        public boolean isMetricNameSet() {
        return isSet.contains("metricName");
    }

        @JsonIgnore
        public boolean isNamespaceSet() {
            return isSet.contains("namespace");
        }

        @JsonIgnore
        public boolean isOperatorSet() {
        return isSet.contains("operator");
    }

        @JsonIgnore
        public boolean isPeriodSet() {
        return isSet.contains("period");
    }

        @JsonIgnore
        public boolean isPolicyNameSet() {
            return isSet.contains("policyName");
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
        public boolean isThresholdSet() {
            return isSet.contains("threshold");
        }

        @JsonIgnore
        public boolean isUnitSet() {
            return isSet.contains("unit");
        }

}

