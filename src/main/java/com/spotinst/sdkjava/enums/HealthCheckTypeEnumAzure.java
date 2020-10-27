package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum HealthCheckTypeEnumAzure {
    VM_STATE("vmState"),
    APPLICATION_GATEWAY("applicationGateway");

    private String name;

    HealthCheckTypeEnumAzure(String name) {
        this.name = name;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckTypeEnumAzure.class);

    public static HealthCheckTypeEnumAzure fromName(String name) {
        HealthCheckTypeEnumAzure retVal = null;

        for (HealthCheckTypeEnumAzure instanceStateEnum : HealthCheckTypeEnumAzure.values()) {
            if (StringUtils.equalsIgnoreCase(name, instanceStateEnum.name)) {
                retVal = instanceStateEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.warn(String.format("Tried to create Health Check Type Enum for: %s, but we don't support such type",
                                      name));
        }
        return retVal;
    }

    public String getName() {
        return name;
    }
}
