package com.spotinst.sdkjava.example.ocean.aks;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.AzureAksVngClient;
import com.spotinst.sdkjava.model.bl.ocean.aks.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OceanAzureAksVNGUsageExample {
    private final static String auth_token = "auth_token";
    private final static String accountId  = "account_id";

    private final static String       oceanId                    = "o-4abcd";
    private final static Integer      maxInstanceCount           = 5;
    private final static Integer      sizeGB                     = 30;
    private final static String      type                        = "Standard_LRS";
    private final static Boolean     utilizeEphemeralStorage     = true;
    private final static List<String>  vmSizes                   = Arrays.asList("standard_ds2_v2", "standard_d2s_v4");
    private final static List<String>  zones                     = Arrays.asList("1", "2");

    public static void main(String[] args) {
        AzureAksVngClient vngClient = SpotinstClient.getAksVngClient(auth_token, accountId);

        String vngId = createAksVng(vngClient);
        getAksVng(vngClient,vngId);
        listAksVng(vngClient, oceanId);
        updateAksVng(vngClient,vngId);
        deleteAksVng(vngClient,vngId);

        //Launch Nodes in VNG
        System.out.println("----------Launch Nodes in VNG--------------");
        List<LaunchNodesInAksVNGResponse> nodesResponse = launchNodesInVNG(vngClient, 2, "launchSpecId");
    }

    private static String createAksVng(AzureAksVngClient client) {
        System.out.println("-------------------------start creating ocean virtual node group------------------------");

        //Build autoscale specification
        ClusterVngAutoScaleSpec.Builder autoScaleBuilder = ClusterVngAutoScaleSpec.Builder.get();
        ClusterVngAutoScaleSpec         autoScale        = autoScaleBuilder.setAutoHeadroomPercentage(20).build();

        //Build tags
        ClusterTagAks.Builder tagsBuilder = ClusterTagAks.Builder.get();

        ClusterTagAks       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingSdkOcean").build();
        List<ClusterTagAks> tagsList = Collections.singletonList(tag1);

        ClusterVngResourceLimits.Builder recourceLimitsbuilder =
                ClusterVngResourceLimits.Builder.get();
        ClusterVngResourceLimits recourceLimitsSpec =
                recourceLimitsbuilder.setMaxInstanceCount(maxInstanceCount).build();

        ClusterVngOsDisk.Builder builder = ClusterVngOsDisk.Builder.get();
        ClusterVngOsDisk osDisk = builder.setSizeGB(sizeGB).setType(type).setUtilizeEphemeralStorage(utilizeEphemeralStorage).build();

        ClusterVngLaunchSpecificaion.Builder launchSpecBuilder = ClusterVngLaunchSpecificaion.Builder.get();

        if (tagsList != null) {
            launchSpecBuilder.setTags(tagsList);
        }
        if (osDisk != null) {
            launchSpecBuilder.setOsDisk(osDisk);
        }

        ClusterVngLaunchSpecificaion launchSpec = launchSpecBuilder.build();

        //Build labels
        ClusterVngLabel.Builder labelsBuilder = ClusterVngLabel.Builder.get();
        List<ClusterVngLabel> labelsList = new LinkedList<>();
        ClusterVngLabel         label1        = labelsBuilder.setKey("Group ").setValue("Platform").build();
        labelsList.add(label1);
        ClusterVngLabel label2     = labelsBuilder.setKey("Service ").setValue("Frontend").build();
        labelsList.add(label2);

        //Build taints
        ClusterVngTaints.Builder taintsBuilder = ClusterVngTaints.Builder.get();
        List<ClusterVngTaints> taintsList = new LinkedList<>();
        ClusterVngTaints         taints        = taintsBuilder.setKey("Creator").setValue("test").setEffect("NoSchedule").build();
        taintsList.add(taints);

        //Build Virtual Node Group
        ClusterVirtualNodeGroup.Builder vngBuilder = ClusterVirtualNodeGroup.Builder.get();

        ClusterVirtualNodeGroup vngSpec = vngBuilder.setOceanId(oceanId).setName("TestVNG").setLabels(labelsList).setTaints(taintsList)
                                             .setResourceLimits(recourceLimitsSpec).setVmSizes(vmSizes).setZones(zones).setAutoScale(autoScale).setLaunchSpecification(launchSpec).build();

        //Create virtual node group
        ClusterVirtualNodeGroup createdK8sVng = client.createAksVng(vngSpec);
        System.out.println("Virtual Node Group Created Successfully: " + createdK8sVng.getId());

        return createdK8sVng.getId();
    }

    private static ClusterVirtualNodeGroup getAksVng(AzureAksVngClient client, String vngId){
        System.out.println("-------------------------start getting ocean virtual node group------------------------");

        ClusterVirtualNodeGroup k8sVng = client.getAksVng(vngId);
        if (k8sVng != null) {
            System.out.println("Get Virtual Node Group Successfully: " + k8sVng.getId());
        }
        return k8sVng;
    }

    private static List<ClusterVirtualNodeGroup> listAksVng (AzureAksVngClient client, String oceanId) {
        System.out.println("-------------------------start listing ocean virtual node group------------------------");

        List<ClusterVirtualNodeGroup> k8sVng = client.listAksVng(oceanId);

        if (k8sVng.size() > 0) {
            for (ClusterVirtualNodeGroup spec : k8sVng) {
                System.out.println("List Virtual Node Group Successfully: " + spec.getName());
            }
        }

        return k8sVng;
    }

    private static void updateAksVng(AzureAksVngClient client, String vngId) {
        System.out.println("-------------------------start updating ocean virtual node group------------------------");

        //Build autoscale specification
        ClusterVngAutoScaleSpec.Builder autoScaleBuilder = ClusterVngAutoScaleSpec.Builder.get();
        ClusterVngAutoScaleSpec         autoScale        = autoScaleBuilder.setAutoHeadroomPercentage(30).build();

        //Build tags
        ClusterTagAks.Builder tagsBuilder = ClusterTagAks.Builder.get();

        ClusterTagAks       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingUpdateSdkOcean").build();
        List<ClusterTagAks> tagsList = Collections.singletonList(tag1);

        ClusterVngResourceLimits.Builder recourceLimitsbuilder =
                ClusterVngResourceLimits.Builder.get();
        ClusterVngResourceLimits recourceLimitsSpec =
                recourceLimitsbuilder.setMaxInstanceCount(10).build();

        ClusterVngOsDisk.Builder builder = ClusterVngOsDisk.Builder.get();
        ClusterVngOsDisk osDisk = builder.setSizeGB(2).setUtilizeEphemeralStorage(false).build();

        ClusterVngLaunchSpecificaion.Builder launchSpecBuilder = ClusterVngLaunchSpecificaion.Builder.get();

        if (tagsList != null) {
            launchSpecBuilder.setTags(tagsList);
        }
        if (osDisk != null) {
            launchSpecBuilder.setOsDisk(osDisk);
        }

        ClusterVngLaunchSpecificaion launchSpec = launchSpecBuilder.build();

        //Build labels
        ClusterVngLabel.Builder labelsBuilder = ClusterVngLabel.Builder.get();
        List<ClusterVngLabel> labelsList = new LinkedList<>();
        ClusterVngLabel         label1        = labelsBuilder.setKey("Group ").setValue("Platform").build();
        labelsList.add(label1);
        ClusterVngLabel label2     = labelsBuilder.setKey("Service ").setValue("Frontend").build();
        labelsList.add(label2);

        //Build taints
        ClusterVngTaints.Builder taintsBuilder = ClusterVngTaints.Builder.get();
        List<ClusterVngTaints> taintsList = new LinkedList<>();
        ClusterVngTaints         taints        = taintsBuilder.setKey("Creator").setValue("test").setEffect("NoSchedule").build();
        taintsList.add(taints);

        //Build Virtual Node Group
        ClusterVirtualNodeGroup.Builder vngBuilder = ClusterVirtualNodeGroup.Builder.get();

        ClusterVirtualNodeGroup vngSpec = vngBuilder.setOceanId(oceanId).setName("TestVNG").setLabels(labelsList).setTaints(taintsList)
                .setResourceLimits(recourceLimitsSpec).setVmSizes(vmSizes).setZones(zones).setAutoScale(autoScale).setLaunchSpecification(launchSpec).build();

        Boolean successUpdate = client.updateAKSVng(vngId, vngSpec);

        if (successUpdate) {
            System.out.println("Virtual Node Group Updated Successfully: " + vngId);
        }
    }

    private static void deleteAksVng(AzureAksVngClient client, String vngId) {
        System.out.println("-------------------------start deleting ocean virtual node group------------------------");

        Boolean successfulDeletion = client.deleteAksVng(vngId);

        if (successfulDeletion) {
            System.out.println("Virtual Node Group Deleted Successfully: " + vngId);
        }
    }

    private static List<LaunchNodesInAksVNGResponse> launchNodesInVNG(AzureAksVngClient client, Integer count, String launchSpecId) {
        System.out.println("-------------------------Launch Cluster Nodes------------------------");

        LaunchNodesInAksVNG.Builder getNodesBuilder = LaunchNodesInAksVNG.Builder.get();
        LaunchNodesInAksVNG launchNodes = getNodesBuilder.setAmount(count).build();
        List<LaunchNodesInAksVNGResponse> nodesResponse = client.launchNodesInVNG(launchNodes, launchSpecId);

        for (LaunchNodesInAksVNGResponse node : nodesResponse) {
            for (VmsDetails instances : node.getVms()) {
                System.out.println(String.format("VM Name: %s", instances.getVmName()));
                System.out.println(String.format("VM Size: %s", instances.getVmSize()));
                System.out.println(String.format("VM Lifecycle: %s", instances.getLifeCycle()));
            }
        }
        return nodesResponse;
    }
}
