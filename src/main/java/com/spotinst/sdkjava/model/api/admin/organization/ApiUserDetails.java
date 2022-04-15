package com.spotinst.sdkjava.model.api.admin.organization;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.admin.account.UserTypeEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiUserDetails implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     userId;
    private String                     username;
    private UserTypeEnum               type;
    private String                     email;
    private String                     mfa;
    private List<ApiUserDetailsPolicy> policies;
    private List<ApiUserDetailsTokens> tokens;
    private List<ApiUserDetailsGroups> groups;

    public ApiUserDetails() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        isSet.add("userId");
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        isSet.add("username");
        this.username = username;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        isSet.add("email");
        this.email = email;
    }

    public String getMfa() {
        return mfa;
    }

    public void setMfa(String mfa) {
        isSet.add("mfa");
        this.mfa = mfa;
    }

    public List<ApiUserDetailsPolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<ApiUserDetailsPolicy> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    public List<ApiUserDetailsTokens> getTokens() {
        return tokens;
    }

    public void setTokens(List<ApiUserDetailsTokens> tokens) {
        isSet.add("tokens");
        this.tokens = tokens;
    }

    public List<ApiUserDetailsGroups> getGroups() {
        return groups;
    }

    public void setGroups(List<ApiUserDetailsGroups> groups) {
        isSet.add("groups");
        this.groups = groups;
    }

    @JsonIgnore
    public boolean isUserIdSet() {
        return isSet.contains("userId");
    }

    @JsonIgnore
    public boolean isUserNameSet() {
        return isSet.contains("username");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    @JsonIgnore
    public boolean isMfaSet() {
        return isSet.contains("mfa");
    }

    @JsonIgnore
    public boolean isPoliciesSet() {
        return isSet.contains("policies");
    }

    @JsonIgnore
    public boolean isTokensSet() {
        return isSet.contains("tokens");
    }

    @JsonIgnore
    public boolean isEmailSet() {
        return isSet.contains("email");
    }

    @JsonIgnore
    public boolean isGroupsSet() {
        return isSet.contains("groups");
    }
}