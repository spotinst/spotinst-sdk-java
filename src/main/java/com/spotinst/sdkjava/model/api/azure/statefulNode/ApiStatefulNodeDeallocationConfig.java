package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeDeallocationConfig implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>             isSet;
    private Boolean                 shouldTerminateVm;
    private ApiDeallocationConfig   networkDeallocationConfig;
    private ApiDeallocationConfig   diskDeallocationConfig;
    private ApiDeallocationConfig   snapshotDeallocationConfig;
    private ApiDeallocationConfig   publicIpDeallocationConfig;

    public ApiStatefulNodeDeallocationConfig() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldTerminateVm() {
        return shouldTerminateVm;
    }

    public void setShouldTerminateVm(Boolean shouldTerminateVm) {
        isSet.add("shouldTerminateVm");
        this.shouldTerminateVm = shouldTerminateVm;
    }

    public ApiDeallocationConfig getNetworkDeallocationConfig() {
        return networkDeallocationConfig;
    }

    public void setNetworkDeallocationConfig(ApiDeallocationConfig networkDeallocationConfig) {
        isSet.add("networkDeallocationConfig");
        this.networkDeallocationConfig = networkDeallocationConfig;
    }

    public ApiDeallocationConfig getDiskDeallocationConfig() {
        return diskDeallocationConfig;
    }

    public void setDiskDeallocationConfig(ApiDeallocationConfig diskDeallocationConfig) {
        isSet.add("diskDeallocationConfig");
        this.diskDeallocationConfig = diskDeallocationConfig;
    }

    public ApiDeallocationConfig getSnapshotDeallocationConfig() {
        return snapshotDeallocationConfig;
    }

    public void setSnapshotDeallocationConfig(ApiDeallocationConfig snapshotDeallocationConfig) {
        isSet.add("snapshotDeallocationConfig");
        this.snapshotDeallocationConfig = snapshotDeallocationConfig;
    }

    public ApiDeallocationConfig getPublicIpDeallocationConfig() {
        return publicIpDeallocationConfig;
    }

    public void setPublicIpDeallocationConfig(ApiDeallocationConfig publicIpDeallocationConfig) {
        isSet.add("publicIpDeallocationConfig");
        this.publicIpDeallocationConfig = publicIpDeallocationConfig;
    }

    @JsonIgnore
    public boolean isShouldTerminateVmSet() {
        return isSet.contains("shouldTerminateVm");
    }

    @JsonIgnore
    public boolean isNetworkDeallocationConfigSet() {
        return isSet.contains("networkDeallocationConfig");
    }

    @JsonIgnore
    public boolean isDiskDeallocationConfigSet() {
        return isSet.contains("diskDeallocationConfig");
    }

    @JsonIgnore
    public boolean isSnapshotDeallocationConfigSet() {
        return isSet.contains("snapshotDeallocationConfig");
    }

    @JsonIgnore
    public boolean isPublicIpDeallocationConfigSet() {
        return isSet.contains("publicIpDeallocationConfig");
    }


}