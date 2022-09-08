package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceVirtualNetwork {

    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      name;

    private StatefulNodeResourceVirtualNetwork() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public static class Builder {

        private StatefulNodeResourceVirtualNetwork virtualNetwork;

        private Builder() {
            this.virtualNetwork = new StatefulNodeResourceVirtualNetwork();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            virtualNetwork.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setName(final String name) {
            virtualNetwork.setName(name);
            return this;
        }

        public StatefulNodeResourceVirtualNetwork build() {
            return virtualNetwork;
        }
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
}
