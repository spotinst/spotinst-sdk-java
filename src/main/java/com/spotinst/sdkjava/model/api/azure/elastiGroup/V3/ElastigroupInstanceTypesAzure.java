package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
public class ElastigroupInstanceTypesAzure {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String onDemand;
    private List<String> spot;
    //endregion

    //region Constructors

    private ElastigroupInstanceTypesAzure() {
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
    //endregion

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupInstanceTypesAzure instanceTypes;

        private Builder() {
            this.instanceTypes = new ElastigroupInstanceTypesAzure();
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

        public ElastigroupInstanceTypesAzure build() {
            // TODO : Validations
            return instanceTypes;
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

    //endregion
}
