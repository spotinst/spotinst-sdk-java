package com.spotinst.sdkjava.model.api.oceanCD;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiProviderWeb implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    method;
    private String                                    url;
    private List<ApiWebHeaders>                       headers;
    private String                                    body;
    private Integer                                   timeoutSeconds;
    private String                                    jsonPath;
    private Boolean                                   insecure;

    public ApiProviderWeb() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        isSet.add("method");
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        isSet.add("url");
        this.url = url;
    }

    public List<ApiWebHeaders> getHeaders() {
        return headers;
    }

    public void setHeaders(List<ApiWebHeaders> headers) {
        isSet.add("headers");
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        isSet.add("body");
        this.body = body;
    }

    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public void setTimeoutSeconds(Integer timeoutSeconds) {
        isSet.add("timeoutSeconds");
        this.timeoutSeconds = timeoutSeconds;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        isSet.add("jsonPath");
        this.jsonPath = jsonPath;
    }

    public Boolean getInsecure() {
        return insecure;
    }

    public void setInsecure(Boolean insecure) {
        isSet.add("insecure");
        this.insecure = insecure;
    }

    @JsonIgnore
    public boolean isMethodSet() {
        return isSet.contains("method");
    }

    @JsonIgnore
    public boolean isUrlSet() {
        return isSet.contains("url");
    }

    @JsonIgnore
    public boolean isHeadersSet() {
        return isSet.contains("headers");
    }

    @JsonIgnore
    public boolean isBodySet() {
        return isSet.contains("body");
    }

    @JsonIgnore
    public boolean isTimeoutSecondsSet() {
        return isSet.contains("timeoutSeconds");
    }

    @JsonIgnore
    public boolean isJsonPathSet() {
        return isSet.contains("jsonPath");
    }

    @JsonIgnore
    public boolean isInsecureSet() {
        return isSet.contains("insecure");
    }
}