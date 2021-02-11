package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.enums.AwsInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.InstanceHealthStatusEnum;
import com.spotinst.sdkjava.model.api.gcp.ApiInstanceHealthinessGcp;


class ApiElastigroupInstanceHealthinessConverterGcp {

    static ElastigroupInstanceHealthinessGcp dalToBl(ApiInstanceHealthinessGcp apiInstanceHealthiness) {
        ElastigroupInstanceHealthinessGcp retVal = new ElastigroupInstanceHealthinessGcp();

        retVal.setInstanceName(apiInstanceHealthiness.getInstanceName());
        retVal.setMachineType(apiInstanceHealthiness.getMachineType());
        retVal.setGroupId(apiInstanceHealthiness.getGroupId());
        retVal.setPrivateIpAddress(apiInstanceHealthiness.getPrivateIpAddress());
        retVal.setUpdatedAt(apiInstanceHealthiness.getUpdatedAt());
        retVal.setCreatedAt(apiInstanceHealthiness.getCreatedAt());

        if (apiInstanceHealthiness.getLifeCycle() != null) {
            AwsInstanceLifecycleEnum instanceHealthStatusEnum =
                    AwsInstanceLifecycleEnum.fromName(apiInstanceHealthiness.getLifeCycle());
            retVal.setLifeCycle(instanceHealthStatusEnum);
        }

        if (apiInstanceHealthiness.getStatusName() != null) {
            InstanceHealthStatusEnum instanceHealthStatusEnum =
                    InstanceHealthStatusEnum.fromName(apiInstanceHealthiness.getStatusName());
            retVal.setStatusName(instanceHealthStatusEnum);
        }

        return retVal;
    }
}
