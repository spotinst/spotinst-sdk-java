package com.spotinst.sdkjava.model.repo.ocean.kubernetes;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotK8sVngRepo;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sImportClusterVngToOceanVngRequest;
import com.spotinst.sdkjava.model.service.ocean.kubernetes.K8sVngSpecService;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVngSpec;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.K8sVngSpec;
import com.spotinst.sdkjava.model.converters.K8sVngConverter;

import java.util.List;
import java.util.stream.Collectors;

public class K8sVngRepo implements ISpotK8sVngRepo {

    @Override
    public RepoGenericResponse<K8sVngSpec> create(K8sVngSpec vngToCreate, String authToken, String account) {

        RepoGenericResponse<K8sVngSpec> retVal;

        try {
            ApiK8sVngSpec apiK8sVngSpecToCreate = K8sVngConverter.toDal(vngToCreate);
            ApiK8sVngSpec apiCreatedVng = K8sVngSpecService.createK8sVng(apiK8sVngSpecToCreate, authToken, account);
            K8sVngSpec createdK8sVngSpec = K8sVngConverter.toBl(apiCreatedVng);
            retVal = new RepoGenericResponse<>(createdK8sVngSpec);
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
            Boolean deleted = K8sVngSpecService.deleteK8sVng(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(deleted);
        }
		
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String identifier, K8sVngSpec vngToUpdate, String authToken,String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiK8sVngSpec apiK8sVngSpec = K8sVngConverter.toDal(vngToUpdate);

        try {
            Boolean success = K8sVngSpecService.updateK8sVng(identifier, apiK8sVngSpec, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
		
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<K8sVngSpec> get(String identifier, String authToken, String account) {
        RepoGenericResponse<K8sVngSpec> retVal;

        try {
            ApiK8sVngSpec apiK8sVngSpec = K8sVngSpecService.getK8sVng(identifier, authToken, account);

            K8sVngSpec k8sVngSpec = K8sVngConverter.toBl(apiK8sVngSpec);
            retVal = new RepoGenericResponse<>(k8sVngSpec);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

	@Override
    public RepoGenericResponse<List<K8sVngSpec>> list(String authToken, String account, String oceanId) {
        RepoGenericResponse<List<K8sVngSpec>> retVal;

        try {
            List<ApiK8sVngSpec> apiGetAllVng = K8sVngSpecService.listK8sVng(authToken, account, oceanId);
            List<K8sVngSpec> k8sVngSpec = apiGetAllVng.stream().map(K8sVngConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(k8sVngSpec);
        }
		
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<K8sVngSpec> importASGToVng(K8sVngSpec importASGRequest, String autoScalingGroupName, String oceanId, String authToken, String account) {
        RepoGenericResponse<K8sVngSpec> retVal;

        try {
            ApiK8sVngSpec apiImportASGToVng = K8sVngConverter.toDal(importASGRequest);
            ApiK8sVngSpec apiImportASG = K8sVngSpecService.importASGToVng(apiImportASGToVng, autoScalingGroupName, oceanId, authToken, account);
            K8sVngSpec ImportedK8sVngSpec = K8sVngConverter.toBl(apiImportASG);
            retVal = new RepoGenericResponse<>(ImportedK8sVngSpec);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<K8sVngSpec> importCluterVngToOceanVng(K8sImportClusterVngToOceanVngRequest importClusterVngRequest, String authToken) {
        RepoGenericResponse<K8sVngSpec> retVal;

        try {
            ApiK8sVngSpec apiImportClusterVngToVng = K8sVngSpecService.importClusterVngToOceanVng(importClusterVngRequest, authToken);
            K8sVngSpec ImportedK8sVngSpec = K8sVngConverter.toBl(apiImportClusterVngToVng);
            retVal = new RepoGenericResponse<>(ImportedK8sVngSpec);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}