package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsCpuCreditsEnum {

    UNLIMITED("unlimited"),
    STANDARD("standard");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsCpuCreditsEnum.class);
    private String name;

    AwsCpuCreditsEnum(String name) {
        this.name = name;
    }

    public static AwsCpuCreditsEnum fromName(String name) {
        AwsCpuCreditsEnum retVal = null;

        for (AwsCpuCreditsEnum credit : AwsCpuCreditsEnum.values()) {
            if (name.equalsIgnoreCase(credit.name)) {
                retVal = credit;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create cpuCredits enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
