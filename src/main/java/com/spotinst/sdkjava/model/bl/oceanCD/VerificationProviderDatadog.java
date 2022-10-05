package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationProviderDatadog {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     address;
    private String                     apiKey;
    private String                     appKey;

    private VerificationProviderDatadog() {
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

    public static class Builder {
        private VerificationProviderDatadog verificationProviderDatadog;

        private Builder() {
            this.verificationProviderDatadog = new VerificationProviderDatadog();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAddress(final String address) {
            verificationProviderDatadog.setAddress(address);
            return this;
        }

        public Builder setApiKey(final String apiKey) {
            verificationProviderDatadog.setApiKey(apiKey);
            return this;
        }

        public Builder setAppKey(final String appKey) {
            verificationProviderDatadog.setAppKey(appKey);
            return this;
        }

        public VerificationProviderDatadog build() {
            return verificationProviderDatadog;
        }
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