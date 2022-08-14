package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolloutSpec {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private RolloutSpecSpotDeployment                 spotDeployment;
    private RolloutSpecStrategy                       strategy;
    private RolloutSpecTraffic                        traffic;
    private RolloutSpecFailurePolicy                  failurePolicy;

    private RolloutSpec() {
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

    public RolloutSpecSpotDeployment getSpotDeployment() {
        return spotDeployment;
    }

    public void setSpotDeployment(RolloutSpecSpotDeployment spotDeployment) {
        isSet.add("spotDeployment");
        this.spotDeployment = spotDeployment;
    }

    public RolloutSpecStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(RolloutSpecStrategy strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public RolloutSpecTraffic getTraffic() {
        return traffic;
    }

    public void setTraffic(RolloutSpecTraffic traffic) {
        isSet.add("traffic");
        this.traffic = traffic;
    }

    public RolloutSpecFailurePolicy getFailurePolicy() {
        return failurePolicy;
    }

    public void setFailurePolicy(RolloutSpecFailurePolicy failurePolicy) {
        isSet.add("failurePolicy");
        this.failurePolicy = failurePolicy;
    }

    public static class Builder {
        private RolloutSpec rolloutSpec;

        private Builder() {
            this.rolloutSpec = new RolloutSpec();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            rolloutSpec.setName(name);
            return this;
        }

        public Builder setSpotDeployment(final RolloutSpecSpotDeployment spotDeployment) {
            rolloutSpec.setSpotDeployment(spotDeployment);
            return this;
        }

        public Builder setStrategy(final RolloutSpecStrategy strategy) {
            rolloutSpec.setStrategy(strategy);
            return this;
        }

        public Builder setTraffic(final RolloutSpecTraffic traffic) {
            rolloutSpec.setTraffic(traffic);
            return this;
        }

        public Builder setFailurePolicy(final RolloutSpecFailurePolicy failurePolicy) {
            rolloutSpec.setFailurePolicy(failurePolicy);
            return this;
        }

        public RolloutSpec build() {
            return rolloutSpec;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isSpotDeploymentSet() {
        return isSet.contains("spotDeployment");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isTrafficSet() {
        return isSet.contains("traffic");
    }

    @JsonIgnore
    public boolean isFailurePolicySet() {
        return isSet.contains("failurePolicy");
    }
}