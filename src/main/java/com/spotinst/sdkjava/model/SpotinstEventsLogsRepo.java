package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
public class SpotinstEventsLogsRepo implements ISpotinstEventsLogsRepo {

    @Override
    public RepoGenericResponse<List<EventLog>> getAll(EventsLogsFilter filter, String authToken, String account) {
        RepoGenericResponse<List<EventLog>> retVal;

        try {
            List<ApiEventLog> apiEventsLogs = SpotinstEventsLogsService
                    .getEventsLogs(filter.getFromDate(), filter.getToDate(), filter.getSeverity(),
                                   filter.getResourceId(), filter.getLimit(), filter.getElastigroupId(), authToken,
                                   account);

            List<EventLog> eventsLogs =
                    apiEventsLogs.stream().map(ApiEventsLogsConverter::dalToBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(eventsLogs);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}