package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNode {

    @JsonIgnore
    private Set<String>                         isSet;
    private String                              id;
    private String                              name;
    private String                              region;
    private String                              resourceGroupName;
    private String                              description;
    private StatefulNodeStrategyConfiguration   strategy;
    private StatefulNodeComputeConfiguration    compute;
    private StatefulNodeSchedulingConfiguration scheduling;
    private StatefulNodePersistentConfiguration persistent;
    private StatefulNodeHealthConfiguration     health;

    private StatefulNode() {
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

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public StatefulNodeStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(StatefulNodeStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public StatefulNodeComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(StatefulNodeComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    public StatefulNodeSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(StatefulNodeSchedulingConfiguration scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }

    public StatefulNodePersistentConfiguration getPersistent() {
        return persistent;
    }

    public void setPersistent(StatefulNodePersistentConfiguration persistent) {
        isSet.add("persistent");
        this.persistent = persistent;
    }

    public StatefulNodeHealthConfiguration getHealth() {
        return health;
    }

    public void setHealth(StatefulNodeHealthConfiguration health) {
        isSet.add("health");
        this.health = health;
    }

    public static class Builder {
        private StatefulNode statefulNode;

        private Builder() {
            this.statefulNode = new StatefulNode();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            statefulNode.setId(id);
            return this;
        }

        public Builder setName(final String name) {
            statefulNode.setName(name);
            return this;
        }

        public Builder setRegion(final String region) {
            statefulNode.setRegion(region);
            return this;
        }

        public Builder setDescription(final String description) {
            statefulNode.setDescription(description);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            statefulNode.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setStrategy(final StatefulNodeStrategyConfiguration strategy) {
            statefulNode.setStrategy(strategy);
            return this;
        }

        public Builder setCompute(final StatefulNodeComputeConfiguration compute) {
            statefulNode.setCompute(compute);
            return this;
        }

        public Builder setScheduling(final StatefulNodeSchedulingConfiguration scheduling) {
            statefulNode.setScheduling(scheduling);
            return this;
        }

        public Builder setPersistent(final StatefulNodePersistentConfiguration persistent) {
            statefulNode.setPersistent(persistent);
            return this;
        }

        public Builder setHealth(final StatefulNodeHealthConfiguration health) {
            statefulNode.setHealth(health);
            return this;
        }

        public StatefulNode build() {
            return statefulNode;
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
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    @JsonIgnore
    public boolean isPersistentSet() {
        return isSet.contains("persistent");
    }

    @JsonIgnore
    public boolean isHealthSet() {
        return isSet.contains("health");
    }

}