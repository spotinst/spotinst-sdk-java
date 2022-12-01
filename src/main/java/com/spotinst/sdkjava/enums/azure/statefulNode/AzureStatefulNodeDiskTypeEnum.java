package com.spotinst.sdkjava.enums.azure.statefulNode;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AzureStatefulNodeDiskTypeEnum {

    Standard_LRS("Standard_LRS"),
    StandardSSD_LRS("StandardSSD_LRS"),
    Premium_LRS("Premium_LRS"),
    UltraSSD_LRS("UltraSSD_LRS");
    //endregion

    //region Members
    private String name;
    //endregion

    //region Constructor
    AzureStatefulNodeDiskTypeEnum(String name) {
        this.name = name;
    }
    //endregion

    private static final Logger LOGGER = LoggerFactory.getLogger(AzureStatefulNodeDiskTypeEnum.class);

    //region methods
    public static AzureStatefulNodeDiskTypeEnum fromName(String name) {
        AzureStatefulNodeDiskTypeEnum retVal = null;

        for (AzureStatefulNodeDiskTypeEnum enumValue : AzureStatefulNodeDiskTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, enumValue.name)) {
                retVal = enumValue;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create disk type Enum for: %s, but we don't support such type", name));
        }
        return retVal;
    }
    //endregion

    //region Properties
    public String getName() {
        return name;
    }
}
