package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupGetDeploymentStatusResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                   isSet;
    private ApiElastigroupDeploymentProgress              progress;
    private Integer                                       numOfBatches;
    private Integer                                       currentBatch;
    private Integer                                       gracePeriod;
    private String                                        strategyAction;
    private String                                        healthCheck;
    private List<ApiElastigroupDeploymentStatusInstances> instances;

    public ApiElastigroupGetDeploymentStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getStrategyAction() { return strategyAction; }

    public void setStrategyAction(String strategyAction) {
        isSet.add("strategyAction");
        this.strategyAction = strategyAction;
    }

    public String getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(String healthCheck) {
        isSet.add("healthCheck");
        this.healthCheck = healthCheck;
    }

    public Integer getCurrentBatch() {
        return currentBatch;
    }

    public void setCurrentBatch(Integer currentBatch) {
        isSet.add("currentBatch");
        this.currentBatch = currentBatch;
    }
    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        isSet.add("gracePeriod");
        this.gracePeriod = gracePeriod;
    }

    public Integer getNumOfBatches() {
        return numOfBatches;
    }

    public void setNumOfBatches(Integer numOfBatches) {
        isSet.add("numOfBatches");
        this.numOfBatches = numOfBatches;
    }

    public ApiElastigroupDeploymentProgress getProgress() {
        return progress;
    }

    public void setProgress(ApiElastigroupDeploymentProgress progress) {
        isSet.add("progress");
        this.progress = progress;
    }

    public List<ApiElastigroupDeploymentStatusInstances> getInstances() {
        return instances;
    }

    public void setInstances(List<ApiElastigroupDeploymentStatusInstances> instances) {
        isSet.add("instances");
        this.instances = instances;
    }

    @JsonIgnore
    public boolean isStrategyActionSet() {
        return isSet.contains("strategyAction");
    }

    @JsonIgnore
    public boolean isHealthCheckSet() {
        return isSet.contains("healthCheck");
    }

    @JsonIgnore
    public boolean isCurrentBatchSet() {
        return isSet.contains("currentBatch");
    }

    @JsonIgnore
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }

    @JsonIgnore
    public boolean isNumOfBatchesSet() { return isSet.contains("numOfBatches");  }

    @JsonIgnore
    public boolean isProgressSet() {
        return isSet.contains("progress");
    }

    @JsonIgnore
    public boolean isInstancesSet() {
        return isSet.contains("instances");
    }

}

