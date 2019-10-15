package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiEcs implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>       isSet;
    private String            clusterName;
    private ApiAutoScale      autoScale;
    private ApiOptimizeImages optimizeImages;
    private ApiBatch          batch;
    //endregion

    //region Constructor
    public ApiEcs() {
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

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        isSet.add("clusterName");
        this.clusterName = clusterName;
    }

    public ApiAutoScale getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ApiAutoScale autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public ApiOptimizeImages getOptimizeImages() {
        return optimizeImages;
    }

    public void setOptimizeImages(ApiOptimizeImages optimizeImages) {
        isSet.add("optimizeImages");
        this.optimizeImages = optimizeImages;
    }

    public ApiBatch getBatch() {
        return batch;
    }

    public void setBatch(ApiBatch batch) {
        isSet.add("batch");
        this.batch = batch;
    }

    //endregion
    // Is autoScale Set boolean method
    @JsonIgnore
    public boolean isAutoScaleSet() {
        return isSet.contains("autoScale");
    }

    // Is clusterName Set boolean method
    @JsonIgnore
    public boolean isClusterNameSet() {
        return isSet.contains("clusterName");
    }

    // Is optimizeImages Set boolean method
    @JsonIgnore
    public boolean isOptimizeImagesSet() {
        return isSet.contains("optimizeImages");
    }

    // Is batch Set boolean method
    @JsonIgnore
    public boolean isApiBatchSet() {
        return isSet.contains("batch");
    }

    //endregion
}
