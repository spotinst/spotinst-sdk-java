package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiElastigroupScaleUpNewInstancesListGcp {

    @JsonIgnore
    private Set<String> isSet;
    private String      instanceName;


    public ApiElastigroupScaleUpNewInstancesListGcp() {
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
        private ApiElastigroupScaleUpNewInstancesListGcp apiElastigroupScaleUpNewInstancesListGcp;

        private Builder() {
            this.apiElastigroupScaleUpNewInstancesListGcp = new ApiElastigroupScaleUpNewInstancesListGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setInstanceName(final String instanceName) {
            apiElastigroupScaleUpNewInstancesListGcp.setInstanceName(instanceName);
            return this;
        }


        public ApiElastigroupScaleUpNewInstancesListGcp build() {
            return apiElastigroupScaleUpNewInstancesListGcp;
        }

    }

    @JsonIgnore
    public boolean isInstanceNameSet() {
        return isSet.contains("instanceName");
    }



}
