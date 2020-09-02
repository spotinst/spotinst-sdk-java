package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum MaintenanceWindowTypeEnumAzure {
    //region Enums
    ALWAYS("always"),
    NEVER("never"),
    TIME_WINDOW("timeWindow");
    //endregion
    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(MaintenanceWindowTypeEnumAzure.class);
    private              String name;
    //endregion

    //region Constructors
    MaintenanceWindowTypeEnumAzure(String name) {
        this.name = name;
    }
    //endregion

    //region Methods
    public static MaintenanceWindowTypeEnumAzure fromName(String name) {
        MaintenanceWindowTypeEnumAzure retVal = null;

        for (MaintenanceWindowTypeEnumAzure typeEnum : MaintenanceWindowTypeEnumAzure.values()) {
            if (StringUtils.equalsIgnoreCase(name, typeEnum.name)) {
                retVal = typeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(
                    String.format("Tried to create Revert To Spot Enum from name: %s, but we don't support such type",
                                  name));
        }

        return retVal;
    }
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }
    //endregion

}
