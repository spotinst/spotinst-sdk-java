package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterInstanceMetadataOptions {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     httpPutResponseHopLimit;
    private String      httpTokens;

    private ClusterInstanceMetadataOptions() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getHttpPutResponseHopLimit() {
        return httpPutResponseHopLimit;
    }

    public void setHttpPutResponseHopLimit(Integer httpPutResponseHopLimit) {
        isSet.add("httpPutResponseHopLimit");
        this.httpPutResponseHopLimit = httpPutResponseHopLimit;
    }

    public String getHttpTokens() {
        return httpTokens;
    }

    public void setHttpTokens(String httpTokens) {
        isSet.add("httpTokens");
        this.httpTokens = httpTokens;
    }

    public static class Builder {

        private ClusterInstanceMetadataOptions clusterInstanceMetadataOptions;

        private Builder() {
            this.clusterInstanceMetadataOptions = new ClusterInstanceMetadataOptions();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setHttpPutResponseHopLimit(final Integer httpPutResponseHopLimit) {
            clusterInstanceMetadataOptions.setHttpPutResponseHopLimit(httpPutResponseHopLimit);
            return this;
        }

        public Builder setHttpTokens(final String httpTokens) {
            clusterInstanceMetadataOptions.setHttpTokens(httpTokens);
            return this;
        }

        public ClusterInstanceMetadataOptions build() {
            return clusterInstanceMetadataOptions;
        }
    }

    @JsonIgnore
    public boolean isHttpPutResponseHopLimitSet() {
        return isSet.contains("httpPutResponseHopLimit");
    }

    @JsonIgnore
    public boolean isHttpTokensSet() {
        return isSet.contains("httpTokens");
    }
}
