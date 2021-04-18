package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.aks.*;
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


    public ClusterAks createAksCluster(AksClusterCreationRequest oceanClusterCreationRequest) {

        ClusterAks retVal;
        ClusterAks clusterToCreate = oceanClusterCreationRequest.getCluster();

        RepoGenericResponse<ClusterAks> creationResponse = getSpotOceanAzureAksClusterRepo().create(clusterToCreate, authToken, account);
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

        ClusterAks clusterToUpdate = aksClusterUpdateRequest.getCluster();
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

    public ClusterAks getOceanAksCluster(AksClusterGetRequest aksClusterGetRequest) {
        ClusterAks retVal;
        String          clusterToGet = aksClusterGetRequest.getClusterId();
        RepoGenericResponse<ClusterAks> clusterRes =
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

    public List<ClusterAks> ListOceanAksCluster() {
        List<ClusterAks> retVal;

        ISpotOceanAzureAksClusterRepo repo         = getSpotOceanAzureAksClusterRepo();
        RepoGenericResponse<List<ClusterAks>> clustersRepoGenericResponse =
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
}
