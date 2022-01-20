package com.spotinst.sdkjava.model.api.admin.account;

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
public class ApiUserDirectPolicies implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>  isSet;
    private String       policyId;
    private List<String> accountIds;

    public ApiUserDirectPolicies() {
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

    @JsonIgnore
    public boolean isPolicyIdSet() {
        return isSet.contains("policyId");
    }

    @JsonIgnore
    public boolean isAccountIdsSet() {
        return isSet.contains("accountIds");
    }
}