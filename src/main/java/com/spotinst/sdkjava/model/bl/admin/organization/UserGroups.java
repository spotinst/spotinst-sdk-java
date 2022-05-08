package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroups {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         id;
    private String                         name;
    private String                         description;
    private String                         createdAt;
    private Integer                        usersCount;
    private List<String>                   policyNames;

    public UserGroups() {
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

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        isSet.add("usersCount");
        this.usersCount = usersCount;
    }

    public List<String> getPolicyNames() {
        return policyNames;
    }

    public void setPolicyNames(List<String> policyNames) {
        isSet.add("policyNames");
        this.policyNames = policyNames;
    }

    public static class Builder {
        private UserGroups groupDetails;

        private Builder() {
            this.groupDetails = new UserGroups();
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

        public Builder setUsersCount(final Integer usersCount) {
            groupDetails.setUsersCount(usersCount);
            return this;
        }

        public Builder setPolicyNames(final List<String > policies) {
            groupDetails.setPolicyNames(policies);
            return this;
        }

        public UserGroups build() {
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
    public boolean isUsersCountSet() {
        return isSet.contains("usersCount");
    }

    @JsonIgnore
    public boolean isPolicyNamesSet() {
        return isSet.contains("policyNames");
    }
}