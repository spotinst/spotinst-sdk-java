package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterMarketplaceAks {
    @JsonIgnore
    private Set<String>                          isSet;
    private String                               offer;
    private String                               publisher;
    private String                               sku;
    private String                               version;


    private ClusterMarketplaceAks() {

        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        isSet.add("offer");
        this.offer = offer;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        isSet.add("version");
        this.version = version;
    }

    @JsonIgnore
    public boolean isOfferSet() {
        return isSet.contains("offer");    }

    @JsonIgnore
    public boolean isPublisherSet() {
        return isSet.contains("publisher");
    }

    @JsonIgnore
    public boolean isSkuSet() {
        return isSet.contains("sku");
    }

    @JsonIgnore
    public boolean isVersioneSet() {
        return isSet.contains("version");    }

    public static class Builder {

        private ClusterMarketplaceAks clusterMarketplaceAks;
        private Builder() {
            this.clusterMarketplaceAks = new ClusterMarketplaceAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public Builder setOffer(final String offer) {
            clusterMarketplaceAks.setOffer(offer);
            return this;
        }
        public Builder setPublisher(final String publisher) {
            clusterMarketplaceAks.setPublisher(publisher);
            return this;
        }
        public Builder setSku(final String sku) {
            clusterMarketplaceAks.setSku(sku);
            return this;
        }
        public Builder setVersion(final String version) {
            clusterMarketplaceAks.setVersion(version);
            return this;
        }

        public ClusterMarketplaceAks build() {
            return clusterMarketplaceAks;
        }
    }
}