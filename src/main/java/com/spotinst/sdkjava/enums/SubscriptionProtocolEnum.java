package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/30/15.
 */
public enum SubscriptionProtocolEnum {

    HTTP("http"),
    HTTPS("https"),
    EMAIL_JSON("email-json"),
    EMAIL("email"),
    AWS_SNS("aws-sns");

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionProtocolEnum.class);
    private final String name;

    SubscriptionProtocolEnum(String name) {
        this.name = name;
    }

    public static SubscriptionProtocolEnum fromName(String name) {
        SubscriptionProtocolEnum retVal = null;
        for (SubscriptionProtocolEnum availabilityTypeEnum : SubscriptionProtocolEnum.values()) {
            if (name.equals(availabilityTypeEnum.name)) {
                retVal = availabilityTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create group subscription event protocol enum for: " + name + ", but we don't support such type ");
        }
        return retVal;
    }

    public String getName() {
        return name;
    }
}
