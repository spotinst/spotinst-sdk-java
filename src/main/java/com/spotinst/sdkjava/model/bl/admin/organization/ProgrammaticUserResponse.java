package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgrammaticUserResponse {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         id;
    private String                         userName;
    private String                         description;
    private List<ProgrammaticUserAccounts> accounts;


    public ProgrammaticUserResponse() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        isSet.add("userName");
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public List<ProgrammaticUserAccounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<ProgrammaticUserAccounts> accounts) {
        isSet.add("accounts");
        this.accounts = accounts;
    }

    public static class Builder {
        private ProgrammaticUserResponse programmaticUser;

        private Builder() {
            this.programmaticUser = new ProgrammaticUserResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            programmaticUser.setId(id);
            return this;
        }

        public Builder setUserName(final String userName) {
            programmaticUser.setUserName(userName);
            return this;
        }

        public Builder setDescription(final String description) {
            programmaticUser.setDescription(description);
            return this;
        }

        public Builder setAccounts(final List<ProgrammaticUserAccounts> accounts) {
            programmaticUser.setAccounts(accounts);
            return this;
        }

        public ProgrammaticUserResponse build() {
            return programmaticUser;
        }
    }
    @JsonIgnore
    public boolean isUserNameSet() {
        return isSet.contains("userName");
    }

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isAccountsSet() {
        return isSet.contains("accounts");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }
}