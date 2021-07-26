package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OceanGKECreateLaunchSpecRes {

    @JsonIgnore
    private Set<String> isSet;
    private String oceanId;
    private String id;
    private String                         name;
    private String                         sourceImage;
    private String                         serviceAccount;
    private int                            rootVolumeSize;
    private String                         rootVolumeType;
    private boolean                        restrictScaleDown;
    private List<OceanGKEMetadata>         metadata;
    private List<String>                   instanceTypes;
    private List<OceanGKETaints>           taints;
    private List<OceanGKELabels>           labels;
    private OceanGKEAutoScale              autoScale;
    private OceanGKEResourceLimits         resourceLimits;
    private OceanGKEShieldedInstanceConfig shieldedInstanceConfig;
    private OceanGKEStrategy strategy;
    private OceanGKEStorage storage;


    private OceanGKECreateLaunchSpecRes() {
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

    public boolean getRestrictScaleDown() {
        return restrictScaleDown;
    }
    public void setRestrictScaleDown(boolean restrictScaleDown) {
        this.restrictScaleDown = restrictScaleDown;
        isSet.add("restrictScaleDown");
    }

    public List<OceanGKEMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<OceanGKEMetadata> metadata) {
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

    public List<OceanGKETaints> getTaints() {
        return taints;
    }

    public void setTaints(List<OceanGKETaints> taints) {
        this.taints = taints;
        isSet.add("taints");
    }

    public List<OceanGKELabels> getLabels() {
        return labels;
    }

    public void setLabels(List<OceanGKELabels> labels) {
        this.labels = labels;
        isSet.add("labels");
    }

    public OceanGKEAutoScale getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(OceanGKEAutoScale autoScale) {
        this.autoScale = autoScale;
        isSet.add("autoScale");
    }

    public OceanGKEResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(OceanGKEResourceLimits resourceLimits) {
        this.resourceLimits = resourceLimits;
    }

    public OceanGKEShieldedInstanceConfig getOceanGKEShieldedInstanceConfig() {
        return shieldedInstanceConfig;
    }

    public void setOceanGKEShieldedInstanceConfig(OceanGKEShieldedInstanceConfig shieldedInstanceConfig) {
        this.shieldedInstanceConfig = shieldedInstanceConfig;
        isSet.add("shieldedInstanceConfig");
    }

    public OceanGKEStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(OceanGKEStrategy strategy) {
        this.strategy = strategy;
        isSet.add("strategy");

    }

    public OceanGKEStorage getStorage() {
        return storage;
    }

    public void setStorage(OceanGKEStorage storage) {
        this.storage = storage;
        isSet.add("storage");
    }


    public static class Builder {
        //region Members
        private OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes;
        //endregion


        private Builder() {
            this.oceanGKECreateLaunchSpecRes = new OceanGKECreateLaunchSpecRes();
        }

        public static OceanGKECreateLaunchSpecRes.Builder get() {
            OceanGKECreateLaunchSpecRes.Builder builder = new OceanGKECreateLaunchSpecRes.Builder();
            return builder;
        }

        public OceanGKECreateLaunchSpecRes.Builder setId(final String launchSpecId) {
            oceanGKECreateLaunchSpecRes.setId(launchSpecId);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setOceanId(final String oceanId) {
            oceanGKECreateLaunchSpecRes.setOceanId(oceanId);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setName(final String name) {
            oceanGKECreateLaunchSpecRes.setName(name);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setSourceImage(final String description) {
            oceanGKECreateLaunchSpecRes.setSourceImage(description);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setServiceAccount(final String region) {
            oceanGKECreateLaunchSpecRes.setServiceAccount(region);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setRootVolumeSize(final int rootVolumeSize) {
            oceanGKECreateLaunchSpecRes.setRootVolumeSize(rootVolumeSize);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setStrategy(final OceanGKEStrategy strategy) {
            oceanGKECreateLaunchSpecRes.setStrategy(strategy);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setRootVolumeType(final String rootVolumeType) {
            oceanGKECreateLaunchSpecRes.setRootVolumeType(rootVolumeType);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setMetadata(final List<OceanGKEMetadata> metadata) {
            oceanGKECreateLaunchSpecRes.setMetadata(metadata);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setInstanceTypes(final List<String> instanceTypes) {
            oceanGKECreateLaunchSpecRes.setInstanceTypes(instanceTypes);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setRestrictScaleDown(final boolean restrictScaleDown) {
            oceanGKECreateLaunchSpecRes.setRestrictScaleDown(restrictScaleDown);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setTaints(final List<OceanGKETaints> taints) {
            oceanGKECreateLaunchSpecRes.setTaints(taints);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setLabels(final List<OceanGKELabels> labels) {
            oceanGKECreateLaunchSpecRes.setLabels(labels);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setResourceLimits(final OceanGKEResourceLimits resourceLimits) {
            oceanGKECreateLaunchSpecRes.setResourceLimits(resourceLimits);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setOceanGKEShieldedInstanceConfig(final OceanGKEShieldedInstanceConfig shieldedInstanceConfig) {
            oceanGKECreateLaunchSpecRes.setOceanGKEShieldedInstanceConfig(shieldedInstanceConfig);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setAutoScales(final OceanGKEAutoScale autoScales) {
            oceanGKECreateLaunchSpecRes.setAutoScale(autoScales);
            return this;
        }

        public OceanGKECreateLaunchSpecRes.Builder setStorage(final OceanGKEStorage storage) {
            oceanGKECreateLaunchSpecRes.setStorage(storage);
            return this;
        }
        public OceanGKECreateLaunchSpecRes build() {
            // Validations
            return oceanGKECreateLaunchSpecRes;
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
