package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportClusterLaunchSpecInstanceMetadataOptions {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     httpPutResponseHopLimit;
    private String      httpTokens;
    private String      httpEndpoint;

    private ImportClusterLaunchSpecInstanceMetadataOptions() {
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

    public String getHttpEndpoint() {
        return httpEndpoint;
    }

    public void setHttpEndpoint(String httpEndpoint) {
        isSet.add("httpEndpoint");
        this.httpEndpoint = httpEndpoint;
    }

    public static class Builder {

        private ImportClusterLaunchSpecInstanceMetadataOptions launchSpecInstanceMetadataOptions;

        private Builder() {
            this.launchSpecInstanceMetadataOptions = new ImportClusterLaunchSpecInstanceMetadataOptions();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setHttpPutResponseHopLimit(final Integer httpPutResponseHopLimit) {
            launchSpecInstanceMetadataOptions.setHttpPutResponseHopLimit(httpPutResponseHopLimit);
            return this;
        }

        public Builder setHttpTokens(final String httpTokens) {
            launchSpecInstanceMetadataOptions.setHttpTokens(httpTokens);
            return this;
        }

        public Builder setHttpEndpoint(final String httpEndpoint) {
            launchSpecInstanceMetadataOptions.setHttpEndpoint(httpEndpoint);
            return this;
        }

        public ImportClusterLaunchSpecInstanceMetadataOptions build() {
            return launchSpecInstanceMetadataOptions;
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

    @JsonIgnore
    public boolean isHttpEndpointSet() {
        return isSet.contains("httpEndpoint");
    }
}
