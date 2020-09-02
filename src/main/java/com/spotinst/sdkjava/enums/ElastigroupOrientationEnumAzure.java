package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/30/15.
 */
public enum ElastigroupOrientationEnumAzure {

    COST_ORIENTED("costOriented"),
    AVAILABILITY_ORIENTED("availabilityOriented"),
    BALANCED("balanced");

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ElastigroupOrientationEnumAzure.class);
    private final String name;

    private ElastigroupOrientationEnumAzure(String name) {
        this.name = name;
    }

    public static ElastigroupOrientationEnumAzure fromName(String name) {
        ElastigroupOrientationEnumAzure retVal = null;
        for (ElastigroupOrientationEnumAzure availabilityTypeEnum : ElastigroupOrientationEnumAzure.values()) {
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
