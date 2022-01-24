package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupMappedPolicies {
    @JsonIgnore
    private Set<String> isSet;
    private String      policyId;

    public UserGroupMappedPolicies() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        isSet.add("policyId");
        this.policyId = policyId;
    }

    public static class Builder {
        private UserGroupMappedPolicies policies;

        private Builder() {
            this.policies = new UserGroupMappedPolicies();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPolicyId(final String policyId) {
            policies.setPolicyId(policyId);
            return this;
        }

        public UserGroupMappedPolicies build() {
            return policies;
        }
    }

    @JsonIgnore
    public boolean isPolicyIdSet() {
            return isSet.contains("policyId");
        }
}
