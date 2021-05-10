package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
//todo daniel : is this should be part of the Elastigroup repo ? this are the goup elasti logs no ? not mandatory - Waiting for an Answer
// At first I put it inside Elastigroup repo but because the _events_logs_v2 is relevant for all resources and providers it might be a good idea to dedicate a repo.
// What do you think? Maybe I should rename the function or should I move it to Elastigroup repo?
public class SpotinstEventsLogsRepo implements ISpotinstEventsLogsRepo {

    @Override
    public RepoGenericResponse<List<EventLog>> getAll(EventsLogsFilter filter, String authToken, String account) {
        RepoGenericResponse<List<EventLog>> retVal;

        try {
            List<ApiEventLog> apiEventsLogs = SpotinstEventsLogsService
                    .getEventsLogs(filter.getFromDate(), filter.getToDate(), filter.getSeverity(),
                                   filter.getResourceId(), filter.getLimit(), filter.getElastigroupId(), authToken,
                                   account);
            //todo daniel : look at spotinst elastigroup repo line 125 more elegant way to write this - Done
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

