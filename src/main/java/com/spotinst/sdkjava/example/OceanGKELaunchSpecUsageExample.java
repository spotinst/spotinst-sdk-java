package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.PerformAtEnumGcp;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.gcp.*;
import org.apache.logging.log4j.core.util.Assert;

import java.io.IOException;
import java.util.*;

public class OceanGKELaunchSpecUsageExample {

    private final static String auth_token    = "3526b1fbfb2d375d095c3d4c2b552c2db86f1b4020a99f425d96b70604293f65";
    private final static String account_id        = "act-7d8b3fee";

    public static void main(String[] args) throws IOException {

        SpotinstOceanGKELaunchSpecClientTest
                spotinstOceanGKELaunchSpecClientTest = SpotinstClient.getSpotinstOceanGKELaunchSpecClientTest(auth_token, account_id);
        String LaunchSpecName = createGKELaunchSpec(spotinstOceanGKELaunchSpecClientTest);
    }

    private static String  createGKELaunchSpec(SpotinstOceanGKELaunchSpecClientTest client) {

        //Build Instance Type
        //LaunchSpecReq.Builder launchSpecReq = LaunchSpecReq.Builder.get();

        // Build gcp elastigroup creation request
        OceanGKECreateLaunchSpecRequest.Builder oceanGKECreateLaunchSpecRequest =
                OceanGKECreateLaunchSpecRequest.Builder.get();

        OceanGKEMetadata.Builder builder = OceanGKEMetadata.Builder.get();
        builder.setKey("Key1");
        builder.setValue("Value1");
        OceanGKEMetadata metadata = builder.build();

        List<String> instanceTypes = Arrays.asList(new String[]{"n1-standard-1","n1-standard-2"});

        List<OceanGKETaints> taintsList = new ArrayList<>();
        OceanGKETaints taintsBuilder = OceanGKETaints.Builder.get().setKey("taintKey")
                                                                    .setValue("taintValue")
                                                                    .setEffect("NoSchedule").build();
        taintsList.add(taintsBuilder);
        List<OceanGKEMetadata> oceanGKEMetadatas = new ArrayList<>();
        oceanGKEMetadatas.add(metadata);

        List<OceanGKELabels> labelList = new ArrayList<>();
        OceanGKELabels oceanGKELabels = OceanGKELabels.Builder.get().setKey("env").setValue("test").build();
        labelList.add(oceanGKELabels);

        List<OceanGKEHeadRooms> headRoomsList = new ArrayList<>();
        OceanGKEHeadRooms oceanGKEHeadRooms = OceanGKEHeadRooms.Builder.get().setCpuPerUnit(1000)
                                                                       .setGpuPerUnit(0)
                                                                       .setMemoryPerUnit(2048)
                                                                       .setNumOfUnits(3).build();
        headRoomsList.add(oceanGKEHeadRooms);
        OceanGKEAutoScale oceanGKEAutoScale = OceanGKEAutoScale.Builder.get().setHeadrooms(headRoomsList).build();


        OceanGKEResourceLimits oceanGKEResourceLimits = OceanGKEResourceLimits.Builder.get().setMaxInstanceCount(5).build();

        OceanGKEShieldedInstanceConfig oceanGKEShieldedInstanceConfig = OceanGKEShieldedInstanceConfig.Builder.get().setEnableSecureBoot(true).setEnableIntegrityMonitoring(true).build();

        OceanGKEStrategy oceanGKEStrategy = OceanGKEStrategy
        OceanGKECreateLaunchSpecRes.Builder oceanGKECreateLaunchSpecResBuilder = OceanGKECreateLaunchSpecRes.Builder.get();
        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecResBuilder.setOceanId("o-0ce40c35")
                                                                                                    .setServiceAccount("serviceAccount")
                                                                                                    .setRootVolumeSize(8)
                                                                                                    .setRootVolumeType("pd-standard")
                                                                                                    .setName("Test_Launch1")
                                                                                                    .setSourceImage("https://www.googleapis.com/compute/v1/projects/gke-node-images/global/images/container-v1-3-v20160517")
                                                                                                    .setInstanceTypes(instanceTypes)
                                                                                                    .setTaints(taintsList)
                                                                                                    .setLabels(labelList)
                                                                                                    .setAutoScales(oceanGKEAutoScale)
                                                                                                    .setResourceLimits(oceanGKEResourceLimits)
                                                                                                    .setOceanGKEShieldedInstanceConfig(oceanGKEShieldedInstanceConfig)
                                                                                                    .setMetadata(oceanGKEMetadatas).build();
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
