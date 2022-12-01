package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiProviderCloudWatch implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    duration;
    private List<ApiCloudWatchMetricDataQueries>      metricDataQueries;

    public ApiProviderCloudWatch() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        isSet.add("duration");
        this.duration = duration;
    }

    public List<ApiCloudWatchMetricDataQueries> getMetricDataQueries() {
        return metricDataQueries;
    }

    public void setMetricDataQueries(List<ApiCloudWatchMetricDataQueries> metricDataQueries) {
        isSet.add("metricDataQueries");
        this.metricDataQueries = metricDataQueries;
    }

    @JsonIgnore
    public boolean isMetricDataQueriesSet() {
        return isSet.contains("metricDataQueries");
    }

    @JsonIgnore
    public boolean isDurationSet() {
        return isSet.contains("duration");
    }
}