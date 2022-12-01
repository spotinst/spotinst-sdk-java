package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderNewRelic {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    profile;
    private String                                    query;

    private ProviderNewRelic() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        isSet.add("profile");
        this.profile = profile;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        isSet.add("query");
        this.query = query;
    }

    public static class Builder {
        private ProviderNewRelic providerNewRelic;

        private Builder() {
            this.providerNewRelic = new ProviderNewRelic();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setQuery(final String query) {
            providerNewRelic.setQuery(query);
            return this;
        }

        public Builder setProfile(final String profile) {
            providerNewRelic.setProfile(profile);
            return this;
        }

        public ProviderNewRelic build() {
            return providerNewRelic;
        }
    }

    @JsonIgnore
    public boolean isProfileSet() {
        return isSet.contains("profile");
    }

    @JsonIgnore
    public boolean isQuerySet() {
        return isSet.contains("query");
    }
}