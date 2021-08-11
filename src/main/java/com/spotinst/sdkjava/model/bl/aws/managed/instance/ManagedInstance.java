package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class ManagedInstance {

    //region Members
    @JsonIgnore
    private Set<String>     isSet;
    private Compute         compute;
    private String          description;
    private HealthCheck healthCheck;
    private Integrations    integrations;
    private String          name;
    private Persistence persistence;
    private String          region;
    private Scheduling      scheduling;
    private Strategy        strategy;

    //endregion

    //region constructor
    private ManagedInstance() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

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

    //endregion

    //region Builder class
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

        public ManagedInstance build() {
            // TODO : Validations
            return managedInstance;
        }
    }
    //endregion

    //region isSet methods
    // Is compute Set boolean method
    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    // Is description Set boolean method
    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    // Is healthCheck Set boolean method
    @JsonIgnore
    public boolean isHealthCheckSet() {
        return isSet.contains("healthCheck");
    }

    // Is integrations Set boolean method
    @JsonIgnore
    public boolean isIntegrationsSet() {
        return isSet.contains("integrations");
    }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is persistence Set boolean method
    @JsonIgnore
    public boolean isPersistenceSet() {
        return isSet.contains("persistence");
    }

    // Is region Set boolean method
    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    // Is scheduling Set boolean method
    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    // Is strategy Set boolean method
    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }
    //endregion

    }
