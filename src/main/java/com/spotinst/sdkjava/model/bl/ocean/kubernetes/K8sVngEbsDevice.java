package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;

import java.util.HashSet;
import java.util.Set;

public class K8sVngEbsDevice {

    @JsonIgnore
    private Set<String>              isSet;
    private Boolean                  deleteOnTermination;
    private K8sVngDynamicVolumeSize  dynamicVolumeSize;
    private Boolean                  encrypted;
    private Integer                  iops;
    private String                   kmsKeyId;
    private String                   snapshotId;
    private Integer                  volumeSize;
    private AwsVolumeTypeEnum        volumeType;
    private Integer                  throughput;

    private K8sVngEbsDevice() {
        isSet = new HashSet<>();
    }

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

    public K8sVngDynamicVolumeSize getDynamicVolumeSize() {
        return dynamicVolumeSize;
    }

    public void setDynamicVolumeSize(K8sVngDynamicVolumeSize dynamicVolumeSize) {
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

    public Integer getVolumeSize() {
        return volumeSize;
    }

    public void setVolumeSize(Integer volumeSize) {
        isSet.add("volumeSize");
        this.volumeSize = volumeSize;
    }

    public AwsVolumeTypeEnum getVolumeType() {
        return volumeType;
    }

    public void setVolumeType(AwsVolumeTypeEnum volumeType) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        K8sVngEbsDevice ebsDevice = (K8sVngEbsDevice) o;

        if (deleteOnTermination != ebsDevice.deleteOnTermination) return false;
        if (encrypted != ebsDevice.encrypted) return false;
        if (iops != null ? !iops.equals(ebsDevice.iops) : ebsDevice.iops != null) return false;
        if (snapshotId != null ? !snapshotId.equals(ebsDevice.snapshotId) : ebsDevice.snapshotId != null) return false;
        if (volumeSize != null ? !volumeSize.equals(ebsDevice.volumeSize) : ebsDevice.volumeSize != null) return false;
        return volumeType == ebsDevice.volumeType;

    }

    @Override
    public int hashCode() {
        int result = (deleteOnTermination ? 1 : 0);
        result = 31 * result + (encrypted ? 1 : 0);
        result = 31 * result + (iops != null ? iops.hashCode() : 0);
        result = 31 * result + (snapshotId != null ? snapshotId.hashCode() : 0);
        result = 31 * result + (volumeSize != null ? volumeSize.hashCode() : 0);
        result = 31 * result + (volumeType != null ? volumeType.hashCode() : 0);
        return result;
    }

    public static class Builder {
        private K8sVngEbsDevice ebsDevice;

        private Builder() {
            this.ebsDevice = new K8sVngEbsDevice();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVolumeType(final AwsVolumeTypeEnum volumeType) {
            ebsDevice.setVolumeType(volumeType);
            return this;
        }

        public Builder setDeleteOnTermination(final Boolean deleteOnTermination) {
            ebsDevice.setDeleteOnTermination(deleteOnTermination);
            return this;
        }

        public Builder setDynamicVolumeSize(final K8sVngDynamicVolumeSize dynamicVolumeSize) {
            ebsDevice.setDynamicVolumeSize(dynamicVolumeSize);
            return this;
        }

        public Builder setEncrypted(final Boolean encrypted) {
            ebsDevice.setEncrypted(encrypted);
            return this;
        }

        public Builder setIops(final Integer iops) {
            ebsDevice.setIops(iops);
            return this;
        }

        public Builder setKmsKeyId(final String kmsKeyId) {
            ebsDevice.setKmsKeyId(kmsKeyId);
            return this;
        }

        public Builder setThroughput(final Integer throughput) {
            ebsDevice.setThroughput(throughput);
            return this;
        }

        public Builder setSnapshotId(final String snapshotId) {
            ebsDevice.setSnapshotId(snapshotId);
            return this;
        }

        public Builder setVolumeSize(final Integer volumeSize) {
            ebsDevice.setVolumeSize(volumeSize);
            return this;
        }

        public K8sVngEbsDevice build() {
            // TODO : Validations
            return ebsDevice;
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
    public boolean isVolumeSizeSet() {
        return isSet.contains("volumeSize");
    }

    @JsonIgnore
    public boolean isVolumeTypeSet() {
        return isSet.contains("volumeType");
    }

    @JsonIgnore
    public boolean isThroughputSet() {
        return isSet.contains("throughput");
    }
}
