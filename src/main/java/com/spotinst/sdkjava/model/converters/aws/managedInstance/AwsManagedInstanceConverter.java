package com.spotinst.sdkjava.model.converters.aws.managedInstance;

import com.spotinst.sdkjava.enums.SchedulingTaskTypeEnum;
import com.spotinst.sdkjava.enums.RecurrenceFrequencyEnum;
import com.spotinst.sdkjava.model.api.aws.managedInstance.*;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.*;

import java.util.List;
import java.util.stream.Collectors;

public class AwsManagedInstanceConverter {
    //region BL -> DAL

    public static ApiManagedInstance toDal(ManagedInstance managedInstance) {
        ApiManagedInstance retVal = null;

        if (managedInstance != null) {
            retVal = new ApiManagedInstance();

            if (managedInstance.isComputeSet()) {
                ApiCompute compute = toDal(managedInstance.getCompute());
                retVal.setCompute(compute);
            }

            if (managedInstance.isDescriptionSet()) {
                retVal.setDescription(managedInstance.getDescription());
            }

            if (managedInstance.isHealthCheckSet()) {
                ApiHealthCheck healthCheck = toDal(managedInstance.getHealthCheck());
                retVal.setHealthCheck(healthCheck);
            }

            if (managedInstance.isIntegrationsSet()) {
                ApiIntegrations integrations = toDal(managedInstance.getIntegrations());
                retVal.setIntegrations(integrations);
            }

            if (managedInstance.isNameSet()) {
                retVal.setName(managedInstance.getName());
            }

            if (managedInstance.isPersistenceSet()) {
                ApiPersistence persistence = toDal(managedInstance.getPersistence());
                retVal.setPersistence(persistence);
            }

            if (managedInstance.isRegionSet()) {
                retVal.setRegion(managedInstance.getRegion());
            }

            if (managedInstance.isSchedulingSet()) {
                ApiScheduling scheduling = toDal(managedInstance.getScheduling());
                retVal.setScheduling(scheduling);
            }

            if (managedInstance.isStrategySet()) {
                ApiStrategy strategy = toDal(managedInstance.getStrategy());
                retVal.setStrategy(strategy);
            }

            if (managedInstance.isIdSet()) {
                retVal.setId(managedInstance.getId());
            }

        }
        return retVal;
    }

    public static ApiAmiBackup toDal(AmiBackup amiBackup) {
        ApiAmiBackup retVal = null;

        if (amiBackup != null) {
            retVal = new ApiAmiBackup();

            if (amiBackup.isShouldDeleteImagesSet()) {
                retVal.setShouldDeleteImages(amiBackup.getShouldDeleteImages());
            }
        }
        return retVal;
    }

    private static ApiBlockDeviceMappings toDal(BlockDeviceMappings blockDeviceMappings) {
        ApiBlockDeviceMappings retVal = null;

        if (blockDeviceMappings != null) {
            retVal = new ApiBlockDeviceMappings();

            if (blockDeviceMappings.isDeviceNameSet()) {
                retVal.setDeviceName(blockDeviceMappings.getDeviceName());
            }

            if (blockDeviceMappings.isEbsSet()) {
                ApiEbs ebs = toDal(blockDeviceMappings.getEbs());
                retVal.setEbs(ebs);
            }
        }
        return retVal;
    }

    private static ApiCompute toDal(Compute compute) {
        ApiCompute retVal = null;

        if (compute != null) {
            retVal = new ApiCompute();

            if (compute.isElasticIpSet()) {
                retVal.setElasticIp(compute.getElasticIp());
            }

            if (compute.isLaunchSpecificationSet()) {
                ApiLaunchSpecification launchSpecification = toDal(compute.getLaunchSpecification());
                retVal.setLaunchSpecification(launchSpecification);
            }

            if (compute.isPrivateIpSet()) {
                retVal.setPrivateIp(compute.getPrivateIp());
            }

            if (compute.isProductSet()) {
                retVal.setProduct(compute.getProduct());
            }

            if (compute.isSubnetIdsSet()) {
                retVal.setSubnetIds(compute.getSubnetIds());
            }

            if (compute.isVpcIdSet()) {
                retVal.setVpcId(compute.getVpcId());
            }
        }
        return retVal;
    }

    private static ApiCreditSpecification toDal(CreditSpecification creditSpecification) {
        ApiCreditSpecification retVal = null;

        if (creditSpecification != null) {
            retVal = new ApiCreditSpecification();

            if (creditSpecification.isCpuCreditsSet()) {
                retVal.setCpuCredits(creditSpecification.getCpuCredits());
            }
        }
        return retVal;
    }

    public static ApiDeallocationConfig toDal(DeallocationConfig deallocationConfig) {
        ApiDeallocationConfig retVal = null;

        if (deallocationConfig != null) {
            retVal = new ApiDeallocationConfig();

            if (deallocationConfig.isShouldDeleteImagesSet()) {
                retVal.setShouldDeleteImages(deallocationConfig.getShouldDeleteImages());
            }

            if (deallocationConfig.isShouldDeleteNetworkInterfacesSet()) {
                retVal.setShouldDeleteNetworkInterfaces(deallocationConfig.getShouldDeleteNetworkInterfaces());
            }

            if (deallocationConfig.isShouldDeleteSnapshotsSet()) {
                retVal.setShouldDeleteSnapshots(deallocationConfig.getShouldDeleteSnapshots());
            }

            if (deallocationConfig.isShouldDeleteVolumesSet()) {
                retVal.setShouldDeleteVolumes(deallocationConfig.getShouldDeleteVolumes());
            }

            if (deallocationConfig.isShouldTerminateInstanceSet()) {
                retVal.setShouldTerminateInstance(deallocationConfig.getShouldTerminateInstance());
            }
        }
        return retVal;
    }

    private static ApiDomains toDal(Domains domains) {
        ApiDomains retVal = null;

        if (domains != null) {
            retVal = new ApiDomains();

            if (domains.isHostedZoneIdSet()) {
                retVal.setHostedZoneId(domains.getHostedZoneId());
            }

            if (domains.isRecordSetTypeSet()) {
                retVal.setRecordSetType(domains.getRecordSetType());
            }

            if (domains.isSpotinstAccountIdSet()) {
                retVal.setSpotinstAccountId(domains.getSpotinstAccountId());
            }

            if (domains.isRecordSetsSet()) {
                List<ApiRecordSets> recordSets =
                        domains.getRecordSets().stream().map(AwsManagedInstanceConverter::toDal)
                                .collect(Collectors.toList());
                retVal.setRecordSets(recordSets);
            }
        }
        return retVal;
    }

    private static ApiEbs toDal(Ebs ebs) {
        ApiEbs retVal = null;

        if (ebs != null) {
            retVal = new ApiEbs();

            if (ebs.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(ebs.getDeleteOnTermination());
            }

            if (ebs.isIopsSet()) {
                retVal.setIops(ebs.getIops());
            }

            if (ebs.isThroughputSet()) {
                retVal.setThroughput(ebs.getThroughput());
            }

            if (ebs.isVolumeSizeSet()) {
                retVal.setVolumeSize(ebs.getVolumeSize());
            }

            if (ebs.isVolumeTypeSet()) {
                retVal.setVolumeType(ebs.getVolumeType());
            }
        }
        return retVal;
    }

    private static ApiHealthCheck toDal(HealthCheck healthCheck) {
        ApiHealthCheck retVal = null;

        if (healthCheck != null) {
            retVal = new ApiHealthCheck();

            if (healthCheck.isAutoHealingSet()) {
                retVal.setAutoHealing(healthCheck.getAutoHealing());
            }

            if (healthCheck.isGracePeriodSet()) {
                retVal.setGracePeriod(healthCheck.getGracePeriod());
            }

            if (healthCheck.isTypeSet()) {
                retVal.setType(healthCheck.getType());
            }

            if (healthCheck.isUnhealthyDurationSet()) {
                retVal.setUnhealthyDuration(healthCheck.getUnhealthyDuration());
            }
        }
        return retVal;
    }

    private static ApiIamRole toDal(IamRole iamRole) {
        ApiIamRole retVal = null;

        if (iamRole != null) {
            retVal = new ApiIamRole();

            if (iamRole.isArnSet()) {
                retVal.setArn(iamRole.getArn());
            }

            if (iamRole.isNameSet()) {
                retVal.setName(iamRole.getName());
            }
        }
        return retVal;
    }

    private static ApiInstanceTypes toDal(InstanceTypes instanceTypes) {
        ApiInstanceTypes retVal = null;

        if (instanceTypes != null) {
            retVal = new ApiInstanceTypes();

            if (instanceTypes.isPreferredTypeSet()) {
                retVal.setPreferredType(instanceTypes.getPreferredType());
            }

            if (instanceTypes.isTypesSet()) {
                retVal.setTypes(instanceTypes.getTypes());
            }
        }
        return retVal;
    }

    private static ApiIntegrations toDal(Integrations integrations) {
        ApiIntegrations retVal = null;

        if (integrations != null) {
            retVal = new ApiIntegrations();

            if (integrations.isLoadBalancersConfigSet()) {
                ApiLoadBalancersConfig loadBalancersConfig = toDal(integrations.getLoadBalancersConfig());
                retVal.setLoadBalancersConfig(loadBalancersConfig);
            }

            if (integrations.isRoute53Set()) {
                ApiRoute53 route53 = toDal(integrations.getRoute53());
                retVal.setRoute53(route53);
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecification toDal(LaunchSpecification launchSpecification) {
        ApiLaunchSpecification retVal = null;

        if (launchSpecification != null) {
            retVal = new ApiLaunchSpecification();

            if (launchSpecification.isBlockDeviceMappingsSet()) {
                List<ApiBlockDeviceMappings> blockDeviceMappings =
                        launchSpecification.getBlockDeviceMappings().stream().map(AwsManagedInstanceConverter::toDal)
                                .collect(Collectors.toList());
                retVal.setBlockDeviceMappings(blockDeviceMappings);
            }

            if (launchSpecification.isCreditSpecificationSet()) {
                ApiCreditSpecification creditSpecification= toDal(launchSpecification.getCreditSpecification());
                retVal.setCreditSpecification(creditSpecification);
            }

            if (launchSpecification.isEbsOptimizedSet()) {
                retVal.setEbsOptimized(launchSpecification.getEbsOptimized());
            }

            if (launchSpecification.isIamRoleSet()) {
                ApiIamRole iamRole = toDal(launchSpecification.getIamRole());
                retVal.setIamRole(iamRole);
            }

            if (launchSpecification.isImageIdSet()) {
                retVal.setImageId(launchSpecification.getImageId());
            }

            if (launchSpecification.isInstanceTypesSet()) {
                ApiInstanceTypes instanceTypes = toDal(launchSpecification.getInstanceTypes());
                retVal.setInstanceTypes(instanceTypes);
            }

            if (launchSpecification.isKeyPairSet()) {
                retVal.setKeyPair(launchSpecification.getKeyPair());
            }

            if (launchSpecification.isMonitoringSet()) {
                retVal.setMonitoring(launchSpecification.getMonitoring());
            }

            if (launchSpecification.isNetworkInterfacesSet()) {
                List<ApiNetworkInterfaces> networkInterfaces =
                        launchSpecification.getNetworkInterfaces().stream().map(AwsManagedInstanceConverter::toDal)
                                .collect(Collectors.toList());
                retVal.setNetworkInterfaces(networkInterfaces);
            }

            if (launchSpecification.isResourceTagSpecificationSet()) {
                ApiResourceTagSpecification resourceTagSpecification = toDal(launchSpecification.getResourceTagSpecification());
                retVal.setResourceTagSpecification(resourceTagSpecification);
            }

            if (launchSpecification.isSecurityGroupIdsSet()) {
                retVal.setSecurityGroupIds(launchSpecification.getSecurityGroupIds());
            }

            if (launchSpecification.isShutdownScriptSet()) {
                retVal.setShutdownScript(launchSpecification.getShutdownScript());
            }

            if (launchSpecification.isTagsSet()) {
                List<ApiTags> tags =
                        launchSpecification.getTags().stream().map(AwsManagedInstanceConverter::toDal)
                                .collect(Collectors.toList());
                retVal.setTags(tags);
            }

            if (launchSpecification.isTenancySet()) {
                retVal.setTenancy(launchSpecification.getTenancy());
            }

            if (launchSpecification.isUserDataSet()) {
                retVal.setUserData(launchSpecification.getUserData());
            }

        }
        return retVal;
    }

    private static ApiLoadBalancers toDal(LoadBalancers loadBalancers) {
        ApiLoadBalancers retVal = null;

        if (loadBalancers != null) {
            retVal = new ApiLoadBalancers();

            if (loadBalancers.isArnSet()) {
                retVal.setArn(loadBalancers.getArn());
            }

            if (loadBalancers.isAutoWeightSet()) {
                retVal.setAutoWeight(loadBalancers.getAutoWeight());
            }

            if (loadBalancers.isAzAwarenessSet()) {
                retVal.setAzAwareness(loadBalancers.getAzAwareness());
            }

            if (loadBalancers.isBalancerIdSet()) {
                retVal.setBalancerId(loadBalancers.getBalancerId());
            }

            if (loadBalancers.isNameSet()) {
                retVal.setName(loadBalancers.getName());
            }

            if (loadBalancers.isTargetSetIdSet()) {
                retVal.setTargetSetId(loadBalancers.getTargetSetId());
            }

            if (loadBalancers.isTypeSet()) {
                retVal.setType(loadBalancers.getType());
            }
        }
        return retVal;
    }

    private static ApiLoadBalancersConfig toDal(LoadBalancersConfig loadBalancersConfig) {
        ApiLoadBalancersConfig retVal = null;

        if (loadBalancersConfig != null) {
            retVal = new ApiLoadBalancersConfig();

            if (loadBalancersConfig.isLoadBalancersSet()) {
                List<ApiLoadBalancers> loadBalancers =
                        loadBalancersConfig.getLoadBalancers().stream().map(AwsManagedInstanceConverter::toDal)
                                .collect(Collectors.toList());
                retVal.setLoadBalancers(loadBalancers);
            }
        }
        return retVal;
    }

    private static ApiNetworkInterfaces toDal(NetworkInterfaces networkInterfaces) {
        ApiNetworkInterfaces retVal = null;

        if (networkInterfaces != null) {
            retVal = new ApiNetworkInterfaces();

            if (networkInterfaces.isAssociateIpv6AddressSet()) {
                retVal.setAssociateIpv6Address(networkInterfaces.getAssociateIpv6Address());
            }

            if (networkInterfaces.isAssociatePublicIpAddressSet()) {
                retVal.setAssociatePublicIpAddress(networkInterfaces.getAssociatePublicIpAddress());
            }

            if (networkInterfaces.isDeviceIndexSet()) {
                retVal.setDeviceIndex(networkInterfaces.getDeviceIndex());
            }
        }
        return retVal;
    }

    private static ApiPersistence toDal(Persistence persistence) {
        ApiPersistence retVal = null;

        if (persistence != null) {
            retVal = new ApiPersistence();

            if (persistence.isBlockDevicesModeSet()) {
                retVal.setBlockDevicesMode(persistence.getBlockDevicesMode());
            }

            if (persistence.isPersistBlockDevicesSet()) {
                retVal.setPersistBlockDevices(persistence.getPersistBlockDevices());
            }

            if (persistence.isPersistPrivateIpSet()) {
                retVal.setPersistPrivateIp(persistence.getPersistPrivateIp());
            }

            if (persistence.isPersistRootDeviceSet()) {
                retVal.setPersistRootDevice(persistence.getPersistRootDevice());
            }
        }
        return retVal;
    }

    private static ApiRecordSets toDal(RecordSets recordSets) {
        ApiRecordSets retVal = null;

        if (recordSets != null) {
            retVal = new ApiRecordSets();

            if (recordSets.isNameSet()) {
                retVal.setName(recordSets.getName());
            }

            if (recordSets.isUsePublicIpSet()) {
                retVal.setUsePublicIp(recordSets.getUsePublicIp());
            }
        }
        return retVal;
    }

    private static ApiResourceTagSpecification toDal(ResourceTagSpecification resourceTagSpecification) {
        ApiResourceTagSpecification retVal = null;

        if (resourceTagSpecification != null) {
            retVal = new ApiResourceTagSpecification();

            if (resourceTagSpecification.isVolumeSet()) {
                ApiTagSpecification tagSpecification = toDal(resourceTagSpecification.getVolumes());
                retVal.setVolumes(tagSpecification);
            }

            if (resourceTagSpecification.isSnapshotSet()) {
                ApiTagSpecification tagSpecification = toDal(resourceTagSpecification.getSnapshots());
                retVal.setSnapshots(tagSpecification);
            }

            if (resourceTagSpecification.isEniSet()) {
                ApiTagSpecification tagSpecification = toDal(resourceTagSpecification.getEnis());
                retVal.setEnis(tagSpecification);
            }

            if (resourceTagSpecification.isAmiSet()) {
                ApiTagSpecification tagSpecification = toDal(resourceTagSpecification.getAmis());
                retVal.setAmis(tagSpecification);
            }
        }
        return retVal;
    }

    private static ApiRevertToSpot toDal(RevertToSpot revertToSpot) {
        ApiRevertToSpot retVal = null;

        if (revertToSpot != null) {
            retVal = new ApiRevertToSpot();

            if (revertToSpot.isPerformAtSet()) {
                retVal.setPerformAt(revertToSpot.getPerformAt());
            }
        }
        return retVal;
    }

    private static ApiRoute53 toDal(Route53 route53) {
        ApiRoute53 retVal = null;

        if (route53 != null) {
            retVal = new ApiRoute53();

            if (route53.isDomainsSet()) {
                List<ApiDomains> domains =
                        route53.getDomains().stream().map(AwsManagedInstanceConverter::toDal)
                                .collect(Collectors.toList());
                retVal.setDomains(domains);
            }
        }
        return retVal;
    }

    private static ApiScheduling toDal(Scheduling scheduling) {
        ApiScheduling retVal = null;

        if (scheduling != null) {
            retVal = new ApiScheduling();

            if (scheduling.isTasksSet()) {
                List<ApiTasks> tasks =
                        scheduling.getTasks().stream().map(AwsManagedInstanceConverter::toDal)
                                .collect(Collectors.toList());
                retVal.setTasks(tasks);
            }
        }
        return retVal;
    }

    private static ApiStrategy toDal(Strategy strategy) {
        ApiStrategy retVal = null;

        if (strategy != null) {
            retVal = new ApiStrategy();

            if (strategy.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(strategy.getDrainingTimeout());
            }

            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }

            if (strategy.isLifeCycleSet()) {
                retVal.setLifeCycle(strategy.getLifeCycle());
            }

            if (strategy.isOptimizationWindowsSet()) {
                retVal.setOptimizationWindows(strategy.getOptimizationWindows());
            }

            if (strategy.isOrientationSet()) {
                retVal.setOrientation(strategy.getOrientation());
            }

            if (strategy.isRevertToSpotSet()) {
                ApiRevertToSpot revertToSpot = toDal(strategy.getRevertToSpot());
                retVal.setRevertToSpot(revertToSpot);
            }

            if (strategy.isUtilizeReservedInstancesSet()) {
                retVal.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }
        }
        return retVal;
    }

    private static ApiTags toDal(Tags tags) {
        ApiTags retVal = null;

        if (tags != null) {
            retVal = new ApiTags();

            if (tags.isTagKeySet()) {
                retVal.setTagKey(tags.getTagKey());
            }

            if (tags.isTagValueSet()) {
                retVal.setTagValue(tags.getTagValue());
            }
        }
        return retVal;
    }

    private static ApiTagSpecification toDal(TagSpecification tagSpecification) {
        ApiTagSpecification retVal = null;

        if (tagSpecification != null) {
            retVal = new ApiTagSpecification();

            if (tagSpecification.isShouldTagSet()) {
                retVal.setShouldTag(tagSpecification.getShouldTag());
            }
        }
        return retVal;
    }

    private static ApiTasks toDal(Tasks tasks) {
        ApiTasks retVal = null;

        if (tasks != null) {
            retVal = new ApiTasks();

            if (tasks.isCronExpressionSet()) {
                retVal.setCronExpression(tasks.getCronExpression());
            }

            if (tasks.isFrequencySet()) {
                retVal.setFrequency(tasks.getFrequency().getName());
            }

            if (tasks.isIsEnabledSet()) {
                retVal.setIsEnabled(tasks.getIsEnabled());
            }

            if (tasks.isStartTimeSet()) {
                retVal.setStartTime(tasks.getStartTime());
            }

            if (tasks.isTaskTypeSet()) {
                retVal.setTaskType(tasks.getTaskType().getName());
            }
        }
        return retVal;
    }

    //region DAL ->
    public static ManagedInstance toBl(ApiManagedInstance managedInstance) {
        ManagedInstance retVal = null;

        if (managedInstance != null) {
            ManagedInstance.Builder managedInstanceBuilder = ManagedInstance.Builder.get();

            if (managedInstance.isDescriptionSet()) {
                managedInstanceBuilder.setDescription(managedInstance.getDescription());
            }

            if (managedInstance.isComputeSet()) {
                managedInstanceBuilder.setCompute(toBl(managedInstance.getCompute()));
            }

            if (managedInstance.isHealthCheckSet()) {
                managedInstanceBuilder.setHealthCheck(toBl(managedInstance.getHealthCheck()));
            }

            if (managedInstance.isIntegrationsSet()) {
                managedInstanceBuilder.setIntegrations(toBl(managedInstance.getIntegrations()));
            }

            if (managedInstance.isNameSet()) {
                managedInstanceBuilder.setName(managedInstance.getName());
            }

            if (managedInstance.isPersistenceSet()) {
                managedInstanceBuilder.setPersistence(toBl(managedInstance.getPersistence()));
            }

            if (managedInstance.isRegionSet()) {
                managedInstanceBuilder.setRegion(managedInstance.getRegion());
            }

            if (managedInstance.isSchedulingSet()) {
                managedInstanceBuilder.setScheduling(toBl(managedInstance.getScheduling()));
            }

            if (managedInstance.isStrategySet()) {
                managedInstanceBuilder.setStrategy(toBl(managedInstance.getStrategy()));
            }

            if (managedInstance.isIdSet()) {
                managedInstanceBuilder.setId(managedInstance.getId());
            }

            retVal = managedInstanceBuilder.build();
        }
        return retVal;
    }

    public static AmiBackup toBl(ApiAmiBackup amiBackup) {
        AmiBackup retVal = null;

        if (amiBackup != null) {
            AmiBackup.Builder amiBackupBuilder = AmiBackup.Builder.get();

            if (amiBackup.isShouldDeleteImagesSet()) {
                amiBackupBuilder.setShouldDeleteImages(amiBackup.getShouldDeleteImages());
            }
            retVal = amiBackupBuilder.build();
        }
        return retVal;
    }

    public static BlockDeviceMappings toBl(ApiBlockDeviceMappings blockDeviceMappings) {
        BlockDeviceMappings retVal = null;

        if (blockDeviceMappings != null) {
            BlockDeviceMappings.Builder blockDeviceMappingsBuilder = BlockDeviceMappings.Builder.get();

            if (blockDeviceMappings.isDeviceNameSet()) {
                blockDeviceMappingsBuilder.setDeviceName(blockDeviceMappings.getDeviceName());
            }

            if (blockDeviceMappings.isEbsSet()) {
                blockDeviceMappingsBuilder.setEbs(toBl(blockDeviceMappings.getEbs()));
            }
            retVal = blockDeviceMappingsBuilder.build();
        }
        return retVal;
    }

    public static Compute toBl(ApiCompute compute) {
        Compute retVal = null;

        if (compute != null) {
            Compute.Builder computeBuilder = Compute.Builder.get();

            if (compute.isElasticIpSet()) {
                computeBuilder.setElasticIp(compute.getElasticIp());
            }

            if (compute.isLaunchSpecificationSet()) {
                computeBuilder.setLaunchSpecification(toBl(compute.getLaunchSpecification()));
            }

            if (compute.isPrivateIpSet()) {
                computeBuilder.setPrivateIp(compute.getPrivateIp());
            }

            if (compute.isProductSet()) {
                computeBuilder.setProduct(compute.getProduct());
            }

            if (compute.isSubnetIdsSet()) {
                computeBuilder.setSubnetIds(compute.getSubnetIds());
            }

            if (compute.isVpcIdSet()) {
                computeBuilder.setVpcId(compute.getVpcId());
            }
            retVal = computeBuilder.build();
        }
        return retVal;
    }

    public static CreditSpecification toBl(ApiCreditSpecification creditSpecification) {
        CreditSpecification retVal = null;

        if (creditSpecification != null) {
            CreditSpecification.Builder creditSpecificationBuilder = CreditSpecification.Builder.get();

            if (creditSpecification.isCpuCreditsSet()) {
                creditSpecificationBuilder.setCpuCredits(creditSpecification.getCpuCredits());
            }
            retVal = creditSpecificationBuilder.build();
        }
        return retVal;
    }

    public static DeallocationConfig toBl(ApiDeallocationConfig deallocationConfig) {
        DeallocationConfig retVal = null;

        if (deallocationConfig != null) {
            DeallocationConfig.Builder deallocationConfigBuilder = DeallocationConfig.Builder.get();

            if (deallocationConfig.isShouldDeleteImagesSet()) {
                deallocationConfigBuilder.setShouldDeleteImages(deallocationConfig.getShouldDeleteImages());
            }

            if (deallocationConfig.isShouldDeleteNetworkInterfacesSet()) {
                deallocationConfigBuilder.setShouldDeleteNetworkInterfaces(deallocationConfig.getShouldDeleteNetworkInterfaces());
            }

            if (deallocationConfig.isShouldDeleteSnapshotsSet()) {
                deallocationConfigBuilder.setShouldDeleteSnapshots(deallocationConfig.getShouldDeleteSnapshots());
            }

            if (deallocationConfig.isShouldDeleteVolumesSet()) {
                deallocationConfigBuilder.setShouldDeleteVolumes(deallocationConfig.getShouldDeleteVolumes());
            }

            if (deallocationConfig.isShouldTerminateInstanceSet()) {
                deallocationConfigBuilder.setShouldTerminateInstance(deallocationConfig.getShouldTerminateInstance());
            }
            retVal = deallocationConfigBuilder.build();
        }
        return retVal;
    }

    public static Domains toBl(ApiDomains domains) {
        Domains retVal = null;

        if (domains != null) {
            Domains.Builder domainsBuilder = Domains.Builder.get();

            if (domains.isHostedZoneIdSet()) {
                domainsBuilder.setHostedZoneId(domains.getHostedZoneId());
            }

            if (domains.isRecordSetsSet()) {
                List<RecordSets> recordSets =
                        domains.getRecordSets().stream().map(AwsManagedInstanceConverter::toBl)
                                .collect(Collectors.toList());
                domainsBuilder.setRecordSets(recordSets);
            }

            if (domains.isRecordSetTypeSet()) {
                domainsBuilder.setRecordSetType(domains.getRecordSetType());
            }

            if (domains.isSpotinstAccountIdSet()) {
                domainsBuilder.setSpotinstAccountId(domains.getSpotinstAccountId());
            }
            retVal = domainsBuilder.build();
        }
        return retVal;
    }

    public static Ebs toBl(ApiEbs ebs) {
        Ebs retVal = null;

        if (ebs != null) {
            Ebs.Builder ebsBuilder = Ebs.Builder.get();

            if (ebs.isDeleteOnTerminationSet()) {
                ebsBuilder.setDeleteOnTermination(ebs.getDeleteOnTermination());
            }

            if (ebs.isIopsSet()) {
                ebsBuilder.setIops(ebs.getIops());
            }

            if (ebs.isThroughputSet()) {
                ebsBuilder.setThroughput(ebs.getThroughput());
            }

            if (ebs.isVolumeSizeSet()) {
                ebsBuilder.setVolumeSize(ebs.getVolumeSize());
            }

            if (ebs.isVolumeTypeSet()) {
                ebsBuilder.setVolumeType(ebs.getVolumeType());
            }
            retVal = ebsBuilder.build();
        }
        return retVal;
    }

    public static HealthCheck toBl(ApiHealthCheck healthCheck) {
        HealthCheck retVal = null;

        if (healthCheck != null) {
            HealthCheck.Builder healthCheckBuilder = HealthCheck.Builder.get();

            if (healthCheck.isAutoHealingSet()) {
                healthCheckBuilder.setAutoHealing(healthCheck.getAutoHealing());
            }

            if (healthCheck.isGracePeriodSet()) {
                healthCheckBuilder.setGracePeriod(healthCheck.getGracePeriod());
            }

            if (healthCheck.isTypeSet()) {
                healthCheckBuilder.setType(healthCheck.getType());
            }

            if (healthCheck.isUnhealthyDurationSet()) {
                healthCheckBuilder.setUnhealthyDuration(healthCheck.getUnhealthyDuration());
            }
            retVal = healthCheckBuilder.build();
        }
        return retVal;
    }

    public static IamRole toBl(ApiIamRole iamRole) {
        IamRole retVal = null;

        if (iamRole != null) {
            IamRole.Builder iamRoleBuilder = IamRole.Builder.get();

            if (iamRole.isArnSet()) {
                iamRoleBuilder.setArn(iamRole.getArn());
            }

            if (iamRole.isNameSet()) {
                iamRoleBuilder.setName(iamRole.getName());
            }
            retVal = iamRoleBuilder.build();
        }
        return retVal;
    }

    public static InstanceTypes toBl(ApiInstanceTypes instanceTypes) {
        InstanceTypes retVal = null;

        if (instanceTypes != null) {
            InstanceTypes.Builder instanceTypesBuilder = InstanceTypes.Builder.get();

            if (instanceTypes.isPreferredTypeSet()) {
                instanceTypesBuilder.setPreferredType(instanceTypes.getPreferredType());
            }

            if (instanceTypes.isTypesSet()) {
                instanceTypesBuilder.setTypes(instanceTypes.getTypes());
            }
            retVal = instanceTypesBuilder.build();
        }
        return retVal;
    }

    public static Integrations toBl(ApiIntegrations integrations) {
        Integrations retVal = null;

        if (integrations != null) {
            Integrations.Builder integrationsBuilder = Integrations.Builder.get();

            if (integrations.isLoadBalancersConfigSet()) {
                integrationsBuilder.setLoadBalancersConfig(toBl(integrations.getLoadBalancersConfig()));
            }

            if (integrations.isRoute53Set()) {
                integrationsBuilder.setRoute53(toBl(integrations.getRoute53()));
            }
            retVal = integrationsBuilder.build();
        }
        return retVal;
    }

    public static LaunchSpecification toBl(ApiLaunchSpecification launchSpecification) {
        LaunchSpecification retVal = null;

        if (launchSpecification != null) {
            LaunchSpecification.Builder launchSpecificationBuilder = LaunchSpecification.Builder.get();

            if (launchSpecification.isKeyPairSet()) {
                launchSpecificationBuilder.setKeyPair(launchSpecification.getKeyPair());
            }

            if (launchSpecification.isBlockDeviceMappingsSet()) {
                List<BlockDeviceMappings> blockDeviceMappings =
                        launchSpecification.getBlockDeviceMappings().stream().map(AwsManagedInstanceConverter::toBl)
                                .collect(Collectors.toList());
                launchSpecificationBuilder.setBlockDeviceMappings(blockDeviceMappings);
            }

            if (launchSpecification.isCreditSpecificationSet()) {
                launchSpecificationBuilder.setCreditSpecification(toBl(launchSpecification.getCreditSpecification()));
            }

            if (launchSpecification.isEbsOptimizedSet()) {
                launchSpecificationBuilder.setEbsOptimized(launchSpecification.getEbsOptimized());
            }

            if (launchSpecification.isIamRoleSet()) {
                launchSpecificationBuilder.setIamRole(toBl(launchSpecification.getIamRole()));
            }

            if (launchSpecification.isImageIdSet()) {
                launchSpecificationBuilder.setImageId(launchSpecification.getImageId());
            }

            if (launchSpecification.isInstanceTypesSet()) {
                launchSpecificationBuilder.setInstanceTypes(toBl(launchSpecification.getInstanceTypes()));
            }

            if (launchSpecification.isMonitoringSet()) {
                launchSpecificationBuilder.setMonitoring(launchSpecification.getMonitoring());
            }

            if (launchSpecification.isNetworkInterfacesSet()) {
                List<NetworkInterfaces> networkInterfaces =
                        launchSpecification.getNetworkInterfaces().stream().map(AwsManagedInstanceConverter::toBl)
                                .collect(Collectors.toList());
                launchSpecificationBuilder.setNetworkInterfaces(networkInterfaces);
            }

            if (launchSpecification.isResourceTagSpecificationSet()) {
                launchSpecificationBuilder.setResourceTagSpecification(toBl(launchSpecification.getResourceTagSpecification()));
            }

            if (launchSpecification.isSecurityGroupIdsSet()) {
                launchSpecificationBuilder.setSecurityGroupIds(launchSpecification.getSecurityGroupIds());
            }

            if (launchSpecification.isShutdownScriptSet()) {
                launchSpecificationBuilder.setShutdownScript(launchSpecification.getShutdownScript());
            }

            if (launchSpecification.isTagsSet()) {
                List<Tags> tags = launchSpecification.getTags().stream().map(AwsManagedInstanceConverter::toBl)
                                .collect(Collectors.toList());
                launchSpecificationBuilder.setTags(tags);
            }

            if (launchSpecification.isTenancySet()) {
                launchSpecificationBuilder.setTenancy(launchSpecification.getTenancy());
            }

            if (launchSpecification.isUserDataSet()) {
                launchSpecificationBuilder.setUserData(launchSpecification.getUserData());
            }
            retVal = launchSpecificationBuilder.build();
        }

        return retVal;
    }

    public static LoadBalancers toBl(ApiLoadBalancers loadBalancers) {
        LoadBalancers retVal = null;

        if (loadBalancers != null) {
            LoadBalancers.Builder loadBalancersBuilder = LoadBalancers.Builder.get();

            if (loadBalancers.isArnSet()) {
                loadBalancersBuilder.setArn(loadBalancers.getArn());
            }

            if (loadBalancers.isAutoWeightSet()) {
                loadBalancersBuilder.setAutoWeight(loadBalancers.getAutoWeight());
            }

            if (loadBalancers.isAzAwarenessSet()) {
                loadBalancersBuilder.setAzAwareness(loadBalancers.getAzAwareness());
            }

            if (loadBalancers.isBalancerIdSet()) {
                loadBalancersBuilder.setBalancerId(loadBalancers.getBalancerId());
            }

            if (loadBalancers.isNameSet()) {
                loadBalancersBuilder.setName(loadBalancers.getName());
            }

            if (loadBalancers.isTargetSetIdSet()) {
                loadBalancersBuilder.setTargetSetId(loadBalancers.getTargetSetId());
            }

            if (loadBalancers.isTypeSet()) {
                loadBalancersBuilder.setType(loadBalancers.getType());
            }
            retVal = loadBalancersBuilder.build();
        }

        return retVal;
    }

    public static LoadBalancersConfig toBl(ApiLoadBalancersConfig loadBalancersConfig) {
        LoadBalancersConfig retVal = null;

        if (loadBalancersConfig != null) {
            LoadBalancersConfig.Builder loadBalancersConfigBuilder = LoadBalancersConfig.Builder.get();

            if (loadBalancersConfig.isLoadBalancersSet()) {
                List<LoadBalancers> loadBalancers =
                        loadBalancersConfig.getLoadBalancers().stream().map(AwsManagedInstanceConverter::toBl)
                                .collect(Collectors.toList());
                loadBalancersConfigBuilder.setLoadBalancers(loadBalancers);
            }
            retVal = loadBalancersConfigBuilder.build();
        }

        return retVal;
    }

    public static NetworkInterfaces toBl(ApiNetworkInterfaces networkInterfaces) {
        NetworkInterfaces retVal = null;

        if (networkInterfaces != null) {
            NetworkInterfaces.Builder networkInterfacesBuilder = NetworkInterfaces.Builder.get();

            if (networkInterfaces.isAssociateIpv6AddressSet()) {
                networkInterfacesBuilder.setAssociateIpv6Address(networkInterfaces.getAssociateIpv6Address());
            }

            if (networkInterfaces.isAssociatePublicIpAddressSet()) {
                networkInterfacesBuilder.setAssociatePublicIpAddress(networkInterfaces.getAssociatePublicIpAddress());
            }

            if (networkInterfaces.isDeviceIndexSet()) {
                networkInterfacesBuilder.setDeviceIndex(networkInterfaces.getDeviceIndex());
            }
            retVal = networkInterfacesBuilder.build();
        }

        return retVal;
    }

    public static Persistence toBl(ApiPersistence persistence) {
        Persistence retVal = null;

        if (persistence != null) {
            Persistence.Builder persistenceBuilder = Persistence.Builder.get();

            if (persistence.isBlockDevicesModeSet()) {
                persistenceBuilder.setBlockDevicesMode(persistence.getBlockDevicesMode());
            }

            if (persistence.isPersistBlockDevicesSet()) {
                persistenceBuilder.setPersistBlockDevices(persistence.getPersistBlockDevices());
            }

            if (persistence.isPersistPrivateIpSet()) {
                persistenceBuilder.setPersistPrivateIp(persistence.getPersistPrivateIp());
            }

            if (persistence.isPersistRootDeviceSet()) {
                persistenceBuilder.setPersistRootDevice(persistence.getPersistRootDevice());
            }
            retVal = persistenceBuilder.build();
        }

        return retVal;
    }

    public static RecordSets toBl(ApiRecordSets recordSets) {
        RecordSets retVal = null;

        if (recordSets != null) {
            RecordSets.Builder recordSetsBuilder = RecordSets.Builder.get();

            if (recordSets.isNameSet()) {
                recordSetsBuilder.setName(recordSets.getName());
            }

            if (recordSets.isUsePublicIpSet()) {
                recordSetsBuilder.setUsePublicIp(recordSets.getUsePublicIp());
            }
            retVal = recordSetsBuilder.build();
        }

        return retVal;
    }

    public static ResourceTagSpecification toBl(ApiResourceTagSpecification resourceTagSpecification) {
        ResourceTagSpecification retVal = null;

        if (resourceTagSpecification != null) {
            ResourceTagSpecification.Builder resourceTagSpecificationBuilder = ResourceTagSpecification.Builder.get();

            if (resourceTagSpecification.isVolumeSet()) {
                resourceTagSpecificationBuilder.setTagVolume(toBl(resourceTagSpecification.getVolumes()));
            }

            if (resourceTagSpecification.isSnapshotSet()) {
                resourceTagSpecificationBuilder.setTagSnapshot(toBl(resourceTagSpecification.getSnapshots()));
            }

            if (resourceTagSpecification.isEniSet()) {
                resourceTagSpecificationBuilder.setTagEnis(toBl(resourceTagSpecification.getEnis()));
            }

            if (resourceTagSpecification.isAmiSet()) {
                resourceTagSpecificationBuilder.setTagAmis(toBl(resourceTagSpecification.getAmis()));
            }
            retVal = resourceTagSpecificationBuilder.build();
        }

        return retVal;
    }

    public static RevertToSpot toBl(ApiRevertToSpot revertToSpot) {
        RevertToSpot retVal = null;

        if (revertToSpot != null) {
            RevertToSpot.Builder revertToSpotBuilder = RevertToSpot.Builder.get();

            if (revertToSpot.isPerformAtSet()) {
                revertToSpotBuilder.setPerformAt(revertToSpot.getPerformAt());
            }
            retVal = revertToSpotBuilder.build();
        }

        return retVal;
    }

    public static Route53 toBl(ApiRoute53 route53) {
        Route53 retVal = null;

        if (route53 != null) {
            Route53.Builder route53Builder = Route53.Builder.get();

            if (route53.isDomainsSet()) {
                List<Domains> domains =
                        route53.getDomains().stream().map(AwsManagedInstanceConverter::toBl)
                                .collect(Collectors.toList());
                route53Builder.setDomains(domains);
            }
            retVal = route53Builder.build();
        }

        return retVal;
    }

    public static Scheduling toBl(ApiScheduling scheduling) {
        Scheduling retVal = null;

        if (scheduling != null) {
            Scheduling.Builder schedulingBuilder = Scheduling.Builder.get();

            if (scheduling.isTasksSet()) {

                List<Tasks> tasks =
                        scheduling.getTasks().stream().map(AwsManagedInstanceConverter::toBl)
                                .collect(Collectors.toList());
                schedulingBuilder.setTasks(tasks);
            }
            retVal = schedulingBuilder.build();
        }

        return retVal;
    }

    public static Strategy toBl(ApiStrategy strategy) {
        Strategy retVal = null;

        if (strategy != null) {
            Strategy.Builder strategyBuilder = Strategy.Builder.get();

            if (strategy.isDrainingTimeoutSet()) {
                strategyBuilder.setDrainingTimeout(strategy.getDrainingTimeout());
            }

            if (strategy.isFallbackToOdSet()) {
                strategyBuilder.setFallbackToOd(strategy.getFallbackToOd());
            }

            if (strategy.isLifeCycleSet()) {
                strategyBuilder.setLifeCycle(strategy.getLifeCycle());
            }

            if (strategy.isOptimizationWindowsSet()) {
                strategyBuilder.setOptimizationWindows(strategy.getOptimizationWindows());
            }

            if (strategy.isOrientationSet()) {
                strategyBuilder.setOrientation(strategy.getOrientation());
            }

            if (strategy.isRevertToSpotSet()) {
                strategyBuilder.setRevertToSpot(toBl(strategy.getRevertToSpot()));
            }

            if (strategy.isUtilizeReservedInstancesSet()) {
                strategyBuilder.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }
            retVal = strategyBuilder.build();
        }

        return retVal;
    }

    public static Tags toBl(ApiTags tags) {
        Tags retVal = null;

        if (tags != null) {
            Tags.Builder tagsBuilder = Tags.Builder.get();

            if (tags.isTagKeySet() && tags.isTagValueSet()) {
                tagsBuilder.setTagKey(tags.getTagKey());
                tagsBuilder.setTagValue(tags.getTagValue());
            }
            retVal = tagsBuilder.build();
        }

        return retVal;
    }

    public static TagSpecification toBl(ApiTagSpecification tagSpecification) {
        TagSpecification retVal = null;

        if (tagSpecification != null) {
            TagSpecification.Builder tagSpecificationyBuilder = TagSpecification.Builder.get();

            if (tagSpecification.isShouldTagSet()) {
                tagSpecificationyBuilder.setShouldTag(tagSpecification.getShouldTag());
            }
            retVal = tagSpecificationyBuilder.build();
        }

        return retVal;
    }

    public static Tasks toBl(ApiTasks tasks) {
        Tasks retVal = null;

        if (tasks != null) {
            Tasks.Builder tasksBuilder = Tasks.Builder.get();

            if (tasks.isCronExpressionSet()) {
                tasksBuilder.setCronExpression(tasks.getCronExpression());
            }

            if (tasks.isFrequencySet()) {
                tasksBuilder.setFrequency(RecurrenceFrequencyEnum.fromName(tasks.getFrequency()));
            }

            if (tasks.isIsEnabledSet()) {
                tasksBuilder.setIsEnabled(tasks.getIsEnabled());
            }

            if (tasks.isStartTimeSet()) {
                tasksBuilder.setStartTime(tasks.getStartTime());
            }

            if (tasks.isTaskTypeSet()) {
                tasksBuilder.setTaskType(SchedulingTaskTypeEnum.fromName(tasks.getTaskType()));
            }
            retVal = tasksBuilder.build();
        }

        return retVal;
    }
}
