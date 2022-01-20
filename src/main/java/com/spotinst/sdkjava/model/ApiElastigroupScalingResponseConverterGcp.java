package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.model.responses.elastigroup.gcp.ElastigroupScalingResponseGcp;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by saikumar on 20/01/2022.
 */
class ApiElastigroupScalingResponseConverterGcp {
    static ElastigroupScalingResponseGcp dalToBl(ApiElastigroupScalingResponseGcp apiElastigroupScalingResponseGcp) {
        ElastigroupScalingResponseGcp retVal = new ElastigroupScalingResponseGcp();
        List<ApiNewInstance> newApiInstances = apiElastigroupScalingResponseGcp.getNewInstances();
        List<ApiNewSpotRequest> newApiSpotRequests = apiElastigroupScalingResponseGcp.getNewSpotRequests();
        if (newApiInstances != null) {
            List<ElastigroupNewInstance> newInstances = new LinkedList<>();
            for (ApiNewInstance newApiInstance : newApiInstances) {
                ElastigroupNewInstance newInstance = new ElastigroupNewInstance();
                newInstance.setAvailabilityZone(newApiInstance.getAvailabilityZone());
                newInstance.setInstanceId(newApiInstance.getInstanceId());
                newInstance.setInstanceType(newApiInstance.getInstanceType());
                newInstances.add(newInstance);
            }
            retVal.setNewInstances(newInstances);
        }
        if (newApiSpotRequests != null) {
            List<ElastigroupNewSpotRequest> newSpotRequests = new LinkedList<>();
            for (ApiNewSpotRequest newApiSpotRequest : newApiSpotRequests) {
                ElastigroupNewSpotRequest newSpotRequest = new ElastigroupNewSpotRequest();
                newSpotRequest.setInstanceType(newApiSpotRequest.getInstanceType());
                newSpotRequest.setAvailabilityZone(newApiSpotRequest.getAvailabilityZone());
                newSpotRequest.setSpotInstanceRequestId(newApiSpotRequest.getSpotInstanceRequestId());
                newSpotRequests.add(newSpotRequest);
            }
            retVal.setNewSpotRequests(newSpotRequests);
        }

        return retVal;
    }
}
