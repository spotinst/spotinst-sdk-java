package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateUserDirectPoliciesRequest {
    @JsonIgnore
    private Set<String>              isSet;
    private List<UserDirectPolicies> policies;

    public UpdateUserDirectPoliciesRequest() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<UserDirectPolicies> getPolicies() {
        return policies;
    }

    public void setPolicies(List<UserDirectPolicies> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    public static class Builder {
        private UpdateUserDirectPoliciesRequest policyRequest;

        private Builder() {
            this.policyRequest = new UpdateUserDirectPoliciesRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPolicies(final List<UserDirectPolicies> policies) {
            policyRequest.setPolicies(policies);
            return this;
        }

        public UpdateUserDirectPoliciesRequest build() {
            return policyRequest;
        }
    }

    @JsonIgnore
    public boolean isPoliciesSet() {
        return isSet.contains("policies");
    }
}
