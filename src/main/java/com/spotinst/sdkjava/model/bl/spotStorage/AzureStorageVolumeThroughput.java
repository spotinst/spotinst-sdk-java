package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class AzureStorageVolumeThroughput {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Double      throughputMibps;
    //endregion

    //region Constructor
    private AzureStorageVolumeThroughput() {
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

    //region ThroughputMibps
    public Double getThroughputMibps() {
        return throughputMibps;
    }

    public void setThroughputMibps(Double throughputMibps) {
        isSet.add("throughputMibps");
        this.throughputMibps = throughputMibps;
    }
    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private AzureStorageVolumeThroughput volumeThroughput;
        //endregion


        private Builder() {
            this.volumeThroughput = new AzureStorageVolumeThroughput();
        }

        public static AzureStorageVolumeThroughput.Builder get() {
            return new Builder();
        }

        //region Build methods
        public AzureStorageVolumeThroughput.Builder setThroughputMibps(final Double throughputMibps) {
            volumeThroughput.setThroughputMibps(throughputMibps);
            return this;
        }

        public AzureStorageVolumeThroughput build() {
            // Validations
            return volumeThroughput;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is throughputMibps Set boolean method
    @JsonIgnore
    public boolean isThroughputMibpsSet() {
        return isSet.contains("throughputMibps");
    }
    //endregion
}
