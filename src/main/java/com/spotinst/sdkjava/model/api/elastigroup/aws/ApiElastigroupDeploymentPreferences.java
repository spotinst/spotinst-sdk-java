package com.spotinst.sdkjava.model.api.elastigroup.aws;

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
public class ApiElastigroupDeploymentPreferences implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean              automaticRoll;
    private Integer              batchSizePercentage;
    private Integer              gracePeriod;
    private ApiBeanstalkStrategy    strategy;
    //endregion

    //region Constructors
    public ApiElastigroupDeploymentPreferences() {
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

    public ApiBeanstalkStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiBeanstalkStrategy strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
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
