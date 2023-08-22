package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ResourceRequirements;

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
    private List<String> onDemandTypes;
    private List<String> spot;
    private List<String> preferredspot;
    private List<ElastigroupInstanceTypesWeights> weights;
    private ResourceRequirements resourcerequirements;
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

    public List<String> getOnDemandTypes() {
        return onDemandTypes;
    }

    public void setOnDemandTypes(List<String> onDemandTypes) {
        isSet.add("onDemandTypes");
        this.onDemandTypes = onDemandTypes;
    }

    public List<ElastigroupInstanceTypesWeights> getWeights() {
        return weights;
    }

    public void setWeights(List<ElastigroupInstanceTypesWeights> weights) {
        isSet.add("weights");
        this.weights = weights;
    }

    public ResourceRequirements getResourceRequirements() {
        return resourcerequirements;
    }

    public void setResourceRequirements(ResourceRequirements requirements) {
        isSet.add("resourceRequirements");
        this.resourcerequirements = requirements;
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
            return new Builder();
        }

        public Builder setOnDemandType(final String onDemandType) {
            instanceTypes.setOnDemand(onDemandType);
            return this;
        }

        public Builder setOnDemandTypes(final List<String> onDemandTypes) {
            instanceTypes.setOnDemandTypes(onDemandTypes);
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

        public Builder setResourceRequirements(final ResourceRequirements requirements) {
            instanceTypes.setResourceRequirements(requirements);
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

    @JsonIgnore
    public boolean isOnDemandTypesSet() {
        return isSet.contains("onDemandTypes");
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

    @JsonIgnore
    public boolean isResourceRequirementsSet() {
        return isSet.contains("resourceRequirements");
    }
    //endregion
}
