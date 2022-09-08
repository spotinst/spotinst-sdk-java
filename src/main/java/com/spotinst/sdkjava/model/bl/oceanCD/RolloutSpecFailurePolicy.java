package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolloutSpecFailurePolicy {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     action;

    private RolloutSpecFailurePolicy() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        isSet.add("action");
        this.action = action;
    }

    public static class Builder {
        private RolloutSpecFailurePolicy rolloutSpecFailurePolicy;

        private Builder() {
            this.rolloutSpecFailurePolicy = new RolloutSpecFailurePolicy();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAction(final String action) {
            rolloutSpecFailurePolicy.setAction(action);
            return this;
        }

        public RolloutSpecFailurePolicy build() {
            return rolloutSpecFailurePolicy;
        }
    }

    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }
}