package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecMarketplaceConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private String      publisher;
    private String      offer;
    private String      sku;
    private String      version;

    public LaunchSpecMarketplaceConfiguration() {
        isSet = new HashSet<>();
    }

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

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        isSet.add("offer");
        this.offer = offer;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        isSet.add("sku");
        this.sku = sku;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        isSet.add("version");
        this.version = version;
    }

    public static class Builder {
        private LaunchSpecMarketplaceConfiguration marketplaceConfiguration;

        private Builder() {
            this.marketplaceConfiguration = new LaunchSpecMarketplaceConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPublisher(final String publisher) {
            marketplaceConfiguration.setPublisher(publisher);
            return this;
        }

        public Builder setOffer(final String offer) {
            marketplaceConfiguration.setOffer(offer);
            return this;
        }

        public Builder setSku(final String sku) {
            marketplaceConfiguration.setSku(sku);
            return this;
        }

        public Builder setVersion(final String version) {
            marketplaceConfiguration.setVersion(version);
            return this;
        }

        public LaunchSpecMarketplaceConfiguration build() {
            return marketplaceConfiguration;
        }
    }

    @JsonIgnore
    public boolean isPublisherSet() {
        return isSet.contains("publisher");
    }

    @JsonIgnore
    public boolean isOfferSet() {
        return isSet.contains("offer");
    }

    @JsonIgnore
    public boolean isSkuSet() {
        return isSet.contains("sku");
    }

    @JsonIgnore
    public boolean isVersionSet() {
        return isSet.contains("version");
    }

}
