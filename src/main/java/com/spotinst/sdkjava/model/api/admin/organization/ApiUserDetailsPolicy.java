package com.spotinst.sdkjava.model.api.admin.organization;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiUserDetailsPolicy implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      policyId;
    private String      policyName;
    private String      policyType;
    private List<String>  userGroupIds;
    private List<String>  accountIds;

    public ApiUserDetailsPolicy() {
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
