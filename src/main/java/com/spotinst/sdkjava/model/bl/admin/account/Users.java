package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         displayName;
    private String                         email;
    private List<String>                   mappedAccountIds;
    private String                         userId;
    //endregion

    //region Constructor
    private Users() {
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

    public List<String> getMappedAccountIds() {
        return mappedAccountIds;
    }

    public void setMappedAccountIds(List<String> mappedAccountIds) {
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

    //region Builder class
    public static class Builder {
        private Users account;

        private Builder() {
            this.account = new Users();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDisplayName(final String displayName) {
            account.setDisplayName(displayName);
            return this;
        }

        public Builder setEmail(final String email) {
            account.setEmail(email);
            return this;
        }

        public Builder setMappedAccountIds(final List<String> mappedAccountIds) {
            account.setMappedAccountIds(mappedAccountIds);
            return this;
        }

        public Builder setUserId(final String userId) {
            account.setUserId(userId);
            return this;
        }

        public Users build() {
            return account;
        }
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
