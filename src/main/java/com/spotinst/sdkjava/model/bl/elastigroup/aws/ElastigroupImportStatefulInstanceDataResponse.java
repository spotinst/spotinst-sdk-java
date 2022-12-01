package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupImportStatefulInstanceDataResponse {

    @JsonIgnore
    private Set<String>                                          isSet;
    private String                                               originalInstanceId;
    private Boolean                                              shouldKeepPrivateIp;
    private Boolean                                              shouldTerminateInstance;

    public ElastigroupImportStatefulInstanceDataResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOriginalInstanceId() {
        return originalInstanceId;
    }

    public void setOriginalInstanceId(String originalInstanceId) {
        isSet.add("originalInstanceId");
        this.originalInstanceId = originalInstanceId;
    }

    public Boolean getShouldKeepPrivateIp() {
        return shouldKeepPrivateIp;
    }

    public void setShouldKeepPrivateIp(Boolean shouldKeepPrivateIp) {
        isSet.add("shouldKeepPrivateIp");
        this.shouldKeepPrivateIp = shouldKeepPrivateIp;
    }

    public Boolean getShouldTerminateInstance() {
        return shouldTerminateInstance;
    }

    public void setShouldTerminateInstance(Boolean shouldTerminateInstance) {
        isSet.add("shouldTerminateInstance");
        this.shouldTerminateInstance = shouldTerminateInstance;
    }

    public static class Builder {
        private ElastigroupImportStatefulInstanceDataResponse elastigroupImportStatefulInstanceResponse;

        private Builder() {
            this.elastigroupImportStatefulInstanceResponse = new ElastigroupImportStatefulInstanceDataResponse();
        }

        public static ElastigroupImportStatefulInstanceDataResponse.Builder get() {
            return new ElastigroupImportStatefulInstanceDataResponse.Builder();
        }

        public ElastigroupImportStatefulInstanceDataResponse.Builder setOriginalInstanceId(final String originalInstanceId) {
            elastigroupImportStatefulInstanceResponse.setOriginalInstanceId(originalInstanceId);
            return this;
        }

        public ElastigroupImportStatefulInstanceDataResponse.Builder setShouldKeepPrivateIp(final Boolean shouldKeepPrivateIp) {
            elastigroupImportStatefulInstanceResponse.setShouldKeepPrivateIp(shouldKeepPrivateIp);
            return this;
        }

        public ElastigroupImportStatefulInstanceDataResponse.Builder setShouldTerminateInstance(final Boolean shouldTerminateInstance) {
            elastigroupImportStatefulInstanceResponse.setShouldTerminateInstance(shouldTerminateInstance);
            return this;
        }

        public ElastigroupImportStatefulInstanceDataResponse build() {
            return elastigroupImportStatefulInstanceResponse;
        }

    }

    @JsonIgnore
    public boolean isOriginalInstanceIdSet() {
        return isSet.contains("originalInstanceId");
    }

    @JsonIgnore
    public boolean isShouldKeepPrivateIpSet() {
        return isSet.contains("shouldKeepPrivateIp");
    }

    @JsonIgnore
    public boolean isShouldTerminateInstanceSet() {
        return isSet.contains("shouldTerminateInstance");
    }

}
