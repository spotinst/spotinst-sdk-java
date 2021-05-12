package com.spotinst.sdkjava.model;

import java.util.Date;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
public class EventLog {

    //region Members
    private String code;
    private String message;
    private String severity;
    private Date   createdAt;
    private String link;
    //endregion

    //region Getter & Setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    //endregion
}
