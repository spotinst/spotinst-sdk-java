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

// Same object class to be used for both user or group policy update
public class ApiUpdatePoliciesRequest implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>            isSet;
    private List<ApiPolicyMapping> policies;

    public ApiUpdatePoliciesRequest() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiPolicyMapping> getPolicies() {
        return policies;
    }

    public void setPolicies(List<ApiPolicyMapping> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    @JsonIgnore
    public boolean isPoliciesSet() {
        return isSet.contains("policies");
    }
}
