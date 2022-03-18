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
public class ApiUser implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      firstName;
    private String      lastName;
    private String      email;
    private String      password;
    private Integer     id;
    private String      organizationId;
    private String      userId;

    public ApiUser() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        isSet.add("firstName");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        isSet.add("lastName");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        isSet.add("email");
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        isSet.add("password");
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        isSet.add("id");
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        isSet.add("organizationId");
        this.organizationId = organizationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        isSet.add("userId");
        this.userId = userId;
    }

    @JsonIgnore
    public boolean isFirstNameSet() {
        return isSet.contains("firstName");
    }

    @JsonIgnore
    public boolean isLastNameSet() {
        return isSet.contains("lastName");
    }

    @JsonIgnore
    public boolean isEmailSet() {
        return isSet.contains("email");
    }

    @JsonIgnore
    public boolean isPasswordSet() {
        return isSet.contains("password");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isOrganizationIdSet() {
        return isSet.contains("organizationId");
    }

    @JsonIgnore
    public boolean isUserIdSet() {
        return isSet.contains("userId");
    }
}