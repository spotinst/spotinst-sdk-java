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
public class ApiMetricsProvider implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private ApiProviderPrometheus                     prometheus;
    private ApiProviderDatadog                        datadog;
    private ApiProviderNewRelic                       newRelic;
    private ApiProviderCloudWatch                     cloudWatch;
    private ApiProviderWeb                            web;

    public ApiMetricsProvider() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiProviderPrometheus getPrometheus() {
        return prometheus;
    }

    public void setPrometheus(ApiProviderPrometheus prometheus) {
        isSet.add("prometheus");
        this.prometheus = prometheus;
    }

    public ApiProviderDatadog getDatadog() {
        return datadog;
    }

    public void setDatadog(ApiProviderDatadog datadog) {
        isSet.add("datadog");
        this.datadog = datadog;
    }

    public ApiProviderNewRelic getNewRelic() {
        return newRelic;
    }

    public void setNewRelic(ApiProviderNewRelic newRelic) {
        isSet.add("newRelic");
        this.newRelic = newRelic;
    }

    public ApiProviderCloudWatch getCloudWatch() {
        return cloudWatch;
    }

    public void setCloudWatch(ApiProviderCloudWatch cloudWatch) {
        isSet.add("cloudWatch");
        this.cloudWatch = cloudWatch;
    }

    public ApiProviderWeb getWeb() {
        return web;
    }

    public void setWeb(ApiProviderWeb web) {
        isSet.add("web");
        this.web = web;
    }

    @JsonIgnore
    public boolean isWebSet() {
        return isSet.contains("web");
    }

    @JsonIgnore
    public boolean isPrometheusSet() {
        return isSet.contains("prometheus");
    }

    @JsonIgnore
    public boolean isDatadogSet() {
        return isSet.contains("datadog");
    }

    @JsonIgnore
    public boolean isNewRelicSet() {
        return isSet.contains("newRelic");
    }

    @JsonIgnore
    public boolean isCloudWatchSet() {
        return isSet.contains("cloudWatch");
    }
}