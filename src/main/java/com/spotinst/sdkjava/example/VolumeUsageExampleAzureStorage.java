package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.spotStorage.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VolumeUsageExampleAzureStorage {

    //    TODO yael: we talked about it
    private final static String auth_token          = "";
    private final static String account_id          = "act-e929c6e7";

    public static void main(String[] args) throws IOException {

        // Get volume service client
        SpotStorageAzureVolumeClient volumeClient = SpotinstClient.getVolumeClient(auth_token, account_id);

        // Create volume
//        TODO yael: return the object here, and then get its ID
        String volumeId = createVolume(volumeClient);

        // Sleep for provisioning
        System.out.println("\nSleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // Get volume
        VolumeAzureStorage volume     = getVolume(volumeClient, volumeId);
        String             volumeName = volume.getName();
        String             preFormat  = "volumeId: %s - volumeName: %s";
        System.out.println(String.format(preFormat, volumeId, volumeName));

        // Sleep for provisioning
        System.out.println("\nSleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // List all Volumes
        getAllVolumes(volumeClient);

        // Delete volume
        deleteVolume(volumeClient, volumeId);

//        TODO yael: add updateVolume Example
    }

    private static String createVolume(SpotStorageAzureVolumeClient client) {
        System.out.println("-------------------------start creating volume------------------------");

        //build Auto Resize Resize Policy Action
        VolumeAutoResizeResizePolicyAction.Builder VolumeAutoResizeResizePolicyActionBuilder =
                VolumeAutoResizeResizePolicyAction.Builder.get();

        VolumeAutoResizeResizePolicyAction autoResizeResizePolicyAction =
                VolumeAutoResizeResizePolicyActionBuilder.setType("increase").setAdjustmentPercentage(1).build();

        //build Auto Resize Resize Policy
        VolumeAutoResizeResizePolicy.Builder VolumeAutoResizeResizePolicyBuilder =
                VolumeAutoResizeResizePolicy.Builder.get();

        VolumeAutoResizeResizePolicy autoResizeResizePolicy =
                VolumeAutoResizeResizePolicyBuilder.setAction(autoResizeResizePolicyAction).setConsecutivePeriods(1)
                                                   .setCooldown(300).setOperator("gt").setPeriod(300)
                                                   .setUsagePercentage(1).setPolicyName("policyName").build();

        List<VolumeAutoResizeResizePolicy> autoResizeResizePolicyList = new ArrayList<>();
        autoResizeResizePolicyList.add(autoResizeResizePolicy);

        //build Auto Resize
        VolumeAutoResize.Builder VolumeAutoResizeBuilder = VolumeAutoResize.Builder.get();

        VolumeAutoResize autoResize = VolumeAutoResizeBuilder.setPolicyType("custom").setMode("recommendation")
                                                             .setResizePolicies(autoResizeResizePolicyList).build();

        //build Tag
        VolumeTag.Builder VolumeTagBuilder = VolumeTag.Builder.get();

        VolumeTag tag = VolumeTagBuilder.setTagKey("tagKey1").setTagValue("tagValue1").build();

        List<VolumeTag> tagList = new ArrayList<>();
        tagList.add(tag);

        //build Spec Network
        VolumeSpecNetwork.Builder VolumeSpecNetworkBuilder = VolumeSpecNetwork.Builder.get();

        VolumeSpecNetwork specNetwork = VolumeSpecNetworkBuilder.setVirtualNetworkName("AutomationResourceGroup-vnet")
                                                                .setResourceGroupName("AutomationResourceGroup")
                                                                .setSubnetName("storage_subnet").build();
//        TODO yael: don't keep commented code.
/*
        //build Spec Protocol Export Policy Rule
        VolumeSpecProtocolExportPolicyRule.Builder VolumeSpecProtocolExportPolicyRuleBuilder =
                VolumeSpecProtocolExportPolicyRule.Builder.get();

        List<String> KerberosRuleAccessesList = new ArrayList<>();
        KerberosRuleAccessesList.add("string-example");

        VolumeSpecProtocolExportPolicyRule specProtocolExportPolicyRule =
                VolumeSpecProtocolExportPolicyRuleBuilder.setKerberosRuleAccesses(KerberosRuleAccessesList)
                                                         .setAccess("string-example")
                                                         .setAllowedClients("string-example").setIndex(1).setRoot(true)
                                                         .build();

        List<VolumeSpecProtocolExportPolicyRule> specProtocolExportPolicyRuleList = new ArrayList<>();
        specProtocolExportPolicyRuleList.add(specProtocolExportPolicyRule);

        //build Spec Protocol Export Policy
        VolumeSpecProtocolExportPolicy.Builder VolumeSpecProtocolExportPolicyBuilder =
                VolumeSpecProtocolExportPolicy.Builder.get();

        VolumeSpecProtocolExportPolicy specProtocolExportPolicy =
                VolumeSpecProtocolExportPolicyBuilder.setRules(specProtocolExportPolicyRuleList).build();
*/
        //build Spec Protocol
        VolumeSpecProtocol.Builder VolumeSpecProtocolBuilder = VolumeSpecProtocol.Builder.get();

        List<String> typesList = new ArrayList<>();
        typesList.add("NFSv3");

        VolumeSpecProtocol specProtocol =
                VolumeSpecProtocolBuilder.setTypes(typesList)
                        //.setExportPolicy(specProtocolExportPolicy)
                                        // .setKerberosEnabled(true).setSecurityStyle("securityStyle")
                                         .setMountPath("mountPath25").build();


        //build Spec
        VolumeSpec.Builder VolumeSpecBuilder = VolumeSpec.Builder.get();

        VolumeSpec spec =
                VolumeSpecBuilder.setNetwork(specNetwork).setProtocol(specProtocol).setServiceLevel("premium")
                                 .setTags(tagList).build();

        //build Capacity
        VolumeCapacity.Builder VolumeCapacityBuilder = VolumeCapacity.Builder.get();

        VolumeCapacity capacity = VolumeCapacityBuilder.setSizeGiB(100).setMinSizeGiB(100).setMaxSizeGiB(100).build();

        //build Throughput
        VolumeThroughput.Builder VolumeThroughputBuilder = VolumeThroughput.Builder.get();

        VolumeThroughput throughput = VolumeThroughputBuilder.setThroughputMibps(1.).build();

        //build volume
        VolumeAzureStorage.Builder VolumeAzureStorageBuilder = VolumeAzureStorage.Builder.get();

        VolumeAzureStorage volume =
                VolumeAzureStorageBuilder.setVolumeSpec(spec).setAutoResize(autoResize).setCapacity(capacity)
                                         .setName("volumeName5").setRegion("eastus")
                                         //.setState("state")
                                         .setThroughput(throughput).build();

        // Build volume creation request
        AzureStorageVolumeCreationRequest.Builder AzureStorageVolumeCreationRequestBuilder =
                AzureStorageVolumeCreationRequest.Builder.get();

        AzureStorageVolumeCreationRequest creationRequest =
                AzureStorageVolumeCreationRequestBuilder.setVolume(volume).build();

        // Convert volume to API object json
        System.out.println(creationRequest.toJson());
        // Create volume

        VolumeAzureStorage createdVolume = client.createVolume(creationRequest);
        System.out.println("Volume successfully created: " + createdVolume.getId());

        // Get volume Id
        return createdVolume.getId();
    }

    private static void deleteVolume(SpotStorageAzureVolumeClient client, String volumeId) {
        System.out.println("-------------------------start deleting volume------------------------");

        VolumeDeletionRequest.Builder deletionBuilder = VolumeDeletionRequest.Builder.get();
        VolumeDeletionRequest         deletionRequest = deletionBuilder.setVolumeId(volumeId).build();

        Boolean successfulDeletion = client.deleteVolume(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Volume succesfully deleted: " + volumeId);
        }

    }

    private static List<VolumeAzureStorage> getAllVolumes(SpotStorageAzureVolumeClient client) {
        System.out.println("-------------------------start getting all volumes------------------------");

        return client.getAllVolumes();

    }

    private static VolumeAzureStorage getVolume(SpotStorageAzureVolumeClient client, String volumeId) {
        System.out.println("-------------------------start getting volume------------------------");

        VolumeGetRequest.Builder requestBuilder = VolumeGetRequest.Builder.get();
        VolumeGetRequest         requestById    = requestBuilder.setVolumeId(volumeId).build();
        VolumeAzureStorage       volume         = client.getVolume(requestById);

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



