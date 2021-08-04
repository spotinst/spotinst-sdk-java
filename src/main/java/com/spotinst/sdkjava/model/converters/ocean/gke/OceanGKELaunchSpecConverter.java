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

                List<ApiLaunchSpecTaintsSpecification> taints =
                        src.getTaints().stream().map(OceanGKELaunchSpecConverter::toDal)
                           .collect(Collectors.toList());

                apiLaunchSpec.setTaints(taints);
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

    private static ApiLaunchSpecTaintsSpecification toDal(LaunchSpecTaintsSpecification taints) {

        ApiLaunchSpecTaintsSpecification apiLaunchSpecTaintsSpecification = new ApiLaunchSpecTaintsSpecification();

        if(taints.isKeySet()){
            apiLaunchSpecTaintsSpecification.setKey(taints.getKey());
        }
        if(taints.isEffectSet()){
            apiLaunchSpecTaintsSpecification.setEffect(taints.getEffect());
        }
        if(taints.isValueSet()){
            apiLaunchSpecTaintsSpecification.setValue(taints.getValue());
        }
        return apiLaunchSpecTaintsSpecification;
    }

    private static ApiLaunchSpecLabelsSpecification toDal(LaunchSpecLabelsSpecification labels){

        ApiLaunchSpecLabelsSpecification apiLaunchSpecLabelsSpecification = new ApiLaunchSpecLabelsSpecification();
        if(labels.isKeySet()){
            apiLaunchSpecLabelsSpecification.setKey(labels.getKey());
        }
        if(labels.isValueSet()){
            apiLaunchSpecLabelsSpecification.setValue(labels.getValue());
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

    private static ApiLaunchSpecHeadRoomsSpecification toDal(LaunchSpecHeadroomsSpecification headRooms) {

        ApiLaunchSpecHeadRoomsSpecification
                headRoomsListToReturn =  new ApiLaunchSpecHeadRoomsSpecification();

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
            headRoomsListToReturn.setNumOfUnits(headRooms.getMemoryPerUnit());
        }

        return headRoomsListToReturn;
    }

    private static ApiLaunchSpecResourceLimitSpecification toDal(LaunchSpecResourceLimitsSpecification restourceLimit){
        ApiLaunchSpecResourceLimitSpecification
                restourceLimitToReturn = new ApiLaunchSpecResourceLimitSpecification();

        if(restourceLimit.isMaxInstanceCountSet()){
            restourceLimitToReturn.setMaxInstanceCount(restourceLimit.getMaxInstanceCount());
        }

        return restourceLimitToReturn;
    }

    private static ApiLaunchSpecResourceShieldedInstanceSpecification toDal(
            LaunchSpecShieldedInstanceConfigSpecification shieldedInstance){
        ApiLaunchSpecResourceShieldedInstanceSpecification shieldedInstanceList =  new ApiLaunchSpecResourceShieldedInstanceSpecification();

        if(shieldedInstance.isEnableIntegrityMonitoringSet()){
            shieldedInstanceList.setEnableIntegrityMonitoring(shieldedInstance.getEnableIntegrityMonitoring());
        }
        if(shieldedInstance.isEnableSecureBootSet()){
            shieldedInstanceList.setEnableSecureBoot(shieldedInstance.getEnableSecureBoot());
        }

        return shieldedInstanceList;
    }

    private static ApiLaunchSpecStrategySpecification toDal(LaunchSpecStrategySpecification startegy){
        ApiLaunchSpecStrategySpecification startegyList = new ApiLaunchSpecStrategySpecification();

        if(startegy.isPreemptiblePercentageSet()){
            startegyList.setPreemptiblePercentage(startegy.getPreemptiblePercentage());
        }
        return startegyList;
    }

    private static ApiLaunchSpecStorageSpecification toDal(LaunchSpecStorageSpecification storage){
        ApiLaunchSpecStorageSpecification storageList = new ApiLaunchSpecStorageSpecification();

        if(storage.isLocalSsdCountSet()){
            storageList.setLocalSsdCount(storage.getLocalSsdCount());
        }
        return storageList;
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


    private static LaunchSpecTaintsSpecification toBl(ApiLaunchSpecTaintsSpecification taints) {

        LaunchSpecTaintsSpecification launchSpecTaintsSpecification = new LaunchSpecTaintsSpecification();

        if(taints.isEffectSet()){
            launchSpecTaintsSpecification.setEffect(taints.getEffect());
        }
        if(taints.isKeySet()){
            launchSpecTaintsSpecification.setKey(taints.getKey());
        }
        if(taints.isValueSet()){
            launchSpecTaintsSpecification.setValue(taints.getValue());
        }
        return launchSpecTaintsSpecification;
    }

    private static LaunchSpecLabelsSpecification toBl(ApiLaunchSpecLabelsSpecification labels){

        LaunchSpecLabelsSpecification launchSpecLabelsSpecification = new LaunchSpecLabelsSpecification();

        if(labels.isKeySet()){
            launchSpecLabelsSpecification.setKey(labels.getKey());
        }
        if(labels.isValueSet()){
            launchSpecLabelsSpecification.setValue((labels.getValue()));
        }
        return launchSpecLabelsSpecification;
    }

    public static LaunchSpecSpecification toBl(ApiLaunchSpecSpecification apiLaunchSpecSpecification) {
        LaunchSpecSpecification oceanGKECreateLaunchSpecRes = null;

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

                List<LaunchSpecTaintsSpecification> taints =
                        apiLaunchSpecSpecification.getTaints().stream().map(OceanGKELaunchSpecConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setTaints(taints);
            }

            if (apiLaunchSpecSpecification.isLabelsSet()) {

                List<LaunchSpecLabelsSpecification> labels =
                        apiLaunchSpecSpecification.getLabels().stream().map(OceanGKELaunchSpecConverter::toBl)
                                                  .collect(Collectors.toList());

                oceanGKECreateLaunchSpecBuilder.setLabels(labels);
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
            oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecBuilder.build();
        }

        return oceanGKECreateLaunchSpecRes;
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
            ApiLaunchSpecResourceLimitSpecification restourceLimit){
        LaunchSpecResourceLimitsSpecification
                restourceLimitToReturn = LaunchSpecResourceLimitsSpecification.Builder.get().build();
        if(restourceLimit.isMaxInstanceCountSet()){
            restourceLimitToReturn.setMaxInstanceCount(restourceLimit.getMaxInstanceCount());
        }

        return restourceLimitToReturn;
    }

    private static LaunchSpecShieldedInstanceConfigSpecification toBl(
            ApiLaunchSpecResourceShieldedInstanceSpecification shieldedInstance){
        LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceList =
                LaunchSpecShieldedInstanceConfigSpecification.Builder.get().build();
        if(shieldedInstance.isEnableIntegrityMonitoringSet()){
            shieldedInstanceList.setEnableIntegrityMonitoring(shieldedInstance.getEnableIntegrityMonitoring());
        }
        if(shieldedInstance.isEnableSecureBootSet()){
            shieldedInstanceList.setEnableSecureBoot(shieldedInstance.getEnableSecureBoot());
        }

        return shieldedInstanceList;
    }

    private static LaunchSpecStrategySpecification toBl(ApiLaunchSpecStrategySpecification startegy){
        LaunchSpecStrategySpecification startegyList = LaunchSpecStrategySpecification.Builder.get().build();
        if(startegy.isPreemptiblePercentageSet()){
            startegyList.setPreemptiblePercentage(startegy.getPreemptiblePercentage());
        }
        return startegyList;
    }

    private static LaunchSpecStorageSpecification toBl(ApiLaunchSpecStorageSpecification storage){
        LaunchSpecStorageSpecification storageList = null;

        storageList = new LaunchSpecStorageSpecification();
        if(storage.isLocalSsdCountSet()){
            storageList.setLocalSsdCount(storage.getLocalSsdCount());
        }
        return storageList;
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
