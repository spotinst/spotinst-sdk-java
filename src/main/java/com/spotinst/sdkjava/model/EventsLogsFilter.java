package com.spotinst.sdkjava.model;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
public class EventsLogsFilter {

    //region Members
    private String elastigroupId;
    private String severity;
    private String fromDate;
    private String toDate;
    //endregion

    //region Getter & Setter methods
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
    //endregion
}
