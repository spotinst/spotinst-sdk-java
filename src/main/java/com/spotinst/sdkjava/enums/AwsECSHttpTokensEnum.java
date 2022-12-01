package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsECSHttpTokensEnum {

    OPTIONAL("optional"),
    REQUIRED("required");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsECSHttpTokensEnum.class);
    private String name;

    AwsECSHttpTokensEnum(String name) {
        this.name = name;
    }

    public static AwsECSHttpTokensEnum fromName(String name) {
        AwsECSHttpTokensEnum retVal = null;
        for (AwsECSHttpTokensEnum HttpTokens : AwsECSHttpTokensEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, HttpTokens.name)) {
                retVal = HttpTokens;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create HTTP TOKEN enum for name : " + name + ", but we don't support such option ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}