package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiInitiateRoll implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                     isSet;
    private Integer            batchSizePercentage;
    private Integer      batchMinHealthyPercentage;
    private String                         comment;
    private Boolean                     respectPdb;
    private List<String>               instanceIds;
    private Boolean   disableLaunchSpecAutoScaling;
    private List<String>             launchSpecIds;


    public ApiInitiateRoll() {
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

    public Integer getBatchMinHealthyPercentage() {
        return batchMinHealthyPercentage;
    }

    public void setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
        isSet.add("batchMinHealthyPercentage");
        this.batchMinHealthyPercentage = batchMinHealthyPercentage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        isSet.add("comment");
        this.comment = comment;
    }

    public Boolean getRespectPdb() {
        return respectPdb;
    }

    public void setRespectPdb(Boolean respectPdb) {
        isSet.add("respectPdb");
        this.respectPdb = respectPdb;
    }

    public Boolean getDisableLaunchSpecAutoScaling() {
        return disableLaunchSpecAutoScaling;
    }

    public void setDisableLaunchSpecAutoScaling(Boolean disableLaunchSpecAutoScaling) {
        isSet.add("disableLaunchSpecAutoScaling");
        this.disableLaunchSpecAutoScaling = disableLaunchSpecAutoScaling;
    }

    public List<String> getInstanceIds() {
        return instanceIds;
    }

    public void setInstanceIds(List<String> instanceIds) {
        isSet.add("instanceIds");
        this.instanceIds = instanceIds;
    }

    public List<String> getLaunchSpecIds() {
        return launchSpecIds;
    }

    public void setLaunchSpecIds(List<String> launchSpecIds) {
        isSet.add("launchSpecIds");
        this.launchSpecIds = launchSpecIds;
    }

    @JsonIgnore
    public boolean isBatchSizePercentageSet() {
        return isSet.contains("batchSizePercentage");
    }

    @JsonIgnore
    public boolean isCommentSet() {
        return isSet.contains("comment");
    }

    @JsonIgnore
    public boolean isRespectPdbSet() {
        return isSet.contains("respectPdb");
    }

    @JsonIgnore
    public boolean isBatchMinHealthyPercentageSet() {
        return isSet.contains("batchMinHealthyPercentage");
    }

    @JsonIgnore
    public boolean isInstanceIdsSet() {
        return isSet.contains("instanceIds");
    }

    @JsonIgnore
    public boolean isLaunchSpecIdsSet() {
        return isSet.contains("launchSpecIds");
    }

    @JsonIgnore
    public boolean isDisableLaunchSpecAutoScalingSet() {
        return isSet.contains("disableLaunchSpecAutoScaling");
    }

    @JsonIgnore
    public boolean isAllocatableMemoryInMiBSet() {
        return isSet.contains("allocatableMemoryInMiB");
    }
}