package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import com.spotinst.sdkjava.enums.HealthCheckTypeEnumAzure;

import java.util.Date;
import java.util.List;

public class DeploymentDetailsOverviewAzure {
    //region members
    private String                         deploymentId;
    private Integer                        numberOfBatches;
    private Integer                        currentBatch;
    private Integer                        gracePeriod;
    private List<HealthCheckTypeEnumAzure> healthCheck;
    private Integer                        blueInstances;
    private Integer                        greenInstances;
    private String                         description;
    private String                         errorMessage;
    private Date                           createdAt;
    //endregion

    //region getters & setters
    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public Integer getNumberOfBatches() {
        return numberOfBatches;
    }

    public void setNumberOfBatches(Integer numberOfBatches) {
        this.numberOfBatches = numberOfBatches;
    }

    public Integer getCurrentBatch() {
        return currentBatch;
    }

    public void setCurrentBatch(Integer currentBatch) {
        this.currentBatch = currentBatch;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public List<HealthCheckTypeEnumAzure> getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(List<HealthCheckTypeEnumAzure> healthCheck) {
        this.healthCheck = healthCheck;
    }

    public Integer getBlueInstances() {
        return blueInstances;
    }

    public void setBlueInstances(Integer blueInstances) {
        this.blueInstances = blueInstances;
    }

    public Integer getGreenInstances() {
        return greenInstances;
    }

    public void setGreenInstances(Integer greenInstances) {
        this.greenInstances = greenInstances;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    //endregion
}
