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

    public static void main(String[] args) throws IOException {

        SpotinstOceanGKELaunchSpecClientTest
                spotinstOceanGKELaunchSpecClientTest = SpotinstClient.getSpotinstOceanGKELaunchSpecClientTest(auth_token, account_id);
        String LaunchSpecName = createElastigroup(spotinstOceanGKELaunchSpecClientTest);

    }

    private static String  createElastigroup(SpotinstOceanGKELaunchSpecClientTest client) {

        //Build Instance Type
        //LaunchSpecReq.Builder launchSpecReq = LaunchSpecReq.Builder.get();

        // Build gcp elastigroup creation request
        OceanGKECreateLaunchSpecRequest.Builder oceanGKECreateLaunchSpecRequest =
                OceanGKECreateLaunchSpecRequest.Builder.get();

        OceanGKECreateLaunchSpecRes.Builder oceanGKECreateLaunchSpecResBuilder = OceanGKECreateLaunchSpecRes.Builder.get();
        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecResBuilder.setOceanId("o-0ce40c35")
                                                                                                    .setSourceImage("https://www.googleapis.com/compute/v1/projects/gke-node-images/global/images/container-v1-3-v20160517").build();
        OceanGKECreateLaunchSpecRequest creationRequest=
                oceanGKECreateLaunchSpecRequest.setOceanGKECreateLaunchSpec(oceanGKECreateLaunchSpecRes).build();

        // Convert elastigroup to API object json
        System.out.println(creationRequest.toJson());
        // Create elastigroup

        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpec = client.createOceanGKELaunchSpec(creationRequest);
        System.out.println("GKE Launch Spec successfully created: " + oceanGKECreateLaunchSpec.getName());

        // Get elastigroup Id
        return oceanGKECreateLaunchSpec.getName();

    }
}
