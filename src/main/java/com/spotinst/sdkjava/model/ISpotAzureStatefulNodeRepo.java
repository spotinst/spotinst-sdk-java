package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.*;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeAttachDataDiskRequest;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeDetachDataDiskRequest;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeGetLogsRequest;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeStateChangeRequest;

import java.util.List;

public interface ISpotAzureStatefulNodeRepo extends IRepository<StatefulNode, Void, String>{

    default RepoGenericResponse<StatefulNode> createNode(StatefulNode statefulNode, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<StatefulNode> getNode(String nodeId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<StatefulNode> updateNode(StatefulNode statefulNodeToUpdate, String nodeId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> deleteNode(StatefulNodeDeallocationConfig statefulNodeDeallocationConfig, String nodeId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<List<StatefulNode>> getAllNodes(String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> updateNodeState(StatefulNodeStateChangeRequest statefulNodeStateChangeRequest, String nodeId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<StatefulNodeGetStatusResponse> getNodeStatus(String nodeId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<ImportConfiguration> importNode(ImportConfiguration node, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<NodeImportStatusResponse> getNodeImportStatus(String importId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<StatefulNode> getImportVmConfiguration(String vmName, String resourceGroup, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<List<StatefulNodeLogsResponse>> getStatefulNodeLogs(StatefulNodeGetLogsRequest nodeGetLogsRequest, String nodeId, String authToken){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<StatefulNodeResourceResponse> getNodeResources(String importId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<List<StatefulNodeGetStatusResponse>> getAllNodeStatus(String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<StatefulNodeAttachDataDiskResponse> attachDataDisk(StatefulNodeAttachDataDiskConfiguration attachDataDisk, String nodeId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> detachDataDisk(StatefulNodeDetachDataDiskConfiguration detachDataDisk, String nodeId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

}