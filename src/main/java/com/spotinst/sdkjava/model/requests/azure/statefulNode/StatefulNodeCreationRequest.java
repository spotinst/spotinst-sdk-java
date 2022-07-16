package com.spotinst.sdkjava.model.requests.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNode;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNode;
import com.spotinst.sdkjava.model.converters.azure.statefulNode.StatefulNodeConverter;

import java.util.HashMap;
import java.util.Map;

public class StatefulNodeCreationRequest {

    @JsonProperty("statefulNode")
    private StatefulNode node;
    private String       nodeId;

    private StatefulNodeCreationRequest(){

    }

    public StatefulNode getNode() {
        return node;
    }

    public void setNode(StatefulNode node) {
        this.node = node;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    //region Builder class
    public static class Builder {
        private StatefulNodeCreationRequest nodeRequest;

        private Builder() {
            this.nodeRequest = new StatefulNodeCreationRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setNode(final StatefulNode statefulNode) {
            nodeRequest.setNode(statefulNode);
            return this;
        }

        public Builder setNodeId(final String nodeId) {
            nodeRequest.setNodeId(nodeId);
            return this;
        }

        public StatefulNodeCreationRequest build() {
            return nodeRequest;
        }

    }
    //endregion
    //region Json methods
    public String toJson() {
        ApiStatefulNode              apiStatefulNodeToCreate = StatefulNodeConverter.toDal(node);
        Map<String, ApiStatefulNode> nodeRequest             = new HashMap<>();
        nodeRequest.put("statefulNode", apiStatefulNodeToCreate);

        return JsonMapper.toJson(nodeRequest);
    }
    //endregion
}