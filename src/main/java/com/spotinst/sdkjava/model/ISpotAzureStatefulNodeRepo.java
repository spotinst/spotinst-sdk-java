package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNode;

public interface ISpotAzureStatefulNodeRepo extends IRepository<StatefulNode, Void, String>{

    default RepoGenericResponse<StatefulNode> createNode(StatefulNode statefulNode, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<StatefulNode> getNode(String nodeId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }


}