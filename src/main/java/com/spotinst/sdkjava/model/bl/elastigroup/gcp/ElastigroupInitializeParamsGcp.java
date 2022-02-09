package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupInitializeParamsGcp {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     diskSizeGb;
    private String      diskType;
    private String      sourceImage;
    //endregion

    //region Constructor
    private ElastigroupInitializeParamsGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter and Setter methods
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getDiskSizeGb() {
        return diskSizeGb;
    }

    public void setDiskSizeGb(Integer diskSizeGb) {
        isSet.add("diskSizeGb");
        this.diskSizeGb = diskSizeGb;
    }

    public String getDiskType() { return diskType; }

    public void setDiskType(String diskType) {
        isSet.add("diskType");
        this.diskType = diskType;
    }

    public String getSourceImage() { return sourceImage; }

    public void setSourceImage(String sourceImage) {
        isSet.add("sourceImage");
        this.sourceImage = sourceImage;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupInitializeParamsGcp capacity;

        private Builder() {
            this.capacity = new ElastigroupInitializeParamsGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDiskSizeGb(final Integer diskSizeGb) {
            capacity.setDiskSizeGb(diskSizeGb);
            return this;
        }

        public Builder setDiskType(final String diskType) {
            capacity.setDiskType(diskType);
            return this;
        }

        public Builder setSourceImage(final String sourceImage) {
            capacity.setSourceImage(sourceImage);
            return this;
        }

        public ElastigroupInitializeParamsGcp build() {
            return capacity;
        }
    }
    //endregion

    //region isSet methods
    // Is diskSizeGb Set boolean method
    @JsonIgnore
    public boolean isDiskSizeGbSet() { return isSet.contains("diskSizeGb"); }

    // Is diskType Set boolean method
    @JsonIgnore
    public boolean isDiskTypeSet() { return isSet.contains("diskType"); }

    // Is sourceImage Set boolean method
    @JsonIgnore
    public boolean isSourceImageSet() { return isSet.contains("sourceImage"); }
    //endregion
}
