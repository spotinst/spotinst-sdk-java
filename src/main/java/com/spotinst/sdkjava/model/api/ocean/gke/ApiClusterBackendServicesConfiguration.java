package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiClusterBackendServicesConfiguration implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String      backendServiceName;
    private String      locationType;

    public ApiClusterBackendServicesConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getBackendServiceName() {
        return backendServiceName;
    }

    public void setBackendServiceName(String backendServiceName) {
        isSet.add("backendServiceName");
        this.backendServiceName = backendServiceName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        isSet.add("locationType");
        this.locationType = locationType;
    }

    @JsonIgnore
    public boolean isBackendServiceNameSet() {
        return isSet.contains("backendServiceName");
    }

    @JsonIgnore
    public boolean isLocationTypeSet() { return isSet.contains("locationType"); }

}

