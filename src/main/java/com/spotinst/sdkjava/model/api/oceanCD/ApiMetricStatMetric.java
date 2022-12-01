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
public class ApiMetricStatMetric implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    metricName;
    private String                                    namespace;
    private List<ApiMetricDimensions>                 dimensions;

    public ApiMetricStatMetric() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        isSet.add("metricName");
        this.metricName = metricName;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        isSet.add("namespace");
        this.namespace = namespace;
    }

    public List<ApiMetricDimensions> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<ApiMetricDimensions> dimensions) {
        isSet.add("dimensions");
        this.dimensions = dimensions;
    }

    @JsonIgnore
    public boolean isDimensionsSet() {
        return isSet.contains("dimensions");
    }

    @JsonIgnore
    public boolean isMetricNameSet() {
        return isSet.contains("metricName");
    }

    @JsonIgnore
    public boolean isNamespaceSet() {
        return isSet.contains("namespace");
    }
}