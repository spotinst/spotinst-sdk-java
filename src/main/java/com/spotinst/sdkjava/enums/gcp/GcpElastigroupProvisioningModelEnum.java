package com.spotinst.sdkjava.enums.gcp;

import java.util.logging.Logger;

public enum GcpElastigroupProvisioningModelEnum {

    PREEMPTIBLE("PREEMPTIBLE"),
    SPOT("SPOT");

    private String name;

    GcpElastigroupProvisioningModelEnum(String name) {
        this.name = name;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(GcpElastigroupProvisioningModelEnum.class);

    public static GcpElastigroupProvisioningModelEnum fromName(String name) {
        GcpElastigroupProvisioningModelEnum retVal = null;

        for (GcpElastigroupProvisioningModelEnum provisioningModelEnum : GcpElastigroupProvisioningModelEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, provisioningModelEnum.name)) {
                retVal = provisioningModelEnum;
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
