package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterEbsSpecification {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Boolean                  deleteOnTermination;
    private ClusterDynamicVolumeSize dynamicVolumeSize;
    private Boolean                  encrypted;
    private Integer                  iops;
    private String                   kmsKeyId;
    private String                   snapshotId;
    private Integer                  throughput;
    private Integer                  volumeSize;
    private String                   volumeType;

    //endregion

    //region Constructors
    private ClusterEbsSpecification() {
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

    public ClusterDynamicVolumeSize getDynamicVolumeSize() {
        return dynamicVolumeSize;
    }

    public void setDynamicVolumeSize(ClusterDynamicVolumeSize dynamicVolumeSize) {
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

        private ClusterEbsSpecification clusterEbsSpecification;

        private Builder() {
            this.clusterEbsSpecification = new ClusterEbsSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDeleteOnTermination(final Boolean deleteOnTermination) {
            clusterEbsSpecification.setDeleteOnTermination(deleteOnTermination);
            return this;
        }

        public Builder setDynamicVolumeSize(final ClusterDynamicVolumeSize dynamicVolumeSize) {
            clusterEbsSpecification.setDynamicVolumeSize(dynamicVolumeSize);
            return this;
        }

        public Builder setEncrypted(final Boolean encrypted) {
            clusterEbsSpecification.setEncrypted(encrypted);
            return this;
        }

        public Builder setIops(final Integer iops) {
            clusterEbsSpecification.setIops(iops);
            return this;
        }

        public Builder setKmsKeyId(final String kmsKeyId) {
            clusterEbsSpecification.setKmsKeyId(kmsKeyId);
            return this;
        }

        public Builder setSnapshotId(final String snapshotId) {
            clusterEbsSpecification.setSnapshotId(snapshotId);
            return this;
        }

        public Builder setThroughput(final Integer throughput) {
            clusterEbsSpecification.setThroughput(throughput);
            return this;
        }

        public Builder setVolumeSize(final Integer volumeSize) {
            clusterEbsSpecification.setVolumeSize(volumeSize);
            return this;
        }

        public Builder setVolumeType(final String volumeType) {
            clusterEbsSpecification.setVolumeType(volumeType);
            return this;
        }

        public ClusterEbsSpecification build() {
            return clusterEbsSpecification;
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
    public boolean isMsKeyIdSet() {
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
