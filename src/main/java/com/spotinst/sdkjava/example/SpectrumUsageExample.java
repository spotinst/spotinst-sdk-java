package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;

import java.io.IOException;

public class SpectrumUsageExample {

    private final static String auth_token = "your-token";
    private final static String act_id     = "your-account-id";

    public static void main(String[] args) throws IOException {

        // Get elastigroup service client
        SpotinstSpectrumClient spectrumClient = SpotinstClient.getSpectrumClient(auth_token, act_id);

        // Create metric data request
        SpectrumMetricDataRequest.Builder metricRequestBuilder = SpectrumMetricDataRequest.Builder.get();
        SpectrumMetricData.Builder        metricDataBuilder    = SpectrumMetricData.Builder.get();

        // Build Dimension
        SpectrumMetricDimension.Builder metricDimensionBuilder = SpectrumMetricDimension.Builder.get();
        SpectrumMetricDimension         metricDimension        =
                metricDimensionBuilder.setName("runtime_id").setValue("rt-c1dbf0fb").build();

        // Build Metric
        SpectrumMetric.Builder metricBuilder = SpectrumMetric.Builder.get();
        SpectrumMetric cpuUtilization =
                metricBuilder.setName("cpu_load").setUnit(SpectrumMetricUnit.PERCENT).setValue(70).build();

        // Build Metric Data
        SpectrumMetricData metricData =
                metricDataBuilder.setDimensions(metricDimension).setMetrics(cpuUtilization).setNamespace("spotinst/compute").build();

        // Build Metric Data Request
        SpectrumMetricDataRequest metricDataRequest = metricRequestBuilder.addMetricData(metricData).build();

        // Publish data
        spectrumClient.publishMetricData(metricDataRequest);

    }
}
