package com.spotinst.sdkjava.model.converters.elastigroup.aws;

import com.spotinst.sdkjava.model.api.elastigroup.aws.*;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;

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

    public static ElastigroupImportStatefulInstanceDataResponse toBl(ApiElastigroupImportStatefulInstanceDataResponse data) {
        ElastigroupImportStatefulInstanceDataResponse retVal = null;

        if (data != null) {
            ElastigroupImportStatefulInstanceDataResponse.Builder detailedStatusBuilder = ElastigroupImportStatefulInstanceDataResponse.Builder.get();

            if (data.isOriginalInstanceIdSet()) {
                detailedStatusBuilder.setOriginalInstanceId(data.getOriginalInstanceId());
            }

            if (data.isShouldKeepPrivateIpSet()) {
                detailedStatusBuilder.setShouldKeepPrivateIp(data.getShouldKeepPrivateIp());
            }

            if (data.isShouldTerminateInstanceSet()) {
                detailedStatusBuilder.setShouldTerminateInstance(data.getShouldTerminateInstance());
            }

            retVal = detailedStatusBuilder.build();
        }

        return retVal;
    }

    public static ElastigroupImportStatefulInstanceResponse toBl(
            ApiElastigroupImportStatefulInstanceResponse elastigroupImportStatefulInstanceResponse) {
        ElastigroupImportStatefulInstanceResponse retVal = null;

        if (elastigroupImportStatefulInstanceResponse != null) {
            retVal = new ElastigroupImportStatefulInstanceResponse();

            if (elastigroupImportStatefulInstanceResponse.isIdSet()) {
                retVal.setId(elastigroupImportStatefulInstanceResponse.getId());
            }

            if (elastigroupImportStatefulInstanceResponse.isGroupIdSet()) {
                retVal.setGroupId(elastigroupImportStatefulInstanceResponse.getGroupId());
            }

            if (elastigroupImportStatefulInstanceResponse.isStateSet()) {
                retVal.setState(elastigroupImportStatefulInstanceResponse.getState());
            }

            if (elastigroupImportStatefulInstanceResponse.isDataSet()) {
                retVal.setData(toBl(elastigroupImportStatefulInstanceResponse.getData()));
            }

        }
        return retVal;

    }

    public static ElastigroupGetImportStatefulStatusResponse toBl(
            ApiElastigroupGetImportStatefulStatusResponse elastigroupGetImportStatefulStatusResponse) {
        ElastigroupGetImportStatefulStatusResponse retVal = null;

        if (elastigroupGetImportStatefulStatusResponse != null) {
            retVal = new ElastigroupGetImportStatefulStatusResponse();

            if (elastigroupGetImportStatefulStatusResponse.isStatefulMigrationIdSet()) {
                retVal.setStatefulMigrationId(elastigroupGetImportStatefulStatusResponse.getStatefulMigrationId());
            }

            if (elastigroupGetImportStatefulStatusResponse.isInstanceIdSet()) {
                retVal.setInstanceId(elastigroupGetImportStatefulStatusResponse.getInstanceId());
            }

            if (elastigroupGetImportStatefulStatusResponse.isGroupIdSet()) {
                retVal.setGroupId(elastigroupGetImportStatefulStatusResponse.getGroupId());
            }

            if (elastigroupGetImportStatefulStatusResponse.isStateSet()) {
                retVal.setState(elastigroupGetImportStatefulStatusResponse.getState());
            }

            if (elastigroupGetImportStatefulStatusResponse.isStateDescriptionSet()) {
                retVal.setStateDescription(elastigroupGetImportStatefulStatusResponse.getStateDescription());
            }

        }
        return retVal;

    }

    public static ElastigroupTerminateStatefulInstanceImportResponse toBl(
            ApiElastigroupTerminateStatefulInstanceImportResponse elastigroupTerminateStatefulInstanceImportResponse) {
        ElastigroupTerminateStatefulInstanceImportResponse retVal = null;

        if (elastigroupTerminateStatefulInstanceImportResponse != null) {
            retVal = new ElastigroupTerminateStatefulInstanceImportResponse();

            if (elastigroupTerminateStatefulInstanceImportResponse.isIdSet()) {
                retVal.setId(elastigroupTerminateStatefulInstanceImportResponse.getId());
            }

            if (elastigroupTerminateStatefulInstanceImportResponse.isGroupIdSet()) {
                retVal.setGroupId(elastigroupTerminateStatefulInstanceImportResponse.getGroupId());
            }

            if (elastigroupTerminateStatefulInstanceImportResponse.isStateSet()) {
                retVal.setState(elastigroupTerminateStatefulInstanceImportResponse.getState());
            }

        }
        return retVal;

    }


}
