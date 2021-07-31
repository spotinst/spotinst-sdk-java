package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVirtualNodeGroup;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.K8sVirtualNodeGroup;

public class OceanK8sVirtualNodeGroupRepo implements ISpotOceanK8sVirtualNodeGroupRepo {

    @Override
    public RepoGenericResponse<K8sVirtualNodeGroup> create(K8sVirtualNodeGroup virtualNodeGroupToCreate, String authToken, String account) {

        RepoGenericResponse<K8sVirtualNodeGroup> retVal;

        try {
            ApiK8sVirtualNodeGroup apiK8sVirtualNodeGroupToCreate = OceanK8sVirtalNodeGroupConverter.toDal(virtualNodeGroupToCreate);
            ApiK8sVirtualNodeGroup apiCreatedVirtualNodeGroup =
                    OceanK8sVirtualNodeGroupService.createK8sVirtualNodeGroup(apiK8sVirtualNodeGroupToCreate, authToken, account);
            K8sVirtualNodeGroup createdK8sVirtualNodeGroup = OceanK8sVirtalNodeGroupConverter.toBl(apiCreatedVirtualNodeGroup);
            retVal = new RepoGenericResponse<>(createdK8sVirtualNodeGroup);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = OceanK8sVirtualNodeGroupService.deleteK8sVirtualNodeGroup(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String identifier, K8sVirtualNodeGroup virtualNodeGroupToUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiK8sVirtualNodeGroup apiK8sVirtualNodeGroup = OceanK8sVirtalNodeGroupConverter.toDal(virtualNodeGroupToUpdate);

        try {
            Boolean success = OceanK8sVirtualNodeGroupService.updateK8sVirtualNodeGroup(identifier, apiK8sVirtualNodeGroup, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<K8sVirtualNodeGroup> get(String identifier, String authToken, String account) {
        RepoGenericResponse<K8sVirtualNodeGroup> retVal;

        try {
            ApiK8sVirtualNodeGroup apiK8sVirtualNodeGroup = OceanK8sVirtualNodeGroupService
                    .getK8sVirtualNodeGroup(identifier, authToken, account);

            K8sVirtualNodeGroup oceanK8sCluster = OceanK8sVirtalNodeGroupConverter.toBl(apiK8sVirtualNodeGroup);
            retVal = new RepoGenericResponse<>(oceanK8sCluster);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
