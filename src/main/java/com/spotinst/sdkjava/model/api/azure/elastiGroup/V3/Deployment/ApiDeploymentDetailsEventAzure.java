package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import java.util.Date;

public class ApiDeploymentDetailsEventAzure {
    //region members
    private String status;
    private String eventType;
    private Date   timestamp;
    //endregion

    //region getters & setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
