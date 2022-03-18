package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupDetailsUsers {
    @JsonIgnore
    private Set<String> isSet;
    private String      userId;
    private String      username;
    private String      type;

    public UserGroupDetailsUsers() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {
        private UserGroupDetailsUsers users;

        private Builder() {
            this.users = new UserGroupDetailsUsers();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setUserId(final String userId) {
            users.setUserId(userId);
            return this;
        }

        public Builder setUserName(final String userName) {
            users.setUsername(userName);
            return this;
        }

        public Builder setType(final String type) {
            users.setType(type);
            return this;
        }

        public UserGroupDetailsUsers build() {
            return users;
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
    public boolean isTypeSet() {
        return isSet.contains("type");
    }
}
