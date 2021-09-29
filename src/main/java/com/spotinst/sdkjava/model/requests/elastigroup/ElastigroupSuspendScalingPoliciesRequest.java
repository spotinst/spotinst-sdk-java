package com.spotinst.sdkjava.model.requests.elastigroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.elastigroup.ApiScalingPolicySuspension;
import com.spotinst.sdkjava.model.bl.elastigroup.ScalingPolicySuspension;
import com.spotinst.sdkjava.model.converters.elastigroup.ScalingPoliciesSuspensionConverter;

import java.util.HashMap;
import java.util.Map;

public class ElastigroupSuspendScalingPoliciesRequest {
    @JsonProperty("suspension")
    private ScalingPolicySuspension suspension;
    private String                  groupId;
    private String                  policyName;

    private ElastigroupSuspendScalingPoliciesRequest() {
    }

    public ScalingPolicySuspension getSuspension() {
        return suspension;
    }

    public void setSuspension(ScalingPolicySuspension suspension) {
        this.suspension = suspension;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public static class Builder {
        private ElastigroupSuspendScalingPoliciesRequest elastigroupSuspendScalingPoliciesRequest;

        private Builder() {
            this.elastigroupSuspendScalingPoliciesRequest = new ElastigroupSuspendScalingPoliciesRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setSuspension(final ScalingPolicySuspension suspension) {
            elastigroupSuspendScalingPoliciesRequest.setSuspension(suspension);
            return this;
        }

        public Builder setGroupId(final String groupId){
            elastigroupSuspendScalingPoliciesRequest.setGroupId(groupId);
            return this;
        }

        public Builder setPolicyName(final String policyName){
            elastigroupSuspendScalingPoliciesRequest.setPolicyName(policyName);
            return this;
        }

        public ElastigroupSuspendScalingPoliciesRequest build() {
            return elastigroupSuspendScalingPoliciesRequest;
        }
    }
}