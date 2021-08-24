package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceTagSpecification {

    @JsonIgnore
    private Set<String>  isSet;
    private TagSpecification volumes;
    private TagSpecification snapshots;
    private TagSpecification enis;
    private TagSpecification amis;

    private ResourceTagSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public TagSpecification getVolumes() {
        return volumes;
    }

    public void setVolumes(TagSpecification volumes) {
        this.volumes= volumes;
        isSet.add("volumes");
    }

    public TagSpecification getSnapshots() {
        return snapshots;
    }

    public void setSnapshots(TagSpecification snapshots) {
        this.snapshots = snapshots;
        isSet.add("snapshots");
    }

    public TagSpecification getEnis() {
        return enis;
    }

    public void setEnis(TagSpecification enis) {
        this.enis = enis;
        isSet.add("enis");
    }

    public TagSpecification getAmis() {
        return amis;
    }

    public void setAmis(TagSpecification amis) {
        this.amis = amis;
        isSet.add("amis");
    }

    public static class Builder {
        private ResourceTagSpecification resourceTagSpecification;

        private Builder() {
            this.resourceTagSpecification = new ResourceTagSpecification();
        }

        public static ResourceTagSpecification.Builder get() {
            ResourceTagSpecification.Builder builder = new ResourceTagSpecification.Builder();
            return builder;
        }

        public ResourceTagSpecification.Builder setTagVolume(TagSpecification volumes) {
            this.resourceTagSpecification.isSet.add("volumes");
            resourceTagSpecification.setVolumes(volumes);
            return this;
        }

        public ResourceTagSpecification.Builder setTagSnapshot(TagSpecification snapshots) {
            this.resourceTagSpecification.isSet.add("snapshots");
            resourceTagSpecification.setSnapshots(snapshots);
            return this;
        }

        public ResourceTagSpecification.Builder setTagEnis(TagSpecification enis) {
            this.resourceTagSpecification.isSet.add("enis");
            resourceTagSpecification.setEnis(enis);
            return this;
        }

        public ResourceTagSpecification.Builder setTagAmis(TagSpecification amis) {
            this.resourceTagSpecification.isSet.add("amis");
            resourceTagSpecification.setAmis(amis);
            return this;
        }

        public ResourceTagSpecification build() {
            return resourceTagSpecification;
        }
    }

    @JsonIgnore
    public boolean isVolumeSet() {
        return isSet.contains("volumes");
    }

    @JsonIgnore
    public boolean isSnapshotSet() {
        return isSet.contains("snapshots");
    }

    @JsonIgnore
    public boolean isEniSet() { return isSet.contains("enis"); }

    @JsonIgnore
    public boolean isAmiSet() {
        return isSet.contains("amis");
    }
}
