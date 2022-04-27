package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ElastigroupAzure {
    //region Members
    @JsonIgnore
    private Set<String>                             isSet;
    private String                                  id;
    private String                                  name;
    private String                                  region;
    private String                                  resourceGroupName;
    private ElastigroupCapacityConfigurationAzure   capacity;
    private ElastigroupStrategyConfigurationAzure   strategy;
    private ElastigroupHealthConfigurationAzure     health;
    private ElastigroupComputeConfigurationAzure    compute;
    private ElastigroupScalingConfigurationAzure    scaling;
    private ElastigroupSchedulingConfigurationAzure scheduling;
    private Date                                    createdAt;
    private Date                                    updatedAt;
    //endregion

    //region Constructor

    private ElastigroupAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
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

    public ElastigroupHealthConfigurationAzure getHealth() {
        return health;
    }

    public void setHealth(ElastigroupHealthConfigurationAzure health) {
        isSet.add("health");
        this.health = health;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public ElastigroupCapacityConfigurationAzure getCapacity() {
        return capacity;
    }

    public void setCapacity(ElastigroupCapacityConfigurationAzure capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ElastigroupStrategyConfigurationAzure getStrategy() {
        return strategy;
    }

    public void setStrategy(ElastigroupStrategyConfigurationAzure strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ElastigroupComputeConfigurationAzure getCompute() {
        return compute;
    }

    public void setCompute(ElastigroupComputeConfigurationAzure compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public ElastigroupScalingConfigurationAzure getScaling() {
        return scaling;
    }

    public void setScaling(ElastigroupScalingConfigurationAzure scaling) {
        isSet.add("scaling");
        this.scaling = scaling;
    }

    public ElastigroupSchedulingConfigurationAzure getScheduling() {
        return scheduling;
    }

    public void setScheduling(ElastigroupSchedulingConfigurationAzure scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }
    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private ElastigroupAzure elastigroup;
        //endregion


        private Builder() {
            this.elastigroup = new ElastigroupAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        protected Builder setId(final String elastigroupId) {
            elastigroup.setId(elastigroupId);
            return this;
        }

        public Builder setScheduling(final ElastigroupSchedulingConfigurationAzure scheduling) {
            elastigroup.setScheduling(scheduling);
            return this;
        }

        public Builder setName(final String name) {
            elastigroup.setName(name);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            elastigroup.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setRegion(final String region) {
            elastigroup.setRegion(region);
            return this;
        }

        public Builder setCapacity(final ElastigroupCapacityConfigurationAzure capacity) {
            elastigroup.setCapacity(capacity);
            return this;
        }

        public Builder setStrategy(final ElastigroupStrategyConfigurationAzure strategy) {
            elastigroup.setStrategy(strategy);
            return this;
        }

        public Builder setCompute(final ElastigroupComputeConfigurationAzure compute) {
            elastigroup.setCompute(compute);
            return this;
        }

        public Builder setScaling(final ElastigroupScalingConfigurationAzure elastigroupScalingConfiguration) {
            elastigroup.setScaling(elastigroupScalingConfiguration);
            return this;
        }

        public Builder setHealth(final ElastigroupHealthConfigurationAzure health) {
            elastigroup.setHealth(health);
            return this;
        }

        public ElastigroupAzure build() {
            // Validations
            return elastigroup;
        }
        //endregion
    }
    //endregion

    //region isSet methods

    // Is thirdPartiesIntegration Set boolean method
    @JsonIgnore
    public boolean isThirdPartiesIntegrationSet() {
        return isSet.contains("thirdPartiesIntegration");
    }

    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }


    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }


    // Is resourceGroupName Set boolean method
    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }


    // Is region Set boolean method
    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }


    // Is capacity Set boolean method
    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }


    // Is strategy Set boolean method
    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }


    // Is compute Set boolean method
    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }


    // Is scaling Set boolean method
    @JsonIgnore
    public boolean isScalingSet() {
        return isSet.contains("scaling");
    }

    // Is health Set boolean method
    @JsonIgnore
    public boolean isHealthSet() {
        return isSet.contains("health");
    }


    // Is createdAt Set boolean method
    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    // Is updatedAt Set boolean method
    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }

    // Is scheduling Set boolean method
    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    //endregion
}
