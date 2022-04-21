package com.spotinst.sdkjava.model.api.admin.organization;

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
public class ApiProgrammaticUserResponse implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                       isSet;
    private String                            id;
    private String                            userName;
    private String                            description;
    private List<ApiProgrammaticUserAccounts> accounts;

    public ApiProgrammaticUserResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        isSet.add("userName");
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public List<ApiProgrammaticUserAccounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<ApiProgrammaticUserAccounts> accounts) {
        isSet.add("accounts");
        this.accounts = accounts;
    }
    @JsonIgnore
    public boolean isUserNameSet() {
        return isSet.contains("userName");
    }

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isAccountsSet() {
        return isSet.contains("accounts");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }
}