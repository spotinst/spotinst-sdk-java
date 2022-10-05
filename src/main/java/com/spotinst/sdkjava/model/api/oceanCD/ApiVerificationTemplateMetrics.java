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
public class ApiVerificationTemplateMetrics implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private String                                    interval;
    private String                                    initialDelay;
    private Integer                                   count;
    private String                                    successCondition;
    private String                                    failureCondition;
    private Integer                                   failureLimit;
    private Integer                                   inconclusiveLimit;
    private Integer                                   consecutiveErrorLimit;
    private ApiMetricsProvider                        provider;

    public ApiVerificationTemplateMetrics() {
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

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        isSet.add("interval");
        this.interval = interval;
    }

    public String getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(String initialDelay) {
        isSet.add("initialDelay");
        this.initialDelay = initialDelay;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        isSet.add("count");
        this.count = count;
    }

    public String getSuccessCondition() {
        return successCondition;
    }

    public void setSuccessCondition(String successCondition) {
        isSet.add("successCondition");
        this.successCondition = successCondition;
    }

    public String getFailureCondition() {
        return failureCondition;
    }

    public void setFailureCondition(String failureCondition) {
        isSet.add("failureCondition");
        this.failureCondition = failureCondition;
    }

    public Integer getFailureLimit() {
        return failureLimit;
    }

    public void setFailureLimit(Integer failureLimit) {
        isSet.add("failureLimit");
        this.failureLimit = failureLimit;
    }

    public Integer getInconclusiveLimit() {
        return inconclusiveLimit;
    }

    public void setInconclusiveLimit(Integer inconclusiveLimit) {
        isSet.add("inconclusiveLimit");
        this.inconclusiveLimit = inconclusiveLimit;
    }

    public Integer getConsecutiveErrorLimit() {
        return consecutiveErrorLimit;
    }

    public void setConsecutiveErrorLimit(Integer consecutiveErrorLimit) {
        isSet.add("consecutiveErrorLimit");
        this.consecutiveErrorLimit = consecutiveErrorLimit;
    }

    public ApiMetricsProvider getProvider() {
        return provider;
    }

    public void setProvider(ApiMetricsProvider provider) {
        isSet.add("provider");
        this.provider = provider;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isIntervalSet() {
        return isSet.contains("interval");
    }

    @JsonIgnore
    public boolean isInitialDelaySet() {
        return isSet.contains("initialDelay");
    }

    @JsonIgnore
    public boolean isCountSet() {
        return isSet.contains("count");
    }

    @JsonIgnore
    public boolean isSuccessConditionSet() {
        return isSet.contains("successCondition");
    }

    @JsonIgnore
    public boolean isFailureConditionSet() {
        return isSet.contains("failureCondition");
    }

    @JsonIgnore
    public boolean isFailureLimitSet() {
        return isSet.contains("failureLimit");
    }

    @JsonIgnore
    public boolean isInconclusiveLimitSet() {
        return isSet.contains("inconclusiveLimit");
    }

    @JsonIgnore
    public boolean isConsecutiveErrorLimitSet() {
        return isSet.contains("consecutiveErrorLimit");
    }

    @JsonIgnore
    public boolean isProviderSet() {
        return isSet.contains("provider");
    }
}