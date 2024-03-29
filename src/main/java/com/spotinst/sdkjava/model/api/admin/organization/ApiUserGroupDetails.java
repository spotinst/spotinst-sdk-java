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
public class ApiUserGroupDetails implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                 isSet;
    private String                      id;
    private String                      name;
    private String                      description;
    private String                      createdAt;
    private List<ApiUserGroupDetailsUsers> users;
    private List<ApiUserGroupDetailsPolicies> policies;

    public ApiUserGroupDetails() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public List<ApiUserGroupDetailsUsers> getUsers() {
        return users;
    }

    public void setUsers(List<ApiUserGroupDetailsUsers> users) {
        isSet.add("users");
        this.users = users;
    }

    public List<ApiUserGroupDetailsPolicies> getPolicies() {
        return policies;
    }

    public void setPolicies(List<ApiUserGroupDetailsPolicies> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUsersSet() {
        return isSet.contains("users");
    }

    @JsonIgnore
    public boolean isPoliciesSet() {
        return isSet.contains("policies");
    }

}