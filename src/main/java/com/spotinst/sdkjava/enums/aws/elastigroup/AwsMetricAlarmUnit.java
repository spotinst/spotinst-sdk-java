package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsMetricAlarmUnit {

    SECONDS("seconds"),
    MICROSECONDS("microseconds"),
    MILLISECONDS("milliseconds"),
    BYTES("bytes"),
    KILOBYTES("kilobytes"),
    MEGABYTES("megabytes"),
    GIGABYTES("gigabytes"),
    TERABYTES("terabytes"),
    BITS("bits"),
    KILOBITS("kilobits"),
    MEGABITS("megabits"),
    GIGABITS("gigabits"),
    TERABITS("terabits"),
    PERCENT("percent"),
    COUNT("count"),
    BYTESPERSECOND("bytes/second"),
    KILOBYTESPERSECOND("kilobytes/second"),
    MEGABYTESPERSECOND("megabytes/second"),
    GIGABYTESPERSECOND("gigabytes/second"),
    TERABYTESPERSECOND("terabytes/second"),
    BITSPERSECOND("bits/second"),
    KILOBITSPERSECOND("kilobits/second"),
    MEGABITSPERSECOND("megabits/second"),
    GIGABITSPERSECOND("gigabits/second"),
    TERABITSPERSECOND("terabits/second"),
    COUNTPERSECOND("count/second"),
    NONE("none");


    private static final Logger LOGGER = LoggerFactory.getLogger(AwsMetricAlarmUnit.class);
    private String name;

    AwsMetricAlarmUnit(String name) {
        this.name = name;
    }

    public static AwsMetricAlarmUnit fromName(String name) {
        AwsMetricAlarmUnit retVal = null;

        for (AwsMetricAlarmUnit credit : AwsMetricAlarmUnit.values()) {
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
