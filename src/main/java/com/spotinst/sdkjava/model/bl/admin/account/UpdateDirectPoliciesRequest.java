package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateDirectPoliciesRequest {
    @JsonIgnore
    private Set<String>         isSet;
    private List<PolicyMapping> policies;

    public UpdateDirectPoliciesRequest() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<PolicyMapping> getPolicies() {
        return policies;
    }

    public void setPolicies(List<PolicyMapping> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    public static class Builder {
        private UpdateDirectPoliciesRequest policyRequest;

        private Builder() {
            this.policyRequest = new UpdateDirectPoliciesRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPolicies(final List<PolicyMapping> policies) {
            policyRequest.setPolicies(policies);
            return this;
        }

        public UpdateDirectPoliciesRequest build() {
            return policyRequest;
        }
    }

    @JsonIgnore
    public boolean isPoliciesSet() {
        return isSet.contains("policies");
    }
}
