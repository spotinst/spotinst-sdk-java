package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricDataQueriesMetricStat {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    expression;
    private Integer                                   period;
    private String                                    stat;
    private String                                    unit;
    private MetricStatMetric                          metric;

    private MetricDataQueriesMetricStat() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        isSet.add("stat");
        this.stat = stat;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }

    public MetricStatMetric getMetric() {
        return metric;
    }

    public void setMetric(MetricStatMetric metric) {
        isSet.add("metric");
        this.metric = metric;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        isSet.add("expression");
        this.expression = expression;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        isSet.add("period");
        this.period = period;
    }

    public static class Builder {
        private MetricDataQueriesMetricStat metricDataQueriesMetricStat;

        private Builder() {
            this.metricDataQueriesMetricStat = new MetricDataQueriesMetricStat();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMetric(final MetricStatMetric metric) {
            metricDataQueriesMetricStat.setMetric(metric);
            return this;
        }

        public Builder setExpression(final String expression) {
            metricDataQueriesMetricStat.setExpression(expression);
            return this;
        }

        public Builder setStat(final String stat) {
            metricDataQueriesMetricStat.setStat(stat);
            return this;
        }

        public Builder setPeriod(final Integer period) {
            metricDataQueriesMetricStat.setPeriod(period);
            return this;
        }

        public Builder setUnit(final String unit) {
            metricDataQueriesMetricStat.setUnit(unit);
            return this;
        }

        public MetricDataQueriesMetricStat build() {
            return metricDataQueriesMetricStat;
        }
    }

    @JsonIgnore
    public boolean isStatSet() {
        return isSet.contains("stat");
    }

    @JsonIgnore
    public boolean isExpressionSet() {
        return isSet.contains("expression");
    }

    @JsonIgnore
    public boolean isMetricSet() {
        return isSet.contains("metric");
    }

    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("Unit");
    }

    @JsonIgnore
    public boolean isPeriodSet() {
        return isSet.contains("period");
    }
}