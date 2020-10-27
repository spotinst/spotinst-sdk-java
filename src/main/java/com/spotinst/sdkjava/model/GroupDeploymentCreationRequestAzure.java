package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.HealthCheckTypeEnumAzure;

import java.util.List;

public class GroupDeploymentCreationRequestAzure {
    //region Members
    private Integer                        batchSizePercentage;
    private Integer                        gracePeriod;
    private Integer                        batchMinHealthyPercentage;
    private Integer                        drainingTimeout;
    private List<HealthCheckTypeEnumAzure> healthCheckTypes;
    //endregion

    //region Getters and Setters
    public Integer getBatchSizePercentage() {
        return batchSizePercentage;
    }

    private void setBatchSizePercentage(Integer batchSizePercentage) {
        this.batchSizePercentage = batchSizePercentage;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    private void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public Integer getBatchMinHealthyPercentage() {
        return batchMinHealthyPercentage;
    }

    private void setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
        this.batchMinHealthyPercentage = batchMinHealthyPercentage;
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    private void setDrainingTimeout(Integer drainingTimeout) {
        this.drainingTimeout = drainingTimeout;
    }

    public List<HealthCheckTypeEnumAzure> getHealthCheckTypes() {
        return healthCheckTypes;
    }

    private void setHealthCheckTypes(List<HealthCheckTypeEnumAzure> healthCheckTypes) {
        this.healthCheckTypes = healthCheckTypes;
    }
    //endregion

    //region Override Methods
    @Override
    public String toString() {
        return "CreateGroupDeploymentRequest{" + "batchSizePercentage=" + batchSizePercentage + ", gracePeriod=" +
               gracePeriod + ", batchMinHealthyPercentage=" + batchMinHealthyPercentage + ", drainingTimeout=" +
               drainingTimeout + ", healthCheckTypes=" + healthCheckTypes + '}';
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
}
