package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yossi.elman on 24/05/2020.
 */
public enum ProcessNameEnum {
    //region Enums
    AUTO_SCALE("AUTO_SCALE"),
    AUTO_HEALING("AUTO_HEALING"),
    OUT_OF_STRATEGY("OUT_OF_STRATEGY"),
    PREVENTIVE_REPLACEMENT("PREVENTIVE_REPLACEMENT"),
    REVERT_PREFERRED("REVERT_PREFERRED"),
    SCHEDULING("SCHEDULING"),
    LB_REGISTRATION("LB_REGISTRATION");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessNameEnum.class);
    private String name;
    //endregion

    //region Constructors
    ProcessNameEnum(String name) {
        this.name = name;
    }
    //endregion

    //region Methods
    public static ProcessNameEnum fromName(String name) {
        ProcessNameEnum retVal = null;

        for (ProcessNameEnum processName : ProcessNameEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, processName.name)) {
                retVal = processName;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create process name enum for name : " + name + ", but we don't support such type ");
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
