package com.spotinst.sdkjava.enums.admin.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum UserTypeEnum {

    personal("personal"),
    programmatic("programmatic");

    private static final Logger LOGGER = LoggerFactory.getLogger(UserTypeEnum.class);
    private              String name;

    private UserTypeEnum(String name) {
        this.name = name;
    }

    public static UserTypeEnum fromName(String name) {
        UserTypeEnum retVal = null;

        for (UserTypeEnum policyTypeEnum : UserTypeEnum.values()) {
            if (name.equalsIgnoreCase(policyTypeEnum.name)) {
                retVal = policyTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create user type enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
