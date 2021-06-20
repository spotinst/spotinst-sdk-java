package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class VolumeThroughput {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Double      throughputMibps;
    //endregion

    //region Constructor
    private VolumeThroughput() {
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
        private VolumeThroughput volumeThroughput;
        //endregion


        private Builder() {
            this.volumeThroughput = new VolumeThroughput();
        }

        public static VolumeThroughput.Builder get() {
            VolumeThroughput.Builder builder = new VolumeThroughput.Builder();
            return builder;
        }

        //region Build methods
        public VolumeThroughput.Builder setThroughputMibps(final Double throughputMibps) {
            volumeThroughput.setThroughputMibps(throughputMibps);
            return this;
        }

        public VolumeThroughput build() {
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
