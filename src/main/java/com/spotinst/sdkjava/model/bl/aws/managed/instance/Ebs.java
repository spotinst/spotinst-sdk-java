package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ebs {

    //region Members
    @JsonIgnore
    private Set<String>       isSet;
    private Boolean           deleteOnTermination;
    private Integer           iops;
    private Integer           throughput;
    private Integer           volumeSize;
    private String            volumeType;

    //endregion

    //region Constructor
    private Ebs() {
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

    public Integer getIops() {
        return iops;
    }

    public void setIops(Integer iops) {
        isSet.add("iops");
        this.iops = iops;
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

    //region Builder class
    public static class Builder {
        private Ebs ebs;

        private Builder() {
            this.ebs = new Ebs();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDeleteOnTermination(final Boolean deleteOnTermination) {
            ebs.setDeleteOnTermination(deleteOnTermination);
            return this;
        }

        public Builder setIops(final Integer iops) {
            ebs.setIops(iops);
            return this;
        }

        public Builder setThroughput(final Integer throughput) {
            ebs.setThroughput(throughput);
            return this;
        }

        public Builder setVolumeSize(final Integer volumeSize) {
            ebs.setVolumeSize(volumeSize);
            return this;
        }

        public Builder setVolumeType(final String volumeType) {
            ebs.setVolumeType(volumeType);
            return this;
        }

        public com.spotinst.sdkjava.model.bl.aws.managed.instance.Ebs build() {
            // TODO : Validations
            return ebs;
        }
    }

    //endregion

    //region isSet methods
    // Is deleteOnTermination Set boolean method
    @JsonIgnore
    public boolean isDeleteOnTerminationSet() {
        return isSet.contains("deleteOnTermination");
    }

    // Is iops Set boolean method
    @JsonIgnore
    public boolean isIopsSet() {
        return isSet.contains("iops");
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
