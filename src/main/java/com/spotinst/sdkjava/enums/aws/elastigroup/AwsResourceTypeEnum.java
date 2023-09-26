package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsResourceTypeEnum {

    CPU("CPU"),
    memory("memory");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsResourceTypeEnum.class);
    private String name;

    AwsResourceTypeEnum(String name) {
        this.name = name;
    }

    public static AwsResourceTypeEnum fromName(String name) {
        AwsResourceTypeEnum retVal = null;

        for (AwsResourceTypeEnum signalNameEnum : AwsResourceTypeEnum.values()) {
            if (name.equalsIgnoreCase(signalNameEnum.name)) {
                retVal = signalNameEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create awsResourceTypeEnum name enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
