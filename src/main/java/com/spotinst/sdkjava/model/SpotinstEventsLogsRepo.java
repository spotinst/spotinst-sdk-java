package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
//todo daniel : is this should be part of the Elastigroup repo ? this are the goup elasti logs no ? not mandatory.
public class SpotinstEventsLogsRepo implements ISpotinstEventsLogsRepo {

    @Override
    public RepoGenericResponse<List<EventLog>> getAll(EventsLogsFilter filter, String authToken, String account) {
        RepoGenericResponse<List<EventLog>> retVal;

        try {
            List<EventLog> eventsLogs = new LinkedList<>();
            List<ApiEventLog> apiEventsLogs = SpotinstEventsLogsService
                    .getEventsLogs(filter.getFromDate(), filter.getToDate(), filter.getSeverity(),
                                   filter.getResourceId(), filter.getLimit(), filter.getElastigroupId(), authToken,
                                   account);
            //todo daniel : look at spotinst elastigroup repo line 125 more elegant way to write this.
            for (ApiEventLog apiEventLog : apiEventsLogs) {
                EventLog eventLog = ApiEventsLogsConverter.dalToBl(apiEventLog);
                eventsLogs.add(eventLog);
            }

            retVal = new RepoGenericResponse<>(eventsLogs);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}

