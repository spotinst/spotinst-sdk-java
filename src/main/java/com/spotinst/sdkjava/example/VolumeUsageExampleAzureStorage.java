package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.spotStorage.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VolumeUsageExampleAzureStorage {

    private final static String auth_token  = "";
    private final static String account_id  = "";
    private static final String VOLUME_NAME = "spot-volume-name";
    private static final String MOUNT_PATH  = "mountPath";

    public static void main(String[] args) throws IOException {

        // Get volume service client
        SpotStorageAzureVolumeClient volumeClient = SpotinstClient.getVolumeClient(auth_token, account_id);

        // Create volume
        AzureStorageVolume newVolume = createVolume(volumeClient);
        String volumeId = newVolume.getId();

        // Sleep for provisioning
        System.out.println("\nSleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // Get volume
        AzureStorageVolume volume     = getVolume(volumeClient, volumeId);
        String             volumeName = volume.getName();
        String             preFormat  = "volumeId: %s - volumeName: %s";
        System.out.println(String.format(preFormat, volumeId, volumeName));

        // Sleep for provisioning
        System.out.println("\nSleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // List all Volumes
        getAllVolumes(volumeClient);

        // Sleep for provisioning
        System.out.println("\nSleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // Update volume
        updateVolume(volumeClient, volumeId);

        // Sleep for provisioning
        System.out.println("\nSleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // Delete volume
        deleteVolume(volumeClient, volumeId);

    }


    private static AzureStorageVolume createVolume(SpotStorageAzureVolumeClient client) {
        System.out.println("-------------------------start creating volume------------------------");

        //build Auto Resize Resize Policy Action
        AzureStorageVolumeAutoResizeResizePolicyAction.Builder VolumeAutoResizeResizePolicyActionBuilder =
                AzureStorageVolumeAutoResizeResizePolicyAction.Builder.get();

        AzureStorageVolumeAutoResizeResizePolicyAction autoResizeResizePolicyAction =
                VolumeAutoResizeResizePolicyActionBuilder.setType("increase").setAdjustmentPercentage(1).build();

        //build Auto Resize Resize Policy
        AzureStorageVolumeAutoResizeResizePolicy.Builder VolumeAutoResizeResizePolicyBuilder =
                AzureStorageVolumeAutoResizeResizePolicy.Builder.get();

        AzureStorageVolumeAutoResizeResizePolicy autoResizeResizePolicy =
                VolumeAutoResizeResizePolicyBuilder.setAction(autoResizeResizePolicyAction).setConsecutivePeriods(1)
                                                   .setCooldown(300).setOperator("gt").setPeriod(300)
                                                   .setUsagePercentage(1).setPolicyName("policyName").build();

        List<AzureStorageVolumeAutoResizeResizePolicy> autoResizeResizePolicyList = new ArrayList<>();
        autoResizeResizePolicyList.add(autoResizeResizePolicy);

        //build Auto Resize
        AzureStorageVolumeAutoResize.Builder VolumeAutoResizeBuilder = AzureStorageVolumeAutoResize.Builder.get();

        AzureStorageVolumeAutoResize
                autoResize = VolumeAutoResizeBuilder.setPolicyType("custom").setMode("recommendation")
                                                    .setResizePolicies(autoResizeResizePolicyList).build();

        //build Tag
        AzureStorageVolumeTag.Builder VolumeTagBuilder = AzureStorageVolumeTag.Builder.get();

        AzureStorageVolumeTag tag = VolumeTagBuilder.setTagKey("tagKey1").setTagValue("tagValue1").build();

        List<AzureStorageVolumeTag> tagList = new ArrayList<>();
        tagList.add(tag);

        //build Spec Network
        AzureStorageVolumeSpecNetwork.Builder VolumeSpecNetworkBuilder = AzureStorageVolumeSpecNetwork.Builder.get();

        AzureStorageVolumeSpecNetwork
                specNetwork = VolumeSpecNetworkBuilder.setVirtualNetworkName("AutomationResourceGroup-vnet")
                                                      .setResourceGroupName("AutomationResourceGroup")
                                                      .setSubnetName("storage_subnet").build();

        AzureStorageVolumeSpecProtocol.Builder VolumeSpecProtocolBuilder = AzureStorageVolumeSpecProtocol.Builder.get();

        List<String> typesList = new ArrayList<>();
        typesList.add("NFSv3");

        AzureStorageVolumeSpecProtocol specProtocol =
                VolumeSpecProtocolBuilder.setTypes(typesList)
                        //.setExportPolicy(specProtocolExportPolicy)
                                        // .setKerberosEnabled(true).setSecurityStyle("securityStyle")
                                         .setMountPath(MOUNT_PATH).build();


        //build Spec
        AzureStorageVolumeSpec.Builder VolumeSpecBuilder = AzureStorageVolumeSpec.Builder.get();

        AzureStorageVolumeSpec spec =
                VolumeSpecBuilder.setNetwork(specNetwork).setProtocol(specProtocol).setServiceLevel("premium")
                                 .setTags(tagList).build();

        //build Capacity
        AzureStorageVolumeCapacity.Builder VolumeCapacityBuilder = AzureStorageVolumeCapacity.Builder.get();

        AzureStorageVolumeCapacity
                capacity = VolumeCapacityBuilder.setSizeGiB(100).setMinSizeGiB(100).setMaxSizeGiB(100).build();

        //build Throughput
        AzureStorageVolumeThroughput.Builder VolumeThroughputBuilder = AzureStorageVolumeThroughput.Builder.get();

        AzureStorageVolumeThroughput throughput = VolumeThroughputBuilder.setThroughputMibps(1.).build();

        //build volume
        AzureStorageVolume.Builder VolumeAzureStorageBuilder = AzureStorageVolume.Builder.get();

        AzureStorageVolume volume =
                VolumeAzureStorageBuilder.setVolumeSpec(spec).setAutoResize(autoResize).setCapacity(capacity)
                                         .setName(VOLUME_NAME).setRegion("eastus")
                                         .setThroughput(throughput).build();

        // Build volume creation request
        AzureStorageVolumeCreationRequest.Builder AzureStorageVolumeCreationRequestBuilder =
                AzureStorageVolumeCreationRequest.Builder.get();

        AzureStorageVolumeCreationRequest creationRequest =
                AzureStorageVolumeCreationRequestBuilder.setVolume(volume).build();

        // Convert volume to API object json
        System.out.println(creationRequest.toJson());
        // Create volume

        AzureStorageVolume createdVolume = client.createVolume(creationRequest);
        System.out.println("Volume successfully created: " + createdVolume.getId());

        // Get volume
        return createdVolume;
    }

    private static void updateVolume(SpotStorageAzureVolumeClient client, String volumeId) {
        System.out.println("-------------------------start updating volume------------------------");

        //build Capacity
        AzureStorageVolumeCapacity.Builder VolumeCapacityBuilder = AzureStorageVolumeCapacity.Builder.get();

        AzureStorageVolumeCapacity updateCapacity =
                VolumeCapacityBuilder.setSizeGiB(101).setMinSizeGiB(101).setMaxSizeGiB(101).build();

        //build Throughput
        AzureStorageVolumeThroughput.Builder VolumeThroughputBuilder = AzureStorageVolumeThroughput.Builder.get();

        AzureStorageVolumeThroughput updateThroughput = VolumeThroughputBuilder.setThroughputMibps(1.5).build();

        // Build volume update
        AzureStorageVolume.Builder updateVolumeBuilder = AzureStorageVolume.Builder.get();
        AzureStorageVolume volumeUpdate =
                updateVolumeBuilder.setCapacity(updateCapacity).setThroughput(updateThroughput)
                                   //.setName(VOLUME_NAME)
                                        .build();

        // Build volume update request
        VolumeUpdateRequest.Builder volumeUpdateRequestBuilder =
                VolumeUpdateRequest.Builder.get();
        VolumeUpdateRequest updateRequest =
                volumeUpdateRequestBuilder.setVolume(volumeUpdate).build();

        // Convert volume update to API object json
        System.out.println(updateRequest.toJson());

        // Update volume
        Boolean updateSuccess = client.updateVolume(updateRequest, volumeId);
        if (updateSuccess) {
            System.out.println("Volume successfully updated.\n");
        }

    }

    private static void deleteVolume(SpotStorageAzureVolumeClient client, String volumeId) {

        System.out.println("-------------------------start deleting volume------------------------");

        AzureStorageVolumeDeletionRequest.Builder deletionBuilder = AzureStorageVolumeDeletionRequest.Builder.get();
        AzureStorageVolumeDeletionRequest         deletionRequest = deletionBuilder.setVolumeId(volumeId).build();

        Boolean successfulDeletion = client.deleteVolume(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Volume succesfully deleted: " + volumeId);
        }
    }

    private static List<AzureStorageVolume> getAllVolumes(SpotStorageAzureVolumeClient client) {
        System.out.println("-------------------------start getting all volumes------------------------");

        return client.getAllVolumes();

    }

    private static AzureStorageVolume getVolume(SpotStorageAzureVolumeClient client, String volumeId) {
        System.out.println("-------------------------start getting volume------------------------");

        VolumeGetRequest.Builder requestBuilder = VolumeGetRequest.Builder.get();
        VolumeGetRequest         requestById    = requestBuilder.setVolumeId(volumeId).build();
        AzureStorageVolume       volume         = client.getVolume(requestById);

        return volume;

    }

    private static void sleep(Integer seconds) {
        for (Integer i = 0; i < seconds; i++) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((i % 5) == 0 && i > 0) {
                System.out.println(i + " seconds have passed.\n");
            }
        }

    }
}



