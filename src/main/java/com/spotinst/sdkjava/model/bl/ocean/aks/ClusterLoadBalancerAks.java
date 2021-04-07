package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterLoadBalancerAks {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<String>                        backendPoolNames;
    private String                              loadBalancerSku;
    private String                              name;
    private String                              resourceGroupName;
    private String                              type;


    private ClusterLoadBalancerAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getBackendPoolNames() {
        return backendPoolNames;
    }

    public void setBackendPoolNames(List<String> backendPoolNames) {
        isSet.add("backendPoolNames");
        this.backendPoolNames = backendPoolNames;
    }

    public String getLoadBalancerSku() {
        return loadBalancerSku;
    }

    public void setLoadBalancerSku(String loadBalancerSku) {
        isSet.add("resourceGroupName");
        // Verify default val
        this.loadBalancerSku = loadBalancerSku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    @JsonIgnore
    public boolean isBackendPoolNamesSet() {
        return isSet.contains("backendPoolNames");
    }

    @JsonIgnore
    public boolean isLoadBalancerSkuSet() {
        return isSet.contains("loadBalancerSku");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    public static class Builder {

        private ClusterLoadBalancerAks clusterLoadBalancerAks;

        private Builder() {
            this.clusterLoadBalancerAks = new ClusterLoadBalancerAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public Builder setBackendPoolNames(final List<String> backendPoolNames) {
            clusterLoadBalancerAks.setBackendPoolNames(backendPoolNames);
            return this;
        }
        public Builder setLoadBalancerSku(final String loadBalancerSku) {
            clusterLoadBalancerAks.setLoadBalancerSku(loadBalancerSku);
            return this;
        }
        public Builder setName(final String name) {
            clusterLoadBalancerAks.setName(name);
            return this;
        }
        public Builder setResourceGroupName(final String resourceGroupName) {
            clusterLoadBalancerAks.setResourceGroupName(resourceGroupName);
            return this;
        }
        public Builder setType(final String type) {
            clusterLoadBalancerAks.setType(type);
            return this;
        }

        public ClusterLoadBalancerAks build() {
            return clusterLoadBalancerAks;
        }
    }


}

