package com.spotinst.sdkjava.model.api.oceanCD;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiProviderNewRelic {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    profile;
    private String                                    query;

    public ApiProviderNewRelic() {
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
        private ApiProviderNewRelic apiProviderNewRelic;

        private Builder() {
            this.apiProviderNewRelic = new ApiProviderNewRelic();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setQuery(final String query) {
            apiProviderNewRelic.setQuery(query);
            return this;
        }

        public Builder setProfile(final String profile) {
            apiProviderNewRelic.setProfile(profile);
            return this;
        }

        public ApiProviderNewRelic build() {
            return apiProviderNewRelic;
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