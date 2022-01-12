package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeDiskModeEnum {
    //region Enum
    REATTACH("reattach"),
    ONLAUNCH("onLaunch");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeDiskModeEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeDiskModeEnum.class);

    //region methods
    public static AzureStatefulNodeDiskModeEnum fromName(String name) {
        AzureStatefulNodeDiskModeEnum retVal = null;

        for (AzureStatefulNodeDiskModeEnum productEnum : AzureStatefulNodeDiskModeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, productEnum.name)) {
                retVal = productEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create disk mode Enum for: %s, but we don't support such type", name));
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
