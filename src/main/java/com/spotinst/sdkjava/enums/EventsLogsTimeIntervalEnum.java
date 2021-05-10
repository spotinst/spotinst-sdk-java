package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
//todo daniel : delete not in use
public enum EventsLogsTimeIntervalEnum {


    ONE_DAY_INTERVAL("1d", 1),
    TWO_DAYS_INTERVAL("2d", 2),
    THREE_DAYS_INTERVAL("3d", 3),
    ONE_WEEK_INTERVAL("1w", 7),
    TWO_WEEKS_INTERVAL("2w", 14),
    ONE_MONTH_INTERVAL("1m", 1),
    TWO_MONTHS_INTERVAL("2m", 2),
    THREE_MONTHS_INTERVAL("3m", 3);

    private EventsLogsTimeIntervalEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EventsLogsTimeIntervalEnum.class);

    private String  name;
    private Integer value;

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public static EventsLogsTimeIntervalEnum fromName(String name) {
        EventsLogsTimeIntervalEnum retVal = null;
        for (EventsLogsTimeIntervalEnum timeIntervalEnum : EventsLogsTimeIntervalEnum.values()) {
            if (timeIntervalEnum.name.equals(name)) {
                retVal = timeIntervalEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create events logs time interval enum from name : " + name +
                         ", but we don't support such type ");
        }

        return retVal;
    }
}


