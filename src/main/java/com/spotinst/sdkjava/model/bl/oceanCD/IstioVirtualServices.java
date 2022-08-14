package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IstioVirtualServices {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private List<String>                              routes;
    private List<VirtualServicesTlsRoutes>            tlsRoutes;

    private IstioVirtualServices() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public List<String> getRoutes() {
        return routes;
    }

    public void setRoutes(List<String> routes) {
        isSet.add("routes");
        this.routes = routes;
    }

    public List<VirtualServicesTlsRoutes> getTlsRoutes() {
        return tlsRoutes;
    }

    public void setTlsRoutes(List<VirtualServicesTlsRoutes> tlsRoutes) {
        isSet.add("tlsRoutes");
        this.tlsRoutes = tlsRoutes;
    }

    public static class Builder {
        private IstioVirtualServices istioVirtualServices;

        private Builder() {
            this.istioVirtualServices = new IstioVirtualServices();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setRoutes(final List<String> routes) {
            istioVirtualServices.setRoutes(routes);
            return this;
        }

        public Builder setName(final String name) {
            istioVirtualServices.setName(name);
            return this;
        }

        public Builder setTlsRoutes(final List<VirtualServicesTlsRoutes> tlsRoutes) {
            istioVirtualServices.setTlsRoutes(tlsRoutes);
            return this;
        }

        public IstioVirtualServices build() {
            return istioVirtualServices;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isRoutesSet() {
        return isSet.contains("routes");
    }

    @JsonIgnore
    public boolean isTlsRoutesSet() {
        return isSet.contains("tlsRoutes");
    }
}