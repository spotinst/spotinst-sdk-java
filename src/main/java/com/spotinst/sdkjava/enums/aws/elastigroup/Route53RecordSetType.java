package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Route53RecordSetType {

    A("a"),
    CNAME("cname");

    private static final Logger LOGGER = LoggerFactory.getLogger(Route53RecordSetType.class);
    private String name;

    Route53RecordSetType(String name) {
        this.name = name;
    }

    public static Route53RecordSetType fromName(String name) {
        Route53RecordSetType retVal = null;

        for (Route53RecordSetType signalNameEnum : Route53RecordSetType.values()) {
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
