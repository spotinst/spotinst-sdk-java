package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.GcpInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.InstanceHealthStatusGcpEnum;
import com.spotinst.sdkjava.model.api.gcp.ApiInstanceHealthinessGcp;


class ApiElastigroupInstanceHealthinessConverterGcp {

    static ElastigroupInstanceHealthinessGcp dalToBl(ApiInstanceHealthinessGcp apiInstanceHealthiness) {
        ElastigroupInstanceHealthinessGcp retVal = new ElastigroupInstanceHealthinessGcp();

        retVal.setInstanceName(apiInstanceHealthiness.getInstanceName());
        retVal.setPublicIpAddress(apiInstanceHealthiness.getPublicIpAddress());
        retVal.setMachineType(apiInstanceHealthiness.getMachineType());
        retVal.setZone(apiInstanceHealthiness.getZone());
        retVal.setPrivateIpAddress(apiInstanceHealthiness.getPrivateIpAddress());
        retVal.setUpdatedAt(apiInstanceHealthiness.getUpdatedAt());
        retVal.setCreatedAt(apiInstanceHealthiness.getCreatedAt());

        if (apiInstanceHealthiness.getLifeCycle() != null) {
            GcpInstanceLifecycleEnum instanceHealthStatusEnum =
                    GcpInstanceLifecycleEnum.fromName(apiInstanceHealthiness.getLifeCycle());
            retVal.setLifeCycle(instanceHealthStatusEnum);
        }

        if (apiInstanceHealthiness.getStatusName() != null) {
            InstanceHealthStatusGcpEnum instanceHealthStatusEnum =
                    InstanceHealthStatusGcpEnum.fromName(apiInstanceHealthiness.getStatusName());
            retVal.setStatusName(instanceHealthStatusEnum);
        }

        return retVal;
    }
}
