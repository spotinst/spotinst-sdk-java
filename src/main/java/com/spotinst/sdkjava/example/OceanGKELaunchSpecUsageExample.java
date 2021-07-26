package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.gcp.*;

import java.io.IOException;
import java.util.*;

public class OceanGKELaunchSpecUsageExample {

    private final static String auth_token    = "3526b1fbfb2d375d095c3d4c2b552c2db86f1b4020a99f425d96b70604293f65";
    private final static String account_id        = "act-7d8b3fee";

    public static void main(String[] args) throws IOException {

        // Create a Launch Spec
        System.out.println("--------------Create a launch spec----------------------");
        SpotInstOceanGKELaunchSpecClient
                spotInstOceanGKELaunchSpecClient = SpotinstClient.getSpotinstOceanGKELaunchSpecClientTest(auth_token, account_id);
        String launchSpecId = createGKELaunchSpec(spotInstOceanGKELaunchSpecClient,"Test_LaunchSpec4");
        if(launchSpecId == null){
            System.out.println("Failed to create Launch spec so exiting from the script");
            System.exit(0);
        }

        // Get created launch spec
        System.out.println("--------------Get a launch spec----------------------");
        OceanGKELaunchSpec res = getALaunchSpecs(spotInstOceanGKELaunchSpecClient,launchSpecId);
        if(res != null){
            System.out.println("Launch Spec ID: "+res.getId());
        }else{
            System.out.println("Failed to get Launch spec so exiting from the script");
            System.exit(0);
        }

        // Updates a launch spec
        System.out.println("--------------Update a launch spec----------------------");
        updateALaunchSpec(spotInstOceanGKELaunchSpecClient,res.getId(),"Update_Test_LaunchSpec4");
        System.out.println("New name after update : "+getALaunchSpecs(spotInstOceanGKELaunchSpecClient,launchSpecId).getName());

        // Delete a launch spec
        System.out.println("--------------Delete a launch spec----------------------");
        deleteALaunchSpec(spotInstOceanGKELaunchSpecClient,res.getId());
    }

    private static String  createGKELaunchSpec(SpotInstOceanGKELaunchSpecClient client,String launchSpecName) {


        // Create request object to bind the request
        OceanGKECreateLaunchSpecRequest.Builder oceanGKECreateLaunchSpecRequest =
                OceanGKECreateLaunchSpecRequest.Builder.get();

        // Form a metadata request builder
        OceanGKEMetadata.Builder builder = OceanGKEMetadata.Builder.get();
        builder.setKey("Key1");
        builder.setValue("Value1");
        OceanGKEMetadata metadata = builder.build();
        List<OceanGKEMetadata> oceanGKEMetadata = new ArrayList<>();
        oceanGKEMetadata.add(metadata);

        // Form a instance type request builder
        List<String> instanceTypes = Arrays.asList(new String[]{"n1-standard-1","n1-standard-2"});

        // Form a taints request builder
        List<OceanGKETaints> taints = new ArrayList<>();
        OceanGKETaints taintsBuilder = OceanGKETaints.Builder.get().setKey("taintKey")
                                                                    .setValue("taintValue")
                                                                    .setEffect("NoSchedule").build();
        taints.add(taintsBuilder);


        // Form a labels request builder
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


        // Form a resource limits request builder
        OceanGKEResourceLimits resourceLimits = OceanGKEResourceLimits.Builder.get().setMaxInstanceCount(5).build();

        // Form a shield instance config request builder
        OceanGKEShieldedInstanceConfig shieldedInstanceConfig = OceanGKEShieldedInstanceConfig.Builder.get().setEnableSecureBoot(true).setEnableIntegrityMonitoring(true).build();

        // Form a strategy request builder
        OceanGKEStrategy strategy = OceanGKEStrategy.Builder.get().setPreemptiblePercentage(80).build();

        // Form a storage request builder
        OceanGKEStorage storage = OceanGKEStorage.Builder.get().setLocalSsdCount(2).build();

        // Build Ocean GKE launch spec
        OceanGKELaunchSpec.Builder oceanGKECreateLaunchSpecResBuilder = OceanGKELaunchSpec.Builder.get();
        OceanGKELaunchSpec oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecResBuilder.setOceanId("o-23da368e")
                                                                                                    .setServiceAccount("serviceAccount")
                                                                                                    .setRootVolumeType("pd-standard")
                                                                                                    .setName(launchSpecName)
                                                                                                    .setSourceImage("https://www.googleapis.com/compute/v1/projects/gke-node-images/global/images/container-v1-3-v20160517")
                                                                                                    .setInstanceTypes(instanceTypes)
                                                                                                    .setTaints(taints)
                                                                                                    .setLabels(labels)
                                                                                                    .setAutoScales(autoScale)
                                                                                                    .setResourceLimits(resourceLimits)
                                                                                                    .setOceanGKEShieldedInstanceConfig(shieldedInstanceConfig)
                                                                                                    .setStrategy(strategy)
                                                                                                    .setStorage(storage)
                                                                                                    .setMetadata(oceanGKEMetadata).build();
        OceanGKECreateLaunchSpecRequest creationRequest=
                oceanGKECreateLaunchSpecRequest.setOceanGKECreateLaunchSpec(oceanGKECreateLaunchSpecRes).build();

        // Convert launch spec to API object json
        System.out.println(creationRequest.toJson());

        //create launch spec
        OceanGKELaunchSpec oceanGKECreateLaunchSpec = client.createOceanGKELaunchSpec(creationRequest);
        System.out.println("GKE Launch Spec successfully created: " + oceanGKECreateLaunchSpec.getName());

        return oceanGKECreateLaunchSpec.getId();

    }

    private static OceanGKELaunchSpec getALaunchSpecs(SpotInstOceanGKELaunchSpecClient client,String LaunchSpecId){

        //Get a launch spec
        return client.getALaunchSpec(LaunchSpecId);
    }

    private static void updateALaunchSpec(SpotInstOceanGKELaunchSpecClient client,String launchSpecId,String newName){

        // Create launch spec request object
        OceanGKECreateLaunchSpecRequest.Builder oceanGKEUpdateLaunchSpecRequest =
                OceanGKECreateLaunchSpecRequest.Builder.get();

        // Form metadata builder to update
        OceanGKEMetadata.Builder builder = OceanGKEMetadata.Builder.get();
        builder.setKey("UKey1");
        builder.setValue("UValue1");
        OceanGKEMetadata metadata = builder.build();
        List<OceanGKEMetadata> oceanGKEMetadatas = new ArrayList<>();
        oceanGKEMetadatas.add(metadata);


        // Form taints builder to update
        List<OceanGKETaints> taints = new ArrayList<>();
        OceanGKETaints taintsBuilder = OceanGKETaints.Builder.get().setKey("UtaintKey")
                                                             .setValue("UtaintValue")
                                                             .setEffect("NoSchedule").build();
        taints.add(taintsBuilder);


        //Create launch spec object
        OceanGKELaunchSpec.Builder oceanGKECreateLaunchSpecResBuilder = OceanGKELaunchSpec.Builder.get();
        OceanGKELaunchSpec oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecResBuilder.setName(newName)
                                                                                                    .setTaints(taints)
                                                                                                    .setMetadata(oceanGKEMetadatas).build();
        OceanGKECreateLaunchSpecRequest updateRequest=
                oceanGKEUpdateLaunchSpecRequest.setOceanGKECreateLaunchSpec(oceanGKECreateLaunchSpecRes).build();

        System.out.println(updateRequest.toJson());

        // Update the launch spec
        Boolean updateSuccess = client.updateOceanGKELaunchSpec(updateRequest,launchSpecId);

        if(updateSuccess){
            System.out.println("launch spec updated successfully");
        }
    }

    private static void deleteALaunchSpec(SpotInstOceanGKELaunchSpecClient client, String launchSpecId) {

        // Delete a launch spec
        Boolean successfulDeletion = client.deleteALaunchSpec(launchSpecId);
        if (successfulDeletion) {
            System.out.println("Launch Spec with id:" + launchSpecId+" deleted successfully");
        }
    }
}
