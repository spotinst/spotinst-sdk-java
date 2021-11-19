package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsElastigroupActionEnum {
    //region Enums
    REPLACE_SERVER("replace-server"),
    RESTART_SERVER("restart-server");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(AwsElastigroupActionEnum.class);
    private              String name;
    //endregion

    //region Constructors

    AwsElastigroupActionEnum(String name) {
        this.name = name;
    }

    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    //endregion

    //region Methods
    public static AwsElastigroupActionEnum fromName(String name) {
        AwsElastigroupActionEnum retVal = null;

        for (AwsElastigroupActionEnum typeEnum : AwsElastigroupActionEnum.values()) {
            if (StringUtils.equalsIgnoreCase(typeEnum.name, name)) {
                retVal = typeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create Root volume type enum from: %s, but we don't support such type",
                                       name));
        }

        return retVal;
    }
    //endregion
}
