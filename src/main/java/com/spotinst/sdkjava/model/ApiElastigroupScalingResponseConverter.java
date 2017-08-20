package com.spotinst.sdkjava.model;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by talzur on 12/12/2016.
 */
class ApiElastigroupScalingResponseConverter {
    static ElastigroupScalingResponse dalToBl(ApiElastigroupScalingResponse apiElastigroupScalingResponse) {
        ElastigroupScalingResponse retVal = new ElastigroupScalingResponse();
        List<ApiNewInstance> newApiInstances = apiElastigroupScalingResponse.getNewInstances();
        List<ApiNewSpotRequest> newApiSpotRequests = apiElastigroupScalingResponse.getNewSpotRequests();
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
