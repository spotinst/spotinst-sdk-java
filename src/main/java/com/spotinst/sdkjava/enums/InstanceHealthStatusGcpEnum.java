package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ohadmuchnik on 12/04/2016.
 */
public enum InstanceHealthStatusGcpEnum {

    SUSPENDED("SUSPENDED"),
    TERMINATED("TERMINATED"),
    PROVISIONING("PROVISIONING"),
    NEW("NEW"),
    RUNNING("RUNNING");

    private InstanceHealthStatusGcpEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final        String name;
    private static final Logger LOGGER = LoggerFactory.getLogger(InstanceHealthStatusGcpEnum.class);

    public static InstanceHealthStatusGcpEnum fromName(String name)
    {
        InstanceHealthStatusGcpEnum retVal = null;
        for (InstanceHealthStatusGcpEnum type : InstanceHealthStatusGcpEnum.values()) {
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
