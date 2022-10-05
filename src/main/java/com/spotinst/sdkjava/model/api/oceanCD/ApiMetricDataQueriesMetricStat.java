package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiMetricDataQueriesMetricStat implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    expression;
    private Integer                                   period;
    private String                                    stat;
    private String                                    unit;
    private ApiMetricStatMetric                       metric;

    public ApiMetricDataQueriesMetricStat() {
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

    public ApiMetricStatMetric getMetric() {
        return metric;
    }

    public void setMetric(ApiMetricStatMetric metric) {
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