package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public enum InstanceHealthStatusGcpEnum {
    // todo or: "change value to lower case -> STOPPING("stopping") - DONE
    stopping("stopping"),
    terminated("terminated"),
    provisioning("provisioning"),
    staging("staging"),
    running("running");

    private InstanceHealthStatusGcpEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final        String name;
    private static final Logger LOGGER = LoggerFactory.getLogger(InstanceHealthStatusGcpEnum.class);

    public static InstanceHealthStatusGcpEnum fromName(String name) {
        InstanceHealthStatusGcpEnum retVal = null;

        for (InstanceHealthStatusGcpEnum type : InstanceHealthStatusGcpEnum.values()) {
            if (name.equalsIgnoreCase(type.name)) {
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
