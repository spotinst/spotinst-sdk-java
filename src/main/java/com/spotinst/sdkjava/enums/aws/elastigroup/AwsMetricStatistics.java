package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsMetricStatistics {

    AVERAGE("average"),
    SUM("sum"),
    SAMPLECOUNT("sampleCount"),
    MAXIMUM("maximum"),
    MINIMUM("minimum"),
    PERCENTILE("percentile");


    private static final Logger LOGGER = LoggerFactory.getLogger(AwsMetricStatistics.class);
    private String name;

    AwsMetricStatistics(String name) {
        this.name = name;
    }

    public static AwsMetricStatistics fromName(String name) {
        AwsMetricStatistics retVal = null;

        for (AwsMetricStatistics credit : AwsMetricStatistics.values()) {
            if (name.equalsIgnoreCase(credit.name)) {
                retVal = credit;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create cpuCredits enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
