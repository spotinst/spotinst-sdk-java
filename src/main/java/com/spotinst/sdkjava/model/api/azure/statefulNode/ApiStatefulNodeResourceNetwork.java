package com.spotinst.sdkjava.model.api.azure.statefulNode;

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
public class ApiStatefulNodeResourceNetwork implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private ApiStatefulNodeResourceVirtualNetwork virtualNetwork;
    private List<ApiStatefulNodeResourceNetworkInterfaces> networkInterfaces;

    public ApiStatefulNodeResourceNetwork() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiStatefulNodeResourceVirtualNetwork getVirtualNetwork() {
        return virtualNetwork;
    }

    public void setVirtualNetwork(ApiStatefulNodeResourceVirtualNetwork virtualNetwork) {
        isSet.add("virtualNetwork");
        this.virtualNetwork = virtualNetwork;
    }

    public List<ApiStatefulNodeResourceNetworkInterfaces> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiStatefulNodeResourceNetworkInterfaces> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
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
