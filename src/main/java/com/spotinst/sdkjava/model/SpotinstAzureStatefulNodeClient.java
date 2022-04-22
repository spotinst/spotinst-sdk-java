package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.*;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class SpotinstAzureStatefulNodeClient {
    private static final Logger                      LOGGER =
            LoggerFactory.getLogger(SpotinstAzureStatefulNodeClient.class);
    //Members
    private              String                      authToken;
    private              String                      account;
    private              ISpotAzureStatefulNodeRepo  spotAzureStatefulNodeRepo;

    //Constructor
    public SpotinstAzureStatefulNodeClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;
        this.spotAzureStatefulNodeRepo = SpotinstRepoManager.getInstance().getSpotAzureStatefulNodeRepo();
    }

    private ISpotAzureStatefulNodeRepo getSpotAzureStatefulNodeRepo() {
        return spotAzureStatefulNodeRepo;

    }

    //Methods
    public StatefulNode createNode(StatefulNodeCreationRequest statefulNodeCreationRequest) {
        StatefulNode retVal;

        StatefulNode statefulNodeToCreate = statefulNodeCreationRequest.getNode();

        RepoGenericResponse<StatefulNode> creationResponse =
                getSpotAzureStatefulNodeRepo().createNode(statefulNodeToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public StatefulNode getNode(String nodeId) {
        StatefulNode retVal;

        RepoGenericResponse<StatefulNode> getNodeResponse =
                getSpotAzureStatefulNodeRepo().getNode(nodeId, authToken, account);

        if (getNodeResponse.isRequestSucceed()) {
            retVal = getNodeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getNodeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public StatefulNodeGetStatusResponse getNodeStatus(String nodeId) {
        StatefulNodeGetStatusResponse retVal;

        RepoGenericResponse<StatefulNodeGetStatusResponse> getNodeStatusResponse =
                getSpotAzureStatefulNodeRepo().getNodeStatus(nodeId, authToken, account);

        if (getNodeStatusResponse.isRequestSucceed()) {
            retVal = getNodeStatusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getNodeStatusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get Azure stateful Node Status. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public StatefulNode updateNode(StatefulNodeCreationRequest statefulNodeUpdateRequest, String nodeId) {
        StatefulNode retVal;

        StatefulNode statefulNodeToUpdate = statefulNodeUpdateRequest.getNode();

        RepoGenericResponse<StatefulNode> updateNodeResponse =
                getSpotAzureStatefulNodeRepo().updateNode(statefulNodeToUpdate, nodeId, authToken, account);

        if (updateNodeResponse.isRequestSucceed()) {
            retVal = updateNodeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateNodeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to update Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean deleteNode(StatefulNodeDeletionRequest deletionRequest, String nodeId) {

        Boolean retVal;

        StatefulNodeDeallocationConfig statefulDeallocationConfig = deletionRequest.getDeallocationConfig();
        RepoGenericResponse<Boolean> deleteNodeResponse =
                getSpotAzureStatefulNodeRepo().deleteNode(statefulDeallocationConfig ,nodeId, authToken, account);

        if (deleteNodeResponse.isRequestSucceed()) {
            retVal = deleteNodeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteNodeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to delete Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<StatefulNode> getAllNodes() {

        List<StatefulNode> retVal;

        RepoGenericResponse<List<StatefulNode>> getAllNodesResponse =
                getSpotAzureStatefulNodeRepo().getAllNodes(authToken, account);

        if (getAllNodesResponse.isRequestSucceed()) {
            retVal = getAllNodesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllNodesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get All Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateStatefulNodeState(StatefulNodeStateChangeRequest updateStatefulNodeStateRequest, String nodeId) {

        Boolean retVal;

        RepoGenericResponse<Boolean> updateNodeStateResponse =
                getSpotAzureStatefulNodeRepo().updateNodeState(updateStatefulNodeStateRequest , nodeId, authToken, account);

        if (updateNodeStateResponse.isRequestSucceed()) {
            retVal = updateNodeStateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateNodeStateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to change state of Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public ImportConfiguration importNode(StatefulNodeImportRequest nodeImportRequest) {
        ImportConfiguration retVal;

        ImportConfiguration statefulNodeToImport = nodeImportRequest.getImportNode();

        RepoGenericResponse<ImportConfiguration> importResponse =
                getSpotAzureStatefulNodeRepo().importNode(statefulNodeToImport, authToken, account);

        if (importResponse.isRequestSucceed()) {
            retVal = importResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = importResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to import Vm from Azure to create stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public NodeImportStatusResponse getNodeImportStatus(String importId) {
        NodeImportStatusResponse retVal;

        RepoGenericResponse<NodeImportStatusResponse> getNodeImportStatusResponse =
                getSpotAzureStatefulNodeRepo().getNodeImportStatus(importId, authToken, account);

        if (getNodeImportStatusResponse.isRequestSucceed()) {
            retVal = getNodeImportStatusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getNodeImportStatusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get Azure stateful Node Import Status. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }


    public StatefulNode getImportVmConfiguration(String nodeId, String resourceGroup) {
        StatefulNode retVal;

        RepoGenericResponse<StatefulNode> getNodeResponse =
                getSpotAzureStatefulNodeRepo().getImportVmConfiguration(nodeId, resourceGroup, authToken, account);

        if (getNodeResponse.isRequestSucceed()) {
            retVal = getNodeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getNodeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get Configuration of the VM. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }


    public List<StatefulNodeLogsResponse> getStatefulNodeLogs(StatefulNodeGetLogsRequest nodeLogsRequest, String nodeId) {

        List<StatefulNodeLogsResponse> getLogs;

        RepoGenericResponse <List<StatefulNodeLogsResponse>> getLogsResponse =
                getSpotAzureStatefulNodeRepo().getStatefulNodeLogs(nodeLogsRequest, nodeId, authToken);

        if(getLogsResponse.isRequestSucceed()){
            getLogs =getLogsResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getLogsResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get the Node Logs. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getLogs;

    }

    public StatefulNodeResourceResponse getStatefulNodeResources(String nodeId) {

        StatefulNodeResourceResponse getResources;

        RepoGenericResponse <StatefulNodeResourceResponse> getResourceResponse =
                getSpotAzureStatefulNodeRepo().getNodeResources(nodeId, authToken, account);

        if(getResourceResponse.isRequestSucceed()){
            getResources =getResourceResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResourceResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get the Node Resources. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getResources;

    }

    public List<StatefulNodeGetStatusResponse> getAllNodeStatus() {

        List<StatefulNodeGetStatusResponse> retVal;

        RepoGenericResponse<List<StatefulNodeGetStatusResponse>> getAllNodeStatusResponse =
                getSpotAzureStatefulNodeRepo().getAllNodeStatus(authToken, account);

        if (getAllNodeStatusResponse.isRequestSucceed()) {
            retVal = getAllNodeStatusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllNodeStatusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get All Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public StatefulNodeAttachDataDiskResponse attachDataDisk(StatefulNodeAttachDataDiskRequest attachDataDiskRequest, String nodeId) {
        StatefulNodeAttachDataDiskResponse retVal;

        StatefulNodeAttachDataDiskConfiguration diskToAttach = attachDataDiskRequest.getAttachDataDisk();
        RepoGenericResponse<StatefulNodeAttachDataDiskResponse> attachDiskResponse =
                getSpotAzureStatefulNodeRepo().attachDataDisk(diskToAttach, nodeId, authToken, account);

        if (attachDiskResponse.isRequestSucceed()) {
            retVal = attachDiskResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = attachDiskResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to attach the data disk to Azure Stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean detachDataDisk(StatefulNodeDetachDataDiskRequest detachDataDiskRequest, String nodeId) {
        Boolean retVal;

        StatefulNodeDetachDataDiskConfiguration diskToDetach = detachDataDiskRequest.getDetachDataDisk();
        RepoGenericResponse<Boolean> detachDiskResponse =
                getSpotAzureStatefulNodeRepo().detachDataDisk(diskToDetach , nodeId, authToken, account);

        if (detachDiskResponse.isRequestSucceed()) {
            retVal = detachDiskResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = detachDiskResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to detach the data disk from Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

}
