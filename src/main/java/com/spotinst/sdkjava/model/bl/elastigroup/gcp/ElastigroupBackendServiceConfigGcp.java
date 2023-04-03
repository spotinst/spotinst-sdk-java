package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupBackendServiceConfigGcp {

    @JsonIgnore
    private Set<String>                         isSet;
    private List<ElastigroupBackendServicesGcp>    backendServices;

    private ElastigroupBackendServiceConfigGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupBackendServicesGcp> getBackendServices() {
        return backendServices;
    }

    public void setBackendServices(List<ElastigroupBackendServicesGcp> backendServices) {
        isSet.add("backendServices");
        this.backendServices = backendServices;
    }

    public static class Builder {
        private ElastigroupBackendServiceConfigGcp backendServiceConfig;

        private Builder() {
            this.backendServiceConfig = new ElastigroupBackendServiceConfigGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBackendServices(final List<ElastigroupBackendServicesGcp> backendServices) {
            backendServiceConfig.setBackendServices(backendServices);
            return this;
        }

        public ElastigroupBackendServiceConfigGcp build() {
            return backendServiceConfig;
        }
    }

    @JsonIgnore
    public boolean isBackendServicesSet() { return isSet.contains("backendServices"); }

}
