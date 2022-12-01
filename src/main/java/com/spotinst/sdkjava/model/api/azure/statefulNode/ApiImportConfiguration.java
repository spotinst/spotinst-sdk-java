package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.*;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiImportConfiguration implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                          isSet;
    private String                               originalVmName;
    private Integer                              drainingTimeout;
    private Integer                              resourcesRetentionTime;
    private String                               resourceGroupName;
    @JsonProperty("node")
    private ApiStatefulNode                      node;
    private String                               statefulImportId;


    public ApiImportConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOriginalVmName() {
        return originalVmName;
    }

    public void setOriginalVmName(String originalVmName) {
        isSet.add("originalVmName");
        this.originalVmName = originalVmName;
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }

    public Integer getResourcesRetentionTime() {
        return resourcesRetentionTime;
    }

    public void setResourcesRetentionTime(Integer resourcesRetentionTime) {
        isSet.add("resourcesRetentionTime");
        this.resourcesRetentionTime = resourcesRetentionTime;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public ApiStatefulNode getNode() {
        return node;
    }

    public void setNode(ApiStatefulNode node) {
        isSet.add("node");
        this.node = node;
    }

    public String getStatefulImportId() {
        return statefulImportId;
    }

    public void setStatefulImportId(String statefulImportId) {
        isSet.add("statefulImportId");
        this.statefulImportId = statefulImportId;
    }

    @JsonIgnore
    public boolean isOriginalVmNameSet() {
        return isSet.contains("originalVmName");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    @JsonIgnore
    public boolean isResourcesRetentionTimeSet() {
        return isSet.contains("resourcesRetentionTime");
    }

    @JsonIgnore
    public boolean isNodeSet() {
        return isSet.contains("node");
    }

    @JsonIgnore
    public boolean isStatefulImportIdSet() {
        return isSet.contains("statefulImportId");
    }

}
