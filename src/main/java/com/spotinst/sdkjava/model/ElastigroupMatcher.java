package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupMatcher {
    @JsonIgnore
    private Set<String> isSet;
    private String httpCode;
    private String grpcCode;

    //region Constructor

    private ElastigroupMatcher() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        isSet.add("httpCode");
        this.httpCode = httpCode;
    }

    public String getGrpcCode() {
        return grpcCode;
    }

    public void setGrpcCode(String grpcCode) {
        isSet.add("grpcCode");
        this.grpcCode = grpcCode;
    }

    //region Builder class
    public static class Builder {
        private ElastigroupMatcher itfMatcher;

        private Builder() {
            this.itfMatcher = new ElastigroupMatcher();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setHttpCode(final String httpCode) {
            itfMatcher.setHttpCode(httpCode);
            return this;
        }

        public Builder setGrpcCode(final String grpcCode) {
            itfMatcher.setGrpcCode(grpcCode);
            return this;
        }

        public ElastigroupMatcher build() {
            return itfMatcher;
        }
    }

    //endregion

    //region isSet methods
    // Is httpCode Set boolean method
    @JsonIgnore
    public boolean isHttpCodeSet() {
        return isSet.contains("httpCode");
    }

    // Is grpcCode Set boolean method
    @JsonIgnore
    public boolean isGrpcCodeSet() {
        return isSet.contains("grpcCode");
    }

    //endregion
}
