package com.spotinst.sdkjava.model.api.azure.statefulNode;

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
public class ApiStatefulNodeResourceResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                     isSet;
    private String                          id;
    private String                          name;
    private String                          resourceGroupName;
    private ApiStatefulNodeResourceNetwork  network;
    private ApiStatefulNodeResourceStorage  storage;

    public ApiStatefulNodeResourceResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public ApiStatefulNodeResourceStorage getStorage() {
        return storage;
    }

    public void setStorage(ApiStatefulNodeResourceStorage storage) {
        isSet.add("storage");
        this.storage = storage;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public ApiStatefulNodeResourceNetwork getNetwork() {
        return network;
    }

    public void setNetwork(ApiStatefulNodeResourceNetwork network) {
        isSet.add("network");
        this.network = network;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
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
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    @JsonIgnore
    public boolean isStorageSet() {
        return isSet.contains("storage");
    }
}
