package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MarketplaceAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String      publisher;
    private String      offer;
    private String      sku;
    private String      version;

    //endregion

    //region Constructors
    private MarketplaceAzure() {
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        isSet.add("publisher");
        this.publisher = publisher;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        isSet.add("sku");
        this.sku = sku;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        isSet.add("offer");
        this.offer = offer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        isSet.add("version");
        this.version = version;
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
        MarketplaceAzure that = (MarketplaceAzure) o;
        return Objects.equals(publisher, that.publisher) && Objects.equals(offer, that.offer) &&
               Objects.equals(sku, that.sku) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisher, offer, sku, version);
    }
    //endregion

    //region Builder class
    public static class Builder {
        private MarketplaceAzure loginAzure;

        private Builder() {
            this.loginAzure = new MarketplaceAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPublisher(final String publisher) {
            loginAzure.setPublisher(publisher);
            return this;
        }

        public Builder setOffer(final String offer) {
            loginAzure.setOffer(offer);
            return this;
        }

        public Builder setSku(final String sku) {
            loginAzure.setSku(sku);
            return this;
        }

        public Builder setVersion(final String version) {
            loginAzure.setVersion(version);
            return this;
        }

        public MarketplaceAzure build() {
            // TODO : Validations
            return loginAzure;
        }
    }
    //endregion

    //region isSet methods
    // Is publisher Set boolean method
    @JsonIgnore
    public boolean isPublisherSet() {
        return isSet.contains("publisher");
    }

    // Is sku Set boolean method
    @JsonIgnore
    public boolean isSkuSet() {
        return isSet.contains("sku");
    }

    // Is offer Set boolean method
    @JsonIgnore
    public boolean isOfferSet() {
        return isSet.contains("offer");
    }

    // Is version Set boolean method
    @JsonIgnore
    public boolean isVersionSet() {
        return isSet.contains("version");
    }

    //endregion
}
