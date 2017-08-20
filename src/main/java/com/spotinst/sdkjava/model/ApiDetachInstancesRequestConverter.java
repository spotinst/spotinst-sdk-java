package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedList;

/**
 * Created by talzur on 16/01/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiDetachInstancesRequestConverter {

    static ApiDetachInstancesRequest toDal(ElastigroupDetachInstancesRequest request) {
        ApiDetachInstancesRequest retVal = null;

        if (request != null) {
            retVal = new ApiDetachInstancesRequest();

            if (request.getInstancesToDetach() != null) {
                retVal.setInstancesToDetach(new LinkedList<>(request.getInstancesToDetach()));
            }

            retVal.setShouldDecrementTargetCapacity(request.getShouldDecrementTargetCapacity());
            retVal.setShouldTerminateInstances(request.getShouldTerminateInstances());
            retVal.setDrainingTimeout(request.getDrainingTimeout());
        }

        return retVal;
    }
}
