package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLaunchSpecEbsSpecification implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private Boolean                        deleteOnTermination;
    private ApiLaunchSpecDynamicVolumeSize dynamicVolumeSize;
    private Boolean                        encrypted;
    private Integer                        iops;
    private String                         kmsKeyId;
    private String                         snapshotId;
    private Integer                        throughput;
    private Integer                        volumeSize;
    private String                         volumeType;

    //endregion

    //region Constructors
    public ApiLaunchSpecEbsSpecification() {
        isSet = new HashSet<>();
    }
    //endregion

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

    public ApiLaunchSpecDynamicVolumeSize getDynamicVolumeSize() {
        return dynamicVolumeSize;
    }

    public void setDynamicVolumeSize(ApiLaunchSpecDynamicVolumeSize dynamicVolumeSize) {
        isSet.add("dynamicVolumeSize");
        this.dynamicVolumeSize = dynamicVolumeSize;
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

    public String getKmsKeyId() {
        return kmsKeyId;
    }

    public void setKmsKeyId(String kmsKeyId) {
        isSet.add("kmsKeyId");
        this.kmsKeyId = kmsKeyId;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        isSet.add("snapshotId");
        this.snapshotId = snapshotId;
    }

    public Integer getThroughput() {
        return throughput;
    }

    public void setThroughput(Integer throughput) {
        isSet.add("throughput");
        this.throughput = throughput;
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

    @JsonIgnore
    public boolean isDeleteOnTerminationSet() {
        return isSet.contains("deleteOnTermination");
    }

    @JsonIgnore
    public boolean isDynamicVolumeSizeSet() {
        return isSet.contains("dynamicVolumeSize");
    }

    @JsonIgnore
    public boolean isEncryptedSet() {
        return isSet.contains("encrypted");
    }

    @JsonIgnore
    public boolean isIopsSet() {
        return isSet.contains("iops");
    }

    @JsonIgnore
    public boolean isKmsKeyIdSet() {
        return isSet.contains("kmsKeyId");
    }

    @JsonIgnore
    public boolean isSnapshotIdSet() {
        return isSet.contains("snapshotId");
    }

    @JsonIgnore
    public boolean isThroughputSet() {
        return isSet.contains("throughput");
    }

    @JsonIgnore
    public boolean isVolumeSizeSet() {
        return isSet.contains("volumeSize");
    }

    @JsonIgnore
    public boolean isVolumeTypeSet() {
        return isSet.contains("volumeType");
    }

}
