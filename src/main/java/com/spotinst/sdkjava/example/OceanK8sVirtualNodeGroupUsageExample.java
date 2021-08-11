package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;
import com.spotinst.sdkjava.enums.K8sVngHttpTokensEnum;
import com.spotinst.sdkjava.model.BlockDeviceMapping;
import com.spotinst.sdkjava.model.EbsDevice;
import com.spotinst.sdkjava.model.OceanK8sVirtualNodeGroupClient;
import com.spotinst.sdkjava.model.Tag;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OceanK8sVirtualNodeGroupUsageExample {
    private final static String auth_token = "auth_token";
    private final static String accountId  = "act-id";

    private final static Integer    initialNodes	= 1;
    private final static String     deviceName      = "deviceName";
    private final static String     snapshotId      = "snap-vngtest";

    // Fill in the correct values from your account
    private final static String       userData                   = "IyEvYmluL2Jhc2gKIyBDb3B5cmlnaHQgMjAxNiBUaGUgS3ViZXJuZXRlcyBBdXRob3JzIEFsbCByaWdo";
    private final static String       imageId                    = "ami-01234";
    private final static List<String> securityGroups             = Arrays.asList("sg-01234");
    private final static String       oceanId                    = "o-4abcd";
    private final static String       kmsKeyId                   = "alias/aws/ebs";
    private final static List<String> subnetIds                  = Arrays.asList("subnet-2b", "subnet-2c");
    private final static List<String> preferredSpotTypes                  = Arrays.asList("c3.2xlarge", "c4.2xlarge");
    private final static List<String> instanceTypes              = Arrays.asList("c4.xlarge","c3.xlarge");
    private final static String       arnRole                    = "your-arn-role";
    private final static String       iamRoleName                = "VirtualNodeGroup-Test";

    public static void main(String[] args) {
        OceanK8sVirtualNodeGroupClient clusterClient = SpotinstClient.getOceanK8sVirtualNodeGroupClient(auth_token, accountId);

        String launchSpecId = createVirtualNodeGroup(clusterClient);
        getVirtualNodeGroup(clusterClient,launchSpecId);
        updateVirtualNodeGroup(clusterClient,launchSpecId);
        deleteVirtualNodeGroup(clusterClient,launchSpecId);
    }

    private static String createVirtualNodeGroup(OceanK8sVirtualNodeGroupClient client) {
        System.out.println("-------------------------start creating ocean virtual node group------------------------");

        //Build headroom
        ClusterHeadroomSpecification.Builder headroomSpecBuilder = ClusterHeadroomSpecification.Builder.get();
        ClusterHeadroomSpecification headroom =
                headroomSpecBuilder.setCpuPerUnit(1024).setGpuPerUnit(0).setMemoryPerUnit(512).setNumOfUnits(2).build();
        List<ClusterHeadroomSpecification> headroomList = Collections.singletonList(headroom);

        //Build autoscale specification
        VirtualNodeGroupAutoScaleSpec.Builder autoScaleBuilder = VirtualNodeGroupAutoScaleSpec.Builder.get();
        VirtualNodeGroupAutoScaleSpec         autoScale        = autoScaleBuilder.setHeadrooms(headroomList).build();

        //Build dynamicVolumeSize
        ClusterDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = ClusterDynamicVolumeSize.Builder.get();
        ClusterDynamicVolumeSize dynamicVolumeSize = dynamicVolumeSizeBuilder.setBaseSize(50).setResource("CPU").setSizePerResourceUnit(20).build();

        //Build ebsDevice
        EbsDevice.Builder ebsDeviceBuilder = EbsDevice.Builder.get();
        EbsDevice         ebsDevice        = ebsDeviceBuilder.setThroughput(null)
                                                             .setSnapshotId(snapshotId)
                                                             .setDeleteOnTermination(false)
                                                             .setEncrypted(false)
                                                             .setIops(1)
                                                             .setKmsKeyId(kmsKeyId)
                                                             .setSnapshotId(snapshotId)
                                                             .setVolumeType(AwsVolumeTypeEnum.GP2)
                                                             .setVolumeSize(null)
                                                             .setDynamicVolumeSize(dynamicVolumeSize)
                                                             .build();

        //Build blockDeviceMappings
        BlockDeviceMapping.Builder blockDeviceMappingBuilder = BlockDeviceMapping.Builder.get();
        BlockDeviceMapping blockDeviceMapping = blockDeviceMappingBuilder.setDeviceName(deviceName).setEbsDevice(ebsDevice).build();
        List<BlockDeviceMapping> blockDeviceMappingList = Collections.singletonList(blockDeviceMapping);

        //Build tags
        Tag.Builder tagsBuilder = Tag.Builder.get();

        Tag       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingSdkOcean").build();
        List<Tag> tagsList = Collections.singletonList(tag1);

        //Build iamInstanceProfile
        ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = ClusterIamInstanceProfileSpec.Builder.get();

        ClusterIamInstanceProfileSpec iamInstanceProfile = iamInstanceProfileBuilder.setArn(arnRole).setName(iamRoleName).build();

        //Build instanceMetadataOptions
        K8sVngInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder = K8sVngInstanceMetadataOptions.Builder.get();
        K8sVngInstanceMetadataOptions instanceMetadataOptions = instanceMetadataOptionsBuilder.setHttpPutResponseHopLimit(12)
                                                                                              .setHttpTokens(K8sVngHttpTokensEnum.OPTIONAL)
                                                                                              .build();

        //Build strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration         strategy        = strategyBuilder.setSpotPercentage(70).build();

        //Build Virtual Node Group
        K8sVirtualNodeGroup.Builder k8sVirtualNodeGroupBuilder = K8sVirtualNodeGroup.Builder.get();
        K8sVirtualNodeGroup k8sVirtualNodeGroup = k8sVirtualNodeGroupBuilder
                .setName("Java-SDK-Testing")
                .setAssociatePublicIpAddress(false)
                .setAutoScale(autoScale)
                .setBlockDeviceMappings(blockDeviceMappingList)
                .setTags(tagsList)
                .setIamInstanceProfile(iamInstanceProfile)
                .setImageId(imageId)
                .setInstanceMetadataOptions(instanceMetadataOptions)
                .setInstanceTypes(instanceTypes)
                .setOceanId(oceanId)
                .setSpotTypes(preferredSpotTypes)
                .setRestrictScaleDown(false)
                .setRootVolumeSize(null)
                .setSecurityGroupIds(securityGroups)
                .setStrategy(null)
                .setSubnetIds(subnetIds)
                .setUserData(userData).build();

        //Build virtual node group creation request
        K8sVirtualNodeGroupCreationRequest.Builder virtualNodeGroupCreationRequestBuilder = K8sVirtualNodeGroupCreationRequest.Builder.get();
        K8sVirtualNodeGroupCreationRequest creationRequest               =
                virtualNodeGroupCreationRequestBuilder.setlaunchSpec(k8sVirtualNodeGroup).build();

        //Convert virtual node group to API object json
        System.out.println(creationRequest.toJson());

        //Create virtual node group
        K8sVirtualNodeGroup createdVirtualNodeGroup = client.createK8sVirtualNodeGroup(creationRequest);
        System.out.println("Virtual Node Group Created Successfully: " + createdVirtualNodeGroup.getId());

        return createdVirtualNodeGroup.getId();
    }

    private static K8sVirtualNodeGroup getVirtualNodeGroup(OceanK8sVirtualNodeGroupClient client, String launchSpecId){
        System.out.println("-------------------------start getting ocean virtual node group------------------------");
        K8sVirtualNodeGroupGetRequest.Builder getBuilder = K8sVirtualNodeGroupGetRequest.Builder.get();
        K8sVirtualNodeGroupGetRequest         getRequest = getBuilder.setOceanLaunchSpecId(launchSpecId).build();

        K8sVirtualNodeGroup k8sVirtualNodeGroup = client.getK8sVirtualNodeGroup(getRequest);
        if (k8sVirtualNodeGroup != null) {
            System.out.println("Get Virtual Node Group Successfully: " + k8sVirtualNodeGroup.getId());
        }
        return k8sVirtualNodeGroup;
    }

    private static void updateVirtualNodeGroup(OceanK8sVirtualNodeGroupClient client, String launchSpecId) {
        System.out.println("-------------------------start updating ocean virtual node group------------------------");

        //Build headroom
        ClusterHeadroomSpecification.Builder headroomSpecBuilder = ClusterHeadroomSpecification.Builder.get();
        ClusterHeadroomSpecification headroom =
                headroomSpecBuilder.setCpuPerUnit(1024).setGpuPerUnit(0).setMemoryPerUnit(512).setNumOfUnits(2).build();
        List<ClusterHeadroomSpecification> headroomList = Collections.singletonList(headroom);

        //Build autoscale specification
        VirtualNodeGroupAutoScaleSpec.Builder autoScaleBuilder = VirtualNodeGroupAutoScaleSpec.Builder.get();
        VirtualNodeGroupAutoScaleSpec         autoScale        = autoScaleBuilder.setHeadrooms(headroomList).build();

        //Build dynamicVolumeSize
        ClusterDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = ClusterDynamicVolumeSize.Builder.get();
        ClusterDynamicVolumeSize dynamicVolumeSize =
                dynamicVolumeSizeBuilder.setBaseSize(50).setResource("CPU").setSizePerResourceUnit(20).build();

        //Build ebsDevice
        EbsDevice.Builder ebsDeviceBuilder = EbsDevice.Builder.get();
        EbsDevice ebsDevice = ebsDeviceBuilder.setThroughput(null)
                                              .setSnapshotId(snapshotId)
                                              .setDeleteOnTermination(false)
                                              .setEncrypted(false)
                                              .setIops(1)
                                              .setKmsKeyId(kmsKeyId)
                                              .setSnapshotId(snapshotId)
                                              .setVolumeType(AwsVolumeTypeEnum.GP2)
                                              .setVolumeSize(null)
                                              .setDynamicVolumeSize(dynamicVolumeSize)
                                              .build();

        //Build blockDeviceMappings
        BlockDeviceMapping.Builder blockDeviceMappingBuilder = BlockDeviceMapping.Builder.get();
        BlockDeviceMapping blockDeviceMapping = blockDeviceMappingBuilder.setDeviceName(deviceName)
                                                .setEbsDevice(ebsDevice).build();
        List<BlockDeviceMapping> blockDeviceMappingList = Collections.singletonList(blockDeviceMapping);

        //Build tags
        Tag.Builder tagsBuilder = Tag.Builder.get();

        Tag       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingSdkOcean").build();
        List<Tag> tagsList = Collections.singletonList(tag1);

        //Build iamInstanceProfile
        ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = ClusterIamInstanceProfileSpec.Builder.get();

        ClusterIamInstanceProfileSpec iamInstanceProfile =
                iamInstanceProfileBuilder.setArn(arnRole).setName(iamRoleName).build();

        //Build instanceMetadataOptions
        K8sVngInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder = K8sVngInstanceMetadataOptions.Builder.get();
        K8sVngInstanceMetadataOptions instanceMetadataOptions = instanceMetadataOptionsBuilder
                                                                .setHttpPutResponseHopLimit(12)
                                                                .setHttpTokens(K8sVngHttpTokensEnum.OPTIONAL).build();

        //Build strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration         strategy        = strategyBuilder.setSpotPercentage(70).build();

        //Build Virtual Node Group
        K8sVirtualNodeGroup.Builder k8sVirtualNodeGroupBuilder = K8sVirtualNodeGroup.Builder.get();
        K8sVirtualNodeGroup k8sVirtualNodeGroup =
                k8sVirtualNodeGroupBuilder.setName("Java-SDK-Update")
                                          .setAssociatePublicIpAddress(false)
                                          .setAutoScale(autoScale)
                                          .setBlockDeviceMappings(blockDeviceMappingList)
                                          .setTags(tagsList)
                                          .setIamInstanceProfile(iamInstanceProfile)
                                          .setImageId(imageId)
                                          .setInstanceMetadataOptions(instanceMetadataOptions)
                                          .setInstanceTypes(instanceTypes)
                                          .setOceanId(null)
                                          .setSpotTypes(preferredSpotTypes)
                                          .setRestrictScaleDown(false)
                                          .setRootVolumeSize(null)
                                          .setSecurityGroupIds(securityGroups)
                                          .setStrategy(null)
                                          .setSubnetIds(subnetIds)
                                          .setUserData(userData)
                                          .build();

        K8sVirtualNodeGroupUpdateRequest.Builder updateBuilder = K8sVirtualNodeGroupUpdateRequest.Builder.get();
        K8sVirtualNodeGroupUpdateRequest         updateRequest = updateBuilder.setVirtualNodeGroup(k8sVirtualNodeGroup).build();

        //Convert virtual node group to API object json
        System.out.println(updateRequest.toJson());

        Boolean successUpdate = client.updateK8sVirtualNodeGroup(updateRequest, launchSpecId);
        if (successUpdate) {
            System.out.println("Virtual Node Group Updated Successfully: " + launchSpecId);
        }
    }

    private static void deleteVirtualNodeGroup(OceanK8sVirtualNodeGroupClient client, String launchSpecId) {
        System.out.println("-------------------------start deleting ocean virtual node group------------------------");
        K8sVirtualNodeGroupDeleteRequest.Builder deletionBuilder = K8sVirtualNodeGroupDeleteRequest.Builder.get();
        K8sVirtualNodeGroupDeleteRequest         deletionRequest = deletionBuilder.setOceanLaunchSpecId(launchSpecId).build();

        Boolean successfulDeletion = client.deleteK8sVirtualNodeGroup(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Virtual Node Group Deleted Successfully: " + launchSpecId);
        }
    }
}
