package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupResourceTagSpecification {
    //region Members
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private Set<String>           isSet = new HashSet<>();

    private GroupTagSpecification volumes;
    private GroupTagSpecification snapshots;
    private GroupTagSpecification enis;
    private GroupTagSpecification amis;

    //endregion

    //region Setters&Getters

    public void setVolumes(GroupTagSpecification volumes) {
        this.volumes= volumes;
        isSet.add("volumes");
    }

    public void setSnapshots(GroupTagSpecification snapshots) {
        this.snapshots = snapshots;
        isSet.add("snapshots");
    }

    public void setEnis(GroupTagSpecification enis) {
        this.enis = enis;
        isSet.add("enis");
    }

    public void setAmis(GroupTagSpecification amis) {
        this.amis = amis;
        isSet.add("amis");
    }

    public GroupTagSpecification getVolumes() {
        return volumes;
    }

    public GroupTagSpecification getSnapshots() {
        return snapshots;
    }

    public GroupTagSpecification getEnis() {
        return enis;
    }

    public GroupTagSpecification getAmis() {
        return amis;
    }

    //region Builder class
    public static class Builder {
        private GroupResourceTagSpecification resourceTagSpecification;

        private Builder() {
            this.resourceTagSpecification = new GroupResourceTagSpecification();
        }

        public static GroupResourceTagSpecification.Builder get() {
            return new Builder();
        }

        public GroupResourceTagSpecification.Builder setTagVolume(GroupTagSpecification volumes) {
            this.resourceTagSpecification.isSet.add("volumes");
            resourceTagSpecification.setVolumes(volumes);
            return this;
        }

        public GroupResourceTagSpecification.Builder setTagSnapshot(GroupTagSpecification snapshots) {
            this.resourceTagSpecification.isSet.add("snapshots");
            resourceTagSpecification.setSnapshots(snapshots);
            return this;
        }

        public GroupResourceTagSpecification.Builder setTagEnis(GroupTagSpecification enis) {
            this.resourceTagSpecification.isSet.add("enis");
            resourceTagSpecification.setEnis(enis);
            return this;
        }

        public GroupResourceTagSpecification.Builder setTagAmis(GroupTagSpecification amis) {
            this.resourceTagSpecification.isSet.add("amis");
            resourceTagSpecification.setAmis(amis);
            return this;
        }

        public GroupResourceTagSpecification build() {
            return resourceTagSpecification;
        }
    }
    //endregion
    @JsonIgnore
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    //endregion

    //region Methods
    @JsonIgnore
    public boolean isVolumeSet() {
        return isSet.contains("volumes");
    }
    @JsonIgnore
    public boolean isSnapshotSet() {
        return isSet.contains("snapshots");
    }
    @JsonIgnore
    public boolean isEniSet() { return isSet.contains("enis");
    }
    @JsonIgnore
    public boolean isAmiSet() {
        return isSet.contains("amis");
    }
    //endregion
}
