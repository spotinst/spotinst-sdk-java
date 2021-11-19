package com.spotinst.sdkjava.model;

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

public class ApiElastigroupGetGroupDeploymentStatusResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                      isSet;
    private String                           id;
    private String                           status;
    private ApiElastigroupDeploymentProgress progress;
    private Date                             createdAt;
    private Date                             updatedAt;

    public ApiElastigroupGetGroupDeploymentStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public ApiElastigroupDeploymentProgress getProgress() {
        return progress;
    }

    public void setProgress(ApiElastigroupDeploymentProgress progress) {
        isSet.add("progress");
        this.progress = progress;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

    @JsonIgnore
    public boolean isProgressSet() {
        return isSet.contains("progress");
    }

    @JsonIgnore
    public Boolean isUpdatedAtSet(){
        return this.isSet.contains("updatedAt");
    }

    @JsonIgnore
    public Boolean isCreatedAtSet(){
        return this.isSet.contains("createdAt");
    }
}
