package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpectrumMetric {

  private String unit;
  private String name;
  private Number value;

  private SpectrumMetric() {
  }

  public String getUnit() {
    return this.unit;
  }

  void setUnit(String unit) {
    this.unit = unit;
  }

  public String getName() {
    return this.name;
  }

  void setName(String name) {
    this.name = name;
  }

  public Number getValue() {
    return this.value;
  }

  void setValue(Number value) {
    this.value = value;
  }

  public static class Builder {

    private SpectrumMetric metric;

    private Builder() {
      this.metric = new SpectrumMetric();
    }

    public static Builder get(){
        return new Builder();
    }

    public Builder setUnit(final SpectrumMetricUnit spectrumMetricUnit) {
      metric.setUnit(spectrumMetricUnit.getName());
      return this;
    }

    public Builder setName(final String name) {
      metric.setName(name);
      return this;
    }

    public Builder setValue(final Number value) {
      metric.setValue(value);
      return this;
    }

    public SpectrumMetric build() {
      // TODO : Validations
      return metric;
    }
  }
}
