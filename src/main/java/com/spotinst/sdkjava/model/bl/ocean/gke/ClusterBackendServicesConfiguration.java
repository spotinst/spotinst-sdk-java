package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterBackendServicesConfiguration {

    @JsonIgnore
    private Set<String> isSet;
    private String      backendServiceName;
    private String      locationType;

    private ClusterBackendServicesConfiguration() {
        isSet = new HashSet<>();
    }


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getBackendServiceName() { return backendServiceName; }

    public void setBackendServiceName(String backendServiceName) {
        isSet.add("backendServiceName");
        this.backendServiceName = backendServiceName;
    }

    public String getLocationType() { return locationType; }

    public void setLocationType(String locationType) {
        isSet.add("locationType");
        this.locationType = locationType;
    }

    public static class Builder {
        private ClusterBackendServicesConfiguration backendService;

        private Builder() {
            this.backendService = new ClusterBackendServicesConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setBackendServiceName(final String backendServiceName) {
            backendService.setBackendServiceName(backendServiceName);
            return this;
        }

        public Builder setLocationType(final String locationType) {
            backendService.setLocationType(locationType);
            return this;
        }

        public ClusterBackendServicesConfiguration build() {
            return backendService;
        }
    }

    @JsonIgnore
    public boolean isBackendServiceNameSet() {
        return isSet.contains("backendServiceName");
    }

    @JsonIgnore
    public boolean isLocationTypeSet() {
        return isSet.contains("locationType");
    }

}
