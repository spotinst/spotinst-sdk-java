package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAws {
    @JsonIgnore
    private Set<String>                          isSet;
    private String                               id;
    private String                               clusterId;
    private String                               name;
    private String                               description;
    private String                               region;
    private MrScalerAwsStrategyConfiguration strategy;
    private MrScalerAwsComputeConfiguration compute;
    private MrScalerAwsScalingConfiguration scaling;
    private MrScalerAwsScalingConfiguration coreScaling;
    private MrScalerAwsClusterConfiguration cluster;
    private MrScalerAwsSchedulingConfiguration scheduling;
    private Date                                 createdAt;
    private Date                                 updatedAt;

    private MrScalerAws() {
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

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        isSet.add("clusterId");
        this.clusterId = clusterId;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public MrScalerAwsStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(MrScalerAwsStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public MrScalerAwsComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(MrScalerAwsComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    public MrScalerAwsClusterConfiguration getCluster() {
        return cluster;
    }

    public void setCluster(MrScalerAwsClusterConfiguration cluster) {
        isSet.add("cluster");
        this.cluster = cluster;
    }

    public MrScalerAwsScalingConfiguration getCoreScaling() {
        return coreScaling;
    }

    public void setCoreScaling(MrScalerAwsScalingConfiguration coreScaling) {
        isSet.add("coreScaling");
        this.coreScaling = coreScaling;
    }

    public MrScalerAwsScalingConfiguration getScaling() {
        return scaling;
    }

    public void setScaling(MrScalerAwsScalingConfiguration scaling) {
        isSet.add("scaling");
        this.scaling = scaling;
    }

    public MrScalerAwsSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(MrScalerAwsSchedulingConfiguration scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
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

    public static class Builder {
        private MrScalerAws mrScalerAws;

        private Builder() { this.mrScalerAws = new MrScalerAws(); }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;

        }

        public Builder setName(final String name) {
            mrScalerAws.setName(name);
            return this;
        }

        public Builder setId(final String id) {
            mrScalerAws.setId(id);
            return this;
        }

        public Builder setDescription(final String description) {
            mrScalerAws.setDescription(description);
            return this;
        }

        public Builder setRegion(final String mrScalerRegion) {
            mrScalerAws.setRegion(mrScalerRegion);
            return this;
        }

        public Builder setStrategy(final MrScalerAwsStrategyConfiguration strategy){
            mrScalerAws.setStrategy(strategy);
            return this;
        }

        public Builder setCompute(final MrScalerAwsComputeConfiguration compute){
            mrScalerAws.setCompute(compute);
            return this;
        }

        public Builder setCluster(final MrScalerAwsClusterConfiguration cluster){
            mrScalerAws.setCluster(cluster);
            return this;
        }

        public Builder setScaling(final MrScalerAwsScalingConfiguration scaling){
            mrScalerAws.setScaling(scaling);
            return this;
        }

        public Builder seCoreScaling(final MrScalerAwsScalingConfiguration coreScaling){
            mrScalerAws.setCoreScaling(coreScaling);
            return this;
        }

        public Builder setScheduling(final MrScalerAwsSchedulingConfiguration scheduling){
            mrScalerAws.setScheduling(scheduling);
            return this;
        }

        public Builder setCreatedAt(final Date createdAt){
            mrScalerAws.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final Date updatedAt){
            mrScalerAws.setUpdatedAt(updatedAt);
            return this;
        }

        public MrScalerAws build(){
            return mrScalerAws;
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
    public boolean isClusterIdSet() { return isSet.contains("clusterId");}

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    @JsonIgnore
    public boolean isCoreScalingSet() {
        return isSet.contains("coreScaling");
    }

    @JsonIgnore
    public boolean isScalingSet() {
        return isSet.contains("scaling");
    }

    @JsonIgnore
    public boolean isClusterSet() {
        return isSet.contains("cluster");
    }

    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }

}
