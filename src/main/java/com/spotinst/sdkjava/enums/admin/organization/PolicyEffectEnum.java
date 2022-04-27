package com.spotinst.sdkjava.enums.admin.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PolicyEffectEnum {

    ALLOW("ALLOW"),
    DENY("DENY");

    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyEffectEnum.class);
    private              String name;

    private PolicyEffectEnum(String name) {
        this.name = name;
    }

    public static PolicyEffectEnum fromName(String name) {
        PolicyEffectEnum retVal = null;

        for (PolicyEffectEnum policyEffectEnum : PolicyEffectEnum.values()) {
            if (name.equalsIgnoreCase(policyEffectEnum.name)) {
                retVal = policyEffectEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create policy effect enum for: %s, but we don't support such type ",name));
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}