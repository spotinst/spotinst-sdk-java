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
    private String                         oceanId;
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
    private OceanGKEShieldedInstanceConfig oceanGKEShieldedInstanceConfig;
    private OceanGKEStrategy               strategy;
    private OceanGKEStorage                storage;



    public ApiOceanGKELaunchSpec() {
        isSet = new HashSet<>();
    }
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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
        return oceanGKEShieldedInstanceConfig;
    }

    public void setOceanGKEShieldedInstanceConfig(OceanGKEShieldedInstanceConfig oceanGKEShieldedInstanceConfig) {
        this.oceanGKEShieldedInstanceConfig = oceanGKEShieldedInstanceConfig;
        isSet.add("oceanGKEShieldedInstanceConfig");
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
    public boolean isOceanGKEShieldedInstanceConfigSet() { return isSet.contains("oceanGKEShieldedInstanceConfig"); }

    @JsonIgnore
    public boolean isStrategySet() { return isSet.contains("strategy"); }

    @JsonIgnore
    public boolean isStorageSet() { return isSet.contains("storage"); }

}
