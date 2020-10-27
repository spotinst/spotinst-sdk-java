package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import com.spotinst.sdkjava.enums.GroupDeploymentStateEnumAzure;

import java.util.Date;

public class DeploymentDetailsEventAzure {
    //region members
    private GroupDeploymentStateEnumAzure status;
    private String                        eventType;
    private Date                          timestamp;
    //endregion

    //region getters & setters
    public GroupDeploymentStateEnumAzure getStatus() {
        return status;
    }

    public void setStatus(GroupDeploymentStateEnumAzure status) {
        this.status = status;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    //endregion

}
