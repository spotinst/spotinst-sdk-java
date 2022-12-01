package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ElastigroupStatusEnumAzure {

        ready("ready"),
        rolling("rolling"),
        replacing("replacing"),
        recycling("recycling");

        private static final Logger LOGGER = LoggerFactory.getLogger(ElastigroupStatusEnumAzure.class);
        private String name;

        ElastigroupStatusEnumAzure(String name) {
            this.name = name;
        }

        public static ElastigroupStatusEnumAzure fromName(String name) {
            ElastigroupStatusEnumAzure retVal = null;

            for (ElastigroupStatusEnumAzure elastigroupStatusEnum : ElastigroupStatusEnumAzure.values()) {
                if (name.equalsIgnoreCase(elastigroupStatusEnum.name)) {
                    retVal = elastigroupStatusEnum;
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
