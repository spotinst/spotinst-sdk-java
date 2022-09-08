package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ElastigroupVmSignalEnumAzure {

        vmReady("vmReady"),
        vmReadyToShutdown("vmReadyToShutdown");

        private static final Logger LOGGER = LoggerFactory.getLogger(ElastigroupVmSignalEnumAzure.class);
        private String name;

        ElastigroupVmSignalEnumAzure(String name) {
            this.name = name;
        }

        public static ElastigroupVmSignalEnumAzure fromName(String name) {
            ElastigroupVmSignalEnumAzure retVal = null;

            for (ElastigroupVmSignalEnumAzure vmSignalEnum : ElastigroupVmSignalEnumAzure.values()) {
                if (name.equalsIgnoreCase(vmSignalEnum.name)) {
                    retVal = vmSignalEnum;
                    break;
                }
            }

            if (retVal == null) {
                LOGGER.error("Tried to create 'status' enum for: " + name + ", but we don't support such type ");
            }

            return retVal;
        }

        public String getName() {
            return name;
        }

}
