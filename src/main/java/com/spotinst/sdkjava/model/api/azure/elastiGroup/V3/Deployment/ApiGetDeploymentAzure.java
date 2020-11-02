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
public class ApiGetDeploymentAzure implements IPartialUpdateEntity {

    //region Members
    @JsonIgnore
    private Set<String>                         isSet;
    private String                              id;
    private String                              status;
    private ApiDeploymentProgressIndicatorAzure progress;
    private Date                                updatedAt;
    private Date                                createdAt;
    //endregion

    //region constructor
    public ApiGetDeploymentAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters and Setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        touch("id");
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        touch("status");
        this.status = status;
    }

    public ApiDeploymentProgressIndicatorAzure getProgress() {
        return progress;
    }

    public void setProgress(ApiDeploymentProgressIndicatorAzure progress) {
        this.progress = progress;
        touch("progress");
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        touch("updatedAt");
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        touch("createdAt");
        this.createdAt = createdAt;
    }
    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isIdSet(){
        return this.isSet.contains("id");
    }
    @JsonIgnore
    public Boolean isStatusSet(){
        return this.isSet.contains("status");
    }
    @JsonIgnore
    public Boolean isProgressSet(){
        return this.isSet.contains("progress");
    }
    @JsonIgnore
    public Boolean isUpdatedAtSet(){
        return this.isSet.contains("updatedAt");
    }
    @JsonIgnore
    public Boolean isCreatedAtSet(){
        return this.isSet.contains("createdAt");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion

}
