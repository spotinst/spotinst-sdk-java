package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.ecs.*;
import com.spotinst.sdkjava.model.requests.ocean.ecs.GetEcsClusterNodesRequest;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsClusterLaunchSpecRequest;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsClusterRequest;

import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsUpdateRollRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotOceanEcsClusterClient {
    private static final Logger                      LOGGER =
            LoggerFactory.getLogger(SpotOceanEcsClusterClient.class);
    //Members
    private              String                      authToken;
    private              String                      account;
    private              ISpotOceanEcsLaunchSpecRepo spotOceanEcsClusterLaunchSpecRepo;
    private              ISpotOceanEcsClusterRepo    spotOceanEcsClusterRepo;

    //Constructor
    public SpotOceanEcsClusterClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;
        this.spotOceanEcsClusterLaunchSpecRepo = SpotinstRepoManager.getInstance().getSpotOceanEcsClusterLaunchSpecRepo();
        this.spotOceanEcsClusterRepo = SpotinstRepoManager.getInstance().getSpotinstOceanEcsClusterRepo();
    }

    private ISpotOceanEcsClusterRepo getSpotOceanEcsClusterRepo() {
        return spotOceanEcsClusterRepo; }

    private ISpotOceanEcsLaunchSpecRepo getSpotOceanEcsClusterLaunchSpecRepo() {
        return spotOceanEcsClusterLaunchSpecRepo;
    }

    //Methods
    public ClusterLaunchSpecification createLaunchSpec(OceanEcsClusterLaunchSpecRequest launchSpecCreationRequest) {
        ClusterLaunchSpecification retVal;

        ClusterLaunchSpecification launchSpecToCreate = launchSpecCreationRequest.getLaunchspec();

        RepoGenericResponse<ClusterLaunchSpecification> creationResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().create(launchSpecToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateLaunchSpec(OceanEcsClusterLaunchSpecRequest launchSpecCreationRequest, String launchSpecId) {
        Boolean retVal;

        ClusterLaunchSpecification launchSpecToUpdate = launchSpecCreationRequest.getLaunchspec();

        RepoGenericResponse<Boolean> updateResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().update(launchSpecId, launchSpecToUpdate, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to update ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean deleteLaunchSpec(OceanEcsClusterLaunchSpecRequest launchSpecRequest) {
        Boolean retVal;
        String  launchSpecId = launchSpecRequest.getOceanLaunchSpecId();
        RepoGenericResponse<Boolean> deleteResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().delete(launchSpecId, authToken, account);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to delete ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public ClusterLaunchSpecification getLaunchSpec(OceanEcsClusterLaunchSpecRequest launchSpecRequest) {
        ClusterLaunchSpecification retVal;
        String                     launchSpecId = launchSpecRequest.getOceanLaunchSpecId();
        RepoGenericResponse<ClusterLaunchSpecification> getResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().get(launchSpecId, authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<ClusterLaunchSpecification> getAllLaunchSpec() {
        List<ClusterLaunchSpecification> retVal;

        RepoGenericResponse<List<ClusterLaunchSpecification>> getAllResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().getAll(null, authToken, account);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to list ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public  OceanEcsCluster createOceanEcsCluster(OceanEcsClusterRequest oceanEcsClusterCreationRequest){
        OceanEcsCluster retVal;
        OceanEcsCluster clusterToCreate = oceanEcsClusterCreationRequest.getCluster();

        RepoGenericResponse<OceanEcsCluster> creationResponse = getSpotOceanEcsClusterRepo().create(clusterToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to create ocean ecs cluster. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateEcsCluster(OceanEcsClusterRequest EcsClusterUpdateRequest, String clusterId) {
        Boolean retVal;

        OceanEcsCluster clusterToUpdate = EcsClusterUpdateRequest.getCluster();
        RepoGenericResponse<Boolean> updateResponse =
                getSpotOceanEcsClusterRepo().update(clusterId, clusterToUpdate, authToken, account);

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

    public OceanEcsCluster getOceanEcsCluster(OceanEcsClusterRequest oceanEcsClusterGetRequest) {
        OceanEcsCluster retVal;

        String          clusterToGet = oceanEcsClusterGetRequest.getClusterId();
        RepoGenericResponse<OceanEcsCluster> clusterRes =
                getSpotOceanEcsClusterRepo().get(clusterToGet, authToken, account);

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

    public Boolean deleteEcsCluster(OceanEcsClusterRequest clusterDeletionRequest) {
        Boolean                      retVal;
        String                       clusterIdToDelete       = clusterDeletionRequest.getClusterId();
        RepoGenericResponse<Boolean> clusterDeletionResponse =
                getSpotOceanEcsClusterRepo().delete(clusterIdToDelete, authToken, account);

        if (clusterDeletionResponse.isRequestSucceed()) {
            retVal = clusterDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to delete ocean cluster. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<OceanEcsCluster> getAllOceanEcsClusters() {
        List<OceanEcsCluster> retVal;

        RepoGenericResponse<List<OceanEcsCluster>> clusterRes = getSpotOceanEcsClusterRepo().getAll(null, authToken, account);

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

    public EcsClusterRollResponse initiateRoll(EcsInitiateRoll initiateRollRequest, String clusterId) {
        EcsClusterRollResponse retVal;
        RepoGenericResponse<EcsClusterRollResponse> initiateRollResponse = getSpotOceanEcsClusterRepo().initiateRoll(initiateRollRequest, clusterId, authToken, account);

        if (initiateRollResponse.isRequestSucceed()) {
            retVal = initiateRollResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = initiateRollResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to Initiate Roll. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<EcsClusterRollResponse> listRolls(String clusterId) {
        List<EcsClusterRollResponse> retVal;
        RepoGenericResponse<List<EcsClusterRollResponse>> listRollsResponse = getSpotOceanEcsClusterRepo().listRolls(clusterId, authToken, account);

        if (listRollsResponse.isRequestSucceed()) {
            retVal = listRollsResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = listRollsResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to list all the Rolls in the cluster. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public EcsClusterRollResponse getRoll(String clusterId, String rollId) {
        EcsClusterRollResponse retVal;
        RepoGenericResponse<EcsClusterRollResponse> getRollResponse = getSpotOceanEcsClusterRepo().getRoll(clusterId, rollId,  authToken, account);

        if (getRollResponse.isRequestSucceed()) {
            retVal = getRollResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getRollResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get the requested Roll details for the cluster. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public EcsClusterRollResponse updateRoll(OceanEcsUpdateRollRequest updateRollRequest, String clusterId, String rollId) {
        EcsClusterRollResponse retVal;
        RepoGenericResponse<EcsClusterRollResponse> updateRollResponse = getSpotOceanEcsClusterRepo().updateRoll(updateRollRequest, clusterId, rollId, authToken, account);

        if (updateRollResponse.isRequestSucceed()) {
            retVal = updateRollResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateRollResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update the roll status to Stopped. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<GetEcsClusterNodesResponse> getClusterContainerInstances(GetEcsClusterNodesRequest getNodesRequest, String clusterId) {
        List<GetEcsClusterNodesResponse> retVal;
        RepoGenericResponse<List<GetEcsClusterNodesResponse>> getNodesResponse = getSpotOceanEcsClusterRepo().getClusterContainerInstances(getNodesRequest, clusterId, authToken);

        if (getNodesResponse.isRequestSucceed()) {
            retVal = getNodesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getNodesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get the cluster container instances. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public ImportOceanEcsClusterResponse importEcsCluster(ImportEcsCluster importEcsCluster, String ecsClusterName) {
        ImportOceanEcsClusterResponse retVal;
        RepoGenericResponse<ImportOceanEcsClusterResponse> importEcsClusterResponse = getSpotOceanEcsClusterRepo().importEcsCluster(importEcsCluster, ecsClusterName, authToken, account);

        if (importEcsClusterResponse.isRequestSucceed()) {
            retVal = importEcsClusterResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = importEcsClusterResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to import ECS cluster. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

}
