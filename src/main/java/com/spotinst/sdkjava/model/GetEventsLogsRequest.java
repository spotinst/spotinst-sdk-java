package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.EventsLogsSeverityEnum;
import com.spotinst.sdkjava.exception.SpotinstValidationException;

import java.util.Objects;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
public class GetEventsLogsRequest {

    //region Members
    private String severity;
    private String timeInterval;
    private String elastigroupId;
    //endregion

    //region Private Constructor
    private GetEventsLogsRequest() {
    }
    //endregion

    //region Getters & Setters
    public String getElastigroupId() {
        return elastigroupId;
    }

    public void setElastigroupId(String elastigroupId) {
        this.elastigroupId = elastigroupId;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
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

        public GetEventsLogsRequest.Builder setElastigroupId(final String elastigroupId) {
            getEventsLogsRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public GetEventsLogsRequest.Builder setSeverity(final String severity) {
            getEventsLogsRequest.setSeverity(severity);
            return this;
        }

        public GetEventsLogsRequest.Builder setInterval(final String interval) {
            getEventsLogsRequest.setTimeInterval(interval);
            return this;
        }

        public GetEventsLogsRequest build() {
            if (getEventsLogsRequest.getSeverity() != null &&
                Objects.isNull(EventsLogsSeverityEnum.fromName(getEventsLogsRequest.getSeverity()))) {

                throw new SpotinstValidationException("Invalid Request - severity must be one of the following: ERROR | WARN | INFO | DEBUG");
            }

            if (getEventsLogsRequest.getTimeInterval() != null &&
                Objects.isNull(EventsLogsSeverityEnum.fromName(getEventsLogsRequest.getTimeInterval()))) {

                throw new SpotinstValidationException("Invalid Request - time interval must be one of the following: 1d | 2d | 3d | 1w | 2w | 1m | 2m | 3m");
            }

            return getEventsLogsRequest;
        }

    }
    //endregion
}
