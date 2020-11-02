package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureUnitEnum {
    //region Enum
    PERCENTAGE("percentage");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureUnitEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureUnitEnum.class);

    //region methods
    public static AzureUnitEnum fromName(String name) {
        AzureUnitEnum retVal = null;

        for (AzureUnitEnum productEnum : AzureUnitEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, productEnum.name)) {
                retVal = productEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create unit Enum for: %s, but we don't support such type", name));
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
