package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VirtualServicesTlsRoutes {
    @JsonIgnore
    private Set<String>                               isSet;
    private Integer                                   port;
    private List<String>                              sniHosts;

    private VirtualServicesTlsRoutes() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        isSet.add("port");
        this.port = port;
    }

    public List<String> getSniHosts() {
        return sniHosts;
    }

    public void setSniHosts(List<String> sniHosts) {
        isSet.add("sniHosts");
        this.sniHosts = sniHosts;
    }

    public static class Builder {
        private VirtualServicesTlsRoutes virtualServicesTlsRoutes;

        private Builder() {
            this.virtualServicesTlsRoutes = new VirtualServicesTlsRoutes();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setSniHosts(final List<String> sniHosts) {
            virtualServicesTlsRoutes.setSniHosts(sniHosts);
            return this;
        }

        public Builder setPort(final Integer port) {
            virtualServicesTlsRoutes.setPort(port);
            return this;
        }

        public VirtualServicesTlsRoutes build() {
            return virtualServicesTlsRoutes;
        }
    }

    @JsonIgnore
    public boolean isPortSet() {
        return isSet.contains("port");
    }

    @JsonIgnore
    public boolean isSniHostsSet() {
        return isSet.contains("sniHosts");
    }
}