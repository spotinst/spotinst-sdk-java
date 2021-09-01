package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.enums.PerformAtEnumGcp;
import com.spotinst.sdkjava.enums.SchedulingTaskTypeEnum;
import com.spotinst.sdkjava.enums.RecurrenceFrequencyEnum;
import com.spotinst.sdkjava.model.SpotAwsManagedInstanceClient;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.*;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceDeletionRequest;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AwsManagedInstanceUsageExample {

    private final static String       auth_token     = "auth-token";
    private final static String       act_id         = "act-id";
    private final static String       image_id       = "ami-082b5a644766e0e6f";
    private final static List<String> subnetIds      = Arrays.asList("subnet-4333093a");
    private final static List<String> securityGroups = Arrays.asList("sg-0b44a6d6f3e286608");
    private final static List<String> types          = Arrays.asList("t3.nano", "t3a.nano");
    private final static List<String> timeWindows    = Arrays.asList("Mon:12:00-Tue:12:00", "Fri:12:00-Sat:12:00");

    public static void main(String[] args) {
        SpotAwsManagedInstanceClient managedInstanceClient = SpotinstClient.getManagedInstanceClient(auth_token, act_id);

        System.out.println("----------Creation of ManagedInstance--------------");
        String managedInstanceId = createManagedInstance(managedInstanceClient);

        System.out.println("----------Updation of ManagedInstance--------------");
        updateManagedInstanceName(managedInstanceClient, managedInstanceId);
        updateManagedInstance(managedInstanceClient, managedInstanceId);

        System.out.println("----------Get managedInstances--------------");
        ManagedInstance managedInstance = getManagedInstance(managedInstanceClient,managedInstanceId);
         //Convert managedInstance response to json
        System.out.println(JsonMapper.toJson(managedInstance));

        System.out.println("----------List of ManagedInstance--------------");
        List<ManagedInstance> allManagedInstances = listManagedInstance(managedInstanceClient);

            for (ManagedInstance myManagedInstance : allManagedInstances) {
                System.out.println(String.format("ManagedInstance Id: %s, ManagedInstance Name: %s",
                        myManagedInstance.getId(), myManagedInstance.getName()));
        }

        System.out.println("----------Deletion of ManagedInstance--------------");
        deleteManagedInstance(managedInstanceClient, managedInstanceId);

        System.out.println("----------Pausing ManagedInstance--------------");
        pauseManagedInstance(managedInstanceClient, managedInstanceId);

        System.out.println("----------Resuming ManagedInstance--------------");
        resumeManagedInstance(managedInstanceClient, managedInstanceId);

        System.out.println("----------Recycling ManagedInstance--------------");
        recycleManagedInstance(managedInstanceClient, managedInstanceId);
    }

    private static String createManagedInstance(SpotAwsManagedInstanceClient client) {

        //Build IamRole
        IamRole.Builder iamRoleBuilder = IamRole.Builder.get();
        IamRole         iamRole        = iamRoleBuilder.setName(null)
                .setArn("arn:aws:iam::253244684816:instance-profile/AutomationRole").build();

        //Build tags
        Tags.Builder tagBuilder = Tags.Builder.get();
        Tags         tag       = tagBuilder.setTagKey("Creator").setTagValue("ChandraTest").build();
        List<Tags>   tags       = Collections.singletonList(tag);

        //Build creditSpecification
        CreditSpecification.Builder creditSpecificationBuilder =
                CreditSpecification.Builder.get();
        CreditSpecification creditSpecification                = creditSpecificationBuilder.setCpuCredits("standard").build();

        //Build ebs
        Ebs.Builder ebsBuilder = Ebs.Builder.get();
        Ebs ebs                = ebsBuilder
                .setThroughput(null)
                .setDeleteOnTermination(true)
                .setIops(100)
                .setVolumeSize(8)
                .setVolumeType("gp3")
                .build();

        //Build BlockDevice Mappings
        BlockDeviceMappings.Builder blockDeviceMappingsBuilder = BlockDeviceMappings.Builder.get();
        BlockDeviceMappings blockDeviceMappings = blockDeviceMappingsBuilder.setDeviceName("/dev/xvda").setEbs(ebs)
                .build();
        List<BlockDeviceMappings> blockDeviceMappingsList = Collections.singletonList(blockDeviceMappings);

        //Build instanceTypes
        InstanceTypes.Builder instanceTypesBuilder = InstanceTypes.Builder.get();
        InstanceTypes instanceTypes                = instanceTypesBuilder.setTypes(types).setPreferredType("t3.nano").build();

        //Build Resource Tag Spec
        TagSpecification volumes = new TagSpecification();
        volumes.setShouldTag(true);
        TagSpecification amis = new TagSpecification();
        amis.setShouldTag(true);
        TagSpecification enis = new TagSpecification();
        enis.setShouldTag(true);
        TagSpecification snapshots = new TagSpecification();
        snapshots.setShouldTag(true);

        ResourceTagSpecification.Builder resourceTagSpecBuilder = ResourceTagSpecification.Builder.get();
        ResourceTagSpecification resourceTagSpecification =
                resourceTagSpecBuilder.setTagAmis(amis).setTagEnis(enis).setTagSnapshot(snapshots).setTagVolume(volumes)
                        .build();

        //Build networkInterfaces
        NetworkInterfaces.Builder networkInterfacesBuilder = NetworkInterfaces.Builder.get();
        NetworkInterfaces networkInterfaces                = networkInterfacesBuilder.setAssociateIpv6Address(false)
                .setAssociatePublicIpAddress(false)
                .setDeviceIndex(0)
                .build();
        List<NetworkInterfaces> networkInterfacesList = Collections.singletonList(networkInterfaces);

        //Build launchSpecification
        LaunchSpecification.Builder launchSpecificationBuilder = LaunchSpecification.Builder.get();
        LaunchSpecification launchSpecification                = launchSpecificationBuilder
                .setBlockDeviceMappings(blockDeviceMappingsList)
                .setEbsOptimized(false)
                .setIamRole(iamRole)
                .setInstanceTypes(instanceTypes)
                .setSecurityGroupIds(securityGroups)
                .setImageId(image_id)
                .setKeyPair("automationKeyPair")
                .setMonitoring(false)
                .setShutdownScript(null)
                .setNetworkInterfaces(networkInterfacesList)
                .setUserData("dXNlcmJhc2g2NGVuY29kZWQ=")
                .setCreditSpecification(creditSpecification)
                .setTags(tags)
                .setTenancy("default")
                .setResourceTagSpecification(resourceTagSpecification)
                .build();



        //Build compute
        Compute.Builder    computeBuilder = Compute.Builder.get();
        Compute            compute        = computeBuilder
                .setElasticIp(null)
                .setProduct("Linux/UNIX")
                .setSubnetIds(subnetIds)
                .setVpcId("vpc-b6923bce")
                .setLaunchSpecification(launchSpecification)
                .build();

        //Build loadBalancers
        LoadBalancers.Builder loadBalancersBuilder = LoadBalancers.Builder.get();
        LoadBalancers loadBalancers                = loadBalancersBuilder.setArn("arn")
                .setAutoWeight(true)
                .setAzAwareness(true)
                .setBalancerId("lb-1ee2e3q")
                .setName("testing")
                .setTargetSetId("ts-3eq")
                .setType("MULTAI_TARGET_SET")
                .build();
        List<LoadBalancers> loadBalancersList = Collections.singletonList(loadBalancers);

        //Build loadBalancersConfig
        LoadBalancersConfig.Builder loadBalancersConfigBuilder = LoadBalancersConfig.Builder.get();
        LoadBalancersConfig loadBalancersConfig                = loadBalancersConfigBuilder
                .setLoadBalancers(loadBalancersList)
                .build();

        //Build recordSets
        RecordSets.Builder recordSetsBuilder = RecordSets.Builder.get();
        RecordSets recordSets                = recordSetsBuilder.setName("test.spot.io")
                .setUsePublicIp(true)
                .build();
        List<RecordSets> RecordSetsList = Collections.singletonList(recordSets);

        //Build domains
        Domains.Builder domainsBuilder  = Domains.Builder.get();
        Domains    domains1 = domainsBuilder.setHostedZoneId("Z00275642KS5ZZJFIQBCA")
                .setRecordSets(RecordSetsList)
                .setRecordSetType("a")
                .setSpotinstAccountId(act_id)
                .build();
        List<Domains> domains           = Collections.singletonList(domains1);

        //Build route53
        Route53.Builder route53Builder = Route53.Builder.get();
        Route53 route53                = route53Builder
                .setDomains(domains)
                .build();

        //Build persistence
        Persistence.Builder persistenceBuilder = Persistence.Builder.get();
        Persistence persistence                = persistenceBuilder.setBlockDevicesMode(null)
                .setPersistBlockDevices(false)
                .setPersistPrivateIp(false)
                .setPersistRootDevice(true)
                .build();

        //Build heathcheck
        HealthCheck.Builder healthCheckBuilder = HealthCheck.Builder.get();
        HealthCheck healthCheck                = healthCheckBuilder.setAutoHealing(true)
                .setGracePeriod(120)
                .setUnhealthyDuration(120)
                .setType("EC2")
                .build();

        //Build tasks

        SimpleDateFormat formatter    = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String           dateInString = "2021-08-19T02:00:00Z";
        Date date         = null;
        try {
            date = formatter.parse(dateInString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        Tasks.Builder tasksBuilder = Tasks.Builder.get();
        Tasks tasks                = tasksBuilder
                //.setCronExpression("0 1 * * *") Optional
                .setFrequency(RecurrenceFrequencyEnum.DAILY)
                .setIsEnabled(true)
                .setStartTime(date)
                .setTaskType(SchedulingTaskTypeEnum.PAUSE)
                .build();

        List<Tasks> tasksList           = Collections.singletonList(tasks);

        //Build scheduling
        Scheduling.Builder schedulingBuilder = Scheduling.Builder.get();
        Scheduling scheduling                = schedulingBuilder.setTasks(tasksList).build();

        //Build integrations
        Integrations.Builder integrationsBuilder = Integrations.Builder.get();
        Integrations integrations                = integrationsBuilder
                //.setLoadBalancersConfig(loadBalancersConfig)
                .setRoute53(route53)
                .build();

        //Build revertToSpot
        RevertToSpot.Builder revertToSpotBuilder = RevertToSpot.Builder.get();
        RevertToSpot revertToSpot                = revertToSpotBuilder.setPerformAt(PerformAtEnumGcp.never).build();

        //Build strategy
        Strategy.Builder strategyBuilder = Strategy.Builder.get();
        Strategy strategy                = strategyBuilder
                .setOptimizationWindows(null)
                .setUtilizeReservedInstances(false)
                .setOrientation("costOriented")
                .setLifeCycle("spot")
                .setFallbackToOd(true)
                .setDrainingTimeout(120)
                .setRevertToSpot(revertToSpot)
                .build();


        //Build managedInstance
        ManagedInstance.Builder managedInstanceBuilder = ManagedInstance.Builder.get();
        ManagedInstance managedInstance                = managedInstanceBuilder
                .setName("MyManagedInstance")
                .setDescription("Automation Testing")
                .setRegion("us-west-2")
                .setStrategy(strategy)
                .setIntegrations(integrations)
                .setPersistence(persistence)
                .setHealthCheck(healthCheck)
                .setCompute(compute)
                .setScheduling(scheduling)
                .build();


        AwsManagedInstanceRequest.Builder managedInstanceCreationRequestBuilder =
                AwsManagedInstanceRequest.Builder.get();

        // Build managed instance creation request
        AwsManagedInstanceRequest managedInstanceCreationRequest =
                managedInstanceCreationRequestBuilder.setManagedInstance(managedInstance).build();

        // Convert managed instance request to API object json
        System.out.println(managedInstanceCreationRequest.toJson());

        // Create managed instance
        ManagedInstance createdManagedInstance = client.createManagedInstance(managedInstanceCreationRequest);
        String                     managedInstanceId      = createdManagedInstance.getId();
        System.out.println(String.format("ManagedInstance successfully created: %s", managedInstanceId));

        return managedInstanceId;
    }

    private static Boolean updateManagedInstanceName(SpotAwsManagedInstanceClient client, String managedInstanceId) {
        //Build ManagedInstance
        ManagedInstance.Builder managedInstanceBuilder = ManagedInstance.Builder.get();
        ManagedInstance managedInstance = managedInstanceBuilder.setName("RenameManagedInstance").build();
        AwsManagedInstanceRequest.Builder managedInstanceUpdateRequestBuilder =
                AwsManagedInstanceRequest.Builder.get();

        // Build managedInstance request
        AwsManagedInstanceRequest managedInstanceUpdateRequest =
                managedInstanceUpdateRequestBuilder.setManagedInstance(managedInstance).build();

        // Update managedInstance
        Boolean isManagedInstanceUpdated = client.updateManagedInstance(managedInstanceUpdateRequest, managedInstanceId);

        if (isManagedInstanceUpdated) {
            System.out.println(String.format("ManagedInstance successfully updated: %s", managedInstanceId));
        }
        return isManagedInstanceUpdated;
    }

    private static Boolean updateManagedInstance(SpotAwsManagedInstanceClient client, String managedInstanceId) {

        //Build HealthCheck
        HealthCheck.Builder healthCheckBuilder = HealthCheck.Builder.get();
        HealthCheck healthCheck                = healthCheckBuilder.setGracePeriod(160)
                .setAutoHealing(true)
                .setUnhealthyDuration(180)
                .setType("EC2")
                .build();

        //Build tasks
        Tasks.Builder tasksBuilder = Tasks.Builder.get();
        Tasks tasks                = tasksBuilder
                //.setCronExpression("0 * 12 * *") Optional
                .setFrequency(RecurrenceFrequencyEnum.DAILY)
                .setIsEnabled(true)
                .setTaskType(SchedulingTaskTypeEnum.RECYCLE)
                .build();

        List<Tasks> tasksList           = Collections.singletonList(tasks);

        //Build scheduling
        Scheduling.Builder schedulingBuilder = Scheduling.Builder.get();
        Scheduling scheduling                = schedulingBuilder.setTasks(tasksList).build();

        // Build managedInstance
        ManagedInstance.Builder managedInstanceBuilder = ManagedInstance.Builder.get();
        ManagedInstance managedInstance = managedInstanceBuilder.setName("TestManagedInstance")
                .setHealthCheck(healthCheck)
                .setScheduling(scheduling)
                .build();
        AwsManagedInstanceRequest.Builder managedInstanceUpdateRequestBuilder =
                AwsManagedInstanceRequest.Builder.get();

        // Build managed instance request
        AwsManagedInstanceRequest managedInstanceUpdateRequest =
                managedInstanceUpdateRequestBuilder.setManagedInstance(managedInstance).build();

        // Convert managed instance request to API object json
        System.out.println(managedInstanceUpdateRequest.toJson());

        // Update managedInstance
        Boolean isManagedInstanceUpdated = client.updateManagedInstance(managedInstanceUpdateRequest, managedInstanceId);

        if (isManagedInstanceUpdated) {
            System.out.println(String.format("Managed instance successfully updated: %s", managedInstanceId));
        }
        return isManagedInstanceUpdated;
    }


    private static ManagedInstance getManagedInstance(SpotAwsManagedInstanceClient client, String managedInstanceId) {
        AwsManagedInstanceRequest.Builder getBuilder = AwsManagedInstanceRequest.Builder.get();
        AwsManagedInstanceRequest getRequest = getBuilder.setManagedInstanceId(managedInstanceId).build();

        ManagedInstance managedInstance = client.getManagedInstance(getRequest);

        if (managedInstance != null) {
            System.out.println("Get managedinstance successful: " + managedInstance.getId());
        }
        return managedInstance;
    }

    private static List<ManagedInstance> listManagedInstance(SpotAwsManagedInstanceClient client) {
        return client.getAllManagedInstances();
    }

    private static Boolean pauseManagedInstance(SpotAwsManagedInstanceClient client, String managedInstanceId) {
        AwsManagedInstanceRequest.Builder pauseBuilder       = AwsManagedInstanceRequest.Builder.get();
        AwsManagedInstanceRequest pauseRequest       =
                pauseBuilder.setManagedInstanceId(managedInstanceId).build();
        Boolean                                  isManagedInstancePaused = client.pauseManagedInstance(pauseRequest);

        if (isManagedInstancePaused) {
            System.out.println(String.format("ManagedInstance paused successfully : %s", managedInstanceId));
        }
        return isManagedInstancePaused;
    }

    private static Boolean resumeManagedInstance(SpotAwsManagedInstanceClient client, String managedInstanceId) {
        AwsManagedInstanceRequest.Builder resumeBuilder       = AwsManagedInstanceRequest.Builder.get();
        AwsManagedInstanceRequest resumeRequest       =
                resumeBuilder.setManagedInstanceId(managedInstanceId).build();
        Boolean                                  isManagedInstanceResumed = client.resumeManagedInstance(resumeRequest);

        if (isManagedInstanceResumed) {
            System.out.println(String.format("ManagedInstance resumed successfully : %s", managedInstanceId));
        }
        return isManagedInstanceResumed;
    }

    private static Boolean recycleManagedInstance(SpotAwsManagedInstanceClient client, String managedInstanceId) {
        AwsManagedInstanceRequest.Builder recycleBuilder       = AwsManagedInstanceRequest.Builder.get();
        AwsManagedInstanceRequest recycleRequest       =
                recycleBuilder.setManagedInstanceId(managedInstanceId).build();
        Boolean                                  isManagedInstanceRecycled = client.recycleManagedInstance(recycleRequest);

        if (isManagedInstanceRecycled) {
            System.out.println(String.format("ManagedInstance recycled successfully : %s", managedInstanceId));
        }
        return isManagedInstanceRecycled;
    }

    private static Boolean deleteManagedInstance(SpotAwsManagedInstanceClient client, String managedInstanceId) {
        //Build Ami Backup
        AmiBackup.Builder amiBackupBuilder = AmiBackup.Builder.get();
        AmiBackup         amiBackup        = amiBackupBuilder.setShouldDeleteImages(true).build();

        //Build deallocation config
        DeallocationConfig.Builder deallocationConfigBuilder = DeallocationConfig.Builder.get();
        DeallocationConfig deallocationConfig        =
                deallocationConfigBuilder.setShouldTerminateInstance(true)
                        .setShouldDeleteVolumes(true)
                        .setShouldDeleteSnapshots(true)
                        .setShouldDeleteNetworkInterfaces(true)
                        .setShouldDeleteImages(true)
                        .build();

        AwsManagedInstanceDeletionRequest.Builder deleteBuilder       = AwsManagedInstanceDeletionRequest.Builder.get();
        AwsManagedInstanceDeletionRequest deleteRequest       =
                deleteBuilder.setDeallocationConfig(deallocationConfig)
                        .setAmiBackup(amiBackup)
                        .setManagedInstanceId(managedInstanceId)
                        .build();
        Boolean                                  isManagedInstanceDeleted = client.deleteManagedInstance(deleteRequest);

        if (isManagedInstanceDeleted) {
            System.out.println(String.format("ManagedInstance deleted successfully : %s", managedInstanceId));
        }
        return isManagedInstanceDeleted;
    }
}
