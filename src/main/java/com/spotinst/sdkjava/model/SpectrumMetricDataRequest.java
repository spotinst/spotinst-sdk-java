package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.rest.JsonMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpectrumMetricDataRequest {
  //region Members
  private List<SpectrumMetricData> metricData = new LinkedList<>();
  //endregion

  //region Private Constructor
  private SpectrumMetricDataRequest() {
  }
  //endregion

  //region Getter and Setter methods

  public List<SpectrumMetricData> getMetricData() {
    return metricData;
  }

  public void setMetricData(List<SpectrumMetricData> metricData) {
    this.metricData = metricData;
  }

  public void addMetricData(SpectrumMetricData metricData) {
    this.metricData.add(metricData);
  }
  //endregion

  //region Json methods
  public String toJson() {
    String retVal = null;
    if (metricData != null) {

      Map<String, List<SpectrumMetricData>> metricDataRequest = new HashMap<>();
      metricDataRequest.put("metricData", metricData);
      String body = JsonMapper.toJson(metricDataRequest);

      retVal = body;
    }
    return retVal;
  }
  //endregion

  //region Builder class
  public static class Builder {
    private SpectrumMetricDataRequest spectrumMetricDataRequest;

    private Builder() {
      this.spectrumMetricDataRequest = new SpectrumMetricDataRequest();
    }

    public static SpectrumMetricDataRequest.Builder get() {
      SpectrumMetricDataRequest.Builder builder = new SpectrumMetricDataRequest.Builder();
      return builder;
    }

    public SpectrumMetricDataRequest.Builder setMetricData(final List<SpectrumMetricData> spectrumMetricData) {
      spectrumMetricDataRequest.setMetricData(spectrumMetricData);
      return this;
    }

    public SpectrumMetricDataRequest.Builder setMetricData(SpectrumMetricData... spectrumMetricData) {
      return setMetricData(Arrays.asList(spectrumMetricData));
    }

    public SpectrumMetricDataRequest.Builder addMetricData(SpectrumMetricData spectrumMetricData) {
      spectrumMetricDataRequest.addMetricData(spectrumMetricData);
      return this;
    }

    public SpectrumMetricDataRequest build() {
      // TODO : Validations
      return spectrumMetricDataRequest;
    }
  }
  //endregion

}
