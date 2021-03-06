package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SchedulingTaskTypeEnum {
    BACKUP_AMI("backup_ami"),
    SCALE("scale"),
    ROLL("roll"),
    SCALE_UP("scaleUp"),
    PERCENTAGE_SCALE_UP("percentageScaleUp"),
    SCALE_DOWN("scaleDown"),
    PERCENTAGE_SCALE_DOWN("percentageScaleDown"),
    STATEFUL_UPDATE_CAPACITY("statefulUpdateCapacity"),
    STATEFUL_RECYCLE("statefulRecycle");

    private SchedulingTaskTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final String name;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SchedulingTaskTypeEnum.class);

    public static SchedulingTaskTypeEnum fromName(String name) {
        SchedulingTaskTypeEnum retVal = null;
        for (SchedulingTaskTypeEnum schedulingTaskTypeEnum : SchedulingTaskTypeEnum.values()) {
            if (name.equals(schedulingTaskTypeEnum.name)) {
                retVal = schedulingTaskTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create group scheduling task type enum for: " + name +
                         ", but we don't support such type ");
        }
        return retVal;
    }
}
