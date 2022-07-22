package com.spotinst.sdkjava.model.api.admin.account;

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
public class ApiAccount implements IPartialUpdateEntity {

    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private String       id;
    private String       name;
    private String       organizationId;
    //endregion

    //region Constructor
    public ApiAccount() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String accountId) {
        isSet.add("id");
        this.id = accountId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId) {
        isSet.add("organizationId");
        this.organizationId = organizationId;
    }
    //endregion

    //region isSet methods

    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is organizationId Set boolean method
    @JsonIgnore
    public boolean isOrganizationIdSet() {
        return isSet.contains("organizationId");
    }
    //endregion
}
