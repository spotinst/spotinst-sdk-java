package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsECSRegistrationStatusEnum {

    REGISTERED("Registered"),
    RESGISTERING("Registering"),
    FAILED("Failed");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsECSRegistrationStatusEnum.class);
    private String name;

    AwsECSRegistrationStatusEnum(String name) {
        this.name = name;
    }

    public static AwsECSRegistrationStatusEnum fromName(String name) {
        AwsECSRegistrationStatusEnum retVal = null;
        for (AwsECSRegistrationStatusEnum awsECSRegistrationStatusEnum : AwsECSRegistrationStatusEnum.values()) {
            if (name.equals(awsECSRegistrationStatusEnum.name)) {
                retVal = awsECSRegistrationStatusEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create registration status enum for AWS ECS Name : " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
