package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiK8sVngInstanceMetadataOptions implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>       isSet;
    private Integer           httpPutResponseHopLimit;
    private String            httpTokens;

    public ApiK8sVngInstanceMetadataOptions() {
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

    @JsonIgnore
    public boolean isHttpPutResponseHopLimitSet() {
        return isSet.contains("httpPutResponseHopLimit");
    }

    @JsonIgnore
    public boolean isHttpTokensSet() {
        return isSet.contains("httpTokens");
    }
}
