package com.spotinst.sdkjava.model.converters.ocean.gke;

import com.spotinst.sdkjava.model.api.ocean.gke.*;
import com.spotinst.sdkjava.model.bl.ocean.gke.*;

import java.util.List;
import java.util.stream.Collectors;

public class OceanGkeConverter {

    //region BL -> DAL

    public static ApiLaunchSpecSpecification toDal(LaunchSpecSpecification src) {
        ApiLaunchSpecSpecification apiLaunchSpec = null;

        if (src != null) {
            apiLaunchSpec = new ApiLaunchSpecSpecification();

            if (src.isIdSet()) {
                apiLaunchSpec.setId(src.getId());
            }

            if (src.isNameSet()) {
                apiLaunchSpec.setName(src.getName());
            }

            if (src.isOceanIdSet()) {
                apiLaunchSpec.setOceanId(src.getOceanId());
            }

            if (src.isSourceImageSet()) {
                apiLaunchSpec.setSourceImage(src.getSourceImage());
            }

            if (src.isServiceAccountSet()) {
                apiLaunchSpec.setServiceAccount(src.getServiceAccount());
            }

            if (src.isRootVolumeSizeInGbSet()) {
                apiLaunchSpec.setRootVolumeSizeInGb(src.getRootVolumeSizeInGb());
            }

            if (src.isRootVolumeTypeSet()) {
                apiLaunchSpec.setRootVolumeType(src.getRootVolumeType());
            }

            if (src.isRestrictScaleDownSet()) {
                apiLaunchSpec.setRestrictScaleDown(src.getRestrictScaleDown());
            }

            if (src.isMetadataSet()) {

                List<ApiLaunchSpecMetadataSpecification> metadata =
                        src.getMetadata().stream().map(OceanGkeConverter::toDal)
                           .collect(Collectors.toList());
                apiLaunchSpec.setMetadata(metadata);
            }

            if (src.isInstanceTypesSet()) {
                apiLaunchSpec.setInstanceTypes(src.getInstanceTypes());
            }

            if (src.isTaintsSet()) {

                List<ApiLaunchSpecTaintsSpecification> taint =
                        src.getTaints().stream().map(OceanGkeConverter::toDal)
                           .collect(Collectors.toList());

                apiLaunchSpec.setTaints(taint);
            }

            if (src.isLabelsSet()) {
                List<ApiLaunchSpecLabelsSpecification> lebels =
                        src.getLabels().stream().map(OceanGkeConverter::toDal)
                                           .collect(Collectors.toList());
                apiLaunchSpec.setLabels(lebels);
            }

            if (src.isAutoScaleSet()) {
                apiLaunchSpec.setAutoScale(toDal(src.getAutoScale()));
            }

            if (src.isResourceLimitsSet()) {
                apiLaunchSpec.setResourceLimits(toDal(src.getResourceLimits()));
            }

            if (src.isShieldedInstanceConfigSet()) {
                apiLaunchSpec.setShieldedInstanceConfig(toDal(src.getShieldedInstanceConfig()));
            }
            if (src.isStrategySet()) {
                apiLaunchSpec.setStrategy(toDal(src.getStrategy()));
            }
            if (src.isStorageSet()) {
                apiLaunchSpec.setStorage(toDal(src.getStorage()));
            }

        }

        return apiLaunchSpec;
    }

    private static ApiLaunchSpecTaintsSpecification toDal(LaunchSpecTaintsSpecification taint) {

        ApiLaunchSpecTaintsSpecification apiLaunchSpecTaintsSpecification = null;

        if(taint != null){
            apiLaunchSpecTaintsSpecification = new ApiLaunchSpecTaintsSpecification();

                if (taint.isKeySet()) {
                    apiLaunchSpecTaintsSpecification.setKey(taint.getKey());
                }

                if (taint.isEffectSet()) {
                    apiLaunchSpecTaintsSpecification.setEffect(taint.getEffect());
                }

                if (taint.isValueSet()) {
                    apiLaunchSpecTaintsSpecification.setValue(taint.getValue());
                }
            }
                return apiLaunchSpecTaintsSpecification;
    }

    private static ApiLaunchSpecLabelsSpecification toDal(LaunchSpecLabelsSpecification label) {

        ApiLaunchSpecLabelsSpecification apiLaunchSpecLabelsSpecification = null;

        if(label != null) {
            apiLaunchSpecLabelsSpecification = new ApiLaunchSpecLabelsSpecification();

        if (label.isKeySet()) {
            apiLaunchSpecLabelsSpecification.setKey(label.getKey());
        }

        if (label.isValueSet()) {
            apiLaunchSpecLabelsSpecification.setValue(label.getValue());
        }
    }
        return apiLaunchSpecLabelsSpecification;
    }

    private static ApiLaunchSpecAutoScaleSpecification toDal(LaunchSpecAutoScaleSpecification autoScale){
        ApiLaunchSpecAutoScaleSpecification autoScaleListToReturn = null;

        if(autoScale != null) {
            autoScaleListToReturn = new ApiLaunchSpecAutoScaleSpecification();

            if (autoScale.isHeadroomsSet()) {

                List<ApiLaunchSpecHeadRoomsSpecification> headrooms =
                        autoScale.getHeadrooms().stream().map(OceanGkeConverter::toDal).collect(Collectors.toList());

                autoScaleListToReturn.setHeadrooms(headrooms);
            }
        }
        return autoScaleListToReturn;
    }

    private static ApiLaunchSpecHeadRoomsSpecification toDal(LaunchSpecHeadroomsSpecification headroom) {

        ApiLaunchSpecHeadRoomsSpecification headRoomsListToReturn = null;

        if(headroom != null) {
            headRoomsListToReturn =  new ApiLaunchSpecHeadRoomsSpecification();

            if (headroom.isGpuPerUnitSet()) {
                headRoomsListToReturn.setGpuPerUnit(headroom.getGpuPerUnit());
            }

            if (headroom.isMemoryPerUnitSet()) {
                headRoomsListToReturn.setMemoryPerUnit(headroom.getMemoryPerUnit());
            }

            if(headroom.isCpuPerUnitSet()){
                headRoomsListToReturn.setCpuPerUnit(headroom.getCpuPerUnit());
            }

            if (headroom.isNumOfUnitsSet()) {
                headRoomsListToReturn.setNumOfUnits(headroom.getMemoryPerUnit());
            }
        }
        return headRoomsListToReturn;
    }

    private static ApiLaunchSpecResourceLimitSpecification toDal(LaunchSpecResourceLimitsSpecification resourceLimit){
        ApiLaunchSpecResourceLimitSpecification resourceLimitToReturn = null;

        if(resourceLimit != null) {
            resourceLimitToReturn = new ApiLaunchSpecResourceLimitSpecification();

            if (resourceLimit.isMaxInstanceCountSet()) {
                resourceLimitToReturn.setMaxInstanceCount(resourceLimit.getMaxInstanceCount());
            }
        }
        return resourceLimitToReturn;
    }

    private static ApiLaunchSpecResourceShieldedInstanceSpecification toDal(LaunchSpecShieldedInstanceConfigSpecification shieldedInstance){
        ApiLaunchSpecResourceShieldedInstanceSpecification shieldedInstanceConfig =  null;

        if(shieldedInstance != null) {
            shieldedInstanceConfig =  new ApiLaunchSpecResourceShieldedInstanceSpecification();
            if (shieldedInstance.isEnableIntegrityMonitoringSet()) {
                shieldedInstanceConfig.setEnableIntegrityMonitoring(shieldedInstance.getEnableIntegrityMonitoring());
            }

            if (shieldedInstance.isEnableSecureBootSet()) {
                shieldedInstanceConfig.setEnableSecureBoot(shieldedInstance.getEnableSecureBoot());
            }
        }
        return shieldedInstanceConfig;
    }

    private static ApiLaunchSpecStrategySpecification toDal(LaunchSpecStrategySpecification strategy){
        ApiLaunchSpecStrategySpecification strategyList = null;

        if(strategy !=null) {
            strategyList = new ApiLaunchSpecStrategySpecification();

            if (strategy.isPreemptiblePercentageSet()) {
                strategyList.setPreemptiblePercentage(strategy.getPreemptiblePercentage());
            }
        }
        return strategyList;
    }

    private static ApiLaunchSpecStorageSpecification toDal(LaunchSpecStorageSpecification storage){
        ApiLaunchSpecStorageSpecification storageSpec = null;

        if(storage != null) {
            storageSpec = new ApiLaunchSpecStorageSpecification();

            if (storage.isLocalSsdCountSet()) {
                storageSpec.setLocalSsdCount(storage.getLocalSsdCount());
            }
        }
        return storageSpec;
    }

    private static ApiLaunchSpecMetadataSpecification toDal(LaunchSpecMetadataSpecification metadata){

        ApiLaunchSpecMetadataSpecification apiLaunchSpecMetadataSpecification = null;

        if(metadata != null) {
            apiLaunchSpecMetadataSpecification = new ApiLaunchSpecMetadataSpecification();

            if (metadata.isKeySet()) {
                apiLaunchSpecMetadataSpecification.setKey(metadata.getKey());
            }

            if (metadata.isValueSet()) {
                apiLaunchSpecMetadataSpecification.setValue(metadata.getValue());
            }
        }
        return apiLaunchSpecMetadataSpecification;
    }

    //region DAL -> BL
    private static LaunchSpecTaintsSpecification toBl(ApiLaunchSpecTaintsSpecification apiTaint) {

        LaunchSpecTaintsSpecification launchSpecTaintsSpecification = null;

        if(apiTaint != null) {
           LaunchSpecTaintsSpecification.Builder launchSpecTaintsSpecificationBuilder = LaunchSpecTaintsSpecification.Builder.get();

            if (apiTaint.isEffectSet()) {
                launchSpecTaintsSpecificationBuilder.setEffect(apiTaint.getEffect());
            }

            if (apiTaint.isKeySet()) {
                launchSpecTaintsSpecificationBuilder.setKey(apiTaint.getKey());
            }

            if (apiTaint.isValueSet()) {
                launchSpecTaintsSpecificationBuilder.setValue(apiTaint.getValue());
            }
            launchSpecTaintsSpecification = launchSpecTaintsSpecificationBuilder.build();
        }
        return launchSpecTaintsSpecification;
    }

    private static LaunchSpecLabelsSpecification toBl(ApiLaunchSpecLabelsSpecification apiLabel){

        LaunchSpecLabelsSpecification launchSpecLabelsSpecification = null;

        if (apiLabel != null) {
            LaunchSpecLabelsSpecification.Builder launchSpecLabelBuilder = LaunchSpecLabelsSpecification.Builder.get();

            if (apiLabel.isKeySet()) {
                launchSpecLabelBuilder.setKey(apiLabel.getKey());
            }
            if (apiLabel.isValueSet()) {
                launchSpecLabelBuilder.setValue((apiLabel.getValue()));
            }
            launchSpecLabelsSpecification = launchSpecLabelBuilder.build();
        }
        return launchSpecLabelsSpecification;
    }

    public static LaunchSpecSpecification toBl(ApiLaunchSpecSpecification apiLaunchSpecSpecification) {
        LaunchSpecSpecification launchSpec = null;

        if (apiLaunchSpecSpecification != null) {
            LaunchSpecSpecification.Builder oceanGKECreateLaunchSpecBuilder = LaunchSpecSpecification.Builder.get();

            if (apiLaunchSpecSpecification.isIdSet()) {
                oceanGKECreateLaunchSpecBuilder.setId(apiLaunchSpecSpecification.getId());
            }

            if (apiLaunchSpecSpecification.isNameSet()) {
                oceanGKECreateLaunchSpecBuilder.setName(apiLaunchSpecSpecification.getName());
            }

            if (apiLaunchSpecSpecification.isOceanIdSet()) {
                oceanGKECreateLaunchSpecBuilder.setOceanId(apiLaunchSpecSpecification.getOceanId());
            }

            if (apiLaunchSpecSpecification.isSourceImageSet()) {
                oceanGKECreateLaunchSpecBuilder.setSourceImage(apiLaunchSpecSpecification.getSourceImage());
            }

            if (apiLaunchSpecSpecification.isServiceAccountSet()) {
                oceanGKECreateLaunchSpecBuilder.setServiceAccount(apiLaunchSpecSpecification.getServiceAccount());
            }

            if (apiLaunchSpecSpecification.isRootVolumeSizeInGbSet()) {
                oceanGKECreateLaunchSpecBuilder.setRootVolumeSizeInGb(apiLaunchSpecSpecification.getRootVolumeSizeInGb());
            }

            if (apiLaunchSpecSpecification.isRootVolumeTypeSet()) {
                oceanGKECreateLaunchSpecBuilder.setRootVolumeType(apiLaunchSpecSpecification.getRootVolumeType());
            }

            if (apiLaunchSpecSpecification.isRestrictScaleDownSet()) {
                oceanGKECreateLaunchSpecBuilder.setRestrictScaleDown(apiLaunchSpecSpecification.getRestrictScaleDown());
            }

            if (apiLaunchSpecSpecification.isMetadataSet()) {

                List<LaunchSpecMetadataSpecification> metadata =
                        apiLaunchSpecSpecification.getMetadata().stream().map(OceanGkeConverter::toBl)
                           .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setMetadata(metadata);
            }

            if (apiLaunchSpecSpecification.isInstanceTypesSet()) {
                oceanGKECreateLaunchSpecBuilder.setInstanceTypes(apiLaunchSpecSpecification.getInstanceTypes());
            }

            if (apiLaunchSpecSpecification.isTaintsSet()) {

                List<LaunchSpecTaintsSpecification> taint =
                        apiLaunchSpecSpecification.getTaints().stream().map(OceanGkeConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setTaints(taint);
            }

            if (apiLaunchSpecSpecification.isLabelsSet()) {

                List<LaunchSpecLabelsSpecification> label =
                        apiLaunchSpecSpecification.getLabels().stream().map(OceanGkeConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setLabels(label);
            }

            if (apiLaunchSpecSpecification.isAutoScaleSet()) {

                oceanGKECreateLaunchSpecBuilder.setAutoScales(toBl(apiLaunchSpecSpecification.getAutoScale()));
            }

            if (apiLaunchSpecSpecification.isResourceLimitsSet()) {
                oceanGKECreateLaunchSpecBuilder.setResourceLimits(toBl(apiLaunchSpecSpecification.getResourceLimits()));
            }

            if (apiLaunchSpecSpecification.isShieldedInstanceConfigSet()) {
                oceanGKECreateLaunchSpecBuilder.setShieldedInstanceConfig(toBl(
                        apiLaunchSpecSpecification.getShieldedInstanceConfig()));
            }
            if (apiLaunchSpecSpecification.isStrategySet()) {
                oceanGKECreateLaunchSpecBuilder.setStrategy(toBl(apiLaunchSpecSpecification.getStrategy()));
            }
            if (apiLaunchSpecSpecification.isStorageSet()) {
                oceanGKECreateLaunchSpecBuilder.setStorage(toBl(apiLaunchSpecSpecification.getStorage()));
            }
            launchSpec = oceanGKECreateLaunchSpecBuilder.build();
        }

        return launchSpec;
    }

    private static LaunchSpecAutoScaleSpecification toBl(ApiLaunchSpecAutoScaleSpecification apiAutoScale){

        LaunchSpecAutoScaleSpecification autoScale = null;

        if(apiAutoScale != null) {
            LaunchSpecAutoScaleSpecification.Builder autoScaleBuilder = LaunchSpecAutoScaleSpecification.Builder.get();
            if (apiAutoScale.isHeadroomsSet()) {

                List<LaunchSpecHeadroomsSpecification> headRooms =
                        apiAutoScale.getHeadrooms().stream().map(OceanGkeConverter::toBl).collect(Collectors.toList());

                autoScaleBuilder.setHeadrooms(headRooms);
            }
            autoScale = autoScaleBuilder.build();
        }
        return autoScale;
    }

    private static LaunchSpecHeadroomsSpecification toBl(ApiLaunchSpecHeadRoomsSpecification apiHeadRooms) {

        LaunchSpecHeadroomsSpecification headRoomsListToReturn = null;

        if(apiHeadRooms != null){

            LaunchSpecHeadroomsSpecification.Builder headRoomsBuilder = LaunchSpecHeadroomsSpecification.Builder.get();

            if (apiHeadRooms.isGpuPerUnitSet()) {
                headRoomsBuilder.setGpuPerUnit(apiHeadRooms.getGpuPerUnit());
            }

            if(apiHeadRooms.isCpuPerUnitSet()){
                headRoomsBuilder.setCpuPerUnit(apiHeadRooms.getCpuPerUnit());
            }

            if (apiHeadRooms.isMemoryPerUnitSet()) {
                headRoomsBuilder.setMemoryPerUnit(apiHeadRooms.getMemoryPerUnit());
            }

            if (apiHeadRooms.isNumOfUnitsSet()) {
                headRoomsBuilder.setNumOfUnits(apiHeadRooms.getNumOfUnits());
            }
            headRoomsListToReturn = headRoomsBuilder.build();
        }
        return headRoomsListToReturn;
    }

    private static LaunchSpecResourceLimitsSpecification toBl( ApiLaunchSpecResourceLimitSpecification apiResourceLimit) {
        LaunchSpecResourceLimitsSpecification restourceLimitToReturn = null;

        if(apiResourceLimit != null){
            LaunchSpecResourceLimitsSpecification.Builder resourceLimitBuilder = LaunchSpecResourceLimitsSpecification.Builder.get();

        if (apiResourceLimit.isMaxInstanceCountSet()) {
            resourceLimitBuilder.setMaxInstanceCount(apiResourceLimit.getMaxInstanceCount());
        }
            restourceLimitToReturn = resourceLimitBuilder.build();
    }
        return restourceLimitToReturn;
    }

    private static LaunchSpecShieldedInstanceConfigSpecification toBl(ApiLaunchSpecResourceShieldedInstanceSpecification apiShieldedInstance){
        LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig = null;

        if(apiShieldedInstance != null) {
            LaunchSpecShieldedInstanceConfigSpecification.Builder shieldedInstanceConfigBuilder = LaunchSpecShieldedInstanceConfigSpecification.Builder.get();

            if (apiShieldedInstance.isEnableIntegrityMonitoringSet()) {
                shieldedInstanceConfigBuilder.setEnableIntegrityMonitoring(apiShieldedInstance.getEnableIntegrityMonitoring());
            }

            if (apiShieldedInstance.isEnableSecureBootSet()) {
                shieldedInstanceConfigBuilder.setEnableSecureBoot(apiShieldedInstance.getEnableSecureBoot());
            }
            shieldedInstanceConfig = shieldedInstanceConfigBuilder.build();
        }
        return shieldedInstanceConfig;
    }

    private static LaunchSpecStrategySpecification toBl(ApiLaunchSpecStrategySpecification apiStrategy){
        LaunchSpecStrategySpecification strategyList = null;

        if(apiStrategy != null) {
            LaunchSpecStrategySpecification.Builder strategyBuilder = LaunchSpecStrategySpecification.Builder.get();

            if (apiStrategy.isPreemptiblePercentageSet()) {
                strategyBuilder.setPreemptiblePercentage(apiStrategy.getPreemptiblePercentage());
            }
            strategyList = strategyBuilder.build();
        }
        return strategyList;
    }

    private static LaunchSpecStorageSpecification toBl(ApiLaunchSpecStorageSpecification apiStorage){
        LaunchSpecStorageSpecification storageSpec = null;

        if(apiStorage != null) {
            LaunchSpecStorageSpecification.Builder storageBuilder = LaunchSpecStorageSpecification.Builder.get();

            if (apiStorage.isLocalSsdCountSet()) {
                storageBuilder.setLocalSsdCount(apiStorage.getLocalSsdCount());
            }
            storageSpec = storageBuilder.build();
        }
        return storageSpec;
    }

    private static LaunchSpecMetadataSpecification toBl(ApiLaunchSpecMetadataSpecification apiMetadata) {

        LaunchSpecMetadataSpecification launchSpecMetadataSpecification = null;

        if(apiMetadata != null){
            LaunchSpecMetadataSpecification.Builder metadataBuilder = LaunchSpecMetadataSpecification.Builder.get();
        if (apiMetadata.isKeySet()) {
            metadataBuilder.setKey(apiMetadata.getKey());
        }

        if (apiMetadata.isValueSet()) {
            metadataBuilder.setValue(apiMetadata.getValue());
        }
            launchSpecMetadataSpecification  = metadataBuilder.build();
    }
        return launchSpecMetadataSpecification;
    }
}
