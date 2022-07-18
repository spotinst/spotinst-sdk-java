package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ImportClusterHeadroomSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private ImportClusterHeadroomAutomatic automatic;

    private ImportClusterHeadroomSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ImportClusterHeadroomAutomatic getAutomatic() {
        return automatic;
    }

    public void setAutomatic(ImportClusterHeadroomAutomatic automatic) {
        isSet.add("automatic");
        this.automatic = automatic;
    }

    public static class Builder {
        private ImportClusterHeadroomSpecification headroom;

        private Builder() {
            this.headroom = new ImportClusterHeadroomSpecification();
        }

        public static ImportClusterHeadroomSpecification.Builder get() {
            return new Builder();
        }

        public ImportClusterHeadroomSpecification.Builder setAutomatic(final ImportClusterHeadroomAutomatic automatic) {
            headroom.setAutomatic(automatic);
            return this;
        }

        public ImportClusterHeadroomSpecification build() {
            return headroom;
        }
    }

    @JsonIgnore
    public boolean isAutomaticSet() {
        return isSet.contains("automatic");
    }

}
