package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetBeanstalkMaintenanceStatusResponse {

    @JsonIgnore
    private Set<String>                                          isSet;
    private String                                               status;

    public ElastigroupGetBeanstalkMaintenanceStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public static class Builder {
        private ElastigroupGetBeanstalkMaintenanceStatusResponse elastigroupGetBeanstalkMaintenanceStatusResponse;

        private Builder() {
            this.elastigroupGetBeanstalkMaintenanceStatusResponse = new ElastigroupGetBeanstalkMaintenanceStatusResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public ElastigroupGetBeanstalkMaintenanceStatusResponse.Builder setStatus(final String status) {
            elastigroupGetBeanstalkMaintenanceStatusResponse.setStatus(status);
            return this;
        }

        public ElastigroupGetBeanstalkMaintenanceStatusResponse build() {
            return elastigroupGetBeanstalkMaintenanceStatusResponse;
        }

    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

}
