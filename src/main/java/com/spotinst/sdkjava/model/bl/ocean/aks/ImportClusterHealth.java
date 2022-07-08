package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ImportClusterHealth {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     gracePeriod;

    private ImportClusterHealth() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        isSet.add("gracePeriod");
        this.gracePeriod = gracePeriod;
    }

    public static class Builder {
        private ImportClusterHealth headroom;

        private Builder() {
            this.headroom = new ImportClusterHealth();
        }

        public static ImportClusterHealth.Builder get() {
            return new Builder();
        }

        public ImportClusterHealth.Builder setGracePeriod(final Integer gracePeriod) {
            headroom.setGracePeriod(gracePeriod);
            return this;
        }

        public ImportClusterHealth build() {
            return headroom;
        }
    }

    @JsonIgnore
    public boolean isGracePeriodSet() {return isSet.contains("gracePeriod");}

}
