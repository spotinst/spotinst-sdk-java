package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterSecurityGroupAks {
    @JsonIgnore
    private Set<String>             isSet;
    private String                  name;
    private String                  resourceGroupName;


    private ClusterSecurityGroupAks() {
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

        private ClusterSecurityGroupAks clusterSecurityGroupAks;
        private Builder() {
            this.clusterSecurityGroupAks = new ClusterSecurityGroupAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public Builder setName(final String name) {
            clusterSecurityGroupAks.setName(name);
            return this;
        }
        public Builder setResourceGroupName(final String resourceGroupName) {
            clusterSecurityGroupAks.setResourceGroupName(resourceGroupName);
            return this;
        }

        public ClusterSecurityGroupAks build() {
            return clusterSecurityGroupAks;
        }
    }
}
