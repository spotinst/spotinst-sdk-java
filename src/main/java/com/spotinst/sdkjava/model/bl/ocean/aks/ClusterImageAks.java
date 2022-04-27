package com.spotinst.sdkjava.model.bl.ocean.aks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
        return new Builder();
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
