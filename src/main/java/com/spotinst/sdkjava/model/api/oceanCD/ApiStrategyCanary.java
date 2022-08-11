package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiStrategyCanary implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private ApiCanaryBackgroundVerification backgroundVerification;
    private List<ApiCanarySteps>                         steps;

    public ApiStrategyCanary() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiCanaryBackgroundVerification getBackgroundVerification() {
        return backgroundVerification;
    }

    public void setBackgroundVerification(ApiCanaryBackgroundVerification backgroundVerification) {
        isSet.add("backgroundVerification");
        this.backgroundVerification = backgroundVerification;
    }

    public List<ApiCanarySteps> getSteps() {
        return steps;
    }

    public void setSteps(List<ApiCanarySteps> steps) {
        isSet.add("steps");
        this.steps = steps;
    }

    public static class Builder {
        private ApiStrategyCanary strategyCanary;

        private Builder() {
            this.strategyCanary = new ApiStrategyCanary();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBackgroundVerification(final ApiCanaryBackgroundVerification backgroundVerification) {
            strategyCanary.setBackgroundVerification(backgroundVerification);
            return this;
        }

        public Builder setSteps(final List<ApiCanarySteps> steps) {
            strategyCanary.setSteps(steps);
            return this;
        }

        public ApiStrategyCanary build() {
            return strategyCanary;
        }
    }

    @JsonIgnore
    public boolean isBackgroundVerificationSet() {
        return isSet.contains("backgroundVerification");
    }

    @JsonIgnore
    public boolean isStepsSet() {
        return isSet.contains("steps");
    }
}