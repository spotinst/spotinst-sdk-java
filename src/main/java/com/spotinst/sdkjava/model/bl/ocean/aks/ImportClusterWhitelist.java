package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImportClusterWhitelist {

    @JsonIgnore
    private Set<String>  isSet;
    private List<String> whitelist;

    private ImportClusterWhitelist() {
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
        private ImportClusterWhitelist clusterWhitelist;

        private Builder() {
            this.clusterWhitelist = new ImportClusterWhitelist();
        }

        public static ImportClusterWhitelist.Builder get() {
            return new Builder();
        }

        public Builder setWhitelist(final List<String> whitelist) {
            clusterWhitelist.setWhitelist(whitelist);
            return this;
        }

        public ImportClusterWhitelist build() {
            return clusterWhitelist;
        }
    }

    @JsonIgnore
    public boolean isWhitelistSet() {
        return isSet.contains("whitelist");
    }

}
