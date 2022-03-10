package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by Bansi Chapla on 20/07/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OceanEcsCluster {

    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 id;
    private String                                 name;
    private String                                 region;
    private String                                 clusterName;
    private ClusterAutoScalerConfiguration         autoScaler;
    private ClusterCapacityConfiguration           capacity;
    private ClusterComputeConfiguration            compute;
    private ClusterSchedulingConfiguration         scheduling;
    private ClusterStrategyConfiguration           strategy;

    private OceanEcsCluster() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setclusterName(String clusterName) {
        isSet.add("clusterName");
        this.clusterName = clusterName;
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

    public ClusterComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ClusterComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
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

    public static class Builder {
        private OceanEcsCluster cluster;

        private Builder() {
            this.cluster = new OceanEcsCluster();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String clusterId) {
            cluster.setId(clusterId);
            return this;
        }

        public Builder setName(final String name) {
            cluster.setName(name);
            return this;
        }
        public Builder setRegion(final String region) {
            cluster.setRegion(region);
            return this;
        }
        public Builder setClusterName(final String clusterName) {
            cluster.setclusterName(clusterName);
            return this;
        }

        public Builder setAutoScaler(final ClusterAutoScalerConfiguration autoScaler) {
            cluster.setAutoScaler(autoScaler);
            return this;
        }

        public Builder setCapacity(final ClusterCapacityConfiguration capacity) {
            cluster.setCapacity(capacity);
            return this;
        }
        public Builder setCompute(final ClusterComputeConfiguration compute) {
            cluster.setCompute(compute);
            return this;
        }
        public Builder setScheduling(final ClusterSchedulingConfiguration scheduling) {
            cluster.setScheduling(scheduling);
            return this;
        }
        public Builder setStrategy(final ClusterStrategyConfiguration strategy) {
            cluster.setStrategy(strategy);
            return this;
        }

        public OceanEcsCluster build() {
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
    public boolean isClusterNameSet() {
        return isSet.contains("clusterName");
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
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

}