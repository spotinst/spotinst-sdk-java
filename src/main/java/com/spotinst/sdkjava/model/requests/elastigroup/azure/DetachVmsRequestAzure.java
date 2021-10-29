package com.spotinst.sdkjava.model.requests.elastigroup.azure;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiDetachVmsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.DetachVmsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;

public class DetachVmsRequestAzure {

    private String          groupId;
    private DetachVmsAzure  detachVms;

    private DetachVmsRequestAzure() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public DetachVmsAzure getDetachVms() {
        return detachVms;
    }

    public void setDetachVms(DetachVmsAzure detachVms) {
        this.detachVms = detachVms;
    }

    public static class Builder {
        private DetachVmsRequestAzure detachVmsRequestAzure;

        private Builder() {
            this.detachVmsRequestAzure = new DetachVmsRequestAzure();
        }

        public static DetachVmsRequestAzure.Builder get() {
            DetachVmsRequestAzure.Builder builder = new DetachVmsRequestAzure.Builder();
            return builder;
        }

        public Builder setGroupId(final String groupId) {
            detachVmsRequestAzure.setGroupId(groupId);
            return this;
        }

        public Builder setDetachVms(final DetachVmsAzure detachVms) {
            detachVmsRequestAzure.setDetachVms(detachVms);
            return this;
        }

        public DetachVmsRequestAzure build() {
            return detachVmsRequestAzure;
        }

    }

    public String toJson() {
        ApiDetachVmsAzure apiDetachVms = ElastigroupConverterAzure.toDal(detachVms);
        String elastigroupJson = JsonMapper.toJson(apiDetachVms);

        return elastigroupJson;
    }
}
