package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceNetwork {

    @JsonIgnore
    private Set<String>                                 isSet;
    private StatefulNodeResourceVirtualNetwork          virtualNetwork;
    private List<StatefulNodeResourceNetworkInterfaces> networkInterfaces;

    private StatefulNodeResourceNetwork() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public StatefulNodeResourceVirtualNetwork getVirtualNetwork() {
        return virtualNetwork;
    }

    public void setVirtualNetwork(StatefulNodeResourceVirtualNetwork virtualNetwork) {
        isSet.add("virtualNetwork");
        this.virtualNetwork = virtualNetwork;
    }

    public List<StatefulNodeResourceNetworkInterfaces> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<StatefulNodeResourceNetworkInterfaces> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public static class Builder {

        private StatefulNodeResourceNetwork network;

        private Builder() {
            this.network = new StatefulNodeResourceNetwork();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setVirtualNetwork(final StatefulNodeResourceVirtualNetwork virtualNetwork) {
            network.setVirtualNetwork(virtualNetwork);
            return this;
        }

        public Builder setNetworkInterfaces(final List<StatefulNodeResourceNetworkInterfaces> networkInterfaces) {
            network.setNetworkInterfaces(networkInterfaces);
            return this;
        }

        public StatefulNodeResourceNetwork build() {
            return network;
        }
    }

    @JsonIgnore
    public boolean isVirtualNetworkSet() {
        return isSet.contains("virtualNetwork");
    }

    @JsonIgnore
    public boolean isNetworkInterfacesSet() {
        return isSet.contains("networkInterfaces");
    }
}
