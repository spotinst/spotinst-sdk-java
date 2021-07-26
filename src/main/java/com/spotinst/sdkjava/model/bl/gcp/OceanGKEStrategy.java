package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class OceanGKEStrategy {

    private int preemptiblePercentage;
    private Set<String> isSet;

    public OceanGKEStrategy(){isSet = new HashSet<>();
    }

    public int getPreemptiblePercentage() {
        return preemptiblePercentage;
    }

    public void setPreemptiblePercentage(int preemptiblePercentage) {
        isSet.add("preemptiblePercentage");
        this.preemptiblePercentage = preemptiblePercentage;
    }

    public static class Builder {
        private OceanGKEStrategy gkeStartergy;

        private Builder() {
            this.gkeStartergy = new OceanGKEStrategy();
        }

        public static OceanGKEStrategy.Builder get() {
            OceanGKEStrategy.Builder builder = new OceanGKEStrategy.Builder();
            return builder;
        }

        public OceanGKEStrategy.Builder setPreemptiblePercentage(final int preemptiblePercentage) {
            gkeStartergy.setPreemptiblePercentage(preemptiblePercentage);
            return this;
        }

        public OceanGKEStrategy build() {
            return gkeStartergy;
        }
    }


    @JsonIgnore
    public boolean isPreemptiblePercentageSet() {
        return isSet.contains("preemptiblePercentage");
    }



}
