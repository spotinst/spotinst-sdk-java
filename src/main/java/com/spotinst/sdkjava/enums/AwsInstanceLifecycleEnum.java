package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/25/15.
 */
public enum AwsInstanceLifecycleEnum {

    SPOT("SPOT"),
    ON_DEMAND("ON-DEMAND");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsInstanceTypeEnum.class);
    private String name;

    private AwsInstanceLifecycleEnum(String name) {
        this.name = name;
    }

    public static AwsInstanceLifecycleEnum fromName(String name) {
        AwsInstanceLifecycleEnum retVal = null;
        for (AwsInstanceLifecycleEnum instanceMarketEnum : AwsInstanceLifecycleEnum.values()) {
            if (name.equals(instanceMarketEnum.name)) {
                retVal = instanceMarketEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create instance market type enum for: " + name + ", but we don't support such type ");
        }
        return retVal;
    }

    public String getName() {
        return name;
    }
}
