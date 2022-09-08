package com.spotinst.sdkjava.model.repo.azure.statefulNode;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotAzureStatefulNodeRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.azure.statefulNode.*;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.*;
import com.spotinst.sdkjava.model.converters.azure.statefulNode.StatefulNodeConverter;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.*;
import com.spotinst.sdkjava.model.service.azure.statefulNode.SpotinstAzureStatefulNodeService;

import java.util.List;
import java.util.stream.Collectors;


public class SpotinstAzureStatefulNodeRepo implements ISpotAzureStatefulNodeRepo {

    @Override
    public RepoGenericResponse<StatefulNode> createNode(StatefulNode NodeToCreate, String authToken, String account) {

        RepoGenericResponse<StatefulNode> retVal;

        try {
            ApiStatefulNode apiStatefulNodeToCreate = StatefulNodeConverter.toDal(NodeToCreate);
            ApiStatefulNode apiCreatedNode          = SpotinstAzureStatefulNodeService
                    .createNode(apiStatefulNodeToCreate, authToken, account);

            StatefulNode createdStatefulNode = StatefulNodeConverter.toBl(apiCreatedNode);
            retVal = new RepoGenericResponse<>(createdStatefulNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<StatefulNode> getNode(String nodeId, String authToken, String account) {

        RepoGenericResponse<StatefulNode> retVal;

        try {
            ApiStatefulNode apiGetNode          = SpotinstAzureStatefulNodeService
                    .getNode(nodeId, authToken, account);

            StatefulNode getStatefulNode = StatefulNodeConverter.toBl(apiGetNode);
            retVal = new RepoGenericResponse<>(getStatefulNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<StatefulNodeGetStatusResponse> getNodeStatus(String nodeId, String authToken, String account) {

        RepoGenericResponse<StatefulNodeGetStatusResponse> retVal;

        try {
            ApiStatefulNodeGetStatusResponse apiGetNodeStatus  = SpotinstAzureStatefulNodeService
                    .getNodeStatus(nodeId, authToken, account);

            StatefulNodeGetStatusResponse getStatefulNodeStatus = StatefulNodeConverter.toBl(apiGetNodeStatus);
            retVal = new RepoGenericResponse<>(getStatefulNodeStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }


    @Override
    public RepoGenericResponse<StatefulNode> updateNode(StatefulNode NodeToUpdate ,String nodeId, String authToken, String account) {

        RepoGenericResponse<StatefulNode> retVal;

        try {
            ApiStatefulNode apiStatefulNodeToUpdate = StatefulNodeConverter.toDal(NodeToUpdate);
            ApiStatefulNode apiUpdatedNode =
                    SpotinstAzureStatefulNodeService.updateNode(apiStatefulNodeToUpdate, nodeId, authToken, account);

            StatefulNode updatedStatefulNode = StatefulNodeConverter.toBl(apiUpdatedNode);
            retVal = new RepoGenericResponse<>(updatedStatefulNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteNode(StatefulNodeDeallocationConfig NodeToDelete , String nodeId, String authToken, String account) {

        RepoGenericResponse<Boolean> retVal;

        try {
            ApiStatefulNodeDeallocationConfig apiStatefulNodeToDelete = StatefulNodeConverter.toDal(NodeToDelete);
            Boolean apiDeletedNode =
                    SpotinstAzureStatefulNodeService.deleteNode(apiStatefulNodeToDelete, nodeId, authToken, account);

            retVal = new RepoGenericResponse<>(apiDeletedNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<StatefulNode>> getAllNodes(String authToken, String account) {

        RepoGenericResponse<List<StatefulNode>> statefulNodesList;

        try {
            List<ApiStatefulNode> apiGetAllNodes =
                    SpotinstAzureStatefulNodeService.getAllNodes(authToken, account);
            List<StatefulNode> statefulNodes = apiGetAllNodes.stream().map(StatefulNodeConverter::toBl).collect(
                    Collectors.toList());
            statefulNodesList = new RepoGenericResponse<>(statefulNodes);
        }
        catch (SpotinstHttpException ex) {
            statefulNodesList = ExceptionHelper.handleHttpException(ex);
        }

        return statefulNodesList;

    }

    @Override
    public RepoGenericResponse<Boolean> updateNodeState(StatefulNodeStateChangeRequest updateStatefulNodeStateRequest , String nodeId, String authToken, String account) {

        RepoGenericResponse<Boolean> retVal;

        try {
            String                            state                                   = updateStatefulNodeStateRequest.getState().getName();
            ApiStatefulNodeStateChangeRequest
                                              updateApiStatefulNodeStateChangeRequest = new ApiStatefulNodeStateChangeRequest();
            updateApiStatefulNodeStateChangeRequest.setState(state);

            Boolean updateNodeState =
                    SpotinstAzureStatefulNodeService.updateNodeState(updateApiStatefulNodeStateChangeRequest, nodeId, authToken, account);

            retVal = new RepoGenericResponse<>(updateNodeState);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ImportConfiguration> importNode(ImportConfiguration nodeToImport, String authToken, String account) {

        RepoGenericResponse<ImportConfiguration> retVal;

        try {
            ApiImportConfiguration apiNodeToImport = StatefulNodeConverter.toDal(nodeToImport);
            ApiImportConfiguration apiCreatedNode          = SpotinstAzureStatefulNodeService
                    .importNode(apiNodeToImport, authToken, account);

            ImportConfiguration importedNode = StatefulNodeConverter.toBl(apiCreatedNode);
            retVal = new RepoGenericResponse<>(importedNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<NodeImportStatusResponse> getNodeImportStatus(String importId, String authToken, String account) {
        RepoGenericResponse<NodeImportStatusResponse> retVal;

        try {
            ApiNodeImportStatusResponse apiGetNodeStatus  = SpotinstAzureStatefulNodeService
                    .getNodeImportStatus(importId, authToken, account);

            NodeImportStatusResponse getStatefulNodeImportStatus = StatefulNodeConverter.toBl(apiGetNodeStatus);
            retVal = new RepoGenericResponse<>(getStatefulNodeImportStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<StatefulNode> getImportVmConfiguration(String vmName, String resouceGroup, String authToken, String account) {

        RepoGenericResponse<StatefulNode> retVal;

        try {
            ApiStatefulNode apiGetImportConfig          = SpotinstAzureStatefulNodeService
                    .getImportVmConfiguration(vmName, resouceGroup, authToken, account);

            StatefulNode getImportConfig = StatefulNodeConverter.toBl(apiGetImportConfig);
            retVal = new RepoGenericResponse<>(getImportConfig);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }


    @Override
    public RepoGenericResponse<List<StatefulNodeLogsResponse>> getStatefulNodeLogs(StatefulNodeGetLogsRequest nodeLogsRequest, String nodeId, String authToken) {
        RepoGenericResponse<List<StatefulNodeLogsResponse>> retVal;

        try {

            List<ApiStatefulNodeLogsResponse> getLogs = SpotinstAzureStatefulNodeService
                    .getStatefulNodeLogs(nodeLogsRequest, nodeId, authToken);
            List<StatefulNodeLogsResponse> getAllLogs = getLogs.stream().map(StatefulNodeConverter::toBl)
                    .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getAllLogs);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<StatefulNodeResourceResponse> getNodeResources(String nodeId, String authToken, String account) {
        RepoGenericResponse<StatefulNodeResourceResponse> retVal;

        try {

            ApiStatefulNodeResourceResponse getResource = SpotinstAzureStatefulNodeService
                    .getNodeResources(nodeId, authToken, account);
            StatefulNodeResourceResponse getNodeResources = StatefulNodeConverter.toBl(getResource);

            retVal = new RepoGenericResponse<>(getNodeResources);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<List<StatefulNodeGetStatusResponse>> getAllNodeStatus(String authToken, String account) {

        RepoGenericResponse<List<StatefulNodeGetStatusResponse>> nodeStatusList;

        try {
            List<ApiStatefulNodeGetStatusResponse> apiGetAllNodes =
                    SpotinstAzureStatefulNodeService.getAllNodeStatus(authToken, account);
            List<StatefulNodeGetStatusResponse> statefulNodes = apiGetAllNodes.stream().map(StatefulNodeConverter::toBl).collect(
                    Collectors.toList());
            nodeStatusList = new RepoGenericResponse<>(statefulNodes);
        }
        catch (SpotinstHttpException ex) {
            nodeStatusList = ExceptionHelper.handleHttpException(ex);
        }

        return nodeStatusList;

    }

    @Override
    public RepoGenericResponse<StatefulNodeAttachDataDiskResponse> attachDataDisk(StatefulNodeAttachDataDiskConfiguration attachDataDisk, String nodeId, String authToken, String account) {
        RepoGenericResponse<StatefulNodeAttachDataDiskResponse> retVal;

        try {
            ApiStatefulNodeAttachDataDiskConfiguration apiDiskToAttach = StatefulNodeConverter.toDal(attachDataDisk);
            ApiStatefulNodeAttachDataDiskResponse apiGetNodeStatus  = SpotinstAzureStatefulNodeService
                    .attachDataDisk(apiDiskToAttach, nodeId, authToken, account);

            StatefulNodeAttachDataDiskResponse attachDataDiskaResponse = StatefulNodeConverter.toBl(apiGetNodeStatus);
            retVal = new RepoGenericResponse<>(attachDataDiskaResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<Boolean> detachDataDisk(StatefulNodeDetachDataDiskConfiguration detachDataDisk, String nodeId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            ApiStatefulNodeDetachDataDiskConfiguration apiDiskToDetach = StatefulNodeConverter.toDal(detachDataDisk);
            Boolean apiDetachDiskResponse  = SpotinstAzureStatefulNodeService
                    .detachDataDisk(apiDiskToDetach, nodeId, authToken, account);

            retVal = new RepoGenericResponse<>(apiDetachDiskResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

}
