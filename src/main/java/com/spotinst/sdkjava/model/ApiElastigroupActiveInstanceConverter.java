package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.enums.AwsInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.AwsInstanceTypeEnum;

/**
 * Created by talzur on 12/12/2016.
 */
class ApiElastigroupActiveInstanceConverter {
    static ElastigroupActiveInstance dalToBl(ApiElastigroupActiveInstance apiElastigroupActiveInstance) {
        ElastigroupActiveInstance retVal = new ElastigroupActiveInstance();
        retVal.setInstanceId(apiElastigroupActiveInstance.getInstanceId());
        retVal.setAvailabilityZone(apiElastigroupActiveInstance.getAvailabilityZone());
        retVal.setInstanceType(AwsInstanceTypeEnum.fromName(apiElastigroupActiveInstance.getInstanceType()));

        if (apiElastigroupActiveInstance.getSpotInstanceRequestId() != null) {
            retVal.setLifeCycle(AwsInstanceLifecycleEnum.SPOT);
        } else {
            retVal.setLifeCycle(AwsInstanceLifecycleEnum.ON_DEMAND);
        }

        retVal.setCreatedAt(apiElastigroupActiveInstance.getCreatedAt());
        retVal.setStatus(apiElastigroupActiveInstance.getStatus());
        retVal.setProduct(apiElastigroupActiveInstance.getProduct());
        retVal.setSpotInstanceRequestId(apiElastigroupActiveInstance.getSpotInstanceRequestId());
        retVal.setGroupId(apiElastigroupActiveInstance.getGroupId());
        retVal.setPublicIp(apiElastigroupActiveInstance.getPublicIp());
        retVal.setPrivateIp(apiElastigroupActiveInstance.getPrivateIp());
        retVal.setIpv6Address(apiElastigroupActiveInstance.getIpv6Address());
        return retVal;
    }
}
