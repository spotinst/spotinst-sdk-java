package com.spotinst.sdkjava.model.bl.aws.elastigroup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AwsElastigroupHealthCheckTypeEnum;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupStartDeployment {
    @JsonIgnore
    private Set<String>                       isSet;
    private Integer                           batchSizePercentage;
    private Integer                           drainingTimeout;
    private Integer                           gracePeriod;
    private AwsElastigroupHealthCheckTypeEnum healthCheckType;
    private ElastigroupDeploymentStrategy     strategy;

    public ElastigroupStartDeployment() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getBatchSizePercentage() {
        return batchSizePercentage;
    }

    public void setBatchSizePercentage(Integer batchSizePercentage) {
        isSet.add("batchSizePercentage");
        this.batchSizePercentage = batchSizePercentage;
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        isSet.add("gracePeriod");
        this.gracePeriod = gracePeriod;
    }

    public AwsElastigroupHealthCheckTypeEnum getHealthCheckType() {
        return healthCheckType;
    }

    public void setHealthCheckType(AwsElastigroupHealthCheckTypeEnum healthCheckType) {
        isSet.add("healthCheckType");
        this.healthCheckType = healthCheckType;
    }

    public ElastigroupDeploymentStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ElastigroupDeploymentStrategy strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public static class Builder {
        private ElastigroupStartDeployment elastigroupDeploymentRequest;

        private Builder() {
            this.elastigroupDeploymentRequest = new ElastigroupStartDeployment();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setBatchSizePercentage (final Integer batchSizePercentage){
            elastigroupDeploymentRequest.setBatchSizePercentage(batchSizePercentage);
            return this;
        }

        public Builder setDrainingTimeout (final Integer drainingTimeout){
            elastigroupDeploymentRequest.setDrainingTimeout(drainingTimeout);
            return this;
        }
        public Builder setGracePeriod (final Integer gracePeriod){
            elastigroupDeploymentRequest.setGracePeriod(gracePeriod);
            return this;
        }
        public Builder setHealthCheckType (final AwsElastigroupHealthCheckTypeEnum healthCheckType){
            elastigroupDeploymentRequest.setHealthCheckType(healthCheckType);
            return this;
        }
        public Builder setStrategy(final ElastigroupDeploymentStrategy strategy){
            elastigroupDeploymentRequest.setStrategy(strategy);
            return this;
        }
        public ElastigroupStartDeployment build() {
            return elastigroupDeploymentRequest;
        }
    }

    @JsonIgnore
    public boolean isBatchSizePercentageSet() { return isSet.contains("batchSizePercentage"); }

    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    @JsonIgnore
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }

    @JsonIgnore
    public boolean isHealthCheckTypeSet() {
        return isSet.contains("healthCheckType");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

}
