package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiImportClusterHeadroomSpecification implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private ApiImportClusterHeadroomAutomatic automatic;

    public ApiImportClusterHeadroomSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiImportClusterHeadroomAutomatic getAutomatic() {
        return automatic;
    }

    public void setAutomatic(ApiImportClusterHeadroomAutomatic automatic) {
        isSet.add("automatic");
        this.automatic = automatic;
    }

    @JsonIgnore
    public boolean isAutomaticSet() {
        return isSet.contains("automatic");
    }

}
