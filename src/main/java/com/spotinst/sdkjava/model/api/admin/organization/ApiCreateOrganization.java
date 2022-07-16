package com.spotinst.sdkjava.model.api.admin.organization;

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
public class ApiCreateOrganization implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                       isSet;
    private ApiOrganization                   organization;

    public ApiCreateOrganization() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(ApiOrganization organization) {
        isSet.add("organization");
        this.organization = organization;
    }

    @JsonIgnore
    public boolean isOrganizationSet() {
        return isSet.contains("organization");
    }
    
}