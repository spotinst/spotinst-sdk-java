package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.GroupDeploymentStateEnumAzure;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DeploymentDetailsEventAzure {
    //region members
    @JsonIgnore
    private Set<String>                   isSet;
    private GroupDeploymentStateEnumAzure status;
    private String                        eventType;
    private Date                          timestamp;
    //endregion

    //region constructor
    public DeploymentDetailsEventAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    public GroupDeploymentStateEnumAzure getStatus() {
        return status;
    }

    public void setStatus(GroupDeploymentStateEnumAzure status) {
        this.status = status;
        touch("status");
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
        touch("eventType");
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        touch("timestamp");
    }
    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isStatusSet() {
        return this.isSet.contains("status");
    }
    @JsonIgnore
    public Boolean isEventTypeSet() {
        return this.isSet.contains("eventType");
    }
    @JsonIgnore
    public Boolean isTimestampSet() {
        return this.isSet.contains("timestamp");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion

}
