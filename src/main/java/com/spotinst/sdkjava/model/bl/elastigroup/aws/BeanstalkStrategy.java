package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeanstalkStrategy {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      action;
    private Boolean     shouldDrainInstances;
    //endregion

    //region Constructors
    private BeanstalkStrategy() {
        isSet = new HashSet<>();
    }
    //region Getters & Setters

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

    public Boolean getShouldDrainInstances() {
        return shouldDrainInstances;
    }

    public void setShouldDrainInstances(Boolean shouldDrainInstances) {
        isSet.add("shouldDrainInstances");
        this.shouldDrainInstances = shouldDrainInstances;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private BeanstalkStrategy strategy;

        private Builder() {
            this.strategy = new BeanstalkStrategy();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAction (final String action){
            strategy.setAction(action);
            return this;
        }

        public Builder setShouldDrainInstances (final Boolean shouldDrainInstances){
            strategy.setShouldDrainInstances(shouldDrainInstances);
            return this;
        }

        public BeanstalkStrategy build(){return strategy;}

    }
    //endregion

    //region isSet methods
    // Is action Set boolean method
    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }

    // Is shouldDrainInstances Set boolean method
    @JsonIgnore
    public boolean isShouldDrainInstancesSet() {
        return isSet.contains("shouldDrainInstances");
    }
    //endregion
}
