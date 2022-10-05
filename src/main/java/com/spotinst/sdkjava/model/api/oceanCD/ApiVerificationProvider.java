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
public class ApiVerificationProvider implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private List<String>                              clusterIds;
    private ApiVerificationProviderPrometheus         prometheus;
    private ApiVerificationProviderDatadog            datadog;
    private ApiVerificationProviderNewRelic           newRelic;
    private ApiVerificationProviderCloudWatch         cloudWatch;

    public ApiVerificationProvider() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public List<String> getClusterIds() {
        return clusterIds;
    }

    public void setClusterIds(List<String> clusterIds) {
        isSet.add("clusterIds");
        this.clusterIds = clusterIds;
    }

    public ApiVerificationProviderPrometheus getPrometheus() {
        return prometheus;
    }

    public void setPrometheus(ApiVerificationProviderPrometheus prometheus) {
        isSet.add("prometheus");
        this.prometheus = prometheus;
    }

    public ApiVerificationProviderDatadog getDatadog() {
        return datadog;
    }

    public void setDatadog(ApiVerificationProviderDatadog datadog) {
        isSet.add("datadog");
        this.datadog = datadog;
    }

    public ApiVerificationProviderNewRelic getNewRelic() {
        return newRelic;
    }

    public void setNewRelic(ApiVerificationProviderNewRelic newRelic) {
        isSet.add("newRelic");
        this.newRelic = newRelic;
    }

    public ApiVerificationProviderCloudWatch getCloudWatch() {
        return cloudWatch;
    }

    public void setCloudWatch(ApiVerificationProviderCloudWatch cloudWatch) {
        isSet.add("cloudWatch");
        this.cloudWatch = cloudWatch;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isClusterIdsSet() {
        return isSet.contains("clusterIds");
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