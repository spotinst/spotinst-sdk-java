package com.spotinst.sdkjava.model.requests.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiImportConfiguration;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.ImportConfiguration;
import com.spotinst.sdkjava.model.converters.azure.statefulNode.StatefulNodeConverter;

import java.util.HashMap;
import java.util.Map;

public class StatefulNodeImportRequest {

    @JsonProperty("statefulNodeImport")
    private ImportConfiguration importNode;

    private StatefulNodeImportRequest(){

    }

    public ImportConfiguration getImportNode() {
        return importNode;
    }

    public void setImportNode(ImportConfiguration importNode) {
        this.importNode = importNode;
    }

    public static class Builder {
        private StatefulNodeImportRequest importNodeRequest;

        private Builder() {
            this.importNodeRequest = new StatefulNodeImportRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setImportNode(final ImportConfiguration importNode) {
            importNodeRequest.setImportNode(importNode);
            return this;
        }

        public StatefulNodeImportRequest build() {
            return importNodeRequest;
        }

    }

    public String toJson() {
        ApiImportConfiguration apiStatefulNodeToImport = StatefulNodeConverter.toDal(importNode);
        Map<String, ApiImportConfiguration> importNodeRequest             = new HashMap<>();
        importNodeRequest.put("statefulNodeImport", apiStatefulNodeToImport);
        String NodeJson = JsonMapper.toJson(importNodeRequest);

        return NodeJson;
    }
}
