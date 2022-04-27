package com.spotinst.sdkjava.enums.azure.statefulNode;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodePreferredLifeCycleEnum {
    //region Enum
    SPOT("spot"),
    OD("od");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodePreferredLifeCycleEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodePreferredLifeCycleEnum.class);

    //region methods
    public static AzureStatefulNodePreferredLifeCycleEnum fromName(String name) {
        AzureStatefulNodePreferredLifeCycleEnum retVal = null;

        for (AzureStatefulNodePreferredLifeCycleEnum enumValue : AzureStatefulNodePreferredLifeCycleEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, enumValue.name)) {
                retVal = enumValue;
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
