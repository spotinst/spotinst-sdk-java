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
public class ApiStatefulNodeResourceOsDisk implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>             isSet;
    private String                  name;
    private String                  resourceGroupName;
    private String                  osType;
    private String                  storageAccountType;
    private Integer                 sizeGb;
    private String                  snapshot;
    private String                  lastCompletedSnapshot;

    public ApiStatefulNodeResourceOsDisk() {
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

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        isSet.add("osType");
        this.osType = osType;
    }

    public String getStorageAccountType() {
        return storageAccountType;
    }

    public void setStorageAccountType(String storageAccountType) {
        isSet.add("storageAccountType");
        this.storageAccountType = storageAccountType;
    }

    public Integer getSizeGb() {
        return sizeGb;
    }

    public void setSizeGb(Integer sizeGb) {
        isSet.add("sizeGb");
        this.sizeGb = sizeGb;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        isSet.add("snapshot");
        this.snapshot = snapshot;
    }

    public String getLastCompletedSnapshot() {
        return lastCompletedSnapshot;
    }

    public void setLastCompletedSnapshot(String lastCompletedSnapshot) {
        isSet.add("lastCompletedSnapshot");
        this.lastCompletedSnapshot = lastCompletedSnapshot;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() { return isSet.contains("resourceGroupName"); }

    @JsonIgnore
    public boolean isStorageAccountTypeSet() { return isSet.contains("storageAccountType"); }

    @JsonIgnore
    public boolean isSizeGbSet() {
        return isSet.contains("sizeGb");
    }

    @JsonIgnore
    public boolean isOsTypeSet() {
        return isSet.contains("osType");
    }

    @JsonIgnore
    public boolean isSnapshotSet() {
        return isSet.contains("snapshot");
    }

    @JsonIgnore
    public boolean isLastCompletedSnapshotSet() {
        return isSet.contains("lastCompletedSnapshot");
    }
}
