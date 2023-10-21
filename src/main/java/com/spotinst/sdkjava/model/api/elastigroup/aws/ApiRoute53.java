package com.spotinst.sdkjava.model.api.elastigroup.aws;

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
public class ApiRoute53 implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private List<ApiRoute53Domains> domains;
    //endregion

    //region Constructor

    public ApiRoute53() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public List<ApiRoute53Domains> getDomains() {
        return domains;
    }

    public void setDomains(List<ApiRoute53Domains> domains) {
        isSet.add("domains");
        this.domains = domains;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region isSet methods
    // Is domains Set boolean method
    @JsonIgnore
    public boolean isDomainsSet() {
        return isSet.contains("domains");
    }
    //endregion
}
