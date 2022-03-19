package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum k8sClusterRollStatusEnum {

        IN_PROGRESS("IN_PROGRESS"),
        COMPLETED("COMPLETED"),
        FAILED("FAILED"),
        STOPPED("STOPPED");

        private static final Logger LOGGER = LoggerFactory.getLogger(k8sClusterRollStatusEnum.class);
        private String name;

        private k8sClusterRollStatusEnum(String name) {
            this.name = name;
        }

        public static k8sClusterRollStatusEnum fromName(String name) {
            k8sClusterRollStatusEnum retVal = null;

            for (k8sClusterRollStatusEnum clusterRollStatusEnum : k8sClusterRollStatusEnum.values()) {
                if (name.equalsIgnoreCase(clusterRollStatusEnum.name)) {
                    retVal = clusterRollStatusEnum;
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
