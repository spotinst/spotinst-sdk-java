package com.spotinst.sdkjava.enums.gcp;

import java.util.logging.Logger;

public enum GcpElastigroupHealthCheckTypeEnum {

    K8S_NODE("K8S_NODE"),
    BACKEND_SERVICE("BACKEND_SERVICE");

    private String name;

    GcpElastigroupHealthCheckTypeEnum(String name) {
        this.name = name;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(GcpElastigroupHealthCheckTypeEnum.class);

    public static GcpElastigroupHealthCheckTypeEnum fromName(String name) {
        GcpElastigroupHealthCheckTypeEnum retVal = null;

        for (GcpElastigroupHealthCheckTypeEnum instanceStateEnum : GcpElastigroupHealthCheckTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, instanceStateEnum.name)) {
                retVal = instanceStateEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create Health Check Type Enum for: %s, but we don't support such type",
                    name));
        }
        return retVal;
    }

    public String getName() {
        return name;
    }
}
