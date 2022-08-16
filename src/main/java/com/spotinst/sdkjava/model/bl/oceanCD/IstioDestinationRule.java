package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IstioDestinationRule {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     name;
    private String                     canarySubsetName;
    private String                     stableSubsetName;

    private IstioDestinationRule() {
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

    public String getCanarySubsetName() {
        return canarySubsetName;
    }

    public void setCanarySubsetName(String canarySubsetName) {
        isSet.add("canarySubsetName");
        this.canarySubsetName = canarySubsetName;
    }

    public String getStableSubsetName() {
        return stableSubsetName;
    }

    public void setStableSubsetName(String stableSubsetName) {
        isSet.add("stableSubsetName");
        this.stableSubsetName = stableSubsetName;
    }

    public static class Builder {
        private IstioDestinationRule istioDestinationRule;

        private Builder() {
            this.istioDestinationRule = new IstioDestinationRule();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            istioDestinationRule.setName(name);
            return this;
        }

        public Builder setCanarySubsetName(final String canarySubsetName) {
            istioDestinationRule.setCanarySubsetName(canarySubsetName);
            return this;
        }

        public Builder setStableSubsetName(final String stableSubsetName) {
            istioDestinationRule.setStableSubsetName(stableSubsetName);
            return this;
        }

        public IstioDestinationRule build() {
            return istioDestinationRule;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isCanarySubsetNameSet() {
        return isSet.contains("canarySubsetName");
    }

    @JsonIgnore
    public boolean isStableSubsetNameSet() {
        return isSet.contains("stableSubsetName");
    }
}