package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKEStrategy;

import java.util.HashSet;
import java.util.Set;

public class ApiOceanGKEStrategy {

    private int         preemptiblePercentage;
    private Set<String> isSet;

    private ApiOceanGKEStrategy(){isSet = new HashSet<>();
    }

    public int getPreemptiblePercentage() {
        return preemptiblePercentage;
    }

    public void setPreemptiblePercentage(int preemptiblePercentage) {
        isSet.add("preemptiblePercentage");
        this.preemptiblePercentage = preemptiblePercentage;
    }

    public static class Builder {
        private ApiOceanGKEStrategy apiGkeStartergy;

        private Builder() {
            this.apiGkeStartergy = new ApiOceanGKEStrategy();
        }

        public static ApiOceanGKEStrategy.Builder get() {
            ApiOceanGKEStrategy.Builder builder = new ApiOceanGKEStrategy.Builder();
            return builder;
        }

        public ApiOceanGKEStrategy.Builder setPreemptiblePercentage(final int preemptiblePercentage) {
            apiGkeStartergy.setPreemptiblePercentage(preemptiblePercentage);
            return this;
        }

        public ApiOceanGKEStrategy build() {
            return apiGkeStartergy;
        }
    }


    @JsonIgnore
    public boolean isPreemptiblePercentageSet() {
        return isSet.contains("preemptiblePercentage");
    }


}
