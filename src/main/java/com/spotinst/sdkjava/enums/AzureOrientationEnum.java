package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureOrientationEnum {

    COST("cost"),
    AVAILABILITY("availability"),
    CHEAPEST("cheapest");

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureOrientationEnum.class);
    private final String name;

    AzureOrientationEnum(String name) {
        this.name = name;
    }

    public static AzureOrientationEnum fromName(String name) {
        AzureOrientationEnum retVal = null;
        for (AzureOrientationEnum availabilityTypeEnum : AzureOrientationEnum.values()) {
            if (name.equals(availabilityTypeEnum.name)) {
                retVal = availabilityTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create group availability vs cost enum for: " + name + ", but we don't support such type ");
        }
        return retVal;
    }

    public String getName() {
        return name;
    }
}
