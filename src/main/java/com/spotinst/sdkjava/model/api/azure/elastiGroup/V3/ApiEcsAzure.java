package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiAutoScale;
import com.spotinst.sdkjava.model.ApiBatch;
import com.spotinst.sdkjava.model.ApiOptimizeImages;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiEcsAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>       isSet;
    private String            clusterName;
    private ApiAutoScaleAzure      autoScale;
    private ApiOptimizeImagesAzure optimizeImages;
    private ApiBatchAzure          batch;
    //endregion

    //region Constructor
    public ApiEcsAzure() {
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

    public ApiAutoScaleAzure getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ApiAutoScaleAzure autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public ApiOptimizeImagesAzure getOptimizeImages() {
        return optimizeImages;
    }

    public void setOptimizeImages(ApiOptimizeImagesAzure optimizeImages) {
        isSet.add("optimizeImages");
        this.optimizeImages = optimizeImages;
    }

    public ApiBatchAzure getBatch() {
        return batch;
    }

    public void setBatch(ApiBatchAzure batch) {
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
