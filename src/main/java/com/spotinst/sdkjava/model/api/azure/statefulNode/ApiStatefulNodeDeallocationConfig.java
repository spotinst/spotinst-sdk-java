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
    private Set<String>                               isSet;
    private Boolean                                   shouldTerminateVm;
    private ApiStatefulNodeNetworkDeallocationConfig  networkDeallocationConfig;
    private ApiStatefulNodeDiskDeallocationConfig     diskDeallocationConfig;
    private ApiStatefulNodeSnapshotDeallocationConfig snapshotDeallocationConfig;
    private ApiStatefulNodePublicIpDeallocationConfig publicIpDeallocationConfig;

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

    public ApiStatefulNodeNetworkDeallocationConfig getNetworkDeallocationConfig() {
        return networkDeallocationConfig;
    }

    public void setNetworkDeallocationConfig(ApiStatefulNodeNetworkDeallocationConfig networkDeallocationConfig) {
        isSet.add("networkDeallocationConfig");
        this.networkDeallocationConfig = networkDeallocationConfig;
    }

    public ApiStatefulNodeDiskDeallocationConfig getDiskDeallocationConfig() {
        return diskDeallocationConfig;
    }

    public void setDiskDeallocationConfig(ApiStatefulNodeDiskDeallocationConfig diskDeallocationConfig) {
        isSet.add("diskDeallocationConfig");
        this.diskDeallocationConfig = diskDeallocationConfig;
    }

    public ApiStatefulNodeSnapshotDeallocationConfig getSnapshotDeallocationConfig() {
        return snapshotDeallocationConfig;
    }

    public void setSnapshotDeallocationConfig(ApiStatefulNodeSnapshotDeallocationConfig snapshotDeallocationConfig) {
        isSet.add("snapshotDeallocationConfig");
        this.snapshotDeallocationConfig = snapshotDeallocationConfig;
    }

    public ApiStatefulNodePublicIpDeallocationConfig getPublicIpDeallocationConfig() {
        return publicIpDeallocationConfig;
    }

    public void setPublicIpDeallocationConfig(ApiStatefulNodePublicIpDeallocationConfig publicIpDeallocationConfig) {
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