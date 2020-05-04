package com.spotinst.sdkjava.client.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yossi.elman on 04/05/2020.
 */
public enum AgentTypeEnum {

    SPINNAKER("Spinnaker");

    private static final Logger LOGGER = LoggerFactory.getLogger(AgentTypeEnum.class);
    private              String name;

    AgentTypeEnum(String name) {
        this.name = name;
    }

    public static AgentTypeEnum fromName(String name) {
        AgentTypeEnum retVal = null;

        for (AgentTypeEnum agentTypeEnum : AgentTypeEnum.values()) {
            if (name.equals(agentTypeEnum.name)) {
                retVal = agentTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create agent type enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
