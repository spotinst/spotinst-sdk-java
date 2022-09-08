package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/25/15.
 */
public enum AwsInstanceMarketEnum {

    //region Enums
    SPOT("SPOT"),
    ON_DEMAND("ON-DEMAND");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(AwsInstanceTypeEnum.class);
    private String name;
    //endregion

    //region Constructors
    AwsInstanceMarketEnum(String name) {
        this.name = name;
    }
    //endregion

    //region Methods
    public static AwsInstanceMarketEnum fromName(String name) {
        AwsInstanceMarketEnum retVal = null;

        for (AwsInstanceMarketEnum instanceMarketEnum : AwsInstanceMarketEnum.values()) {
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
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }
    //endregion
}
