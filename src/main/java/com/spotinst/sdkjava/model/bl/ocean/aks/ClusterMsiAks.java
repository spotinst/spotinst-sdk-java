package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterMsiAks {
    @JsonIgnore
    private Set<String>               isSet;
    private String                    name;
    private String                    resourceGroupName;


    private ClusterMsiAks() {
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

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    public static class Builder {

        private ClusterMsiAks clusterMsiAks;

        private Builder() {
            this.clusterMsiAks = new ClusterMsiAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            clusterMsiAks.setName(name);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            clusterMsiAks.setResourceGroupName(resourceGroupName);
            return this;
        }

        public ClusterMsiAks build() {
            return clusterMsiAks;
        }
    }
}
