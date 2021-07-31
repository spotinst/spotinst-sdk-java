package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;
import com.spotinst.sdkjava.model.BlockDeviceMapping;
import com.spotinst.sdkjava.model.EbsDevice;
import com.spotinst.sdkjava.model.SpotOceanK8sClusterClient;
import com.spotinst.sdkjava.model.Tag;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ClusterDynamicVolumeSize;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ClusterHeadroomSpecification;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ClusterIamInstanceProfileSpec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OceanK8sVirtualNodeGroupUsageExample {
	private final static String auth_token = "auth_token";
    private final static String accountId  = "accountId";

	private final static Integer    initialNodes	= 1;
	private final static String     deviceName      = "deviceName";
	private final static String     snapshotId      = "snap-abcdefghi111110"

    // Fill in the correct values from your account
    private final static String       controllerClusterId        = "your-sdk-Cluster-id";
    private final static String       launchSpecificationImageId = "your-launchSpec-image-id";
    private final static List<String> securityGroups             = Arrays.asList("sg-1", "sg-2");
    private final static String       region                     = "chosen-region";
    private final static String       kmsKeyId                    = "alias/aws/ebs";
    private final static List<String> subnetIds                  = Arrays.asList("subnet-1", "subnet-2");
    private final static String       arnRole                    = "your-arn-role";
    private final static String       iamRoleName                = "VirtualNodeGroup-Test"

    public static void main(String[] args) {
        SpotOceanK8sClusterClient clusterClient = SpotinstClient.getOceanClusterClient(auth_token, accountId);

        String launchSpecId = createVirtualNodeGroup(clusterClient);
        getVirtualNodeGroup(clusterClient,launchSpecId);
        updateVirtualNodeGroup(clusterClient, launchSpecId);
        deleteVirtualNodeGroup(clusterClient, launchSpecId);
    }

    private static String createVirtualNodeGroup(SpotOceanK8sClusterClient client) {
        System.out.println("-------------------------start creating ocean virtual node group------------------------");

        //Build autoScale
        ClusterHeadroomSpecification.Builder headroomSpecBuilder = ClusterHeadroomSpecification.Builder.get();
        ClusterHeadroomSpecification headroom =
                headroomSpecBuilder.setCpuPerUnit(2000).setGpuPerUnit(0).setMemoryPerUnit(0).setNumOfUnits(2).build();

        //Build dynamicVolumeSize
        ClusterDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = ClusterDynamicVolumeSize.Builder.get();
        ClusterDynamicVolumeSize dynamicVolumeSize = dynamicVolumeSizeBuilder.setBaseSize(50).setResource("CPU").setSizePerResourceUnit(20).build();

        //Build ebsDevice
        EbsDevice.Builder ebsDeviceBuilder = EbsDevice.Builder.get();
        EbsDevice         ebsDevice        = ebsDeviceBuilder.setThroughput(125)
                                            .setSnapshotId(snapshotId)
                                            .setDeleteOnTermination(false)
                                            .setEncrypted(false)
                                            .setIops(1)
                                            .setKmsKeyId(kmsKeyId)
                                            .setSnapshotId(snapshotId)
                                            .setVolumeType(AwsVolumeTypeEnum.GP2)
                                            .setVolumeSize(0)
                                            .setDynamicVolumeSize(dynamicVolumeSize)
                                            .build();

        //Build blockDeviceMappings
        BlockDeviceMapping.Builder blockDeviceMappingBuilder = BlockDeviceMapping.Builder.get();

        BlockDeviceMapping blockDeviceMapping = blockDeviceMappingBuilder.setDeviceName(deviceName).setEbsDevice(ebsDevice).build();

        //Build tags
        Tag.Builder tagsBuilder = Tag.Builder.get();

        Tag       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingSdkOcean").build();
        List<Tag> tagsList = Collections.singletonList(tag1);

        //Build iamInstanceProfile
        ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = ClusterIamInstanceProfileSpec.Builder.get();

        ClusterIamInstanceProfileSpec iamInstanceProfile = iamInstanceProfileBuilder.setArn(arnRole).setName(iamRoleName).build();

        //Build instanceMetadataOptions
        

        ClusterResourceLimitsSpecification.Builder resourceLimitSpecBuilder =
                ClusterResourceLimitsSpecification.Builder.get();
        ClusterResourceLimitsSpecification resourceLimits =
                resourceLimitSpecBuilder.setMaxMemoryGib(5).setMaxVCpu(2000).build();

        ClusterAutoScalerConfiguration.Builder clusterAutoScalerBuilder = ClusterAutoScalerConfiguration.Builder.get();
        ClusterAutoScalerConfiguration autoScaler =
                clusterAutoScalerBuilder.setIsAutoConfig(false).setCooldown(180).setDown(down)
                                        .setAutoHeadroomPercentage(null).setHeadroom(headroom).setIsEnabled(false)
                                        .setResourceLimits(resourceLimits).build();

        //Build capacity
        ClusterCapacityConfiguration.Builder capacityBuilder = ClusterCapacityConfiguration.Builder.get();
        ClusterCapacityConfiguration capacity = capacityBuilder.setMaximum(0).setMinimum(0).setTarget(0).build();

        //Build strategy
        ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
        ClusterStrategyConfiguration strategy =
                strategyBuilder.setFallbackToOnDemand(false).setUtilizeReservedInstances(true).setDrainingTimeout(60)
                               .setGracePeriod(600).build();

        //Build compute
        Tag.Builder tagsBuilder = Tag.Builder.get();

        Tag       tag1     = tagsBuilder.setTagKey("Creator").setTagValue("testingSdkOcean").build();
        List<Tag> tagsList = Collections.singletonList(tag1);


        ClusterIamInstanceProfileSpec.Builder iamInstanceProfileBuilder = ClusterIamInstanceProfileSpec.Builder.get();
        ClusterIamInstanceProfileSpec iamInstanceProfileSpec = iamInstanceProfileBuilder.setArn(arnRole).build();

        ClusterLaunchSpecification.Builder launchSpecificationBuilder = ClusterLaunchSpecification.Builder.get();
        ClusterLaunchSpecification launchSpecification =
                launchSpecificationBuilder.setSecurityGroupIds(securityGroups).setAssociatePublicIpAddress(true)
                                          .setEbsOptimized(false).setMonitoring(false).setRootVolumeSize(73)
                                          .setIamInstanceProfile(iamInstanceProfileSpec)
                                          .setImageId(launchSpecificationImageId).setTags(tagsList).setKeyPair(keyPair)
                                          .build();

        ClusterInstanceTypes.Builder instanceTypesBuilder = ClusterInstanceTypes.Builder.get();

        List<String> whiteList = Arrays.asList("c4.xlarge");

        ClusterInstanceTypes instanceTypes = instanceTypesBuilder.setWhitelist(whiteList).build();


        ClusterComputeConfiguration.Builder computeBuilder = ClusterComputeConfiguration.Builder.get();
        ClusterComputeConfiguration compute =
                computeBuilder.setInstanceTypes(instanceTypes).setLaunchSpecification(launchSpecification)
                              .setSubnetIds(subnetIds).build();

        //Build scheduling
        List<String> timeWindows = Arrays.asList("Mon:12:00-Tue:12:00", "Fri:12:00-Sat:12:00");

        ClusterShutdownHoursSpecification.Builder shutDownSpecBuilder = ClusterShutdownHoursSpecification.Builder.get();
        ClusterShutdownHoursSpecification shutDownHours =
                shutDownSpecBuilder.setEnabled(true).setTimeWindows(timeWindows).build();

        ClusterTasksSpecification.Builder tasksBuilder = ClusterTasksSpecification.Builder.get();

        ClusterTasksSpecification task1 =
                tasksBuilder.setIsEnabled(true).setCronExpression("0 1 * * *").setTaskType("clusterRoll").build();
        List<ClusterTasksSpecification> tasksList = Collections.singletonList(task1);

        ClusterSchedulingConfiguration.Builder schedulingBuilder = ClusterSchedulingConfiguration.Builder.get();
        ClusterSchedulingConfiguration scheduling =
                schedulingBuilder.setShutdownHours(shutDownHours).setTasks(tasksList).build();

        // Build cluster
        OceanK8sCluster.Builder oceanBuilder = OceanK8sCluster.Builder.get();
        OceanK8sCluster oceanK8sCluster =
                oceanBuilder.setName("Java-SDK-Testing").setRegion(region).setControllerClusterId(controllerClusterId)
                            .setAutoScaler(autoScaler).setStrategy(strategy).setCapacity(capacity).setCompute(compute)
                            .setScheduling(scheduling).build();
        // Build cluster creation request
        K8sClusterCreationRequest.Builder clusterCreationRequestBuilder = K8sClusterCreationRequest.Builder.get();
        K8sClusterCreationRequest creationRequest               =
                clusterCreationRequestBuilder.setCluster(oceanK8sCluster).build();

        // Convert cluster to API object json
        System.out.println(creationRequest.toJson());

        // Create cluster
        OceanK8sCluster createdCluster = client.createK8sCluster(creationRequest);
        System.out.println("Cluster successfully created: " + createdCluster.getId());

        return createdCluster.getId();
    }
}
