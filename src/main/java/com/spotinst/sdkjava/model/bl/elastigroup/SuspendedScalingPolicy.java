package com.spotinst.sdkjava.model.bl.elastigroup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuspendedScalingPolicy {
    @JsonIgnore
    private Set<String> isSet;
    private String      groupId;
    private String      policyName;
    private String      State;
    private Date        expiresAt;

    private SuspendedScalingPolicy() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        isSet.add("groupId");
        this.groupId = groupId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        isSet.add("policyName");
        this.policyName = policyName;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        isSet.add("state");
        State = state;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        isSet.add("expiresAt");
        this.expiresAt = expiresAt;
    }

    public static class Builder {

        private SuspendedScalingPolicy suspendedScalingPolicy;

        private Builder() {
            this.suspendedScalingPolicy = new SuspendedScalingPolicy();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setGroupId(final String groupId) {
            suspendedScalingPolicy.setGroupId(groupId);
            return this;
        }

        public Builder setPolicyName(final String policyName) {
            suspendedScalingPolicy.setPolicyName(policyName);
            return this;
        }

        public Builder setState(final String state) {
            suspendedScalingPolicy.setState(state);
            return this;
        }

        public Builder setExpiresAt(final Date expiresAt) {
            suspendedScalingPolicy.setExpiresAt(expiresAt);
            return this;
        }

        public SuspendedScalingPolicy build() {
            return suspendedScalingPolicy;
        }
    }

    @JsonIgnore
    public boolean isGroupIdSet() {
        return isSet.contains("groupId");
    }

    @JsonIgnore
    public boolean isPolicyNameSet() {
        return isSet.contains("policyName");
    }

    @JsonIgnore
    public boolean isExpiresAtSet() {
        return isSet.contains("expiresAt");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }
}
