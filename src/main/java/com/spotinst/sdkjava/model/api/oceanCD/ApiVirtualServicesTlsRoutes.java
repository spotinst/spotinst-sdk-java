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
public class ApiVirtualServicesTlsRoutes implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private Integer                                   port;
    private List<String>                              sniHosts;

    public ApiVirtualServicesTlsRoutes() {
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

    @JsonIgnore
    public boolean isPortSet() {
        return isSet.contains("port");
    }

    @JsonIgnore
    public boolean isSniHostsSet() {
        return isSet.contains("sniHosts");
    }
}