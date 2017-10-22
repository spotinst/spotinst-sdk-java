package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.ElastigroupOrientationEnum;
import com.spotinst.sdkjava.enums.SubscriptionEventTypeEnum;
import com.spotinst.sdkjava.enums.SubscriptionProtocolEnum;
import com.spotinst.sdkjava.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpectrumUsageExample {

    public static void main(String[] args) throws IOException {

        // Get elastigroup service client
        SpotinstSpectrumClient spectrumClient = SpotinstClient.getSpectrumClient("place-your-token-here","account-id");

        // Create metric data request
        SpectrumMetricDataRequest.Builder metricRequestBuilder = SpectrumMetricDataRequest.Builder.get();
        SpectrumMetricData.Builder metricDataBuilder = SpectrumMetricData.Builder.get();

        // Build Dimension
        SpectrumMetricDimension.Builder metricDimensionBuilder = SpectrumMetricDimension.Builder.get();
        SpectrumMetricDimension           metricDimension                = metricDimensionBuilder.setName("instanceId").setValue("i-123456789").build();

        // Build Metric
        SpectrumMetric.Builder metricBuilder = SpectrumMetric.Builder.get();
        SpectrumMetric         cpuUtilization =
                metricBuilder.setName("CPUUtilizationTest").setUnit(SpectrumMetricUnit.PERCENT).setValue(36).build();

        // Build Metric Data
        SpectrumMetricData        metricData      =
                metricDataBuilder.addDimension(metricDimension).addMetric(cpuUtilization).build();

        // Build Metric Data Request
        SpectrumMetricDataRequest metricDataRequest = metricRequestBuilder.addMetricData(metricData).build();

        // Publish data
        spectrumClient.publishMetricData(metricDataRequest);

    }
}
