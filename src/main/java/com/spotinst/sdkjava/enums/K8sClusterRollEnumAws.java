package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum K8sClusterRollEnumAws {

        IN_PROGRESS("IN_PROGRESS"),
        COMPLETED("COMPLETED"),
        FAILED("FAILED"),
        STOPPED("STOPPED");

        private static final Logger LOGGER = LoggerFactory.getLogger(K8sClusterRollEnumAws.class);
        private String name;

        private K8sClusterRollEnumAws(String name) {
            this.name = name;
        }

        public static K8sClusterRollEnumAws fromName(String name) {
            K8sClusterRollEnumAws retVal = null;

            for (K8sClusterRollEnumAws clusterRollStatusEnum : K8sClusterRollEnumAws.values()) {
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
