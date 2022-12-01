package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class LaunchNodesInAksVNG {
    @JsonIgnore
    private Set<String>                      isSet;
    private Integer                         amount;

    private LaunchNodesInAksVNG() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        isSet.add("amount");
        this.amount = amount;
    }

    public static class Builder {
        private LaunchNodesInAksVNG launchRequest;

        private Builder() {
            this.launchRequest = new LaunchNodesInAksVNG();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAmount(final Integer amount) {
            launchRequest.setAmount(amount);
            return this;
        }

        public LaunchNodesInAksVNG build() {
            // Validations
            return launchRequest;
        }
    }

    @JsonIgnore
    public boolean isAmountSet() {
        return isSet.contains("amount");
    }
}