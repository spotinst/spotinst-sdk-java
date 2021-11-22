package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsElastigroupActionTypeEnum {

    //region Enums
    DETACH_OLD("detach-old"),
    DETACH_NEW("detach-new");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(AwsElastigroupActionTypeEnum.class);
    private              String name;
    //endregion

    //region Constructors

    AwsElastigroupActionTypeEnum(String name) {
        this.name = name;
    }

    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    //endregion

    //region Methods
    public static AwsElastigroupActionTypeEnum fromName(String name) {
        AwsElastigroupActionTypeEnum retVal = null;

        for (AwsElastigroupActionTypeEnum typeEnum : AwsElastigroupActionTypeEnum.values()) {
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
