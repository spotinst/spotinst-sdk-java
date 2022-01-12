package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeLifeCycleTypeEnum {
    //region Enum
    SPOT("spot"),
    OD("od");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeLifeCycleTypeEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeLifeCycleTypeEnum.class);

    //region methods
    public static AzureStatefulNodeLifeCycleTypeEnum fromName(String name) {
        AzureStatefulNodeLifeCycleTypeEnum retVal = null;

        for (AzureStatefulNodeLifeCycleTypeEnum productEnum : AzureStatefulNodeLifeCycleTypeEnum.values()) {
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
