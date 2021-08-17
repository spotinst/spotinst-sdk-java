package com.spotinst.sdkjava.model.requests.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.aws.managed.instance.ApiManagedInstance;
import com.spotinst.sdkjava.model.bl.aws.managed.instance.ManagedInstance;
import com.spotinst.sdkjava.model.converters.aws.managed.instance.AwsManagedInstanceConverter;

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

    //region Builder class
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
    //endregion

    //region Json methods
    public String toJson() {
        ApiManagedInstance apiManagedInstanceToCreate = AwsManagedInstanceConverter.toDal(managedInstance);

        Map<String, ApiManagedInstance> managedInstanceRequest = new HashMap<>();
        managedInstanceRequest.put("managedInstance", apiManagedInstanceToCreate);
        String managedInstanceJson = JsonMapper.toJson(managedInstanceRequest);

        return managedInstanceJson;
    }
    //endregion
}
