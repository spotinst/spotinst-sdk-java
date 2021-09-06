package com.spotinst.sdkjava.model.converters.ocean.gke;

import com.spotinst.sdkjava.model.api.ocean.gke.*;
import com.spotinst.sdkjava.model.bl.ocean.gke.*;

import java.util.List;
import java.util.stream.Collectors;

public class OceanGKELaunchSpecConverter {

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

            if (src.isRootVolumeSizeSet()) {
                apiLaunchSpec.setRootVolumeSize(src.getRootVolumeSize());
            }

            if (src.isRootVolumeTypeSet()) {
                apiLaunchSpec.setRootVolumeType(src.getRootVolumeType());
            }

            if (src.isRestrictScaleDown()) {
                apiLaunchSpec.setRestrictScaleDown(src.getRestrictScaleDown());
            }

            if (src.isMetadataSet()) {

                List<ApiLaunchSpecMetadataSpecification> metadata =
                        src.getMetadata().stream().map(OceanGKELaunchSpecConverter::toDal)
                           .collect(Collectors.toList());
                apiLaunchSpec.setMetadata(metadata);
            }

            if (src.isInstanceTypesSet()) {
                apiLaunchSpec.setInstanceTypes(src.getInstanceTypes());
            }

            if (src.isTaintsSet()) {

                List<ApiLaunchSpecTaintsSpecification> taint =
                        src.getTaints().stream().map(OceanGKELaunchSpecConverter::toDal)
                           .collect(Collectors.toList());

                apiLaunchSpec.setTaints(taint);
            }

            if (src.isLabelsSet()) {
                List<ApiLaunchSpecLabelsSpecification> lebels =
                        src.getLabels().stream().map(OceanGKELaunchSpecConverter::toDal)
                                           .collect(Collectors.toList());
                apiLaunchSpec.setLabels(lebels);
            }

            if (src.isAutoScaleSet()) {
                apiLaunchSpec.setAutoScale(toDal(src.getAutoScale()));
            }

            if (src.isResourceLimitsSet()) {
                apiLaunchSpec.setResourceLimits(toDal(src.getResourceLimits()));
            }

            if (src.isOceanGKEShieldedInstanceConfigSet()) {
                apiLaunchSpec.setOceanGKEShieldedInstanceConfig(toDal(src.getOceanGKEShieldedInstanceConfig()));
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

        ApiLaunchSpecTaintsSpecification apiLaunchSpecTaintsSpecification = new ApiLaunchSpecTaintsSpecification();

        if(taint.isKeySet()){
            apiLaunchSpecTaintsSpecification.setKey(taint.getKey());
        }

        if(taint.isEffectSet()){
            apiLaunchSpecTaintsSpecification.setEffect(taint.getEffect());
        }

        if(taint.isValueSet()){
            apiLaunchSpecTaintsSpecification.setValue(taint.getValue());
        }
        return apiLaunchSpecTaintsSpecification;
    }

    private static ApiLaunchSpecLabelsSpecification toDal(LaunchSpecLabelsSpecification label){

        ApiLaunchSpecLabelsSpecification apiLaunchSpecLabelsSpecification = new ApiLaunchSpecLabelsSpecification();
        if(label.isKeySet()){
            apiLaunchSpecLabelsSpecification.setKey(label.getKey());
        }

        if(label.isValueSet()){
            apiLaunchSpecLabelsSpecification.setValue(label.getValue());
        }

        return apiLaunchSpecLabelsSpecification;
    }

    private static ApiLaunchSpecAutoScaleSpecification toDal(LaunchSpecAutoScaleSpecification autoScale){
        ApiLaunchSpecAutoScaleSpecification
                autoScaleListToReturn = new ApiLaunchSpecAutoScaleSpecification();

        if(autoScale.isHeadroomsSet()){

            List<ApiLaunchSpecHeadRoomsSpecification> headRooms =
                    autoScale.getHeadrooms().stream().map(OceanGKELaunchSpecConverter::toDal)
                       .collect(Collectors.toList());

            autoScaleListToReturn.setHeadrooms(headRooms);
        }

        return autoScaleListToReturn;
    }

    private static ApiLaunchSpecHeadRoomsSpecification toDal(LaunchSpecHeadroomsSpecification headroom) {

        ApiLaunchSpecHeadRoomsSpecification
                headRoomsListToReturn =  new ApiLaunchSpecHeadRoomsSpecification();

        if(headroom.isCpuPerUnitSet()){
            headRoomsListToReturn.setCpuPerUnit(headroom.getCpuPerUnit());
        }

        if(headroom.isGpuPerUnitSet()){
            headRoomsListToReturn.setGpuPerUnit(headroom.getGpuPerUnit());
        }

        if(headroom.isMemoryPerUnitSet()){
            headRoomsListToReturn.setMemoryPerUnit(headroom.getMemoryPerUnit());
        }

        if(headroom.isNumOfUnitsSet()){
            headRoomsListToReturn.setNumOfUnits(headroom.getMemoryPerUnit());
        }

        return headRoomsListToReturn;
    }

    private static ApiLaunchSpecResourceLimitSpecification toDal(LaunchSpecResourceLimitsSpecification resourceLimit){
        ApiLaunchSpecResourceLimitSpecification
                resourceLimitToReturn = new ApiLaunchSpecResourceLimitSpecification();

        if(resourceLimit.isMaxInstanceCountSet()){
            resourceLimitToReturn.setMaxInstanceCount(resourceLimit.getMaxInstanceCount());
        }

        return resourceLimitToReturn;
    }

    private static ApiLaunchSpecResourceShieldedInstanceSpecification toDal(
            LaunchSpecShieldedInstanceConfigSpecification shieldedInstance){
        ApiLaunchSpecResourceShieldedInstanceSpecification shieldedInstanceConfig =  new ApiLaunchSpecResourceShieldedInstanceSpecification();

        if(shieldedInstance.isEnableIntegrityMonitoringSet()){
            shieldedInstanceConfig.setEnableIntegrityMonitoring(shieldedInstance.getEnableIntegrityMonitoring());
        }

        if(shieldedInstance.isEnableSecureBootSet()){
            shieldedInstanceConfig.setEnableSecureBoot(shieldedInstance.getEnableSecureBoot());
        }

        return shieldedInstanceConfig;
    }

    private static ApiLaunchSpecStrategySpecification toDal(LaunchSpecStrategySpecification strategy){
        ApiLaunchSpecStrategySpecification strategyList = new ApiLaunchSpecStrategySpecification();

        if(strategy.isPreemptiblePercentageSet()){
            strategyList.setPreemptiblePercentage(strategy.getPreemptiblePercentage());
        }

        return strategyList;
    }

    private static ApiLaunchSpecStorageSpecification toDal(LaunchSpecStorageSpecification storage){
        ApiLaunchSpecStorageSpecification storageSpec = new ApiLaunchSpecStorageSpecification();

        if(storage.isLocalSsdCountSet()){
            storageSpec.setLocalSsdCount(storage.getLocalSsdCount());
        }
        return storageSpec;
    }

    private static ApiLaunchSpecMetadataSpecification toDal(LaunchSpecMetadataSpecification metadata){

        ApiLaunchSpecMetadataSpecification apiLaunchSpecMetadataSpecification = new ApiLaunchSpecMetadataSpecification();

        if(metadata.isKeySet()){
            apiLaunchSpecMetadataSpecification.setKey(metadata.getKey());
        }

        if(metadata.isValueSet()){
            apiLaunchSpecMetadataSpecification.setValue(metadata.getValue());
        }

        return apiLaunchSpecMetadataSpecification;
    }


    private static LaunchSpecTaintsSpecification toBl(ApiLaunchSpecTaintsSpecification taint) {

        LaunchSpecTaintsSpecification launchSpecTaintsSpecification = new LaunchSpecTaintsSpecification();

        if(taint.isEffectSet()){
            launchSpecTaintsSpecification.setEffect(taint.getEffect());
        }

        if(taint.isKeySet()){
            launchSpecTaintsSpecification.setKey(taint.getKey());
        }

        if(taint.isValueSet()){
            launchSpecTaintsSpecification.setValue(taint.getValue());
        }

        return launchSpecTaintsSpecification;
    }

    private static LaunchSpecLabelsSpecification toBl(ApiLaunchSpecLabelsSpecification label){

        LaunchSpecLabelsSpecification launchSpecLabelsSpecification = new LaunchSpecLabelsSpecification();

        if(label.isKeySet()){
            launchSpecLabelsSpecification.setKey(label.getKey());
        }
        if(label.isValueSet()){
            launchSpecLabelsSpecification.setValue((label.getValue()));
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

            if (apiLaunchSpecSpecification.isRootVolumeSizeSet()) {
                oceanGKECreateLaunchSpecBuilder.setRootVolumeSize(apiLaunchSpecSpecification.getRootVolumeSize());
            }

            if (apiLaunchSpecSpecification.isRootVolumeTypeSet()) {
                oceanGKECreateLaunchSpecBuilder.setRootVolumeType(apiLaunchSpecSpecification.getRootVolumeType());
            }

            if (apiLaunchSpecSpecification.isRestrictScaleDown()) {
                oceanGKECreateLaunchSpecBuilder.setRestrictScaleDown(apiLaunchSpecSpecification.getRestrictScaleDown());
            }

            if (apiLaunchSpecSpecification.isMetadataSet()) {

                List<LaunchSpecMetadataSpecification> metadata =
                        apiLaunchSpecSpecification.getMetadata().stream().map(OceanGKELaunchSpecConverter::toBl)
                           .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setMetadata(metadata);
            }

            if (apiLaunchSpecSpecification.isInstanceTypesSet()) {
                oceanGKECreateLaunchSpecBuilder.setInstanceTypes(apiLaunchSpecSpecification.getInstanceTypes());
            }

            if (apiLaunchSpecSpecification.isTaintsSet()) {

                List<LaunchSpecTaintsSpecification> taint =
                        apiLaunchSpecSpecification.getTaints().stream().map(OceanGKELaunchSpecConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setTaints(taint);
            }

            if (apiLaunchSpecSpecification.isLabelsSet()) {

                List<LaunchSpecLabelsSpecification> label =
                        apiLaunchSpecSpecification.getLabels().stream().map(OceanGKELaunchSpecConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setLabels(label);
            }

            if (apiLaunchSpecSpecification.isAutoScaleSet()) {

                oceanGKECreateLaunchSpecBuilder.setAutoScales(toBl(apiLaunchSpecSpecification.getAutoScale()));
            }

            if (apiLaunchSpecSpecification.isResourceLimitsSet()) {
                oceanGKECreateLaunchSpecBuilder.setResourceLimits(toBl(
                        apiLaunchSpecSpecification.getResourceLimits()));
            }

            if (apiLaunchSpecSpecification.isOceanGKEShieldedInstanceConfigSet()) {
                oceanGKECreateLaunchSpecBuilder.setOceanGKEShieldedInstanceConfig(toBl(
                        apiLaunchSpecSpecification.getOceanGKEShieldedInstanceConfig()));
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

    private static LaunchSpecAutoScaleSpecification toBl(ApiLaunchSpecAutoScaleSpecification autoScale){

        LaunchSpecAutoScaleSpecification autoScaleListToReturn = new LaunchSpecAutoScaleSpecification();
        if(autoScale.isHeadroomsSet()){

            List<LaunchSpecHeadroomsSpecification> headRooms =
                    autoScale.getHeadrooms().stream().map(OceanGKELaunchSpecConverter::toBl)
                                              .collect(Collectors.toList());

            autoScaleListToReturn.setHeadrooms(headRooms);
        }

        return autoScaleListToReturn;
    }

    private static LaunchSpecHeadroomsSpecification toBl(ApiLaunchSpecHeadRoomsSpecification headRooms) {

        LaunchSpecHeadroomsSpecification
                headRoomsListToReturn = new LaunchSpecHeadroomsSpecification();

        if(headRooms.isCpuPerUnitSet()){
            headRoomsListToReturn.setCpuPerUnit(headRooms.getCpuPerUnit());
        }

        if(headRooms.isGpuPerUnitSet()){
            headRoomsListToReturn.setGpuPerUnit(headRooms.getGpuPerUnit());
        }

        if(headRooms.isMemoryPerUnitSet()){
            headRoomsListToReturn.setMemoryPerUnit(headRooms.getMemoryPerUnit());
        }

        if(headRooms.isNumOfUnitsSet()){
            headRoomsListToReturn.setNumOfUnits(headRooms.getNumOfUnits());
        }

        return headRoomsListToReturn;
    }

    private static LaunchSpecResourceLimitsSpecification toBl(
            ApiLaunchSpecResourceLimitSpecification resourceLimit){
        LaunchSpecResourceLimitsSpecification
                restourceLimitToReturn = LaunchSpecResourceLimitsSpecification.Builder.get().build();
        if(resourceLimit.isMaxInstanceCountSet()){
            restourceLimitToReturn.setMaxInstanceCount(resourceLimit.getMaxInstanceCount());
        }

        return restourceLimitToReturn;
    }

    private static LaunchSpecShieldedInstanceConfigSpecification toBl(
            ApiLaunchSpecResourceShieldedInstanceSpecification shieldedInstance){
        LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig =
                LaunchSpecShieldedInstanceConfigSpecification.Builder.get().build();
        if(shieldedInstance.isEnableIntegrityMonitoringSet()){
            shieldedInstanceConfig.setEnableIntegrityMonitoring(shieldedInstance.getEnableIntegrityMonitoring());
        }

        if(shieldedInstance.isEnableSecureBootSet()){
            shieldedInstanceConfig.setEnableSecureBoot(shieldedInstance.getEnableSecureBoot());
        }

        return shieldedInstanceConfig;
    }

    private static LaunchSpecStrategySpecification toBl(ApiLaunchSpecStrategySpecification strategy){
        LaunchSpecStrategySpecification strategyList = LaunchSpecStrategySpecification.Builder.get().build();
        if(strategy.isPreemptiblePercentageSet()){
            strategyList.setPreemptiblePercentage(strategy.getPreemptiblePercentage());
        }

        return strategyList;
    }

    private static LaunchSpecStorageSpecification toBl(ApiLaunchSpecStorageSpecification storage){
        LaunchSpecStorageSpecification storageSpec = null;

        storageSpec = new LaunchSpecStorageSpecification();

        if(storage.isLocalSsdCountSet()){
            storageSpec.setLocalSsdCount(storage.getLocalSsdCount());
        }

        return storageSpec;
    }

    private static LaunchSpecMetadataSpecification toBl(ApiLaunchSpecMetadataSpecification metadata){

        LaunchSpecMetadataSpecification launchSpecMetadataSpecification = new LaunchSpecMetadataSpecification();

        if(metadata.isKeySet()){
            launchSpecMetadataSpecification.setKey(metadata.getKey());
        }

        if(metadata.isValueSet()){
            launchSpecMetadataSpecification.setValue(metadata.getValue());
        }

        return launchSpecMetadataSpecification;
    }
}
