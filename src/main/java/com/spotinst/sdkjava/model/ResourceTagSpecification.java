package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceTagSpecification {
    //region Members
    private Set<String>        isSet = new HashSet<>();
    private ShouldTag            volumes;
    private ShouldTag            snapshots;
    private ShouldTag            enis;
    private ShouldTag            amis;

    //endregion


    //region Setters&Getters


    public Boolean isShouldTagVolumes() {
        if(isSet.contains("volumes")) {
        return volumes.getShouldTag();
        }
        else return null;
    }

    public void setShouldTagVolumes(Boolean shouldTagVolumes) {
        if(this.volumes == null) {
            this.volumes = new ShouldTag();
        }
        this.volumes.setShouldTag(shouldTagVolumes);
    }

    public Boolean isShouldTagSnapshots() {
        if(isSet.contains("snapshots")) {
            return snapshots.getShouldTag();
        }
        else return null;
    }

    public void setShouldTagSnapshots(Boolean shouldTagSnapshots) {
        if(this.snapshots == null) {
            this.snapshots = new ShouldTag();
        }
        this.snapshots.setShouldTag(shouldTagSnapshots);
    }

    public Boolean isShouldTagEnis() {
        if(isSet.contains("enis")) {
            return enis.getShouldTag();
        }
        else return null;
    }

    public void setShouldTagEnis(Boolean shouldTagEnis) {
        if(this.enis == null) {
            this.enis = new ShouldTag();
        }
        this.enis.setShouldTag(shouldTagEnis);
    }

    public Boolean isShouldTagAmis() {
        if(isSet.contains("amis")) {
            return enis.getShouldTag();
        }
        else return null;
    }

    public void setShouldTagAmis(Boolean shouldTagAmis) {
        if(this.amis == null) {
            this.amis = new ShouldTag();
        }
        this.amis.setShouldTag(shouldTagAmis);
    }

    public ShouldTag getVolumes() {
        return volumes;
    }

    public ShouldTag getSnapshots() {
        return snapshots;
    }

    public ShouldTag getEnis() {
        return enis;
    }

    public ShouldTag getAmis() {
        return amis;
    }

    //region Builder class
    public static class Builder {
        private ResourceTagSpecification resourceTagSpecification;

        private Builder() {
            this.resourceTagSpecification = new ResourceTagSpecification();
        }

        public static ResourceTagSpecification.Builder get() {
            ResourceTagSpecification.Builder builder = new ResourceTagSpecification.Builder();
            return builder;
        }

        public ResourceTagSpecification.Builder setTagVolume(Boolean shouldTagVolume) {
            this.resourceTagSpecification.isSet.add("volumes");
            resourceTagSpecification.setShouldTagVolumes(shouldTagVolume);
            return this;
        }

        public ResourceTagSpecification.Builder setTagSnapshot(Boolean shouldTagSnapshot) {
            this.resourceTagSpecification.isSet.add("snapshots");
            resourceTagSpecification.setShouldTagSnapshots(shouldTagSnapshot);
            return this;
        }

        public ResourceTagSpecification.Builder setTagEnis(Boolean shouldTagEnis) {
            this.resourceTagSpecification.isSet.add("enis");
            resourceTagSpecification.setShouldTagEnis(shouldTagEnis);
            return this;
        }

        public ResourceTagSpecification.Builder setTagAmis(Boolean shouldTagAmis) {
            this.resourceTagSpecification.isSet.add("amis");
            resourceTagSpecification.setShouldTagAmis(shouldTagAmis);
            return this;
        }

        public ResourceTagSpecification build() {
            return resourceTagSpecification;
        }
    }
    //endregion

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
    public boolean isSnapshotSet() {
        return isSet.contains("snapshots");
    }
    public boolean isEniSet() {
        return isSet.contains("enis");
    }
    public boolean isAmiSet() {
        return isSet.contains("amis");
    }
    //endregion
}
