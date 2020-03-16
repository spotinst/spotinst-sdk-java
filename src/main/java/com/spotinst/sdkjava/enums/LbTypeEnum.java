package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yossi.elman on 12/03/20.
 */
public enum LbTypeEnum {
    //region Enums
    CLASSIC("CLASSIC"),
    TARGET_GROUP("TARGET_GROUP");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(LbTypeEnum.class);
    private              String name;
    //endregion

    //region Constructors

    LbTypeEnum(String name) {
        this.name = name;
    }

    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    //endregion

    //region Methods
    public static LbTypeEnum fromName(String name) {
        LbTypeEnum retVal = null;

        for (LbTypeEnum typeEnum : LbTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(typeEnum.name, name)) {
                retVal = typeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create lb type enum from: %s, but we don't support such type",
                                       name));
        }

        return retVal;
    }
    //endregion
}
