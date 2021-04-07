package com.spotinst.sdkjava.model.bl.ocean.aks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

public class ClusterImageAks {
    @JsonIgnore
    private Set<String>                         isSet;
    private ClusterMarketplaceAks               marketplace;


    private ClusterImageAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ClusterMarketplaceAks getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(ClusterMarketplaceAks marketplace) {
        isSet.add("marketplace");
        this.marketplace = marketplace;
    }

    @JsonIgnore
    public boolean isMarketplaceSet() {
        return isSet.contains("marketplace");
    }

    public static class Builder {

        private ClusterImageAks clusterImageAks;
        private Builder() {
            this.clusterImageAks = new ClusterImageAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setMarketplace(final ClusterMarketplaceAks marketplace) {
            clusterImageAks.setMarketplace(marketplace);
            return this;
        }

        public ClusterImageAks build() {
            return clusterImageAks;
        }
    }

}
