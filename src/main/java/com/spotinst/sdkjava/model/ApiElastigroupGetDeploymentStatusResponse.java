package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.AwsElastigroupActionEnum;
import com.spotinst.sdkjava.enums.AwsElastigroupHealthCheckTypeEnum;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupDeploymentProgress;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupDeploymentStatusInstances;

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
    private Integer                                       numberOfBatches;
    private Integer                                       currentBatch;
    private Integer                                       gracePeriod;
    private AwsElastigroupActionEnum                      strategyAction;
    private AwsElastigroupHealthCheckTypeEnum             healthCheck;
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

    public AwsElastigroupActionEnum getStrategyAction() { return strategyAction; }

    public void setStrategyAction(AwsElastigroupActionEnum strategyAction) {
        isSet.add("strategyAction");
        this.strategyAction = strategyAction;
    }

    public AwsElastigroupHealthCheckTypeEnum getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(AwsElastigroupHealthCheckTypeEnum healthCheck) {
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

    public Integer getNumberOfBatches() {
        return numberOfBatches;
    }

    public void setNumberOfBatches(Integer numberOfBatches) {
        isSet.add("numberOfBatches");
        this.numberOfBatches = numberOfBatches;
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
    public boolean isNumberOfBatchesSet() { return isSet.contains("numberOfBatches");  }

    @JsonIgnore
    public boolean isProgressSet() {
        return isSet.contains("progress");
    }

    @JsonIgnore
    public boolean isInstancesSet() {
        return isSet.contains("instances");
    }

}

