package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiGroupResourceTagSpecification {
    //region Members
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private Set<String>           isSet;
    private ApiGroupTagSpecification volumes;
    private ApiGroupTagSpecification snapshots;
    private ApiGroupTagSpecification enis;
    private ApiGroupTagSpecification amis;

    //endregion
    public ApiGroupResourceTagSpecification() {
        isSet = new HashSet<>();
    }


    //region Setters&Getters

    public void setVolumes(ApiGroupTagSpecification volumes) {
        isSet.add("volumes");
        this.volumes = volumes;
    }

    public void setSnapshots(ApiGroupTagSpecification snapshots) {
        isSet.add("snapshots");
        this.snapshots = snapshots;
    }

    public void setEnis(ApiGroupTagSpecification enis) {
        isSet.add("enis");
        this.enis = enis;
    }

    public void setAmis(ApiGroupTagSpecification amis) {
        isSet.add("amis");
        this.amis = amis;
    }

    public ApiGroupTagSpecification getVolumes() {
        return volumes;
    }

    public ApiGroupTagSpecification getSnapshots() {
        return snapshots;
    }

    public ApiGroupTagSpecification getEnis() {
        return enis;
    }

    public ApiGroupTagSpecification getAmis() {
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
    @JsonIgnore
    public boolean isSnapshotSet() {
        return isSet.contains("snapshots");
    }
    @JsonIgnore
    public boolean isEniSet() {
        return isSet.contains("enis");
    }
    @JsonIgnore
    public boolean isAmiSet() {
        return isSet.contains("amis");
    }
    //endregion
}
