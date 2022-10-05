package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiVerificationProviderDatadog implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     address;
    private String                     apiKey;
    private String                     appKey;

    public ApiVerificationProviderDatadog() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        isSet.add("address");
        this.address = address;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        isSet.add("apiKey");
        this.apiKey = apiKey;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        isSet.add("appKey");
        this.appKey = appKey;
    }

    @JsonIgnore
    public boolean isAddressSet() {
        return isSet.contains("address");
    }

    @JsonIgnore
    public boolean isApiKeySet() {
        return isSet.contains("apiKey");
    }

    @JsonIgnore
    public boolean isAppKeySet() {
        return isSet.contains("appKey");
    }
}