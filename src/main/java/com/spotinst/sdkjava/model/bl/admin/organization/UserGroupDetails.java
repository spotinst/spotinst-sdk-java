package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupDetails {
    @JsonIgnore
    private Set<String>                 isSet;
    private String                      id;
    private String                      name;
    private String                      description;
    private String                      createdAt;
    private List<UserGroupDetailsUsers> users;
    private List<UserGroupDetailsPolicies> policies;

    public UserGroupDetails() {
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

    public List<UserGroupDetailsUsers> getUsers() {
        return users;
    }

    public void setUsers(List<UserGroupDetailsUsers> users) {
        isSet.add("users");
        this.users = users;
    }

    public List<UserGroupDetailsPolicies> getPolicies() {
        return policies;
    }

    public void setPolicies(List<UserGroupDetailsPolicies> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    public static class Builder {
        private UserGroupDetails groupDetails;

        private Builder() {
            this.groupDetails = new UserGroupDetails();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            groupDetails.setId(id);
            return this;
        }

        public Builder setName(final String name) {
            groupDetails.setName(name);
            return this;
        }

        public Builder setDescription(final String description) {
            groupDetails.setDescription(description);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            groupDetails.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUsers(final List<UserGroupDetailsUsers> users) {
            groupDetails.setUsers(users);
            return this;
        }

        public Builder setPolicies(final List<UserGroupDetailsPolicies> policies) {
            groupDetails.setPolicies(policies);
            return this;
        }

        public UserGroupDetails build() {
            return groupDetails;
        }
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