package com.spotinst.sdkjava.model.api.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResourceTagSpecification {

    @JsonIgnore
    private Set<String>         isSet;
    private ApiTagSpecification volumes;
    private ApiTagSpecification snapshots;
    private ApiTagSpecification enis;
    private ApiTagSpecification amis;

    public ApiResourceTagSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiTagSpecification getVolumes() {
        return volumes;
    }

    public void setVolumes(ApiTagSpecification volumes) {
        this.volumes= volumes;
        isSet.add("volumes");
    }

    public ApiTagSpecification getSnapshots() {
        return snapshots;
    }

    public void setSnapshots(ApiTagSpecification snapshots) {
        this.snapshots = snapshots;
        isSet.add("snapshots");
    }

    public ApiTagSpecification getEnis() {
        return enis;
    }

    public void setEnis(ApiTagSpecification enis) {
        this.enis = enis;
        isSet.add("enis");
    }

    public ApiTagSpecification getAmis() {
        return amis;
    }

    public void setAmis(ApiTagSpecification amis) {
        this.amis = amis;
        isSet.add("amis");
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
