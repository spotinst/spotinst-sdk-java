package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationProviderNewRelic {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     personalApiKey;
    private String                     accountId;
    private String                     region;
    private String                     baseUrlRest;
    private String                     baseUrlNerdGraph;

    private VerificationProviderNewRelic() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getPersonalApiKey() {
        return personalApiKey;
    }

    public void setPersonalApiKey(String personalApiKey) {
        isSet.add("personalApiKey");
        this.personalApiKey = personalApiKey;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        isSet.add("accountId");
        this.accountId = accountId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getBaseUrlRest() {
        return baseUrlRest;
    }

    public void setBaseUrlRest(String baseUrlRest) {
        isSet.add("baseUrlRest");
        this.baseUrlRest = baseUrlRest;
    }

    public String getBaseUrlNerdGraph() {
        return baseUrlNerdGraph;
    }

    public void setBaseUrlNerdGraph(String baseUrlNerdGraph) {
        isSet.add("baseUrlNerdGraph");
        this.baseUrlNerdGraph = baseUrlNerdGraph;
    }

    public static class Builder {
        private VerificationProviderNewRelic verificationProviderNewRelic;

        private Builder() {
            this.verificationProviderNewRelic = new VerificationProviderNewRelic();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPersonalApiKey(final String personalApiKey) {
            verificationProviderNewRelic.setPersonalApiKey(personalApiKey);
            return this;
        }

        public Builder setAccountId(final String accountId) {
            verificationProviderNewRelic.setAccountId(accountId);
            return this;
        }

        public Builder setRegion(final String region) {
            verificationProviderNewRelic.setRegion(region);
            return this;
        }

        public Builder setBaseUrlRest(final String baseUrlRest) {
            verificationProviderNewRelic.setBaseUrlRest(baseUrlRest);
            return this;
        }

        public Builder setBaseUrlNerdGraph(final String baseUrlNerdGraph) {
            verificationProviderNewRelic.setBaseUrlNerdGraph(baseUrlNerdGraph);
            return this;
        }

        public VerificationProviderNewRelic build() {
            return verificationProviderNewRelic;
        }
    }

    @JsonIgnore
    public boolean isPersonalApiKeySet() {
        return isSet.contains("personalApiKey");
    }

    @JsonIgnore
    public boolean isAccountIdSet() {
        return isSet.contains("accountId");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isBaseUrlRestSet() {
        return isSet.contains("baseUrlRest");
    }

    @JsonIgnore
    public boolean isBaseUrlNerdGraphSet() {
        return isSet.contains("baseUrlNerdGraph");
    }
}