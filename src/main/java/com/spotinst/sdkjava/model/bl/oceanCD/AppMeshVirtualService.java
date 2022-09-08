package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppMeshVirtualService {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private List<String>                              routes;

    private AppMeshVirtualService() {
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

    public static class Builder {
        private AppMeshVirtualService appMeshVirtualServices;

        private Builder() {
            this.appMeshVirtualServices = new AppMeshVirtualService();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setRoutes(final List<String> routes) {
            appMeshVirtualServices.setRoutes(routes);
            return this;
        }

        public Builder setName(final String name) {
            appMeshVirtualServices.setName(name);
            return this;
        }

        public AppMeshVirtualService build() {
            return appMeshVirtualServices;
        }
    }

    @JsonIgnore
    public boolean isRoutesSet() {
        return isSet.contains("routes");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
}