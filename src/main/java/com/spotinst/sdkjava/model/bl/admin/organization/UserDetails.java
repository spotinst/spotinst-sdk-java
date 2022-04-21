package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.admin.organization.UserTypeEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetails {
    @JsonIgnore
    private Set<String>             isSet;
    private String                  userId;
    private String                  username;
    private UserTypeEnum            type;
    private String                  email;
    private String                  mfa;
    private List<UserDetailsPolicies> policies;
    private List<UserDetailsTokens> tokens;
    private List<UserDetailsGroups> groups;

    public UserDetails() {
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

    public List<UserDetailsPolicies> getPolicies() {
        return policies;
    }

    public void setPolicies(List<UserDetailsPolicies> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    public List<UserDetailsTokens> getTokens() {
        return tokens;
    }

    public void setTokens(List<UserDetailsTokens> tokens) {
        isSet.add("tokens");
        this.tokens = tokens;
    }

    public List<UserDetailsGroups> getGroups() {
        return groups;
    }

    public void setGroups(List<UserDetailsGroups> groupNames) {
        isSet.add("groups");
        this.groups = groupNames;
    }

    public static class Builder {
        private UserDetails userDetails;

        private Builder() {
            this.userDetails = new UserDetails();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setUserId(final String userId) {
            userDetails.setUserId(userId);
            return this;
        }

        public Builder setUserName(final String userName) {
            userDetails.setUsername(userName);
            return this;
        }

        public Builder setType(final UserTypeEnum type) {
            userDetails.setType(type);
            return this;
        }

        public Builder setMfa(final String mfa) {
            userDetails.setMfa(mfa);
            return this;
        }

        public Builder setPolicies(final List<UserDetailsPolicies> policies) {
            userDetails.setPolicies(policies);
            return this;
        }

        public Builder setTokens(final List<UserDetailsTokens> tokens) {
            userDetails.setTokens(tokens);
            return this;
        }

        public Builder setGroups(final List<UserDetailsGroups> groupNames) {
            userDetails.setGroups(groupNames);
            return this;
        }

        public UserDetails build() {
            return userDetails;
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
    public boolean isPoliciesSet() {
        return isSet.contains("policies");
    }

    @JsonIgnore
    public boolean isTokensSet() {
        return isSet.contains("tokens");
    }

    @JsonIgnore
    public boolean isGroupNamesSet() {
        return isSet.contains("groups");
    }
}