package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.EventsLogsSeverityEnum;
import com.spotinst.sdkjava.enums.EventsLogsTimeIntervalEnum;
import com.spotinst.sdkjava.exception.SpotinstValidationException;

import java.util.Objects;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
public class GetEventsLogsRequest {

    //region Members
    private EventsLogsTimeIntervalEnum timeInterval;
    private EventsLogsSeverityEnum     severity;
    private String                     resourceId;
    private String                     limit;
    private String                     elastigroupId;
    //endregion

    //region Private Constructor
    private GetEventsLogsRequest() {
    }
    //endregion

    //region Getters & Setters
    public EventsLogsTimeIntervalEnum getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(EventsLogsTimeIntervalEnum timeInterval) {
        this.timeInterval = timeInterval;
    }

    public EventsLogsSeverityEnum getSeverity() {
        return severity;
    }

    public void setSeverity(EventsLogsSeverityEnum severity) {
        this.severity = severity;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getElastigroupId() {
        return elastigroupId;
    }

    public void setElastigroupId(String elastigroupId) {
        this.elastigroupId = elastigroupId;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private GetEventsLogsRequest getEventsLogsRequest;

        private Builder() {
            this.getEventsLogsRequest = new GetEventsLogsRequest();
        }

        public static GetEventsLogsRequest.Builder get() {
            GetEventsLogsRequest.Builder builder = new GetEventsLogsRequest.Builder();
            return builder;
        }

        public GetEventsLogsRequest.Builder setTimeInterval(final EventsLogsTimeIntervalEnum timeInterval) {
            getEventsLogsRequest.setTimeInterval(timeInterval);
            return this;
        }

        public GetEventsLogsRequest.Builder setSeverity(final EventsLogsSeverityEnum severity) {
            getEventsLogsRequest.setSeverity(severity);
            return this;
        }

        public GetEventsLogsRequest.Builder setResourceId(final String resourceId) {
            getEventsLogsRequest.setResourceId(resourceId);
            return this;
        }

        public GetEventsLogsRequest.Builder setLimit(final String limit) {
            getEventsLogsRequest.setLimit(limit);
            return this;
        }

        public GetEventsLogsRequest.Builder setElastigroupId(final String elastigroupId) {
            getEventsLogsRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public GetEventsLogsRequest build() {
            if (Objects.isNull(getEventsLogsRequest.getElastigroupId())) {
                throw new SpotinstValidationException("Invalid Request - elastigroupId must be set");
            }

            return getEventsLogsRequest;
        }
    }
    //endregion
}
