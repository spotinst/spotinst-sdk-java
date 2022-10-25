package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/30/15.
 */
public enum SubscriptionEventTypeEnum {

    AWS_EC2_INSTANCE_TERMINATE("AWS_EC2_INSTANCE_TERMINATE"),
    AWS_EC2_INSTANCE_TERMINATED("AWS_EC2_INSTANCE_TERMINATED"),
    AWS_EC2_INSTANCE_LAUNCH("AWS_EC2_INSTANCE_LAUNCH"),
    AWS_EC2_INSTANCE_UNHEALTHY_IN_ELB("AWS_EC2_INSTANCE_UNHEALTHY_IN_ELB"),
    GROUP_ROLL_FAILED("GROUP_ROLL_FAILED"),
    GROUP_ROLL_FINISHED("GROUP_ROLL_FINISHED");

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionEventTypeEnum.class);
    private final String name;

    SubscriptionEventTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static SubscriptionEventTypeEnum fromName(String name) {
        SubscriptionEventTypeEnum retVal = null;
        for (SubscriptionEventTypeEnum availabilityTypeEnum : SubscriptionEventTypeEnum.values()) {
            if (name.equals(availabilityTypeEnum.name)) {
                retVal = availabilityTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create group subscription event type enum for: " + name + ", but we don't support such type ");
        }
        return retVal;
    }
}
