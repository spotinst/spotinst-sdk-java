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
public class ApiTrafficIstio implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private List<ApiIstioVirtualService>             virtualServices;
    private ApiIstioDestinationRule                   destinationRule;

    public ApiTrafficIstio() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiIstioVirtualService> getVirtualServices() {
        return virtualServices;
    }

    public void setVirtualServices(List<ApiIstioVirtualService> virtualServices) {
        isSet.add("virtualServices");
        this.virtualServices = virtualServices;
    }

    public ApiIstioDestinationRule getDestinationRule() {
        return destinationRule;
    }

    public void setDestinationRule(ApiIstioDestinationRule destinationRule) {
        isSet.add("destinationRule");
        this.destinationRule = destinationRule;
    }

    @JsonIgnore
    public boolean isVirtualServicesSet() {
        return isSet.contains("virtualServices");
    }

    @JsonIgnore
    public boolean isDestinationRuleSet() {
        return isSet.contains("destinationRule");
    }
}