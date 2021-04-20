package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterAdditionalIpConfigurationsAks {
    @JsonIgnore
    private Set<String>               isSet;
    private String                    name;



    public ClusterAdditionalIpConfigurationsAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    public static class Builder {

        private ClusterAdditionalIpConfigurationsAks additionalIpConfigurationsAks;

        private Builder() {
            this.additionalIpConfigurationsAks = new ClusterAdditionalIpConfigurationsAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            additionalIpConfigurationsAks.setName(name);
            return this;
        }

        public ClusterAdditionalIpConfigurationsAks build() {
            return additionalIpConfigurationsAks;
        }
    }
}
