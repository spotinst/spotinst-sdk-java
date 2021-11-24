package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzurePerformAtEnum {

    never("never"),
    timeWindow("timeWindow"),
    always("always");

    private static final Logger LOGGER = LoggerFactory.getLogger(AzurePerformAtEnum.class);
    private              String name;

    private AzurePerformAtEnum(String name) {
        this.name = name;
    }

    public static AzurePerformAtEnum fromName(String name) {
        AzurePerformAtEnum retVal = null;

        for (AzurePerformAtEnum instanceMarketEnum : AzurePerformAtEnum.values()) {
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
