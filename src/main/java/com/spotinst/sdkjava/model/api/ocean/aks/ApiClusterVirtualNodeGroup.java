package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiClusterVirtualNodeGroup implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           name;
    private String                           oceanId;
    private ApiClusterVngResourceLimits	     resourceLimits;
    private List<ApiClusterVngLabel>		 labels;
    private List<ApiClusterVngTaints>        taints;
    private List<String>         		  	 vmSizes;
    private List<String>         		  	 zones;
    private ApiClusterVngAutoScaleSpec		 autoScale;
    private ApiClusterVngLaunchSpecification launchSpecification;
    private String                           id;
    private String                           createdAt;
    private String                           updatedAt;

    public ApiClusterVirtualNodeGroup() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        isSet.add("oceanId");
        this.oceanId = oceanId;
    }

    public ApiClusterVngResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ApiClusterVngResourceLimits resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }

    public List<ApiClusterVngLabel> getLabels() {
        return labels;
    }

    public void setLabels (List<ApiClusterVngLabel> labels) {
        isSet.add("labels");
        this.labels = labels;
    }

    public List<ApiClusterVngTaints> getTaints() {
        return taints;
    }

    public void setTaints(List<ApiClusterVngTaints> taints) {
        isSet.add("taints");
        this.taints = taints;
    }

    public List<String> getVmSizes() {
        return vmSizes;
    }

    public void setVmSizes(List<String> vmSizes) {
        isSet.add("vmSizes");
        this.vmSizes = vmSizes;
    }

    public List<String> getZones() {
        return zones;
    }

    public void setZones(List<String> zones) {
        isSet.add("zones");
        this.zones = zones;
    }

    public ApiClusterVngAutoScaleSpec getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ApiClusterVngAutoScaleSpec autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public ApiClusterVngLaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiClusterVngLaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isOceanIdSet() {
        return isSet.contains("oceanId");
    }

    @JsonIgnore
    public boolean isResourceLimitsSet() {
        return isSet.contains("resourceLimits");
    }

    @JsonIgnore
    public boolean isLabelsSet() {
        return isSet.contains("labels");
    }

    @JsonIgnore
    public boolean isTaintsSet() {
        return isSet.contains("taints");
    }

    @JsonIgnore
    public boolean isVmSizesSet() {
        return isSet.contains("vmSizes");
    }

    @JsonIgnore
    public boolean isZonesSet() {
        return isSet.contains("zones");
    }

    @JsonIgnore
    public boolean isAutoScaleSet() { return isSet.contains("autoScale");
    }

    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
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