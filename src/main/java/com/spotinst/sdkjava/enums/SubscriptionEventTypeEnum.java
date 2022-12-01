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
    AWS_EC2_INSTANCE_READY_SIGNAL_TIMEOUT("AWS_EC2_INSTANCE_READY_SIGNAL_TIMEOUT"),
    SIGNAL_TIMEOUT_SHUTDOWN_SCRIPT("SIGNAL_TIMEOUT_SHUTDOWN_SCRIPT"),
    AWS_EC2_CANT_SPIN_OD("AWS_EC2_CANT_SPIN_OD"),
    AWS_EC2_INSTANCE_UNHEALTHY_IN_ELB("AWS_EC2_INSTANCE_UNHEALTHY_IN_ELB"),
    GROUP_ROLL_FAILED("GROUP_ROLL_FAILED"),
    GROUP_ROLL_FINISHED("GROUP_ROLL_FINISHED"),
    CANT_SCALE_UP_GROUP_MAX_CAPACITY("CANT_SCALE_UP_GROUP_MAX_CAPACITY"),
    GROUP_UPDATED("GROUP_UPDATED"),
    AWS_EMR_PROVISION_TIMEOUT("AWS_EMR_PROVISION_TIMEOUT"),
    GROUP_BEANSTALK_INIT_READY("GROUP_BEANSTALK_INIT_READY"),
    AZURE_VM_TERMINATED("AZURE_VM_TERMINATED"),
    AZURE_VM_TERMINATE("AZURE_VM_TERMINATE"),
    AWS_EC2_MANAGED_INSTANCE_PAUSING("AWS_EC2_MANAGED_INSTANCE_PAUSING"),
    AWS_EC2_MANAGED_INSTANCE_RESUMING("AWS_EC2_MANAGED_INSTANCE_RESUMING"),
    AWS_EC2_MANAGED_INSTANCE_RECYCLING("AWS_EC2_MANAGED_INSTANCE_RECYCLING"),
    AWS_EC2_MANAGED_INSTANCE_DELETING("AWS_EC2_MANAGED_INSTANCE_DELETING");

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
