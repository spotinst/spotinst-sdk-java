package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yossi.elman on 12/03/20.
 */
public class LoadBalancerAzure {
    // region Members
    @JsonIgnore
    private Set<String> isSet = new HashSet<>();
    private String      type;
    private String      resourceGroupName;
    private String      name;
    private String      backendPoolNames;
    private String      sku;
    //endregion

    //region Getters & Setters

    @JsonIgnore


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

    public String getBackendPoolNames() {
        return backendPoolNames;
    }

    public void setBackendPoolNames(String backendPoolNames) {
        isSet.add("backendPoolNames");
        this.backendPoolNames = backendPoolNames;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        isSet.add("sku");
        this.sku = sku;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private LoadBalancerAzure loadBalancer;

        private Builder() {
            this.loadBalancer = new LoadBalancerAzure();
        }

        public static LoadBalancerAzure.Builder get() {
            LoadBalancerAzure.Builder builder = new LoadBalancerAzure.Builder();
            return builder;
        }

        public LoadBalancerAzure.Builder setName(final String name) {
            loadBalancer.setName(name);
            return this;
        }

        public LoadBalancerAzure.Builder setBackendPoolNames(final String backendPoolNames) {
            loadBalancer.setBackendPoolNames(backendPoolNames);
            return this;
        }

        public LoadBalancerAzure.Builder setResourceGroupName(final String resourceGroupName) {
            loadBalancer.setResourceGroupName(resourceGroupName);
            return this;
        }

        public LoadBalancerAzure.Builder setSku(final String sku) {
            loadBalancer.setSku(sku);
            return this;
        }

        public LoadBalancerAzure.Builder setType(final String type) {
            loadBalancer.setType(type);
            return this;
        }

        public LoadBalancerAzure build() {
            // TODO : Validations
            return loadBalancer;
        }
    }
    //endregion

    //region isSet Methods
    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    public boolean isBackendPoolNamesSet() {
        return isSet.contains("backendPoolNames");
    }

    @JsonIgnore
    public boolean isSkuSet() {
        return isSet.contains("sku");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }
    //endregion
}
