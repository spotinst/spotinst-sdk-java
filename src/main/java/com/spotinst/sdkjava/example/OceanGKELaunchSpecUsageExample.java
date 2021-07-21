package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.PerformAtEnumGcp;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.gcp.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OceanGKELaunchSpecUsageExample {

    private final static String auth_token    = "337ef881fe540a521363fe652c59dd0af246384185049c897f54293538912f43";
    private final static String account_id        = "act-7d8b3fee";
    private final static String key_pair_name = "some-key-pair-name";

    public static void main(String[] args) throws IOException {

        SpotinstOceanGKELaunchSpecClientTest
                spotinstOceanGKELaunchSpecClientTest = SpotinstClient.getSpotinstOceanGKELaunchSpecClientTest(auth_token, account_id);


    }

    private static String  createElastigroup(SpotinstOceanGKELaunchSpecClientTest client) {

        //Build Instance Type
        LaunchSpecReq.Builder launchSpecReq = LaunchSpecReq.Builder.get();

        List<String> PreemtibleList = new ArrayList<>();
        PreemtibleList.add("n1-standard-1");

        LaunchSpecReq oceanId = launchSpecReq.setOceanId("").build();
        LaunchSpecReq sourceImage = launchSpecReq.setSourceImage("").build();


        // Build gcp elastigroup creation request
        OceanGKECreateLaunchSpecRequest.Builder oceanGKECreateLaunchSpecRequest =
                OceanGKECreateLaunchSpecRequest.Builder.get();

        OceanGKECreateLaunchSpecRequest creationRequestGcp=
                oceanGKECreateLaunchSpecRequest.setOceanGKECreateLaunchSpec()

        // Convert elastigroup to API object json
        System.out.println(creationRequestGcp.toJson());
        // Create elastigroup

        ElastigroupGcp createdElastigroup = client.createElastigroup(creationRequestGcp);
        System.out.println("Elastigroup successfully created: " + createdElastigroup.getId());

        // Get elastigroup Id
        return createdElastigroup.getId();

    }
}
