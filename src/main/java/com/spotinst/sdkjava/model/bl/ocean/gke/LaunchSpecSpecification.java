package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecSpecification {

    @JsonIgnore
    private Set<String>                                   isSet;
    private String                                        oceanId;
    private String                                        id;
    private String                                        name;
    private String                                        sourceImage;
    private String                                        serviceAccount;
    private Integer                                           rootVolumeSize;
    private String                                        rootVolumeType;
    private Boolean                                       restrictScaleDown = false;
    private List<LaunchSpecMetadataSpecification>         metadata;
    private List<String>                                  instanceTypes;
    private List<LaunchSpecTaintsSpecification>           taints;
    private List<LaunchSpecLabelsSpecification>           labels;
    private LaunchSpecAutoScaleSpecification              autoScale;
    private LaunchSpecResourceLimitsSpecification         resourceLimits;
    private LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig;
    private LaunchSpecStrategySpecification               strategy;
    private LaunchSpecStorageSpecification                storage;


    private LaunchSpecSpecification() {
        isSet = new HashSet<>();
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

    public Integer getRootVolumeSize() {
        return rootVolumeSize;
    }

    public void setRootVolumeSize(Integer rootVolumeSize) {
        this.rootVolumeSize = rootVolumeSize;
        isSet.add("rootVolumeSize");
    }

    public String getRootVolumeType() {
        return rootVolumeType;
    }

    public void setRootVolumeType(String rootVolumeType) {
        this.rootVolumeType = rootVolumeType;
        isSet.add("rootVolumeType");
    }

    public Boolean getRestrictScaleDown() {
        return restrictScaleDown;
    }

    public void setRestrictScaleDown(Boolean restrictScaleDown) {
        this.restrictScaleDown = restrictScaleDown;
        isSet.add("restrictScaleDown");
    }

    public List<LaunchSpecMetadataSpecification> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<LaunchSpecMetadataSpecification> metadata) {
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

    public List<LaunchSpecTaintsSpecification> getTaints() {
        return taints;
    }

    public void setTaints(List<LaunchSpecTaintsSpecification> taints) {
        this.taints = taints;
        isSet.add("taints");
    }

    public List<LaunchSpecLabelsSpecification> getLabels() {
        return labels;
    }

    public void setLabels(List<LaunchSpecLabelsSpecification> labels) {
        this.labels = labels;
        isSet.add("labels");
    }

    public LaunchSpecAutoScaleSpecification getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(LaunchSpecAutoScaleSpecification autoScale) {
        this.autoScale = autoScale;
        isSet.add("autoScale");
    }

    public LaunchSpecResourceLimitsSpecification getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(LaunchSpecResourceLimitsSpecification resourceLimits) {
        this.resourceLimits = resourceLimits;
    }

    public LaunchSpecShieldedInstanceConfigSpecification getShieldedInstanceConfig() {
        return shieldedInstanceConfig;
    }

    public void setShieldedInstanceConfig(LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig) {
        this.shieldedInstanceConfig = shieldedInstanceConfig;
        isSet.add("shieldedInstanceConfig");
    }

    public LaunchSpecStrategySpecification getStrategy() {
        return strategy;
    }

    public void setStrategy(LaunchSpecStrategySpecification strategy) {
        this.strategy = strategy;
        isSet.add("strategy");

    }

    public LaunchSpecStorageSpecification getStorage() {
        return storage;
    }

    public void setStorage(LaunchSpecStorageSpecification storage) {
        this.storage = storage;
        isSet.add("storage");
    }


    public static class Builder {
        //region Members
        private LaunchSpecSpecification launchSpec;
        //endregion


        private Builder() {
            this.launchSpec = new LaunchSpecSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String launchSpecId) {
            launchSpec.setId(launchSpecId);
            return this;
        }

        public Builder setOceanId(final String oceanId) {
            launchSpec.setOceanId(oceanId);
            return this;
        }

        public Builder setName(final String name) {
            launchSpec.setName(name);
            return this;
        }

        public Builder setSourceImage(final String description) {
            launchSpec.setSourceImage(description);
            return this;
        }

        public Builder setServiceAccount(final String region) {
            launchSpec.setServiceAccount(region);
            return this;
        }

        public Builder setRootVolumeSize(final Integer rootVolumeSize) {
            launchSpec.setRootVolumeSize(rootVolumeSize);
            return this;
        }

        public Builder setStrategy(final LaunchSpecStrategySpecification strategy) {
            launchSpec.setStrategy(strategy);
            return this;
        }

        public Builder setRootVolumeType(final String rootVolumeType) {
            launchSpec.setRootVolumeType(rootVolumeType);
            return this;
        }

        public Builder setMetadata(final List<LaunchSpecMetadataSpecification> metadata) {
            launchSpec.setMetadata(metadata);
            return this;
        }

        public Builder setInstanceTypes(final List<String> instanceTypes) {
            launchSpec.setInstanceTypes(instanceTypes);
            return this;
        }

        public Builder setRestrictScaleDown(final Boolean restrictScaleDown) {
            launchSpec.setRestrictScaleDown(restrictScaleDown);
            return this;
        }

        public Builder setTaints(final List<LaunchSpecTaintsSpecification> taints) {
            launchSpec.setTaints(taints);
            return this;
        }

        public Builder setLabels(final List<LaunchSpecLabelsSpecification> labels) {
            launchSpec.setLabels(labels);
            return this;
        }

        public Builder setResourceLimits(final LaunchSpecResourceLimitsSpecification resourceLimits) {
            launchSpec.setResourceLimits(resourceLimits);
            return this;
        }

        public Builder setShieldedInstanceConfig(final LaunchSpecShieldedInstanceConfigSpecification shieldedInstanceConfig) {
            launchSpec.setShieldedInstanceConfig(shieldedInstanceConfig);
            return this;
        }

        public Builder setAutoScales(final LaunchSpecAutoScaleSpecification autoScales) {
            launchSpec.setAutoScale(autoScales);
            return this;
        }

        public Builder setStorage(final LaunchSpecStorageSpecification storage) {
            launchSpec.setStorage(storage);
            return this;
        }
        public LaunchSpecSpecification build() {
            // Validations
            return launchSpec;
        }
        //endregion
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
    public Boolean isRootVolumeSizeSet() { return isSet.contains("rootVolumeSize"); }

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
