package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.GcpInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.GroupActiveInstanceStatusEnumGcp;
import com.spotinst.sdkjava.model.api.gcp.ApiGroupActiveInstanceStatusGcp;

// todo oz: rename - DONE
class ApiElastigroupInstanceStatusConverterGcp {

    // todo oz: rename to toBl (convention) - DONE
    static GroupActiveInstanceStatusGcp toBl(ApiGroupActiveInstanceStatusGcp apiInstanceHealthiness) {
        // todo oz: check if null - how? it returns from cloud provider
        GroupActiveInstanceStatusGcp retVal = new GroupActiveInstanceStatusGcp();

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
