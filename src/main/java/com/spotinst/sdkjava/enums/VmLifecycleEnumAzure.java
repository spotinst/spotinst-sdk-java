package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum VmLifecycleEnumAzure {

    SPOT("SPOT"),
    OD("ON_DEMAND");

    private static final Logger LOGGER = LoggerFactory.getLogger(VmLifecycleEnumAzure.class);
    private String name;

    private VmLifecycleEnumAzure(String name) {
        this.name = name;
    }

    public static VmLifecycleEnumAzure fromName(String name) {
        VmLifecycleEnumAzure retVal = null;

        for (VmLifecycleEnumAzure vmLifecycleEnum : VmLifecycleEnumAzure.values()) {
            if (name.equalsIgnoreCase(vmLifecycleEnum.name)) {
                retVal = vmLifecycleEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create 'lifecycle' enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
