package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.client.rest.SpotinstDefaults;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class SpectrumMetricDataRequest {

  private static final String METRIC_DATA_JSON_PREFIX = "{\"metricData\":[";
  private static final String METRIC_DATA_JSON_SUFFIX = "]}";
  private static final int METRIC_DATA_FIXED_SIZE = METRIC_DATA_JSON_PREFIX.length() + METRIC_DATA_JSON_SUFFIX.length();

  private Queue<SpectrumMetricData> metricData = new LinkedList<>();

  private SpectrumMetricDataRequest() {
  }

  public Queue<SpectrumMetricData> getMetricData() {
    return metricData;
  }

  public void setMetricData(Queue<SpectrumMetricData> metricData) {
    this.metricData = metricData;
  }

  public void addMetricData(SpectrumMetricData metricData) {
    this.metricData.add(metricData);
  }

  public Collection<String> toJsonParts() {
    Collection<String> parts = new LinkedList<>();
    if (metricData != null && !metricData.isEmpty()) {
      int size = METRIC_DATA_FIXED_SIZE;
      StringJoiner stringJoiner = newStringJoiner();
      Queue<SpectrumMetricData> queue = this.metricData;
      SpectrumMetricData element = queue.poll();
      do {
        String str = JsonMapper.toJson(element);
        if ((size + str.length()) >= SpotinstDefaults.HTTP_PAYLOAD_THRESHOLD_IN_BYTES) {
          parts.add(stringJoiner.toString());
          stringJoiner = newStringJoiner();
          size = METRIC_DATA_FIXED_SIZE;
        }
        stringJoiner.add(str);
        size += str.length();
        size += 1; // json array element delimiter (,)

      } while ((element = queue.poll()) != null);

      // remainder left?
      if(stringJoiner.length() > METRIC_DATA_FIXED_SIZE) {
        parts.add(stringJoiner.toString());
      }
    }
    return parts;
  }

  private static StringJoiner newStringJoiner() {
    return new StringJoiner(",", METRIC_DATA_JSON_PREFIX, METRIC_DATA_JSON_SUFFIX);
  }


  public static class Builder {
    private SpectrumMetricDataRequest spectrumMetricDataRequest;

    private Builder() {
      this.spectrumMetricDataRequest = new SpectrumMetricDataRequest();
    }

    public static SpectrumMetricDataRequest.Builder get() {
        return new Builder();
    }

    public SpectrumMetricDataRequest.Builder setMetricData(final Queue<SpectrumMetricData> spectrumMetricData) {
      spectrumMetricDataRequest.setMetricData(spectrumMetricData);
      return this;
    }

    public SpectrumMetricDataRequest.Builder setMetricData(SpectrumMetricData... spectrumMetricData) {
      Queue<SpectrumMetricData> queue = new ArrayDeque<>(spectrumMetricData.length);
      Collections.addAll(queue, spectrumMetricData);
      return setMetricData(queue);
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
}
