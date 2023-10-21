package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupBackendServicesGcp {

    @JsonIgnore
    private Set<String>                     isSet;
    private String                          backendServiceName;
    private String                          locationType;
    private ElastigroupNamedPortsGcp        namedPorts;
    private String                          scheme;

    private ElastigroupBackendServicesGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getBackendServiceName() {
        return backendServiceName;
    }

    public void setBackendServiceName(String backendServiceName) {
        isSet.add("backendServiceName");
        this.backendServiceName = backendServiceName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        isSet.add("locationType");
        this.locationType = locationType;
    }

    public ElastigroupNamedPortsGcp getNamedPorts() {
        return namedPorts;
    }

    public void setNamedPorts(ElastigroupNamedPortsGcp namedPorts) {
        isSet.add("namedPorts");
        this.namedPorts = namedPorts;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        isSet.add("scheme");
        this.scheme = scheme;
    }

    public static class Builder {
        private ElastigroupBackendServicesGcp backendServices;

        private Builder() {
            this.backendServices = new ElastigroupBackendServicesGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBackendServiceName(final String backendServiceName) {
            backendServices.setBackendServiceName(backendServiceName);
            return this;
        }

        public Builder setLocationType(final String locationType) {
            backendServices.setLocationType(locationType);
            return this;
        }

        public Builder setNamedPorts(final ElastigroupNamedPortsGcp namedPorts) {
            backendServices.setNamedPorts(namedPorts);
            return this;
        }

        public Builder setScheme(final String scheme) {
            backendServices.setScheme(scheme);
            return this;
        }

        public ElastigroupBackendServicesGcp build() {
            return backendServices;
        }
    }

    @JsonIgnore
    public boolean isBackendServiceNameSet() { return isSet.contains("backendServiceName"); }

    @JsonIgnore
    public boolean isLocationTypeSet() { return isSet.contains("locationType"); }

    @JsonIgnore
    public boolean isNamedPortsSet() { return isSet.contains("namedPorts"); }

    @JsonIgnore
    public boolean isSchemeSet() { return isSet.contains("scheme"); }
}
