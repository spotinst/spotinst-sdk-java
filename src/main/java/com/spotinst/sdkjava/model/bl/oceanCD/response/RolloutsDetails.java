package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolloutsDetails {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 id;
    private String                 status;
    private SpotDeployment         spotDeployment;
    private String                 strategyType;
    private Date                   startTime;
    private Date                   endTime;
    private String                 clusterId;
    private String                 namespace;
    private String                 strategy;
    private String                 strategyName;
    private String                 rolloutSpec;
    private String                 cloudProvider;

    private RolloutsDetails() {
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

    public SpotDeployment getSpotDeployment() {
        return spotDeployment;
    }

    public void setSpotDeployment(SpotDeployment spotDeployment) {
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

    public static class Builder {
        private RolloutsDetails rolloutsDetails;

        private Builder() {
            this.rolloutsDetails = new RolloutsDetails();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            rolloutsDetails.setId(id);
            return this;
        }

        public Builder setSpotDeployment(final SpotDeployment spotDeployment) {
            rolloutsDetails.setSpotDeployment(spotDeployment);
            return this;
        }

        public Builder setStrategy(final String strategy) {
            rolloutsDetails.setStrategy(strategy);
            return this;
        }

        public Builder setStatus(final String status) {
            rolloutsDetails.setStatus(status);
            return this;
        }

        public Builder setStrategyType(final String strategyType) {
            rolloutsDetails.setStrategyType(strategyType);
            return this;
        }

        public Builder setStartTime(final Date startTime) {
            rolloutsDetails.setStartTime(startTime);
            return this;
        }

        public Builder setEndTime(final Date endTime) {
            rolloutsDetails.setEndTime(endTime);
            return this;
        }

        public Builder setClusterId(final String clusterId) {
            rolloutsDetails.setClusterId(clusterId);
            return this;
        }

        public Builder setNamespace(final String namespace) {
            rolloutsDetails.setNamespace(namespace);
            return this;
        }

        public Builder setStrategyName(final String strategyName) {
            rolloutsDetails.setStrategyName(strategyName);
            return this;
        }

        public Builder setRolloutSpec(final String rolloutSpec) {
            rolloutsDetails.setRolloutSpec(rolloutSpec);
            return this;
        }

        public Builder setCloudProvider(final String cloudProvider) {
            rolloutsDetails.setCloudProvider(cloudProvider);
            return this;
        }

        public RolloutsDetails build() {
            return rolloutsDetails;
        }
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