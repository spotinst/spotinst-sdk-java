package com.spotinst.sdkjava.model;

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
public class ApiMatcher implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      httpCode;
    private String      grpcCode;
    //endregion

    //region Constructor
    public ApiMatcher() {
        isSet = new HashSet<>();
    }

    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
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

    @JsonIgnore
    public boolean isHttpCodeSet() {
        return isSet.contains("httpCode");
    }

    @JsonIgnore
    public boolean isGrpcCodeSet() {
        return isSet.contains("grpcCode");
    }
    //endregion
}
