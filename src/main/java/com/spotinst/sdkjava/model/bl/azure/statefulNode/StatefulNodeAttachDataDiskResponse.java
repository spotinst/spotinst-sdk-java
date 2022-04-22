package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeAttachDataDiskResponse {

    @JsonIgnore
    private Set<String>                 isSet;
    private String                      name;
    private String                      resourceGroupName;
    private String                      region;
    private String                      zone;
    private Integer                     size;
    private Integer                     lun;
    private String                      storageAccountType;
    private String                      managedBy;
    private AttachDataDiskTagsResponse  tags;


    private StatefulNodeAttachDataDiskResponse() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        isSet.add("zone");
        this.zone = zone;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }
    public String getStorageAccountType() {
        return storageAccountType;
    }

    public void setStorageAccountType(String storageAccountType) {
        isSet.add("storageAccountType");
        this.storageAccountType = storageAccountType;
    }

    public String getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(String managedBy) {
        isSet.add("managedBy");
        this.managedBy = managedBy;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        isSet.add("size");
        this.size = size;
    }

    public Integer getLun() {
        return lun;
    }

    public void setLun(Integer lun) {
        isSet.add("lun");
        this.lun = lun;
    }

    public AttachDataDiskTagsResponse getTags() {
        return tags;
    }

    public void setTags(AttachDataDiskTagsResponse tags) {
        isSet.add("tags");
        this.tags = tags;
    }


    public static class Builder {
        private StatefulNodeAttachDataDiskResponse statefulNode;

        private Builder() {
            this.statefulNode = new StatefulNodeAttachDataDiskResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            statefulNode.setName(name);
            return this;
        }

        public Builder setRegion(final String region) {
            statefulNode.setRegion(region);
            return this;
        }

        public Builder setZone(final String zone) {
            statefulNode.setZone(zone);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            statefulNode.setResourceGroupName(resourceGroupName);
            return this;
        }
        public Builder setStorageAccountType(final String storageAccountType) {
            statefulNode.setStorageAccountType(storageAccountType);
            return this;
        }

        public Builder setManagedBy(final String managedBy) {
            statefulNode.setManagedBy(managedBy);
            return this;
        }

        public Builder setLun(final Integer lun) {
            statefulNode.setLun(lun);
            return this;
        }

        public Builder setSize(final Integer size) {
            statefulNode.setSize(size);
            return this;
        }

        public Builder setTags(final AttachDataDiskTagsResponse tags) {
            statefulNode.setTags(tags);
            return this;
        }

        public StatefulNodeAttachDataDiskResponse build() {
            return statefulNode;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isZoneSet() {
        return isSet.contains("zone");
    }

    @JsonIgnore
    public boolean isSizeSet() {
        return isSet.contains("size");
    }

    @JsonIgnore
    public boolean isLunSet() {
        return isSet.contains("lun");
    }

    @JsonIgnore
    public boolean isManagedBySet() {
        return isSet.contains("managedBy");
    }

    @JsonIgnore
    public boolean isStorageAccountTypeSet() {
        return isSet.contains("storageAccountType");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

}
