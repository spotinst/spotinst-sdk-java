package com.spotinst.sdkjava.model.requests.elastigroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiElastigroupUpdateCapacityAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupUpdateCapacityAzure;

import java.util.HashMap;
import java.util.Map;

public class ElastigroupUpdateCapacityRequestAzure {

    private String groupId;
    @JsonProperty("capacity")
    private ElastigroupUpdateCapacityAzure capacityAzure;

    private ElastigroupUpdateCapacityRequestAzure() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ElastigroupUpdateCapacityAzure getCapacityAzure() {
        return capacityAzure;
    }

    public void setCapacityAzure(ElastigroupUpdateCapacityAzure capacityAzure) {
        this.capacityAzure = capacityAzure;
    }

    public static class Builder {
        private ElastigroupUpdateCapacityRequestAzure groupUpdateCapacity;

        private Builder() {
            this.groupUpdateCapacity = new ElastigroupUpdateCapacityRequestAzure();
        }

        public static ElastigroupUpdateCapacityRequestAzure.Builder get() {
            ElastigroupUpdateCapacityRequestAzure.Builder builder = new ElastigroupUpdateCapacityRequestAzure.Builder();
            return builder;
        }

        public Builder setCapacityAzure(final ElastigroupUpdateCapacityAzure capacityAzure) {
            groupUpdateCapacity.setCapacityAzure(capacityAzure);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            groupUpdateCapacity.setGroupId(groupId);
            return this;
        }

        public ElastigroupUpdateCapacityRequestAzure build() {
            return groupUpdateCapacity;
        }

    }

    public String toJson() {
        ApiElastigroupUpdateCapacityAzure apiCapacity = ElastigroupConverterAzure.toDal(capacityAzure);
        Map<String, ApiElastigroupUpdateCapacityAzure> capacityRequest = new HashMap<>();
        capacityRequest.put("capacity", apiCapacity);
        String elastigroupJson = JsonMapper.toJson(capacityRequest);

        return elastigroupJson;
    }
}