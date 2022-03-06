package com.spotinst.sdkjava.model.requests.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.aws.managedInstance.ApiAmiBackup;
import com.spotinst.sdkjava.model.api.aws.managedInstance.ApiDeallocationConfig;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.AmiBackup;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.DeallocationConfig;
import com.spotinst.sdkjava.model.converters.aws.managedInstance.AwsManagedInstanceConverter;
import java.util.HashMap;
import java.util.Map;

public class AwsManagedInstanceDeletionRequest {

    @JsonProperty("deallocationConfig")
    private DeallocationConfig deallocationConfig;
    @JsonProperty("amiBackup")
    private AmiBackup          amiBackup;
    private String             managedInstanceId;

    private AwsManagedInstanceDeletionRequest() {
    }

    public DeallocationConfig getDeallocationConfig() {
        return deallocationConfig;
    }

    public void setDeallocationConfig(DeallocationConfig deallocationConfig) {
        this.deallocationConfig = deallocationConfig;
    }

    public AmiBackup getAmiBackup() {
        return amiBackup;
    }

    public void setAmiBackup(AmiBackup amiBackup) {
        this.amiBackup = amiBackup;
    }

    public String getManagedInstanceId() {
        return managedInstanceId;
    }

    public void setManagedInstanceId(String managedInstanceId) {
        this.managedInstanceId = managedInstanceId;
    }

    //region Builder class
    public static class Builder {
        private AwsManagedInstanceDeletionRequest managedInstanceDeletionRequest;

        private Builder() {
            this.managedInstanceDeletionRequest = new AwsManagedInstanceDeletionRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDeallocationConfig(final DeallocationConfig deallocationConfig) {
            managedInstanceDeletionRequest.setDeallocationConfig(deallocationConfig);
            return this;
        }

        public Builder setAmiBackup(final AmiBackup amiBackup) {
            managedInstanceDeletionRequest.setAmiBackup(amiBackup);
            return this;
        }

        public Builder setManagedInstanceId(final String managedInstanceId) {
            managedInstanceDeletionRequest.setManagedInstanceId(managedInstanceId);
            return this;
        }

        public AwsManagedInstanceDeletionRequest build() {
            return managedInstanceDeletionRequest;
        }

    }

    public String toJson() {
        ApiDeallocationConfig apiDeallocationConfig = AwsManagedInstanceConverter.toDal(deallocationConfig);
        ApiAmiBackup apiAmiBackup                   = AwsManagedInstanceConverter.toDal(amiBackup);

        Map<String, Object> managedInstanceDeleteRequest = new HashMap<>();
        managedInstanceDeleteRequest.put("deallocationConfig", apiDeallocationConfig);
        managedInstanceDeleteRequest.put("amiBackup", apiAmiBackup);

        return JsonMapper.toJson(managedInstanceDeleteRequest);
    }
}
