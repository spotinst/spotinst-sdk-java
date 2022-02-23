package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetInstanceTypesByRegionResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             instanceType;

    public ElastigroupGetInstanceTypesByRegionResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public static class Builder {
        private ElastigroupGetInstanceTypesByRegionResponse elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new ElastigroupGetInstanceTypesByRegionResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public ElastigroupGetInstanceTypesByRegionResponse.Builder setInstanceType(final String instanceType) {
            elastigroupGetDeploymentStatusInstances.setInstanceType(instanceType);
            return this;
        }

        public ElastigroupGetInstanceTypesByRegionResponse build() {
            return elastigroupGetDeploymentStatusInstances;
        }

    }

    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

}
