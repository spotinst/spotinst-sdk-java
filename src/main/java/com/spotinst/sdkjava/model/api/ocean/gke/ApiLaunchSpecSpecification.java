package com.spotinst.sdkjava.model.api.ocean.gke;

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
public class ApiLaunchSpecSpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             id;
    private String                                             oceanId;
    private String                                             name;
    private String                                             sourceImage;
    private String                                             serviceAccount;
    private Integer                                            rootVolumeSizeInGb;
    private String                                             rootVolumeType;
    private Boolean                                            restrictScaleDown;
    private List<ApiLaunchSpecMetadataSpecification>           metadata;
    private List<String>                                       instanceTypes;
    private List<ApiLaunchSpecTaintsSpecification>             taints;
    private List<ApiLaunchSpecLabelsSpecification>             labels;
    private ApiLaunchSpecAutoScaleSpecification                autoScale;
    private ApiLaunchSpecResourceLimitSpecification            resourceLimits;
    private ApiLaunchSpecResourceShieldedInstanceSpecification shieldedInstanceConfig;
    private ApiLaunchSpecStrategySpecification                 strategy;
    private ApiLaunchSpecStorageSpecification                  storage;

    public ApiLaunchSpecSpecification() {
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

    public void setId(String launchSpecId) {
        this.id = launchSpecId;
        isSet.add("id");
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        this.oceanId = oceanId;
        isSet.add("oceanId");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        isSet.add("name");
    }

    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
        isSet.add("sourceImage");
    }

    public String getServiceAccount() {
        return serviceAccount;
    }

    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
        isSet.add("serviceAccount");
    }

    public Integer getRootVolumeSizeInGb() {
        return rootVolumeSizeInGb;
    }

    public void setRootVolumeSizeInGb(Integer rootVolumeSizeInGb) {
        this.rootVolumeSizeInGb = rootVolumeSizeInGb;
        isSet.add("rootVolumeSizeInGb");
    }

    public String getRootVolumeType() {
        return rootVolumeType;
    }

    public void setRootVolumeType(String rootVolumeType) {
        this.rootVolumeType = rootVolumeType;
        isSet.add("rootVolumeType");
    }

    public Boolean getRestrictScaleDown(){
        return restrictScaleDown;
    }

    public void setRestrictScaleDown(Boolean restrictScaleDown) {
        this.restrictScaleDown = restrictScaleDown;
        isSet.add("restrictScaleDown");
    }

    public List<ApiLaunchSpecMetadataSpecification> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<ApiLaunchSpecMetadataSpecification> metadata) {
        this.metadata = metadata;
        isSet.add("metadata");
    }

    public List<String> getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(List<String> instanceTypes) {
        this.instanceTypes = instanceTypes;
        isSet.add("instanceTypes");
    }

    public List<ApiLaunchSpecTaintsSpecification> getTaints() {
        return taints;
    }

    public void setTaints(List<ApiLaunchSpecTaintsSpecification> taints) {
        this.taints = taints;
        isSet.add("taints");
    }

    public List<ApiLaunchSpecLabelsSpecification> getLabels() {
        return labels;
    }

    public void setLabels(List<ApiLaunchSpecLabelsSpecification> labels) {
        this.labels = labels;
        isSet.add("labels");
    }

    public ApiLaunchSpecAutoScaleSpecification getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ApiLaunchSpecAutoScaleSpecification autoScale) {
        this.autoScale = autoScale;
        isSet.add("autoScale");
    }

    public ApiLaunchSpecResourceLimitSpecification getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ApiLaunchSpecResourceLimitSpecification resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }

    public ApiLaunchSpecResourceShieldedInstanceSpecification getShieldedInstanceConfig() {
        return shieldedInstanceConfig;
    }

    public void setShieldedInstanceConfig(ApiLaunchSpecResourceShieldedInstanceSpecification shieldedInstanceConfig) {
        this.shieldedInstanceConfig = shieldedInstanceConfig;
        isSet.add("shieldedInstanceConfig");
    }

    public ApiLaunchSpecStrategySpecification getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiLaunchSpecStrategySpecification strategy) {
        this.strategy = strategy;
        isSet.add("strategy");
    }

    public ApiLaunchSpecStorageSpecification getStorage() {
        return storage;
    }

    public void setStorage(ApiLaunchSpecStorageSpecification storage) {
        this.storage = storage;
        isSet.add("storage");
    }

    @JsonIgnore
    public Boolean isIdSet() { return isSet.contains("id"); }

    @JsonIgnore
    public Boolean isOceanIdSet() { return isSet.contains("oceanId"); }

    @JsonIgnore
    public Boolean isNameSet() { return isSet.contains("name"); }

    @JsonIgnore
    public Boolean isSourceImageSet() { return isSet.contains("sourceImage"); }

    @JsonIgnore
    public Boolean isServiceAccountSet() { return isSet.contains("serviceAccount"); }

    @JsonIgnore
    public Boolean isRootVolumeSizeInGbSet() { return isSet.contains("rootVolumeSizeInGb"); }

    @JsonIgnore
    public Boolean isRootVolumeTypeSet() { return isSet.contains("rootVolumeType"); }

    @JsonIgnore
    public Boolean isRestrictScaleDownSet() { return isSet.contains("restrictScaleDown"); }

    @JsonIgnore
    public Boolean isMetadataSet() { return isSet.contains("metadata"); }

    @JsonIgnore
    public Boolean isInstanceTypesSet() { return isSet.contains("instanceTypes"); }

    @JsonIgnore
    public Boolean isTaintsSet() { return isSet.contains("taints"); }

    @JsonIgnore
    public Boolean isLabelsSet() { return isSet.contains("labels"); }

    @JsonIgnore
    public Boolean isAutoScaleSet() { return isSet.contains("autoScale"); }

    @JsonIgnore
    public Boolean isResourceLimitsSet() { return isSet.contains("resourceLimits"); }

    @JsonIgnore
    public Boolean isShieldedInstanceConfigSet() { return isSet.contains("shieldedInstanceConfig"); }

    @JsonIgnore
    public Boolean isStrategySet() { return isSet.contains("strategy"); }

    @JsonIgnore
    public Boolean isStorageSet() { return isSet.contains("storage"); }

}
