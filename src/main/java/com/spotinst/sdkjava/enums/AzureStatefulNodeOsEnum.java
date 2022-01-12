package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeOsEnum {
    //region Enum
    LINUX("Linux"),
    WINDOWS("Windows");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeOsEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeOsEnum.class);

    //region methods
    public static AzureStatefulNodeOsEnum fromName(String name) {
        AzureStatefulNodeOsEnum retVal = null;

        for (AzureStatefulNodeOsEnum productEnum : AzureStatefulNodeOsEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, productEnum.name)) {
                retVal = productEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create os Enum for: %s, but we don't support such type", name));
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
