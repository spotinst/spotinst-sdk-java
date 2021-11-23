package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecImageConfiguration {
    @JsonIgnore
    private Set<String>                        isSet;
    private LaunchSpecMarketplaceConfiguration marketplace;


    public LaunchSpecImageConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public LaunchSpecMarketplaceConfiguration getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(LaunchSpecMarketplaceConfiguration marketplace) {
        isSet.add("marketplace");
        this.marketplace = marketplace;
    }

    public static class Builder {
        private LaunchSpecImageConfiguration imageConfiguration;

        private Builder() {
            this.imageConfiguration = new LaunchSpecImageConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setMarketplace(final LaunchSpecMarketplaceConfiguration marketplace) {
            imageConfiguration.setMarketplace(marketplace);
            return this;
        }

        public LaunchSpecImageConfiguration build() {
            return imageConfiguration;
        }
    }

    @JsonIgnore
    public boolean isMarketplaceSet() {
        return isSet.contains("marketplace");
    }

}
