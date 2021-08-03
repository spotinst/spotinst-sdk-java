package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class LaunchSpecEbsSpecification {
    //region Members
    @JsonIgnore
    private Set<String>                 isSet;
    private Boolean                     deleteOnTermination;
    private LaunchSpecDynamicVolumeSize dynamicVolumeSize;
    private Boolean                     encrypted;
    private Integer                     iops;
    private String                      kmsKeyId;
    private String                      snapshotId;
    private Integer                     throughput;
    private Integer                     volumeSize;
    private String                      volumeType;

    //endregion

    //region Constructors
    private LaunchSpecEbsSpecification() {
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

    public LaunchSpecDynamicVolumeSize getDynamicVolumeSize() {
        return dynamicVolumeSize;
    }

    public void setDynamicVolumeSize(LaunchSpecDynamicVolumeSize dynamicVolumeSize) {
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

    public static class Builder {

        private LaunchSpecEbsSpecification launchSpecEbsSpecification;

        private Builder() {
            this.launchSpecEbsSpecification = new LaunchSpecEbsSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDeleteOnTermination(final Boolean deleteOnTermination) {
            launchSpecEbsSpecification.setDeleteOnTermination(deleteOnTermination);
            return this;
        }

        public Builder setDynamicVolumeSize(final LaunchSpecDynamicVolumeSize dynamicVolumeSize) {
            launchSpecEbsSpecification.setDynamicVolumeSize(dynamicVolumeSize);
            return this;
        }

        public Builder setEncrypted(final Boolean encrypted) {
            launchSpecEbsSpecification.setEncrypted(encrypted);
            return this;
        }

        public Builder setIops(final Integer iops) {
            launchSpecEbsSpecification.setIops(iops);
            return this;
        }

        public Builder setKmsKeyId(final String kmsKeyId) {
            launchSpecEbsSpecification.setKmsKeyId(kmsKeyId);
            return this;
        }

        public Builder setSnapshotId(final String snapshotId) {
            launchSpecEbsSpecification.setSnapshotId(snapshotId);
            return this;
        }

        public Builder setThroughput(final Integer throughput) {
            launchSpecEbsSpecification.setThroughput(throughput);
            return this;
        }

        public Builder setVolumeSize(final Integer volumeSize) {
            launchSpecEbsSpecification.setVolumeSize(volumeSize);
            return this;
        }

        public Builder setVolumeType(final String volumeType) {
            launchSpecEbsSpecification.setVolumeType(volumeType);
            return this;
        }

        public LaunchSpecEbsSpecification build() {
            return launchSpecEbsSpecification;
        }
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
