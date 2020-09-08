package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupVmSizesAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> odSizes;
    private List<String> spotSizes;
    //endregion

    //region Constructors
    private ElastigroupVmSizesAzure() {
        isSet = new HashSet<>();
    }

    public ElastigroupVmSizesAzure(String odSizes, String spotSizes) {
        this.setOdSizes(Arrays.asList(odSizes));
        this.setSpotSizes(Arrays.asList(spotSizes));
    }
    public ElastigroupVmSizesAzure(List<String> odSizes, List<String> spotSizes) {
        this.setOdSizes(odSizes);
        this.setSpotSizes(spotSizes);
    }

    public ElastigroupVmSizesAzure(ElastigroupVmSizesAzure src) {
        if (src != null) {
            this.odSizes = src.odSizes;

            if (src.spotSizes != null) {
                this.spotSizes = src.spotSizes.stream().map(String::new).collect(Collectors.toList());
            }
        }
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getOdSizes() {
        return odSizes;
    }

    public void setOdSizes(List<String> odSizes) {
        isSet.add("odSizes");
        this.odSizes = odSizes;
    }


    public List<String> getSpotSizes() {
        return spotSizes;
    }

    public void setSpotSizes(List<String> spotSizes) {
        isSet.add("spotSizes");
        this.spotSizes = spotSizes;
    }
    //endregion

    //region Object overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ElastigroupVmSizesAzure that = (ElastigroupVmSizesAzure) o;

        if (odSizes != null ? !odSizes.equals(that.odSizes) : that.odSizes != null) {
            return false;
        }
        return spotSizes != null ? spotSizes.equals(that.spotSizes) : that.spotSizes == null;

    }

    @Override
    public int hashCode() {
        int result = odSizes != null ? odSizes.hashCode() : 0;
        result = 31 * result + (spotSizes != null ? spotSizes.hashCode() : 0);
        return result;
    }

    //endregion

    //region isSet methods
    // Is odSizes Set boolean method
    @JsonIgnore
    public boolean isOdSizesSet() {
        return isSet.contains("odSizes");
    }

    // Is spotSizes Set boolean method
    @JsonIgnore
    public boolean isSpotSizesSet() {
        return isSet.contains("spotSizes");
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupVmSizesAzure vmSizesAzure;

        private Builder() {
            this.vmSizesAzure = new ElastigroupVmSizesAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setSpotSizes(final List<String> spotSizes) {
            vmSizesAzure.setSpotSizes(spotSizes);
            return this;
        }

        public Builder setOdSizes(final List<String>  odSizes) {
            vmSizesAzure.setOdSizes(odSizes);
            return this;
        }

        public ElastigroupVmSizesAzure build() {
            // TODO : Validations
            return vmSizesAzure;
        }
    }

    //endregion
}
