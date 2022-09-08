package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum k8sClusterRollOldVmsStatusEnum {

        REPLACED("REPLACED"),
        TO_BE_REPLACED("TO_BE_REPLACED"),
        COULD_NOT_BE_REPLACED("COULD_NOT_BE_REPLACED");

        private static final Logger LOGGER = LoggerFactory.getLogger(k8sClusterRollOldVmsStatusEnum.class);
        private String name;

        k8sClusterRollOldVmsStatusEnum(String name) {
            this.name = name;
        }

        public static k8sClusterRollOldVmsStatusEnum fromName(String name) {
            k8sClusterRollOldVmsStatusEnum retVal = null;

            for (k8sClusterRollOldVmsStatusEnum clusterRollStatusEnum : k8sClusterRollOldVmsStatusEnum.values()) {
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
