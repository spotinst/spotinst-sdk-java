package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class K8sVngClient {
    private static final Logger     LOGGER = LoggerFactory.getLogger(K8sVngClient.class);

    private String                  authToken;
    private String                  account;
    private ISpotK8sVngRepo   		K8sVngRepo;

    public ISpotK8sVngRepo getK8sVngRepo() {
        return K8sVngRepo;
    }

    public K8sVngClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setK8sVngRepo();
    }

    public void setK8sVngRepo() {
        this.K8sVngRepo = SpotinstRepoManager.getInstance().getK8sVngRepo();
    }

    public K8sVngSpec createK8sVng(K8sVngCreationRequest k8sVngSpec) {
        K8sVngSpec retVal;

        K8sVngSpec vngToCreate = k8sVngSpec.getVngLaunchSpec();

        RepoGenericResponse<K8sVngSpec> creationResponse = getK8sVngRepo().create(vngToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create ocean Virtual Node Group. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateK8sVng(K8sVngUpdateRequest k8sVngUpdateRequest, String launchSpecId) {
        Boolean retVal;

        K8sVngSpec vngToUpdate = k8sVngUpdateRequest.getVngLaunchSpec();
        RepoGenericResponse<Boolean> updateResponse = getK8sVngRepo().update(launchSpecId, vngToUpdate, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to update Virtual Node Group. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteK8sVngSpec(K8sVngDeleteRequest vngDeletionRequest) {
        Boolean                      retVal;
        String                       launchSpecIdToDelete     = vngDeletionRequest.getOceanLaunchSpecId();
        RepoGenericResponse<Boolean> clusterDeletionResponse  = getK8sVngRepo().delete(launchSpecIdToDelete, authToken, account);

        if (clusterDeletionResponse.isRequestSucceed()) {
            retVal = clusterDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete ocean Virtual Node Group. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public K8sVngSpec getK8sVngSpec(K8sVngGetRequest k8sVngSpecGetRequest) {
        K8sVngSpec retVal;
        String          vngToGet = k8sVngSpecGetRequest.getOceanLaunchSpecId();
        RepoGenericResponse<K8sVngSpec> clusterRes = getK8sVngRepo().get(vngToGet, authToken, account);

        if (clusterRes.isRequestSucceed()) {
            retVal = clusterRes.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterRes.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get ocean Virtual Node Group. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<K8sVngSpec> listK8sVngSpec(K8sVngListRequest k8sVngListRequest) {
        List<K8sVngSpec> retVal;
        String          oceanId = k8sVngListRequest.getOceanId();
        RepoGenericResponse<List<K8sVngSpec>> clusterRes = getK8sVngRepo().list(authToken, account, oceanId);

        if (clusterRes.isRequestSucceed()) {
            retVal = clusterRes.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterRes.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to list ocean Virtual Node Group. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public K8sVngSpec importASGToVng(K8sVngSpec importASGRequest, String autoScalingGroupName, String oceanId) {
        K8sVngSpec retVal;
        RepoGenericResponse<K8sVngSpec> importASGToVngResponse = getK8sVngRepo().importASGToVng(importASGRequest, autoScalingGroupName, oceanId, authToken, account);

        if (importASGToVngResponse.isRequestSucceed()) {
            retVal = importASGToVngResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = importASGToVngResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to import ASG to  Virtual Node Group. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public K8sVngSpec importClusterVngToOceanVng(K8sImportClusterVngToOceanVngRequest importVngRequest) {
        K8sVngSpec retVal;
        RepoGenericResponse<K8sVngSpec> importClusterVngToVngResponse = getK8sVngRepo().importCluterVngToOceanVng(importVngRequest, authToken);

        if (importClusterVngToVngResponse.isRequestSucceed()) {
            retVal = importClusterVngToVngResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = importClusterVngToVngResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to import cluster vng to  ocean Virtual Node Group. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<LaunchNodesInVNGResponse> launchNodesInVNG(LaunchNodesInVNG lauchNodes, String vngId) {
        List<LaunchNodesInVNGResponse> retVal;
        RepoGenericResponse<List<LaunchNodesInVNGResponse>> launchNodesResponse = getK8sVngRepo().launchNodesInVNG(lauchNodes, vngId, authToken, account);

        if (launchNodesResponse.isRequestSucceed()) {
            retVal = launchNodesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = launchNodesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to launch nodes in Virtual Node Group. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<GetClusterVNGNodesResponse> getClusterVNGNodes(GetClusterVNGNodesRequest getNodesRequest, String clusterId) {
        List<GetClusterVNGNodesResponse> retVal;
        RepoGenericResponse<List<GetClusterVNGNodesResponse>> getNodesResponse = getK8sVngRepo().getClusterVNGNodes(getNodesRequest, clusterId, authToken);

        if (getNodesResponse.isRequestSucceed()) {
            retVal = getNodesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getNodesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get the cluster nodes in Virtual Node Group. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

}
