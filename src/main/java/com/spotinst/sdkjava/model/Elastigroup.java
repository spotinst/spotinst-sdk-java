package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by aharontwizer on 8/24/15.
 */
public class Elastigroup {
    //region Members
    @JsonIgnore
    private Set<String>                                     isSet;
    private String                                          id;
    private String                                          name;
    private String                                          description;
    private String                                          region;
    private ElastigroupCapacityConfiguration                capacity;
    private ElastigroupStrategyConfiguration                strategy;
    private ElastigroupComputeConfiguration                 compute;
    private ElastigroupScalingConfiguration                 scaling;
    private ElastigroupThirdPartiesIntegrationConfiguration thirdPartiesIntegration;
    private ElastigroupSchedulingConfiguration              scheduling;
    private Date                                            createdAt;
    private Date                                            updatedAt;
    //endregion

    //region Constructor

    private Elastigroup() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public ElastigroupThirdPartiesIntegrationConfiguration getThirdPartiesIntegration() {
        return thirdPartiesIntegration;
    }

    public void setThirdPartiesIntegration(ElastigroupThirdPartiesIntegrationConfiguration thirdPartiesIntegration) {
        isSet.add("thirdPartiesIntegration");
        this.thirdPartiesIntegration = thirdPartiesIntegration;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public ElastigroupCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ElastigroupCapacityConfiguration capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ElastigroupStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ElastigroupStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ElastigroupComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ElastigroupComputeConfiguration compute) {
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

    public ElastigroupScalingConfiguration getScaling() {
        return scaling;
    }

    public void setScaling(ElastigroupScalingConfiguration scaling) {
        isSet.add("scaling");
        this.scaling = scaling;
    }
    public ElastigroupSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(ElastigroupSchedulingConfiguration scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }
    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private Elastigroup elastigroup;
        //endregion


        private Builder() {
            this.elastigroup = new Elastigroup();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        protected Builder setId(final String elastigroupId) {
            elastigroup.setId(elastigroupId);
            return this;
        }

        public Builder setThirdPartiesIntegration(final ElastigroupThirdPartiesIntegrationConfiguration thirdPartiesIntegration) {
            elastigroup.setThirdPartiesIntegration(thirdPartiesIntegration);
            return this;
        }

        public Builder setScheduling(final ElastigroupSchedulingConfiguration scheduling){
            elastigroup.setScheduling(scheduling);
            return this;
        }

        public Builder setName(final String name) {
            elastigroup.setName(name);
            return this;
        }

        public Builder setDescription(final String description) {
            elastigroup.setDescription(description);
            return this;
        }

        public Builder setRegion(final String region) {
            elastigroup.setRegion(region);
            return this;
        }

        public Builder setCapacity(final ElastigroupCapacityConfiguration capacity) {
            elastigroup.setCapacity(capacity);
            return this;
        }

        public Builder setStrategy(final ElastigroupStrategyConfiguration strategy) {
            elastigroup.setStrategy(strategy);
            return this;
        }

        public Builder setCompute(final ElastigroupComputeConfiguration compute) {
            elastigroup.setCompute(compute);
            return this;
        }

        public Builder setScaling(final ElastigroupScalingConfiguration elastigroupScalingConfiguration) {
            elastigroup.setScaling(elastigroupScalingConfiguration);
            return this;
        }

        public Elastigroup build() {
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


    // Is description Set boolean method
    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
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
