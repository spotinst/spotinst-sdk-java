package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.SpotOceanEcsClusterClient;
import com.spotinst.sdkjava.model.bl.ocean.ecs.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OceanEcsLaunchSpecExample {
    private final static String       auth_token     = "auth_token";
    private final static String       act_id         = "act_id";
    private final static String       ocean_id       = "ocean_id";
    private final static String       image_id       = "image_id";
    private final static List<String> subnetIds      = Arrays.asList("subnet-1");
    private final static List<String> securityGroups = Arrays.asList("sg-1");

    public static void main(String[] args) {
        SpotOceanEcsClusterClient clusterClient = SpotinstClient.getOceanEcsClusterClient(auth_token, act_id);

        System.out.println("----------Creation of launch specs--------------");
        String launchSpecId = createLaunchSpec(clusterClient);

        System.out.println("----------Updation of launch specs--------------");
        Boolean isLaunchSpecUpdated = updateLaunchSpec(clusterClient, launchSpecId);

        System.out.println("----------Get launch specs--------------");
        ClusterLaunchSpecification launchSpec = getLaunchSpec(clusterClient, launchSpecId);
        System.out.println(String.format("Launch spec name for Id %s is %s", launchSpecId, launchSpec.getName()));

        System.out.println("----------List of launch specs--------------");
        List<ClusterLaunchSpecification> allLaunchSpec = ListLaunchSpec(clusterClient);

        for (ClusterLaunchSpecification launchSpecs : allLaunchSpec) {
            System.out.println(String.format("LaunchSpec Id: %s, LaunchSpec Name: %s", launchSpecs.getId(),
                                             launchSpecs.getName()));
        }

        System.out.println("----------Deletion of launch specs--------------");
        deleteLaunchSpec(clusterClient, launchSpecId);
    }

    private static String createLaunchSpec(SpotOceanEcsClusterClient client) {
        //Build Headrooms
        ClusterHeadroomsSpecification.Builder headroomBuilder = ClusterHeadroomsSpecification.Builder.get();
        ClusterHeadroomsSpecification headroom1 = headroomBuilder.setCpuPerUnit(1024)
                                                                 .setMemoryPerUnit(512)
                                                                 .setNumOfUnits(2).build();
        List<ClusterHeadroomsSpecification> headrooms = Collections.singletonList(headroom1);

        //Build autoscale specification
        ClusterAutoScaleSpecification.Builder autoScaleBuilder = ClusterAutoScaleSpecification.Builder.get();
        ClusterAutoScaleSpecification         autoScale        = autoScaleBuilder.setHeadrooms(headrooms).build();

        //Build array of attributes
        ClusterAttributes.Builder    attributesBuilder1 = ClusterAttributes.Builder.get();
        ClusterAttributes            attributes1        = attributesBuilder1.setKey("key1").setValue("value1").build();

        ClusterAttributes.Builder    attributesBuilder2 = ClusterAttributes.Builder.get();
        ClusterAttributes            attributes2        = attributesBuilder2.setKey("Key2").setValue("value2").build();

        ArrayList<ClusterAttributes> attributes         = new ArrayList<>();
        attributes.add(attributes1);
        attributes.add(attributes2);

        ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = ClusterIamInstanceProfileSpec.Builder.get();
        ClusterIamInstanceProfileSpec         iamInstanceProfile        =
                iamInstanceProfileBuilder.setArn("arn:aws:iam::abc1234").build();

        //Build tags
        ClusterTagsSepcification.Builder tagBuilder = ClusterTagsSepcification.Builder.get();
        ClusterTagsSepcification         tag1       = tagBuilder.setTagKey("Creator").setTagValue("Jack").build();
        List<ClusterTagsSepcification>   tags       = Collections.singletonList(tag1);

        //Build instance metadata options
        ClusterInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder =
                ClusterInstanceMetadataOptions.Builder.get();
        ClusterInstanceMetadataOptions         instanceMetadataOptions        =
                instanceMetadataOptionsBuilder.setHttpPutResponseHopLimit(12).setHttpTokens("optional").build();

        //Build dynamic volumesize mapping
        ClusterDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = ClusterDynamicVolumeSize.Builder.get();
        ClusterDynamicVolumeSize         dynamicVolumeSize        =
                dynamicVolumeSizeBuilder.setBaseSize(50).setResource("CPU").setSizePerResourceUnit(20).build();

        //Build ebs specification
        ClusterEbsSpecification.Builder ebsBuilder = ClusterEbsSpecification.Builder.get();
        ClusterEbsSpecification         ebs        = ebsBuilder.setThroughput(400)
                                                               .setDeleteOnTermination(false)
                                                               .setEncrypted(false)
                                                               .setIops(1)
                                                               .setKmsKeyId("alias/aws/ebs")
                                                               .setSnapshotId("snap-abc")
                                                               .setVolumeType("gp3")
                                                               .setDynamicVolumeSize(dynamicVolumeSize)
                                                               .build();

        //Build block device mappings
        ClusterBlockDeviceMappings.Builder blockDeviceBuilder1  = ClusterBlockDeviceMappings.Builder.get();
        ClusterBlockDeviceMappings         blockDeviceMappings1 = blockDeviceBuilder1.setDeviceName("/dev/xvda").setEbs(ebs).build();
        List<ClusterBlockDeviceMappings>   blockDeviceMappings  = Collections.singletonList(blockDeviceMappings1);

        // Build launch specification
        ClusterLaunchSpecification.Builder launchSpecBuilder = ClusterLaunchSpecification.Builder.get();
        ClusterLaunchSpecification launchSpec = launchSpecBuilder.setOceanId(ocean_id)
                                                                 .setName("myLaunchSpec")
                                                                 .setImageId(image_id)
                                                                 .setUserData("dXNlcmJhc2g2NGVuY29kZWQ=")
                                                                 .setSecurityGroupIds(securityGroups)
                                                                 .setSubnetIds(subnetIds)
                                                                 .setAttributes(attributes)
                                                                 .setAutoScale(autoScale)
                                                                 .setTags(tags)
                                                                 .setRestrictScaleDown(false)
                                                                 .setInstanceMetadataOptions(instanceMetadataOptions)
                                                                 .setIamInstanceProfile(iamInstanceProfile)
                                                                 .setBlockDeviceMappings(blockDeviceMappings)
                                                                 .build();

        OceanEcsClusterLaunchSpecRequest.Builder launchSpecCreationRequestBuilder =
                OceanEcsClusterLaunchSpecRequest.Builder.get();

        // Build launch specification creation request
        OceanEcsClusterLaunchSpecRequest launchSpecCreationRequest =
                launchSpecCreationRequestBuilder.setLaunchSpec(launchSpec).build();

        // Convert launch specification request to API object json
        System.out.println(launchSpecCreationRequest.toJson());

        // Create launch specification
        ClusterLaunchSpecification createdLaunchSpec = client.createLaunchSpec(launchSpecCreationRequest);
        String                     launchSpecId      = createdLaunchSpec.getId();
        System.out.println(String.format("Launch specification successfully created: %s", launchSpecId));

        return launchSpecId;
    }

    private static ClusterLaunchSpecification getLaunchSpec(SpotOceanEcsClusterClient client, String launchSpecId) {
        OceanEcsClusterLaunchSpecRequest.Builder getBuilder = OceanEcsClusterLaunchSpecRequest.Builder.get();
        OceanEcsClusterLaunchSpecRequest         getRequest = getBuilder.setOceanLaunchSpecId(launchSpecId).build();

        ClusterLaunchSpecification launchSpecification = client.getLaunchSpec(getRequest);

        if (launchSpecification != null) {
            System.out.println("Get launch specification successful: " + launchSpecification.getId());
        }
        return launchSpecification;
    }

    private static List<ClusterLaunchSpecification> ListLaunchSpec(SpotOceanEcsClusterClient client) {
        return client.getAllLaunchSpec();
    }

    private static Boolean deleteLaunchSpec(SpotOceanEcsClusterClient client, String launchSpecId) {
        OceanEcsClusterLaunchSpecRequest.Builder deleteBuilder       = OceanEcsClusterLaunchSpecRequest.Builder.get();
        OceanEcsClusterLaunchSpecRequest         deleteRequest       =
                deleteBuilder.setOceanLaunchSpecId(launchSpecId).build();
        Boolean                                  isLaunchSpecDeleted = client.deleteLaunchSpec(deleteRequest);

        if (isLaunchSpecDeleted) {
            System.out.println(String.format("Launch spec deleted successfully : %s", launchSpecId));
        }
        return isLaunchSpecDeleted;
    }

    private static Boolean updateLaunchSpec(SpotOceanEcsClusterClient client, String launchSpecId) {
        //Build Headrooms
        ClusterHeadroomsSpecification.Builder headroomBuilder = ClusterHeadroomsSpecification.Builder.get();
        ClusterHeadroomsSpecification headroom1 = headroomBuilder.setCpuPerUnit(512)
                                                                 .setMemoryPerUnit(1024)
                                                                 .setNumOfUnits(2)
                                                                 .build();
        List<ClusterHeadroomsSpecification> headrooms = Collections.singletonList(headroom1);

        //Build autoscale specification
        ClusterAutoScaleSpecification.Builder autoScaleBuilder = ClusterAutoScaleSpecification.Builder.get();
        ClusterAutoScaleSpecification         autoScale        = autoScaleBuilder.setHeadrooms(headrooms).build();

        //Build instance metadata options
        ClusterInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder =
                ClusterInstanceMetadataOptions.Builder.get();
        ClusterInstanceMetadataOptions         instanceMetadataOptions        =
                instanceMetadataOptionsBuilder.setHttpPutResponseHopLimit(12).setHttpTokens("optional").build();

        //Build dynamic volumesize mapping
        ClusterDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = ClusterDynamicVolumeSize.Builder.get();
        ClusterDynamicVolumeSize         dynamicVolumeSize        =
                dynamicVolumeSizeBuilder.setBaseSize(10).setResource("CPU").setSizePerResourceUnit(2).build();

        //Build ebs specification
        ClusterEbsSpecification.Builder ebsBuilder = ClusterEbsSpecification.Builder.get();
        ClusterEbsSpecification         ebs        = ebsBuilder.setThroughput(125)
                                                               .setDeleteOnTermination(false)
                                                               .setEncrypted(false)
                                                               .setIops(1)
                                                               .setKmsKeyId("alias/aws/ebs")
                                                               .setSnapshotId("snap-123")
                                                               .setVolumeType("gp2")
                                                               .setVolumeSize(0)
                                                               .setDynamicVolumeSize(dynamicVolumeSize)
                                                               .build();

        // Build launch specification
        ClusterLaunchSpecification.Builder launchSpecBuilder = ClusterLaunchSpecification.Builder.get();
        ClusterLaunchSpecification launchSpec = launchSpecBuilder.setName("TestSpec")
                                                                 .setImageId(image_id)
                                                                 .setUserData("dXNlcmJhc2g2NGVuY29kZWQ=")
                                                                 .setSecurityGroupIds(securityGroups)
                                                                 .setSubnetIds(subnetIds)
                                                                 .setAutoScale(autoScale)
                                                                 .setRestrictScaleDown(false)
                                                                 .setInstanceMetadataOptions(instanceMetadataOptions)
                                                                 .build();
        OceanEcsClusterLaunchSpecRequest.Builder launchSpecUpdateRequestBuilder =
                OceanEcsClusterLaunchSpecRequest.Builder.get();

        // Build launch specification request
        OceanEcsClusterLaunchSpecRequest launchSpecUpdateRequest =
                launchSpecUpdateRequestBuilder.setLaunchSpec(launchSpec).build();

        // Convert launch specification request to API object json
        System.out.println(launchSpecUpdateRequest.toJson());

        // Update launch specification
        Boolean isLaunchSpecUpdated = client.updateLaunchSpec(launchSpecUpdateRequest, launchSpecId);

        if (isLaunchSpecUpdated) {
            System.out.println(String.format("Launch specification successfully updated: %s", launchSpecId));
        }
        return isLaunchSpecUpdated;
    }
}
