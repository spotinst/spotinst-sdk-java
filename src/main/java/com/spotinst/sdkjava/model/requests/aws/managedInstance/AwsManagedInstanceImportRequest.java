package com.spotinst.sdkjava.model.requests.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.aws.managedInstance.ApiImport;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.Import;
import com.spotinst.sdkjava.model.converters.aws.managedInstance.AwsManagedInstanceConverter;

import java.util.HashMap;
import java.util.Map;

public class AwsManagedInstanceImportRequest {

    @JsonProperty("migration")
    private Import     importInstance;

    private AwsManagedInstanceImportRequest() {
    }

    public Import getImportInstance() { return importInstance; }

    public void setImportInstance(Import importInstance) { this.importInstance = importInstance; }


    public static class Builder {
        private AwsManagedInstanceImportRequest awsManagedInstanceImportRequest;

        private Builder() {
            this.awsManagedInstanceImportRequest = new AwsManagedInstanceImportRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setImportInstance(final Import importInstance) {
            awsManagedInstanceImportRequest.setImportInstance(importInstance);
            return this;
        }

        public AwsManagedInstanceImportRequest build() {
            return awsManagedInstanceImportRequest;
        }

    }

    public String toJson() {
        ApiImport apiImport = AwsManagedInstanceConverter.toDal(importInstance);

        Map<String, ApiImport> managedInstanceRequest = new HashMap<>();
        managedInstanceRequest.put("migration", apiImport);

        return JsonMapper.toJson(managedInstanceRequest);
    }
}
