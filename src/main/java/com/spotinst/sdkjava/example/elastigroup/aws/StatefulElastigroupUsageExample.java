package com.spotinst.sdkjava.example.elastigroup.aws;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.*;
import com.spotinst.sdkjava.model.RecurrenceFrequencyEnum;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceUnLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StatefulElastigroupUsageExample {
    private final static String auth_token    = "your-token";
    private final static String act_id        = "your-account-id";

    private static final String ELASTIGROUP_ID = "stateful-elastigroup-id";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        SpotinstElastigroupClient elastigroupClient = SpotinstClient.getElastigroupClient(auth_token, act_id);

        //List stateful instance
        System.out.println("----------List stateful Instances--------------");
        List<ElastigroupListStatefulInstancesResponse> statefulInstacesList = listStatefulInstances(elastigroupClient, ELASTIGROUP_ID);
        String statefulId = null;
        for (ElastigroupListStatefulInstancesResponse statusData : statefulInstacesList) {
            statefulId = statusData.getId();
        }

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

    }

    private static Boolean pauseStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId) {

        Boolean pauseStatus = client.pauseStatefulInstance(elastigroupId, statefulId);

        if (pauseStatus) {
            System.out.println("Pause operation is started successfully");
        }
        return pauseStatus;
    }

    private static Boolean resumeStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId) {

        Boolean resumeStatus = client.resumeStatefulInstance(elastigroupId, statefulId);

        if (resumeStatus) {
            System.out.println("Resume operation is started successfully");
        }
        return resumeStatus;
    }

    private static Boolean recycleStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId) {

        Boolean recycleStatus = client.pauseStatefulInstance(elastigroupId, statefulId);

        if (recycleStatus) {
            System.out.println("Recycle operation is started successfully");
        }
        return recycleStatus;
    }

    private static Boolean deallocateStatefulInstance(SpotinstElastigroupClient client, String elastigroupId, String statefulId) {

        Boolean deallocateStatus = client.deallocateStatefulInstance(elastigroupId, statefulId);

        if (deallocateStatus) {
            System.out.println("Deallocate operation is started successfully");
        }
        return deallocateStatus;
    }

    private static List<ElastigroupListStatefulInstancesResponse> listStatefulInstances(SpotinstElastigroupClient client, String elastigroupId) {

        List<ElastigroupListStatefulInstancesResponse> elastigroupStatefulInstances =
                client.listStatefulInstances(elastigroupId);

        for (ElastigroupListStatefulInstancesResponse statusData : elastigroupStatefulInstances) {
            System.out.println(String.format("Stateful Id: %s", statusData.getId()));
            System.out.println(String.format("Stateful Instance Id: %s", statusData.getInstanceId()));
            System.out.println(String.format("Stateful Instance Image Id: %s", statusData.getImageId()));
            System.out.println(String.format("Stateful Instance private IP: %s", statusData.getPrivateIp()));
        }

        return elastigroupStatefulInstances;
    }

}
