package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiElastigroupScaleUpNewInstancesGcp {

    @JsonIgnore
    private Set<String> isSet;
    private String      instanceName;


    public ApiElastigroupScaleUpNewInstancesGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        isSet.add("instanceName");
        this.instanceName = instanceName;
    }
    public static class Builder {
        private ApiElastigroupScaleUpNewInstancesGcp apiElastigroupScaleUpNewInstancesGcp;

        private Builder() {
            this.apiElastigroupScaleUpNewInstancesGcp = new ApiElastigroupScaleUpNewInstancesGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setInstanceName(final String instanceName) {
            apiElastigroupScaleUpNewInstancesGcp.setInstanceName(instanceName);
            return this;
        }


        public ApiElastigroupScaleUpNewInstancesGcp build() {
            return apiElastigroupScaleUpNewInstancesGcp;
        }

    }

    @JsonIgnore
    public boolean isInstanceNameSet() {
        return isSet.contains("instanceName");
    }



}
