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
public class ApiVerificationTemplate implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                  isSet;
    private String                                       name;
    private List<ApiVerificationTemplateArgs>            args;
    private List<ApiVerificationTemplateMetrics>         metrics;

    public ApiVerificationTemplate() {
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

    public List<ApiVerificationTemplateArgs> getArgs() {
        return args;
    }

    public void setArgs(List<ApiVerificationTemplateArgs> args) {
        isSet.add("args");
        this.args = args;
    }

    public List<ApiVerificationTemplateMetrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<ApiVerificationTemplateMetrics> metrics) {
        isSet.add("metrics");
        this.metrics = metrics;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isArgsSet() {
        return isSet.contains("args");
    }

    @JsonIgnore
    public boolean isMetricsSet() {
        return isSet.contains("metrics");
    }
}