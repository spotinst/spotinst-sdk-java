package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class OceanGkeCluster {

    @JsonIgnore
    private Set<String>                    isSet;
    private String                         id;
    private String                         name;
    private ClusterAutoScalerConfiguration autoScaler;
    private ClusterCapacityConfiguration   capacity;
    private ClusterComputeConfiguration    compute;
    private String                         controllerClusterId;
    private ClusterGkeConfiguration        gke;
    private ClusterSchedulingConfiguration scheduling;
    private ClusterSecurityConfiguration   security;
    private ClusterStrategyConfiguration   strategy;

    private OceanGkeCluster() {
        isSet = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String launchSpecId) {
        this.id = launchSpecId;
        isSet.add("id");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        isSet.add("name");
    }

    public ClusterAutoScalerConfiguration getAutoScaler() {
        return autoScaler;
    }

    public void setAutoScaler(ClusterAutoScalerConfiguration autoScaler) {
        this.autoScaler = autoScaler;
        isSet.add("autoScaler");
    }

    public ClusterCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ClusterCapacityConfiguration capacity) {
        this.capacity = capacity;
        isSet.add("capacity");
    }

    public ClusterComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ClusterComputeConfiguration compute) {
        this.compute = compute;
        isSet.add("compute");
    }

    public String getControllerClusterId() {
        return controllerClusterId;
    }

    public void setControllerClusterId(String controllerClusterId) {
        this.controllerClusterId = controllerClusterId;
        isSet.add("controllerClusterId");
    }

    public ClusterGkeConfiguration getGke() {
        return gke;
    }

    public void setGke(ClusterGkeConfiguration gke) {
        isSet.add("gke");
        this.gke = gke;
    }

    public ClusterSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(ClusterSchedulingConfiguration scheduling) {
        this.scheduling = scheduling;
        isSet.add("scheduling");
    }

    public ClusterSecurityConfiguration getSecurity() {
        return security;
    }

    public void setSecurity(ClusterSecurityConfiguration security) {
        this.security = security;
        isSet.add("security");
    }

    public ClusterStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ClusterStrategyConfiguration strategy) {
        this.strategy = strategy;
        isSet.add("strategy");
    }

    public static class Builder {
        //region Members
        private OceanGkeCluster oceanGkeCluster;
        //endregion

        private Builder() {
            this.oceanGkeCluster = new OceanGkeCluster();
        }

        public static OceanGkeCluster.Builder get() {
            return new Builder();
        }

        public Builder setId(final String oceanGkeClusterId) {
            oceanGkeCluster.setId(oceanGkeClusterId);
            return this;
        }

        public Builder setName(final String name) {
            oceanGkeCluster.setName(name);
            return this;
        }

        public Builder setControllerClusterId(final String controllerClusterId) {
            oceanGkeCluster.setControllerClusterId(controllerClusterId);
            return this;
        }

        public Builder setAutoScaler(final ClusterAutoScalerConfiguration autoScaler) {
            oceanGkeCluster.setAutoScaler(autoScaler);
            return this;
        }

        public Builder setCapacity(final ClusterCapacityConfiguration capacity) {
            oceanGkeCluster.setCapacity(capacity);
            return this;
        }

        public Builder setCompute(final ClusterComputeConfiguration compute) {
            oceanGkeCluster.setCompute(compute);
            return this;
        }

        public Builder setGke(final ClusterGkeConfiguration gke) {
            oceanGkeCluster.setGke(gke);
            return this;
        }

        public Builder setScheduling(final ClusterSchedulingConfiguration scheduling) {
            oceanGkeCluster.setScheduling(scheduling);
            return this;
        }

        public Builder setStrategy(final ClusterStrategyConfiguration strategy) {
            oceanGkeCluster.setStrategy(strategy);
            return this;
        }

        public Builder setSecurity(final ClusterSecurityConfiguration security) {
            oceanGkeCluster.setSecurity(security);
            return this;
        }

        public OceanGkeCluster build() {
            // Validations
            return oceanGkeCluster;
        }
        //endregion
    }

    @JsonIgnore
    public Boolean isIdSet() { return isSet.contains("id"); }

    @JsonIgnore
    public Boolean isNameSet() { return isSet.contains("name"); }

    @JsonIgnore
    public Boolean isControllerClusterIdSet() { return isSet.contains("controllerClusterId"); }

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
    public boolean isGkeSet() {
        return isSet.contains("gke");
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

}

