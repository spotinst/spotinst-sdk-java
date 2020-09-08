package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ImageSpecAzure {
    //region Members
    @JsonIgnore
    private Set<String> isSet;

    //private List<CustomSpecAzure>         custom;
    private List<MarketplaceAzure> matketplace;     //TODO Itzik - typo

    //todo add custom



    //endregion

    //region Constructor

    private ImageSpecAzure() {
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

    public List<MarketplaceAzure> getMatketplace() {
        return matketplace;
    }

    public void setMatketplace(List<MarketplaceAzure> matketplace) {
        isSet.add("matketplace");
        this.matketplace = matketplace;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ImageSpecAzure launchSpecification;

        private Builder() {
            this.launchSpecification = new ImageSpecAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setMatketplace(final List<MarketplaceAzure> marketplace) {
            launchSpecification.setMatketplace(marketplace);
            return this;
        }

        public ImageSpecAzure build() {
            // TODO : Validations
            return launchSpecification;
        }
    }
    //endregion
    //region isSet methods


    // Is matketplace Set boolean method
    @JsonIgnore
    public boolean isMatketplaceSet() {
        return isSet.contains("matketplace");
    }
    //endregion
}
