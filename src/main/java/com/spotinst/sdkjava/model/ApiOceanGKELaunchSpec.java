package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.gcp.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiOceanGKELaunchSpec implements IPartialUpdateEntity {


    @JsonIgnore
    private Set<String>                    isSet;
    private String id;
    private String                         oceanId;
    private String                         name;
    private String                         sourceImage;
    private String                         serviceAccount;
    private int                            rootVolumeSize;
    private String                         rootVolumeType;
    private boolean                        restrictScaleDown;
    private List<ApiOceanGKEMetadata>         metadata;
    private List<String>                   instanceTypes;
    private List<ApiOceanGKETaints>           taints;
    private List<ApiOceanGKELabels>           labels;
    private ApiOceanGKEAutoScale              autoScale;
    private ApiOceanGKEResourceLimits         resourceLimits;
    private ApiOceanGKEShieldedInstanceConfig shieldedInstanceConfig;
    private ApiOceanGKEStrategy               strategy;
    private ApiOceanGKEStorage                storage;



    public ApiOceanGKELaunchSpec() {
        isSet = new HashSet<>();
    }


    @Override
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

    public int getRootVolumeSize() {
        return rootVolumeSize;
    }

    public void setRootVolumeSize(int rootVolumeSize) {
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

    public boolean isRestrictScaleDown() {
        return restrictScaleDown;
    }

    public boolean getRestrictScaleDown(){
        return restrictScaleDown;
    }
    public void setRestrictScaleDown(boolean restrictScaleDown) {
        this.restrictScaleDown = restrictScaleDown;
        isSet.add("restrictScaleDown");
    }

    public List<ApiOceanGKEMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<ApiOceanGKEMetadata> metadata) {
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

    public List<ApiOceanGKETaints> getTaints() {
        return taints;
    }

    public void setTaints(List<ApiOceanGKETaints> taints) {
        this.taints = taints;
        isSet.add("taints");
    }

    public List<ApiOceanGKELabels> getLabels() {
        return labels;
    }

    public void setLabels(List<ApiOceanGKELabels> labels) {
        this.labels = labels;
        isSet.add("labels");
    }

    public ApiOceanGKEAutoScale getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ApiOceanGKEAutoScale autoScale) {
        this.autoScale = autoScale;
        isSet.add("autoScale");
    }

    public ApiOceanGKEResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ApiOceanGKEResourceLimits resourceLimits) {
        this.resourceLimits = resourceLimits;
    }

    public ApiOceanGKEShieldedInstanceConfig getOceanGKEShieldedInstanceConfig() {
        return shieldedInstanceConfig;
    }

    public void setOceanGKEShieldedInstanceConfig(ApiOceanGKEShieldedInstanceConfig shieldedInstanceConfig) {
        this.shieldedInstanceConfig = shieldedInstanceConfig;
        isSet.add("shieldedInstanceConfig");
    }

    public ApiOceanGKEStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiOceanGKEStrategy strategy) {
        this.strategy = strategy;
        isSet.add("strategy");

    }

    public ApiOceanGKEStorage getStorage() {
        return storage;
    }

    public void setStorage(ApiOceanGKEStorage storage) {
        this.storage = storage;
        isSet.add("storage");
    }

    public static class Builder {
        //region Members
        private ApiOceanGKELaunchSpec apiOceanGKELaunchSpec;
        //endregion


        private Builder() {
            this.apiOceanGKELaunchSpec = new ApiOceanGKELaunchSpec();
        }

        public static ApiOceanGKELaunchSpec.Builder get() {
            ApiOceanGKELaunchSpec.Builder builder = new ApiOceanGKELaunchSpec.Builder();
            return builder;
        }

        public ApiOceanGKELaunchSpec.Builder setId(final String launchSpecId) {
            apiOceanGKELaunchSpec.setId(launchSpecId);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setOceanId(final String oceanId) {
            apiOceanGKELaunchSpec.setOceanId(oceanId);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setName(final String name) {
            apiOceanGKELaunchSpec.setName(name);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setSourceImage(final String description) {
            apiOceanGKELaunchSpec.setSourceImage(description);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setServiceAccount(final String region) {
            apiOceanGKELaunchSpec.setServiceAccount(region);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setRootVolumeSize(final int rootVolumeSize) {
            apiOceanGKELaunchSpec.setRootVolumeSize(rootVolumeSize);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setStrategy(final ApiOceanGKEStrategy strategy) {
            apiOceanGKELaunchSpec.setStrategy(strategy);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setRootVolumeType(final String rootVolumeType) {
            apiOceanGKELaunchSpec.setRootVolumeType(rootVolumeType);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setMetadata(final List<ApiOceanGKEMetadata> metadata) {
            apiOceanGKELaunchSpec.setMetadata(metadata);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setInstanceTypes(final List<String> instanceTypes) {
            apiOceanGKELaunchSpec.setInstanceTypes(instanceTypes);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setRestrictScaleDown(final boolean restrictScaleDown) {
            apiOceanGKELaunchSpec.setRestrictScaleDown(restrictScaleDown);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setTaints(final List<ApiOceanGKETaints> taints) {
            apiOceanGKELaunchSpec.setTaints(taints);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setLabels(final List<ApiOceanGKELabels> labels) {
            apiOceanGKELaunchSpec.setLabels(labels);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setResourceLimits(final ApiOceanGKEResourceLimits resourceLimits) {
            apiOceanGKELaunchSpec.setResourceLimits(resourceLimits);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setOceanGKEShieldedInstanceConfig(final ApiOceanGKEShieldedInstanceConfig shieldedInstanceConfig) {
            apiOceanGKELaunchSpec.setOceanGKEShieldedInstanceConfig(shieldedInstanceConfig);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setAutoScales(final ApiOceanGKEAutoScale autoScales) {
            apiOceanGKELaunchSpec.setAutoScale(autoScales);
            return this;
        }

        public ApiOceanGKELaunchSpec.Builder setStorage(final ApiOceanGKEStorage storage) {
            apiOceanGKELaunchSpec.setStorage(storage);
            return this;
        }
        public ApiOceanGKELaunchSpec build() {
            // Validations
            return apiOceanGKELaunchSpec;
        }
        //endregion
    }


    @JsonIgnore
    public boolean isIdSet() { return isSet.contains("id"); }

    @JsonIgnore
    public boolean isOceanIdSet() { return isSet.contains("oceanId"); }

    @JsonIgnore
    public boolean isNameSet() { return isSet.contains("name"); }

    @JsonIgnore
    public boolean isSourceImageSet() { return isSet.contains("sourceImage"); }

    @JsonIgnore
    public boolean isServiceAccountSet() { return isSet.contains("serviceAccount"); }

    @JsonIgnore
    public boolean isRootVolumeSizeSet() { return isSet.contains("rootVolumeSize"); }

    @JsonIgnore
    public boolean isRootVolumeTypeSet() { return isSet.contains("rootVolumeType"); }

    @JsonIgnore
    public boolean isRestrictScaleDownSet() { return isSet.contains("restrictScaleDown"); }

    @JsonIgnore
    public boolean isMetadataSet() { return isSet.contains("metadata"); }

    @JsonIgnore
    public boolean isInstanceTypesSet() { return isSet.contains("instanceTypes"); }

    @JsonIgnore
    public boolean isTaintsSet() { return isSet.contains("taints"); }

    @JsonIgnore
    public boolean isLabelsSet() { return isSet.contains("labels"); }

    @JsonIgnore
    public boolean isAutoScaleSet() { return isSet.contains("autoScale"); }

    @JsonIgnore
    public boolean isResourceLimitsSet() { return isSet.contains("resourceLimits"); }

    @JsonIgnore
    public boolean isOceanGKEShieldedInstanceConfigSet() { return isSet.contains("shieldedInstanceConfig"); }

    @JsonIgnore
    public boolean isStrategySet() { return isSet.contains("strategy"); }

    @JsonIgnore
    public boolean isStorageSet() { return isSet.contains("storage"); }

}
