package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiAksInitiateRoll implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                     isSet;
    private Integer            batchSizePercentage;
    private String                         comment;
    private List<String>                   vmNames;
    private List<String>        virtualNodeGroupIds;


    public ApiAksInitiateRoll() {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        isSet.add("comment");
        this.comment = comment;
    }

    public List<String> getVmNames() {
        return vmNames;
    }

    public void setVmNames(List<String> vmNames) {
        isSet.add("vmNames");
        this.vmNames = vmNames;
    }

    public List<String> getVirtualNodeGroupIds() {
        return virtualNodeGroupIds;
    }

    public void setVirtualNodeGroupIds(List<String> virtualNodeGroupIds) {
        isSet.add("virtualNodeGroupIds");
        this.virtualNodeGroupIds = virtualNodeGroupIds;
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
    public boolean isVmNamesSet() {
        return isSet.contains("vmNames");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupIdsSet() {
        return isSet.contains("virtualNodeGroupIds");
    }
}