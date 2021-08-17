package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiDeallocationConfig {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeleteImages;
    private Boolean     shouldDeleteNetworkInterfaces;
    private Boolean     shouldDeleteSnapshots;
    private Boolean     shouldDeleteVolumes;
    private Boolean     shouldTerminateInstance;

    public ApiDeallocationConfig() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldDeleteImages() {
        return shouldDeleteImages;
    }

    public void setShouldDeleteImages(Boolean shouldDeleteImages) {
        isSet.add("shouldDeleteImages");
        this.shouldDeleteImages = shouldDeleteImages;
    }

    public Boolean getShouldDeleteNetworkInterfaces() {
        return shouldDeleteNetworkInterfaces;
    }

    public void setShouldDeleteNetworkInterfaces(Boolean shouldDeleteNetworkInterfaces) {
        isSet.add("shouldDeleteNetworkInterfaces");
        this.shouldDeleteNetworkInterfaces = shouldDeleteNetworkInterfaces;
    }

    public Boolean getShouldDeleteSnapshots() {
        return shouldDeleteSnapshots;
    }

    public void setShouldDeleteSnapshots(Boolean shouldDeleteSnapshots) {
        isSet.add("shouldDeleteSnapshots");
        this.shouldDeleteSnapshots = shouldDeleteSnapshots;
    }

    public Boolean getShouldDeleteVolumes() {
        return shouldDeleteVolumes;
    }

    public void setShouldDeleteVolumes(Boolean shouldDeleteVolumes) {
        isSet.add("shouldDeleteVolumes");
        this.shouldDeleteVolumes = shouldDeleteVolumes;
    }

    public Boolean getShouldTerminateInstance() {
        return shouldTerminateInstance;
    }

    public void setShouldTerminateInstance(Boolean shouldTerminateInstance) {
        isSet.add("shouldTerminateInstance");
        this.shouldTerminateInstance = shouldTerminateInstance;
    }

    @JsonIgnore
    public boolean isShouldDeleteImagesSet() {
        return isSet.contains("shouldDeleteImages");
    }

    @JsonIgnore
    public boolean isShouldDeleteNetworkInterfacesSet() {
        return isSet.contains("shouldDeleteNetworkInterfaces");
    }

    @JsonIgnore
    public boolean isShouldDeleteSnapshotsSet() {
        return isSet.contains("shouldDeleteSnapshots");
    }

    @JsonIgnore
    public boolean isShouldDeleteVolumesSet() {
        return isSet.contains("shouldDeleteVolumes");
    }

    @JsonIgnore
    public boolean isShouldTerminateInstanceSet() {
        return isSet.contains("shouldTerminateInstance");
    }

}
