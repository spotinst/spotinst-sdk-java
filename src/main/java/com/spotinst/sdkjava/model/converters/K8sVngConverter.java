package com.spotinst.sdkjava.model.converters;


import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;
import com.spotinst.sdkjava.enums.K8sVngHttpTokensEnum;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class K8sVngConverter {
    public static ApiK8sVngSpec toDal(K8sVngSpec vngLaunchSpec) {
        ApiK8sVngSpec retVal = null;

        if (vngLaunchSpec != null) {
            retVal = new ApiK8sVngSpec();

            if (vngLaunchSpec.isIdSet()) {
                retVal.setId(vngLaunchSpec.getId());
            }

            if (vngLaunchSpec.isNameSet()) {
                retVal.setName(vngLaunchSpec.getName());
            }

            if (vngLaunchSpec.isAssociatePublicIpAddressSet()) {
                retVal.setAssociatePublicIpAddress(vngLaunchSpec.getAssociatePublicIpAddress());
            }

            if (vngLaunchSpec.isAutoScaleSet()) {
                retVal.setAutoScale(toDal(vngLaunchSpec.getAutoScale()));
            }

            if (vngLaunchSpec.isBlockDevicesSet()) {
                if (vngLaunchSpec.getBlockDevices() != null) {
                    List<ApiK8sVngBlockDevice> vngBlockDeviceList = vngLaunchSpec.getBlockDevices()
                                                                                 .stream()
                                                                                 .map(K8sVngConverter::toDal)
                                                                                 .collect(Collectors.toList());
                    retVal.setBlockDeviceMappings(vngBlockDeviceList);
                }
            }

            if (vngLaunchSpec.isElasticIpPoolSet()) {
                retVal.setElasticIpPool(toDal(vngLaunchSpec.getElasticIpPool()));
            }

            if (vngLaunchSpec.isTagsSet()) {
                if (vngLaunchSpec.getTags() != null) {
                    List<ApiK8sVngTag> k8sVngTagList = vngLaunchSpec.getTags()
                                                                    .stream()
                                                                    .map(K8sVngConverter::toDal)
                                                                    .collect(Collectors.toList());
                    retVal.setTags(k8sVngTagList);
                }
            }

            if (vngLaunchSpec.isLabelsSet()) {
                if (vngLaunchSpec.getLabels() != null) {
                    List<ApiK8sVngLabels> k8sVngLabels = vngLaunchSpec.getLabels()
                                                                      .stream()
                                                                      .map(K8sVngConverter::toDal)
                                                                      .collect(Collectors.toList());

                    retVal.setLabels(k8sVngLabels);
                }
            }

            if (vngLaunchSpec.isTaintsSet()) {
                if (vngLaunchSpec.getTaints() != null) {
                    List<ApiK8sVngTaints> k8sVngTaints = vngLaunchSpec.getTaints()
                                                                      .stream()
                                                                      .map(K8sVngConverter::toDal)
                                                                      .collect(Collectors.toList());

                    retVal.setTaints(k8sVngTaints);
                }
            }

            if (vngLaunchSpec.isIamInstanceProfileSet()) {
                if (vngLaunchSpec.getIamInstanceProfile() != null) {
                    retVal.setIamInstanceProfile(toDal(vngLaunchSpec.getIamInstanceProfile()));
                }
            }

            if (vngLaunchSpec.isImageIdSet()) {
                retVal.setImageId(vngLaunchSpec.getImageId());
            }
            if (vngLaunchSpec.isInstanceMetadataOptionsSet()) {
                if (vngLaunchSpec.getInstanceMetadataOptions() != null) {
                    retVal.setInstanceMetadataOptions(toDal(vngLaunchSpec.getInstanceMetadataOptions()));
                }
            }

            if (vngLaunchSpec.isInstanceTypesSet()) {
                retVal.setInstanceTypes(vngLaunchSpec.getInstanceTypes());
            }

            if (vngLaunchSpec.isOceanIdSet()) {
                retVal.setOceanId(vngLaunchSpec.getOceanId());
            }

            if (vngLaunchSpec.isPreferredSpotTypesSet()) {
                retVal.setPreferredSpotTypes(vngLaunchSpec.getPreferredSpotTypes());
            }

            if (vngLaunchSpec.isResourceLimitsSet()) {
                if (vngLaunchSpec.getResourceLimits() != null) {
                    retVal.setResourceLimits(toDal(vngLaunchSpec.getResourceLimits()));
                }
            }

            if (vngLaunchSpec.isRestrictScaleDownSet()) {
                retVal.setRestrictScaleDown(vngLaunchSpec.getRestrictScaleDown());
            }

            if (vngLaunchSpec.isRootVolumeSizeSet()) {
                retVal.setRootVolumeSize(vngLaunchSpec.getRootVolumeSize());
            }

            if (vngLaunchSpec.isSecurityGroupIdsSet()) {
                retVal.setSecurityGroupIds(vngLaunchSpec.getSecurityGroupIds());
            }

            if (vngLaunchSpec.isStrategySet()) {
                retVal.setStrategy(toDal(vngLaunchSpec.getStrategy()));
            }

            if (vngLaunchSpec.isSubnetIdsSet()) {
                retVal.setSubnetIds(vngLaunchSpec.getSubnetIds());
            }

            if (vngLaunchSpec.isUserDataSet()) {
                retVal.setUserData(vngLaunchSpec.getUserData());
            }
        }

        return retVal;
    }

    private static ApiK8sVngAutoScaleSpec toDal(K8sVngAutoScaleSpec vngAutoScaleSpec) {
        ApiK8sVngAutoScaleSpec retval = null;

        if (vngAutoScaleSpec != null) {
            retval = new ApiK8sVngAutoScaleSpec();

            if (vngAutoScaleSpec.isHeadroomSet()) {
                List<ApiK8sVngHeadroomSpec> headrooms = vngAutoScaleSpec.getHeadrooms()
                                                                        .stream()
                                                                        .map(K8sVngConverter::toDal)
                                                                        .collect(Collectors.toList());
                retval.setHeadrooms(headrooms);
            }
        }

        return retval;
    }

    private static ApiK8sVngHeadroomSpec toDal(K8sVngHeadroomSpec headroom) {
        ApiK8sVngHeadroomSpec retVal = null;
        if (headroom != null) {
            retVal = new ApiK8sVngHeadroomSpec();
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

    private static ApiK8sVngBlockDevice toDal (K8sVngBlockDevice blockDeviceMapping) {
        ApiK8sVngBlockDevice retVal = null;
        if (blockDeviceMapping != null) {
            retVal = new ApiK8sVngBlockDevice();

            if (blockDeviceMapping.isDeviceNameSet()) {
                retVal.setDeviceName(blockDeviceMapping.getDeviceName());
            }

            if (blockDeviceMapping.isEbsDeviceSet()) {
                retVal.setEbs(toDal(blockDeviceMapping.getEbsDevice()));
            }
        }
        return retVal;
    }

    private static ApiK8sVngEbsDevice toDal (K8sVngEbsDevice VngEbsDevice) {
        ApiK8sVngEbsDevice retVal = null;
        if (VngEbsDevice != null) {
            retVal = new ApiK8sVngEbsDevice();

            if (VngEbsDevice.isDeleteOnTerminationSet()) {
                retVal.setDeleteOnTermination(VngEbsDevice.getDeleteOnTermination());
            }

            if (VngEbsDevice.isDynamicVolumeSizeSet()) {
                retVal.setDynamicVolumeSize(toDal(VngEbsDevice.getDynamicVolumeSize()));
            }
            if (VngEbsDevice.isEncryptedSet()) {
                retVal.setEncrypted(VngEbsDevice.getEncrypted());
            }

            if (VngEbsDevice.isIopsSet()) {
                retVal.setIops(VngEbsDevice.getIops());
            }

            if (VngEbsDevice.isMsKeyIdSet()) {
                retVal.setKmsKeyId(VngEbsDevice.getKmsKeyId());
            }

            if (VngEbsDevice.isSnapshotIdSet()) {
                retVal.setSnapshotId(VngEbsDevice.getSnapshotId());
            }

            if (VngEbsDevice.isThroughputSet()) {
                retVal.setThroughput(VngEbsDevice.getThroughput());
            }

            if (VngEbsDevice.isVolumeSizeSet()) {
                retVal.setVolumeSize(VngEbsDevice.getVolumeSize());
            }

            if (VngEbsDevice.isVolumeTypeSet()) {
                retVal.setVolumeType(VngEbsDevice.getVolumeType().getName());
            }
        }
        return retVal;
    }

    private static ApiK8sVngDynamicVolumeSize toDal (K8sVngDynamicVolumeSize dynamicVolumeSize) {
        ApiK8sVngDynamicVolumeSize retVal = null;
        if (dynamicVolumeSize != null) {
            retVal = new ApiK8sVngDynamicVolumeSize();

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

    private static ApiK8sVngElasticIpPool toDal (K8sVngElasticIpPool k8sVngElasticIpPool) {
        ApiK8sVngElasticIpPool retVal = null;

        if (k8sVngElasticIpPool != null) {
            retVal = new ApiK8sVngElasticIpPool();

            if (k8sVngElasticIpPool.isTagSelectorSet()) {
                retVal.setTagSelector(toDal(k8sVngElasticIpPool.getTagSelector()));
            }
        }

        return retVal;
    }

    private static ApiK8sVngTagSelector toDal (K8sVngTagSelector k8sVngTagSelector) {
        ApiK8sVngTagSelector retVal = null;

        if (k8sVngTagSelector != null) {
            retVal = new ApiK8sVngTagSelector();

            if (k8sVngTagSelector.isTagKeySet()) {
                retVal.setTagKey(k8sVngTagSelector.getTagKey());
            }

            if (k8sVngTagSelector.isTagValueSet()) {
                retVal.setTagValue(k8sVngTagSelector.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiK8sVngTag toDal(K8sVngTag k8sVngTag) {
        ApiK8sVngTag retVal = null;

        if (k8sVngTag != null) {

            if (k8sVngTag.isTagKeySet() && k8sVngTag.isTagValueSet()) {
                retVal = new ApiK8sVngTag(k8sVngTag.getTagKey(), k8sVngTag.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiK8sVngLabels toDal (K8sVngLabels k8sVngLabels) {
        ApiK8sVngLabels retVal = null;

        if (k8sVngLabels != null) {
            if (k8sVngLabels.isKeySet() && k8sVngLabels.isValueSet()) {
                retVal = new ApiK8sVngLabels(k8sVngLabels.getKey(), k8sVngLabels.getValue());
            }
        }

        return retVal;
    }

    private static ApiK8sVngTaints toDal (K8sVngTaints k8sVngTaints) {
        ApiK8sVngTaints retVal = null;

        if (k8sVngTaints != null) {
            if (k8sVngTaints.isEffectSet() && k8sVngTaints.isKeySet() && k8sVngTaints.isValueSet()) {
                retVal = new ApiK8sVngTaints(k8sVngTaints.getEffect(), k8sVngTaints.getKey(), k8sVngTaints.getValue());
            }
        }

        return retVal;
    }

    private static ApiK8sVngIamInstanceProfileSpec toDal (K8sVngIamInstanceProfileSpec iamInstanceProfileSpec) {
        ApiK8sVngIamInstanceProfileSpec retVal = null;

        if (iamInstanceProfileSpec != null) {
            retVal = new ApiK8sVngIamInstanceProfileSpec();

            if (iamInstanceProfileSpec.isArnSet()) {
                retVal.setArn(iamInstanceProfileSpec.getArn());
            }
        }

        return retVal;
    }

    private static ApiK8sVngResourceLimits toDal (K8sVngResourceLimits k8sVngResourceLimits) {
        ApiK8sVngResourceLimits retVal = null;

        if(k8sVngResourceLimits != null) {
            retVal = new ApiK8sVngResourceLimits();

            if (k8sVngResourceLimits.isMaxInstanceCountSet()) {
                retVal.setMaxInstanceCount(k8sVngResourceLimits.getMaxInstanceCount());
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

    private static ApiK8sVngStrategySpec toDal (K8sVngStrategySpec strategy) {
        ApiK8sVngStrategySpec retVal = null;

        if(strategy != null) {
            retVal = new ApiK8sVngStrategySpec();

            if(strategy.isSpotPercentageSet()) {
                retVal.setSpotPercentage(strategy.getSpotPercentage());
            }
        }

        return retVal;
    }

    //Dal-> Bl
    public static K8sVngSpec toBl (ApiK8sVngSpec apiVngLaunchSpec) {
        K8sVngSpec retVal = null;

        if (apiVngLaunchSpec != null) {
            K8sVngSpec.Builder vngLaunchSpecBuilder = K8sVngSpec.Builder.get();

            if (apiVngLaunchSpec.isIdSet()) {
                vngLaunchSpecBuilder.setId(apiVngLaunchSpec.getId());
            }

            if (apiVngLaunchSpec.isNameSet()) {
                vngLaunchSpecBuilder.setName(apiVngLaunchSpec.getName());
            }

            if (apiVngLaunchSpec.isAssociatePublicIpAddressSet()) {
                vngLaunchSpecBuilder.setAssociatePublicIpAddress(apiVngLaunchSpec.getAssociatePublicIpAddress());
            }

            if (apiVngLaunchSpec.isAutoScaleSet()) {
                vngLaunchSpecBuilder.setAutoScale(toBl(apiVngLaunchSpec.getAutoScale()));
            }

            if (apiVngLaunchSpec.isBlockDeviceMappingsSet()) {
                if (apiVngLaunchSpec.getBlockDeviceMappings() != null) {
                    List<K8sVngBlockDevice> vngBlockDeviceList = apiVngLaunchSpec.getBlockDeviceMappings()
                                                                                 .stream()
                                                                                 .map(K8sVngConverter::toBl)
                                                                                 .collect(Collectors.toList());
                    vngLaunchSpecBuilder.setBlockDevices(vngBlockDeviceList);
                }
            }

            if (apiVngLaunchSpec.isElasticIpPoolSet()) {
                if (apiVngLaunchSpec.getElasticIpPool() != null) {
                    vngLaunchSpecBuilder.setElasticIpPool(toBl(apiVngLaunchSpec.getElasticIpPool()));
                }
            }

            if (apiVngLaunchSpec.isTagsSet()) {

                if (apiVngLaunchSpec.getTags() != null) {
                    List<K8sVngTag> k8sVngTagList = apiVngLaunchSpec.getTags()
                                                                    .stream()
                                                                    .map(K8sVngConverter::toBl)
                                                                    .collect(Collectors.toList());
                    vngLaunchSpecBuilder.setTags(k8sVngTagList);
                }
            }

            if (apiVngLaunchSpec.isLabelsSet()) {

                if (apiVngLaunchSpec.getLabels() != null) {
                    List<K8sVngLabels> k8sVngLabels = apiVngLaunchSpec.getLabels()
                                                                    .stream()
                                                                    .map(K8sVngConverter::toBl)
                                                                    .collect(Collectors.toList());

                    vngLaunchSpecBuilder.setLabels(k8sVngLabels);
                }
            }

            if (apiVngLaunchSpec.isTaintsSet()) {

                if (apiVngLaunchSpec.getTaints() != null) {
                    List<K8sVngTaints> k8sVngTaints = apiVngLaunchSpec.getTaints()
                                                                      .stream()
                                                                      .map(K8sVngConverter::toBl)
                                                                      .collect(Collectors.toList());

                    vngLaunchSpecBuilder.setTaints(k8sVngTaints);
                }
            }

            if (apiVngLaunchSpec.isIamInstanceProfileSet()) {

                if (apiVngLaunchSpec.getIamInstanceProfile() != null) {
                    vngLaunchSpecBuilder.setIamInstanceProfile(toBl(apiVngLaunchSpec.getIamInstanceProfile()));
                }
            }

            if (apiVngLaunchSpec.isImageIdSet()) {
                vngLaunchSpecBuilder.setImageId(apiVngLaunchSpec.getImageId());
            }

            if (apiVngLaunchSpec.isInstanceMetadataOptionsSet()) {

                if (apiVngLaunchSpec.getInstanceMetadataOptions() != null) {
                    vngLaunchSpecBuilder.setInstanceMetadataOptions(toBl(apiVngLaunchSpec.getInstanceMetadataOptions()));
                }
            }

            if (apiVngLaunchSpec.isResourceLimitsSet()) {

                if (apiVngLaunchSpec.getResourceLimits() != null) {
                    vngLaunchSpecBuilder.setResourceLimits(toBl(apiVngLaunchSpec.getResourceLimits()));
                }
            }

            if (apiVngLaunchSpec.isInstanceTypesSet()) {
                vngLaunchSpecBuilder.setInstanceTypes(apiVngLaunchSpec.getInstanceTypes());
            }

            if (apiVngLaunchSpec.isOceanIdSet()) {
                vngLaunchSpecBuilder.setOceanId(apiVngLaunchSpec.getOceanId());
            }

            if (apiVngLaunchSpec.isPreferredSpotTypesSet()) {
                vngLaunchSpecBuilder.setPreferredSpotTypes(apiVngLaunchSpec.getPreferredSpotTypes());
            }

            if (apiVngLaunchSpec.isRestrictScaleDownSet()) {
                vngLaunchSpecBuilder.setRestrictScaleDown(apiVngLaunchSpec.getRestrictScaleDown());
            }

            if (apiVngLaunchSpec.isRootVolumeSizeSet()) {
                vngLaunchSpecBuilder.setRootVolumeSize(apiVngLaunchSpec.getRootVolumeSize());
            }

            if (apiVngLaunchSpec.isSecurityGroupIdsSet()) {
                vngLaunchSpecBuilder.setSecurityGroupIds(apiVngLaunchSpec.getSecurityGroupIds());
            }

            if (apiVngLaunchSpec.isStrategySet()) {
                vngLaunchSpecBuilder.setStrategy(toBl(apiVngLaunchSpec.getStrategy()));
            }

            if (apiVngLaunchSpec.isSubnetIdsSet()) {
                vngLaunchSpecBuilder.setSubnetIds(apiVngLaunchSpec.getSubnetIds());
            }

            if (apiVngLaunchSpec.isUserDataSet()) {
                vngLaunchSpecBuilder.setUserData(apiVngLaunchSpec.getUserData());
            }

            retVal = vngLaunchSpecBuilder.build();
        }

        return retVal;
    }

    private static K8sVngAutoScaleSpec toBl(ApiK8sVngAutoScaleSpec vngAutoScaleSpec) {
        K8sVngAutoScaleSpec retval = null;

        if (vngAutoScaleSpec != null) {
            K8sVngAutoScaleSpec.Builder autoScaleBuilder = K8sVngAutoScaleSpec.Builder.get();

            if (vngAutoScaleSpec.isHeadroomSet()) {
                List<K8sVngHeadroomSpec> headrooms = vngAutoScaleSpec.getHeadrooms()
                                                                     .stream()
                                                                     .map(K8sVngConverter::toBl)
                                                                     .collect(Collectors.toList());
                autoScaleBuilder.setHeadrooms(headrooms);
            }
            retval = autoScaleBuilder.build();
        }
        return retval;
    }

    private static K8sVngHeadroomSpec toBl(ApiK8sVngHeadroomSpec apiHeadroom) {
        K8sVngHeadroomSpec retVal = null;
        if (apiHeadroom != null) {
            K8sVngHeadroomSpec.Builder headroomBuilder = K8sVngHeadroomSpec.Builder.get();

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

    private static K8sVngBlockDevice toBl (ApiK8sVngBlockDevice apiVngBlockDeviceMapping) {
        K8sVngBlockDevice retVal = null;
        if (apiVngBlockDeviceMapping != null) {
            K8sVngBlockDevice.Builder blockDeviceMappingBuilder = K8sVngBlockDevice.Builder.get();

            if (apiVngBlockDeviceMapping.isDeviceNameSet()) {
                blockDeviceMappingBuilder.setDeviceName(apiVngBlockDeviceMapping.getDeviceName());
            }

            if (apiVngBlockDeviceMapping.isEbsSet()) {
                blockDeviceMappingBuilder.setEbsDevice(toBl(apiVngBlockDeviceMapping.getEbs()));
            }

            retVal = blockDeviceMappingBuilder.build();
        }
        return retVal;
    }

    private static K8sVngEbsDevice toBl (ApiK8sVngEbsDevice apiVNGEbsDevice) {
        K8sVngEbsDevice retVal = null;
        if (apiVNGEbsDevice != null) {
            K8sVngEbsDevice.Builder VngEbsDeviceBuilder = K8sVngEbsDevice.Builder.get();

            if (apiVNGEbsDevice.isDeleteOnTerminationSet()) {
                VngEbsDeviceBuilder.setDeleteOnTermination(apiVNGEbsDevice.getDeleteOnTermination());
            }

            if (apiVNGEbsDevice.isDynamicVolumeSizeSet()) {
                VngEbsDeviceBuilder.setDynamicVolumeSize(toBl(apiVNGEbsDevice.getDynamicVolumeSize()));
            }

            if (apiVNGEbsDevice.isEncryptedSet()) {
                VngEbsDeviceBuilder.setEncrypted(apiVNGEbsDevice.getEncrypted());
            }

            if (apiVNGEbsDevice.isIopsSet()) {
                VngEbsDeviceBuilder.setIops(apiVNGEbsDevice.getIops());
            }

            if (apiVNGEbsDevice.isMsKeyIdSet()) {
                VngEbsDeviceBuilder.setKmsKeyId(apiVNGEbsDevice.getKmsKeyId());
            }

            if (apiVNGEbsDevice.isSnapshotIdSet()) {
                VngEbsDeviceBuilder.setSnapshotId(apiVNGEbsDevice.getSnapshotId());
            }

            if (apiVNGEbsDevice.isThroughputSet()) {
                VngEbsDeviceBuilder.setThroughput(apiVNGEbsDevice.getThroughput());
            }

            if (apiVNGEbsDevice.isVolumeSizeSet()) {
                VngEbsDeviceBuilder.setVolumeSize(apiVNGEbsDevice.getVolumeSize());
            }

            if (apiVNGEbsDevice.isVolumeTypeSet()) {
                VngEbsDeviceBuilder.setVolumeType(AwsVolumeTypeEnum.fromName(apiVNGEbsDevice.getVolumeType()));
            }

            retVal = VngEbsDeviceBuilder.build();
        }
        return retVal;
    }

    private static K8sVngElasticIpPool toBl (ApiK8sVngElasticIpPool apiK8sVngElasticIpPool) {
        K8sVngElasticIpPool retVal = null;
        if (apiK8sVngElasticIpPool != null) {
            K8sVngElasticIpPool.Builder vngElasticIpPoolBuilder = K8sVngElasticIpPool.Builder.get();

            if (apiK8sVngElasticIpPool.isTagSelectorSet()) {
                vngElasticIpPoolBuilder.setTagSelector(toBl(apiK8sVngElasticIpPool.getTagSelector()));
            }

            retVal = vngElasticIpPoolBuilder.build();
        }

        return retVal;
    }

    private static K8sVngTagSelector toBl (ApiK8sVngTagSelector apiK8sVngTagSelector) {
        K8sVngTagSelector retVal = null;
        if (apiK8sVngTagSelector != null) {
            K8sVngTagSelector.Builder vngTagSelectorBuilder = K8sVngTagSelector.Builder.get();

            if (apiK8sVngTagSelector.isTagKeySet()) {
                vngTagSelectorBuilder.setTagKey(apiK8sVngTagSelector.getTagKey());
            }

            if (apiK8sVngTagSelector.isValueSet()) {
                vngTagSelectorBuilder.setTagValue(apiK8sVngTagSelector.getTagValue());
            }

            retVal = vngTagSelectorBuilder.build();
        }

        return  retVal;
    }

    private static K8sVngDynamicVolumeSize toBl (ApiK8sVngDynamicVolumeSize apiDynamicVolumeSize) {
        K8sVngDynamicVolumeSize retVal = null;
        if (apiDynamicVolumeSize != null) {
            K8sVngDynamicVolumeSize.Builder dynamicVolumeSizeBuilder = K8sVngDynamicVolumeSize.Builder.get();

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

    private static K8sVngTag toBl(ApiK8sVngTag apiK8sVngTag) {
        K8sVngTag retVal = null;

        if (apiK8sVngTag != null) {
            if (apiK8sVngTag.isTagKeySet() && apiK8sVngTag.isTagValueSet()) {
                K8sVngTag.Builder k8sVngTagBuilder = K8sVngTag.Builder.get();
                retVal = k8sVngTagBuilder.setTagKey(apiK8sVngTag.getTagKey())
                                         .setTagValue(apiK8sVngTag.getTagValue())
                                         .build();
            }
        }

        return retVal;
    }

    private static K8sVngLabels toBl (ApiK8sVngLabels apiK8sVngLabels) {
        K8sVngLabels retVal = null;

        if (apiK8sVngLabels != null) {
            if (apiK8sVngLabels.isKeySet() && apiK8sVngLabels.isValueSet()) {
                K8sVngLabels.Builder k8sVngLabelsBuilder = K8sVngLabels.Builder.get();
                retVal = k8sVngLabelsBuilder.setKey(apiK8sVngLabels.getKey())
                                            .setValue((apiK8sVngLabels.getValue()))
                                            .build();
            }
        }

        return retVal;
    }

    private static K8sVngTaints toBl (ApiK8sVngTaints apiK8sVngTaints) {
        K8sVngTaints retVal = null;

        if (apiK8sVngTaints != null) {
            if (apiK8sVngTaints.isEffectSet() && apiK8sVngTaints.isKeySet() && apiK8sVngTaints.isValueSet()) {
                K8sVngTaints.Builder vngTaintsBuilder = K8sVngTaints.Builder.get();
                retVal = vngTaintsBuilder.setEffect(apiK8sVngTaints.getEffect())
                                         .setKey(apiK8sVngTaints.getKey())
                                         .setValue(apiK8sVngTaints.getValue())
                                         .build();
            }
        }

        return retVal;
    }
    private static K8sVngIamInstanceProfileSpec toBl (ApiK8sVngIamInstanceProfileSpec iamInstanceProfileSpec) {
        K8sVngIamInstanceProfileSpec retVal = null;

        if (iamInstanceProfileSpec != null) {
            K8sVngIamInstanceProfileSpec.Builder iamInstanceProfileSpecBuilder = K8sVngIamInstanceProfileSpec.Builder.get();

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

    private static K8sVngResourceLimits toBl (ApiK8sVngResourceLimits apiK8sVngResourceLimits) {
        K8sVngResourceLimits retVal = null;

        if (apiK8sVngResourceLimits != null) {
            K8sVngResourceLimits.Builder vngResourceLimitsBuilder = K8sVngResourceLimits.Builder.get();

            if (apiK8sVngResourceLimits.isMaxInstanceCountSet()) {
                vngResourceLimitsBuilder.setMaxInstanceCount((apiK8sVngResourceLimits.getMaxInstanceCount()));
            }

            retVal = vngResourceLimitsBuilder.build();
        }

        return retVal;
    }

    private static K8sVngStrategySpec toBl (ApiK8sVngStrategySpec apiStrategy) {
        K8sVngStrategySpec retVal = null;

        if(apiStrategy != null) {
            K8sVngStrategySpec.Builder strategyBuilder = K8sVngStrategySpec.Builder.get();

            if(apiStrategy.isSpotPercentageSet()) {
                strategyBuilder.setSpotPercentage(apiStrategy.getSpotPercentage());
            }

            retVal = strategyBuilder.build();
        }

        return retVal;
    }
}