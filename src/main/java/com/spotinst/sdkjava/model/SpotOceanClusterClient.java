package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotOceanClusterClient {
    private static final Logger                   LOGGER = LoggerFactory.getLogger(SpotOceanClusterClient.class);
    //Members
    private              String                   authToken;
    private              String                   account;
    private              ISpotOceanK8sClusterRepo spotinstOceanClusterRepo;

    public ISpotOceanK8sClusterRepo getSpotinstOceanClusterRepo() {
        return spotinstOceanClusterRepo;
    }

    public void setSpotinstOceanClusterRepo() {
        this.spotinstOceanClusterRepo = SpotinstRepoManager.getInstance().getSpotinstOceanClusterRepo();
    }

    //Constructor
    public SpotOceanClusterClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstOceanClusterRepo();
    }

    //Methods
    //todo lihi - change ClusterCreationRequest to k8s (and more classes if needed)
    public OceanCluster createK8sCluster(ClusterCreationRequest oceanClusterCreationRequest) {
        OceanCluster retVal;

        OceanCluster clusterToCreate = oceanClusterCreationRequest.getCluster();

        RepoGenericResponse<OceanCluster> creationResponse =
                getSpotinstOceanClusterRepo().create(clusterToCreate, authToken, account);
        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create ocean cluster. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateCluster(ClusterUpdateRequest clusterUpdateRequest, String clusterId) {
        Boolean retVal;

        OceanCluster clusterToUpdate = clusterUpdateRequest.getCluster();
        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstOceanClusterRepo().update(clusterId, clusterToUpdate, authToken, account);
        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to update cluster. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteCluster(ClusterDeleteRequest clusterDeletionRequest) {
        Boolean                      retVal;
        String                       clusterIdToDelete       = clusterDeletionRequest.getClusterId();
        RepoGenericResponse<Boolean> clusterDeletionResponse =
                getSpotinstOceanClusterRepo().delete(clusterIdToDelete, authToken, account);

        if (clusterDeletionResponse.isRequestSucceed()) {
            retVal = clusterDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete ocean cluster. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    // todo lihi - add example
    public OceanCluster getOceanCluster(ClusterGetRequest oceanClusterGetRequest) {
        OceanCluster retVal;
        String       clusterToGet = oceanClusterGetRequest.getClusterId();
        RepoGenericResponse<OceanCluster> clusterRes =
                getSpotinstOceanClusterRepo().get(clusterToGet, authToken, account);
        if (clusterRes.isRequestSucceed()) {
            retVal = clusterRes.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterRes.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get ocean cluster. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }
}
