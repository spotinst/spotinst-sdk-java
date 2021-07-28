package com.spotinst.sdkjava.model.converters;

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
                List<ApiClusterBlockDeviceMappings> blockDeviceMappings =
                        launchSpecification.getBlockDeviceMappings().stream().map(OceanEcsLaunchSpecConverter::toDal)
                                           .collect(Collectors.toList());
                retVal.setBlockDeviceMappings(blockDeviceMappings);
            }
            if (launchSpecification.isIamInstanceProfileSet()) {
                ApiClusterIamInstanceProfileSpec instanceProfileSpecs =
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
                List<ApiClusterTagsSepcification> tags =
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

    private static ApiClusterAutoScaleSpecification toDal(ClusterAutoScaleSpecification autoScaler) {
        ApiClusterAutoScaleSpecification retval = null;

        if (autoScaler != null) {
            retval = new ApiClusterAutoScaleSpecification();

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

    private static ApiClusterBlockDeviceMappings toDal(ClusterBlockDeviceMappings blockDeviceMappings) {
        ApiClusterBlockDeviceMappings retVal = null;

        if (blockDeviceMappings != null) {
            retVal = new ApiClusterBlockDeviceMappings();

            if (blockDeviceMappings.isDeviceNameSet()) {
                retVal.setDeviceName(blockDeviceMappings.getDeviceName());
            }
            if (blockDeviceMappings.isEbsSet()) {
                retVal.setEbs(toDal(blockDeviceMappings.getEbs()));
            }
        }
        return retVal;
    }

    private static ApiClusterEbsSpecification toDal(ClusterEbsSpecification ebs) {
        ApiClusterEbsSpecification retVal = null;

        if (ebs != null) {
            retVal = new ApiClusterEbsSpecification();

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
            if (ebs.isMsKeyIdSet()) {
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

    private static ApiClusterDynamicVolumeSize toDal(ClusterDynamicVolumeSize dynamicVolumeSize) {
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

    private static ApiClusterIamInstanceProfileSpec toDal(ClusterIamInstanceProfileSpec instanceProfile) {
        ApiClusterIamInstanceProfileSpec retVal = null;

        if (instanceProfile != null) {
            retVal = new ApiClusterIamInstanceProfileSpec();

            if (instanceProfile.isArnSet()) {
                retVal.setArn(instanceProfile.getArn());
            }
            if (instanceProfile.isNameSet()) {
                retVal.setName(instanceProfile.getName());
            }
        }
        return retVal;
    }

    private static ApiClusterInstanceMetadataOptions toDal(ClusterInstanceMetadataOptions instanceMetadataOptions) {
        ApiClusterInstanceMetadataOptions retVal = null;

        if (instanceMetadataOptions != null) {
            retVal = new ApiClusterInstanceMetadataOptions();

            if (instanceMetadataOptions.isHttpPutResponseHopLimitSet()) {
                retVal.setHttpPutResponseHopLimit(instanceMetadataOptions.getHttpPutResponseHopLimit());
            }
            if (instanceMetadataOptions.isHttpTokensSet()) {
                retVal.setHttpTokens(instanceMetadataOptions.getHttpTokens());
            }
        }
        return retVal;
    }

    private static ApiClusterTagsSepcification toDal(ClusterTagsSepcification tag) {
        ApiClusterTagsSepcification retVal = null;

        if (tag != null) {
            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                retVal = new ApiClusterTagsSepcification(tag.getTagKey(), tag.getTagValue());
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
                List<ClusterBlockDeviceMappings> blockDeviceMappings =
                        launchSpecification.getBlockDeviceMappings().stream().map(OceanEcsLaunchSpecConverter::toBl)
                                           .collect(Collectors.toList());
                clusterLaunchSpecBuilder.setBlockDeviceMappings(blockDeviceMappings);
            }
            if (launchSpecification.isIamInstanceProfileSet()) {
                ClusterIamInstanceProfileSpec instanceProfileSpecs = toBl(launchSpecification.getIamInstanceProfile());
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
                List<ClusterTagsSepcification> tags =
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

    private static ClusterAutoScaleSpecification toBl(ApiClusterAutoScaleSpecification autoScaler) {
        ClusterAutoScaleSpecification retval = null;

        if (autoScaler != null) {
            ClusterAutoScaleSpecification.Builder autoScaleBuilder = ClusterAutoScaleSpecification.Builder.get();

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

    private static ClusterBlockDeviceMappings toBl(ApiClusterBlockDeviceMappings blockDeviceMappings) {
        ClusterBlockDeviceMappings retVal = null;

        if (blockDeviceMappings != null) {
            ClusterBlockDeviceMappings.Builder blockDeviceMappingsBuilder = ClusterBlockDeviceMappings.Builder.get();

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

    private static ClusterEbsSpecification toBl(ApiClusterEbsSpecification ebs) {
        ClusterEbsSpecification retVal = null;

        if (ebs != null) {
            ClusterEbsSpecification.Builder ebsBuilder = ClusterEbsSpecification.Builder.get();

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
            if (ebs.isMsKeyIdSet()) {
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

    private static ClusterDynamicVolumeSize toBl(ApiClusterDynamicVolumeSize dynamicVolumeSize) {
        ClusterDynamicVolumeSize retVal = null;

        if (dynamicVolumeSize != null) {
            ClusterDynamicVolumeSize.Builder volumeSizeBuilder = ClusterDynamicVolumeSize.Builder.get();

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

    private static ClusterIamInstanceProfileSpec toBl(ApiClusterIamInstanceProfileSpec instanceProfile) {
        ClusterIamInstanceProfileSpec retVal = null;

        if (instanceProfile != null) {
            ClusterIamInstanceProfileSpec.Builder IamInstanceProfileSpecBuilder =
                    ClusterIamInstanceProfileSpec.Builder.get();

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

    private static ClusterInstanceMetadataOptions toBl(ApiClusterInstanceMetadataOptions instanceMetadataOptions) {
        ClusterInstanceMetadataOptions retVal = null;

        if (instanceMetadataOptions != null) {
            ClusterInstanceMetadataOptions.Builder instanceMetadataOptionsBuilder =
                    ClusterInstanceMetadataOptions.Builder.get();

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

    private static ClusterTagsSepcification toBl(ApiClusterTagsSepcification tag) {
        ClusterTagsSepcification retVal = null;

        if (tag != null) {
            ClusterTagsSepcification.Builder tagBuilder = ClusterTagsSepcification.Builder.get();

            if (tag.isTagKeySet() && tag.isTagValueSet()) {
                tagBuilder.setTagKey(tag.getTagKey());
                tagBuilder.setTagValue(tag.getTagValue());
            }
            retVal = tagBuilder.build();
        }
        return retVal;
    }
}
