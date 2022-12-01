package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ImportEcsCluster {
    @JsonIgnore
    private Set<String>     isSet;
    private String          name;
    private String			region;

    private ImportEcsCluster() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public static class Builder {
        private ImportEcsCluster cluster;

        private Builder() {
            this.cluster = new ImportEcsCluster();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            cluster.setName(name);
            return this;
        }

        public Builder setRegion(final String region) {
            cluster.setRegion(region);
            return this;
        }

        public ImportEcsCluster build() {
            // Validations
            return cluster;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }
}