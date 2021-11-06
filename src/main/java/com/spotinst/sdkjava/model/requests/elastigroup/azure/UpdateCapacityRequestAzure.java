package com.spotinst.sdkjava.model.requests.elastigroup.azure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiUpdateCapacityAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.UpdateCapacityAzure;

import java.util.HashMap;
import java.util.Map;

public class UpdateCapacityRequestAzure {

    private String groupId;
    @JsonProperty("capacity")
    private UpdateCapacityAzure capacityAzure;

    private UpdateCapacityRequestAzure() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public UpdateCapacityAzure getCapacityAzure() {
        return capacityAzure;
    }

    public void setCapacityAzure(UpdateCapacityAzure capacityAzure) {
        this.capacityAzure = capacityAzure;
    }

    public static class Builder {
        private UpdateCapacityRequestAzure groupUpdateCapacity;

        private Builder() {
            this.groupUpdateCapacity = new UpdateCapacityRequestAzure();
        }

        public static UpdateCapacityRequestAzure.Builder get() {
            UpdateCapacityRequestAzure.Builder builder = new UpdateCapacityRequestAzure.Builder();
            return builder;
        }

        public Builder setCapacityAzure(final UpdateCapacityAzure capacityAzure) {
            groupUpdateCapacity.setCapacityAzure(capacityAzure);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            groupUpdateCapacity.setGroupId(groupId);
            return this;
        }

        public UpdateCapacityRequestAzure build() {
            return groupUpdateCapacity;
        }

    }

    public String toJson() {
        ApiUpdateCapacityAzure apiCapacity = ElastigroupConverterAzure.toDal(capacityAzure);
        Map<String, ApiUpdateCapacityAzure> capacityRequest = new HashMap<>();
        capacityRequest.put("capacity", apiCapacity);
        String elastigroupJson = JsonMapper.toJson(capacityRequest);
        return elastigroupJson;
    }
}
