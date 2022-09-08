package com.spotinst.sdkjava.model.api.oceanCD;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiCanarySteps implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private Integer                                   setWeight;
    private ApiStepsSetCanaryScale                    setCanaryScale;
    private ApiCanaryBackgroundVerification           verification;
    private ApiStepsPause pause;


    public ApiCanarySteps() {
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

    public ApiStepsSetCanaryScale getSetCanaryScale() {
        return setCanaryScale;
    }

    public void setSetCanaryScale(ApiStepsSetCanaryScale setCanaryScale) {
        isSet.add("setCanaryScale");
        this.setCanaryScale = setCanaryScale;
    }

    public ApiCanaryBackgroundVerification getVerification() {
        return verification;
    }

    public void setVerification(ApiCanaryBackgroundVerification verification) {
        isSet.add("verification");
        this.verification = verification;
    }

    public ApiStepsPause getPause() {
        return pause;
    }

    public void setPause(ApiStepsPause pause) {
        isSet.add("pause");
        this.pause = pause;
    }

    public static class Builder {
        private ApiCanarySteps canarySteps;

        private Builder() {
            this.canarySteps = new ApiCanarySteps();
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

        public Builder setSetCanaryScale(final ApiStepsSetCanaryScale setCanaryScale) {
            canarySteps.setSetCanaryScale(setCanaryScale);
            return this;
        }

        public Builder setVerification(final ApiCanaryBackgroundVerification verification) {
            canarySteps.setVerification(verification);
            return this;
        }

        public Builder setPause(final ApiStepsPause pause) {
            canarySteps.setPause(pause);
            return this;
        }

        public ApiCanarySteps build() {
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