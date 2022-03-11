package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyMapping {
    @JsonIgnore
    private Set<String>  isSet;
    private String       policyId;
    private List<String> accountIds;

    public PolicyMapping() {
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

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        isSet.add("accountIds");
        this.accountIds = accountIds;
    }

    public static class Builder {
        private PolicyMapping policy;

        private Builder() {
            this.policy = new PolicyMapping();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPolicyId(final String policyId) {
            policy.setPolicyId(policyId);
            return this;
        }

        public Builder setAccountIds(final List<String> accountIds) {
            policy.setAccountIds(accountIds);
            return this;
        }
        public PolicyMapping build() {
            return policy;
        }
    }

    @JsonIgnore
    public boolean isPolicyIdSet() {
        return isSet.contains("policyId");
    }

    @JsonIgnore
    public boolean isAccountIdsSet() {
        return isSet.contains("accountIds");
    }
}