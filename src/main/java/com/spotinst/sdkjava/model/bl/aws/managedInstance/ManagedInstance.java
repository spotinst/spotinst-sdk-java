package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ManagedInstance implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>     isSet;
    private Compute         compute;
    private String          description;
    private HealthCheck     healthCheck;
    private Integrations    integrations;
    private String          name;
    private Persistence     persistence;
    private String          region;
    private Scheduling      scheduling;
    private Strategy        strategy;
    private String          id;

    private ManagedInstance() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Compute getCompute() {
        return compute;
    }

    public void setCompute(Compute compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public HealthCheck getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(HealthCheck healthCheck) {
        isSet.add("healthCheck");
        this.healthCheck = healthCheck;
    }

    public Integrations getIntegrations() {
        return integrations;
    }

    public void setIntegrations(Integrations integrations) {
        isSet.add("integrations");
        this.integrations = integrations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Persistence getPersistence() {
        return persistence;
    }

    public void setPersistence(Persistence persistence) {
        isSet.add("persistence");
        this.persistence = persistence;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public Scheduling getScheduling() {
        return scheduling;
    }

    public void setScheduling(Scheduling scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public static class Builder {
        private ManagedInstance managedInstance;

        private Builder() {
            this.managedInstance = new ManagedInstance();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCompute(final Compute compute) {
            managedInstance.setCompute(compute);
            return this;
        }

        public Builder setDescription(final String description) {
            managedInstance.setDescription(description);
            return this;
        }

        public Builder setHealthCheck(final HealthCheck healthCheck) {
            managedInstance.setHealthCheck(healthCheck);
            return this;
        }

        public Builder setIntegrations(final Integrations integrations) {
            managedInstance.setIntegrations(integrations);
            return this;
        }

        public Builder setName(final String name) {
            managedInstance.setName(name);
            return this;
        }

        public Builder setPersistence(final Persistence persistence) {
            managedInstance.setPersistence(persistence);
            return this;
        }

        public Builder setRegion(final String region) {
            managedInstance.setRegion(region);
            return this;
        }

        public Builder setScheduling(final Scheduling scheduling) {
            managedInstance.setScheduling(scheduling);
            return this;
        }

        public Builder setStrategy(final Strategy strategy) {
            managedInstance.setStrategy(strategy);
            return this;
        }

        public Builder setId(final String id) {
            managedInstance.setId(id);
            return this;
        }

        public ManagedInstance build() {
            return managedInstance;
        }
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isHealthCheckSet() {
        return isSet.contains("healthCheck");
    }

    @JsonIgnore
    public boolean isIntegrationsSet() {
        return isSet.contains("integrations");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isPersistenceSet() {
        return isSet.contains("persistence");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }
}
