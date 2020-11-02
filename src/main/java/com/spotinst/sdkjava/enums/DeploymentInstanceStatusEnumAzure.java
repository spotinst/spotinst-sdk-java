package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum DeploymentInstanceStatusEnumAzure {
    //region Enums
    PENDING("pending"),
    RUNNING("running"),
    DETACHED("detached");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(DeploymentInstanceStatusEnumAzure.class);
    private              String name;
    //endregion

    //region Constructors
    DeploymentInstanceStatusEnumAzure(String name)
    {
        this.name = name;
    }
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }
    //endregion

    //region Methods
    public static DeploymentInstanceStatusEnumAzure fromName(String name) {
        DeploymentInstanceStatusEnumAzure retVal = null;

        for (DeploymentInstanceStatusEnumAzure deploymentBatchStatus : DeploymentInstanceStatusEnumAzure.values()) {
            if (name.equalsIgnoreCase(deploymentBatchStatus.name)) {
                retVal = deploymentBatchStatus;
                break;
            }
        }

        if (retVal == null) {
            String preFormatted = "Tried to create deployment group status enum for %s but we don't support such type";
            LOGGER.error(preFormatted, name);
        }

        return retVal;
    }
    //endregion
}
