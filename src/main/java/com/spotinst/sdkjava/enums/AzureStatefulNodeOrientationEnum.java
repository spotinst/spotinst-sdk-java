package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeOrientationEnum {
    //region Enum
    AVAILABILITY("availability"),
    CHEAPEST("cheapest"),
    COST("cost");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeOrientationEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeOrientationEnum.class);

    //region methods
    public static AzureStatefulNodeOrientationEnum fromName(String name) {
        AzureStatefulNodeOrientationEnum retVal = null;

        for (AzureStatefulNodeOrientationEnum productEnum : AzureStatefulNodeOrientationEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, productEnum.name)) {
                retVal = productEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create Orientation Enum for: %s, but we don't support such type", name));
        }
        return retVal;
    }
    //endregion

    //region Properties
    public String getName() {
        return name;
    }
    //endregion
}
