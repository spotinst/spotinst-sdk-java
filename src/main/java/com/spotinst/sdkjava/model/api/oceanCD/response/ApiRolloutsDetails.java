package com.spotinst.sdkjava.model.api.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiRolloutsDetails implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 id;
    private String                 status;
    private ApiSpotDeployment spotDeployment;
    private String                 strategyType;
    private Date                   startTime;
    private Date                   endTime;
    private String                 clusterId;
    private String                 namespace;
    private String                 strategy;
    private String                 strategyName;
    private String                 rolloutSpec;
    private String                 cloudProvider;

    private ApiRolloutsDetails() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public ApiSpotDeployment getSpotDeployment() {
        return spotDeployment;
    }

    public void setSpotDeployment(ApiSpotDeployment spotDeployment) {
        isSet.add("spotDeployment");
        this.spotDeployment = spotDeployment;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        isSet.add("strategyType");
        this.strategyType = strategyType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        isSet.add("startTime");
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        isSet.add("endTime");
        this.endTime = endTime;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        isSet.add("clusterId");
        this.clusterId = clusterId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        isSet.add("namespace");
        this.namespace = namespace;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        isSet.add("strategyName");
        this.strategyName = strategyName;
    }

    public String getRolloutSpec() {
        return rolloutSpec;
    }

    public void setRolloutSpec(String rolloutSpec) {
        isSet.add("rolloutSpec");
        this.rolloutSpec = rolloutSpec;
    }

    public String getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        isSet.add("cloudProvider");
        this.cloudProvider = cloudProvider;
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

    @JsonIgnore
    public boolean isStrategyTypeSet() {
        return isSet.contains("strategyType");
    }

    @JsonIgnore
    public boolean isStartTimeSet() {
        return isSet.contains("startTime");
    }

    @JsonIgnore
    public boolean isEndTimeSet() {
        return isSet.contains("endTime");
    }

    @JsonIgnore
    public boolean isClusterIdSet() {
        return isSet.contains("clusterId");
    }

    @JsonIgnore
    public boolean isSpotDeploymentSet() {
        return isSet.contains("spotDeployment");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isNamespaceSet() {
        return isSet.contains("namespace");
    }

    @JsonIgnore
    public boolean isStrategyNameSet() {
        return isSet.contains("strategyName");
    }

    @JsonIgnore
    public boolean isRolloutSpecSet() {
        return isSet.contains("rolloutSpec");
    }

    @JsonIgnore
    public boolean isCloudProviderSet() {
        return isSet.contains("cloudProvider");
    }
}