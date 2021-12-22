package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureDiskModeEnum {
    //region Enum
    REATTACH("reattach"),
    ONLAUNCH("onLaunch");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureDiskModeEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureDiskModeEnum.class);

    //region methods
    public static AzureDiskModeEnum fromName(String name) {
        AzureDiskModeEnum retVal = null;

        for (AzureDiskModeEnum productEnum : AzureDiskModeEnum.values()) {
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
