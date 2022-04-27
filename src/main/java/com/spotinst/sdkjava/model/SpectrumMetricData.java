package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpectrumMetricData {

  private String namespace;
  private List<SpectrumMetricDimension> dimensions = new LinkedList<>();
  private List<SpectrumMetric> metrics = new LinkedList<>();

  private SpectrumMetricData() {
  }

  public String getNamespace() {
    return this.namespace;
  }

  void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public List<SpectrumMetricDimension> getDimensions() {
    return this.dimensions;
  }

  void setDimensions(List<SpectrumMetricDimension> dimensions) {
    this.dimensions = dimensions;
  }

  public List<SpectrumMetric> getMetrics() {
    return this.metrics;
  }

  void setMetrics(List<SpectrumMetric> metrics) {
    this.metrics = metrics;
  }

  public static class Builder {

    private SpectrumMetricData spectrumMetricData;

    private Builder() {
      this.spectrumMetricData = new SpectrumMetricData();
    }

    public static Builder get() {
        return new Builder();
    }

    public Builder setNamespace(final String namespace) {
      spectrumMetricData.setNamespace(namespace);
      return this;
    }

    public Builder setDimensions(final List<SpectrumMetricDimension> dimensions) {
      spectrumMetricData.setDimensions(dimensions);
      return this;
    }

    public Builder setDimensions(SpectrumMetricDimension... dimensions) {
      return setDimensions(Arrays.asList(dimensions));
    }

    public Builder addDimension(SpectrumMetricDimension dimension) {
      spectrumMetricData.dimensions.add(dimension);
      return this;
    }

    public Builder setMetrics(final List<SpectrumMetric> metrics) {
      spectrumMetricData.setMetrics(metrics);
      return this;
    }

    public Builder setMetrics(SpectrumMetric... metrics) {
      return setMetrics(Arrays.asList(metrics));
    }

    public Builder addMetric(SpectrumMetric metric) {
      spectrumMetricData.metrics.add(metric);
      return this;
    }

    public SpectrumMetricData build() {
      return spectrumMetricData;
    }
  }
}
