package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceResponse {

    @JsonIgnore
    private Set<String>                     isSet;
    private String                          id;
    private String                          name;
    private String                          resourceGroupName;
    private StatefulNodeResourceNetwork     network;
    private StatefulNodeResourceStorage     storage;

    private StatefulNodeResourceResponse() {
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

    public StatefulNodeResourceStorage getStorage() {
        return storage;
    }

    public void setStorage(StatefulNodeResourceStorage storage) {
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

    public StatefulNodeResourceNetwork getNetwork() {
        return network;
    }

    public void setNetwork(StatefulNodeResourceNetwork network) {
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

    public static class Builder {

        private StatefulNodeResourceResponse getResource;

        private Builder() {
            this.getResource = new StatefulNodeResourceResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            getResource.setId(id);
            return this;
        }

        public Builder setName(final String name) {
            getResource.setName(name);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            getResource.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setNetwork(final StatefulNodeResourceNetwork network) {
            getResource.setNetwork(network);
            return this;
        }

        public Builder setStorage(final StatefulNodeResourceStorage storage) {
            getResource.setStorage(storage);
            return this;
        }

        public StatefulNodeResourceResponse build() {
            return getResource;
        }
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
