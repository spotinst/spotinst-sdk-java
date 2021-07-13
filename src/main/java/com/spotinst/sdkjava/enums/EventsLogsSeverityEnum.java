package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
public enum EventsLogsSeverityEnum {
    //region Enums
    ERROR("ERROR"),
    WARN("WARN"),
    INFO("INFO"),
    DEBUG("DEBUG"),
    ALL("ALL");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(EventsLogsSeverityEnum.class);
    private              String name;
    //endregion

    //region Constructors
    EventsLogsSeverityEnum(String name) {
        this.name = name;
    }
    //endregion

    //region Methods
    public static EventsLogsSeverityEnum fromName(String name) {
        EventsLogsSeverityEnum retVal = null;

        for (EventsLogsSeverityEnum eventsLogsSeverity : EventsLogsSeverityEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, eventsLogsSeverity.name)) {
                retVal = eventsLogsSeverity;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create events logs severity enum for name : " + name +
                         ", but we don't support such type ");
        }

        return retVal;
    }
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }
    //endregion
}
