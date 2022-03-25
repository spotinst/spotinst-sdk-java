package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.aks.ClusterVirtualNodeGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AzureAksVngClient {
    private static final Logger     LOGGER = LoggerFactory.getLogger(AzureAksVngClient.class);

    private String                  authToken;
    private String                  account;
    private ISpotAzureAksVngRepo   	aksVngRepo;

    public ISpotAzureAksVngRepo getAksVngRepo() {
        return aksVngRepo;
    }

    public AzureAksVngClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setAksVngRepo();
    }

    public void setAksVngRepo() {
        this.aksVngRepo = SpotinstRepoManager.getInstance().getAksVngRepo();
    }

    public ClusterVirtualNodeGroup createAksVng(ClusterVirtualNodeGroup clusterVirtualNodeGroup) {
        ClusterVirtualNodeGroup retVal;

        RepoGenericResponse<ClusterVirtualNodeGroup> creationResponse = getAksVngRepo().create(clusterVirtualNodeGroup, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create AKS Virtual Node Group. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateAKSVng(String launchSpecId, ClusterVirtualNodeGroup aksVngUpdate) {
        Boolean retVal;

        RepoGenericResponse<Boolean> updateResponse = getAksVngRepo().update(launchSpecId, aksVngUpdate, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to update AKS cluster Virtual Node Group. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteAksVng(String vngId) {
        Boolean                      retVal;

        RepoGenericResponse<Boolean> clusterDeletionResponse  = getAksVngRepo().delete(vngId, authToken, account);

        if (clusterDeletionResponse.isRequestSucceed()) {
            retVal = clusterDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete AKS Virtual Node Group. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public ClusterVirtualNodeGroup getAksVng(String aksVngId) {
        ClusterVirtualNodeGroup retVal;

        RepoGenericResponse<ClusterVirtualNodeGroup> clusterRes = getAksVngRepo().get(aksVngId, authToken, account);

        if (clusterRes.isRequestSucceed()) {
            retVal = clusterRes.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterRes.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get aks Virtual Node Group. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<ClusterVirtualNodeGroup> listAksVng(String oceanId) {
        List<ClusterVirtualNodeGroup> retVal;

        RepoGenericResponse<List<ClusterVirtualNodeGroup>> clusterRes = getAksVngRepo().list(authToken, account, oceanId);

        if (clusterRes.isRequestSucceed()) {
            retVal = clusterRes.getValue();
        }
        else {
            List<HttpError> httpExceptions = clusterRes.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to list AKS Virtual Node Group. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

}
