package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum K8sVngHttpTokensEnum {

    OPTIONAL("optional"),
    REQUIRED("required");

    private static final Logger LOGGER = LoggerFactory.getLogger(K8sVngHttpTokensEnum.class);
    private String name;

    K8sVngHttpTokensEnum(String name) {
        this.name = name;
    }

    public static K8sVngHttpTokensEnum fromName(String name) {
        K8sVngHttpTokensEnum retVal = null;
        for (K8sVngHttpTokensEnum HttpTokens : K8sVngHttpTokensEnum.values()) {
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