package com.spotinst.sdkjava.enums.admin.messageCenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AudienceSpecificationEnum {

    ATTR_PROVIDER_AWS("ATTR_PROVIDER_AWS"),
    ALL("ALL"),
    ORGANIZATION("ORGANIZATION"),
    USER("USER");

    private static final Logger LOGGER = LoggerFactory.getLogger(AudienceSpecificationEnum.class);
    private              String name;

    AudienceSpecificationEnum(String name) {
        this.name = name;
    }

    public static AudienceSpecificationEnum fromName(String name) {
        AudienceSpecificationEnum retVal = null;

        for (AudienceSpecificationEnum policyEffectEnum : AudienceSpecificationEnum.values()) {
            if (name.equalsIgnoreCase(policyEffectEnum.name)) {
                retVal = policyEffectEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create message type enum for: %s, but we don't support such type ",name));
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}