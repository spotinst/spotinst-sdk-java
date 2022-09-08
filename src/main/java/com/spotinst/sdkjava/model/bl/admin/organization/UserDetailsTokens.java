package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsTokens {

    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      createdAt;
    private Integer     tokenId;
    private String      tokenLastDigits;

    public UserDetailsTokens() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        isSet.add("tokenId");
        this.tokenId = tokenId;
    }

    public String getTokenLastDigits() {
        return tokenLastDigits;
    }

    public void setTokenLastDigits(String tokenLastDigits) {
        isSet.add("tokenLastDigits");
        this.tokenLastDigits = tokenLastDigits;
    }

    public static class Builder {
        private UserDetailsTokens userTokens;

        private Builder() {
            this.userTokens = new UserDetailsTokens();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            userTokens.setName(name);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            userTokens.setCreatedAt(createdAt);
            return this;
        }

        public Builder setTokenId(final Integer tokenId) {
            userTokens.setTokenId(tokenId);
            return this;
        }

        public Builder setTokenLastDigits(final String tokenLastDigits) {
            userTokens.setTokenLastDigits(tokenLastDigits);
            return this;
        }

        public UserDetailsTokens build() {
            return userTokens;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isTokenIdSet() {
        return isSet.contains("tokenId");
    }

    @JsonIgnore
    public boolean isTokenLastDigitsSet() {
        return isSet.contains("tokenLastDigits");
    }
}