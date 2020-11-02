package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDeploymentDetailsEventAzure implements IPartialUpdateEntity {
    //region members
    @JsonIgnore
    private Set<String> isSet;
    private String      status;
    private String      eventType;
    private Date        timestamp;
    //endregion

    //region constructor
    public ApiDeploymentDetailsEventAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
