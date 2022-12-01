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
public class ApiCloudWatchMetricDataQueries implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    id;
    private String                                    expression;
    private String                                    label;
    private Integer                                   period;
    private Boolean                                   returnData;
    private ApiMetricDataQueriesMetricStat             metricStat;

    public ApiCloudWatchMetricDataQueries() {
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

    public ApiMetricDataQueriesMetricStat getMetricStat() {
        return metricStat;
    }

    public void setMetricStat(ApiMetricDataQueriesMetricStat metricStat) {
        isSet.add("metricStat");
        this.metricStat = metricStat;
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