package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.Expressions;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.Metrics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Sobhana Priyadarshani
 * @since: 20/09/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMultipleMetrics implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>       isSet;
    private List<ApiExpressions> expressions;
    private List<ApiMetrics>     metrics;
    //endregion

    //region Constructor

    public ApiMultipleMetrics() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiExpressions> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<ApiExpressions> expressions) {
        isSet.add("expressions");
        this.expressions = expressions;
    }

    public List<ApiMetrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<ApiMetrics> metrics) {
        isSet.add("metrics");
        this.metrics = metrics;
    }

    //endregion

    //expressions isSet methods
    @JsonIgnore
    public boolean isExpressionsSet() {
        return isSet.contains("expressions");
    }

    //metrics isSet methods
    @JsonIgnore
    public boolean isMetricssSet() {
        return isSet.contains("metrics");
    }

    //endregion
}
