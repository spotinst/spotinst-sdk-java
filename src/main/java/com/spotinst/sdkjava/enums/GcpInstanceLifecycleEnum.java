package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GcpInstanceLifecycleEnum {

    ONDEMAND("ONDEMAND"),
    PREEMPTIBLE("PREEMPTIBLE");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsInstanceTypeEnum.class);
    private String name;

    private GcpInstanceLifecycleEnum(String name) {
        this.name = name;
    }

    public static GcpInstanceLifecycleEnum fromName(String name) {
        GcpInstanceLifecycleEnum retVal = null;

        for (GcpInstanceLifecycleEnum instanceMarketEnum : GcpInstanceLifecycleEnum.values()) {
            if (name.equalsIgnoreCase(instanceMarketEnum.name)) {
                retVal = instanceMarketEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create instance life cycle enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
