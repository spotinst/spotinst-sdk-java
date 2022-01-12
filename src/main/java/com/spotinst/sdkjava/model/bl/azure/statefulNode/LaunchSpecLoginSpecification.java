package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecLoginSpecification {
    @JsonIgnore
    private Set<String> isSet;
    private String      userName;
    private String      password;
    private String      sshPublicKey;

    public LaunchSpecLoginSpecification() {
        isSet = new HashSet<>();
    }

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

    public static class Builder {
        private LaunchSpecLoginSpecification loginSpecification;

        private Builder() {
            this.loginSpecification = new LaunchSpecLoginSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setUserName(final String userName) {
            loginSpecification.setUserName(userName);
            return this;
        }

        public Builder setPassword(final String password) {
            loginSpecification.setPassword(password);
            return this;
        }

        public Builder setSshPublicKey(final String sshPublicKey) {
            loginSpecification.setSshPublicKey(sshPublicKey);
            return this;
        }

        public LaunchSpecLoginSpecification build() {
            return loginSpecification;
        }
    }

    @JsonIgnore
    public boolean isUserNameSet() {
        return isSet.contains("userName");
    }

    @JsonIgnore
    public boolean isPasswordSet() {
        return isSet.contains("password");
    }

    @JsonIgnore
    public boolean isSshPublicKeySet() {
        return isSet.contains("sshPublicKey");
    }

}