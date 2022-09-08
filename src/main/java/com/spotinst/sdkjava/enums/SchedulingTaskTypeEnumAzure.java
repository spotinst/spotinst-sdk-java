package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SchedulingTaskTypeEnumAzure {
    BACKUP_AMI("backup_ami"),
    SCALE("scale"),
    ROLL("roll"),
    SCALE_UP("scaleUp"),
    PERCENTAGE_SCALE_UP("percentageScaleUp"),
    SCALE_DOWN("scaleDown"),
    PERCENTAGE_SCALE_DOWN("percentageScaleDown"),
    STATEFUL_UPDATE_CAPACITY("statefulUpdateCapacity"),
    STATEFUL_RECYCLE("statefulRecycle");

    SchedulingTaskTypeEnumAzure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final String name;
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulingTaskTypeEnumAzure.class);

    public static SchedulingTaskTypeEnumAzure fromName(String name) {
        SchedulingTaskTypeEnumAzure retVal = null;
        for (SchedulingTaskTypeEnumAzure schedulingTaskTypeEnum : SchedulingTaskTypeEnumAzure.values()) {
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
