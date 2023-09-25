package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiDynamicVolumeSize;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiDynamiclops;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiEbsDevice implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                 isSet;
    private Boolean                     deleteOnTermination;
    private Boolean                     encrypted;
    private Integer                     iops;
    private String                      snapshotId;
    private Integer                     volumeSize;
    private String                      volumeType;
    private Integer                     throughput;
    private ApiDynamiclops dynamicIops;
    private ApiDynamicVolumeSize dynamicVolumeSize;
    private String                      kmsKeyId;

    //region Constructor
    public ApiEbsDevice() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getDeleteOnTermination() {
        return deleteOnTermination;
    }

    public void setDeleteOnTermination(Boolean deleteOnTermination) {
        isSet.add("deleteOnTermination");
        this.deleteOnTermination = deleteOnTermination;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        isSet.add("encrypted");
        this.encrypted = encrypted;
    }

    public Integer getIops() {
        return iops;
    }

    public void setIops(Integer iops) {
        isSet.add("iops");
        this.iops = iops;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        isSet.add("snapshotId");
        this.snapshotId = snapshotId;
    }

    public Integer getVolumeSize() {
        return volumeSize;
    }

    public void setVolumeSize(Integer volumeSize) {
        isSet.add("volumeSize");
        this.volumeSize = volumeSize;
    }

    public String getVolumeType() {
        return volumeType;
    }

    public void setVolumeType(String volumeType) {
        isSet.add("volumeType");
        this.volumeType = volumeType;
    }

    public Integer getThroughput() {
        return throughput;
    }

    public void setThroughput(Integer throughput) {
        isSet.add("throughput");
        this.throughput = throughput;
    }

    public ApiDynamiclops getDynamicIops() {
        return dynamicIops;
    }

    public void setDynamicIops(ApiDynamiclops dynamicIops) {
        isSet.add("dynamicIops");
        this.dynamicIops = dynamicIops;
    }

    public ApiDynamicVolumeSize getDynamicVolumeSize() {
        return dynamicVolumeSize;
    }

    public void setDynamicVolumeSize(ApiDynamicVolumeSize dynamicVolumeSize) {
        isSet.add("dynamicVolumeSize");
        this.dynamicVolumeSize = dynamicVolumeSize;
    }

    public String getKmsKeyId() {
        return kmsKeyId;
    }

    public void setKmsKeyId(String kmsKeyId) {
        isSet.add("kmsKeyId");
        this.kmsKeyId = kmsKeyId;
    }

    //endregion

    //region isSet methods
    // Is deleteOnTermination Set boolean method
    @JsonIgnore
    public boolean isDeleteOnTerminationSet() {
        return isSet.contains("deleteOnTermination");
    }

    @JsonIgnore
    public boolean isDynamicVolumeSizeSet() {
        return isSet.contains("dynamicVolumeSize");
    }

    // Is encrypted Set boolean method
    @JsonIgnore
    public boolean isEncryptedSet() {
        return isSet.contains("encrypted");
    }


    // Is iops Set boolean method
    @JsonIgnore
    public boolean isIopsSet() {
        return isSet.contains("iops");
    }

    @JsonIgnore
    public boolean isMsKeyIdSet() {
        return isSet.contains("kmsKeyId");
    }

    // Is snapshotId Set boolean method
    @JsonIgnore
    public boolean isSnapshotIdSet() {
        return isSet.contains("snapshotId");
    }


    // Is volumeSize Set boolean method
    @JsonIgnore
    public boolean isVolumeSizeSet() {
        return isSet.contains("volumeSize");
    }

    // Is volumeType Set boolean method
    @JsonIgnore
    public boolean isVolumeTypeSet() {
        return isSet.contains("volumeType");
    }

    // Is throughput Set boolean method
    @JsonIgnore
    public boolean isThroughputSet() {
        return isSet.contains("throughput");
    }

    // Is dynamicIops Set boolean method
    @JsonIgnore
    public boolean isDynamicIopsSet() {
        return isSet.contains("dynamicIops");
    }

    // Is kmsKeyId Set boolean method
    @JsonIgnore
    public boolean isKmsKeyIdSet() {
        return isSet.contains("kmsKeyId");
    }
    //endregion
}
