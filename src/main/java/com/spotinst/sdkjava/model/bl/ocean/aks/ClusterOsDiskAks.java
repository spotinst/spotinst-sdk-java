package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterOsDiskAks {
    @JsonIgnore
    private Set<String>                         isSet;
    private Integer                             sizeGB;


    private ClusterOsDiskAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(Integer sizeGB) {
        isSet.add("sizeGB");
        this.sizeGB = sizeGB;
    }

    @JsonIgnore
    public boolean isSizeGBSet() {
        return isSet.contains("sizeGB");
    }

    public static class Builder {

        private ClusterOsDiskAks clusterOsDiskAks;
        private Builder() {
            this.clusterOsDiskAks = new ClusterOsDiskAks();
        }

        public static ClusterOsDiskAks.Builder get() {
            ClusterOsDiskAks.Builder builder = new ClusterOsDiskAks.Builder();
            return builder;
        }

        public ClusterOsDiskAks.Builder setSizeGB(final Integer sizeGB) {
            clusterOsDiskAks.setSizeGB(sizeGB);
            return this;
        }

        public ClusterOsDiskAks build() {
            return clusterOsDiskAks;
        }
    }
}
