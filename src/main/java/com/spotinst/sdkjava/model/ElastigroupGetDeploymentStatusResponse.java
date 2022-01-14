package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupDeploymentProgress;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupDeploymentStatusInstances;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetDeploymentStatusResponse {

    @JsonIgnore
    private Set<String>                                isSet;
    private ElastigroupDeploymentProgress              progress;
    private Integer                                    numOfBatches;
    private Integer                                    currentBatch;
    private Integer                                    gracePeriod;
    private String                                     strategyAction;
    private String                                     healthCheck;
    private List<ElastigroupDeploymentStatusInstances> instances;

    public ElastigroupGetDeploymentStatusResponse() {
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

    public ElastigroupDeploymentProgress getProgress() {
        return progress;
    }

    public void setProgress(ElastigroupDeploymentProgress progress) {
        isSet.add("progress");
        this.progress = progress;
    }

    public List<ElastigroupDeploymentStatusInstances> getInstances() {
        return instances;
    }

    public void setInstances(List<ElastigroupDeploymentStatusInstances> instances) {
        isSet.add("instances");
        this.instances = instances;
    }


    public static class Builder {
        private ElastigroupGetDeploymentStatusResponse getDeploymentStatusResponse;

        private Builder() {
            this.getDeploymentStatusResponse = new ElastigroupGetDeploymentStatusResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setStrategyAction(final String strategyAction) {
            getDeploymentStatusResponse.setStrategyAction(strategyAction);
            return this;
        }

        public Builder setHealthCheck(final String healthCheck) {
            getDeploymentStatusResponse.setHealthCheck(healthCheck);
            return this;
        }

        public Builder setCurrentBatch(final Integer currentBatch) {
            getDeploymentStatusResponse.setCurrentBatch(currentBatch);
            return this;
        }
        public Builder setGracePeriod(final Integer gracePeriod) {
            getDeploymentStatusResponse.setGracePeriod(gracePeriod);
            return this;
        }

        public Builder setNumOfBatches(final Integer numOfBatches) {
            getDeploymentStatusResponse.setNumOfBatches(numOfBatches);
            return this;
        }

        public Builder setProgress(final ElastigroupDeploymentProgress progress) {
            getDeploymentStatusResponse.setProgress(progress);
            return this;
        }

        public Builder setInstances(final List<ElastigroupDeploymentStatusInstances> instances) {
            getDeploymentStatusResponse.setInstances(instances);
            return this;
        }


        public ElastigroupGetDeploymentStatusResponse build() {
            return getDeploymentStatusResponse;
        }
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

