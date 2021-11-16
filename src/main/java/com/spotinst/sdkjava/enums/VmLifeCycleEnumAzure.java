package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum VmLifeCycleEnumAzure {

    SPOT("SPOT"),
    OD("ON_DEMAND");

    private static final Logger LOGGER = LoggerFactory.getLogger(VmLifeCycleEnumAzure.class);
    private String name;

    private VmLifeCycleEnumAzure(String name) {
        this.name = name;
    }

    public static VmLifeCycleEnumAzure fromName(String name) {
        VmLifeCycleEnumAzure retVal = null;

        for (VmLifeCycleEnumAzure vmLifecycleEnum : VmLifeCycleEnumAzure.values()) {
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
