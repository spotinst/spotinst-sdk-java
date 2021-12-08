package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeTaskTypeEnum {
    //region Enum
    PAUSE("pause"),
    RESUME("resume"),
    RECYCLE("recycle");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeTaskTypeEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeTaskTypeEnum.class);

    //region methods
    public static AzureStatefulNodeTaskTypeEnum fromName(String name) {
        AzureStatefulNodeTaskTypeEnum retVal = null;

        for (AzureStatefulNodeTaskTypeEnum productEnum : AzureStatefulNodeTaskTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, productEnum.name)) {
                retVal = productEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create task type for: %s, but we don't support such type", name));
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
