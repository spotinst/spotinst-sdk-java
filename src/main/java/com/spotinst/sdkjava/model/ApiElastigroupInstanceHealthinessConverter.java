package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.enums.InstanceHealthStatusEnum;

/**
 * Created by yossi.elman on 13/04/2020.
 */
class ApiElastigroupInstanceHealthinessConverter {

    static ElastigroupInstanceHealthiness dalToBl(ApiInstanceHealthiness apiInstanceHealthiness) {
        ElastigroupInstanceHealthiness retVal = new ElastigroupInstanceHealthiness();

        retVal.setInstanceId(apiInstanceHealthiness.getInstanceId());
        retVal.setSpotRequestId(apiInstanceHealthiness.getSpotRequestId());
        retVal.setGroupId(apiInstanceHealthiness.getGroupId());
        retVal.setAvailabilityZone(apiInstanceHealthiness.getAvailabilityZone());
        retVal.setLifeCycle(apiInstanceHealthiness.getLifeCycle());

        if (apiInstanceHealthiness.getHealthStatus() != null) {
            InstanceHealthStatusEnum instanceHealthStatusEnum =
                    InstanceHealthStatusEnum.fromName(apiInstanceHealthiness.getHealthStatus());
            retVal.setHealthStatus(instanceHealthStatusEnum);
        }

        return retVal;
    }
}
