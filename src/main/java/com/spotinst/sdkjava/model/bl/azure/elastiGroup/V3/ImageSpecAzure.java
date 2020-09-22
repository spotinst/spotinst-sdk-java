package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImageSpecAzure {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<CustomSpecAzure>  custom;
    private MarketplaceAzure marketplace;
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

    public List<CustomSpecAzure> getCustom() {
        return custom;
    }

    public void setCustom(List<CustomSpecAzure> custom) {
        isSet.add("custom");
        this.custom = custom;
    }

    public MarketplaceAzure getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(MarketplaceAzure marketplace) {
        isSet.add("marketplace");
        this.marketplace = marketplace;
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

        public Builder setMarketplace(final MarketplaceAzure marketplace) {
            launchSpecification.setMarketplace(marketplace);
            return this;
        }
        public Builder setCustom(final List<CustomSpecAzure> custom) {
            launchSpecification.setCustom(custom);
            return this;
        }

        public ImageSpecAzure build() {
            // TODO : Validations
            return launchSpecification;
        }
    }
    //endregion

    //region isSet methods
    // Is marketplace Set boolean method
    @JsonIgnore
    public boolean isMarketplaceSet() {
        return isSet.contains("marketplace");
    }

    // Is custom Set boolean method
    @JsonIgnore
    public boolean isCustomSet() {
        return isSet.contains("custom");
    }
    //endregion
}
