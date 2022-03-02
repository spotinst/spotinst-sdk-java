package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPolicy {
    @JsonIgnore
    private Set<String> isSet;
    private String      policyId;
    private String      policyName;
    private String      policyType;
    private List<String>  userGroupIds;
    private List<String>  accountIds;

    public UserPolicy() {
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

    public List<String> getUserGroupIds() {
        return userGroupIds;
    }

    public void setUserGroupIds(List<String> userGroupIds) {
        isSet.add("userGroupIds");
        this.userGroupIds = userGroupIds;
    }

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        isSet.add("accountIds");
        this.accountIds = accountIds;
    }

    public static class Builder {
        private UserPolicy userPolicy;

        private Builder() {
            this.userPolicy = new UserPolicy();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPolicyId(final String policyId) {
            userPolicy.setPolicyId(policyId);
            return this;
        }

        public Builder setPolicyName(final String policyName) {
            userPolicy.setPolicyName(policyName);
            return this;
        }

        public Builder setPolicyType(final String policyType) {
            userPolicy.setPolicyType(policyType);
            return this;
        }

        public Builder setAccountIds(final List<String> accountIds) {
            userPolicy.setAccountIds(accountIds);
            return this;
        }

        public Builder setUserGroupIds(final List<String> userGroupIds) {
            userPolicy.setUserGroupIds(userGroupIds);
            return this;
        }

        public UserPolicy build() {
            return userPolicy;
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

    @JsonIgnore
    public boolean isUserGroupIdsSet() {
        return isSet.contains("userGroupIds");
    }

    @JsonIgnore
    public boolean isAccountIdsSet() {
        return isSet.contains("accountIds");
    }
}
