package com.spotinst.sdkjava.model;

/**
 * Created by daniel on 09/05/2021.
 */
public class ApiEventsLogsConverter {

    static EventLog dalToBl(ApiEventLog apiEventLog) {
        EventLog retVal = new EventLog();
        retVal.setCode(apiEventLog.getCode());
        retVal.setMessage(apiEventLog.getMessage());
        retVal.setSeverity(apiEventLog.getSeverity());
        retVal.setCreatedAt(apiEventLog.getCreatedAt());
        retVal.setLink(apiEventLog.getLink());
        return retVal;
    }
}
