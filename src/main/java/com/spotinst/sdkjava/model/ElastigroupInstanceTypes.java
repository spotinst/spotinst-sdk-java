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
    private List<ElastigroupWeights> weights;
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

    public List<ElastigroupWeights> getWeights() {
        return weights;
    }

    public void setWeights(List<ElastigroupWeights> weights) {
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

        public ElastigroupInstanceTypes build() {
            // TODO : Validations
            return instanceTypes;
        }

        public Builder setWeights(final List<ElastigroupWeights> weights) {
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

    // Is weights Set boolean method
    @JsonIgnore
    public boolean isWeightsSet() {
        return isSet.contains("weights");
    }

    //endregion
}
