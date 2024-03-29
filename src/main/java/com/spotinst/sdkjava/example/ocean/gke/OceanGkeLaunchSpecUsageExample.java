package com.spotinst.sdkjava.example.ocean.gke;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.OceanGkeLaunchSpecRootVolumeTypeEnum;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.ocean.gke.*;
import com.spotinst.sdkjava.model.requests.ocean.gke.LaunchSpecRequest;

import java.io.IOException;
import java.util.*;

public class OceanGkeLaunchSpecUsageExample {

    private final static String auth_token    = "auth token";
    private final static String account_id    = "act-id";

    public static void main(String[] args) throws IOException {

        // Create a Launch Spec
        System.out.println("--------------Create two launch specs----------------------");
        SpotOceanGkeClusterClient spotOceanGkeClusterClient =
                SpotinstClient.getSpotOceanGkeLaunchSpecClient(auth_token, account_id);
        String launchSpecId1 = createLaunchSpec(spotOceanGkeClusterClient, "Test_LaunchSpec1");
        String launchSpecId2 = createLaunchSpec(spotOceanGkeClusterClient, "Test_LaunchSpec2");

        if (launchSpecId1 == null || launchSpecId2 == null) {
            System.out.println("Failed to create Launch spec so exiting from the script");
            System.exit(0);
        }


        // Get created launch spec
        System.out.println("--------------Get a launch spec----------------------");
        LaunchSpecSpecification res = getLaunchSpec(spotOceanGkeClusterClient, launchSpecId1);
        if (res != null) {
            System.out.println("Launch Spec ID: " + launchSpecId1);
        }
        else {
            System.out.println("Failed to get launch specification details with id: "+launchSpecId1+"  so exiting from the script");
            System.exit(0);
        }

        // Get created all launch specs
        System.out.println("--------------Get all launch specs----------------------");
        List<LaunchSpecSpecification> allLaunchSpecs = getAllLaunchSpecs(spotOceanGkeClusterClient);
        if(allLaunchSpecs.size() > 0){
            for (LaunchSpecSpecification launchSpec : allLaunchSpecs) {
                System.out.println("Below are the launch specs details");
                System.out.println("LaunchSpec Id: " + launchSpec.getId() + "and Launch Spec Name: " +
                        launchSpec.getName());
            }
        }else{
            System.out.println("Failed to get all launch specs so exiting from the script");
            System.exit(0);
        }

        // Updates a launch spec
        System.out.println("--------------Update a launch spec----------------------");
        updateLaunchSpec(spotOceanGkeClusterClient, launchSpecId1, "Update_Test_LaunchSpec4");
        System.out.println("New name after update : "+getLaunchSpec(spotOceanGkeClusterClient, launchSpecId1).getName());

        // Delete a launch spec
        System.out.println("--------------Delete a launch spec----------------------");
        deleteLaunchSpec(spotOceanGkeClusterClient, launchSpecId1);
        deleteLaunchSpec(spotOceanGkeClusterClient, launchSpecId2);
    }

    private static String  createLaunchSpec(SpotOceanGkeClusterClient client, String launchSpecName) {
        // Create request object to bind the request
        LaunchSpecRequest.Builder launchSpecRequest =
                LaunchSpecRequest.Builder.get();

        // Form a metadata request builder
        LaunchSpecMetadataSpecification.Builder builder = LaunchSpecMetadataSpecification.Builder.get();
        builder.setKey("Key1");
        builder.setValue("Value1");
        LaunchSpecMetadataSpecification       metadata         = builder.build();
        List<LaunchSpecMetadataSpecification> oceanGKEMetadata = new ArrayList<>();
        oceanGKEMetadata.add(metadata);

        // Form a instance type request builder
        List<String> instanceTypes = Arrays.asList("n1-standard-1","n1-standard-2");

        // Form a taints request builder
        List<LaunchSpecTaintsSpecification> taints = new ArrayList<>();
        LaunchSpecTaintsSpecification taintsBuilder = LaunchSpecTaintsSpecification.Builder.get().setKey("taintKey")
                                                                                           .setValue("taintValue")
                                                                                           .setEffect("NoSchedule").build();
        taints.add(taintsBuilder);


        // Form a labels request builder
        List<LaunchSpecLabelsSpecification> labels         = new ArrayList<>();
        LaunchSpecLabelsSpecification       oceanGKELabels = LaunchSpecLabelsSpecification.Builder.get().setKey("env").setValue("test").build();
        labels.add(oceanGKELabels);

        List<LaunchSpecHeadroomsSpecification> headRoomsList = new ArrayList<>();
        LaunchSpecHeadroomsSpecification
                oceanGKEHeadRooms = LaunchSpecHeadroomsSpecification.Builder.get().setCpuPerUnit(1000)
                                                                            .setGpuPerUnit(0)
                                                                            .setMemoryPerUnit(2048)
                                                                            .setNumOfUnits(3).build();
        headRoomsList.add(oceanGKEHeadRooms);
        LaunchSpecAutoScaleSpecification
                autoScale = LaunchSpecAutoScaleSpecification.Builder.get().setHeadrooms(headRoomsList).build();


        // Form a resource limits request builder
        LaunchSpecResourceLimitsSpecification
                resourceLimits = LaunchSpecResourceLimitsSpecification.Builder.get().setMaxInstanceCount(5).setMinInstanceCount(1).build();

        // Form a shield instance config request builder
        LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig = LaunchSpecShieldedInstanceConfigSpecification.Builder.get().setEnableSecureBoot(true).setEnableIntegrityMonitoring(true).build();

        // Form a strategy request builder
        LaunchSpecStrategySpecification
                strategy = LaunchSpecStrategySpecification.Builder.get().setPreemptiblePercentage(80).build();

        // Form a storage request builder
        LaunchSpecStorageSpecification
                storage = LaunchSpecStorageSpecification.Builder.get().setLocalSsdCount(2).build();

        // Build Ocean GKE launch spec
        LaunchSpecSpecification.Builder oceanGKECreateLaunchSpecResBuilder = LaunchSpecSpecification.Builder.get();
        LaunchSpecSpecification
                oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecResBuilder.setOceanId("<OceanID>")
                                                                                .setRestrictScaleDown(false)
                                                                                .setServiceAccount("serviceAccount")
                                                                                .setRootVolumeType(
                                                                                        OceanGkeLaunchSpecRootVolumeTypeEnum.PD_STANDARD)
                                                                                .setRootVolumeSizeInGb(100)
                                                                                .setName(launchSpecName)
                                                                                .setSourceImage("https://www.googleapis.com/compute/v1/projects/gke-node-images/global/images/container-v1-3-v20160517")
                                                                                .setInstanceTypes(instanceTypes)
                                                                                .setTaints(taints)
                                                                                .setLabels(labels)
                                                                                .setAutoScale(autoScale)
                                                                                .setResourceLimits(resourceLimits)
                                                                                .setShieldedInstanceConfig(shieldedInstanceConfig)
                                                                                .setStrategy(strategy)
                                                                                .setStorage(storage)
                                                                                .setMetadata(oceanGKEMetadata).build();
        LaunchSpecRequest creationRequest=
                launchSpecRequest.setOceanGKELaunchSpec(oceanGKECreateLaunchSpecRes).build();

        // Convert launch spec to API object json
        System.out.println(creationRequest.toJson());

        //create launch spec
        LaunchSpecSpecification oceanGKECreateLaunchSpec = client.createLaunchSpec(creationRequest);
        System.out.println("GKE Launch Spec successfully created: " + oceanGKECreateLaunchSpec.getName());

        return oceanGKECreateLaunchSpec.getId();

    }

    private static List<LaunchSpecSpecification> getAllLaunchSpecs(SpotOceanGkeClusterClient client) {

        return client.getAllLaunchSpec("<OceanId>");

    }
    private static LaunchSpecSpecification getLaunchSpec(SpotOceanGkeClusterClient client, String LaunchSpecId){

        //Get a launch spec
        LaunchSpecRequest.Builder getBuilder = LaunchSpecRequest.Builder.get();
        LaunchSpecRequest getRequest = getBuilder.setLaunchSpecId(LaunchSpecId).build();

        LaunchSpecSpecification launchSpec = client.getLaunchSpec(getRequest);

        if (launchSpec!=null) {
            System.out.println("Get Cluster successfully: " + launchSpec.getId());
        }
        return launchSpec;
    }

    private static void updateLaunchSpec(SpotOceanGkeClusterClient client, String launchSpecId, String newName){

        // Create launch spec request object
        LaunchSpecRequest.Builder oceanGKEUpdateLaunchSpecRequest =
                LaunchSpecRequest.Builder.get();

        // Form metadata builder to update
        LaunchSpecMetadataSpecification.Builder builder = LaunchSpecMetadataSpecification.Builder.get();
        builder.setKey("UKey1");
        builder.setValue("UValue1");
        LaunchSpecMetadataSpecification       metadata          = builder.build();
        List<LaunchSpecMetadataSpecification> oceanGKEMetadatas = new ArrayList<>();
        oceanGKEMetadatas.add(metadata);


        // Form taints builder to update
        List<LaunchSpecTaintsSpecification> taints = new ArrayList<>();
        LaunchSpecTaintsSpecification taintsBuilder = LaunchSpecTaintsSpecification.Builder.get().setKey("UtaintKey")
                                                                                           .setValue("UtaintValue")
                                                                                           .setEffect("NoSchedule").build();
        taints.add(taintsBuilder);


        //Create launch spec object
        LaunchSpecSpecification.Builder oceanGKECreateLaunchSpecResBuilder = LaunchSpecSpecification.Builder.get();
        LaunchSpecSpecification oceanGKEUpdateLaunchSpecRes = oceanGKECreateLaunchSpecResBuilder.setName(newName)
                                                                                                .setTaints(taints)
                                                                                                .setMetadata(oceanGKEMetadatas).build();
        LaunchSpecRequest updateRequest=
                oceanGKEUpdateLaunchSpecRequest.setOceanGKELaunchSpec(oceanGKEUpdateLaunchSpecRes).build();

        System.out.println(updateRequest.toJson());

        // Update the launch spec
        Boolean updateSuccess = client.updateLaunchSpec(updateRequest, launchSpecId);

        if(updateSuccess){
            System.out.println("launch spec updated successfully");
        }
    }

    private static void deleteLaunchSpec(SpotOceanGkeClusterClient client, String launchSpecId) {

        // Delete a launch spec

        LaunchSpecRequest.Builder deleteBuilder       = LaunchSpecRequest.Builder.get();
        LaunchSpecRequest         deleteRequest       =
                deleteBuilder.setLaunchSpecId(launchSpecId).build();
        Boolean                                  isLaunchSpecDeleted = client.deleteALaunchSpec(deleteRequest);
        if (isLaunchSpecDeleted) {
            System.out.println("Launch Spec with id:" + launchSpecId+" deleted successfully");
        }
    }
}