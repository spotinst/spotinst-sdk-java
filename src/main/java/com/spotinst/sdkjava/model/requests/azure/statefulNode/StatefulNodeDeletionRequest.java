package com.spotinst.sdkjava.model.requests.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNodeDeallocationConfig;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNodeDeallocationConfig;
import com.spotinst.sdkjava.model.converters.azure.statefulNode.StatefulNodeConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatefulNodeDeletionRequest {

    @JsonProperty("deallocationConfig")
    private Set<String>                    isSet;
    private StatefulNodeDeallocationConfig deallocationConfig;

    private StatefulNodeDeletionRequest(){

    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public StatefulNodeDeallocationConfig getDeallocationConfig() {
        return deallocationConfig;
    }

    public void setDeallocationConfig(StatefulNodeDeallocationConfig deallocationConfig) {
        this.deallocationConfig = deallocationConfig;
    }

    //region Builder class
    public static class Builder {
        private StatefulNodeDeletionRequest nodeDeletionRequest;

        private Builder() {
            this.nodeDeletionRequest = new StatefulNodeDeletionRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDeallocationConfig(final StatefulNodeDeallocationConfig deallocationConfig) {
            nodeDeletionRequest.setDeallocationConfig(deallocationConfig);
            return this;
        }


        public StatefulNodeDeletionRequest build() {
            return nodeDeletionRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiStatefulNodeDeallocationConfig apiStatefulNodeToCreate = StatefulNodeConverter.toDal(deallocationConfig);
        Map<String, ApiStatefulNodeDeallocationConfig>      nodeRequest             = new HashMap<>();
        nodeRequest.put("deallocationConfig", apiStatefulNodeToCreate);
        String NodeJson = JsonMapper.toJson(nodeRequest);

        return NodeJson;
    }
    //endregion

}
