package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BlMrScalerAws {
    //region Members
    private String id;
    private String clusterId;
    private String name;
    private String description;
    private String region;
    private BlMrScalerAwsStrategyConfiguration strategy;
    private BlMrScalerAwsComputeConfiguration compute;
    private BlMrScalerAwsScalingConfiguration scaling;
    private BlMrScalerAwsScalingConfiguration coreScaling;
    private BlMrScalerAwsClusterConfiguration cluster;
    private BlMrScalerAwsSchedulingConfiguration scheduling;
    private Date createdAt;
    private Date updatedAt;
    // endregion

    //region Constructor
    public BlMrScalerAws() { }
    // endregion

    //region getters and setters
    // region ID
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    // endregion

    // region clusterId
    public String getClusterId(){ return clusterId;}

    public void setClusterId(String clusterId){
        this.clusterId = clusterId;
    }
    // endregion

    // region Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // endregion

    // region Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // endregion

    // region Region
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    // endregion

    // region Strategy
    public BlMrScalerAwsStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(BlMrScalerAwsStrategyConfiguration strategy) {
        this.strategy = strategy;
    }
    // endregion

    // region Compute
    public BlMrScalerAwsComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(BlMrScalerAwsComputeConfiguration compute) {
        this.compute = compute;
    }
    // endregion

    // region Cluster
    public BlMrScalerAwsClusterConfiguration getCluster() {
        return cluster;
    }

    public void setCluster(BlMrScalerAwsClusterConfiguration cluster) {
        this.cluster = cluster;
    }
    // endregion

    // region Core Scaling
    public BlMrScalerAwsScalingConfiguration getCoreScaling() {
        return coreScaling;
    }

    public void setCoreScaling(BlMrScalerAwsScalingConfiguration coreScaling) {
        this.coreScaling = coreScaling;
    }
    // endregion

    // region Scaling
    public BlMrScalerAwsScalingConfiguration getScaling() {
        return scaling;
    }

    public void setScaling(BlMrScalerAwsScalingConfiguration scaling) {
        this.scaling = scaling;
    }
    // endregion

    // region Scheduling
    public BlMrScalerAwsSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(BlMrScalerAwsSchedulingConfiguration scheduling) {
        this.scheduling = scheduling;
    }
    // endregion

    // region createdAt
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    // endregion

    // region updatedAt
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    // endregion
    // endregion

}
