package com.spotinst.sdkjava.enums.azure.statefulNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeStateEnum {

    RECYCLE("recycle"),
    PAUSE("pause"),
    RESUME("resume");

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeStateEnum.class);
    private              String name;

    private AzureStatefulNodeStateEnum(String name) {
        this.name = name;
    }

    public static AzureStatefulNodeStateEnum fromName(String name) {
        AzureStatefulNodeStateEnum retVal = null;

        for (AzureStatefulNodeStateEnum enumValue : AzureStatefulNodeStateEnum.values()) {
            if (name.equalsIgnoreCase(enumValue.name)) {
                retVal = enumValue;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create state for azure stateful node enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
