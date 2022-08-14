package com.spotinst.sdkjava.model.api.oceanCD;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiIstioVirtualServices implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private List<String>                              routes;
    private List<ApiVirtualServicesTlsRoutes>         tlsRoutes;

    public ApiIstioVirtualServices() {
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

    public List<ApiVirtualServicesTlsRoutes> getTlsRoutes() {
        return tlsRoutes;
    }

    public void setTlsRoutes(List<ApiVirtualServicesTlsRoutes> tlsRoutes) {
        isSet.add("tlsRoutes");
        this.tlsRoutes = tlsRoutes;
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