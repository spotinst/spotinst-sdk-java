package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVngSpec;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.K8sVngSpec;
import com.spotinst.sdkjava.model.converters.K8sVngConverter;

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
            Boolean updated = K8sVngSpecService.deleteK8sVng(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);
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

    public RepoGenericResponse<K8sVngSpec> getAll(String identifier, String authToken, String account) {
        RepoGenericResponse<K8sVngSpec> retVal;

        try {
            ApiK8sVngSpec apiK8sVngSpec = K8sVngSpecService.listK8sVng(identifier, authToken, account);

            K8sVngSpec k8sVngSpec = K8sVngConverter.toBl(apiK8sVngSpec);
            retVal = new RepoGenericResponse<>(k8sVngSpec);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
