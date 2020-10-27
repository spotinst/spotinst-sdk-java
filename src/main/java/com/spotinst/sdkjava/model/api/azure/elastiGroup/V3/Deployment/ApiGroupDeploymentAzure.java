package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGroupDeploymentAzure implements IPartialUpdateEntity {

    //region members
    @JsonIgnore
    private Set<String>                     isSet;
    private String                          id;
    private String                          groupId;
    private Integer                         currentBatch;
    private Integer                         numberOfBatches;
    private String                          state;
    private ApiGroupDeploymentStrategyAzure strategy;
    private Date                            updatedAt;
    private Date                            createdAt;
    //endregion

    //region constructor
    public ApiGroupDeploymentAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        touch("id");
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
        touch("groupId");
    }

    public Integer getCurrentBatch() {
        return currentBatch;
    }

    public void setCurrentBatch(Integer currentBatch) {
        this.currentBatch = currentBatch;
        touch("currentBatch");
    }

    public Integer getNumberOfBatches() {
        return numberOfBatches;
    }

    public void setNumberOfBatches(Integer numberOfBatches) {
        this.numberOfBatches = numberOfBatches;
        touch("numberOfBatches");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        touch("state");
    }

    public ApiGroupDeploymentStrategyAzure getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiGroupDeploymentStrategyAzure strategy) {
        this.strategy = strategy;
        touch("strategy");
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        touch("updatedAt");
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        touch("createdAt");
    }
    //endregion

    //region isSet methods
    public Boolean isCurrentBatchSet() {
        return this.isSet.contains("currentBatch");
    }

    public Boolean isNumberOfBatchesSet() {
        return this.isSet.contains("numberOfBatches");
    }

    public Boolean isStateSet() {
        return this.isSet.contains("state");
    }

    public Boolean isStrategySet() {
        return this.isSet.contains("strategy");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
