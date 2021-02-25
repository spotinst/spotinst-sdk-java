package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PerformAtEnumGcp {

    never("never"),
    timeWindow("timeWindow"),
    always("always");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsInstanceTypeEnum.class);
    private String name;

    private PerformAtEnumGcp(String name) {
        this.name = name;
    }

    public static PerformAtEnumGcp fromName(String name) {
        PerformAtEnumGcp retVal = null;

        for (PerformAtEnumGcp instanceMarketEnum : PerformAtEnumGcp.values()) {
            if (name.equalsIgnoreCase(instanceMarketEnum.name)) {
                retVal = instanceMarketEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create 'perfom at' enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
