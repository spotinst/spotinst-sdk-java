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

        for (UserTypeEnum userTypeEnum : UserTypeEnum.values()) {
            if (name.equalsIgnoreCase(userTypeEnum.name)) {
                retVal = userTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create user type enum for: %s, but we don't support such type ",name));
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
