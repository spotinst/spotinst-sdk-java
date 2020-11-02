package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDeploymentDetailsOverviewAzure implements IPartialUpdateEntity {
    //region members
    @JsonIgnore
    private Set<String>  isSet;
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

    //region constructor
    public ApiDeploymentDetailsOverviewAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

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

    public List<String> getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(List<String> healthCheck) {
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
