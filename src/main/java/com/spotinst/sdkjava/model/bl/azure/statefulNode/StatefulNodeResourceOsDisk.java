package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceOsDisk {

    @JsonIgnore
    private Set<String>             isSet;
    private String                  name;
    private String                  resourceGroupName;
    private String                  osType;
    private String                  storageAccountType;
    private Integer                 sizeGB;
    private String                  snapshot;
    private String                  lastCompletedSnapshot;

    private StatefulNodeResourceOsDisk() {
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

    public Integer getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(Integer sizeGB) {
        isSet.add("sizeGB");
        this.sizeGB = sizeGB;
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

    public static class Builder {

        private StatefulNodeResourceOsDisk nodeResourceDataDisks;

        private Builder() {
            this.nodeResourceDataDisks = new StatefulNodeResourceOsDisk();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            nodeResourceDataDisks.setName(name);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            nodeResourceDataDisks.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setStorageAccountType(final String storageAccountType) {
            nodeResourceDataDisks.setStorageAccountType(storageAccountType);
            return this;
        }

        public Builder setSizeGB(final Integer sizeGB) {
            nodeResourceDataDisks.setSizeGB(sizeGB);
            return this;
        }

        public Builder setOsType(final String osType) {
            nodeResourceDataDisks.setOsType(osType);
            return this;
        }

        public Builder setSnapshot(final String snapshot) {
            nodeResourceDataDisks.setSnapshot(snapshot);
            return this;
        }

        public Builder setLastCompletedSnapshot(final String lastCompletedSnapshot) {
            nodeResourceDataDisks.setLastCompletedSnapshot(lastCompletedSnapshot);
            return this;
        }

        public StatefulNodeResourceOsDisk build() {
            return nodeResourceDataDisks;
        }
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
    public boolean isSizeGBSet() {
        return isSet.contains("sizeGB");
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
