package com.spotinst.sdkjava.enums.admin.messageCenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum MessageTypeEnum {

    NOTIFICATION_POLICY("NOTIFICATION_POLICY"),
    GENERAL("GENERAL"),
    ANNOUNCEMENT("ANNOUNCEMENT");

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageTypeEnum.class);
    private              String name;

    MessageTypeEnum(String name) {
        this.name = name;
    }

    public static MessageTypeEnum fromName(String name) {
        MessageTypeEnum retVal = null;

        for (MessageTypeEnum policyEffectEnum : MessageTypeEnum.values()) {
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