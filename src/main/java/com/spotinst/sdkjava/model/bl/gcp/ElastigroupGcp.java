package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ElastigroupGcp {
    //region Members
    @JsonIgnore
    private Set<String>            isSet;
    private String                 id;
    private String                 name;
    private String                 description;
    private ElastigroupCapacityGcp capacity;
    private ElastigroupStrategyGcp strategy;
    private ElastigroupComputeGcp  compute;
    private Date                   createdAt;
    private Date                   updatedAt;
    //endregion

    //region Constructor
    private ElastigroupGcp() {
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

    public ElastigroupCapacityGcp getCapacity() {
        return capacity;
    }

    public void setCapacity(ElastigroupCapacityGcp capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ElastigroupStrategyGcp getStrategy() {
        return strategy;
    }

    public void setStrategy(ElastigroupStrategyGcp strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ElastigroupComputeGcp getCompute() {
        return compute;
    }

    public void setCompute(ElastigroupComputeGcp compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private ElastigroupGcp elastigroup;
        //endregion


        private Builder() {
            this.elastigroup = new ElastigroupGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setId(final String elastigroupId) {
            elastigroup.setId(elastigroupId);
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

        public Builder setCapacity(final ElastigroupCapacityGcp capacity) {
            elastigroup.setCapacity(capacity);
            return this;
        }

        public Builder setStrategy(final ElastigroupStrategyGcp strategy) {
            elastigroup.setStrategy(strategy);
            return this;
        }

        public Builder setCompute(final ElastigroupComputeGcp compute) {
            elastigroup.setCompute(compute);
            return this;
        }

        public ElastigroupGcp build() {
            // Validations
            return elastigroup;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() { return isSet.contains("id"); }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() { return isSet.contains("name"); }

    // Is description Set boolean method
    @JsonIgnore
    public boolean isDescriptionSet() { return isSet.contains("description"); }

    // Is capacity Set boolean method
    @JsonIgnore
    public boolean isCapacitySet() { return isSet.contains("capacity"); }

    // Is strategy Set boolean method
    @JsonIgnore
    public boolean isStrategySet() { return isSet.contains("strategy"); }

    // Is compute Set boolean method
    @JsonIgnore
    public boolean isComputeSet() { return isSet.contains("compute"); }

    // Is createdAt Set boolean method
    @JsonIgnore
    public boolean isCreatedAtSet() { return isSet.contains("createdAt"); }

    // Is updatedAt Set boolean method
    @JsonIgnore
    public boolean isUpdatedAtSet() { return isSet.contains("updatedAt"); }
    //endregion
}
