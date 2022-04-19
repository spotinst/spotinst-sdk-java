package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroup {
    @JsonIgnore
    private Set<String>                   isSet;
    private String                        id;
    private String                        name;
    private String                        description;
    private List<String>                  userIds;
    private List<PolicyMapping>           policies;

    public UserGroup() {
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

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        isSet.add("userIds");
        this.userIds = userIds;
    }

    public List<PolicyMapping> getPolicies() {
        return policies;
    }

    public void setPolicies(List<PolicyMapping> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    public static class Builder {
        private UserGroup userGroup;

        private Builder() {
            this.userGroup = new UserGroup();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            userGroup.setId(id);
            return this;
        }

        public Builder setName(final String name) {
            userGroup.setName(name);
            return this;
        }

        public Builder setDescription(final String description) {
            userGroup.setDescription(description);
            return this;
        }

        public Builder setUserIds(final List<String> userIds) {
            userGroup.setUserIds(userIds);
            return this;
        }

        public Builder setPolicies(final List<PolicyMapping> policies) {
            userGroup.setPolicies(policies);
            return this;
        }

        public UserGroup build() {
            return userGroup;
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
    public boolean isUserIdsSet() {
        return isSet.contains("userIds");
    }

    @JsonIgnore
    public boolean isPoliciesSet() {
        return isSet.contains("policies");
    }
}