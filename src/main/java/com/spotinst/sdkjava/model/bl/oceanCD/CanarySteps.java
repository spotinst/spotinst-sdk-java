package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CanarySteps {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private Integer                                   setWeight;
    private StepsSetCanaryScale                       setCanaryScale;
    private CanaryBackgroundVerification              verification;
    private StepsPause                                pause;


    private CanarySteps() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Integer getSetWeight() {
        return setWeight;
    }

    public void setSetWeight(Integer setWeight) {
        isSet.add("setWeight");
        this.setWeight = setWeight;
    }

    public StepsSetCanaryScale getSetCanaryScale() {
        return setCanaryScale;
    }

    public void setSetCanaryScale(StepsSetCanaryScale setCanaryScale) {
        isSet.add("setCanaryScale");
        this.setCanaryScale = setCanaryScale;
    }

    public CanaryBackgroundVerification getVerification() {
        return verification;
    }

    public void setVerification(CanaryBackgroundVerification verification) {
        isSet.add("verification");
        this.verification = verification;
    }

    public StepsPause getPause() {
        return pause;
    }

    public void setPause(StepsPause pause) {
        isSet.add("pause");
        this.pause = pause;
    }

    public static class Builder {
        private CanarySteps canarySteps;

        private Builder() {
            this.canarySteps = new CanarySteps();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            canarySteps.setName(name);
            return this;
        }

        public Builder setSetWeight(final Integer setWeight) {
            canarySteps.setSetWeight(setWeight);
            return this;
        }

        public Builder setSetCanaryScale(final StepsSetCanaryScale setCanaryScale) {
            canarySteps.setSetCanaryScale(setCanaryScale);
            return this;
        }

        public Builder setVerification(final CanaryBackgroundVerification verification) {
            canarySteps.setVerification(verification);
            return this;
        }

        public Builder setPause(final StepsPause pause) {
            canarySteps.setPause(pause);
            return this;
        }

        public CanarySteps build() {
            return canarySteps;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isSetWeightSet() {
        return isSet.contains("setWeight");
    }

    @JsonIgnore
    public boolean isSetCanaryScaleSet() {
        return isSet.contains("setCanaryScale");
    }

    @JsonIgnore
    public boolean isVerificationSet() {
        return isSet.contains("verification");
    }

    @JsonIgnore
    public boolean isPauseSet() {
        return isSet.contains("pause");
    }
}