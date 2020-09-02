package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum RecurrenceFrequencyEnumAzure {

    HOURLY("hourly"),
    DAILY("daily"),
    WEEKLY("weekly"),
    CONTINUOUS("continuous");

    private RecurrenceFrequencyEnumAzure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final        String name;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(RecurrenceFrequencyEnumAzure.class);

    public static RecurrenceFrequencyEnumAzure fromName(String name)
    {
        RecurrenceFrequencyEnumAzure retVal = null;
        for (RecurrenceFrequencyEnumAzure frequencyEnum : RecurrenceFrequencyEnumAzure.values()) {
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
