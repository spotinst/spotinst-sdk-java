package com.spotinst.sdkjava.model.api.admin.organization;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiUserDetailsTokens implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      createdAt;
    private Integer     tokenId;
    private String      tokenLastDigits;

    public ApiUserDetailsTokens() {
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
