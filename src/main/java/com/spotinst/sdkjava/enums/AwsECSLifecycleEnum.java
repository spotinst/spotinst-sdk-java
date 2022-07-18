package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsECSLifecycleEnum {

    SPOT("Spot"),
    OD("OD"),
    OD_RI("OD (RI)");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsECSLifecycleEnum.class);
    private String name;

    AwsECSLifecycleEnum(String name) {
        this.name = name;
    }

    public static AwsECSLifecycleEnum fromName(String name) {
        AwsECSLifecycleEnum retVal = null;
        for (AwsECSLifecycleEnum awsECSLifecycleEnum : AwsECSLifecycleEnum.values()) {
            if (name.equals(awsECSLifecycleEnum.name)) {
                retVal = awsECSLifecycleEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create Lifecycle enum for AWS ECS Name : " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
