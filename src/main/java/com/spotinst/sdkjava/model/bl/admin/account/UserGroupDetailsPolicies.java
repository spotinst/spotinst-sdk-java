package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupDetailsPolicies {
    @JsonIgnore
    private Set<String> isSet;
    private String      policyId;
    private String      policyName;
    private String      policyType;

    public UserGroupDetailsPolicies() {
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

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        isSet.add("policyName");
        this.policyName = policyName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        isSet.add("policyType");
        this.policyType = policyType;
    }

    public static class Builder {
        private UserGroupDetailsPolicies policies;

        private Builder() {
            this.policies = new UserGroupDetailsPolicies();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPolicyId(final String policyId) {
            policies.setPolicyId(policyId);
            return this;
        }

        public Builder setPolicyName(final String policyName) {
            policies.setPolicyName(policyName);
            return this;
        }

        public Builder setPolicyType(final String policyType) {
            policies.setPolicyType(policyType);
            return this;
        }

        public UserGroupDetailsPolicies build() {
            return policies;
        }
    }

    @JsonIgnore
    public boolean isPolicyIdSet() {
        return isSet.contains("policyId");
    }

    @JsonIgnore
    public boolean isPolicyNameSet() {
        return isSet.contains("policyName");
    }

    @JsonIgnore
    public boolean isPolicyTypeSet() {
        return isSet.contains("policyType");
    }
}
