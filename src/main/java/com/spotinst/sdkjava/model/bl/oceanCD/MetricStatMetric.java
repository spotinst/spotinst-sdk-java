package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricStatMetric {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    metricName;
    private String                                    namespace;
    private List<MetricDimensions>                    dimensions;

    private MetricStatMetric() {
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

    public List<MetricDimensions> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<MetricDimensions> dimensions) {
        isSet.add("dimensions");
        this.dimensions = dimensions;
    }

    public static class Builder {
        private MetricStatMetric metricStatMetric;

        private Builder() {
            this.metricStatMetric = new MetricStatMetric();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDimensions(final List<MetricDimensions> dimensions) {
            metricStatMetric.setDimensions(dimensions);
            return this;
        }

        public Builder setMetricName(final String metricName) {
            metricStatMetric.setMetricName(metricName);
            return this;
        }

        public Builder setNamespace(final String namespace) {
            metricStatMetric.setNamespace(namespace);
            return this;
        }

        public MetricStatMetric build() {
            return metricStatMetric;
        }
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