package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GetInstanceCost {

    @JsonIgnore
    private Set<String> isSet;
    private Costs      costs;
    private Running    running;
    private Savings    savings;

    private GetInstanceCost() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public Costs getCosts() {
        return costs;
    }

    public void setCosts(Costs costs) {
        isSet.add("costs");
        this.costs = costs;
    }

    public Running getRunning() {
        return running;
    }

    public void setRunning(Running running) {
        isSet.add("running");
        this.running = running;
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        isSet.add("savings");
        this.savings = savings;
    }

    public static class Builder {
        private GetInstanceCost getInstanceCosts;

        private Builder() {
            this.getInstanceCosts = new GetInstanceCost();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCosts(final Costs costs) {
            getInstanceCosts.setCosts(costs);
            return this;
        }

        public Builder setRunning(final Running running) {
            getInstanceCosts.setRunning(running);
            return this;
        }

        public Builder setSavings(final Savings savings) {
            getInstanceCosts.setSavings(savings);
            return this;
        }

        public GetInstanceCost build() {
            return getInstanceCosts;
        }
    }


    @JsonIgnore
    public boolean isCostsSet() {
        return isSet.contains("costs");
    }

    @JsonIgnore
    public boolean isRunningSet() {
        return isSet.contains("running");
    }

    @JsonIgnore
    public boolean isSavingsSet() {
        return isSet.contains("savings");
    }

}

