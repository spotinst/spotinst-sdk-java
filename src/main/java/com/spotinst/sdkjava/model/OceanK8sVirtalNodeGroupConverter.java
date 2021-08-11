package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;
import com.spotinst.sdkjava.enums.K8sVngHttpTokensEnum;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;

import java.util.List;
import java.util.stream.Collectors;

public class OceanK8sVirtalNodeGroupConverter {
    public static ApiK8sVirtualNodeGroup toDal(K8sVirtualNodeGroup launchSpec) {
        ApiK8sVirtualNodeGroup retVal = null;

        if (launchSpec != null) {
            retVal = new ApiK8sVirtualNodeGroup();

            if (launchSpec.isIdSet()) {
                retVal.setId(launchSpec.getId());
            }
            if (launchSpec.isNameSet()) {
                retVal.setName(launchSpec.getName());
            }
			if (launchSpec.isAssociatePublicIpAddressSet()) {
                retVal.setAssociatePublicIpAddress(launchSpec.getAssociatePublicIpAddress());
            }
			if (launchSpec.isAutoScaleSet()) {
                retVal.setAutoScale(toDal(launchSpec.getAutoScale()));
            }
			if (launchSpec.isBlockDeviceMappingsSet()) {
			    if (launchSpec.getBlockDeviceMappings() != null) {
			        List<ApiBlockDevice> blockDeviceList = launchSpec.getBlockDeviceMappings().stream().map(OceanK8sVirtalNodeGroupConverter::toDal)
                                                                     .collect(Collectors.toList());
                    retVal.setBlockDeviceMappings(blockDeviceList);
                }
            }
            if (launchSpec.isTagsSet()) {
                if (launchSpec.getTags() != null) {
                    List<ApiTag> tagList = launchSpec.getTags().stream().map(OceanK8sVirtalNodeGroupConverter::toDal)
                                                     .collect(Collectors.toList());
                    retVal.setTags(tagList);
                }
            }
            if (launchSpec.isIamInstanceProfileSet()) {
                if (launchSpec.getIamInstanceProfile() != null) {
                    retVal.setIamInstanceProfile(toDal(launchSpec.getIamInstanceProfile()));
                }
            }
            if (launchSpec.isImageIdSet()) {
                retVal.setImageId(launchSpec.getImageId());
            }
            if (launchSpec.isInstanceMetadataOptionsSet()) {
                if (launchSpec.getInstanceMetadataOptions() != null) {
                    retVal.setInstanceMetadataOptions(toDal(launchSpec.getInstanceMetadataOptions()));
                }
            }
            if (launchSpec.isInstanceTypesSet()) {
                retVal.setInstanceTypes(launchSpec.getInstanceTypes());
            }
            if (launchSpec.isOceanIdSet()) {
                retVal.setOceanId(launchSpec.getOceanId());
            }
            if (launchSpec.isSpotTypesSet()) {
                retVal.setSpotTypes(launchSpec.getSpotTypes());
            }
            if (launchSpec.isRestrictScaleDownSet()) {
                retVal.setRestrictScaleDown(launchSpec.getRestrictScaleDown());
            }
            if (launchSpec.isRootVolumeSizeSet()) {
                retVal.setRootVolumeSize(launchSpec.getRootVolumeSize());
            }
            if (launchSpec.isSecurityGroupIdsSet()) {
                retVal.setSecurityGroupIds(launchSpec.getSecurityGroupIds());
            }
            if (launchSpec.isStrategySet()) {
                retVal.setStrategy(toDal(launchSpec.getStrategy()));
            }
            if (launchSpec.isSubnetIdsSet()) {
                retVal.setSubnetIds(launchSpec.getSubnetIds());
            }
            if (launchSpec.isUserDataSet()) {
                retVal.setUserData(launchSpec.getUserData());
            }
        }

        return retVal;
    }

    private static ApiVirtualNodeGroupAutoScaleSpec toDal(VirtualNodeGroupAutoScaleSpec autoScaler) {
        ApiVirtualNodeGroupAutoScaleSpec retval = null;

        if (autoScaler != null) {
            retval = new ApiVirtualNodeGroupAutoScaleSpec();

            if (autoScaler.isHeadroomSet()) {
                List<ApiClusterHeadroomSpecification> headrooms =
                        autoScaler.getHeadrooms().stream().map(OceanK8sVirtalNodeGroupConverter::toDal)
                                  .collect(Collectors.toList());
                retval.setHeadrooms(headrooms);
            }
        }

        return retval;
    }

    private static ApiClusterHeadroomSpecification toDal(ClusterHeadroomSpecification headroom) {
        ApiClusterHeadroomSpecification retVal = null;
        if (headroom != null) {
            retVal = new ApiClusterHeadroomSpecification();
            if (headroom.isCpuPerUnitSet()) {
                retVal.setCpuPerUnit(headroom.getCpuPerUnit());
            }
            if (headroom.isMemoryPerUnitSet()) {
                retVal.setMemoryPerUnit(headroom.getMemoryPerUnit());
            }
            if (headroom.isGpuPerUnitSet()) {
                retVal.setGpuPerUnit(headroom.getGpuPerUnit());
            }
            if (headroom.isNumOfUnitsSet()) {
                retVal.setNumOfUnits(headroom.getNumOfUnits());
            }
        }
        return retVal;
    }

    private static ApiBlockDevice toDal (BlockDeviceMapping blockDeviceMapping) {
        ApiBlockDevice retVal = null;
        if (blockDeviceMapping != null) {
            retVal = new ApiBlockDevice();
            if (blockDeviceMapping.isDeviceNameSet()) {
                retVal.setDeviceName(blockDeviceMapping.getDeviceName());
            }
            if (blockDeviceMapping.isEbsDeviceSet()) {
                retVal.setEbs(toDal(blockDeviceMapping.getEbsDevice()));
            }
        }
        return retVal;
    }

    private static ApiEbsDevice toDal (EbsDevice ebsDevice) {
        ApiEbsDevice retVal = null;
        if (ebsDevice != null) {
            retVal = new ApiEbsDevice();
            if (ebsDevice.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(ebsDevice.getDeleteOnTermination());
            }
            if (ebsDevice.isDynamicVolumeSizeSet()) {
                retVal.setDynamicVolumeSize(toDal(ebsDevice.getDynamicVolumeSize()));
            }
            if (ebsDevice.isEncryptedSet()) {
                retVal.setEncrypted(ebsDevice.getEncrypted());
            }
            if (ebsDevice.isIopsSet()) {
                retVal.setIops(ebsDevice.getIops());
            }
            if (ebsDevice.isMsKeyIdSet()) {
                retVal.setKmsKeyId(ebsDevice.getKmsKeyId());
            }
            if (ebsDevice.isSnapshotIdSet()) {
                retVal.setSnapshotId(ebsDevice.getSnapshotId());
            }
            if (ebsDevice.isThroughputSet()) {
                retVal.setThroughput(ebsDevice.getThroughput());
            }
            if (ebsDevice.isVolumeSizeSet()) {
                retVal.setVolumeSize(ebsDevice.getVolumeSize());
            }
            if (ebsDevice.isVolumeTypeSet()) {
                retVal.setVolumeType(ebsDevice.getVolumeType().getName());
            }
        }
        return retVal;
    }

    private static ApiClusterDynamicVolumeSize toDal (ClusterDynamicVolumeSize dynamicVolumeSize) {
        ApiClusterDynamicVolumeSize retVal = null;
        if (dynamicVolumeSize != null) {
            retVal = new ApiClusterDynamicVolumeSize();

            if (dynamicVolumeSize.isBaseSizeSet()) {
                retVal.setBaseSize(dynamicVolumeSize.getBaseSize());
            }
            if (dynamicVolumeSize.isResourceSet()) {
                retVal.setResource(dynamicVolumeSize.getResource());
            }
            if (dynamicVolumeSize.isSizePerResourceUnitSet()) {
                retVal.setSizePerResourceUnit(dynamicVolumeSize.getSizePerResourceUnit());
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

    private static ApiClusterIamInstanceProfileSpec toDal (ClusterIamInstanceProfileSpec iamInstanceProfileSpec) {
        ApiClusterIamInstanceProfileSpec retVal = null;

        if (iamInstanceProfileSpec != null) {
            retVal = new ApiClusterIamInstanceProfileSpec();

            if (iamInstanceProfileSpec.isArnSet()) {
                retVal.setArn(iamInstanceProfileSpec.getArn());
            }
        }

        return retVal;
    }

    private static ApiK8sVngInstanceMetadataOptions toDal (K8sVngInstanceMetadataOptions instanceMetadataOptions) {
        ApiK8sVngInstanceMetadataOptions retVal = null;

        if (instanceMetadataOptions != null) {
            retVal = new ApiK8sVngInstanceMetadataOptions();

            if(instanceMetadataOptions.isHttpPutResponseHopLimitSet()) {
                retVal.setHttpPutResponseHopLimit(instanceMetadataOptions.getHttpPutResponseHopLimit());
            }
            if(instanceMetadataOptions.isHttpTokensSet()) {
                retVal.setHttpTokens(instanceMetadataOptions.getHttpTokens().getName());
            }
        }

        return retVal;
    }

    private static ApiClusterStrategyConfiguration toDal (ClusterStrategyConfiguration strategy) {
        ApiClusterStrategyConfiguration retVal = null;

        if(strategy != null) {
            retVal = new ApiClusterStrategyConfiguration();

            if(strategy.isSpotPercentageSet()) {
                retVal.setSpotPercentage(strategy.getSpotPercentage());
            }
        }

        return retVal;
    }
    //Dal-> Bl
    public static K8sVirtualNodeGroup toBl (ApiK8sVirtualNodeGroup apiLaunchSpec) {
        K8sVirtualNodeGroup retVal = null;

        if (apiLaunchSpec != null) {
            K8sVirtualNodeGroup.Builder launchSpecBuilder = K8sVirtualNodeGroup.Builder.get();

            if (apiLaunchSpec.isIdSet()) {
                launchSpecBuilder.setId(apiLaunchSpec.getId());
            }
            if (apiLaunchSpec.isNameSet()) {
                launchSpecBuilder.setName(apiLaunchSpec.getName());
            }
            if (apiLaunchSpec.isAssociatePublicIpAddressSet()) {
                launchSpecBuilder.setAssociatePublicIpAddress(apiLaunchSpec.getAssociatePublicIpAddress());
            }
            if (apiLaunchSpec.isAutoScaleSet()) {
                launchSpecBuilder.setAutoScale(toBl(apiLaunchSpec.getAutoScale()));
            }
            if (apiLaunchSpec.isBlockDeviceMappingsSet()) {
                if (apiLaunchSpec.getBlockDeviceMappings() != null) {
                    List<BlockDeviceMapping> blockDeviceList = apiLaunchSpec.getBlockDeviceMappings().stream().map(OceanK8sVirtalNodeGroupConverter::toBl)
                                                                     .collect(Collectors.toList());
                    launchSpecBuilder.setBlockDeviceMappings(blockDeviceList);
                }
            }
            if (apiLaunchSpec.isTagsSet()) {
                if (apiLaunchSpec.getTags() != null) {
                    List<Tag> tagList = apiLaunchSpec.getTags().stream().map(OceanK8sVirtalNodeGroupConverter::toBl)
                                                     .collect(Collectors.toList());
                    launchSpecBuilder.setTags(tagList);
                }
            }
            if (apiLaunchSpec.isIamInstanceProfileSet()) {
                if (apiLaunchSpec.getIamInstanceProfile() != null) {
                    launchSpecBuilder.setIamInstanceProfile(toBl(apiLaunchSpec.getIamInstanceProfile()));
                }
            }
            if (apiLaunchSpec.isImageIdSet()) {
                launchSpecBuilder.setImageId(apiLaunchSpec.getImageId());
            }
            if (apiLaunchSpec.isInstanceMetadataOptionsSet()) {
                if (apiLaunchSpec.getInstanceMetadataOptions() != null) {
                    launchSpecBuilder.setInstanceMetadataOptions(toBl(apiLaunchSpec.getInstanceMetadataOptions()));
                }
            }
            if (apiLaunchSpec.isInstanceTypesSet()) {
                launchSpecBuilder.setInstanceTypes(apiLaunchSpec.getInstanceTypes());
            }
            if (apiLaunchSpec.isOceanIdSet()) {
                launchSpecBuilder.setOceanId(apiLaunchSpec.getOceanId());
            }
            if (apiLaunchSpec.isSpotTypesSet()) {
                launchSpecBuilder.setSpotTypes(apiLaunchSpec.getSpotTypes());
            }
            if (apiLaunchSpec.isRestrictScaleDownSet()) {
                launchSpecBuilder.setRestrictScaleDown(apiLaunchSpec.getRestrictScaleDown());
            }
            if (apiLaunchSpec.isRootVolumeSizeSet()) {
                launchSpecBuilder.setRootVolumeSize(apiLaunchSpec.getRootVolumeSize());
            }
            if (apiLaunchSpec.isSecurityGroupIdsSet()) {
                launchSpecBuilder.setSecurityGroupIds(apiLaunchSpec.getSecurityGroupIds());
            }
            if (apiLaunchSpec.isStrategySet()) {
                launchSpecBuilder.setStrategy(toBl(apiLaunchSpec.getStrategy()));
            }
            if (apiLaunchSpec.isSubnetIdsSet()) {
                launchSpecBuilder.setSubnetIds(apiLaunchSpec.getSubnetIds());
            }
            if (apiLaunchSpec.isUserDataSet()) {
                launchSpecBuilder.setUserData(apiLaunchSpec.getUserData());
            }

            retVal = launchSpecBuilder.build();
        }

        return retVal;
    }

    private static VirtualNodeGroupAutoScaleSpec toBl(ApiVirtualNodeGroupAutoScaleSpec autoScaler) {
        VirtualNodeGroupAutoScaleSpec retval = null;

        if (autoScaler != null) {
            VirtualNodeGroupAutoScaleSpec.Builder autoScaleBuilder = VirtualNodeGroupAutoScaleSpec.Builder.get();

            if (autoScaler.isHeadroomSet()) {
                List<ClusterHeadroomSpecification> headrooms =
                        autoScaler.getHeadrooms().stream().map(OceanK8sVirtalNodeGroupConverter::toBl)
                                  .collect(Collectors.toList());
                autoScaleBuilder.setHeadrooms(headrooms);
            }
            retval = autoScaleBuilder.build();
        }
        return retval;
    }

    private static ClusterHeadroomSpecification toBl(ApiClusterHeadroomSpecification apiHeadroom) {
        ClusterHeadroomSpecification retVal = null;
        if (apiHeadroom != null) {
            ClusterHeadroomSpecification.Builder headroomBuilder = ClusterHeadroomSpecification.Builder.get();

            if (apiHeadroom.isCpuPerUnitSet()) {
                headroomBuilder.setCpuPerUnit(apiHeadroom.getCpuPerUnit());
            }
            if (apiHeadroom.isMemoryPerUnitSet()) {
                headroomBuilder.setMemoryPerUnit(apiHeadroom.getMemoryPerUnit());
            }
            if (apiHeadroom.isGpuPerUnitSet()) {
                headroomBuilder.setGpuPerUnit(apiHeadroom.getGpuPerUnit());
            }
            if (apiHeadroom.isNumOfUnitsSet()) {
                headroomBuilder.setNumOfUnits(apiHeadroom.getNumOfUnits());
            }

            retVal = headroomBuilder.build();
        }
        return retVal;
    }

    private static BlockDeviceMapping toBl (ApiBlockDevice apiBlockDeviceMapping) {
        BlockDeviceMapping retVal = null;
        if (apiBlockDeviceMapping != null) {
            BlockDeviceMapping.Builder blockDeviceMappingBuilder = BlockDeviceMapping.Builder.get();

            if (apiBlockDeviceMapping.isDeviceNameSet()) {
                blockDeviceMappingBuilder.setDeviceName(apiBlockDeviceMapping.getDeviceName());
            }
            if (apiBlockDeviceMapping.isEbsSet()) {
                blockDeviceMappingBuilder.setEbsDevice(toBl(apiBlockDeviceMapping.getEbs()));
            }

            retVal = blockDeviceMappingBuilder.build();
        }
        return retVal;
    }

    private static EbsDevice toBl (ApiEbsDevice apiEbsDevice) {
        EbsDevice retVal = null;
        if (apiEbsDevice != null) {
            EbsDevice.Builder ebsDeviceBuilder = EbsDevice.Builder.get();

            if (apiEbsDevice.isDeleteOnTerminationSet()) {
                ebsDeviceBuilder.setDeleteOnTermination(apiEbsDevice.getDeleteOnTermination());
            }
            if (apiEbsDevice.isDynamicVolumeSizeSet()) {
                ebsDeviceBuilder.setDynamicVolumeSize(toBl(apiEbsDevice.getDynamicVolumeSize()));
            }
            if (apiEbsDevice.isEncryptedSet()) {
                ebsDeviceBuilder.setEncrypted(apiEbsDevice.getEncrypted());
            }
            if (apiEbsDevice.isIopsSet()) {
                ebsDeviceBuilder.setIops(apiEbsDevice.getIops());
            }
            if (apiEbsDevice.isMsKeyIdSet()) {
                ebsDeviceBuilder.setKmsKeyId(apiEbsDevice.getKmsKeyId());
            }
            if (apiEbsDevice.isSnapshotIdSet()) {
                ebsDeviceBuilder.setSnapshotId(apiEbsDevice.getSnapshotId());
            }
            if (apiEbsDevice.isThroughputSet()) {
                ebsDeviceBuilder.setThroughput(apiEbsDevice.getThroughput());
            }
            if (apiEbsDevice.isVolumeSizeSet()) {
                ebsDeviceBuilder.setVolumeSize(apiEbsDevice.getVolumeSize());
            }
            if (apiEbsDevice.isVolumeTypeSet()) {
                ebsDeviceBuilder.setVolumeType(AwsVolumeTypeEnum.fromName(apiEbsDevice.getVolumeType()));
            }

            retVal = ebsDeviceBuilder.build();
        }
        return retVal;
    }

    private static ClusterDynamicVolumeSize toBl (ApiClusterDynamicVolumeSize apiDynamicVolumeSize) {
        ClusterDynamicVolumeSize retVal = null;
        if (apiDynamicVolumeSize != null) {
            ClusterDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = ClusterDynamicVolumeSize.Builder.get();

            if (apiDynamicVolumeSize.isBaseSizeSet()) {
                dynamicVolumeSizeBuilder.setBaseSize(apiDynamicVolumeSize.getBaseSize());
            }
            if (apiDynamicVolumeSize.isResourceSet()) {
                dynamicVolumeSizeBuilder.setResource(apiDynamicVolumeSize.getResource());
            }
            if (apiDynamicVolumeSize.isSizePerResourceUnitSet()) {
                dynamicVolumeSizeBuilder.setSizePerResourceUnit(apiDynamicVolumeSize.getSizePerResourceUnit());
            }

            retVal = dynamicVolumeSizeBuilder.build();
        }
        return retVal;
    }

    private static Tag toBl(ApiTag apiTag) {
        Tag retVal = null;

        if (apiTag != null) {
            if (apiTag.isTagKeySet() && apiTag.isTagValueSet()) {
                Tag.Builder tagBuilder = Tag.Builder.get();
                retVal = tagBuilder.setTagKey(apiTag.getTagKey()).setTagValue(apiTag.getTagValue()).build();
            }
        }

        return retVal;
    }

    private static ClusterIamInstanceProfileSpec toBl (ApiClusterIamInstanceProfileSpec iamInstanceProfileSpec) {
        ClusterIamInstanceProfileSpec retVal = null;

        if (iamInstanceProfileSpec != null) {
            ClusterIamInstanceProfileSpec.Builder iamInstanceProfileSpecBuilder = ClusterIamInstanceProfileSpec.Builder.get();
            if (iamInstanceProfileSpec.isArnSet()) {
                iamInstanceProfileSpecBuilder.setArn(iamInstanceProfileSpec.getArn());
            }

            retVal = iamInstanceProfileSpecBuilder.build();
        }

        return retVal;
    }

    private static K8sVngInstanceMetadataOptions toBl (ApiK8sVngInstanceMetadataOptions apiInstanceMetadataOptions) {
        K8sVngInstanceMetadataOptions retVal = null;

        if (apiInstanceMetadataOptions != null) {
            K8sVngInstanceMetadataOptions.Builder vngInstanceMetadataOptions = K8sVngInstanceMetadataOptions.Builder.get();

            if(apiInstanceMetadataOptions.isHttpPutResponseHopLimitSet()) {
                vngInstanceMetadataOptions.setHttpPutResponseHopLimit(apiInstanceMetadataOptions.getHttpPutResponseHopLimit());
            }
            if(apiInstanceMetadataOptions.isHttpTokensSet()) {
                vngInstanceMetadataOptions.setHttpTokens(K8sVngHttpTokensEnum.fromName(apiInstanceMetadataOptions.getHttpTokens()));
            }

            retVal = vngInstanceMetadataOptions.build();
        }

        return retVal;
    }

    private static ClusterStrategyConfiguration toBl (ApiClusterStrategyConfiguration apiStrategy) {
        ClusterStrategyConfiguration retVal = null;

        if(apiStrategy != null) {
            ClusterStrategyConfiguration.Builder strategyBuilder = ClusterStrategyConfiguration.Builder.get();
            if(apiStrategy.isSpotPercentageSet()) {
                strategyBuilder.setSpotPercentage(apiStrategy.getSpotPercentage());
            }

            retVal = strategyBuilder.build();
        }

        return retVal;
    }
}