package com.spotinst.sdkjava.example.elastigroup.aws;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.ElastigroupTerminateStatefulInstanceImportRequest;

import java.io.IOException;
import java.util.*;

public class StatefulElastigroupUsageExample {
    private final static String auth_token    = "your-token";
    private final static String act_id        = "your-account-id";

    private static final String ELASTIGROUP_ID = "stateful-elastigroup-id";
    private static final String Instance_ID = "instance-id";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        SpotinstElastigroupClient elastigroupClient = SpotinstClient.getElastigroupClient(auth_token, act_id);

        String volumeId = null;//volume ID

        //List stateful instance
        System.out.println("----------List stateful Instances--------------");
        List<ElastigroupListStatefulInstancesResponse> statefulInstacesList = listStatefulInstances(elastigroupClient, ELASTIGROUP_ID);

        String statefulId = null;//stateful ID

        //Pause the stateful instance
        System.out.println("----------Pause stateful Instance--------------");
        Boolean pauseStatus = pauseStatefulInstance(elastigroupClient, ELASTIGROUP_ID, statefulId);

        //Resume the stateful instance
        System.out.println("----------Resume stateful Instance--------------");
        Boolean resumeStatus = resumeStatefulInstance(elastigroupClient, ELASTIGROUP_ID, statefulId);

        //Recycle the stateful instance
        System.out.println("----------Recycle stateful Instance--------------");
        Boolean recycleStatus = recycleStatefulInstance(elastigroupClient, ELASTIGROUP_ID, statefulId);

        //Deallocate the stateful instance
        System.out.println("----------Deallocate stateful Instance--------------");
        Boolean deallocateStatus = deallocateStatefulInstance(elastigroupClient, ELASTIGROUP_ID, statefulId);

        //Delete volume in the stateful instance
        System.out.println("----------Delete volume in the stateful Instance--------------");
        Boolean deleteVolumeStatus = deleteVolumeInStatefulInstance(elastigroupClient, ELASTIGROUP_ID, statefulId, volumeId);

        //Import stateful instance
        System.out.println("----------Import stateful Instance--------------");
        ElastigroupImportStatefulInstanceResponse importResponse = importStatefulInstance(elastigroupClient, Instance_ID);

        //Terminate stateful instance
        String statefulMigrationGroupID = null;
        System.out.println("----------Terminate stateful Instance--------------");
        ElastigroupTerminateStatefulInstanceImportResponse terminateResponse = terminateStatefulInstanceImport(elastigroupClient, statefulMigrationGroupID);

        //Delete stateful instance
        System.out.println("----------Delete stateful Instance--------------");
        ElastigroupTerminateStatefulInstanceImportResponse deleteResponse = deleteStatefulInstanceImport(elastigroupClient, statefulMigrationGroupID);

        //List stateful instance import status
        System.out.println("----------List stateful Instance Import Status--------------");
        ElastigroupGetImportStatefulStatusResponse importStatusResponse = getStatefulImportStatus(elastigroupClient, statefulMigrationGroupID);

    }

    private static Boolean pauseStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId) {

        Boolean pauseStatus = client.pauseStatefulInstance(elastigroupId, statefulId);

        if (pauseStatus) {
            System.out.println("Pause operation is started successfully");
        }
        else {
            System.out.println("Pause operation is not started");
        }
        return pauseStatus;
    }

    private static Boolean resumeStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId) {

        Boolean resumeStatus = client.resumeStatefulInstance(elastigroupId, statefulId);

        if (resumeStatus) {
            System.out.println("Resume operation is started successfully");
        }
        else {
            System.out.println("Resume operation is not started");
        }
        return resumeStatus;
    }

    private static Boolean recycleStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId) {

        Boolean recycleStatus = client.pauseStatefulInstance(elastigroupId, statefulId);

        if (recycleStatus) {
            System.out.println("Recycle operation is started successfully");
        }
        else {
            System.out.println("Recycle operation is not started");
        }
        return recycleStatus;
    }

    private static Boolean deallocateStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId) {

        Boolean deallocateStatus = client.deallocateStatefulInstance(elastigroupId, statefulId);

        if (deallocateStatus) {
            System.out.println("Deallocate operation is started successfully");
        }
        else {
            System.out.println("Deallocate operation is not started");
        }
        return deallocateStatus;
    }

    private static Boolean deleteVolumeInStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId, String volumeId) {

        Boolean deleteVolumeStatus = client.deleteVolumeInStatefulInstance(elastigroupId, statefulId, volumeId);

        if (deleteVolumeStatus) {
            System.out.println("Delete volume operation is success");
        }
        else {
            System.out.println("Delete volume operation failed");
        }
        return deleteVolumeStatus;
    }

    private static List<ElastigroupListStatefulInstancesResponse> listStatefulInstances(SpotinstElastigroupClient client, String elastigroupId) {

        List<ElastigroupListStatefulInstancesResponse> elastigroupStatefulInstances =
                client.listStatefulInstances(elastigroupId);

        for (ElastigroupListStatefulInstancesResponse instance : elastigroupStatefulInstances) {
            System.out.println(String.format("Stateful Id: %s", instance.getId()));
            System.out.println(String.format("Stateful Instance Id: %s", instance.getInstanceId()));
            System.out.println(String.format("Stateful Instance Image Id: %s", instance.getImageId()));
            System.out.println(String.format("Stateful Instance private IP: %s", instance.getPrivateIp()));
            System.out.println(String.format("Stateful Instance Devices: %s", instance.getDevices()));
            System.out.println(String.format("Stateful Instance state: %s", instance.getState()));
            System.out.println(String.format("Stateful Instance created date: %s", instance.getCreatedAt()));
            System.out.println(String.format("Stateful Instance launched date: %s", instance.getLaunchedAt()));
            for (ElastigroupListStatefulInstancesDevices device : instance.getDevices()) {
                System.out.println(String.format("Stateful Instance Device name: %s", device.getDeviceName()));
                System.out.println(String.format("Stateful Instance Snapshot Id: %s", device.getSnapshotId()));
                System.out.println(String.format("Stateful Instance Volume Id: %s", device.getVolumeId()));
            }
        }

        return elastigroupStatefulInstances;
    }

    private static ElastigroupImportStatefulInstanceResponse importStatefulInstance(SpotinstElastigroupClient client, String Instance_ID) {

        ElastigroupImportStatefulInstance.Builder importBuilder = ElastigroupImportStatefulInstance.Builder.get();
        ElastigroupImportStatefulInstance importStatus = importBuilder.setName("Test").setOriginalInstanceId(Instance_ID).setShouldKeepPrivateIp(false).build();

        return client.importStatefulInstance(importStatus);
    }

    private static ElastigroupTerminateStatefulInstanceImportResponse terminateStatefulInstanceImport(SpotinstElastigroupClient client, String statefulMigrationGroupID) {

        ElastigroupTerminateStatefulInstanceImportRequest.Builder importBuilder = ElastigroupTerminateStatefulInstanceImportRequest.Builder.get();
        ElastigroupTerminateStatefulInstanceImportRequest importStatus = importBuilder.setType("terminate").build();

        return client.terminateStatefulInstanceImport(importStatus, statefulMigrationGroupID);
    }

    private static ElastigroupTerminateStatefulInstanceImportResponse deleteStatefulInstanceImport(SpotinstElastigroupClient client, String statefulMigrationGroupID) {

        return client.deleteStatefulInstanceImport(statefulMigrationGroupID);
    }

    private static ElastigroupGetImportStatefulStatusResponse getStatefulImportStatus(SpotinstElastigroupClient client, String statefulMigrationGroupID) {

        ElastigroupGetImportStatefulStatusResponse elastigroupStatefulImportStatus =
                client.getStatefulImportStatus(statefulMigrationGroupID);

            System.out.println(String.format("Stateful Migration Id: %s", elastigroupStatefulImportStatus.getStatefulMigrationId()));
            System.out.println(String.format("Stateful Instance Id: %s", elastigroupStatefulImportStatus.getInstanceId()));
            System.out.println(String.format("Stateful Instance Group Id: %s", elastigroupStatefulImportStatus.getGroupId()));
            System.out.println(String.format("Stateful Instance state description: %s", elastigroupStatefulImportStatus.getStateDescription()));
            System.out.println(String.format("Stateful Instance state: %s", elastigroupStatefulImportStatus.getState()));

        return elastigroupStatefulImportStatus;
    }

}
