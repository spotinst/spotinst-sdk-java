package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ProcessNameEnumsAzure {

    autoHealing("autoHealing"),
    signalTimeout("signalTimeout"),
    autoScale("autoScale"),
    scaleDown("scaleDown"),
    syncStrategy("syncStrategy"),
    preventiveReplacement("preventiveReplacement");

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessNameEnumsAzure.class);
    private String name;

    ProcessNameEnumsAzure(String name) {
        this.name = name;
    }

    public static ProcessNameEnumsAzure fromName(String name) {
        ProcessNameEnumsAzure retVal = null;

        for (ProcessNameEnumsAzure processName : ProcessNameEnumsAzure.values()) {
            if (StringUtils.equalsIgnoreCase(name, processName.name)) {
                retVal = processName;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create process name enum for name : " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
