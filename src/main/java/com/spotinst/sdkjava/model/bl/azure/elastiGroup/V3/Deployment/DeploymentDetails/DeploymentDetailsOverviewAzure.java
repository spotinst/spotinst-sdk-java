package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.HealthCheckTypeEnumAzure;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeploymentDetailsOverviewAzure {
    //region members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         deploymentId;
    private Integer                        numberOfBatches;
    private Integer                        currentBatch;
    private Integer                        gracePeriod;
    private List<HealthCheckTypeEnumAzure> healthCheck;
    private Integer                        blueVms;
    private Integer                        greenVms;
    private String                         description;
    private String                         errorMessage;
    private Date                           createdAt;
    //endregion

    //region constructor
    public DeploymentDetailsOverviewAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
        touch("deploymentId");
    }

    public Integer getNumberOfBatches() {
        return numberOfBatches;
    }

    public void setNumberOfBatches(Integer numberOfBatches) {
        this.numberOfBatches = numberOfBatches;
        touch("numberOfBatches");
    }

    public Integer getCurrentBatch() {
        return currentBatch;
    }

    public void setCurrentBatch(Integer currentBatch) {
        this.currentBatch = currentBatch;
        touch("currentBatch");
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
        touch("gracePeriod");
    }

    public List<HealthCheckTypeEnumAzure> getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(List<HealthCheckTypeEnumAzure> healthCheck) {
        this.healthCheck = healthCheck;
        touch("healthCheck");
    }

    public Integer getBlueVms() {
        return blueVms;
    }

    public void setBlueVms(Integer blueVms) {
        this.blueVms = blueVms;
        touch("blueVms");
    }

    public Integer getGreenVms() {
        return greenVms;
    }

    public void setGreenVms(Integer greenVms) {
        this.greenVms = greenVms;
        touch("greenVms");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        touch("description");
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        touch("errorMessage");
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        touch("createdAt");
    }

    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isCreatedAtSet() {
        return this.isSet.contains("createdAt");
    }
    @JsonIgnore
    public Boolean isErrorMessageSet() {
        return this.isSet.contains("errorMessage");
    }
    @JsonIgnore
    public Boolean isDescriptionSet() {
        return this.isSet.contains("description");
    }
    @JsonIgnore
    public Boolean isGreenVmsSet() {
        return this.isSet.contains("greenVms");
    }
    @JsonIgnore
    public Boolean isBlueVmsSet() {
        return this.isSet.contains("blueVms");
    }
    @JsonIgnore
    public Boolean isHealthCheckSet() {
        return this.isSet.contains("healthCheck");
    }
    @JsonIgnore
    public Boolean isGracePeriodSet() {
        return this.isSet.contains("gracePeriod");
    }
    @JsonIgnore
    public Boolean isCurrentBatchSet() {
        return this.isSet.contains("currentBatch");
    }
    @JsonIgnore
    public Boolean isNumberOfBatchesSet() {
        return this.isSet.contains("numberOfBatches");
    }
    @JsonIgnore
    public Boolean isDeploymentIdSet() {
        return this.isSet.contains("deploymentId");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
