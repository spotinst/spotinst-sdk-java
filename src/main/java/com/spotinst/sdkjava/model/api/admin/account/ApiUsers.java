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
public class ApiUsers implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         displayName;
    private String                         email;
    private String                         mappedAccountIds;
    private String                         userId;
    //endregion

    //region Constructor
    private ApiUsers() {
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        isSet.add("displayName");
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        isSet.add("email");
        this.email = email;
    }

    public String getMappedAccountIds() {
        return mappedAccountIds;
    }

    public void setMappedAccountIds(String mappedAccountIds) {
        isSet.add("mappedAccountIds");
        this.mappedAccountIds = mappedAccountIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        isSet.add("userId");
        this.userId = userId;
    }

    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isDisplayNameSet() {
        return isSet.contains("displayName");
    }

    @JsonIgnore
    public boolean isEmailSet() {
        return isSet.contains("email");
    }

    @JsonIgnore
    public boolean isMappedAccountIdsSet() {
        return isSet.contains("mappedAccountIds");
    }

    @JsonIgnore
    public boolean isUserIdSet() {
        return isSet.contains("userId");
    }

    //endregion
}
