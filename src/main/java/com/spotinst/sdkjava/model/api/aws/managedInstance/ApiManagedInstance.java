package com.spotinst.sdkjava.model.api.aws.managedInstance;

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
public class ApiManagedInstance implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>     isSet;
    private ApiCompute      compute;
    private String          description;
    private ApiHealthCheck  healthCheck;
    private ApiIntegrations integrations;
    private String          name;
    private ApiPersistence  persistence;
    private String          region;
    private ApiScheduling   scheduling;
    private ApiStrategy     strategy;
    private String          id;

    public ApiManagedInstance() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiCompute getCompute() {
        return compute;
    }

    public void setCompute(ApiCompute compute) {
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

    public ApiHealthCheck getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(ApiHealthCheck healthCheck) {
        isSet.add("healthCheck");
        this.healthCheck = healthCheck;
    }

    public ApiIntegrations getIntegrations() {
        return integrations;
    }

    public void setIntegrations(ApiIntegrations integrations) {
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

    public ApiPersistence getPersistence() {
        return persistence;
    }

    public void setPersistence(ApiPersistence persistence) {
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

    public ApiScheduling getScheduling() {
        return scheduling;
    }

    public void setScheduling(ApiScheduling scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }

    public ApiStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiStrategy strategy) {
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
