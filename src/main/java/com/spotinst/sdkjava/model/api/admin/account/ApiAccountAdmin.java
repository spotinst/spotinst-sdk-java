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
public class ApiAccountAdmin implements IPartialUpdateEntity {

    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private String       accountId;
    private String       name;
    private String       organizationId;
    private String       cloudProvider;
    private String       providerExternalId;
    //endregion

    //region Constructor
    public ApiAccountAdmin() {
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

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        isSet.add("accountId");
        this.accountId = accountId;
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

    public String getCloudProvider() {
        return this.cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        isSet.add("cloudProvider");
        this.cloudProvider = cloudProvider;
    }

    public String getProviderExternalId() {
        return this.providerExternalId;
    }

    public void setProviderExternalId(String providerExternalId) {
        isSet.add("providerExternalId");
        this.providerExternalId = providerExternalId;
    }

    //endregion

    //region isSet methods

    // Is accountId Set boolean method
    @JsonIgnore
    public boolean isAccountIdSet() {
        return isSet.contains("accountId");
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

    // Is cloudProvider Set boolean method
    @JsonIgnore
    public boolean isCloudProviderSet() {
        return isSet.contains("cloudProvider");
    }
    //endregion

    // Is providerExternalId Set boolean method
    @JsonIgnore
    public boolean isProviderExternalIdSet() {
        return isSet.contains("providerExternalId");
    }
    //endregion

}
