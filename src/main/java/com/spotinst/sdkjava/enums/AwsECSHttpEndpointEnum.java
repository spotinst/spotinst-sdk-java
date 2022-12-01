package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsECSHttpEndpointEnum {

    ENABLED("enabled"),
    DISABLED("disabled");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsECSHttpEndpointEnum.class);
    private String name;

    AwsECSHttpEndpointEnum(String name) {
        this.name = name;
    }

    public static AwsECSHttpEndpointEnum fromName(String name) {
        AwsECSHttpEndpointEnum retVal = null;
        for (AwsECSHttpEndpointEnum HttpEndpoint : AwsECSHttpEndpointEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, HttpEndpoint.name)) {
                retVal = HttpEndpoint;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create HTTP Endpoint enum for name : " + name + ", but we don't support such option ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}