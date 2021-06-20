package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VolumeSpec {
    //region Members
    @JsonIgnore
    private Set<String>        isSet;
    private VolumeSpecNetwork  network;
    private VolumeSpecProtocol protocol;
    private String             serviceLevel;
    private List<VolumeTag>    tags;
    //endregion

    //region Constructor
    private VolumeSpec() {
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

    public VolumeSpecNetwork getNetwork() {
        return network;
    }

    public void setNetwork(VolumeSpecNetwork network) {
        isSet.add("network");
        this.network = network;
    }

    public VolumeSpecProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(VolumeSpecProtocol protocol) {
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

    public List<VolumeTag> getTags() {
        return tags;
    }

    public void setTags(List<VolumeTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }
    //end region

    //region Builder class
    public static class Builder {
        //region Members
        private VolumeSpec volumeSpec;
        //endregion


        private Builder() {
            this.volumeSpec = new VolumeSpec();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setNetwork(final VolumeSpecNetwork network) {
            volumeSpec.setNetwork(network);
            return this;
        }

        public Builder setProtocol(final VolumeSpecProtocol protocol) {
            volumeSpec.setProtocol(protocol);
            return this;
        }

        public Builder setServiceLevel(final String serviceLevel) {
            volumeSpec.setServiceLevel(serviceLevel);
            return this;
        }

        public Builder setTags(final List<VolumeTag> tags) {
            volumeSpec.setTags(tags);
            return this;
        }

        public VolumeSpec build() {
            // Validations
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
