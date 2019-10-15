package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

///todo change the enum! tp a correct one
public enum EmrSchedulingTaskTypeEnum {
    SET_CAPACITY("setCapacity");

    //region Members
    private final        String name;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EmrSchedulingTaskTypeEnum.class);
    //endregion

    //region Constructor
    EmrSchedulingTaskTypeEnum(String name) {
        this.name = name;
    }
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }
    //endregion

    //region fromName
    public static EmrSchedulingTaskTypeEnum fromName(String name) {
        EmrSchedulingTaskTypeEnum retVal = null;

        for (EmrSchedulingTaskTypeEnum schedulingTaskTypeEnum : EmrSchedulingTaskTypeEnum.values()) {
            if (name.equals(schedulingTaskTypeEnum.name)) {
                retVal = schedulingTaskTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create mrScaler scheduling task type enum for: " + name +
                         ", but we don't support such type ");
        }

        return retVal;
    }
    //endregion
}
