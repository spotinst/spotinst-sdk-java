package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDeploymentDetailsOverviewAzure {
    //region members
    private String       deploymentId;
    private Integer      numberOfBatches;
    private Integer      currentBatch;
    private Integer      gracePeriod;
    private List<String> healthCheck;
    private Integer      blueVms;
    private Integer      greenVms;
    private String       description;
    private String       errorMessage;
    private Date         createdAt;
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

    public List<String> getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(List<String> healthCheck) {
        this.healthCheck = healthCheck;
    }

    public Integer getBlueVms() {
        return blueVms;
    }

    public void setBlueVms(Integer blueVms) {
        this.blueVms = blueVms;
    }

    public Integer getGreenVms() {
        return greenVms;
    }

    public void setGreenVms(Integer greenVms) {
        this.greenVms = greenVms;
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
