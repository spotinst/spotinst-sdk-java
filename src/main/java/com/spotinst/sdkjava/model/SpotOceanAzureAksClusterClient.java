package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.aks.*;
import com.spotinst.sdkjava.model.requests.ocean.aks.AksUpdateRollRequest;
import com.spotinst.sdkjava.model.requests.ocean.aks.GetAksClusterNodesRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class SpotOceanAzureAksClusterClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotOceanAzureAksClusterClient.class);
    private              String                                    authToken;
    private              String                                    account;
    private              ISpotOceanAzureAksClusterRepo             spotOceanAzureAksClusterRepo;


    public ISpotOceanAzureAksClusterRepo getSpotOceanAzureAksClusterRepo() {
        return spotOceanAzureAksClusterRepo;
    }

    public void setSpotOceanAzureAksClusterRepo() {
        this.spotOceanAzureAksClusterRepo = SpotinstRepoManager.getInstance().getSpotOceanAzureAksClusterRepo();
    }

    //Constructor
    public SpotOceanAzureAksClusterClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;
        setSpotOceanAzureAksClusterRepo();
    }


    public OceanClusterAks createAksCluster(AksClusterCreationRequest oceanClusterCreationRequest) {

        OceanClusterAks retVal;
        OceanClusterAks clusterToCreate = oceanClusterCreationRequest.getCluster();

        RepoGenericResponse<OceanClusterAks> creationResponse = getSpotOceanAzureAksClusterRepo().create(clusterToCreate, authToken, account);
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

    public Boolean updateAksCluster(AksClusterUpdateRequest aksClusterUpdateRequest, String clusterId) {
        Boolean retVal;

        OceanClusterAks clusterToUpdate = aksClusterUpdateRequest.getCluster();
        RepoGenericResponse<Boolean> updateResponse =
                getSpotOceanAzureAksClusterRepo().update(clusterId, clusterToUpdate, authToken, account);
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

    public Boolean deleteAksCluster(AksClusterDeleteRequest clusterDeletionRequest) {
        Boolean                      retVal;
        String                       clusterIdToDelete       = clusterDeletionRequest.getClusterId();
        RepoGenericResponse<Boolean> clusterDeletionResponse =
                getSpotOceanAzureAksClusterRepo().delete(clusterIdToDelete, authToken, account);

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

    public OceanClusterAks getOceanAksCluster(AksClusterGetRequest aksClusterGetRequest) {
        OceanClusterAks retVal;
        String          clusterToGet = aksClusterGetRequest.getClusterId();
        RepoGenericResponse<OceanClusterAks> clusterRes =
                getSpotOceanAzureAksClusterRepo().get(clusterToGet, authToken, account);
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

    public List<OceanClusterAks> ListOceanAksCluster() {
        List<OceanClusterAks> retVal;

        ISpotOceanAzureAksClusterRepo repo         = getSpotOceanAzureAksClusterRepo();
        RepoGenericResponse<List<OceanClusterAks>> clustersRepoGenericResponse =
                repo.getAll(null, authToken, account);
        if (clustersRepoGenericResponse.isRequestSucceed()) {
            retVal = clustersRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = clustersRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to List all Ocean clusters. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        System.out.println("GET- List All Ocean clusters:");

        if (retVal.size() == 0){ // No groups for this account
            System.out.println("No cluster found for this account");
        }

        for (int i = 0; i < retVal.size(); i++) {
            System.out.println("Cluster number:" + i + "   " + retVal.get(i).getName() + "   " + retVal.get(i).getControllerClusterId());
        }

        return retVal;
    }

    public GetAzureAksClusterHeartBeatStatusResponse getAzureAksClusterHeartBeatStatus(String clusterId) {

        GetAzureAksClusterHeartBeatStatusResponse getK8sClusterHeartBeatStatus;

        RepoGenericResponse<GetAzureAksClusterHeartBeatStatusResponse> getK8sClusterHeartBeatStatusResponse =
                getSpotOceanAzureAksClusterRepo().getAzureAksClusterHeartBeatStatus(clusterId, authToken, account);

        if(getK8sClusterHeartBeatStatusResponse.isRequestSucceed()){
            getK8sClusterHeartBeatStatus =getK8sClusterHeartBeatStatusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getK8sClusterHeartBeatStatusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get Ocean cluster heartbeat status. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getK8sClusterHeartBeatStatus;

    }

    public List<GetAksClusterNodesResponse> getClusterNodes(GetAksClusterNodesRequest getNodesRequest, String clusterId) {
        List<GetAksClusterNodesResponse> retVal;
        RepoGenericResponse<List<GetAksClusterNodesResponse>> getNodesResponse = getSpotOceanAzureAksClusterRepo().getClusterNodes(getNodesRequest, clusterId, authToken);

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

    public List<AksDetachInstancesResponse> detachVms(AksDetachInstances instances, String clusterId) {
        List<AksDetachInstancesResponse> retVal;
        RepoGenericResponse<List<AksDetachInstancesResponse>> detachInstancesResponse = getSpotOceanAzureAksClusterRepo().detachVms(instances, clusterId, authToken, account);

        if (detachInstancesResponse.isRequestSucceed()) {
            retVal = detachInstancesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = detachInstancesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to detach vms from the Ocean cluster. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public AksClusterRollResponse initiateRoll(AksInitiateRoll initiateRollRequest, String clusterId) {
        AksClusterRollResponse retVal;
        RepoGenericResponse<AksClusterRollResponse> initiateRollResponse = getSpotOceanAzureAksClusterRepo().initiateRoll(initiateRollRequest, clusterId, authToken, account);

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

    public AksClusterRollResponse updateRoll(AksUpdateRollRequest updateRollRequest, String clusterId, String rollId) {
        AksClusterRollResponse retVal;
        RepoGenericResponse<AksClusterRollResponse> updateRollResponse = getSpotOceanAzureAksClusterRepo().updateRoll(updateRollRequest, clusterId, rollId, authToken, account);

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

    public AksClusterRollResponse getRoll(String clusterId, String rollId) {
        AksClusterRollResponse retVal;
        RepoGenericResponse<AksClusterRollResponse> getRollResponse = getSpotOceanAzureAksClusterRepo().getRoll(clusterId, rollId,  authToken, account);

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

    public List<AksClusterRollResponse> listRolls(String clusterId) {
        List<AksClusterRollResponse> retVal;
        RepoGenericResponse<List<AksClusterRollResponse>> listRollsResponse = getSpotOceanAzureAksClusterRepo().listRolls(clusterId, authToken, account);

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

    public ImportOceanClusterAksResponse importAksCluster(ImportOceanClusterAks oceanClusterImportRequest, String acdIdentifier) {

        ImportOceanClusterAksResponse retVal;

        RepoGenericResponse<ImportOceanClusterAksResponse> importResponse = getSpotOceanAzureAksClusterRepo().importAksCluster(oceanClusterImportRequest, acdIdentifier, authToken, account);
        if (importResponse.isRequestSucceed()) {
            retVal = importResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = importResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to import ocean cluster. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }
}
