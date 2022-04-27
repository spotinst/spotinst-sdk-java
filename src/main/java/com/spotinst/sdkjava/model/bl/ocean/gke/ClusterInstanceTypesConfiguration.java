package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterInstanceTypesConfiguration {
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> whitelist;

    private ClusterInstanceTypesConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(List<String> whitelist) {
        isSet.add("whitelist");
        this.whitelist = whitelist;
    }

    public static class Builder {
        private ClusterInstanceTypesConfiguration instanceTypes;

        private Builder() {
            this.instanceTypes = new ClusterInstanceTypesConfiguration();
        }


        public static Builder get() {
            return new Builder();
        }

        public ClusterInstanceTypesConfiguration.Builder setWhitelist(final List<String> whitelist) {
            instanceTypes.setWhitelist(whitelist);
            return this;
        }

        public ClusterInstanceTypesConfiguration build() {
            return instanceTypes;
        }
    }
    @JsonIgnore
    public boolean isWhitelistSet() {
        return isSet.contains("whitelist");
    }

}
