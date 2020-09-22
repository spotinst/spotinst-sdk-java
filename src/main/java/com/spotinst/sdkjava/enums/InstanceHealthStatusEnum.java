package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ohadmuchnik on 12/04/2016.
 */
public enum InstanceHealthStatusEnum {

    HEALTHY("HEALTHY"),
    UNHEALTHY("UNHEALTHY"),
    INSUFFICIENT_DATA("INSUFFICIENT_DATA"),
    UNKNOWN("UNKNOWN");

    private InstanceHealthStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final        String name;
    private static final Logger LOGGER = LoggerFactory.getLogger(InstanceHealthStatusEnum.class);

    public static InstanceHealthStatusEnum fromName(String name)
    {
        InstanceHealthStatusEnum retVal = null;
        for (InstanceHealthStatusEnum type : InstanceHealthStatusEnum.values()) {
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
