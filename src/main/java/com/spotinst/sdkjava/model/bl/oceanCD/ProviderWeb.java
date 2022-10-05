package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderWeb {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    method;
    private String                                    url;
    private List<WebHeaders>                          headers;
    private String                                    body;
    private Integer                                   timeoutSeconds;
    private String                                    jsonPath;
    private Boolean                                   insecure;

    private ProviderWeb() {
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

    public List<WebHeaders> getHeaders() {
        return headers;
    }

    public void setHeaders(List<WebHeaders> headers) {
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

    public static class Builder {
        private ProviderWeb providerWeb;

        private Builder() {
            this.providerWeb = new ProviderWeb();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMethod(final String method) {
            providerWeb.setMethod(method);
            return this;
        }

        public Builder setUrl(final String url) {
            providerWeb.setUrl(url);
            return this;
        }

        public Builder setHeaders(final List<WebHeaders> headers) {
            providerWeb.setHeaders(headers);
            return this;
        }

        public Builder setBody(final String body) {
            providerWeb.setBody(body);
            return this;
        }

        public Builder setTimeoutSeconds(final Integer timeoutSeconds) {
            providerWeb.setTimeoutSeconds(timeoutSeconds);
            return this;
        }

        public Builder setJsonPath(final String jsonPath) {
            providerWeb.setJsonPath(jsonPath);
            return this;
        }

        public Builder setInsecure(final Boolean insecure) {
            providerWeb.setInsecure(insecure);
            return this;
        }

        public ProviderWeb build() {
            return providerWeb;
        }
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