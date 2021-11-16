package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum VmHealthStatusEnumAzure {

    HEALTHY("HEALTHY"),
    UNHEALTHY("UNHEALTHY"),
    UNKNOWN("UNKNOWN");

    private static final Logger LOGGER = LoggerFactory.getLogger(VmHealthStatusEnumAzure.class);
    private String name;

    private VmHealthStatusEnumAzure(String name) {
        this.name = name;
    }

    public static VmHealthStatusEnumAzure fromName(String name) {
        VmHealthStatusEnumAzure retVal = null;

        for (VmHealthStatusEnumAzure vmHealthStatusEnum : VmHealthStatusEnumAzure.values()) {
            if (name.equalsIgnoreCase(vmHealthStatusEnum.name)) {
                retVal = vmHealthStatusEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create 'healthiness' enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
