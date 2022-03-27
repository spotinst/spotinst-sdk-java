package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class AzureStorageVolumeCapacity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     sizeGiB;
    private Integer     minSizeGiB;
    private Integer     maxSizeGiB;
    //endregion

    //region Constructor
    private AzureStorageVolumeCapacity() {
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

    //region SizeGiB
    public Integer getSizeGiB() {
        return sizeGiB;
    }

    public void setSizeGiB(Integer sizeGiB) {
        isSet.add("sizeGiB");
        this.sizeGiB = sizeGiB;
    }
    //endregion

    //region MinSizeGiB
    public Integer getMinSizeGiB() {
        return minSizeGiB;
    }

    public void setMinSizeGiB(Integer minSizeGiB) {
        isSet.add("minSizeGiB");
        this.minSizeGiB = minSizeGiB;
    }
    //endregion

    //region MaxSizeGiB
    public Integer getMaxSizeGiB() {
        return maxSizeGiB;
    }

    public void setMaxSizeGiB(Integer maxSizeGiB) {
        isSet.add("maxSizeGiB");
        this.maxSizeGiB = maxSizeGiB;
    }
    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private AzureStorageVolumeCapacity volumeCapacity;
        //endregion


        private Builder() {
            this.volumeCapacity = new AzureStorageVolumeCapacity();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setSizeGiB(final Integer sizeGiB) {
            volumeCapacity.setSizeGiB(sizeGiB);
            return this;
        }

        public Builder setMinSizeGiB(final Integer minSizeGiB) {
            volumeCapacity.setMinSizeGiB(minSizeGiB);
            return this;
        }

        public Builder setMaxSizeGiB(final Integer maxSizeGiB) {
            volumeCapacity.setMaxSizeGiB(maxSizeGiB);
            return this;
        }

        public AzureStorageVolumeCapacity build() {
            // Validations
            return volumeCapacity;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is sizeGiB Set boolean method
    @JsonIgnore
    public boolean isSizeGiBSet() {
        return isSet.contains("sizeGiB");
    }

    // Is minSizeGiB Set boolean method
    @JsonIgnore
    public boolean isMinSizeGiBSet() {
        return isSet.contains("minSizeGiB");
    }

    // Is maxSizeGiB Set boolean method
    @JsonIgnore
    public boolean isMaxSizeGiBSet() {
        return isSet.contains("maxSizeGiB");
    }

    //endregion
}
