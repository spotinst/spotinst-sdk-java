package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderDatadog {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    duration;
    private String                                    query;

    private ProviderDatadog() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        isSet.add("duration");
        this.duration = duration;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        isSet.add("query");
        this.query = query;
    }

    public static class Builder {
        private ProviderDatadog providerPrometheus;

        private Builder() {
            this.providerPrometheus = new ProviderDatadog();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setQuery(final String query) {
            providerPrometheus.setQuery(query);
            return this;
        }

        public Builder setDuration(final String duration) {
            providerPrometheus.setDuration(duration);
            return this;
        }

        public ProviderDatadog build() {
            return providerPrometheus;
        }
    }

    @JsonIgnore
    public boolean isQuerySet() {
        return isSet.contains("query");
    }

    @JsonIgnore
    public boolean isDurationSet() {
        return isSet.contains("duration");
    }
}