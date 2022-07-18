package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ImportOceanClusterAks {

    @JsonIgnore
    private Set<String>                           isSet;
    private String                                id;
    private ClusterConfigurationAks               aks;
    private String                                controllerClusterId;
    private String                                name;
    private ImportClusterAutoScalerConfiguration  autoScaler;
    private ImportClusterStrategyConfiguration    strategy;
    private ImportClusterHealth                   health;
    private ImportClusterVirtualNodeGroupTemplate virtualNodeGroupTemplate;
    private Date                                  createdAt;
    private Date                                  updatedAt;


    private ImportOceanClusterAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public ImportOceanClusterAks setIsSet(Set<String> isSet) {
        this.isSet = isSet;
        return this;
    }

    public ClusterConfigurationAks getAks() {
        return aks;
    }

    public void setAks(ClusterConfigurationAks aks) {
        isSet.add("aks");
        this.aks = aks;
    }

    public String getControllerClusterId() {
        return controllerClusterId;
    }

    public void setControllerClusterId(String controllerClusterId) {
        isSet.add("controllerClusterId");
        this.controllerClusterId = controllerClusterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public ImportClusterAutoScalerConfiguration getAutoScaler() {

        return autoScaler;
    }

    public void setAutoScaler(ImportClusterAutoScalerConfiguration autoScaler) {

        isSet.add("autoScaler");
        this.autoScaler = autoScaler;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public ImportClusterStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ImportClusterStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ImportClusterHealth getHealth() {
        return health;
    }

    public void setHealth(ImportClusterHealth health) {
        isSet.add("health");
        this.health = health;
    }

    public ImportClusterVirtualNodeGroupTemplate getVirtualNodeGroupTemplate() {
        return virtualNodeGroupTemplate;
    }

    public void setVirtualNodeGroupTemplate(ImportClusterVirtualNodeGroupTemplate virtualNodeGroupTemplate) {
        isSet.add("virtualNodeGroupTemplate");
        this.virtualNodeGroupTemplate = virtualNodeGroupTemplate;
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

    public static class Builder {

        private ImportOceanClusterAks clusterAks;

        private Builder() {
            this.clusterAks = new ImportOceanClusterAks();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setControllerClusterId(final String controllerClusterId) {
            clusterAks.setControllerClusterId(controllerClusterId);
            return this;
        }

        public Builder setName(final String name) {
            clusterAks.setName(name);
            return this;

        }

        public Builder setAks(final ClusterConfigurationAks aks) {
            clusterAks.setAks(aks);
            return this;
        }

        public Builder setVirtualNodeGroupTemplate(final ImportClusterVirtualNodeGroupTemplate virtualNodeGroupTemplate) {
            clusterAks.setVirtualNodeGroupTemplate(virtualNodeGroupTemplate);
            return this;
        }

        public Builder setId(final String id) {
            clusterAks.setId(id);
            return this;
        }

        public Builder setHealth(final ImportClusterHealth health) {
            clusterAks.setHealth(health);
            return this;
        }

        public Builder setStrategy(final ImportClusterStrategyConfiguration strategy) {
            clusterAks.setStrategy(strategy);
            return this;
        }

        public Builder setAutoScaler(final ImportClusterAutoScalerConfiguration autoScaler) {
            clusterAks.setAutoScaler(autoScaler);
            return this;
        }

        public ImportOceanClusterAks build() {
            return clusterAks;
        }
    }

    @JsonIgnore
    public boolean isAksSet() {
        return isSet.contains("aks");
    }

    @JsonIgnore
    public boolean isControllerClusterIdSet() {
        return isSet.contains("controllerClusterId");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupTemplateSet() {
        return isSet.contains("virtualNodeGroupTemplate");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isHealthSet() {
        return isSet.contains("health");
    }

    @JsonIgnore
    public boolean isAutoScalerSet() {
        return isSet.contains("autoScaler");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }

}