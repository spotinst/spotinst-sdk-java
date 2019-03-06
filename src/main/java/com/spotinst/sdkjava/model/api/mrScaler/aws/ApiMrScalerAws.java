package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAws {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String id;
    private String name;
    private String description;
    private String region;
    private ApiMrScalerAwsStrategyConfiguration strategy;
    private ApiMrScalerAwsComputeConfiguration compute;
    private ApiMrScalerAwsScalingConfiguration scaling;
    private ApiMrScalerAwsScalingConfiguration coreScaling;
    private ApiMrScalerAwsClusterConfiguration cluster;
    private ApiMrScalerAwsSchedulingConfiguration scheduling;
    private Date createdAt;
    private Date updatedAt;
    // endregion

    //region Constructor
    public ApiMrScalerAws() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    // region ID
    public String getId(){
        return id;
    }

    public void setId(String id){
        isSet.add("id");
        this.id = id;
    }

    public Boolean isIdSet(){
        return isSet.contains("id");
    }
    // endregion

    // region Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Boolean isNameSet(){
        return isSet.contains("name");
    }
    // endregion

    // region Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public Boolean isDescriptionSet(){
        return isSet.contains("description");
    }
    // endregion

    // region Region
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public Boolean isRegionSet(){
        return isSet.contains("region");
    }
    // endregion

    // region Strategy
    public ApiMrScalerAwsStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiMrScalerAwsStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public Boolean isStrategySet(){
        return isSet.contains("strategy");
    }
    // endregion

    // region Compute
    public ApiMrScalerAwsComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ApiMrScalerAwsComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    public Boolean isComputeSet(){
        return isSet.contains("compute");
    }
    // endregion

    // region Cluster
    public ApiMrScalerAwsClusterConfiguration getCluster() {
        return cluster;
    }

    public void setCluster(ApiMrScalerAwsClusterConfiguration cluster) {
        isSet.add("cluster");
        this.cluster = cluster;
    }

    public Boolean isClusterSet(){
        return isSet.contains("cluster");
    }
    // endregion

    // region Core Scaling
    public ApiMrScalerAwsScalingConfiguration getCoreScaling() {
        return coreScaling;
    }

    public void setCoreScaling(ApiMrScalerAwsScalingConfiguration coreScaling) {
        isSet.add("coreScaling");
        this.coreScaling = coreScaling;
    }

    public Boolean isCoreScalingSet(){
        return isSet.contains("coreScaling");
    }
    // endregion

    // region Scaling
    public ApiMrScalerAwsScalingConfiguration getScaling() {
        return scaling;
    }

    public void setScaling(ApiMrScalerAwsScalingConfiguration scaling) {
        isSet.add("scaling");
        this.scaling = scaling;
    }

    public Boolean isScalingSet(){
        return isSet.contains("scaling");
    }
    // endregion

    // region Scheduling
    public ApiMrScalerAwsSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(ApiMrScalerAwsSchedulingConfiguration scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }

    public Boolean isSchedulingSet(){
        return isSet.contains("scheduling");
    }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAws apiMrScalerAws;

        private Builder() { this.apiMrScalerAws = new ApiMrScalerAws(); }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;

        }

        //region Build methods
        public Builder setName(final String name) {
            apiMrScalerAws.setName(name);
            return this;
        }

        protected Builder setId(final String id) {
            apiMrScalerAws.setId(id);
            return this;
        }

        public Builder setDescription(final String description) {
            apiMrScalerAws.setDescription(description);
            return this;
        }

        public Builder setRegion(final String mrScalerRegion) {
            apiMrScalerAws.setRegion(mrScalerRegion);
            return this;
        }

        public Builder setStrategy(final ApiMrScalerAwsStrategyConfiguration strategy){
            apiMrScalerAws.setStrategy(strategy);
            return this;
        }

        public Builder setCompute(final ApiMrScalerAwsComputeConfiguration compute){
            apiMrScalerAws.setCompute(compute);
            return this;
        }

        public Builder setCluster(final ApiMrScalerAwsClusterConfiguration cluster){
            apiMrScalerAws.setCluster(cluster);
            return this;
        }

        public Builder setScaling(final ApiMrScalerAwsScalingConfiguration scaling){
            apiMrScalerAws.setScaling(scaling);
            return this;
        }

        public Builder seCoretScaling(final ApiMrScalerAwsScalingConfiguration coreScaling){
            apiMrScalerAws.setCoreScaling(coreScaling);
            return this;
        }

        public Builder setScheduling(final ApiMrScalerAwsSchedulingConfiguration scheduling){
            apiMrScalerAws.setScheduling(scheduling);
            return this;
        }

        public ApiMrScalerAws build(){
            return apiMrScalerAws;
        }
        // endregion
    }
}
