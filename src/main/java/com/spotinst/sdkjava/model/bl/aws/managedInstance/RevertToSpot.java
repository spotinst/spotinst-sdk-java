package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.AwsPerformAtEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevertToSpot {

    @JsonIgnore
    private Set<String>      isSet;
    private AwsPerformAtEnum performAt;

    private RevertToSpot() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public AwsPerformAtEnum getPerformAt() {
        return performAt;
    }

    public void setPerformAt(AwsPerformAtEnum performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }

    public static class Builder {
        private RevertToSpot revertToSpot;

        private Builder() {
            this.revertToSpot = new RevertToSpot();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPerformAt(final AwsPerformAtEnum performAt) {
            revertToSpot.setPerformAt(performAt);
            return this;
        }

        public RevertToSpot build() {
            return revertToSpot;
        }
    }

    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }
}
