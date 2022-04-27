package com.spotinst.sdkjava.enums.azure.statefulNode;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeDiskPersistenceModeEnum {
    //region Enum
    REATTACH("reattach"),
    ONLAUNCH("onLaunch");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeDiskPersistenceModeEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeDiskPersistenceModeEnum.class);

    //region methods
    public static AzureStatefulNodeDiskPersistenceModeEnum fromName(String name) {
        AzureStatefulNodeDiskPersistenceModeEnum retVal = null;

        for (AzureStatefulNodeDiskPersistenceModeEnum productEnum : AzureStatefulNodeDiskPersistenceModeEnum.values()) {
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
