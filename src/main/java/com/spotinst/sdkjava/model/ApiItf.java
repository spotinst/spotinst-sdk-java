package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiItf implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private String                   weightStrategy;
    private Integer                  migrationHealthinessThreshold;
    private Boolean                  fixedTargetGroups;
    private ApiTargetGroupConfig     targetGroupConfig;
    private List<ApiItfLoadBalancer> loadBalancers;
    //endregion

    //region Constructor

    public ApiItf() {
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

    public String getWeightStrategy() {
        return weightStrategy;
    }

    public void setWeightStrategy(String weightStrategy) {
        isSet.add("weightStrategy");
        this.weightStrategy = weightStrategy;
    }

    public Integer getMigrationHealthinessThreshold() {
        return migrationHealthinessThreshold;
    }

    public void setMigrationHealthinessThreshold(Integer migrationHealthinessThreshold) {
        isSet.add("migrationHealthinessThreshold");
        this.migrationHealthinessThreshold = migrationHealthinessThreshold;
    }

    public Boolean getFixedTargetGroups() {
        return fixedTargetGroups;
    }

    public void setFixedTargetGroups(Boolean fixedTargetGroups) {
        isSet.add("fixedTargetGroups");
        this.fixedTargetGroups = fixedTargetGroups;
    }

    public ApiTargetGroupConfig getTargetGroupConfig() {
        return targetGroupConfig;
    }

    public void setTargetGroupConfig(ApiTargetGroupConfig targetGroupConfig) {
        isSet.add("targetGroupConfig");
        this.targetGroupConfig = targetGroupConfig;
    }

    public List<ApiItfLoadBalancer> getLoadBalancers() {
        return loadBalancers;
    }

    public void setLoadBalancers(List<ApiItfLoadBalancer> loadBalancers) {
        isSet.add("loadBalancers");
        this.loadBalancers = loadBalancers;
    }

    //endregion

    //region isSet methods

    // Is weightStrategy Set boolean method
    @JsonIgnore
    public boolean isWeightStrategySet() { return isSet.contains("weightStrategy"); }

    // Is migrationHealthinessThreshold Set boolean method
    @JsonIgnore
    public boolean isMigrationHealthinessThresholdSet() { return isSet.contains("migrationHealthinessThreshold"); }

    // Is fixedTargetGroups Set boolean method
    @JsonIgnore
    public boolean isFixedTargetGroupsSet() { return isSet.contains("fixedTargetGroups"); }

    // Is targetGroupConfig Set boolean method
    @JsonIgnore
    public boolean isTargetGroupConfigSet() { return isSet.contains("targetGroupConfig"); }

    // Is loadBalancers Set boolean method
    @JsonIgnore
    public boolean isLoadBalancersSet() { return isSet.contains("loadBalancers"); }

    //endregion
}
