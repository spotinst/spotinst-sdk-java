package com.spotinst.sdkjava.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AscDescEnum {
    DESC("DESC"),
    ASC("ASC");

    private static final Logger LOGGER = LoggerFactory.getLogger(AscDescEnum.class);
    private              String name;

    AscDescEnum(String name) {
        this.name = name;
    }

    public static AscDescEnum fromName(String name) {
        AscDescEnum retVal = null;

        for (AscDescEnum agentTypeEnum : AscDescEnum.values()) {
            if (name.equals(agentTypeEnum.name)) {
                retVal = agentTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create desc/asc enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }

}
