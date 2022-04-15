package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.admin.account.UserTypeEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationUsers {
    @JsonIgnore
    private Set<String>  isSet;
    private String       userId;
    private String       username;
    private UserTypeEnum type;
    private String       email;
    private String       mfa;
    private List<String> groupNames;

    public OrganizationUsers() {
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

    public List<String> getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(List<String> groupNames) {
        isSet.add("groupNames");
        this.groupNames = groupNames;
    }

    public static class Builder {
        private OrganizationUsers organizationUsers;

        private Builder() {
            this.organizationUsers = new OrganizationUsers();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setUserId(final String userId) {
            organizationUsers.setUserId(userId);
            return this;
        }

        public Builder setUserName(final String userName) {
            organizationUsers.setUsername(userName);
            return this;
        }

        public Builder setType(final UserTypeEnum type) {
            organizationUsers.setType(type);
            return this;
        }

        public Builder setEmail(final String email) {
            organizationUsers.setEmail(email);
            return this;
        }

        public Builder setMfa(final String mfa) {
            organizationUsers.setMfa(mfa);
            return this;
        }

        public Builder setGroupNames(final List<String> groupNames) {
            organizationUsers.setGroupNames(groupNames);
            return this;
        }

        public OrganizationUsers build() {
            return organizationUsers;
        }
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
    public boolean isTypeSet() { return isSet.contains("type"); }

    @JsonIgnore
    public boolean isEmailSet() {
        return isSet.contains("email");
    }

    @JsonIgnore
    public boolean isMfaSet() {
        return isSet.contains("mfa");
    }

    @JsonIgnore
    public boolean isGroupNamesSet() {
        return isSet.contains("groupNames");
    }

}