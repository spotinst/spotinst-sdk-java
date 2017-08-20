package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;
import com.spotinst.sdkjava.enums.ElastigroupOrientationEnum;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sniramsalem
 * @since: 06/12/2016
 */
class ElastigroupConverter {
    //region BL -> DAL
    public static ApiElastigroup toDal(Elastigroup src) {
        ApiElastigroup apiGroup = null;

        if (src != null) {
            apiGroup = new ApiElastigroup();

            if (src.isNameSet()) {
                apiGroup.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                apiGroup.setDescription(src.getDescription());
            }
            if (src.isCapacitySet()) {
                apiGroup.setCapacity(toDal(src.getCapacity()));
            }
            if (src.isStrategySet()) {
                apiGroup.setStrategy(toDal(src.getStrategy()));
            }
            if (src.isComputeSet()) {
                apiGroup.setCompute(toDal(src.getCompute()));
            }
            if (src.isRegionSet()) {
                apiGroup.setRegion(src.getRegion());
            }
        }

        return apiGroup;
    }

    private static ApiGroupCompute toDal(ElastigroupComputeConfiguration compute) {
        ApiGroupCompute optCompute = null;

        if (compute != null) {
            optCompute = new ApiGroupCompute();
            if (compute.isInstanceTypesSet()) {
                optCompute.setInstanceTypes(toDal(compute.getInstanceTypes()));
            }

            if (compute.isAvailabilityZonesSet()) {
                if (compute.getAvailabilityZones() != null) {
                    List<ApiPlacement> optPlacements =
                            compute.getAvailabilityZones().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    optCompute.setAvailabilityZones(optPlacements);
                }
            }
            if (compute.isProductSet()) {
                optCompute.setProduct(compute.getProduct());
            }
            if (compute.isLaunchSpecificationSet()) {
                optCompute.setLaunchSpecification(toDal(compute.getLaunchSpecification()));
            }

            if (compute.isElasticIpsSet()) {
                if (compute.getElasticIps() != null) {
                    optCompute.setElasticIps(new LinkedList<>(compute.getElasticIps()));
                }
            }

            if (compute.isEbsVolumePoolSet()) {
                if (compute.getEbsVolumePool() != null) {
                    List<ApiVolumePool> optVolumePool =
                            compute.getEbsVolumePool().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    optCompute.setEbsVolumePool(optVolumePool);
                }
            }

        }

        return optCompute;
    }

    private static ApiVolumePool toDal(ElastigroupEbsVolumePool volumePool) {
        ApiVolumePool retVal = null;

        if (volumePool != null) {
            retVal = new ApiVolumePool();
            if (volumePool.isDeviceNameSet()) {
                retVal.setDeviceName(volumePool.getDeviceName());
            }

            if (volumePool.isVolumeIdsSet()) {
                if (volumePool.getVolumeIds() != null) {
                    retVal.setVolumeIds(new LinkedList<>(volumePool.getVolumeIds()));
                }
            }
        }

        return retVal;
    }

    private static ApiPlacement toDal(Placement placement) {
        ApiPlacement retVal = null;

        if (placement != null) {
            retVal = new ApiPlacement();
            if (placement.isAzNameSet()) {
                retVal.setName(placement.getAzName());
            }
            if (placement.isSubnetIdsSet()) {
                if (placement.getSubnetIds() != null) {
                    retVal.setSubnetIds(new LinkedList<>(placement.getSubnetIds()));
                }
            }
        }

        return retVal;
    }

    private static ApiLaunchSpec toDal(ElastigroupLaunchSpecification launchSpecification) {
        ApiLaunchSpec retVal = null;

        if (launchSpecification != null) {
            retVal = new ApiLaunchSpec();

            if (launchSpecification.isHealthCheckTypeSet()) {
                retVal.setHealthCheckType(launchSpecification.getHealthCheckType());
            }

            if (launchSpecification.isHealthCheckGracePeriodSet()) {
                retVal.setHealthCheckGracePeriod(launchSpecification.getHealthCheckGracePeriod());
            }

            if (launchSpecification.isSecurityGroupIdsSet()) {
                if (launchSpecification.getSecurityGroupIds() != null) {
                    retVal.setSecurityGroupIds(new LinkedList<>(launchSpecification.getSecurityGroupIds()));
                }
            }

            if (launchSpecification.isDetailedMonitoringSet()) {
                retVal.setMonitoring(launchSpecification.getDetailedMonitoring());
            }

            if (launchSpecification.isEbsOptimizedSet()) {
                retVal.setEbsOptimized(launchSpecification.getEbsOptimized());
            }

            if (launchSpecification.isImageIdSet()) {
                retVal.setImageId(launchSpecification.getImageId());
            }

            if (launchSpecification.isIamRoleSet()) {
                retVal.setIamRole(toDal(launchSpecification.getIamRole()));
            }

            if (launchSpecification.isKeyPairSet()) {
                retVal.setKeyPair(launchSpecification.getKeyPair());
            }

            if (launchSpecification.isUserDataSet()) {
                retVal.setUserData(launchSpecification.getUserData());
            }

            if (launchSpecification.isBlockDeviceMappingsSet()) {
                if (launchSpecification.getBlockDeviceMappings() != null) {
                    List<ApiBlockDevice> optimizerBDM =
                            launchSpecification.getBlockDeviceMappings().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setBlockDeviceMappings(optimizerBDM);
                }
            }

            if (launchSpecification.isNetworkInterfacesSet()) {
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<ApiNetworkInterface> optimizerNIC =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setNetworkInterfaces(optimizerNIC);
                }
            }

            if (launchSpecification.isTagsSet()) {
                if (launchSpecification.getTags() != null) {
                    List<ApiTag> optimizerTags =
                            launchSpecification.getTags().stream().map(ElastigroupConverter::toDal)
                                    .collect(Collectors.toList());
                    retVal.setTags(optimizerTags);
                }
            }
        }

        return retVal;
    }

    private static ApiTag toDal(Tag tag) {
        ApiTag retVal = null;
        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                retVal = new ApiTag(tag.getTagKey(), tag.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiNetworkInterface toDal(NetworkInterface networkInterface) {
        ApiNetworkInterface retVal = null;
        if (networkInterface != null) {
            retVal = new ApiNetworkInterface();
            if (networkInterface.isDescriptionSet()) {
                retVal.setDescription(networkInterface.getDescription());
            }

            if (networkInterface.isDeviceIndexSet()) {
                retVal.setDeviceIndex(networkInterface.getDeviceIndex());
            }

            if (networkInterface.isSecondaryPrivateIpAddressCountSet()) {
                retVal.setSecondaryPrivateIpAddressCount(networkInterface.getSecondaryPrivateIpAddressCount());
            }

            if (networkInterface.isAssociatePublicIpAddressSet()) {
                retVal.setAssociatePublicIpAddress(networkInterface.getAssociatePublicIpAddress());
            }

            if (networkInterface.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(networkInterface.getDeleteOnTermination());
            }

            if (networkInterface.isNetworkInterfaceIdSet()) {
                retVal.setNetworkInterfaceId(networkInterface.getNetworkInterfaceId());
            }
        }

        return retVal;
    }

    private static ApiBlockDevice toDal(BlockDeviceMapping blockDeviceMapping) {
        ApiBlockDevice retVal = null;

        if (blockDeviceMapping != null) {
            retVal = new ApiBlockDevice();
            if (blockDeviceMapping.isDeviceNameSet()) {
                retVal.setDeviceName(blockDeviceMapping.getDeviceName());
            }

            if (blockDeviceMapping.isNoDeviceSet()) {
                retVal.setNoDevice(blockDeviceMapping.getNoDevice());
            }

            if (blockDeviceMapping.isVirtualNameSet()) {
                retVal.setVirtualName(blockDeviceMapping.getVirtualName());
            }

            if (blockDeviceMapping.isEbsDeviceSet()) {
                retVal.setEbs(toDal(blockDeviceMapping.getEbsDevice()));
            }
        }

        return retVal;
    }

    private static ApiEbsDevice toDal(EbsDevice ebsDevice) {
        ApiEbsDevice retVal = null;

        if (ebsDevice != null) {
            retVal = new ApiEbsDevice();

            if (ebsDevice.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(ebsDevice.getDeleteOnTermination());
            }

            if (ebsDevice.isEncryptedSet()) {
                retVal.setEncrypted(ebsDevice.getEncrypted());
            }

            if (ebsDevice.isIopsSet()) {
                retVal.setIops(ebsDevice.getIops());
            }

            if (ebsDevice.isSnapshotIdSet()) {
                retVal.setSnapshotId(ebsDevice.getSnapshotId());
            }

            if (ebsDevice.isVolumeSizeSet()) {
                retVal.setVolumeSize(ebsDevice.getVolumeSize());
            }
            if (ebsDevice.isVolumeTypeSet()) {
                if (ebsDevice.getVolumeType() != null) {
                    retVal.setVolumeType(ebsDevice.getVolumeType().getName());
                }
            }
        }

        return retVal;
    }

    private static ApiIamRole toDal(IamRole iamRole) {
        ApiIamRole retVal = null;

        if (iamRole != null) {
            retVal = new ApiIamRole();

            if (iamRole.isNameSet()) {
                retVal.setName(iamRole.getName());
            }

            if (iamRole.isArnSet()) {
                retVal.setArn(iamRole.getArn());
            }
        }

        return retVal;
    }

    private static ApiInstanceTypes toDal(ElastigroupInstanceTypes instanceTypes) {
        ApiInstanceTypes retVal = null;

        if (instanceTypes != null) {
            retVal = new ApiInstanceTypes();
            if (instanceTypes.isOnDemandSet()) {
                retVal.setOndemand(instanceTypes.getOnDemand());
            }
            if (instanceTypes.isSpotSet()) {
                if (instanceTypes.getSpot() != null) {
                    retVal.setSpot(new LinkedList<>(instanceTypes.getSpot()));
                }
            }
        }

        return retVal;
    }

    private static ApiStrategy toDal(ElastigroupStrategyConfiguration strategy) {
        ApiStrategy retVal = null;

        if (strategy != null) {
            retVal = new ApiStrategy();

            if (strategy.isSpotPercentageSet()) {
                retVal.setRisk(strategy.getSpotPercentage());
            }

            if (strategy.isOnDemandCountSet()) {
                retVal.setOnDemandCount(strategy.getOnDemandCount());
            }

            if (strategy.isElastigroupOrientationSet()) {
                if (strategy.getElastigroupOrientation() != null) {
                    retVal.setAvailabilityVsCost(strategy.getElastigroupOrientation().getName());
                }
            }

            if (strategy.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(strategy.getDrainingTimeout());
            }

            if (strategy.isUtilizeReservedInstancesSet()) {
                retVal.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }

            if (strategy.isFallbackToOdSet()) {
                retVal.setFallbackToOd(strategy.getFallbackToOd());
            }

        }

        return retVal;
    }

    private static ApiCapacity toDal(ElastigroupCapacityConfiguration capacity) {
        ApiCapacity retVal = null;

        if (capacity != null) {
            retVal = new ApiCapacity();

            if (capacity.isMaximumSet()) {
                retVal.setMaximum(capacity.getMaximum());
            }

            if (capacity.isMinimumSet()) {
                retVal.setMinimum(capacity.getMinimum());
            }

            if (capacity.isTargetSet()) {
                retVal.setTarget(capacity.getTarget());
            }

        }

        return retVal;
    }

    //endregion

    //region DAL -> BL
    public static Elastigroup toBl(ApiElastigroup apiElastigroup) {
        Elastigroup elastigroup = null;

        if (apiElastigroup != null) {
            Elastigroup.Builder elastigroupBuilder = Elastigroup.Builder.get();

            if (apiElastigroup.isIdSet()) {
                elastigroupBuilder.setId(apiElastigroup.getId());
            }
            if (apiElastigroup.isNameSet()) {
                elastigroupBuilder.setName(apiElastigroup.getName());
            }

            if (apiElastigroup.isDescriptionSet()) {
                elastigroupBuilder.setDescription(apiElastigroup.getDescription());
            }

            if (apiElastigroup.isCapacitySet()) {
                elastigroupBuilder.setCapacity(toBl(apiElastigroup.getCapacity()));
            }

            if (apiElastigroup.isStrategySet()) {
                elastigroupBuilder.setStrategy(toBl(apiElastigroup.getStrategy()));
            }
            if (apiElastigroup.isComputeSet()) {
                elastigroupBuilder.setCompute(toBl(apiElastigroup.getCompute()));
            }
            elastigroup = elastigroupBuilder.build();
        }

        return elastigroup;
    }

    private static ElastigroupComputeConfiguration toBl(ApiGroupCompute compute) {
        ElastigroupComputeConfiguration blCompute = null;

        if (compute != null) {
            ElastigroupComputeConfiguration.Builder blComputeBuilder = ElastigroupComputeConfiguration.Builder.get();

            if (compute.isInstanceTypesSet()) {
                blComputeBuilder.setInstanceTypes(toBl(compute.getInstanceTypes()));
            }

            if (compute.isAvailabilityZonesSet()) {
                if (compute.getAvailabilityZones() != null) {
                    List<Placement> placements =
                            compute.getAvailabilityZones().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    blComputeBuilder.setAvailabilityZones(placements);
                }
            }

            if (compute.isProductSet()) {
                blComputeBuilder.setProduct(compute.getProduct());
            }
            if (compute.isLaunchSpecificationSet()) {
                blComputeBuilder.setLaunchSpecification(toBl(compute.getLaunchSpecification()));
            }

            if (compute.isElasticIpsSet()) {
                if (compute.getElasticIps() != null) {
                    blComputeBuilder.setElasticIps(new LinkedList<>(compute.getElasticIps()));
                }
            }

            if (compute.isEbsVolumePoolSet()) {
                if (compute.getEbsVolumePool() != null) {
                    List<ElastigroupEbsVolumePool> blVolumePool =
                            compute.getEbsVolumePool().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    blComputeBuilder.setEbsVolumePools(blVolumePool);
                }
            }

            blCompute = blComputeBuilder.build();
        }

        return blCompute;
    }

    private static ElastigroupEbsVolumePool toBl(ApiVolumePool volumePool) {
        ElastigroupEbsVolumePool retVal = null;

        if (volumePool != null) {
            ElastigroupEbsVolumePool.Builder retValBuilder = ElastigroupEbsVolumePool.Builder.get();
            if (volumePool.isDeviceNameSet()) {
                retValBuilder.setDeviceName(volumePool.getDeviceName());
            }

            if (volumePool.isVolumeIdsSet()) {
                if (volumePool.getVolumeIds() != null) {
                    retValBuilder.setVolumeIds(new LinkedList<>(volumePool.getVolumeIds()));
                }
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static Placement toBl(ApiPlacement placement) {
        Placement retVal = null;

        if (placement != null) {
            Placement.Builder retValBuilder = Placement.Builder.get();
            if (placement.isNameSet()) {
                retValBuilder.setAvailabilityZoneName(placement.getName());
            }

            if (placement.isSubnetIdsSet()) {
                if (placement.getSubnetIds() != null) {
                    retValBuilder.setSubnetIds(new LinkedList<>(placement.getSubnetIds()));
                }
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupLaunchSpecification toBl(ApiLaunchSpec launchSpecification) {
        ElastigroupLaunchSpecification retVal = null;

        if (launchSpecification != null) {

            ElastigroupLaunchSpecification.Builder retValBuilder = ElastigroupLaunchSpecification.Builder.get();

            if (launchSpecification.isHealthCheckTypeSet()) {
                retValBuilder.setHealthCheckType(launchSpecification.getHealthCheckType());
            }

            if (launchSpecification.isHealthCheckGracePeriodSet()) {
                retValBuilder.setHealthCheckGracePeriod(launchSpecification.getHealthCheckGracePeriod());
            }

            if (launchSpecification.isSecurityGroupIdsSet()) {
                if (launchSpecification.getSecurityGroupIds() != null) {
                    retValBuilder.setSecurityGroupIds(new LinkedList<>(launchSpecification.getSecurityGroupIds()));
                }
            }

            if (launchSpecification.isMonitoringSet()) {
                retValBuilder.setDetailedMonitoring(launchSpecification.getMonitoring());
            }

            if (launchSpecification.isEbsOptimizedSet()) {
                retValBuilder.setEbsOptimized(launchSpecification.getEbsOptimized());
            }

            if (launchSpecification.isImageIdSet()) {
                retValBuilder.setImageId(launchSpecification.getImageId());
            }

            if (launchSpecification.isIamRoleSet()) {
                retValBuilder.setIamRole(toBl(launchSpecification.getIamRole()));
            }

            if (launchSpecification.isKeyPairSet()) {
                retValBuilder.setKeyPair(launchSpecification.getKeyPair());
            }

            if (launchSpecification.isUserDataSet()) {
                retValBuilder.setUserData(launchSpecification.getUserData());
            }

            if (launchSpecification.isBlockDeviceMappingsSet()) {
                if (launchSpecification.getBlockDeviceMappings() != null) {
                    List<BlockDeviceMapping> blBDM =
                            launchSpecification.getBlockDeviceMappings().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    retValBuilder.setBlockDeviceMappings(blBDM);
                }
            }

            if (launchSpecification.isNetworkInterfacesSet()) {
                if (launchSpecification.getNetworkInterfaces() != null) {
                    List<NetworkInterface> blNIC =
                            launchSpecification.getNetworkInterfaces().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    retValBuilder.setNetworkInterfaces(blNIC);
                }
            }

            if (launchSpecification.isTagsSet()) {
                if (launchSpecification.getTags() != null) {
                    List<Tag> tags =
                            launchSpecification.getTags().stream().map(ElastigroupConverter::toBl)
                                    .collect(Collectors.toList());
                    retValBuilder.setTags(tags);
                }
            }

            retVal = retValBuilder.build();
        }


        return retVal;
    }

    private static Tag toBl(ApiTag tag) {
        Tag retVal = null;

        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                Tag.Builder tagBuilder = Tag.Builder.get();
                retVal = tagBuilder.setTagKey(tag.getTagKey()).setTagValue(tag.getTagValue()).build();
            }
        }

        return retVal;
    }

    private static NetworkInterface toBl(ApiNetworkInterface networkInterface) {
        NetworkInterface retVal = null;

        if (networkInterface != null) {
            NetworkInterface.Builder retValBuilder = NetworkInterface.Builder.get();

            if (networkInterface.isDescriptionSet()) {
                retValBuilder.setDescription(networkInterface.getDescription());
            }

            if (networkInterface.isDeviceIndexSet()) {
                retValBuilder.setDeviceIndex(networkInterface.getDeviceIndex());
            }

            if (networkInterface.isSecondaryPrivateIpAddressCountSet()) {
                retValBuilder.setSecondaryPrivateIpAddressCount(networkInterface.getSecondaryPrivateIpAddressCount());
            }

            if (networkInterface.isAssociatePublicIpAddressSet()) {
                retValBuilder.setAssociatePublicIpAddress(networkInterface.getAssociatePublicIpAddress());
            }

            if (networkInterface.isDeleteOnTerminationSet()) {
                retValBuilder.setDeleteOnTermination(networkInterface.getDeleteOnTermination());
            }

            if (networkInterface.isNetworkInterfaceIdSet()) {
                retValBuilder.setNetworkInterfaceId(networkInterface.getNetworkInterfaceId());
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static BlockDeviceMapping toBl(ApiBlockDevice blockDevice) {
        BlockDeviceMapping retVal = null;

        if (blockDevice != null) {

            BlockDeviceMapping.Builder retValBuilder = BlockDeviceMapping.Builder.get();

            if (blockDevice.isDeviceNameSet()) {
                retValBuilder.setDeviceName(blockDevice.getDeviceName());
            }

            if (blockDevice.isNoDeviceSet()) {
                retValBuilder.setNoDevice(blockDevice.getNoDevice());
            }

            if (blockDevice.isVirtualNameSet()) {
                retValBuilder.setVirtualName(blockDevice.getVirtualName());
            }

            if (blockDevice.isEbsSet()) {
                retValBuilder.setEbsDevice(toBl(blockDevice.getEbs()));
            }
            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static EbsDevice toBl(ApiEbsDevice ebsDevice) {
        EbsDevice retVal = null;

        if (ebsDevice != null) {
            EbsDevice.Builder retValBuilder = EbsDevice.Builder.get();

            if (ebsDevice.isDeleteOnTerminationSet()) {
                retValBuilder.setDeleteOnTermination(ebsDevice.getDeleteOnTermination());
            }

            if (ebsDevice.isEncryptedSet()) {
                retValBuilder.setEncrypted(ebsDevice.getEncrypted());
            }

            if (ebsDevice.isIopsSet()) {
                retValBuilder.setIops(ebsDevice.getIops());
            }

            if (ebsDevice.isSnapshotIdSet()) {
                retValBuilder.setSnapshotId(ebsDevice.getSnapshotId());
            }

            if (ebsDevice.isVolumeSizeSet()) {
                retValBuilder.setVolumeSize(ebsDevice.getVolumeSize());
            }

            if (ebsDevice.isVolumeTypeSet()) {
                retValBuilder.setVolumeType(AwsVolumeTypeEnum.fromName(ebsDevice.getVolumeType()));
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static IamRole toBl(ApiIamRole iamRole) {
        IamRole retVal = null;

        if (iamRole != null) {
            IamRole.Builder retValBuilder = IamRole.Builder.get();

            if (iamRole.isNameSet()) {
                retValBuilder.setName(iamRole.getName());
            }

            if (iamRole.isArnSet()) {
                retValBuilder.setArn(iamRole.getArn());
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static ElastigroupInstanceTypes toBl(ApiInstanceTypes instanceTypes) {
        ElastigroupInstanceTypes retVal = null;

        if (instanceTypes != null) {
            ElastigroupInstanceTypes.Builder retValBuilder = ElastigroupInstanceTypes.Builder.get();

            if (instanceTypes.isOndemandSet()) {
                retValBuilder.setOnDemandType(instanceTypes.getOndemand());
            }

            if (instanceTypes.isSpotSet()) {
                if (instanceTypes.getSpot() != null) {
                    retValBuilder.setSpotTypes(new LinkedList<>(instanceTypes.getSpot()));
                }
            }

            retVal = retValBuilder.build();
        }

        return retVal;
    }

    private static ElastigroupStrategyConfiguration toBl(ApiStrategy strategy) {
        ElastigroupStrategyConfiguration retVal = null;

        if (strategy != null) {
            ElastigroupStrategyConfiguration.Builder retValBuilder = ElastigroupStrategyConfiguration.Builder.get();
            if (strategy.isRiskSet()) {
                retValBuilder.setSpotPercentage(strategy.getRisk());
            }

            if (strategy.isOnDemandCountSet()) {
                retValBuilder.setOnDemandCount(strategy.getOnDemandCount());
            }

            if (strategy.isAvailabilityVsCostSet()) {
                retValBuilder.setElastigroupOrientation(ElastigroupOrientationEnum.fromName(strategy.getAvailabilityVsCost()));
            }

            if (strategy.isDrainingTimeoutSet()) {
                retValBuilder.setDrainingTimeout(strategy.getDrainingTimeout());
            }

            if (strategy.isUtilizeReservedInstancesSet()) {
                retValBuilder.setUtilizeReservedInstances(strategy.getUtilizeReservedInstances());
            }

            if (strategy.isFallbackToOdSet()) {
                retValBuilder.setFallbackToOnDemand(strategy.getFallbackToOd());
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }

    private static ElastigroupCapacityConfiguration toBl(ApiCapacity capacity) {
        ElastigroupCapacityConfiguration retVal = null;

        if (capacity != null) {
            ElastigroupCapacityConfiguration.Builder retValBuilder = ElastigroupCapacityConfiguration.Builder.get();

            if (capacity.isMaximumSet()) {
                retValBuilder.setMaximum(capacity.getMaximum());
            }

            if (capacity.isMinimumSet()) {
                retValBuilder.setMinimum(capacity.getMinimum());
            }

            if (capacity.isTargetSet()) {
                retValBuilder.setTarget(capacity.getTarget());
            }

            retVal = retValBuilder.build();

        }

        return retVal;
    }
    //endregion
}
