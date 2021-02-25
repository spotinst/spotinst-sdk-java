package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.GcpInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.GroupActiveInstanceStatusEnumGcp;
import com.spotinst.sdkjava.model.api.gcp.ApiInstanceHealthinessGcp;

// todo or: rename
class ApiElastigroupInstanceHealthinessConverterGcp {

    // todo or: rename to toBl (convention)
    static ElastigroupInstanceHealthinessGcp dalToBl(ApiInstanceHealthinessGcp apiInstanceHealthiness) {
        // todo or: check if null
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
            GroupActiveInstanceStatusEnumGcp instanceHealthStatusEnum =
                    GroupActiveInstanceStatusEnumGcp.fromName(apiInstanceHealthiness.getStatusName());
            retVal.setStatusName(instanceHealthStatusEnum);
        }

        return retVal;
    }
}
