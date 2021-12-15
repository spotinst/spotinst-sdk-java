package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
public class ElastigroupInstanceTypes {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String onDemand;
    private List<String> spot;
    private List<String> preferredspot;
    private List<ElastigroupInstanceTypesWeights> weights;
    //endregion

    //region Constructors

    private ElastigroupInstanceTypes() {
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

    //region PreferredSpot
    public List<String> getPreferredSpot() {
        return preferredspot;
    }

    public void setPreferredSpot(List<String> preferredspot) {
        isSet.add("preferredSpot");
        this.preferredspot = preferredspot;
    }
    //endregion

    //region Spot
    public List<String> getSpot() {
        return spot;
    }

    public void setSpot(List<String> spot) {
        isSet.add("spot");
        this.spot = spot;
    }
    //endregion

    //region OD
    public String getOnDemand() {
        return onDemand;
    }

    public void setOnDemand(String onDemand) {
        isSet.add("onDemand");
        this.onDemand = onDemand;
    }

    public List<ElastigroupInstanceTypesWeights> getWeights() {
        return weights;
    }

    public void setWeights(List<ElastigroupInstanceTypesWeights> weights) {
        isSet.add("weights");
        this.weights = weights;
    }
    //endregion

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupInstanceTypes instanceTypes;

        private Builder() {
            this.instanceTypes = new ElastigroupInstanceTypes();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setOnDemandType(final String onDemandType) {
            instanceTypes.setOnDemand(onDemandType);
            return this;
        }

        public Builder setSpotTypes(final List<String> spotTypes) {
            instanceTypes.setSpot(spotTypes);
            return this;
        }

        public Builder setPreferredSpotTypes(final List<String> preferredSpotTypes) {
            instanceTypes.setPreferredSpot(preferredSpotTypes);
            return this;
        }

        public ElastigroupInstanceTypes build() {
            // TODO : Validations
            return instanceTypes;
        }

        public Builder setWeights(final List<ElastigroupInstanceTypesWeights> weights) {
            instanceTypes.setWeights(weights);
            return this;
        }
    }
    //endregion
    //region isSet methods
    // Is onDemand Set boolean method
    @JsonIgnore
    public boolean isOnDemandSet() {
        return isSet.contains("onDemand");
    }

    // Is spot Set boolean method
    @JsonIgnore
    public boolean isSpotSet() {
        return isSet.contains("spot");
    }

    // Is spot Set boolean method
    @JsonIgnore
    public boolean isPreferredSpotSet() {
        return isSet.contains("preferredSpot");
    }

    // Is weights Set boolean method
    @JsonIgnore
    public boolean isWeightsSet() {
        return isSet.contains("weights");
    }

    //endregion
}
