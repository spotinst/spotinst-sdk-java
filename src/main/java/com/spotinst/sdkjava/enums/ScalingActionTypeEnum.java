package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ScalingActionTypeEnum {

    ADJUSTMENT_NUMERIC("adjustment"),
    SET_MIN_TARGET("setMinTarget"),
    SET_MAX_TARGET("setMaxTarget"),
    UPDATE_CAPACITY("updateCapacity"),
    PERCENTAGE_ADJUSTMENT("percentageAdjustment");

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(ScalingActionTypeEnum.class);
    private              String name;
    //endregion

    //region Constructors

    ScalingActionTypeEnum(String name) {
        this.name = name;
    }

    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    //endregion

    //region Methods
    public static ScalingActionTypeEnum fromName(String name) {
        ScalingActionTypeEnum retVal = null;

        for (ScalingActionTypeEnum typeEnum : ScalingActionTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(typeEnum.name, name)) {
                retVal = typeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(
                    String.format("Tried to create scaling action type enum from: %s, but we don't support such type",
                                  name));
        }

        return retVal;
    }
    //endregion
}