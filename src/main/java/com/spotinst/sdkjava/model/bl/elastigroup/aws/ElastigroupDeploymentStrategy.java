package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AwsElastigroupActionEnum;
import java.util.HashSet;
import java.util.Set;

public class ElastigroupDeploymentStrategy {
    @JsonIgnore
    private Set<String>                            isSet;
    private Integer                                batchMinHealthyPercentage;
    private AwsElastigroupActionEnum               action;
    private ElastigroupDeploymentStrategyOnFailure onFailure;

    public ElastigroupDeploymentStrategy() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getBatchMinHealthyPercentage() {
        return batchMinHealthyPercentage;
    }

    public void setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
        isSet.add("batchMinHealthyPercentage");
        this.batchMinHealthyPercentage = batchMinHealthyPercentage;
    }

    public AwsElastigroupActionEnum getAction() {
        return action;
    }

    public void setAction(AwsElastigroupActionEnum action) {
        isSet.add("action");
        this.action = action;
    }

    public ElastigroupDeploymentStrategyOnFailure getOnFailure() {
        return onFailure;
    }

    public void setOnFailure(ElastigroupDeploymentStrategyOnFailure onFailure) {
        isSet.add("onFailure");
        this.onFailure = onFailure;
    }

    public static class Builder {
        private ElastigroupDeploymentStrategy elastigroupStrategyRequest;

        private Builder() {
            this.elastigroupStrategyRequest = new ElastigroupDeploymentStrategy();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBatchMinHealthyPercentage(final Integer batchMinHealthyPercentage) {
            elastigroupStrategyRequest.setBatchMinHealthyPercentage(batchMinHealthyPercentage);
            return this;
        }

        public Builder setAction(final AwsElastigroupActionEnum action) {
            elastigroupStrategyRequest.setAction(action);
            return this;
        }

        public Builder setOnFailure(final ElastigroupDeploymentStrategyOnFailure onFailure) {
            elastigroupStrategyRequest.setOnFailure(onFailure);
            return this;
        }

        public ElastigroupDeploymentStrategy build() {
            return elastigroupStrategyRequest;
        }
    }

    @JsonIgnore
    public boolean isBatchMinHealthyPercentageSet() { return isSet.contains("batchMinHealthyPercentage"); }

    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }

    @JsonIgnore
    public boolean isOnFailureSet() {
        return isSet.contains("onFailure");
    }

}
