package com.spotinst.sdkjava.model.repo.ocean.aks;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotAzureAksVngRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.ocean.aks.ApiClusterVirtualNodeGroup;
import com.spotinst.sdkjava.model.bl.ocean.aks.ClusterVirtualNodeGroup;
import com.spotinst.sdkjava.model.converters.aks.AksVngConverter;
import com.spotinst.sdkjava.model.service.ocean.aks.AzureAksVngSpecService;

import java.util.List;
import java.util.stream.Collectors;

public class AzureAksVngRepo implements ISpotAzureAksVngRepo {

    @Override
    public RepoGenericResponse<ClusterVirtualNodeGroup> create(ClusterVirtualNodeGroup vngToCreate, String authToken, String account) {

        RepoGenericResponse<ClusterVirtualNodeGroup> retVal;

        try {
            ApiClusterVirtualNodeGroup apiAksVngSpecToCreate = AksVngConverter.toDal(vngToCreate);
            ApiClusterVirtualNodeGroup apiCreatedVng = AzureAksVngSpecService.createAksVng(apiAksVngSpecToCreate, authToken, account);
            ClusterVirtualNodeGroup createdAksVngSpec = AksVngConverter.toBl(apiCreatedVng);
            retVal = new RepoGenericResponse<>(createdAksVngSpec);
        }
		
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String vngId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean deleted = AzureAksVngSpecService.deleteAksVng(vngId, authToken, account);
            retVal = new RepoGenericResponse<>(deleted);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String vngId, ClusterVirtualNodeGroup vngToUpdate, String authToken,String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiClusterVirtualNodeGroup apiK8sVngSpec = AksVngConverter.toDal(vngToUpdate);

        try {
            Boolean success = AzureAksVngSpecService.updateAksVng(vngId, apiK8sVngSpec, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ClusterVirtualNodeGroup> get(String vngId, String authToken, String account) {
        RepoGenericResponse<ClusterVirtualNodeGroup> retVal;

        try {
            ApiClusterVirtualNodeGroup apiK8sVngSpec = AzureAksVngSpecService.getAksVng(vngId, authToken, account);

            ClusterVirtualNodeGroup aksVngSpec = AksVngConverter.toBl(apiK8sVngSpec);
            retVal = new RepoGenericResponse<>(aksVngSpec);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

	@Override
    public RepoGenericResponse<List<ClusterVirtualNodeGroup>> list(String authToken, String account, String oceanId) {
        RepoGenericResponse<List<ClusterVirtualNodeGroup>> retVal;

        try {
            List<ApiClusterVirtualNodeGroup> apiGetAllVng = AzureAksVngSpecService.listAksVng(authToken, account, oceanId);
            List<ClusterVirtualNodeGroup> aksVngSpec = apiGetAllVng.stream().map(AksVngConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(aksVngSpec);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}