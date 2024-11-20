package com.spotinst.sdkjava.model.api.mrScaler.aws;

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
public class ApiMrScalerAws implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                           isSet;
    private String                                id;
    private String                                clusterId;
    private String                                name;
    private String                                description;
    private String                                region;
    private ApiMrScalerAwsStrategyConfiguration   strategy;
    private ApiMrScalerAwsComputeConfiguration    compute;
    private ApiMrScalerAwsScalingConfiguration    scaling;
    private ApiMrScalerAwsScalingConfiguration    coreScaling;
    private ApiMrScalerAwsClusterConfiguration    cluster;
    private ApiMrScalerAwsSchedulingConfiguration scheduling;
    private Date                                  createdAt;
    private Date                                  updatedAt;


    public ApiMrScalerAws() {
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

    public ApiMrScalerAwsStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiMrScalerAwsStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ApiMrScalerAwsComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ApiMrScalerAwsComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    public ApiMrScalerAwsClusterConfiguration getCluster() {
        return cluster;
    }

    public void setCluster(ApiMrScalerAwsClusterConfiguration cluster) {
        isSet.add("cluster");
        this.cluster = cluster;
    }

    public ApiMrScalerAwsScalingConfiguration getCoreScaling() {
        return coreScaling;
    }

    public void setCoreScaling(ApiMrScalerAwsScalingConfiguration coreScaling) {
        isSet.add("coreScaling");
        this.coreScaling = coreScaling;
    }

    public ApiMrScalerAwsScalingConfiguration getScaling() {
        return scaling;
    }

    public void setScaling(ApiMrScalerAwsScalingConfiguration scaling) {
        isSet.add("scaling");
        this.scaling = scaling;
    }

    public ApiMrScalerAwsSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(ApiMrScalerAwsSchedulingConfiguration scheduling) {
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
