package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKECreateLaunchSpecRes;

public class OceanGKELaunchSpecConverter {

    public static ApiOceanGKELaunchSpec toDal(OceanGKECreateLaunchSpecRes src) {
        ApiOceanGKELaunchSpec apiGroup = null;

        if (src != null) {
            apiGroup = new ApiOceanGKELaunchSpec();

            if (src.isNameSet()) {
                apiGroup.setName(src.getName());
            }
            if (src.isOceanIdSet()) {
                apiGroup.setOceanId(src.getOceanId());
            }

            if (src.isSourceImageSet()) {
                apiGroup.setSourceImage(src.getSourceImage());
            }

            if (src.isServiceAccountSet()) {
                apiGroup.setServiceAccount(src.getServiceAccount());
            }

            if (src.isRootVolumeSizeSet()) {
                apiGroup.setRootVolumeSize(src.getRootVolumeSize());
            }

            if (src.isRootVolumeTypeSet()) {
                apiGroup.setRootVolumeType(src.getRootVolumeType());
            }

            if (src.isRestrictScaleDown()) {
                apiGroup.setRestrictScaleDown(src.getRestrictScaleDown());
            }
            if (src.isMetadataSet()) {
                apiGroup.setMetadata(src.getMetadata());
            }
            if (src.isInstanceTypesSet()) {
                apiGroup.setInstanceTypes(src.getInstanceTypes());
            }

            if (src.isTaintsSet()) {
                apiGroup.setTaints(src.getTaints());
            }

            if (src.isLabelsSet()) {
                apiGroup.setLabels(src.getLabels());
            }

            if (src.isAutoScaleSet()) {
                apiGroup.setAutoScale(src.getAutoScale());
            }

            if (src.isResourceLimitsSet()) {
                apiGroup.setResourceLimits(src.getResourceLimits());
            }

            if (src.isOceanGKEShieldedInstanceConfigSet()) {
                apiGroup.setOceanGKEShieldedInstanceConfig(src.getOceanGKEShieldedInstanceConfig());
            }
            if (src.isStrategySet()) {
                apiGroup.setStrategy(src.getStrategy());
            }
            if (src.isStorageSet()) {
                apiGroup.setStorage(src.getStorage());
            }

        }

        return apiGroup;
    }


    public static OceanGKECreateLaunchSpecRes toBl(ApiOceanGKELaunchSpec apiOceanGKELaunchSpec) {
        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes = null;

        if (apiOceanGKELaunchSpec != null) {
            OceanGKECreateLaunchSpecRes.Builder oceanGKECreateLaunchSpecBuilder = OceanGKECreateLaunchSpecRes.Builder.get();

            if (apiOceanGKELaunchSpec.isNameSet()) {
                oceanGKECreateLaunchSpecBuilder.setName(apiOceanGKELaunchSpec.getName());
            }
            if (apiOceanGKELaunchSpec.isOceanIdSet()) {
                oceanGKECreateLaunchSpecBuilder.setOceanId(apiOceanGKELaunchSpec.getOceanId());
            }

            if (apiOceanGKELaunchSpec.isSourceImageSet()) {
                oceanGKECreateLaunchSpecBuilder.setSourceImage(apiOceanGKELaunchSpec.getSourceImage());
            }

            if (apiOceanGKELaunchSpec.isServiceAccountSet()) {
                oceanGKECreateLaunchSpecBuilder.setServiceAccount(apiOceanGKELaunchSpec.getServiceAccount());
            }

            if (apiOceanGKELaunchSpec.isRootVolumeSizeSet()) {
                oceanGKECreateLaunchSpecBuilder.setRootVolumeSize(apiOceanGKELaunchSpec.getRootVolumeSize());
            }

            if (apiOceanGKELaunchSpec.isRootVolumeTypeSet()) {
                oceanGKECreateLaunchSpecBuilder.setRootVolumeType(apiOceanGKELaunchSpec.getRootVolumeType());
            }

            if (apiOceanGKELaunchSpec.isRestrictScaleDown()) {
                oceanGKECreateLaunchSpecBuilder.setRestrictScaleDown(apiOceanGKELaunchSpec.getRestrictScaleDown());
            }
            if (apiOceanGKELaunchSpec.isMetadataSet()) {
                oceanGKECreateLaunchSpecBuilder.setMetadata(apiOceanGKELaunchSpec.getMetadata());
            }
            if (apiOceanGKELaunchSpec.isInstanceTypesSet()) {
                oceanGKECreateLaunchSpecBuilder.setInstanceTypes(apiOceanGKELaunchSpec.getInstanceTypes());
            }

            if (apiOceanGKELaunchSpec.isTaintsSet()) {
                oceanGKECreateLaunchSpecBuilder.setTaints(apiOceanGKELaunchSpec.getTaints());
            }

            if (apiOceanGKELaunchSpec.isLabelsSet()) {
                oceanGKECreateLaunchSpecBuilder.setLabels(apiOceanGKELaunchSpec.getLabels());
            }

            if (apiOceanGKELaunchSpec.isAutoScaleSet()) {
                oceanGKECreateLaunchSpecBuilder.setAutoScales(apiOceanGKELaunchSpec.getAutoScale());
            }

            if (apiOceanGKELaunchSpec.isResourceLimitsSet()) {
                oceanGKECreateLaunchSpecBuilder.setResourceLimits(apiOceanGKELaunchSpec.getResourceLimits());
            }

            if (apiOceanGKELaunchSpec.isOceanGKEShieldedInstanceConfigSet()) {
                oceanGKECreateLaunchSpecBuilder.setOceanGKEShieldedInstanceConfig(apiOceanGKELaunchSpec.getOceanGKEShieldedInstanceConfig());
            }
            if (apiOceanGKELaunchSpec.isStrategySet()) {
                oceanGKECreateLaunchSpecBuilder.setStrategy(apiOceanGKELaunchSpec.getStrategy());
            }
            if (apiOceanGKELaunchSpec.isStorageSet()) {
                oceanGKECreateLaunchSpecBuilder.setStorage(apiOceanGKELaunchSpec.getStorage());
            }
            oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecBuilder.build();
        }

        return oceanGKECreateLaunchSpecRes;
    }
}
