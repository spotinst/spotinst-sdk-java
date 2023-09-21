package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsMetricSource {

    CLOUDWATCH("cloudWatch"),
    SPECTRUM("spectrum");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsMetricSource.class);
    private String name;

    AwsMetricSource(String name) {
        this.name = name;
    }

    public static AwsMetricSource fromName(String name) {
        AwsMetricSource retVal = null;

        for (AwsMetricSource credit : AwsMetricSource.values()) {
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
