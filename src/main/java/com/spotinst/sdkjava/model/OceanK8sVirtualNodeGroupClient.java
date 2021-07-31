package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OceanK8sVirtualNodeGroupClient {
    private static final Logger                 LOGGER = LoggerFactory.getLogger(OceanK8sVirtualNodeGroupClient.class);

    private String                              authToken;
    private String                              account;
    private ISpotOceanK8sVirtualNodeGroupRepo   oceanK8sVirtualNodeGroupRepo;

    public ISpotOceanK8sVirtualNodeGroupRepo getOceanK8sVirtualNodeGroupRepo() {
        return oceanK8sVirtualNodeGroupRepo;
    }

    public OceanK8sVirtualNodeGroupClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setOceanK8sVirtualNodeGroupRepo();
    }

    public void setOceanK8sVirtualNodeGroupRepo() {
        this.oceanK8sVirtualNodeGroupRepo = SpotinstRepoManager.getInstance().getOceanK8sVirtualNodeGroupRepo();
    }

    public K8sVirtualNodeGroup createK8sVirtualNodeGroup(K8sVirtualNodeGroupCreationRequest oceanVirtualNodeGroup) {
        K8sVirtualNodeGroup retVal;

        K8sVirtualNodeGroup virtualNodeGroupToCreate = oceanVirtualNodeGroup.getLaunchSpec();

        RepoGenericResponse<K8sVirtualNodeGroup> creationResponse = getOceanK8sVirtualNodeGroupRepo().create(virtualNodeGroupToCreate, authToken, account);

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

    public Boolean updateK8sVirtualNodeGroup(K8sVirtualNodeGroupUpdateRequest k8sVirtualNodeGroupUpdateRequest, String launchSpecId) {
        Boolean retVal;

        K8sVirtualNodeGroup virtualNodeGroupToUpdate = k8sVirtualNodeGroupUpdateRequest.getVirtualNodeGroup();
        RepoGenericResponse<Boolean> updateResponse = getOceanK8sVirtualNodeGroupRepo().update(launchSpecId, virtualNodeGroupToUpdate, authToken, account);

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

    public Boolean deleteK8sVirtualNodeGroup(K8sVirtualNodeGroupDeleteRequest virtualNodeGroupDeletionRequest) {
        Boolean                      retVal;
        String                       launchSpecIdToDelete     = virtualNodeGroupDeletionRequest.getOceanLaunchSpecId();
        RepoGenericResponse<Boolean> clusterDeletionResponse  = getOceanK8sVirtualNodeGroupRepo().delete(launchSpecIdToDelete, authToken, account);

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

    public K8sVirtualNodeGroup getK8sVirtualNodeGroup(K8sVirtualNodeGroupGetRequest oceanK8sVirtualNodeGroupGetRequest) {
        K8sVirtualNodeGroup retVal;
        String          virtualNodeGroupToGet = oceanK8sVirtualNodeGroupGetRequest.getOceanLaunchSpecId();
        RepoGenericResponse<K8sVirtualNodeGroup> clusterRes = getOceanK8sVirtualNodeGroupRepo().get(virtualNodeGroupToGet, authToken, account);

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
}
