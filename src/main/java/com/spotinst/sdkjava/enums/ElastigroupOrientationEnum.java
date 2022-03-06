package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/30/15.
 */
public enum ElastigroupOrientationEnum {

    COST_ORIENTED("costOriented"),
    AVAILABILITY_ORIENTED("availabilityOriented"),
    BALANCED("balanced");

    private static final Logger LOGGER = LoggerFactory.getLogger(ElastigroupOrientationEnum.class);
    private final String name;

    private ElastigroupOrientationEnum(String name) {
        this.name = name;
    }

    public static ElastigroupOrientationEnum fromName(String name) {
        ElastigroupOrientationEnum retVal = null;
        for (ElastigroupOrientationEnum availabilityTypeEnum : ElastigroupOrientationEnum.values()) {
            if (name.equals(availabilityTypeEnum.name)) {
                retVal = availabilityTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create group availability vs cost enum for: " + name + ", but we don't support such type ");
        }
        return retVal;
    }

    public String getName() {
        return name;
    }
}
