package com.spotinst.sdkjava.enums.azure.statefulNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodePerformAtEnum {

    NEVER("never"),
    TIMEWINDOW("timeWindow"),
    ALWAYS("always");

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodePerformAtEnum.class);
    private              String name;

    AzureStatefulNodePerformAtEnum(String name) {
        this.name = name;
    }

    public static AzureStatefulNodePerformAtEnum fromName(String name) {
        AzureStatefulNodePerformAtEnum retVal = null;

        for (AzureStatefulNodePerformAtEnum enumValue : AzureStatefulNodePerformAtEnum.values()) {
            if (name.equalsIgnoreCase(enumValue.name)) {
                retVal = enumValue;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create 'perform at' enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
