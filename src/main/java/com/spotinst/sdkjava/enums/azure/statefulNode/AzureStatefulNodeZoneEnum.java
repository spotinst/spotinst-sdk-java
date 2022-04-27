package com.spotinst.sdkjava.enums.azure.statefulNode;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeZoneEnum {

    ONE("1"),
    TWO("2"),
    THREE("3");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeZoneEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeZoneEnum.class);

    //region methods
    public static AzureStatefulNodeZoneEnum fromName(String name) {
        AzureStatefulNodeZoneEnum retVal = null;

        for (AzureStatefulNodeZoneEnum enumValue : AzureStatefulNodeZoneEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, enumValue.name)) {
                retVal = enumValue;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create disk type Enum for: %s, but we don't support such type", name));
        }
        return retVal;
    }
    //endregion

    //region Properties
    public String getName() {
        return name;
    }
}
