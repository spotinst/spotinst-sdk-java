package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsSignalNameEnum {

    INSTANCE_READY("INSTANCE_READY"),
    INSTANCE_READY_TO_SHUTDOWN("INSTANCE_READY_TO_SHUTDOWN");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsSignalNameEnum.class);
    private String name;

    AwsSignalNameEnum(String name) {
        this.name = name;
    }

    public static AwsSignalNameEnum fromName(String name) {
        AwsSignalNameEnum retVal = null;

        for (AwsSignalNameEnum signalNameEnum : AwsSignalNameEnum.values()) {
            if (name.equalsIgnoreCase(signalNameEnum.name)) {
                retVal = signalNameEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create signal name enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
