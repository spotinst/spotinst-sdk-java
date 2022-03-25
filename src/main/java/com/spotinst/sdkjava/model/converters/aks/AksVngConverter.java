package com.spotinst.sdkjava.model.converters.aks;

import com.spotinst.sdkjava.model.api.ocean.aks.*;
import com.spotinst.sdkjava.model.bl.ocean.aks.*;

import java.util.List;
import java.util.stream.Collectors;

public class AksVngConverter {
    public static ApiClusterVirtualNodeGroup toDal(ClusterVirtualNodeGroup clusterVirtualNodeGroup) {
        ApiClusterVirtualNodeGroup retVal = null;

        if (clusterVirtualNodeGroup != null) {
            retVal = new ApiClusterVirtualNodeGroup();

            if (clusterVirtualNodeGroup.isNameSet()) {
                retVal.setName(clusterVirtualNodeGroup.getName());
            }

            if (clusterVirtualNodeGroup.isOceanIdSet()) {
                retVal.setOceanId(clusterVirtualNodeGroup.getOceanId());
            }

            if (clusterVirtualNodeGroup.isResourceLimitsSet()) {
                if (clusterVirtualNodeGroup.getResourceLimits() != null) {
                    retVal.setResourceLimits(toDal(clusterVirtualNodeGroup.getResourceLimits()));
                }
            }

            if (clusterVirtualNodeGroup.isLabelsSet()) {
                if (clusterVirtualNodeGroup.getLabels() != null) {
                    List<ApiClusterVngLabel> aksVngLabels = clusterVirtualNodeGroup.getLabels()
                            .stream()
                            .map(AksVngConverter::toDal)
                            .collect(Collectors.toList());

                    retVal.setLabels(aksVngLabels);
                }
            }

            if (clusterVirtualNodeGroup.isTaintsSet()) {
                if (clusterVirtualNodeGroup.getTaints() != null) {
                    List<ApiClusterVngTaints> aksVngTaints = clusterVirtualNodeGroup.getTaints()
                            .stream()
                            .map(AksVngConverter::toDal)
                            .collect(Collectors.toList());

                    retVal.setTaints(aksVngTaints);
                }
            }

            if (clusterVirtualNodeGroup.isVmSizesSet()) {
                retVal.setVmSizes(clusterVirtualNodeGroup.getVmSizes());
            }

            if (clusterVirtualNodeGroup.isZonesSet()) {
                retVal.setZones(clusterVirtualNodeGroup.getZones());
            }

            if (clusterVirtualNodeGroup.isAutoScaleSet()) {
                retVal.setAutoScale(toDal(clusterVirtualNodeGroup.getAutoScale()));
            }

            if (clusterVirtualNodeGroup.isLaunchSpecificationSet()) {
                retVal.setLaunchSpecification(toDal(clusterVirtualNodeGroup.getLaunchSpecification()));
            }

            }
        return retVal;

    }

    private static ApiClusterVngAutoScaleSpec toDal(ClusterVngAutoScaleSpec vngAutoScaleSpec) {
        ApiClusterVngAutoScaleSpec retval = null;

        if (vngAutoScaleSpec != null) {
            retval = new ApiClusterVngAutoScaleSpec();

            if (vngAutoScaleSpec.isHeadroomSet() && vngAutoScaleSpec.getHeadrooms() != null) {
                List<ApiClusterVngHeadroomSpec> headrooms = vngAutoScaleSpec.getHeadrooms()
                        .stream()
                        .map(AksVngConverter::toDal)
                        .collect(Collectors.toList());
                retval.setHeadrooms(headrooms);
            }

            if (vngAutoScaleSpec.isAutoHeadroomPercentageSet() && vngAutoScaleSpec.getAutoHeadroomPercentage() != null) {
                retval.setAutoHeadroomPercentage(vngAutoScaleSpec.getAutoHeadroomPercentage());
            }
        }

        return retval;
    }

    private static ApiClusterVngHeadroomSpec toDal(ClusterVngHeadroomSpec headroom) {
        ApiClusterVngHeadroomSpec retVal = null;
        if (headroom != null) {
            retVal = new ApiClusterVngHeadroomSpec();
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

    private static ApiClusterVngLaunchSpecification toDal(ClusterVngLaunchSpecificaion vngLaunchSpec) {
        ApiClusterVngLaunchSpecification retval = null;

        if (vngLaunchSpec != null) {
            retval = new ApiClusterVngLaunchSpecification();

            if (vngLaunchSpec.isTagsSet()) {
                if (vngLaunchSpec.getTags() != null) {
                    List<ApiClusterTagAks> aksVngTagList = vngLaunchSpec.getTags()
                            .stream()
                            .map(AksVngConverter::toDal)
                            .collect(Collectors.toList());
                    retval.setTags(aksVngTagList);
                }
            }

            if (vngLaunchSpec.isOsDiskSet()) {
                if (vngLaunchSpec.getOsDisk() != null) {
                    retval.setOsDisk(toDal(vngLaunchSpec.getOsDisk()));
                }
            }
        }

        return retval;
    }

    private static ApiClusterVngOsDisk toDal(ClusterVngOsDisk aksVngOsDisk) {
        ApiClusterVngOsDisk retVal = null;

        if (aksVngOsDisk != null) {
            retVal = new ApiClusterVngOsDisk();

            if (aksVngOsDisk.isTypeSet()) {
                retVal.setType(aksVngOsDisk.getType());
            }

            if (aksVngOsDisk.isSizeGBSet()) {
                retVal.setSizeGB(aksVngOsDisk.getSizeGB());
            }

            if (aksVngOsDisk.isUtilizeEphemeralStorageSet()) {
                retVal.setUtilizeEphemeralStorage(aksVngOsDisk.getUtilizeEphemeralStorage());
            }
        }

        return retVal;
    }

    private static ApiClusterTagAks toDal(ClusterTagAks aksVngTag) {
        ApiClusterTagAks retVal = null;

        if (aksVngTag != null) {

            retVal = new ApiClusterTagAks();

            if (aksVngTag.isTagKeySet()){
                retVal.setTagKey(aksVngTag.getTagKey());
            }

            if (aksVngTag.isTagValueSet()){
                retVal.setTagValue(aksVngTag.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiClusterVngLabel toDal(ClusterVngLabel aksVngLabels) {
        ApiClusterVngLabel retVal = null;

        if (aksVngLabels != null) {
            if (aksVngLabels.isKeySet() && aksVngLabels.isValueSet()) {
                retVal = new ApiClusterVngLabel(aksVngLabels.getKey(), aksVngLabels.getValue());
            }
        }

        return retVal;
    }

    private static ApiClusterVngTaints toDal(ClusterVngTaints aksVngTaints) {
        ApiClusterVngTaints retVal = null;

        if (aksVngTaints != null) {
            if (aksVngTaints.isEffectSet() && aksVngTaints.isKeySet() && aksVngTaints.isValueSet()) {
                retVal = new ApiClusterVngTaints(aksVngTaints.getEffect(), aksVngTaints.getKey(), aksVngTaints.getValue());
            }
        }

        return retVal;
    }

    private static ApiClusterVngResourceLimits toDal(ClusterVngResourceLimits aksVngResourceLimits) {
        ApiClusterVngResourceLimits retVal = null;

        if (aksVngResourceLimits != null) {
            retVal = new ApiClusterVngResourceLimits();

            if (aksVngResourceLimits.isMaxInstanceCountSet()) {
                retVal.setMaxInstanceCount(aksVngResourceLimits.getMaxInstanceCount());
            }
        }

        return retVal;
    }

    //Dal-> Bl

    public static ClusterVirtualNodeGroup toBl(ApiClusterVirtualNodeGroup apiClusterVirtualNodeGroup) {
        ClusterVirtualNodeGroup retVal = null;

        if (apiClusterVirtualNodeGroup != null) {
            ClusterVirtualNodeGroup.Builder clusterVirtualNodeGroupBuilder = ClusterVirtualNodeGroup.Builder.get();

            if (apiClusterVirtualNodeGroup.isIdSet()) {
                clusterVirtualNodeGroupBuilder.setId(apiClusterVirtualNodeGroup.getId());
            }

            if (apiClusterVirtualNodeGroup.isNameSet()) {
                clusterVirtualNodeGroupBuilder.setName(apiClusterVirtualNodeGroup.getName());
            }

            if (apiClusterVirtualNodeGroup.isOceanIdSet()) {
                clusterVirtualNodeGroupBuilder.setOceanId(apiClusterVirtualNodeGroup.getOceanId());
            }

            if (apiClusterVirtualNodeGroup.isResourceLimitsSet()) {

                if (apiClusterVirtualNodeGroup.getResourceLimits() != null) {
                    clusterVirtualNodeGroupBuilder.setResourceLimits(toBl(apiClusterVirtualNodeGroup.getResourceLimits()));
                }
            }

            if (apiClusterVirtualNodeGroup.isLabelsSet()) {

                if (apiClusterVirtualNodeGroup.getLabels() != null) {
                    List<ClusterVngLabel> k8sVngLabels = apiClusterVirtualNodeGroup.getLabels()
                            .stream()
                            .map(AksVngConverter::toBl)
                            .collect(Collectors.toList());

                    clusterVirtualNodeGroupBuilder.setLabels(k8sVngLabels);
                }
            }

            if (apiClusterVirtualNodeGroup.isTaintsSet()) {

                if (apiClusterVirtualNodeGroup.getTaints() != null) {
                    List<ClusterVngTaints> k8sVngTaints = apiClusterVirtualNodeGroup.getTaints()
                            .stream()
                            .map(AksVngConverter::toBl)
                            .collect(Collectors.toList());

                    clusterVirtualNodeGroupBuilder.setTaints(k8sVngTaints);
                }
            }

            if (apiClusterVirtualNodeGroup.isVmSizesSet()) {
                clusterVirtualNodeGroupBuilder.setVmSizes(apiClusterVirtualNodeGroup.getVmSizes());
            }

            if (apiClusterVirtualNodeGroup.isZonesSet()) {
                clusterVirtualNodeGroupBuilder.setZones(apiClusterVirtualNodeGroup.getZones());
            }

            if (apiClusterVirtualNodeGroup.isAutoScaleSet()) {
                clusterVirtualNodeGroupBuilder.setAutoScale(toBl(apiClusterVirtualNodeGroup.getAutoScale()));
            }

            if (apiClusterVirtualNodeGroup.isLaunchSpecificationSet()) {
                clusterVirtualNodeGroupBuilder.setLaunchSpecification(toBl(apiClusterVirtualNodeGroup.getLaunchSpecification()));
            }

            if (apiClusterVirtualNodeGroup.isCreatedAtSet()) {
                clusterVirtualNodeGroupBuilder.setCreatedAt(apiClusterVirtualNodeGroup.getCreatedAt());
            }

            if (apiClusterVirtualNodeGroup.isUpdatedAtSet()) {
                clusterVirtualNodeGroupBuilder.setUpdatedAt(apiClusterVirtualNodeGroup.getUpdatedAt());
            }

            retVal = clusterVirtualNodeGroupBuilder.build();
        }

        return retVal;
    }

    private static ClusterVngAutoScaleSpec toBl(ApiClusterVngAutoScaleSpec vngAutoScaleSpec) {
        ClusterVngAutoScaleSpec retval = null;

        if (vngAutoScaleSpec != null) {
            ClusterVngAutoScaleSpec.Builder autoScaleBuilder = ClusterVngAutoScaleSpec.Builder.get();

            if (vngAutoScaleSpec.isHeadroomSet() && vngAutoScaleSpec.getHeadrooms() != null) {
                List<ClusterVngHeadroomSpec> headrooms = vngAutoScaleSpec.getHeadrooms()
                        .stream()
                        .map(AksVngConverter::toBl)
                        .collect(Collectors.toList());
                autoScaleBuilder.setHeadrooms(headrooms);
            }

            if (vngAutoScaleSpec.isAutoHeadroomPercentageSet() && vngAutoScaleSpec.getAutoHeadroomPercentage() != null) {
                autoScaleBuilder.setAutoHeadroomPercentage(vngAutoScaleSpec.getAutoHeadroomPercentage());
            }

            retval = autoScaleBuilder.build();
        }
        return retval;
    }

    private static ClusterVngLaunchSpecificaion toBl(ApiClusterVngLaunchSpecification apiClusterVngLaunchSpecification) {
        ClusterVngLaunchSpecificaion retval = null;

        if (apiClusterVngLaunchSpecification != null) {
            ClusterVngLaunchSpecificaion.Builder launchSpecBuilder = ClusterVngLaunchSpecificaion.Builder.get();

            if (apiClusterVngLaunchSpecification.isTagsSet() && apiClusterVngLaunchSpecification.getTags() != null) {
                List<ClusterTagAks> tags = apiClusterVngLaunchSpecification.getTags()
                        .stream()
                        .map(AksVngConverter::toBl)
                        .collect(Collectors.toList());
                launchSpecBuilder.setTags(tags);
            }

            if (apiClusterVngLaunchSpecification.isOsDiskSet() && apiClusterVngLaunchSpecification.getOsDisk() != null) {
                launchSpecBuilder.setOsDisk(toBl(apiClusterVngLaunchSpecification.getOsDisk()));
            }

            retval = launchSpecBuilder.build();
        }
        return retval;
    }

    private static ClusterVngOsDisk toBl(ApiClusterVngOsDisk apiClusterVngOsDisk) {
        ClusterVngOsDisk retVal = null;

        if (apiClusterVngOsDisk != null) {
            ClusterVngOsDisk.Builder clusterVngOsDiskBuilder = ClusterVngOsDisk.Builder.get();

            if (apiClusterVngOsDisk.isTypeSet()) {
                clusterVngOsDiskBuilder.setType((apiClusterVngOsDisk.getType()));
            }

            if (apiClusterVngOsDisk.isSizeGBSet()) {
                clusterVngOsDiskBuilder.setSizeGB((apiClusterVngOsDisk.getSizeGB()));
            }

            if (apiClusterVngOsDisk.isUtilizeEphemeralStorageSet()) {
                clusterVngOsDiskBuilder.setUtilizeEphemeralStorage((apiClusterVngOsDisk.getUtilizeEphemeralStorage()));
            }

            retVal = clusterVngOsDiskBuilder.build();
        }

        return retVal;
    }

    private static ClusterVngHeadroomSpec toBl(ApiClusterVngHeadroomSpec apiHeadroom) {
        ClusterVngHeadroomSpec retVal = null;
        if (apiHeadroom != null) {
            ClusterVngHeadroomSpec.Builder headroomBuilder = ClusterVngHeadroomSpec.Builder.get();

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

    private static ClusterTagAks toBl(ApiClusterTagAks apiK8sVngTag) {
        ClusterTagAks retVal = null;

        if (apiK8sVngTag != null) {
            if (apiK8sVngTag.isTagKeySet() && apiK8sVngTag.isTagValueSet()) {
                ClusterTagAks.Builder k8sVngTagBuilder = ClusterTagAks.Builder.get();
                retVal = k8sVngTagBuilder.setTagKey(apiK8sVngTag.getTagKey())
                        .setTagValue(apiK8sVngTag.getTagValue())
                        .build();
            }
        }

        return retVal;
    }

    private static ClusterVngLabel toBl(ApiClusterVngLabel apiK8sVngLabels) {
        ClusterVngLabel retVal = null;

        if (apiK8sVngLabels != null) {
            if (apiK8sVngLabels.isKeySet() && apiK8sVngLabels.isValueSet()) {
                ClusterVngLabel.Builder k8sVngLabelsBuilder = ClusterVngLabel.Builder.get();
                retVal = k8sVngLabelsBuilder.setKey(apiK8sVngLabels.getKey())
                        .setValue((apiK8sVngLabels.getValue()))
                        .build();
            }
        }

        return retVal;
    }

    private static ClusterVngTaints toBl(ApiClusterVngTaints apiK8sVngTaints) {
        ClusterVngTaints retVal = null;

        if (apiK8sVngTaints != null) {
            if (apiK8sVngTaints.isEffectSet() && apiK8sVngTaints.isKeySet() && apiK8sVngTaints.isValueSet()) {
                ClusterVngTaints.Builder vngTaintsBuilder = ClusterVngTaints.Builder.get();
                retVal = vngTaintsBuilder.setEffect(apiK8sVngTaints.getEffect())
                        .setKey(apiK8sVngTaints.getKey())
                        .setValue(apiK8sVngTaints.getValue())
                        .build();
            }
        }

        return retVal;
    }

    private static ClusterVngResourceLimits toBl(ApiClusterVngResourceLimits apiK8sVngResourceLimits) {
        ClusterVngResourceLimits retVal = null;

        if (apiK8sVngResourceLimits != null) {
            ClusterVngResourceLimits.Builder vngResourceLimitsBuilder = ClusterVngResourceLimits.Builder.get();

            if (apiK8sVngResourceLimits.isMaxInstanceCountSet()) {
                vngResourceLimitsBuilder.setMaxInstanceCount((apiK8sVngResourceLimits.getMaxInstanceCount()));
            }

            retVal = vngResourceLimitsBuilder.build();
        }

        return retVal;
    }
}