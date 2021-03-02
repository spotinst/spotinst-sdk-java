package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// todo oz: GroupActiveInstanceStatusEnumGcp - DONE
public enum GroupActiveInstanceStatusEnumGcp {
    // todo oz: "change value to lower case -> STOPPING("stopping") - DONE
    stopping("stopping"),
    terminated("terminated"),
    provisioning("provisioning"),
    staging("staging"),
    NEW("new"),
    running("running");

    private GroupActiveInstanceStatusEnumGcp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final        String name;
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupActiveInstanceStatusEnumGcp.class);

    public static GroupActiveInstanceStatusEnumGcp fromName(String name) {
        GroupActiveInstanceStatusEnumGcp retVal = null;

        for (GroupActiveInstanceStatusEnumGcp type : GroupActiveInstanceStatusEnumGcp.values()) {
            if (name.equalsIgnoreCase(type.name)) {
                retVal = type;
                break;
            }
        }

        if (retVal == null)
        {
            LOGGER.error("Tried to create instance health status enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }
}
