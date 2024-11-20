package com.spotinst.sdkjava.model.api.gcp;

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
public class ApiElastigroupBackendServiceConfigGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private List<ApiElastigroupBackendServicesGcp> backendServices;

    public ApiElastigroupBackendServiceConfigGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupBackendServicesGcp> getBackendServices() {
        return backendServices;
    }

    public void setBackendServices(List<ApiElastigroupBackendServicesGcp> backendServices) {
        isSet.add("backendServices");
        this.backendServices = backendServices;
    }

    @JsonIgnore
    public boolean isBackendServicesSet() { return isSet.contains("backendServices"); }
}
