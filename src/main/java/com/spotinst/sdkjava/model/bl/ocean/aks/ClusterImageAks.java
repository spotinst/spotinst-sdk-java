package com.spotinst.sdkjava.model.bl.ocean.aks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

public class ClusterImageAks {
    @JsonIgnore
    private Set<String>                         isSet;
    private ClusterMarketplaceAks               marketplace;


    public ClusterImageAks() {
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
}
