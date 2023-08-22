package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsTerminationPolicyEnum {

    DEFAULT("default"),
    NEWEST_INSTANCE("newestInstance");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsTerminationPolicyEnum.class);
    private String name;

    AwsTerminationPolicyEnum(String name) {
        this.name = name;
    }

    public static AwsTerminationPolicyEnum fromName(String name) {
        AwsTerminationPolicyEnum retVal = null;

        for (AwsTerminationPolicyEnum policy : AwsTerminationPolicyEnum.values()) {
            if (name.equalsIgnoreCase(policy.name)) {
                retVal = policy;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create terminationPolicy enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
