package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class EbsDevice {

    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Boolean                  deleteOnTermination;
    private Boolean                  encrypted;
    private Integer                  iops;
    private String                   snapshotId;
    private Integer                  volumeSize;
    private AwsVolumeTypeEnum        volumeType;
    private Integer                  throughput;
    //endregion

    //region Constructor
    private EbsDevice() {
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

    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EbsDevice ebsDevice = (EbsDevice) o;

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

    //region Builder class
    public static class Builder {
        private EbsDevice ebsDevice;

        private Builder() {
            this.ebsDevice = new EbsDevice();
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

        public Builder setEncrypted(final Boolean encrypted) {
            ebsDevice.setEncrypted(encrypted);
            return this;
        }

        public Builder setIops(final Integer iops) {
            ebsDevice.setIops(iops);
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

        public EbsDevice build() {
            // TODO : Validations
            return ebsDevice;
        }
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
    //endregion
}
