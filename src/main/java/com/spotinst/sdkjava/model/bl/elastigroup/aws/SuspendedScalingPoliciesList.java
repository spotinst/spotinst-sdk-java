package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuspendedScalingPoliciesList {
    @JsonIgnore
    private Set<String>                     isSet;
    private List<SuspendedScalingPolicy> scalePolicySuspensions;

    public SuspendedScalingPoliciesList() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<SuspendedScalingPolicy> getScalePolicySuspensions() {
        return scalePolicySuspensions;
    }

    public void setScalePolicySuspensions(List<SuspendedScalingPolicy> scalePolicySuspensions) {
        isSet.add("scalePolicySuspensions");
        this.scalePolicySuspensions = scalePolicySuspensions;
    }

    public static class Builder {

        private SuspendedScalingPoliciesList suspendedScalingPoliciesList;

        private Builder() {
            this.suspendedScalingPoliciesList = new SuspendedScalingPoliciesList();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setScalePolicySuspensions(final List<SuspendedScalingPolicy> policies) {
            suspendedScalingPoliciesList.setScalePolicySuspensions(policies);
            return this;
        }

        public SuspendedScalingPoliciesList build() {
            return suspendedScalingPoliciesList;
        }
    }

    @JsonIgnore
    public boolean isScalePolicySuspensionsSet() {
        return isSet.contains("scalePolicySuspensions");
    }
}
