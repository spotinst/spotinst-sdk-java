package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
public class SpotinstEventsLogsRepo implements ISpotinstEventsLogsRepo {

    @Override
    public RepoGenericResponse<List<EventLog>> getAll(EventsLogsFilter filter, String authToken, String account) {
        RepoGenericResponse<List<EventLog>> retVal;

        try {
            List<EventLog> eventsLogs = new LinkedList<>();
            List<ApiEventLog> apiEventsLogs = SpotinstEventsLogsService
                    .getEventsLogs(filter.getSeverity(), filter.getFromDate(), filter.getToDate(),
                                   filter.getElastigroupId(), authToken, account);
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

