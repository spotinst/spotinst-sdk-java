package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNode;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNodeDeallocationConfig;

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


}