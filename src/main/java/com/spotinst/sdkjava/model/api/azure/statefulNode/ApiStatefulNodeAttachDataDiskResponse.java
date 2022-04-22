package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeAttachDataDiskResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                     isSet;
    private String                          name;
    private String                          resourceGroupName;
    private String                          region;
    private String                          zone;
    private Integer                         size;
    private Integer                         lun;
    private String                          storageAccountType;
    private String                          managedBy;
    private ApiAttachDataDiskTagsResponse   tags;


    public ApiStatefulNodeAttachDataDiskResponse() {
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

    public ApiAttachDataDiskTagsResponse getTags() {
        return tags;
    }

    public void setTags(ApiAttachDataDiskTagsResponse tags) {
        isSet.add("tags");
        this.tags = tags;
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
