package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GroupDeploymentStateEnumAzure {
    //region Enums
    DEPLOYMENT_START("deploymentStart"),
    DEPLOYMENT_IN_PROGRESS("deploymentInProgress"),
    DEPLOYMENT_FINISH("deploymentFinish"),
    DEPLOYMENT_FINISHED("deploymentFinished"),
    DEPLOYMENT_STOPPING("deploymentStopping"),
    DEPLOYMENT_STOPPED("deploymentStopped"),
    DEPLOYMENT_ERROR("deploymentError"),
    DEPLOYMENT_FAILED("deploymentFailed");

    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupDeploymentStateEnumAzure.class);
    private              String name;
    //endregion

    //region Constructors
    GroupDeploymentStateEnumAzure(String name) {
        this.name = name;
    }
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }
    //endregion

    //region Methods
    public static GroupDeploymentStateEnumAzure fromName(String name) {
        GroupDeploymentStateEnumAzure retVal = null;

        for (GroupDeploymentStateEnumAzure deploymentBatchStatus : GroupDeploymentStateEnumAzure.values()) {
            if (name.equalsIgnoreCase(deploymentBatchStatus.name)) {
                retVal = deploymentBatchStatus;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(
                    "Tried to create Deployment group state enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }
    //endregion
}
