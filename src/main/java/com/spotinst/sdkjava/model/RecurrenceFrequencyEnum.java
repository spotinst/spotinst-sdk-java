package com.spotinst.sdkjava.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum RecurrenceFrequencyEnum {

    HOURLY("hourly"),
    DAILY("daily"),
    WEEKLY("weekly"),
    CONTINUOUS("continuous");

    private RecurrenceFrequencyEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final        String name;
    private static final Logger LOGGER = LoggerFactory.getLogger(RecurrenceFrequencyEnum.class);

    public static RecurrenceFrequencyEnum fromName(String name)
    {
        RecurrenceFrequencyEnum retVal = null;
        for (RecurrenceFrequencyEnum frequencyEnum : RecurrenceFrequencyEnum.values()) {
            if (name.equals(frequencyEnum.name))
            {
                retVal = frequencyEnum;
                break;
            }
        }

        if (retVal == null)
        {
            LOGGER.error("Tried to create recurrence frequency enum for: " + name + ", but we don't support such frequency ");
        }
        return retVal;
    }
}
