package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum UnitEnum {

    //region Enum
    PERCENTAGE("percentage"),
    PERCENT("percent");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    UnitEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitEnum.class);

    //region methods
    public static UnitEnum fromName(String name) {
        UnitEnum retVal = null;

        for (UnitEnum productEnum : UnitEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, productEnum.name)) {
                retVal = productEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.warn(String.format("Tried to create unit Enum for: %s, but we don't support such type", name));
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
