package com.spotinst.sdkjava.model.converters.ocean.ecs;

import com.spotinst.sdkjava.model.api.ocean.ecs.*;
import com.spotinst.sdkjava.model.bl.ocean.ecs.*;

import java.util.List;
import java.util.stream.Collectors;

public class OceanEcsLaunchSpecConverter {
    //region BL -> DAL

    public static ApiClusterLaunchSpecification toDal(ClusterLaunchSpecification launchSpecification) {
        ApiClusterLaunchSpecification retVal = null;

        if (launchSpecification != null) {
            retVal = new ApiClusterLaunchSpecification();

            if (launchSpecification.isIdSet()) {
                retVal.setId(launchSpecification.getId());
            }
            if (launchSpecification.isImageIdSet()) {
                retVal.setImageId(launchSpecification.getImageId());
            }
            if (launchSpecification.isNameSet()) {
                retVal.setName(launchSpecification.getName());
            }
            if (launchSpecification.isOceanIdSet()) {
                retVal.setOceanId(launchSpecification.getOceanId());
            }
            if (launchSpecification.isAttributesSet()) {
                List<ApiClusterAttributes> attributes =
                        launchSpecification.getAttributes().stream().map(OceanEcsLaunchSpecConverter::toDal)
                                           .collect(Collectors.toList());
                retVal.setAttributes(attributes);
            }
            if (launchSpecification.isAutoScaleSet()) {
                retVal.setAutoScale(toDal(launchSpecification.getAutoScale()));
            }
            if (launchSpecification.isBlockDeviceMappingsSet()) {
                List<ApiLaunchSpecBlockDeviceMappings> blockDeviceMappings =
                        launchSpecification.getBlockDeviceMappings().stream().map(OceanEcsLaunchSpecConverter::toDal)
                                           .collect(Collectors.toList());
                retVal.setBlockDeviceMappings(blockDeviceMappings);
            }
            if (launchSpecification.isIamInstanceProfileSet()) {
                ApiLaunchSpecIamInstanceProfileSpecification instanceProfileSpecs =
                        toDal(launchSpecification.getIamInstanceProfile());
                retVal.setIamInstanceProfile(instanceProfileSpecs);
            }
            if (launchSpecification.isInstanceMetadataOptionsSet()) {
                retVal.setInstanceMetadataOptions(toDal(launchSpecification.getInstanceMetadataOptions()));
            }
            if (launchSpecification.isInstanceTypesSet()) {
                retVal.setInstanceTypes(launchSpecification.getInstanceTypes());
            }
            if (launchSpecification.isRestrictScaleDownSet()) {
                retVal.setRestrictScaleDown(launchSpecification.getRestrictScaleDown());
            }
            if (launchSpecification.isSecurityGroupIdsSet()) {
                retVal.setSecurityGroupIds(launchSpecification.getSecurityGroupIds());
            }
            if (launchSpecification.isSubnetIdsSet()) {
                retVal.setSubnetIds(launchSpecification.getSubnetIds());
            }
            if (launchSpecification.isTagsSet()) {
                List<ApiLaunchSpecTagsSepcification> tags =
                        launchSpecification.getTags().stream().map(OceanEcsLaunchSpecConverter::toDal)
                                           .collect(Collectors.toList());
                retVal.setTags(tags);
            }
            if (launchSpecification.isUserDataSet()) {
                retVal.setUserData(launchSpecification.getUserData());
            }
        }
        return retVal;
    }

    private static ApiClusterAttributes toDal(ClusterAttributes attributes) {
        ApiClusterAttributes retVal = null;

        if (attributes != null) {

            if (attributes.isKeySet() && attributes.isValueSet()) {
                retVal = new ApiClusterAttributes(attributes.getKey(), attributes.getValue());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecAutoScaleSpecification toDal(LaunchSpecAutoScaleSpecification autoScaler) {
        ApiLaunchSpecAutoScaleSpecification retval = null;

        if (autoScaler != null) {
            retval = new ApiLaunchSpecAutoScaleSpecification();

            if (autoScaler.isHeadroomSet()) {
                List<ApiClusterHeadroomsSpecification> headrooms =
                        autoScaler.getHeadrooms().stream().map(OceanEcsLaunchSpecConverter::toDal)
                                  .collect(Collectors.toList());
                retval.setHeadrooms(headrooms);
            }
        }

        return retval;
    }

    private static ApiClusterHeadroomsSpecification toDal(ClusterHeadroomsSpecification headroom) {
        ApiClusterHeadroomsSpecification retVal = null;

        if (headroom != null) {
            retVal = new ApiClusterHeadroomsSpecification();

            if (headroom.isCpuPerUnitSet()) {
                retVal.setCpuPerUnit(headroom.getCpuPerUnit());
            }
            if (headroom.isMemoryPerUnitSet()) {
                retVal.setMemoryPerUnit(headroom.getMemoryPerUnit());
            }
            if (headroom.isNumOfUnitsSet()) {
                retVal.setNumOfUnits(headroom.getNumOfUnits());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecBlockDeviceMappings toDal(LaunchSpecBlockDeviceMappings blockDeviceMappings) {
        ApiLaunchSpecBlockDeviceMappings retVal = null;

        if (blockDeviceMappings != null) {
            retVal = new ApiLaunchSpecBlockDeviceMappings();

            if (blockDeviceMappings.isDeviceNameSet()) {
                retVal.setDeviceName(blockDeviceMappings.getDeviceName());
            }
            if (blockDeviceMappings.isEbsSet()) {
                retVal.setEbs(toDal(blockDeviceMappings.getEbs()));
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecEbsSpecification toDal(LaunchSpecEbsSpecification ebs) {
        ApiLaunchSpecEbsSpecification retVal = null;

        if (ebs != null) {
            retVal = new ApiLaunchSpecEbsSpecification();

            if (ebs.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(ebs.getDeleteOnTermination());
            }
            if (ebs.isDynamicVolumeSizeSet()) {
                retVal.setDynamicVolumeSize(toDal(ebs.getDynamicVolumeSize()));
            }
            if (ebs.isEncryptedSet()) {
                retVal.setEncrypted(ebs.getEncrypted());
            }
            if (ebs.isIopsSet()) {
                retVal.setIops(ebs.getIops());
            }
            if (ebs.isKmsKeyIdSet()) {
                retVal.setKmsKeyId(ebs.getKmsKeyId());
            }
            if (ebs.isSnapshotIdSet()) {
                retVal.setSnapshotId(ebs.getSnapshotId());
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

    private static ApiLaunchSpecDynamicVolumeSize toDal(LaunchSpecDynamicVolumeSize dynamicVolumeSize) {
        ApiLaunchSpecDynamicVolumeSize retVal = null;

        if (dynamicVolumeSize != null) {
            retVal = new ApiLaunchSpecDynamicVolumeSize();

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

    private static ApiLaunchSpecIamInstanceProfileSpecification toDal(
            LaunchSpecIamInstanceProfileSpecification instanceProfile) {
        ApiLaunchSpecIamInstanceProfileSpecification retVal = null;

        if (instanceProfile != null) {
            retVal = new ApiLaunchSpecIamInstanceProfileSpecification();

            if (instanceProfile.isArnSet()) {
                retVal.setArn(instanceProfile.getArn());
            }
            if (instanceProfile.isNameSet()) {
                retVal.setName(instanceProfile.getName());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecInstanceMetadataOptions toDal(LaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
        ApiLaunchSpecInstanceMetadataOptions retVal = null;

        if (instanceMetadataOptions != null) {
            retVal = new ApiLaunchSpecInstanceMetadataOptions();

            if (instanceMetadataOptions.isHttpPutResponseHopLimitSet()) {
                retVal.setHttpPutResponseHopLimit(instanceMetadataOptions.getHttpPutResponseHopLimit());
            }
            if (instanceMetadataOptions.isHttpTokensSet()) {
                retVal.setHttpTokens(instanceMetadataOptions.getHttpTokens());
            }
        }
        return retVal;
    }

    private static ApiLaunchSpecTagsSepcification toDal(LaunchSpecTagsSepcification tag) {
        ApiLaunchSpecTagsSepcification retVal = null;

        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                retVal = new ApiLaunchSpecTagsSepcification(tag.getTagKey(), tag.getTagValue());
            }
        }
        return retVal;
    }

    //region DAL ->
    public static ClusterLaunchSpecification toBl(ApiClusterLaunchSpecification launchSpecification) {
        ClusterLaunchSpecification retVal = null;

        if (launchSpecification != null) {
            ClusterLaunchSpecification.Builder clusterLaunchSpecBuilder = ClusterLaunchSpecification.Builder.get();

            if (launchSpecification.isIdSet()) {
                clusterLaunchSpecBuilder.setId(launchSpecification.getId());
            }
            if (launchSpecification.isImageIdSet()) {
                clusterLaunchSpecBuilder.setImageId(launchSpecification.getImageId());
            }
            if (launchSpecification.isNameSet()) {
                clusterLaunchSpecBuilder.setName(launchSpecification.getName());
            }
            if (launchSpecification.isOceanIdSet()) {
                clusterLaunchSpecBuilder.setOceanId(launchSpecification.getOceanId());
            }
            if (launchSpecification.isAttributesSet()) {
                List<ClusterAttributes> attributes =
                        launchSpecification.getAttributes().stream().map(OceanEcsLaunchSpecConverter::toBl)
                                           .collect(Collectors.toList());
                clusterLaunchSpecBuilder.setAttributes(attributes);
            }
            if (launchSpecification.isAutoScaleSet()) {
                clusterLaunchSpecBuilder.setAutoScale(toBl(launchSpecification.getAutoScale()));
            }
            if (launchSpecification.isBlockDeviceMappingsSet()) {
                List<LaunchSpecBlockDeviceMappings> blockDeviceMappings =
                        launchSpecification.getBlockDeviceMappings().stream().map(OceanEcsLaunchSpecConverter::toBl)
                                           .collect(Collectors.toList());
                clusterLaunchSpecBuilder.setBlockDeviceMappings(blockDeviceMappings);
            }
            if (launchSpecification.isIamInstanceProfileSet()) {
                LaunchSpecIamInstanceProfileSpecification
                        instanceProfileSpecs = toBl(launchSpecification.getIamInstanceProfile());
                clusterLaunchSpecBuilder.setIamInstanceProfile(instanceProfileSpecs);
            }
            if (launchSpecification.isInstanceMetadataOptionsSet()) {
                clusterLaunchSpecBuilder
                        .setInstanceMetadataOptions(toBl(launchSpecification.getInstanceMetadataOptions()));
            }
            if (launchSpecification.isInstanceTypesSet()) {
                clusterLaunchSpecBuilder.setInstanceTypes(launchSpecification.getInstanceTypes());
            }
            if (launchSpecification.isRestrictScaleDownSet()) {
                clusterLaunchSpecBuilder.setRestrictScaleDown(launchSpecification.getRestrictScaleDown());
            }
            if (launchSpecification.isSecurityGroupIdsSet()) {
                clusterLaunchSpecBuilder.setSecurityGroupIds(launchSpecification.getSecurityGroupIds());
            }
            if (launchSpecification.isSubnetIdsSet()) {
                clusterLaunchSpecBuilder.setSubnetIds(launchSpecification.getSubnetIds());
            }
            if (launchSpecification.isTagsSet()) {
                List<LaunchSpecTagsSepcification> tags =
                        launchSpecification.getTags().stream().map(OceanEcsLaunchSpecConverter::toBl)
                                           .collect(Collectors.toList());
                clusterLaunchSpecBuilder.setTags(tags);
            }
            if (launchSpecification.isUserDataSet()) {
                clusterLaunchSpecBuilder.setUserData(launchSpecification.getUserData());
            }
            retVal = clusterLaunchSpecBuilder.build();
        }
        return retVal;
    }

    private static ClusterAttributes toBl(ApiClusterAttributes attributes) {
        ClusterAttributes retVal = null;

        if (attributes != null) {
            ClusterAttributes.Builder attributeBuilder = ClusterAttributes.Builder.get();

            if (attributes.isKeySet() && attributes.isValueSet()) {
                attributeBuilder.setKey(attributes.getKey());
                attributeBuilder.setValue(attributes.getValue());
            }
            retVal = attributeBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecAutoScaleSpecification toBl(ApiLaunchSpecAutoScaleSpecification autoScaler) {
        LaunchSpecAutoScaleSpecification retval = null;

        if (autoScaler != null) {
            LaunchSpecAutoScaleSpecification.Builder autoScaleBuilder = LaunchSpecAutoScaleSpecification.Builder.get();

            if (autoScaler.isHeadroomSet()) {
                List<ClusterHeadroomsSpecification> headrooms =
                        autoScaler.getHeadrooms().stream().map(OceanEcsLaunchSpecConverter::toBl)
                                  .collect(Collectors.toList());
                autoScaleBuilder.setHeadrooms(headrooms);
            }
            retval = autoScaleBuilder.build();
        }
        return retval;
    }

    private static ClusterHeadroomsSpecification toBl(ApiClusterHeadroomsSpecification headroom) {
        ClusterHeadroomsSpecification retVal = null;

        if (headroom != null) {
            ClusterHeadroomsSpecification.Builder headroomBuilder = ClusterHeadroomsSpecification.Builder.get();

            if (headroom.isCpuPerUnitSet()) {
                headroomBuilder.setCpuPerUnit(headroom.getCpuPerUnit());
            }
            if (headroom.isMemoryPerUnitSet()) {
                headroomBuilder.setMemoryPerUnit(headroom.getMemoryPerUnit());
            }
            if (headroom.isNumOfUnitsSet()) {
                headroomBuilder.setNumOfUnits(headroom.getNumOfUnits());
            }
            retVal = headroomBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecBlockDeviceMappings toBl(ApiLaunchSpecBlockDeviceMappings blockDeviceMappings) {
        LaunchSpecBlockDeviceMappings retVal = null;

        if (blockDeviceMappings != null) {
            LaunchSpecBlockDeviceMappings.Builder blockDeviceMappingsBuilder = LaunchSpecBlockDeviceMappings.Builder.get();

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

    private static LaunchSpecEbsSpecification toBl(ApiLaunchSpecEbsSpecification ebs) {
        LaunchSpecEbsSpecification retVal = null;

        if (ebs != null) {
            LaunchSpecEbsSpecification.Builder ebsBuilder = LaunchSpecEbsSpecification.Builder.get();

            if (ebs.isDeleteOnTerminationSet()) {
                ebsBuilder.setDeleteOnTermination(ebs.getDeleteOnTermination());
            }
            if (ebs.isDynamicVolumeSizeSet()) {
                ebsBuilder.setDynamicVolumeSize(toBl(ebs.getDynamicVolumeSize()));
            }
            if (ebs.isEncryptedSet()) {
                ebsBuilder.setEncrypted(ebs.getEncrypted());
            }
            if (ebs.isIopsSet()) {
                ebsBuilder.setIops(ebs.getIops());
            }
            if (ebs.isKmsKeyIdSet()) {
                ebsBuilder.setKmsKeyId(ebs.getKmsKeyId());
            }
            if (ebs.isSnapshotIdSet()) {
                ebsBuilder.setSnapshotId(ebs.getSnapshotId());
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

    private static LaunchSpecDynamicVolumeSize toBl(ApiLaunchSpecDynamicVolumeSize dynamicVolumeSize) {
        LaunchSpecDynamicVolumeSize retVal = null;

        if (dynamicVolumeSize != null) {
            LaunchSpecDynamicVolumeSize.Builder volumeSizeBuilder = LaunchSpecDynamicVolumeSize.Builder.get();

            if (dynamicVolumeSize.isBaseSizeSet()) {
                volumeSizeBuilder.setBaseSize(dynamicVolumeSize.getBaseSize());
            }
            if (dynamicVolumeSize.isResourceSet()) {
                volumeSizeBuilder.setResource(dynamicVolumeSize.getResource());
            }
            if (dynamicVolumeSize.isSizePerResourceUnitSet()) {
                volumeSizeBuilder.setSizePerResourceUnit(dynamicVolumeSize.getSizePerResourceUnit());
            }
            retVal = volumeSizeBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecIamInstanceProfileSpecification toBl(ApiLaunchSpecIamInstanceProfileSpecification instanceProfile) {
        LaunchSpecIamInstanceProfileSpecification retVal = null;

        if (instanceProfile != null) {
            LaunchSpecIamInstanceProfileSpecification.Builder IamInstanceProfileSpecBuilder =
                    LaunchSpecIamInstanceProfileSpecification.Builder.get();

            if (instanceProfile.isArnSet()) {
                IamInstanceProfileSpecBuilder.setArn(instanceProfile.getArn());
            }
            if (instanceProfile.isNameSet()) {
                IamInstanceProfileSpecBuilder.setName(instanceProfile.getName());
            }
            retVal = IamInstanceProfileSpecBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecInstanceMetadataOptions toBl(ApiLaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
        LaunchSpecInstanceMetadataOptions retVal = null;

        if (instanceMetadataOptions != null) {
            LaunchSpecInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder =
                    LaunchSpecInstanceMetadataOptions.Builder.get();

            if (instanceMetadataOptions.isHttpPutResponseHopLimitSet()) {
                instanceMetadataOptionsBuilder
                        .setHttpPutResponseHopLimit(instanceMetadataOptions.getHttpPutResponseHopLimit());
            }
            if (instanceMetadataOptions.isHttpTokensSet()) {
                instanceMetadataOptionsBuilder.setHttpTokens(instanceMetadataOptions.getHttpTokens());
            }
            retVal = instanceMetadataOptionsBuilder.build();
        }
        return retVal;
    }

    private static LaunchSpecTagsSepcification toBl(ApiLaunchSpecTagsSepcification tag) {
        LaunchSpecTagsSepcification retVal = null;

        if (tag != null) {
            LaunchSpecTagsSepcification.Builder tagBuilder = LaunchSpecTagsSepcification.Builder.get();

            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                tagBuilder.setTagKey(tag.getTagKey());
                tagBuilder.setTagValue(tag.getTagValue());
            }
            retVal = tagBuilder.build();
        }
        return retVal;
    }
}
