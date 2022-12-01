package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterVirtualNodeGroup {
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           name;
    private String                           oceanId;
    private ClusterVngResourceLimits         resourceLimits;
    private List<ClusterVngLabel>		     labels;
    private List<ClusterVngTaints>           taints;
    private List<String>         		  	 vmSizes;
    private List<String>         		  	 zones;
    private ClusterVngAutoScaleSpec          autoScale;
    private ClusterVngLaunchSpecificaion     launchSpecification;
    private String                           id;
    private String                           createdAt;
    private String                           updatedAt;

    private ClusterVirtualNodeGroup() {
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

    public ClusterVngResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ClusterVngResourceLimits resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }

    public List<ClusterVngLabel> getLabels() {
        return labels;
    }

    public void setLabels (List<ClusterVngLabel> labels) {
        isSet.add("labels");
        this.labels = labels;
    }

    public List<ClusterVngTaints> getTaints() {
        return taints;
    }

    public void setTaints(List<ClusterVngTaints> taints) {
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

    public ClusterVngAutoScaleSpec getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ClusterVngAutoScaleSpec autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public ClusterVngLaunchSpecificaion getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ClusterVngLaunchSpecificaion launchSpecification) {
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

    public static class Builder {
        private ClusterVirtualNodeGroup virtualNodeGroupSpec;

        private Builder() {
            this.virtualNodeGroupSpec = new ClusterVirtualNodeGroup();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            virtualNodeGroupSpec.setName(name);
            return this;
        }

        public Builder setOceanId(final String oceanId) {
            virtualNodeGroupSpec.setOceanId(oceanId);
            return this;
        }

        public Builder setResourceLimits(final ClusterVngResourceLimits resourceLimits) {
            virtualNodeGroupSpec.setResourceLimits(resourceLimits);
            return this;
        }

        public Builder setLabels(final List<ClusterVngLabel> labels) {
            virtualNodeGroupSpec.setLabels(labels);
            return this;
        }

        public Builder setTaints(final List<ClusterVngTaints> taints) {
            virtualNodeGroupSpec.setTaints(taints);
            return this;
        }

        public Builder setVmSizes(final List<String> vmSizes) {
            virtualNodeGroupSpec.setVmSizes(vmSizes);
            return this;
        }

        public Builder setZones(final List<String> zones) {
            virtualNodeGroupSpec.setZones(zones);
            return this;
        }

        public Builder setAutoScale(final ClusterVngAutoScaleSpec autoScale) {
            virtualNodeGroupSpec.setAutoScale(autoScale);
            return this;
        }

        public Builder setLaunchSpecification(final ClusterVngLaunchSpecificaion launchSpecification) {
            virtualNodeGroupSpec.setLaunchSpecification(launchSpecification);
            return this;
        }

        public Builder setId(final String id) {
            virtualNodeGroupSpec.setId(id);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            virtualNodeGroupSpec.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final String updatedAt) {
            virtualNodeGroupSpec.setUpdatedAt(updatedAt);
            return this;
        }

        public ClusterVirtualNodeGroup build() {
            // Validations
            return virtualNodeGroupSpec;
        }
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