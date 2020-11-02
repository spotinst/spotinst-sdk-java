package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.HealthCheckTypeEnumAzure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupDeploymentCreationRequestAzure {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private Integer                        batchSizePercentage;
    private Integer                        gracePeriod;
    private Integer                        batchMinHealthyPercentage;
    private Integer                        drainingTimeout;
    private List<HealthCheckTypeEnumAzure> healthCheckTypes;
    //endregion

    //region constructor

    public GroupDeploymentCreationRequestAzure() {
        isSet = new HashSet<>();
    }

    //

    //region Getters and Setters

    public Integer getBatchSizePercentage() {
        return batchSizePercentage;
    }

    public void setBatchSizePercentage(Integer batchSizePercentage) {
        this.batchSizePercentage = batchSizePercentage;
        touch("batchSizePercentage");
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
        touch("gracePeriod");
    }

    public Integer getBatchMinHealthyPercentage() {
        return batchMinHealthyPercentage;
    }

    private void setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
        this.batchMinHealthyPercentage = batchMinHealthyPercentage;
        touch("batchMinHealthyPercentage");
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        this.drainingTimeout = drainingTimeout;
        touch("drainingTimeout");
    }

    public List<HealthCheckTypeEnumAzure> getHealthCheckTypes() {
        return healthCheckTypes;
    }

    private void setHealthCheckTypes(List<HealthCheckTypeEnumAzure> healthCheckTypes) {
        this.healthCheckTypes = healthCheckTypes;
        touch("healthCheckTypes");
    }

    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isBatchSizePercentageSet() {
        return this.isSet.contains("batchSizePercentage");
    }
    @JsonIgnore
    public Boolean isGracePeriodSet() {
        return this.isSet.contains("gracePeriod");
    }
    @JsonIgnore
    public Boolean isBatchMinHealthyPercentageSet() {
        return this.isSet.contains("batchMinHealthyPercentage");
    }
    @JsonIgnore
    public Boolean isDrainingTimeoutSet() {
        return this.isSet.contains("drainingTimeout");
    }
    @JsonIgnore
    public Boolean isHealthCheckTypesSet() {
        return this.isSet.contains("healthCheckTypes");
    }
    //endregion

    //region Builder class
    public static class Builder {
        private GroupDeploymentCreationRequestAzure groupDeploymentCreationRequestAzure;

        private Builder() {
            this.groupDeploymentCreationRequestAzure = new GroupDeploymentCreationRequestAzure();
        }

        public static GroupDeploymentCreationRequestAzure.Builder get() {
            GroupDeploymentCreationRequestAzure.Builder builder = new GroupDeploymentCreationRequestAzure.Builder();
            return builder;
        }

        public GroupDeploymentCreationRequestAzure.Builder setBatchSizePercentage(Integer batchSizePercentage) {
            groupDeploymentCreationRequestAzure.setBatchSizePercentage(batchSizePercentage);
            return this;
        }

        public GroupDeploymentCreationRequestAzure.Builder setGracePeriod(Integer gracePeriod) {
            groupDeploymentCreationRequestAzure.setGracePeriod(gracePeriod);
            return this;
        }

        public GroupDeploymentCreationRequestAzure.Builder setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
            groupDeploymentCreationRequestAzure.setBatchMinHealthyPercentage(batchMinHealthyPercentage);
            return this;
        }

        public GroupDeploymentCreationRequestAzure.Builder setDrainingTimeout(Integer drainingTimeout) {
            groupDeploymentCreationRequestAzure.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public GroupDeploymentCreationRequestAzure.Builder setHealthCheckTypes(List<HealthCheckTypeEnumAzure> healthCheckTypes) {
            groupDeploymentCreationRequestAzure.setHealthCheckTypes(healthCheckTypes);
            return this;
        }


        public GroupDeploymentCreationRequestAzure build() {
            return groupDeploymentCreationRequestAzure;
        }

    }
    //endregion


    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
