package com.spotinst.sdkjava.enums.admin.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PolicyTypeEnum {

    ACCOUNT("ACCOUNT"),
    ORGANIZATION("ORGANIZATION"),
    SPOT_MANAGED_ACCOUNT("SPOT_MANAGED_ACCOUNT"),
    SPOT_MANAGED_ORGANIZATION("SPOT_MANAGED_ORGANIZATION");

    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyTypeEnum.class);
    private              String name;

    private PolicyTypeEnum(String name) {
        this.name = name;
    }

    public static PolicyTypeEnum fromName(String name) {
        PolicyTypeEnum retVal = null;

        for (PolicyTypeEnum policyTypeEnum : PolicyTypeEnum.values()) {
            if (name.equalsIgnoreCase(policyTypeEnum.name)) {
                retVal = policyTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create policy type enum for: %s, but we don't support such type ",name));
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
