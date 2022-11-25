package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.BeanstalkDeleteConfig;
import com.spotinst.sdkjava.model.bl.oceanCD.Strategy;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupDeploymentPreferences {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean              automaticRoll;
    private Integer              batchSizePercentage;
    private Integer              gracePeriod;
    private BeanstalkStrategy    strategy;
    //endregion

    //region Constructors
    private ElastigroupDeploymentPreferences() {
        isSet = new HashSet<>();
    }
    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getAutomaticRoll() {
        return automaticRoll;
    }

    public void setAutomaticRoll(Boolean automaticRoll) {
        isSet.add("automaticRoll");
        this.automaticRoll = automaticRoll;
    }

    public Integer getBatchSizePercentage() {
        return batchSizePercentage;
    }

    public void setBatchSizePercentage(Integer batchSizePercentage) {
        isSet.add("batchSizePercentage");
        this.batchSizePercentage = batchSizePercentage;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        isSet.add("gracePeriod");
        this.gracePeriod = gracePeriod;
    }

    public BeanstalkStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(BeanstalkStrategy strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupDeploymentPreferences deploymentPreferences;

        private Builder() {
            this.deploymentPreferences = new ElastigroupDeploymentPreferences();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAutomaticRoll (final Boolean automaticRoll){
            deploymentPreferences.setAutomaticRoll(automaticRoll);
            return this;
        }

        public Builder setBatchSizePercentage (final Integer batchSizePercentage){
            deploymentPreferences.setBatchSizePercentage(batchSizePercentage);
            return this;
        }

        public Builder setGracePeriod (final Integer gracePeriod){
            deploymentPreferences.setGracePeriod(gracePeriod);
            return this;
        }

        public Builder setStrategy (final BeanstalkStrategy strategy){
            deploymentPreferences.setStrategy(strategy);
            return this;
        }

        public ElastigroupDeploymentPreferences build(){return deploymentPreferences;}

    }
    //endregion

    //region isSet methods
    // Is automaticRoll Set boolean method
    @JsonIgnore
    public boolean isAutomaticRollSet() {
        return isSet.contains("automaticRoll");
    }

    // Is batchSizePercentage Set boolean method
    @JsonIgnore
    public boolean isBatchSizePercentageSet() {
        return isSet.contains("batchSizePercentage");
    }

    // Is gracePeriod Set boolean method
    @JsonIgnore
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }

    // Is strategy Set boolean method
    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    //endregion
}
