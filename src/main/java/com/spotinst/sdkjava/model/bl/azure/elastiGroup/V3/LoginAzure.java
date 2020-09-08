package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class LoginAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String      userName;
    private String      sshPublicKey;
    private String      password;

    //endregion

    //region Constructors
    private LoginAzure() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        isSet.add("userName");
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        isSet.add("password");
        this.password = password;
    }

    public String getSshPublicKey() {
        return sshPublicKey;
    }

    public void setSshPublicKey(String sshPublicKey) {
        isSet.add("sshPublicKey");
        this.sshPublicKey = sshPublicKey;
    }

    //endregion

    //TODO Itzik - delete?
    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginAzure tag = (LoginAzure) o;

        if (!userName.equals(tag.userName)) {
            return false;
        }
        return sshPublicKey.equals(tag.sshPublicKey);

    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + sshPublicKey.hashCode();
        return result;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private LoginAzure loginAzure;

        private Builder() {
            this.loginAzure = new LoginAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setUserName(final String userName) {
            loginAzure.setUserName(userName);
            return this;
        }

        public Builder setSshPublicKey(final String sshPublicKey) {
            loginAzure.setSshPublicKey(sshPublicKey);
            return this;
        }
        public Builder setPassword(final String password) {
            loginAzure.setPassword(password);
            return this;
        }

        public LoginAzure build() {
            // TODO : Validations
            return loginAzure;
        }
    }
    //endregion

    //region isSet methods
    // Is userName Set boolean method
    @JsonIgnore
    public boolean isUserNameSet() {
        return isSet.contains("userName");
    }

    @JsonIgnore
    public boolean isPasswordSet() {
        return isSet.contains("password");
    }

    // Is sshPublicKey Set boolean method
    @JsonIgnore
    public boolean isSshPublicKeySet() {
        return isSet.contains("sshPublicKey");
    }

    //endregion
}
