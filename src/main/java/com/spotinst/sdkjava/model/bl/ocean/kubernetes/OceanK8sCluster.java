package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lihi Shoham on 3/7/2020.
 */
public class OceanK8sCluster {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         id;
    private String                         name;
    private String                         controllerClusterId;
    private String                         region;
    private ClusterAutoScalerConfiguration autoScaler;
    private ClusterCapacityConfiguration   capacity;
    private ClusterStrategyConfiguration   strategy;
    private ClusterSchedulingConfiguration scheduling;
    private ClusterSecurityConfiguration   security;
    private ClusterComputeConfiguration    compute;
    private Date                           createdAt;
    private Date                           updatedAt;

    private OceanK8sCluster() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getControllerClusterId() {
        return controllerClusterId;
    }

    public void setControllerClusterId(String controllerClusterId) {
        isSet.add("controllerClusterId");
        this.controllerClusterId = controllerClusterId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public ClusterAutoScalerConfiguration getAutoScaler() {
        return autoScaler;
    }

    public void setAutoScaler(ClusterAutoScalerConfiguration autoScaler) {
        isSet.add("autoScaler");
        this.autoScaler = autoScaler;
    }

    public ClusterCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ClusterCapacityConfiguration capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ClusterSecurityConfiguration getSecurity() {
        return security;
    }

    public void setSecurity(ClusterSecurityConfiguration security) {
        isSet.add("security");
        this.security = security;
    }

    public ClusterSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(ClusterSchedulingConfiguration scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }

    public ClusterStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ClusterStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ClusterComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ClusterComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
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
        private OceanK8sCluster cluster;

        private Builder() {
            this.cluster = new OceanK8sCluster();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String clusterId) {
            cluster.setId(clusterId);
            return this;
        }

        public Builder setName(final String name) {
            cluster.setName(name);
            return this;
        }

        public Builder setControllerClusterId(final String controllerClusterId) {
            cluster.setControllerClusterId(controllerClusterId);
            return this;
        }

        public Builder setRegion(final String region) {
            cluster.setRegion(region);
            return this;
        }

        public Builder setAutoScaler(final ClusterAutoScalerConfiguration autoscaler) {
            cluster.setAutoScaler(autoscaler);
            return this;
        }

        public Builder setCapacity(final ClusterCapacityConfiguration capacity) {
            cluster.setCapacity(capacity);
            return this;
        }

        public Builder setStrategy(final ClusterStrategyConfiguration strategy) {
            cluster.setStrategy(strategy);
            return this;
        }

        public Builder setScheduling(final ClusterSchedulingConfiguration scheduling) {
            cluster.setScheduling(scheduling);
            return this;
        }

        public Builder setSecurity(final ClusterSecurityConfiguration security) {
            cluster.setSecurity(security);
            return this;
        }

        public Builder setCompute(final ClusterComputeConfiguration compute) {
            cluster.setCompute(compute);
            return this;
        }

        public OceanK8sCluster build() {
            // Validations
            return cluster;
        }
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isControllerClusterIdSet() {
        return isSet.contains("controllerClusterId");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isAutoScalerSet() {
        return isSet.contains("autoScaler");
    }

    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    @JsonIgnore
    public boolean isSecuritySet() {
        return isSet.contains("security");
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
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
