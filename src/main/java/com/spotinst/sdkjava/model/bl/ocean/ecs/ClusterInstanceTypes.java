package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterInstanceTypes {
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> whitelist;
    private List<String> blacklist;

    private ClusterInstanceTypes() {
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

    public List<String> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(List<String> blacklist) {
        isSet.add("blacklist");
        this.blacklist = blacklist;
    }

    public static class Builder {
        private ClusterInstanceTypes instanceTypes;

        private Builder() {
            this.instanceTypes = new ClusterInstanceTypes();
        }

        public static ClusterInstanceTypes.Builder get() {
            ClusterInstanceTypes.Builder builder = new ClusterInstanceTypes.Builder();
            return builder;
        }

        public ClusterInstanceTypes.Builder setWhitelist(final List<String> whitelist) {
            instanceTypes.setWhitelist(whitelist);
            return this;
        }

        public ClusterInstanceTypes.Builder setBlacklist(final List<String> blacklist) {
            instanceTypes.setBlacklist(blacklist);
            return this;
        }

        public ClusterInstanceTypes build() {
            return instanceTypes;
        }
    }
    @JsonIgnore
    public boolean isWhitelistSet() {
        return isSet.contains("whitelist");
    }

    @JsonIgnore
    public boolean isBlacklistSet() {
        return isSet.contains("blacklist");
    }
}
