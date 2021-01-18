package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResourceTagSpecification {
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
        isSet.add("volumes");
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
        isSet.add("snapshots");
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
        isSet.add("enis");
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
        isSet.add("amis");
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
