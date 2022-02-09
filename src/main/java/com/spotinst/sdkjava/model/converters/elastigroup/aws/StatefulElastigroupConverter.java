package com.spotinst.sdkjava.model.converters.elastigroup.aws;

import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupGetElastilogResponse;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupListStatefulInstancesDevices;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupListStatefulInstancesResponse;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupGetElastilogResponse;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupListStatefulInstancesDevices;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupListStatefulInstancesResponse;

import java.util.List;
import java.util.stream.Collectors;

public class StatefulElastigroupConverter {
    public static ElastigroupListStatefulInstancesResponse toBl(
            ApiElastigroupListStatefulInstancesResponse elastigroupListStatefulInstancesResponse) {
        ElastigroupListStatefulInstancesResponse retVal = null;

        if (elastigroupListStatefulInstancesResponse != null) {
            retVal = new ElastigroupListStatefulInstancesResponse();

            if (elastigroupListStatefulInstancesResponse.isIdSet()) {
                retVal.setId(elastigroupListStatefulInstancesResponse.getId());
            }

            if (elastigroupListStatefulInstancesResponse.isInstanceIdSet()) {
                retVal.setInstanceId(elastigroupListStatefulInstancesResponse.getInstanceId());
            }

            if (elastigroupListStatefulInstancesResponse.isPrivateIpSet()) {
                retVal.setPrivateIp(elastigroupListStatefulInstancesResponse.getPrivateIp());
            }

            if (elastigroupListStatefulInstancesResponse.isImageIdSet()) {
                retVal.setImageId(elastigroupListStatefulInstancesResponse.getImageId());
            }

            if (elastigroupListStatefulInstancesResponse.isStateSet()) {
                retVal.setState(elastigroupListStatefulInstancesResponse.getState());
            }

            if (elastigroupListStatefulInstancesResponse.isDevicesSet()) {
                List<ElastigroupListStatefulInstancesDevices> devices = elastigroupListStatefulInstancesResponse.getDevices()
                        .stream().map(StatefulElastigroupConverter::toBl).collect(Collectors.toList());
                retVal.setDevices(devices);
            }

            if (elastigroupListStatefulInstancesResponse.isLaunchedAtSet()) {
                retVal.setLaunchedAt(elastigroupListStatefulInstancesResponse.getLaunchedAt());
            }

            if (elastigroupListStatefulInstancesResponse.isCreatedAtSet()) {
                retVal.setCreatedAt(elastigroupListStatefulInstancesResponse.getCreatedAt());
            }

        }
        return retVal;

    }

    private static ElastigroupListStatefulInstancesDevices toBl(
            ApiElastigroupListStatefulInstancesDevices elastigroupListStatefulInstancesDevices) {
        ElastigroupListStatefulInstancesDevices retVal = null;

        if (elastigroupListStatefulInstancesDevices != null) {
            retVal = new ElastigroupListStatefulInstancesDevices();


            if (elastigroupListStatefulInstancesDevices.isDeviceNameSet()) {
                retVal.setDeviceName(elastigroupListStatefulInstancesDevices.getDeviceName());
            }

            if (elastigroupListStatefulInstancesDevices.isVolumeIdSet()) {
                retVal.setVolumeId(elastigroupListStatefulInstancesDevices.getVolumeId());
            }

            if (elastigroupListStatefulInstancesDevices.isSnapshotIdSet()) {
                retVal.setSnapshotId(elastigroupListStatefulInstancesDevices.getSnapshotId());
            }
        }
        return retVal;

    }

    public static ElastigroupGetElastilogResponse toBl(
            ApiElastigroupGetElastilogResponse elastigroupGetElastilogResponse) {
        ElastigroupGetElastilogResponse retVal = null;

        if (elastigroupGetElastilogResponse != null) {
            retVal = new ElastigroupGetElastilogResponse();

            if (elastigroupGetElastilogResponse.isMessageSet()) {
                retVal.setMessage(elastigroupGetElastilogResponse.getMessage());
            }

            if (elastigroupGetElastilogResponse.isSeveritySet()) {
                retVal.setSeverity(elastigroupGetElastilogResponse.getSeverity());
            }

            if (elastigroupGetElastilogResponse.isCreatedAtSet()) {
                retVal.setCreatedAt(elastigroupGetElastilogResponse.getCreatedAt());
            }

        }
        return retVal;

    }


}
