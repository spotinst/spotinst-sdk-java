package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StrategyCanary {
    @JsonIgnore
    private Set<String>                               isSet;
    private CanaryBackgroundVerification              backgroundVerification;
    private List<CanarySteps>                         steps;

    private StrategyCanary() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public CanaryBackgroundVerification getBackgroundVerification() {
        return backgroundVerification;
    }

    public void setBackgroundVerification(CanaryBackgroundVerification backgroundVerification) {
        isSet.add("backgroundVerification");
        this.backgroundVerification = backgroundVerification;
    }

    public List<CanarySteps> getSteps() {
        return steps;
    }

    public void setSteps(List<CanarySteps> steps) {
        isSet.add("steps");
        this.steps = steps;
    }

    public static class Builder {
        private StrategyCanary strategyCanary;

        private Builder() {
            this.strategyCanary = new StrategyCanary();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBackgroundVerification(final CanaryBackgroundVerification backgroundVerification) {
            strategyCanary.setBackgroundVerification(backgroundVerification);
            return this;
        }

        public Builder setSteps(final List<CanarySteps> steps) {
            strategyCanary.setSteps(steps);
            return this;
        }

        public StrategyCanary build() {
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