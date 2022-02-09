package com.spotinst.sdkjava.model.converters.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListInstancesAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerListInstancesAws;

public class MrScalerListInstancesConverter {

    public static BlMrScalerListInstancesAws toBl(ApiMrScalerListInstancesAws apiMrScalerListInstancesAws) {
        BlMrScalerListInstancesAws blMrScalerListInstancesAws = null;

        if (apiMrScalerListInstancesAws != null) {
            blMrScalerListInstancesAws = new BlMrScalerListInstancesAws();

            if (apiMrScalerListInstancesAws.isInstanceIdSet()) {
                blMrScalerListInstancesAws.setInstanceId(apiMrScalerListInstancesAws.getInstanceId());
            }

            if (apiMrScalerListInstancesAws.isInstanceGroupIdSet()) {
                blMrScalerListInstancesAws.setInstanceGroupId(apiMrScalerListInstancesAws.getInstanceGroupId());
            }

            if (apiMrScalerListInstancesAws.isInstanceGroupRoleSet()) {
                blMrScalerListInstancesAws.setInstanceGroupRole(apiMrScalerListInstancesAws.getInstanceGroupRole());
            }

            if (apiMrScalerListInstancesAws.isInstanceTypeSet()) {
                blMrScalerListInstancesAws.setInstanceType(apiMrScalerListInstancesAws.getInstanceType());
            }

            if (apiMrScalerListInstancesAws.isAvailabilityZoneSet()) {
                blMrScalerListInstancesAws.setAvailabilityZone(apiMrScalerListInstancesAws.getAvailabilityZone());
            }

            if (apiMrScalerListInstancesAws.isStatusSet()) {
                blMrScalerListInstancesAws.setStatus(apiMrScalerListInstancesAws.getStatus());
            }
        }

        return blMrScalerListInstancesAws;
    }

    // region toApi
    public static ApiMrScalerListInstancesAws toApi(BlMrScalerListInstancesAws blMrScalerListInstancesAws) {
        ApiMrScalerListInstancesAws apiMrScalerListInstancesAws = null;

        if (blMrScalerListInstancesAws != null) {
            apiMrScalerListInstancesAws = new ApiMrScalerListInstancesAws();

            if (blMrScalerListInstancesAws.getInstanceId() != null) {
                apiMrScalerListInstancesAws.setInstanceId(blMrScalerListInstancesAws.getInstanceId());
            }

            if (blMrScalerListInstancesAws.getInstanceGroupId() != null) {
                apiMrScalerListInstancesAws.setInstanceGroupId(blMrScalerListInstancesAws.getInstanceGroupId());
            }

            if (blMrScalerListInstancesAws.getInstanceGroupRole() != null) {
                apiMrScalerListInstancesAws.setInstanceGroupRole(blMrScalerListInstancesAws.getInstanceGroupRole());
            }

            if (blMrScalerListInstancesAws.getInstanceType() != null) {
                apiMrScalerListInstancesAws.setInstanceType(blMrScalerListInstancesAws.getInstanceType());
            }

            if (blMrScalerListInstancesAws.getAvailabilityZone() != null) {
                apiMrScalerListInstancesAws.setAvailabilityZone(blMrScalerListInstancesAws.getAvailabilityZone());
            }

            if (blMrScalerListInstancesAws.getStatus() != null) {
                apiMrScalerListInstancesAws.setStatus(blMrScalerListInstancesAws.getStatus());
            }
        }

        return apiMrScalerListInstancesAws;
    }
}
