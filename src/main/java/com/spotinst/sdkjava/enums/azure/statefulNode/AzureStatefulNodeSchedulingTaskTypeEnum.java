package com.spotinst.sdkjava.enums.azure.statefulNode;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeSchedulingTaskTypeEnum {
    //region Enum
    PAUSE("pause"),
    RESUME("resume"),
    RECYCLE("recycle");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeSchedulingTaskTypeEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeSchedulingTaskTypeEnum.class);

    //region methods
    public static AzureStatefulNodeSchedulingTaskTypeEnum fromName(String name) {
        AzureStatefulNodeSchedulingTaskTypeEnum retVal = null;

        for (AzureStatefulNodeSchedulingTaskTypeEnum enumValue : AzureStatefulNodeSchedulingTaskTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, enumValue.name)) {
                retVal = enumValue;
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
