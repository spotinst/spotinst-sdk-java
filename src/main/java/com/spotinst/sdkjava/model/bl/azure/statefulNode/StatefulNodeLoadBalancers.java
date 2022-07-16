package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodeLoadBalancerTypeEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeLoadBalancers {

    @JsonIgnore
    private Set<String>                             isSet;
    private List<String>                            backendPoolNames;
    private String                                  loadBalancerSku;
    private String                                  name;
    private String                                  resourceGroupName;
    private AzureStatefulNodeLoadBalancerTypeEnum   type;

    private StatefulNodeLoadBalancers() {
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
        isSet.add("loadBalancerSku");
        this.loadBalancerSku = loadBalancerSku;
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

    public AzureStatefulNodeLoadBalancerTypeEnum getType() {
        return type;
    }

    public void setType(AzureStatefulNodeLoadBalancerTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {
        private StatefulNodeLoadBalancers statefulNodeLoadbalancers;

        private Builder() {
            this.statefulNodeLoadbalancers = new StatefulNodeLoadBalancers();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBackendPoolNames(final List<String> backendPoolNames) {
            statefulNodeLoadbalancers.setBackendPoolNames(backendPoolNames);
            return this;
        }

        public Builder setLoadBalancerSku(final String loadBalancerSku) {
            statefulNodeLoadbalancers.setLoadBalancerSku(loadBalancerSku);
            return this;
        }
        public Builder setName(final String name) {
            statefulNodeLoadbalancers.setName(name);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            statefulNodeLoadbalancers.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setType(final AzureStatefulNodeLoadBalancerTypeEnum type) {
            statefulNodeLoadbalancers.setType(type);
            return this;
        }


        public StatefulNodeLoadBalancers build() {
            return statefulNodeLoadbalancers;
        }
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
}
