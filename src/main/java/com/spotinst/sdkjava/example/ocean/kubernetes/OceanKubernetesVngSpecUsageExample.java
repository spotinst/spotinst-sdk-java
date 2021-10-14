package com.spotinst.sdkjava.example.ocean.kubernetes;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;
import com.spotinst.sdkjava.enums.K8sVngHttpTokensEnum;
import com.spotinst.sdkjava.model.K8sVngClient;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OceanKubernetesVngSpecUsageExample {
    private final static String auth_token = "auth_token";
    private final static String accountId  = "account_id";

    private final static String deviceName = "deviceName";
    private final static String snapshotId = "snap-vngtest";

    // Fill in the correct values from your account
    private final static String       userData                   = "userData";
    private final static String       imageId                    = "ami-000bdc7aed61562d7";
    private final static List<String> securityGroups             = Arrays.asList("sg-01234", "sg-12345");
    private final static String       oceanId                    = "o-4abcd";
    private final static String       kmsKeyId                   = "alias/aws/ebs";
    private final static List<String> subnetIds                  = Arrays.asList("subnet-2b", "subnet-2c");
    private final static List<String> preferredSpotTypes         = Arrays.asList("c3.2xlarge", "c4.2xlarge");
    private final static List<String> instanceTypes              = Arrays.asList("c4.xlarge","c3.xlarge");
    private final static String       arnRole                    = "your-arn-role";
    private final static String       iamRoleName                = "VirtualNodeGroup-Test";

    //headroom
    private final static Integer cpuPerUnit             =   1024;
    private final static Integer gpuPerUnit             =   0;
    private final static Integer memoryPerUnit          =   512;
    private final static Integer numOfUnits             =   2;
    private final static Integer baseSize               =   50;
    private final static String  resource               =   "CPU";
    private final static Integer sizePerResourceUnit    =   20;

    public static void main(String[] args) {
        K8sVngClient vngClient = SpotinstClient.getK8sVngClient(auth_token, accountId);

        String launchSpecId = createK8sVng(vngClient);
        getK8sVng(vngClient,launchSpecId);
        listK8sVng(vngClient, accountId, oceanId);
        updateK8sVng(vngClient,launchSpecId);
        deleteK8sVng(vngClient,launchSpecId);
    }

    private static String createK8sVng(K8sVngClient client) {
        System.out.println("-------------------------start creating ocean virtual node group------------------------");

        //Build headroom
        K8sVngHeadroomSpec.Builder headroomSpecBuilder = K8sVngHeadroomSpec.Builder.get();
        K8sVngHeadroomSpec headroom = headroomSpecBuilder.setCpuPerUnit(cpuPerUnit)
                                                         .setGpuPerUnit(gpuPerUnit)
                                                         .setMemoryPerUnit(memoryPerUnit)
                                                         .setNumOfUnits(numOfUnits)
                                                         .build();

        List<K8sVngHeadroomSpec> headroomList = Collections.singletonList(headroom);

        //Build autoscale specification
        K8sVngAutoScaleSpec.Builder autoScaleBuilder = K8sVngAutoScaleSpec.Builder.get();
        K8sVngAutoScaleSpec         autoScale        = autoScaleBuilder.setHeadrooms(headroomList).build();

        //Build dynamicVolumeSize
        K8sVngDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = K8sVngDynamicVolumeSize.Builder.get();
        K8sVngDynamicVolumeSize dynamicVolumeSize = dynamicVolumeSizeBuilder.setBaseSize(baseSize)
                                                                            .setResource(resource)
                                                                            .setSizePerResourceUnit(sizePerResourceUnit)
                                                                            .build();

        //Build ebsDevice
        K8sVngEbsDevice.Builder ebsDeviceBuilder = K8sVngEbsDevice.Builder.get();
        K8sVngEbsDevice ebsDevice = ebsDeviceBuilder.setThroughput(null)
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
        K8sVngBlockDevice.Builder blockDeviceMappingBuilder = K8sVngBlockDevice.Builder.get();
        K8sVngBlockDevice blockDeviceMapping = blockDeviceMappingBuilder.setDeviceName(deviceName).setEbsDevice(ebsDevice).build();
        List<K8sVngBlockDevice> blockDeviceMappingList = Collections.singletonList(blockDeviceMapping);

        //Build tags
        K8sVngTag.Builder tagsBuilder = K8sVngTag.Builder.get();

        K8sVngTag       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingSdkOcean").build();
        List<K8sVngTag> tagsList = Collections.singletonList(tag1);

        //Build iamInstanceProfile
        K8sVngIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = K8sVngIamInstanceProfileSpec.Builder.get();

        K8sVngIamInstanceProfileSpec iamInstanceProfile = iamInstanceProfileBuilder.setArn(arnRole).setName(iamRoleName).build();

        //Build instanceMetadataOptions
        K8sVngInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder = K8sVngInstanceMetadataOptions.Builder.get();
        K8sVngInstanceMetadataOptions instanceMetadataOptions = instanceMetadataOptionsBuilder.setHttpPutResponseHopLimit(12)
                                                                                              .setHttpTokens(K8sVngHttpTokensEnum.OPTIONAL)
                                                                                              .build();

        //Build strategy
        K8sVngStrategySpec.Builder strategyBuilder = K8sVngStrategySpec.Builder.get();
        K8sVngStrategySpec         strategy        = strategyBuilder.setSpotPercentage(70).build();

        //Build Virtual Node Group
        K8sVngSpec.Builder k8sVngBuilder = K8sVngSpec.Builder.get();
        K8sVngSpec k8sVng = k8sVngBuilder.setName("Java-SDK-Testing")
                                         .setAssociatePublicIpAddress(false)
                                         .setAutoScale(autoScale)
                                         .setBlockDevices(blockDeviceMappingList)
                                         .setTags(tagsList)
                                         .setIamInstanceProfile(iamInstanceProfile)
                                         .setImageId(imageId)
                                         .setInstanceMetadataOptions(instanceMetadataOptions)
                                         .setInstanceTypes(instanceTypes)
                                         .setOceanId(oceanId)
                                         .setPreferredSpotTypes(preferredSpotTypes)
                                         .setRestrictScaleDown(false)
                                         .setRootVolumeSize(null)
                                         .setSecurityGroupIds(securityGroups)
                                         .setStrategy(null)
                                         .setSubnetIds(subnetIds)
                                         .setUserData(userData).build();

        //Build virtual node group creation request
        K8sVngCreationRequest.Builder vngCreationRequestBuilder = K8sVngCreationRequest.Builder.get();
        K8sVngCreationRequest         creationRequest           = vngCreationRequestBuilder.setVngLaunchSpec(k8sVng).build();

        //Convert virtual node group to API object json
        System.out.println(creationRequest.toJson());

        //Create virtual node group
        K8sVngSpec createdK8sVng = client.createK8sVng(creationRequest);
        System.out.println("Virtual Node Group Created Successfully: " + createdK8sVng.getId());

        return createdK8sVng.getId();
    }

    private static K8sVngSpec getK8sVng(K8sVngClient client, String launchSpecId){
        System.out.println("-------------------------start getting ocean virtual node group------------------------");
        K8sVngGetRequest.Builder getBuilder = K8sVngGetRequest.Builder.get();
        K8sVngGetRequest         getRequest = getBuilder.setOceanLaunchSpecId(launchSpecId).build();

        K8sVngSpec k8sVng = client.getK8sVngSpec(getRequest);
        if (k8sVng != null) {
            System.out.println("Get Virtual Node Group Successfully: " + k8sVng.getId());
        }
        return k8sVng;
    }

    private static List<K8sVngSpec> listK8sVng (K8sVngClient client, String accountId, String oceanId) {
        System.out.println("-------------------------start listing ocean virtual node group------------------------");
        K8sVngListRequest.Builder listBuilder = K8sVngListRequest.Builder.get();
        K8sVngListRequest listRequest =listBuilder.setAccountId(accountId).setOceanId(oceanId).build();

        List<K8sVngSpec> k8sVng = client.listK8sVngSpec(listRequest);

        if (k8sVng.size() > 0) {
            for(int i = 0; i < k8sVng.size(); i++) {
                System.out.println("List Virtual Node Group Successfully: " + k8sVng.get(i).getName());
            }
        }

        return k8sVng;
    }

    private static void updateK8sVng(K8sVngClient client, String launchSpecId) {
        System.out.println("-------------------------start updating ocean virtual node group------------------------");

        //Build headroom
        K8sVngHeadroomSpec.Builder headroomSpecBuilder = K8sVngHeadroomSpec.Builder.get();
        K8sVngHeadroomSpec headroom = headroomSpecBuilder.setCpuPerUnit(cpuPerUnit)
                                                         .setGpuPerUnit(gpuPerUnit)
                                                         .setMemoryPerUnit(memoryPerUnit)
                                                         .setNumOfUnits(numOfUnits)
                                                         .build();

        List<K8sVngHeadroomSpec> headroomList = Collections.singletonList(headroom);

        //Build autoscale specification
        K8sVngAutoScaleSpec.Builder autoScaleBuilder = K8sVngAutoScaleSpec.Builder.get();
        K8sVngAutoScaleSpec         autoScale        = autoScaleBuilder.setHeadrooms(headroomList).build();

        //Build dynamicVolumeSize
        K8sVngDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = K8sVngDynamicVolumeSize.Builder.get();
        K8sVngDynamicVolumeSize dynamicVolumeSize = dynamicVolumeSizeBuilder.setBaseSize(baseSize)
                                                                            .setResource(resource)
                                                                            .setSizePerResourceUnit(sizePerResourceUnit)
                                                                            .build();

        //Build ebsDevice
        K8sVngEbsDevice.Builder ebsDeviceBuilder = K8sVngEbsDevice.Builder.get();
        K8sVngEbsDevice ebsDevice = ebsDeviceBuilder.setThroughput(null)
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
        K8sVngBlockDevice.Builder blockDeviceMappingBuilder = K8sVngBlockDevice.Builder.get();
        K8sVngBlockDevice blockDeviceMapping = blockDeviceMappingBuilder.setDeviceName(deviceName)
                                                                        .setEbsDevice(ebsDevice)
                                                                        .build();

        List<K8sVngBlockDevice> blockDeviceMappingList = Collections.singletonList(blockDeviceMapping);

        //Build tags
        K8sVngTag.Builder tagsBuilder = K8sVngTag.Builder.get();

        K8sVngTag       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingSdkOcean").build();
        List<K8sVngTag> tagsList = Collections.singletonList(tag1);

        //Build iamInstanceProfile
        K8sVngIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = K8sVngIamInstanceProfileSpec.Builder.get();

        K8sVngIamInstanceProfileSpec iamInstanceProfile = iamInstanceProfileBuilder.setArn(arnRole)
                                                                                   .setName(iamRoleName)
                                                                                   .build();

        //Build instanceMetadataOptions
        K8sVngInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder = K8sVngInstanceMetadataOptions.Builder.get();
        K8sVngInstanceMetadataOptions instanceMetadataOptions = instanceMetadataOptionsBuilder
                                                                .setHttpPutResponseHopLimit(12)
                                                                .setHttpTokens(K8sVngHttpTokensEnum.OPTIONAL).build();

        //Build strategy
        K8sVngStrategySpec.Builder strategyBuilder = K8sVngStrategySpec.Builder.get();
        K8sVngStrategySpec         strategy        = strategyBuilder.setSpotPercentage(70).build();

        //Build Virtual Node Group
        K8sVngSpec.Builder k8sVngBuilder = K8sVngSpec.Builder.get();
        K8sVngSpec k8sVng = k8sVngBuilder.setName("Java-SDK-Update")
                                         .setAssociatePublicIpAddress(false)
                                         .setAutoScale(autoScale)
                                         .setBlockDevices(blockDeviceMappingList)
                                         .setTags(tagsList)
                                         .setIamInstanceProfile(iamInstanceProfile)
                                         .setImageId(imageId)
                                         .setInstanceMetadataOptions(instanceMetadataOptions)
                                         .setInstanceTypes(instanceTypes)
                                         .setOceanId(null)
                                         .setPreferredSpotTypes(preferredSpotTypes)
                                         .setRestrictScaleDown(false)
                                         .setRootVolumeSize(null)
                                         .setSecurityGroupIds(securityGroups)
                                         .setStrategy(null)
                                         .setSubnetIds(subnetIds)
                                         .setUserData(userData)
                                         .build();

        K8sVngUpdateRequest.Builder updateBuilder = K8sVngUpdateRequest.Builder.get();
        K8sVngUpdateRequest         updateRequest = updateBuilder.setVngLaunchSpec(k8sVng).build();

        //Convert virtual node group to API object json
        System.out.println(updateRequest.toJson());

        Boolean successUpdate = client.updateK8sVng(updateRequest, launchSpecId);
        if (successUpdate) {
            System.out.println("Virtual Node Group Updated Successfully: " + launchSpecId);
        }
    }

    private static void deleteK8sVng(K8sVngClient client, String launchSpecId) {
        System.out.println("-------------------------start deleting ocean virtual node group------------------------");
        K8sVngDeleteRequest.Builder deletionBuilder = K8sVngDeleteRequest.Builder.get();
        K8sVngDeleteRequest         deletionRequest = deletionBuilder.setOceanLaunchSpecId(launchSpecId).build();

        Boolean successfulDeletion = client.deleteK8sVngSpec(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Virtual Node Group Deleted Successfully: " + launchSpecId);
        }
    }
}
