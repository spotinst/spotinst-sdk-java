package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ElastigroupSeverityEnumAzure {

    DEBUG("DEBUG"),
    WARN("WARN"),
    INFO("INFO"),
    ALL("ALL"),
    ERROR("ERROR");

    private static final Logger LOGGER = LoggerFactory.getLogger(ElastigroupSeverityEnumAzure.class);
    private String name;

    private ElastigroupSeverityEnumAzure(String name) {
        this.name = name;
    }

    public static ElastigroupSeverityEnumAzure fromName(String name) {
        ElastigroupSeverityEnumAzure retVal = null;

        for (ElastigroupSeverityEnumAzure elastigroupStatusEnum : ElastigroupSeverityEnumAzure.values()) {
            if (name.equalsIgnoreCase(elastigroupStatusEnum.name)) {
                retVal = elastigroupStatusEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create 'severity' enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
