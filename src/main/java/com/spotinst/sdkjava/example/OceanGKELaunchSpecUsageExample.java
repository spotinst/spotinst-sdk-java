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
        String launchSpecId = createGKELaunchSpec(spotinstOceanGKELaunchSpecClientTest,"Test_LaunchSpec4");
        if(launchSpecId == null){
            System.out.println("Failed to create Launch spec so exiting from the script");
            System.exit(0);
        }
        OceanGKECreateLaunchSpecRes res = getALaunchSpecs(spotinstOceanGKELaunchSpecClientTest,launchSpecId);
        System.out.println("Below are the recent fetch launch spec details");
        System.out.println("Launch Spec ID: "+res.getId());
        updateALaunchSpec(spotinstOceanGKELaunchSpecClientTest,res.getId(),"Update_Test_LaunchSpec4");
        System.out.println("New name after update : "+getALaunchSpecs(spotinstOceanGKELaunchSpecClientTest,launchSpecId).getName());
        deleteALaunchSpec(spotinstOceanGKELaunchSpecClientTest,res.getId());

    }

    private static String  createGKELaunchSpec(SpotinstOceanGKELaunchSpecClientTest client,String launchSpecname) {


        OceanGKECreateLaunchSpecRequest.Builder oceanGKECreateLaunchSpecRequest =
                OceanGKECreateLaunchSpecRequest.Builder.get();

        OceanGKEMetadata.Builder builder = OceanGKEMetadata.Builder.get();
        builder.setKey("Key1");
        builder.setValue("Value1");
        OceanGKEMetadata metadata = builder.build();
        List<OceanGKEMetadata> oceanGKEMetadatas = new ArrayList<>();
        oceanGKEMetadatas.add(metadata);


        List<String> instanceTypes = Arrays.asList(new String[]{"n1-standard-1","n1-standard-2"});
        List<OceanGKETaints> taints = new ArrayList<>();
        OceanGKETaints taintsBuilder = OceanGKETaints.Builder.get().setKey("taintKey")
                                                                    .setValue("taintValue")
                                                                    .setEffect("NoSchedule").build();
        taints.add(taintsBuilder);


        List<OceanGKELabels> labels = new ArrayList<>();
        OceanGKELabels oceanGKELabels = OceanGKELabels.Builder.get().setKey("env").setValue("test").build();
        labels.add(oceanGKELabels);

        List<OceanGKEHeadRooms> headRoomsList = new ArrayList<>();
        OceanGKEHeadRooms oceanGKEHeadRooms = OceanGKEHeadRooms.Builder.get().setCpuPerUnit(1000)
                                                                       .setGpuPerUnit(0)
                                                                       .setMemoryPerUnit(2048)
                                                                       .setNumOfUnits(3).build();
        headRoomsList.add(oceanGKEHeadRooms);
        OceanGKEAutoScale autoScale = OceanGKEAutoScale.Builder.get().setHeadrooms(headRoomsList).build();


        OceanGKEResourceLimits resourceLimits = OceanGKEResourceLimits.Builder.get().setMaxInstanceCount(5).build();

        OceanGKEShieldedInstanceConfig shieldedInstanceConfig = OceanGKEShieldedInstanceConfig.Builder.get().setEnableSecureBoot(true).setEnableIntegrityMonitoring(true).build();

        OceanGKEStrategy strategy = OceanGKEStrategy.Builder.get().setPreemptiblePercentage(80).build();

        OceanGKEStorage storage = OceanGKEStorage.Builder.get().setLocalSsdCount(2).build();

        OceanGKECreateLaunchSpecRes.Builder oceanGKECreateLaunchSpecResBuilder = OceanGKECreateLaunchSpecRes.Builder.get();
        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecResBuilder.setOceanId("o-23da368e")
                                                                                                    .setServiceAccount("serviceAccount")
                                                                                                    .setRootVolumeType("pd-standard")
                                                                                                    .setName(launchSpecname)
                                                                                                    .setSourceImage("https://www.googleapis.com/compute/v1/projects/gke-node-images/global/images/container-v1-3-v20160517")
                                                                                                    .setInstanceTypes(instanceTypes)
                                                                                                    .setTaints(taints)
                                                                                                    .setLabels(labels)
                                                                                                    .setAutoScales(autoScale)
                                                                                                    .setResourceLimits(resourceLimits)
                                                                                                    .setOceanGKEShieldedInstanceConfig(shieldedInstanceConfig)
                                                                                                    .setStrategy(strategy)
                                                                                                    .setStorage(storage)
                                                                                                    .setMetadata(oceanGKEMetadatas).build();
        OceanGKECreateLaunchSpecRequest creationRequest=
                oceanGKECreateLaunchSpecRequest.setOceanGKECreateLaunchSpec(oceanGKECreateLaunchSpecRes).build();

        System.out.println(creationRequest.toJson());

        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpec = client.createOceanGKELaunchSpec(creationRequest);
        System.out.println("GKE Launch Spec successfully created: " + oceanGKECreateLaunchSpec.getName());

        return oceanGKECreateLaunchSpec.getId();

    }

    private static OceanGKECreateLaunchSpecRes getALaunchSpecs(SpotinstOceanGKELaunchSpecClientTest client,String LaunchSpecId){
        return client.getALaunchSpec(LaunchSpecId);
    }

    private static void updateALaunchSpec(SpotinstOceanGKELaunchSpecClientTest client,String launchSpecId,String newName){

        OceanGKECreateLaunchSpecRequest.Builder oceanGKEUpdateLaunchSpecRequest =
                OceanGKECreateLaunchSpecRequest.Builder.get();

        OceanGKEMetadata.Builder builder = OceanGKEMetadata.Builder.get();
        builder.setKey("UKey1");
        builder.setValue("UValue1");
        OceanGKEMetadata metadata = builder.build();
        List<OceanGKEMetadata> oceanGKEMetadatas = new ArrayList<>();
        oceanGKEMetadatas.add(metadata);


        List<OceanGKETaints> taints = new ArrayList<>();
        OceanGKETaints taintsBuilder = OceanGKETaints.Builder.get().setKey("UtaintKey")
                                                             .setValue("UtaintValue")
                                                             .setEffect("NoSchedule").build();
        taints.add(taintsBuilder);


        OceanGKECreateLaunchSpecRes.Builder oceanGKECreateLaunchSpecResBuilder = OceanGKECreateLaunchSpecRes.Builder.get();
        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecResBuilder.setName(newName)
                                                                                                    .setTaints(taints)
                                                                                                    .setMetadata(oceanGKEMetadatas).build();
        OceanGKECreateLaunchSpecRequest updateRequest=
                oceanGKEUpdateLaunchSpecRequest.setOceanGKECreateLaunchSpec(oceanGKECreateLaunchSpecRes).build();

        System.out.println(updateRequest.toJson());

        Boolean updateSuccess = client.updateOceanGKELaunchSpec(updateRequest,launchSpecId);

        if(updateSuccess){
            System.out.println("launch spec updated successfully");
        }
    }

    private static void deleteALaunchSpec(SpotinstOceanGKELaunchSpecClientTest client, String launchSpecId) {
        Boolean successfulDeletion = client.deleteALaunchSpec(launchSpecId);
        if (successfulDeletion) {
            System.out.println("Launch Spec with id:" + launchSpecId+" deleted successfully");
        }
    }
}
