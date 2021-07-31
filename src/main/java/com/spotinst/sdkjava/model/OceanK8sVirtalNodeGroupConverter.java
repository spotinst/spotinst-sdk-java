package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;
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
			if (launchSpec.isHeadroomSet()) {
                retVal.setHeadroom(toDal(launchSpec.getHeadroom()));
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
                retVal.setInstanceTypes(toDal(launchSpec.getInstanceTypes()));
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
            if (launchSpec.isSpotPercentageSet()) {
                retVal.setSpotPercentage(launchSpec.getSpotPercentage());
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
                retVal.setHttpTokens(instanceMetadataOptions.getHttpTokens());
            }
        }

        return retVal;
    }

    private static ApiClusterInstanceTypes toDal(ClusterInstanceTypes instanceTypes) {
        ApiClusterInstanceTypes retVal = null;

        if (instanceTypes != null) {
            retVal = new ApiClusterInstanceTypes();

            if (instanceTypes.isBlacklistSet()) {
                retVal.setBlacklist(instanceTypes.getBlacklist());
            }
            if (instanceTypes.isWhitelistSet()) {
                retVal.setWhitelist(instanceTypes.getWhitelist());
            }
        }

        return retVal;
    }

    //Dal-> Bl
    public static K8sVirtualNodeGroup toBl (ApiK8sVirtualNodeGroup apiLaunchSpec) {
        K8sVirtualNodeGroup retVal = null;

        if (apiLaunchSpec != null) {
            if (apiLaunchSpec.isIdSet()) {
                retVal.setId(apiLaunchSpec.getId());
            }
            if (apiLaunchSpec.isNameSet()) {
                retVal.setName(apiLaunchSpec.getName());
            }
            if (apiLaunchSpec.isAssociatePublicIpAddressSet()) {
                retVal.setAssociatePublicIpAddress(apiLaunchSpec.getAssociatePublicIpAddress());
            }
            if (apiLaunchSpec.isHeadroomSet()) {
                retVal.setHeadroom(toBl(apiLaunchSpec.getHeadroom()));
            }
            if (apiLaunchSpec.isBlockDeviceMappingsSet()) {
                if (apiLaunchSpec.getBlockDeviceMappings() != null) {
                    List<BlockDeviceMapping> blockDeviceList = apiLaunchSpec.getBlockDeviceMappings().stream().map(OceanK8sVirtalNodeGroupConverter::toBl)
                                                                     .collect(Collectors.toList());
                    retVal.setBlockDeviceMappings(blockDeviceList);
                }
            }
            if (apiLaunchSpec.isTagsSet()) {
                if (apiLaunchSpec.getTags() != null) {
                    List<Tag> tagList = apiLaunchSpec.getTags().stream().map(OceanK8sVirtalNodeGroupConverter::toBl)
                                                     .collect(Collectors.toList());
                    retVal.setTags(tagList);
                }
            }
            if (apiLaunchSpec.isIamInstanceProfileSet()) {
                if (apiLaunchSpec.getIamInstanceProfile() != null) {
                    retVal.setIamInstanceProfile(toBl(apiLaunchSpec.getIamInstanceProfile()));
                }
            }
            if (apiLaunchSpec.isImageIdSet()) {
                retVal.setImageId(apiLaunchSpec.getImageId());
            }
            if (apiLaunchSpec.isInstanceMetadataOptionsSet()) {
                if (apiLaunchSpec.getInstanceMetadataOptions() != null) {
                    retVal.setInstanceMetadataOptions(toBl(apiLaunchSpec.getInstanceMetadataOptions()));
                }
            }
            if (apiLaunchSpec.isInstanceTypesSet()) {
                retVal.setInstanceTypes(toBl(apiLaunchSpec.getInstanceTypes()));
            }
            if (apiLaunchSpec.isOceanIdSet()) {
                retVal.setOceanId(apiLaunchSpec.getOceanId());
            }
            if (apiLaunchSpec.isSpotTypesSet()) {
                retVal.setSpotTypes(apiLaunchSpec.getSpotTypes());
            }
            if (apiLaunchSpec.isRestrictScaleDownSet()) {
                retVal.setRestrictScaleDown(apiLaunchSpec.getRestrictScaleDown());
            }
            if (apiLaunchSpec.isRootVolumeSizeSet()) {
                retVal.setRootVolumeSize(apiLaunchSpec.getRootVolumeSize());
            }
            if (apiLaunchSpec.isSecurityGroupIdsSet()) {
                retVal.setSecurityGroupIds(apiLaunchSpec.getSecurityGroupIds());
            }
            if (apiLaunchSpec.isSpotPercentageSet()) {
                retVal.setSpotPercentage(apiLaunchSpec.getSpotPercentage());
            }
            if (apiLaunchSpec.isSubnetIdsSet()) {
                retVal.setSubnetIds(apiLaunchSpec.getSubnetIds());
            }
            if (apiLaunchSpec.isUserDataSet()) {
                retVal.setUserData(apiLaunchSpec.getUserData());
            }
        }

        return retVal;
    }

    private static ClusterHeadroomSpecification toBl(ApiClusterHeadroomSpecification apiHeadroom) {
        ClusterHeadroomSpecification retVal = null;
        if (apiHeadroom != null) {

            if (apiHeadroom.isCpuPerUnitSet()) {
                retVal.setCpuPerUnit(apiHeadroom.getCpuPerUnit());
            }
            if (apiHeadroom.isMemoryPerUnitSet()) {
                retVal.setMemoryPerUnit(apiHeadroom.getMemoryPerUnit());
            }
            if (apiHeadroom.isGpuPerUnitSet()) {
                retVal.setGpuPerUnit(apiHeadroom.getGpuPerUnit());
            }
            if (apiHeadroom.isNumOfUnitsSet()) {
                retVal.setNumOfUnits(apiHeadroom.getNumOfUnits());
            }
        }
        return retVal;
    }

    private static BlockDeviceMapping toBl (ApiBlockDevice apiBlockDeviceMapping) {
        BlockDeviceMapping retVal = null;
        if (apiBlockDeviceMapping != null) {
            if (apiBlockDeviceMapping.isDeviceNameSet()) {
                retVal.setDeviceName(apiBlockDeviceMapping.getDeviceName());
            }
            if (apiBlockDeviceMapping.isEbsSet()) {
                retVal.setEbsDevice(toBl(apiBlockDeviceMapping.getEbs()));
            }
        }
        return retVal;
    }

    private static EbsDevice toBl (ApiEbsDevice apiEbsDevice) {
        EbsDevice retVal = null;
        if (apiEbsDevice != null) {
            if (apiEbsDevice.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(apiEbsDevice.getDeleteOnTermination());
            }
            if (apiEbsDevice.isDynamicVolumeSizeSet()) {
                retVal.setDynamicVolumeSize(toBl(apiEbsDevice.getDynamicVolumeSize()));
            }
            if (apiEbsDevice.isEncryptedSet()) {
                retVal.setEncrypted(apiEbsDevice.getEncrypted());
            }
            if (apiEbsDevice.isIopsSet()) {
                retVal.setIops(apiEbsDevice.getIops());
            }
            if (apiEbsDevice.isMsKeyIdSet()) {
                retVal.setKmsKeyId(apiEbsDevice.getKmsKeyId());
            }
            if (apiEbsDevice.isSnapshotIdSet()) {
                retVal.setSnapshotId(apiEbsDevice.getSnapshotId());
            }
            if (apiEbsDevice.isThroughputSet()) {
                retVal.setThroughput(apiEbsDevice.getThroughput());
            }
            if (apiEbsDevice.isVolumeSizeSet()) {
                retVal.setVolumeSize(apiEbsDevice.getVolumeSize());
            }
            if (apiEbsDevice.isVolumeTypeSet()) {
                retVal.setVolumeType(AwsVolumeTypeEnum.fromName(apiEbsDevice.getVolumeType()));
            }
        }
        return retVal;
    }

    private static ClusterDynamicVolumeSize toBl (ApiClusterDynamicVolumeSize apiDynamicVolumeSize) {
        ClusterDynamicVolumeSize retVal = null;
        if (apiDynamicVolumeSize != null) {
            if (apiDynamicVolumeSize.isBaseSizeSet()) {
                retVal.setBaseSize(apiDynamicVolumeSize.getBaseSize());
            }
            if (apiDynamicVolumeSize.isResourceSet()) {
                retVal.setResource(apiDynamicVolumeSize.getResource());
            }
            if (apiDynamicVolumeSize.isSizePerResourceUnitSet()) {
                retVal.setSizePerResourceUnit(apiDynamicVolumeSize.getSizePerResourceUnit());
            }
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
            if (iamInstanceProfileSpec.isArnSet()) {
                retVal.setArn(iamInstanceProfileSpec.getArn());
            }
        }

        return retVal;
    }

    private static K8sVngInstanceMetadataOptions toBl (ApiK8sVngInstanceMetadataOptions ApiInstanceMetadataOptions) {
        K8sVngInstanceMetadataOptions retVal = null;

        if (ApiInstanceMetadataOptions != null) {
            if(ApiInstanceMetadataOptions.isHttpPutResponseHopLimitSet()) {
                retVal.setHttpPutResponseHopLimit(ApiInstanceMetadataOptions.getHttpPutResponseHopLimit());
            }
            if(ApiInstanceMetadataOptions.isHttpTokensSet()) {
                retVal.setHttpTokens(ApiInstanceMetadataOptions.getHttpTokens());
            }
        }

        return retVal;
    }

    private static ClusterInstanceTypes toBl(ApiClusterInstanceTypes apiInstanceTypes) {
        ClusterInstanceTypes retVal = null;

        if (apiInstanceTypes != null) {
            if (apiInstanceTypes.isBlacklistSet()) {
                retVal.setBlacklist(apiInstanceTypes.getBlacklist());
            }
            if (apiInstanceTypes.isWhitelistSet()) {
                retVal.setWhitelist(apiInstanceTypes.getWhitelist());
            }
        }

        return retVal;
    }
}