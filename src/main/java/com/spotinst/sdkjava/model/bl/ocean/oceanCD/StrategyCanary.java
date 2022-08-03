package com.spotinst.sdkjava.model.bl.ocean.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StrategyCanary {
    @JsonIgnore
    private Set<String>                     isSet;
    private CanaryBackgroundVerification    backgroundVerification;
    private List<CanarySteps>               steps;

    public StrategyCanary() {
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
        private StrategyCanary canary;

        private Builder() {
            this.canary = new StrategyCanary();
        }

        public static StrategyCanary.Builder get() {
            return new Builder();
        }

        public Builder setBackgroundVerification(CanaryBackgroundVerification backgroundVerification) {
            canary.setBackgroundVerification(backgroundVerification);
            return this;
        }

        public Builder setSteps(List<CanarySteps> steps) {
            canary.setSteps(steps);
            return this;
        }

        public StrategyCanary build() {
            return canary;
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
