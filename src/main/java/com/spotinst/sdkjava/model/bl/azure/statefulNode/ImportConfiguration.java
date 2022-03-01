package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportConfiguration {

    @JsonIgnore
    private Set<String> isSet;
    private String                               originalVmName;
    private Integer                              drainingTimeout;
    private Integer                              resourcesRetentionTime;
    private String                               resourceGroupName;
    @JsonProperty("node")
    private StatefulNode                         node;
    private String                               statefulImportId;


    private ImportConfiguration() {
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

    public StatefulNode getNode() {
        return node;
    }

    public void setNode(StatefulNode node) {
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

    public static class Builder {
        private ImportConfiguration importConfiguration;

        private Builder() {
            this.importConfiguration = new ImportConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }


        public Builder setOriginalVmName(final String originalVmName) {
            importConfiguration.setOriginalVmName(originalVmName);
            return this;
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            importConfiguration.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setResourcesRetentionTime(final Integer resourcesRetentionTime) {
            importConfiguration.setResourcesRetentionTime(resourcesRetentionTime);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            importConfiguration.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setNode(final StatefulNode node) {
            importConfiguration.setNode(node);
            return this;
        }

        public Builder setStatefulImportId(final String statefulImportId) {
            importConfiguration.setStatefulImportId(statefulImportId);
            return this;
        }

        public ImportConfiguration build() {
            return importConfiguration;
        }
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
