package com.spotinst.sdkjava.model.requests.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.aws.managedInstance.ApiManagedInstance;
import com.spotinst.sdkjava.model.api.aws.managedInstance.ApiManagedInstanceUpdate;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.ManagedInstance;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.ManagedInstanceUpdate;
import com.spotinst.sdkjava.model.converters.aws.managedInstance.AwsManagedInstanceConverter;

import java.util.HashMap;
import java.util.Map;

public class AwsManagedInstanceUpdateRequest {
    @JsonProperty("managedInstanceUpdate")
    private ManagedInstanceUpdate managedInstanceUpdate;

    private AwsManagedInstanceUpdateRequest() {
    }

    public ManagedInstanceUpdate getManagedInstanceUpdate() {
        return managedInstanceUpdate;
    }

    public void setManagedInstanceUpdate(ManagedInstanceUpdate managedInstanceUpdate) {
        this.managedInstanceUpdate = managedInstanceUpdate;
    }

    public static class Builder {
        private AwsManagedInstanceUpdateRequest managedInstanceUpdateRequest;

        private Builder() {
            this.managedInstanceUpdateRequest = new AwsManagedInstanceUpdateRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setManagedInstanceUpdate(final ManagedInstanceUpdate managedInstanceUpdate) {
            managedInstanceUpdateRequest.setManagedInstanceUpdate(managedInstanceUpdate);
            return this;
        }

        public AwsManagedInstanceUpdateRequest build() {
            return managedInstanceUpdateRequest;
        }

    }

    public String toJson() {
        ApiManagedInstanceUpdate apiManagedInstanceUpdate = AwsManagedInstanceConverter.toDal(managedInstanceUpdate);

        Map<String, ApiManagedInstanceUpdate> managedInstanceUpdateRequest = new HashMap<>();
        managedInstanceUpdateRequest.put("managedInstanceUpdate", apiManagedInstanceUpdate);

        return JsonMapper.toJson(managedInstanceUpdateRequest);
    }
}
