package com.spotinst.sdkjava.model.requests.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.aws.managedInstance.ApiManagedInstance;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.ManagedInstance;
import com.spotinst.sdkjava.model.converters.aws.managedInstance.AwsManagedInstanceConverter;

import java.util.HashMap;
import java.util.Map;

public class AwsManagedInstanceRequest {
    @JsonProperty("managedInstance")
    private ManagedInstance     managedInstance;
    private String              managedInstanceId;

    private AwsManagedInstanceRequest() {
    }

    public ManagedInstance getManagedInstance() {
        return managedInstance;
    }

    public void setManagedInstance(ManagedInstance managedInstance) {
        this.managedInstance = managedInstance;
    }

    public String getManagedInstanceId() {
        return managedInstanceId;
    }

    public void setManagedInstanceId(String managedInstanceId) {
        this.managedInstanceId = managedInstanceId;
    }

    public static class Builder {
        private AwsManagedInstanceRequest managedInstanceRequest;

        private Builder() {
            this.managedInstanceRequest = new AwsManagedInstanceRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setManagedInstance(final ManagedInstance managedInstance) {
            managedInstanceRequest.setManagedInstance(managedInstance);
            return this;
        }

        public Builder setManagedInstanceId(final String managedInstanceId) {
            managedInstanceRequest.setManagedInstanceId(managedInstanceId);
            return this;
        }

        public AwsManagedInstanceRequest build() {
            return managedInstanceRequest;
        }

    }

    public String toJson() {
        ApiManagedInstance apiManagedInstance = AwsManagedInstanceConverter.toDal(managedInstance);

        Map<String, ApiManagedInstance> managedInstanceRequest = new HashMap<>();
        managedInstanceRequest.put("managedInstance", apiManagedInstance);
        String managedInstanceJson = JsonMapper.toJson(managedInstanceRequest);

        return managedInstanceJson;
    }
}
