package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudWatchMetricDataQueries {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    id;
    private String                                    expression;
    private String                                    label;
    private Integer                                   period;
    private Boolean                                   returnData;
    private MetricDataQueriesMetricStat               metricStat;

    private CloudWatchMetricDataQueries() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        isSet.add("expression");
        this.expression = expression;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        isSet.add("label");
        this.label = label;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        isSet.add("period");
        this.period = period;
    }

    public Boolean getReturnData() {
        return returnData;
    }

    public void setReturnData(Boolean returnData) {
        isSet.add("returnData");
        this.returnData = returnData;
    }

    public MetricDataQueriesMetricStat getMetricStat() {
        return metricStat;
    }

    public void setMetricStat(MetricDataQueriesMetricStat metricStat) {
        isSet.add("metricStat");
        this.metricStat = metricStat;
    }

    public static class Builder {
        private CloudWatchMetricDataQueries cloudWatchMetricDataQueries;

        private Builder() {
            this.cloudWatchMetricDataQueries = new CloudWatchMetricDataQueries();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            cloudWatchMetricDataQueries.setId(id);
            return this;
        }

        public Builder setExpression(final String expression) {
            cloudWatchMetricDataQueries.setExpression(expression);
            return this;
        }

        public Builder setLabel(final String label) {
            cloudWatchMetricDataQueries.setLabel(label);
            return this;
        }

        public Builder setPeriod(final Integer period) {
            cloudWatchMetricDataQueries.setPeriod(period);
            return this;
        }

        public Builder setReturnData(final Boolean returnData) {
            cloudWatchMetricDataQueries.setReturnData(returnData);
            return this;
        }

        public Builder setMetricStat(final MetricDataQueriesMetricStat metricStat) {
            cloudWatchMetricDataQueries.setMetricStat(metricStat);
            return this;
        }

        public CloudWatchMetricDataQueries build() {
            return cloudWatchMetricDataQueries;
        }
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isExpressionSet() {
        return isSet.contains("expression");
    }

    @JsonIgnore
    public boolean isLabelSet() {
        return isSet.contains("label");
    }

    @JsonIgnore
    public boolean isMetricStatSet() {
        return isSet.contains("metricStat");
    }

    @JsonIgnore
    public boolean isPeriodSet() {
        return isSet.contains("period");
    }

    @JsonIgnore
    public boolean isReturnDataSet() {
        return isSet.contains("returnData");
    }
}