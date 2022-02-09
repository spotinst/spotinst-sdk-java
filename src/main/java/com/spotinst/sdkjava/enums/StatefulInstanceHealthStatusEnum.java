package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Janetlin Kiruba on 20/01/2022.
 */
public enum StatefulInstanceHealthStatusEnum {

    ACTIVE("ACTIVE"),
    PAUSE("PAUSE"),
    PAUSING("PAUSING"),
    PAUSED("PAUSED"),
    RESUME("RESUME"),
    RESUMING("RESUMING"),
    RECYCLE("RECYCLE"),
    RECYCLING("RECYCLING"),
    DEALLOCATE("DEALLOCATE"),
    DEALLOCATING("DEALLOCATING"),
    DEALLOCATED("DEALLOCATED"),
    ERROR("ERROR");

    private StatefulInstanceHealthStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final        String name;
    private static final Logger LOGGER = LoggerFactory.getLogger(StatefulInstanceHealthStatusEnum.class);

    public static StatefulInstanceHealthStatusEnum fromName(String name)
    {
        StatefulInstanceHealthStatusEnum retVal = null;
        for (StatefulInstanceHealthStatusEnum type : StatefulInstanceHealthStatusEnum.values()) {
            if (name.equalsIgnoreCase(type.name))
            {
                retVal = type;
                break;
            }
        }

        if (retVal == null)
        {
            LOGGER.error("Tried to create instance health status enum for: " + name + ", but we don't support such type ");
        }
        return retVal;
    }
}
