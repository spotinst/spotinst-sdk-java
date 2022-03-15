package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sClusterFetchElastilogRequest;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.UpdateRollRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotOceanK8sClusterClient {
    private static final Logger                   LOGGER = LoggerFactory.getLogger(SpotOceanK8sClusterClient.class);
    //Members
    private              String                   authToken;
    private              String                   account;
    private              ISpotOceanK8sClusterRepo spotOceanK8sClusterRepo;

    public ISpotOceanK8sClusterRepo getSpotOceanK8sClusterRepo() {
        return this.spotOceanK8sClusterRepo;
    }

    public void setSpotinstOceanClusterRepo() {
        this.spotOceanK8sClusterRepo = SpotinstRepoManager.getInstance().getSpotinstOceanClusterRepo();
    }

    //Constructor
    public SpotOceanK8sClusterClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstOceanClusterRepo();
    }


    //Methods
    public OceanK8sCluster createK8sCluster(K8sClusterCreationRequest oceanClusterCreationRequest) {
        OceanK8sCluster retVal;

        OceanK8sCluster clusterToCreate = oceanClusterCreationRequest.getCluster();

        RepoGenericResponse<OceanK8sCluster> creationResponse =
                getSpotOceanK8sClusterRepo().create(clusterToCreate, authToken, account);
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

    public Boolean updateK8sCluster(K8sClusterUpdateRequest k8SClusterUpdateRequest, String clusterId) {
        Boolean retVal;

        OceanK8sCluster clusterToUpdate = k8SClusterUpdateRequest.getCluster();
        RepoGenericResponse<Boolean> updateResponse =
                getSpotOceanK8sClusterRepo().update(clusterId, clusterToUpdate, authToken, account);
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

    public Boolean deleteK8sCluster(K8sClusterDeleteRequest clusterDeletionRequest) {
        Boolean                      retVal;
        String                       clusterIdToDelete       = clusterDeletionRequest.getClusterId();
        RepoGenericResponse<Boolean> clusterDeletionResponse =
                getSpotOceanK8sClusterRepo().delete(clusterIdToDelete, authToken, account);

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

    public OceanK8sCluster getOceanK8sCluster(K8sClusterGetRequest oceanK8sClusterGetRequest) {
        OceanK8sCluster retVal;
        String          clusterToGet = oceanK8sClusterGetRequest.getClusterId();
        RepoGenericResponse<OceanK8sCluster> clusterRes =
                getSpotOceanK8sClusterRepo().get(clusterToGet, authToken, account);
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

    public List<OceanK8sCluster> getAllK8sClusters() {

        List<OceanK8sCluster> getK8sClusters;

        RepoGenericResponse <List<OceanK8sCluster>> getK8sClustersResponse =
                getSpotOceanK8sClusterRepo().getAllK8sClusters(authToken, account);

        if(getK8sClustersResponse.isRequestSucceed()){
            getK8sClusters =getK8sClustersResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getK8sClustersResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get all the Ocean K8s clusters. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getK8sClusters;

    }

    public GetK8sClusterHeartBeatStatusResponse getK8sClusterHeartBeatStatus(String clusterId) {

        GetK8sClusterHeartBeatStatusResponse getK8sClusterHeartBeatStatus;

        RepoGenericResponse<GetK8sClusterHeartBeatStatusResponse> getK8sClusterHeartBeatStatusResponse =
                getSpotOceanK8sClusterRepo().getK8sClusterHeartBeatStatus(clusterId, authToken, account);

        if(getK8sClusterHeartBeatStatusResponse.isRequestSucceed()){
            getK8sClusterHeartBeatStatus =getK8sClusterHeartBeatStatusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getK8sClusterHeartBeatStatusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get Ocean K8s cluster heartbeat status. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getK8sClusterHeartBeatStatus;

    }

    public OceanK8sCluster importASGToOceanCluster(ImportAsgToClusterConfiguration instanceTypes, String autoScalingGroupName, String region) {

        OceanK8sCluster importedClusterConfiguration;

        RepoGenericResponse<OceanK8sCluster> importASGToOceanClusterResponse =
                getSpotOceanK8sClusterRepo().importASGToOceanCluster(instanceTypes, autoScalingGroupName, region, authToken, account);

        if(importASGToOceanClusterResponse.isRequestSucceed()){
            importedClusterConfiguration =importASGToOceanClusterResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = importASGToOceanClusterResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to import ASG to ocean cluster. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return importedClusterConfiguration;

    }

    public List<K8sClusterFetchElastilogResponse> fetchElastilog(K8sClusterFetchElastilogRequest clusterGetElastilogRequest, String clusterId) {

        List<K8sClusterFetchElastilogResponse> getLogs;

        RepoGenericResponse <List<K8sClusterFetchElastilogResponse>> getLogsResponse =
                getSpotOceanK8sClusterRepo().fetchElastilog(clusterGetElastilogRequest, clusterId, authToken);

        if(getLogsResponse.isRequestSucceed()){
            getLogs =getLogsResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getLogsResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get the ocean EKS Elastilog. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getLogs;
    }

    public ClusterRollResponse initiateRoll(InitiateRoll initiateRollRequest, String clusterId) {
        ClusterRollResponse retVal;
        RepoGenericResponse<ClusterRollResponse> initiateRollResponse = getSpotOceanK8sClusterRepo().initiateRoll(initiateRollRequest, clusterId, authToken, account);

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

    public List<ClusterRollResponse> listRolls(String clusterId) {
        List<ClusterRollResponse> retVal;
        RepoGenericResponse<List<ClusterRollResponse>> listRollsResponse = getSpotOceanK8sClusterRepo().listRolls(clusterId, authToken, account);

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

    public ClusterRollResponse getRoll(String clusterId, String rollId) {
        ClusterRollResponse retVal;
        RepoGenericResponse<ClusterRollResponse> getRollResponse = getSpotOceanK8sClusterRepo().getRoll(clusterId, rollId,  authToken, account);

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

    public ClusterRollResponse updateRoll(UpdateRollRequest updateRollRequest, String clusterId, String rollId) {
        ClusterRollResponse retVal;
        RepoGenericResponse<ClusterRollResponse> updateRollResponse = getSpotOceanK8sClusterRepo().updateRoll(updateRollRequest, clusterId, rollId, authToken, account);

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

    public Boolean detachInstances(DetachInstances instances, String clusterId) {
        Boolean retVal;
        RepoGenericResponse<Boolean> detachInstancesResponse = getSpotOceanK8sClusterRepo().detachInstances(instances, clusterId, authToken, account);

        if (detachInstancesResponse.isRequestSucceed()) {
            retVal = detachInstancesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = detachInstancesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to detach instances from the Ocean cluster. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }
}
