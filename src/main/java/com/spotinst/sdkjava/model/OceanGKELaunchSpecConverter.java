package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.gcp.*;

import java.util.ArrayList;

import java.util.List;

public class OceanGKELaunchSpecConverter {

    public static ApiOceanGKELaunchSpec toDal(OceanGKELaunchSpec src) {
        ApiOceanGKELaunchSpec apiGroup = null;

        if (src != null) {
            apiGroup = ApiOceanGKELaunchSpec.Builder.get().build();

            if (src.isIdSet()) {
                apiGroup.setId(src.getId());
            }
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
                apiGroup.setMetadata(metadataToDal(src.getMetadata()));
            }
            if (src.isInstanceTypesSet()) {
                apiGroup.setInstanceTypes(src.getInstanceTypes());
            }

            if (src.isTaintsSet()) {
                apiGroup.setTaints(oceanGKETaintsToDal(src.getTaints()));
            }

            if (src.isLabelsSet()) {
                apiGroup.setLabels(labelsToDal(src.getLabels()));
            }

            if (src.isAutoScaleSet()) {
                apiGroup.setAutoScale(autoScaleToDal(src.getAutoScale()));
            }

            if (src.isResourceLimitsSet()) {
                apiGroup.setResourceLimits(restourceLimitToDal(src.getResourceLimits()));
            }

            if (src.isOceanGKEShieldedInstanceConfigSet()) {
                apiGroup.setOceanGKEShieldedInstanceConfig(shieldedInstanceToDal(src.getOceanGKEShieldedInstanceConfig()));
            }
            if (src.isStrategySet()) {
                apiGroup.setStrategy(startegyToDal(src.getStrategy()));
            }
            if (src.isStorageSet()) {
                apiGroup.setStorage(storageToDal(src.getStorage()));
            }

        }

        return apiGroup;
    }

    private static List<ApiOceanGKETaints> oceanGKETaintsToDal(List<OceanGKETaints> taints) {

        List<ApiOceanGKETaints> taintsListToReturn = new ArrayList<>();
        ArrayList<OceanGKETaints> taintsList =  new ArrayList<>(taints);

        for(int i = 0; i < taintsList.size();i++){
            ApiOceanGKETaints retVal = ApiOceanGKETaints.Builder.get().build();

            if(taintsList.get(i).isKeySet()){
                retVal.setKey(taintsList.get(i).getKey());
            }
            if(taintsList.get(i).isValueSet()){
                retVal.setValue(taintsList.get(i).getValue());
            }
            if(taintsList.get(i).isEffectSet()){
                retVal.setEffect(taintsList.get(i).getEffect());
            }

            taintsListToReturn.add(retVal);

        }

        return taintsListToReturn;
    }

    private static List<ApiOceanGKELabels> labelsToDal(List<OceanGKELabels> labels){
        List<ApiOceanGKELabels> labelsListToReturn = new ArrayList<>();
        ArrayList<OceanGKELabels> labelsList =  new ArrayList<>(labels);

        for(int i = 0; i < labelsList.size();i++){
            ApiOceanGKELabels retVal = ApiOceanGKELabels.Builder.get().build();

            if(labelsList.get(i).isKeySet()){
                retVal.setKey(labelsList.get(i).getKey());
            }
            if(labelsList.get(i).isValueSet()){
                retVal.setValue(labelsList.get(i).getValue());
            }
            labelsListToReturn.add(retVal);

        }

        return labelsListToReturn;
    }

    private static ApiOceanGKEAutoScale autoScaleToDal(OceanGKEAutoScale autoScale){
        ApiOceanGKEAutoScale autoScaleListToReturn = ApiOceanGKEAutoScale.Builder.get().build();

        if(autoScale.isHeadroomsSet()){
            autoScaleListToReturn.setHeadrooms(headRoomsToDal(autoScale.getHeadrooms()));
        }

        return autoScaleListToReturn;
    }

    private static List<ApiOceanGKEHeadRooms> headRoomsToDal(List<OceanGKEHeadRooms> headRooms) {

        List<ApiOceanGKEHeadRooms> headRoomsList = new ArrayList<>();
        ArrayList<OceanGKEHeadRooms> headRoomsLists =  new ArrayList<>(headRooms);

        for(int i = 0; i < headRoomsLists.size();i++) {

            ApiOceanGKEHeadRooms headRoomsListToReturn =  ApiOceanGKEHeadRooms.Builder.get().build();

            if (headRoomsLists.get(i).isCpuPerUnitSet()) {
                headRoomsListToReturn.setCpuPerUnit(headRoomsLists.get(i).getCpuPerUnit());
            }

            if(headRoomsLists.get(i).isGpuPerUnitSet()){
                headRoomsListToReturn.setGpuPerUnit(headRoomsLists.get(i).getGpuPerUnit());
            }
            if(headRoomsLists.get(i).isMemoryPerUnitSet()){
                headRoomsListToReturn.setMemoryPerUnit(headRoomsLists.get(i).getMemoryPerUnit());
            }
            if(headRoomsLists.get(i).isNumOfUnitsSet()){
                headRoomsListToReturn.setGpuPerUnit(headRoomsLists.get(i).getNumOfUnits());
            }
            headRoomsList.add(headRoomsListToReturn);
        }

        return headRoomsList;
    }

    private static ApiOceanGKEResourceLimits restourceLimitToDal(OceanGKEResourceLimits restourceLimit){
        ApiOceanGKEResourceLimits restourceLimitToReturn = ApiOceanGKEResourceLimits.Builder.get().build();

        if(restourceLimit.isMaxInstanceCountSet()){
            restourceLimitToReturn.setMaxInstanceCount(restourceLimit.getMaxInstanceCount());
        }

        return restourceLimitToReturn;
    }

    private static ApiOceanGKEShieldedInstanceConfig shieldedInstanceToDal(OceanGKEShieldedInstanceConfig shieldedInstance){
        ApiOceanGKEShieldedInstanceConfig shieldedInstanceList =  ApiOceanGKEShieldedInstanceConfig.Builder.get().build();

        if(shieldedInstance.isEnableIntegrityMonitoringSet()){
            shieldedInstanceList.setEnableIntegrityMonitoring(shieldedInstance.getEnableIntegrityMonitoring());
        }
        if(shieldedInstance.isEnableSecureBootSet()){
            shieldedInstanceList.setEnableSecureBoot(shieldedInstance.getEnableSecureBoot());
        }

        return shieldedInstanceList;
    }

    private static ApiOceanGKEStrategy startegyToDal(OceanGKEStrategy startegy){
        ApiOceanGKEStrategy startegyList = ApiOceanGKEStrategy.Builder.get().build();

        if(startegy.isPreemptiblePercentageSet()){
            startegyList.setPreemptiblePercentage(startegy.getPreemptiblePercentage());
        }
        return startegyList;
    }

    private static ApiOceanGKEStorage storageToDal(OceanGKEStorage storage){
        ApiOceanGKEStorage storageList = ApiOceanGKEStorage.Builder.get().build();

        if(storage.isLocalSsdCountSet()){
            storageList.setLocalSsdCount(storage.getLocalSsdCount());
        }
        return storageList;
    }

    private static List<ApiOceanGKEMetadata> metadataToDal(List<OceanGKEMetadata> metadata){
        List<ApiOceanGKEMetadata> metadataListToReturn = new ArrayList<>();
        ArrayList<OceanGKEMetadata> metadataList =  new ArrayList<>(metadata);
        for(int i = 0; i < metadataList.size();i++){
            ApiOceanGKEMetadata retVal = null;

            if (metadataList != null) {
                retVal = new ApiOceanGKEMetadata();

                if(metadataList.get(i).isKeySet()){
                    retVal.setKey(metadataList.get(i).getKey());
                }
                if(metadataList.get(i).isValueSet()){
                    retVal.setValue(metadataList.get(i).getValue());
                }
            }
            metadataListToReturn.add(retVal);

        }

        return metadataListToReturn;
    }


    private static List<OceanGKETaints> taintsToBl(List<ApiOceanGKETaints> taints) {

        List<OceanGKETaints> taintsListToReturn = new ArrayList<>();
        ArrayList<ApiOceanGKETaints> taintsList =  new ArrayList<>(taints);

        for(int i = 0; i < taints.size();i++){

            OceanGKETaints retVal = null;
            retVal = new OceanGKETaints();

            if(taintsList.get(i).isKeySet()){
                retVal.setKey(taintsList.get(i).getKey());
            }
            if(taintsList.get(i).isValueSet()){
                retVal.setValue(taintsList.get(i).getValue());
            }
            if(taintsList.get(i).isEffectSet()){
                retVal.setValue(taintsList.get(i).getEffect());
            }
            taintsListToReturn.add(retVal);
        }

        return taintsListToReturn;
    }

    private static List<OceanGKELabels> labelsToBl(List<ApiOceanGKELabels> labels){
        List<OceanGKELabels> labelsListToReturn = new ArrayList<>();
        ArrayList<ApiOceanGKELabels> labelsList =  new ArrayList<>(labels);

        for(int i = 0; i < labelsList.size();i++){
            OceanGKELabels retVal = null;

            retVal = new OceanGKELabels();

            if(labelsList.get(i).isKeySet()){
                retVal.setKey(labelsList.get(i).getKey());
            }
            if(labelsList.get(i).isValueSet()){
                retVal.setValue(labelsList.get(i).getValue());
            }
            labelsListToReturn.add(retVal);

        }

        return labelsListToReturn;
    }

    public static OceanGKELaunchSpec toBl(ApiOceanGKELaunchSpec apiOceanGKELaunchSpec) {
        OceanGKELaunchSpec oceanGKECreateLaunchSpecRes = null;

        if (apiOceanGKELaunchSpec != null) {
            OceanGKELaunchSpec.Builder oceanGKECreateLaunchSpecBuilder = OceanGKELaunchSpec.Builder.get();

            if (apiOceanGKELaunchSpec.isIdSet()) {
                oceanGKECreateLaunchSpecBuilder.setId(apiOceanGKELaunchSpec.getId());
            }
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
                oceanGKECreateLaunchSpecBuilder.setMetadata(metadataToBl(apiOceanGKELaunchSpec.getMetadata()));
            }
            if (apiOceanGKELaunchSpec.isInstanceTypesSet()) {
                oceanGKECreateLaunchSpecBuilder.setInstanceTypes(apiOceanGKELaunchSpec.getInstanceTypes());
            }

            if (apiOceanGKELaunchSpec.isTaintsSet()) {
                oceanGKECreateLaunchSpecBuilder.setTaints(taintsToBl(apiOceanGKELaunchSpec.getTaints()));
            }

            if (apiOceanGKELaunchSpec.isLabelsSet()) {
                oceanGKECreateLaunchSpecBuilder.setLabels(labelsToBl(apiOceanGKELaunchSpec.getLabels()));
            }

            if (apiOceanGKELaunchSpec.isAutoScaleSet()) {
                oceanGKECreateLaunchSpecBuilder.setAutoScales(autoScaleToBl(apiOceanGKELaunchSpec.getAutoScale()));
            }

            if (apiOceanGKELaunchSpec.isResourceLimitsSet()) {
                oceanGKECreateLaunchSpecBuilder.setResourceLimits(restourceLimitToBl(apiOceanGKELaunchSpec.getResourceLimits()));
            }

            if (apiOceanGKELaunchSpec.isOceanGKEShieldedInstanceConfigSet()) {
                oceanGKECreateLaunchSpecBuilder.setOceanGKEShieldedInstanceConfig(shieldedInstanceToBl(apiOceanGKELaunchSpec.getOceanGKEShieldedInstanceConfig()));
            }
            if (apiOceanGKELaunchSpec.isStrategySet()) {
                oceanGKECreateLaunchSpecBuilder.setStrategy(startegyToBl(apiOceanGKELaunchSpec.getStrategy()));
            }
            if (apiOceanGKELaunchSpec.isStorageSet()) {
                oceanGKECreateLaunchSpecBuilder.setStorage(storageToBl(apiOceanGKELaunchSpec.getStorage()));
            }
            oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecBuilder.build();
        }

        return oceanGKECreateLaunchSpecRes;
    }

    private static OceanGKEAutoScale autoScaleToBl(ApiOceanGKEAutoScale autoScale){
        OceanGKEAutoScale autoScaleListToReturn = OceanGKEAutoScale.Builder.get().build();
        if(autoScale.isHeadroomsSet()){
            autoScaleListToReturn.setHeadrooms(headRoomsToBl(autoScale.getHeadrooms()));
        }

        return autoScaleListToReturn;
    }

    private static List<OceanGKEHeadRooms> headRoomsToBl(List<ApiOceanGKEHeadRooms> headRooms) {

        List<OceanGKEHeadRooms> headRoomsList = new ArrayList<>();
        ArrayList<ApiOceanGKEHeadRooms> headRoomsLists =  new ArrayList<>(headRooms);

        for(int i = 0; i < headRoomsLists.size();i++) {

            OceanGKEHeadRooms headRoomsListToReturn = OceanGKEHeadRooms.Builder.get().build();
            if (headRoomsLists.get(i).isCpuPerUnitSet()) {
                headRoomsListToReturn.setCpuPerUnit(headRoomsLists.get(i).getCpuPerUnit());
            }

            if(headRoomsLists.get(i).isGpuPerUnitSet()){
                headRoomsListToReturn.setGpuPerUnit(headRoomsLists.get(i).getGpuPerUnit());
            }
            if(headRoomsLists.get(i).isMemoryPerUnitSet()){
                headRoomsListToReturn.setMemoryPerUnit(headRoomsLists.get(i).getMemoryPerUnit());
            }
            if(headRoomsLists.get(i).isNumOfUnitsSet()){
                headRoomsListToReturn.setGpuPerUnit(headRoomsLists.get(i).getNumOfUnits());
            }
            headRoomsList.add(headRoomsListToReturn);
        }

        return headRoomsList;
    }

    private static OceanGKEResourceLimits restourceLimitToBl(ApiOceanGKEResourceLimits restourceLimit){
        OceanGKEResourceLimits restourceLimitToReturn = OceanGKEResourceLimits.Builder.get().build();
        if(restourceLimit.isMaxInstanceCountSet()){
            restourceLimitToReturn.setMaxInstanceCount(restourceLimit.getMaxInstanceCount());
        }

        return restourceLimitToReturn;
    }

    private static OceanGKEShieldedInstanceConfig shieldedInstanceToBl(ApiOceanGKEShieldedInstanceConfig shieldedInstance){
        OceanGKEShieldedInstanceConfig shieldedInstanceList =OceanGKEShieldedInstanceConfig.Builder.get().build();
        if(shieldedInstance.isEnableIntegrityMonitoringSet()){
            shieldedInstanceList.setEnableIntegrityMonitoring(shieldedInstance.getEnableIntegrityMonitoring());
        }
        if(shieldedInstance.isEnableSecureBootSet()){
            shieldedInstanceList.setEnableSecureBoot(shieldedInstance.getEnableSecureBoot());
        }

        return shieldedInstanceList;
    }

    private static OceanGKEStrategy startegyToBl(ApiOceanGKEStrategy startegy){
        OceanGKEStrategy startegyList = OceanGKEStrategy.Builder.get().build();
        if(startegy.isPreemptiblePercentageSet()){
            startegyList.setPreemptiblePercentage(startegy.getPreemptiblePercentage());
        }
        return startegyList;
    }

    private static OceanGKEStorage storageToBl(ApiOceanGKEStorage storage){
        OceanGKEStorage storageList = null;

        storageList = new OceanGKEStorage();
        if(storage.isLocalSsdCountSet()){
            storageList.setLocalSsdCount(storage.getLocalSsdCount());
        }
        return storageList;
    }

    private static List<OceanGKEMetadata> metadataToBl(List<ApiOceanGKEMetadata> metadata){
        List<OceanGKEMetadata> metadataListToReturn = new ArrayList<>();
        ArrayList<ApiOceanGKEMetadata> metadataLists =  new ArrayList<>(metadata);

        for(int i = 0; i < metadataLists.size();i++){
            OceanGKEMetadata retVal = null;

            if (metadataLists.get(i) != null) {
                retVal = OceanGKEMetadata.Builder.get().build();

                if(metadataLists.get(i).isKeySet()){
                    retVal.setKey(metadata.get(i).getKey());
                }
                if(metadataLists.get(i).isValueSet()){
                    retVal.setValue(metadata.get(i).getValue());
                }
            }
            metadataListToReturn.add(retVal);

        }

        return metadataListToReturn;
    }
}
