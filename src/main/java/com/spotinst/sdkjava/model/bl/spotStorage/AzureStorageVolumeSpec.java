package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AzureStorageVolumeSpec {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private AzureStorageVolumeSpecNetwork  network;
    private AzureStorageVolumeSpecProtocol protocol;
    private String                         serviceLevel;
    private List<AzureStorageVolumeTag>    tags;
    //endregion

    //region Constructor
    private AzureStorageVolumeSpec() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters &setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public AzureStorageVolumeSpecNetwork getNetwork() {
        return network;
    }

    public void setNetwork(AzureStorageVolumeSpecNetwork network) {
        isSet.add("network");
        this.network = network;
    }

    public AzureStorageVolumeSpecProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(AzureStorageVolumeSpecProtocol protocol) {
        isSet.add("protocol");
        this.protocol = protocol;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        isSet.add("serviceLevel");
        this.serviceLevel = serviceLevel;
    }

    public List<AzureStorageVolumeTag> getTags() {
        return tags;
    }

    public void setTags(List<AzureStorageVolumeTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }
    //end region

    //region Builder class
    public static class Builder {
        //region Members
        private AzureStorageVolumeSpec volumeSpec;
        //endregion


        private Builder() {
            this.volumeSpec = new AzureStorageVolumeSpec();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setNetwork(final AzureStorageVolumeSpecNetwork network) {
            volumeSpec.setNetwork(network);
            return this;
        }

        public Builder setProtocol(final AzureStorageVolumeSpecProtocol protocol) {
            volumeSpec.setProtocol(protocol);
            return this;
        }

        public Builder setServiceLevel(final String serviceLevel) {
            volumeSpec.setServiceLevel(serviceLevel);
            return this;
        }

        public Builder setTags(final List<AzureStorageVolumeTag> tags) {
            volumeSpec.setTags(tags);
            return this;
        }

        public AzureStorageVolumeSpec build() {
            return volumeSpec;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is network Set boolean method
    @JsonIgnore
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    // Is protocol Set boolean method
    @JsonIgnore
    public boolean isProtocolSet() {
        return isSet.contains("protocol");
    }

    // Is serviceLevel Set boolean method
    @JsonIgnore
    public boolean isServiceLevelSet() {
        return isSet.contains("serviceLevel");
    }

    // Is tags Set boolean method
    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }
    //endregion
}
