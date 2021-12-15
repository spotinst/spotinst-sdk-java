package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLoadBalancerAzure implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet = new HashSet<>();
    private String      type;
    private String      resourceGroupName;
    private String      name;
    private String[]      backendPoolNames;
    private String      sku;
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String[] getBackendPoolNames() {
        return backendPoolNames;
    }

    public void setBackendPoolNames(String[] backendPoolNames) {
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
    //endregion


    //region is Set methods
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isBackendPoolNamesSet() {
        return isSet.contains("backendPoolNames");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
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
