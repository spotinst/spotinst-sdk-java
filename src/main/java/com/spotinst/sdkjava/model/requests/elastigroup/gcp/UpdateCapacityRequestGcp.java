package com.spotinst.sdkjava.model.requests.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.gcp.ApiUpdateCapacityGcp;
import com.spotinst.sdkjava.model.bl.gcp.UpdateCapacityGcp;
import com.spotinst.sdkjava.model.converters.elastigroup.gcp.ElastigroupConverterGcp;

import java.util.HashMap;
import java.util.Map;

public class UpdateCapacityRequestGcp {

    private String groupId;
    @JsonProperty("capacity")
    private UpdateCapacityGcp capacityGcp;

    private UpdateCapacityRequestGcp() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public UpdateCapacityGcp getCapacityGcp() {
        return capacityGcp;
    }

    public void setCapacityGcp(UpdateCapacityGcp capacityGcp) {
        this.capacityGcp = capacityGcp;
    }

    public static class Builder {
        private UpdateCapacityRequestGcp groupUpdateCapacity;

        private Builder() {
            this.groupUpdateCapacity = new UpdateCapacityRequestGcp();
        }

        public static UpdateCapacityRequestGcp.Builder get() {
            UpdateCapacityRequestGcp.Builder builder = new UpdateCapacityRequestGcp.Builder();
            return builder;
        }

        public Builder setCapacityGcp(final UpdateCapacityGcp capacityGcp) {
            groupUpdateCapacity.setCapacityGcp(capacityGcp);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            groupUpdateCapacity.setGroupId(groupId);
            return this;
        }

        public UpdateCapacityRequestGcp build() {
            return groupUpdateCapacity;
        }

    }

    public String toJson() {
        ApiUpdateCapacityGcp apiCapacity = ElastigroupConverterGcp.toDal(capacityGcp);
        Map<String, ApiUpdateCapacityGcp> capacityRequest = new HashMap<>();
        capacityRequest.put("capacity", apiCapacity);
        String elastigroupJson = JsonMapper.toJson(capacityRequest);
        return elastigroupJson;
    }
}
