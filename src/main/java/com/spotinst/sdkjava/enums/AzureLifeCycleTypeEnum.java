package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureLifeCycleTypeEnum {
    //region Enum
    SPOT("spot"),
    OD("od");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureLifeCycleTypeEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureLifeCycleTypeEnum.class);

    //region methods
    public static AzureLifeCycleTypeEnum fromName(String name) {
        AzureLifeCycleTypeEnum retVal = null;

        for (AzureLifeCycleTypeEnum productEnum : AzureLifeCycleTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, productEnum.name)) {
                retVal = productEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create azure lifecycle Enum for: %s, but we don't support such type", name));
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
